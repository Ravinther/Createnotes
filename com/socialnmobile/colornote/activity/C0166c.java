package com.socialnmobile.colornote.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.view.C0412c;

/* renamed from: com.socialnmobile.colornote.activity.c */
final class C0166c implements OnItemClickListener {
    final /* synthetic */ BackupLocal f817a;

    C0166c(BackupLocal backupLocal) {
        this.f817a = backupLocal;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (((C0412c) view.getTag()).f2138e.f955a > 7) {
            Toast.makeText(this.f817a, 2131230799, 1).show();
        } else {
            this.f817a.f631b.showContextMenuForChild(view);
        }
    }
}
