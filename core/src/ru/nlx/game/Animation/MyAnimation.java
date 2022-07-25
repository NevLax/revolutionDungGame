package ru.nlx.game.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ru.nlx.game.Animation.FrameInterval;

public class MyAnimation {

    Animation<TextureRegion> anim;  //LibGDX реализация анимации
    TextureRegion[] Frames;         //нарезка кадров из текстуры
    TextureRegion currentFrame;     //текущий кадр отрисовки

    float timeAnimation;    //продолжительность анимации
    float timeStep;         //шаг анимации


    //конструктор моей анимации, параметры:
    //текстура, время кадра, ширина кадра, высота, с какого по какой кадр из текстуры(атласа)
    public MyAnimation(Texture image, float speed, int w, int h, FrameInterval interval) {
        timeStep = speed;                                       //установка скорости
        Frames = new TextureRegion[interval.getAmountFrames()]; //разметка массива кадров
        currentFrame = new TextureRegion();                     //текущий кадр анимации

        int index = 0;                                                          //индекс заполения массива(массив начинается с нуля)
        for (int step = interval.getFrom(); step < interval.getTo(); step++){   //цикл, щагающий по кадрам в атласе
            Frames[index] = new TextureRegion(image, w*step, 0, w, h);    //занесения кадра в массив
            index++;                                                            //переход на следующий элемент массива
        }

        anim = new Animation<TextureRegion>(timeStep, Frames);                  //создаем анимацию LibGDX
    }


    public void render(SpriteBatch batch, Vector2 vector) {                             //вызывается каждый кадр
        timeAnimation += Gdx.graphics.getDeltaTime();                                   //фиксируем шаг времени
        currentFrame = anim.getKeyFrame(timeAnimation, true);                   //находим текущий кадр по продолжительсти

        batch.draw(currentFrame, vector.x-12, vector.y-12, 24, 24); //рисуем по положению физ.тела
    }

    public void timeToZero(){
        timeAnimation = 0;
    }
}