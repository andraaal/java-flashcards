module muth.andreas.flashcards {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mariadb.jdbc;


    opens muth.andreas.flashcards to javafx.fxml;
    exports muth.andreas.flashcards;
}