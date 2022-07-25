package ru.nlx.game;

public class FrameInterval {                    //контейнер данных с-по кадр из атласа, чисто для понятности и красоты
    private final int from;                     //с какого
    private final int to;                       //по какой

    public FrameInterval(int from, int to) {    //конструктор
        this.from = from;                       //установка значений
        this.to = to;                           //устанвока значений
    }

    public int getFrom(){
        return from-1;
    }   //-1  - для того, что бы правильно работало, математический прикол

    public int getTo(){
        return to;
    }         //ну тут ясно

    public int getAmountFrames(){             //узанть количество содержимого
        return getTo()-getFrom();             //супер хитрый расчет
    }
}
