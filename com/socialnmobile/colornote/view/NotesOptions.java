package com.socialnmobile.colornote.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.fragment.NoteListFragment;

public class NotesOptions extends RelativeLayout {
    NoteListFragment f1971a;
    Dialog f1972b;
    MyViewPager f1973c;
    View[] f1974d;
    TextView[] f1975e;
    OnClickListener f1976f;
    ao f1977g;

    public NotesOptions(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1974d = new View[2];
        this.f1975e = new TextView[2];
        this.f1976f = new be(this);
        this.f1977g = new bf(this);
    }

    public NotesOptions(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1974d = new View[2];
        this.f1975e = new TextView[2];
        this.f1976f = new be(this);
        this.f1977g = new bf(this);
    }

    public NotesOptions(Context context) {
        super(context, null);
        this.f1974d = new View[2];
        this.f1975e = new TextView[2];
        this.f1976f = new be(this);
        this.f1977g = new bf(this);
    }

    public final void m2125a(NoteListFragment noteListFragment, Dialog dialog) {
        this.f1971a = noteListFragment;
        this.f1972b = dialog;
        Context context = this.f1971a.f48C;
        this.f1973c = (MyViewPager) findViewById(2131623942);
        this.f1974d[0] = findViewById(2131624125);
        this.f1974d[1] = findViewById(2131624126);
        this.f1975e[0] = (TextView) findViewById(2131624122);
        this.f1975e[1] = (TextView) findViewById(2131624123);
        for (View onClickListener : this.f1975e) {
            onClickListener.setOnClickListener(this.f1976f);
        }
        this.f1973c.setPageMargin(C0313j.m1664c(context, 10));
        this.f1973c.setAdapter(new bg(this));
        this.f1973c.setOnPageChangeListener(this.f1977g);
        this.f1973c.setCurrentItem(0);
        m2124a(0);
    }

    final void m2124a(int i) {
        int i2 = 0;
        int n = C0209d.m875a(getContext()).m1145n(13);
        for (View visibility : this.f1974d) {
            visibility.setVisibility(4);
        }
        this.f1974d[i].setVisibility(0);
        TextView[] textViewArr = this.f1975e;
        int length = textViewArr.length;
        while (i2 < length) {
            TextView textView = textViewArr[i2];
            textView.setTextColor(C0313j.m1632a(85, n));
            textView.setTypeface(Typeface.DEFAULT);
            i2++;
        }
        this.f1975e[i].setTextColor(n);
        this.f1975e[i].setTypeface(Typeface.DEFAULT_BOLD);
    }
}
