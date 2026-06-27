package controller;
import models.Cuenta;
import models.Producto;

import java.util.HashMap;
import java.util.Map;

public class controladorMemory {
    private Map<Integer, Cuenta> listadoCuenta = new HashMap<>();
    private Map<Integer, Producto> listadoProducto = new HashMap<>();
    private int lastIDAccount = 0;
    private int lastIDProducto = 0;
    private Cuenta cuentaLogueada = null;

    public void cargarCuentasMemory (int id, String nombre, String apellido, String apellido2, String email, String password, String roleString) {
        Cuenta c = new Cuenta(id, nombre, apellido, apellido2, email, password);

        // Conversion de String al enum del rol.
        c.setRole(models.enums.Role.valueOf(roleString));
        listadoCuenta.put(c.getId(), c);
    }

    public void cargarProductosMemory (int id, String nombreProducto, String descripcion, float precio, int stock, int stockMinimo, int caducable, String tipoproducto) {
        Producto p = new Producto(id, nombreProducto, descripcion, precio, stock, stockMinimo, caducable);

        p.setTipoProducto(models.enums.TipoProducto.valueOf(tipoproducto));
        listadoProducto.put(p.getId(), p);
    }

    public Cuenta crearCuenta (String nombre, String apellido, String apellido2, String email, String password) {
        this.lastIDAccount++;
        Cuenta c = new Cuenta(this.lastIDAccount, nombre, apellido, apellido2, email, password);
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

    public int getLastIDAccount() {
        return lastIDAccount;
    }
    public int getLastIDProducto() {
        return lastIDProducto;
    }
    public Map<Integer, Cuenta> getListadoCuenta() {
        return listadoCuenta;
    }
    public Map<Integer, Producto> getListadoProducto() {
        return listadoProducto;
    }

    public Cuenta getCuentaLogueada() {
        return cuentaLogueada;
    }
    public void setLastIDAccount(int lastIDAccount) {
        this.lastIDAccount = lastIDAccount;
    }
    public void setLastIDProducto(int lastIDProducto) {
        this.lastIDProducto = lastIDProducto;
    }
    public void setCuentaLogueada(Cuenta cuentaLogueada) {
        this.cuentaLogueada = cuentaLogueada;
    }
}
