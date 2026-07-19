package com.boehmod.blockfront;

import com.mojang.blaze3d.platform.MacosUtil;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.server.packs.resources.IoSupplier;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/f.class */
public final class C0136f {

    @NotNull
    private static final String g = "/assets/bf/icons/icon_16x16.png";

    @NotNull
    private static final String h = "/assets/bf/icons/icon_32x32.png";

    @NotNull
    private static final String i = "/assets/bf/icons/icon_update_16x16.png";

    @NotNull
    private static final String j = "/assets/bf/icons/icon_update_32x32.png";

    @NotNull
    private static final String k = "Minecraft v" + SharedConstants.getCurrentVersion().getId() + " - BlockFront Mod v" + C0002a.c;
    private static boolean r = false;

    public static void a(@NotNull C0297l c0297l, @NotNull Window window) {
        if (r) {
            return;
        }
        r = true;
        C0405p c0405pM588a = c0297l.m588a();
        try {
            URL resource = C0136f.class.getResource(g);
            URL resource2 = C0136f.class.getResource(h);
            if (c0405pM588a.ad()) {
                resource = C0136f.class.getResource(i);
                resource2 = C0136f.class.getResource(j);
            }
            if (resource != null && resource2 != null) {
                a(window, (IoSupplier<InputStream>) IoSupplier.create(Paths.get(resource2.toURI())));
            }
        } catch (IOException | URISyntaxException e) {
            C0263jt.a("[Brand] Failed to assign window icon.", e, new Object[0]);
            throw new RuntimeException(e);
        }
    }

    public static void a(@NotNull Window window, @NotNull IoSupplier<InputStream> ioSupplier) throws IOException {
        RenderSystem.assertOnRenderThreadOrInit();
        if (Minecraft.ON_OSX) {
            MacosUtil.loadIcon(ioSupplier);
            return;
        }
        ObjectList objectListSingleton = ObjectLists.singleton(ioSupplier);
        int size = objectListSingleton.size();
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        try {
            MemoryStack memoryStackStackPush = MemoryStack.stackPush();
            try {
                GLFWImage.Buffer bufferMalloc = GLFWImage.malloc(size, memoryStackStackPush);
                for (int i2 = 0; i2 < size; i2++) {
                    NativeImage nativeImage = NativeImage.read((InputStream) ((IoSupplier) objectListSingleton.get(i2)).get());
                    try {
                        int width = nativeImage.getWidth();
                        int height = nativeImage.getHeight();
                        ByteBuffer byteBufferMemAlloc = MemoryUtil.memAlloc(width * height * 4);
                        objectArrayList.add(byteBufferMemAlloc);
                        byteBufferMemAlloc.asIntBuffer().put(nativeImage.getPixelsRGBA());
                        bufferMalloc.position(i2);
                        bufferMalloc.width(width);
                        bufferMalloc.height(height);
                        bufferMalloc.pixels(byteBufferMemAlloc);
                        if (nativeImage != null) {
                            nativeImage.close();
                        }
                    } catch (Throwable th) {
                        if (nativeImage != null) {
                            try {
                                nativeImage.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                GLFW.glfwSetWindowIcon(window.getWindow(), bufferMalloc.position(0));
                if (memoryStackStackPush != null) {
                    memoryStackStackPush.close();
                }
            } finally {
            }
        } finally {
            objectArrayList.forEach((v0) -> {
                MemoryUtil.memFree(v0);
            });
        }
    }

    public static void a(@NotNull C0297l c0297l, @NotNull Minecraft minecraft) {
        a(c0297l, minecraft, ((fV) c0297l.a()).m404a(minecraft).k().getString());
    }

    public static void a(@NotNull C0297l c0297l, @NotNull Minecraft minecraft, @NotNull String str) {
        String str2;
        C0405p c0405pM588a = c0297l.m588a();
        Window window = minecraft.getWindow();
        String str3 = k;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = " (" + (c0405pM588a.ad() ? I18n.get("bf.cloud.popup.update.title", new Object[0]) : str) + ")";
        }
        window.setTitle(str3 + " " + str2);
    }
}
