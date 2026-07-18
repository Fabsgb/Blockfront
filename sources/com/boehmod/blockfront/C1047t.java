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

/* JADX INFO: renamed from: com.boehmod.blockfront.t */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/t.class */
public class C1047t extends AbstractC0517jA<C0622l> {

    /* JADX INFO: renamed from: u */
    public static final int f5540u = 854;

    /* JADX INFO: renamed from: v */
    public static final int f5541v = 480;

    /* JADX INFO: renamed from: a */
    @NotNull
    public a f5542a = a.IDLE;

    /* JADX INFO: renamed from: com.boehmod.blockfront.t$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/t$a.class */
    public enum a {
        IDLE,
        RECEIVED_REQUEST,
        PROCESSING_REQUEST
    }

    /* JADX INFO: renamed from: j */
    public void m5822j() {
        this.f5542a = a.RECEIVED_REQUEST;
    }

    /* JADX INFO: renamed from: k */
    private void m5823k() throws IOException {
        C0562jt.log("[AC] Creating new screenshot for server...", new Object[0]);
        BufferedImage bufferedImageM5824a = m5824a(2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImageM5824a, "PNG", byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        C0562jt.log("[AC] Sending screenshot to server...", new Object[0]);
        C1194vo.m6653c(new C0520jD(byteArray));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static BufferedImage m5824a(int i) throws IOException {
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

    /* JADX INFO: renamed from: a */
    public static byte[] m5825a(float f) throws IOException {
        BufferedImage bufferedImageM5824a = m5824a(1);
        ImageWriter imageWriter = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam defaultWriteParam = imageWriter.getDefaultWriteParam();
        defaultWriteParam.setCompressionMode(2);
        defaultWriteParam.setCompressionQuality(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOutputStreamCreateImageOutputStream = ImageIO.createImageOutputStream(byteArrayOutputStream);
            try {
                imageWriter.setOutput(imageOutputStreamCreateImageOutputStream);
                imageWriter.write((IIOMetadata) null, new IIOImage(bufferedImageM5824a, (List) null, (IIOMetadata) null), defaultWriteParam);
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

    @Override // com.boehmod.blockfront.AbstractC0517jA
    /* JADX INFO: renamed from: c */
    public void mo2274b(@NotNull C0622l c0622l) {
        switch (this.f5542a.ordinal()) {
            case 1:
                this.f5542a = a.PROCESSING_REQUEST;
                break;
            case 2:
                this.f5542a = a.IDLE;
                if (!RenderSystem.isOnRenderThread()) {
                    RenderSystem.recordRenderCall(() -> {
                        try {
                            m5823k();
                        } catch (IOException e) {
                            C0562jt.log("[AC] Failed to create new screenshot for server.", e);
                        }
                    });
                } else {
                    try {
                        m5823k();
                    } catch (IOException e) {
                        C0562jt.log("[AC] Failed to create new screenshot for server.", e);
                    }
                }
                break;
        }
    }
}
