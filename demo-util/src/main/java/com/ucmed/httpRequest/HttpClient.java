package com.ucmed.httpRequest;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpClient {
    public static final String TAG = "ucmed";
    private static final Logger logger = Logger.getLogger(HttpClient.class);
    private String mUrl;
    private String proxyHost;
    private int proxyport;
    static CommonHttpClient sWapHttpClient = null;

    public int getProxyport() {
        return this.proxyport;
    }

    public void setProxyport(int proxyport) {
        this.proxyport = proxyport;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public HttpClient() {
        this((String)null);
    }

    public HttpClient(String url) {
        this.mUrl = url;
        this.setDefaultHostnameVerifier();
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public URL getURL() {
        URL url = null;

        try {
            url = new URL(this.mUrl);
        } catch (Exception var3) {
            logger.error(var3);
        }

        return url;
    }

    private void setDefaultHostnameVerifier() {
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    public String sendSynchronousRequest(String requestData) {
        logger.debug("ucmed requestData=" + requestData);
        return this.sendSynchronousRequest((String)requestData, (ArrayList)null);
    }

    public String sendSynchronousRequest(String requestData, ArrayList<BasicHeader> headers) {
        ArrayList<BasicNameValuePair> pairs = new ArrayList();
//        pairs.add(new BasicNameValuePair("requestData", requestData));
        JSONObject req=JSONObject.fromObject(requestData);
        for (Object o:req.keySet()){
            String key=o.toString();
            pairs.add(new BasicNameValuePair(key, req.optString(key)));
        }
        return this.sendSynchronousRequest(pairs, headers);
    }

    public HttpResponse sendSynchronousRequestAsHttpResponse(String requestData, ArrayList<BasicHeader> headers) {
        ArrayList<BasicNameValuePair> pairs = new ArrayList();
        pairs.add(new BasicNameValuePair("requestData", requestData));
        return this.sendSynchronousRequestAsHttpResponse(pairs, headers);
    }

    public String sendSynchronousRequest(ArrayList<BasicNameValuePair> pairs, ArrayList<BasicHeader> headers) {
        String retVal = null;

        try {
            HttpResponse httpResponse = this.sendSynchronousRequestAsHttpResponse(pairs, headers);
            HttpEntity entity = httpResponse.getEntity();
            retVal = EntityUtils.toString(entity);
            logger.debug("ucmed responseData=" + retVal);
        } catch (Exception var6) {
            logger.error(var6);
        }

        return retVal;
    }

    public HttpResponse sendSynchronousRequestAsHttpResponse(ArrayList<BasicNameValuePair> pairs, ArrayList<BasicHeader> headers) {
        HttpResponse httpResponse = null;
        URL url = this.getURL();
        UrlEncodedFormEntity entity = null;
        HttpRequest httpRequest = null;
        HttpHost target = null;

        try {
            if (sWapHttpClient == null) {
                CommonHttpClient var10000 = sWapHttpClient;
                sWapHttpClient = CommonHttpClient.newInstance("wap");
            }

            HttpParams httpParams = sWapHttpClient.getParams();
            HttpHost proxy = this.getProxy();
            httpParams.setParameter("http.route.default-proxy", proxy);
            String protocol = url.getProtocol();
            int port = url.getPort();
            if (port == -1) {
                port = url.getDefaultPort();
            }

            target = new HttpHost(url.getHost(), port, protocol);
            if (pairs != null) {
                httpRequest = new HttpPost(this.mUrl);
                entity = new UrlEncodedFormEntity(pairs, "utf-8");
                ((HttpPost)httpRequest).setEntity(entity);
            } else {
                httpRequest = new HttpGet(this.mUrl);
            }

            ((HttpRequest)httpRequest).addHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            ((HttpRequest)httpRequest).addHeader("Accept", "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
            if (headers != null) {
                Iterator var12 = headers.iterator();

                while(var12.hasNext()) {
                    Header header = (Header)var12.next();
                    ((HttpRequest)httpRequest).addHeader(header);
                }
            }

            httpResponse = sWapHttpClient.execute(target, (HttpRequest)httpRequest);
        } catch (NullPointerException var15) {
            logger.error(var15);

            try {
                httpResponse = sWapHttpClient.execute(target, (HttpRequest)httpRequest);
            } catch (Exception var14) {
                logger.error(var15);
            }
        } catch (Exception var16) {
            logger.error(var16);
        }

        return httpResponse;
    }

    public HttpHost getProxy() {
        HttpHost proxy = null;
        if (this.proxyHost != null) {
            proxy = new HttpHost(this.proxyHost, this.proxyport, "http");
        }

        return proxy;
    }
}
