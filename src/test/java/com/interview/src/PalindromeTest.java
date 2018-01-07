package com.interview.src;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {
    Palindrome palindrome = null;

    @Test
    public void testCheckPalindromeByFullIteration() {

        // Without stripping special characters
        Assert.assertFalse(palindrome.checkByFullIteration("Niagara. O roar again!"));
        Assert.assertFalse(palindrome.checkByFullIteration("A man, a plan, a canal, Panama!"));
        Assert.assertFalse(palindrome.checkByFullIteration("Was it a car or a cat I saw?"));
        Assert.assertFalse(palindrome.checkByFullIteration("No 'x' in Nixon"));
        Assert.assertFalse(palindrome.checkByFullIteration("Madam, I'm Adam."));

        // Stripping special characters and checking for palindrome
        Assert.assertTrue(palindrome.checkByFullIteration("Niagara. O roar again!", true));
        Assert.assertTrue(palindrome.checkByFullIteration("A man, a plan, a canal, Panama!", true));
        Assert.assertTrue(palindrome.checkByFullIteration("Was it a car or a cat I saw?", true));
        Assert.assertTrue(palindrome.checkByFullIteration("No 'x' in Nixon", true));
        Assert.assertTrue(palindrome.checkByFullIteration("Madam, I'm Adam.",true));
    }

    @Test
    public void testCheckPalindromeByHalfIteration() {

        // Without stripping special characters
        Assert.assertFalse(palindrome.checkByHalfIteration("Niagara. O roar again!"));
        Assert.assertFalse(palindrome.checkByHalfIteration("A man, a plan, a canal, Panama!"));
        Assert.assertFalse(palindrome.checkByHalfIteration("Was it a car or a cat I saw?"));
        Assert.assertFalse(palindrome.checkByHalfIteration("No 'x' in Nixon"));
        Assert.assertFalse(palindrome.checkByHalfIteration("Madam, I'm Adam."));

        // Stripping special characters and checking for palindrome
        Assert.assertTrue(palindrome.checkByHalfIteration("Niagara. O roar again!", true));
        Assert.assertTrue(palindrome.checkByHalfIteration("A man, a plan, a canal, Panama!", true));
        Assert.assertTrue(palindrome.checkByHalfIteration("Was it a car or a cat I saw?", true));
        Assert.assertTrue(palindrome.checkByHalfIteration("No 'x' in Nixon", true));
        Assert.assertTrue(palindrome.checkByHalfIteration("Madam, I'm Adam.",true));
    }

    @Test
    public void testCheckPalindromeByReversal() {

        // Without stripping special characters
        Assert.assertFalse(palindrome.checkByReversal("Niagara. O roar again!"));
        Assert.assertFalse(palindrome.checkByReversal("A man, a plan, a canal, Panama!"));
        Assert.assertFalse(palindrome.checkByReversal("Was it a car or a cat I saw?"));
        Assert.assertFalse(palindrome.checkByReversal("No 'x' in Nixon"));
        Assert.assertFalse(palindrome.checkByReversal("Madam, I'm Adam."));

        // Stripping special characters and checking for palindrome
        Assert.assertTrue(palindrome.checkByReversal("Niagara. O roar again!", true));
        Assert.assertTrue(palindrome.checkByReversal("A man, a plan, a canal, Panama!", true));
        Assert.assertTrue(palindrome.checkByReversal("Was it a car or a cat I saw?", true));
        Assert.assertTrue(palindrome.checkByReversal("No 'x' in Nixon", true));
        Assert.assertTrue(palindrome.checkByReversal("Madam, I'm Adam.",true));
    }

    @Test
    public void testCheckPalindromeByRecursion() {

        // Without stripping special characters
        Assert.assertFalse(palindrome.checkByRecursion("Niagara. O roar again!"));
        Assert.assertFalse(palindrome.checkByRecursion("A man, a plan, a canal, Panama!"));
        Assert.assertFalse(palindrome.checkByRecursion("Was it a car or a cat I saw?"));
        Assert.assertFalse(palindrome.checkByRecursion("No 'x' in Nixon"));
        Assert.assertFalse(palindrome.checkByRecursion("Madam, I'm Adam."));

        // Stripping special characters and checking for palindrome
        Assert.assertTrue(palindrome.checkByRecursion("Niagara. O roar again!", true));
        Assert.assertTrue(palindrome.checkByRecursion("A man, a plan, a canal, Panama!", true));
        Assert.assertTrue(palindrome.checkByRecursion("Was it a car or a cat I saw?", true));
        Assert.assertTrue(palindrome.checkByRecursion("No 'x' in Nixon", true));
        Assert.assertTrue(palindrome.checkByRecursion("Madam, I'm Adam.",true));
    }

    @Test
    public void testIsAlphaNumeric() {
        Assert.assertTrue(palindrome.isAlphaNumeric("sarat1"));
        Assert.assertTrue(palindrome.isAlphaNumeric("sarat chandra"));
        Assert.assertFalse(palindrome.isAlphaNumeric("sarat!"));
        Assert.assertTrue(palindrome.isAlphaNumeric("awesome"));
    }
}
