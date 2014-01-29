package com.nps.koan.primitives;

import com.nps.koan.fixture.KoanRunner;
import com.nps.koan.fixture.annotation.Koan;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas_smith
 * Date: 29/05/13
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */

@RunWith(KoanRunner.class)
public class PrimitiveBasics {

    byte byte8Bit; short short16Bit; int int32Bit; long long64Bit; float float32Bit; double double64bit;
    char char16Bit; boolean bool;

    @Koan
    public void reflectOnHowToInitializePrimitivesWithLiteralsAndGainInsightIntoDefaultValues(){

        /* (@_@)  Begin Meditation */
        byte8Bit = 100;
        short16Bit = 100;
        int32Bit = 100;
        long64Bit = 100;
        float32Bit = 100.00f;
        double64bit = 100.00;
        char16Bit = 'C';
        bool = true;
        /* (^_^)  Complete Meditation */

        assertThat(byte8Bit, is(not((byte)0)));
        assertThat(short16Bit, is(not((short)0)));
        assertThat(int32Bit, is(not(0)));
        assertThat(long64Bit, is(not((long)0)));
        assertThat(float32Bit, is(not((float)0)));
        assertThat(double64bit, is(not((double)0)));
        assertThat(char16Bit, is(not('\u0000')));
        assertThat(bool, is(not(false)));
    }


    @Koan
    public void reflectOnMinimumAndMaximumByteValues(){
        byte maximumByteValue = 0;
        byte minimumByteValue = 0;

        /* (@_@)  */
        maximumByteValue = Byte.MAX_VALUE;
        minimumByteValue = Byte.MIN_VALUE;
        /* (^_^)  */

        assertThat(maximumByteValue, is((byte)127));
        assertThat(minimumByteValue, is((byte)-128));
    }


    // -2,147,483,648 to 2,147,483,647
    // 2^31 -1
    // 0x7fffffff
    // http://www.escapistmagazine.com/forums/read/7.829855-GTA-V-2-147-483-647-Glitch-Could-Wipe-Your-Cash-Away
    @Koan
    public void reflectOnMinimumAndMaximumIntValues(){

        int maximumIntValue = 0;
        int minimumIntValue = 0;

        /* (@_@)  */
        maximumIntValue = Integer.MAX_VALUE;
        minimumIntValue = Integer.MIN_VALUE;
        /* (^_^)  */

        assertThat(maximumIntValue, is(2147483647));
        assertThat(minimumIntValue, is(-2147483648));
    }

    @Koan
    public void reflectOnMinimumAndMaximumDoubleValues(){
        double maximumDoubleValue = 0;
        double minimumDoubleValue = 0;

        /* (@_@)  */
        maximumDoubleValue = Double.MAX_VALUE;
        minimumDoubleValue = Double.MIN_VALUE;
        /* (^_^)  */

        assertThat(maximumDoubleValue, is(1.7976931348623157e+308));
        assertThat(minimumDoubleValue, is(4.9e-324));
    }

    @Koan
    public void reflectOnCharactersAlsoHaveMinimumAndMaximumValues(){
        char maximumCharValue = '\u0001';
        char minimumCharValue = '\u0001';

        /* (@_@)  */
        maximumCharValue = Character.MAX_VALUE;
        minimumCharValue = Character.MIN_VALUE;
        /* (^_^)  */

        assertThat(maximumCharValue, is('\uffff'));
        assertThat(minimumCharValue, is('\u0000'));
    }

    @Koan
    public void reflectOnCharMinimumAndMaximumValues(){
        char maximumCharValue = '\u0001';
        char minimumCharValue = '\u0001';

        /* (@_@)  */
        maximumCharValue = Character.MAX_VALUE;
        minimumCharValue = Character.MIN_VALUE;
        /* (^_^)  */

        assertThat(maximumCharValue, is('\uffff'));
        assertThat(minimumCharValue, is('\u0000'));
    }

    @Koan
    public void reflectOnEqualityForPrimitives(){
        int valueA = 0;
        int valueB = 1;

        /* (@_@)  */
        valueA = 1;
        /* (^_^)  */

        assertEquals(valueA, valueB);
    }

    @Koan
    public void reflectOnBoxedPrimitivesAreUnBoxedForEvaluationWithPrimitive(){
        Integer valueA = null;
        int valueB = 999;

        /* (@_@)  */
        valueA = 999;
        /* (^_^)  */

        assertTrue(valueA == valueB);
        assertTrue(valueA.intValue() == valueB);
    }


    @Koan
    public void reflectOnTwoBoxedPrimitivesEvaluateByReference(){
        Integer valueA = 999;
        Integer valueB = 555;

        /* (@_@)  */
        valueB = 999;
        /* (^_^)  */

        assertTrue(valueA != valueB);
    }

    @Koan
    public void reflectOnEqualityForBoxedPrimitives(){
        Double valueA = 1.00;
        Double valueB = 0.00;

        /* (@_@)  */
        valueB = 1.00;
        /* (^_^)  */

        assertEquals(valueA, valueB);
    }

    // Cached reference -128 to 127  http://tech.puredanger.com/2007/02/01/valueof/
    @Koan
    public void reflectOnIntegersHaveCachedValues(){
        Integer valueA = 1;
        Integer valueB = 0;

        /* (@_@)  */
        valueB = 1;
        /* (^_^)  */

        assertTrue(valueA == valueB);
    }

    @Koan
    public void reflectOnDifferentObjectIdsForBoxedPrimitives(){
        Integer valueA = 200;
        Integer valueB = 0;

        /* (@_@)  */
        valueB = 200;
        /* (^_^)  */

        assertFalse(valueA == valueB);
    }

    static Integer boxedInt;

    @Koan
    public void reflectOnNullPointersWhenUnboxingIntegers(){

        try {
            /* (@_@)  */
            if(boxedInt > 9){
                fail("Should have thrown null pointer");
            }
            /* (^_^)  */
        } catch (NullPointerException e){
            assertTrue(e instanceof NullPointerException);
        }

    }

    static int primitiveInt;

    @Koan
    public void reflectOnSaferToFavouringAPrimitive(){

        try {
            /* (@_@) */
            if(primitiveInt != 0){
                fail("Uninitialised int should be zero");
            }
            /* (^_^) */
        } catch (Exception e){
            fail("Should not have thrown an exception");
        }
    }

    @Koan
    public void reflectOnUnnecessaryBoxingTakesALongTime(){
        long sum = 0L;
        long sumStartTime = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long sumDuration = System.currentTimeMillis() - sumStartTime;

        Long boxedSum = 0L;
        long boxedSumStartTime = System.currentTimeMillis();

        /* (@_@) */
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            boxedSum += i;
        }
        long boxedSumDuration = System.currentTimeMillis() - boxedSumStartTime;
        /* (^_^) */

        System.out.println("boxedSumDuration: " + boxedSumDuration + " sumDuration: " + sumDuration);

        assertTrue(boxedSumDuration > sumDuration);
    }

}
