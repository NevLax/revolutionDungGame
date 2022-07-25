package ru.nlx.game.Dino;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class DinoFisics {


    BodyDef bodyDef;
    Body body;
    CircleShape circle;
    FixtureDef fixtureDef;
    Fixture fixture;

    public DinoFisics (World world, float posX, float posY, float radius){
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(posX, posY);

        body = world.createBody(bodyDef);

        circle = new CircleShape();
        circle.setRadius(radius);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 1f;

        fixture = body.createFixture(fixtureDef);
    }

    public Vector2 getPosition(){
        return body.getPosition();
    }

    public void setVelocity(Vector2 value){
        body.setLinearVelocity(value);
    }

    public void dispose(){
        circle.dispose();
    }
}
