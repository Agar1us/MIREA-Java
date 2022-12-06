package Exercise3;

public class MVCPatternDemo {
    public static void main(String [] args){
        StarShip m = new StarShip();
        StarShipView v = new StarShipView();
        StarShipController c = new StarShipController(m, v);
        c.initController();
    }
}
