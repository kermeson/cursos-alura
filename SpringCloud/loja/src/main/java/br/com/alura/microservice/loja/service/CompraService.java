package br.com.alura.microservice.loja.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.client.TransportadorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoEntregaDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.controller.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.controller.dto.VoucherDTO;
import br.com.alura.microservice.loja.model.Compra;
import br.com.alura.microservice.loja.repository.CompraRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    @Autowired
    private FornecedorClient fornecedorClient;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private TransportadorClient transportadorClient;

    private static final String RESILIENCE4J_INSTANCE_NAME = "example";

    public Compra obterPorId(Long id) {
        return compraRepository.findById(id).orElse(new Compra());
    }

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = "fallbackForRealizaCompra")
    @TimeLimiter(name = "timeLimiterApi")
    public CompletableFuture<Compra> realizaCompra(CompraDTO compra) {
        return CompletableFuture.supplyAsync(() -> {

            // ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
            // "http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET,
            // null,
            // InfoFornecedorDTO.class);
            // System.out.println(exchange.getBody().getEndereco());

            InfoFornecedorDTO infoPorEstado = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

            InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

            InfoEntregaDTO entrega = new InfoEntregaDTO();
            entrega.setPedidoId(pedido.getId());
            entrega.setDataParaEntrega(LocalDate.now().plusDays(pedido.getTempoDePreparo()));
            entrega.setEnderecoOrigem(infoPorEstado.getEndereco());
            entrega.setEnderecoDestino(compra.getEndereco().toString());

            VoucherDTO voucher = transportadorClient.reservaEntrega(entrega);

            Compra compraSalva = new Compra();
            compraSalva.setIdPedido(pedido.getId());
            compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
            compraSalva.setEndereco(compra.getEndereco().toString());
            compraSalva.setVoucher(voucher.getNumero());
            compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
            compraRepository.save(compraSalva);
            return compraSalva;
        });

    }

    public CompletableFuture<Compra> fallbackForRealizaCompra(CompraDTO compra, Exception e) {
        return CompletableFuture.supplyAsync(() -> {
            Compra compraFallback = new Compra();
            System.out.println(e.getClass().getName());
            return compraFallback;
        });
    }

}
