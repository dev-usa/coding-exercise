package com.interview.src;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BitOperationsTests
 */
public class BitOperationsTest {

    BitOperations bitOps = null;

    @Before
    public void init() {
        bitOps = new BitOperations();
    }

    @Test
    public void testNthBitSet(){
        Assert.assertFalse(bitOps.checkIfNthBitSet((byte) 127,7));
        Assert.assertTrue(bitOps.checkIfNthBitSet((byte) 122,3));
        Assert.assertTrue(bitOps.checkIfNthBitSet((byte) -89,1));
        Assert.assertFalse(bitOps.checkIfNthBitSet((byte) -33,5));
        Assert.assertFalse(bitOps.checkIfNthBitSet((byte) 122,0));
        Assert.assertFalse(bitOps.checkIfNthBitSet((byte) 59,2));
    }

    @Test
    public void testMSBSet(){
        Assert.assertFalse(bitOps.checkMSBSet((byte) 127));
        Assert.assertFalse(bitOps.checkMSBSet((byte) 122));
        Assert.assertTrue(bitOps.checkMSBSet((byte) -33));
        Assert.assertTrue(bitOps.checkMSBSet((byte) -1));
        Assert.assertTrue(bitOps.checkMSBSet((byte) -2));
        Assert.assertTrue(bitOps.checkMSBSet((byte) -128));
        Assert.assertTrue(bitOps.checkMSBSet((byte) -127));
    }

    @Test
    public void testMSBSetUsingIdxApproach(){
        Assert.assertFalse(bitOps.checkMSBSetUsingIdx((byte) 127));
        Assert.assertFalse(bitOps.checkMSBSetUsingIdx((byte) 122));
        Assert.assertTrue(bitOps.checkMSBSetUsingIdx((byte) -33));
        Assert.assertTrue(bitOps.checkMSBSetUsingIdx((byte) -1));
        Assert.assertTrue(bitOps.checkMSBSetUsingIdx((byte) -2));  
        Assert.assertTrue(bitOps.checkMSBSetUsingIdx((byte) -128));
        Assert.assertTrue(bitOps.checkMSBSetUsingIdx((byte) -127));
    }

   @Test
   public void testMSBSetUsingStringFormatApproach(){
       Assert.assertFalse(bitOps.checkMSBSetUsingStringFormat((byte) 127));
       Assert.assertFalse(bitOps.checkMSBSetUsingStringFormat((byte) 122));
       Assert.assertTrue(bitOps.checkMSBSetUsingStringFormat((byte) -33));
       Assert.assertTrue(bitOps.checkMSBSetUsingStringFormat((byte) -1));
       Assert.assertTrue(bitOps.checkMSBSetUsingStringFormat((byte) -2));
       Assert.assertTrue(bitOps.checkMSBSetUsingStringFormat((byte) -128));
       Assert.assertTrue(bitOps.checkMSBSetUsingStringFormat((byte) -127));
   }

    @Test
    public void testFormatByteWithOrdinals(){
        Assert.assertEquals("121st", bitOps.formatWithOrdinals((byte) 121));
        Assert.assertEquals("29th", bitOps.formatWithOrdinals((byte) 29));
        Assert.assertEquals("22nd", bitOps.formatWithOrdinals((byte) 22));
        Assert.assertEquals("13th", bitOps.formatWithOrdinals((byte) 13));

        System.out.println((byte)(1 << 7));
    }
}
