package foundry.veil.api.client.render.shader.processor;

import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/processor/ShaderMultiProcessor.class */
public final class ShaderMultiProcessor extends Record implements ShaderPreProcessor {
    private final ShaderPreProcessor[] processors;

    public ShaderMultiProcessor(ShaderPreProcessor[] processors) {
        this.processors = processors;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShaderMultiProcessor.class), ShaderMultiProcessor.class, "processors", "FIELD:Lfoundry/veil/api/client/render/shader/processor/ShaderMultiProcessor;->processors:[Lfoundry/veil/api/client/render/shader/processor/ShaderPreProcessor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShaderMultiProcessor.class), ShaderMultiProcessor.class, "processors", "FIELD:Lfoundry/veil/api/client/render/shader/processor/ShaderMultiProcessor;->processors:[Lfoundry/veil/api/client/render/shader/processor/ShaderPreProcessor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShaderMultiProcessor.class, Object.class), ShaderMultiProcessor.class, "processors", "FIELD:Lfoundry/veil/api/client/render/shader/processor/ShaderMultiProcessor;->processors:[Lfoundry/veil/api/client/render/shader/processor/ShaderPreProcessor;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ShaderPreProcessor[] processors() {
        return this.processors;
    }

    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void prepare() {
        for (ShaderPreProcessor processor : this.processors) {
            processor.prepare();
        }
    }

    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        for (ShaderPreProcessor preProcessor : this.processors) {
            preProcessor.modify(ctx, tree);
        }
    }
}
