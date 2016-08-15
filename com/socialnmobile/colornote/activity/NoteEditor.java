package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.support.v4.app.C0017z;
import android.view.KeyEvent;
import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import com.socialnmobile.colornote.fragment.EditorContainer;
import com.socialnmobile.colornote.sync.df;

public class NoteEditor extends ThemeFragmentActivity {
    df f662n;
    private boolean f663o;
    private EditorContainer f664p;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m682a(1, null);
        setContentView(2130903044);
        this.f663o = false;
        this.f664p = (EditorContainer) this.f97b.m156a("EDITOR_CONTAINER");
        if (this.f664p == null) {
            this.f664p = EditorContainer.m1392b(getIntent());
            C0017z a = this.f97b.m158a();
            a.m130a(this.f664p, "EDITOR_CONTAINER");
            a.m131b();
        }
    }

    protected void onDestroy() {
        if (this.f662n != null) {
            unbindService(this.f662n);
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            AbstractEditorViewer abstractEditorViewer = this.f664p.f1179e;
            if (abstractEditorViewer != null && abstractEditorViewer.m1227F()) {
                this.f663o = true;
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f663o) {
            this.f663o = false;
            AbstractEditorViewer abstractEditorViewer = this.f664p.f1179e;
            if (abstractEditorViewer != null && abstractEditorViewer.m1227F()) {
                abstractEditorViewer.m1228G();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
        } catch (NullPointerException e2) {
        }
    }

    public boolean onSearchRequested() {
        AbstractEditorViewer abstractEditorViewer = this.f664p.f1179e;
        if (abstractEditorViewer == null || abstractEditorViewer.m1226E()) {
            return super.onSearchRequested();
        }
        return false;
    }
}
