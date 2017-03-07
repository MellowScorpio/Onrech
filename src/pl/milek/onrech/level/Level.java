package pl.milek.onrech.level;

import pl.milek.onrech.graphics.Screen;
import pl.milek.onrech.level.tile.Tile;

public class Level {

    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
    }

    private void loadLevel(String path) {
        System.out.println("Level loading started.");
    }

    protected void generateLevel() {
        System.out.println("Level generation started.");
    }

    public void update() {
        System.out.println("Level update started.");
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        //xScroll / yScroll - actuall position of the player
        screen.setOffset(xScroll, yScroll);
        // define render region of the screen from top left to bottom right corner = corner pins method
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;
        //rendering between the corner pins
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == 0) return Tile.grass;
        return Tile.voidTile;
    }

    private void time() {
        System.out.println("Level time change.");
    }

}
