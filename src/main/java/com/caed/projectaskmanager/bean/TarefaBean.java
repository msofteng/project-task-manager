package com.caed.projectaskmanager.bean;

import com.caed.projectaskmanager.model.Projeto;
import com.caed.projectaskmanager.model.Tarefa;
import com.caed.projectaskmanager.service.Service;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class TarefaBean implements Serializable {
    private Tarefa tarefa;
    private List<Tarefa> tarefas;
    private Service<Tarefa> tarefaService;
    private Service<Projeto> projetoService;
    
    private Projeto projeto;
    
    public TarefaBean() {
        this.tarefa = new Tarefa();
        this.projeto = new Projeto();
        this.tarefas = new ArrayList();
    }
    
    @PostConstruct
    public void init() {
        this.tarefaService = new Service<>(Tarefa.class);
        this.projetoService = new Service<>(Projeto.class);
        this.tarefas = this.tarefaService.findAll();
        
        // Recupera o parâmetro 'id' da URL
        String projetoId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("projetoId");

        if (projetoId != null && !projetoId.isEmpty()) {
            this.projeto = projetoService.findById(Long.valueOf(projetoId));
        }
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    public String salvarTarefa() {
        tarefa.setProjeto(projeto);
        tarefaService.create(tarefa);
        return "/tarefas/index.xhtml?faces-redirect=true";
    }

    public String editarTarefa(Long id) {
//        System.out.println("editando tarefa");
        return "/tarefas/cadastro.xhtml?faces-redirect=true";
    }

    public String excluirTarefa(Long id) {
        tarefaService.delete(id);
        return "/tarefas/index.xhtml?faces-redirect=true";
    }

    public String visualizarTarefa(Long id) {
//        System.out.println("visualizando tarefa");
        return "/tarefas/index.xhtml?faces-redirect=true";
    }
}
