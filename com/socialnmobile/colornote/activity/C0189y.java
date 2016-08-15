package com.socialnmobile.colornote.activity;

import android.os.AsyncTask;
import com.socialnmobile.colornote.data.C0229s;

/* renamed from: com.socialnmobile.colornote.activity.y */
final class C0189y extends AsyncTask {
    final /* synthetic */ Main f855a;

    private C0189y(Main main) {
        this.f855a = main;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (((Long) obj).longValue() >= 9) {
            this.f855a.f659x = true;
        }
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return Long.valueOf((long) C0229s.m1034a(this.f855a));
    }
}
