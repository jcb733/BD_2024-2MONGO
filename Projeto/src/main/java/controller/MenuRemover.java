package controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import conexion.ConexaoMongoDB;

public class MenuRemover {

    private static final Logger logger = Logger.getLogger(MenuRemover.class.getName());

    public static void menuRemover(Scanner teclado) {
        char opcaoRemover;
        ConexaoMongoDB conexaoMongoDB = new ConexaoMongoDB();

        do {
            System.out.println("Menu de Remoção\n" +
                    "1. Remover Cliente\n" +
                    "2. Remover Ordem de Serviço\n" +
                    "3. Voltar ao Menu Principal"
            );
            opcaoRemover = teclado.next().charAt(0);
            switch (opcaoRemover) {
                case '1':
                    System.out.println("Opção 1: Remover Cliente");
                    removerCliente(teclado, conexaoMongoDB);
                    break;
                case '2':
                    System.out.println("Opção 2: Remover Ordem de Serviço");
                    removerOrdemServico(teclado, conexaoMongoDB);
                    break;
                case '3':
                    conexaoMongoDB.close();
                    MenuPrincipal.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcaoRemover != '3');
    }

    private static void removerCliente(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
        System.out.println("Removendo dados do cliente...");

        try {
            System.out.print("Informe o ID do cliente a ser removido: ");
            int idClienteMongo = teclado.nextInt();
            Document filter = new Document("cliente_id", idClienteMongo);
            conexaoMongoDB.getDatabase().getCollection("cliente").deleteOne(filter);
            System.out.println("Dados do cliente removidos do MongoDB com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao remover dados do cliente do MongoDB: " + e.getMessage());
        }
    }

    private static void removerOrdemServico(Scanner teclado, ConexaoMongoDB conexaoMongoDB) {
        System.out.println("Removendo dados da ordem de serviço...");

        try {
            System.out.print("Informe o ID da ordem de serviço a ser removida: ");
            int idOrdemServicoMongo = teclado.nextInt();
            Document filter = new Document("ordem_servico_id", idOrdemServicoMongo);
            conexaoMongoDB.getDatabase().getCollection("ordem_servico").deleteOne(filter);
            System.out.println("Dados da ordem de serviço removidos do MongoDB com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao remover dados da ordem de serviço do MongoDB: " + e.getMessage());
        }
    }
}
