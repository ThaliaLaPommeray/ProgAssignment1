// Thalia La Pommeray

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ProgAssign1 {

    public static long totalPrimeCount;
    public static long sumofPrime;
    private static volatile boolean[] prime;
    public static volatile long current;
    private static volatile long n;

    public static class myrun implements Runnable {

        @Override
        public synchronized void run() {
            isPrime(current);
            if (current == 2) current++;
            else current+=2;
        }

    }
    private static synchronized void isPrime(long p) {
            if ((p<n) && prime[(int)p]){
               // System.out.println(p);
                totalPrimeCount++;
                sumofPrime+=p;
                // Update all multiples of p
                for (long i = p * p; i <= n; i += p)
                    prime[(int)i] = false;
            }
        }

    public static void main(String[] args) throws InterruptedException {


        n = 100000;
        prime = new boolean[(int)n+1];
        long[] topTen = new long[10];
        int count = 9;
        Thread[] threads = new Thread[8];

        for (long i = 0; i <= n; i++){
            prime[(int)i] = true;
        }
        current = 2;

        totalPrimeCount = 0;
        sumofPrime = 0;

        final long startTime = System.currentTimeMillis();
        myrun my = new myrun();
        boolean isT = true;
        while (current<=n){
            for(int t=0; t<8; t++){
                if (!isT) try {
                    threads[t].join();
                } catch (NullPointerException ignored) {}
                else isT = false;
                threads[t] = new Thread(my);
                threads[t].start();
            }
        }

        for(int t=0; t< 8; t++){
            try {
                threads[t].join();
            }
            catch (NullPointerException ignored) {}
        }
        int h = (int) n;

//        while(count > 0){
//            if (prime[h]) {
//                topTen[count] = h;
//                count--;
//            }
//        }
       // for (int j=0; j<8; j++)threads[j].join();
        long endTime = System.currentTimeMillis();
        try {
            FileWriter myWriter = new FileWriter("primes.txt");
            myWriter.write("<" + (float)(endTime - startTime)/1000 + " seconds> <" + totalPrimeCount + " primes found> <" + sumofPrime + ": sum of all primes> \n");
            myWriter.write((Arrays.toString(topTen)));
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println("<" + (float)(endTime - startTime)/1000 + " seconds> <" + totalPrimeCount + " primes found> <" + sumofPrime + ": sum of all primes>");
        //System.out.println(Arrays.toString(topTen));
    }

}
