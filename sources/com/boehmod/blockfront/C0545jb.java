package com.boehmod.blockfront;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.platform.NativeImage;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.jb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jb.class */
public class C0545jb {

    /* JADX INFO: renamed from: aB */
    private static final String f3257aB = "https://sessionserver.mojang.com/session/minecraft/profile/%s";

    /* JADX INFO: renamed from: lq */
    private static final int f3258lq = 15000;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ExecutorService f3259a = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Cache<UUID, CompletableFuture<ResourceLocation>> f3260a = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).removalListener(removalNotification -> {
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
                C0530jM.log("Released skin texture for: " + String.valueOf(uuid), new Object[0]);
            });
        } catch (Exception e) {
            C0530jM.log("Failed to resolve texture for: " + String.valueOf(uuid) + " due to: " + e.getMessage(), new Object[0]);
        }
    }).build();

    @NotNull
    /* JADX INFO: renamed from: a */
    public ResourceLocation m2464a(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        if (uuid.version() != 4) {
            return DefaultPlayerSkin.get(uuid).texture();
        }
        try {
            return (ResourceLocation) ((CompletableFuture) this.f3260a.get(uuid, () -> {
                return CompletableFuture.supplyAsync(() -> {
                    return m2465b(minecraft, uuid);
                }, this.f3259a);
            })).getNow(DefaultPlayerSkin.get(uuid).texture());
        } catch (Exception e) {
            C0530jM.m2338a("Failed to fetch skin for player '" + String.valueOf(uuid) + "' due to: ", e, new Object[0]);
            return DefaultPlayerSkin.get(uuid).texture();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private ResourceLocation m2465b(@NotNull Minecraft minecraft, @NotNull UUID uuid) {
        C0530jM.log("Fetching skin for player '%s'...", uuid);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(String.format(f3257aB, uuid.toString().replace("-", ""))).toURL().openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(f3258lq);
            httpURLConnection.setReadTimeout(f3258lq);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() != 200) {
                httpURLConnection.disconnect();
                C0530jM.log("No Mojang profile for player '%s', using default skin.", uuid);
                return DefaultPlayerSkin.get(uuid).texture();
            }
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
                    JsonObject jsonObject = (JsonObject) new Gson().fromJson(sb.toString(), JsonObject.class);
                    if (jsonObject == null || !jsonObject.has("properties")) {
                        C0530jM.log("Empty profile response for player '%s', using default skin.", uuid);
                        ResourceLocation resourceLocationTexture = DefaultPlayerSkin.get(uuid).texture();
                        bufferedReader.close();
                        httpURLConnection.disconnect();
                        return resourceLocationTexture;
                    }
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) URI.create(((JsonObject) new Gson().fromJson(new String(Base64.getDecoder().decode(jsonObject.getAsJsonArray("properties").get(0).getAsJsonObject().get("value").getAsString())), JsonObject.class)).getAsJsonObject("textures").getAsJsonObject("SKIN").get("url").getAsString()).toURL().openConnection();
                    httpURLConnection2.setConnectTimeout(f3258lq);
                    httpURLConnection2.setReadTimeout(f3258lq);
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    try {
                        BufferedImage bufferedImage = ImageIO.read(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
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
                                C0530jM.log("Successfully fetched and registered skin for player '" + String.valueOf(uuid) + "'!", new Object[0]);
                            } catch (Exception e) {
                                completableFuture.completeExceptionally(e);
                            }
                        });
                        ResourceLocation resourceLocation = (ResourceLocation) completableFuture.get();
                        bufferedReader.close();
                        httpURLConnection.disconnect();
                        return resourceLocation;
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
                    try {
                        bufferedReader.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                httpURLConnection.disconnect();
                throw th5;
            }
        } catch (Exception e) {
            C0530jM.m2338a("Failed to fetch or register skin for player '" + String.valueOf(uuid) + "', using default skin.", e, new Object[0]);
            return DefaultPlayerSkin.get(uuid).texture();
        }
    }

    public void shutdown() {
        this.f3259a.shutdown();
    }
}
