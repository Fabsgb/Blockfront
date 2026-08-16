package foundry.veil.api.client.render.shader.program;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.util.EnumCodec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.lwjgl.opengl.GL20C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderBlendMode.class */
public final class ShaderBlendMode extends Record {
    private final BlendEquation colorEquation;
    private final BlendEquation alphaEquation;
    private final GlStateManager.SourceFactor srcColorFactor;
    private final GlStateManager.DestFactor dstColorFactor;
    private final GlStateManager.SourceFactor srcAlphaFactor;
    private final GlStateManager.DestFactor dstAlphaFactor;
    public static final Codec<GlStateManager.SourceFactor> SOURCE_FACTOR_CODEC = EnumCodec.builder("Source Factor").values(GlStateManager.SourceFactor.class).build();
    public static final Codec<GlStateManager.DestFactor> DESTINATION_FACTOR_CODEC = EnumCodec.builder("Destination Factor").values(GlStateManager.DestFactor.class).build();
    public static final Codec<ShaderBlendMode> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(BlendEquation.CODEC.optionalFieldOf("func", BlendEquation.ADD).forGetter((v0) -> {
            return v0.colorEquation();
        }), BlendEquation.CODEC.optionalFieldOf("alphafunc", BlendEquation.ADD).forGetter((v0) -> {
            return v0.alphaEquation();
        }), SOURCE_FACTOR_CODEC.optionalFieldOf("srcrgb", GlStateManager.SourceFactor.ONE).forGetter((v0) -> {
            return v0.srcColorFactor();
        }), DESTINATION_FACTOR_CODEC.optionalFieldOf("dstrgb", GlStateManager.DestFactor.ZERO).forGetter((v0) -> {
            return v0.dstColorFactor();
        }), SOURCE_FACTOR_CODEC.optionalFieldOf("srcalpha", GlStateManager.SourceFactor.ONE).forGetter((v0) -> {
            return v0.srcAlphaFactor();
        }), DESTINATION_FACTOR_CODEC.optionalFieldOf("dstalpha", GlStateManager.DestFactor.ZERO).forGetter((v0) -> {
            return v0.dstAlphaFactor();
        })).apply(instance, ShaderBlendMode::new);
    });

    public ShaderBlendMode(BlendEquation colorEquation, BlendEquation alphaEquation, GlStateManager.SourceFactor srcColorFactor, GlStateManager.DestFactor dstColorFactor, GlStateManager.SourceFactor srcAlphaFactor, GlStateManager.DestFactor dstAlphaFactor) {
        this.colorEquation = colorEquation;
        this.alphaEquation = alphaEquation;
        this.srcColorFactor = srcColorFactor;
        this.dstColorFactor = dstColorFactor;
        this.srcAlphaFactor = srcAlphaFactor;
        this.dstAlphaFactor = dstAlphaFactor;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShaderBlendMode.class), ShaderBlendMode.class, "colorEquation;alphaEquation;srcColorFactor;dstColorFactor;srcAlphaFactor;dstAlphaFactor", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->colorEquation:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->alphaEquation:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->srcColorFactor:Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->dstColorFactor:Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->srcAlphaFactor:Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->dstAlphaFactor:Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShaderBlendMode.class), ShaderBlendMode.class, "colorEquation;alphaEquation;srcColorFactor;dstColorFactor;srcAlphaFactor;dstAlphaFactor", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->colorEquation:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->alphaEquation:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->srcColorFactor:Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->dstColorFactor:Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->srcAlphaFactor:Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->dstAlphaFactor:Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShaderBlendMode.class, Object.class), ShaderBlendMode.class, "colorEquation;alphaEquation;srcColorFactor;dstColorFactor;srcAlphaFactor;dstAlphaFactor", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->colorEquation:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->alphaEquation:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->srcColorFactor:Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->dstColorFactor:Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->srcAlphaFactor:Lcom/mojang/blaze3d/platform/GlStateManager$SourceFactor;", "FIELD:Lfoundry/veil/api/client/render/shader/program/ShaderBlendMode;->dstAlphaFactor:Lcom/mojang/blaze3d/platform/GlStateManager$DestFactor;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public BlendEquation colorEquation() {
        return this.colorEquation;
    }

    public BlendEquation alphaEquation() {
        return this.alphaEquation;
    }

    public GlStateManager.SourceFactor srcColorFactor() {
        return this.srcColorFactor;
    }

    public GlStateManager.DestFactor dstColorFactor() {
        return this.dstColorFactor;
    }

    public GlStateManager.SourceFactor srcAlphaFactor() {
        return this.srcAlphaFactor;
    }

    public GlStateManager.DestFactor dstAlphaFactor() {
        return this.dstAlphaFactor;
    }

    public void apply() {
        if (this.colorEquation != BlendEquation.ADD || this.alphaEquation != BlendEquation.ADD) {
            GL20C.glBlendEquationSeparate(this.colorEquation.getGlType(), this.alphaEquation.getGlType());
        }
        RenderSystem.blendFuncSeparate(this.srcColorFactor, this.dstColorFactor, this.srcAlphaFactor, this.dstAlphaFactor);
    }

    public boolean hasEquation() {
        return (this.colorEquation == BlendEquation.ADD && this.alphaEquation == BlendEquation.ADD) ? false : true;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/program/ShaderBlendMode$BlendEquation.class */
    public enum BlendEquation {
        ADD(32774),
        SUBTRACT(32778),
        REVERSE_SUBTRACT(32779),
        MIN(32775),
        MAX(32776);

        public static final Codec<BlendEquation> CODEC = EnumCodec.builder("Blend Equation").values(BlendEquation.class).build();
        private final int glType;

        BlendEquation(int glType) {
            this.glType = glType;
        }

        public int getGlType() {
            return this.glType;
        }
    }
}
