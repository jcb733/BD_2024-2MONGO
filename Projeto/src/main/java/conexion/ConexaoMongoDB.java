/*package conexion;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

public class ConexaoMongoDB {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public ConexaoMongoDB() {
        conectar();
    }

    private void conectar() {
        try {
            
            String username = "labdatabase";
            String password = "labDatabase2022";
            String databaseName = "CRUDMONGO"; 

            
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyToClusterSettings(builder ->
                            builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
                    .credential(MongoCredential.createCredential(username, databaseName, password.toCharArray()))
                    .build();

            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase(databaseName);

            System.out.println("Conexão bem-sucedida com o banco de dados MongoDB.");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                System.out.println("Conexão com o banco de dados MongoDB fechada.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados MongoDB: " + e.getMessage());
            e.printStackTrace();
        }
    }
}*/

package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMongoDB {

    private static final Logger logger = Logger.getLogger(ConexaoMongoDB.class.getName());

    private MongoClient mongoClient;
    private MongoDatabase database;

    public ConexaoMongoDB() {
        configurarLoggerMongoDB();
        conectar();
    }

    private void configurarLoggerMongoDB() {
        // Configurar o nível de log para SEVERE (somente mensagens de erro)
        logger.setLevel(Level.SEVERE);

        // Remover qualquer manipulador de console existente
        for (java.util.logging.Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }

        // Adicionar um novo manipulador de console com o nível de log desejado
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(consoleHandler);
    }

    private void conectar() {
        try {
            // URI de conexão MongoDB
            String uri = "mongodb://labdatabase:labDatabase2022@localhost:27017/?authSource=admin";

            // Configurações do cliente MongoDB
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(uri))
                    .build();

            mongoClient = MongoClients.create(settings);
            database = mongoClient.getDatabase("CRUDMONGO");

            System.out.println("Conexão bem-sucedida com o banco de dados MongoDB.");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados MongoDB: " + e.getMessage());
            logger.log(Level.SEVERE, "Erro ao conectar ao banco de dados MongoDB", e);
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                System.out.println("Conexão com o banco de dados MongoDB fechada.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados MongoDB: " + e.getMessage());
            logger.log(Level.SEVERE, "Erro ao fechar a conexão com o banco de dados MongoDB", e);
            e.printStackTrace();
        }
    }
}
