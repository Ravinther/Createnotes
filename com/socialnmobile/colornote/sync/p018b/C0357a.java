package com.socialnmobile.colornote.sync.p018b;

import com.socialnmobile.util.p011b.p017b.C0355d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.sync.b.a */
public final class C0357a {
    public static Object m1817a(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return new C0361e((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return new C0360d((JSONArray) obj);
        }
        return obj;
    }

    public static Object m1823b(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (obj instanceof C0361e) {
            return ((C0361e) obj).f1507a;
        }
        if (obj instanceof C0360d) {
            return ((C0360d) obj).f1506a;
        }
        return obj;
    }

    public static Object m1820a(JSONArray jSONArray, int i) {
        try {
            return C0357a.m1817a(jSONArray.get(i));
        } catch (JSONException e) {
            throw new IndexOutOfBoundsException(i + " of " + jSONArray.length() + " has been referenced");
        }
    }

    public static Object m1821a(JSONObject jSONObject, String str) {
        try {
            return C0357a.m1817a(jSONObject.get(str));
        } catch (JSONException e) {
            throw new C0358b("Member Not Found: " + str);
        }
    }

    public static Object m1818a(String str, Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new C0359c("not null expected: " + str);
    }

    public static Object m1819a(String str, String str2, C0355d c0355d) {
        try {
            return c0355d.m1812a(str2);
        } catch (Throwable e) {
            throw new C0359c("can't parse: " + str, e);
        }
    }

    public static Boolean m1822b(String str, Object obj) {
        try {
            return (Boolean) obj;
        } catch (Throwable e) {
            throw new C0359c("Boolean expected: " + str, e);
        }
    }

    public static Number m1825c(String str, Object obj) {
        try {
            return (Number) obj;
        } catch (Throwable e) {
            throw new C0359c("Number expected: " + str, e);
        }
    }

    public static String m1826d(String str, Object obj) {
        try {
            return (String) obj;
        } catch (Throwable e) {
            throw new C0359c("String expected: " + str, e);
        }
    }

    public static C0360d m1827e(String str, Object obj) {
        try {
            return (C0360d) obj;
        } catch (Throwable e) {
            throw new C0359c("JsonList expected: " + str, e);
        }
    }

    public static C0361e m1828f(String str, Object obj) {
        try {
            return (C0361e) obj;
        } catch (Throwable e) {
            throw new C0359c("JsonMap expected: " + str, e);
        }
    }

    public static C0361e m1824c(Object obj) {
        if (obj == null) {
            return null;
        }
        return C0357a.m1828f(obj.toString(), obj);
    }
}
