package com.ederlonbarbosa.sistemaDePedidos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataDoPedido;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO_DE_ENTREGA")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "itemPedidoPK.pedido")
    private Set<ItemPedido> itemPedidos = new HashSet<>();

    public Pedido(Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        this.dataDoPedido = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Pedido() {
    }

    public Set<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(Set<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(Date dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
