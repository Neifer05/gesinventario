package models;
import models.enums.Role;
import jakarta.persistence.*;


@Entity
@Table(name = "Cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String apellido2;
    private Role role;

    /* Constructor vacio para JPA */
    public Cuenta() {
    }

    public Cuenta(String nombre, String apellido, String apellido2) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.role = Role.EMPLEADO;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido2;
    }
    public String getApellido2() {
        return apellido;
    }
    public Role getRole() {
        return role;
    }
}