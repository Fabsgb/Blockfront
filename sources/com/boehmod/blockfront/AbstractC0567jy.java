package com.boehmod.blockfront;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforgespi.language.IModInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jy.class */
public abstract class AbstractC0567jy {

    /* JADX INFO: renamed from: jU */
    private static final int f3205jU = 8001;

    /* JADX INFO: renamed from: jV */
    private static final int f3206jV = 6000;

    /* JADX INFO: renamed from: aG */
    @NotNull
    private final String f3207aG;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final Set<String> f3213h = Set.of("cdn.modrinth.com", "download.blockfrontmc.com", "www.blockfrontmc.com", "blockfrontmc.com");

    /* JADX INFO: renamed from: i */
    private static final long f3214i = 536870912;

    /* JADX INFO: renamed from: jX */
    private static final int f3215jX = 4;

    /* JADX INFO: renamed from: j */
    private static final long f3216j = 5000;

    /* JADX INFO: renamed from: k */
    private static final long f3217k = 25000;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AtomicBoolean f3208a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: dw */
    private boolean f3209dw = false;

    /* JADX INFO: renamed from: aH */
    @NotNull
    private String f3210aH = C0029a.f248c;

    /* JADX INFO: renamed from: jW */
    private int f3211jW = 1;

    /* JADX INFO: renamed from: aI */
    @Nullable
    private final String f3212aI = m2561u();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final AtomicBoolean f3218b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b */
    @NotNull
    private volatile a f3219b = a.IDLE;

    /* JADX INFO: renamed from: l */
    private volatile long f3220l = 0;

    /* JADX INFO: renamed from: m */
    private volatile long f3221m = 0;

    /* JADX INFO: renamed from: aJ */
    @Nullable
    private volatile String f3222aJ = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    private volatile Path f3223a = null;

    /* JADX INFO: renamed from: com.boehmod.blockfront.jy$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jy$a.class */
    public enum a {
        IDLE,
        PREPARING,
        DOWNLOADING,
        VERIFYING,
        READY,
        FAILED
    }

    /* JADX INFO: renamed from: g */
    protected abstract void mo2572g();

    protected AbstractC0567jy(@NotNull String str) {
        this.f3207aG = str;
    }

    /* JADX INFO: renamed from: ad */
    public boolean m2558ad() {
        return this.f3209dw;
    }

    @NotNull
    /* JADX INFO: renamed from: s */
    public String m2559s() {
        return this.f3210aH;
    }

    @Nullable
    /* JADX INFO: renamed from: t */
    public String m2560t() {
        return this.f3212aI;
    }

