package com.company;

import java.util.*;

/**
 * +===================================+
 * |          |           |     8      |
 * |     5    |    6      |_Secret Rm)_|
 * |(Kitchen) | (dinning) |     7      |
 * |_____ ____|___________|__(Vault)___|
 * |          |           |            |
 * |    2     |    3      |     4      |
 * |(Front Rm)| (Library) | (Parlor)   |
 * |__________|_____ _____|____________|
 * |          |
 * |     1    |
 * | (Foyer)  |
 * |_____ ____|
 * *       North
 * * West         East
 * *       South
 */
public class AdventureGameNormalText {
    private static int countTrollRob = 0;
    private static double robbedTotal = 0;
    private static double currentGold = 0;
    private static boolean isSecretRoomUnlocked = false;
    private static Map<Integer, Boolean> castleMap = new HashMap<>();
    private static Map<Integer, String> roomItems = new HashMap<>();
    private static Map<Integer, Double> money = new HashMap<>();
    private List<String> historyOfTheGame = new ArrayList<>();

    public AdventureGameNormalText() {
        Welcome();
        Foyer();
    }

    public void Welcome() {
        System.out.println("\t Welcome to the castle");
        System.out.println("\t *********************");
        System.out.println("WARNING: THIS CASTLE HAS MANY TROLLS");
        System.out.println(" =>YOU CAN BE ROBBED MANY TIMES<=");
    }

    private void DisplayCurrentGold() {
        System.out.println("Your total gold right now $" + String.format("%.2f", currentGold));
    }

    private void computeGold(int room) {
        int troll = 1 + new Random().nextInt(7);
        if (!money.containsKey(room)) {
            double gold;
            double min = 0;
            double max = 1000;
            gold = min + (max - min) * new Random().nextDouble();
            System.out.println("This room has $" + String.format("%.2f", gold));
            money.put(room, gold);
            currentGold += gold;
            System.out.println("Your current gold is: $" + String.format("%.2f", currentGold));

        }
        if (troll == room) {
            robbedTotal += currentGold;
            currentGold -= currentGold;
            System.out.println("\tT.T YOU HAVE BEEN ROBBED BY A TROLL T.T");
            countTrollRob++;
            DisplayCurrentGold();
        }

    }

