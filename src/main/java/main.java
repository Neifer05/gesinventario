import controller.controladorDB;
import view.tui;

public class main {
    public static void main(String[] args) {
        controladorDB c = new controladorDB();
        tui t = new tui();
        t.menuInicioMain();
    }
}