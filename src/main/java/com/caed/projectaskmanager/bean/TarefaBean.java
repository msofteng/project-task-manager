package com.caed.projectaskmanager.bean;

import com.caed.projectaskmanager.model.Tarefa;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class TarefaBean implements Serializable {
    private Tarefa tarefa;
    private List<Tarefa> tarefas;
    
    public TarefaBean() {
        this.tarefa = new Tarefa();
        this.tarefas = new ArrayList();
    }

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
    
    public String salvarTarefa() {
        System.out.println("salvando tarefa");
        System.out.println(this.tarefa);
        return "/tarefas/index.xhtml?faces-redirect=true";
    }

    public String editarTarefa(Long id) {
        System.out.println("editando tarefa");
        return "/tarefas/cadastro.xhtml?faces-redirect=true";
    }

    public String excluirTarefa(Long id) {
        System.out.println("removendo tarefa");
        return "/tarefas/index.xhtml?faces-redirect=true";
    }

    public String visualizarTarefa(Long id) {
        System.out.println("visualizando tarefa");
        return "/tarefas/index.xhtml?faces-redirect=true";
    }
}
