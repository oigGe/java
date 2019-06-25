package georggross;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    public Window(int width, int height,String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimenssion(width,height));
        frame.setMaximumSize(new Dimenssion(width,height));
        frame.setMinimumSize(new Dimenssion(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.app(game);
        frame.setVisible(true);
        game.start():
    }
}
