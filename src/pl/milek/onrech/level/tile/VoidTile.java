package pl.milek.onrech.level.tile;

import pl.milek.onrech.graphics.Screen;
import pl.milek.onrech.graphics.Sprite;

public class VoidTile extends Tile {
    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<4, y<<4, this);
    }
}
