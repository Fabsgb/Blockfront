package foundry.veil.impl.compat.sodium;

import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.api.compat.IrisCompat;
import io.github.ocelot.glslprocessor.api.GlslInjectionPoint;
import io.github.ocelot.glslprocessor.api.GlslParser;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeList;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/compat/sodium/SodiumShaderPreProcessor.class */
@ApiStatus.Internal
public class SodiumShaderPreProcessor implements ShaderPreProcessor {
    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        int activeBuffers = ctx.activeBuffers();
        if (activeBuffers == 0) {
            return;
        }
        DynamicBufferType[] buffers = DynamicBufferType.decode(activeBuffers);
        List<GlslNode> mainBody = (List) Objects.requireNonNull(tree.mainFunction().orElseThrow().getBody());
        GlslNodeList treeBody = tree.getBody();
        boolean iris = IrisCompat.INSTANCE != null && IrisCompat.INSTANCE.areShadersLoaded();
        GlslNodeStringWriter writer = new GlslNodeStringWriter(true);
        boolean modified = false;
        if (ctx.isVertex() && !iris) {
            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("layout(location = 4) in uvec4 a_VeilNormal"));
            modified = true;
        }
        for (int i = 0; i < buffers.length; i++) {
            DynamicBufferType type = buffers[i];
            String sourceName = type.getSourceName();
            writer.clear();
            writer.visitTypeSpecifier(type.getType());
            String output = "layout(location = " + (1 + i) + ") out " + String.valueOf(writer) + " " + sourceName;
            switch (type) {
                case ALBEDO:
                    if (ctx.isVertex()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec4 PassVeilVertexColor"));
                        mainBody.add(GlslParser.parseExpression("PassVeilVertexColor = _vert_color"));
                        modified = true;
                    }
                    if (ctx.isFragment()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec4 PassVeilVertexColor"));
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                        mainBody.add(1, GlslParser.parseExpression(sourceName + " = texture(u_BlockTex, v_TexCoord, lodBias) * PassVeilVertexColor"));
                        modified = true;
                    }
                    break;
                case NORMAL:
                    if (ctx.isVertex()) {
                        if (!iris) {
                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 VeilNormalMatrix"));
                        }
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 PassVeilNormal"));
                        Object[] objArr = new Object[2];
                        objArr[0] = iris ? "iris_NormalMatrix" : "VeilNormalMatrix";
                        objArr[1] = iris ? "iris_Normal" : "(vec3(ivec3(a_VeilNormal.xyz)) * 0.007874016)";
                        mainBody.add(GlslParser.parseExpression("PassVeilNormal = %s * %s".formatted(objArr)));
                        modified = true;
                    }
                    if (ctx.isFragment()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 PassVeilNormal"));
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                        mainBody.add(GlslParser.parseExpression(sourceName + " = vec4(PassVeilNormal, 1.0)"));
                        modified = true;
                    }
                    break;
                case LIGHT_UV:
                    if (ctx.isVertex()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec2 PassVeilLightUV"));
                        mainBody.add(GlslParser.parseExpression("PassVeilLightUV = _vert_tex_light_coord"));
                        modified = true;
                    }
                    if (ctx.isFragment()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec2 PassVeilLightUV"));
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                        mainBody.add(GlslParser.parseExpression(sourceName + " = vec4(PassVeilLightUV, 0.0, 1.0)"));
                        modified = true;
                    }
                    break;
                case LIGHT_COLOR:
                    if (ctx.isVertex()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 PassVeilLightColor"));
                        mainBody.add(GlslParser.parseExpression("PassVeilLightColor = texture(u_LightTex, _vert_tex_light_coord).rgb"));
                        modified = true;
                    }
                    if (ctx.isFragment()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 PassVeilLightColor"));
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                        mainBody.add(GlslParser.parseExpression(sourceName + " = vec4(PassVeilLightColor, 1.0)"));
                        modified = true;
                    }
                    break;
            }
        }
        if (modified && ctx.isFragment()) {
            tree.markOutputs();
        }
    }
}
