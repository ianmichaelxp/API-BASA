# Projeto Portal de Processos - Java API Restful

API de um portal de cadastro e consulta de processos judiciais.
A documentação da API pode ser acessada em [https://{url}.herokuapp.com/swagger-ui.html](https://{url}.herokuapp.com/swagger-ui.html)

## Estrutura do Projeto
Cada pacote possui um conjuntos de classes que distribui as responsabilidades do projeto:  
- Model: onde estão definidos os modelos ou seja as classes dos objetos usados no sistema, que são entidade mapeada para o Banco de Dados
- Repository: onde estão definidos os métodos JPA para acessar os dados no Banco de Dados
- Service: onde estão definidas as regras de negócio para manipulação dos Models
- DTO: onde estão definidas as classes em que serão consumidas e enviadas pelo frontend
- Controller: onde estão configurados os recursos / endpoints a serem consumidos pelo frontend
- Enums: onde estão definidas as enumerações
- Exception: onde estão definidas as exceções personalizadas a serem tratadas em todo o sistema

##Atributos gerais para as classes de Modelo
Foi utilizado uma biblioteca chamada Lombok, que permite usar anotações para deixar implícita escrita de métodos
como Get, Set e construtores (com e sem parâmetros). Essas anotações foram usadas em todas as classes do pacote model.

## Processo
O model tem os atributos:
- Id
- Numero do processo
- Data de Cadastro
- Segredo Justica
- Situação 
- Quantidade das partes

O service faz as validações para criação de processo.
- O numero, dataCadastro, segredoJustica, situacao e qtdPartes não podem ser nulos.
- O numero não pode passar de 19 caracteres.

O Controller mapeia as rotas da API, que podem ser vistas com mais detalhes na [documentação](https://{url}.herokuapp.com/swagger-ui.html) feita com o Swagger

## SegredoJustica Enum
- PUBLICO
- NAO_PUBLICO

## Situacao Enum
- ANDAMENTO
- ARQUIVADO
- JULGADO

# SPRING BOOT
- A API será um Portal com funcionalidades específicas de CRUD de processos.

## Funcionalidades da API
### Processo
- Listar
- Criar
- Editar
- Excluir

# Requisitos

- Java 8
- Oracle Database 18c XE
- Maven

## Instalação
- Na pasta raiz do projeto rodar o comando maven `mvn clean package`
- Após concluir o build abrir a pasta Target `cd target`
- Rodar a aplicação JAR `java -jar portal-0.0.1-SNAPSHOT.jar`

## DUMP
- O arquivo do esquema do banco de dados está pasta raiz. (exportar.sql)
