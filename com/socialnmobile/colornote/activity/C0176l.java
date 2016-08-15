package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0218h;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.C0375c;
import java.util.UUID;

/* renamed from: com.socialnmobile.colornote.activity.l */
final class C0176l extends AsyncTask implements C0175k {
    int f825a;
    String f826b;
    int f827c;
    C0218h f828d;
    final /* synthetic */ BackupLocal f829e;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m825a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        this.f829e.f634e = false;
        this.f829e.f635f.dismiss();
        if (!bool.booleanValue()) {
            Toast.makeText(this.f829e, 2131230794, 1).show();
        } else if (this.f827c == 0) {
            Intent intent = new Intent("note.socialnmobile.intent.action.VIEW_BACKUP_ARCHIVE");
            intent.putExtra("EXTRA_BACKUP_TIME", this.f828d.f957c);
            this.f829e.startActivity(intent);
        } else if (this.f827c == 1) {
            C0367b c = C0367b.m1871c(this.f829e);
            if (c != null) {
                UUID randomUUID = UUID.randomUUID();
                C0375c a = c.m1875a();
                a.n.m2008a(randomUUID);
                a.q.m2008a(null);
                if (a.m1941a()) {
                    c.n.m2008a(randomUUID);
                    c.q.m2008a(null);
                }
            }
            Toast.makeText(this.f829e, 2131230787, 1).show();
            this.f829e.finish();
        }
    }

    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    C0176l(BackupLocal backupLocal, String str, C0218h c0218h, int i) {
        this.f829e = backupLocal;
        this.f826b = str;
        this.f827c = i;
        this.f828d = c0218h;
    }

    private Boolean m825a() {
        publishProgress(new Integer[]{Integer.valueOf(0)});
        this.f829e.f632c.m990a(this.f826b);
        try {
            boolean a;
            if (this.f827c == 0) {
                a = this.f829e.f632c.m993a(this.f828d, (C0175k) this);
            } else if (this.f827c == 1) {
                C0229s.m1049b(this.f829e.f632c.f949a);
                a = this.f829e.f632c.m994a(this.f828d, (C0175k) this, false);
                if (a) {
                    ColorNote.m654c();
                }
            } else {
                a = false;
            }
            return Boolean.valueOf(a);
        } catch (Throwable e) {
            e.printStackTrace();
            C0311h.f1370a.m1624a("RESTORETASK1:" + this.f827c, e);
            return Boolean.valueOf(false);
        } catch (Throwable e2) {
            e2.printStackTrace();
            C0311h.f1370a.m1624a("RESTORETASK2:" + this.f827c, e2);
            return Boolean.valueOf(false);
        } catch (Throwable e22) {
            e22.printStackTrace();
            C0311h.f1370a.m1624a("RESTORETASK3:" + this.f827c, e22);
            return Boolean.valueOf(false);
        }
    }

    public final void m826a(int i) {
        this.f825a = i;
    }

    public final void m827b(int i) {
        publishProgress(new Integer[]{Integer.valueOf(i)});
    }

    protected final void onPreExecute() {
        this.f829e.f634e = true;
        this.f829e.m692a();
    }
}
