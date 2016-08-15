package com.socialnmobile.colornote.p013g;

import android.text.TextPaint;
import android.text.style.URLSpan;

/* renamed from: com.socialnmobile.colornote.g.f */
final class C0308f extends URLSpan {
    public C0308f(String str) {
        super(str);
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
