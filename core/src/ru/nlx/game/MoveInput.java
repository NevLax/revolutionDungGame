package ru.nlx.game;

import com.badlogic.gdx.math.Vector2;

public interface MoveInput {
    Vector2 moveDirect(float speedFactor);
}
