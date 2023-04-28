package br.com.alura.microservice.loja.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Compra {
    @Id
    private Long idPedido;
    private Integer tempoDePreparo;
    private String endereco;
    private Long voucher;
    private LocalDate dataParaEntrega;

    public Integer getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Integer tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getVoucher() {
        return voucher;
    }

    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

    public LocalDate getDataParaEntrega() {
        return dataParaEntrega;
    }

    public void setDataParaEntrega(LocalDate dataParaEntrega) {
        this.dataParaEntrega = dataParaEntrega;
    }

}
