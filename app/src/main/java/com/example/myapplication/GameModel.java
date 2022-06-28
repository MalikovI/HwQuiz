package com.example.myapplication;

import java.io.Serializable;

public class GameModel implements Serializable {

    public String firstImg, secondImg, thirdImg, fourthImg, answer, levelChoice, levelDisplay;

    public GameModel(String firstImg, String secondImg, String thirdImg, String fourthImg, String answer, String level, String levelDisplay) {
        this.firstImg = firstImg;
        this.secondImg = secondImg;
        this.thirdImg = thirdImg;
        this.fourthImg = fourthImg;
        this.answer = answer;
        this.levelChoice = level;
        this.levelDisplay = levelDisplay;
    }
}
