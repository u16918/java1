package MyProgect.Test.T8_2;

public class Person {
    String a = "servus";

static class Child1{
    String hello(){
        return "привет";
    }
}
class Child2{
    String hello(){
        return a;
    }
}

    public static void main(String[] args) {
        System.out.println(new Person.Child1().hello());
        System.out.println(new Person().new Child2().hello());
    }

}
/*
Создайте класс Person, а внутри него 2 класса

вложенный класс Child1
внутренний класс Child2
У каждого класса, Child1 и Child2 создайте метод String hello()

У Child1 String hello() должен вернуть "привет"
У Child2 String hello() должен вернуть "servus"
 */