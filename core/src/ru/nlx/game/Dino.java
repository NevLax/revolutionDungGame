package ru.nlx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Dino {
    MyAnimation wait;
    BodyDef bodyDef;
    Body body;
    CircleShape circle;
    FixtureDef fixtureDef;
    Fixture fixture;

    public Dino(Texture texture, World world){
        wait = new MyAnimation(texture, 24, 24,0.25f);
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(12, 12);

        body = world.createBody(bodyDef);

        circle = new CircleShape();
        circle.setRadius(12f);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;

        fixture = body.createFixture(fixtureDef);
    }

    public void draw(SpriteBatch batch){
        wait.render(batch, body.getPosition());
        body.applyLinearImpulse(Vector2.X, Vector2.Zero, false);
    }

    public void dispose(){
        circle.dispose();
    }
}
