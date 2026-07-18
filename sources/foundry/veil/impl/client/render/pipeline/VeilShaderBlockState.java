package foundry.veil.impl.client.render.pipeline;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.impl.client.render.shader.block.ShaderBlockImpl;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.BitSet;
import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/VeilShaderBlockState.class */
@ApiStatus.Internal
public class VeilShaderBlockState {
    public static final int RESERVED_BINDINGS;
    private final ObjectSet<ShaderBlockImpl<?>> boundBlocks = new ObjectArraySet();
    private final BitSet usedBindings = new BitSet();
    private CharSequence[] shaderBindings = null;
    private int nextBinding;

    static {
        RESERVED_BINDINGS = Veil.platform().isModLoaded("flywheel") ? 8 : 0;
    }

    private void freeBinding() {
        ObjectIterator<ShaderBlockImpl<?>> iterator = this.boundBlocks.iterator();
        while (iterator.hasNext()) {
            ShaderBlockImpl<?> block = (ShaderBlockImpl) iterator.next();
            int index = block.getIndex();
            if (!this.usedBindings.get(index)) {
                if (index != -1) {
                    block.unbind(index + RESERVED_BINDINGS);
                    this.usedBindings.clear(index);
                    block.setIndex(-1);
                }
                iterator.remove();
                this.nextBinding = index;
                return;
            }
        }
        throw new IllegalStateException("Too many shader blocks bound, failed to find empty space.");
    }

    private int bind(ShaderBlock<?> block) {
        if (!(block instanceof ShaderBlockImpl)) {
            throw new UnsupportedOperationException("Cannot bind " + String.valueOf(block.getClass()));
        }
        ShaderBlockImpl<?> impl = (ShaderBlockImpl) block;
        int index = impl.getIndex();
        if (index == -1) {
            if (this.nextBinding >= VeilRenderSystem.maxUniformBuffersBindings() - RESERVED_BINDINGS) {
                freeBinding();
            }
            int i = this.nextBinding;
            index = i;
            impl.setIndex(i);
            this.nextBinding = this.usedBindings.nextClearBit(this.nextBinding + 1);
        }
        this.boundBlocks.add(impl);
        this.usedBindings.set(index);
        impl.bind(index + RESERVED_BINDINGS);
        return index;
    }

    public void bind(CharSequence name, ShaderBlock<?> block) {
        if (!(block instanceof ShaderBlockImpl)) {
            throw new UnsupportedOperationException("Cannot bind " + String.valueOf(block.getClass()));
        }
        ShaderBlockImpl<?> impl = (ShaderBlockImpl) block;
        int binding = bind(block);
        if (this.shaderBindings == null) {
            this.shaderBindings = new CharSequence[VeilRenderSystem.maxUniformBuffersBindings() - RESERVED_BINDINGS];
        }
        CharSequence boundName = this.shaderBindings[binding];
        if (!Objects.equals(name, boundName)) {
            this.shaderBindings[binding] = name;
            VeilRenderSystem.renderer().getShaderManager().setGlobal(shader -> {
                switch (impl.getBinding()) {
                    case UNIFORM:
                        shader.setUniformBlock(name, binding + RESERVED_BINDINGS);
                        break;
                    case SHADER_STORAGE:
                        shader.setStorageBlock(name, binding + RESERVED_BINDINGS);
                        break;
                }
            });
        }
    }

    public void unbind(ShaderBlock<?> block) {
        CharSequence name;
        if (!(block instanceof ShaderBlockImpl)) {
            throw new UnsupportedOperationException("Cannot unbind " + String.valueOf(block.getClass()));
        }
        ShaderBlockImpl<?> impl = (ShaderBlockImpl) block;
        int index = impl.getIndex();
        if (index == -1) {
            return;
        }
        impl.unbind(index + RESERVED_BINDINGS);
        this.boundBlocks.remove(impl);
        this.usedBindings.clear(index);
        impl.setIndex(-1);
        if (this.shaderBindings != null && (name = this.shaderBindings[index]) != null) {
            this.shaderBindings[index] = null;
            VeilRenderSystem.renderer().getShaderManager().setGlobal(shader -> {
                switch (impl.getBinding()) {
                    case UNIFORM:
                        shader.setUniformBlock(name, 0);
                        break;
                    case SHADER_STORAGE:
                        shader.setStorageBlock(name, 0);
                        break;
                }
            });
        }
        if (index < this.nextBinding) {
            this.nextBinding = index;
        }
    }

    public void onShaderCompile() {
        this.shaderBindings = null;
    }

    public void clearUsedBindings() {
        this.usedBindings.clear();
    }
}
