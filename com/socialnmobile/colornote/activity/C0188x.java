package com.socialnmobile.colornote.activity;

import android.support.v4.app.C0015f;
import android.support.v4.app.C0031p;
import com.socialnmobile.colornote.fragment.CalendarFragment;
import com.socialnmobile.colornote.fragment.NotesFragment;
import com.socialnmobile.colornote.view.ac;
import com.socialnmobile.colornote.view.ad;

/* renamed from: com.socialnmobile.colornote.activity.x */
public final class C0188x extends ac {
    final /* synthetic */ Main f854a;

    public C0188x(Main main, C0031p c0031p, ad adVar) {
        this.f854a = main;
        super(c0031p, adVar);
    }

    public final C0015f m845a(int i) {
        if (i == 0) {
            return new NotesFragment();
        }
        if (i == 1) {
            return new CalendarFragment();
        }
        return null;
    }
}
