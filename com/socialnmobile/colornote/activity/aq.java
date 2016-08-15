package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.p004a.p005a.C0106a;
import com.p004a.p005a.C0108d;
import com.p004a.p005a.C0110e;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.bg;
import com.socialnmobile.colornote.sync.ci;

final class aq implements C0108d {
    final /* synthetic */ SyncActivity f797a;

    aq(SyncActivity syncActivity) {
        this.f797a = syncActivity;
    }

    public final void m811a(Bundle bundle) {
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("refresh_token");
        int parseInt = Integer.parseInt(bundle.getString("expires_in"));
        ci ciVar = new ci(string, parseInt, new bg(bg.m1891a().f1558a + ((long) (parseInt * 1000))), string2);
        if (this.f797a.f728c != null) {
            this.f797a.m759a(ciVar);
        }
    }

    public final void m810a() {
    }

    public final void m812a(C0106a c0106a) {
        Toast.makeText(this.f797a, c0106a.getLocalizedMessage(), 0).show();
        Toast.makeText(this.f797a, 2131230797, 0).show();
        ColorNote.m651a("Google Auth Error" + c0106a.getMessage());
    }

    public final void m813a(C0110e c0110e) {
        Toast.makeText(this.f797a, c0110e.getLocalizedMessage(), 0).show();
        ColorNote.m651a("Google Auth Error" + c0110e.getMessage());
    }
}
