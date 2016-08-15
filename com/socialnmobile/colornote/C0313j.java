package com.socialnmobile.colornote;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.Toast;
import com.socialnmobile.colornote.activity.SendAsAttachment;
import com.socialnmobile.colornote.activity.SendToClipboard;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.view.as;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.socialnmobile.colornote.j */
public final class C0313j {
    static Comparator f1372a;
    static Comparator f1373b;
    private static WakeLock f1374c;

    public static boolean m1651a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 256);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m1650a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean m1653a(Locale locale) {
        if (locale.getDisplayName().length() <= 0) {
            return false;
        }
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        if (directionality == (byte) 1 || directionality == 2) {
            return true;
        }
        return false;
    }

    public static String m1640a(Context context, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - j) < 604800000) {
            try {
                return DateUtils.getRelativeTimeSpanString(j, currentTimeMillis, 0, 327680).toString();
            } catch (RuntimeException e) {
                ColorNote.m651a("Can't format time");
            }
        }
        return DateUtils.formatDateRange(context, j, j, 327680);
    }

    public static Dialog m1635a(Context context, int i, int i2, OnClickListener onClickListener) {
        return C0313j.m1634a(context, 0, i, i2, onClickListener);
    }

    public static Dialog m1634a(Context context, int i, int i2, int i3, OnClickListener onClickListener) {
        Builder builder = new Builder(context);
        if (i != 0) {
            builder.setIcon(2130837583);
        }
        builder.setTitle(i2);
        builder.setMessage(i3);
        builder.setPositiveButton(17039370, onClickListener);
        builder.setNegativeButton(17039360, null);
        return builder.create();
    }

    public static CharSequence m1639a(String str) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static Drawable m1636a(Context context, int i) {
        if (i == 0) {
            return context.getResources().getDrawable(2130837592);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) context.getResources().getDrawable(2130837529);
        gradientDrawable.setColor(C0209d.m875a(context).m1136e(i));
        return gradientDrawable;
    }

    public static Drawable m1656b(Context context, int i) {
        if (i == 0) {
            GradientDrawable gradientDrawable = (GradientDrawable) context.getResources().getDrawable(2130837528);
            gradientDrawable.setColor(0);
            return new as(gradientDrawable, (float) C0313j.m1664c(context, 1));
        }
        gradientDrawable = (GradientDrawable) context.getResources().getDrawable(2130837528);
        gradientDrawable.setColor(C0209d.m875a(context).m1136e(i));
        return gradientDrawable;
    }

    public static int m1631a(int i) {
        switch (i) {
            case 1:
            case 6:
                return 2130837597;
            case 2:
                return 2130837616;
            case 3:
                return 2130837617;
            case 4:
                return 2130837610;
            case 5:
                return 2130837594;
            case 7:
                return 2130837605;
            default:
                return 0;
        }
    }

    public static int m1654b(int i) {
        switch (i) {
            case -1:
                return 2130837588;
            case 0:
                return 2130837593;
            case 16:
                return 2130837604;
            default:
                return 0;
        }
    }

    public static int m1632a(int i, int i2) {
        return Color.argb(i, Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public static String m1657b(Context context, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        Time time = new Time();
        Time time2 = new Time();
        time.set(j);
        time2.set(currentTimeMillis);
        time.set(time.monthDay, time.month, time.year);
        C0147f.m660a(time);
        time2.set(time2.monthDay, time2.month, time2.year);
        C0147f.m660a(time2);
        int julianDay = Time.getJulianDay(C0147f.m661a(time, true), time.gmtoff) - Time.getJulianDay(C0147f.m661a(time2, true), time2.gmtoff);
        if (julianDay == 0) {
            return context.getResources().getString(2131231010);
        }
        if (julianDay == 1) {
            return context.getResources().getString(2131231012);
        }
        if (julianDay == -1) {
            return context.getResources().getString(2131231027);
        }
        if (julianDay < 0) {
            return context.getResources().getString(2131230896, new Object[]{Integer.valueOf(Math.abs(julianDay))});
        } else if (julianDay <= 6) {
            return DateUtils.getDayOfWeekString(time.weekDay + 1, 10);
        } else {
            return context.getResources().getString(2131230806, new Object[]{Integer.valueOf(julianDay)});
        }
    }

    public static long m1633a(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.timezone = "UTC";
        time.set(i3, i2, i);
        return C0147f.m661a(time, false);
    }

    public static void m1647a(Time time) {
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.timezone = "UTC";
        time.set(i3, i2, i);
    }

    public static long m1655b(long j) {
        Time time = new Time();
        time.set(j);
        time.monthDay++;
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        return C0147f.m660a(time);
    }

    public static void m1644a(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        try {
            intent = Intent.createChooser(intent, activity.getString(2131230973));
            Intent intent2 = new Intent(activity, SendToClipboard.class);
            intent2.putExtra("android.intent.extra.TEXT", str2);
            intent2.putExtra("android.intent.extra.SUBJECT", str);
            Intent intent3 = new Intent(activity, SendAsAttachment.class);
            intent3.putExtra("android.intent.extra.TEXT", str2);
            intent3.putExtra("android.intent.extra.SUBJECT", str);
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2, intent3});
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, 2131230888, 0).show();
        }
    }

    public static void m1643a() {
        C0313j.m1652a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/data/colornote/temp/"));
    }

    private static boolean m1652a(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!C0313j.m1652a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static File m1638a(String str, String str2) {
        String str3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/data/colornote/temp/";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str3 + new StringBuilder(NoteMajorColumns.NOTE).append(System.currentTimeMillis()).append(".html").toString());
        String str4 = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"/><title>" + TextUtils.htmlEncode(str) + "</title></head><body>" + Html.toHtml(new SpannableString(str2)) + "</body></html>";
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file2));
            try {
                bufferedWriter.write(str4);
                bufferedWriter.close();
            } catch (IOException e) {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e2) {
                    }
                }
                return file2;
            }
        } catch (IOException e3) {
            bufferedWriter = null;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            return file2;
        }
        return file2;
    }

    public static String m1658b(String str) {
        return str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&#39;", "\\").replaceAll("&quot;", "\"");
    }

    public static void m1660b(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/html");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", "\n\n" + activity.getString(2131230974));
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(C0313j.m1638a(str, str2)));
        try {
            activity.startActivity(Intent.createChooser(intent, activity.getString(2131230973)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, 2131230888, 0).show();
        }
    }

    public static void m1649a(ArrayList arrayList) {
        Collections.sort(arrayList, f1373b);
    }

    public static void m1662b(ArrayList arrayList) {
        Collections.sort(arrayList, f1372a);
    }

    static {
        f1372a = new C0314k();
        f1373b = new C0315l();
    }

    public static void m1645a(Context context) {
        if (f1374c == null) {
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ColorNote");
            f1374c = newWakeLock;
            newWakeLock.acquire();
        }
    }

    public static void m1659b() {
        if (f1374c != null) {
            f1374c.release();
            f1374c = null;
        }
    }

    public static boolean m1667c(String str) {
        return Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$").matcher(str).matches();
    }

    private static String m1642a(Reader reader) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(reader);
            try {
                StringBuffer stringBuffer = new StringBuffer();
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer.append(cArr, 0, read);
                }
                String stringBuffer2 = stringBuffer.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
                return stringBuffer2;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static String m1669d(String str) {
        try {
            return C0313j.m1642a(new FileReader(str));
        } catch (IOException e) {
            ColorNote.m651a("readFile error" + e.getMessage());
            return "";
        }
    }

    public static String m1641a(InputStream inputStream) {
        try {
            return C0313j.m1642a(new InputStreamReader(inputStream));
        } catch (IOException e) {
            ColorNote.m651a("readFile error" + e.getMessage());
            return "";
        }
    }

    public static boolean m1666c() {
        Locale locale = Locale.getDefault();
        if (locale == null || !"CN".equals(locale.getCountry())) {
            return false;
        }
        return true;
    }

    public static int m1664c(Context context, int i) {
        return (int) (((float) i) * context.getResources().getDisplayMetrics().density);
    }

    public static boolean m1663b(Context context) {
        return C0147f.m666a(ViewConfiguration.get(context));
    }

    public static void m1646a(Resources resources, ImageView imageView, int i) {
        imageView.setImageDrawable(resources.getDrawable(i));
    }

    public static void m1665c(Context context) {
        context.startActivity(C0313j.m1668d());
    }

    public static boolean m1670d(Context context) {
        return C0313j.m1650a(context, C0313j.m1668d());
    }

    public static Intent m1671e(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("fb://page/195606680452466"));
        intent.setFlags(268435456);
        if (!C0313j.m1650a(context, intent)) {
            intent.setData(Uri.parse("http://www.facebook.com/ColorNote"));
        }
        return intent;
    }

    public static Intent m1672e(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(268435456);
    }

    public static View m1637a(AbsListView absListView) {
        for (int i = 0; i < absListView.getChildCount(); i++) {
            View childAt = absListView.getChildAt(i);
            if (childAt == null) {
                return null;
            }
            if (childAt.getBottom() >= 0) {
                return childAt;
            }
        }
        return null;
    }

    public static Intent m1673f(String str) {
        return C0313j.m1676i("http://www.google.com/cse?cx=partner-pub-2353536094017743:1302913524&ie=UTF-8&sa=Search&q=" + Uri.encode(str));
    }

    public static Intent m1674g(String str) {
        return C0313j.m1676i(String.format("http://www.amazon.com/gp/aw/s?tag=colornotenotepa-20&linkCode=da4&i=aps&k=%s&sort=&p_lbr_brands_browse-bin=", new Object[]{Uri.encode(str)}));
    }

    private static Intent m1676i(String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setFlags(524288);
        return intent;
    }

    public static void m1648a(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height != i) {
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void m1661b(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.width != i) {
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static String m1675h(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(10);
        if (indexOf >= 0) {
            indexOf = Math.min(50, indexOf);
        } else {
            indexOf = 50;
        }
        String substring = trim.substring(0, Math.min(indexOf, trim.length()));
        if (substring.length() >= 50) {
            int lastIndexOf = substring.lastIndexOf(32);
            if (lastIndexOf > 0) {
                substring = substring.substring(0, lastIndexOf);
            }
        }
        return substring.trim();
    }

    private static Intent m1668d() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.socialnmobile.dictapps.notepad.color.note"));
        intent.addFlags(335544320);
        return intent;
    }
}
