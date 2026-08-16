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
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforgespi.language.IModInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jR.class */
public abstract class AbstractC0535jR {

    /* JADX INFO: renamed from: lB */
    private static final int f3189lB = 8001;

    /* JADX INFO: renamed from: lC */
    private static final int f3190lC = 6000;

    /* JADX INFO: renamed from: aM */
    @NotNull
    private final String f3191aM;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final Set<String> f3197i = Set.of("cdn.modrinth.com", "download.blockfrontmc.com", "www.blockfrontmc.com", "blockfrontmc.com");

    /* JADX INFO: renamed from: n */
    private static final long f3198n = 536870912;

    /* JADX INFO: renamed from: lE */
    private static final int f3199lE = 4;

    /* JADX INFO: renamed from: o */
    private static final long f3200o = 5000;

    /* JADX INFO: renamed from: p */
    private static final long f3201p = 25000;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AtomicBoolean f3192a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: dH */
    private boolean f3193dH = false;

    /* JADX INFO: renamed from: aN */
    @NotNull
    private String f3194aN = C0030a.f265c;

    /* JADX INFO: renamed from: lD */
    private int f3195lD = 1;

    /* JADX INFO: renamed from: aO */
    @Nullable
    private final String f3196aO = m2385y();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final AtomicBoolean f3202b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b */
    @NotNull
    private volatile a f3203b = a.IDLE;

    /* JADX INFO: renamed from: q */
    private volatile long f3204q = 0;

    /* JADX INFO: renamed from: r */
    private volatile long f3205r = 0;

    /* JADX INFO: renamed from: aP */
    @Nullable
    private volatile String f3206aP = null;

    /* JADX INFO: renamed from: b */
    @Nullable
    private volatile Path f3207b = null;

    /* JADX INFO: renamed from: com.boehmod.blockfront.jR$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jR$a.class */
    public enum a {
        IDLE,
        PREPARING,
        DOWNLOADING,
        VERIFYING,
        READY,
        FAILED
    }

    /* JADX INFO: renamed from: g */
    protected abstract void mo2396g();

