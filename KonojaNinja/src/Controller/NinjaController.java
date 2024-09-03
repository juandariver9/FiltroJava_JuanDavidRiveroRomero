

package Controller;
import View.NinjaView;


public class NinjaController {
    private NinjaView ninjaView;
    
    public NinjaController() {
        ninjaView = new NinjaView();
    }
    public void start() {
        ninjaView.displayMenu();
    }
}
