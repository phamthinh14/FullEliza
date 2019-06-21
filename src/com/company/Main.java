package com.company;

import java.util.*;
import java.util.stream.IntStream;

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
        String echoRespond;//Variable echoRespind is to receive the changes of I and me-> you, my->your, and am->are from the method Echo() that takes the variable respond Echo(respond)
        String hedgeAndQuantifier;//Variable hedgeAndQuantifier is to receive the random of themselves from the method RandomRespond() which return a String
        String respondPigLatin;//Variable respondPigLatin is to receive the changes of the method PigLatin() which return a String if user inputs the variable respond ="pig"
        boolean isLoop = true;//This
        boolean isRed;

        HelloToUser();

        while (isLoop) {
            System.out.println("Enter respond here or press Q to quit:");
            respond = new Scanner(System.in).nextLine();
            stringHistory.add(respond);
            if (respond.equalsIgnoreCase("red")) {
                isRed = true;
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
            } else {
                isRed = false;
                if (respond.equalsIgnoreCase("pig")) {
                    respondPigLatin = PigLatin();
                    System.out.println(respondPigLatin);
                    stringHistory.add(respondPigLatin);
                }
                if (respond.equalsIgnoreCase("play game")) {
                    StartGame(isRed);
                }
                echoRespond = Echo(respond);
                hedgeAndQuantifier = RandomRespond();
                if (respond.equalsIgnoreCase("q")) {
                    System.out.println("***********************************************************");
                    System.out.println("\t\t\t\tHISTORY OF THE CHAT");
                    IntStream.range(0, stringHistory.size()).forEach(i -> {
                        if (i % 2 == 0) {
                            System.out.println("You: " + stringHistory.get(i) + "\n");
                        }
                        if (i % 2 != 0) {
                            System.out.println("Eliza: " + stringHistory.get(i) + "\n");
                        }
                    });
                    isLoop = false;
                }
                if (!respond.equalsIgnoreCase("q")
                        && (hedgeAndQuantifier.equals(HEDGE_1) || hedgeAndQuantifier.equals(HEDGE_2) || hedgeAndQuantifier.equals(HEDGE_3))
                        && !respond.equalsIgnoreCase("pig")
                        && !respond.equalsIgnoreCase("play game")) {
                    System.out.println(hedgeAndQuantifier);
                    stringHistory.add(hedgeAndQuantifier);
                }
                if (!respond.equalsIgnoreCase("q")
                        && (hedgeAndQuantifier.equals(QUANTIFIER_1) || hedgeAndQuantifier.equals(QUANTIFIER_2) || hedgeAndQuantifier.equals(QUANTIFIER_3))
                        && !respond.equalsIgnoreCase("pig")
                        && !respond.equalsIgnoreCase("play game")) {
                    System.out.println(hedgeAndQuantifier + " " + echoRespond);
                    stringHistory.add(hedgeAndQuantifier + " " + echoRespond);
                }
            }
        }
    }

    private static void HelloToUser() {
        String echoRespond;
        System.out.println("\tBelow are the test cases:");
        System.out.println("***********************************************************");
        String testCase = "This is me and I";
        String testCase1 = "This is me and I and my is your, if I think me is";
        String testCase2 = "I am who I am and if my ego is dead";
        String testCase3 = "I am you";
        String testCase4 = "I am you and my is me";
        String testCase5 = "Hola my friend is I and You think my is I, and then bye";
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

    private static String Echo(String respond) {
        String result = "";
        List<String> verifyList = new ArrayList<>();
        for (String word : respond.split(" ")) {
            verifyList.add(word.toLowerCase());
        }

        for (int i = 0; i < verifyList.size(); i++) {
            if (verifyList.get(i).equalsIgnoreCase("I")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).matches("I[,?:'; ]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("am")) {
                verifyList.set(i, "are");
            }
            if (verifyList.get(i).equalsIgnoreCase("my")) {
                verifyList.set(i, "your");
            }
            if (verifyList.get(i).matches("my[,?:'; ]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("me")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).matches("me[,?:'; ]")) {
                verifyList.set(i, StringWithSymbol(verifyList.get(i)));
            }
        }

        for (int i = 0; i < verifyList.size(); i++) {
            result += verifyList.get(i) + " ";
        }
        return result.toUpperCase();
    }

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
//        stringHistory.add(holders2.toString());
        return holders2.toString();
    }

    private static String StringWithSymbol(String word) {
        String result = "";
        switch (word) {
            case "I,":
            case "me,":
                result = "you,";
                break;
            case "I:":
            case "me:":
                result = "you:";
                break;
            case "I;":
            case "me;":
                result = "you;";
                break;
            case "I?":
            case "me?":
                result = "you?";
                break;
            case "I'":
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
            case "is,":
                result = "are,";
                break;
            case "is:":
                result = "are:";
                break;
            case "is;":
                result = "are;";
                break;
            case "is?":
                result = "are?";
                break;
            case "is'":
                result = "are'";
                break;
        }
        return result;
    }

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