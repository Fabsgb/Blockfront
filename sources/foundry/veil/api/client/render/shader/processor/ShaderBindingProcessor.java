package foundry.veil.api.client.render.shader.processor;

import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderBindingProcessor.class */
public class ShaderBindingProcessor implements ShaderPreProcessor {
    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        if (tree.getVersionStatement().getVersion() >= 420 || !(ctx instanceof ShaderPreProcessor.VeilContext)) {
            return;
        }
        ShaderPreProcessor.VeilContext veilContext = (ShaderPreProcessor.VeilContext) ctx;
        tree.fields().forEach(node -> {
            String string;
            GlslSpecifiedType type = node.getType();
            if (type.getSpecifier() == GlslTypeSpecifier.BuiltinType.ATOMIC_UINT) {
                return;
            }
            ListIterator<GlslTypeQualifier> qualifierIterator = type.getQualifiers().listIterator();
            while (qualifierIterator.hasNext()) {
                GlslTypeQualifier qualifier = qualifierIterator.next();
                if (qualifier instanceof GlslTypeQualifier.Layout) {
                    GlslTypeQualifier.Layout $b$0 = (GlslTypeQualifier.Layout) qualifier;
                    try {
                        List<GlslTypeQualifier.LayoutId> listLayoutIds = $b$0.layoutIds();
                        List<GlslTypeQualifier.LayoutId> layoutIds = new ArrayList<>(listLayoutIds);
                        Iterator<GlslTypeQualifier.LayoutId> layoutIdIterator = layoutIds.iterator();
                        while (layoutIdIterator.hasNext()) {
                            GlslTypeQualifier.LayoutId layoutId = layoutIdIterator.next();
                            if ("binding".equals(layoutId.identifier())) {
                                GlslNode patt2$temp = layoutId.expression();
                                if (patt2$temp instanceof GlslConstantNode) {
                                    GlslConstantNode constantNode = (GlslConstantNode) patt2$temp;
                                    if (node.getName() != null) {
                                        string = node.getName();
                                    } else {
                                        GlslNodeStringWriter writer = new GlslNodeStringWriter(true);
                                        writer.visitSpecifiedType(type);
                                        string = writer.toString();
                                    }
                                    String name = string;
                                    veilContext.addUniformBinding(name, constantNode.intValue());
                                    layoutIdIterator.remove();
                                }
                            }
                        }
                        if (layoutIds.size() != listLayoutIds.size()) {
                            if (layoutIds.isEmpty()) {
                                qualifierIterator.remove();
                            } else {
                                qualifierIterator.set(GlslTypeQualifier.layout(layoutIds));
                            }
                        }
                    } catch (Throwable th) {
                        throw new MatchException(th.toString(), th);
                    }
                }
            }
        });
    }
}
