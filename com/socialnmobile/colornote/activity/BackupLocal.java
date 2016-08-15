package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.flurry.android.C0115a;
import com.socialnmobile.colornote.C0267e;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0214d;
import com.socialnmobile.colornote.data.C0218h;
import com.socialnmobile.colornote.dialog.C0170m;
import com.socialnmobile.colornote.dialog.C0245i;
import com.socialnmobile.colornote.dialog.C0249n;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;
import com.socialnmobile.colornote.view.C0411b;
import com.socialnmobile.util.service.C0477d;
import java.io.File;
import java.util.ArrayList;

public class BackupLocal extends Activity {
    Button f630a;
    ListView f631b;
    C0214d f632c;
    C0218h f633d;
    boolean f634e;
    Dialog f635f;
    boolean f636g;
    OnItemClickListener f637h;
    C0170m f638i;
    C0170m f639j;
    C0170m f640k;

    class SyncListener implements ServiceConnection, Listener {
        SyncListener() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ((SyncService) ((C0477d) iBinder).f2282a).m1746a(this);
            new Handler().post(new C0177m(this));
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public void onInit() {
            BackupLocal.this.m692a();
        }

        public void onFinalize() {
            new C0174j(BackupLocal.this).execute(new String[0]);
            BackupLocal.this.f636g = false;
        }

        public void onException(Exception exception) {
        }

        public void onError(AuthRequired authRequired) {
        }

        public void onProgress(int i, int i2) {
        }

        public void onFinished(Object obj) {
        }

        public void onError(UnsupportedClientVersion unsupportedClientVersion) {
        }
    }

    public BackupLocal() {
        this.f636g = false;
        this.f637h = new C0166c(this);
        this.f638i = new C0171g(this);
        this.f639j = new C0172h(this);
        this.f640k = new C0173i(this);
    }

    static /* synthetic */ void m691b(BackupLocal backupLocal) {
        if (!backupLocal.f636g) {
            backupLocal.f636g = true;
            if (!backupLocal.bindService(new Intent(backupLocal, SyncService.class), new SyncListener(), 1)) {
                ColorNote.m651a("NoteList bind SyncService FAILED");
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f632c = new C0214d(this);
        setContentView(2130903041);
        this.f630a = (Button) findViewById(2131623938);
        this.f630a.setOnClickListener(new C0165b(this));
        this.f631b = (ListView) findViewById(2131623939);
        this.f631b.setOnItemClickListener(this.f637h);
        this.f631b.setOnCreateContextMenuListener(this);
        m690b();
    }

    protected void onStart() {
        super.onStart();
        C0115a.m512a((Context) this, "7WTGHNWSX5PSDGSHN65D");
    }

    protected void onStop() {
        super.onStop();
        C0115a.m511a(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            showDialog(4);
        }
    }

    private void m690b() {
        this.f631b.setAdapter(new C0411b(this, this.f632c, this.f632c.m998e()));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        try {
            Object item = ((AdapterView) view).getAdapter().getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
            if (item != null) {
                this.f633d = (C0218h) item;
                contextMenu.setHeaderTitle(C0267e.m1197b(this, this.f633d.f957c));
                getMenuInflater().inflate(2131558412, contextMenu);
                if (this.f633d.f955a < 3) {
                    contextMenu.findItem(2131624189).setVisible(false);
                }
                if (C0367b.m1868a((Context) this)) {
                    contextMenu.findItem(2131624186).setVisible(false);
                }
                if (VERSION.SDK_INT >= 19 && this.f633d.f959e.equals(C0214d.m985c())) {
                    contextMenu.findItem(2131624169).setVisible(false);
                }
            }
        } catch (ClassCastException e) {
            ColorNote.m651a("bad menuInfo");
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624169:
                showDialog(7);
                return true;
            case 2131624186:
                showDialog(1);
                return true;
            case 2131624189:
                m693a(5, this.f638i);
                return true;
            case 2131624190:
                Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                intent.setType("plain/text");
                intent.putExtra("android.intent.extra.SUBJECT", getString(2131231058) + " - " + getString(2131230736));
                intent.putExtra("android.intent.extra.TEXT", getString(2131231058) + " - " + getString(2131230736));
                ArrayList arrayList = new ArrayList();
                if (this.f633d.m999a()) {
                    arrayList.add(Uri.fromFile(new File(this.f633d.f959e + this.f633d.f960f + ".doc")));
                } else {
                    arrayList.add(Uri.fromFile(new File(this.f633d.f959e + this.f633d.f960f + ".idx")));
                    arrayList.add(Uri.fromFile(new File(this.f633d.f959e + this.f633d.f960f + ".dat")));
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                startActivity(Intent.createChooser(intent, getString(2131230972)));
                break;
        }
        return false;
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                return C0313j.m1635a(this, 2131231072, 2131230772, new C0167d(this));
            case 3:
                return new C0245i(this, this.f639j, null, 2131230779);
            case 4:
                return new C0245i(this, this.f640k, null, 0);
            case 5:
                return new C0245i(this, this.f638i, null, 2131230779);
            case 6:
                return C0313j.m1634a(this, 2130837583, 2131230822, 2131230765, new C0169f(this));
            case 7:
                return C0313j.m1635a(this, 2131230824, 2131230764, new C0168e(this));
            default:
                return super.onCreateDialog(i);
        }
    }

    final void m693a(int i, C0170m c0170m) {
        if (!c0170m.m819a("0000")) {
            showDialog(i);
        }
    }

    final boolean m694a(String str, C0218h c0218h) {
        this.f632c.m990a(str);
        return this.f632c.m992a(c0218h);
    }

    final void m692a() {
        if (this.f635f == null) {
            this.f635f = new C0249n(this);
        }
        this.f635f.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131558402, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624161:
                showDialog(6);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
