package MyProgect;

public class Calculator {
    private int result;
    Calculator(){
        result = 0;
    }
    public int set(int num){
        result = num;
        return num;
    }
    public int add(int num){
        result += num;
        return num;
    }
    public int sub(int num){
        result -= num;
        return num;
    }
    public int getResult(){
        return result;
    }
}
