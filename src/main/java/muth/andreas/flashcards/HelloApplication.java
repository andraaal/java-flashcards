package muth.andreas.flashcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void getDB() {
        try {
            Connection connection = DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_User"), System.getenv("DB_PASSWORD"));
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS flashcards (id INT PRIMARY KEY AUTO_INCREMENT, question VARCHAR(255), answer VARCHAR(255))");

            statement.execute("SELECT * FROM flashcards");
            statement.getResultSet().next();

            String question = statement.getResultSet().getString("question");
            System.out.println("next: " + question);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}