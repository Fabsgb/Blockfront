package foundry.veil.api.client.render.framebuffer;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import foundry.veil.api.client.render.texture.TextureFilter;
import foundry.veil.api.molang.MolangExpressionCodec;
import foundry.veil.api.molang.VeilMolang;
import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/framebuffer/FramebufferDefinition.class */
public final class FramebufferDefinition extends Record {
    private final MolangExpression width;
    private final MolangExpression height;
    private final FramebufferAttachmentDefinition[] colorBuffers;

    @Nullable
    private final FramebufferAttachmentDefinition depthBuffer;
    private final boolean autoClear;
    public static final MolangExpression DEFAULT_WIDTH;
    public static final MolangExpression DEFAULT_HEIGHT;
    private static final Codec<Optional<FramebufferAttachmentDefinition>> DEPTH_CODEC;
    private static final Codec<FramebufferDefinition> FULL_CODEC;
    private static final Codec<FramebufferDefinition> COMPACT_CODEC;
    public static final Codec<FramebufferDefinition> CODEC;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FramebufferDefinition.class), FramebufferDefinition.class, "width;height;colorBuffers;depthBuffer;autoClear", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->width:Lgg/moonflower/molangcompiler/api/MolangExpression;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->height:Lgg/moonflower/molangcompiler/api/MolangExpression;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->colorBuffers:[Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->depthBuffer:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->autoClear:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FramebufferDefinition.class), FramebufferDefinition.class, "width;height;colorBuffers;depthBuffer;autoClear", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->width:Lgg/moonflower/molangcompiler/api/MolangExpression;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->height:Lgg/moonflower/molangcompiler/api/MolangExpression;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->colorBuffers:[Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->depthBuffer:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->autoClear:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FramebufferDefinition.class, Object.class), FramebufferDefinition.class, "width;height;colorBuffers;depthBuffer;autoClear", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->width:Lgg/moonflower/molangcompiler/api/MolangExpression;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->height:Lgg/moonflower/molangcompiler/api/MolangExpression;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->colorBuffers:[Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->depthBuffer:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferDefinition;->autoClear:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MolangExpression width() {
        return this.width;
    }

    public MolangExpression height() {
        return this.height;
    }

    public FramebufferAttachmentDefinition[] colorBuffers() {
        return this.colorBuffers;
    }

    @Nullable
    public FramebufferAttachmentDefinition depthBuffer() {
        return this.depthBuffer;
    }

    public boolean autoClear() {
        return this.autoClear;
    }

    static {
        try {
            DEFAULT_WIDTH = VeilMolang.get().compile("q.screen_width");
            DEFAULT_HEIGHT = VeilMolang.get().compile("q.screen_height");
            DEPTH_CODEC = Codec.either(FramebufferAttachmentDefinition.DEPTH_CODEC, Codec.BOOL).xmap(either -> {
                return (Optional) either.map((v0) -> {
                    return Optional.of(v0);
                }, compact -> {
                    if (compact.booleanValue()) {
                        return Optional.of(new FramebufferAttachmentDefinition(FramebufferAttachmentDefinition.Type.TEXTURE, FramebufferAttachmentDefinition.Format.DEPTH_COMPONENT, true, TextureFilter.CLAMP, 1, null));
                    }
                    return Optional.empty();
                });
            }, optional -> {
                if (optional.isEmpty()) {
                    return Either.right(false);
                }
                FramebufferAttachmentDefinition definition = (FramebufferAttachmentDefinition) optional.get();
                if (definition.isCompactDepthAttachment()) {
                    return Either.right(true);
                }
                return Either.left(definition);
            });
            FULL_CODEC = RecordCodecBuilder.create(instance -> {
                return instance.group(MolangExpressionCodec.CODEC.optionalFieldOf("width", DEFAULT_WIDTH).forGetter((v0) -> {
                    return v0.width();
                }), MolangExpressionCodec.CODEC.optionalFieldOf("height", DEFAULT_HEIGHT).forGetter((v0) -> {
                    return v0.height();
                }), FramebufferAttachmentDefinition.COLOR_CODEC.listOf().fieldOf("color_buffers").flatXmap(FramebufferDefinition::colorSizeCheck, FramebufferDefinition::colorSizeCheck).forGetter(definition -> {
                    return Arrays.asList(definition.colorBuffers);
                }), DEPTH_CODEC.fieldOf("depth").forGetter(definition2 -> {
                    return Optional.ofNullable(definition2.depthBuffer);
                }), Codec.BOOL.optionalFieldOf("autoClear", true).forGetter((v0) -> {
                    return v0.autoClear();
                })).apply(instance, (width, height, colorBuffers, depthBuffer, autoClear) -> {
                    return new FramebufferDefinition(width, height, (FramebufferAttachmentDefinition[]) colorBuffers.toArray(x$0 -> {
                        return new FramebufferAttachmentDefinition[x$0];
                    }), (FramebufferAttachmentDefinition) depthBuffer.orElse(null), autoClear.booleanValue());
                });
            });
            COMPACT_CODEC = RecordCodecBuilder.create(instance2 -> {
                return instance2.group(MolangExpressionCodec.CODEC.optionalFieldOf("width", DEFAULT_WIDTH).forGetter((v0) -> {
                    return v0.width();
                }), MolangExpressionCodec.CODEC.optionalFieldOf("height", DEFAULT_HEIGHT).forGetter((v0) -> {
                    return v0.height();
                }), FramebufferAttachmentDefinition.Type.CODEC.optionalFieldOf("type", FramebufferAttachmentDefinition.Type.TEXTURE).forGetter(definition -> {
                    return definition.colorBuffers[0].type();
                }), FramebufferAttachmentDefinition.Format.CODEC.optionalFieldOf("format", FramebufferAttachmentDefinition.Format.RGBA8).forGetter(definition2 -> {
                    return definition2.colorBuffers[0].format();
                }), TextureFilter.CLAMP_DEFAULT_CODEC.optionalFieldOf("filter", TextureFilter.CLAMP).forGetter(definition3 -> {
                    return definition3.colorBuffers[0].filter();
                }), Codec.INT.optionalFieldOf("levels", 1).forGetter(definition4 -> {
                    return Integer.valueOf(definition4.colorBuffers[0].levels());
                }), Codec.STRING.optionalFieldOf("name").forGetter(definition5 -> {
                    return Optional.ofNullable(definition5.colorBuffers[0].name());
                }), DEPTH_CODEC.fieldOf("depth").forGetter(definition6 -> {
                    return Optional.ofNullable(definition6.depthBuffer);
                }), Codec.BOOL.optionalFieldOf("autoClear", true).forGetter((v0) -> {
                    return v0.autoClear();
                })).apply(instance2, (width, height, type, format, filter, levels, name, depth, autoClear) -> {
                    return new FramebufferDefinition(width, height, new FramebufferAttachmentDefinition[]{new FramebufferAttachmentDefinition(type, format, false, filter, levels.intValue(), (String) name.orElse(null))}, (FramebufferAttachmentDefinition) depth.orElse(null), autoClear.booleanValue());
                });
            });
            CODEC = Codec.either(FULL_CODEC, COMPACT_CODEC).xmap(either2 -> {
                return (FramebufferDefinition) either2.map(left -> {
                    return left;
                }, right -> {
                    return right;
                });
            }, definition -> {
                return definition.colorBuffers.length == 1 ? Either.right(definition) : Either.left(definition);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static DataResult<List<FramebufferAttachmentDefinition>> colorSizeCheck(List<FramebufferAttachmentDefinition> definitions) {
        if (definitions.isEmpty()) {
            return DataResult.error(() -> {
                return "There must be at least 1 color buffer";
            });
        }
        return DataResult.success(definitions);
    }

    public FramebufferDefinition(MolangExpression width, MolangExpression height, FramebufferAttachmentDefinition[] colorBuffers, @Nullable FramebufferAttachmentDefinition depthBuffer, boolean autoClear) {
        if (colorBuffers.length >= 1) {
            this.width = width;
            this.height = height;
            this.colorBuffers = colorBuffers;
            this.depthBuffer = depthBuffer;
            this.autoClear = autoClear;
            return;
        }
        throw new IllegalArgumentException("At least 1 color buffer must be defined");
    }

    public AdvancedFbo.Builder createBuilder(int screenWidth, int screenHeight) {
        MolangRuntime runtime = (MolangRuntime) MolangRuntime.runtime().setQuery("screen_width", screenWidth).setQuery("screen_height", screenHeight).create();
        return createBuilder(runtime);
    }

    public AdvancedFbo.Builder createBuilder(MolangEnvironment environment) {
        int width = (int) environment.safeResolve(this.width);
        int height = (int) environment.safeResolve(this.height);
        int maxWidth = VeilRenderSystem.maxFramebufferWidth();
        int maxHeight = VeilRenderSystem.maxFramebufferHeight();
        Validate.inclusiveBetween(1L, maxWidth, width, "width must be between 1 and " + maxWidth);
        Validate.inclusiveBetween(1L, maxHeight, height, "height must be between 1 and " + maxHeight);
        AdvancedFbo.Builder builder = AdvancedFbo.withSize(width, height);
        for (FramebufferAttachmentDefinition definition : this.colorBuffers) {
            builder.setLevels(definition.levels()).setFormat(definition.format());
            if (definition.type() == FramebufferAttachmentDefinition.Type.RENDER_BUFFER) {
                builder.addColorRenderBuffer();
            } else {
                builder.setFilter(definition.filter()).setName(definition.name()).addColorTextureBuffer();
            }
        }
        if (this.depthBuffer != null) {
            builder.setLevels(this.depthBuffer.levels()).setFormat(this.depthBuffer.format());
            if (this.depthBuffer.type() == FramebufferAttachmentDefinition.Type.RENDER_BUFFER) {
                builder.setDepthRenderBuffer();
            } else {
                builder.setFilter(this.depthBuffer.filter()).setName(this.depthBuffer.name()).setDepthTextureBuffer();
            }
        }
        return builder;
    }
}
