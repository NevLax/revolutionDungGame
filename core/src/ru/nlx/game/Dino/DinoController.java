package ru.nlx.game.Dino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;

public class DinoController {

    float timeKoff;
    float walkKof;
    Vector2 vector;
    Vector2 buff;
    Interpolation interpol;

    public DinoController(){
        timeKoff = 1f;
        walkKof = 120f;
        vector = new Vector2();
        buff = new Vector2();
        interpol = new Interpolation.SwingOut(0.2f);
    }

    public Vector2 control(float koff){

        if (isUP() & isDOWN()) {
            setX(0f);
        }   else if (isUP()) {
            setX(koff);
        }   else if (isDOWN()) {
            setX(-koff);
        }   else setX(0f);

        if (isRIGHT() & isLEFT()) {
            setY(0f);
        }   else if (isRIGHT()) {
            setY(koff);
        }   else if (isLEFT()) {
            setY(-koff);
        }   else setY(0f);

        buff.set(interpol.apply(buff.x, vector.x, Gdx.graphics.getDeltaTime()*timeKoff),
                interpol.apply(buff.y, vector.y, Gdx.graphics.getDeltaTime()*timeKoff));

        return invert();
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

    private Vector2 invert(){
        return new Vector2(buff.y, buff.x);
    }

    public boolean isWalk(){
        return ((buff.y * buff.y) + (buff.x * buff.x)) > walkKof;
    }
}
