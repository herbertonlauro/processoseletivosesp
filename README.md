# Projeto Prático Processo Seletivo SESP
## Perfil de Desenvolvimento de Sistemas


### Cenário Proposto:

Deve ser implementada uma API Rest contendo pelo menos a estrutura de dados abaixo:

> **_Classes:_** PESSOA
>
> **_Classes:_** ENDEREÇO

### Requisitos Gerais:
> **_Requisitos:_**
> - O projeto deve ser criado utilizando MAVEN 3;
> - Utilizar linguagem Java 17 (ou superior) e SpringBoot Framework;
> - Para o armazenamento de dados poderá ser utilizado os seguintes bancos: Oracle, PostgreSQL, H2;
> - O projeto deve conter todas as operações básicas (CRUD) além das funcionalidades específicas listadas a seguir;
> - A estrutura do banco de dados deve ser gerada a partir do mapeamento das entidades;
> - As consultas devem conter paginação;

> **_Requisitos Específicos:_**
> - Criar CRUD para Pessoa e Endereço;
> - Criar consulta por nome, cpf e uma consulta que permita combinar partes do nome, data de nascimento e partes do nome da mãe;
> - Criar endpoint para consulta de pessoas a partir de uma cidade/estado;
> - Criar documentação da API utilizando Swagger ou equivalente;
> - Implementação de Testes Unitários para classes que contenham regras de negócio.

Este projeto utiliza o Quarkus, o Framework Java Supersônico Subatômico.

Se deseja saber mais sobre o Quarkus, por favor visite o seu website: [https://quarkus.io/](https://quarkus.io/) .

## Executando a aplicação em modo de desenvolvimento

Você pode executar sua aplicação em modo de desenvolvimento, que permite a codificação ao vivo, usando:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTA:_**  O Quarkus agora inclui uma interface de usuário de desenvolvimento, disponível apenas no modo de desenvolvimento em http://localhost:8080/q/dev/.

## Empacotando e executando a aplicação

A aplicação pode ser empacotada usando:

```shell script
./mvnw package
```

Isso produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`.
Esteja ciente de que não é um _über-jar_, pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

A aplicação agora pode ser executada usando `java -jar target/quarkus-app/quarkus-run.jar`.

Se deseja construir um _über-jar_, execute o seguinte comando:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

A aplicação, empacotada como um _über-jar_, agora pode ser executada usando `java -jar target/*-runner.jar`.

## Criando um executável nativo

Você pode criar um executável nativo usando:

```shell script
./mvnw package -Dnative
```

Ou, se não tiver o GraalVM instalado, pode executar a compilação do executável nativo em um contêiner usando:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Em seguida, pode executar seu executável nativo com: `./target/projetopraticosesp-1.0-SNAPSHOT-runner`

Se deseja saber mais sobre a criação de executáveis nativos, consulte [https://quarkus.io/guides/maven-tooling](https://quarkus.io/guides/maven-tooling).

## Guias Relacionados

- Driver JDBC - H2 ([guia](https://quarkus.io/guides/datasource)): Conecte-se ao banco de dados H2 via JDBC

## Código Fornecido

### RESTEasy Reativo

Inicie facilmente seus Serviços da Web REST Reativos

[Seção do guia relacionado...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

