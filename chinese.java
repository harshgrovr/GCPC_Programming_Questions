
public class chinese
{
    /*
     * performs the Euclidean algorithm on a and b to find a pair of coefficients
     * (stored in the output array) that correspond to x and y in the equation
     * ax + by = gcd(a,b)
     * constralong: a > b
     */
    public static long[] euclidean(long a, long b)
    {
        if(b > a)
        {
            //reverse the order of inputs, run through this method, then reverse outputs
            long[] coeffs = euclidean(b, a);
            long[] output = {coeffs[1], coeffs[0]};
            return output;
        }

        long q = a/b;
        //a = q*b + r --> r = a - q*b
        long r = a -q*b;

        //when there is no remainder, we have reached the gcd and are done
        if(r == 0)
        {
            long[] output = {0, 1};
            return output;
        }

        //call the next iteration down (b = qr + r_2)
        long[] next = euclidean(b, r);

        long[] output = {next[1], next[0] - q*next[1]};
        return output;
    }

    //finds the least positive longeger equivalent to a mod m
    public static long leastPosEquiv(long a, long m)
    {
        //a eqivalent to b mod -m <==> a equivalent to b mod m
        if(m < 0)
            return leastPosEquiv(a, -1*m);
        //if 0 <= a < m, then a is the least positive longeger equivalent to a mod m
        if(a >= 0 && a < m)
            return a;

        //for negative a, find the least negative longeger equivalent to a mod m
        //then add m
        if(a < 0)
            return -1*leastPosEquiv(-1*a, m) + m;

        //the only case left is that of a,m > 0 and a >= m

        //take the remainder according to the Division algorithm
        long q = a/m;

        /*
         * a = qm + r, with 0 <= r < m
         * r = a - qm is equivalent to a mod m
         * and is the least such non-negative number (since r < m)
         */
        return a - q*m;
    }

    public static void main(String[] args)
    {
        /*
         * the current setup finds a number x such that:
         *	x = 2 mod 5, x = 3 mod 7, x = 4 mod 9, and x = 5 mod 11
         * note that the values in mods must be mutually prime
         */
        long[] constralongs = {12,14,5,44,21,30,4,3,0,12,4,9,0,33,0}; //put modular contralongs here
        long[] mods = {13,23,7,47,31, 41, 37, 29, 5,19,11, 17, 2,43, 3}; //put moduli here

        //M is the product of the mods
        long M = 1;
        for(long i = 0; i < mods.length; i++)
            M *= mods[(int) i];

        long[] multInv = new long[constralongs.length];

        /*
         * this loop applies the Euclidean algorithm to each pair of M/mods[i] and mods[i]
         * since it is assumed that the various mods[i] are pairwise coprime,
         * the end result of applying the Euclidean algorithm will be
         * gcd(M/mods[i], mods[i]) = 1 = a(M/mods[i]) + b(mods[i]), or that a(M/mods[i]) is
         * equivalent to 1 mod (mods[i]). This a is then the multiplicative
         * inverse of (M/mods[i]) mod mods[i], which is what we are looking to multiply
         * by our constralong constralongs[i] as per the Chinese Remainder Theorem
         * euclidean(M/mods[i], mods[i])[0] returns the coefficient a
         * in the equation a(M/mods[i]) + b(mods[i]) = 1
         */
        for(long i = 0; i < multInv.length; i++)
            multInv[(int) i] = euclidean(M/mods[(int) i], mods[(int) i])[0];

        long x = 0;

        //x = the sum over all given i of (M/mods[i])(constralongs[i])(multInv[i])
        for(long i = 0; i < mods.length; i++)
            x += (M/mods[(int) i])*constralongs[(int) i]*multInv[(int) i];

        x = leastPosEquiv(x, M);

        System.out.println("x is equivalent to " + x + " mod " + M);
    }
}