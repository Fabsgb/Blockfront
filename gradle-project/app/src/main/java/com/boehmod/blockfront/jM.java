package com.boehmod.blockfront;

import com.boehmod.blockfront.jU;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jM.class */
public class jM<T extends jU> {

    @NotNull
    private static final Gson b = new GsonBuilder().setPrettyPrinting().create();

    @NotNull
    private final String aL;

    @NotNull
    private final String aM;

    @NotNull
    private final Map<String, T> v = new ConcurrentHashMap();

    @NotNull
    private final List<String> X = new ObjectArrayList();

    @NotNull
    private final AbstractC0275ke<T> a;

    @NotNull
    private final Codec<T> j;

    public jM(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull jO jOVar, @NotNull String str, @NotNull AbstractC0275ke<T> abstractC0275ke) {
        this.aL = str;
        this.a = abstractC0275ke;
        this.j = (Codec<T>) abstractC0275ke.a(abstractC0264ju);
        this.aM = jOVar.y() + "/" + str;
        bl();
        bk();
    }

    public void bk() {
        Iterator<T> it = this.v.values().iterator();
        while (it.hasNext()) {
            it.next().bp();
        }
        this.v.clear();
        try {
            Files.walk(Paths.get(this.aM, new String[0]), new FileVisitOption[0]).filter(path -> {
                return Files.isRegularFile(path, new LinkOption[0]);
            }).filter(path2 -> {
                return path2.toString().endsWith(".json");
            }).forEach(this::a);
            C0263jt.log("[Asset Registry] Found %d assets for asset type '%s'", Integer.valueOf(this.v.size()), this.aL);
        } catch (IOException e) {
            C0263jt.logError("Failed to load all assets.", e);
        }
    }

    public void a(@NotNull CommandSource commandSource) {
        this.v.values().forEach(jUVar -> {
            jUVar.c(commandSource);
        });
    }

    private void a(@NotNull Path path) {
        try {
            this.v.put(m520a(path), (T) m519a(path));
        } catch (Exception e) {
            C0263jt.a("[Asset Registry] Failed to load asset '%s'.", e, path.getFileName());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private T m519a(@NotNull Path path) throws IOException {
        FileReader fileReader = new FileReader(path.toFile());
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                JsonElement jsonElement = (JsonElement) b.fromJson(bufferedReader, JsonElement.class);
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    throw new IOException("Asset file is empty or contains no JSON.");
                }
                T t = (T) this.j.parse(JsonOps.INSTANCE, jsonElement).getOrThrow(str -> {
                    C0263jt.logError("[Asset Registry] Failed to parse asset '%s' with codec (%s)", path.getFileName(), str);
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

    public void a(@NotNull String str, @NotNull T t) {
        this.X.remove(str);
        if (this.v.containsKey(str)) {
            C0263jt.logError("[Asset Registry] Asset '%s' for asset type '%s' already exists and has been replaced!", str, this.aL);
        }
        C0263jt.log("[Asset Registry] Registered new asset '%s' for asset type '%s'", str, this.aL);
        this.v.put(str, t);
    }

    @Nullable
    public T a(@NotNull String str) {
        return this.v.get(str);
    }

    private void bl() {
        Path path = Paths.get(this.aM, new String[0]);
        try {
            Files.createDirectories(path, new FileAttribute[0]);
            C0263jt.log("[Asset Registry] Created new directory '%s' for asset type '%s'", path.toAbsolutePath(), this.aL);
        } catch (IOException e) {
            C0263jt.a("[Asset Registry] Failed to create directory '%s' for asset type '%s'", e, path.toAbsolutePath(), this.aL);
        }
    }

    public void b(@Nullable CommandSource commandSource) {
        for (Map.Entry<String, T> entry : this.v.entrySet()) {
            String key = entry.getKey();
            try {
                b(key, entry.getValue());
            } catch (Exception e) {
                C0263jt.a("[Asset Store] An error occurred while saving asset " + key + ".", e, new Object[0]);
                if (commandSource != null) {
                    lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.save.error", new Object[]{key, Component.literal(e.getMessage()).withStyle(ChatFormatting.GRAY)}));
                }
                throw e;
            }
        }
    }

    private void b(@NotNull String str, @NotNull T t) {
        JsonElement jsonElement = (JsonElement) this.j.encodeStart(JsonOps.INSTANCE, t).getOrThrow(str2 -> {
            C0263jt.logError("[Asset Registry] Failed to encode asset '%s' with codec (%s)", str, str2);
            return new RuntimeException(str2);
        });
        File file = Paths.get(this.aM, str + ".json").toFile();
        File parentFile = file.getParentFile();
        if (!file.exists() || file.delete()) {
            if (parentFile.exists() || parentFile.mkdir()) {
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    try {
                        b.toJson(jsonElement, fileWriter);
                        fileWriter.close();
                    } finally {
                    }
                } catch (IOException e) {
                    C0263jt.a("[Asset Registry] Failed to save asset '%s' with codec.", e, str);
                }
            }
        }
    }

    public void j(@NotNull String str) {
        T t = this.v.get(str);
        if (t == null) {
            C0263jt.logError("[Asset Registry] Cannot save asset '%s' for type '%s' — not found in registry.", str, this.aL);
        } else {
            b(str, t);
        }
    }

    public void c(@NotNull String str, @NotNull T t) {
        this.X.remove(str);
        this.v.put(str, t);
        b(str, t);
    }

    public void bm() {
        this.X.forEach(this::k);
    }

    private void k(@NotNull String str) {
        File file = Paths.get(this.aM, str + ".json").toFile();
        if (!file.delete()) {
            C0263jt.log("[Asset Registry] Failed to delete file '%s' during asset refresh. (Does the file exist?)", file.getName());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m520a(@NotNull Path path) {
        String string = path.getFileName().toString();
        int iLastIndexOf = string.lastIndexOf(46);
        return iLastIndexOf != -1 ? string.substring(0, iLastIndexOf) : string;
    }

    @NotNull
    public String w() {
        return this.aM;
    }

    @NotNull
    public String x() {
        return this.aL;
    }

    @NotNull
    public Map<String, T> d() {
        return Collections.unmodifiableMap(this.v);
    }

    public void l(@NotNull String str) {
        T tRemove = this.v.remove(str);
        if (tRemove != null) {
            tRemove.bp();
        }
        this.X.add(str);
    }

    @NotNull
    public AbstractC0275ke<T> a() {
        return this.a;
    }
}
