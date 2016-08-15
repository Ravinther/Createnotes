package com.socialnmobile.colornote.p010d;

import com.p004a.p005a.C0108d;
import com.socialnmobile.colornote.ColorNote;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.socialnmobile.colornote.d.f */
public final class C0207f {
    public C0108d f901a;
    public String f902b;
    String f903c;
    String f904d;
    String f905e;
    long f906f;

    public C0207f(String str, String str2) {
        this.f902b = str;
        this.f903c = str2;
    }

    public static String m870a(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        defaultHttpClient.setParams(basicHttpParams);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("client_id", "908669027715.apps.googleusercontent.com"));
        arrayList.add(new BasicNameValuePair("client_secret", "SNZBS6UfQj4_DJSY1K6S3naw"));
        arrayList.add(new BasicNameValuePair("code", str));
        arrayList.add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
        arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
        try {
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "UTF-8");
            HttpUriRequest httpPost = new HttpPost("https://accounts.google.com/o/oauth2/token");
            httpPost.setEntity(urlEncodedFormEntity);
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = execute.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            }
        } catch (UnsupportedEncodingException e) {
            ColorNote.m651a("Unsupported Encoding");
        }
        return null;
    }
}
