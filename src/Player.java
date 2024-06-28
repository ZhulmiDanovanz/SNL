/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : C
 * Group    : 15
 * Members  :
 * 1. 5026231227 - Arjuna Veetaraq
 * 2. 5026231172 - M. Zhulmi Danovanz Hidanasukha
 * 3. 5026231192 - Ikhwanul Hafidz
 * ------------------------------------------------------
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Player{
    //states
    private String userName;
    private int position;
    private int wins;

    //methods
    //constructor
    public Player(String userName){
        this.userName = userName;
        this.position = 0;
        this.wins = 0;
    }

    //setter
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPosition(int position){
        this.position = position;
    }

    //getter
    public String getUserName(){
        return userName;
    }

    public int getPosition(){
        return position;
    }

    //rolldice method
    public int rollDice(){
        return (int) (Math.random()*6)+1;
    }

    //move around method
    public void moveAround(int x, int boardSize){
        if(this.position + x > boardSize)
            this.position = boardSize - ((this.position + x) % boardSize);
        else this.position += x;
    }

    // recordWins method
    public void recordWins() {
        this.wins++;
    }

    // getWins method
    public int getWins() {
        return this.wins;
    }

}