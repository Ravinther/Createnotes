package com.socialnmobile.colornote.view;

import com.socialnmobile.colornote.ColorNote;

final class bn implements Runnable {
    final /* synthetic */ ScreenGridList f2107a;

    bn(ScreenGridList screenGridList) {
        this.f2107a = screenGridList;
    }

    public final void run() {
        ColorNote.m651a("Couldn't load cursor in GridList");
        this.f2107a.setGridListViewOptions(this.f2107a.f2008k.f1282b, this.f2107a.f2008k.f1283c, this.f2107a.f2008k.f1285e, this.f2107a.f2008k.f1286f, this.f2107a.f2008k.f1287g, this.f2107a.f2008k.f1284d, true, true);
    }
}
