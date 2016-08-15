package com.socialnmobile.colornote.activity;

import android.content.Intent;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.menu.C0164q;

final class bf implements C0164q {
    final /* synthetic */ Today f816a;

    bf(Today today) {
        this.f816a = today;
    }

    public final boolean m818a(int i, String str) {
        Today today = this.f816a;
        Intent intent = new Intent("android.intent.action.INSERT", C0228r.f997a);
        intent.putExtra("socialnmobile.intent.extra.TYPE", i);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_TYPE", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_DATE", System.currentTimeMillis());
        today.startActivity(intent);
        return true;
    }
}
