package com.socialnmobile.util.p011b.p017b;

import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.cl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.socialnmobile.util.b.b.f */
public final class C0463f extends C0356a {
    public static final TimeZone f2256a;
    public static final C0463f f2257b;
    private final SimpleDateFormat f2258c;

    public final /* synthetic */ Object m2297a(Object obj) {
        return m2294b((String) obj);
    }

    public final /* synthetic */ Object m2298b(Object obj) {
        return m2292a((Date) obj);
    }

    static {
        f2256a = TimeZone.getTimeZone("UTC");
        f2257b = new C0463f();
    }

    public C0463f() {
        this.f2258c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        this.f2258c.setTimeZone(f2256a);
    }

    private synchronized String m2292a(Date date) {
        String format;
        format = this.f2258c.format(date);
        if (!C0463f.m2295c(format)) {
            Calendar instance = Calendar.getInstance(f2256a, Locale.US);
            instance.setTime(date);
            int i = instance.get(1);
            int i2 = instance.get(2) + 1;
            int i3 = instance.get(5);
            int i4 = instance.get(11);
            int i5 = instance.get(12);
            int i6 = instance.get(13);
            int i7 = instance.get(14);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format(null, "%04d", new Object[]{Integer.valueOf(i)}));
            stringBuffer.append('-');
            stringBuffer.append(String.format(null, "%02d", new Object[]{Integer.valueOf(i2)}));
            stringBuffer.append('-');
            stringBuffer.append(String.format(null, "%02d", new Object[]{Integer.valueOf(i3)}));
            stringBuffer.append(' ');
            stringBuffer.append(String.format(null, "%02d", new Object[]{Integer.valueOf(i4)}));
            stringBuffer.append(':');
            stringBuffer.append(String.format(null, "%02d", new Object[]{Integer.valueOf(i5)}));
            stringBuffer.append(':');
            stringBuffer.append(String.format(null, "%02d", new Object[]{Integer.valueOf(i6)}));
            stringBuffer.append('.');
            stringBuffer.append(String.format(null, "%03d", new Object[]{Integer.valueOf(i7)}));
            format = stringBuffer.toString();
        }
        return format;
    }

    private synchronized Date m2294b(String str) {
        Date parse;
        try {
            parse = this.f2258c.parse(str);
        } catch (ParseException e) {
            parse = C0463f.m2296d(str);
        }
        return parse;
    }

    private static boolean m2295c(String str) {
        try {
            Integer.parseInt(str.substring(0, 4));
            C0463f.m2293a('-', str.charAt(4));
            Integer.parseInt(str.substring(5, 7));
            C0463f.m2293a('-', str.charAt(7));
            Integer.parseInt(str.substring(8, 10));
            C0463f.m2293a(' ', str.charAt(10));
            Integer.parseInt(str.substring(11, 13));
            C0463f.m2293a(':', str.charAt(13));
            Integer.parseInt(str.substring(14, 16));
            C0463f.m2293a(':', str.charAt(16));
            Integer.parseInt(str.substring(17, 19));
            C0463f.m2293a('.', str.charAt(19));
            Integer.parseInt(str.substring(20, 23));
            return true;
        } catch (Exception e) {
            C0311h.f1370a.m1626b("Invalid DateTime format", "", str);
            return false;
        }
    }

    private static void m2293a(char c, char c2) {
        if (c != c2) {
            throw new RuntimeException();
        }
    }

    private static Date m2296d(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(0, 4));
            int parseInt2 = Integer.parseInt(str.substring(5, 7));
            int parseInt3 = Integer.parseInt(str.substring(8, 10));
            int parseInt4 = Integer.parseInt(str.substring(11, 13));
            int parseInt5 = Integer.parseInt(str.substring(14, 16));
            int parseInt6 = Integer.parseInt(str.substring(17, 19));
            int parseInt7 = Integer.parseInt(str.substring(20, 23));
            Calendar instance = Calendar.getInstance(f2256a, Locale.US);
            instance.setTimeInMillis(0);
            instance.set(parseInt, parseInt2 - 1, parseInt3, parseInt4, parseInt5, parseInt6);
            instance.set(14, parseInt7);
            return new Date(instance.getTimeInMillis());
        } catch (Throwable e) {
            throw new cl(e);
        }
    }
}
