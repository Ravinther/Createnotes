package com.socialnmobile.colornote.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;

final class bg extends af {
    final /* synthetic */ NotesOptions f2099a;

    public bg(NotesOptions notesOptions) {
        this.f2099a = notesOptions;
    }

    public final Object m2192a(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater from = LayoutInflater.from(context);
        ListView listView;
        TopBarSubMenuInfo a;
        if (i == 0) {
            listView = (ListView) from.inflate(2130903093, viewGroup, false);
            a = C0330r.m1711a(this.f2099a.f1971a, this.f2099a.f1971a.m1312c("BAR"));
            listView.setAdapter(a.m1683b(context));
            listView.setOnItemClickListener(new bh(this.f2099a, a));
            viewGroup.addView(listView);
            return listView;
        } else if (i != 1) {
            return null;
        } else {
            listView = (ListView) from.inflate(2130903093, viewGroup, false);
            a = C0330r.m1709a(context, this.f2099a.f1971a.m1316d("BAR"));
            listView.setAdapter(a.m1683b(context));
            listView.setOnItemClickListener(new bh(this.f2099a, a));
            viewGroup.addView(listView);
            return listView;
        }
    }

    public final void m2193a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final boolean m2194a(View view, Object obj) {
        return view == obj;
    }
}
