package br.com.alura.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.microservice.loja.controller.dto.InfoEntregaDTO;
import br.com.alura.microservice.loja.controller.dto.VoucherDTO;

/**
 * TransportadorClient
 */
@FeignClient("transportador")
public interface TransportadorClient {

    @PostMapping("/entrega")
    public VoucherDTO reservaEntrega(@RequestBody InfoEntregaDTO entrega);
}