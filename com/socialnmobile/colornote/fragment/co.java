package com.socialnmobile.colornote.fragment;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.p000a.C0004c;
import com.socialnmobile.colornote.data.C0228r;

final class co extends C0004c {
    int f1300u;

    public final /* synthetic */ Object m1586d() {
        return m1587e();
    }

    public co(Context context, int i) {
        super(context);
        this.f1300u = i;
    }

    public final Cursor m1587e() {
        String str;
        Context context = this.f2o;
        String str2 = "active_state = 16 AND account_id = 0";
        switch (this.f1300u) {
            case 2:
                str = "title ASC";
                break;
            case 3:
                str = "color_index ASC, modified_date DESC";
                break;
            case 5:
                str = "created_date DESC";
                break;
            case 6:
                str = "minor_modified_date DESC";
                break;
            default:
                str = null;
                break;
        }
        return context.getContentResolver().query(C0228r.f997a, null, str2, null, str);
    }
}
