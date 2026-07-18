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

    /* JADX WARN: Removed duplicated region for block: B:317:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0451 A[PHI: r23
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
 binds: [B:324:0x0206, B:343:0x0335, B:359:0x0400, B:360:0x0403, B:350:0x035b, B:352:0x0360, B:357:0x03e7, B:340:0x02dc, B:341:0x02df, B:333:0x0234, B:338:0x02c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0a4f  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0843 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
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

    /* JADX INFO: renamed from: foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferProcessor$1.class */
    static /* synthetic */ class C14291 {

        /* JADX INFO: renamed from: $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType */
        static final /* synthetic */ int[] f8771x94a8c387 = new int[GlslTypeSpecifier.BuiltinType.values().length];

        static {
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.VEC2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.VEC3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.VEC4.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.IVEC2.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.IVEC3.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.IVEC4.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.UINT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.UVEC2.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.UVEC3.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f8771x94a8c387[GlslTypeSpecifier.BuiltinType.UVEC4.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }
}
