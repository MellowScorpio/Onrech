package pl.milek.onrech.graphics;

public class Sprite {

    private static int TILE_SIZE = 16;
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(TILE_SIZE, 0, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(TILE_SIZE, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(TILE_SIZE, 2, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(TILE_SIZE, 0x1B87E0);

    public static Sprite player_forward = new Sprite(TILE_SIZE*2, 0, 0, SpriteSheet.characters);
    public static Sprite player_forward_1 = new Sprite(TILE_SIZE*2,1,0,SpriteSheet.characters);
    public static Sprite player_forward_2 = new Sprite(TILE_SIZE*2,2,0,SpriteSheet.characters);

    public static Sprite player_backward = new Sprite(TILE_SIZE*2, 0, 3, SpriteSheet.characters);
    public static Sprite player_backward_1 = new Sprite(TILE_SIZE*2,1,3,SpriteSheet.characters);
    public static Sprite player_backward_2 = new Sprite(TILE_SIZE*2,2,3,SpriteSheet.characters);

    public static Sprite player_left = new Sprite(TILE_SIZE*2, 0, 1, SpriteSheet.characters);
    public static Sprite player_left_1 = new Sprite(TILE_SIZE*2,1,1,SpriteSheet.characters);
    public static Sprite player_left_2 = new Sprite(TILE_SIZE*2,2,1,SpriteSheet.characters);

    public static Sprite player_right = new Sprite(TILE_SIZE*2, 0, 2, SpriteSheet.characters);
    public static Sprite player_right_1 = new Sprite(TILE_SIZE*2,1,2,SpriteSheet.characters);
    public static Sprite player_right_2 = new Sprite(TILE_SIZE*2,2,2,SpriteSheet.characters);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int colour) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }

    private void setColour(int colour) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            pixels[i] = colour;
        }
    }


    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
