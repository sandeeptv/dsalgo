package com.dsalgo.problems.other;

public class BitwiseOperators {

    public int Add(int x, int y) {
        // Iterate till there is no carry
        while (y != 0) {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }


    public int subtractNumber(int i, int j) {
        while (j != 0) {
            int carry = (~i) & j;
            i = i ^ j;
            j = carry << 1;
        }
        return i;
    }


    public int multiplyNumber(int a, int b) {
        // 0 multiplied with 0 is 0
        if (b == 0)
            return 0;
        // adding variable a one by one
        if (b > 0)
            return (a + multiplyNumber(a, b - 1));
        // here's the case where b is negative
        if (b < 0)
            return -multiplyNumber(a, -b);
        return -1;
    }
    }
