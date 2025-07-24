package packag;

import java.awt.Dimension;
import javax.swing.JButton;

public class Button extends  JButton {

    Button(){
        this.setSize(new Dimension(200,150));
        this.setFocusable(false);
    }

}
