package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.widget.f */
public class C0092f {
    private static final C0093i f309b;
    private Object f310a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f309b = new C0095h();
        } else {
            f309b = new C0094g();
        }
    }

    public C0092f(Context context) {
        this.f310a = f309b.m401a(context);
    }

    public void m396a(int i, int i2) {
        f309b.m402a(this.f310a, i, i2);
    }

    public boolean m397a() {
        return f309b.m403a(this.f310a);
    }

    public boolean m398a(float f) {
        return f309b.m404a(this.f310a, f);
    }

    public boolean m400b() {
        return f309b.m406b(this.f310a);
    }

    public boolean m399a(Canvas canvas) {
        return f309b.m405a(this.f310a, canvas);
    }
}
