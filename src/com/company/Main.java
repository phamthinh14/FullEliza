package com.company;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Thinh Pham
 */


public class Main {
    //These HEDGE and QUANTIFIER are here to easy to debug if we make any changes
    private static final String HEDGE_1 = "Please tell me more";
    private static final String HEDGE_2 = "Many of my patients tell me the same thing";
    private static final String HEDGE_3 = "It is getting late, maybe we had better quit";
    private static final String QUANTIFIER_1 = "Why do you say that";
    private static final String QUANTIFIER_2 = "You seem to think that";
    private static final String QUANTIFIER_3 = "So, you are concerned that";
    private static final String ANSI_RED = "\u001B[31m";//This is to show red texts in the console
    private static final List<String> stringHistory = new ArrayList<>();//This will add the whole conversation between user and Eliza

    public static void main(String[] args) {
        String respond;//Variable respond is to take the user input
        boolean isLoop = true;//This will control the loop. If isLoop is false, it will terminate the loop

        HelloToUser();
        while (isLoop) {
            System.out.println("Enter respond here or press Q to quit:");
            respond = new Scanner(System.in).nextLine();
            stringHistory.add(respond);
            if (respond.equalsIgnoreCase("red")) {
                isLoop = DisplayInRed(respond);
            } else {
                isLoop = DisplayNormal(respond);
            }
        }
    }

    /**
     * Display black text in the console
     *
     * @param respond is the user input
     * @return a boolean to terminate the loop in the main method
     */
    private static boolean DisplayNormal(String respond) {
        String echoRespond;//Variable echoRespind is to receive the changes of I and me-> you, my->your, and am->are from the method Echo() that takes the variable respond Echo(respond)
        String hedgeAndQuantifier;//Variable hedgeAndQuantifier is to receive the random of themselves from the method RandomRespond() which return a String
        String respondPigLatin;//Variable respondPigLatin is to receive the changes of the method PigLatin() which return a String if user inputs the variable respond ="pig"
        boolean isLoop = true;//This will return true or false to terminate the loop
        boolean isRed = false;
        //If the user input pig, Eliza will speak Pig Latin
        if (respond.equalsIgnoreCase("pig")) {
            respondPigLatin = PigLatin();
            System.out.println(respondPigLatin);
            stringHistory.add(respondPigLatin);
        }
        //If the user input play game, Eliza will let user play a game of guessing a number from 0 to 10
        if (respond.equalsIgnoreCase("play game")) {
            StartGame(isRed);
        }
        //echoRespond will change the text I to you etc... Read description for method Echo(String response)
        echoRespond = Echo(respond);
        //hedgeAndQuantifier will be assigned a random hedge and quantifier
        hedgeAndQuantifier = RandomRespond();
        //If the user type q, Eliza application will show the history of the user and Eliza
        //It also set isLoop to false to return a false to terminate the loop in the main and shut down application
        if (respond.equalsIgnoreCase("q")) {
            System.out.println("***********************************************************");
            System.out.println("\t\t\t\tHISTORY OF THE CHAT");
            IntStream.range(0, stringHistory.size()).forEach((int i) -> {
                if (i % 2 == 0) {
                    System.out.println("You: " + stringHistory.get(i) + "\n");
                }
                if (i % 2 != 0) {
                    System.out.println("Eliza: " + stringHistory.get(i) + "\n");
                }
            });
            isLoop = false;
        }
        //If the user does not to quit by enter q, it will display a message if the respond does not equal those conditions below
        //It will make sure the history will be correct
        //Hedge does not require the application to return what user ask. Therefore, if variable hedgeAndQuantifier equals one of three Hedges
        //The application will display only the hedge
        if (!respond.equalsIgnoreCase("q")
                && (hedgeAndQuantifier.equals(HEDGE_1) || hedgeAndQuantifier.equals(HEDGE_2) || hedgeAndQuantifier.equals(HEDGE_3))
                && !respond.equalsIgnoreCase("pig")
                && !respond.equalsIgnoreCase("play game")) {
            System.out.println(hedgeAndQuantifier);
            stringHistory.add(hedgeAndQuantifier);
        }
        //Same thing applies for this condition. If variable hedgeAndQuantifier equals one of three Quantifiers, the application will display a modified sentence(I->you, my->your etc..)
        // and a random Quantifiers
        if (!respond.equalsIgnoreCase("q")
                && (hedgeAndQuantifier.equals(QUANTIFIER_1) || hedgeAndQuantifier.equals(QUANTIFIER_2) || hedgeAndQuantifier.equals(QUANTIFIER_3))
                && !respond.equalsIgnoreCase("pig")
                && !respond.equalsIgnoreCase("play game")) {
            System.out.println(hedgeAndQuantifier + " " + echoRespond);
            stringHistory.add(hedgeAndQuantifier + " " + echoRespond);
        }
        return isLoop;
    }

