package MyProgect.Test;

public class Task4 {
    static int addAsStrings(int n1, int n2){
        Integer.toString (n1);
        Integer.toString (n2);
        String n3 = ("" + n1 + "" + n2);
        return Integer.parseInt(n3);

    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(365, 55555));
    }
}
