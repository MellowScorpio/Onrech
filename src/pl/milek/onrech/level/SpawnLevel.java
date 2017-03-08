package pl.milek.onrech.level;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        System.out.println("Level loading started.");
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            width = image.getWidth();
            height = image.getHeight();
            tiles = new int[width * height];
            image.getRGB(0, 0, width, height, tiles, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        }
    }

    //converts pixels to tilesInt :)
    //Grass = 0xFF00 Flower = 0xFFFF00 Rock = 0x7F7F00
    protected void generateLevel() {

    }
}
