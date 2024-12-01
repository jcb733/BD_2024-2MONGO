package conexion;

import controller.MenuPrincipal;
import utils.SplashScreen;

public class Main {
    public static void main(String[] args) {
        ConexaoMongoDB conexao = new ConexaoMongoDB();

        if (conexao.getDatabase() != null) {
            SplashScreen.showSplashScreen();
            MenuPrincipal.menuPrincipal();
            conexao.close();
        } else {
            System.out.println("Falha na conexão com o banco de dados MongoDB.");
        }
    }
}

