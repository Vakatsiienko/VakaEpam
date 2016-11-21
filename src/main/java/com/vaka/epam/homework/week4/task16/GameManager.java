package com.vaka.epam.homework.week4.task16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Iaroslav on 11/20/2016.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GameManager {

    private static List<Ship> shipsWithoutCoordinates;

    static {
        List<Ship> list = new ArrayList<>(10);
        list.add(new Ship(1));
        list.add(new Ship(1));
        list.add(new Ship(1));
        list.add(new Ship(1));
        list.add(new Ship(2));
        list.add(new Ship(2));
        list.add(new Ship(2));
        list.add(new Ship(3));
        list.add(new Ship(3));
        list.add(new Ship(4));
        shipsWithoutCoordinates = Collections.unmodifiableList(list);
    }

    private static String emptyField;

    static {
        StringBuilder builder = new StringBuilder();
        int a = 97;
        char line = '\n';
        char space = ' ';
        char dash = '-';
        builder.append(space);
        for (int j = 0; j < 10; j++) {
            builder.append(space).append(j + 1);
        }
        builder.append(line);
        for (int i = 0; i < 10; i++) {
            char r = (char) (97 + i);
            builder.append(r);
            for (int j = 0; j < 10; j++) {
                builder.append(space).append(dash);
            }
            builder.append(line);
        }
        emptyField = builder.toString().toUpperCase();
    }

    private Player firstPlayer;
    private Player secondPlayer;


    public static GameManager createSP(String playerName) {
        Player first = initializeHumanPlayer(playerName);
        placeShips(first);
        Player second = initializeAIPlayer();
        placeShips(second);
        return new GameManager(first, second);
    }

    public static Player initializeHumanPlayer(String playerName) {
        Player player = new HumanPlayer();
        player.setName(playerName);
        player.setPlayerField(initializeHumanField());
        return player;
    }

    public static Field initializeHumanField() {
        return new Field();
    }

    public static Field initializeAIField() {
        return new Field();
    }

    public static Player initializeAIPlayer() {
        Player aiPlayer = new AIPlayer();
        aiPlayer.setPlayerField(initializeAIField());
        return new AIPlayer();
    }

    public static void placeShips(Player player) {
        buildShips(player);
        if (player instanceof HumanPlayer) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            List<Ship> ships = player.getPlayerField().getShips();
            for (int i = 0; i < ships.size(); i++) {
                try {

                    Ship ship = ships.get(i);
                    printField(player);
                    String strCoordinates = getCoordinated(writer, reader, String.join("",
                            "Write coordinates for your " + ship.getDecks() + "-decks ship, example 'A0 A2 A3 A4'"));
                    ship.setCoordinates(parseCoordinates(strCoordinates, ship.getDecks()));
                } catch (IOException ioe) {
                    i--;
                    System.out.println("Problems with input, try to rewrite");
                } catch (CoordinatesParseException cpe) {
                    i--;
                    System.out.println("Wrong coordinates, try to rewrite");
                }

            }

        }
        if (player instanceof AIPlayer)
            generateShips(player);
    }

    public static void generateShips(Player player) {
        //TODO add realization
    }

    public static void buildShips(Player player) {
        List<Ship> ships = new ArrayList<>(10);
        Collections.copy(ships, shipsWithoutCoordinates);
        player.getPlayerField().setShips(ships);
    }

    public static Coordinate[] parseCoordinates(String strCoors, int decks) throws CoordinatesParseException {
        strCoors = strCoors.toUpperCase();
        String[] coorsArray = strCoors.split(" ");
        int i = 1;
        Coordinate[] coordinates = new Coordinate[decks];
        for (String s : coorsArray) {
            coordinates[i++] = parseCoordinate(s);
        }
        return coordinates;
    }

    public static Coordinate parseCoordinate(String string) throws CoordinatesParseException {
        try {
            for (int i = 0; i < 10; i++) {
                if (string.charAt(0) == 97 + i)
                    return new Coordinate(i, Integer.valueOf(string.substring(1)));
            }
        } catch (NumberFormatException ex) {
            throw new CoordinatesParseException(ex);
        }
        throw new CoordinatesParseException("Inappropriate coordinate");
    }

    public static String getCoordinated(BufferedWriter writer, BufferedReader reader, String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
        return reader.readLine();
    }

    public static void printField(Player player) {
        List<Ship> list = player.getPlayerField().getShips();

    }

    public static void main(String[] args) {
        System.out.println(emptyField);
        System.out.println();
        emptyField = emptyField.substring(0, 25) + 'O' + emptyField.substring(26);  
        emptyField = emptyField.substring(0, 47) + 'O' + emptyField.substring(48);
        emptyField = emptyField.substring(0, 69) + 'O' + emptyField.substring(70);
        System.out.println(emptyField);
    }
}
