package com.socialnmobile.colornote.data;

import com.socialnmobile.colornote.ColorNote;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.data.o */
public final class C0226o extends C0225q {
    JSONObject f987a;
    JSONObject f988b;

    public C0226o() {
        m1024a();
    }

    public final void m1024a() {
        try {
            this.f987a = new JSONObject();
            this.f988b = new JSONObject();
            this.f988b.put("T", 1);
            this.f988b.put("V", 1);
            this.f988b.put("D", this.f987a);
        } catch (JSONException e) {
            ColorNote.m651a("JSON Exeption" + e.getMessage());
            e.printStackTrace();
        }
    }

    public final synchronized boolean m1030b() {
        boolean z;
        Iterator keys = this.f987a.keys();
        while (keys.hasNext()) {
            if (m1028a((String) keys.next())) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void m1025a(long j, long j2) {
        Iterator keys = this.f987a.keys();
        while (keys.hasNext()) {
            m1026a((String) keys.next(), j, j2);
        }
    }

    public final synchronized boolean m1028a(String str) {
        boolean z = false;
        synchronized (this) {
            if (this.f987a.has(str)) {
                try {
                    z = this.f987a.getJSONObject(str).has("V");
                } catch (JSONException e) {
                    ColorNote.m651a("JSON Exeption" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    public final synchronized void m1026a(String str, long j, long j2) {
        C0227p c = m1023c(str);
        if (c != null) {
            if (j2 > c.f992d) {
                c.f996h = c.f994f;
                c.f995g = c.f993e;
            }
            c.f993e = false;
            c.f994f = null;
            c.f989a = 1;
            c.f990b = 1;
            c.f991c = j;
            c.f992d = j2;
            m1022a(str, c);
        }
    }

    public final synchronized void m1027a(String str, Object obj, long j, long j2) {
        C0227p c = m1023c(str);
        if (c != null) {
            c.m1032a(obj, j, j2);
        } else {
            c = new C0227p();
            c.m1032a(obj, j, j2);
        }
        m1022a(str, c);
    }

    private synchronized void m1022a(String str, C0227p c0227p) {
        try {
            this.f987a.put(str, c0227p.m1031a());
        } catch (JSONException e) {
            ColorNote.m651a("JSON Exeption" + e.getMessage());
            e.printStackTrace();
        }
    }

    private synchronized C0227p m1023c(String str) {
        C0227p c0227p;
        if (this.f987a.has(str)) {
            try {
                c0227p = new C0227p(this.f987a.getJSONObject(str));
            } catch (JSONException e) {
                ColorNote.m651a("JSON Exeption" + e.getMessage());
                e.printStackTrace();
            }
        }
        c0227p = null;
        return c0227p;
    }

    public final synchronized Object m1029b(String str) {
        Object obj = null;
        synchronized (this) {
            if (this.f987a.has(str)) {
                try {
                    Object opt = this.f987a.getJSONObject(str).opt("V");
                    if (opt != JSONObject.NULL) {
                        obj = opt;
                    }
                } catch (JSONException e) {
                    ColorNote.m651a("JSON Exeption" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}
