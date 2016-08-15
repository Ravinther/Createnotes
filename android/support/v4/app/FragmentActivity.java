package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p002c.C0046l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity extends Activity {
    final Handler f96a;
    public final C0033r f97b;
    final C0022o f98c;
    boolean f99d;
    boolean f100e;
    boolean f101f;
    boolean f102g;
    boolean f103h;
    boolean f104i;
    boolean f105j;
    boolean f106k;
    C0046l f107l;
    ac f108m;

    public FragmentActivity() {
        this.f96a = new C0027k(this);
        this.f97b = new C0033r();
        this.f98c = new C0028l(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f97b.f201s = false;
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.f97b.f188f == null || i3 < 0 || i3 >= this.f97b.f188f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            C0015f c0015f = (C0015f) this.f97b.f188f.get(i3);
            if (c0015f == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                c0015f.m51a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f97b.m204c()) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f97b.m182a(configuration);
    }

    public void onCreate(Bundle bundle) {
        this.f97b.m185a(this, this.f98c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0030n c0030n = (C0030n) getLastNonConfigurationInstance();
        if (c0030n != null) {
            this.f107l = c0030n.f178e;
        }
        if (bundle != null) {
            ArrayList arrayList;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            C0033r c0033r = this.f97b;
            if (c0030n != null) {
                arrayList = c0030n.f177d;
            } else {
                arrayList = null;
            }
            c0033r.m184a(parcelable, arrayList);
        }
        this.f97b.m212i();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f97b.m194a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        C0015f c0015f = null;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0029m.f173a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C0015f.m44b((Context) this, attributeValue)) {
            return super.onCreateView(str, context, attributeSet);
        }
        if (resourceId != -1) {
            c0015f = this.f97b.m176a(resourceId);
        }
        if (c0015f == null && string != null) {
            c0015f = this.f97b.m178a(string);
        }
        if (c0015f == null) {
            c0015f = this.f97b.m176a(0);
        }
        if (C0033r.f182a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + c0015f);
        }
        if (c0015f == null) {
            C0015f a = C0015f.m42a((Context) this, attributeValue);
            a.f84x = true;
            a.f51F = resourceId != 0 ? resourceId : 0;
            a.f52G = 0;
            a.f53H = string;
            a.f85y = true;
            a.f47B = this.f97b;
            Bundle bundle = a.f73m;
            a.f60O = true;
            this.f97b.m188a(a, true);
            c0015f = a;
        } else if (c0015f.f85y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + attributeValue);
        } else {
            c0015f.f85y = true;
            if (!c0015f.f57L) {
                Bundle bundle2 = c0015f.f73m;
                c0015f.f60O = true;
            }
            this.f97b.m197b(c0015f);
        }
        if (c0015f.f63R == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            c0015f.f63R.setId(resourceId);
        }
        if (c0015f.f63R.getTag() == null) {
            c0015f.f63R.setTag(string);
        }
        return c0015f.f63R;
    }

    public void onDestroy() {
        super.onDestroy();
        m100a(false);
        this.f97b.m217n();
        if (this.f108m != null) {
            this.f108m.m117g();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f97b.m218o();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f97b.m195a(menuItem);
            case 6:
                return this.f97b.m201b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f97b.m199b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.f100e = false;
        if (this.f96a.hasMessages(2)) {
            this.f96a.removeMessages(2);
            this.f97b.m215l();
        }
        this.f97b.m202c(4);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f97b.f201s = false;
    }

    public void onResume() {
        super.onResume();
        this.f96a.sendEmptyMessage(2);
        this.f100e = true;
        this.f97b.m209f();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f96a.removeMessages(2);
        this.f97b.m215l();
        this.f97b.m209f();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f104i) {
            this.f104i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(0, view, menu) | this.f97b.m193a(menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        ArrayList arrayList;
        int i;
        int i2 = 0;
        if (this.f101f) {
            m100a(true);
        }
        C0033r c0033r = this.f97b;
        if (c0033r.f188f != null) {
            arrayList = null;
            for (i = 0; i < c0033r.f188f.size(); i++) {
                C0015f c0015f = (C0015f) c0033r.f188f.get(i);
                if (c0015f != null && c0015f.f56K) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0015f);
                    c0015f.f57L = true;
                    c0015f.f79s = c0015f.f78r != null ? c0015f.f78r.f75o : -1;
                    if (C0033r.f182a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + c0015f);
                    }
                }
            }
        } else {
            arrayList = null;
        }
        int i3;
        if (this.f107l != null) {
            i = this.f107l.size();
            ac[] acVarArr = new ac[i];
            for (int i4 = i - 1; i4 >= 0; i4--) {
                acVarArr[i4] = (ac) this.f107l.m229b(i4);
            }
            i3 = 0;
            while (i2 < i) {
                ac acVar = acVarArr[i2];
                if (acVar.f115g) {
                    i3 = true;
                } else {
                    acVar.m117g();
                    this.f107l.remove(acVar.f112d);
                }
                i2++;
            }
        } else {
            i3 = 0;
        }
        if (arrayList == null && r0 == 0) {
            return null;
        }
        C0030n c0030n = new C0030n();
        c0030n.f174a = null;
        c0030n.f175b = null;
        c0030n.f176c = null;
        c0030n.f177d = arrayList;
        c0030n.f178e = this.f107l;
        return c0030n;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable h = this.f97b.m211h();
        if (h != null) {
            bundle.putParcelable("android:support:fragments", h);
        }
    }

    public void onStart() {
        super.onStart();
        this.f101f = false;
        this.f102g = false;
        this.f96a.removeMessages(1);
        if (!this.f99d) {
            this.f99d = true;
            this.f97b.m213j();
        }
        this.f97b.f201s = false;
        this.f97b.m209f();
        if (!this.f106k) {
            this.f106k = true;
            if (this.f108m != null) {
                this.f108m.m112b();
            } else if (!this.f105j) {
                this.f108m = m97a("(root)", this.f106k, false);
                if (!(this.f108m == null || this.f108m.f114f)) {
                    this.f108m.m112b();
                }
            }
            this.f105j = true;
        }
        this.f97b.m214k();
        if (this.f107l != null) {
            int i;
            int size = this.f107l.size();
            ac[] acVarArr = new ac[size];
            for (i = size - 1; i >= 0; i--) {
                acVarArr[i] = (ac) this.f107l.m229b(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ac acVar = acVarArr[i2];
                if (acVar.f115g) {
                    if (ac.f109a) {
                        Log.v("LoaderManager", "Finished Retaining in " + acVar);
                    }
                    acVar.f115g = false;
                    for (i = acVar.f110b.m260a() - 1; i >= 0; i--) {
                        ad adVar = (ad) acVar.f110b.m265c(i);
                        if (adVar.f125i) {
                            if (ac.f109a) {
                                Log.v("LoaderManager", "  Finished Retaining: " + adVar);
                            }
                            adVar.f125i = false;
                            if (!(adVar.f124h == adVar.f126j || adVar.f124h)) {
                                adVar.m121b();
                            }
                        }
                        if (adVar.f124h && adVar.f121e && !adVar.f127k) {
                            adVar.m122b(adVar.f120d, adVar.f123g);
                        }
                    }
                }
                acVar.m116f();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.f101f = true;
        this.f96a.sendEmptyMessage(1);
        this.f97b.m216m();
    }

    public final void a_() {
        if (VERSION.SDK_INT >= 11) {
            C0016a.m101a(this);
        } else {
            this.f104i = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f99d);
        printWriter.print("mResumed=");
        printWriter.print(this.f100e);
        printWriter.print(" mStopped=");
        printWriter.print(this.f101f);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f102g);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f106k);
        if (this.f108m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f108m)));
            printWriter.println(":");
            this.f108m.m110a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f97b.m191a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m96a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String m95a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m96a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m95a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m96a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final void m100a(boolean z) {
        if (!this.f102g) {
            this.f102g = true;
            this.f103h = z;
            this.f96a.removeMessages(1);
            if (this.f106k) {
                this.f106k = false;
                if (this.f108m != null) {
                    if (this.f103h) {
                        this.f108m.m114d();
                    } else {
                        this.f108m.m113c();
                    }
                }
            }
            this.f97b.m202c(2);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void m98a(C0015f c0015f, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((c0015f.f75o + 1) << 16) + (65535 & i));
        }
    }

    final void m99a(String str) {
        if (this.f107l != null) {
            ac acVar = (ac) this.f107l.get(str);
            if (acVar != null && !acVar.f115g) {
                acVar.m117g();
                this.f107l.remove(str);
            }
        }
    }

    final ac m97a(String str, boolean z, boolean z2) {
        if (this.f107l == null) {
            this.f107l = new C0046l();
        }
        ac acVar = (ac) this.f107l.get(str);
        if (acVar != null) {
            acVar.f113e = this;
            return acVar;
        } else if (!z2) {
            return acVar;
        } else {
            acVar = new ac(str, this, z);
            this.f107l.put(str, acVar);
            return acVar;
        }
    }
}
