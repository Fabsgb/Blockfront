package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0537jU;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.jM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jM.class */
public class C0529jM<T extends InterfaceC0537jU> {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final Gson f3127b = new GsonBuilder().setPrettyPrinting().create();

    /* JADX INFO: renamed from: aL */
    @NotNull
    private final String f3128aL;

    /* JADX INFO: renamed from: aM */
    @NotNull
    private final String f3129aM;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final Map<String, T> f3130v = new ConcurrentHashMap();

    /* JADX INFO: renamed from: X */
    @NotNull
    private final List<String> f3131X = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0600ke<T> f3132a;

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Codec<T> f3133j;

    public C0529jM(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0531jO c0531jO, @NotNull String str, @NotNull AbstractC0600ke<T> abstractC0600ke) {
        this.f3128aL = str;
        this.f3132a = abstractC0600ke;
        this.f3133j = (Codec<T>) abstractC0600ke.mo2641a(abstractC0563ju);
        this.f3129aM = c0531jO.m2385y() + "/" + str;
        m2348bl();
        m2342bk();
    }

    /* JADX INFO: renamed from: bk */
    public void m2342bk() {
        Iterator<T> it = this.f3130v.values().iterator();
        while (it.hasNext()) {
            it.next().mo2431bp();
        }
        this.f3130v.clear();
        try {
            Files.walk(Paths.get(this.f3129aM, new String[0]), new FileVisitOption[0]).filter(path -> {
                return Files.isRegularFile(path, new LinkOption[0]);
            }).filter(path2 -> {
                return path2.toString().endsWith(".json");
            }).forEach(this::m2344a);
            C0562jt.log("[Asset Registry] Found %d assets for asset type '%s'", Integer.valueOf(this.f3130v.size()), this.f3128aL);
        } catch (IOException e) {
            C0562jt.logError("Failed to load all assets.", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2343a(@NotNull CommandSource commandSource) {
        this.f3130v.values().forEach(interfaceC0537jU -> {
            interfaceC0537jU.mo2430c(commandSource);
        });
    }

    /* JADX INFO: renamed from: a */
    private void m2344a(@NotNull Path path) {
        try {
            this.f3130v.put(m2355a(path), (T) m2345a(path));
        } catch (Exception e) {
            C0562jt.m2516a("[Asset Registry] Failed to load asset '%s'.", e, path.getFileName());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private T m2345a(@NotNull Path path) throws IOException {
        FileReader fileReader = new FileReader(path.toFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                JsonElement jsonElement = (JsonElement) f3127b.fromJson(bufferedReader, JsonElement.class);
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    throw new IOException("Asset file is empty or contains no JSON.");
                }
                T t = (T) this.f3133j.parse(JsonOps.INSTANCE, jsonElement).getOrThrow(str -> {
                    C0562jt.logError("[Asset Registry] Failed to parse asset '%s' with codec (%s)", path.getFileName(), str);
                    return new RuntimeException(str);
                });
                if (t == null) {
                    throw new IOException("Asset codec produced a null result.");
                }
                bufferedReader.close();
                fileReader.close();
                return t;
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2346a(@NotNull String str, @NotNull T t) {
        this.f3131X.remove(str);
        if (this.f3130v.containsKey(str)) {
            C0562jt.logError("[Asset Registry] Asset '%s' for asset type '%s' already exists and has been replaced!", str, this.f3128aL);
        }
        C0562jt.log("[Asset Registry] Registered new asset '%s' for asset type '%s'", str, this.f3128aL);
        this.f3130v.put(str, t);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public T m2347a(@NotNull String str) {
        return this.f3130v.get(str);
    }

    /* JADX INFO: renamed from: bl */
    private void m2348bl() {
        Path path = Paths.get(this.f3129aM, new String[0]);
        try {
            Files.createDirectories(path, new FileAttribute[0]);
            C0562jt.log("[Asset Registry] Created new directory '%s' for asset type '%s'", path.toAbsolutePath(), this.f3128aL);
        } catch (IOException e) {
            C0562jt.m2516a("[Asset Registry] Failed to create directory '%s' for asset type '%s'", e, path.toAbsolutePath(), this.f3128aL);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2349b(@Nullable CommandSource commandSource) {
        for (Map.Entry<String, T> entry : this.f3130v.entrySet()) {
            String key = entry.getKey();
            try {
                m2350b(key, entry.getValue());
            } catch (Exception e) {
                C0562jt.m2516a("[Asset Store] An error occurred while saving asset " + key + ".", e, new Object[0]);
                if (commandSource != null) {
                    C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.save.error", new Object[]{key, Component.literal(e.getMessage()).withStyle(ChatFormatting.GRAY)}));
                }
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2350b(@NotNull String str, @NotNull T t) {
        JsonElement jsonElement = (JsonElement) this.f3133j.encodeStart(JsonOps.INSTANCE, t).getOrThrow(str2 -> {
            C0562jt.logError("[Asset Registry] Failed to encode asset '%s' with codec (%s)", str, str2);
            return new RuntimeException(str2);
        });
        File file = Paths.get(this.f3129aM, str + ".json").toFile();
        File parentFile = file.getParentFile();
        if (!file.exists() || file.delete()) {
            if (parentFile.exists() || parentFile.mkdir()) {
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    try {
                        f3127b.toJson(jsonElement, fileWriter);
                        fileWriter.close();
                    } finally {
                    }
                } catch (IOException e) {
                    C0562jt.m2516a("[Asset Registry] Failed to save asset '%s' with codec.", e, str);
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public void m2351j(@NotNull String str) {
        T t = this.f3130v.get(str);
        if (t == null) {
            C0562jt.logError("[Asset Registry] Cannot save asset '%s' for type '%s' — not found in registry.", str, this.f3128aL);
        } else {
            m2350b(str, t);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2352c(@NotNull String str, @NotNull T t) {
        this.f3131X.remove(str);
        this.f3130v.put(str, t);
        m2350b(str, t);
    }

    /* JADX INFO: renamed from: bm */
    public void m2353bm() {
        this.f3131X.forEach(this::m2354k);
    }

    /* JADX INFO: renamed from: k */
    private void m2354k(@NotNull String str) {
        File file = Paths.get(this.f3129aM, str + ".json").toFile();
        if (!file.delete()) {
            C0562jt.log("[Asset Registry] Failed to delete file '%s' during asset refresh. (Does the file exist?)", file.getName());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private String m2355a(@NotNull Path path) {
        String string = path.getFileName().toString();
        int iLastIndexOf = string.lastIndexOf(46);
        return iLastIndexOf != -1 ? string.substring(0, iLastIndexOf) : string;
    }

    @NotNull
    /* JADX INFO: renamed from: w */
    public String m2356w() {
        return this.f3129aM;
    }

    @NotNull
    /* JADX INFO: renamed from: x */
    public String m2357x() {
        return this.f3128aL;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Map<String, T> m2358d() {
        return Collections.unmodifiableMap(this.f3130v);
    }

    /* JADX INFO: renamed from: l */
    public void m2359l(@NotNull String str) {
        T tRemove = this.f3130v.remove(str);
        if (tRemove != null) {
            tRemove.mo2431bp();
        }
        this.f3131X.add(str);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0600ke<T> m2360a() {
        return this.f3132a;
    }
}
