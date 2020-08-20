package MyProgect.Trening;

public class Bitwise {
    private int i;
    private int j;
    private String temp = "";

    Bitwise(){
        i = 0xAA;
    }
    public void setNumber (int number) {
        i = number;
    }
    public int getNumber() {
        return i;
    }

    public void magic(){

        while(i != 0){
            j = i % 2;
            temp = j + temp;
            i = i / 2;
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {

        Bitwise number1 = new Bitwise();
        String str = Integer.toBinaryString(-128);
        System.out.println(str);

        Bitwise number2 = new Bitwise();
        number2.magic();

    }
}
