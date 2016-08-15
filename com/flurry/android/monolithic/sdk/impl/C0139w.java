package com.flurry.android.monolithic.sdk.impl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.flurry.android.monolithic.sdk.impl.w */
public final class C0139w extends bk {
    static int f584a;
    private String f585b;
    private String f586e;
    private String f587f;
    private byte[] f588g;
    private C0133y f589h;

    static {
        f584a = 15000;
    }

    public C0139w(String str, String str2, String str3, byte[] bArr, C0133y c0133y) {
        this.f585b = str;
        this.f586e = str2;
        this.f587f = str3;
        this.f588g = bArr;
        this.f589h = c0133y;
    }

    public final void m631a() {
        HttpClient defaultHttpClient;
        HttpResponse execute;
        Exception e;
        StatusLine statusLine;
        Throwable th;
        HttpClient httpClient = null;
        Thread.currentThread().setName("DataSender Sending Executor Thread, id = " + Long.valueOf(Thread.currentThread().getId()));
        try {
            HttpEntity byteArrayEntity = new ByteArrayEntity(this.f588g);
            byteArrayEntity.setContentType("application/octet-stream");
            HttpUriRequest httpPost = new HttpPost(this.f585b);
            httpPost.setEntity(byteArrayEntity);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, f584a);
            httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
            defaultHttpClient = new DefaultHttpClient(new SingleClientConnManager(basicHttpParams, bg.m582a()), basicHttpParams);
            try {
                execute = defaultHttpClient.execute(httpPost);
                defaultHttpClient.getConnectionManager().shutdown();
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (defaultHttpClient != null) {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                    if (execute != null) {
                        try {
                            if (execute.getStatusLine() != null) {
                                statusLine = execute.getStatusLine();
                                this.f589h.m627a(statusLine.getStatusCode(), statusLine.getReasonPhrase(), this.f586e, this.f587f);
                                return;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    this.f589h.m628a(this.f586e);
                } catch (Throwable th2) {
                    th = th2;
                    httpClient = defaultHttpClient;
                    if (httpClient != null) {
                        httpClient.getConnectionManager().shutdown();
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e3 = e4;
            defaultHttpClient = httpClient;
            e3.printStackTrace();
            if (defaultHttpClient != null) {
                defaultHttpClient.getConnectionManager().shutdown();
            }
            if (execute != null) {
                if (execute.getStatusLine() != null) {
                    statusLine = execute.getStatusLine();
                    this.f589h.m627a(statusLine.getStatusCode(), statusLine.getReasonPhrase(), this.f586e, this.f587f);
                    return;
                }
            }
            this.f589h.m628a(this.f586e);
        } catch (Throwable th3) {
            th = th3;
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
            throw th;
        }
        if (execute != null) {
            if (execute.getStatusLine() != null) {
                statusLine = execute.getStatusLine();
                this.f589h.m627a(statusLine.getStatusCode(), statusLine.getReasonPhrase(), this.f586e, this.f587f);
                return;
            }
        }
        this.f589h.m628a(this.f586e);
    }
}
