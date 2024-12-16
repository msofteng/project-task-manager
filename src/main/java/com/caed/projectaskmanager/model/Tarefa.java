package com.caed.projectaskmanager.model;

import java.util.Date;

public class Tarefa {
    private String titulo;
    private String descricao;
    private String prioridade;
    private Date estimativa;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getEstimativa() {
        return estimativa;
    }

    public void setEstimativa(Date estimativa) {
        this.estimativa = estimativa;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "titulo=" + titulo + ", descricao=" + descricao + ", prioridade=" + prioridade + ", estimativa=" + estimativa.toString() + '}';
    }
}