    protected AbstractC0535jR(@NotNull String str) {
        this.f3191aM = str;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public URI m2381a(@NotNull String str) throws URISyntaxException {
        String str2;
        if (C0030a.f270d.equals(this.f3191aM)) {
            str2 = C0030a.f272e;
        } else {
            str2 = "http://" + this.f3191aM + ":8001";
        }
        return new URI(str2 + "/api/v2/?type=" + str);
    }

    /* JADX INFO: renamed from: ah */
    public boolean m2382ah() {
        return this.f3193dH;
    }

    @NotNull
    /* JADX INFO: renamed from: w */
    public String m2383w() {
        return this.f3194aN;
    }

    @Nullable
    /* JADX INFO: renamed from: x */
    public String m2384x() {
        return this.f3196aO;
    }

    public void onUpdate() {
        if (!this.f3193dH) {
            int i = this.f3195lD;
            this.f3195lD = i - 1;
            if (i <= 0) {
                this.f3195lD = f3190lC;
                if (!this.f3192a.get()) {
                    this.f3192a.set(true);
                    new Thread(new b(this)).start();
                }
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: y */
    public String m2385y() {
        Path pathM2386b = m2386b();
        if (pathM2386b == null) {
            return null;
        }
        try {
            String strM7154c = C1268xH.m7154c(pathM2386b);
            C0530jM.log("Found HASH '%s' for mod jar.", strM7154c);
            return strM7154c;
        } catch (Exception e) {
            C0530jM.m2338a("[API] Failed to calculate HASH of the mod jar.", e, new Object[0]);
            return null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static Path m2386b() {
        for (IModInfo iModInfo : ModList.get().getMods()) {
            if (iModInfo.getModId().equals("bf")) {
                return iModInfo.getOwningFile().getFile().getFilePath();
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m2387a() {
        return this.f3203b;
    }

    /* JADX INFO: renamed from: ai */
    public boolean m2388ai() {
        a aVar = this.f3203b;
        return aVar == a.PREPARING || aVar == a.DOWNLOADING || aVar == a.VERIFYING;
    }

    /* JADX INFO: renamed from: d */
    public long mo2389d() {
        return this.f3204q;
    }

    /* JADX INFO: renamed from: e */
    public long mo2390e() {
        return this.f3205r;
    }

    @Nullable
    /* JADX INFO: renamed from: z */
    public String m2391z() {
        return this.f3206aP;
    }

    /* JADX INFO: renamed from: bn */
    public void m2392bn() {
        if (this.f3202b.compareAndSet(false, true)) {
            this.f3206aP = null;
            this.f3204q = 0L;
            this.f3205r = 0L;
            m2400b(a.PREPARING);
            Thread thread = new Thread(this::m2393bo, "BlockFront-Update-Download");
            thread.setDaemon(true);
            thread.start();
        }
    }

    /* JADX INFO: renamed from: bo */
    private void m2393bo() {
        try {
            JsonObject asJsonObject = JsonParser.parseString(m2395a(m2381a("download"))).getAsJsonObject();
            String asString = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : "";
            long asLong = asJsonObject.has("size") ? asJsonObject.get("size").getAsLong() : 0L;
            String asString2 = asJsonObject.has("sha512") ? asJsonObject.get("sha512").getAsString() : null;
            if (asString.isBlank() || asString2 == null || asString2.isEmpty() || asLong <= 0 || asLong > f3198n) {
                m2399h("bf.screen.update.fail.unverified");
                return;
            }
            URI uri = new URI(asString);
            String strM2403b = m2403b(uri);
            if (!m2402a(uri) || strM2403b == null) {
                m2399h("bf.screen.update.fail.unverified");
                return;
            }
            this.f3205r = asLong;
            Path pathResolve = FMLPaths.GAMEDIR.get().resolve("blockfront").resolve("updates");
            Files.createDirectories(pathResolve, new FileAttribute[0]);
            Path pathResolve2 = pathResolve.resolve(strM2403b + ".part");
            m2400b(a.DOWNLOADING);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            long jM7156a = C1269xI.m7156a(uri, pathResolve2, messageDigest, j -> {
                this.f3204q = j;
            }, AbstractC0535jR::m2402a);
            m2400b(a.VERIFYING);
            String strM2404a = m2404a(messageDigest.digest());
            if (jM7156a != asLong || !strM2404a.equalsIgnoreCase(asString2)) {
                Files.deleteIfExists(pathResolve2);
                m2399h("bf.screen.update.fail.verify");
                return;
            }
            Path pathResolve3 = pathResolve.resolve(strM2403b);
            Files.move(pathResolve2, pathResolve3, StandardCopyOption.REPLACE_EXISTING);
            this.f3207b = pathResolve3;
            m2400b(a.READY);
            C0530jM.log("[Update] Downloaded and verified update jar '%s'.", strM2403b);
        } catch (Exception e) {
            C0530jM.m2338a("[Update] Failed to download the update.", e, new Object[0]);
            m2399h("bf.screen.update.fail.download");
        } finally {
            this.f3202b.set(false);
        }
    }

    /* JADX INFO: renamed from: bp */
    public void m2394bp() {
        Path path = this.f3207b;
        if (this.f3203b != a.READY || path == null) {
            return;
        }
        try {
            Path pathM2386b = m2386b();
            if (pathM2386b == null || !Files.isRegularFile(pathM2386b, new LinkOption[0]) || !pathM2386b.toString().endsWith(".jar")) {
                C0530jM.log("[Update] Not running from a mod jar (dev environment), shutting down without installing. Staged update left at '%s'.", path);
                mo2396g();
                return;
            }
            Path parent = path.getParent();
            Path pathResolve = parent.resolve("installer");
            Path pathResolve2 = pathResolve.resolve("com.boehmod.blockfront.common.update.UpdateInstaller".replace('.', '/') + ".class");
            Files.createDirectories(pathResolve2.getParent(), new FileAttribute[0]);
            InputStream resourceAsStream = AbstractC0535jR.class.getResourceAsStream("/" + "com.boehmod.blockfront.common.update.UpdateInstaller".replace('.', '/') + ".class");
            try {
                if (resourceAsStream == null) {
                    m2399h("bf.screen.update.fail.install");
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
                C0530jM.log("[Update] Installer launched (pid %d), shutting down to install...", Long.valueOf(new ProcessBuilder(pathResolve3.toString(), "-cp", pathResolve.toString(), "com.boehmod.blockfront.common.update.UpdateInstaller", String.valueOf(ProcessHandle.current().pid()), pathM2386b.toString(), path.toString(), pathM2386b.getParent().toString()).redirectErrorStream(true).redirectOutput(parent.resolve("installer.log").toFile()).start().pid()));
                mo2396g();
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            C0530jM.m2338a("[Update] Failed to launch the update installer.", e, new Object[0]);
            m2399h("bf.screen.update.fail.install");
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m2395a(@NotNull URI uri) throws InterruptedException, IOException {
        IOException iOException = null;
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                Thread.sleep(f3200o + ((long) (Math.random() * 25000.0d)));
            }
            try {
                return C1269xI.m7155c(uri);
            } catch (IOException e) {
                iOException = e;
                C0530jM.log("[Update] Download metadata attempt %d/%d failed (%s).", Integer.valueOf(i + 1), 4, e.getMessage());
            }
        }
        throw iOException;
    }

    /* JADX INFO: renamed from: f */
    protected void mo2397f() {
    }

    /* JADX INFO: renamed from: a */
    protected void mo2398a(@NotNull a aVar) {
    }

    /* JADX INFO: renamed from: h */
    private void m2399h(@NotNull String str) {
        this.f3206aP = str;
        m2400b(a.FAILED);
    }

    /* JADX INFO: renamed from: b */
    private void m2400b(@NotNull a aVar) {
        this.f3203b = aVar;
        mo2398a(aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static Path m2401b(@NotNull Path path) throws IOException {
        Path pathResolve = path.getParent().resolve("debug-mods");
        Files.createDirectories(pathResolve, new FileAttribute[0]);
        Path pathResolve2 = pathResolve.resolve("BlockFront-debug-old.jar");
        if (!Files.exists(pathResolve2, new LinkOption[0])) {
            Files.writeString(pathResolve2, "Placeholder standing in for the running mod jar.", new OpenOption[0]);
        }
        C0530jM.log("[Update] DEBUG_UPDATE_INSTALLER: installing into sandbox '%s', replacing '%s'.", pathResolve, pathResolve2.getFileName());
        return pathResolve2;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static boolean m2402a(@NotNull URI uri) {
        return "https".equals(uri.getScheme()) && f3197i.contains(uri.getHost());
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    private static String m2403b(@NotNull URI uri) {
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
    private static String m2404a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.jR$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jR$b.class */
    public final class b implements Runnable {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractC0535jR f3208a;

        public b(AbstractC0535jR abstractC0535jR) {
            this.f3208a = abstractC0535jR;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0530jM.log("[API] Checking for updates...", new Object[0]);
            String strM2385y = this.f3208a.m2385y();
            try {
                JsonObject asJsonObject = JsonParser.parseString(C1269xI.m7155c(AbstractC0535jR.this.m2381a("version"))).getAsJsonObject();
                String asString = asJsonObject.get("version").getAsString();
                String asString2 = asJsonObject.get("hash").getAsString();
                boolean z = (strM2385y == null || asString2.isEmpty() || !strM2385y.equals(asString2)) ? false : true;
                boolean z2 = false;
                if (asJsonObject.has("hashes")) {
                    try {
                        JsonArray<JsonElement> asJsonArray = asJsonObject.getAsJsonArray("hashes");
                        for (JsonElement jsonElement : asJsonArray) {
                            if (jsonElement.isJsonPrimitive() && strM2385y != null && strM2385y.equals(jsonElement.getAsString())) {
                                z2 = true;
                                break;
                            }
                        }
                        C0530jM.log("[API] Received version '%s' with %d optional hash(es).", asString, Integer.valueOf(asJsonArray.size()));
                    } catch (Exception e) {
                        C0530jM.log("[API] Failed to parse hashes array, falling back to primary hash only.", new Object[0]);
                    }
                } else {
                    C0530jM.log("[API] Received version '%s' and hash '%s'.", asString, asString2);
                }
                boolean z3 = (asString.isEmpty() || asString.equals(C0030a.f265c)) ? false : true;
                boolean z4 = (asString.isEmpty() || z || z2) ? false : true;
                if (z3 || z4) {
                    this.f3208a.f3193dH = true;
                    this.f3208a.f3194aN = asString;
                    this.f3208a.mo2397f();
                }
            } catch (IOException e2) {
                C0530jM.m2338a("[API] Failed to receive latest update for BlockFront.", e2, new Object[0]);
            } catch (InterruptedException e3) {
                C0530jM.m2338a("[API] Update check was interrupted.", e3, new Object[0]);
            } catch (URISyntaxException e4) {
                C0530jM.m2338a("[API] Invalid URI for update check.", e4, new Object[0]);
            }
            AbstractC0535jR.this.f3192a.set(false);
        }
    }
}
