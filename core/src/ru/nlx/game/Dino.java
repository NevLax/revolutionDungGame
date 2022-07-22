package ru.nlx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dino {
    MyAnimation wait;

    public Dino(Texture texture){
        wait = new MyAnimation(texture, 24, 24,0.25f);
    }

    public void draw(SpriteBatch batch){
        wait.render(batch);
    }
}
