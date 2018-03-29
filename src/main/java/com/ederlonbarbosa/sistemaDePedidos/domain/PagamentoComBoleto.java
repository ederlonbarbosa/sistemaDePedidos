package com.ederlonbarbosa.sistemaDePedidos.domain;

import com.ederlonbarbosa.sistemaDePedidos.domain.enums.StatusPagamento;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(StatusPagamento statusPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(statusPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
