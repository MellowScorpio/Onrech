package pl.milek.onrech.entity.mob;

import pl.milek.onrech.graphics.Screen;
import pl.milek.onrech.graphics.Sprite;
import pl.milek.onrech.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;


    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public void update() {
        int xa = 0, ya = 0;
        if (anim < 7500) anim++;
        else anim = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0){
            walking = true;
            move(xa, ya);
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        if (dir == 0){
            sprite = Sprite.player_forward;
            if(walking){
                if (anim%20 > 10){
                    sprite = Sprite.player_forward_1;
                } else {
                    sprite = Sprite.player_forward_2;
                }
            }
        }
        if (dir == 1){
            sprite = Sprite.player_right;
            if(walking){
                if (anim%20 > 10){
                    sprite = Sprite.player_right_1;
                } else {
                    sprite = Sprite.player_right_2;
                }
            }
        }
        if (dir == 2){
            sprite = Sprite.player_backward;
            if(walking){
                if (anim%20 > 10){
                    sprite = Sprite.player_backward_1;
                } else {
                    sprite = Sprite.player_backward_2;
                }
            }
        }
        if (dir == 3){
            sprite = Sprite.player_left;
            if(walking){
                if (anim%20 > 10){
                    sprite = Sprite.player_left_1;
                } else {
                    sprite = Sprite.player_left_2;
                }
            }
        }
        screen.renderPlayer(x - 16, y - 16, sprite);//-16 to center player on screen

    }
}
