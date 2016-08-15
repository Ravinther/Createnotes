package com.socialnmobile.colornote.view;

import android.database.DataSetObservable;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class af {
    DataSetObservable f847e;

    public abstract boolean m835a(View view, Object obj);

    public af() {
        this.f847e = new DataSetObservable();
    }

    public void m834a(Object obj) {
    }

    public void m831a() {
    }

    public Parcelable m836b() {
        return null;
    }

    public void m832a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Object m830a(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m833a(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
}
