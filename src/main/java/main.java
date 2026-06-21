import controller.controladorDB;
import controller.controladorMemory;
import view.tui;

public class main {
    public static void main(String[] args) {
        controladorMemory cMemory = new controladorMemory();
        controladorDB c = new controladorDB(cMemory);
        tui t = new tui();
        c.connect();

        bucle_principal:
        while (true) {
            int opcion = t.menuInicioMain();
            switch (opcion) {
                case 1:
                    String[] datos = t.datosFormulario();
                    c.crearCuenta(datos[0], datos[1], datos[2], datos[3], datos[4]);
                    break;
                case 2:
                    t.salirAgendaMenuPrincipal();
                    break bucle_principal;
            }
        }
    }
}