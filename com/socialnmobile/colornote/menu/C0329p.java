package com.socialnmobile.colornote.menu;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.view.MyImageButton;

/* renamed from: com.socialnmobile.colornote.menu.p */
public final class C0329p {
    public int f1440a;
    public int f1441b;
    public int f1442c;
    public String f1443d;
    boolean f1444e;
    Drawable f1445f;
    boolean f1446g;
    public boolean f1447h;
    public boolean f1448i;

    public C0329p(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public C0329p(int i, int i2, int i3, String str) {
        this.f1440a = i;
        this.f1441b = i2;
        this.f1442c = i3;
        this.f1443d = str;
        if (i2 == 0) {
            this.f1444e = false;
        } else {
            this.f1444e = true;
        }
        this.f1446g = false;
        this.f1447h = true;
        this.f1448i = true;
    }

    public final void m1706a(int i) {
        this.f1441b = i;
        this.f1446g = false;
    }

    public final void m1707a(Drawable drawable) {
        this.f1445f = drawable;
        this.f1446g = true;
        this.f1444e = true;
    }

    public final void m1708a(MyImageButton myImageButton) {
        myImageButton.setVisibility(0);
        myImageButton.setBlockLayout(true);
        if (this.f1446g) {
            myImageButton.setImageDrawable(this.f1445f);
        } else {
            C0313j.m1646a(myImageButton.getResources(), (ImageView) myImageButton, this.f1441b);
            if (myImageButton.getDrawable() instanceof BitmapDrawable) {
                float f = myImageButton.getResources().getDisplayMetrics().density;
                myImageButton.setImageDrawable(new BitmapDrawable(myImageButton.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) myImageButton.getDrawable()).getBitmap(), (int) (36.0f * f), (int) (f * 36.0f), true)));
            }
        }
        myImageButton.setBlockLayout(false);
        myImageButton.setTitle(this.f1442c);
    }
}
