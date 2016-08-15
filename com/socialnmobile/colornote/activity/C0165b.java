package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.data.C0213c;

/* renamed from: com.socialnmobile.colornote.activity.b */
final class C0165b implements OnClickListener {
    final /* synthetic */ BackupLocal f810a;

    C0165b(BackupLocal backupLocal) {
        this.f810a = backupLocal;
    }

    public final void onClick(View view) {
        if (C0213c.m961a(this.f810a)) {
            this.f810a.showDialog(4);
            return;
        }
        this.f810a.startActivityForResult(new Intent(this.f810a, PasswordSetting.class), 1);
    }
}
