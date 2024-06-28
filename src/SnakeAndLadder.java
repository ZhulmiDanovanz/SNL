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

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class SnakeAndLadder {
    //states
    private ArrayList<Player> players;
    private ArrayList<Snake> snakes;
    private ArrayList<
            Ladder> ladders;
    private int boardSize;
    //0 = the game isnt started yet
    //1 = the game is started
    //2 = the game is over
    private int status;
    private int playerInTurn;
    private int currentPlayerIndex;

    public SnakeAndLadder(int boardSize) {
        this.boardSize = boardSize;
        this.players = new ArrayList<Player>();
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.status = 0;
    }

    public void initiateGame() {
        //set the ladders
        int[][] ladders = {
                {2, 23},
                {8, 34},
                {20, 77},
                {32, 68},
                {41, 79},
                {74, 88},
                {82, 100},
                {85, 95}
        };
        addLadders(ladders);
        //set the snakes
        int[][] snakes = {
                {29, 9},
                {38, 15},
                {47, 5},
                {53, 33},
                {62, 37},
                {86, 54},
                {92, 70},
                {97, 25}
        };
        addSnakes(snakes);
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPlayerInTurn(int p) {
        this.playerInTurn = p;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public void addSnake(Snake s) {
        this.snakes.add(s);
    }

    public void addSnakes(int[][] s) {
        for (int i = 0; i < s.length; i++) {
            Snake snake = new Snake(s[i][0], s[i][1]);
            this.snakes.add(snake);
        }
    }

    public void addLadder(Ladder l) {
        this.ladders.add(l);
    }

    public void addLadders(int[][] l) {
        for (int m = 0; m < l.length; m++) {
            Ladder ladder = new Ladder(l[m][0], l[m][1]);
            this.ladders.add(ladder);
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getStatus() {
        return status;
    }

    public int getPlayerInTurn() {
        return playerInTurn;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public ArrayList<Ladder> getLadders() {
        return ladders;
    }

    public int getTurn() {
        if (this.status == 0) {
            double r = Math.random();
            if (r < 0.5) return 0;
            else return 1;
        } else {
            if (playerInTurn == 0) {
                return 1;
            } else return 0;
        }
    }

    public void movePlayer(Player p, int diceRoll) {
        int newPosition = p.getPosition() + diceRoll;
        if (newPosition > boardSize) {
            newPosition = boardSize - (newPosition - boardSize);
        }
        p.setPosition(newPosition);

        // Check for ladders and snakes
        for (Ladder ladder : ladders) {
            if (p.getPosition() == ladder.getFromPosition()) {
                p.setPosition(ladder.getToPosition());
                System.out.println(p.getUserName() + " climbed a ladder to position " + p.getPosition());
                break;
            }
        }

        for (Snake snake : snakes) {
            if (p.getPosition() == snake.getFromPosition()) {
                p.setPosition(snake.getToPosition());
                System.out.println(p.getUserName() + " slid down a snake to position " + p.getPosition());
                break;
            }
        }

        System.out.println(p.getUserName() + "'s new position is " + p.getPosition());
    }

    public void play() {
        System.out.println("Enter number of players:");
        Scanner sc = new Scanner(System.in);
        int numPlayers = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter player " + i + " name:");
            String playerName = sc.nextLine();
            Player player = new Player(playerName);
            addPlayer(player);
        }

        initiateGame();

        currentPlayerIndex = 0;

        do {
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println("---------------------------------");
            System.out.println("Player in turn is " + currentPlayer.getUserName());

            System.out.println(currentPlayer.getUserName() + ", press enter to roll dice");
            sc.nextLine(); // Wait for player input

            int diceResult = currentPlayer.rollDice();
            System.out.println("Dice number: " + diceResult);
            movePlayer(currentPlayer, diceResult);

            // Check if player has won
            if (currentPlayer.getPosition() == boardSize) {
                status = 2;
                System.out.println("The winner is: " + currentPlayer.getUserName());
                currentPlayer.recordWins();
                // Implement scoring system where currentPlayer's score is updated
            }

            // Move to next player
            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;

        } while (status != 2);

        System.out.println("Final wins count:");

        for (Player player : players) {
            System.out.println(player.getUserName() + " total wins is: " + player.getWins());
        }

        sc.close();
    }

}
