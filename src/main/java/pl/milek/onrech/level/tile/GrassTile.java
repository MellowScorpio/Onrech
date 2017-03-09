package pl.milek.onrech.level.tile;

import pl.milek.onrech.graphics.Screen;
import pl.milek.onrech.graphics.Sprite;

public class GrassTile extends Tile {

    public static final String NAME = "Grass";

    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

    public String getName() {
        return NAME;
    }
}
