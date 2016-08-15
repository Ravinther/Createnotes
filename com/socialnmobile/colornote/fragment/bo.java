package com.socialnmobile.colornote.fragment;

import android.content.ContentUris;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.socialnmobile.colornote.activity.NoteWidgetConfigure;

final class bo implements OnItemClickListener {
    final /* synthetic */ NoteListFragment f1264a;

    bo(NoteListFragment noteListFragment) {
        this.f1264a = noteListFragment;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f1264a.ah != 1) {
            this.f1264a.m1310b(j);
        } else if (this.f1264a.f48C instanceof NoteWidgetConfigure) {
            ((NoteWidgetConfigure) this.f1264a.f48C).m725a(j);
        } else {
            this.f1264a.f48C.setResult(-1, new Intent().setData(ContentUris.withAppendedId(this.f1264a.m1321z(), j)));
            this.f1264a.f48C.finish();
        }
    }
}
