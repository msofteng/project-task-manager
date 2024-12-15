package com.caed.projectaskmanager.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Projeto {
    private String titulo;
    private String descricao;
    private LocalDate dataInicio;
}