package com.socialnmobile.colornote.activity;

import android.content.Intent;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.menu.C0164q;

final class ab implements C0164q {
    final /* synthetic */ NoteWidgetConfigure f780a;

    ab(NoteWidgetConfigure noteWidgetConfigure) {
        this.f780a = noteWidgetConfigure;
    }

    public final boolean m808a(int i, String str) {
        if (this.f780a.f666o != null) {
            this.f780a.f666o.dismiss();
            this.f780a.f666o = null;
        }
        Intent intent = new Intent("android.intent.action.INSERT", C0228r.f997a);
        intent.putExtra("socialnmobile.intent.extra.TYPE", i);
        this.f780a.startActivityForResult(intent, 1);
        return true;
    }
}
