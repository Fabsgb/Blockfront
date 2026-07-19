package com.boehmod.blockfront;

import com.boehmod.blockfront.C0459r;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/w.class */
public class C0594w implements InterfaceC0641z<C0459r> {
    private static final int y = 20;
    private static final ClassLoader[] a = a();
    private static final ObjectList<String> c = ObjectLists.unmodifiable(new ObjectArrayList(new String[]{"net.neoforged", "net.minecraft", "com.mojang", "com.boehmod", "com.google.gson", "com.google.common", "org.apache.maven", "software.bernie", "net.labymod.opus", "cpw.mods", "org.objectweb.asm", "it.unimi.dsi", "org.openjdk", "org.prismlauncher", "io.github.zekerzhayard.forgewrapper", "org.multimc", "org.spongepowered.asm", "com.llamalad7.mixinextras", "de.jcm.discordgamesdk", "com.intellij", "net.covers1624.devlogin", "com.modrinth", "foundry.veil", "gg.moonflower.molangcompiler", "io.github.ocelot.glslprocessor"}));
    private int z = 0;

    @NotNull
    private static ClassLoader[] a() {
        ClassLoader classLoader = C0594w.class.getClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (classLoader == systemClassLoader) {
            return new ClassLoader[]{classLoader};
        }
        return new ClassLoader[]{classLoader, systemClassLoader};
    }

    private static boolean a(@NotNull String str) {
        ObjectListIterator it = c.iterator();
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

    @Override // com.boehmod.blockfront.InterfaceC0641z
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0459r c0459r) {
        int i = this.z;
        this.z = i - 1;
        if (i > 0) {
            return false;
        }
        this.z = 20;
        for (ClassLoader classLoader : a) {
            for (Package r0 : classLoader.getDefinedPackages()) {
                if (!a(r0.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0641z
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0459r.a mo1294a() {
        return C0459r.a.RUNTIME;
    }
}