    /**
     * Display red text in the console
     *
     * @param respond is the user input
     * @return a boolean to terminate the loop in the main method
     */
    private static boolean DisplayInRed(String respond) {
        //Eveything in this method will be the same in DisplayNormal(String respond) method, except the displayed texts will be red
        String echoRespond;
        String hedgeAndQuantifier;
        String respondPigLatin;
        boolean isLoop = true;
        boolean isRed = true;

        if (respond.equalsIgnoreCase("pig")) {
            respondPigLatin = PigLatin();
            System.out.println(ANSI_RED + respondPigLatin);
            stringHistory.add(respondPigLatin);
        }
        if (respond.equalsIgnoreCase("play game")) {

            StartGame(isRed);
        }
        echoRespond = Echo(respond);
        hedgeAndQuantifier = RandomRespond();
        if (respond.equalsIgnoreCase("q")) {
            System.out.println(ANSI_RED + "***********************************************************");
            System.out.println(ANSI_RED + "\t\t\t\tHISTORY OF THE CHAT");

            IntStream.range(0, stringHistory.size()).forEach(i -> {
                if (i % 2 == 0) {
                    System.out.println(ANSI_RED + "You: " + stringHistory.get(i) + "\n");
                }
                if (i % 2 != 0) {
                    System.out.println(ANSI_RED + "Eliza: " + stringHistory.get(i) + "\n");
                }
            });
            isLoop = false;
        }
        if (!respond.equalsIgnoreCase("q")
                && (hedgeAndQuantifier.equals(HEDGE_1) || hedgeAndQuantifier.equals(HEDGE_2) || hedgeAndQuantifier.equals(HEDGE_3))
                && !respond.equalsIgnoreCase("pig")
                && !respond.equalsIgnoreCase("play game")) {
            System.out.println(ANSI_RED + hedgeAndQuantifier);
            stringHistory.add(hedgeAndQuantifier);
        }
        if (!respond.equalsIgnoreCase("q")
                && (hedgeAndQuantifier.equals(QUANTIFIER_1) || hedgeAndQuantifier.equals(QUANTIFIER_2) || hedgeAndQuantifier.equals(QUANTIFIER_3))
                && !respond.equalsIgnoreCase("pig")
                && !respond.equalsIgnoreCase("play game")) {
            System.out.println(ANSI_RED + hedgeAndQuantifier + " " + echoRespond);
            stringHistory.add(hedgeAndQuantifier + " " + echoRespond);
        }
        return isLoop;
    }

    /**
     * Display a welcome to user and provide a list of successful test cases
     */
    private static void HelloToUser() {
        String echoRespond;
        System.out.println("\t\t\t\t\t\tWELCOME");
        System.out.println("\t\t\t\tBelow are the test cases:");
        System.out.println("***********************************************************");
        String testCase = "This is me and I";
        String testCase1 = "This is me and I and my is your, if I think me is";
        String testCase2 = "I am who I am and if my ego is dead";
        String testCase3 = "I am you";
        String testCase4 = "I am you and my is me";
        String testCase5 = "Hola my friend is I and You think my is I, and then bye";
        //Read Echo(String respond) method
        echoRespond = Echo(testCase);
        System.out.println(echoRespond);
        echoRespond = Echo(testCase1);
        System.out.println(echoRespond);
        echoRespond = Echo(testCase2);
        System.out.println(echoRespond);
        echoRespond = Echo(testCase3);
        System.out.println(echoRespond);
        echoRespond = Echo(testCase4);
        System.out.println(echoRespond);
        echoRespond = Echo(testCase5);
        System.out.println(echoRespond);
        System.out.println("***********************************************************");
        StringBuilder welcomePrompt = new StringBuilder("Good day. What is your problem?\n");
        System.out.println(welcomePrompt);
    }

