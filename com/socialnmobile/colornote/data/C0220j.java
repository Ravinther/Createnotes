package com.socialnmobile.colornote.data;

import android.content.Context;
import android.text.SpannableString;
import com.socialnmobile.colornote.p013g.C0303a;
import java.util.ArrayList;

/* renamed from: com.socialnmobile.colornote.data.j */
public final class C0220j {
    public String f964a;
    public SpannableString f965b;
    int f966c;
    public int f967d;
    public ArrayList f968e;

    public C0220j(String str, boolean z) {
        m1003a(str);
        m1004a(z);
    }

    public final void m1004a(boolean z) {
        if (z) {
            this.f966c = 0;
        } else {
            this.f966c = 1;
        }
    }

    public final boolean m1005a() {
        return this.f966c == 0;
    }

    public final void m1003a(String str) {
        this.f964a = str;
        this.f967d = 0;
        this.f965b = null;
        this.f968e = null;
    }

    public final void m1002a(Context context, boolean z) {
        if (this.f967d == 0) {
            this.f965b = C0303a.m1594a(context, z, this.f964a);
            if (this.f965b != null) {
                this.f968e = C0303a.m1596a(this.f965b);
                if (this.f968e.size() > 0) {
                    C0303a.m1597a(this.f965b);
                    this.f967d = 1;
                    return;
                }
                this.f967d = 2;
                return;
            }
            this.f967d = 2;
        }
    }
}
