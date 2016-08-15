package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.dialog.C0170m;

/* renamed from: com.socialnmobile.colornote.activity.g */
final class C0171g implements C0170m {
    final /* synthetic */ BackupLocal f821a;

    C0171g(BackupLocal backupLocal) {
        this.f821a = backupLocal;
    }

    public final boolean m820a(String str) {
        if (this.f821a.f634e || this.f821a.f633d == null) {
            return true;
        }
        if (!this.f821a.m694a(str, this.f821a.f633d)) {
            return false;
        }
        ColorNote.m646a(this.f821a.getApplicationContext(), "BACKUP", "VIEW");
        new C0176l(this.f821a, str, this.f821a.f633d, 0).execute(new String[0]);
        return true;
    }
}
