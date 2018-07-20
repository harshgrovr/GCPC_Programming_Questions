
// A Java program to demonstrate
// working of Chinise remainder
// Theorem
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class chinese_remainder_theorm {

    // Returns modulo inverse of a
    // with respect to m using extended
    // Euclid Algorithm. Refer below post for details:
    // https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
    static long inv(long a, long m) {
        long m0 = m, t, q;
        long x0 = 0, x1 = 1;

        if (m == 1)
            return 0;

        // Apply extended Euclid Algorithm
        while (a > 1) {
            // q is quotient
            q = a / m;

            t = m;

            // m is remainder now, process
            // same as euclid's algo
            m = a % m;
            a = t;

            t = x0;

            x0 = x1 - q * x0;

            x1 = t;
        }

        // Make x1 positive
        if (x1 < 0)
            x1 += m0;

        return x1;
    }

    // k is size of num[] and rem[].
    // Returns the smallest number
    // x such that:
    // x % num[0] = rem[0],
    // x % num[1] = rem[1],
    // ..................
    // x % num[k-2] = rem[k-1]
    // Assumption: Numbers in num[] are pairwise
    // coprime (gcd for every pair is 1)
    static long findMinX(Long[] num, Long[] rem, long k) {
        // Compute product of all numbers
        long prod = 1;
        for (long i = 0; i < k; i++)
            prod *= num[(int) i];

        // Initialize result
        long result = 0;
        BigInteger result_1 = new BigInteger("0");
        // Apply above formula
        for (int i = 0; i < k; i++) {
            long pp = (long) (prod / num[i]);
           //System.out.println(inv(pp,(num[i]))*pp+" "+pp+"  "+rem[i]);

            //result_1=BigInteger.valueOf(rem[i] * inv(pp, (num[i])) * pp);
            result_1=result_1.add(BigInteger.valueOf(rem[i] * inv(pp, (num[i])) * pp));
            //result= result_1;
            //System.out.println(result_1);
        }

        return  result_1.mod(BigInteger.valueOf(prod)).longValue();
        //return result_1 % BigInteger.valueOf(prod);
    }

    // Driver method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        for (long j = 0; j < t; j++) {
            long count=j;
            long n = sc.nextLong();
            long k = sc.nextLong();
            long max = 0;
            if (n != 0) {
                ArrayList<Long> rest = new ArrayList<>();
                ArrayList<Long> size = new ArrayList<>();
                ArrayList<ArrayList<Long>> collection = new ArrayList<>();
                long n1 = 0, k1 = 0;
                for (long i = 0; i < n; i++) {
                    n1 = sc.nextLong();
                    k1 = sc.nextLong();
                    size.add(n1);
                    rest.add(k1);
                }
                Long[] num = new Long[rest.size()];
                num = size.toArray(num);
                Long[] rem = new Long[rest.size()];
                rem = rest.toArray(rem);

                long length_h = num.length;

                long result=0;
                long number=0;
                long x=findMinX(num, rem, length_h);
                long lcm=lcm_of_array_elements(num);
                if(x>0) {
                    if (lcm > k && x > k) {
                        System.out.println("Case #" + (++count) + ": impossible");
                    } else if (lcm > k && x <= k) {
                        System.out.println("Case #" + (++count) + ": " + x);
                    } else {
                        while (true) {
                            number++;
                            if ((lcm * number) + x <= k) {
                                result = (lcm * number) + x;
                            } else
                                break;
                        }
                        if (result == 0)
                            System.out.println("Case #" + (++count) + ": " + x);
                        else
                            System.out.println("Case #" + (++count) + ": " + result);
                    }
                }
                else {
                    result=k+x;
                    System.out.println("Case #" + (++count) + ": " + result);
                }
            }
        }
    }


    public static long lcm_of_array_elements(Long[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }
}
