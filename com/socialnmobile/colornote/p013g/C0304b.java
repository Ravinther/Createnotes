package com.socialnmobile.colornote.p013g;

import android.net.Uri;
import android.text.util.Linkify.TransformFilter;
import java.util.regex.Matcher;

/* renamed from: com.socialnmobile.colornote.g.b */
final class C0304b implements TransformFilter {
    C0304b() {
    }

    public final String transformUrl(Matcher matcher, String str) {
        if (str.startsWith("[[")) {
            str = C0303a.m1595a(str);
        }
        return Uri.encode(str);
    }
}
