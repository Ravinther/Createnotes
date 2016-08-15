package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.dialog.C0170m;
import com.socialnmobile.colornote.sync.C0367b;

/* renamed from: com.socialnmobile.colornote.activity.i */
final class C0173i implements C0170m {
    final /* synthetic */ BackupLocal f823a;

    C0173i(BackupLocal backupLocal) {
        this.f823a = backupLocal;
    }

    public final boolean m822a(String str) {
        if (this.f823a.f634e) {
            return true;
        }
        if (!C0213c.m962a(this.f823a, str)) {
            return false;
        }
        ColorNote.m646a(this.f823a.getApplicationContext(), "BACKUP", "MANUAL_BACKUP");
        if (C0367b.m1868a(this.f823a)) {
            BackupLocal.m691b(this.f823a);
            return true;
        }
        new C0174j(this.f823a).execute(new String[0]);
        return true;
    }
}
