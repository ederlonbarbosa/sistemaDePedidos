package com.ederlonbarbosa.sistemaDePedidos.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1L, "Pessoa Física"),
    PESSOA_JURIDICA(2L, "Pessoa Jurídica");

    private Long codigo;
    private String descricao;

    TipoCliente(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente getTipoClientePorCodigo(Long codigo) {
        if (codigo == null) {
            return null;
        }

        for (TipoCliente tipoCliente : TipoCliente.values()) {
            if (codigo.equals(tipoCliente.getCodigo())) {
                return tipoCliente;
            }
        }
        throw new IllegalArgumentException(String.format("O código %s é inválido!", codigo));
    }
}
