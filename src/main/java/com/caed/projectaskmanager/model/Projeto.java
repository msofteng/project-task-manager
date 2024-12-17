package com.caed.projectaskmanager.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projeto implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String descricao;
    private Date dataInicio;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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