package com.socialnmobile.colornote.p013g;

import android.text.util.Linkify.MatchFilter;

/* renamed from: com.socialnmobile.colornote.g.d */
final class C0306d implements MatchFilter {
    C0306d() {
    }

    public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
        char c = ' ';
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (Character.isDigit(charAt)) {
                i4++;
                i3 = 0;
            } else if (charAt == '-' || charAt == ' ' || charAt == '.') {
                if (charAt != ' ') {
                    if (c == ' ') {
                        c = charAt;
                    } else if (c != charAt) {
                        return false;
                    }
                }
                i3++;
                if (i3 > 1) {
                    return false;
                }
                z = true;
            }
            i++;
        }
        if (i4 < 5 || i4 > 15 || !r3) {
            return false;
        }
        return true;
    }
}
