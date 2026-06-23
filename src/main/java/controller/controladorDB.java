package controller;

import models.Cuenta;

import java.sql.*;
public class controladorDB {
    private controladorMemory cMemory;
    private Connection conn;
    private final String url = "jdbc:sqlite:src/main/resources/database.db";

    public controladorDB(controladorMemory cMemory) {
        this.cMemory = cMemory;
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(url);
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
        String sqlProductos = """
                CREATE TABLE IF NOT EXISTS productos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombreProducto TEXT NOT NULL,
                    descripcion TEXT NOT NULL,
                    precio REAL NOT NULL,
                    stock INTEGER NOT NULL,
                    stockMinimo INTEGER NOT NULL,
                    caducable INTEGER NOT NULL CHECK (caducable IN (0, 1)),
                    tipoproducto TEXT NOT NULL CHECK(tipoproducto IN ('TECNOLOGIA', 'HERRAMIENTA', 'MUEBLE', 'UTENSILIO', 'PERSONAL'))
                );
                """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlProductos);
            System.out.println("Tablas verificadas.");
        }
    }

    private void obtenerUltimoID (Connection conn) throws SQLException {
        String queryCount = "SELECT count(*) from usuarios";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryCount)) {
            if (rs.next()) {
                cMemory.setLastID(rs.getInt(1));
            }
        }
    }

    public void cargarCuentasDB () {
        String sqlSelect = "SELECT * FROM usuarios";
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");;
                String apellido = rs.getString("apellido");;
                String apellido2 = rs.getString("apellido2");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String roleString = rs.getString("role");
                cMemory.cargarCuentasMemory(id, nombre, apellido, apellido2, email, password, roleString);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // NOTE: Funciones de usuarios.
    public void crearCuenta (String nombre, String apellido, String apellido2, String email, String password) {
        String sqlInsert = "INSERT INTO usuarios (nombre, apellido, apellido2, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        Cuenta c = cMemory.crearCuenta(nombre, apellido, apellido2, email, password);

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
