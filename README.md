# project-task-manager

Este projeto é um gerenciador de projetos e tarefas desenvolvido com:

- Java Server Faces (JSF)
- Hibernate
- HQL (Hibernate Query Language)
- ~~Spring Framework~~ _Obs.: Não foi necessário pois como o projeto foi desenvolvido numa aplicação gerada por um arquétipo do Maven, houveram dificuldades para integrar o Spring ao modelo inicial gerado, tendo um retrabalho de construir outro microsserviço além da aplicação JSF que seria a API para persistir as informações dos projetos e tarefas no banco de dados_

> URL (raiz): http://localhost:8080/project-task-manager

### Como executar

Para rodar esse projeto utilizo o [Docker / Docker Compose](https://www.docker.com/products/docker-desktop/) para subir o container da minha aplicação com todos os serviços necessários, incluindo ambiente JDK 8, Tomcat 9, banco de dados MySQL 8 e bibliotecas compatíveis com o [RichFaces](https://richfaces.jboss.org/). Para executar o conteiner desse projeto, faça o clone desse repositório e com o Docker instalado, abra-o em um terminal de sua preferência e com o Docker instalado em sua máquina execute o comando a seguir:

```bash
docker-compose up -d
```

Espere por alguns minutos e abra a URL raiz do projeto no seu navegador.

> **Obs.:** A construção desse projeto foi desenvolvida em um container para criar um ambiente mais antigo que rode essa aplicação.
> Como o RichFaces chegou ao fim em 2016 e o JSF passou do JaxaX para o Jakarta EE nas versões mais recentes, foi necessária a criação de uma construção Docker para executar essa aplicação.

### Páginas

- `/projetos/cadastro.jsf`

   ![image](https://github.com/user-attachments/assets/eec4afff-0bda-41a0-bd03-9020dc4a6d78)

- `/projetos/index.jsf`

   ![image](https://github.com/user-attachments/assets/11f0f95e-8756-486a-9b1c-e7603e165726)

- `/tarefas/cadastro.jsf?projetoId=1`

   ![image](https://github.com/user-attachments/assets/d25f8385-e766-4626-b8ba-dc82db0868d5)

- `/tarefas/index.jsf`

   ![image](https://github.com/user-attachments/assets/9ccf4103-6825-4760-9704-f374751ec3ff)

---

Agora é só testar e avaliar! ;-)
