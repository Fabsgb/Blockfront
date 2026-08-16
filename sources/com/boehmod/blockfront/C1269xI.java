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
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xI.class */
public class C1269xI {

    /* JADX INFO: renamed from: aa */
    private static final long f6828aa = 10;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Duration f6823a = Duration.ofSeconds(15);

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Duration f6824b = Duration.ofSeconds(30);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final HttpClient f6825a = HttpClient.newBuilder().connectTimeout(f6823a).build();

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final HttpClient f6826b = HttpClient.newBuilder().connectTimeout(f6823a).followRedirects(HttpClient.Redirect.NORMAL).build();

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final Duration f6827c = Duration.ofSeconds(60);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ScheduledExecutorService f6829a = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "BlockFront-Download-Watchdog");
        thread.setDaemon(true);
        return thread;
    });

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m7155c(@NotNull URI uri) throws InterruptedException, IOException {
        HttpResponse httpResponseSend = f6825a.send(HttpRequest.newBuilder().uri(uri).timeout(f6824b).GET().build(), HttpResponse.BodyHandlers.ofString());
        if (httpResponseSend.statusCode() != 200) {
            throw new IOException("HTTP response code: " + httpResponseSend.statusCode());
        }
        return (String) httpResponseSend.body();
    }

    /* JADX INFO: renamed from: a */
    public static long m7156a(@NotNull URI uri, @NotNull Path path, @NotNull MessageDigest messageDigest, @NotNull LongConsumer longConsumer, @NotNull Predicate<URI> predicate) throws InterruptedException, IOException {
        HttpResponse httpResponseSend = f6826b.send(HttpRequest.newBuilder().uri(uri).GET().build(), HttpResponse.BodyHandlers.ofInputStream());
        if (httpResponseSend.statusCode() != 200) {
            throw new IOException("HTTP response code: " + httpResponseSend.statusCode());
        }
        URI uri2 = httpResponseSend.uri();
        if (!predicate.test(uri2)) {
            ((InputStream) httpResponseSend.body()).close();
            throw new IOException("Download redirected to a disallowed location: " + String.valueOf(uri2));
        }
        long j = 0;
        InputStream inputStream = (InputStream) httpResponseSend.body();
        try {
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, new OpenOption[0]);
            try {
                AtomicLong atomicLong = new AtomicLong(System.nanoTime());
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = f6829a.scheduleAtFixedRate(() -> {
                    if (System.nanoTime() - atomicLong.get() < f6827c.toNanos()) {
                        return;
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }, f6828aa, f6828aa, TimeUnit.SECONDS);
                try {
                    byte[] bArr = new byte[InterfaceC1274xN.f6856vY];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        outputStreamNewOutputStream.write(bArr, 0, i);
                        messageDigest.update(bArr, 0, i);
                        j += (long) i;
                        atomicLong.set(System.nanoTime());
                        longConsumer.accept(j);
                    }
                    scheduledFutureScheduleAtFixedRate.cancel(false);
                    if (outputStreamNewOutputStream != null) {
                        outputStreamNewOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return j;
                } catch (Throwable th) {
                    scheduledFutureScheduleAtFixedRate.cancel(false);
                    throw th;
                }
            } catch (Throwable th2) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (Throwable th4) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
            }
            throw th4;
        }
    }
}
