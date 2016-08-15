package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0221k;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import com.socialnmobile.colornote.fragment.cd;
import com.socialnmobile.colornote.view.C0419j;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.socialnmobile.colornote.dialog.a */
public final class C0237a extends Dialog implements cd {
    ArrayList f1047a;
    HashMap f1048b;
    int f1049c;
    int f1050d;
    OnItemClickListener f1051e;
    OnItemLongClickListener f1052f;
    private NoteListFragment f1053g;
    private GridView f1054h;
    private C0419j f1055i;

    protected final void onStart() {
        m1123b();
        this.f1053g.f1158Z = this;
    }

    protected final void onStop() {
        super.onStop();
        NoteListFragment noteListFragment = this.f1053g;
        if (noteListFragment.f1158Z == this) {
            noteListFragment.f1158Z = null;
        }
    }

    public final void m1125a() {
        m1123b();
    }

    private void m1123b() {
        int i = this.f1053g.m1297G().f1286f;
        int i2 = this.f1053g.m1297G().f1287g;
        this.f1049c = i;
        this.f1050d = i2;
        if (this.f1049c != -1) {
            this.f1055i.f2175b = true;
        } else {
            this.f1055i.f2175b = false;
        }
        m1124c();
        this.f1047a.clear();
        m1124c();
        if (this.f1049c != -1) {
            Context context = getContext();
            i2 = this.f1049c;
            int i3 = this.f1050d;
            String str = "active_state = 0 AND account_id = 0 AND folder_id = " + i2;
            if (i3 != -1) {
                str = str + " AND space = " + i3;
            }
            Cursor query = context.getContentResolver().query(C0228r.f999c, null, str, null, null);
            if (query.moveToFirst()) {
                i = 0;
                do {
                    int i4 = query.getInt(query.getColumnIndex(NoteMinorColumns.COLOR));
                    int i5 = query.getInt(query.getColumnIndex("notes_count"));
                    this.f1048b.put(Integer.valueOf(i4), Integer.valueOf(i5));
                    i += i5;
                } while (query.moveToNext());
            } else {
                i = 0;
            }
            query.close();
        } else {
            i = 0;
        }
        this.f1047a.add(new C0221k(0, getContext().getString(2131230729), i));
        m1121a(1);
        m1121a(2);
        m1121a(3);
        m1121a(4);
        m1121a(5);
        m1121a(6);
        m1121a(7);
        m1121a(8);
        m1121a(9);
        this.f1055i.notifyDataSetChanged();
    }

    private void m1121a(int i) {
        this.f1047a.add(new C0221k(i, C0213c.m959a(getContext(), this.f1049c, i), ((Integer) this.f1048b.get(Integer.valueOf(i))).intValue()));
    }

    private void m1124c() {
        this.f1048b.put(Integer.valueOf(1), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(2), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(3), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(4), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(5), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(6), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(7), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(8), Integer.valueOf(0));
        this.f1048b.put(Integer.valueOf(9), Integer.valueOf(0));
    }

    public C0237a(NoteListFragment noteListFragment) {
        super(noteListFragment.f48C);
        this.f1047a = new ArrayList();
        this.f1048b = new HashMap();
        this.f1051e = new C0238b(this);
        this.f1052f = new C0239c(this);
        setTitle(2131230823);
        this.f1053g = noteListFragment;
        setContentView(2130903052);
        setCanceledOnTouchOutside(true);
        this.f1054h = (GridView) findViewById(2131624008);
        this.f1054h.setOnItemLongClickListener(this.f1052f);
        this.f1054h.setOnItemClickListener(this.f1051e);
        this.f1055i = new C0419j(getContext(), this.f1047a);
        this.f1054h.setAdapter(this.f1055i);
        this.f1054h.setBackgroundColor(C0209d.m875a(noteListFragment.f48C).m1145n(12));
    }
}