    private void Foyer() {
        boolean quit = false;
        String userInput = "";
        System.out.println("\tYou are now in the FOYER room");
        System.out.println("This room has a: DEAD SCORPION");
        castleMap.put(1, true);
        roomItems.put(1, "Dead Scorpion");
        computeGold(1);

        direction(1);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") || userInput.equalsIgnoreCase("q"))) {
            direction(1);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
            FrontRoom();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void Library() {
        boolean quit = false;
        String userInput;
        System.out.println("\tYou are now in the LIBRARY");
        System.out.println("This room has a: SPIDERS");
        castleMap.put(3, true);
        roomItems.put(3, "Spiders");
        computeGold(3);
        direction(1);
        direction(2);
        direction(3);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
                userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
                userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(1);
            direction(2);
            direction(3);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
            DiningRoom();
        }
        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
            FrontRoom();
        }
        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
            Parlor();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void Parlor() {
        boolean quit = false;
        String userInput;
        System.out.println("\tYou are now in the PARLOR");
        System.out.println("This room has a: TREASURE CHEST");
        castleMap.put(4, true);
        roomItems.put(4, "Treasure Chest");
        computeGold(4);
        direction(1);
        direction(2);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
                userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(1);
            direction(2);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
            Vault();
        }
        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
            Library();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void DiningRoom() {
        boolean quit = false;
        String userInput;
        System.out.println("\tYou are now in the DINING ROOM");
        System.out.println("This room has a: DUST AND EMPTY BOX");
        castleMap.put(6, true);
        roomItems.put(6, "Dust and Empty Box");
        computeGold(6);
        direction(2);
        direction(3);
        direction(4);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
                userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
                userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(2);
            direction(3);
            direction(4);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
            Library();
        }
        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
            Kitchen();
        }
        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
            Vault();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void Vault() {
        boolean quit = false;
        String userInput;
        System.out.println("\tYou are now in the VAULT");
        System.out.println("This room has a: THREE SKELETONS");
        castleMap.put(7, true);
        roomItems.put(7, "Three Skeletons");
        computeGold(7);
        int random = new Random().nextInt(4);
        if (random == 0) {
            System.out.println("You have unlocked the secret room");
            isSecretRoomUnlocked = true;
        }
        if (isSecretRoomUnlocked) {
            direction(1);
        }
        direction(2);
        direction(4);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!isSecretRoomUnlocked && !(userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(2);
            direction(4);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        while (isSecretRoomUnlocked && !(userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
                userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(1);
            direction(2);
            direction(4);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (isSecretRoomUnlocked) {
            if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
                SecretRoom();
            }
        }
        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
            DiningRoom();
        }
        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
            Parlor();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void SecretRoom() {
        boolean quit = false;
        String userInput;
        System.out.println("\tYou are now in the SECRET ROOM");
        System.out.println("This room has a: PILES OF GOLD");
        castleMap.put(8, true);
        roomItems.put(8, "Piles of gold");
        computeGold(8);
        direction(2);
        direction(4);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
                userInput.equalsIgnoreCase("q"))) {
            computeGold(8);
            direction(2);
            direction(4);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
        }
        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
            DiningRoom();
        }
        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
            Vault();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void FrontRoom() {
        boolean quit = false;
        String userInput = "";
        System.out.println("\tYou are now in the FRONT ROOM");
        System.out.println("This room has a: PIANO");
        castleMap.put(2, true);
        roomItems.put(2, "Piano");
        computeGold(2);
        direction(1);
        direction(3);
        direction(4);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
                userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(1);
            direction(3);
            direction(4);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
            Kitchen();
        }
        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
            Library();
        }
        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
            Foyer();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void Kitchen() {
        boolean quit = false;
        String userInput;
        System.out.println("\tYou are now in the KITCHEN");
        System.out.println("This room has a: BATS");
        castleMap.put(5, true);
        roomItems.put(5, "Bats");
        computeGold(5);
        direction(3);
        direction(4);
        System.out.println("Type q to stop the game");
        DisplayCurrentGold();
        userInput = new Scanner(System.in).nextLine();
        while (!(userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
                userInput.equalsIgnoreCase("q"))) {
            direction(3);
            direction(4);
            System.out.println("Type q to stop the game");
            DisplayCurrentGold();
            userInput = new Scanner(System.in).nextLine();
        }
        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
            DiningRoom();
        }
        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
            FrontRoom();
        }
        if (userInput.equalsIgnoreCase("q")) {
            quit = quit();
        }

    }

    private void direction(int number) {
        if (number == 1) {
            System.out.println("Type N or North to go to the North");
        }
        if (number == 2) {
            System.out.println("Type W or West to go to the West");
        }
        if (number == 3) {
            System.out.println("Type E or East to go to the East");
        }
        if (number == 4) {
            System.out.println("Type S or South to go to the South");
        }
    }

    private boolean quit() {
        int count = 1;
        int random = new Random().nextInt(4);
        if (random == 3) {
            System.out.println("****************************************");
            System.out.println("\t A GHOST HAVE FOLLOWED YOU");
            this.historyOfTheGame.add("****************************************\n" + "\t A GHOST HAVE FOLLOWED YOU\n");
        }
        System.out.println("**************************************************");
        System.out.println("\tYOU VISITED " + castleMap.size() + " ROOM");
        System.out.println("\tYOU EARNED $" + String.format("%.2f", currentGold));
        System.out.println("\tYOU HAVE BEEN ROBBED $" + String.format("%.2f", robbedTotal) + " AFTER " + countTrollRob + " TIMES");
        System.out.println("\tITEMS YOU FOUND: ");
        this.historyOfTheGame.add("**************************************************\n"
                + "\tYOU VISITED " + castleMap.size() + " ROOM" + "\n"
                + "\tYOU EARNED $" + String.format("%.2f", currentGold) + "\n"
                + "\tYOU HAVE BEEN ROBBED $" + String.format("%.2f", robbedTotal) + " AFTER " + countTrollRob + " TIMES" + "\n"
                + "\tITEMS YOU FOUND: " + "\n");
        for (String item : roomItems.values()) {
            System.out.println(count + "/ " + item);
            this.historyOfTheGame.add(count + "/ " + item + "\n");
            count++;
        }
        System.out.println("\t\t\tEND GAME");
        System.out.println("**************************************************");
        this.historyOfTheGame.add("\t\t\tEND GAME\n" + "**************************************************\n");
        return true;
    }

    public String gameHistory() {
        String result = "";
        for (String aHistoryOfTheGame : this.historyOfTheGame) {
            result += aHistoryOfTheGame;
        }
        return result;
    }
}
