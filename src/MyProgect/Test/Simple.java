package MyProgect.Test;

import java.io.IOException;

public class Simple {

    private static int [] generatePrimes(int max) {
        int [] temp = new int [max];
        temp [0] = 2;
        int index = 1;
        int prime = 1;
        boolean isPrime = false;
        while((prime += 2) <= max) {
            isPrime = true;
            for(int i = 0; i < index; i++) {
                if(prime % temp [i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                temp [index++] = prime;
            }
        }
        int [] primes = new int [index];
        while(--index >= 0) {
            primes [index] = temp [index];
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(generatePrimes(51));
    }

  /*
    public static void main(String[] args) throws IOException {
        if(System.in.read() % 2 == 0){
            System.out.println("Compositive number");

        }else{
            System.out.println("Prime number");
        }
    }
  */


}
