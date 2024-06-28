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

public class Snake{
    private int fromPosition;
    private int toPosition;

    public Snake(int from, int to) {
        this.fromPosition = from;
        this.toPosition = to;
    }
    public void setFromPosition(int fromPosition){
        this.fromPosition = fromPosition;
    }
    public void setToPosition(int toPosition){
        this.toPosition = toPosition;
    }
    public int getFromPosition(){
        return fromPosition;
    }
    public int getToPosition(){
        return toPosition;
    }
}