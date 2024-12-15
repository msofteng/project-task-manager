package com.caed.projectaskmanager.model;

import com.caed.projectaskmanager.model.enums.Prioridade;
import java.time.LocalTime;
import lombok.Data;

@Data
public class Tarefa {
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private LocalTime estimativa;
}