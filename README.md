# Challenge Back-end - Controle Financeiro
Este projeto foi desenvolvido como parte da segunda edição do Alura Challenges para Back-end. A proposta do desafio é criar uma API para controle financeiro dos usuários, passando por diferentes etapas de desenvolvimento, incluindo mudanças na API, melhorias de segurança.

## Descrição
O objetivo do projeto é criar uma API RESTful que permita o controle financeiro de usuários. A API oferece funcionalidades básicas, como cadastro e gerenciamento de receitas e despesas, além de autenticação e segurança para garantir que apenas usuários autenticados possam acessar seus dados.

## Tecnologias Utilizadas
Spring Boot: Framework para criação da API RESTful.
<br>
Spring Security: Para autenticação e autorização dos usuários.
<br>
JWT (JSON Web Tokens): Para gerenciar a autenticação de forma segura.
<br>
Banco de Dados: Utilização de MySQL para armazenar os dados de receitas e despesas.
<br>
## Funcionalidades
<br>
Cadastro e login de usuários: Endpoint para registrar novos usuários e realizar login com autenticação JWT.
<br>
Controle de receitas e despesas: Cadastro, listagem e atualização de receitas e despesas financeiras.
<br>
Filtros de busca: Possibilidade de buscar receitas e despesas por descrição e por período (ano/mês).
<br>
Segurança: Utilização de JWT para autenticação e autorização de usuários.
<br>

## Endpoints da Aplicação
<br>

 1. Cadastro e Autenticação


### POST /auth/register
<br>

![Image](https://github.com/user-attachments/assets/33dfe786-0fbe-4958-9e22-2cee85131a9b)
<br>

### POST /auth/login
<br>

![Image](https://github.com/user-attachments/assets/4a3d8066-0c2d-4882-9520-8738220e6df8)
<br>

 2. Controle de Despesas

<br>
 
### POST /despesas
<br>

![Image](https://github.com/user-attachments/assets/3722fb66-7c74-41b1-a8f3-3d7ec7277f57)
<br>

### GET /despesas
<br>

![Image](https://github.com/user-attachments/assets/d4b5b832-c61e-46fa-9bd6-b7e694f88e65)
<br>

### GET /despesas/{id}
<br>

![Image](https://github.com/user-attachments/assets/e0ba81fe-96b7-4c19-ab2b-d6eb3ebcfece)
<br>

### GET /despesas/{ano}/{mes}
<br>

![Image](https://github.com/user-attachments/assets/1a0fa2f4-e713-4cda-9200-b882ed59f0c5)
<br>

### GET /despesas/buscar
<br>

![Image](https://github.com/user-attachments/assets/76efec0c-dca9-448d-8daa-0fba76761d4a)
<br>

### PUT /despesas/{id}
<br>

![Image](https://github.com/user-attachments/assets/ab7609b3-a6a0-402b-9077-ab079dd1ba5c)
<br>

### DELETE /despesas/{id}
<br>

![Image](https://github.com/user-attachments/assets/92af1321-dd43-4698-bdaa-a5d7f6353250)
<br>
 3. Controle de Receitas
### POST /receitas
<br>

![Image](https://github.com/user-attachments/assets/b9ba0b1b-c927-4bf2-b7b0-ff7a43f9f385)
<br>

### GET /receitas
<br>

![Image](https://github.com/user-attachments/assets/f88869dd-b2df-4d0a-8c71-7dc4610fc91a)
<br>

### GET /receitas/{ano}/{mes}
<br>

![Image](https://github.com/user-attachments/assets/072a42cd-744e-405f-a2a8-cb0f5d0550a0)
<br>

### GET /receitas/{id}
<br>

![Image](https://github.com/user-attachments/assets/1779669f-4769-454f-8a3a-88c7926a2add)
<br>

### GET /receitas/buscar

<br>

![Image](https://github.com/user-attachments/assets/44afdd93-4dc1-4562-b691-4df99b5d1f6f)
<br>

### PUT /receitas/{id}
<br>

![Image](https://github.com/user-attachments/assets/745c21bc-ef63-4efe-9899-a1bba583b408)
<br>

### DELETE /receitas/{id}
<br>

![Image](https://github.com/user-attachments/assets/17bcc9ef-9d62-4a6e-8c60-d8b2f0ff6a24)
<br>

## Requisitos
JDK 17 ou superior.
<br>
Maven ou Gradle (dependendo da configuração do projeto).
<br>
Banco de dados configurado: MySQL para o ambiente de produção.

### Agradecimentos
Agradeço aos instrutores Jaqueline Oliveira e Rodrigo Ferreira pela orientação durante o desafio.
