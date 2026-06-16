import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorDB {
    private final String url = "jdbc:sqlite:src/main/resources/database.db";

    void connect() {

        try (var conn = DriverManager.getConnection(url)){
            System.out.println("Conexión establecida.");
            crearTablas(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void crearTablas(Connection conn) {
        String sqlUsuarios = """
                CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL
                );
                """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUsuarios);
            System.out.println("Tabla verificada.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
