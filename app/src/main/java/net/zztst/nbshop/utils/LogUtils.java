package net.zztst.nbshop.utils;

import com.orhanobut.logger.Logger;

public class LogUtils {
    //开关
    private static final boolean ENABLE = false;
    
    public static void i(String tag, String msg) {
    if (ENABLE) {
        Logger.i(tag,msg);
    }
}
    public static void i( String msg) {
        if (ENABLE) {
            Logger.i(msg);
        }
    }

    public static void i(Class<?> cls, String msg) {
        if (ENABLE) {
            Logger.i(cls.getSimpleName(),msg);
        }
    }
}