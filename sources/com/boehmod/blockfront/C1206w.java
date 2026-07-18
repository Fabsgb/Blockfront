package com.boehmod.blockfront;

import com.boehmod.blockfront.C0940r;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.w */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/w.class */
public class C1206w implements InterfaceC1305z<C0940r> {

    /* JADX INFO: renamed from: y */
    private static final int f6339y = 20;

    /* JADX INFO: renamed from: a */
    private static final ClassLoader[] f6340a = m6712a();

    /* JADX INFO: renamed from: c */
    private static final ObjectList<String> f6341c = ObjectLists.unmodifiable(new ObjectArrayList(new String[]{"net.neoforged", "net.minecraft", "com.mojang", "com.boehmod", "com.google.gson", "com.google.common", "org.apache.maven", "software.bernie", "net.labymod.opus", "cpw.mods", "org.objectweb.asm", "it.unimi.dsi", "org.openjdk", "org.prismlauncher", "io.github.zekerzhayard.forgewrapper", "org.multimc", "org.spongepowered.asm", "com.llamalad7.mixinextras", "de.jcm.discordgamesdk", "com.intellij", "net.covers1624.devlogin", "com.modrinth", "foundry.veil", "gg.moonflower.molangcompiler", "io.github.ocelot.glslprocessor"}));

    /* JADX INFO: renamed from: z */
    private int f6342z = 0;

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ClassLoader[] m6712a() {
        ClassLoader classLoader = C1206w.class.getClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (classLoader == systemClassLoader) {
            return new ClassLoader[]{classLoader};
        }
        return new ClassLoader[]{classLoader, systemClassLoader};
    }

    /* JADX INFO: renamed from: a */
    private static boolean m6713a(@NotNull String str) {
        ObjectListIterator it = f6341c.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!str.equals(str2)) {
                if (str.startsWith(str2) && str.charAt(str2.length()) == '.') {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1305z
    /* JADX INFO: renamed from: a */
    public boolean mo6058a(@NotNull Minecraft minecraft, @NotNull C0940r c0940r) {
        int i = this.f6342z;
        this.f6342z = i - 1;
        if (i > 0) {
            return false;
        }
        this.f6342z = 20;
        for (ClassLoader classLoader : f6340a) {
            for (Package r0 : classLoader.getDefinedPackages()) {
                if (!m6713a(r0.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1305z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0940r.a mo6057a() {
        return C0940r.a.RUNTIME;
    }
}
