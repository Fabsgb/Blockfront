package com.boehmod.bflib.cloud.common.p000ac;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.Locale;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/ac/RuntimeSources.class */
public final class RuntimeSources {

    @NotNull
    public static final String THREAD_ATTACH_LISTENER = "Attach Listener";

    @NotNull
    private static final ObjectList<Pattern> CODE_NAMESPACES = ObjectLists.unmodifiable(new ObjectArrayList(new Pattern[]{namespace("java"), namespace("javax"), namespace("jdk"), namespace("sun"), namespace("com.sun"), namespace("org.ietf"), namespace("org.w3c"), namespace("org.xml"), namespace("org.graalvm"), namespace("com.oracle"), namespace("com.ibm"), namespace("openj9"), namespace("com.azul"), namespace("net.minecraft"), namespace("com.mojang"), namespace("net.neoforged"), namespace("cpw.mods"), namespace("org.spongepowered"), namespace("com.llamalad7.mixinextras"), namespace("org.objectweb.asm"), namespace("net.minecrell"), namespace("org.jline"), namespace("com.jcraft"), namespace("lzma"), namespace("org.cservenak"), namespace("net.caffeinemc"), namespace("net.fabricmc.fabric"), namespace("org.sinytra.fabric"), namespace("com.boehmod"), namespace("software.bernie"), namespace("foundry.veil"), namespace("gg.moonflower"), namespace("io.github.ocelot"), namespace("imgui"), namespace("de.jcm.discordgamesdk"), namespace("net.labymod.opus"), namespace("it.unimi.dsi"), namespace("com.google"), namespace("org.apache"), namespace("org.slf4j"), namespace("io.netty"), namespace("org.lwjgl"), namespace("org.joml"), namespace("oshi"), namespace("com.electronwill"), namespace("joptsimple"), namespace("org.prismlauncher"), namespace("io.github.zekerzhayard"), namespace("org.multimc"), namespace("com.modrinth"), namespace("oolloo.jlw")}));

    @NotNull
    private static final ObjectList<Pattern> NATIVE_NAMES = ObjectLists.unmodifiable(new ObjectArrayList(new Pattern[]{namePrefix("jna"), namePrefix("lwjgl"), namePrefix("liblwjgl"), namePrefix("glfw"), namePrefix("libglfw"), namePrefix("openal"), namePrefix("libopenal"), namePrefix("jemalloc"), namePrefix("libjemalloc"), namePrefix("freetype"), namePrefix("libfreetype"), namePrefix("netty"), namePrefix("libnetty"), namePrefix("discord_game_sdk"), namePrefix("libjlw"), namePrefix("corpse_physics"), namePrefix("sqlite-"), namePrefix("webp"), Pattern.compile("ffi[a-z0-9]{6}")}));

    @NotNull
    private static final ObjectList<Pattern> NATIVE_PATHS = ObjectLists.unmodifiable(new ObjectArrayList(new Pattern[]{Pattern.compile("\\.mount_[^/]+/.+")}));

    private RuntimeSources() {
    }

    @NotNull
    private static Pattern namespace(@NotNull String prefix) {
        return Pattern.compile(Pattern.quote(prefix) + "(\\..+)?");
    }

    @NotNull
    private static Pattern namePrefix(@NotNull String prefix) {
        return Pattern.compile(Pattern.quote(prefix) + ".*");
    }

    public static boolean isKnownClassName(@NotNull String className) {
        ObjectListIterator it = CODE_NAMESPACES.iterator();
        while (it.hasNext()) {
            Pattern pattern = (Pattern) it.next();
            if (pattern.matcher(className).matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKnownNativeName(@NotNull String fileName) {
        String lowered = fileName.toLowerCase(Locale.ROOT);
        ObjectListIterator it = NATIVE_NAMES.iterator();
        while (it.hasNext()) {
            Pattern pattern = (Pattern) it.next();
            if (pattern.matcher(lowered).matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKnownNativePath(@NotNull String relativePath) {
        String lowered = relativePath.toLowerCase(Locale.ROOT).replace('\\', '/');
        ObjectListIterator it = NATIVE_PATHS.iterator();
        while (it.hasNext()) {
            Pattern pattern = (Pattern) it.next();
            if (pattern.matcher(lowered).matches()) {
                return true;
            }
        }
        return false;
    }
}
