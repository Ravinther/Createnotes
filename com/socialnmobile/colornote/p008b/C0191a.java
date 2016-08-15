package com.socialnmobile.colornote.p008b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.b.a */
public final class C0191a {
    final URI f857a;
    final PackageInfo f858b;
    final String f859c;
    final C0198h f860d;
    final int f861e;
    ThreadPoolExecutor f862f;
    public UncaughtExceptionHandler f863g;
    C0192g f864h;

    public C0191a(Context context, String str, String str2) {
        this(context, str, new URI(str2));
    }

    private C0191a(Context context, String str, URI uri) {
        this(context.getPackageManager().getPackageInfo(context.getPackageName(), 0), str, uri);
    }

    private C0191a(PackageInfo packageInfo, String str, URI uri) {
        this.f860d = new C0198h();
        this.f861e = 3;
        this.f862f = null;
        this.f863g = null;
        this.f864h = new C0193b(this);
        this.f857a = uri;
        this.f858b = packageInfo;
        this.f859c = str;
        m853a(packageInfo.packageName);
    }

    public final void m856a(Throwable th) {
        if (th != null) {
            m855a("UNHANDLED_EXCEPTION", th, "UNHANDLED", th.getMessage());
        }
    }

    public final void m853a(String str) {
        this.f860d.f885a.add(str);
    }

    private synchronized ExecutorService m847a() {
        ExecutorService executorService;
        if (this.f862f != null) {
            executorService = this.f862f;
        } else {
            RejectedExecutionHandler discardPolicy = new DiscardPolicy();
            this.f862f = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new C0195d(this), discardPolicy);
            executorService = this.f862f;
        }
        return executorService;
    }

    public final void m854a(String str, String str2, String str3, Object obj) {
        m847a().submit(new C0196e(this, str, str2, str3, obj, this.f864h.m858a(Thread.currentThread().getName())));
    }

    final void m857a(JSONObject jSONObject) {
        C0191a.m846a(this.f857a, "POST", "application/json", jSONObject.toString(2).getBytes("utf-8"));
    }

    private static int m846a(URI uri, String str, String str2, byte[] bArr) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        OutputStream outputStream;
        try {
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setDoInput(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", str2);
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            Log.d("EventReporter", "EventReport: " + responseCode + " " + httpURLConnection.getResponseMessage());
            httpURLConnection.disconnect();
            return responseCode;
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    final JSONObject m852a(String str, Object obj, String str2, Object obj2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        PackageInfo packageInfo = this.f858b;
        String str4 = this.f859c;
        JSONObject jSONObject2 = new JSONObject();
        C0191a.m849a(jSONObject2, "name", packageInfo.packageName);
        C0191a.m849a(jSONObject2, "versionCode", Integer.valueOf(packageInfo.versionCode));
        C0191a.m849a(jSONObject2, "versionName", packageInfo.versionName);
        C0191a.m849a(jSONObject2, "variant", str4);
        JSONObject jSONObject3 = new JSONObject();
        C0191a.m849a(jSONObject3, NoteMinorColumns.TYPE, str);
        C0191a.m849a(jSONObject3, "content", obj);
        C0191a.m849a(jSONObject3, "name", str2);
        C0191a.m849a(jSONObject3, "param", obj2);
        C0191a.m849a(jSONObject3, "thread", str3);
        JSONObject jSONObject4 = new JSONObject();
        C0191a.m849a(jSONObject4, "VERSION", VERSION.RELEASE);
        C0191a.m849a(jSONObject4, "BRAND", Build.BRAND);
        C0191a.m849a(jSONObject4, "MANUFACTURER", Build.MANUFACTURER);
        C0191a.m849a(jSONObject4, "MODEL", Build.MODEL);
        C0191a.m849a(jSONObject, "packageInfo", jSONObject2);
        C0191a.m849a(jSONObject, "event", jSONObject3);
        if (z) {
            C0191a.m849a(jSONObject, "build", jSONObject4);
        } else {
            C0191a.m849a(jSONObject, "build", null);
        }
        return jSONObject;
    }

    final JSONArray m851a(Throwable th, int i) {
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        int i3 = 0;
        Throwable th2 = th;
        while (th2 != null && i3 < 3) {
            Object obj;
            JSONObject b = m850b(th2, i);
            jSONArray.put(b);
            if (b.getJSONArray("stacktrace").length() > 1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i2++;
            }
            i3++;
            th2 = th2.getCause();
        }
        if (i2 == 0) {
            i2 = 0;
            Throwable th3 = th2;
            while (th3 != null && i2 < 3) {
                jSONArray.put(m850b(th3, i));
                th3 = th3.getCause();
                i2++;
            }
        }
        return jSONArray;
    }

    private JSONObject m850b(Throwable th, int i) {
        JSONObject jSONObject = new JSONObject();
        String name = th.getClass().getName();
        Object stackTrace = th.getStackTrace();
        int length = th.getStackTrace().length;
        int length2 = stackTrace.length;
        if (i > length) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length2) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            length -= i;
            length2 = Math.min(length, length2 - i);
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) Array.newInstance(stackTrace.getClass().getComponentType(), length);
            System.arraycopy(stackTrace, i, stackTraceElementArr, 0, length2);
            stackTraceElementArr = C0198h.m860b(this.f860d.m862a(stackTraceElementArr));
            C0191a.m849a(jSONObject, "exception", name);
            C0191a.m849a(jSONObject, "stacktrace", m848a(stackTraceElementArr));
            return jSONObject;
        }
    }

    private JSONArray m848a(StackTraceElement[] stackTraceElementArr) {
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            Object obj;
            if (stackTraceElement == null) {
                obj = "...";
            } else {
                boolean a = this.f860d.m861a(stackTraceElement);
                StringBuilder stringBuilder = new StringBuilder(80);
                stringBuilder.append(stackTraceElement.getClassName());
                stringBuilder.append('.');
                stringBuilder.append(stackTraceElement.getMethodName());
                if (stackTraceElement.isNativeMethod()) {
                    stringBuilder.append("(Native Method)");
                } else if (a) {
                    int lineNumber = stackTraceElement.getLineNumber();
                    stringBuilder.append('(');
                    if (lineNumber >= 0) {
                        stringBuilder.append(':');
                        stringBuilder.append(lineNumber);
                    }
                    stringBuilder.append(')');
                }
                obj = stringBuilder.toString();
            }
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    private static void m849a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            jSONObject.put(str, JSONObject.NULL);
        } else {
            jSONObject.put(str, obj);
        }
    }

    public final void m855a(String str, Throwable th, String str2, Object obj) {
        m847a().submit(new C0197f(this, str, th, str2, obj, this.f864h.m858a(Thread.currentThread().getName())));
    }
}
