package com.caed.projectaskmanager.bean;

import com.caed.projectaskmanager.model.Projeto;
import com.caed.projectaskmanager.service.Service;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class ProjetoBean implements Serializable {
    private Projeto projeto;
    private List<Projeto> projetos;
    private Service<Projeto> projetoService;
    
    public ProjetoBean() throws SQLException {
        this.projeto = new Projeto();
        this.projetos = new ArrayList();
        
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
    @PostConstruct
    public void init() {
        this.projetoService = new Service<>(Projeto.class);
        this.projetos = this.projetoService.findAll();
        
        // Recupera o parâmetro 'id' da URL
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        // Se 'id' for válido, carrega o projeto correspondente
        if (id != null && !id.isEmpty()) {
            this.projeto = projetoService.findById(Long.valueOf(id));
        } else {
            // Caso contrário, cria um novo projeto
            this.projeto = new Projeto();
        }
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    
    public String salvarProjeto() {
        if (projeto.getId() == null) {
            projetoService.create(projeto);
        } else {
            projetoService.update(projeto);
        }
        
        return "/projetos/index.xhtml?faces-redirect=true";
    }

    public String editarProjeto(Long id) {
        this.projeto = projetoService.findById(id);
        return "/projetos/cadastro.xhtml?faces-redirect=true&id=" + id;
    }

    public String excluirProjeto(Long id) {
        projetoService.delete(id);
        return "/projetos/index.xhtml?faces-redirect=true";
    }

    public String visualizarProjeto(Long id) {
        return "/projetos/index.xhtml?faces-redirect=true";
    }
}
