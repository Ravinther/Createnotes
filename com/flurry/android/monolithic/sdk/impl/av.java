package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;

public class av implements aq {
    static final String f475a;
    private static av f476l;
    Location f477b;
    boolean f478c;
    boolean f479d;
    int f480e;
    private final long f481f;
    private final long f482g;
    private LocationManager f483h;
    private Criteria f484i;
    private aw f485j;
    private String f486k;

    static {
        f475a = av.class.getSimpleName();
    }

    private av() {
        this.f481f = 1800000;
        this.f482g = 0;
        this.f478c = false;
        this.f480e = 0;
        this.f485j = new aw(this);
        ap a = ao.m552a();
        this.f484i = (Criteria) a.m553a("LocationCriteria");
        a.m554a("LocationCriteria", (aq) this);
        bh.m584a(4, "initSettings, LocationCriteria = " + this.f484i);
        this.f479d = ((Boolean) a.m553a("ReportLocation")).booleanValue();
        a.m554a("ReportLocation", (aq) this);
        bh.m584a(4, "initSettings, ReportLocation = " + this.f479d);
    }

    public static synchronized av m561a() {
        av avVar;
        synchronized (av.class) {
            if (f476l == null) {
                f476l = new av();
            }
            avVar = f476l;
        }
        return avVar;
    }

    public final synchronized void m565b() {
        if (this.f483h == null) {
            this.f483h = (LocationManager) am.f442a.f443b.getSystemService("location");
        }
    }

    public final synchronized void m566c() {
        bh.m584a(4, "Location provider subscribed");
        this.f480e++;
        if (!this.f478c) {
            m562g();
        }
    }

    public final synchronized void m567d() {
        bh.m584a(4, "Location provider unsubscribed");
        if (this.f480e <= 0) {
            bh.m584a(6, "Error! Unsubscribed too many times!");
            m568e();
        } else {
            this.f480e--;
            if (this.f480e == 0) {
                m568e();
            }
        }
    }

    final void m568e() {
        this.f483h.removeUpdates(this.f485j);
        this.f478c = false;
        bh.m584a(4, "LocationProvider stoped");
    }

    private void m562g() {
        if (this.f479d) {
            Context context = am.f442a.f443b;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                m568e();
                String f = m569f();
                if (!TextUtils.isEmpty(f)) {
                    this.f483h.requestLocationUpdates(f, 1800000, 0.0f, this.f485j, Looper.getMainLooper());
                }
                this.f477b = m563a(f);
                this.f478c = true;
                bh.m584a(4, "LocationProvider started");
            }
        }
    }

    final String m569f() {
        String bestProvider;
        Criteria criteria = this.f484i;
        if (criteria == null) {
            criteria = new Criteria();
        }
        if (TextUtils.isEmpty(this.f486k)) {
            bestProvider = this.f483h.getBestProvider(criteria, true);
        } else {
            bestProvider = this.f486k;
        }
        bh.m584a(4, "provider = " + bestProvider);
        return bestProvider;
    }

    final Location m563a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f483h.getLastKnownLocation(str);
    }

    public final void m564a(String str, Object obj) {
        if (str.equals("LocationCriteria")) {
            this.f484i = (Criteria) obj;
            bh.m584a(4, "onSettingUpdate, LocationCriteria = " + this.f484i);
            if (this.f478c) {
                m562g();
            }
        } else if (str.equals("ReportLocation")) {
            this.f479d = ((Boolean) obj).booleanValue();
            bh.m584a(4, "onSettingUpdate, ReportLocation = " + this.f479d);
            if (!this.f479d) {
                m568e();
            } else if (!this.f478c && this.f480e > 0) {
                m562g();
            }
        } else {
            bh.m584a(6, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
        }
    }
}
