package com.vaka.epam.homework.week4.task25Memento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Iaroslav on 11/22/2016.
 */
public class TickTackToeGame {
    private String turn = TURN_X;
    private static final String TURN_X = "X";
    private static final String TURN_O = "O";
    private String[][] gameField = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private Memento memento = new Memento();

    public void undoTurn() {
        gameField = memento.backupField.clone();
    }

    public static void main(String[] args) throws IOException {
        TickTackToeGame game = new TickTackToeGame();
        System.out.println(game.startGame());

    }

    public String startGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        while (true) {
            printField();
            if (checkForDraw()) {
                return "Draw!";
            }
            String command = reader.readLine();
            if ("undo".equals(command)) {
                undoTurn();
                nextTurn();
                continue;
            }
            memento.saveState();
            int[] shot = parseCoordinates(command);
            giveAShot(shot[0], shot[1]);
            if (checkForWin(shot[0], shot[1], turn)) {
                printField();
                return turn + " won!";
            }
            nextTurn();
            counter++;
        }


    }

    private void nextTurn() {
        if (turn.equals("X"))
            turn = "O";
        else turn = "X";
    }

    private void printField() {
        for (String[] strings : gameField) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private int[] parseCoordinates(String str) throws IOException {
        String[] coor = str.split(" ");
        int[] coordinates = new int[2];
        coordinates[0] = Integer.valueOf(coor[0]);
        coordinates[1] = Integer.valueOf(coor[1]);
        return coordinates;
    }

    private boolean checkForDraw() {
        for (String[] strings : gameField) {
            for (String string : strings) {
                if (" ".equals(string))
                    return false;
            }
        }
        return true;
    }

    private void giveAShot(int x, int y) {
        if (turn.equals(TURN_O)) {
            gameField[y - 1][x - 1] = "O";
        } else {
            gameField[y - 1][x - 1] = "X";
        }
    }

    private boolean checkForWin(int x, int y, String turn) {
        boolean result = checkX(x, turn);
        if (result)
            return true;
        result = checkY(y, turn);
        if (result)
            return true;

        return checkX(x, turn) || checkY(y, turn) || checkDiagonals(turn);
    }

    private boolean checkX(int x, String turn) {
        int[] count = new int[3];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[j][i].equals(turn))
                    count[i]++;
            }
        }
        for (int i : count) {
            if (i == 3)
                return true;
        }
        return false;
    }

    private boolean checkY(int y, String turn) {
        int[] count = new int[3];
        for (int i = 0; i < gameField.length; i++) {
            String[] strings = gameField[i];
            for (String string : strings) {
                if (string.equals(turn))
                    count[i]++;
            }
        }
        for (int i : count) {
            if (i == 3)
                return true;
        }
        return false;
    }

    private boolean checkDiagonals(String turn) {
        if (!gameField[1][1].equals(turn))
            return false;
        if (gameField[0][0].equals(gameField[2][2]))
            return gameField[0][0].equals(gameField[1][1]);
        return gameField[0][2].equals(gameField[2][0]) && gameField[0][2].equals(gameField[1][1]);
    }

    private class Memento {
        private String[][] backupField;

        public Memento() {
        }

        private void saveState() {
            backupField = new String[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    backupField[i][j] = TickTackToeGame.this.gameField[i][j];
                }
            }
        }
    }
}
