package ru.nlx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

public class Dino {
    MyAnimation wait;
    BodyDef bodyDef;
    Body body;
    CircleShape circle;
    FixtureDef fixtureDef;
    Fixture fixture;
    float koff;
    DinoController control;

    public Dino(Texture texture, World world){
        wait = new MyAnimation(texture, 24, 24,0.25f);
        koff = 50f;
        control = new DinoController();

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
        wait.render(batch, body.getPosition());
        body.setLinearVelocity(control.control(koff));
    }

    public void dispose(){
        circle.dispose();
    }

}
