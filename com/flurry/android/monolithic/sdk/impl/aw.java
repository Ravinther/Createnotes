package com.flurry.android.monolithic.sdk.impl;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class aw implements LocationListener {
    final /* synthetic */ av f487a;

    public aw(av avVar) {
        this.f487a = avVar;
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            this.f487a.f477b = location;
        }
    }
}
