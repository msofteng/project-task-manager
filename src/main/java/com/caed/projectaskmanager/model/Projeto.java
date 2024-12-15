package com.caed.projectaskmanager.model;

import java.util.Date;

public class Projeto {
    private Long id;
    private String titulo;
    private String descricao;
    private Date dataInicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "Projeto{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + '}';
    }
}