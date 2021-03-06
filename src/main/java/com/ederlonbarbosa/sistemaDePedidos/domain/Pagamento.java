package com.ederlonbarbosa.sistemaDePedidos.domain;

import com.ederlonbarbosa.sistemaDePedidos.core.BaseEntity;
import com.ederlonbarbosa.sistemaDePedidos.domain.enums.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends BaseEntity implements Serializable {

    @Id
    private Long id;
    private Integer statusPagamento;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ID_PEDIDO")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(StatusPagamento statusPagamento, Pedido pedido) {
        this.statusPagamento = statusPagamento.getCodigo();
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPagamento getStatusPagamento() {
        return StatusPagamento.getStatusPagamentoPorCodigo(statusPagamento);
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento.getCodigo();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
