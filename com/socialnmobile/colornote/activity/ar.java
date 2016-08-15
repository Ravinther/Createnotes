package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.p004a.p005a.C0106a;
import com.p004a.p005a.C0108d;
import com.p004a.p005a.C0110e;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.bg;
import com.socialnmobile.colornote.sync.cf;

final class ar implements C0108d {
    final /* synthetic */ SyncActivity f798a;

    ar(SyncActivity syncActivity) {
        this.f798a = syncActivity;
    }

    public final void m815a(Bundle bundle) {
        String string = bundle.getString("access_token");
        int parseInt = Integer.parseInt(bundle.getString("expires_in"));
        cf cfVar = new cf(string, parseInt, new bg(bg.m1891a().f1558a + ((long) (parseInt * 1000))));
        if (this.f798a.f728c != null) {
            this.f798a.m758a(cfVar);
        }
    }

    public final void m814a() {
    }

    public final void m816a(C0106a c0106a) {
        Toast.makeText(this.f798a, c0106a.getLocalizedMessage(), 0).show();
        Toast.makeText(this.f798a, 2131230797, 0).show();
        ColorNote.m651a("Facebook Auth Error" + c0106a.getMessage());
    }

    public final void m817a(C0110e c0110e) {
        Toast.makeText(this.f798a, c0110e.getLocalizedMessage(), 0).show();
        ColorNote.m651a("Facebook Auth Error" + c0110e.getMessage());
    }
}
