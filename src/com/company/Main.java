package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String HEDGE_1 = "Please tell me more";
    private static final String HEDGE_2 = "Many of my patients tell me the same thing";
    private static final String HEDGE_3 = "It is getting late, maybe we had better quit";
    private static final String QUANTIFIER_1 = "Why do you say that";
    private static final String QUANTIFIER_2 = "You seem to think that";
    private static final String QUANTIFIER_3 = "So, you are concerned that";

    public static void main(String[] args) {
//        String testCase;
        String respond;
        String echoRespond;
        String hedgeAndQuantifier;
        boolean loop = true;
        HelloToUser();
        while (loop) {
            System.out.println("Enter respond here or press Q to quit:");
            respond = new Scanner(System.in).nextLine();
            echoRespond = Echo(respond);
            hedgeAndQuantifier = RandomRespond();
            if (respond.equalsIgnoreCase("q")) {
                loop = false;
            }
            if (!respond.equalsIgnoreCase("q")
                    && (hedgeAndQuantifier.equals(HEDGE_1) || hedgeAndQuantifier.equals(HEDGE_2) || hedgeAndQuantifier.equals(HEDGE_3))) {
                System.out.println(hedgeAndQuantifier);
            }
            if (!respond.equalsIgnoreCase("q")
                    && (hedgeAndQuantifier.equals(QUANTIFIER_1) || hedgeAndQuantifier.equals(QUANTIFIER_2) || hedgeAndQuantifier.equals(QUANTIFIER_3))) {
                System.out.println(hedgeAndQuantifier + " " + echoRespond);
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
        String result1;
        String result2 = "";

        respond.toLowerCase();
        if (respond.contains("I") || respond.contains("i")) {
            result = respond.replaceAll("I", "you");
            if (result.contains("am") || result.contains("Am")) {
                result1 = result.replaceAll("am", "are");
                if (result1.contains("my") || result1.contains("My")) {
                    result2 = result1.replaceAll("my", "your");
                    if (result2.contains("me") || result2.contains("Me")) {
                        return result2.replaceAll("me", "you").toUpperCase();
                    }
                    if (!result2.contains("me") || !result2.contains("Me")) {
                        return result2.toUpperCase();
                    }
                }
                if (!result1.contains("my") || !result1.contains("My") ||
                        !result2.contains("me") || !result2.contains("Me")) {
                    return result1.toUpperCase();
                }
            }
        }
        if (respond.contains("my") || respond.contains("My")) {
            result1 = result.replaceAll("my", "your");
            if (result1.contains("me") || result1.contains("Me")) {
                return result1.replaceAll("me", "you").toUpperCase();
            }
            if (!result1.contains("me") || !result1.contains("Me")) {
                return result1.toUpperCase();
            }
        }
        if (respond.contains("me") || respond.contains("Me")) {
            result1 = result.replaceAll("me", "you");
            if (result1.contains("my") || result1.contains("My")) {
                return result1.replaceAll("my", "your").toUpperCase();
            }
            if (!result1.contains("my") || !result1.contains("My")) {
                return result1.toUpperCase();
            }
        }
        return respond.toUpperCase();
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
}