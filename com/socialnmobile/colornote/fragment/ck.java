package com.socialnmobile.colornote.fragment;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.net.Uri;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.receiver.C0332a;
import java.util.ArrayList;
import java.util.Iterator;

final class ck implements OnClickListener {
    final /* synthetic */ RecycleBinFragment f1295a;

    ck(RecycleBinFragment recycleBinFragment) {
        this.f1295a = recycleBinFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.f1295a.f48C;
        ColorNote.m646a(context, "NOTE", "EMPTY_RECYCLEBIN");
        ContentValues a = C0229s.m1035a();
        ArrayList arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(C0228r.f997a, new String[]{"_id"}, "active_state = 16", null, null);
        int columnIndex = query.getColumnIndex("_id");
        while (query.moveToNext()) {
            arrayList.add(ContentUris.withAppendedId(C0228r.f997a, query.getLong(columnIndex)));
        }
        query.close();
        context.getContentResolver().update(C0228r.f997a, a, "active_state = ?", new String[]{"16"});
        context.getContentResolver().delete(C0228r.f997a, "active_state = 32 AND revision = 0", null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0332a.m1725a(context, (Uri) it.next());
        }
    }
}
