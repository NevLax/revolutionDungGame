package ru.nlx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class DesktopMoveInput implements MoveInput{

    Vector2 vector;

    public DesktopMoveInput(){
        vector = new Vector2();
    }

    @Override
    public Vector2 moveDirect(float speedFactor) {

        if (isUP() & isDOWN()) {
            setX(0f);
        }   else if (isUP()) {
            setX(speedFactor);
        }   else if (isDOWN()) {
            setX(-speedFactor);
        }   else setX(0f);

        if (isRIGHT() & isLEFT()) {
            setY(0f);
        }   else if (isRIGHT()) {
            setY(speedFactor);
        }   else if (isLEFT()) {
            setY(-speedFactor);
        }   else setY(0f);

        return vector;
    }

    private boolean isUP(){
        return Gdx.input.isKeyPressed(Input.Keys.W) |
                Gdx.input.isKeyPressed(Input.Keys.UP);
    }

    private boolean isDOWN(){
        return Gdx.input.isKeyPressed(Input.Keys.S) |
                Gdx.input.isKeyPressed(Input.Keys.DOWN);
    }

    private boolean isRIGHT(){
        return Gdx.input.isKeyPressed(Input.Keys.D) |
                Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }

    private boolean isLEFT(){
        return Gdx.input.isKeyPressed(Input.Keys.A) |
                Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }

    private void setX(float value){
        vector.set(value, vector.y);
    }

    private void setY(float value){
        vector.set(vector.x, value);
    }
}
