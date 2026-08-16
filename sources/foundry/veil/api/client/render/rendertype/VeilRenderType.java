package foundry.veil.api.client.render.rendertype;

import com.boehmod.blockfront.InterfaceC1274xN;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.vertex.VeilVertexFormat;
import foundry.veil.impl.client.render.pipeline.CullFaceShard;
import foundry.veil.impl.client.render.rendertype.WhiteTextureStateShard;
import foundry.veil.mixin.rendertype.accessor.RenderStateShardAccessor;
import foundry.veil.mixin.rendertype.accessor.RenderTypeAccessor;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/VeilRenderType.class */
public final class VeilRenderType extends RenderType {
    public static final RenderStateShard.DepthTestStateShard NEVER_DEPTH_TEST = new RenderStateShard.DepthTestStateShard("never", InterfaceC1274xN.f6852vU);
    public static final RenderStateShard.DepthTestStateShard LESS_DEPTH_TEST = new RenderStateShard.DepthTestStateShard("<", 513);
    public static final RenderStateShard.DepthTestStateShard NOTEQUAL_DEPTH_TEST = new RenderStateShard.DepthTestStateShard("<", 517);
    public static final RenderStateShard.DepthTestStateShard GEQUAL_DEPTH_TEST = new RenderStateShard.DepthTestStateShard(">=", 518);
    public static final RenderStateShard CULL_FRONT = new CullFaceShard(1028);
    public static final RenderStateShard CULL_BACK = new CullFaceShard(1029);
    public static final RenderStateShard CULL_FRONT_AND_BACK = new CullFaceShard(1032);
    public static final RenderStateShard.WriteMaskStateShard NO_WRITE = new RenderStateShard.WriteMaskStateShard(false, false);
    public static final RenderStateShard.EmptyTextureStateShard WHITE_TEXTURE = new WhiteTextureStateShard();
    private static final EnumMap<GlStateManager.LogicOp, RenderStateShard.ColorLogicStateShard> COLOR_LOGIC_SHARDS = new EnumMap<>(GlStateManager.LogicOp.class);
    private static final RenderStateShard.ShaderStateShard PARTICLE;
    private static final BiFunction<ResourceLocation, Boolean, RenderType> QUASAR_PARTICLE;
    private static final BiFunction<ResourceLocation, Boolean, RenderType> QUASAR_TRAIL;
    private static final Function<Boolean, RenderType> NO_TEXTURE_QUASAR_TRAIL;

