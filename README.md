# TestePraticoJava
# Desafio – Teste Prático para Desenvolvedor Java

Bem-vindo ao projeto de Controle de Agendamentos para Vagas Disponíveis. Este guia irá orientá-lo na configuração, instalação e execução do projeto, fornecendo todas as informações necessárias para que você possa entender o funcionamento e as melhores práticas de manutenção.

# Visão Geral
O objetivo do projeto é criar uma aplicação completa para cadastro de vagas, solicitantes e agendamentos, além de permitir consultas detalhadas sobre os agendamentos realizados. 
A aplicação utiliza Spring Boot no back-end, junto com JPA/Hibernate para persistência. 
O front-end é construído com JSF/PrimeFaces para proporcionar uma interface de usuário rica.

# Tecnologias Utilizadas
Java: Linguagem de programação
Spring Boot: Framework para back-end
Hibernate: Framework de ORM
JSF/PrimeFaces: Frameworks para front-end
HSQLDB: Banco de dados em memória

# Funcionalidades
Cadastro de Vagas: Permite especificar as datas de início e fim, além da quantidade disponível para cada vaga.
Cadastro de Solicitantes: Simples cadastro de nomes dos solicitantes.
Cadastro de Agendamentos: Permite cadastrar agendamentos com data, número, motivo e solicitante.
Consulta de Agendamentos: Pesquisa e filtra os agendamentos por intervalo de datas.
Validações: Impede cadastro de vagas retroativas e agendamentos com falta de vagas disponíveis.

# Configuração Inicial
Clone o Repositório:
Faça o clone do repositório para o seu computador.
bash
Copie o codigo

git clone https://github.com/swilliamsilva/TestePraticoJava.git

# Configuração do Banco de Dados:
Edite o arquivo application.properties no diretório src/main/resources e atualize o caminho completo do banco de dados:
properties
altere

spring.datasource.url=jdbc:hsqldb:file:C:\\Projetos\\Teste-Pratico-Desenvolvedor-Java\\banco\\agenda;hsqldb.lock_file=false

# Compile e Instale o Projeto:
Use o comando Maven para compilar o projeto, ignorando os testes:
bash
digite
mvn install -DskipTests

Execute a Aplicação:
Inicie o aplicativo com o seguinte comando:
bash
digite

java -jar -Dserver.port=9494 target/Teste-Pratico-Desenvolvedor-Java-0.0.1-SNAPSHOT.jar

Acesse a Aplicação:
Pelo browse na porta 9494
http://localhost:9494/index.html

# Detalhes Técnicos Importantes
Banco de Dados: O projeto utiliza HSQLDB como banco de dados, proporcionando uma solução rápida e leve.
Se necessário, é possível trocar o banco de dados para outro sistema relacional, como MySQL ou PostgreSQL, ajustando as propriedades de conexão no arquivo application.properties.

Gestão de Dependências: O gerenciamento de dependências é feito pelo Maven, facilitando a atualização de bibliotecas e plugins. 
Verifique o arquivo pom.xml para ajustes ou adição de novas dependências.

# Arquitetura: A arquitetura segue um modelo de camadas:

Entidades: Representam as tabelas do banco de dados e são anotadas para a integração com o JPA.
Repositórios: Interfaces que fornecem métodos para CRUD e outras consultas personalizadas.
Serviços: Contêm a lógica de negócios e a manipulação dos dados.
Controladores: Ligam as requisições do usuário às camadas de serviço, controlando o fluxo de dados.
Front-end: A interface do usuário é implementada em JSF com PrimeFaces, fornecendo componentes ricos e responsivos.

Deploy: A aplicação pode ser facilmente empacotada como um arquivo .jar usando o Spring Boot Maven 

Plugin e ser executada em qualquer servidor com Java instalado.

# Considerações Finais
Este projeto apresenta um framework robusto para a criação de um sistema de agendamentos e gestão de vagas. A integração entre Spring Boot, JPA/Hibernate e JSF/PrimeFaces oferece uma base sólida, modular e escalável, pronta para personalizações ou futuras expansões.


