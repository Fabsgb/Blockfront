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

/* JADX INFO: renamed from: com.boehmod.blockfront.jy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jy.class */
public abstract class AbstractC0268jy {
    private static final int jU = 8001;
    private static final int jV = 6000;

    @NotNull
    private final String aG;

    @NotNull
    private static final Set<String> h = Set.of("cdn.modrinth.com", "download.blockfrontmc.com", "www.blockfrontmc.com", "blockfrontmc.com");
    private static final long i = 536870912;
    private static final int jX = 4;
    private static final long j = 5000;
    private static final long k = 25000;

    @NotNull
    private final AtomicBoolean a = new AtomicBoolean(false);
    private boolean dw = false;

    @NotNull
    private String aH = C0002a.c;
    private int jW = 1;

    @Nullable
    private final String aI = u();

    @NotNull
    private final AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private volatile a f189b = a.IDLE;
    private volatile long l = 0;
    private volatile long m = 0;

    @Nullable
    private volatile String aJ = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private volatile Path f190a = null;

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

    protected abstract void g();

    protected AbstractC0268jy(@NotNull String str) {
        this.aG = str;
    }

    public boolean ad() {
        return this.dw;
    }

    @NotNull
    public String s() {
        return this.aH;
    }

    @Nullable
    public String t() {
        return this.aI;
    }

    public void onUpdate() {
        if (!this.dw) {
            int i2 = this.jW;
            this.jW = i2 - 1;
            if (i2 <= 0) {
                this.jW = jV;
                if (!this.a.get()) {
                    this.a.set(true);
                    new Thread(new b(this)).start();
                }
            }
        }
    }

