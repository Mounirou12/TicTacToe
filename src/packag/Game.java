package packag;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Game implements ActionListener {



    JLabel infosGame;
    JPanel gamePanel;
    Button[] gameButton = new Button[9];
    boolean player = true;
    ImageIcon oIcon = new ImageIcon(getClass().getResource("/packag/Image/O.jpeg"));
    ImageIcon xIcon = new ImageIcon(getClass().getResource("/packag/Image/X.png"));

    public Game() {
        infosGame = new JLabel("ghdjhf");
        infosGame.setBounds(0, 0, 600, 112);
        infosGame.setBackground(Color.BLACK);
        infosGame.setForeground(Color.green);
        infosGame.setBackground(Color.black);
        infosGame.setHorizontalTextPosition(SwingConstants.RIGHT);
        infosGame.setOpaque(true);

        gamePanel = new JPanel();
        gamePanel.setBounds(0, 112, 600, 450);
        gamePanel.setLayout(new GridLayout(3, 3, 0, 0));

        for (int i = 0; i < gameButton.length; i++) {
            gameButton[i] = new Button();
        }
        for (Button button : gameButton) {
            button.addActionListener(this::actionPerformed);
            gamePanel.add(button);
        }
    }

    private void  resetGame(){
        for (Button button : gameButton) {
            button.setEnabled(true);
            button.setText("");
        }
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < gameButton.length; i++) {
            if (e.getSource() == gameButton[i]) {
                gameButton[i].setText(player? "o":"x");
                gameButton[i].setEnabled(false);
                infosGame.setText(player?"O joue" : "X joue");
                if (checkWin()) {
                    JOptionPane.showMessageDialog(null, "Joueur" +(player?" O ":" X ") +"gagne!");
                    resetGame();
                } 
                else if (isDrawn()) {
                    JOptionPane.showMessageDialog(null, "Match nul");
                    resetGame();
                }else {
                    player = !player;
                }
                break;
            }
        }
    }

    private boolean checkWin() {
        return checkLine(0, 1, 2) || checkLine(3, 4, 5) || checkLine(6, 7, 8)
                || checkLine(0, 3, 6) || checkLine(1, 4, 7) || checkLine(2, 5, 8)
                || checkLine(0, 4, 8) || checkLine(2, 4, 6);
    }

    private boolean checkLine(int a, int b, int c) {
        return !gameButton[a].getText().isEmpty()
                && gameButton[a].getText().equals(gameButton[b].getText())
                && gameButton[a].getText().equals(gameButton[c].getText());
    }

    private boolean isDrawn() {
        for (Button button : gameButton) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
