package com.caed.projectaskmanager.bean;

import com.caed.projectaskmanager.model.Tarefa;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@Named(value = "tarefaBean")
@RequestScoped
public class TarefaBean {
    private Tarefa tarefa;
    private List<Tarefa> tarefas;
    private Long projetoId;

    // Construtores
    public TarefaBean() {
        this.tarefa = new Tarefa();
        this.tarefas = new ArrayList<>();
    }

    // Getters e Setters
    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
    }
    
    public String salvarTarefa() {
        System.out.println("salvando tarefa");
        System.out.println(this.tarefa);
        return "listagemTarefas.xhtml?faces-redirect=true";
    }

    public String editarTarefa(Long id) {
        System.out.println("editando tarefa");
        return "cadastroTarefa.xhtml?faces-redirect=true";
    }

    public String excluirTarefa(Long id) {
        System.out.println("removendo tarefa");
        return "listagemTarefas.xhtml?faces-redirect=true";
    }

    public String visualizarTarefa(Long id) {
        System.out.println("visualizando tarefa");
        return "visualizarTarefa.xhtml?faces-redirect=true";
    }
}
