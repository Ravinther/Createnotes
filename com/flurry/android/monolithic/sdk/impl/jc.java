package com.flurry.android.monolithic.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class jc extends BroadcastReceiver {
    private static jc f546d;
    boolean f547a;
    private List f548b;
    private boolean f549c;

    public jc() {
        this.f549c = false;
        this.f548b = new LinkedList();
    }

    public static synchronized jc m611a() {
        jc jcVar;
        synchronized (jc.class) {
            if (f546d == null) {
                f546d = new jc();
            }
            jcVar = f546d;
        }
        return jcVar;
    }

    public final synchronized void m613a(bi biVar) {
        if (biVar != null) {
            this.f548b.add(new WeakReference(biVar));
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean a = m612a(context);
        if (this.f547a != a) {
            this.f547a = a;
            for (WeakReference weakReference : new LinkedList(this.f548b)) {
                bi biVar = (bi) weakReference.get();
                if (biVar != null) {
                    biVar.m594a(this.f547a);
                }
            }
        }
    }

    private boolean m612a(Context context) {
        if (!this.f549c || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final synchronized void m614b() {
        Context context = am.f442a.f443b;
        this.f549c = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        this.f547a = m612a(context);
        if (this.f549c) {
            Context context2 = am.f442a.f443b;
            this.f547a = m612a(context2);
            context2.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
