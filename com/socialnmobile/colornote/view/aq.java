package com.socialnmobile.colornote.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p001b.C0041a;
import android.view.View.BaseSavedState;

public final class aq extends BaseSavedState {
    public static final Creator CREATOR;
    int f2037a;
    Parcelable f2038b;
    ClassLoader f2039c;

    public aq(Parcelable parcelable) {
        super(parcelable);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2037a);
        parcel.writeParcelable(this.f2038b, i);
    }

    public final String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f2037a + "}";
    }

    static {
        CREATOR = C0041a.m219a(new ar());
    }

    aq(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        this.f2037a = parcel.readInt();
        this.f2038b = parcel.readParcelable(classLoader);
        this.f2039c = classLoader;
    }
}
