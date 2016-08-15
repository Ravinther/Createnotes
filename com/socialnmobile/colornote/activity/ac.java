package com.socialnmobile.colornote.activity;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0222l;
import com.socialnmobile.colornote.data.ad;

final class ac implements OnClickListener {
    final /* synthetic */ PasswordSetting f781a;

    ac(PasswordSetting passwordSetting) {
        this.f781a = passwordSetting;
    }

    public final void onClick(View view) {
        String trim = this.f781a.f673c.getText().toString().trim();
        String trim2 = this.f781a.f674d.getText().toString().trim();
        if (this.f781a.f676f == 2 && !C0213c.m962a(this.f781a, this.f781a.f671a.getText().toString().trim())) {
            Toast.makeText(this.f781a, 2131230807, 1).show();
        } else if (trim.length() < 4) {
            Toast.makeText(this.f781a, 2131230904, 1).show();
        } else if (!trim.equals(trim2)) {
            Toast.makeText(this.f781a, 2131230903, 1).show();
        } else if (this.f781a.f676f == 2) {
            trim2 = null;
            if (C0213c.m965d(this.f781a)) {
                trim2 = C0213c.m964c(this.f781a);
            }
            PasswordSetting.m729a(this.f781a, trim);
            if (trim2 != null) {
                Context context = this.f781a;
                String b = C0213c.m963b(context);
                if (b != null) {
                    C0222l b2 = C0222l.m1009b(30);
                    b2.m1017b(b);
                    b2.m1019c(1);
                    trim2 = b2.m1018c(trim2);
                    Editor edit = ad.m920a(context, "name_master_password").edit();
                    edit.putString("CRYPTO_ENCRYPTED_USER_KEY", trim2);
                    edit.commit();
                }
            }
            this.f781a.setResult(-1);
            this.f781a.finish();
        } else {
            PasswordSetting.m729a(this.f781a, trim);
            this.f781a.setResult(-1);
            this.f781a.finish();
        }
    }
}
