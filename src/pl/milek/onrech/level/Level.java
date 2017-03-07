package pl.milek.onrech.level;

import pl.milek.onrech.graphics.Screen;

public class Level {

    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height){
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    public Level(String path){
        loadLevel(path);
    }

    private void loadLevel(String path) {
        System.out.println("Level loading started.");
    }

    protected void generateLevel() {
        System.out.println("Level generation started.");
    }

    public void update(){
        System.out.println("Level update started.");
    }

    public void render(int xScroll, int yScroll, Screen screen){
        System.out.println("Level render started.");
    }

    private void time(){
        System.out.println("Level time change.");
    }

}
