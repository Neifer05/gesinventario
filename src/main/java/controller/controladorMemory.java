package controller;
import models.Cuenta;
import java.util.HashMap;
import java.util.Map;

public class controladorMemory {
    private Map<Integer, Cuenta> listadoCuenta = new HashMap<>();
    private int lastID = 0;
    private Cuenta cuentaLogueada = null;

    public void cargarCuentasMemory (int id, String nombre, String apellido, String apellido2, String email, String password, String roleString) {
        Cuenta c = new Cuenta(id, nombre, apellido, apellido2, email, password);

        // Conversion de String al enum del rol.
        c.setRole(models.enums.Role.valueOf(roleString));
        listadoCuenta.put(c.getId(), c);
    }

    public Cuenta crearCuenta (String nombre, String apellido, String apellido2, String email, String password) {
        this.lastID++;
        Cuenta c = new Cuenta(this.lastID, nombre, apellido, apellido2, email, password);
        listadoCuenta.put(c.getId(), c);
        return c;
    }

    public Cuenta iniciarSesion (String email, String password) {
        for (Cuenta c : listadoCuenta.values()) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    }

    public int getLastID() {
        return lastID;
    }
    public Map<Integer, Cuenta> getListadoCuenta() {
        return listadoCuenta;
    }
    public Cuenta getCuentaLogueada() {
        return cuentaLogueada;
    }
    public void setLastID(int lastID) {
        this.lastID = lastID;
    }
    public void setCuentaLogueada(Cuenta cuentaLogueada) {
        this.cuentaLogueada = cuentaLogueada;
    }
}
