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
public class AdventureGameInRedText extends AdventureGameNormalText {
//    private final String ANSI_RED = "\u001B[31m";//This is to show red texts in the console
//    private int countTrollRob = 0;
//    private double robbedTotal = 0;
//    private double currentGold = 0;
//    private boolean isSecretRoomUnlocked = false;
//    private Map<Integer, Boolean> castleMap = new HashMap<>();
//    private Map<Integer, String> roomItems = new HashMap<>();
//    private Map<Integer, Double> money = new HashMap<>();
//    private List<String> historyOfTheGame = new ArrayList<>();
//    private final String QUIT_GAME_PROMPT = ANSI_RED + "Type q to stop the game";
//    private final String FOYER_WELCOME = ANSI_RED + "\tYou are now in the FOYER room\n" + "This room has a: DEAD SCORPION\n";
//    private final String LIBRARY_WELCOME = ANSI_RED + "\tYou are now in the LIBRARY room\n" + "This room has a: SPIDERS\n";
//    private final String PARLOR_WELCOME = ANSI_RED + "\tYou are now in the PARLOR room\n" + "This room has a: TREASURE CHEST\n";
//    private final String FRONT_ROOM_WELCOME = ANSI_RED + "\tYou are now in the FRONT ROOM\n" + "This room has a: PIANO\n";
//    private final String KITCHEN_WELCOME = ANSI_RED + "\tYou are now in the KITCHEN\n" + "This room has a: BATS\n";
//    private final String DINING_ROOM_WELCOME = ANSI_RED + "\tYou are now in the DINING ROOM\n" + "This room has a: DUST AND EMPTYBOX\n";
//    private final String VAULT_WELCOME = ANSI_RED + "\tYou are now in the VAULT ROOM\n" + "This room has a: THREE WALKING SKELETONS\n";
//    private final String SECRET_ROOM_WELCOME = ANSI_RED + "\tYou are now in the SECRET ROOM\n" + "This room has a: PILES OF GOLD\n";
//
//    public AdventureGameInRedText() {
//        Welcome();
//    }

    @Override
    public void Welcome() {
        super.toString();
    }

    @Override
    public void computeGold(int room) {
        super.computeGold(room);
    }

    @Override
    public void DisplayCurrentGold() {
        super.DisplayCurrentGold();
    }

    @Override
    public void Foyer() {
        super.Foyer();
    }

    @Override
    public void Library() {
        super.Library();
    }

    @Override
    public void Parlor() {
        super.Parlor();
    }

    @Override
    public void DiningRoom() {
        super.DiningRoom();
    }

    @Override
    public void Vault() {
        super.Vault();
    }

    @Override
    public void SecretRoom() {
        super.SecretRoom();
    }

    @Override
    public void FrontRoom() {
        super.FrontRoom();
    }

    @Override
    public void Kitchen() {
        super.Kitchen();
    }

    @Override
    public void DisplayDirection(int number) {
        super.DisplayDirection(number);
    }

    @Override
    public boolean quit() {
        return super.quit();
    }

