package software.bernie.geckolib.cache.texture;

import com.mojang.blaze3d.pipeline.RenderCall;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.resources.metadata.animation.AnimationMetadataSection;
import net.minecraft.client.resources.metadata.animation.FrameSize;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/cache/texture/AnimatableTexture.class */
public class AnimatableTexture extends SimpleTexture {
    private AnimationContents animationContents;
    private boolean isAnimated;

    public AnimatableTexture(ResourceLocation location) {
        super(location);
        this.animationContents = null;
        this.isAnimated = false;
    }

    public void load(ResourceManager manager) throws IOException {
        Resource resource = manager.getResourceOrThrow(this.location);
        AnimationMetadataSection animMeta = (AnimationMetadataSection) resource.metadata().getSection(AnimationMetadataSection.SERIALIZER).orElse(null);
        if (animMeta != null) {
            InputStream inputstream = resource.open();
            try {
                NativeImage nativeImage = NativeImage.read(inputstream);
                if (inputstream != null) {
                    inputstream.close();
                }
                this.animationContents = new AnimationContents(nativeImage, animMeta);
                if (!this.animationContents.isValid()) {
                    nativeImage.close();
                } else {
                    this.isAnimated = true;
                    onRenderThread(() -> {
                        TextureUtil.prepareImage(getId(), 0, this.animationContents.frameSize.width(), this.animationContents.frameSize.height());
                        nativeImage.upload(0, 0, 0, 0, 0, this.animationContents.frameSize.width(), this.animationContents.frameSize.height(), false, false);
                    });
                }
            } catch (Throwable th) {
                if (inputstream != null) {
                    try {
                        inputstream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public boolean isAnimated() {
        return this.isAnimated;
    }

    public static void setAndUpdate(ResourceLocation texturePath) {
        setAndUpdate(texturePath, (int) RenderUtil.getCurrentTick());
    }

    public static void setAndUpdate(ResourceLocation texturePath, int frameTick) {
        AnimatableTexture texture = Minecraft.getInstance().getTextureManager().getTexture(texturePath);
        if (texture instanceof AnimatableTexture) {
            AnimatableTexture animatableTexture = texture;
            animatableTexture.setAnimationFrame(frameTick);
        }
        RenderSystem.setShaderTexture(0, texture.getId());
    }

    public void setAnimationFrame(int tick) {
        if (this.animationContents != null && this.animationContents.animatedTexture != null) {
            this.animationContents.animatedTexture.setCurrentFrame(tick);
        }
    }

    private static void onRenderThread(RenderCall renderCall) {
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(renderCall);
        } else {
            renderCall.execute();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents.class */
    private class AnimationContents {
        private final FrameSize frameSize;
        private final Texture animatedTexture;

        private AnimationContents(NativeImage image, AnimationMetadataSection animMeta) {
            this.frameSize = animMeta.calculateFrameSize(image.getWidth(), image.getHeight());
            this.animatedTexture = generateAnimatedTexture(image, animMeta);
        }

        private boolean isValid() {
            return this.animatedTexture != null;
        }

        private Texture generateAnimatedTexture(NativeImage image, AnimationMetadataSection animMeta) {
            if (!Mth.isMultipleOf(image.getWidth(), this.frameSize.width()) || !Mth.isMultipleOf(image.getHeight(), this.frameSize.height())) {
                GeckoLibConstants.LOGGER.error("Image {} size {},{} is not multiple of frame size {},{}", AnimatableTexture.this.location, Integer.valueOf(image.getWidth()), Integer.valueOf(image.getHeight()), Integer.valueOf(this.frameSize.width()), Integer.valueOf(this.frameSize.height()));
                return null;
            }
            int columns = image.getWidth() / this.frameSize.width();
            int rows = image.getHeight() / this.frameSize.height();
            int frameCount = columns * rows;
            ObjectArrayList<Frame> objectArrayList = new ObjectArrayList();
            animMeta.forEachFrame((frame, frameTime) -> {
                objectArrayList.add(new Frame(frame, frameTime));
            });
            if (objectArrayList.isEmpty()) {
                for (int frame2 = 0; frame2 < frameCount; frame2++) {
                    objectArrayList.add(new Frame(frame2, animMeta.getDefaultFrameTime()));
                }
            } else {
                int index = 0;
                IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
                for (Frame frame3 : objectArrayList) {
                    if (frame3.time <= 0) {
                        GeckoLibConstants.LOGGER.warn("Invalid frame duration on sprite {} frame {}: {}", AnimatableTexture.this.location, Integer.valueOf(index), Integer.valueOf(frame3.time));
                        intOpenHashSet.add(frame3.index);
                    } else if (frame3.index < 0 || frame3.index >= frameCount) {
                        GeckoLibConstants.LOGGER.warn("Invalid frame index on sprite {} frame {}: {}", AnimatableTexture.this.location, Integer.valueOf(index), Integer.valueOf(frame3.index));
                        intOpenHashSet.add(frame3.index);
                    }
                    index++;
                }
                if (!intOpenHashSet.isEmpty()) {
                    GeckoLibConstants.LOGGER.warn("Unused frames in sprite {}: {}", AnimatableTexture.this.location, Arrays.toString(intOpenHashSet.toArray()));
                }
            }
            if (objectArrayList.size() <= 1) {
                return null;
            }
            return new Texture(image, (Frame[]) objectArrayList.toArray(new Frame[0]), columns, animMeta.isInterpolatedFrames());
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame.class */
        private static final class Frame extends Record {
            private final int index;
            private final int time;

            private Frame(int index, int time) {
                this.index = index;
                this.time = time;
            }

            @Override // java.lang.Record
            public final String toString() {
                return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Frame.class), Frame.class, "index;time", "FIELD:Lsoftware/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame;->index:I", "FIELD:Lsoftware/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame;->time:I").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Frame.class), Frame.class, "index;time", "FIELD:Lsoftware/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame;->index:I", "FIELD:Lsoftware/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame;->time:I").dynamicInvoker().invoke(this) /* invoke-custom */;
            }

            @Override // java.lang.Record
            public final boolean equals(Object o) {
                return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Frame.class, Object.class), Frame.class, "index;time", "FIELD:Lsoftware/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame;->index:I", "FIELD:Lsoftware/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Frame;->time:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
            }

            public int index() {
                return this.index;
            }

            public int time() {
                return this.time;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/cache/texture/AnimatableTexture$AnimationContents$Texture.class */
        private class Texture implements AutoCloseable {
            private final NativeImage baseImage;
            private final Frame[] frames;
            private final int framePanelSize;
            private final boolean interpolating;
            private final NativeImage interpolatedFrame;
            private final int totalFrameTime;
            private int currentFrame;
            private int currentSubframe;

            private Texture(NativeImage baseImage, Frame[] frames, int framePanelSize, boolean interpolating) {
                this.baseImage = baseImage;
                this.frames = frames;
                this.framePanelSize = framePanelSize;
                this.interpolating = interpolating;
                this.interpolatedFrame = interpolating ? new NativeImage(AnimationContents.this.frameSize.width(), AnimationContents.this.frameSize.height(), false) : null;
                int time = 0;
                for (Frame frame : this.frames) {
                    time += frame.time;
                }
                this.totalFrameTime = time;
            }

            private int getFrameX(int frameIndex) {
                return frameIndex % this.framePanelSize;
            }

            private int getFrameY(int frameIndex) {
                return frameIndex / this.framePanelSize;
            }

            public void setCurrentFrame(int ticks) {
                int ticks2 = ticks % this.totalFrameTime;
                if (ticks2 == this.currentSubframe) {
                    return;
                }
                int lastSubframe = this.currentSubframe;
                int lastFrame = this.currentFrame;
                int time = 0;
                Frame[] frameArr = this.frames;
                int length = frameArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Frame frame = frameArr[i];
                    time += frame.time;
                    if (ticks2 >= time) {
                        i++;
                    } else {
                        this.currentFrame = frame.index;
                        this.currentSubframe = ticks2 % frame.time;
                        break;
                    }
                }
                if (this.currentFrame != lastFrame && this.currentSubframe == 0) {
                    AnimatableTexture.onRenderThread(() -> {
                        TextureUtil.prepareImage(AnimatableTexture.this.getId(), 0, AnimationContents.this.frameSize.width(), AnimationContents.this.frameSize.height());
                        this.baseImage.upload(0, 0, 0, getFrameX(this.currentFrame) * AnimationContents.this.frameSize.width(), getFrameY(this.currentFrame) * AnimationContents.this.frameSize.height(), AnimationContents.this.frameSize.width(), AnimationContents.this.frameSize.height(), false, false);
                    });
                } else if (this.currentSubframe != lastSubframe && this.interpolating) {
                    AnimatableTexture.onRenderThread(this::generateInterpolatedFrame);
                }
            }

            private void generateInterpolatedFrame() {
                Frame frame = this.frames[this.currentFrame];
                double frameProgress = 1.0d - (((double) this.currentSubframe) / ((double) frame.time));
                int nextFrameIndex = this.frames[(this.currentFrame + 1) % this.frames.length].index;
                if (frame.index != nextFrameIndex) {
                    for (int y = 0; y < this.interpolatedFrame.getHeight(); y++) {
                        for (int x = 0; x < this.interpolatedFrame.getWidth(); x++) {
                            int prevFramePixel = getPixel(frame.index, x, y);
                            int nextFramePixel = getPixel(nextFrameIndex, x, y);
                            int blendedRed = interpolate(frameProgress, (prevFramePixel >> 16) & 255, (nextFramePixel >> 16) & 255);
                            int blendedGreen = interpolate(frameProgress, (prevFramePixel >> 8) & 255, (nextFramePixel >> 8) & 255);
                            int blendedBlue = interpolate(frameProgress, prevFramePixel & 255, nextFramePixel & 255);
                            this.interpolatedFrame.setPixelRGBA(x, y, (prevFramePixel & (-16777216)) | (blendedRed << 16) | (blendedGreen << 8) | blendedBlue);
                        }
                    }
                    TextureUtil.prepareImage(AnimatableTexture.this.getId(), 0, AnimationContents.this.frameSize.width(), AnimationContents.this.frameSize.height());
                    this.interpolatedFrame.upload(0, 0, 0, 0, 0, AnimationContents.this.frameSize.width(), AnimationContents.this.frameSize.height(), false, false);
                }
            }

            private int getPixel(int frameIndex, int x, int y) {
                return this.baseImage.getPixelRGBA(x + (getFrameX(frameIndex) * AnimationContents.this.frameSize.width()), y + (getFrameY(frameIndex) * AnimationContents.this.frameSize.height()));
            }

            private int interpolate(double frameProgress, double prevColor, double nextColor) {
                return (int) ((frameProgress * prevColor) + ((1.0d - frameProgress) * nextColor));
            }

            @Override // java.lang.AutoCloseable
            public void close() {
                this.baseImage.close();
                if (this.interpolatedFrame != null) {
                    this.interpolatedFrame.close();
                }
            }
        }
    }
}
