package com.socialnmobile.colornote.activity;

import android.os.AsyncTask;
import android.widget.Toast;
import com.socialnmobile.colornote.data.C0214d;
import com.socialnmobile.colornote.data.C0229s;

/* renamed from: com.socialnmobile.colornote.activity.j */
public final class C0174j extends AsyncTask {
    final /* synthetic */ BackupLocal f824a;

    public C0174j(BackupLocal backupLocal) {
        this.f824a = backupLocal;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        C0214d c0214d = new C0214d(this.f824a);
        c0214d.m989a(1);
        return Boolean.valueOf(c0214d.m991a(1, C0229s.m1034a(c0214d.f949a)));
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f824a.f634e = false;
        this.f824a.m690b();
        if (bool.booleanValue()) {
            Toast.makeText(this.f824a, 2131230894, 1).show();
        } else {
            Toast.makeText(this.f824a, 2131230739, 1).show();
        }
        this.f824a.f635f.dismiss();
    }

    protected final void onPreExecute() {
        this.f824a.f634e = true;
        this.f824a.m692a();
    }
}
