package foundry.veil.api.client.render.shader.block;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/block/DynamicShaderBlock.class */
public interface DynamicShaderBlock<T> extends ShaderBlock<T> {
    int getSize();

    void setSize(int i);
}
