package com.socialnmobile.colornote.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.fragment.CalendarFragment;

/* renamed from: com.socialnmobile.colornote.dialog.u */
final class C0256u implements OnClickListener {
    final /* synthetic */ CalendarFragment f1087a;

    C0256u(CalendarFragment calendarFragment) {
        this.f1087a = calendarFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1087a.m1310b(((C0230t) ((AlertDialog) dialogInterface).getListView().getAdapter().getItem(i)).f1002a);
    }
}
