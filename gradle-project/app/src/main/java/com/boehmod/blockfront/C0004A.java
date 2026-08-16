package com.boehmod.blockfront;

import foundry.veil.Veil;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLib;

/* JADX INFO: renamed from: com.boehmod.blockfront.A */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/A.class */
public class C0004A implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: ah */
    private static final int f123ah = 20;

    /* JADX INFO: renamed from: ai */
    private static final int f124ai = 25;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ClassLoader[] f125a = m5a();

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final ObjectList<String> f126i = ObjectLists.unmodifiable(new ObjectArrayList(new String[]{"net.neoforged", "net.minecraft", "com.mojang", "com.boehmod", "com.google.gson", "com.google.common", "org.apache.maven", "software.bernie", "net.labymod.opus", "cpw.mods", "org.objectweb.asm", "it.unimi.dsi", "org.openjdk", "org.prismlauncher", "io.github.zekerzhayard.forgewrapper", "org.multimc", "org.spongepowered.asm", "com.llamalad7.mixinextras", "de.jcm.discordgamesdk", "com.intellij", "net.covers1624.devlogin", "com.modrinth", "foundry.veil", "gg.moonflower.molangcompiler", "io.github.ocelot.glslprocessor", "net.caffeinemc", "net.fabricmc.fabric", "org.sinytra.fabric"}));

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final ObjectList<a> f127j = ObjectLists.unmodifiable(new ObjectArrayList(new a[]{new a("net.minecraft", Minecraft.class.getClassLoader()), new a("com.boehmod", C0004A.class.getClassLoader()), new a("software.bernie", GeckoLib.class.getClassLoader()), new a("foundry.veil", Veil.class.getClassLoader())}));

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final ObjectList<String> f128k = ObjectLists.unmodifiable(new ObjectArrayList(new String[]{"net.minecraft"}));

    /* JADX INFO: renamed from: ab */
    private int f129ab = 0;

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ClassLoader[] m5a() {
        ClassLoader classLoader = C0004A.class.getClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (classLoader == systemClassLoader) {
            return new ClassLoader[]{classLoader};
        }
        return new ClassLoader[]{classLoader, systemClassLoader};
    }

    /* JADX INFO: renamed from: a */
    private static boolean m6a(@NotNull String str, @NotNull String str2) {
        return str.equals(str2) || (str.startsWith(str2) && str.charAt(str2.length()) == '.');
    }

    /* JADX INFO: renamed from: b */
    private static boolean m7b(@NotNull String str) {
        ObjectListIterator it = f126i.iterator();
        while (it.hasNext()) {
            if (m6a(str, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static ClassLoader m8a(@NotNull String str) {
        ObjectListIterator it = f127j.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (m6a(str, aVar.m15j())) {
                return aVar.m16a();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9a(@NotNull String str, @NotNull ClassLoader classLoader) {
        if (classLoader != ClassLoader.getSystemClassLoader()) {
            return false;
        }
        ObjectListIterator it = f128k.iterator();
        while (it.hasNext()) {
            if (m6a(str, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        int i = this.f129ab;
        this.f129ab = i - 1;
        if (i > 0) {
            return null;
        }
        this.f129ab = 20;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        loop0: for (ClassLoader classLoader : f125a) {
            for (Package r0 : classLoader.getDefinedPackages()) {
                if (objectArrayList.size() >= 25) {
                    break loop0;
                }
                String name = r0.getName();
                if (!name.isEmpty()) {
                    if (!m7b(name)) {
                        objectArrayList.add(name);
                    } else {
                        ClassLoader classLoaderM8a = m8a(name);
                        if (classLoaderM8a != null && classLoaderM8a != classLoader && !m9a(name, classLoader)) {
                            objectArrayList.add(name + " @ " + classLoader.getClass().getName());
                        }
                    }
                }
            }
        }
        if (objectArrayList.isEmpty()) {
            return null;
        }
        return String.join(", ", (Iterable<? extends CharSequence>) objectArrayList);
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
        return 5;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.b mo13a() {
        return C0994s.b.SILENT;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.A$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/A$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: t */
        @NotNull
        private final String f130t;

        /* JADX INFO: renamed from: a */
        @Nullable
        private final ClassLoader f131a;

        private a(@NotNull String str, @Nullable ClassLoader classLoader) {
            this.f130t = str;
            this.f131a = classLoader;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "prefix;owner", "FIELD:Lcom/boehmod/blockfront/A$a;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A$a;->a:Ljava/lang/ClassLoader;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "prefix;owner", "FIELD:Lcom/boehmod/blockfront/A$a;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A$a;->a:Ljava/lang/ClassLoader;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "prefix;owner", "FIELD:Lcom/boehmod/blockfront/A$a;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A$a;->a:Ljava/lang/ClassLoader;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: j */
        public String m15j() {
            return this.f130t;
        }

        @Nullable
        /* JADX INFO: renamed from: a */
        public ClassLoader m16a() {
            return this.f131a;
        }
    }
}
