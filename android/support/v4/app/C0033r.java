package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p002c.C0051d;
import android.support.v4.p002c.C0052e;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: android.support.v4.app.r */
final class C0033r extends C0031p {
    static final Interpolator f179A;
    static final Interpolator f180B;
    static final Interpolator f181C;
    static boolean f182a;
    static final boolean f183b;
    static final Interpolator f184z;
    ArrayList f185c;
    Runnable[] f186d;
    boolean f187e;
    ArrayList f188f;
    ArrayList f189g;
    ArrayList f190h;
    ArrayList f191i;
    ArrayList f192j;
    ArrayList f193k;
    ArrayList f194l;
    ArrayList f195m;
    int f196n;
    FragmentActivity f197o;
    C0022o f198p;
    C0015f f199q;
    boolean f200r;
    boolean f201s;
    boolean f202t;
    String f203u;
    boolean f204v;
    Bundle f205w;
    SparseArray f206x;
    Runnable f207y;

    C0033r() {
        this.f196n = 0;
        this.f205w = null;
        this.f206x = null;
        this.f207y = new C0034s(this);
    }

    static {
        boolean z = false;
        f182a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f183b = z;
        f184z = new DecelerateInterpolator(2.5f);
        f179A = new DecelerateInterpolator(1.5f);
        f180B = new AccelerateInterpolator(2.5f);
        f181C = new AccelerateInterpolator(1.5f);
    }

