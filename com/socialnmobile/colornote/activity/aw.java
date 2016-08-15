package com.socialnmobile.colornote.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.sync.C0367b;

final class aw implements OnClickListener {
    final /* synthetic */ SyncStatus f806a;

    aw(SyncStatus syncStatus) {
        this.f806a = syncStatus;
    }

    public final void onClick(View view) {
        C0367b c = C0367b.m1871c(this.f806a);
        if (c != null) {
            Toast.makeText(this.f806a, "ID : " + c.m1860h(), 1).show();
        }
    }
}
