package foundry.veil.impl.client.render.dynamicbuffer;

import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import java.util.Set;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferProcessor.class */
@ApiStatus.Internal
public class DynamicBufferProcessor implements ShaderPreProcessor {
    private static final String[] VECTOR_ELEMENTS = {".x", ".y", ".z", ".w"};
    private static final Set<String> BLOCK_SHADERS = Set.of("rendertype_solid", "rendertype_cutout", "rendertype_cutout_mipped", "rendertype_translucent");

    /* JADX WARN: Removed duplicated region for block: B:110:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0a4f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0843 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0451 A[PHI: r23
  0x0451: PHI (r23v6 'modified' boolean) = 
  (r23v5 'modified' boolean)
  (r23v5 'modified' boolean)
  (r23v5 'modified' boolean)
  (r23v15 'modified' boolean)
  (r23v5 'modified' boolean)
  (r23v5 'modified' boolean)
  (r23v16 'modified' boolean)
  (r23v5 'modified' boolean)
  (r23v17 'modified' boolean)
  (r23v5 'modified' boolean)
  (r23v18 'modified' boolean)
 binds: [B:45:0x0206, B:64:0x0335, B:80:0x0400, B:81:0x0403, B:71:0x035b, B:73:0x0360, B:78:0x03e7, B:61:0x02dc, B:62:0x02df, B:54:0x0234, B:59:0x02c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x04d5  */
    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void modify(foundry.veil.api.client.render.shader.processor.ShaderPreProcessor.Context r9, io.github.ocelot.glslprocessor.api.node.GlslTree r10) throws io.github.ocelot.glslprocessor.api.GlslSyntaxException, java.io.IOException, io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException {
        /*
            Method dump skipped, instruction units count: 3235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor.modify(foundry.veil.api.client.render.shader.processor.ShaderPreProcessor$Context, io.github.ocelot.glslprocessor.api.node.GlslTree):void");
    }

    /* JADX INFO: renamed from: foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferProcessor$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType = new int[GlslTypeSpecifier.BuiltinType.values().length];

        static {
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.VEC2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.VEC3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.VEC4.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.IVEC2.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.IVEC3.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.IVEC4.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.UINT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.UVEC2.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.UVEC3.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType[GlslTypeSpecifier.BuiltinType.UVEC4.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }
}
