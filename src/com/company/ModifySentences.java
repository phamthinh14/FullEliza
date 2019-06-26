package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ModifySentences {

    public ModifySentences() {
    }

    /**
     * Change I and me -> you, am -> are, and my -> your
     *
     * @param respond user input
     * @return result of a String with the changes of I and me -> you, am -> are, and my -> your
     */
    public String ModifyWords(String respond) {
        String result = "";
        List<String> verifyList = new ArrayList<>();
        //This loop will take the user input and delete all the spaces between words
        //This also means if a word has a symbol behind it, the word will be add to the verifyList
        for (String word : respond.split(" ")) {
            verifyList.add(word.toLowerCase());
        }
        //This loop is to change Change I and me -> you, am -> are, and my -> your
        //The regular expression i[,?:';] means if a word has i and a symbols such as: , ? : ' ; the match will return true
        //the word would be pass to ModifyStringWithSymbol(verifyList.get(i))
        // to modify I, me, my, and am with symbols at the end into you, you, your, and are with original symbols
        for (int i = 0; i < verifyList.size(); i++) {
            if (verifyList.get(i).equalsIgnoreCase("I")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).matches("i[,?:';]")) {
                verifyList.set(i, ModifyStringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("am")) {
                verifyList.set(i, "are");
            }
            if (verifyList.get(i).matches("am[,?:';]")) {
                verifyList.set(i, ModifyStringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("my")) {
                verifyList.set(i, "your");
            }
            if (verifyList.get(i).matches("my[,?:';]")) {
                verifyList.set(i, ModifyStringWithSymbol(verifyList.get(i)));
            }
            if (verifyList.get(i).equalsIgnoreCase("me")) {
                verifyList.set(i, "you");
            }
            if (verifyList.get(i).matches("me[,?:';]")) {
                verifyList.set(i, ModifyStringWithSymbol(verifyList.get(i)));
            }
        }
        //After I and me -> you, am -> are, and my -> your and all the symbols changes.
        // The result will be assign to the variable result in uppercase to display on the screen
        for (int i = 0; i < verifyList.size(); i++) {
            result += verifyList.get(i) + " ";
        }
        return result.toUpperCase();
    }

    /**
     * This method will modify I, me, my, and am with symbols at the end into you, you, your, and are with original symbols
     * which was provided by the user
     *
     * @param word I, me, my, and am with symbols at the end
     * @return you, you, your, and are with original symbols
     */
    private String ModifyStringWithSymbol(String word) {
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
     * This method helps Eliza to speak Pig Latin
     *
     * @return If the first letter is a consonant, add "ay" to the end
     * If the first letter is a vowel, add "way" or "tay" to the end
     */
    public String ModifyToPigLatin(String prompt) {
        final String AY = "AY";
        final String WAY = "WAY";
        final String TAY = "TAY";
        final String SPACE = " ";
        int randomNum;
        StringBuilder holders2 = new StringBuilder();
        List<String> wordArrayList = new ArrayList<>();

        String[] split = prompt.split(" ");
        Collections.addAll(wordArrayList, split);
// This loop is to add "ay" to the end of consonant
// add "way" or "tay" randomly to the end vowel
        for (String word : wordArrayList) {
            if (word.toLowerCase().startsWith("a")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.toLowerCase().startsWith("e")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.toLowerCase().startsWith("i")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.toLowerCase().startsWith("o")) {
                holders2.append(word).append(AY).append(SPACE);
            } else if (word.toLowerCase().startsWith("u")) {
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
