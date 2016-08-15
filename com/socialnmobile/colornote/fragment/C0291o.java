package com.socialnmobile.colornote.fragment;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.socialnmobile.colornote.sync.SyncIndexColumns;

/* renamed from: com.socialnmobile.colornote.fragment.o */
final class C0291o extends ContentObserver {
    final /* synthetic */ Cursor f1336a;
    final /* synthetic */ AbstractEditorViewer f1337b;

    C0291o(AbstractEditorViewer abstractEditorViewer, Handler handler, Cursor cursor) {
        this.f1337b = abstractEditorViewer;
        this.f1336a = cursor;
        super(handler);
    }

    public final void onChange(boolean z) {
        if (!this.f1336a.isClosed() && this.f1337b.f1147Z != null && this.f1337b.f48C != null && this.f1337b.f1150c != null) {
            long j = this.f1337b.f1147Z.f1016o;
            Context context = this.f1337b.f48C;
            Cursor query = context.getContentResolver().query(this.f1337b.f1150c, null, null, null, null);
            long j2 = 0;
            if (query.moveToNext()) {
                j2 = query.getLong(query.getColumnIndex(SyncIndexColumns.REVISION));
            }
            query.close();
            if (j < j2) {
                this.f1336a.requery();
            }
        }
    }
}
