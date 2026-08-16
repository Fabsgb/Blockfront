package foundry.veil.impl.client.render.dynamicbuffer;

import com.boehmod.blockfront.C0994s;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import foundry.veil.Veil;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.GlslInjectionPoint;
import io.github.ocelot.glslprocessor.api.GlslParser;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeList;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslAssignmentNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslOperationNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslInvokeFunctionNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferProcessor.class */
@ApiStatus.Internal
public class DynamicBufferProcessor implements ShaderPreProcessor {
    private static final String[] VECTOR_ELEMENTS = {".x", ".y", ".z", ".w"};
    private static final Set<String> BLOCK_SHADERS = Set.of("rendertype_solid", "rendertype_cutout", "rendertype_cutout_mipped", "rendertype_translucent");

    /* JADX WARN: Code duplicated, block: B:101:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:103:0x0562  */
    /* JADX WARN: Code duplicated, block: B:105:0x056b  */
    /* JADX WARN: Code duplicated, block: B:110:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:195:0x0a4f  */
    /* JADX WARN: Code duplicated, block: B:255:0x0843 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:43:0x0201  */
    /* JADX WARN: Code duplicated, block: B:46:0x0209  */
    /* JADX WARN: Code duplicated, block: B:48:0x0211  */
    /* JADX WARN: Code duplicated, block: B:51:0x0229  */
    /* JADX WARN: Code duplicated, block: B:53:0x0232  */
    /* JADX WARN: Code duplicated, block: B:55:0x0237  */
    /* JADX WARN: Code duplicated, block: B:57:0x0251  */
    /* JADX WARN: Code duplicated, block: B:58:0x0293  */
    /* JADX WARN: Code duplicated, block: B:60:0x02da  */
    /* JADX WARN: Code duplicated, block: B:62:0x02df  */
    /* JADX WARN: Code duplicated, block: B:63:0x0330  */
    /* JADX WARN: Code duplicated, block: B:65:0x0338  */
    /* JADX WARN: Code duplicated, block: B:68:0x0350  */
    /* JADX WARN: Code duplicated, block: B:70:0x0359  */
    /* JADX WARN: Code duplicated, block: B:76:0x037d  */
    /* JADX WARN: Code duplicated, block: B:77:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:79:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:81:0x0403  */
    /* JADX WARN: Code duplicated, block: B:82:0x0451 A[PHI: r23
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
    /* JADX WARN: Code duplicated, block: B:84:0x0459  */
    /* JADX WARN: Code duplicated, block: B:88:0x0477  */
    /* JADX WARN: Code duplicated, block: B:97:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:99:0x04de  */
    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws GlslSyntaxException, IOException, LexerException {
        String sourceName;
        String str;
        GlslNode expression;
        boolean z;
        boolean inVertex;
        Optional<GlslNewFieldNode> fieldOptional;
        DynamicBufferType[] types = DynamicBufferType.decode(ctx.activeBuffers());
        Map<String, GlslNode> markers = tree.getMarkers();
        GlslFunctionNode mainFunction = tree.mainFunction().orElseThrow();
        GlslNodeList mainFunctionBody = (GlslNodeList) Objects.requireNonNull(mainFunction.getBody());
        GlslNodeList treeBody = tree.getBody();
        GlslVersionStatement version = tree.getVersionStatement();
        if (version.getVersion() < 330) {
            version.setVersion(330);
        }
        version.setCore(true);
        GlslNode sampler = null;
        GlslNode lightmapUV = null;
        boolean blockLightmap = false;
        boolean injectLightmap = (markers.containsKey("veil:" + DynamicBufferType.LIGHT_COLOR.getName()) && markers.containsKey("veil:" + DynamicBufferType.LIGHT_UV.getName())) ? false : true;
        Map<String, Object> data = ctx.customProgramData();
        GlslNodeStringWriter writer = new GlslNodeStringWriter(true);
        boolean modified = false;
        if (ctx instanceof ShaderPreProcessor.MinecraftContext) {
            ShaderPreProcessor.MinecraftContext minecraftContext = (ShaderPreProcessor.MinecraftContext) ctx;
            VertexFormat vertexFormat = minecraftContext.vertexFormat();
            if (ctx.isVertex() && injectLightmap) {
                Optional<GlslNode> sampleLightmapOptional = mainFunction.stream().filter(node -> {
                    if (!(node instanceof GlslInvokeFunctionNode)) {
                        return false;
                    }
                    GlslInvokeFunctionNode invokeFunctionNode = (GlslInvokeFunctionNode) node;
                    if (invokeFunctionNode.getParameters().size() != 2) {
                        return false;
                    }
                    GlslNode patt0$temp = invokeFunctionNode.getHeader();
                    if (patt0$temp instanceof GlslVariableNode) {
                        GlslVariableNode variableNode = (GlslVariableNode) patt0$temp;
                        if ("minecraft_sample_lightmap".equals(variableNode.getName())) {
                            return true;
                        }
                    }
                    return false;
                }).findFirst();
                if (sampleLightmapOptional.isPresent()) {
                    List<GlslNode> parameters = ((GlslInvokeFunctionNode) sampleLightmapOptional.get()).getParameters();
                    sampler = parameters.get(0);
                    lightmapUV = parameters.get(1);
                    blockLightmap = true;
                } else if (vertexFormat.contains(VertexFormatElement.UV2)) {
                    Optional<GlslNode> texelFetchOptional = mainFunction.stream().filter(node2 -> {
                        if (!(node2 instanceof GlslInvokeFunctionNode)) {
                            return false;
                        }
                        GlslInvokeFunctionNode invokeFunctionNode = (GlslInvokeFunctionNode) node2;
                        if (invokeFunctionNode.getParameters().size() != 3) {
                            return false;
                        }
                        List<GlslNode> parameters2 = invokeFunctionNode.getParameters();
                        GlslNode patt0$temp = invokeFunctionNode.getHeader();
                        if (patt0$temp instanceof GlslVariableNode) {
                            GlslVariableNode functionName = (GlslVariableNode) patt0$temp;
                            if ("texelFetch".equals(functionName.getName())) {
                                Object patt1$temp = parameters2.get(1);
                                if (patt1$temp instanceof GlslOperationNode) {
                                    GlslOperationNode operation = (GlslOperationNode) patt1$temp;
                                    GlslNode patt2$temp = operation.getFirst();
                                    if (patt2$temp instanceof GlslVariableNode) {
                                        GlslVariableNode variableNode = (GlslVariableNode) patt2$temp;
                                        GlslNode patt3$temp = operation.getSecond();
                                        if (patt3$temp instanceof GlslConstantNode) {
                                            GlslConstantNode constantNode = (GlslConstantNode) patt3$temp;
                                            if (constantNode.intValue() == 16 && operation.getOperand() == GlslOperationNode.Operand.DIVIDE && vertexFormat.getElementName(VertexFormatElement.UV2).equals(variableNode.getName())) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return false;
                    }).findFirst();
                    if (texelFetchOptional.isPresent()) {
                        List<GlslNode> parameters2 = ((GlslInvokeFunctionNode) texelFetchOptional.get()).getParameters();
                        sampler = parameters2.get(0);
                        lightmapUV = ((GlslOperationNode) parameters2.get(1)).getFirst();
                    }
                }
            }
            for (int i = 0; i < types.length; i++) {
                DynamicBufferType type = types[i];
                String output = type.getOutputDeclaration(1 + i);
                String shaderName = minecraftContext.shaderInstance();
                if ("rendertype_lines".equals(shaderName)) {
                    if (type == DynamicBufferType.NORMAL && ctx.isFragment()) {
                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 0.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                    }
                    if (type == DynamicBufferType.ALBEDO) {
                        if (data.containsKey("mask")) {
                            z = false;
                        } else {
                            z = false;
                        }
                        inVertex = z;
                        if (!injectLightmap) {
                            if (type == DynamicBufferType.LIGHT_UV) {
                                if (!markers.containsKey("veil:" + DynamicBufferType.LIGHT_UV.getName())) {
                                    if (ctx.isVertex()) {
                                        if (lightmapUV != null) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec2 Pass" + type.getSourceName()));
                                            if (blockLightmap) {
                                                mainFunctionBody.add(GlslParser.parseExpression("vec2 veilTexCoord2 = clamp(" + lightmapUV.toSourceString() + " / 256.0, vec2(0.5 / 16.0), vec2(15.5 / 16.0))"));
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), new GlslVariableNode("veilTexCoord2"), GlslAssignmentNode.Operand.EQUAL));
                                            } else {
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("vec2(" + lightmapUV.toSourceString() + " / 256.0)"), GlslAssignmentNode.Operand.EQUAL));
                                            }
                                            modified = true;
                                            data.compute("mask", (s, o) -> {
                                                int iIntValue;
                                                if (o instanceof Integer) {
                                                    Integer val = (Integer) o;
                                                    iIntValue = val.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                return Integer.valueOf(iIntValue | type.getMask());
                                            });
                                        }
                                    } else if (inVertex) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec2 Pass" + type.getSourceName()));
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 0.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                    if (type == DynamicBufferType.NORMAL) {
                                        if (ctx.isFragment()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                        }
                                        if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                            if (ctx.isVertex()) {
                                                fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                                if (fieldOptional.isPresent()) {
                                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                                    modified = true;
                                                    data.compute("mask", (s2, o2) -> {
                                                        int iIntValue;
                                                        if (o2 instanceof Integer) {
                                                            Integer val = (Integer) o2;
                                                            iIntValue = val.intValue();
                                                        } else {
                                                            iIntValue = 0;
                                                        }
                                                        return Integer.valueOf(iIntValue | type.getMask());
                                                    });
                                                }
                                            } else if (ctx.isFragment()) {
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                                modified = true;
                                            }
                                        }
                                    }
                                    if (type != DynamicBufferType.ALBEDO) {
                                    }
                                }
                            } else if (type != DynamicBufferType.LIGHT_COLOR) {
                                if (!markers.containsKey("veil:" + DynamicBufferType.LIGHT_COLOR.getName())) {
                                    if (ctx.isVertex()) {
                                        if (lightmapUV != null) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                            if (blockLightmap) {
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("texture(" + sampler.toSourceString() + ", veilTexCoord2).rgb"), GlslAssignmentNode.Operand.EQUAL));
                                            } else {
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("texelFetch(" + sampler.toSourceString() + ", " + lightmapUV.toSourceString() + " / 16, 0).rgb"), GlslAssignmentNode.Operand.EQUAL));
                                            }
                                            modified = true;
                                            data.compute("mask", (s3, o3) -> {
                                                int iIntValue;
                                                if (o3 instanceof Integer) {
                                                    Integer val = (Integer) o3;
                                                    iIntValue = val.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                return Integer.valueOf(iIntValue | type.getMask());
                                            });
                                        }
                                    } else if (inVertex) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                    if (type == DynamicBufferType.NORMAL) {
                                        if (ctx.isFragment()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                        }
                                        if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                            if (ctx.isVertex()) {
                                                fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                                if (fieldOptional.isPresent()) {
                                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                                    modified = true;
                                                    data.compute("mask", (s4, o4) -> {
                                                        int iIntValue;
                                                        if (o4 instanceof Integer) {
                                                            Integer val = (Integer) o4;
                                                            iIntValue = val.intValue();
                                                        } else {
                                                            iIntValue = 0;
                                                        }
                                                        return Integer.valueOf(iIntValue | type.getMask());
                                                    });
                                                }
                                            } else if (ctx.isFragment()) {
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                                modified = true;
                                            }
                                        }
                                    }
                                    if (type != DynamicBufferType.ALBEDO) {
                                    }
                                }
                            } else {
                                if (type == DynamicBufferType.NORMAL) {
                                    if (ctx.isFragment()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                    if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                        if (ctx.isVertex()) {
                                            fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                            if (fieldOptional.isPresent()) {
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                                modified = true;
                                                data.compute("mask", (s5, o5) -> {
                                                    int iIntValue;
                                                    if (o5 instanceof Integer) {
                                                        Integer val = (Integer) o5;
                                                        iIntValue = val.intValue();
                                                    } else {
                                                        iIntValue = 0;
                                                    }
                                                    return Integer.valueOf(iIntValue | type.getMask());
                                                });
                                            }
                                        } else if (ctx.isFragment()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                        }
                                    }
                                }
                                if (type != DynamicBufferType.ALBEDO) {
                                }
                            }
                        } else {
                            if (type == DynamicBufferType.NORMAL) {
                                if (ctx.isFragment()) {
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                    modified = true;
                                }
                                if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                    if (ctx.isVertex()) {
                                        fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                        if (fieldOptional.isPresent()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                            data.compute("mask", (s6, o6) -> {
                                                int iIntValue;
                                                if (o6 instanceof Integer) {
                                                    Integer val = (Integer) o6;
                                                    iIntValue = val.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                return Integer.valueOf(iIntValue | type.getMask());
                                            });
                                        }
                                    } else if (ctx.isFragment()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                }
                            }
                            if (type != DynamicBufferType.ALBEDO) {
                            }
                        }
                    }
                } else {
                    if (data.containsKey("mask") || (((Integer) data.get("mask")).intValue() & type.getMask()) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    inVertex = z;
                    if (!injectLightmap) {
                        if (type == DynamicBufferType.LIGHT_UV) {
                            if (!markers.containsKey("veil:" + DynamicBufferType.LIGHT_UV.getName())) {
                                if (ctx.isVertex()) {
                                    if (lightmapUV != null) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec2 Pass" + type.getSourceName()));
                                        if (blockLightmap) {
                                            mainFunctionBody.add(GlslParser.parseExpression("vec2 veilTexCoord2 = clamp(" + lightmapUV.toSourceString() + " / 256.0, vec2(0.5 / 16.0), vec2(15.5 / 16.0))"));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), new GlslVariableNode("veilTexCoord2"), GlslAssignmentNode.Operand.EQUAL));
                                        } else {
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("vec2(" + lightmapUV.toSourceString() + " / 256.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        }
                                        modified = true;
                                        data.compute("mask", (s7, o7) -> {
                                            int iIntValue;
                                            if (o7 instanceof Integer) {
                                                Integer val = (Integer) o7;
                                                iIntValue = val.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            return Integer.valueOf(iIntValue | type.getMask());
                                        });
                                    }
                                } else if (inVertex) {
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec2 Pass" + type.getSourceName()));
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 0.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                    modified = true;
                                }
                                if (type == DynamicBufferType.NORMAL) {
                                    if (ctx.isFragment()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                    if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                        if (ctx.isVertex()) {
                                            fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                            if (fieldOptional.isPresent()) {
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                                modified = true;
                                                data.compute("mask", (s8, o8) -> {
                                                    int iIntValue;
                                                    if (o8 instanceof Integer) {
                                                        Integer val = (Integer) o8;
                                                        iIntValue = val.intValue();
                                                    } else {
                                                        iIntValue = 0;
                                                    }
                                                    return Integer.valueOf(iIntValue | type.getMask());
                                                });
                                            }
                                        } else if (ctx.isFragment()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                        }
                                    }
                                }
                                if (type != DynamicBufferType.ALBEDO) {
                                }
                            }
                        } else if (type != DynamicBufferType.LIGHT_COLOR) {
                            if (!markers.containsKey("veil:" + DynamicBufferType.LIGHT_COLOR.getName())) {
                                if (ctx.isVertex()) {
                                    if (lightmapUV != null && sampler != null) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                        if (blockLightmap) {
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("texture(" + sampler.toSourceString() + ", veilTexCoord2).rgb"), GlslAssignmentNode.Operand.EQUAL));
                                        } else {
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("texelFetch(" + sampler.toSourceString() + ", " + lightmapUV.toSourceString() + " / 16, 0).rgb"), GlslAssignmentNode.Operand.EQUAL));
                                        }
                                        modified = true;
                                        data.compute("mask", (s9, o9) -> {
                                            int iIntValue;
                                            if (o9 instanceof Integer) {
                                                Integer val = (Integer) o9;
                                                iIntValue = val.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            return Integer.valueOf(iIntValue | type.getMask());
                                        });
                                    }
                                } else if (inVertex) {
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                    modified = true;
                                }
                                if (type == DynamicBufferType.NORMAL) {
                                    if (ctx.isFragment()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                    if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                        if (ctx.isVertex()) {
                                            fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                            if (fieldOptional.isPresent()) {
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                                modified = true;
                                                data.compute("mask", (s10, o10) -> {
                                                    int iIntValue;
                                                    if (o10 instanceof Integer) {
                                                        Integer val = (Integer) o10;
                                                        iIntValue = val.intValue();
                                                    } else {
                                                        iIntValue = 0;
                                                    }
                                                    return Integer.valueOf(iIntValue | type.getMask());
                                                });
                                            }
                                        } else if (ctx.isFragment()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                        }
                                    }
                                }
                                if (type != DynamicBufferType.ALBEDO) {
                                }
                            }
                        } else {
                            if (type == DynamicBufferType.NORMAL) {
                                if (ctx.isFragment()) {
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                    modified = true;
                                }
                                if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                    if (ctx.isVertex()) {
                                        fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                        if (fieldOptional.isPresent()) {
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                            treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                            modified = true;
                                            data.compute("mask", (s11, o11) -> {
                                                int iIntValue;
                                                if (o11 instanceof Integer) {
                                                    Integer val = (Integer) o11;
                                                    iIntValue = val.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                return Integer.valueOf(iIntValue | type.getMask());
                                            });
                                        }
                                    } else if (ctx.isFragment()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                    }
                                }
                            }
                            if (type != DynamicBufferType.ALBEDO) {
                            }
                        }
                    } else {
                        if (type == DynamicBufferType.NORMAL && !markers.containsKey("veil:" + DynamicBufferType.NORMAL.getName())) {
                            if (ctx.isFragment() && ("particle".equals(shaderName) || "rendertype_leash".equals(shaderName) || "rendertype_text".equals(shaderName))) {
                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(0.0, 0.0, 1.0, 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                modified = true;
                            }
                            if (vertexFormat.contains(VertexFormatElement.NORMAL)) {
                                if (ctx.isVertex()) {
                                    fieldOptional = tree.field(vertexFormat.getElementName(VertexFormatElement.NORMAL));
                                    if (fieldOptional.isPresent()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("uniform mat3 NormalMat"));
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec3 Pass" + type.getSourceName()));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), GlslParser.parseExpression("NormalMat * " + fieldOptional.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                        data.compute("mask", (s12, o12) -> {
                                            int iIntValue;
                                            if (o12 instanceof Integer) {
                                                Integer val = (Integer) o12;
                                                iIntValue = val.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            return Integer.valueOf(iIntValue | type.getMask());
                                        });
                                    }
                                } else if (ctx.isFragment() && inVertex) {
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec3 Pass" + type.getSourceName()));
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression(output));
                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("vec4(Pass" + type.getSourceName() + ", 1.0)"), GlslAssignmentNode.Operand.EQUAL));
                                    modified = true;
                                }
                            }
                        }
                        if (type != DynamicBufferType.ALBEDO && !markers.containsKey("veil:" + DynamicBufferType.ALBEDO.getName())) {
                            if (ctx.isVertex()) {
                                if (BLOCK_SHADERS.contains(shaderName)) {
                                }
                                Optional<GlslNode> mixLightOptional = mainFunction.stream().filter(node3 -> {
                                    if (!(node3 instanceof GlslInvokeFunctionNode)) {
                                        return false;
                                    }
                                    GlslInvokeFunctionNode invokeFunctionNode = (GlslInvokeFunctionNode) node3;
                                    if (invokeFunctionNode.getParameters().size() != 4) {
                                        return false;
                                    }
                                    GlslNode patt0$temp = invokeFunctionNode.getHeader();
                                    if (patt0$temp instanceof GlslVariableNode) {
                                        GlslVariableNode variableNode = (GlslVariableNode) patt0$temp;
                                        if ("minecraft_mix_light".equals(variableNode.getName())) {
                                            return true;
                                        }
                                    }
                                    return false;
                                }).findFirst();
                                if (mixLightOptional.isPresent()) {
                                    GlslNode color = ((GlslInvokeFunctionNode) mixLightOptional.get()).getParameters().get(3);
                                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec4 Pass" + type.getSourceName()));
                                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), color, GlslAssignmentNode.Operand.EQUAL));
                                    modified = true;
                                    data.compute("mask", (s13, o13) -> {
                                        int iIntValue;
                                        if (o13 instanceof Integer) {
                                            Integer val = (Integer) o13;
                                            iIntValue = val.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        return Integer.valueOf(iIntValue | type.getMask());
                                    });
                                } else if (vertexFormat.contains(VertexFormatElement.COLOR)) {
                                    Optional<GlslNewFieldNode> fieldOptional2 = tree.field(vertexFormat.getElementName(VertexFormatElement.COLOR));
                                    if (fieldOptional2.isPresent()) {
                                        treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out vec4 Pass" + type.getSourceName()));
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode("Pass" + type.getSourceName()), new GlslVariableNode(fieldOptional2.get().getName()), GlslAssignmentNode.Operand.EQUAL));
                                        modified = true;
                                        data.compute("mask", (s14, o14) -> {
                                            int iIntValue;
                                            if (o14 instanceof Integer) {
                                                Integer val = (Integer) o14;
                                                iIntValue = val.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            return Integer.valueOf(iIntValue | type.getMask());
                                        });
                                    }
                                }
                            } else if (inVertex) {
                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in vec4 Pass" + type.getSourceName()));
                                treeBody.addFirst(GlslParser.parseExpression(output));
                                boolean hasColorModulator = tree.field("ColorModulator").isPresent();
                                boolean inserted = false;
                                for (int j = 0; j < mainFunctionBody.size(); j++) {
                                    Optional<GlslNode> textureOptional = mainFunctionBody.get(i).stream().filter(node4 -> {
                                        if (!(node4 instanceof GlslInvokeFunctionNode)) {
                                            return false;
                                        }
                                        GlslInvokeFunctionNode invokeFunctionNode = (GlslInvokeFunctionNode) node4;
                                        if (invokeFunctionNode.getParameters().size() != 2) {
                                            return false;
                                        }
                                        GlslNode patt0$temp = invokeFunctionNode.getHeader();
                                        if (patt0$temp instanceof GlslVariableNode) {
                                            GlslVariableNode variableNode = (GlslVariableNode) patt0$temp;
                                            if ("texture".equals(variableNode.getName())) {
                                                Object patt1$temp = invokeFunctionNode.getParameters().getFirst();
                                                if (patt1$temp instanceof GlslVariableNode) {
                                                    GlslVariableNode textureSampler = (GlslVariableNode) patt1$temp;
                                                    if ("Sampler0".equals(textureSampler.getName())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                        return false;
                                    }).findFirst();
                                    if (textureOptional.isPresent()) {
                                        if (hasColorModulator) {
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression(textureOptional.get().toSourceString() + " * ColorModulator * Pass" + type.getSourceName()), GlslAssignmentNode.Operand.EQUAL));
                                        } else {
                                            mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression(textureOptional.get().toSourceString() + " * Pass" + type.getSourceName()), GlslAssignmentNode.Operand.EQUAL));
                                        }
                                        inserted = true;
                                        break;
                                    }
                                }
                                if (!inserted) {
                                    if (hasColorModulator) {
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), GlslParser.parseExpression("Pass" + type.getSourceName() + " * ColorModulator"), GlslAssignmentNode.Operand.EQUAL));
                                    } else {
                                        mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(type.getSourceName()), new GlslVariableNode("Pass" + type.getSourceName()), GlslAssignmentNode.Operand.EQUAL));
                                    }
                                }
                                modified = true;
                            }
                        }
                    }
                }
            }
        }
        for (int i2 = 0; i2 < types.length; i2++) {
            DynamicBufferType bufferType = types[i2];
            String typeName = bufferType.getName();
            GlslTypeSpecifier.BuiltinType outType = bufferType.getType();
            GlslNode node5 = markers.get("veil:" + typeName);
            boolean vertexPassthrough = data.containsKey("passmask") && (((Integer) data.get("passmask")).intValue() & bufferType.getMask()) != 0;
            if (node5 == null) {
                if (vertexPassthrough) {
                    String sourceName2 = bufferType.getSourceName();
                    writer.clear();
                    writer.visitTypeSpecifier(outType);
                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("in " + String.valueOf(writer) + " Pass" + sourceName2));
                    treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("layout(location = " + (1 + i2) + ") out " + String.valueOf(writer) + " " + sourceName2));
                    mainFunctionBody.add((GlslNode) new GlslAssignmentNode(new GlslVariableNode(sourceName2), new GlslVariableNode("Pass" + sourceName2), GlslAssignmentNode.Operand.EQUAL));
                }
            } else {
                if (vertexPassthrough) {
                    throw new IOException("Node marked '#veil:" + typeName + "' in both vertex and fragment shader");
                }
                GlslSpecifiedType specifiedType = null;
                String copyName = null;
                List<GlslNode> body = null;
                int index = 0;
                if (node5 instanceof GlslNewFieldNode) {
                    GlslNewFieldNode newNode = (GlslNewFieldNode) node5;
                    Optional<GlslTree.GlslBlock> block = tree.containingBlock(newNode);
                    if (block.isPresent()) {
                        copyName = newNode.getName();
                        specifiedType = newNode.getType();
                        GlslTree.GlslBlock pair = block.get();
                        body = pair.body();
                        index = pair.index() + 1;
                    }
                } else if (node5 instanceof GlslAssignmentNode) {
                    GlslAssignmentNode assignmentNode = (GlslAssignmentNode) node5;
                    GlslNode first = assignmentNode.getFirst();
                    if (first instanceof GlslVariableNode) {
                        GlslVariableNode variableNode = (GlslVariableNode) first;
                        Optional<GlslTree.GlslBlock> block2 = tree.containingBlock(assignmentNode);
                        if (block2.isPresent()) {
                            copyName = variableNode.getName();
                            List<GlslNewFieldNode> fields = tree.searchField(copyName).toList();
                            if (fields.size() == 1) {
                                specifiedType = ((GlslNewFieldNode) fields.getFirst()).getType();
                                GlslTree.GlslBlock pair2 = block2.get();
                                body = pair2.body();
                                index = pair2.index() + 1;
                            }
                        }
                    }
                }
                if (copyName == null || specifiedType == null) {
                    Veil.LOGGER.warn("Invalid node marked '#veil:{}' in {} shader: {}", new Object[]{typeName, ctx.typeName(), ctx.name()});
                } else {
                    GlslTypeSpecifier specifier = specifiedType.getSpecifier();
                    if (specifier instanceof GlslTypeSpecifier.BuiltinType) {
                        GlslTypeSpecifier.BuiltinType nodeType = (GlslTypeSpecifier.BuiltinType) specifier;
                        if ((!nodeType.isPrimitive() && !nodeType.isVector()) || (!nodeType.isFloat() && !nodeType.isInteger() && !nodeType.isUnsignedInteger())) {
                            Veil.LOGGER.warn("Invalid node marked '#veil:{}' in {} shader: {}", new Object[]{typeName, ctx.typeName(), ctx.name()});
                        } else {
                            modified = true;
                            writer.clear();
                            writer.visitTypeSpecifier(outType);
                            if (ctx.isVertex()) {
                                sourceName = "Pass" + bufferType.getSourceName();
                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("out " + String.valueOf(writer) + " " + sourceName));
                                data.compute("passmask", (s15, o15) -> {
                                    int iIntValue;
                                    if (o15 instanceof Integer) {
                                        Integer val = (Integer) o15;
                                        iIntValue = val.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                    return Integer.valueOf(iIntValue | bufferType.getMask());
                                });
                            } else {
                                sourceName = bufferType.getSourceName();
                                treeBody.add(GlslInjectionPoint.BEFORE_MAIN, GlslParser.parseExpression("layout(location = " + (1 + i2) + ") out " + String.valueOf(writer) + " " + sourceName));
                            }
                            switch (C14551.f9157x94a8c387[outType.ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                    str = nodeType.isFloat() ? null : "float";
                                    break;
                                case 5:
                                case 6:
                                case C0994s.f5462C /* 7 */:
                                case 8:
                                    str = nodeType.isInteger() ? null : "int";
                                    break;
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                    str = nodeType.isUnsignedInteger() ? null : "uint";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            String cast = str;
                            if (nodeType == outType) {
                                expression = new GlslVariableNode(copyName);
                            } else if (nodeType.getComponents() < outType.getComponents()) {
                                StringBuilder builder = new StringBuilder(writer.toString()).append("(");
                                String padding = outType.getConstant(0.0d);
                                if (nodeType.getComponents() == 1) {
                                    builder.append(cast != null ? cast + "(" + copyName + "), " : copyName + ", ");
                                } else {
                                    for (int j2 = 0; j2 < nodeType.getComponents(); j2++) {
                                        builder.append(cast != null ? cast + "(" + copyName + VECTOR_ELEMENTS[j2] + "), " : copyName + VECTOR_ELEMENTS[j2] + ", ");
                                    }
                                }
                                for (int j3 = nodeType.getComponents(); j3 < 3; j3++) {
                                    builder.append(padding).append(", ");
                                }
                                builder.append(outType.getConstant(1.0d));
                                builder.append(')');
                                expression = GlslParser.parseExpression(builder.toString());
                            } else {
                                expression = GlslParser.parseExpression((cast != null ? writer.toString() : "") + "(" + copyName + ")");
                            }
                            body.add(index, new GlslAssignmentNode(new GlslVariableNode(sourceName), expression, GlslAssignmentNode.Operand.EQUAL));
                        }
                    } else {
                        Veil.LOGGER.warn("Invalid node marked '#veil:{}' in {} shader: {}", new Object[]{typeName, ctx.typeName(), ctx.name()});
                    }
                }
            }
        }
        if (modified && ctx.isFragment()) {
            tree.markOutputs();
        }
    }

    /* JADX INFO: renamed from: foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferProcessor$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferProcessor$1.class */
    static /* synthetic */ class C14551 {

        /* JADX INFO: renamed from: $SwitchMap$io$github$ocelot$glslprocessor$api$grammar$GlslTypeSpecifier$BuiltinType */
        static final /* synthetic */ int[] f9157x94a8c387 = new int[GlslTypeSpecifier.BuiltinType.values().length];

        static {
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.VEC2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.VEC3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.VEC4.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.IVEC2.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.IVEC3.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.IVEC4.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.UINT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.UVEC2.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.UVEC3.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f9157x94a8c387[GlslTypeSpecifier.BuiltinType.UVEC4.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }
}