    @Nullable
    public String u() {
        Path pathA = a();
        if (pathA == null) {
            return null;
        }
        try {
            String strB = C0632xk.b(pathA);
            C0263jt.log("Found HASH '%s' for mod jar.", strB);
            return strB;
        } catch (Exception e) {
            C0263jt.a("[API] Failed to calculate HASH of the mod jar.", e, new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Path a() {
        for (IModInfo iModInfo : ModList.get().getMods()) {
            if (iModInfo.getModId().equals("bf")) {
                return iModInfo.getOwningFile().getFile().getFilePath();
            }
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m541a() {
        return this.f189b;
    }

    public boolean ae() {
        a aVar = this.f189b;
        return aVar == a.PREPARING || aVar == a.DOWNLOADING || aVar == a.VERIFYING;
    }

    public long c() {
        return this.l;
    }

    public long d() {
        return this.m;
    }

    @Nullable
    public String v() {
        return this.aJ;
    }

    public void bb() {
        if (this.b.compareAndSet(false, true)) {
            this.aJ = null;
            this.l = 0L;
            this.m = 0L;
            b(a.PREPARING);
            Thread thread = new Thread(this::bc, "BlockFront-Update-Download");
            thread.setDaemon(true);
            thread.start();
        }
    }

    private void bc() {
        try {
            try {
                JsonObject asJsonObject = JsonParser.parseString(a(new URI("http://" + this.aG + ":8001/api/v2/?type=download"))).getAsJsonObject();
                String asString = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : "";
                long asLong = asJsonObject.has("size") ? asJsonObject.get("size").getAsLong() : 0L;
                String asString2 = asJsonObject.has("sha512") ? asJsonObject.get("sha512").getAsString() : null;
                if (asString.isBlank() || asString2 == null || asString2.isEmpty() || asLong <= 0 || asLong > i) {
                    h("bf.screen.update.fail.unverified");
                    this.b.set(false);
                    return;
                }
                URI uri = new URI(asString);
                String strB = b(uri);
                if (!"https".equals(uri.getScheme()) || !h.contains(uri.getHost()) || strB == null) {
                    h("bf.screen.update.fail.unverified");
                    this.b.set(false);
                    return;
                }
                this.m = asLong;
                Path pathResolve = FMLPaths.GAMEDIR.get().resolve("blockfront").resolve("updates");
                Files.createDirectories(pathResolve, new FileAttribute[0]);
                Path pathResolve2 = pathResolve.resolve(strB + ".part");
                b(a.DOWNLOADING);
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                long jA = C0633xl.a(uri, pathResolve2, messageDigest, j2 -> {
                    this.l = j2;
                });
                b(a.VERIFYING);
                String strA = a(messageDigest.digest());
                if (jA != asLong || !strA.equalsIgnoreCase(asString2)) {
                    Files.deleteIfExists(pathResolve2);
                    h("bf.screen.update.fail.verify");
                    this.b.set(false);
                } else {
                    Path pathResolve3 = pathResolve.resolve(strB);
                    Files.move(pathResolve2, pathResolve3, StandardCopyOption.REPLACE_EXISTING);
                    this.f190a = pathResolve3;
                    b(a.READY);
                    C0263jt.log("[Update] Downloaded and verified update jar '%s'.", strB);
                    this.b.set(false);
                }
            } catch (Exception e) {
                C0263jt.a("[Update] Failed to download the update.", e, new Object[0]);
                h("bf.screen.update.fail.download");
                this.b.set(false);
            }
        } catch (Throwable th) {
            this.b.set(false);
            throw th;
        }
    }

    public void bd() {
        Path path = this.f190a;
        if (this.f189b != a.READY || path == null) {
            return;
        }
        try {
            Path pathA = a();
            if (pathA == null || !Files.isRegularFile(pathA, new LinkOption[0]) || !pathA.toString().endsWith(".jar")) {
                C0263jt.log("[Update] Not running from a mod jar (dev environment), shutting down without installing. Staged update left at '%s'.", path);
                g();
                return;
            }
            Path parent = path.getParent();
            Path pathResolve = parent.resolve("installer");
            Path pathResolve2 = pathResolve.resolve("com.boehmod.blockfront.common.update.UpdateInstaller".replace('.', '/') + ".class");
            Files.createDirectories(pathResolve2.getParent(), new FileAttribute[0]);
            InputStream resourceAsStream = AbstractC0268jy.class.getResourceAsStream("/" + "com.boehmod.blockfront.common.update.UpdateInstaller".replace('.', '/') + ".class");
            try {
                if (resourceAsStream == null) {
                    h("bf.screen.update.fail.install");
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
                C0263jt.log("[Update] Installer launched (pid %d), shutting down to install...", Long.valueOf(new ProcessBuilder(pathResolve3.toString(), "-cp", pathResolve.toString(), "com.boehmod.blockfront.common.update.UpdateInstaller", String.valueOf(ProcessHandle.current().pid()), pathA.toString(), path.toString(), pathA.getParent().toString()).redirectErrorStream(true).redirectOutput(parent.resolve("installer.log").toFile()).start().pid()));
                g();
            } finally {
            }
        } catch (Exception e) {
            C0263jt.a("[Update] Failed to launch the update installer.", e, new Object[0]);
            h("bf.screen.update.fail.install");
        }
    }

    @NotNull
    private static String a(@NotNull URI uri) throws InterruptedException, IOException {
        IOException iOException = null;
        for (int i2 = 0; i2 < 4; i2++) {
            if (i2 > 0) {
                Thread.sleep(j + ((long) (Math.random() * 25000.0d)));
            }
            try {
                return C0633xl.c(uri);
            } catch (IOException e) {
                iOException = e;
                C0263jt.log("[Update] Download metadata attempt %d/%d failed (%s).", Integer.valueOf(i2 + 1), 4, e.getMessage());
            }
        }
        throw iOException;
    }

    protected void f() {
    }

    protected void a(@NotNull a aVar) {
    }

    private void h(@NotNull String str) {
        this.aJ = str;
        b(a.FAILED);
    }

    private void b(@NotNull a aVar) {
        this.f189b = aVar;
        a(aVar);
    }

    @NotNull
    private static Path a(@NotNull Path path) throws IOException {
        Path pathResolve = path.getParent().resolve("debug-mods");
        Files.createDirectories(pathResolve, new FileAttribute[0]);
        Path pathResolve2 = pathResolve.resolve("BlockFront-debug-old.jar");
        if (!Files.exists(pathResolve2, new LinkOption[0])) {
            Files.writeString(pathResolve2, "Placeholder standing in for the running mod jar.", new OpenOption[0]);
        }
        C0263jt.log("[Update] DEBUG_UPDATE_INSTALLER: installing into sandbox '%s', replacing '%s'.", pathResolve, pathResolve2.getFileName());
        return pathResolve2;
    }

    @Nullable
    private static String b(@NotNull URI uri) {
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
    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.jy$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jy$b.class */
    public final class b implements Runnable {

        @NotNull
        private final AbstractC0268jy a;

        public b(@NotNull AbstractC0268jy abstractC0268jy) {
            this.a = abstractC0268jy;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0263jt.log("[API] Checking for updates...", new Object[0]);
            String strU = this.a.u();
            try {
                JsonObject asJsonObject = JsonParser.parseString(C0633xl.c(new URI("http://" + AbstractC0268jy.this.aG + ":8001/api/v2/?type=version"))).getAsJsonObject();
                String asString = asJsonObject.get("version").getAsString();
                String asString2 = asJsonObject.get("hash").getAsString();
                boolean z = (strU == null || asString2.isEmpty() || !strU.equals(asString2)) ? false : true;
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
                            if (jsonElement.isJsonPrimitive() && strU != null && strU.equals(jsonElement.getAsString())) {
                                z2 = true;
                                break;
                            }
                        }
                        C0263jt.log("[API] Received version '%s' with %d optional hash(es).", asString, Integer.valueOf(asJsonArray.size()));
                    } catch (Exception e) {
                        C0263jt.log("[API] Failed to parse hashes array, falling back to primary hash only.", new Object[0]);
                    }
                } else {
                    C0263jt.log("[API] Received version '%s' and hash '%s'.", asString, asString2);
                }
                boolean z3 = (asString.isEmpty() || asString.equals(C0002a.c)) ? false : true;
                boolean z4 = (asString.isEmpty() || z || z2) ? false : true;
                if (z3 || z4) {
                    this.a.dw = true;
                    this.a.aH = asString;
                    this.a.f();
                }
            } catch (IOException e2) {
                C0263jt.a("[API] Failed to receive latest update for BlockFront.", e2, new Object[0]);
            } catch (InterruptedException e3) {
                C0263jt.a("[API] Update check was interrupted.", e3, new Object[0]);
            } catch (URISyntaxException e4) {
                C0263jt.a("[API] Invalid URI for update check.", e4, new Object[0]);
            }
            AbstractC0268jy.this.a.set(false);
        }
    }
}
