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

/* JADX INFO: renamed from: com.boehmod.blockfront.f */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/f.class */
public final class C0304f {

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final String f2304g = "/assets/bf/icons/icon_16x16.png";

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final String f2305h = "/assets/bf/icons/icon_32x32.png";

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final String f2306i = "/assets/bf/icons/icon_update_16x16.png";

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final String f2307j = "/assets/bf/icons/icon_update_32x32.png";

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final String f2308k = "Minecraft v" + SharedConstants.getCurrentVersion().getId() + " - BlockFront Mod v" + C0029a.f248c;

    /* JADX INFO: renamed from: r */
    private static boolean f2309r = false;

    /* JADX INFO: renamed from: a */
    public static void m1599a(@NotNull C0622l c0622l, @NotNull Window window) {
        if (f2309r) {
            return;
        }
        f2309r = true;
        C0834p c0834pM2684a = c0622l.m2684a();
        try {
            URL resource = C0304f.class.getResource(f2304g);
            URL resource2 = C0304f.class.getResource(f2305h);
            if (c0834pM2684a.m2558ad()) {
                resource = C0304f.class.getResource(f2306i);
                resource2 = C0304f.class.getResource(f2307j);
            }
            if (resource != null && resource2 != null) {
                m1600a(window, (IoSupplier<InputStream>) IoSupplier.create(Paths.get(resource2.toURI())));
            }
        } catch (IOException | URISyntaxException e) {
            C0562jt.m2516a("[Brand] Failed to assign window icon.", e, new Object[0]);
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1600a(@NotNull Window window, @NotNull IoSupplier<InputStream> ioSupplier) throws IOException {
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
                for (int i = 0; i < size; i++) {
                    NativeImage nativeImage = NativeImage.read((InputStream) ((IoSupplier) objectListSingleton.get(i)).get());
                    try {
                        int width = nativeImage.getWidth();
                        int height = nativeImage.getHeight();
                        ByteBuffer byteBufferMemAlloc = MemoryUtil.memAlloc(width * height * 4);
                        objectArrayList.add(byteBufferMemAlloc);
                        byteBufferMemAlloc.asIntBuffer().put(nativeImage.getPixelsRGBA());
                        bufferMalloc.position(i);
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

    /* JADX INFO: renamed from: a */
    public static void m1601a(@NotNull C0622l c0622l, @NotNull Minecraft minecraft) {
        m1602a(c0622l, minecraft, ((C0326fV) c0622l.m2670a()).m1676a(minecraft).m2190k().getString());
    }

    /* JADX INFO: renamed from: a */
    public static void m1602a(@NotNull C0622l c0622l, @NotNull Minecraft minecraft, @NotNull String str) {
        String str2;
        C0834p c0834pM2684a = c0622l.m2684a();
        Window window = minecraft.getWindow();
        String str3 = f2308k;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = " (" + (c0834pM2684a.m2558ad() ? I18n.get("bf.cloud.popup.update.title", new Object[0]) : str) + ")";
        }
        window.setTitle(str3 + " " + str2);
    }
}
