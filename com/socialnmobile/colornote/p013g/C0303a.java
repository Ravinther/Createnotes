package com.socialnmobile.colornote.p013g;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.socialnmobile.colornote.g.a */
public final class C0303a {
    public static final Pattern f1350a;
    public static final Pattern f1351b;
    public static final Pattern f1352c;
    static final TransformFilter f1353d;
    static final TransformFilter f1354e;
    static final MatchFilter f1355f;
    private static final Pattern f1356g;
    private static final Pattern f1357h;
    private static final Pattern f1358i;

    static {
        f1356g = Pattern.compile("\\[\\[(.*?)\\]\\]|\\b[A-Z]+[a-z0-9]+[A-Z][A-Za-z0-9]+\\b");
        f1357h = Pattern.compile("\\[\\[(.*?)\\]\\]");
        f1358i = Pattern.compile("\\[http[s]*://(.+?) (.+?)\\]");
        f1350a = Pattern.compile("(\\+[0-9]+[\\- ]*)?(\\([0-9]+\\)[\\- ]*)?([0-9][0-9\\-][0-9\\-]+[0-9])");
        f1351b = Pattern.compile("(\\+[0-9]+[ \\. ]*)?(\\([0-9]+\\)[ \\.]*)?([0-9][0-9\\.][0-9\\.]+[0-9])");
        f1352c = Pattern.compile("(\\+[0-9]+[ ]*)?(\\([0-9]+\\)[ ]*)?([0-9][0-9 ][0-9 ]+[0-9])");
        f1353d = new C0304b();
        f1354e = new C0305c();
        f1355f = new C0306d();
    }

    static String m1595a(String str) {
        return str.substring(2, str.length() - 2);
    }

    public static SpannableString m1594a(Context context, boolean z, String str) {
        String str2;
        int i;
        int i2;
        CharSequence spannableStringBuilder;
        Matcher matcher;
        int intValue = Integer.valueOf(C0212b.m936a(context, "pref_autolink_phone_type", context.getString(2131231059))).intValue();
        if (z) {
            str2 = C0228r.f1001e.toString() + "/";
        } else {
            str2 = C0228r.f998b.toString() + "/";
        }
        SpannableString spannableString = (SpannableString) Factory.getInstance().newSpannable(str);
        if (intValue != 7) {
            try {
                if (Linkify.addLinks(spannableString, 11)) {
                    i = 1;
                    if (intValue != 0) {
                        switch (intValue) {
                            case 1:
                                if (Linkify.addLinks(spannableString, f1350a, "tel:", f1355f, Linkify.sPhoneNumberTransformFilter)) {
                                    i = 1;
                                    break;
                                }
                                break;
                            case 2:
                                if (Linkify.addLinks(spannableString, f1351b, "tel:", f1355f, Linkify.sPhoneNumberTransformFilter)) {
                                    i = 1;
                                    break;
                                }
                                break;
                            case 4:
                                if (Linkify.addLinks(spannableString, f1352c, "tel:", f1355f, Linkify.sPhoneNumberTransformFilter)) {
                                    i = 1;
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            } catch (RuntimeException e) {
                ColorNote.m651a("addLinks RuntimeError");
                try {
                    spannableString = (SpannableString) Factory.getInstance().newSpannable(str);
                    if (Linkify.addLinks(spannableString, 3)) {
                        i = 1;
                    }
                } catch (RuntimeException e2) {
                }
            }
            i = 0;
            if (intValue != 0) {
                switch (intValue) {
                    case 1:
                        if (Linkify.addLinks(spannableString, f1350a, "tel:", f1355f, Linkify.sPhoneNumberTransformFilter)) {
                            i = 1;
                            break;
                        }
                        break;
                    case 2:
                        if (Linkify.addLinks(spannableString, f1351b, "tel:", f1355f, Linkify.sPhoneNumberTransformFilter)) {
                            i = 1;
                            break;
                        }
                        break;
                    case 4:
                        if (Linkify.addLinks(spannableString, f1352c, "tel:", f1355f, Linkify.sPhoneNumberTransformFilter)) {
                            i = 1;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        try {
            if (Linkify.addLinks(spannableString, 15)) {
                i = 1;
            }
        } catch (RuntimeException e3) {
            ColorNote.m651a("addLinks RuntimeError");
            try {
                spannableString = (SpannableString) Factory.getInstance().newSpannable(str);
                if (Linkify.addLinks(spannableString, 7)) {
                    i = 1;
                }
            } catch (RuntimeException e4) {
                i = 0;
            }
        }
        i = 0;
        if (C0212b.m940a(context, "pref_use_note_link", context.getResources().getBoolean(2131296269))) {
            if (C0212b.m940a(context, "pref_autolink_wiki_word", context.getResources().getBoolean(2131296258))) {
                if (Linkify.addLinks(spannableString, f1356g, str2, null, f1353d)) {
                    i2 = 1;
                    i = 1;
                }
                i2 = i;
                i = 0;
            } else {
                if (Linkify.addLinks(spannableString, f1357h, str2, null, f1353d)) {
                    i2 = 1;
                    i = 1;
                }
                i2 = i;
                i = 0;
            }
            if (i != 0) {
                spannableStringBuilder = new SpannableStringBuilder(spannableString);
                matcher = f1357h.matcher(spannableStringBuilder);
                i = 0;
                while (matcher.find()) {
                    spannableStringBuilder.replace(matcher.start(), matcher.end(), C0303a.m1595a(matcher.group(0)));
                    matcher.reset(spannableStringBuilder);
                    i = 1;
                }
                if (i != 0) {
                    spannableString = (SpannableString) Factory.getInstance().newSpannable(spannableStringBuilder);
                    i = i2;
                }
            }
            i = i2;
        }
        if (Linkify.addLinks(spannableString, f1358i, "", null, f1354e)) {
            i2 = 1;
            i = 1;
        } else {
            i2 = i;
            i = 0;
        }
        if (i != 0) {
            spannableStringBuilder = new SpannableStringBuilder(spannableString);
            matcher = f1358i.matcher(spannableStringBuilder);
            i = 0;
            while (matcher.find()) {
                i = matcher.start();
                int end = matcher.end();
                String group = matcher.group(0);
                spannableStringBuilder.replace(i, end, group.substring(group.indexOf(32) + 1, group.length() - 1));
                matcher.reset(spannableStringBuilder);
                i = 1;
            }
            if (i != 0) {
                spannableString = (SpannableString) Factory.getInstance().newSpannable(spannableStringBuilder);
            }
        }
        if (i2 != 0) {
            return spannableString;
        }
        return null;
    }

    public static void m1597a(Spannable spannable) {
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new C0308f(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
    }

    public static ArrayList m1596a(SpannableString spannableString) {
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length() - 1, URLSpan.class);
        ArrayList arrayList = new ArrayList();
        for (URLSpan uRLSpan : uRLSpanArr) {
            C0307e c0307e = new C0307e();
            c0307e.f1360b = uRLSpan.getURL();
            c0307e.f1361c = spannableString.subSequence(spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan)).toString();
            String str = c0307e.f1360b;
            int i = str.startsWith("tel:") ? 1 : str.startsWith("geo:") ? 4 : str.startsWith("mailto:") ? 3 : (str.startsWith("http") || str.startsWith("rstp")) ? 2 : str.startsWith("content://note") ? 5 : 0;
            c0307e.f1359a = i;
            arrayList.add(c0307e);
        }
        return arrayList;
    }
}
