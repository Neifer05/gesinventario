import controller.controladorDB;
import controller.controladorMemory;
import exceptions.InvalidAccountException;
import models.Cuenta;
import models.enums.Role;
import view.tui;

public class main {
    public static void main(String[] args) {
        controladorMemory cMemory = new controladorMemory();
        controladorDB c = new controladorDB(cMemory);
        tui t = new tui();
        c.connect();
        c.cargarCuentasDB();

        while (cMemory.getCuentaLogueada() == null) {
            int seleccion = t.formularioIngresoCabecera();
            switch (seleccion) {
                case 1: {
                    try {
                        String []datosIngreso = t.formularioIngreso();
                        cMemory.setCuentaLogueada(cMemory.iniciarSesion(datosIngreso[0], datosIngreso[1]));
                        if (cMemory.getCuentaLogueada() == null) {
                            throw new InvalidAccountException("Los datos de inicio de sesión no son correctos o la cuenta no existe.");
                        }
                        break;
                    } catch (InvalidAccountException e) {
                        t.mensajeErrorExcepcion(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    String []datosRegistro = t.datosFormulario();
                    c.crearCuenta(datosRegistro[0], datosRegistro[1], datosRegistro[2], datosRegistro[3], datosRegistro[4]);
                    break;
                }
            }
        }

        bucle_principal:
        while (true) {
            int opcionPrincipal = t.menuInicioMain(cMemory.getCuentaLogueada().getRole());
            switch (opcionPrincipal) {
                case 1:
                    break;
                case 2:
                    gestionarFlujoInventario(t);
                    break;
                case 3:
                    if (cMemory.getCuentaLogueada().getRole() == Role.ADMIN) {
                        System.out.println("Abriendo panel de administrador.");
                    }
                    break;
                case 4:
                    t.salirAgendaMenuPrincipal();
                    break bucle_principal;
                default:
                    t.opcionNoValida();
                    break;
            }
        }
    }
    private static void gestionarFlujoInventario (tui t) {
        while (true) {
            int opcionInventario = t.subMenuGesInventarioMain();

            switch (opcionInventario) {
                case 1:
                    int opcionAnadir = t.subMenuGesInvAñadir();
                    switch (opcionAnadir) {
                        case 1 -> System.out.println("Añadiendo nuevo producto...");
                        case 2 -> System.out.println("Añadiendo producto en venta...");
                        case 3 -> {} // Evitar que caiga en default.
                    }
                    break;
                case 2:
                    int opcionVer = t.subMenuGesVerExistencia();
                    switch (opcionVer) {
                        case 1 -> System.out.println("Mostrando todos los productos...");
                        case 2 -> System.out.println("Mostrando productos en venta...");
                        case 3 -> {}
                    }
                    break;
                case 9: {
                    System.out.println("Volviendo al menu principal."); //TODO: Cambiar para que la tui lo gestione.
                    return;
                }
                default:
                    t.opcionNoValida();
                    break;
            }
        }
    }
}