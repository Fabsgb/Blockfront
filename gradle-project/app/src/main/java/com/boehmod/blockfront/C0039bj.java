package com.boehmod.blockfront;

import com.mojang.blaze3d.platform.NativeImage;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bj.class */
public final class C0039bj {

    @NotNull
    public static final List<String> m = new ObjectArrayList();

    @NotNull
    public static final Object2ObjectMap<String, ResourceLocation> a = new Object2ObjectOpenHashMap();

    @NotNull
    private static final ResourceLocation y = C0265jv.d("textures/gui/loading.png");

    @NotNull
    public static ResourceLocation a(@NotNull Minecraft minecraft, @NotNull String str) {
        if (a.containsKey(str)) {
            return (ResourceLocation) a.get(str);
        }
        if (!m.contains(str)) {
            m.add(str);
            try {
                m228a(minecraft, str);
            } catch (IOException e) {
                C0263jt.a("Error while loading image.", e, new Object[0]);
            }
        }
        return y;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m228a(@NotNull Minecraft minecraft, @NotNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                a.put(str, minecraft.getTextureManager().register("url" + str.hashCode(), new DynamicTexture(NativeImage.read(inputStream))));
                if (inputStream != null) {
                    inputStream.close();
                }
                m.remove(str);
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
