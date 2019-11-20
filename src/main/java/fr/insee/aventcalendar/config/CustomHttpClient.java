package fr.insee.aventcalendar.config;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class CustomHttpClient {

    @Value("${proxy.host}")
    private String proxyAddress;
    @Value("${proxy.port}")
    private Integer proxyPort;
    @Value("${proxy.use}")
    private Boolean proxyUse;
    @Value("${auth.cookie}")
    private String authCookie;

    @Bean
    public OkHttpClient getClient() {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                final Request original = chain.request();

                final Request authorized = original.newBuilder()
                    .addHeader("Cookie", "session="+ authCookie)
                    .build();

                return chain.proceed(authorized);
            }
        });

        if (proxyUse) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddress, proxyPort));
            client.proxy(proxy);
        }

        return client.build();
    }
}
