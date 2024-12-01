package controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import conexion.ConexaoMongoDB;

public class MenuRelatorio {

    private static final Logger logger = Logger.getLogger(MenuRelatorio.class.getName());

    public static void menuRelatorio(Scanner teclado) {
        char opcaoRelatorios;
        ConexaoMongoDB conexaoMongoDB = new ConexaoMongoDB();
        do {
            System.out.println("Menu de Relatórios\n" +
                    "1. Listar todos os clientes cadastrados\n" +
                    "2. Listar todas as ordens de serviços\n" +
                    "3. Mostrar a quantidade de ordens de serviços cadastradas\n" +
                    "4. Voltar ao Menu Principal"
            );
            opcaoRelatorios = teclado.next().charAt(0);
            switch (opcaoRelatorios) {
                case '1':
                    System.out.println("Opção 1: Listar todos os clientes cadastrados");
                    listarClientes(conexaoMongoDB);
                    break;
                case '2':
                    System.out.println("Opção 2: Listar todas as ordens de serviços");
                    listarOrdensServico(conexaoMongoDB);
                    break;
                case '3':
                    System.out.println("Opção 3: Mostrar todas as ordens de serviços cadastradas");
                    mostrarQuantidadeOrdensServico(conexaoMongoDB);
                    break;
                case '4':
                	conexaoMongoDB.close();
                    MenuPrincipal.menuPrincipal();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (opcaoRelatorios != '4');
    }

    private static void listarClientes(ConexaoMongoDB conexaoMongoDB) {
        try {
            conexaoMongoDB.getDatabase().getCollection("cliente")
                    .find()
                    .forEach((Document cliente) -> {
                        System.out.println("ID: " + cliente.getInteger("cliente_id"));
                        System.out.println("Nome: " + cliente.getString("nome"));
                        System.out.println("CPF: " + cliente.getString("cpf"));
                        System.out.println("Telefone: " + cliente.getString("telefone"));
                        System.out.println("Rua: " + cliente.getString("rua"));
                        System.out.println("Número: " + cliente.getString("numero_residencia"));
                        System.out.println("Bairro: " + cliente.getString("bairro"));
                        System.out.println("CEP: " + cliente.getString("cep"));
                        System.out.println("Cidade: " + cliente.getString("cidade"));
                        System.out.println("----------------------------------------");
                    });

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao listar clientes: " + e.getMessage());
        }
    }

    private static void listarOrdensServico(ConexaoMongoDB conexaoMongoDB) {
        try {
            conexaoMongoDB.getDatabase().getCollection("ordem_servico")
                    .find()
                    .forEach((Document ordemServico) -> {
                        System.out.println("ID: " + ordemServico.getInteger("ordem_servico_id"));
                        System.out.println("Nome do equipamento: " + ordemServico.getString("nome_equipamento"));
                        System.out.println("Fabricante: " + ordemServico.getString("fabricante"));
                        System.out.println("Modelo: " + ordemServico.getString("modelo"));
                        System.out.println("Defeito: " + ordemServico.getString("defeito"));
                        System.out.println("Observação: " + ordemServico.getString("observacao"));
                        System.out.println("ID do Cliente: " + ordemServico.getInteger("cliente_id"));
                        System.out.println("------------------------------");
                    });

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao listar ordens de serviço: " + e.getMessage());
        }
    }

    private static void mostrarQuantidadeOrdensServico(ConexaoMongoDB conexaoMongoDB) {
        try {
            long quantidadeOrdensServico = conexaoMongoDB.getDatabase().getCollection("ordem_servico").countDocuments();
            System.out.println("Quantidade de ordens de serviços cadastradas: " + quantidadeOrdensServico);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao calcular a quantidade de ordens de serviço: " + e.getMessage());
        }
    }
    
    
}

