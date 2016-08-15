package com.socialnmobile.colornote.menu;

import android.content.Context;
import android.widget.ListView;

/* renamed from: com.socialnmobile.colornote.menu.e */
final class C0320e extends ListView {
    private boolean f1422a;
    private boolean f1423b;

    public C0320e(Context context, boolean z) {
        super(context, null, 2130771969);
        this.f1423b = z;
        setCacheColorHint(0);
    }

    public final boolean isInTouchMode() {
        return (this.f1423b && this.f1422a) || super.isInTouchMode();
    }

    public final boolean hasWindowFocus() {
        return this.f1423b || super.hasWindowFocus();
    }

    public final boolean isFocused() {
        return this.f1423b || super.isFocused();
    }

    public final boolean hasFocus() {
        return this.f1423b || super.hasFocus();
    }
}
