package pl.milek.onrech;

import pl.milek.onrech.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    private static final String TITLE = "OnReach";
    private static final int WIDTH = 300;
    private static final int HEIGHT = WIDTH / 16 * 9;
    private static final int SCALE = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    // executed once when we create object
    public Game() {
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);

        frame = new JFrame();
        screen = new Screen(WIDTH, HEIGHT);
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start(); // runs the run() method
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // because game implements runnable - when we start the thread
    // it calls the run method
    public void run() {
        while (running) {
            update();
            render();
        }
    }

    private void update() {

    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render();

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();

    }

    //this is the Genesis! runned when program starts
    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(TITLE);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
