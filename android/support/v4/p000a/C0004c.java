package android.support.v4.p000a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* renamed from: android.support.v4.a.c */
public class C0004c extends C0001a {
    final C0005e f26f;
    Uri f27g;
    String[] f28h;
    String f29i;
    String[] f30j;
    String f31k;
    Cursor f32l;

    public final /* synthetic */ void m32a(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public final /* synthetic */ void m34b(Object obj) {
        m31a((Cursor) obj);
    }

    public /* synthetic */ Object m35d() {
        return m36e();
    }

    public C0004c(Context context) {
        super(context);
        this.f26f = new C0005e(this);
    }

    protected final void m37f() {
        if (this.f32l != null) {
            m31a(this.f32l);
        }
        boolean z = this.f6s;
        this.f6s = false;
        this.f7t |= z;
        if (z || this.f32l == null) {
            m8j();
        }
    }

    protected final void m38g() {
        m16b();
    }

    protected final void m39h() {
        super.m6h();
        m16b();
        if (!(this.f32l == null || this.f32l.isClosed())) {
            this.f32l.close();
        }
        this.f32l = null;
    }

    public final void m33a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m15a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f27g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f28h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f29i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f30j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f31k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f32l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.s);
    }

    public Cursor m36e() {
        Cursor query = this.f2o.getContentResolver().query(this.f27g, this.f28h, this.f29i, this.f30j, this.f31k);
        if (query != null) {
            query.getCount();
            query.registerContentObserver(this.f26f);
        }
        return query;
    }

    private void m31a(Cursor cursor) {
        if (!this.f5r) {
            Cursor cursor2 = this.f32l;
            this.f32l = cursor;
            if (this.f3p) {
                super.m3b(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }
}
