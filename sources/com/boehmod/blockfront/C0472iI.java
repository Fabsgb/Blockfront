package com.boehmod.blockfront;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.platform.NativeImage;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iI.class */
public class C0472iI {

    /* JADX INFO: renamed from: av */
    private static final String f2909av = "https://sessionserver.mojang.com/session/minecraft/profile/%s";

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ExecutorService f2910a = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Cache<UUID, CompletableFuture<ResourceLocation>> f2911a = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).removalListener(removalNotification -> {
        CompletableFuture completableFuture = (CompletableFuture) removalNotification.getValue();
        UUID uuid = (UUID) removalNotification.getKey();
        if (completableFuture == null || uuid == null || !completableFuture.isDone()) {
            return;
        }
        try {
            ResourceLocation resourceLocation = (ResourceLocation) completableFuture.get();
            if (resourceLocation == null || resourceLocation.equals(DefaultPlayerSkin.get(uuid).texture())) {
                return;
            }
            Minecraft minecraft = Minecraft.getInstance();
            minecraft.execute(() -> {
                minecraft.getTextureManager().release(resourceLocation);
                C0562jt.log("Released skin texture for: " + String.valueOf(uuid), new Object[0]);
            });
        } catch (Exception e) {
            C0562jt.log("Failed to resolve texture for: " + String.valueOf(uuid) + " due to: " + e.getMessage(), new Object[0]);
        }
    }).build();

    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation m2137a(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        try {
            return (ResourceLocation) ((CompletableFuture) this.f2911a.get(uuid, () -> {
                return CompletableFuture.supplyAsync(() -> {
                    return m2138b(minecraft, uuid);
                }, this.f2910a);
            })).getNow(DefaultPlayerSkin.get(uuid).texture());
        } catch (Exception e) {
            C0562jt.m2516a("Failed to fetch skin for player '" + String.valueOf(uuid) + "' due to: ", e, new Object[0]);
            return DefaultPlayerSkin.get(uuid).texture();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private ResourceLocation m2138b(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        C0562jt.log("Fetching skin for player '%s'...", uuid);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(String.format(f2909av, uuid.toString().replace("-", ""))).toURL().openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    BufferedImage bufferedImage = ImageIO.read(URI.create(((JsonObject) new Gson().fromJson(new String(Base64.getDecoder().decode(((JsonObject) new Gson().fromJson(sb.toString(), JsonObject.class)).getAsJsonArray("properties").get(0).getAsJsonObject().get("value").getAsString())), JsonObject.class)).getAsJsonObject("textures").getAsJsonObject("SKIN").get("url").getAsString()).toURL());
                    NativeImage nativeImage = new NativeImage(bufferedImage.getWidth(), bufferedImage.getHeight(), true);
                    for (int i = 0; i < bufferedImage.getWidth(); i++) {
                        for (int i2 = 0; i2 < bufferedImage.getHeight(); i2++) {
                            int rgb = bufferedImage.getRGB(i, i2);
                            nativeImage.setPixelRGBA(i, i2, (((rgb >> 24) & 255) << 24) | ((rgb & 255) << 16) | (((rgb >> 8) & 255) << 8) | ((rgb >> 16) & 255));
                        }
                    }
                    CompletableFuture completableFuture = new CompletableFuture();
                    minecraft.submit(() -> {
                        try {
                            completableFuture.complete(minecraft.getTextureManager().register("skins/" + String.valueOf(uuid), new DynamicTexture(nativeImage)));
                            C0562jt.log("Successfully fetched and registered skin for player '" + String.valueOf(uuid) + "'!", new Object[0]);
                        } catch (Exception e) {
                            completableFuture.completeExceptionally(e);
                        }
                    });
                    ResourceLocation resourceLocation = (ResourceLocation) completableFuture.get();
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return resourceLocation;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection.disconnect();
                throw th3;
            }
        } catch (Exception e) {
            C0562jt.logError("Failed to fetch or register skin for player '" + String.valueOf(uuid) + "'. Retrying.", new Object[0]);
            return DefaultPlayerSkin.get(uuid).texture();
        }
    }

    public void shutdown() {
        this.f2910a.shutdown();
    }
}
