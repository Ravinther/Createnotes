package com.socialnmobile.colornote.p013g;

import android.text.util.Linkify.TransformFilter;
import java.util.regex.Matcher;

/* renamed from: com.socialnmobile.colornote.g.c */
final class C0305c implements TransformFilter {
    C0305c() {
    }

    public final String transformUrl(Matcher matcher, String str) {
        return str.substring(1, str.indexOf(32));
    }
}
