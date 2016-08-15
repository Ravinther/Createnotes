package com.socialnmobile.colornote.fragment;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.p000a.C0004c;
import com.socialnmobile.colornote.data.C0228r;

final class cr extends C0004c {
    String f1302u;

    public final /* synthetic */ Object m1588d() {
        return m1589e();
    }

    public cr(Context context, String str) {
        super(context);
        this.f1302u = str;
    }

    public final Cursor m1589e() {
        Context context = this.f2o;
        String str = this.f1302u;
        return context.getContentResolver().query(C0228r.f997a, null, "active_state <> 32 AND active_state <> 256 AND (title like ? OR note like ? )", new String[]{"%" + str + "%", "%" + str + "%"}, "modified_date DESC");
    }
}
