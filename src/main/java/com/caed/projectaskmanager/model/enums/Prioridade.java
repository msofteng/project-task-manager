package com.caed.projectaskmanager.model.enums;

public enum Prioridade {
    MUITO_BAIXA(1),
    BAIXA(2),
    ALTA(3),
    MUITO_ALTA(4);
    
    private Integer valor;

    private Prioridade(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}