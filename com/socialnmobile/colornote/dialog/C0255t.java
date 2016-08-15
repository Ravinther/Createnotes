package com.socialnmobile.colornote.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.fragment.CalendarFragment;

/* renamed from: com.socialnmobile.colornote.dialog.t */
final class C0255t implements OnClickListener {
    final /* synthetic */ CalendarFragment f1086a;

    C0255t(CalendarFragment calendarFragment) {
        this.f1086a = calendarFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1086a.m1365a(10, true);
    }
}
