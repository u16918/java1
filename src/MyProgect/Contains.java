package MyProgect;

public class Contains {
    public static boolean containsDigit(int number, int digit) {

        for (int i = number; number > 0; ) {

            i = number % 10;

            if (i == digit) return true;

            else { number = number / 10;  }

        }   return false;
    }
        public static void main (String[] args){
            System.out.println(containsDigit(112, 0));
        }

}