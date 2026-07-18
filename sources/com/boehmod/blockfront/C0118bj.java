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

/* JADX INFO: renamed from: com.boehmod.blockfront.bj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bj.class */
public final class C0118bj {

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final List<String> f719m = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Object2ObjectMap<String, ResourceLocation> f720a = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: y */
    @NotNull
    private static final ResourceLocation f721y = C0564jv.m2555d("textures/gui/loading.png");

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m363a(@NotNull Minecraft minecraft, @NotNull String str) {
        if (f720a.containsKey(str)) {
            return (ResourceLocation) f720a.get(str);
        }
        if (!f719m.contains(str)) {
            f719m.add(str);
            try {
                m364a(minecraft, str);
            } catch (IOException e) {
                C0562jt.m2516a("Error while loading image.", e, new Object[0]);
            }
        }
        return f721y;
    }

    /* JADX INFO: renamed from: a */
    public static void m364a(@NotNull Minecraft minecraft, @NotNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                f720a.put(str, minecraft.getTextureManager().register("url" + str.hashCode(), new DynamicTexture(NativeImage.read(inputStream))));
                if (inputStream != null) {
                    inputStream.close();
                }
                f719m.remove(str);
            } finally {
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
