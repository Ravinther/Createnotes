package com.socialnmobile.colornote.data;

import android.content.Context;

public final class af {
    static af f944a;
    Context f945b;
    public C0234x f946c;
    public C0232v f947d;

    public static af m930a(Context context) {
        if (f944a == null) {
            f944a = new af(context.getApplicationContext());
        }
        return f944a;
    }

    private af(Context context) {
        this.f945b = context;
    }

    public final void m932a(boolean z) {
        if (z) {
            if (this.f946c == null) {
                m931a();
                this.f946c = new C0234x(this.f945b, "colornote_temp.db");
                this.f947d = null;
            }
            NoteProvider.m889c(m933b());
            return;
        }
        this.f946c = new C0234x(this.f945b, "colornote_temp.db");
        this.f947d = null;
    }

    public final void m931a() {
        this.f945b.deleteDatabase("colornote_temp.db");
    }

    public final C0232v m933b() {
        if (this.f947d == null) {
            if (this.f946c == null) {
                this.f946c = new C0234x(this.f945b, "colornote_temp.db");
            }
            this.f947d = new C0232v(this.f946c.getWritableDatabase());
        }
        return this.f947d;
    }
}
