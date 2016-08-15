package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.dialog.C0170m;

/* renamed from: com.socialnmobile.colornote.activity.h */
final class C0172h implements C0170m {
    final /* synthetic */ BackupLocal f822a;

    C0172h(BackupLocal backupLocal) {
        this.f822a = backupLocal;
    }

    public final boolean m821a(String str) {
        if (this.f822a.f634e || this.f822a.f633d == null) {
            return true;
        }
        if (!this.f822a.m694a(str, this.f822a.f633d)) {
            return false;
        }
        ColorNote.m646a(this.f822a.getApplicationContext(), "BACKUP", "RESTORE");
        new C0176l(this.f822a, str, this.f822a.f633d, 1).execute(new String[0]);
        return true;
    }
}
