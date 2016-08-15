package com.socialnmobile.colornote.sync;

import java.lang.reflect.Field;

public final class bj {
    public static final bj f1560a;
    public final String f1561b;

    static {
        f1560a = new bj("com.socialnmobile.colornote.sync.DevConfigValues");
    }

    private bj(String str) {
        this.f1561b = str;
    }

    public final boolean m1899a(String str) {
        try {
            return m1897b(str).getBoolean(null);
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchFieldException e2) {
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final Object m1898a(String str, Object obj) {
        try {
            obj = m1897b(str).get(null);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchFieldException e2) {
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        return obj;
    }

    private Field m1897b(String str) {
        return getClass().getClassLoader().loadClass(this.f1561b).getDeclaredField(str);
    }
}
