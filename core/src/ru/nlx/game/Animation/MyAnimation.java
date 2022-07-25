package ru.nlx.game.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MyAnimation {
    private final Animation<TextureRegion> anim;  //LibGDX реализация анимации
    private TextureRegion currentFrame;     //текущий кадр отрисовки
    private float timeAnimation;            //продолжительность анимации

    //конструктор моей анимации, параметры:
    //текстура, время кадра, ширина кадра, высота, с какого по какой кадр из текстуры(атласа)
    public MyAnimation(Texture image, float speed, int w, int h, FrameInterval interval) {
        TextureRegion[] frames = new TextureRegion[interval.getAmountFrames()]; //нарезка из текстуры
        currentFrame = new TextureRegion();                                     //текущий кадр анимации

        int index = 0;                                                          //индекс заполения массива(массив начинается с нуля)
        for (int step = interval.getFrom(); step < interval.getTo(); step++){   //цикл, щагающий по кадрам в атласе
            frames[index] = new TextureRegion(image, w*step, 0, w, h);    //занесения кадра в массив
            index++;                                                            //переход на следующий элемент массива
        }

        anim = new Animation<TextureRegion>(speed, frames);                  //создаем анимацию LibGDX
    }


    public void render(SpriteBatch batch, Vector2 vector, int frameResolution, boolean reflected) {                             //вызывается каждый кадр
        timeAnimation += Gdx.graphics.getDeltaTime();                                   //фиксируем шаг времени
        currentFrame = anim.getKeyFrame(timeAnimation, true);                   //находим текущий кадр по продолжительсти

        if (reflected) drawReflected(batch, vector, frameResolution);                   //рисуем отраженно
        else draw(batch, vector, frameResolution);                                      //рисуем нормально
    }

    public void timeToZero(){   //обнуляем время
        timeAnimation = 0;
    }

    private void draw(SpriteBatch batch, Vector2 vector, int frameResolution){
        batch.draw(currentFrame, vector.x-(frameResolution/2), vector.y-(frameResolution/2), frameResolution, frameResolution);
    }

    private void drawReflected(SpriteBatch batch, Vector2 vector, int frameResolution){
        batch.draw(currentFrame, vector.x+(frameResolution/2), vector.y-(frameResolution/2), -frameResolution, frameResolution);
    }
}