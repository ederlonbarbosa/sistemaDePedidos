package com.ederlonbarbosa.sistemaDePedidos.domain.enums;

public enum StatusPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codigo;
    private String descricao;

    StatusPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPagamento getStatusPagamentoPorCodigo(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (StatusPagamento statusPagamento : StatusPagamento.values()) {
            if (codigo.equals(statusPagamento.getCodigo())) {
                return statusPagamento;
            }
        }
        throw new IllegalArgumentException(String.format("O código %s é inválido!", codigo));
    }
}
