package com.interview.src;

public class Palindrome {

    /**
     * Checks if the input string is a Palindrome -
     *
     * 1. By comparing the edge characters on both sides of the input string (Char at [0] == Char at [string.length()]
     * 2. If they match, iteratively check the characters inner of the edge (Char at [1] == Char at [string.length()-1])
     * 3. They checking continues till all character's in nth position of the string is compared
     * against [string.length()-n] th character
     * 4. If all are matching, this method returns a true, else a false
     *
     * @param stripSplChars - Strips special characters from the input string if "stripSplChars" is set to true
     * and proceeds to perform Palindrome Check. If "stripSplChars" is set to false and the inputString has
     * special characters, this method returns false for the palindrome check
     * @param inputString
     * @return
     */
    public static boolean checkByFullIteration(String inputString, boolean stripSplChars) {

        if (inputString==null || (!stripSplChars && !isAlphaNumeric(inputString))){
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputString + "\"" + " is NOT a palindrome");
            return false;
        }

        String inputStringCopy = inputString;
        inputString = sanitize(inputString, stripSplChars);

        int n = inputString.length();
        for (int i = 0; i < n; ++i) {
            if (inputString.charAt(i) != inputString.charAt(n-i-1)) {
                System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is NOT a palindrome");
                return false;
            }
        }

        System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is a palindrome");
        return true;
    }

    /**
     * Makes the assumption that the string does NOT have any special characters
     *
     * 1. By comparing the edge characters on both sides of the input string (Char at [0] == Char at [string.length()]
     * 2. If they match, iteratively check the characters inner of the edge (Char at [1] == Char at [string.length()-1])
     * 3. They checking continues till all character's in nth position of the string is compared
     * against [string.length()-n] th character
     * 4. If all are matching, this method returns a true, else a false
     *
     * @param inputString
     * @return
     */
    public static boolean checkByFullIteration(String inputString) {
        return checkByFullIteration(inputString, false);
    }

    /**
     * Checks if the input string is a Palindrome -
     *
     * 1. By comparing the edge characters on both sides of the input string (Char at [0] == Char at [string.length()]
     * 2. If they match, iteratively check the characters inner of the edge (Char at [1] == Char at [string.length()-1])
     * 3. If the edges on both sides of the center of the string match, the string is considered a palindrome
     *
     * @param stripSplChars - Strips special characters from the input string if "stripSplChars" is set to true
     * and proceeds to perform Palindrome Check. If "stripSplChars" is set to false and the inputString has
     * special characters, this method returns false for the palindrome check
     * @param inputString
     * @return
     */
    public static boolean checkByHalfIteration(String inputString, boolean stripSplChars) {

        if (inputString==null || (!stripSplChars && !isAlphaNumeric(inputString))){
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputString + "\"" + " is NOT a palindrome");
            return false;
        }

        String inputStringCopy = inputString;
        inputString = sanitize(inputString, stripSplChars);

        int strLen = inputString.length();
        for( int i = 0; i < strLen/2; i++ ) {
            if (inputString.charAt(i) != inputString.charAt(strLen - i - 1)) {
                System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is NOT a palindrome");
                return false;
            }
        }

        System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is a palindrome");
        return true;
    }

    /**
     * Makes the assumption that the string does NOT have any special characters
     *
     * Checks if the input string is a Palindrome -
     * 1. By comparing the edge characters on both sides of the input string (Char at [0] == Char at [string.length()]
     * 2. If they match, iteratively check the characters inner of the edge (Char at [1] == Char at [string.length()-1])
     * 3. If the edges on both sides of the center of the string match, the string is considered a palindrome
     *
     * @param inputString
     * @return
     */
    public static boolean checkByHalfIteration(String inputString) {
        return checkByHalfIteration(inputString, false);
    }

    /**
     * Checks if the input string is a palindrome by comparing -
     *
     * 1. Reversing the string using StringBuffer's builtin method
     * 2. Comparing string equality
     *
     * @param stripSplChars - Strips special characters from the input string if "stripSplChars" is set to true
     * and proceeds to perform Palindrome Check. If "stripSplChars" is set to false and the inputString has
     * special characters, this method returns false for the palindrome check
     * @param inputString
     * @return
     */
    public static boolean checkByReversal(String inputString, boolean stripSplChars) {

        if (inputString==null || (!stripSplChars && !isAlphaNumeric(inputString))){
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputString + "\"" + " is NOT a palindrome");
            return false;
        }

        String inputStringCopy = inputString;
        inputString = sanitize(inputString, stripSplChars);

        boolean equals = inputString.equals(new StringBuilder(inputString).reverse().toString());

        if(equals)
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is a palindrome");
        else
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is NOT a palindrome");

        return equals;
    }

    /**
     * Assumption: The inputString does NOT have any special characters
     *
     * Checks if the input string is a palindrome by comparing -
     * 1. Reversing the string using StringBuffer's builtin method
     * 2. Comparing string equality
     *
     * @param inputString
     * @return
     */
    public static boolean checkByReversal(String inputString) {
        return checkByReversal(inputString, false);
    }

    /**
     * Checks if the input string is a palindrome using recursion
     *
     * 1. checks the edge characters of the string
     * 2. if characters match, recursively checks the characters inner to the edge till all the characters
     * towards the center of the string are compared
     * 3. if characters do not match, return false
     *
     * @param stripSplChars - Strips special characters from the input string if "stripSplChars" is set to true
     * and proceeds to perform Palindrome Check. If "stripSplChars" is set to false and the inputString has
     * special characters, this method returns false for the palindrome check
     * @param inputString
     * @return
     */
    public static boolean checkByRecursion(String inputString, boolean stripSplChars) {

        if (inputString==null || (!stripSplChars && !isAlphaNumeric(inputString))){
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputString + "\"" + " is NOT a palindrome");
            return false;
        }

        String inputStringCopy = inputString;
        inputString = sanitize(inputString, stripSplChars);

        int length = inputString.length();

        if (length < 2) {
            System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is a palindrome");
            return true;
        }
        else {
            boolean equals = inputString.charAt(0) != inputString.charAt(length - 1) ? false :
                    checkByRecursion(inputString.substring(1, length - 1), false);

            if(equals)
                System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is a palindrome");
            else
                System.out.println("StripSplChars = " + stripSplChars + "\t | \"" + inputStringCopy + "\"" + " is NOT a palindrome");

            return equals;
        }
    }

    /**
     * Assumption: The inputString does NOT have any special characters
     *
     * Checks if the input string is a palindrome using recursion
     *
     * 1. checks the edge characters of the string
     * 2. if characters match, recursively checks the characters inner to the edge till all the characters
     * towards the center of the string are compared
     * 3. if characters do not match, return false
     *
     * @param inputString
     * @return
     */
    public static boolean checkByRecursion(String inputString) {
        return checkByRecursion(inputString, false);
    }

    private static String sanitize(String inputString, boolean stripSplChars) {
        if(stripSplChars) {
            inputString = inputString.replaceAll("[\\W]", "");
        }
        return inputString.toLowerCase();
    }

    /**
     * Checks if the input string has any special characters or has only [A-Z,a-z,0-9,\\s]
     *
     * @param inputString
     * @return
     */
    public static boolean isAlphaNumeric(String inputString) {
        return inputString.chars().allMatch(value -> {
            if (Character.isLetterOrDigit((char) value) || Character.isWhitespace((char) value)) {
                //System.out.println("input = \"" + inputString + "\"" + " has special characters");
                return true;
            }
            return false;
        });
    }
}
