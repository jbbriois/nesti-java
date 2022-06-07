package FilRouge.Controlleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    public static Connection connect() {
        
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/fil_rouge_java", "root", "");
            System.out.println("Connexion réussie !");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e); //connexion échouée
        }
        return conn;
    }
}

    

