package com.boehmod.blockfront;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/t.class */
public class C0513t extends jA<C0297l> {
    public static final int u = 854;
    public static final int v = 480;

    @NotNull
    public a a = a.IDLE;

    /* JADX INFO: renamed from: com.boehmod.blockfront.t$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/t$a.class */
    public enum a {
        IDLE,
        RECEIVED_REQUEST,
        PROCESSING_REQUEST
    }

    public void j() {
        this.a = a.RECEIVED_REQUEST;
    }

    private void k() throws IOException {
        C0263jt.log("[AC] Creating new screenshot for server...", new Object[0]);
        BufferedImage bufferedImageA = a(2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImageA, "PNG", byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        C0263jt.log("[AC] Sending screenshot to server...", new Object[0]);
        C0582vo.c(new jD(byteArray));
    }

    @NotNull
    private static BufferedImage a(int i) throws IOException {
        NativeImage nativeImageTakeScreenshot = Screenshot.takeScreenshot(Minecraft.getInstance().getMainRenderTarget());
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(nativeImageTakeScreenshot.asByteArray());
            try {
                BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
                BufferedImage bufferedImage2 = new BufferedImage(854, 480, i);
                Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
                graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, 854, 480, (ImageObserver) null);
                graphics2DCreateGraphics.dispose();
                byteArrayInputStream.close();
                if (nativeImageTakeScreenshot != null) {
                    nativeImageTakeScreenshot.close();
                }
                return bufferedImage2;
            } finally {
            }
        } catch (Throwable th) {
            if (nativeImageTakeScreenshot != null) {
                try {
                    nativeImageTakeScreenshot.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static byte[] a(float f) throws IOException {
        BufferedImage bufferedImageA = a(1);
        ImageWriter imageWriter = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam defaultWriteParam = imageWriter.getDefaultWriteParam();
        defaultWriteParam.setCompressionMode(2);
        defaultWriteParam.setCompressionQuality(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOutputStreamCreateImageOutputStream = ImageIO.createImageOutputStream(byteArrayOutputStream);
            try {
                imageWriter.setOutput(imageOutputStreamCreateImageOutputStream);
                imageWriter.write((IIOMetadata) null, new IIOImage(bufferedImageA, (List) null, (IIOMetadata) null), defaultWriteParam);
                if (imageOutputStreamCreateImageOutputStream != null) {
                    imageOutputStreamCreateImageOutputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } finally {
            imageWriter.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.jA
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull C0297l c0297l) {
        switch (this.a.ordinal()) {
            case 1:
                this.a = a.PROCESSING_REQUEST;
                break;
            case 2:
                this.a = a.IDLE;
                if (!RenderSystem.isOnRenderThread()) {
                    RenderSystem.recordRenderCall(() -> {
                        try {
                            k();
                        } catch (IOException e) {
                            C0263jt.log("[AC] Failed to create new screenshot for server.", e);
                        }
                    });
                } else {
                    try {
                        k();
                    } catch (IOException e) {
                        C0263jt.log("[AC] Failed to create new screenshot for server.", e);
                    }
                }
                break;
        }
    }
}
