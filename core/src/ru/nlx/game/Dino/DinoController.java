package ru.nlx.game.Dino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import ru.nlx.game.MoveInput;

public class DinoController {

    float timeKoff;
    float walkKof;
    Vector2 vector;
    Vector2 buff;
    Interpolation interpol;
    final MoveInput moveInput;

    public DinoController(MoveInput moveInput){
        timeKoff = 1f;
        walkKof = 120f;
        vector = new Vector2();
        buff = new Vector2();
        interpol = new Interpolation.SwingOut(0.2f);
        this.moveInput = moveInput;
    }

    public Vector2 control(float koff){
        vector.set(moveInput.moveDirect(koff));

        buff.set(interpol.apply(buff.x, vector.x, Gdx.graphics.getDeltaTime()*timeKoff),
                interpol.apply(buff.y, vector.y, Gdx.graphics.getDeltaTime()*timeKoff));

        return invert();
    }

    private Vector2 invert(){
        return new Vector2(buff.y, buff.x);
    }

    public boolean isWalk(){
        return ((buff.y * buff.y) + (buff.x * buff.x)) > walkKof;
    }

    public boolean walkToLeft(){
        return invert().x < 0f;
    }
}
