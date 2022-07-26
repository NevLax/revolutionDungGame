package ru.nlx.game.Dino;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import ru.nlx.game.Animation.*;

public class Dino {
    MyAnimation wait;
    MyAnimation walk;
    FrameInterval intervalWait;
    FrameInterval intervalWalk;
    float koff;
    float animSpeed;
    int frameResolution;
    boolean isWalking;
    DinoController control;
    DinoFisics body;

    public Dino(Texture texture, World world){
        isWalking = false;
        animSpeed = 0.1f;
        frameResolution = 24;
        intervalWait = new FrameInterval(1, 4);
        intervalWalk = new FrameInterval(5, 10);
        wait = new MyAnimation(texture, animSpeed, frameResolution, frameResolution, intervalWait);
        walk = new MyAnimation(texture, animSpeed, frameResolution, frameResolution, intervalWalk);
        koff = 50f;
        control = new DinoController();

        body = new DinoFisics(world, 0f, 0f, new Vector2(8f, 8f));
    }

    public void draw(SpriteBatch batch){
        body.setVelocity(control.control(koff));

        if (control.isWalk()){
            if (isWalking){
                isWalking = !isWalking;
                walk.timeToZero();
            }
            walk.render(batch, body.getPosition(), frameResolution, control.walkToLeft());
        }   else {
            if (!isWalking){
                isWalking = !isWalking;
                wait.timeToZero();
            }
            wait.render(batch, body.getPosition(), frameResolution, control.walkToLeft());
        }
    }

    public void dispose(){
        body.dispose();
    }

}
