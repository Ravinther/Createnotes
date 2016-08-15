package com.socialnmobile.colornote.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class BackupTab extends TabActivity {
    private TabHost f641a;
    private TabWidget f642b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903042);
        this.f641a = getTabHost();
        this.f642b = getTabWidget();
        if (VERSION.SDK_INT >= 11) {
            m695a(SyncLogIn.class, 2131230737);
            m695a(BackupLocal.class, 2131230738);
        } else {
            m696b(SyncLogIn.class, 2131230737);
            m696b(BackupLocal.class, 2131230738);
        }
        this.f641a.setCurrentTab(0);
    }

    private void m695a(Class cls, int i) {
        this.f641a.addTab(this.f641a.newTabSpec("online").setIndicator(getString(i)).setContent(new Intent().setClass(this, cls)));
    }

    private void m696b(Class cls, int i) {
        Intent intent = new Intent().setClass(this, cls);
        View inflate = LayoutInflater.from(this).inflate(2130903079, this.f642b, false);
        ((TextView) inflate.findViewById(16908310)).setText(i);
        this.f641a.addTab(this.f641a.newTabSpec("online").setIndicator(inflate).setContent(intent));
    }
}
