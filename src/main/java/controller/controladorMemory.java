package controller;
import models.Cuenta;
import java.util.HashMap;
import java.util.Map;

public class controladorMemory {
    private Map<Integer, Cuenta> listadoCuenta = new HashMap<>();
    private int lastID = 0;

    public Cuenta crearCuenta (String nombre, String apellido, String apellido2, String email, String password) {
        this.lastID++;
        Cuenta c = new Cuenta(this.lastID, nombre, apellido, apellido2, email, password);
        listadoCuenta.put(c.getId(), c);
        return c;
    }

    public int getLastID() {
        return lastID;
    }
    public void setLastID(int lastID) {
        this.lastID = lastID;
    }
}