    public void onUpdate() {
        if (!this.f3209dw) {
            int i = this.f3211jW;
            this.f3211jW = i - 1;
            if (i <= 0) {
                this.f3211jW = f3206jV;
                if (!this.f3208a.get()) {
                    this.f3208a.set(true);
                    new Thread(new b(this)).start();
                }
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: u */
    public String m2561u() {
        Path pathM2562a = m2562a();
        if (pathM2562a == null) {
            return null;
        }
        try {
            String strM7830b = C1288xk.m7830b(pathM2562a);
            C0562jt.log("Found HASH '%s' for mod jar.", strM7830b);
            return strM7830b;
        } catch (Exception e) {
            C0562jt.m2516a("[API] Failed to calculate HASH of the mod jar.", e, new Object[0]);
            return null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static Path m2562a() {
        for (IModInfo iModInfo : ModList.get().getMods()) {
            if (iModInfo.getModId().equals("bf")) {
                return iModInfo.getOwningFile().getFile().getFilePath();
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m2563a() {
        return this.f3219b;
    }

    /* JADX INFO: renamed from: ae */
    public boolean m2564ae() {
        a aVar = this.f3219b;
        return aVar == a.PREPARING || aVar == a.DOWNLOADING || aVar == a.VERIFYING;
    }

    /* JADX INFO: renamed from: c */
    public long m2565c() {
        return this.f3220l;
    }

    /* JADX INFO: renamed from: d */
    public long mo2566d() {
        return this.f3221m;
    }

    @Nullable
    /* JADX INFO: renamed from: v */
    public String m2567v() {
        return this.f3222aJ;
    }

    /* JADX INFO: renamed from: bb */
    public void m2568bb() {
        if (this.f3218b.compareAndSet(false, true)) {
            this.f3222aJ = null;
            this.f3220l = 0L;
            this.f3221m = 0L;
            m2576b(a.PREPARING);
            Thread thread = new Thread(this::m2569bc, "BlockFront-Update-Download");
            thread.setDaemon(true);
            thread.start();
        }
    }

    /* JADX INFO: renamed from: bc */
    private void m2569bc() {
        try {
            try {
                JsonObject asJsonObject = JsonParser.parseString(m2571a(new URI("http://" + this.f3207aG + ":8001/api/v2/?type=download"))).getAsJsonObject();
                String asString = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : "";
                long asLong = asJsonObject.has("size") ? asJsonObject.get("size").getAsLong() : 0L;
                String asString2 = asJsonObject.has("sha512") ? asJsonObject.get("sha512").getAsString() : null;
                if (asString.isBlank() || asString2 == null || asString2.isEmpty() || asLong <= 0 || asLong > f3214i) {
                    m2575h("bf.screen.update.fail.unverified");
                    this.f3218b.set(false);
                    return;
                }
                URI uri = new URI(asString);
                String strM2578b = m2578b(uri);
                if (!"https".equals(uri.getScheme()) || !f3213h.contains(uri.getHost()) || strM2578b == null) {
                    m2575h("bf.screen.update.fail.unverified");
                    this.f3218b.set(false);
                    return;
                }
                this.f3221m = asLong;
                Path pathResolve = FMLPaths.GAMEDIR.get().resolve("blockfront").resolve("updates");
                Files.createDirectories(pathResolve, new FileAttribute[0]);
                Path pathResolve2 = pathResolve.resolve(strM2578b + ".part");
                m2576b(a.DOWNLOADING);
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                long jM7832a = C1289xl.m7832a(uri, pathResolve2, messageDigest, j -> {
                    this.f3220l = j;
                });
                m2576b(a.VERIFYING);
                String strM2579a = m2579a(messageDigest.digest());
                if (jM7832a != asLong || !strM2579a.equalsIgnoreCase(asString2)) {
                    Files.deleteIfExists(pathResolve2);
                    m2575h("bf.screen.update.fail.verify");
                    this.f3218b.set(false);
                } else {
                    Path pathResolve3 = pathResolve.resolve(strM2578b);
                    Files.move(pathResolve2, pathResolve3, StandardCopyOption.REPLACE_EXISTING);
                    this.f3223a = pathResolve3;
                    m2576b(a.READY);
                    C0562jt.log("[Update] Downloaded and verified update jar '%s'.", strM2578b);
                    this.f3218b.set(false);
                }
            } catch (Exception e) {
                C0562jt.m2516a("[Update] Failed to download the update.", e, new Object[0]);
                m2575h("bf.screen.update.fail.download");
                this.f3218b.set(false);
            }
        } catch (Throwable th) {
            this.f3218b.set(false);
            throw th;
        }
    }

    /* JADX INFO: renamed from: bd */
    public void m2570bd() {
        Path path = this.f3223a;
        if (this.f3219b != a.READY || path == null) {
            return;
        }
        try {
            Path pathM2562a = m2562a();
            if (pathM2562a == null || !Files.isRegularFile(pathM2562a, new LinkOption[0]) || !pathM2562a.toString().endsWith(".jar")) {
                C0562jt.log("[Update] Not running from a mod jar (dev environment), shutting down without installing. Staged update left at '%s'.", path);
                mo2572g();
                return;
            }
            Path parent = path.getParent();
            Path pathResolve = parent.resolve("installer");
            Path pathResolve2 = pathResolve.resolve("com.boehmod.blockfront.common.update.UpdateInstaller".replace('.', '/') + ".class");
            Files.createDirectories(pathResolve2.getParent(), new FileAttribute[0]);
            InputStream resourceAsStream = AbstractC0567jy.class.getResourceAsStream("/" + "com.boehmod.blockfront.common.update.UpdateInstaller".replace('.', '/') + ".class");
            try {
                if (resourceAsStream == null) {
                    m2575h("bf.screen.update.fail.install");
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                        return;
                    }
                    return;
                }
                Files.copy(resourceAsStream, pathResolve2, StandardCopyOption.REPLACE_EXISTING);
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                boolean zContains = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win");
                Path pathOf = Path.of(System.getProperty("java.home"), "bin");
                Path pathResolve3 = pathOf.resolve(zContains ? "javaw.exe" : "java");
                if (!Files.exists(pathResolve3, new LinkOption[0])) {
                    pathResolve3 = pathOf.resolve(zContains ? "java.exe" : "java");
                }
                C0562jt.log("[Update] Installer launched (pid %d), shutting down to install...", Long.valueOf(new ProcessBuilder(pathResolve3.toString(), "-cp", pathResolve.toString(), "com.boehmod.blockfront.common.update.UpdateInstaller", String.valueOf(ProcessHandle.current().pid()), pathM2562a.toString(), path.toString(), pathM2562a.getParent().toString()).redirectErrorStream(true).redirectOutput(parent.resolve("installer.log").toFile()).start().pid()));
                mo2572g();
            } finally {
            }
        } catch (Exception e) {
            C0562jt.m2516a("[Update] Failed to launch the update installer.", e, new Object[0]);
            m2575h("bf.screen.update.fail.install");
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m2571a(@NotNull URI uri) throws InterruptedException, IOException {
        IOException iOException = null;
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                Thread.sleep(f3216j + ((long) (Math.random() * 25000.0d)));
            }
            try {
                return C1289xl.m7831c(uri);
            } catch (IOException e) {
                iOException = e;
                C0562jt.log("[Update] Download metadata attempt %d/%d failed (%s).", Integer.valueOf(i + 1), 4, e.getMessage());
            }
        }
        throw iOException;
    }

    /* JADX INFO: renamed from: f */
    protected void mo2573f() {
    }

    /* JADX INFO: renamed from: a */
    protected void mo2574a(@NotNull a aVar) {
    }

    /* JADX INFO: renamed from: h */
    private void m2575h(@NotNull String str) {
        this.f3222aJ = str;
        m2576b(a.FAILED);
    }

    /* JADX INFO: renamed from: b */
    private void m2576b(@NotNull a aVar) {
        this.f3219b = aVar;
        mo2574a(aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Path m2577a(@NotNull Path path) throws IOException {
        Path pathResolve = path.getParent().resolve("debug-mods");
        Files.createDirectories(pathResolve, new FileAttribute[0]);
        Path pathResolve2 = pathResolve.resolve("BlockFront-debug-old.jar");
        if (!Files.exists(pathResolve2, new LinkOption[0])) {
            Files.writeString(pathResolve2, "Placeholder standing in for the running mod jar.", new OpenOption[0]);
        }
        C0562jt.log("[Update] DEBUG_UPDATE_INSTALLER: installing into sandbox '%s', replacing '%s'.", pathResolve, pathResolve2.getFileName());
        return pathResolve2;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    private static String m2578b(@NotNull URI uri) {
        String path = uri.getPath();
        if (path == null || path.isEmpty()) {
            return null;
        }
        String strDecode = URLDecoder.decode(path.substring(path.lastIndexOf(47) + 1), StandardCharsets.UTF_8);
        if (!strDecode.endsWith(".jar") || strDecode.contains("..") || strDecode.contains("/") || strDecode.contains("\\")) {
            return null;
        }
        return strDecode;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m2579a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.jy$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jy$b.class */
    public final class b implements Runnable {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractC0567jy f3224a;

        public b(@NotNull AbstractC0567jy abstractC0567jy) {
            this.f3224a = abstractC0567jy;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0562jt.log("[API] Checking for updates...", new Object[0]);
            String strM2561u = this.f3224a.m2561u();
            try {
                JsonObject asJsonObject = JsonParser.parseString(C1289xl.m7831c(new URI("http://" + AbstractC0567jy.this.f3207aG + ":8001/api/v2/?type=version"))).getAsJsonObject();
                String asString = asJsonObject.get("version").getAsString();
                String asString2 = asJsonObject.get("hash").getAsString();
                boolean z = (strM2561u == null || asString2.isEmpty() || !strM2561u.equals(asString2)) ? false : true;
                boolean z2 = false;
                if (asJsonObject.has("hashes")) {
                    try {
                        JsonArray asJsonArray = asJsonObject.getAsJsonArray("hashes");
                        Iterator it = asJsonArray.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            JsonElement jsonElement = (JsonElement) it.next();
                            if (jsonElement.isJsonPrimitive() && strM2561u != null && strM2561u.equals(jsonElement.getAsString())) {
                                z2 = true;
                                break;
                            }
                        }
                        C0562jt.log("[API] Received version '%s' with %d optional hash(es).", asString, Integer.valueOf(asJsonArray.size()));
                    } catch (Exception e) {
                        C0562jt.log("[API] Failed to parse hashes array, falling back to primary hash only.", new Object[0]);
                    }
                } else {
                    C0562jt.log("[API] Received version '%s' and hash '%s'.", asString, asString2);
                }
                boolean z3 = (asString.isEmpty() || asString.equals(C0029a.f248c)) ? false : true;
                boolean z4 = (asString.isEmpty() || z || z2) ? false : true;
                if (z3 || z4) {
                    this.f3224a.f3209dw = true;
                    this.f3224a.f3210aH = asString;
                    this.f3224a.mo2573f();
                }
            } catch (IOException e2) {
                C0562jt.m2516a("[API] Failed to receive latest update for BlockFront.", e2, new Object[0]);
            } catch (InterruptedException e3) {
                C0562jt.m2516a("[API] Update check was interrupted.", e3, new Object[0]);
            } catch (URISyntaxException e4) {
                C0562jt.m2516a("[API] Invalid URI for update check.", e4, new Object[0]);
            }
            AbstractC0567jy.this.f3208a.set(false);
        }
    }
}
