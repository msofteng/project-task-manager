package com.caed.projectaskmanager.bean;

import com.caed.projectaskmanager.model.Projeto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@ViewScoped
@ManagedBean
public class ProjetoBean implements Serializable {
    private Projeto projeto;
    private List<Projeto> projetos;
    
    public ProjetoBean() {
        this.projeto = new Projeto();
        this.projetos = new ArrayList();
        
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
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
        System.out.println("salvando o projeto");
        System.out.println(this.projeto);
        return "/projetos/index.xhtml?faces-redirect=true";
    }

    public String editarProjeto(Long id) {
        System.out.println("editando o projeto");
        return "/projetos/cadastro.xhtml?faces-redirect=true";
    }

    public String excluirProjeto(Long id) {
        System.out.println("removendo o projeto");
        return "/projetos/index.xhtml?faces-redirect=true";
    }

    public String visualizarProjeto(Long id) {
        System.out.println("visualizando o projeto");
        return "/projetos/index.xhtml?faces-redirect=true";
    }
}