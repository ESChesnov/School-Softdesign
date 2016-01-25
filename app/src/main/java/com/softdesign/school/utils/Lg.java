package com.softdesign.school.utils;

import android.util.Log;

/**
 * Зарефакторить код логера в соответствии с данными на лекции рекомендациями, исспользовать подход DRY Don’t repeat yourself (не повторяй себя) - 
 * т.е. избегаем повторения уже ранее написанного кода + Javadoc, 
 * логер должен исспользовать различные уровни вывода логов (Verbose, debug, info, error, warn, assert ).??? O_o
 */
public class Lg {

    private static final String PREFIX = "HTC ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private static boolean shouldLog() {
//        return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**уровень Verbose
     */
    public static void v(String tag, String msg) {
        log(Log.VERBOSE, tag, msg);
    }

    /**уровень Debug
     */
    public static void d(String tag, String msg) {
        log(Log.DEBUG, tag, msg);
    }

    /**уровень Info
     */
    public static void i(String tag, String msg) {
        log(Log.INFO, tag, msg);
    }

    /**уровень Error
     */
    public static void e(String tag, String msg) {
        log(Log.ERROR, tag, msg);
    }

    /**уровень Warn
     */
    public static void w(String tag, String msg) {
        log(Log.WARN, tag, msg);
    }

    /**уровень Assert
     */
    public static void a(String tag, String msg) {
        log(Log.ASSERT, tag, msg);
    }

    private static void log (int lvl, String tag, String msg){
        if (shouldLog()) {
            String str = msg;
            while (str.length() > LOGCAT_BUFFER_SIZE){
                String substr = str.substring(0, LOGCAT_BUFFER_SIZE);
                str = substr.substring(LOGCAT_BUFFER_SIZE);
                Log.println(lvl, PREFIX + tag, str);
            }
            Log.println(lvl, PREFIX + tag, str);
        }
    }

}