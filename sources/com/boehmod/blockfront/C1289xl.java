package com.boehmod.blockfront;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.function.LongConsumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xl.class */
public class C1289xl {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final HttpClient f8631a = HttpClient.newHttpClient();

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final HttpClient f8632b = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m7831c(@NotNull URI uri) throws InterruptedException, IOException {
        HttpResponse httpResponseSend = f8631a.send(HttpRequest.newBuilder().uri(uri).GET().build(), HttpResponse.BodyHandlers.ofString());
        if (httpResponseSend.statusCode() != 200) {
            throw new IOException("HTTP response code: " + httpResponseSend.statusCode());
        }
        return (String) httpResponseSend.body();
    }

    /* JADX INFO: renamed from: a */
    public static long m7832a(@NotNull URI uri, @NotNull Path path, @NotNull MessageDigest messageDigest, @NotNull LongConsumer longConsumer) throws InterruptedException, IOException {
        HttpResponse httpResponseSend = f8632b.send(HttpRequest.newBuilder().uri(uri).GET().build(), HttpResponse.BodyHandlers.ofInputStream());
        if (httpResponseSend.statusCode() != 200) {
            throw new IOException("HTTP response code: " + httpResponseSend.statusCode());
        }
        long j = 0;
        InputStream inputStream = (InputStream) httpResponseSend.body();
        try {
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, new OpenOption[0]);
            try {
                byte[] bArr = new byte[InterfaceC1294xq.f8659tU];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    outputStreamNewOutputStream.write(bArr, 0, i);
                    messageDigest.update(bArr, 0, i);
                    j += (long) i;
                    longConsumer.accept(j);
                }
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return j;
            } finally {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
