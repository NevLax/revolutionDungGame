package ru.nlx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.Vector;

public class Dino {
    MyAnimation wait;
    BodyDef bodyDef;
    Body body;
    CircleShape circle;
    FixtureDef fixtureDef;
    Fixture fixture;
    boolean isRIGHT;
    boolean isLEFT;
    boolean isUP;
    boolean isDOWN;
    Vector2 move;
    Vector2 buff;
    Interpolation interpol;
    float koff;

    public Dino(Texture texture, World world){
        wait = new MyAnimation(texture, 24, 24,0.25f);
        move = new Vector2();
        buff = new Vector2();
        koff = 20f;

        interpol = new Interpolation.SwingOut(0.5f);

        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0, 0);

        body = world.createBody(bodyDef);

        circle = new CircleShape();
        circle.setRadius(8f);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 1f;

        fixture = body.createFixture(fixtureDef);
    }

    public void draw(SpriteBatch batch){
        isUP = Gdx.input.isKeyPressed(Input.Keys.W);
        isDOWN = Gdx.input.isKeyPressed(Input.Keys.S);
        isRIGHT = Gdx.input.isKeyPressed(Input.Keys.D);
        isLEFT = Gdx.input.isKeyPressed(Input.Keys.A);

        if (isUP){
            move.set(0f, 1*koff);
        } else if (isDOWN) {
            move.set(0f, -1*koff);
        } else if (isRIGHT) {
            move.set(1*koff, 0f);
        } else if (isLEFT) {
            move.set(-1*koff, 0f);
        }   else {
            move.set(0f, 0f);
        }

//        buff.set(interpol.apply(move));
        buff.set(interpol.apply(buff.x, move.x, Gdx.graphics.getDeltaTime()),
                interpol.apply(buff.y, move.y, Gdx.graphics.getDeltaTime())
        );

        wait.render(batch, body.getPosition());
        body.setLinearVelocity(buff);
    }

    public void dispose(){
        circle.dispose();
    }

}
