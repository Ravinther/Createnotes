package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0222l;
import com.socialnmobile.colornote.data.ad;

public class PasswordSetting extends Activity {
    EditText f671a;
    View f672b;
    EditText f673c;
    EditText f674d;
    Button f675e;
    int f676f;
    OnClickListener f677g;

    public PasswordSetting() {
        this.f677g = new ac(this);
    }

    static /* synthetic */ void m729a(PasswordSetting passwordSetting, String str) {
        int i;
        C0222l b = C0222l.m1009b(30);
        b.m1016a(str);
        b.m1019c(1);
        String a = b.m1012a();
        String c = b.m1018c(a);
        if (c == null) {
            i = 0;
        } else {
            Editor edit = ad.m920a((Context) passwordSetting, "name_master_password").edit();
            edit.putString("BACKUP_SECRET_KEY", a);
            edit.putString("BACKUP_ENCRYPTED_DATA", c);
            edit.commit();
            i = 1;
        }
        if (i == 0) {
            Toast.makeText(passwordSetting, 2131230794, 1).show();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903045);
        this.f671a = (EditText) findViewById(2131623955);
        this.f672b = findViewById(2131623954);
        this.f673c = (EditText) findViewById(2131623956);
        this.f674d = (EditText) findViewById(2131623957);
        this.f675e = (Button) findViewById(2131623958);
        if ("note.socialnmobile.intent.action.CHANGE_MASTER_PASSWORD".equalsIgnoreCase(getIntent().getAction()) && C0213c.m961a(this)) {
            this.f676f = 2;
            this.f671a.setVisibility(0);
            this.f672b.setVisibility(0);
            this.f675e.setText(2131230743);
        } else {
            this.f676f = 1;
        }
        this.f675e.setOnClickListener(this.f677g);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f676f != 2) {
            return false;
        }
        getMenuInflater().inflate(2131558409, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624188:
                showDialog(1);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                return C0313j.m1634a(this, 2130837583, 2131230959, 2131230771, new ad(this));
            default:
                return super.onCreateDialog(i);
        }
    }
}
