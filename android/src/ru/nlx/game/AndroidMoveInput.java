package ru.nlx.game;

import com.badlogic.gdx.math.Vector2;

public class AndroidMoveInput implements MoveInput{

    @Override
    public Vector2 moveDirect(float speedFactor) {
        return Vector2.Zero;
    }
}
