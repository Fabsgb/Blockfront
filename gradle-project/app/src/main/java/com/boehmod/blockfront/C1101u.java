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

/* JADX INFO: renamed from: com.boehmod.blockfront.u */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/u.class */
public class C1101u extends AbstractC0537jT<C0623l> {

    /* JADX INFO: renamed from: K */
    public static final int f5997K = 854;

    /* JADX INFO: renamed from: L */
    public static final int f5998L = 480;

    /* JADX INFO: renamed from: a */
    @NotNull
    public volatile a f5999a = a.IDLE;

    /* JADX INFO: renamed from: com.boehmod.blockfront.u$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/u$a.class */
    public enum a {
        IDLE,
        RECEIVED_REQUEST,
        PROCESSING_REQUEST
    }

    /* JADX INFO: renamed from: l */
    public void m6186l() {
        this.f5999a = a.RECEIVED_REQUEST;
    }

    /* JADX INFO: renamed from: m */
    private void m6187m() throws IOException {
        C0530jM.log("[AC] Creating new screenshot for server...", new Object[0]);
        BufferedImage bufferedImageM6188a = m6188a(2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImageM6188a, "PNG", byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        C0530jM.log("[AC] Sending screenshot to server...", new Object[0]);
        C1169vO.m6648c(new C0540jW(byteArray));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static BufferedImage m6188a(int i) throws IOException {
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
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (nativeImageTakeScreenshot != null) {
                try {
                    nativeImageTakeScreenshot.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m6189a(float f) throws IOException {
        BufferedImage bufferedImageM6188a = m6188a(1);
        ImageWriter imageWriter = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam defaultWriteParam = imageWriter.getDefaultWriteParam();
        defaultWriteParam.setCompressionMode(2);
        defaultWriteParam.setCompressionQuality(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOutputStreamCreateImageOutputStream = ImageIO.createImageOutputStream(byteArrayOutputStream);
            try {
                imageWriter.setOutput(imageOutputStreamCreateImageOutputStream);
                imageWriter.write((IIOMetadata) null, new IIOImage(bufferedImageM6188a, (List) null, (IIOMetadata) null), defaultWriteParam);
                if (imageOutputStreamCreateImageOutputStream != null) {
                    imageOutputStreamCreateImageOutputStream.close();
                }
                imageWriter.dispose();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                if (imageOutputStreamCreateImageOutputStream != null) {
                    try {
                        imageOutputStreamCreateImageOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            imageWriter.dispose();
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0537jT
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void mo2408b(@NotNull C0623l c0623l) {
        switch (this.f5999a.ordinal()) {
            case 1:
                this.f5999a = a.PROCESSING_REQUEST;
                break;
            case 2:
                this.f5999a = a.IDLE;
                if (!RenderSystem.isOnRenderThread()) {
                    RenderSystem.recordRenderCall(() -> {
                        try {
                            m6187m();
                        } catch (IOException e) {
                            C0530jM.log("[AC] Failed to create new screenshot for server.", e);
                        }
                    });
                } else {
                    try {
                        m6187m();
                    } catch (IOException e) {
                        C0530jM.log("[AC] Failed to create new screenshot for server.", e);
                    }
                }
                break;
        }
    }
}
