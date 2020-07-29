package MyProgect;

public class Test4_2 {
    static String textGrade(int grade) {
        if (grade == 0) return "не оценено";
        if (grade > 1 && grade < 20) return "очень плохо";
        if (!(grade <= 21 || grade > 40)) return "плохо";
        if (!(grade < 41 || grade >= 60)) return "удовлетворительно";
        if (grade > 61 && grade < 80) return "хорошо";
        if (grade > 81 && grade < 100) return "отлично";

         else return "не определено";
    }

    public static void main(String[] args) {
        System.out.println(textGrade(40));
    }
}


/*
Напишите метод, который возвращает текстовую характеристику оценки по числовой.

0 - не оценено
1..20 - очень плохо
21..40 - плохо
41..60 - удовлетворительно
61..80 - хорошо
81..100 - отлично
в остальных случаях - не определено

Сигнатура метода static String textGrade(int grade)

Например, textGrade(45) должна вернуть "удовлетворительно"
 */