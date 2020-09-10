package ru.progwards.java1.lessons.TelegrammBot;


import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

public class PobotVerter extends ProgwardsTelegramBot {
    private final String menu = "У нас есть билеты на Марс, Юпитер, Венеру и Катманду";

    @Override
    public String processMessage(String text) {
        checkTags(text);
        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Приветствую тебя, о мой повелитель!\n Куда желаешь стартануть? ";

            return "Отлично, добавляю в заказ билет ,  " + getLastFound() + ",  Желаешь куда нибудь еще?";
    }
            if (checkLastFound("конец")) {
                return "Спасибо за заказ. Счастливого пути!";
            }

            if (checkLastFound("дурак")){
                return "Сам такой. Лети тогда на Хутор, бабочек ловить!";
        }
        if (checkLastFound("отлично")){
            return "Спасибо. Вы самый приятный пассажир!";
        }
        if (foundCount() > 1)
            return "Под твой запрос подходит: \n" + extract() + "Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас туда не летают, попробуй сказать по другому. ";

    }

    public static void main(String[] args) {
        System.out.println("Hollo Bot");

ApiContextInitializer.init();

    PobotVerter bot = new PobotVerter();
    bot.username = "PobotVerterBot";
    bot.token = "1347167132:AAHr-q6GcZMuo6hZj4vYoxp2yZoPs-TZIRU";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello");
        bot.addTags("конец", "конец, все, стоп, нет, пошел");
        bot.addTags("дурак", "дурак, придурок, идиот, тупой");
        bot.addTags("отлично", "отличный, хорош, молодец, прият");

        bot.addTags("На Марс", "марс");
        bot.addTags("На Юпитер", "юпитер");
        bot.addTags("На Венеру", "венер");

        bot.addTags("На хутор", "послать, билет, хутор");
        bot.addTags("В Катманду", "куда, катманду, город");
        bot.addTags("В Никуда", "никуда, сюда");


        bot.start();
       // bot.test();

 }

}
