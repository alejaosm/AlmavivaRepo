
package aplicacionalmaviva;

import controller.ControllerPersonas;
import model.ConsultasPersonas;
import model.Personas;
import view.FrmPersonas;

/**
 *
 * @author Maleja Gosman
 */
public class AplicacionAlmaviva {

   
    public static void main(String[] args) {
        // TODO code application logic here
        
        Personas mod = new Personas();
        ConsultasPersonas modC = new ConsultasPersonas();
        FrmPersonas frm = new FrmPersonas();
        
        ControllerPersonas ctrl = new ControllerPersonas(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);

    }
    
}
