package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000ac.RuntimeSources;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.Tlhelp32;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.z */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/z.class */
public final class C1331z implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: ae */
    private static final int f9091ae = 375;

    /* JADX INFO: renamed from: af */
    private static final int f9092af = 16384;

    /* JADX INFO: renamed from: ag */
    private static final int f9093ag = 5;

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final String f9094s = m8320i();

    /* JADX INFO: renamed from: I */
    private static final boolean f9095I = f9094s.equals(".dll");

    /* JADX INFO: renamed from: ab */
    private int f9096ab = 0;

    /* JADX INFO: renamed from: c */
    private static final long f9097c = 67108864;

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m8319a(@NotNull Path path, @NotNull String str) {
        try {
            long size = Files.size(path);
            if (size > f9097c) {
                return str + " {" + size + "b}";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(PacketIdentifier.HASH_ALGORITHM);
            InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
            try {
                byte[] bArr = new byte[InterfaceC1274xN.f6856vY];
                while (true) {
                    int i = inputStreamNewInputStream.read(bArr);
                    if (i < 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                    return str + " {unreadable}";
                }
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
                StringBuilder sb = new StringBuilder();
                for (byte b : messageDigest.digest()) {
                    sb.append(Character.forDigit((b >> 4) & 15, 16)).append(Character.forDigit(b & 15, 16));
                }
                String.valueOf(sb);
                return str + " {" + size + "b sha256=" + str + "}";
            } catch (Throwable th) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            return str + " {unreadable}";
        }
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    private static String m8320i() {
        String strMapLibraryName = System.mapLibraryName("a");
        int iLastIndexOf = strMapLibraryName.lastIndexOf(46);
        return iLastIndexOf < 0 ? ".so" : strMapLibraryName.substring(iLastIndexOf).toLowerCase(Locale.ROOT);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m8321a(@NotNull Path path, long j) {
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, new LinkOption[0]);
            return Math.max(attributes.creationTime().toMillis(), attributes.lastModifiedTime().toMillis()) >= j;
        } catch (IOException | UnsupportedOperationException e) {
            return false;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static Path m8322a() {
        String property = System.getProperty("java.io.tmpdir");
        if (property == null || property.isEmpty()) {
            return null;
        }
        try {
            return Paths.get(property, new String[0]).toAbsolutePath().normalize();
        } catch (Throwable th) {
            return null;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ObjectList<String> m8323a(@NotNull Path path) throws Throwable {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator it = Kernel32Util.getModules(Kernel32.INSTANCE.GetCurrentProcessId()).iterator();
        while (it.hasNext()) {
            Path pathNormalize = Paths.get(((Tlhelp32.MODULEENTRY32W) it.next()).szExePath(), new String[0]).toAbsolutePath().normalize();
            if (pathNormalize.startsWith(path)) {
                String string = path.relativize(pathNormalize).toString();
                if (!RuntimeSources.isKnownNativePath(string) && !RuntimeSources.isKnownNativeName(pathNormalize.getFileName().toString())) {
                    objectArrayList.add(m8319a(pathNormalize, string));
                    if (objectArrayList.size() >= 5) {
                        break;
                    }
                }
            } else {
                continue;
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ObjectList<String> m8324a(@NotNull Path path, @NotNull Path path2) throws Throwable {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        for (String str : Files.readString(path).split("\n")) {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf >= 0) {
                String[] strArrSplit = str.substring(0, iIndexOf).trim().split("\\s+");
                if (strArrSplit.length >= 2 && strArrSplit[1].indexOf(C0358g.f2490g) >= 0) {
                    String strSubstring = str.substring(iIndexOf);
                    if (strSubstring.endsWith(" (deleted)")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - " (deleted)".length());
                    }
                    if (objectOpenHashSet.add(strSubstring)) {
                        try {
                            Path pathNormalize = Paths.get(strSubstring, new String[0]).toAbsolutePath().normalize();
                            if (pathNormalize.startsWith(path2)) {
                                String string = path2.relativize(pathNormalize).toString();
                                if (!RuntimeSources.isKnownNativePath(string) && !RuntimeSources.isKnownNativeName(pathNormalize.getFileName().toString())) {
                                    objectArrayList.add(m8319a(pathNormalize, string));
                                    if (objectArrayList.size() >= 5) {
                                        break;
                                    }
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable th) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static ObjectList<String> m8325b(@NotNull Path path) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        try {
            long startTime = ManagementFactory.getRuntimeMXBean().getStartTime();
            try {
                DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
                try {
                    int i = 0;
                    for (Path path2 : directoryStreamNewDirectoryStream) {
                        i++;
                        if (i > 16384) {
                            break;
                        }
                        String lowerCase = path2.getFileName().toString().toLowerCase(Locale.ROOT);
                        if (lowerCase.endsWith(f9094s) && !RuntimeSources.isKnownNativeName(lowerCase) && Files.isRegularFile(path2, new LinkOption[0]) && m8321a(path2, startTime)) {
                            objectArrayList.add(m8319a(path2, path2.getFileName().toString()));
                            if (objectArrayList.size() >= 5) {
                                break;
                            }
                        }
                    }
                    if (directoryStreamNewDirectoryStream != null) {
                        directoryStreamNewDirectoryStream.close();
                    }
                    return objectArrayList;
                } catch (Throwable th) {
                    if (directoryStreamNewDirectoryStream != null) {
                        try {
                            directoryStreamNewDirectoryStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException | SecurityException e) {
                return objectArrayList;
            }
        } catch (Throwable th3) {
            return objectArrayList;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static ObjectList<String> m8326c() {
        Path pathM8322a = m8322a();
        if (pathM8322a == null) {
            return ObjectLists.emptyList();
        }
        if (f9095I) {
            try {
                return m8323a(pathM8322a);
            } catch (Throwable th) {
                return m8325b(pathM8322a);
            }
        }
        Path path = Paths.get("/proc/self/maps", new String[0]);
        if (Files.isReadable(path)) {
            try {
                return m8324a(path, pathM8322a);
            } catch (Throwable th2) {
                return m8325b(pathM8322a);
            }
        }
        return m8325b(pathM8322a);
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        if (!C0529jL.m2334ag()) {
            return null;
        }
        int i = this.f9096ab;
        this.f9096ab = i - 1;
        if (i > 0) {
            return null;
        }
        this.f9096ab = f9091ae;
        ObjectList<String> objectListM8326c = m8326c();
        if (objectListM8326c.isEmpty()) {
            return null;
        }
        return String.join((CharSequence) ", ", (Iterable<? extends CharSequence>) objectListM8326c);
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.RUNTIME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 7;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.b mo13a() {
        return C0994s.b.SILENT;
    }
}
