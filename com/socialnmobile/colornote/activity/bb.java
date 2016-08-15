package com.socialnmobile.colornote.activity;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.socialnmobile.colornote.data.C0228r;

final class bb implements OnClickListener {
    final /* synthetic */ Today f812a;

    bb(Today today) {
        this.f812a = today;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f812a.f769a.moveToPosition(i);
        Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(C0228r.f997a, this.f812a.f769a.getLong(this.f812a.f769a.getColumnIndex("_id"))));
        intent.putExtra("EXTRA_VIEW_FROM", "TODAY");
        this.f812a.startActivity(intent);
    }
}
