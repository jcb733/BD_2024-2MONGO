package utils;

import conexion.ConexaoMongoDB;

public class SplashScreen {
    public static void showSplashScreen() {
        
        ConexaoMongoDB conexaoMongoDB = new ConexaoMongoDB();

    	long qtdeClientes = conexaoMongoDB.getDatabase().getCollection("cliente").countDocuments();
    	long qtdeOrdensServico = conexaoMongoDB.getDatabase().getCollection("ordem_servico").countDocuments();
    	
        System.out.println("------------------------------------------------");
        System.out.println("#    SISTEMA DE GESTÃO   DE ORDEM DE SERVIÇO   #");
        System.out.println("#                                              #");
        System.out.println("#  REGISTROS:                                  #");
        System.out.println("#  CLIENTE: " + qtdeClientes + "               #");
        System.out.println("#  ORDENS DE SERVIÇO: "+ qtdeOrdensServico + " #");
        System.out.println("#                                              #");
        System.out.println("#  DESENVOLVIDO POR:                           #");
        System.out.println("#  JULIO SEPULCRI                              #");
        System.out.println("#  ISAAC					                   #");
        System.out.println("#                                              #");
        System.out.println("#  DISCIPLINA: BANCO DE DADOS                  #");
        System.out.println("#  2024/2                                      #");
        System.out.println("#                                              #");
        System.out.println("#  PROFESSOR: HOWARD ROATTI                    #");
        System.out.println("------------------------------------------------");
    }
}