    /**
     * Change I and me -> you, am -> are, and my -> your
     *
     * @param respond user input
     * @return result of a String with the changes of I and me -> you, am -> are, and my -> your
     */
    private static String Echo(String respond) {
        String result = "";
        List<String> verifyList = new ArrayList<>();
        //This loop will take the user input and delete all the spaces between words
        //This also means if a word has a symbol behind it, the word will be add to the verifyList
        for (String word : respond.split(" ")) {
            verifyList.add(word.toLowerCase());
        }
        //This loop is to change Change I and me -> you, am -> are, and my -> your
        //The regular expression i[,?:';] means if a word has i and a symbols such as: , ? : ' ; the match will return true
        //the word would be pass to StringWithSymbol(verifyList.get(i)) to modify I, me, my, and am with symbols at the end into you, you, your, and are with original symbols
        for (int i = 0; i < verifyList.size(); i++) {
            if (verifyList.get(i).equalsIgnoreCase("I")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).matches("i[,?:';]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("am")) {
                verifyList.set(i, "are");
            }
            if (verifyList.get(i).matches("am[,?:';]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("my")) {
                verifyList.set(i, "your");
            }
            if (verifyList.get(i).matches("my[,?:';]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("me")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).matches("me[,?:';]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
        }
        //After I and me -> you, am -> are, and my -> your and all the symbols changes. The result will be assign to the variable result in uppercase to display on the screen
        for (int i = 0; i < verifyList.size(); i++) {
            result += verifyList.get(i) + " ";
        }
        return result.toUpperCase();
    }

    /**
     * Generate random Hedge or Quantifier in the Eliza responses to user
     *
     * @return a String of random Hedge or Quantifier
     */
    private static String RandomRespond() {
        List<String> myRandomSentences = new ArrayList<>();
        myRandomSentences.add(HEDGE_1);
        myRandomSentences.add(HEDGE_2);
        myRandomSentences.add(HEDGE_3);
        myRandomSentences.add(QUANTIFIER_1);
        myRandomSentences.add(QUANTIFIER_2);
        myRandomSentences.add(QUANTIFIER_3);
        return myRandomSentences.get(new Random().nextInt(6));
    }

    /**
     * This method helps Eliza to speak Pig Latin
     *
     * @return If the first letter is a consonant, add "ay" to the end
     * If the first letter is a vowel, add "way" or "tay" to the end
     */
    private static String PigLatin() {
        final String AY = "AY";
        final String WAY = "WAY";
        final String TAY = "TAY";
        final String SPACE = " ";
        String prompt;

        StringBuilder holders2 = new StringBuilder();
        int randomNum;
        List<String> wordArrayList = new ArrayList<>();

        System.out.println("\tPlease Type Something: ");
        stringHistory.add("Please Type Something");
        prompt = new Scanner(System.in).nextLine();
        stringHistory.add(prompt);
        prompt.toUpperCase();
        String[] split = prompt.split(" ");
        Collections.addAll(wordArrayList, split);
// This loop is to add "ay" to the end of consonant
// add "way" or "tay" randomly to the end vowel
        for (String word : wordArrayList) {
            if (word.startsWith("a") || word.startsWith("A")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.startsWith("e") || word.startsWith("E")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.startsWith("i") || word.startsWith("I")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.startsWith("o") || word.startsWith("O")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.startsWith("u") || word.startsWith("U")) {
                holders2.append(word).append(AY).append(SPACE);
            } else {
                randomNum = new Random().nextInt(2);
                if (randomNum == 0) {
                    holders2.append(word).append(WAY).append(SPACE);
                }
                if (randomNum == 1) {
                    holders2.append(word).append(TAY).append(SPACE);
                }
            }
        }
        return holders2.toString();
    }

    /**
     * This method will modify I, me, my, and am with symbols at the end into you, you, your, and are with original symbols
     * which was provided by the user
     *
     * @param word I, me, my, and am with symbols at the end
     * @return you, you, your, and are with original symbols
     */
    private static String StringWithSymbol(String word) {
        String result = "";
        switch (word) {
            case "i,":
            case "me,":
                result = "you,";
                break;
            case "i:":
            case "me:":
                result = "you:";
                break;
            case "i;":
            case "me;":
                result = "you;";
                break;
            case "i?":
            case "me?":
                result = "you?";
                break;
            case "i'":
            case "me'":
                result = "you'";
                break;
            case "my,":
                result = "your,";
                break;
            case "my:":
                result = "your:";
                break;
            case "my;":
                result = "your;";
                break;
            case "my?":
                result = "your?";
                break;
            case "my'":
                result = "your'";
                break;
            case "am,":
                result = "are,";
                break;
            case "am:":
                result = "are:";
                break;
            case "am;":
                result = "are;";
                break;
            case "am?":
                result = "are?";
                break;
            case "am'":
                result = "are'";
                break;
        }
        return result;
    }

    /**
     * This start of game of guessing a random number from 0 to 10
     *
     * @param isColored to display text in red or black
     */
    private static void StartGame(boolean isColored) {
        int randomNumToGuess = new Random().nextInt(10);
        int userGuess;
        if (isColored) {
            System.out.println(ANSI_RED + "From 0 to 10, what number is in my head?");
            stringHistory.add("From 0 to 10, what number is in my head?");
            userGuess = new Scanner(System.in).nextInt();
            stringHistory.add(String.valueOf(userGuess));
            if (userGuess == randomNumToGuess) {
                System.out.println(ANSI_RED + "You won. The number is " + randomNumToGuess);
                stringHistory.add("You won. The number is " + randomNumToGuess);
            }
            if (userGuess != randomNumToGuess) {
                System.out.println(ANSI_RED + "You lost. The number is " + randomNumToGuess);
                stringHistory.add("You lost. The number is " + randomNumToGuess);
            }
        }
        if (!isColored) {
            System.out.println("From 0 to 10, what number is in my head?");
            stringHistory.add("From 0 to 10, what number is in my head?");
            userGuess = new Scanner(System.in).nextInt();
            stringHistory.add(String.valueOf(userGuess));
            if (userGuess == randomNumToGuess) {
                System.out.println("You won. The number is " + randomNumToGuess);
                stringHistory.add("You won. The number is " + randomNumToGuess);
            }
            if (userGuess != randomNumToGuess) {
                System.out.println("You lost. The number is " + randomNumToGuess);
                stringHistory.add("You lost. The number is " + randomNumToGuess);
            }
        }
    }
}