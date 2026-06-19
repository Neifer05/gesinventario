import controller.controladorDB;
import controller.controladorMemory;
import view.tui;

public class main {
    public static void main(String[] args) {
        controladorMemory cMemory = new controladorMemory();
        controladorDB c = new controladorDB(cMemory);
        tui t = new tui();
        c.connect();
        t.menuInicioMain();
    }
}