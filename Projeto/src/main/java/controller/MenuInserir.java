package controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import conexion.ConexaoMongoDB;

public class MenuInserir {

    private static final Logger logger = Logger.getLogger(MenuInserir.class.getName());

    public static void menuInserir(Scanner teclado) {
        char opcaoInserir;
        ConexaoMongoDB conexaoMongoDB = new ConexaoMongoDB();

        do {
            System.out.println("Menu de Inserção\n" +
                    "1. Inserir Cliente\n" +
                    "2. Inserir Ordem de Serviço\n" +
                    "3. Voltar ao Menu Principal"
            );
            opcaoInserir = teclado.next().charAt(0);
            switch (opcaoInserir) {
                case '1':
                    System.out.println("Opção 1: Inserir Cliente");
                    inserirCliente(teclado, conexaoMongoDB);
                    break;
                case '2':
                    System.out.println("Opção 2: Inserir Ordem de Serviço");
                    inserirOrdemServico(teclado, conexaoMongoDB);
                    break;
                case '3':
                    conexaoMongoDB.close();
                    MenuPrincipal.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcaoInserir != '3');
    }

    private static void inserirCliente(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
        logger.log(Level.INFO, "Inserindo dados do cliente...");

        int idClienteMongo = obterUltimoIdClienteMongo(conexaoMongoDB) + 1;

        System.out.print("Nome: ");
        String nomeCliente = teclado.next();
        teclado.nextLine();        
        System.out.print("CPF: ");
        String cpfCliente = teclado.nextLine();
        
        System.out.print("Telefone: ");
        String telefoneCliente = teclado.nextLine();
        
        System.out.print("Rua: ");
        String ruaCliente = teclado.nextLine();
        
        System.out.print("Número da Residência: ");
        String numeroResidenciaCliente = teclado.next();
        teclado.nextLine();
        ;
        System.out.print("Bairro: ");
        String bairroCliente = teclado.nextLine();
        
        System.out.print("CEP: ");
        String cepCliente = teclado.nextLine();
        
        System.out.print("Cidade: ");
        String cidadeCliente = teclado.nextLine();
        

        Document clienteDocument = new Document("cliente_id", idClienteMongo)
                .append("nome", nomeCliente)
                .append("cpf", cpfCliente)
                .append("telefone", telefoneCliente)
                .append("rua", ruaCliente)
                .append("numero_residencia", numeroResidenciaCliente)
                .append("bairro", bairroCliente)
                .append("cep", cepCliente)
                .append("cidade", cidadeCliente);

        try {
            conexaoMongoDB.getDatabase().getCollection("cliente").insertOne(clienteDocument);
            logger.log(Level.INFO, "Dados do cliente inseridos no MongoDB com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao inserir dados do cliente no MongoDB: " + e.getMessage());
        }
    }

    private static void inserirOrdemServico(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
        logger.log(Level.INFO, "Inserindo dados da ordem de serviço...");

        System.out.print("Digite o ID do Cliente: ");
        int idCliente = teclado.nextInt();

        // Verifica se o cliente existe
        if (!clienteExiste(conexaoMongoDB, idCliente)) {
            System.out.println("Cliente não encontrado. Cadastre o cliente antes de criar uma ordem de serviço.");
            return;
        }

        int idOrdemServicoMongo = obterUltimoIdOrdemServicoMongo(conexaoMongoDB) + 1;

        System.out.print("Nome do Equipamento: ");
        String nomeEquipamento = teclado.next();
        teclado.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = teclado.next();
        teclado.nextLine();
        System.out.print("Modelo: ");
        String modelo = teclado.next();
        teclado.nextLine();
        System.out.print("Defeito: ");
        String defeito = teclado.nextLine();
        
        System.out.print("Observação: ");
        String observacao = teclado.nextLine();
        

        Document ordemServicoDocument = new Document("ordem_servico_id", idOrdemServicoMongo)
                .append("cliente_id", idCliente)
                .append("nome_equipamento", nomeEquipamento)
                .append("fabricante", fabricante)
                .append("modelo", modelo)
                .append("defeito", defeito)
                .append("observacao", observacao);

        try {
            conexaoMongoDB.getDatabase().getCollection("ordem_servico").insertOne(ordemServicoDocument);
            logger.log(Level.INFO, "Dados da ordem de serviço inseridos no MongoDB com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao inserir dados da ordem de serviço no MongoDB: " + e.getMessage());
        }
    }

    private static int obterUltimoIdClienteMongo(ConexaoMongoDB conexaoMongoDB) {
        try {
            MongoCollection<Document> clienteCollection = conexaoMongoDB.getDatabase().getCollection("cliente");

            Document sortQuery = new Document("cliente_id", -1); // Ordenar em ordem decrescente
            Document result = clienteCollection.find().sort(sortQuery).limit(1).first();

            if (result != null) {
                return result.getInteger("cliente_id", 0) + 1;
            } else {
                return 1; // Se não houver nenhum documento na coleção, retorna 1 como o primeiro ID.
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter último ID de cliente no MongoDB: " + e.getMessage());
            return 0;
        }
    }

    private static int obterUltimoIdOrdemServicoMongo(ConexaoMongoDB conexaoMongoDB) {
        try {
            MongoCollection<Document> ordemServicoCollection = conexaoMongoDB.getDatabase().getCollection("ordem_servico");

            Document sortQuery = new Document("ordem_servico_id", -1); // Ordenar em ordem decrescente
            Document result = ordemServicoCollection.find().sort(sortQuery).limit(1).first();

            if (result != null) {
                return result.getInteger("ordem_servico_id", 0) + 1;
            } else {
                return 1; // Se não houver nenhum documento na coleção, retorna 1 como o primeiro ID.
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao obter último ID de ordem de serviço no MongoDB: " + e.getMessage());
            return 0;
        }
    }

    private static boolean clienteExiste(ConexaoMongoDB conexaoMongoDB, int idCliente) {
        try {
            MongoCollection<Document> clienteCollection = conexaoMongoDB.getDatabase().getCollection("cliente");

            Document clienteQuery = new Document("cliente_id", idCliente);
            return clienteCollection.find(clienteQuery).first() != null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao verificar se o cliente existe no MongoDB: " + e.getMessage());
            return false;
        }
    }
}
