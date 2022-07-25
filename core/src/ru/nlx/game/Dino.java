package ru.nlx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

public class Dino {
    MyAnimation wait;
    FrameInterval intervalWait;
    float koff;
    DinoController control;
    DinoFisics body;

    public Dino(Texture texture, World world){
        intervalWait = new FrameInterval(1, 4);
        wait = new MyAnimation(texture, 0.25f, 24, 24, intervalWait);
        koff = 50f;
        control = new DinoController();

        body = new DinoFisics(world, 0f, 0f, 8f);
    }

    public void draw(SpriteBatch batch){
        wait.render(batch, body.getPosition());
        body.setVelocity(control.control(koff));
    }

    public void dispose(){
        body.dispose();
    }

}
