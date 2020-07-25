public class Time {
    public static void main(String[] args) {
        //Если вы хотите написать какое-то примечание или комментарий, то поставьте 2 символа косой черты
        //как сделал я и пишите, ошибок возникать не будет, это называется однострочный комментарий

        //Дано количество секунд
        int seconds = 1000000;

        //Сохраним сколько секунд в минутах, сколько секунд в часах и сколько секунд в сутках, для дальнейших вычислений
        int secondsInMinutes = 60;
        int secondsInHours = secondsInMinutes * 60;
        int secondsInDays = secondsInHours * 24;

        //Вычисляем количество дней - оно равно общему количеству секунд деленному на количество секунд в днях
        int days = seconds / secondsInDays;

        //Вычисляем количество часов - берем остаток от деления (из предыдущего действия) и делим его на количество секунд в часах
        int hours = (seconds % secondsInDays) / secondsInHours;

        //Вычисляем количество минут - берем остаток от деления (из предыдущего действия) и делим его  на количество секунд в минутах
        int minutes = ((seconds % secondsInDays) % secondsInHours) / secondsInMinutes;

        //Вычисляем количество секунд - берем общее количество секунд и вычитаем количество секунд, которое ушло на формирование дней, часов и минут
        int leftSeconds = seconds - days * secondsInDays - hours * secondsInHours - minutes * secondsInMinutes;

        //Выводим информацию на экран
        System.out.println("Дано количество секунд: " + seconds);
        System.out.println("Это равно");
        System.out.println("Дней: " + days);
        System.out.println("Часов: " + hours);
        System.out.println("Минут: " + minutes);
        System.out.println("Секунд: " + leftSeconds);
    }
}
