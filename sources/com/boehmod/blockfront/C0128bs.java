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

/* JADX INFO: renamed from: com.boehmod.blockfront.bs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bs.class */
public final class C0128bs {

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final List<String> f854o = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Object2ObjectMap<String, ResourceLocation> f855a = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: y */
    @NotNull
    private static final ResourceLocation f856y = C0532jO.m2378d("textures/gui/loading.png");

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m463a(@NotNull Minecraft minecraft, @NotNull String str) {
        if (f855a.containsKey(str)) {
            return (ResourceLocation) f855a.get(str);
        }
        if (!f854o.contains(str)) {
            f854o.add(str);
            try {
                m464a(minecraft, str);
            } catch (IOException e) {
                C0530jM.m2338a("Error while loading image.", e, new Object[0]);
            }
        }
        return f856y;
    }

    /* JADX INFO: renamed from: a */
    public static void m464a(@NotNull Minecraft minecraft, @NotNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                f855a.put(str, minecraft.getTextureManager().register("url" + str.hashCode(), new DynamicTexture(NativeImage.read(inputStream))));
                if (inputStream != null) {
                    inputStream.close();
                }
                httpURLConnection.disconnect();
                f854o.remove(str);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }
}
