import javax.swing.*;
import java.awt.*;

public class GameScree extends JFrame {


    public GameScree(String title) throws HeadlessException {
        super(title);
    }


    public static void main(String[] args) {
        GameScree screen=new GameScree("SNAKE GAME");



        screen.setResizable(false);

        screen.setFocusable(false);

        // 800 600

        //900 900

        screen.setSize(900,900);

        Game s=new Game();

        s.requestFocus();

        s.addKeyListener(s);

        s.setFocusable(true);


        s.setFocusTraversalKeysEnabled(true);


        screen.add(s);


        screen.setVisible(true);

        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);








    }


}