    private void m170a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0052e("FragmentManager"));
        if (this.f197o != null) {
            try {
                this.f197o.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m191a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public final C0017z m180a() {
        return new C0018b(this);
    }

    public final boolean m200b() {
        return m209f();
    }

    public final boolean m204c() {
        m174p();
        m209f();
        return m192a(-1, 0);
    }

    public final void m196b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m190a(new C0035t(this, i), false);
    }

    public final int m205d() {
        return this.f191i != null ? this.f191i.size() : 0;
    }

    public final void m189a(C0032q c0032q) {
        if (this.f195m == null) {
            this.f195m = new ArrayList();
        }
        this.f195m.add(c0032q);
    }

    public final void m183a(Bundle bundle, String str, C0015f c0015f) {
        if (c0015f.f75o < 0) {
            m170a(new IllegalStateException("Fragment " + c0015f + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, c0015f.f75o);
    }

    public final C0015f m177a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f188f.size()) {
            m170a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        C0015f c0015f = (C0015f) this.f188f.get(i);
        if (c0015f != null) {
            return c0015f;
        }
        m170a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return c0015f;
    }

    public final C0025i m179a(C0015f c0015f) {
        if (c0015f.f75o < 0) {
            m170a(new IllegalStateException("Fragment " + c0015f + " is not currently in the FragmentManager"));
        }
        if (c0015f.f70j <= 0) {
            return null;
        }
        Bundle d = m173d(c0015f);
        if (d != null) {
            return new C0025i(d);
        }
        return null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f199q != null) {
            C0051d.m256a(this.f199q, stringBuilder);
        } else {
            C0051d.m256a(this.f197o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void m191a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        C0015f c0015f;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f188f != null) {
            size = this.f188f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c0015f = (C0015f) this.f188f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0015f);
                    if (c0015f != null) {
                        printWriter.print(str2);
                        printWriter.print("mFragmentId=#");
                        printWriter.print(Integer.toHexString(c0015f.f51F));
                        printWriter.print(" mContainerId=#");
                        printWriter.print(Integer.toHexString(c0015f.f52G));
                        printWriter.print(" mTag=");
                        printWriter.println(c0015f.f53H);
                        printWriter.print(str2);
                        printWriter.print("mState=");
                        printWriter.print(c0015f.f70j);
                        printWriter.print(" mIndex=");
                        printWriter.print(c0015f.f75o);
                        printWriter.print(" mWho=");
                        printWriter.print(c0015f.f76p);
                        printWriter.print(" mBackStackNesting=");
                        printWriter.println(c0015f.f46A);
                        printWriter.print(str2);
                        printWriter.print("mAdded=");
                        printWriter.print(c0015f.f81u);
                        printWriter.print(" mRemoving=");
                        printWriter.print(c0015f.f82v);
                        printWriter.print(" mResumed=");
                        printWriter.print(c0015f.f83w);
                        printWriter.print(" mFromLayout=");
                        printWriter.print(c0015f.f84x);
                        printWriter.print(" mInLayout=");
                        printWriter.println(c0015f.f85y);
                        printWriter.print(str2);
                        printWriter.print("mHidden=");
                        printWriter.print(c0015f.f54I);
                        printWriter.print(" mDetached=");
                        printWriter.print(c0015f.f55J);
                        printWriter.print(" mMenuVisible=");
                        printWriter.print(c0015f.f59N);
                        printWriter.print(" mHasMenu=");
                        printWriter.println(c0015f.f58M);
                        printWriter.print(str2);
                        printWriter.print("mRetainInstance=");
                        printWriter.print(c0015f.f56K);
                        printWriter.print(" mRetaining=");
                        printWriter.print(c0015f.f57L);
                        printWriter.print(" mUserVisibleHint=");
                        printWriter.println(c0015f.f66U);
                        if (c0015f.f47B != null) {
                            printWriter.print(str2);
                            printWriter.print("mFragmentManager=");
                            printWriter.println(c0015f.f47B);
                        }
                        if (c0015f.f48C != null) {
                            printWriter.print(str2);
                            printWriter.print("mActivity=");
                            printWriter.println(c0015f.f48C);
                        }
                        if (c0015f.f50E != null) {
                            printWriter.print(str2);
                            printWriter.print("mParentFragment=");
                            printWriter.println(c0015f.f50E);
                        }
                        if (c0015f.f77q != null) {
                            printWriter.print(str2);
                            printWriter.print("mArguments=");
                            printWriter.println(c0015f.f77q);
                        }
                        if (c0015f.f73m != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedFragmentState=");
                            printWriter.println(c0015f.f73m);
                        }
                        if (c0015f.f74n != null) {
                            printWriter.print(str2);
                            printWriter.print("mSavedViewState=");
                            printWriter.println(c0015f.f74n);
                        }
                        if (c0015f.f78r != null) {
                            printWriter.print(str2);
                            printWriter.print("mTarget=");
                            printWriter.print(c0015f.f78r);
                            printWriter.print(" mTargetRequestCode=");
                            printWriter.println(c0015f.f80t);
                        }
                        if (c0015f.f61P != 0) {
                            printWriter.print(str2);
                            printWriter.print("mNextAnim=");
                            printWriter.println(c0015f.f61P);
                        }
                        if (c0015f.f62Q != null) {
                            printWriter.print(str2);
                            printWriter.print("mContainer=");
                            printWriter.println(c0015f.f62Q);
                        }
                        if (c0015f.f63R != null) {
                            printWriter.print(str2);
                            printWriter.print("mView=");
                            printWriter.println(c0015f.f63R);
                        }
                        if (c0015f.f64S != null) {
                            printWriter.print(str2);
                            printWriter.print("mInnerView=");
                            printWriter.println(c0015f.f63R);
                        }
                        if (c0015f.f71k != null) {
                            printWriter.print(str2);
                            printWriter.print("mAnimatingAway=");
                            printWriter.println(c0015f.f71k);
                            printWriter.print(str2);
                            printWriter.print("mStateAfterAnimating=");
                            printWriter.println(c0015f.f72l);
                        }
                        if (c0015f.f67V != null) {
                            printWriter.print(str2);
                            printWriter.println("Loader Manager:");
                            c0015f.f67V.m110a(str2 + "  ", fileDescriptor, printWriter, strArr);
                        }
                        if (c0015f.f49D != null) {
                            printWriter.print(str2);
                            printWriter.println("Child " + c0015f.f49D + ":");
                            c0015f.f49D.m191a(str2 + "  ", fileDescriptor, printWriter, strArr);
                        }
                    }
                }
            }
        }
        if (this.f189g != null) {
            size = this.f189g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    c0015f = (C0015f) this.f189g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0015f.toString());
                }
            }
        }
        if (this.f192j != null) {
            size = this.f192j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0015f = (C0015f) this.f192j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0015f.toString());
                }
            }
        }
        if (this.f191i != null) {
            size = this.f191i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0018b c0018b = (C0018b) this.f191i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0018b.toString());
                    c0018b.m143a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.f193k != null) {
                int size2 = this.f193k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0018b = (C0018b) this.f193k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0018b);
                    }
                }
            }
            if (this.f194l != null && this.f194l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f194l.toArray()));
            }
        }
        if (this.f185c != null) {
            i = this.f185c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f185c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f197o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f198p);
        if (this.f199q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f199q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f196n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f201s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f202t);
        if (this.f200r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f200r);
        }
        if (this.f203u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f203u);
        }
        if (this.f190h != null && this.f190h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f190h.toArray()));
        }
    }

    private static Animation m167a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f184z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f179A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private static Animation m166a(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f179A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private Animation m168a(C0015f c0015f, int i, boolean z, int i2) {
        int i3 = c0015f.f61P;
        C0015f.m46m();
        if (c0015f.f61P != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f197o, c0015f.f61P);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        switch (obj) {
            case 1:
                return C0033r.m167a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0033r.m167a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0033r.m167a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0033r.m167a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0033r.m166a(0.0f, 1.0f);
            case 6:
                return C0033r.m166a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f197o.getWindow() != null) {
                    i2 = this.f197o.getWindow().getAttributes().windowAnimations;
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m187a(android.support.v4.app.C0015f r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.f81u;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f55J;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f82v;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f70j;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f70j;
    L_0x001a:
        r0 = r11.f65T;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f70j;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f70j;
        if (r0 >= r12) goto L_0x0350;
    L_0x0029:
        r0 = r11.f84x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f85y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f71k;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f71k = r7;
        r2 = r11.f72l;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m187a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f70j;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x016b;
            case 2: goto L_0x0292;
            case 3: goto L_0x0292;
            case 4: goto L_0x02ef;
            default: goto L_0x0045;
        };
    L_0x0045:
        r11.f70j = r12;
        goto L_0x0031;
    L_0x0048:
        r0 = f182a;
        if (r0 == 0) goto L_0x0060;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0060:
        r0 = r11.f73m;
        if (r0 == 0) goto L_0x0099;
    L_0x0064:
        r0 = r11.f73m;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f74n = r0;
        r0 = r11.f73m;
        r1 = "android:target_state";
        r0 = r10.m177a(r0, r1);
        r11.f78r = r0;
        r0 = r11.f78r;
        if (r0 == 0) goto L_0x0086;
    L_0x007c:
        r0 = r11.f73m;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f80t = r0;
    L_0x0086:
        r0 = r11.f73m;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f66U = r0;
        r0 = r11.f66U;
        if (r0 != 0) goto L_0x0099;
    L_0x0094:
        r11.f65T = r5;
        if (r12 <= r6) goto L_0x0099;
    L_0x0098:
        r12 = r6;
    L_0x0099:
        r0 = r10.f197o;
        r11.f48C = r0;
        r0 = r10.f199q;
        r11.f50E = r0;
        r0 = r10.f199q;
        if (r0 == 0) goto L_0x00d1;
    L_0x00a5:
        r0 = r10.f199q;
        r0 = r0.f49D;
    L_0x00a9:
        r11.f47B = r0;
        r11.f60O = r3;
        r0 = r10.f197o;
        r11.m53a(r0);
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x00d6;
    L_0x00b6:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00d1:
        r0 = r10.f197o;
        r0 = r0.f97b;
        goto L_0x00a9;
    L_0x00d6:
        r0 = r11.f50E;
        r0 = r11.f57L;
        if (r0 != 0) goto L_0x0135;
    L_0x00dc:
        r0 = r11.f73m;
        r1 = r11.f49D;
        if (r1 == 0) goto L_0x00e6;
    L_0x00e2:
        r1 = r11.f49D;
        r1.f201s = r3;
    L_0x00e6:
        r11.f60O = r3;
        r11.m56a(r0);
        r1 = r11.f60O;
        if (r1 != 0) goto L_0x010a;
    L_0x00ef:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onCreate()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x010a:
        if (r0 == 0) goto L_0x0135;
    L_0x010c:
        r1 = "android:support:fragments";
        r0 = r0.getParcelable(r1);
        if (r0 == 0) goto L_0x0135;
    L_0x0114:
        r1 = r11.f49D;
        if (r1 != 0) goto L_0x012b;
    L_0x0118:
        r1 = new android.support.v4.app.r;
        r1.<init>();
        r11.f49D = r1;
        r1 = r11.f49D;
        r2 = r11.f48C;
        r4 = new android.support.v4.app.g;
        r4.<init>(r11);
        r1.m185a(r2, r4, r11);
    L_0x012b:
        r1 = r11.f49D;
        r1.m184a(r0, r7);
        r0 = r11.f49D;
        r0.m212i();
    L_0x0135:
        r11.f57L = r3;
        r0 = r11.f84x;
        if (r0 == 0) goto L_0x016b;
    L_0x013b:
        r0 = r11.f73m;
        r0 = r11.m60b(r0);
        r1 = r11.f73m;
        r0 = r11.m61b(r0, r1);
        r11.f63R = r0;
        r0 = r11.f63R;
        if (r0 == 0) goto L_0x024a;
    L_0x014d:
        r0 = r11.f63R;
        r11.f64S = r0;
        r0 = r11.f63R;
        r0 = android.support.v4.app.ae.m124a(r0);
        r11.f63R = r0;
        r0 = r11.f54I;
        if (r0 == 0) goto L_0x0164;
    L_0x015d:
        r0 = r11.f63R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0164:
        r0 = r11.f63R;
        r0 = r11.f73m;
        android.support.v4.app.C0015f.m47n();
    L_0x016b:
        if (r12 <= r5) goto L_0x0292;
    L_0x016d:
        r0 = f182a;
        if (r0 == 0) goto L_0x0185;
    L_0x0171:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto ACTIVITY_CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0185:
        r0 = r11.f84x;
        if (r0 != 0) goto L_0x021c;
    L_0x0189:
        r0 = r11.f52G;
        if (r0 == 0) goto L_0x05ac;
    L_0x018d:
        r0 = r10.f198p;
        r1 = r11.f52G;
        r0 = r0.m151a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01d8;
    L_0x0199:
        r1 = r11.f86z;
        if (r1 != 0) goto L_0x01d8;
    L_0x019d:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r4 = "No view found for id 0x";
        r2.<init>(r4);
        r4 = r11.f52G;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m70f();
        r8 = r11.f52G;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m170a(r1);
    L_0x01d8:
        r11.f62Q = r0;
        r1 = r11.f73m;
        r1 = r11.m60b(r1);
        r2 = r11.f73m;
        r1 = r11.m61b(r1, r2);
        r11.f63R = r1;
        r1 = r11.f63R;
        if (r1 == 0) goto L_0x024e;
    L_0x01ec:
        r1 = r11.f63R;
        r11.f64S = r1;
        r1 = r11.f63R;
        r1 = android.support.v4.app.ae.m124a(r1);
        r11.f63R = r1;
        if (r0 == 0) goto L_0x020a;
    L_0x01fa:
        r1 = r10.m168a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0205;
    L_0x0200:
        r2 = r11.f63R;
        r2.startAnimation(r1);
    L_0x0205:
        r1 = r11.f63R;
        r0.addView(r1);
    L_0x020a:
        r0 = r11.f54I;
        if (r0 == 0) goto L_0x0215;
    L_0x020e:
        r0 = r11.f63R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0215:
        r0 = r11.f63R;
        r0 = r11.f73m;
        android.support.v4.app.C0015f.m47n();
    L_0x021c:
        r0 = r11.f73m;
        r1 = r11.f49D;
        if (r1 == 0) goto L_0x0226;
    L_0x0222:
        r1 = r11.f49D;
        r1.f201s = r3;
    L_0x0226:
        r11.f60O = r3;
        r11.m67d(r0);
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x0251;
    L_0x022f:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onActivityCreated()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x024a:
        r11.f64S = r7;
        goto L_0x016b;
    L_0x024e:
        r11.f64S = r7;
        goto L_0x021c;
    L_0x0251:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x025a;
    L_0x0255:
        r0 = r11.f49D;
        r0.m213j();
    L_0x025a:
        r0 = r11.f63R;
        if (r0 == 0) goto L_0x0290;
    L_0x025e:
        r0 = r11.f73m;
        r0 = r11.f74n;
        if (r0 == 0) goto L_0x026d;
    L_0x0264:
        r0 = r11.f64S;
        r1 = r11.f74n;
        r0.restoreHierarchyState(r1);
        r11.f74n = r7;
    L_0x026d:
        r11.f60O = r3;
        r11.f60O = r5;
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x0290;
    L_0x0275:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onViewStateRestored()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0290:
        r11.f73m = r7;
    L_0x0292:
        if (r12 <= r6) goto L_0x02ef;
    L_0x0294:
        r0 = f182a;
        if (r0 == 0) goto L_0x02ac;
    L_0x0298:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto STARTED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ac:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x02b9;
    L_0x02b0:
        r0 = r11.f49D;
        r0.f201s = r3;
        r0 = r11.f49D;
        r0.m209f();
    L_0x02b9:
        r11.f60O = r3;
        r11.m65c();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x02dd;
    L_0x02c2:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStart()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02dd:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x02e6;
    L_0x02e1:
        r0 = r11.f49D;
        r0.m214k();
    L_0x02e6:
        r0 = r11.f67V;
        if (r0 == 0) goto L_0x02ef;
    L_0x02ea:
        r0 = r11.f67V;
        r0.m116f();
    L_0x02ef:
        if (r12 <= r9) goto L_0x0045;
    L_0x02f1:
        r0 = f182a;
        if (r0 == 0) goto L_0x0309;
    L_0x02f5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto RESUMED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0309:
        r11.f83w = r5;
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x0318;
    L_0x030f:
        r0 = r11.f49D;
        r0.f201s = r3;
        r0 = r11.f49D;
        r0.m209f();
    L_0x0318:
        r11.f60O = r3;
        r11.m78o();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x033c;
    L_0x0321:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onResume()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x033c:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x034a;
    L_0x0340:
        r0 = r11.f49D;
        r0.m215l();
        r0 = r11.f49D;
        r0.m209f();
    L_0x034a:
        r11.f73m = r7;
        r11.f74n = r7;
        goto L_0x0045;
    L_0x0350:
        r0 = r11.f70j;
        if (r0 <= r12) goto L_0x0045;
    L_0x0354:
        r0 = r11.f70j;
        switch(r0) {
            case 1: goto L_0x035b;
            case 2: goto L_0x0423;
            case 3: goto L_0x0406;
            case 4: goto L_0x03bf;
            case 5: goto L_0x0375;
            default: goto L_0x0359;
        };
    L_0x0359:
        goto L_0x0045;
    L_0x035b:
        if (r12 > 0) goto L_0x0045;
    L_0x035d:
        r0 = r10.f202t;
        if (r0 == 0) goto L_0x036c;
    L_0x0361:
        r0 = r11.f71k;
        if (r0 == 0) goto L_0x036c;
    L_0x0365:
        r0 = r11.f71k;
        r11.f71k = r7;
        r0.clearAnimation();
    L_0x036c:
        r0 = r11.f71k;
        if (r0 == 0) goto L_0x04bf;
    L_0x0370:
        r11.f72l = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0375:
        r0 = 5;
        if (r12 >= r0) goto L_0x03bf;
    L_0x0378:
        r0 = f182a;
        if (r0 == 0) goto L_0x0390;
    L_0x037c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom RESUMED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0390:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x0399;
    L_0x0394:
        r0 = r11.f49D;
        r0.m202c(r9);
    L_0x0399:
        r11.f60O = r3;
        r11.m79p();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x03bd;
    L_0x03a2:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onPause()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03bd:
        r11.f83w = r3;
    L_0x03bf:
        if (r12 >= r9) goto L_0x0406;
    L_0x03c1:
        r0 = f182a;
        if (r0 == 0) goto L_0x03d9;
    L_0x03c5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom STARTED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03d9:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x03e2;
    L_0x03dd:
        r0 = r11.f49D;
        r0.m216m();
    L_0x03e2:
        r11.f60O = r3;
        r11.m66d();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x0406;
    L_0x03eb:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStop()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0406:
        if (r12 >= r6) goto L_0x0423;
    L_0x0408:
        r0 = f182a;
        if (r0 == 0) goto L_0x0420;
    L_0x040c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom STOPPED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0420:
        r11.m81s();
    L_0x0423:
        r0 = 2;
        if (r12 >= r0) goto L_0x035b;
    L_0x0426:
        r0 = f182a;
        if (r0 == 0) goto L_0x043e;
    L_0x042a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x043e:
        r0 = r11.f63R;
        if (r0 == 0) goto L_0x0451;
    L_0x0442:
        r0 = r10.f197o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0451;
    L_0x044a:
        r0 = r11.f74n;
        if (r0 != 0) goto L_0x0451;
    L_0x044e:
        r10.m171c(r11);
    L_0x0451:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x045a;
    L_0x0455:
        r0 = r11.f49D;
        r0.m202c(r5);
    L_0x045a:
        r11.f60O = r3;
        r11.m68e();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x047e;
    L_0x0463:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroyView()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x047e:
        r0 = r11.f67V;
        if (r0 == 0) goto L_0x0487;
    L_0x0482:
        r0 = r11.f67V;
        r0.m115e();
    L_0x0487:
        r0 = r11.f63R;
        if (r0 == 0) goto L_0x04b7;
    L_0x048b:
        r0 = r11.f62Q;
        if (r0 == 0) goto L_0x04b7;
    L_0x048f:
        r0 = r10.f196n;
        if (r0 <= 0) goto L_0x05a9;
    L_0x0493:
        r0 = r10.f202t;
        if (r0 != 0) goto L_0x05a9;
    L_0x0497:
        r0 = r10.m168a(r11, r13, r3, r14);
    L_0x049b:
        if (r0 == 0) goto L_0x04b0;
    L_0x049d:
        r1 = r11.f63R;
        r11.f71k = r1;
        r11.f72l = r12;
        r1 = new android.support.v4.app.u;
        r1.<init>(r10, r11);
        r0.setAnimationListener(r1);
        r1 = r11.f63R;
        r1.startAnimation(r0);
    L_0x04b0:
        r0 = r11.f62Q;
        r1 = r11.f63R;
        r0.removeView(r1);
    L_0x04b7:
        r11.f62Q = r7;
        r11.f63R = r7;
        r11.f64S = r7;
        goto L_0x035b;
    L_0x04bf:
        r0 = f182a;
        if (r0 == 0) goto L_0x04d7;
    L_0x04c3:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom CREATED: ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x04d7:
        r0 = r11.f57L;
        if (r0 != 0) goto L_0x0508;
    L_0x04db:
        r0 = r11.f49D;
        if (r0 == 0) goto L_0x04e4;
    L_0x04df:
        r0 = r11.f49D;
        r0.m217n();
    L_0x04e4:
        r11.f60O = r3;
        r11.m80q();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x0508;
    L_0x04ed:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroy()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0508:
        r11.f60O = r3;
        r11.m62b();
        r0 = r11.f60O;
        if (r0 != 0) goto L_0x052c;
    L_0x0511:
        r0 = new android.support.v4.app.af;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x052c:
        if (r15 != 0) goto L_0x0045;
    L_0x052e:
        r0 = r11.f57L;
        if (r0 != 0) goto L_0x059f;
    L_0x0532:
        r0 = r11.f75o;
        if (r0 < 0) goto L_0x0045;
    L_0x0536:
        r0 = f182a;
        if (r0 == 0) goto L_0x054e;
    L_0x053a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "Freeing fragment index ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x054e:
        r0 = r10.f188f;
        r1 = r11.f75o;
        r0.set(r1, r7);
        r0 = r10.f190h;
        if (r0 != 0) goto L_0x0560;
    L_0x0559:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.f190h = r0;
    L_0x0560:
        r0 = r10.f190h;
        r1 = r11.f75o;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r0 = r10.f197o;
        r1 = r11.f76p;
        r0.m99a(r1);
        r0 = -1;
        r11.f75o = r0;
        r11.f76p = r7;
        r11.f81u = r3;
        r11.f82v = r3;
        r11.f83w = r3;
        r11.f84x = r3;
        r11.f85y = r3;
        r11.f86z = r3;
        r11.f46A = r3;
        r11.f47B = r7;
        r11.f49D = r7;
        r11.f48C = r7;
        r11.f51F = r3;
        r11.f52G = r3;
        r11.f53H = r7;
        r11.f54I = r3;
        r11.f55J = r3;
        r11.f57L = r3;
        r11.f67V = r7;
        r11.f68W = r3;
        r11.f69X = r3;
        goto L_0x0045;
    L_0x059f:
        r11.f48C = r7;
        r11.f50E = r7;
        r11.f47B = r7;
        r11.f49D = r7;
        goto L_0x0045;
    L_0x05a9:
        r0 = r7;
        goto L_0x049b;
    L_0x05ac:
        r0 = r7;
        goto L_0x01d8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.r.a(android.support.v4.app.f, int, int, int, boolean):void");
    }

    final void m197b(C0015f c0015f) {
        m187a(c0015f, this.f196n, 0, 0, false);
    }

    final void m202c(int i) {
        m181a(i, 0, 0, false);
    }

    final void m181a(int i, int i2, int i3, boolean z) {
        if (this.f197o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f196n != i) {
            this.f196n = i;
            if (this.f188f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f188f.size()) {
                    int a;
                    C0015f c0015f = (C0015f) this.f188f.get(i4);
                    if (c0015f != null) {
                        m187a(c0015f, i, i2, i3, false);
                        if (c0015f.f67V != null) {
                            a = i5 | c0015f.f67V.m111a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m207e();
                }
                if (this.f200r && this.f197o != null && this.f196n == 5) {
                    this.f197o.a_();
                    this.f200r = false;
                }
            }
        }
    }

    final void m207e() {
        if (this.f188f != null) {
            for (int i = 0; i < this.f188f.size(); i++) {
                C0015f c0015f = (C0015f) this.f188f.get(i);
                if (c0015f != null && c0015f.f65T) {
                    if (this.f187e) {
                        this.f204v = true;
                    } else {
                        c0015f.f65T = false;
                        m187a(c0015f, this.f196n, 0, 0, false);
                    }
                }
            }
        }
    }

    public final void m188a(C0015f c0015f, boolean z) {
        if (this.f189g == null) {
            this.f189g = new ArrayList();
        }
        if (f182a) {
            Log.v("FragmentManager", "add: " + c0015f);
        }
        if (c0015f.f75o < 0) {
            if (this.f190h == null || this.f190h.size() <= 0) {
                if (this.f188f == null) {
                    this.f188f = new ArrayList();
                }
                c0015f.m52a(this.f188f.size(), this.f199q);
                this.f188f.add(c0015f);
            } else {
                c0015f.m52a(((Integer) this.f190h.remove(this.f190h.size() - 1)).intValue(), this.f199q);
                this.f188f.set(c0015f.f75o, c0015f);
            }
            if (f182a) {
                Log.v("FragmentManager", "Allocated fragment index " + c0015f);
            }
        }
        if (!c0015f.f55J) {
            if (this.f189g.contains(c0015f)) {
                throw new IllegalStateException("Fragment already added: " + c0015f);
            }
            this.f189g.add(c0015f);
            c0015f.f81u = true;
            c0015f.f82v = false;
            if (c0015f.f58M && c0015f.f59N) {
                this.f200r = true;
            }
            if (z) {
                m197b(c0015f);
            }
        }
    }

    public final void m186a(C0015f c0015f, int i, int i2) {
        boolean z;
        if (f182a) {
            Log.v("FragmentManager", "remove: " + c0015f + " nesting=" + c0015f.f46A);
        }
        if (c0015f.f46A > 0) {
            z = true;
        } else {
            z = false;
        }
        z = !z;
        if (!c0015f.f55J || z) {
            int i3;
            if (this.f189g != null) {
                this.f189g.remove(c0015f);
            }
            if (c0015f.f58M && c0015f.f59N) {
                this.f200r = true;
            }
            c0015f.f81u = false;
            c0015f.f82v = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m187a(c0015f, i3, i, i2, false);
        }
    }

    public final void m198b(C0015f c0015f, int i, int i2) {
        if (f182a) {
            Log.v("FragmentManager", "hide: " + c0015f);
        }
        if (!c0015f.f54I) {
            c0015f.f54I = true;
            if (c0015f.f63R != null) {
                Animation a = m168a(c0015f, i, false, i2);
                if (a != null) {
                    c0015f.f63R.startAnimation(a);
                }
                c0015f.f63R.setVisibility(8);
            }
            if (c0015f.f81u && c0015f.f58M && c0015f.f59N) {
                this.f200r = true;
            }
            C0015f.m45i();
        }
    }

    public final void m203c(C0015f c0015f, int i, int i2) {
        if (f182a) {
            Log.v("FragmentManager", "show: " + c0015f);
        }
        if (c0015f.f54I) {
            c0015f.f54I = false;
            if (c0015f.f63R != null) {
                Animation a = m168a(c0015f, i, true, i2);
                if (a != null) {
                    c0015f.f63R.startAnimation(a);
                }
                c0015f.f63R.setVisibility(0);
            }
            if (c0015f.f81u && c0015f.f58M && c0015f.f59N) {
                this.f200r = true;
            }
            C0015f.m45i();
        }
    }

    public final void m206d(C0015f c0015f, int i, int i2) {
        if (f182a) {
            Log.v("FragmentManager", "detach: " + c0015f);
        }
        if (!c0015f.f55J) {
            c0015f.f55J = true;
            if (c0015f.f81u) {
                if (this.f189g != null) {
                    if (f182a) {
                        Log.v("FragmentManager", "remove from detach: " + c0015f);
                    }
                    this.f189g.remove(c0015f);
                }
                if (c0015f.f58M && c0015f.f59N) {
                    this.f200r = true;
                }
                c0015f.f81u = false;
                m187a(c0015f, 1, i, i2, false);
            }
        }
    }

    public final void m208e(C0015f c0015f, int i, int i2) {
        if (f182a) {
            Log.v("FragmentManager", "attach: " + c0015f);
        }
        if (c0015f.f55J) {
            c0015f.f55J = false;
            if (!c0015f.f81u) {
                if (this.f189g == null) {
                    this.f189g = new ArrayList();
                }
                if (this.f189g.contains(c0015f)) {
                    throw new IllegalStateException("Fragment already added: " + c0015f);
                }
                if (f182a) {
                    Log.v("FragmentManager", "add from attach: " + c0015f);
                }
                this.f189g.add(c0015f);
                c0015f.f81u = true;
                if (c0015f.f58M && c0015f.f59N) {
                    this.f200r = true;
                }
                m187a(c0015f, this.f196n, i, i2, false);
            }
        }
    }

    public final C0015f m176a(int i) {
        int size;
        C0015f c0015f;
        if (this.f189g != null) {
            for (size = this.f189g.size() - 1; size >= 0; size--) {
                c0015f = (C0015f) this.f189g.get(size);
                if (c0015f != null && c0015f.f51F == i) {
                    return c0015f;
                }
            }
        }
        if (this.f188f != null) {
            for (size = this.f188f.size() - 1; size >= 0; size--) {
                c0015f = (C0015f) this.f188f.get(size);
                if (c0015f != null && c0015f.f51F == i) {
                    return c0015f;
                }
            }
        }
        return null;
    }

    public final C0015f m178a(String str) {
        int size;
        C0015f c0015f;
        if (!(this.f189g == null || str == null)) {
            for (size = this.f189g.size() - 1; size >= 0; size--) {
                c0015f = (C0015f) this.f189g.get(size);
                if (c0015f != null && str.equals(c0015f.f53H)) {
                    return c0015f;
                }
            }
        }
        if (!(this.f188f == null || str == null)) {
            for (size = this.f188f.size() - 1; size >= 0; size--) {
                c0015f = (C0015f) this.f188f.get(size);
                if (c0015f != null && str.equals(c0015f.f53H)) {
                    return c0015f;
                }
            }
        }
        return null;
    }

    private void m174p() {
        if (this.f201s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f203u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f203u);
        }
    }

    public final void m190a(Runnable runnable, boolean z) {
        if (!z) {
            m174p();
        }
        synchronized (this) {
            if (this.f202t || this.f197o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f185c == null) {
                this.f185c = new ArrayList();
            }
            this.f185c.add(runnable);
            if (this.f185c.size() == 1) {
                this.f197o.f96a.removeCallbacks(this.f207y);
                this.f197o.f96a.post(this.f207y);
            }
        }
    }

    public final int m175a(C0018b c0018b) {
        int size;
        synchronized (this) {
            if (this.f194l == null || this.f194l.size() <= 0) {
                if (this.f193k == null) {
                    this.f193k = new ArrayList();
                }
                size = this.f193k.size();
                if (f182a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0018b);
                }
                this.f193k.add(c0018b);
            } else {
                size = ((Integer) this.f194l.remove(this.f194l.size() - 1)).intValue();
                if (f182a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0018b);
                }
                this.f193k.set(size, c0018b);
            }
        }
        return size;
    }

    private void m169a(int i, C0018b c0018b) {
        synchronized (this) {
            if (this.f193k == null) {
                this.f193k = new ArrayList();
            }
            int size = this.f193k.size();
            if (i < size) {
                if (f182a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0018b);
                }
                this.f193k.set(i, c0018b);
            } else {
                while (size < i) {
                    this.f193k.add(null);
                    if (this.f194l == null) {
                        this.f194l = new ArrayList();
                    }
                    if (f182a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f194l.add(Integer.valueOf(size));
                    size++;
                }
                if (f182a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0018b);
                }
                this.f193k.add(c0018b);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m209f() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f187e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f197o;
        r3 = r3.f96a;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.f185c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.f185c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.f204v;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f188f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f188f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.C0015f) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.f67V;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.f67V;
        r0 = r0.m111a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.f185c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.f186d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.f186d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.f186d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.f185c;	 Catch:{ all -> 0x0097 }
        r4 = r6.f186d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.f185c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.f197o;	 Catch:{ all -> 0x0097 }
        r1 = r1.f96a;	 Catch:{ all -> 0x0097 }
        r4 = r6.f207y;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.f187e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.f186d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f186d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.f187e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.f204v = r2;
        r6.m207e();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.r.f():boolean");
    }

    final void m210g() {
        if (this.f195m != null) {
            for (int i = 0; i < this.f195m.size(); i++) {
                ((C0032q) this.f195m.get(i)).m165a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m192a(int r9, int r10) {
        /*
        r8 = this;
        r2 = 1;
        r3 = 0;
        r0 = r8.f191i;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return r3;
    L_0x0007:
        if (r9 >= 0) goto L_0x0027;
    L_0x0009:
        r0 = r10 & 1;
        if (r0 != 0) goto L_0x0027;
    L_0x000d:
        r0 = r8.f191i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0006;
    L_0x0017:
        r1 = r8.f191i;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.app.C0018b) r0;
        r0.m145a(r2);
    L_0x0022:
        r8.m210g();
        r3 = r2;
        goto L_0x0006;
    L_0x0027:
        r0 = -1;
        if (r9 < 0) goto L_0x0061;
    L_0x002a:
        r0 = r8.f191i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0032:
        if (r1 < 0) goto L_0x0045;
    L_0x0034:
        r0 = r8.f191i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.C0018b) r0;
        if (r9 < 0) goto L_0x0042;
    L_0x003e:
        r0 = r0.f146o;
        if (r9 == r0) goto L_0x0045;
    L_0x0042:
        r1 = r1 + -1;
        goto L_0x0032;
    L_0x0045:
        if (r1 < 0) goto L_0x0006;
    L_0x0047:
        r0 = r10 & 1;
        if (r0 == 0) goto L_0x0060;
    L_0x004b:
        r1 = r1 + -1;
    L_0x004d:
        if (r1 < 0) goto L_0x0060;
    L_0x004f:
        r0 = r8.f191i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.C0018b) r0;
        if (r9 < 0) goto L_0x0060;
    L_0x0059:
        r0 = r0.f146o;
        if (r9 != r0) goto L_0x0060;
    L_0x005d:
        r1 = r1 + -1;
        goto L_0x004d;
    L_0x0060:
        r0 = r1;
    L_0x0061:
        r1 = r8.f191i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0006;
    L_0x006b:
        r5 = new java.util.ArrayList;
        r5.<init>();
        r1 = r8.f191i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x0078:
        if (r1 <= r0) goto L_0x0086;
    L_0x007a:
        r4 = r8.f191i;
        r4 = r4.remove(r1);
        r5.add(r4);
        r1 = r1 + -1;
        goto L_0x0078;
    L_0x0086:
        r0 = r5.size();
        r6 = r0 + -1;
        r4 = r3;
    L_0x008d:
        if (r4 > r6) goto L_0x0022;
    L_0x008f:
        r0 = f182a;
        if (r0 == 0) goto L_0x00ab;
    L_0x0093:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r7 = "Popping back stack state: ";
        r1.<init>(r7);
        r7 = r5.get(r4);
        r1 = r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00ab:
        r0 = r5.get(r4);
        r0 = (android.support.v4.app.C0018b) r0;
        if (r4 != r6) goto L_0x00bb;
    L_0x00b3:
        r1 = r2;
    L_0x00b4:
        r0.m145a(r1);
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x008d;
    L_0x00bb:
        r1 = r3;
        goto L_0x00b4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.r.a(int, int):boolean");
    }

    private void m171c(C0015f c0015f) {
        if (c0015f.f64S != null) {
            if (this.f206x == null) {
                this.f206x = new SparseArray();
            } else {
                this.f206x.clear();
            }
            c0015f.f64S.saveHierarchyState(this.f206x);
            if (this.f206x.size() > 0) {
                c0015f.f74n = this.f206x;
                this.f206x = null;
            }
        }
    }

    private Bundle m173d(C0015f c0015f) {
        Bundle bundle;
        if (this.f205w == null) {
            this.f205w = new Bundle();
        }
        c0015f.m73g(this.f205w);
        if (this.f205w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f205w;
            this.f205w = null;
        }
        if (c0015f.f63R != null) {
            m171c(c0015f);
        }
        if (c0015f.f74n != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c0015f.f74n);
        }
        if (!c0015f.f66U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c0015f.f66U);
        }
        return bundle;
    }

    final Parcelable m211h() {
        C0020d[] c0020dArr = null;
        m209f();
        if (f183b) {
            this.f201s = true;
        }
        if (this.f188f == null || this.f188f.size() <= 0) {
            return null;
        }
        int size = this.f188f.size();
        C0039x[] c0039xArr = new C0039x[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0015f c0015f = (C0015f) this.f188f.get(i);
            if (c0015f != null) {
                if (c0015f.f75o < 0) {
                    m170a(new IllegalStateException("Failure saving state: active " + c0015f + " has cleared index: " + c0015f.f75o));
                }
                C0039x c0039x = new C0039x(c0015f);
                c0039xArr[i] = c0039x;
                if (c0015f.f70j <= 0 || c0039x.f226j != null) {
                    c0039x.f226j = c0015f.f73m;
                } else {
                    c0039x.f226j = m173d(c0015f);
                    if (c0015f.f78r != null) {
                        if (c0015f.f78r.f75o < 0) {
                            m170a(new IllegalStateException("Failure saving state: " + c0015f + " has target not in fragment manager: " + c0015f.f78r));
                        }
                        if (c0039x.f226j == null) {
                            c0039x.f226j = new Bundle();
                        }
                        m183a(c0039x.f226j, "android:target_state", c0015f.f78r);
                        if (c0015f.f80t != 0) {
                            c0039x.f226j.putInt("android:target_req_state", c0015f.f80t);
                        }
                    }
                }
                if (f182a) {
                    Log.v("FragmentManager", "Saved state of " + c0015f + ": " + c0039x.f226j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            C0037v c0037v;
            if (this.f189g != null) {
                i = this.f189g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((C0015f) this.f189g.get(i2)).f75o;
                        if (iArr[i2] < 0) {
                            m170a(new IllegalStateException("Failure saving state: active " + this.f189g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f182a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f189g.get(i2));
                        }
                    }
                    if (this.f191i != null) {
                        i = this.f191i.size();
                        if (i > 0) {
                            c0020dArr = new C0020d[i];
                            for (i2 = 0; i2 < i; i2++) {
                                c0020dArr[i2] = new C0020d((C0018b) this.f191i.get(i2));
                                if (f182a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f191i.get(i2));
                                }
                            }
                        }
                    }
                    c0037v = new C0037v();
                    c0037v.f214a = c0039xArr;
                    c0037v.f215b = iArr;
                    c0037v.f216c = c0020dArr;
                    return c0037v;
                }
            }
            iArr = null;
            if (this.f191i != null) {
                i = this.f191i.size();
                if (i > 0) {
                    c0020dArr = new C0020d[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0020dArr[i2] = new C0020d((C0018b) this.f191i.get(i2));
                        if (f182a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f191i.get(i2));
                        }
                    }
                }
            }
            c0037v = new C0037v();
            c0037v.f214a = c0039xArr;
            c0037v.f215b = iArr;
            c0037v.f216c = c0020dArr;
            return c0037v;
        } else if (!f182a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    final void m184a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            C0037v c0037v = (C0037v) parcelable;
            if (c0037v.f214a != null) {
                int i;
                C0015f c0015f;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        c0015f = (C0015f) arrayList.get(i);
                        if (f182a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0015f);
                        }
                        C0039x c0039x = c0037v.f214a[c0015f.f75o];
                        c0039x.f227k = c0015f;
                        c0015f.f74n = null;
                        c0015f.f46A = 0;
                        c0015f.f85y = false;
                        c0015f.f81u = false;
                        c0015f.f78r = null;
                        if (c0039x.f226j != null) {
                            c0039x.f226j.setClassLoader(this.f197o.getClassLoader());
                            c0015f.f74n = c0039x.f226j.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f188f = new ArrayList(c0037v.f214a.length);
                if (this.f190h != null) {
                    this.f190h.clear();
                }
                for (i2 = 0; i2 < c0037v.f214a.length; i2++) {
                    C0039x c0039x2 = c0037v.f214a[i2];
                    if (c0039x2 != null) {
                        Context context = this.f197o;
                        C0015f c0015f2 = this.f199q;
                        if (c0039x2.f227k == null) {
                            if (c0039x2.f225i != null) {
                                c0039x2.f225i.setClassLoader(context.getClassLoader());
                            }
                            c0039x2.f227k = C0015f.m43a(context, c0039x2.f217a, c0039x2.f225i);
                            if (c0039x2.f226j != null) {
                                c0039x2.f226j.setClassLoader(context.getClassLoader());
                                c0039x2.f227k.f73m = c0039x2.f226j;
                            }
                            c0039x2.f227k.m52a(c0039x2.f218b, c0015f2);
                            c0039x2.f227k.f84x = c0039x2.f219c;
                            c0039x2.f227k.f86z = true;
                            c0039x2.f227k.f51F = c0039x2.f220d;
                            c0039x2.f227k.f52G = c0039x2.f221e;
                            c0039x2.f227k.f53H = c0039x2.f222f;
                            c0039x2.f227k.f56K = c0039x2.f223g;
                            c0039x2.f227k.f55J = c0039x2.f224h;
                            c0039x2.f227k.f47B = context.f97b;
                            if (f182a) {
                                Log.v("FragmentManager", "Instantiated fragment " + c0039x2.f227k);
                            }
                        }
                        C0015f c0015f3 = c0039x2.f227k;
                        if (f182a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + c0015f3);
                        }
                        this.f188f.add(c0015f3);
                        c0039x2.f227k = null;
                    } else {
                        this.f188f.add(null);
                        if (this.f190h == null) {
                            this.f190h = new ArrayList();
                        }
                        if (f182a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f190h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        c0015f = (C0015f) arrayList.get(i3);
                        if (c0015f.f79s >= 0) {
                            if (c0015f.f79s < this.f188f.size()) {
                                c0015f.f78r = (C0015f) this.f188f.get(c0015f.f79s);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0015f + " target no longer exists: " + c0015f.f79s);
                                c0015f.f78r = null;
                            }
                        }
                    }
                }
                if (c0037v.f215b != null) {
                    this.f189g = new ArrayList(c0037v.f215b.length);
                    for (i = 0; i < c0037v.f215b.length; i++) {
                        c0015f = (C0015f) this.f188f.get(c0037v.f215b[i]);
                        if (c0015f == null) {
                            m170a(new IllegalStateException("No instantiated fragment for index #" + c0037v.f215b[i]));
                        }
                        c0015f.f81u = true;
                        if (f182a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + c0015f);
                        }
                        if (this.f189g.contains(c0015f)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f189g.add(c0015f);
                    }
                } else {
                    this.f189g = null;
                }
                if (c0037v.f216c != null) {
                    this.f191i = new ArrayList(c0037v.f216c.length);
                    for (i2 = 0; i2 < c0037v.f216c.length; i2++) {
                        C0018b a = c0037v.f216c[i2].m150a(this);
                        if (f182a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a.f146o + "): " + a);
                            a.m144a("  ", new PrintWriter(new C0052e("FragmentManager")), false);
                        }
                        this.f191i.add(a);
                        if (a.f146o >= 0) {
                            m169a(a.f146o, a);
                        }
                    }
                    return;
                }
                this.f191i = null;
            }
        }
    }

    public final void m185a(FragmentActivity fragmentActivity, C0022o c0022o, C0015f c0015f) {
        if (this.f197o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f197o = fragmentActivity;
        this.f198p = c0022o;
        this.f199q = c0015f;
    }

    public final void m212i() {
        this.f201s = false;
        m202c(1);
    }

    public final void m213j() {
        this.f201s = false;
        m202c(2);
    }

    public final void m214k() {
        this.f201s = false;
        m202c(4);
    }

    public final void m215l() {
        this.f201s = false;
        m202c(5);
    }

    public final void m216m() {
        this.f201s = true;
        m202c(3);
    }

    public final void m217n() {
        this.f202t = true;
        m209f();
        m202c(0);
        this.f197o = null;
        this.f198p = null;
        this.f199q = null;
    }

    public final void m182a(Configuration configuration) {
        if (this.f189g != null) {
            for (int i = 0; i < this.f189g.size(); i++) {
                C0015f c0015f = (C0015f) this.f189g.get(i);
                if (c0015f != null) {
                    c0015f.onConfigurationChanged(configuration);
                    if (c0015f.f49D != null) {
                        c0015f.f49D.m182a(configuration);
                    }
                }
            }
        }
    }

    public final void m218o() {
        if (this.f189g != null) {
            for (int i = 0; i < this.f189g.size(); i++) {
                C0015f c0015f = (C0015f) this.f189g.get(i);
                if (c0015f != null) {
                    c0015f.onLowMemory();
                    if (c0015f.f49D != null) {
                        c0015f.f49D.m218o();
                    }
                }
            }
        }
    }

    public final boolean m194a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f189g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f189g.size()) {
                boolean z2;
                C0015f c0015f = (C0015f) this.f189g.get(i2);
                if (c0015f != null) {
                    int i3;
                    if (c0015f.f54I) {
                        i3 = 0;
                    } else {
                        if (c0015f.f58M && c0015f.f59N) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (c0015f.f49D != null) {
                            i3 |= c0015f.f49D.m194a(menu, menuInflater);
                        }
                    }
                    if (i3 != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c0015f);
                        z2 = true;
                        i2++;
                        z = z2;
                    }
                }
                z2 = z;
                i2++;
                z = z2;
            }
        } else {
            z = false;
        }
        if (this.f192j != null) {
            while (i < this.f192j.size()) {
                c0015f = (C0015f) this.f192j.get(i);
                if (arrayList == null || !arrayList.contains(c0015f)) {
                    C0015f.m48r();
                }
                i++;
            }
        }
        this.f192j = arrayList;
        return z;
    }

    public final boolean m193a(Menu menu) {
        if (this.f189g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f189g.size(); i++) {
            C0015f c0015f = (C0015f) this.f189g.get(i);
            if (c0015f != null) {
                int i2;
                if (c0015f.f54I) {
                    i2 = 0;
                } else {
                    if (c0015f.f58M && c0015f.f59N) {
                        c0015f.m58a(menu);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (c0015f.f49D != null) {
                        i2 |= c0015f.f49D.m193a(menu);
                    }
                }
                if (i2 != 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean m195a(MenuItem menuItem) {
        if (this.f189g == null) {
            return false;
        }
        for (int i = 0; i < this.f189g.size(); i++) {
            C0015f c0015f = (C0015f) this.f189g.get(i);
            if (c0015f != null) {
                boolean z;
                if (!c0015f.f54I) {
                    if (c0015f.f58M && c0015f.f59N && c0015f.m59a(menuItem)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    } else if (c0015f.f49D != null && c0015f.f49D.m195a(menuItem)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean m201b(MenuItem menuItem) {
        if (this.f189g == null) {
            return false;
        }
        for (int i = 0; i < this.f189g.size(); i++) {
            C0015f c0015f = (C0015f) this.f189g.get(i);
            if (c0015f != null) {
                boolean z;
                if (!c0015f.f54I) {
                    if (c0015f.m64b(menuItem)) {
                        z = true;
                    } else if (c0015f.f49D != null && c0015f.f49D.m201b(menuItem)) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void m199b(Menu menu) {
        if (this.f189g != null) {
            for (int i = 0; i < this.f189g.size(); i++) {
                C0015f c0015f = (C0015f) this.f189g.get(i);
                if (!(c0015f == null || c0015f.f54I || c0015f.f49D == null)) {
                    c0015f.f49D.m199b(menu);
                }
            }
        }
    }

    public static int m172d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }
}