    static {
        for (GlStateManager.LogicOp logicOp : GlStateManager.LogicOp.values()) {
            COLOR_LOGIC_SHARDS.put(logicOp, new RenderStateShard.ColorLogicStateShard(logicOp.name().toLowerCase(Locale.ROOT), () -> {
                RenderSystem.enableColorLogicOp();
                RenderSystem.logicOp(logicOp);
            }, RenderSystem::disableColorLogicOp));
        }
        PARTICLE = VeilRenderBridge.shaderState(Veil.veilPath("quasar/particle"));
        QUASAR_PARTICLE = Util.memoize((texture, additive) -> {
            RenderType.CompositeState state = RenderType.CompositeState.builder().setShaderState(PARTICLE).setTextureState(new RenderStateShard.TextureStateShard(texture, false, false)).setTransparencyState(additive.booleanValue() ? ADDITIVE_TRANSPARENCY : TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setWriteMaskState(COLOR_DEPTH_WRITE).createCompositeState(false);
            return create("veil:quasar_particle", VeilVertexFormat.QUASAR_PARTICLE, VertexFormat.Mode.QUADS, 786432, false, true, state);
        });
        QUASAR_TRAIL = Util.memoize((texture2, additive2) -> {
            RenderType.CompositeState state = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER).setTextureState(new RenderStateShard.TextureStateShard(texture2, false, false)).setTransparencyState(additive2.booleanValue() ? ADDITIVE_TRANSPARENCY : TRANSLUCENT_TRANSPARENCY).setWriteMaskState(COLOR_DEPTH_WRITE).setCullState(NO_CULL).createCompositeState(false);
            return RenderType.create("veil:quasar_trail", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.TRIANGLE_STRIP, 1536, false, false, state);
        });
        NO_TEXTURE_QUASAR_TRAIL = Util.memoize(additive3 -> {
            RenderType.CompositeState state = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER).setTextureState(WHITE_TEXTURE).setTransparencyState(additive3.booleanValue() ? ADDITIVE_TRANSPARENCY : TRANSLUCENT_TRANSPARENCY).setWriteMaskState(COLOR_DEPTH_WRITE).setCullState(NO_CULL).createCompositeState(false);
            return RenderType.create("veil:quasar_trail", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.TRIANGLE_STRIP, 1536, false, false, state);
        });
    }

    public static RenderType quasarParticle(ResourceLocation texture, boolean additive) {
        return QUASAR_PARTICLE.apply(texture, Boolean.valueOf(additive));
    }

    public static RenderType quasarTrail(@Nullable ResourceLocation texture) {
        return quasarTrail(texture, true);
    }

    public static RenderType quasarTrail(@Nullable ResourceLocation texture, boolean additive) {
        return texture != null ? QUASAR_TRAIL.apply(texture, Boolean.valueOf(additive)) : NO_TEXTURE_QUASAR_TRAIL.apply(Boolean.valueOf(additive));
    }

    public static RenderStateShard.TransparencyStateShard noTransparencyShard() {
        return RenderStateShard.NO_TRANSPARENCY;
    }

    public static RenderStateShard.TransparencyStateShard additiveTransparencyShard() {
        return RenderStateShard.ADDITIVE_TRANSPARENCY;
    }

    public static RenderStateShard.TransparencyStateShard lightningTransparencyShard() {
        return RenderStateShard.LIGHTNING_TRANSPARENCY;
    }

    public static RenderStateShard.TransparencyStateShard glintTransparencyShard() {
        return RenderStateShard.GLINT_TRANSPARENCY;
    }

    public static RenderStateShard.TransparencyStateShard crumblingTransparencyShard() {
        return RenderStateShard.CRUMBLING_TRANSPARENCY;
    }

    public static RenderStateShard.TransparencyStateShard translucentTransparencyShard() {
        return RenderStateShard.TRANSLUCENT_TRANSPARENCY;
    }

    public static RenderStateShard.DepthTestStateShard noDepthTestShard() {
        return RenderStateShard.NO_DEPTH_TEST;
    }

    public static RenderStateShard.DepthTestStateShard equalDepthTestShard() {
        return RenderStateShard.EQUAL_DEPTH_TEST;
    }

    public static RenderStateShard.DepthTestStateShard lequalDepthTestShard() {
        return RenderStateShard.LEQUAL_DEPTH_TEST;
    }

    public static RenderStateShard.DepthTestStateShard greaterDepthTestShard() {
        return RenderStateShard.GREATER_DEPTH_TEST;
    }

    public static RenderStateShard.CullStateShard cullShard() {
        return RenderStateShard.CULL;
    }

    public static RenderStateShard.CullStateShard noCullShard() {
        return RenderStateShard.NO_CULL;
    }

    public static RenderStateShard.LightmapStateShard lightmap() {
        return RenderStateShard.LIGHTMAP;
    }

    public static RenderStateShard.LightmapStateShard noLightmap() {
        return RenderStateShard.NO_LIGHTMAP;
    }

    public static RenderStateShard.OverlayStateShard overlay() {
        return RenderStateShard.OVERLAY;
    }

    public static RenderStateShard.OverlayStateShard noOverlay() {
        return RenderStateShard.NO_OVERLAY;
    }

    public static RenderStateShard.LayeringStateShard noLayering() {
        return RenderStateShard.NO_LAYERING;
    }

    public static RenderStateShard.LayeringStateShard polygonOffsetLayering() {
        return RenderStateShard.POLYGON_OFFSET_LAYERING;
    }

    public static RenderStateShard.LayeringStateShard viewOffsetLayering() {
        return RenderStateShard.VIEW_OFFSET_Z_LAYERING;
    }

    public static RenderStateShard.WriteMaskStateShard colorDepthWriteShard() {
        return RenderStateShard.COLOR_DEPTH_WRITE;
    }

    public static RenderStateShard.WriteMaskStateShard colorWriteShard() {
        return RenderStateShard.COLOR_WRITE;
    }

    public static RenderStateShard.WriteMaskStateShard depthWriteShard() {
        return RenderStateShard.DEPTH_WRITE;
    }

    public static RenderStateShard.ColorLogicStateShard colorLogicStateShard(GlStateManager.LogicOp op) {
        return COLOR_LOGIC_SHARDS.get(op);
    }

    @Contract(pure = true)
    @Nullable
    public static RenderType get(ResourceLocation id, Object... params) {
        return VeilRenderSystem.renderer().getDynamicRenderTypeManager().get(id, params);
    }

    @Contract(value = "_->new", pure = true)
    public static RenderTypeWrapper getWrapper(ResourceLocation id) {
        return new RenderTypeWrapper(id);
    }

    @Contract(pure = true)
    public static String getName(RenderStateShard shard) {
        return ((RenderStateShardAccessor) shard).getName();
    }

    @Contract(pure = true)
    public static VeilRenderTypeAccessor getShards(RenderType renderType) {
        if (!(renderType instanceof RenderType.CompositeRenderType)) {
            throw new IllegalArgumentException("Expected composite render type to be an instance of " + RenderType.CompositeRenderType.class.getName() + ", but was " + String.valueOf(renderType.getClass()));
        }
        RenderType.CompositeRenderType compositeRenderType = (RenderType.CompositeRenderType) renderType;
        return compositeRenderType.state();
    }

    @Contract(pure = true)
    public static RenderType layered(RenderType... layers) {
        if (layers.length == 0) {
            throw new IllegalArgumentException("At least 1 render type must be specified");
        }
        if (layers.length == 1) {
            return layers[0];
        }
        RenderType[] array = new RenderType[layers.length - 1];
        VertexFormat format = layers[0].format();
        VertexFormat.Mode mode = layers[0].mode();
        int bufferSize = layers[0].bufferSize();
        boolean sortOnUpload = ((RenderTypeAccessor) layers[0]).isSortOnUpload();
        for (int i = 1; i < layers.length; i++) {
            RenderType layer = layers[i];
            if (!layer.format().equals(format)) {
                throw new IllegalArgumentException("Expected " + String.valueOf(layer) + " to use " + String.valueOf(format) + ", but was " + String.valueOf(layer.format()));
            }
            if (!layer.mode().equals(mode)) {
                throw new IllegalArgumentException("Expected " + String.valueOf(layer) + " to use " + String.valueOf(mode) + ", but was " + String.valueOf(layer.mode()));
            }
            bufferSize = Math.max(bufferSize, layer.bufferSize());
            if (((RenderTypeAccessor) layer).isSortOnUpload()) {
                sortOnUpload = true;
            }
            array[i - 1] = layer;
        }
        return new LayeredRenderType(layers[0], array, "LayeredRenderType[" + ((String) Arrays.stream(layers).map((v0) -> {
            return getName(v0);
        }).collect(Collectors.joining(", "))) + "]", bufferSize, sortOnUpload);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/VeilRenderType$LayeredRenderType.class */
    public static class LayeredRenderType extends RenderType {
        private final RenderType[] layers;

        /* JADX WARN: Illegal instructions before constructor call */
        private LayeredRenderType(RenderType defaultValue, RenderType[] layers, String name, int bufferSize, boolean sortOnUpload) {
            VertexFormat vertexFormat = defaultValue.format();
            VertexFormat.Mode mode = defaultValue.mode();
            boolean zAffectsCrumbling = defaultValue.affectsCrumbling();
            Objects.requireNonNull(defaultValue);
            Runnable runnable = defaultValue::setupRenderState;
            Objects.requireNonNull(defaultValue);
            super(name, vertexFormat, mode, bufferSize, zAffectsCrumbling, sortOnUpload, runnable, defaultValue::clearRenderState);
            this.layers = layers;
        }

        public void draw(@NotNull MeshData meshData) {
            super.draw(meshData);
            if (BufferUploader.lastImmediateBuffer != null) {
                Matrix4f modelViewMatrix = RenderSystem.getModelViewMatrix();
                Matrix4f projectionMatrix = RenderSystem.getProjectionMatrix();
                for (RenderType layer : this.layers) {
                    layer.setupRenderState();
                    ShaderInstance shader = RenderSystem.getShader();
                    if (shader != null) {
                        BufferUploader.lastImmediateBuffer.drawWithShader(modelViewMatrix, projectionMatrix, shader);
                    }
                    layer.clearRenderState();
                }
            }
        }

        public RenderType[] getLayers() {
            return this.layers;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/VeilRenderType$RenderTypeWrapper.class */
    public static class RenderTypeWrapper extends RenderType {
        private static final Object[] NO_PARAMS = new Object[0];

        /* JADX INFO: renamed from: id */
        private final ResourceLocation f9136id;
        private Object[] params;

        private RenderTypeWrapper(ResourceLocation id) {
            super(id.toString(), DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 0, false, false, () -> {
            }, () -> {
            });
            this.f9136id = id;
            this.params = NO_PARAMS;
        }

        public void setupRenderState() {
            RenderType renderType = get();
            if (renderType != null) {
                renderType.setupRenderState();
            }
        }

        public void clearRenderState() {
            RenderType renderType = get();
            if (renderType != null) {
                renderType.clearRenderState();
            }
        }

        public void draw(@NotNull MeshData meshData) {
            RenderType renderType = get();
            if (renderType != null) {
                renderType.draw(meshData);
            }
        }

        public int bufferSize() {
            RenderType renderType = get();
            if (renderType != null) {
                return renderType.bufferSize();
            }
            return 1536;
        }

        @NotNull
        public VertexFormat format() {
            RenderType renderType = get();
            return renderType != null ? renderType.format() : DefaultVertexFormat.POSITION;
        }

        public VertexFormat.Mode mode() {
            RenderType renderType = get();
            return renderType != null ? renderType.mode() : VertexFormat.Mode.QUADS;
        }

        @NotNull
        public Optional<RenderType> outline() {
            RenderType renderType = get();
            return renderType != null ? renderType.outline() : Optional.empty();
        }

        public boolean isOutline() {
            RenderType renderType = get();
            return renderType != null && renderType.isOutline();
        }

        public boolean affectsCrumbling() {
            RenderType renderType = get();
            return renderType != null && renderType.affectsCrumbling();
        }

        public boolean canConsolidateConsecutiveGeometry() {
            RenderType renderType = get();
            return renderType != null && renderType.canConsolidateConsecutiveGeometry();
        }

        public boolean sortOnUpload() {
            RenderType renderType = get();
            return renderType != null && renderType.sortOnUpload();
        }

        public void setParams(Object... params) {
            if (params.length == 0) {
                this.params = NO_PARAMS;
            } else if (this.params.length == params.length) {
                System.arraycopy(params, 0, this.params, 0, params.length);
            } else {
                this.params = Arrays.copyOf(params, params.length);
            }
        }

        @Nullable
        public RenderType get() {
            return VeilRenderSystem.renderer().getDynamicRenderTypeManager().get(this.f9136id, this.params);
        }
    }

    private VeilRenderType(String name, VertexFormat format, VertexFormat.Mode mode, int bufferSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setupState, Runnable clearState) {
        super(name, format, mode, bufferSize, affectsCrumbling, sortOnUpload, setupState, clearState);
    }
}
