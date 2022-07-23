package ru.nlx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MyAnimation {

    float timeAnimation;    //счетчик анимации
    TextureRegion wait0;    //ууудивительный массив текстуры
    TextureRegion wait1;    //ууудивительный массив текстуры
    TextureRegion wait2;    //ууудивительный массив текстуры
    TextureRegion wait3;    //ууудивительный массив текстуры
    float timeStep;         //шаг анимации

    public MyAnimation(Texture image, int w, int h, float speed) {

        timeStep = speed;   //просто заносим шаг анимации

        //заполнение удивительного массива
        wait0 = new TextureRegion(image, 0, 0, w, h);
        wait1 = new TextureRegion(image, 24, 0, w, h);
        wait2 = new TextureRegion(image, 48, 0, w, h);
        wait3 = new TextureRegion(image, 72, 0, w, h);
    }


    public void render(SpriteBatch batch, Vector2 vector) {

        //счетчик времени, складываем в счетчик время затраченное на предыдущий кадр
        timeAnimation += Gdx.graphics.getDeltaTime();

        //если больше 4 кадров, то снимаем четыре шага
        if (timeAnimation > timeStep * 4){
            timeAnimation -= timeStep * 4;
        }

        //удивительный метоод рисования анимации
        if(timeAnimation < timeStep){
            batch.draw(wait0, vector.x-12, vector.y-12);
        } else if (timeAnimation < timeStep * 2) {
            batch.draw(wait1, vector.x-12, vector.y-12);
        } else if (timeAnimation < timeStep * 3) {
            batch.draw(wait2, vector.x-12, vector.y-12);
        } else {
            batch.draw(wait3, vector.x-12, vector.y-12);
        }
    }
}
