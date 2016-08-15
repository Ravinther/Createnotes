package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class DialogFragment extends C0015f implements OnCancelListener, OnDismissListener {
    int f87a;
    int f88b;
    boolean f89c;
    public boolean f90d;
    int f91e;
    public Dialog f92f;
    boolean f93g;
    boolean f94h;
    boolean f95i;

    public DialogFragment() {
        this.f87a = 0;
        this.f88b = 0;
        this.f89c = true;
        this.f90d = true;
        this.f91e = -1;
    }

    public void m85a(C0031p c0031p, String str) {
        this.f94h = false;
        this.f95i = true;
        C0017z a = c0031p.m158a();
        a.m130a((C0015f) this, str);
        a.m131b();
    }

    public void m82a() {
        m86a(false);
    }

    public final void m86a(boolean z) {
        if (!this.f94h) {
            this.f94h = true;
            this.f95i = false;
            if (this.f92f != null) {
                this.f92f.dismiss();
                this.f92f = null;
            }
            this.f93g = true;
            if (this.f91e >= 0) {
                this.f47B.m161b(this.f91e);
                this.f91e = -1;
                return;
            }
            C0017z a = this.f47B.m158a();
            a.m129a((C0015f) this);
            if (z) {
                a.m133c();
            } else {
                a.m131b();
            }
        }
    }

    public final void m83a(Activity activity) {
        super.m53a(activity);
        if (!this.f95i) {
            this.f94h = false;
        }
    }

    public final void m88b() {
        super.m62b();
        if (!this.f95i && !this.f94h) {
            this.f94h = true;
        }
    }

    public void m84a(Bundle bundle) {
        super.m56a(bundle);
        this.f90d = this.G == 0;
        if (bundle != null) {
            this.f87a = bundle.getInt("android:style", 0);
            this.f88b = bundle.getInt("android:theme", 0);
            this.f89c = bundle.getBoolean("android:cancelable", true);
            this.f90d = bundle.getBoolean("android:showsDialog", this.f90d);
            this.f91e = bundle.getInt("android:backStackId", -1);
        }
    }

    public final LayoutInflater m87b(Bundle bundle) {
        if (!this.f90d) {
            return super.m60b(bundle);
        }
        this.f92f = m89c(bundle);
        switch (this.f87a) {
            case 1:
            case 2:
                break;
            case 3:
                this.f92f.getWindow().addFlags(24);
                break;
        }
        this.f92f.requestWindowFeature(1);
        if (this.f92f != null) {
            return (LayoutInflater) this.f92f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.C.getSystemService("layout_inflater");
    }

    public Dialog m89c(Bundle bundle) {
        return new Dialog(this.f48C, this.f88b);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f93g) {
            m86a(true);
        }
    }

    public void m92d(Bundle bundle) {
        super.m67d(bundle);
        if (this.f90d) {
            View view = this.f63R;
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f92f.setContentView(view);
            }
            this.f92f.setOwnerActivity(this.f48C);
            this.f92f.setCancelable(this.f89c);
            this.f92f.setOnCancelListener(this);
            this.f92f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f92f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void m90c() {
        super.m65c();
        if (this.f92f != null) {
            this.f93g = false;
            this.f92f.show();
        }
    }

    public final void m94e(Bundle bundle) {
        super.m69e(bundle);
        if (this.f92f != null) {
            Bundle onSaveInstanceState = this.f92f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f87a != 0) {
            bundle.putInt("android:style", this.f87a);
        }
        if (this.f88b != 0) {
            bundle.putInt("android:theme", this.f88b);
        }
        if (!this.f89c) {
            bundle.putBoolean("android:cancelable", this.f89c);
        }
        if (!this.f90d) {
            bundle.putBoolean("android:showsDialog", this.f90d);
        }
        if (this.f91e != -1) {
            bundle.putInt("android:backStackId", this.f91e);
        }
    }

    public void m91d() {
        super.m66d();
        if (this.f92f != null) {
            this.f92f.hide();
        }
    }

    public final void m93e() {
        super.m68e();
        if (this.f92f != null) {
            this.f93g = true;
            this.f92f.dismiss();
            this.f92f = null;
        }
    }
}
