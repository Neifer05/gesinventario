package controller;

import models.Cuenta;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class controladorDB {
    private Map<Integer, Cuenta>listadoCuenta = new HashMap<>();
    private final String url = "jdbc:sqlite:src/main/resources/database.db";
    private final String queryCount = "SELECT count(*) from usuarios";
    private Connection conn;
    private int lastID = 0;


    public controladorDB() {
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(url)
            System.out.println("Conexión establecida.");
            crearTablas(conn);
            obtenerUltimoID(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void crearTablas(Connection conn) throws SQLException {
        String sqlUsuarios = """
                CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                apellido TEXT NOT NULL,
                apellido2 TEXT NOT NULL,
                email TEXT NOT NULL,
                password TEXT NOT NULL,
                role TEXT NOT NULL CHECK(role IN ('ADMIN', 'EMPLEADO'))
                );
                """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUsuarios);
            System.out.println("Tabla verificada.");
        }
    }

    private void obtenerUltimoID (Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryCount)) {
            if (rs.next()) {
                lastID = rs.getInt(1);
            }
        }
    }

    public int getLastID() {
        return lastID;
    }

    // NOTE: Funciones de usuarios.
    public void crearCuenta (String nombre, String apellido, String apellido2, String email, String password) {
        String sqlInsert = "INSERT INTO usuarios (nombre, apellido, apellido2, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        Cuenta c = new Cuenta(lastID + 1, nombre, apellido, apellido2, email, password);
        listadoCuenta.put(c.getId(), c);

        try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getApellido());
            pstmt.setString(3, c.getApellido2());
            pstmt.setString(4, c.getEmail());
            pstmt.setString(5, c.getPassword());
            pstmt.setString(6, c.getRole().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
