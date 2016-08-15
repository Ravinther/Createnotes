package com.socialnmobile.colornote.data;

import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ae implements Editor {
    final /* synthetic */ ad f941a;
    private final Map f942b;
    private boolean f943c;

    public ae(ad adVar) {
        this.f941a = adVar;
        this.f942b = new HashMap();
        this.f943c = false;
    }

    public final boolean commit() {
        if (this.f941a.f938f == null) {
            this.f941a.f938f = C0229s.m1039a(this.f941a.f936d, 256, 256, 256, 3, this.f941a.f937e, "");
        }
        synchronized (this.f941a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f943c) {
                if (!this.f941a.f935a.m1030b()) {
                    this.f941a.f935a.m1025a(currentTimeMillis, this.f941a.f940h);
                }
                this.f943c = false;
            }
            for (Entry entry : this.f942b.entrySet()) {
                String str = (String) entry.getKey();
                ae value = entry.getValue();
                if (value != this) {
                    if (this.f941a.f935a.m1028a(str)) {
                        Object b = this.f941a.f935a.m1029b(str);
                        if (b != null && b.equals(value)) {
                        }
                    }
                    this.f941a.f935a.m1027a(str, value, currentTimeMillis, this.f941a.f940h);
                } else if (this.f941a.f935a.m1028a(str)) {
                    this.f941a.f935a.m1026a(str, currentTimeMillis, this.f941a.f940h);
                }
            }
            this.f942b.clear();
        }
        this.f941a.f939g = this.f941a.f935a.f988b.toString();
        C0229s.m1044a(this.f941a.f936d, this.f941a.f938f, 0, this.f941a.f939g, this.f941a.f937e, 3, 0, 0);
        return true;
    }

    public final Editor putString(String str, String str2) {
        synchronized (this) {
            this.f942b.put(str, str2);
        }
        return this;
    }

    public final Editor putStringSet(String str, Set set) {
        synchronized (this) {
            this.f942b.put(str, set);
        }
        return this;
    }

    public final Editor putInt(String str, int i) {
        synchronized (this) {
            this.f942b.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public final Editor putLong(String str, long j) {
        synchronized (this) {
            this.f942b.put(str, Long.valueOf(j));
        }
        return this;
    }

    public final Editor putFloat(String str, float f) {
        synchronized (this) {
            this.f942b.put(str, Float.valueOf(f));
        }
        return this;
    }

    public final Editor putBoolean(String str, boolean z) {
        synchronized (this) {
            this.f942b.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    public final Editor remove(String str) {
        synchronized (this) {
            this.f942b.put(str, this);
        }
        return this;
    }

    public final Editor clear() {
        synchronized (this) {
            this.f943c = true;
        }
        return this;
    }

    public final void apply() {
        commit();
    }
}
