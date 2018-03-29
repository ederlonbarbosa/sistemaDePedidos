package com.ederlonbarbosa.sistemaDePedidos.domain;

import com.ederlonbarbosa.sistemaDePedidos.domain.enums.StatusPagamento;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PagamentoComCartao extends Pagamento{

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(StatusPagamento statusPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(statusPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
