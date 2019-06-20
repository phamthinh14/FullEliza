package com.company;

import java.util.*;

public class Main {
    private static final String HEDGE_1 = "Please tell me more";
    private static final String HEDGE_2 = "Many of my patients tell me the same thing";
    private static final String HEDGE_3 = "It is getting late, maybe we had better quit";
    private static final String QUANTIFIER_1 = "Why do you say that";
    private static final String QUANTIFIER_2 = "You seem to think that";
    private static final String QUANTIFIER_3 = "So, you are concerned that";
    public static final String ANSI_RED = "\u001B[31m";
    private static final List<String> stringHistory = new ArrayList<>();

    public static void main(String[] args) {
        String respond;
        String echoRespond;
        String hedgeAndQuantifier;
        String respondPigLatin;
        boolean loop = true;
        HelloToUser();
        while (loop) {
            System.out.println("Enter respond here or press Q to quit:");
            respond = new Scanner(System.in).nextLine();
            stringHistory.add(respond);
            if (respond.equalsIgnoreCase("red")) {
                if (respond.equalsIgnoreCase("pig")) {
                    respondPigLatin = PigLatin();
                    System.out.println(ANSI_RED + respondPigLatin);
                }
                echoRespond = Echo(respond);
                hedgeAndQuantifier = RandomRespond();
                if (respond.equalsIgnoreCase("q")) {
                    System.out.println(ANSI_RED + "***********************************************************");
                    System.out.println(ANSI_RED + "\t\t\tHISTORY OF THE CHAT");
                    stringHistory.forEach(x -> System.out.println(ANSI_RED + x));
                    loop = false;
                }
                if (!respond.equalsIgnoreCase("q")
                        && (hedgeAndQuantifier.equals(HEDGE_1) || hedgeAndQuantifier.equals(HEDGE_2) || hedgeAndQuantifier.equals(HEDGE_3))) {
                    System.out.println(ANSI_RED + hedgeAndQuantifier);
                    stringHistory.add(hedgeAndQuantifier);
                }
                if (!respond.equalsIgnoreCase("q")
                        && (hedgeAndQuantifier.equals(QUANTIFIER_1) || hedgeAndQuantifier.equals(QUANTIFIER_2) || hedgeAndQuantifier.equals(QUANTIFIER_3))) {
                    System.out.println(ANSI_RED + hedgeAndQuantifier + " " + echoRespond);
                    stringHistory.add(hedgeAndQuantifier + " " + echoRespond);
                }
            } else {
                if (respond.equalsIgnoreCase("pig")) {
                    respondPigLatin = PigLatin();
                    System.out.println(respondPigLatin);
                }
                echoRespond = Echo(respond);
                hedgeAndQuantifier = RandomRespond();
                if (respond.equalsIgnoreCase("q")) {
                    System.out.println("***********************************************************");
                    System.out.println("\t\t\tHISTORY OF THE CHAT");
                    stringHistory.forEach(System.out::println);
                    loop = false;
                }
                if (!respond.equalsIgnoreCase("q")
                        && (hedgeAndQuantifier.equals(HEDGE_1) || hedgeAndQuantifier.equals(HEDGE_2) || hedgeAndQuantifier.equals(HEDGE_3))) {
                    System.out.println(hedgeAndQuantifier);
                    stringHistory.add(hedgeAndQuantifier);
                }
                if (!respond.equalsIgnoreCase("q")
                        && (hedgeAndQuantifier.equals(QUANTIFIER_1) || hedgeAndQuantifier.equals(QUANTIFIER_2) || hedgeAndQuantifier.equals(QUANTIFIER_3))) {
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
        String result1 = "";
        String result2 = "";
        String space = " ";
        int index = 0;
        List<String> verifyList = new ArrayList<>();
        for (String word : respond.split(" ")) {
//            if (word.matches("[A-Za-z]")) {
                verifyList.add(word);
//                continue;
//            }
//            else {
//                verifyList.add(word);
//            }
        }



        for (int i = 0; i < verifyList.size(); i++) {
            if (verifyList.get(i).equalsIgnoreCase("I")&& verifyList.get(i).contains(",")) {

                    verifyList.set(i, "you");

            }

            if (verifyList.get(i).equalsIgnoreCase("am")) {
                verifyList.set(i, "are");
            }
            if (verifyList.get(i).equalsIgnoreCase("my")) {
                verifyList.set(i, "your");
            }
            if (verifyList.get(i).equalsIgnoreCase("me")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).equalsIgnoreCase("me") && verifyList.get(i).substring(1).equalsIgnoreCase(",")) {
                verifyList.set(i, "you");
            }
        }
//        System.out.println(verifyList);
//        respond.toLowerCase();
        for (int i = 0; i < verifyList.size(); i++) {
            result += verifyList.get(i) + " ";
        }
        return result;
//        if (respond.contains("I") || respond.contains("i")) {
//            result = respond.replaceAll("I", "you");
//            if (result.contains("am") || result.contains("Am")) {
//
//                result1 = result.replaceAll("am", "are");
//
//                if (result1.contains("my") || result1.contains("My")) {
//                    result2 = result1.replaceAll("my", "your");
//                    if (result2.contains("me") || result2.contains("Me")) {
//                        return result2.replaceAll("me", "you").toUpperCase();
//                    }
//                    if (!result2.contains("me") || !result2.contains("Me")) {
//                        return result2.toUpperCase();
//                    }
//                }
//                if (!result1.contains("my") || !result1.contains("My") ||
//                        !result2.contains("me") || !result2.contains("Me")) {
//                    return result1.toUpperCase();
//                }
//            }
//            if (!result.contains("am") || !result.contains("Am")) {
//                if (result.contains("my") || result.contains("My")) {
//                    result1 = result.replaceAll("my", "your");
//                    if (result1.contains("me") || result1.contains("Me")) {
//                        return result1.replaceAll("me", "you").toUpperCase();
//                    }
//                    if (!result1.contains("me") || !result1.contains("Me")) {
//                        return result1.toUpperCase();
//                    }
//
//                }
//                if (!result.contains("my") || result.contains("My")) {
//                    if (result.contains("me") || result.contains("Me")) {
//                        return result.replaceAll("me", "you").toUpperCase();
//                    }
//                    if (result.contains("me") || result.contains("Me")) {
//                        return result.toUpperCase();
//                    }
//                }
//                return result.toUpperCase();
//            }
//        }
//
//        if (respond.contains("my") || respond.contains("My")) {
//            result1 = result.replaceAll("my", "your");
//            if (result1.contains("me") || result1.contains("Me")) {
//                return result1.replaceAll("me", "you").toUpperCase();
//            }
//            if (!result1.contains("me") || !result1.contains("Me")) {
//                return result1.toUpperCase();
//            }
//            if (result1.contains("am"))
//                return result1.toUpperCase();
//
//        }
//        if (respond.contains("me") || respond.contains("Me")) {
//            result1 = result.replaceAll("me", "you");
//            if (result1.contains("my") || result1.contains("My")) {
//                return result1.replaceAll("my", "your").toUpperCase();
//            }
//            if (!result1.contains("my") || !result1.contains("My")) {
//                return result1.toUpperCase();
//            }
//            if (result1.contains("am"))
//                return result1.toUpperCase();
//
//        }
//        return respond.toUpperCase();
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
        stringHistory.add(holders2.toString());
        return holders2.toString();
    }

    private static void Game() {

    }
}