package lib.JavaFirstStart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static GameWindow gw;
    private static Image bg;
    private static Image go;
    private static Image d;
    private static long last_frame_time;
    private static float drop_left = 200;
    private static float drop_top = -100;
    private static float drop_v = 200;
    private static int score = 0;


    public static void start() throws IOException {
        bg = ImageIO.read(GameWindow.class.getResourceAsStream("lib/GameWindowRe/drop.png"));
        go = ImageIO.read(GameWindow.class.getResourceAsStream("lib/GameWindowRe/game_over.png"));
        d= ImageIO.read(GameWindow.class.getResourceAsStream("lib/GameWindowRe/drop.png"));
        gw = new GameWindow();
        gw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gw.setLocation(200,100);
        gw.setSize(906,468);
        gw.setResizable(false);
        last_frame_time = System.nanoTime();

        GameField gf = new GameField();
        gf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_right = drop_left + d.getWidth(null);
                float drop_bottom = drop_top + d.getHeight(null);
                boolean is_drop = x >= drop_left && x <= drop_right && y >= drop_top && y <= drop_bottom;
                if(is_drop) {
                    drop_top = -100;
                    drop_left = (int) (Math.random() * gf.getWidth() - d.getWidth(null));
                    drop_v = drop_v + 20;
                    score++;
                    gw.setTitle("Score: " + score);
                }
            }
        });
        gw.add(gf);
        gw.setVisible(true);
    }
    private static void onRepaint (Graphics g) {
        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;
        drop_top = drop_top + drop_v * delta_time;
        g.drawImage(bg, 0, 0, null);
        g.drawImage(d,(int) drop_left,(int) drop_top,null);
        if (drop_top > gw.getHeight()) g.drawImage(go, 280, 120, null);
    }

    private static class GameField extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }

}
