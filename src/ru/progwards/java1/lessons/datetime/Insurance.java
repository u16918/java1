package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {
    public static enum FormatStyle {SHORT, LONG, FULL}
    private ZonedDateTime start;
    private Duration duration = null;

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        ZoneId defaultZone = ZoneId.of("Europe/Moscow");
        DateTimeFormatter dtf;
        switch (style) {
            case SHORT -> {
                dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate ldate = LocalDate.parse(strStart, dtf);
                LocalTime ltime = LocalTime.of(0, 0, 0);
                LocalDateTime temp1 = LocalDateTime.of(ldate, ltime);
                this.start = temp1.atZone(defaultZone);
            }
            case LONG -> {
                dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                LocalDateTime temp2 = LocalDateTime.parse(strStart, dtf);
                this.start = temp2.atZone(defaultZone);
            }
            case FULL -> {
                dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                this.start = ZonedDateTime.parse(strStart, dtf);
            }
            default -> System.out.println("Не правильный формат даты");
        }
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        duration = Duration.between(start, expiration);
    }

    public void setDuration(int months, int days, int hours) {
        duration = Duration.ofHours(hours).plusDays(days).plusDays(months*30);
    }

    public void setDuration(String strDuration, FormatStyle style) {
        switch (style) {
            case SHORT -> {
                long millis = Long.parseLong(strDuration);
                duration = Duration.ofMillis(millis);
            }
            case LONG -> {
                int years = Integer.parseInt(strDuration.substring(0, 4));
                int months = Integer.parseInt(strDuration.substring(5, 7));
                int days = Integer.parseInt(strDuration.substring(8, 10));
                int hours = Integer.parseInt(strDuration.substring(11, 13));
                int minutes = Integer.parseInt(strDuration.substring(14, 16));
                int seconds = Integer.parseInt(strDuration.substring(17, 19));
                duration = Duration.ofSeconds(seconds).plusMinutes(minutes).plusHours(hours);
                duration = duration.plusDays(days).plusDays(months * 30).plusDays(years * 365);
            }
            case FULL -> duration = Duration.parse(strDuration);
            default -> System.out.println("Не правильный формат даты");
        }
    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if (dateTime.isBefore(start)) {
            return false;
        }
        if (duration == null || dateTime.isEqual(start)) {
            return true;
        }
        if (dateTime.isAfter(start)) {
            long seconds = duration.getSeconds();
            ZonedDateTime end = start.plusSeconds(seconds);
            return dateTime.isBefore(end);
        }
        return false;
    }

    @Override
    public String toString() {
        String validStr;
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Moscow"));
        if (checkValid(zdt)) {
            validStr = " is valid";
        } else {
            validStr = " is not valid";
        }
        return "Insurance issued on " + start + validStr;
    }

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2020, 1,1,10,10,10);
        Insurance t = new Insurance(ZonedDateTime.parse("2021-01-22T21:42:14.548223+03:00[Europe/Moscow]"));
        ZonedDateTime zdt = ZonedDateTime.parse("2020-10-24T21:42:14.548249+03:00[Europe/Moscow]");
        System.out.println(t.checkValid(zdt));
        System.out.println(t.toString());
    }
}
/*
Задача 1. Класс Insurance

Класс должен проверять валидность страховок, например для выезжающих за рубеж.
Каждая страховка имеет дату-время начала, и продолжительность.
1.1  Реализовать локальный public static enum FormatStyle {SHORT, LONG, FULL} - стиль формата даты-времени
1.2. Реализовать приватные свойства класса:
private ZonedDateTime start - дата-время начала действия страховки.
private Duration duration - продолжительность действия.
1.2 Реализовать конструкторы:
public Insurance(ZonedDateTime start) - установить дату-время начала действия страховки.
public Insurance(String strStart, FormatStyle style) - установить дату-время начала действия страховки
SHORT соответствует ISO_LOCAL_DATE
LONG  - ISO_LOCAL_DATE_TIME
FULL - ISO_ZONED_DATE_TIME
Для вариантов, когда не задан явно часовой пояс использовать таковой по умолчанию.
1.3 Реализовать методы, устанавливающие продолжительность действия страховки:
public void setDuration(Duration duration) - установить продолжительность действия страховки.
public void setDuration(ZonedDateTime expiration) - установить продолжительность действия страховки,
задав дату-время окончания.
public void setDuration(int months, int days, int hours) - установить продолжительность действия страховки,
задав целыми числами количество месяцев, дней и часов.
public void setDuration(String strDuration, FormatStyle style) - установить продолжительность действия страховки
SHORT - целое число миллисекунд (тип long)
LONG  - ISO_LOCAL_DATE_TIME - как период, например “0000-06-03T10:00:00” означает,
что продолжительность действия страховки 0 лет, 6 месяцев, 3 дня 10 часов.
FULL - стандартный формат Duration, который получается через toString()
1.4 Реализовать методы возврата информации:
public boolean checkValid(ZonedDateTime dateTime) - проверить действительна ли страховка на указанную дату-время.
Если продолжительность не задана считать страховку бессрочной.
public String toString() - вернуть строку формата
"Insurance issued on " + start + validStr, где validStr = " is valid",
если страховка действительна на данный момент и " is not valid", если она недействительна.
 */