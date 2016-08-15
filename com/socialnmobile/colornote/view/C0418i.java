package com.socialnmobile.colornote.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.p013g.C0307e;

/* renamed from: com.socialnmobile.colornote.view.i */
final class C0418i implements OnClickListener {
    final /* synthetic */ C0416g f2173a;

    C0418i(C0416g c0416g) {
        this.f2173a = c0416g;
    }

    public final void onClick(View view) {
        if (this.f2173a.f2163d) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(((C0307e) this.f2173a.f2161b.f968e.get(0)).f1360b));
            try {
                this.f2173a.f2162c.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this.f2173a.f2162c, 2131230794, 1).show();
                return;
            }
        }
        this.f2173a.m2212a();
    }
}