    @Override
    public String gameHistory() {
        return super.gameHistory();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //    public AdventureGameInRedText() {
//        Welcome();
//        Foyer();
//    }

//    public void Welcome() {
//        StringBuilder welcomeUser = new StringBuilder();
//        welcomeUser.append(ANSI_RED + "\t Welcome to the castle\n"
//                + "\t *********************\n"
//                + "WARNING: THIS CASTLE HAS MANY TROLLS\n"
//                + " =>YOU CAN BE ROBBED MANY TIMES<=\n");
//        System.out.println(welcomeUser.toString());
//    }
//
//    private void DisplayCurrentGold() {
//        System.out.println(ANSI_RED + "Your total gold right now $" + String.format("%.2f", currentGold));
//    }
//
//    private void computeGold(int room) {
//        int troll = 1 + new Random().nextInt(7);
//        if (!money.containsKey(room)) {
//            double gold;
//            double min = 0;
//            double max = 1000;
//            gold = min + (max - min) * new Random().nextDouble();
//            System.out.println(ANSI_RED + "This room has $" + String.format("%.2f", gold));
//            money.put(room, gold);
//            currentGold += gold;
//            System.out.println(ANSI_RED + "Your current gold is: $" + String.format("%.2f", currentGold));
//
//        }
//        if (troll == room) {
//            robbedTotal += currentGold;
//            currentGold -= currentGold;
//            System.out.println(ANSI_RED + "\tT.T YOU HAVE BEEN ROBBED BY A TROLL T.T");
//            countTrollRob++;
//            DisplayCurrentGold();
//        }
//
//    }
//
//    private void Foyer() {
//        boolean quit = false;
//        String userInput = "";
//
//        System.out.println(FOYER_WELCOME);
//        castleMap.put(1, true);
//        roomItems.put(1, "Dead Scorpion");
//        computeGold(1);
//        DisplayDirection(1);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") || userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(1);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
//            FrontRoom();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void Library() {
//        boolean quit = false;
//        String userInput;
//
//        System.out.println(LIBRARY_WELCOME);
//        castleMap.put(3, true);
//        roomItems.put(3, "Spiders");
//        computeGold(3);
//        DisplayDirection(1);
//        DisplayDirection(2);
//        DisplayDirection(3);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
//                userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
//                userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(1);
//            DisplayDirection(2);
//            DisplayDirection(3);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
//            DiningRoom();
//        }
//        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
//            FrontRoom();
//        }
//        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
//            Parlor();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void Parlor() {
//        boolean quit = false;
//        String userInput;
//        System.out.println(PARLOR_WELCOME);
//        castleMap.put(4, true);
//        roomItems.put(4, "Treasure Chest");
//        computeGold(4);
//        DisplayDirection(1);
//        DisplayDirection(2);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
//                userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(1);
//            DisplayDirection(2);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
//            Vault();
//        }
//        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
//            Library();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void DiningRoom() {
//        boolean quit = false;
//        String userInput;
//        System.out.println(DINING_ROOM_WELCOME);
//        castleMap.put(6, true);
//        roomItems.put(6, "Dust and Empty Box");
//        computeGold(6);
//        DisplayDirection(2);
//        DisplayDirection(3);
//        DisplayDirection(4);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
//                userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
//                userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(2);
//            DisplayDirection(3);
//            DisplayDirection(4);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
//            Library();
//        }
//        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
//            Kitchen();
//        }
//        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
//            Vault();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void Vault() {
//        boolean quit = false;
//        String userInput;
//        System.out.println(VAULT_WELCOME);
//        castleMap.put(7, true);
//        roomItems.put(7, "Three Skeletons");
//        computeGold(7);
//        int random = new Random().nextInt(4);
//        if (random == 0) {
//            System.out.println(ANSI_RED + "You have unlocked the secret room");
//            isSecretRoomUnlocked = true;
//        }
//        if (isSecretRoomUnlocked) {
//            DisplayDirection(1);
//        }
//        DisplayDirection(2);
//        DisplayDirection(4);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!isSecretRoomUnlocked && !(userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
//                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(2);
//            DisplayDirection(4);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        while (isSecretRoomUnlocked && !(userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
//                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
//                userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(1);
//            DisplayDirection(2);
//            DisplayDirection(4);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (isSecretRoomUnlocked) {
//            if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
//                SecretRoom();
//            }
//        }
//        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
//            DiningRoom();
//        }
//        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
//            Parlor();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//    }
//
//    private void SecretRoom() {
//        boolean quit = false;
//        String userInput;
//        System.out.println(SECRET_ROOM_WELCOME);
//        castleMap.put(8, true);
//        roomItems.put(8, "Piles of gold");
//        computeGold(8);
//        DisplayDirection(2);
//        DisplayDirection(4);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west") ||
//                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
//                userInput.equalsIgnoreCase("q"))) {
//            computeGold(8);
//            DisplayDirection(2);
//            DisplayDirection(4);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//        }
//        if (userInput.equalsIgnoreCase("w") || userInput.equalsIgnoreCase("west")) {
//            DiningRoom();
//        }
//        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
//            Vault();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void FrontRoom() {
//        boolean quit = false;
//        String userInput = "";
//        System.out.println(FRONT_ROOM_WELCOME);
//        castleMap.put(2, true);
//        roomItems.put(2, "Piano");
//        computeGold(2);
//        DisplayDirection(1);
//        DisplayDirection(3);
//        DisplayDirection(4);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north") ||
//                userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
//                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(1);
//            DisplayDirection(3);
//            DisplayDirection(4);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("north")) {
//            Kitchen();
//        }
//        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
//            Library();
//        }
//        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
//            Foyer();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void Kitchen() {
//        boolean quit = false;
//        String userInput;
//        System.out.println(KITCHEN_WELCOME);
//        castleMap.put(5, true);
//        roomItems.put(5, "Bats");
//        computeGold(5);
//        DisplayDirection(3);
//        DisplayDirection(4);
//        System.out.println(QUIT_GAME_PROMPT);
//        DisplayCurrentGold();
//        userInput = new Scanner(System.in).nextLine();
//        while (!(userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east") ||
//                userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south") ||
//                userInput.equalsIgnoreCase("q"))) {
//            DisplayDirection(3);
//            DisplayDirection(4);
//            System.out.println(QUIT_GAME_PROMPT);
//            DisplayCurrentGold();
//            userInput = new Scanner(System.in).nextLine();
//        }
//        if (userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("east")) {
//            DiningRoom();
//        }
//        if (userInput.equalsIgnoreCase("s") || userInput.equalsIgnoreCase("south")) {
//            FrontRoom();
//        }
//        if (userInput.equalsIgnoreCase("q")) {
//            quit = quit();
//        }
//
//    }
//
//    private void DisplayDirection(int number) {
//        if (number == 1) {
//            System.out.println("Type N or North to go to the North");
//        }
//        if (number == 2) {
//            System.out.println("Type W or West to go to the West");
//        }
//        if (number == 3) {
//            System.out.println("Type E or East to go to the East");
//        }
//        if (number == 4) {
//            System.out.println("Type S or South to go to the South");
//        }
//    }
//
//    private boolean quit() {
//        int count = 1;
//        int random = new Random().nextInt(4);
//        if (random == 3) {
//            System.out.println(ANSI_RED + "****************************************");
//            System.out.println(ANSI_RED + "\t A GHOST HAVE FOLLOWED YOU");
//            this.historyOfTheGame.add(ANSI_RED + "****************************************\n" + "\t A GHOST HAVE FOLLOWED YOU\n");
//        }
//        System.out.println(ANSI_RED + "**************************************************");
//        System.out.println(ANSI_RED + "\tYOU VISITED " + castleMap.size() + " ROOM");
//        System.out.println(ANSI_RED + "\tYOU EARNED $" + String.format("%.2f", currentGold));
//        System.out.println(ANSI_RED + "\tYOU HAVE BEEN ROBBED $" + String.format("%.2f", robbedTotal) + " AFTER " + countTrollRob + " TIMES");
//        System.out.println(ANSI_RED + "\tITEMS YOU FOUND: ");
//        this.historyOfTheGame.add(ANSI_RED + "**************************************************\n"
//                + "\tYOU VISITED " + castleMap.size() + " ROOM" + "\n"
//                + "\tYOU EARNED $" + String.format("%.2f", currentGold) + "\n"
//                + "\tYOU HAVE BEEN ROBBED $" + String.format("%.2f", robbedTotal) + " AFTER " + countTrollRob + " TIMES" + "\n"
//                + "\tITEMS YOU FOUND: " + "\n");
//        for (String item : roomItems.values()) {
//            System.out.println(ANSI_RED + count + "/ " + item);
//            this.historyOfTheGame.add(ANSI_RED + count + "/ " + item + "\n");
//            count++;
//        }
//        System.out.println(ANSI_RED + "\t\t\tEND GAME");
//        System.out.println(ANSI_RED + "**************************************************");
//        this.historyOfTheGame.add(ANSI_RED + "\t\t\tEND GAME\n" + "**************************************************\n");
//        return true;
//    }
//
//    public String gameHistory() {
//        String result = "";
//        for (String aHistoryOfTheGame : this.historyOfTheGame) {
//            result += ANSI_RED + aHistoryOfTheGame;
//        }
//        return result;
//    }
}
