package muth.andreas.flashcards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    public static Card getCardByID(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/flashcards", "admin", "password");
            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM flashcards WHERE id = " + id);
            statement.getResultSet().next();

            Card flashcard = new Card(statement.getResultSet().getString("question"), statement.getResultSet().getString("answer"), statement.getResultSet().getInt("id"));

            statement.close();
            connection.close();

            return flashcard;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addCard(String question, String answer) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/flashcards", "admin", "password");
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO flashcards (question, answer) VALUES ('" + question + "', '" + answer + "')");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getCardCount() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/flashcards", "admin", "password");
            Statement statement = connection.createStatement();

            statement.execute("SELECT COUNT(*) FROM flashcards");
            statement.getResultSet().next();

            int count = statement.getResultSet().getInt(1);

            statement.close();
            connection.close();

            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
