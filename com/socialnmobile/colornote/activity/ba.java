package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.C0375c;
import com.socialnmobile.colornote.sync.C0384f;

final class ba implements OnClickListener {
    final /* synthetic */ SyncStatus f811a;

    ba(SyncStatus syncStatus) {
        this.f811a = syncStatus;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0367b c = C0367b.m1871c(this.f811a);
        if (c != null) {
            ColorNote.m646a(this.f811a.getApplicationContext(), "SYNC", "DISCONNECT");
            C0384f a = c.x.m2012a();
            a.f1775a.f1812j = true;
            C0375c a2 = c.m1875a();
            a2.x.m2014a(a);
            a2.m1941a();
            this.f811a.finish();
        }
    }
}
