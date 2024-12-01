/*package controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import conexion.ConexaoMongoDB;

public class MenuAtualizar {

    private static final Logger logger = Logger.getLogger(MenuAtualizar.class.getName());

    public static void menuAtualizar(Scanner teclado) {
        char opcaoAtualizar;
        ConexaoMongoDB conexaoMongoDB = new ConexaoMongoDB();
        do {
            System.out.println("Menu de Atualização\n" +
                    "1. Atualizar Cliente\n" +
                    "2. Atualizar Ordem de Serviço\n" +
                    "3. Voltar ao Menu Principal"
            );
            opcaoAtualizar = teclado.next().charAt(0);
            switch (opcaoAtualizar) {
                case '1':
                    System.out.println("Opção 1: Atualizar Cliente");
                    atualizarCliente(teclado, conexaoMongoDB);
                    break;
                case '2':
                    System.out.println("Opção 2: Atualizar Ordem de Serviço");
                    atualizarOrdemServico(teclado, conexaoMongoDB);
                    break;
                case '3':
                    conexaoMongoDB.close();
                    MenuPrincipal.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcaoAtualizar != '3');
    }

    private static void atualizarCliente(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
        System.out.println("Atualizando dados do cliente...");

        try {
            System.out.print("Informe o ID do cliente a ser atualizado: ");
            int idClienteMongo = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Novo nome para o cliente: ");
            String novoNomeClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo CPF para o cliente: ");
            String novoCpfClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo telefone para o cliente: ");
            String novoTelefoneClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Nova rua para o cliente: ");
            String novaRuaClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo número de residência para o cliente: ");
            String novoNumeroResidenciaClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo bairro para o cliente: ");
            String novoBairroClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Nova cidade para o cliente: ");
            String novaCidadeClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo CEP para o cliente: ");
            String novoCepClienteMongo = teclado.next();
            teclado.nextLine();

            Document filter = new Document("cliente_id", idClienteMongo);
            Document update = new Document("$set", new Document("nome", novoNomeClienteMongo)
                    .append("cpf", novoCpfClienteMongo)
                    .append("telefone", novoTelefoneClienteMongo)
                    .append("rua", novaRuaClienteMongo)
                    .append("numero_residencia", novoNumeroResidenciaClienteMongo)
                    .append("bairro", novoBairroClienteMongo)
                    .append("cidade", novaCidadeClienteMongo)
                    .append("cep", novoCepClienteMongo));
            conexaoMongoDB.getDatabase().getCollection("cliente").updateOne(filter, update);
            System.out.println("Dados do cliente atualizados no MongoDB com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao atualizar dados do cliente no MongoDB: " + e.getMessage());
        }
    }

    private static void atualizarOrdemServico(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
        System.out.println("Atualizando dados da ordem de serviço...");

        try {
            System.out.print("Informe o ID da ordem de serviço a ser atualizada: ");
            int idOrdemServicoMongo = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Novo nome do equipamento: ");
            String novoNomeEquipamento = teclado.next();
            teclado.nextLine();

            System.out.print("Novo fabricante: ");
            String novoFabricante = teclado.next();
            teclado.nextLine();

            System.out.print("Novo modelo: ");
            String novoModelo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo defeito: ");
            String novoDefeito = teclado.next();
            teclado.nextLine();

            System.out.print("Nova observação: ");
            String novaObservacao = teclado.next();
            teclado.nextLine();

            System.out.print("Informe o ID do cliente associado a esta ordem de serviço: ");
            int idClienteAssociado = teclado.nextInt();
            teclado.nextLine();

            Document filter = new Document("ordem_servico_id", idOrdemServicoMongo);
            Document update = new Document("$set", new Document("nome_equipamento", novoNomeEquipamento)
                    .append("fabricante", novoFabricante)
                    .append("modelo", novoModelo)
                    .append("defeito", novoDefeito)
                    .append("observacao", novaObservacao)
                    .append("cliente_id", idClienteAssociado));

            conexaoMongoDB.getDatabase().getCollection("ordem_servico").updateOne(filter, update);
            System.out.println("Dados da ordem de serviço atualizados no MongoDB com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao atualizar dados da ordem de serviço no MongoDB: " + e.getMessage());
        }
    }
    
    
}*/

package controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import conexion.ConexaoMongoDB;

public class MenuAtualizar {

    private static final Logger logger = Logger.getLogger(MenuAtualizar.class.getName());

    public static void menuAtualizar(Scanner teclado) {
        char opcaoAtualizar;
        ConexaoMongoDB conexaoMongoDB = new ConexaoMongoDB();
        do {
            System.out.println("Menu de Atualização\n" +
                    "1. Atualizar Cliente\n" +
                    "2. Atualizar Ordem de Serviço\n" +
                    "3. Voltar ao Menu Principal"
            );
            opcaoAtualizar = teclado.next().charAt(0);
            switch (opcaoAtualizar) {
                case '1':
                    System.out.println("Opção 1: Atualizar Cliente");
                    atualizarCliente(teclado, conexaoMongoDB);
                    
                    break;
                case '2':
                    System.out.println("Opção 2: Atualizar Ordem de Serviço");
                    atualizarOrdemServico(teclado, conexaoMongoDB);
                    break;
                case '3':
                    conexaoMongoDB.close();
                    MenuPrincipal.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcaoAtualizar != '3');
    }

    private static void atualizarCliente(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
    	System.out.println("Atualizando dados do cliente...");

        try {
            System.out.print("Informe o ID do cliente a ser atualizado: ");
            int idClienteMongo = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Novo nome para o cliente: ");
            String novoNomeClienteMongo = teclado.nextLine();

            System.out.print("Novo CPF para o cliente: ");
            String novoCpfClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo telefone para o cliente: ");
            String novoTelefoneClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Nova rua para o cliente: ");
            String novaRuaClienteMongo = teclado.nextLine();
            

            System.out.print("Novo número de residência para o cliente: ");
            String novoNumeroResidenciaClienteMongo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo bairro para o cliente: ");
            String novoBairroClienteMongo = teclado.nextLine();
            

            System.out.print("Nova cidade para o cliente: ");
            String novaCidadeClienteMongo = teclado.nextLine();
            

            System.out.print("Novo CEP para o cliente: ");
            String novoCepClienteMongo = teclado.next();
            teclado.nextLine();

            Document filter = new Document("cliente_id", idClienteMongo);
            Document update = new Document("$set", new Document("nome", novoNomeClienteMongo)
                    .append("cpf", novoCpfClienteMongo)
                    .append("telefone", novoTelefoneClienteMongo)
                    .append("rua", novaRuaClienteMongo)
                    .append("numero_residencia", novoNumeroResidenciaClienteMongo)
                    .append("bairro", novoBairroClienteMongo)
                    .append("cidade", novaCidadeClienteMongo)
                    .append("cep", novoCepClienteMongo));
            conexaoMongoDB.getDatabase().getCollection("cliente").updateOne(filter, update);
            System.out.println("Dados do cliente atualizados no MongoDB com sucesso!");
            exibirClienteAtualizado(conexaoMongoDB, idClienteMongo);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao atualizar dados do cliente no MongoDB: " + e.getMessage());
        }
    }

    private static void atualizarOrdemServico(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
    	System.out.println("Atualizando dados da ordem de serviço...");

        try {
            System.out.print("Informe o ID da ordem de serviço a ser atualizada: ");
            int idOrdemServicoMongo = teclado.nextInt();
            teclado.nextLine();

            System.out.print("Novo nome do equipamento: ");
            String novoNomeEquipamento = teclado.nextLine();
            

            System.out.print("Novo fabricante: ");
            String novoFabricante = teclado.next();
            teclado.nextLine();

            System.out.print("Novo modelo: ");
            String novoModelo = teclado.next();
            teclado.nextLine();

            System.out.print("Novo defeito: ");
            String novoDefeito = teclado.nextLine();
            

            System.out.print("Nova observação: ");
            String novaObservacao = teclado.nextLine();
            

            System.out.print("Informe o ID do cliente associado a esta ordem de serviço: ");
            int idClienteAssociado = teclado.nextInt();
            teclado.nextLine();

            Document filter = new Document("ordem_servico_id", idOrdemServicoMongo);
            Document update = new Document("$set", new Document("nome_equipamento", novoNomeEquipamento)
                    .append("fabricante", novoFabricante)
                    .append("modelo", novoModelo)
                    .append("defeito", novoDefeito)
                    .append("observacao", novaObservacao)
                    .append("cliente_id", idClienteAssociado));

            conexaoMongoDB.getDatabase().getCollection("ordem_servico").updateOne(filter, update);
            System.out.println("Dados da ordem de serviço atualizados no MongoDB com sucesso!");
            exibirOrdemServicoAtualizada(conexaoMongoDB, idOrdemServicoMongo);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao atualizar dados da ordem de serviço no MongoDB: " + e.getMessage());
        }
    }

    private static void exibirClienteAtualizado(ConexaoMongoDB conexaoMongoDB, int idCliente) {
        try {
            Document clienteDocument = conexaoMongoDB.getDatabase().getCollection("cliente")
                    .find(new Document("cliente_id", idCliente)).first();

            if (clienteDocument != null) {
                System.out.println("Dados atualizados do Cliente:");
                exibirCliente(clienteDocument);
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter e exibir dados atualizados do cliente: " + e.getMessage());
        }
    }

    private static void exibirOrdemServicoAtualizada(ConexaoMongoDB conexaoMongoDB, int idOrdemServico) {
        try {
            Document ordemServicoDocument = conexaoMongoDB.getDatabase().getCollection("ordem_servico")
                    .find(new Document("ordem_servico_id", idOrdemServico)).first();

            if (ordemServicoDocument != null) {
                System.out.println("Dados atualizados da Ordem de Serviço:");
                exibirOrdemServico(ordemServicoDocument);
            } else {
                System.out.println("Ordem de Serviço não encontrada.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter e exibir dados atualizados da ordem de serviço: " + e.getMessage());
        }
    }

    private static void exibirCliente(Document clienteDocument) {
        System.out.println("ID: " + clienteDocument.getInteger("cliente_id"));
        System.out.println("Nome: " + clienteDocument.getString("nome"));
        System.out.println("CPF: " + clienteDocument.getString("cpf"));
        System.out.println("Telefone: " + clienteDocument.getString("telefone"));
        System.out.println("Rua: " + clienteDocument.getString("rua"));
        System.out.println("Número: " + clienteDocument.getString("numero_residencia"));
        System.out.println("Bairro: " + clienteDocument.getString("bairro"));
        System.out.println("CEP: " + clienteDocument.getString("cep"));
        System.out.println("Cidade: " + clienteDocument.getString("cidade"));
        System.out.println("----------------------------------------");
    }

    private static void exibirOrdemServico(Document ordemServicoDocument) {
        System.out.println("ID: " + ordemServicoDocument.getInteger("ordem_servico_id"));
        System.out.println("Nome do equipamento: " + ordemServicoDocument.getString("nome_equipamento"));
        System.out.println("Fabricante: " + ordemServicoDocument.getString("fabricante"));
        System.out.println("Modelo: " + ordemServicoDocument.getString("modelo"));
        System.out.println("Defeito: " + ordemServicoDocument.getString("defeito"));
        System.out.println("Observação: " + ordemServicoDocument.getString("observacao"));
        System.out.println("ID do Cliente: " + ordemServicoDocument.getInteger("cliente_id"));
        System.out.println("------------------------------");
    }
}

