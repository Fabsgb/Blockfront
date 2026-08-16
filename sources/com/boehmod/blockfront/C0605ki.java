package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0613kq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ki */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ki.class */
public class C0605ki<T extends InterfaceC0613kq> {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Gson f3504b = new GsonBuilder().setPrettyPrinting().create();

    /* JADX INFO: renamed from: mf */
    private static final int f3505mf = 128;

    /* JADX INFO: renamed from: aU */
    @NotNull
    private final String f3506aU;

    /* JADX INFO: renamed from: aV */
    @NotNull
    private final String f3507aV;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final Map<String, T> f3508v = new ConcurrentHashMap();

    /* JADX INFO: renamed from: ae */
    @NotNull
    private final List<String> f3509ae = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0571kA<T> f3510a;

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Codec<T> f3511j;

    public C0605ki(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0607kk c0607kk, @NotNull String str, @NotNull AbstractC0571kA<T> abstractC0571kA) {
        this.f3506aU = str;
        this.f3510a = abstractC0571kA;
        this.f3511j = (Codec<T>) abstractC0571kA.mo2591a(abstractC0531jN);
        this.f3507aV = c0607kk.m2747F() + "/" + str;
        m2708bw();
        m2702bv();
    }

    /* JADX INFO: renamed from: bv */
    public void m2702bv() {
        Iterator<T> it = this.f3508v.values().iterator();
        while (it.hasNext()) {
            it.next().mo2598bA();
        }
        this.f3508v.clear();
        try {
            Files.walk(Paths.get(this.f3507aV, new String[0]), new FileVisitOption[0]).filter(path -> {
                return Files.isRegularFile(path, new LinkOption[0]);
            }).filter(path2 -> {
                return path2.toString().endsWith(".json");
            }).forEach(this::m2704a);
            C0530jM.log("[Asset Registry] Found %d assets for asset type '%s'", Integer.valueOf(this.f3508v.size()), this.f3506aU);
        } catch (IOException e) {
            C0530jM.logError("Failed to load all assets.", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2703a(@NotNull CommandSource commandSource) {
        this.f3508v.values().forEach(interfaceC0613kq -> {
            interfaceC0613kq.mo2597c(commandSource);
        });
    }

    /* JADX INFO: renamed from: a */
    private void m2704a(@NotNull Path path) {
        try {
            this.f3508v.put(m2717b(path), (T) m2705a(path));
        } catch (Exception e) {
            C0530jM.m2338a("[Asset Registry] Failed to load asset '%s'.", e, path.getFileName());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private T m2705a(@NotNull Path path) throws IOException {
        FileReader fileReader = new FileReader(path.toFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                JsonElement jsonElement = (JsonElement) f3504b.fromJson(bufferedReader, JsonElement.class);
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    throw new IOException("Asset file is empty or contains no JSON.");
                }
                T t = (T) this.f3511j.parse(JsonOps.INSTANCE, jsonElement).getOrThrow(str -> {
                    C0530jM.logError("[Asset Registry] Failed to parse asset '%s' with codec (%s)", path.getFileName(), str);
                    return new RuntimeException(str);
                });
                if (t == null) {
                    throw new IOException("Asset codec produced a null result.");
                }
                bufferedReader.close();
                fileReader.close();
                return t;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileReader.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2706a(@NotNull String str, @NotNull T t) {
        this.f3509ae.remove(str);
        if (this.f3508v.containsKey(str)) {
            C0530jM.logError("[Asset Registry] Asset '%s' for asset type '%s' already exists and has been replaced!", str, this.f3506aU);
        }
        C0530jM.log("[Asset Registry] Registered new asset '%s' for asset type '%s'", str, this.f3506aU);
        this.f3508v.put(str, t);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public T m2707a(@NotNull String str) {
        return this.f3508v.get(str);
    }

    /* JADX INFO: renamed from: bw */
    private void m2708bw() {
        Path path = Paths.get(this.f3507aV, new String[0]);
        try {
            Files.createDirectories(path, new FileAttribute[0]);
            C0530jM.log("[Asset Registry] Created new directory '%s' for asset type '%s'", path.toAbsolutePath(), this.f3506aU);
        } catch (IOException e) {
            C0530jM.m2338a("[Asset Registry] Failed to create directory '%s' for asset type '%s'", e, path.toAbsolutePath(), this.f3506aU);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2709b(@Nullable CommandSource commandSource) {
        for (Map.Entry<String, T> entry : this.f3508v.entrySet()) {
            String key = entry.getKey();
            try {
                m2712b(key, entry.getValue());
            } catch (Exception e) {
                C0530jM.m2338a("[Asset Store] An error occurred while saving asset " + key + ".", e, new Object[0]);
                if (commandSource != null) {
                    C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.save.error", new Object[]{key, Component.literal(e.getMessage()).withStyle(ChatFormatting.GRAY)}));
                }
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public static boolean m2710m(@Nullable String str) {
        return str != null && !str.isBlank() && str.length() <= 128 && !str.contains("..") && str.indexOf(47) < 0 && str.indexOf(92) < 0;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private Path m2711a(@NotNull String str) {
        if (!m2710m(str)) {
            C0530jM.logError("[Asset Registry] Rejected unsafe asset name '%s' for type '%s'.", str, this.f3506aU);
            return null;
        }
        Path pathNormalize = Paths.get(this.f3507aV, new String[0]).toAbsolutePath().normalize();
        Path pathNormalize2 = pathNormalize.resolve(str + ".json").normalize();
        if (!pathNormalize.equals(pathNormalize2.getParent())) {
            C0530jM.logError("[Asset Registry] Rejected asset name '%s' for type '%s': resolves outside '%s'.", str, this.f3506aU, this.f3507aV);
            return null;
        }
        return pathNormalize2;
    }

    /* JADX INFO: renamed from: b */
    private void m2712b(@NotNull String str, @NotNull T t) {
        Path pathM2711a = m2711a(str);
        if (pathM2711a == null) {
            return;
        }
        JsonElement jsonElement = (JsonElement) this.f3511j.encodeStart(JsonOps.INSTANCE, t).getOrThrow(str2 -> {
            C0530jM.logError("[Asset Registry] Failed to encode asset '%s' with codec (%s)", str, str2);
            return new RuntimeException(str2);
        });
        File file = pathM2711a.toFile();
        File parentFile = file.getParentFile();
        if (!file.exists() || file.delete()) {
            if (parentFile.exists() || parentFile.mkdir()) {
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    try {
                        f3504b.toJson(jsonElement, fileWriter);
                        fileWriter.close();
                    } catch (Throwable th) {
                        try {
                            fileWriter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    C0530jM.m2338a("[Asset Registry] Failed to save asset '%s' with codec.", e, str);
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void m2713j(@NotNull String str) {
        T t = this.f3508v.get(str);
        if (t == null) {
            C0530jM.logError("[Asset Registry] Cannot save asset '%s' for type '%s' — not found in registry.", str, this.f3506aU);
        } else {
            m2712b(str, t);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2714c(@NotNull String str, @NotNull T t) {
        this.f3509ae.remove(str);
        this.f3508v.put(str, t);
        m2712b(str, t);
    }

    /* JADX INFO: renamed from: bx */
    public void m2715bx() {
        this.f3509ae.forEach(this::m2716k);
    }

    /* JADX INFO: renamed from: k */
    private void m2716k(@NotNull String str) {
        Path pathM2711a = m2711a(str);
        if (pathM2711a == null) {
            return;
        }
        File file = pathM2711a.toFile();
        if (!file.delete()) {
            C0530jM.log("[Asset Registry] Failed to delete file '%s' during asset refresh. (Does the file exist?)", file.getName());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private String m2717b(@NotNull Path path) {
        String string = path.getFileName().toString();
        int iLastIndexOf = string.lastIndexOf(46);
        return iLastIndexOf != -1 ? string.substring(0, iLastIndexOf) : string;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public String m2718D() {
        return this.f3507aV;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public String m2719E() {
        return this.f3506aU;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Map<String, T> m2720d() {
        return Collections.unmodifiableMap(this.f3508v);
    }

    /* JADX INFO: renamed from: l */
    public void m2721l(@NotNull String str) {
        T tRemove = this.f3508v.remove(str);
        if (tRemove != null) {
            tRemove.mo2598bA();
        }
        this.f3509ae.add(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0571kA<T> m2722a() {
        return this.f3510a;
    }
}
