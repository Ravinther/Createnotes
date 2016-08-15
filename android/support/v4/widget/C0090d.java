package android.support.v4.widget;

import android.support.v4.p003d.C0080r;
import android.support.v4.p003d.C0085w;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

/* renamed from: android.support.v4.widget.d */
final class C0090d extends C0089t {
    final int f304a;
    C0103q f305b;
    final /* synthetic */ DrawerLayout f306c;
    private final Runnable f307d;

    public C0090d(DrawerLayout drawerLayout, int i) {
        this.f306c = drawerLayout;
        this.f307d = new C0091e(this);
        this.f304a = i;
    }

    public final void m384a() {
        this.f306c.removeCallbacks(this.f307d);
    }

    public final boolean m389a(View view) {
        return DrawerLayout.m365c(view) && this.f306c.m371a(view, this.f304a) && this.f306c.m368a(view) == 0;
    }

    public final void m385a(int i) {
        DrawerLayout drawerLayout = this.f306c;
        View view = this.f305b.f326m;
        int i2 = drawerLayout.f279a.f314a;
        int i3 = drawerLayout.f280b.f314a;
        if (i2 == 1 || i3 == 1) {
            i2 = 1;
        } else if (i2 == 2 || i3 == 2) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (view != null && i == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            View childAt;
            if (layoutParams.f275b == 0.0f) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.f277d) {
                    layoutParams.f277d = false;
                    childAt = drawerLayout.getChildAt(0);
                    if (childAt != null) {
                        C0085w.m359b(childAt, 1);
                    }
                    C0085w.m359b(view, 4);
                    if (drawerLayout.hasWindowFocus()) {
                        childAt = drawerLayout.getRootView();
                        if (childAt != null) {
                            childAt.sendAccessibilityEvent(32);
                        }
                    }
                }
            } else if (layoutParams.f275b == 1.0f) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                if (!layoutParams.f277d) {
                    layoutParams.f277d = true;
                    childAt = drawerLayout.getChildAt(0);
                    if (childAt != null) {
                        C0085w.m359b(childAt, 4);
                    }
                    C0085w.m359b(view, 1);
                    drawerLayout.sendAccessibilityEvent(32);
                    view.requestFocus();
                }
            }
        }
        if (i2 != drawerLayout.f281c) {
            drawerLayout.f281c = i2;
        }
    }

    public final void m388a(View view, int i) {
        float f;
        int width = view.getWidth();
        if (this.f306c.m371a(view, 3)) {
            f = ((float) (width + i)) / ((float) width);
        } else {
            f = ((float) (this.f306c.getWidth() - i)) / ((float) width);
        }
        DrawerLayout.m360a(view, f);
        view.setVisibility(f == 0.0f ? 4 : 0);
        this.f306c.invalidate();
    }

    public final void m392b(View view) {
        ((LayoutParams) view.getLayoutParams()).f276c = false;
        m391b();
    }

    final void m391b() {
        int i = 3;
        if (this.f304a == 3) {
            i = 5;
        }
        View a = this.f306c.m369a(i);
        if (a != null) {
            this.f306c.m373e(a);
        }
    }

    public final void m387a(View view, float f) {
        int i;
        float b = DrawerLayout.m362b(view);
        int width = view.getWidth();
        if (this.f306c.m371a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && b > 0.5f)) ? 0 : -width;
        } else {
            i = this.f306c.getWidth();
            if (f < 0.0f || (f == 0.0f && b > 0.5f)) {
                i -= width;
            }
        }
        C0103q c0103q = this.f305b;
        width = view.getTop();
        if (c0103q.f327n) {
            c0103q.m480a(i, width, (int) C0080r.m346a(c0103q.f322i, c0103q.f316c), (int) C0080r.m347b(c0103q.f322i, c0103q.f316c));
            this.f306c.invalidate();
            return;
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public final void m394c() {
        this.f306c.postDelayed(this.f307d, 160);
    }

    public final void m386a(int i, int i2) {
        View a;
        if ((i & 1) == 1) {
            a = this.f306c.m369a(3);
        } else {
            a = this.f306c.m369a(5);
        }
        if (a != null && this.f306c.m368a(a) == 0) {
            this.f305b.m479a(a, i2);
        }
    }

    public final int m393c(View view) {
        return view.getWidth();
    }

    public final int m390b(View view, int i) {
        if (this.f306c.m371a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f306c.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public final int m395d(View view) {
        return view.getTop();
    }
}
