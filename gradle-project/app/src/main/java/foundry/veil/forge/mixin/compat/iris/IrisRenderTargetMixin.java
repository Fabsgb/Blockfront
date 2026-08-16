package foundry.veil.forge.mixin.compat.iris;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.blockfront.AbstractC0927qm;
import com.boehmod.blockfront.C0244ds;
import com.boehmod.blockfront.C0885px;
import com.boehmod.blockfront.C0994s;
import com.boehmod.blockfront.C1043sv;
import com.boehmod.blockfront.C1089to;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import foundry.veil.ext.iris.IrisRenderTargetExtension;
import net.irisshaders.iris.gl.texture.InternalTextureFormat;
import net.irisshaders.iris.gl.texture.PixelType;
import net.irisshaders.iris.targets.RenderTarget;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/iris/IrisRenderTargetMixin.class */
@Mixin({RenderTarget.class})
public abstract class IrisRenderTargetMixin implements IrisRenderTargetExtension {

    @Shadow(remap = false)
    private String name;

    @Shadow
    @Final
    private PixelType type;

    @Shadow(remap = false)
    public abstract int getMainTexture();

    @Shadow(remap = false)
    public abstract int getAltTexture();

    @Shadow(remap = false)
    public abstract int getWidth();

    @Shadow(remap = false)
    public abstract int getHeight();

    @Shadow
    public abstract InternalTextureFormat getInternalFormat();

    @Override // foundry.veil.ext.iris.IrisRenderTargetExtension
    public String veil$getName() {
        return this.name;
    }

    @Override // foundry.veil.ext.iris.IrisRenderTargetExtension
    public int veil$getMainTexture() {
        return getMainTexture();
    }

    @Override // foundry.veil.ext.iris.IrisRenderTargetExtension
    public int veil$getAltTexture() {
        return getAltTexture();
    }

    @Override // foundry.veil.ext.iris.IrisRenderTargetExtension
    public int veil$getWidth() {
        return getWidth();
    }

    @Override // foundry.veil.ext.iris.IrisRenderTargetExtension
    public int veil$getHeight() {
        return getHeight();
    }

