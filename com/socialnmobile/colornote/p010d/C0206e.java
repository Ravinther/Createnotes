package com.socialnmobile.colornote.p010d;

import android.os.AsyncTask;
import android.os.Bundle;
import com.p004a.p005a.C0110e;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.colornote.sync.cj;
import com.socialnmobile.colornote.sync.cl;
import java.io.IOException;

/* renamed from: com.socialnmobile.colornote.d.e */
final class C0206e extends AsyncTask {
    final /* synthetic */ C0202a f900a;

    private C0206e(C0202a c0202a) {
        this.f900a = c0202a;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return C0206e.m869a((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        this.f900a.f892f = false;
        if (!this.f900a.f893g.isFinishing()) {
            this.f900a.f889c.dismiss();
        }
        if (str != null) {
            try {
                ci ciVar = (ci) cj.f1622a.m1788a(str);
                Bundle bundle = new Bundle();
                bundle.putString("access_token", ciVar.b);
                bundle.putString("refresh_token", ciVar.f1621a);
                bundle.putString("expires_in", String.valueOf(ciVar.c));
                this.f900a.f888b.m494a(bundle);
            } catch (cl e) {
            }
        } else {
            this.f900a.f888b.m496a(new C0110e("retrieve token error"));
        }
        if (!this.f900a.f893g.isFinishing()) {
            this.f900a.dismiss();
        }
    }

    private static String m869a(String... strArr) {
        try {
            return C0207f.m870a(strArr[0]);
        } catch (IOException e) {
            return null;
        }
    }

    protected final void onPreExecute() {
        if (!this.f900a.f893g.isFinishing()) {
            this.f900a.f889c.show();
        }
    }
}
