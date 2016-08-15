package android.support.v4.p002c;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.c.e */
public final class C0052e extends Writer {
    private final String f245a;
    private StringBuilder f246b;

    public C0052e(String str) {
        this.f246b = new StringBuilder(128);
        this.f245a = str;
    }

    public final void close() {
        m257a();
    }

    public final void flush() {
        m257a();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m257a();
            } else {
                this.f246b.append(c);
            }
        }
    }

    private void m257a() {
        if (this.f246b.length() > 0) {
            Log.d(this.f245a, this.f246b.toString());
            this.f246b.delete(0, this.f246b.length());
        }
    }
}