    /* JADX INFO: renamed from: foundry.veil.forge.mixin.compat.iris.IrisRenderTargetMixin$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/iris/IrisRenderTargetMixin$1.class */
    static /* synthetic */ class C14411 {
        static final /* synthetic */ int[] $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat = new int[InternalTextureFormat.values().length];

        static {
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R8.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG8.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB8.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA8.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R8_SNORM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG8_SNORM.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB8_SNORM.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA8_SNORM.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R16.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG16.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB16.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA16.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R16_SNORM.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG16_SNORM.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB16_SNORM.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA16_SNORM.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R16F.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG16F.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB16F.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA16F.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R32F.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG32F.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB32F.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA32F.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R8I.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG8I.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB8I.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA8I.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R8UI.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG8UI.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB8UI.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA8UI.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R16I.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG16I.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB16I.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA16I.ordinal()] = 37;
            } catch (NoSuchFieldError e37) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R16UI.ordinal()] = 38;
            } catch (NoSuchFieldError e38) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG16UI.ordinal()] = 39;
            } catch (NoSuchFieldError e39) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB16UI.ordinal()] = 40;
            } catch (NoSuchFieldError e40) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA16UI.ordinal()] = 41;
            } catch (NoSuchFieldError e41) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R32I.ordinal()] = 42;
            } catch (NoSuchFieldError e42) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG32I.ordinal()] = 43;
            } catch (NoSuchFieldError e43) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB32I.ordinal()] = 44;
            } catch (NoSuchFieldError e44) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA32I.ordinal()] = 45;
            } catch (NoSuchFieldError e45) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R32UI.ordinal()] = 46;
            } catch (NoSuchFieldError e46) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RG32UI.ordinal()] = 47;
            } catch (NoSuchFieldError e47) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB32UI.ordinal()] = 48;
            } catch (NoSuchFieldError e48) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA32UI.ordinal()] = 49;
            } catch (NoSuchFieldError e49) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA2.ordinal()] = 50;
            } catch (NoSuchFieldError e50) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGBA4.ordinal()] = 51;
            } catch (NoSuchFieldError e51) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R3_G3_B2.ordinal()] = 52;
            } catch (NoSuchFieldError e52) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB5_A1.ordinal()] = 53;
            } catch (NoSuchFieldError e53) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB565.ordinal()] = 54;
            } catch (NoSuchFieldError e54) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB10_A2.ordinal()] = 55;
            } catch (NoSuchFieldError e55) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB10_A2UI.ordinal()] = 56;
            } catch (NoSuchFieldError e56) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.R11F_G11F_B10F.ordinal()] = 57;
            } catch (NoSuchFieldError e57) {
            }
            try {
                $SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[InternalTextureFormat.RGB9_E5.ordinal()] = 58;
            } catch (NoSuchFieldError e58) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // foundry.veil.ext.iris.IrisRenderTargetExtension
    public FramebufferAttachmentDefinition.Format veil$getFormat() throws MatchException {
        switch (C14411.$SwitchMap$net$irisshaders$iris$gl$texture$InternalTextureFormat[getInternalFormat().ordinal()]) {
            case 1:
                return FramebufferAttachmentDefinition.Format.RGBA;
            case 2:
                return FramebufferAttachmentDefinition.Format.R8;
            case 3:
                return FramebufferAttachmentDefinition.Format.RG8;
            case 4:
                return FramebufferAttachmentDefinition.Format.RGB8;
            case 5:
                return FramebufferAttachmentDefinition.Format.RGBA8;
            case 6:
                return FramebufferAttachmentDefinition.Format.R8_SNORM;
            case C0994s.f5462C /* 7 */:
                return FramebufferAttachmentDefinition.Format.RG8_SNORM;
            case 8:
                return FramebufferAttachmentDefinition.Format.RGB8_SNORM;
            case 9:
                return FramebufferAttachmentDefinition.Format.RGBA8_SNORM;
            case 10:
                return FramebufferAttachmentDefinition.Format.R16;
            case 11:
                return FramebufferAttachmentDefinition.Format.RG16;
            case 12:
                return FramebufferAttachmentDefinition.Format.RGB16;
            case C0885px.f4841pt /* 13 */:
                return FramebufferAttachmentDefinition.Format.RGBA16;
            case 14:
                return FramebufferAttachmentDefinition.Format.R16_SNORM;
            case 15:
                return FramebufferAttachmentDefinition.Format.RG16_SNORM;
            case 16:
                return FramebufferAttachmentDefinition.Format.RGB16_SNORM;
            case 17:
                return FramebufferAttachmentDefinition.Format.RGBA16_SNORM;
            case 18:
                return FramebufferAttachmentDefinition.Format.R16F;
            case 19:
                return FramebufferAttachmentDefinition.Format.RG16F;
            case 20:
                return FramebufferAttachmentDefinition.Format.RGB16F;
            case 21:
                return FramebufferAttachmentDefinition.Format.RGBA16F;
            case 22:
                return FramebufferAttachmentDefinition.Format.R32F;
            case C0885px.f4843pv /* 23 */:
                return FramebufferAttachmentDefinition.Format.RG32F;
            case 24:
                return FramebufferAttachmentDefinition.Format.RGB32F;
            case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                return FramebufferAttachmentDefinition.Format.RGBA32F;
            case 26:
                return FramebufferAttachmentDefinition.Format.R8I;
            case 27:
                return FramebufferAttachmentDefinition.Format.RG8I;
            case AbstractC0927qm.f5121pT /* 28 */:
                return FramebufferAttachmentDefinition.Format.RGB8I;
            case 29:
                return FramebufferAttachmentDefinition.Format.RGBA8I;
            case 30:
                return FramebufferAttachmentDefinition.Format.R8UI;
            case 31:
                return FramebufferAttachmentDefinition.Format.RG8UI;
            case 32:
                return FramebufferAttachmentDefinition.Format.RGB8UI;
            case 33:
                return FramebufferAttachmentDefinition.Format.RGBA8UI;
            case 34:
                return FramebufferAttachmentDefinition.Format.R16I;
            case C1043sv.f5687sk /* 35 */:
                return FramebufferAttachmentDefinition.Format.RG16I;
            case 36:
                return FramebufferAttachmentDefinition.Format.RGB16I;
            case C1089to.f5854tg /* 37 */:
                return FramebufferAttachmentDefinition.Format.RGBA16I;
            case 38:
                return FramebufferAttachmentDefinition.Format.R16UI;
            case 39:
                return FramebufferAttachmentDefinition.Format.RG16UI;
            case 40:
                return FramebufferAttachmentDefinition.Format.RGB16UI;
            case 41:
                return FramebufferAttachmentDefinition.Format.RGBA16UI;
            case 42:
                return FramebufferAttachmentDefinition.Format.R32I;
            case C1089to.f5856ti /* 43 */:
                return FramebufferAttachmentDefinition.Format.RG32I;
            case 44:
                return FramebufferAttachmentDefinition.Format.RGB32I;
            case 45:
                return FramebufferAttachmentDefinition.Format.RGBA32I;
            case 46:
                return FramebufferAttachmentDefinition.Format.R32UI;
            case 47:
                return FramebufferAttachmentDefinition.Format.RG32UI;
            case 48:
                return FramebufferAttachmentDefinition.Format.RGB32UI;
            case 49:
                return FramebufferAttachmentDefinition.Format.RGBA32UI;
            case 50:
                return FramebufferAttachmentDefinition.Format.RGBA2;
            case 51:
                return FramebufferAttachmentDefinition.Format.RGBA4;
            case 52:
                return FramebufferAttachmentDefinition.Format.R3_G3_B2;
            case 53:
                return FramebufferAttachmentDefinition.Format.RGB5_A1;
            case 54:
                return FramebufferAttachmentDefinition.Format.RGB565;
            case 55:
                return FramebufferAttachmentDefinition.Format.RGB10_A2;
            case C0244ds.f1990he /* 56 */:
                return FramebufferAttachmentDefinition.Format.RGB10_A2UI;
            case 57:
                return FramebufferAttachmentDefinition.Format.R11F_G11F_B10F;
            case 58:
                return FramebufferAttachmentDefinition.Format.RGB9_E5;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
