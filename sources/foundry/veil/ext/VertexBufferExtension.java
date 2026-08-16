package foundry.veil.ext;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/VertexBufferExtension.class */
@ApiStatus.Internal
public interface VertexBufferExtension {
    void veil$drawInstanced(int i);

    void veil$drawIndirect(long j, int i, int i2);

    int veil$getIndexCount();
}
