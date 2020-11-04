package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SessionManager {
    private Collection<UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
        sessions = new ArrayList<>();
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
        userSession.updateLastAccess();
        sessions.add(userSession);
    }

    public UserSession find(String userName) {
        for (UserSession temp : sessions) {
            if (userName.equals(temp.getUserName())) {
                LocalDateTime AccessExp = temp.getLastAccess().plusSeconds(sessionValid);
                if (AccessExp.isAfter(LocalDateTime.now())) {
                    temp.updateLastAccess();
                    return temp;
                } else {
                    break;
                }
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        for (UserSession temp : sessions) {
            if (sessionHandle == temp.getSessionHandle()) {
                LocalDateTime AccessExp = temp.getLastAccess().plusSeconds(sessionValid);
                if (AccessExp.isAfter(LocalDateTime.now())) {
                    temp.updateLastAccess();
                    return temp;
                } else {
                    break;
                }
            }
        }
        return null;
    }

    public void delete(int sessionHandle) {
        Iterator<UserSession> sh = sessions.iterator();
        while (sh.hasNext()) {
            UserSession temp = sh.next();
            if (sessionHandle == temp.getSessionHandle()) {
                sh.remove();
                break;
            }
        }
    }

    public void deleteExpired() {
        Iterator<UserSession> sh = sessions.iterator();
        while (sh.hasNext()) {
            UserSession temp = sh.next();
            LocalDateTime AccessExp = temp.getLastAccess().plusSeconds(sessionValid);
            if (AccessExp.isBefore(LocalDateTime.now())) {
                sh.remove();
            }
        }
    }

    public static void main(String[] args)  {
        SessionManager s = new SessionManager(5);
        UserSession newOne = new UserSession("Alex");

        if (s.find("Alex")==null) {
            s.add(newOne);
        }
        s.get(newOne.getSessionHandle());
        s.get(newOne.getSessionHandle());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(s.get(newOne.getSessionHandle()));

        UserSession newOne1 = new UserSession("Andrey");
        s.add(newOne1);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        UserSession newOne2 = new UserSession("Roman");
        s.add(newOne2);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        s.deleteExpired();
        System.out.println(s.sessions);

        s.delete(newOne2.getSessionHandle());
        System.out.println(s.sessions);
    }
}

/*
Задача 3. Класс SessionManager

Реализовать класс для хранения пользовательских сессий для сервера, который проверяет аутентификацию пользователей.
 Менеджер работает по следующему принципу: при логине (считаем что проверка логин-пароль уже прошла)
 данные о сессии пользователя заносятся в список и возвращается хэндл сессии. Затем пользователи запрашивают
 информацию используя хэндл, авторизация идет по хендлу сессии, который валиден определенное время, с момента
 крайнего запроса. Проверка сессии по хендлу должна работать максимально быстро. У каждого пользователя может
 быть только одна сессия.
3.1 Реализовать класс UserSession, структура данных следующая:
private int sessionHandle;
private String userName;
private <дата-время> lastAccess;
Все свойства приватные, сделать для них методы-геттеры (getSessionHandle(), getUserName(), getLastAccess())
соответствующих типов,
метод updateLastAccess() -  обновляет время доступа к сессии,
а также конструктор
public UserSession(String userName) - создать сессию пользователя. Внутри автоматически сгенерировать sessionHanle,
 для примера использовать просто случайное число через класс Random, а так же установить текущее время доступа.
3.2 Реализовать класс SessionManager, структура данных следующая:
private <коллекция> sessions;
private int sessionValid;
3.3 реализовать конструктор
public SessionManager(int sessionValid) - создает экземпляр SessionManager и сохраняет sessionValid -
период валидности сессии в секундах.
Реализовать методы:
3.4 public void add(UserSession userSession) - добавляет новую сессию пользователя
3.5 public UserSession find(String userName) - проверяет наличие существующей сессии по userName.
Если срок валидности истек, или такой  сессии нет, возвращает null. В противном случае возвращает сессию,
обновив ее дату доступа.
3.6 public UserSession get(int sessionHandle) - проверяет наличие существующей сессии по хендлу.
Если срок валидности истек, или такой  сессии нет, возвращает null. В противном случае возвращает сессию,
обновив ее дату доступа.
3.7 public void delete(int sessionHandle) - удаляет указанную сессию пользователя
3.8 public deleteExpired() - удаляет все сессии с истекшим сроком годности.
Протестировать следующим образом:
Создать сессию по userName, для этого
- сделать find,
- убедиться что вернется null
- создать новую сессию
- добавить используя add
Вызвать несколько раз get
Подождать (Thread.sleep) время, большее, чем время валидности
Проверить что сессии нет через метод get
Создать еще одну сессию
Подождать половину времени валидности сессии
Создать еще одну сессию
Подождать еще раз половину времени валидности сессии
Вызвать deleteExpired()
Убедиться, что одна сессия удалена, вторая нет
Удалить оставшуюся через метод delete
Убедиться что удаление прошло
 */