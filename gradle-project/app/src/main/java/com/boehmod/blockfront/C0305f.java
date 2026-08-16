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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/f.class */
public final class C0305f {

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final String f2382h = "/assets/bf/icons/icon_16x16.png";

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final String f2383i = "/assets/bf/icons/icon_32x32.png";

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final String f2384j = "/assets/bf/icons/icon_update_16x16.png";

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final String f2385k = "/assets/bf/icons/icon_update_32x32.png";

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final String f2386l = "Minecraft v" + SharedConstants.getCurrentVersion().getId() + " - BlockFront Mod v" + C0030a.f265c;

    /* JADX INFO: renamed from: s */
    private static boolean f2387s = false;

    /* JADX INFO: renamed from: a */
    public static void m1652a(@NotNull C0623l c0623l, @NotNull Window window) {
        if (f2387s) {
            return;
        }
        f2387s = true;
        C0835p c0835pM2870a = c0623l.m2870a();
        try {
            URL resource = C0305f.class.getResource(f2382h);
            URL resource2 = C0305f.class.getResource(f2383i);
            if (c0835pM2870a.m2382ah()) {
                resource = C0305f.class.getResource(f2384j);
                resource2 = C0305f.class.getResource(f2385k);
            }
            if (resource != null && resource2 != null) {
                m1653a(window, (IoSupplier<InputStream>) IoSupplier.create(Paths.get(resource2.toURI())));
            }
        } catch (IOException | URISyntaxException e) {
            C0530jM.m2338a("[Brand] Failed to assign window icon.", e, new Object[0]);
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1653a(@NotNull Window window, @NotNull IoSupplier<InputStream> ioSupplier) throws IOException {
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
                objectArrayList.forEach((v0) -> {
                    MemoryUtil.memFree(v0);
                });
            } catch (Throwable th3) {
                if (memoryStackStackPush != null) {
                    try {
                        memoryStackStackPush.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Throwable th5) {
            objectArrayList.forEach((v0) -> {
                MemoryUtil.memFree(v0);
            });
            throw th5;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1654a(@NotNull C0623l c0623l, @NotNull Minecraft minecraft) {
        m1655a(c0623l, minecraft, ((C0396gl) c0623l.m2855a()).m1886a(minecraft).m2517k().getString());
    }

    /* JADX INFO: renamed from: a */
    public static void m1655a(@NotNull C0623l c0623l, @NotNull Minecraft minecraft, @NotNull String str) {
        String str2;
        C0835p c0835pM2870a = c0623l.m2870a();
        Window window = minecraft.getWindow();
        String str3 = f2386l;
        if (str.isEmpty()) {
            str2 = "";
        } else {
            str2 = " (" + (c0835pM2870a.m2382ah() ? I18n.get("bf.cloud.popup.update.title", new Object[0]) : str) + ")";
        }
        window.setTitle(str3 + " " + str2);
    }
}
