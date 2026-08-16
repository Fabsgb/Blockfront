package com.boehmod.blockfront;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import foundry.veil.Veil;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.stream.Stream;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;

/* JADX INFO: renamed from: com.boehmod.blockfront.y */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/y.class */
public final class C1313y implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ObjectSet<String> f9030a = ObjectSets.unmodifiable(new ObjectOpenHashSet(new String[]{"minecraft", "neoforge", "bf", GeckoLibConstants.MODID, Veil.MODID}));

    /* JADX INFO: renamed from: ac */
    private static final int f9031ac = 3;

    /* JADX INFO: renamed from: f */
    @Nullable
    private ObjectList<String> f9032f;

    /* JADX INFO: renamed from: g */
    @Nullable
    private ObjectList<String> f9033g;

    /* JADX INFO: renamed from: H */
    private boolean f9034H;

    /* JADX INFO: renamed from: h */
    @Nullable
    private ObjectList<a> f9035h;

    /* JADX INFO: renamed from: ad */
    private int f9036ad;

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        if (!this.f9034H) {
            this.f9034H = true;
            m8235j(minecraft);
        }
        if (this.f9032f == null || this.f9033g == null) {
            return null;
        }
        if (this.f9032f.isEmpty() && this.f9033g.isEmpty()) {
            return null;
        }
        if (this.f9035h == null) {
            if (this.f9036ad >= 3) {
                return null;
            }
            this.f9036ad++;
            this.f9035h = m8238b();
            if (this.f9035h == null) {
                return null;
            }
        }
        String strM8236h = m8236h();
        if (strM8236h == null) {
            return null;
        }
        return strM8236h;
    }

    /* JADX INFO: renamed from: j */
    private void m8235j(@NotNull Minecraft minecraft) {
        ModList modList = ModList.get();
        IModFileInfo modFileById = modList.getModFileById("bf");
        Path pathNormalize = modFileById != null ? modFileById.getFile().getFilePath().toAbsolutePath().normalize() : null;
        Path pathNormalize2 = minecraft.gameDirectory.toPath().resolve(FMLPaths.MODSDIR.relative()).toAbsolutePath().normalize();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        try {
            Stream<Path> list = Files.list(pathNormalize2);
            try {
                list.filter(path -> {
                    return path.getFileName().toString().endsWith(".jar");
                }).map(path2 -> {
                    return path2.toAbsolutePath().normalize();
                }).filter(path3 -> {
                    return !path3.equals(pathNormalize);
                }).sorted().forEach(path4 -> {
                    objectArrayList.add(String.valueOf(path4.getFileName()) + "#" + m8239a(path4));
                });
                if (list != null) {
                    list.close();
                }
            } catch (Throwable th) {
                if (list != null) {
                    try {
                        list.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (IModInfo iModInfo : modList.getMods()) {
            String modId = iModInfo.getModId();
            if (!f9030a.contains(modId)) {
                objectArrayList2.add(modId + "@" + String.valueOf(iModInfo.getVersion()));
            }
        }
        this.f9032f = objectArrayList;
        this.f9033g = objectArrayList2;
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    private String m8236h() {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectListIterator it = this.f9032f.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            int iLastIndexOf = str.lastIndexOf(35);
            a aVarM8237a = iLastIndexOf > 0 ? m8237a(str.substring(iLastIndexOf + 1)) : null;
            if (aVarM8237a != null) {
                objectOpenHashSet.addAll(aVarM8237a.m8245b());
            } else {
                objectArrayList.add(str);
            }
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        ObjectListIterator it2 = this.f9033g.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            int iLastIndexOf2 = str2.lastIndexOf(64);
            if (!objectOpenHashSet.contains(iLastIndexOf2 > 0 ? str2.substring(0, iLastIndexOf2) : str2)) {
                objectArrayList2.add(str2);
            }
        }
        if (objectArrayList.isEmpty() && objectArrayList2.isEmpty()) {
            return null;
        }
        return "jars: " + String.join(", ", (Iterable<? extends CharSequence>) objectArrayList) + "; mods: " + String.join(", ", (Iterable<? extends CharSequence>) objectArrayList2);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private a m8237a(@NotNull String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        ObjectListIterator it = this.f9035h.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.m8244a().contains(lowerCase)) {
                return aVar;
            }
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    private static ObjectList<a> m8238b() {
        try {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (c0623lM2852b == null) {
                return null;
            }
            JsonArray asJsonArray = JsonParser.parseString(C1269xI.m7155c(c0623lM2852b.m2870a().m2381a("ac_mod_allowlist"))).getAsJsonObject().getAsJsonArray("entries");
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator it = asJsonArray.iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = ((JsonElement) it.next()).getAsJsonObject();
                ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
                Iterator it2 = asJsonObject.getAsJsonArray("sha512").iterator();
                while (it2.hasNext()) {
                    objectOpenHashSet.add(((JsonElement) it2.next()).getAsString().toLowerCase(Locale.ROOT));
                }
                ObjectOpenHashSet objectOpenHashSet2 = new ObjectOpenHashSet();
                Iterator it3 = asJsonObject.getAsJsonArray("modIds").iterator();
                while (it3.hasNext()) {
                    objectOpenHashSet2.add(((JsonElement) it3.next()).getAsString());
                }
                objectArrayList.add(new a(objectOpenHashSet, objectOpenHashSet2));
            }
            C0530jM.log("[AC] Fetched mod allowlist with %d entries.", Integer.valueOf(objectArrayList.size()));
            return objectArrayList;
        } catch (Exception e) {
            C0530jM.log("[AC] Failed to fetch the mod allowlist. (%s)", e.getMessage());
            return null;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m8239a(@NotNull Path path) {
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                byte[] bArr = new byte[InterfaceC1274xN.f6856vY];
                while (true) {
                    int i = inputStreamNewInputStream.read(bArr);
                    if (i < 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                }
                String hex = HexFormat.of().formatHex(messageDigest.digest());
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
                return hex;
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
        } catch (IOException | NoSuchAlgorithmException e) {
            return "unreadable";
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.ALL;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 11;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.y$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/y$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: b */
        @NotNull
        private final ObjectSet<String> f9037b;

        /* JADX INFO: renamed from: c */
        @NotNull
        private final ObjectSet<String> f9038c;

        private a(@NotNull ObjectSet<String> objectSet, @NotNull ObjectSet<String> objectSet2) {
            this.f9037b = objectSet;
            this.f9038c = objectSet2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "hashes;modIds", "FIELD:Lcom/boehmod/blockfront/y$a;->b:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/blockfront/y$a;->c:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "hashes;modIds", "FIELD:Lcom/boehmod/blockfront/y$a;->b:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/blockfront/y$a;->c:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "hashes;modIds", "FIELD:Lcom/boehmod/blockfront/y$a;->b:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/blockfront/y$a;->c:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ObjectSet<String> m8244a() {
            return this.f9037b;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public ObjectSet<String> m8245b() {
            return this.f9038c;
        }
    }
}
