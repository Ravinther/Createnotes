package com.socialnmobile.colornote.service;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.data.C0214d;
import com.socialnmobile.colornote.receiver.AutoSyncReceiver;

/* renamed from: com.socialnmobile.colornote.service.a */
public final class C0333a extends AsyncTask {
    final /* synthetic */ SDBackupService f1452a;

    public C0333a(SDBackupService sDBackupService) {
        this.f1452a = sDBackupService;
    }

    protected final void onPreExecute() {
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        AutoSyncReceiver.m1714a(this.f1452a);
        this.f1452a.stopSelf();
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (C0214d.m977a(this.f1452a)) {
            Context context = this.f1452a;
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("PREF_LAST_AUTO_SDBACKUP_TIME", currentTimeMillis);
            edit.commit();
        }
        return Long.valueOf(0);
    }
}
