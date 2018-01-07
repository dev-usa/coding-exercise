package com.interview.src;

/**
 * BitOperations - performs checks to determine if a bit in nth position of a byte is set
 * Bit Wise Operations inspired from blog - http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
 */
public class BitOperations {

    /**
     * Checks if the bit at the nth position of a byte is set using the approach
     *  1. Shift byte representation of 1 (00000001) left by n positions
     *  2. Perform logical AND of input number with the result from step 1
     *  3. If the result is a non-zero value, the bit at nth position is set
     * @param number - byte to be checked
     * @param position - 0 based position / index of the byte to be checked if set (from right to left). Valid range is [0-7]
     * @return
     */
    public boolean checkIfNthBitSet(byte number, int position) {
        if(position > 7 || position < 0) {
            System.out.println("Invalid bit index to check. Byte is 8 bits. True developer style, valid range is [0-7] :)");
            throw new IndexOutOfBoundsException("Invalid bit index to check. Byte is 8 bits :)");
        }

        byte byteMask = (byte) (1 << position);
        if((number & byteMask) != 0) {
            System.out.println(formatWithOrdinals((byte) position) + " bit of " + number + "(" + formatToBinary(number) + ") is set");
            return true;
        }
        System.out.println(formatWithOrdinals((byte) position) + " bit of " + number + "(" + formatToBinary(number) + ") is NOT set");
        return false;
    }

    /**
     * Checks if the Most Significant Bit (MSB) or the High-Order Bit of a byte is set
     * This method uses fundamentals of 2's complement notation used by Java for byte representation in binary
     * MSB is the "sign bit" and any number less than 0 in the valid byte range should have the MSB set
     * @param number - byte to be checked
     * @param number
     * @return
     */
    public boolean checkMSBSet(byte number) {
        if(number < 0) {
            System.out.println("MSB of " + number + "(" + formatToBinary(number) + ") is set");
            return true;
        }
        System.out.println("MSB of " + number + "(" + formatToBinary(number) + ") is NOT set");
        return false;
    }

    /**
     * Checks if the Most Significant Bit (MSB) or the High-Order Bit of a byte is set using the "nth bit set" approach
     * @param number - byte to be checked
     * @param number
     * @return
     */
    public boolean checkMSBSetUsingIdx(byte number) {
        return checkIfNthBitSet(number,7);
    }

    /**
     * Checks if the Most Significant Bit (MSB) or the High-Order Bit of a byte is set using the approach -
     * 1. Convert the byte to a string in binary format
     * 2. Check if the string starts with 1
     * @param number - byte to be checked
     * @param number
     * @return
     */
    public boolean checkMSBSetUsingStringFormat(byte number) {
        String binaryStr = formatToBinary(number);
        if(binaryStr.startsWith("1")) {
            System.out.println("MSB of " + number + "(" + binaryStr + ") is set");
            return true;
        }
        System.out.println("MSB of " + number + "(" + binaryStr + ") is NOT set");
        return false;
    }

    /**
     * Utility method to convert byte to String (in binary representation)
     * Credits - https://stackoverflow.com/a/12310078/829542
     * @param number
     * @return
     */
    public String formatToBinary(byte number) {
        return String.format("%8s", Integer.toBinaryString(number & 0xFF)).replace(' ', '0');
    }

    /**
     * Utility method for the obsessive formatter in you
     * Adds the <a href="https://english.stackexchange.com/a/192805">ordinal</> for a byte.
     * @param number
     * @return
     */
    public String formatWithOrdinals(byte number) {
        String formattedNumber = String.valueOf(number);
        if((number % 10) == 0 || (number % 10) >= 4 || ((number % 100) >= 11 && (number % 100) <= 13)) {
            formattedNumber += "th";
        } else if ((number % 10) == 1) {
            formattedNumber += "st";
        } else if ((number % 10) == 2) {
            formattedNumber += "nd";
        } else if ((number % 10) == 3) {
            formattedNumber += "rd";
        }
        return formattedNumber;
    }
}
