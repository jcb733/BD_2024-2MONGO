Sistema de Gestão de Ordem de Serviço
Este é um sistema simples para Gerenciamento de Ordens de Serviço, que permite a inserção, remoção, atualização e geração de relatórios de ordens de serviço e seus respectivos clientes. O projeto utiliza um banco de dados Oracle e uma aplicação Java para interagir com o banco de dados.

Pré-requisitos
Sistema operacional Linux
Java 8 ou superior
Oracle Database
Driver JDBC (arquivo ojdbc8.jar) para conexão com o Oracle Database
Configuração do Banco de Dados
Certifique-se de que o Oracle Database esteja configurado e em execução. Você pode usar o SQL Developer para executar os scripts SQL fornecidos para criar as tabelas necessárias:

DROP TABLE OrdemServico;
DROP TABLE Cliente;

-- Tabela Cliente
CREATE TABLE Cliente (
    clienteId INTEGER PRIMARY KEY NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    cpf VARCHAR2(11) NOT NULL,
    telefone VARCHAR2(20) NOT NULL,
    rua VARCHAR2(255) NOT NULL,
    cep VARCHAR2(8) NOT NULL,
    cidade VARCHAR2(100) NOT NULL
);

-- Tabela OrdemServico
CREATE TABLE OrdemServico (
    ordemServicoId INTEGER PRIMARY KEY NOT NULL,
    clienteId INTEGER NOT NULL,
    nomeEquipamento VARCHAR2(100) NOT NULL,
    fabricante VARCHAR2(50) NOT NULL,
    modelo VARCHAR2(50) NOT NULL,
    defeito VARCHAR2(100) NOT NULL,
    observacao VARCHAR2(255) NOT NULL,
    FOREIGN KEY (clienteId) REFERENCES Cliente(clienteId)
);
Observação: Certifique-se de criar as sequências e triggers necessárias para geração automática de IDs, caso aplicável.

Executando o Projeto

Clone este repositório: https://github.com/jcb733/BD_MONGO_2024-2

Execute o aplicativo: java Main

Dica: Caso esteja utilizando o Visual Studio Code, será necessário instalar a extensão Pack for Java para compilar e executar o projeto.

O aplicativo será iniciado e você verá o menu principal, onde poderá interagir com o sistema.

Como Usar
Insira informações de clientes e ordens de serviço.
Atualize os registros existentes.
Remova registros de clientes ou ordens de serviço.
Gere relatórios detalhados.

Video Explicativo

Confira o vídeo demonstrativo de como utilizar o programa no seguinte link: https://www.youtube.com/watch?v=2nUPlkbK7PE