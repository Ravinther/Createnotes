package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.data.C0214d;

/* renamed from: com.socialnmobile.colornote.activity.e */
final class C0168e implements OnClickListener {
    final /* synthetic */ BackupLocal f819a;

    C0168e(BackupLocal backupLocal) {
        this.f819a = backupLocal;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        C0214d c0214d = this.f819a.f632c;
        String str = this.f819a.f633d.f959e;
        String str2 = this.f819a.f633d.f960f;
        C0214d.m973a(str, str2);
        String[] a = c0214d.m995a(false);
        int length = a.length;
        while (i2 < length) {
            C0214d.m973a(a[i2], str2);
            i2++;
        }
        this.f819a.m690b();
    }
}
