package com.ucmed.httpRequest;


import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class CommonHttpClient implements HttpClient {
    private final DefaultHttpClient delegate;

    public static CommonHttpClient newInstance(String userAgent) {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(params, true);
        HttpConnectionParams.setConnectionTimeout(params, 20000);
        HttpConnectionParams.setSoTimeout(params, 20000);
        HttpConnectionParams.setSocketBufferSize(params, 16384);
        HttpClientParams.setRedirecting(params, false);
        HttpClientParams.setAuthenticating(params, false);
        if (userAgent != null) {
            HttpProtocolParams.setUserAgent(params, userAgent);
        }

        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        SSLSocketFactory sslsf = SSLSocketFactory.getSocketFactory();
        HostnameVerifier hostnameVerifier = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        sslsf.setHostnameVerifier((X509HostnameVerifier)hostnameVerifier);
        HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        schemeRegistry.register(new Scheme("https", sslsf, 443));
        ClientConnectionManager manager = new ThreadSafeClientConnManager(params, schemeRegistry);
        return new CommonHttpClient(manager, params);
    }

    private CommonHttpClient(ClientConnectionManager ccm, HttpParams params) {
        this.delegate = new CommonHttpClient.DelegateHttpClient(ccm, params);
    }

    public void close() {
        this.getConnectionManager().shutdown();
    }

    public HttpParams getParams() {
        return this.delegate.getParams();
    }

    public ClientConnectionManager getConnectionManager() {
        return this.delegate.getConnectionManager();
    }

    public HttpResponse execute(HttpUriRequest request) throws IOException {
        return this.delegate.execute(request);
    }

    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        return this.delegate.execute(request, context);
    }

    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        HttpResponse httpResponse = this.delegate.execute(target, request);
        return httpResponse;
    }

    public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException {
        return this.delegate.execute(target, request, context);
    }

    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        return this.delegate.execute(request, responseHandler);
    }

    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException {
        return this.delegate.execute(request, responseHandler, context);
    }

    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        return this.delegate.execute(target, request, responseHandler);
    }

    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException {
        return this.delegate.execute(target, request, responseHandler, context);
    }

    private static class DelegateHttpClient extends DefaultHttpClient {
        private DelegateHttpClient(ClientConnectionManager ccm, HttpParams params) {
            super(ccm, params);
        }

        protected HttpContext createHttpContext() {
            HttpContext context = new BasicHttpContext();
            context.setAttribute("http.authscheme-registry", this.getAuthSchemes());
            context.setAttribute("http.cookiespec-registry", this.getCookieSpecs());
            context.setAttribute("http.auth.credentials-provider", this.getCredentialsProvider());
            return context;
        }
    }
}

