package pl.milek.onrech;

public class Game implements Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final int SCALE = 3;

    private Thread thread;

    public synchronized void start(){
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

    }
}
