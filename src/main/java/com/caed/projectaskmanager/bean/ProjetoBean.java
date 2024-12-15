package com.caed.projectaskmanager.bean;

import com.caed.projectaskmanager.model.Projeto;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@Named("projetoBean")
@RequestScoped
public class ProjetoBean {
    private Projeto projeto;  // O objeto que representa um projeto
    private List<Projeto> projetos;  // A lista de projetos cadastrados

    // Construtores
    public ProjetoBean() {
        this.projeto = new Projeto();  // Inicializa o objeto de projeto
        this.projetos = new ArrayList<>();  // Carrega a lista de projetos da base de dados
        
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

    // Métodos de ação
    public String salvarProjeto() {
        // Chama o DAO para salvar o projeto na base de dados
        System.out.println("salvando o projeto");
        System.out.println(this.projeto);
        return "listagemProjetos.xhtml?faces-redirect=true";  // Redireciona para a página de listagem
    }

    public String editarProjeto(Long id) {
        System.out.println("editando o projeto");
        return "cadastroProjeto.xhtml?faces-redirect=true";  // Redireciona para a página de cadastro
    }

    public String excluirProjeto(Long id) {
        System.out.println("removendo o projeto");
        return "listagemProjetos.xhtml?faces-redirect=true";  // Redireciona para a página de listagem
    }

    public String visualizarProjeto(Long id) {
        System.out.println("visualizando o projeto");
        return "visualizarProjeto.xhtml?faces-redirect=true";  // Exibe a página de visualização do projeto
    }
}
