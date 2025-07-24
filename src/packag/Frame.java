package packag;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame {
    Game game = new Game();
   public  Frame(){

        this.add(game.gamePanel);
        this.add(game.infosGame);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
