package MyProgect.Test;

public class ToGrade {
    public static enum Grade{
        VERYBAD,
        BAD,
        SATISFACTORILY,
        GOOD,
        EXCELLENT,
        NOTDEFINED,
    }
    static Grade intToGrade(int grade){
        switch (grade) {
            case 1:
                return Grade.valueOf("VERYBAD");
            case 2:
                return Grade.valueOf("BAD");
            case 3:
                return Grade.valueOf("SATISFACTORILY");
            case 4:
                return Grade.valueOf("GOOD");
            case 5:
                return Grade.valueOf("EXCELLENT");
            default:
                return Grade.valueOf("NOTDEFINED");
        }
    }

    public static void main(String[] args) {
        System.out.println(intToGrade(5));
    }
}
