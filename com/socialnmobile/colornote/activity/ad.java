package com.socialnmobile.colornote.activity;

import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.receiver.C0332a;
import java.util.ArrayList;
import java.util.Iterator;

final class ad implements OnClickListener {
    final /* synthetic */ PasswordSetting f782a;

    ad(PasswordSetting passwordSetting) {
        this.f782a = passwordSetting;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context = this.f782a;
        Editor edit = com.socialnmobile.colornote.data.ad.m920a(context, "name_master_password").edit();
        edit.remove("BACKUP_SECRET_KEY");
        edit.remove("BACKUP_ENCRYPTED_DATA");
        edit.remove("CRYPTO_ENCRYPTED_USER_KEY");
        edit.commit();
        if (C0212b.m936a(context, "BACKUP_SECRET_KEY", null) != null) {
            Editor edit2 = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit2.remove("BACKUP_SECRET_KEY");
            edit2.remove("BACKUP_ENCRYPTED_DATA");
            edit2.remove("CRYPTO_ENCRYPTED_USER_KEY");
            edit2.commit();
        }
        Context context2 = this.f782a;
        ArrayList arrayList = new ArrayList();
        Cursor query = context2.getContentResolver().query(C0228r.f997a, new String[]{"_id"}, "encrypted <> 0", null, null);
        int columnIndex = query.getColumnIndex("_id");
        while (query.moveToNext()) {
            arrayList.add(ContentUris.withAppendedId(C0228r.f997a, query.getLong(columnIndex)));
        }
        query.close();
        context2.getContentResolver().update(C0228r.f997a, C0229s.m1035a(), "encrypted <> 0", null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0332a.m1725a(context2, (Uri) it.next());
        }
        this.f782a.finish();
    }
}
