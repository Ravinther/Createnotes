package com.socialnmobile.colornote.data;

import com.socialnmobile.colornote.ColorNote;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.data.p */
final class C0227p implements Comparable {
    int f989a;
    int f990b;
    long f991c;
    long f992d;
    boolean f993e;
    Object f994f;
    boolean f995g;
    Object f996h;

    public final /* synthetic */ int compareTo(Object obj) {
        C0227p c0227p = (C0227p) obj;
        if (this.f992d == c0227p.f992d) {
            switch (this.f990b) {
                case 1:
                    return Long.valueOf(this.f991c).compareTo(Long.valueOf(c0227p.f991c));
                case 2:
                    return 1;
                default:
                    throw new RuntimeException("Not reachable");
            }
        } else if (this.f992d < c0227p.f992d) {
            return -1;
        } else {
            return 1;
        }
    }

    C0227p() {
    }

    C0227p(JSONObject jSONObject) {
        this.f993e = jSONObject.has("V");
        this.f994f = jSONObject.opt("V");
        this.f995g = jSONObject.has("O");
        this.f996h = jSONObject.opt("O");
        this.f989a = jSONObject.optInt("M");
        this.f990b = jSONObject.optInt("B");
        this.f991c = jSONObject.optLong("U");
        this.f992d = jSONObject.optLong("R");
    }

    final void m1032a(Object obj, long j, long j2) {
        if (j2 > this.f992d) {
            this.f996h = this.f994f;
            this.f995g = this.f993e;
        }
        this.f993e = true;
        this.f994f = obj;
        this.f989a = 1;
        this.f990b = 1;
        this.f991c = j;
        this.f992d = j2;
    }

    final JSONObject m1031a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f993e) {
                if (this.f994f == null) {
                    jSONObject.put("V", JSONObject.NULL);
                } else {
                    jSONObject.put("V", this.f994f);
                }
            }
            if (this.f995g) {
                if (this.f996h == null) {
                    jSONObject.put("O", JSONObject.NULL);
                } else {
                    jSONObject.put("O", this.f996h);
                }
            }
            jSONObject.put("U", this.f991c);
            jSONObject.put("R", this.f992d);
            jSONObject.put("M", this.f989a);
            jSONObject.put("B", this.f990b);
        } catch (JSONException e) {
            ColorNote.m651a("JSON Exeption" + e.getMessage());
            e.printStackTrace();
        }
        return jSONObject;
    }
}
