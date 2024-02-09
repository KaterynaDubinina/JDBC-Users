package org.example.app.utils;

public class Constants {

    public final static String TABLE_USERS = "users";


    public final static String EMAIL_RGX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String WRONG_EMAIL_MSG = "\u2757  Невірно введено електронну пошту  \u2757";


    public final static String ID_RGX = "^[1-9]$";
    public final static String WRONG_ID_MSG = "\u2757  Невірно введено ID  \u2757";

    public final static String DATA_ABSENT_MSG = "\n\u274C  Дані відсутні";
    public final static String DATA_INSERT_MSG = "\n\u2705  Створено";
    public final static String DATA_UPDATE_MSG = "\n\u2705  Оновлено";
    public final static String DATA_DELETE_MSG = "\n\u2705  Видалено";

    public final static String APP_CLOSE_MSG = "\n\u2705  Додоток закрито";
    public final static String INPUT_REQ_MSG = "Потрібно введення";
    public final static String INCORRECT_VALUE_MSG = "\u2757  Некоректне значення \u2757 Спробуйте знов  \u2757";
    public final static String ID_NO_EXISTS_MSG = "\n\u2757  Таке ID відсутнє  \u2757";
}
