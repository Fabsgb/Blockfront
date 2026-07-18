package foundry.veil.impl.client.render.vertex;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.MeshData;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.ext.AutoStorageIndexBufferExtension;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBDirectStateAccess;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/vertex/DSAVertexArray.class */
@ApiStatus.Internal
public class DSAVertexArray extends VertexArray {
    public DSAVertexArray(int id) {
        super(id, vao -> {
            return new DSAVertexAttribBindingBuilder(vao, id);
        });
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArray
    public void uploadIndexBuffer(ByteBuffer data) {
        this.indexBuffer = null;
        int elementArrayBuffer = getOrCreateBuffer(1);
        ARBDirectStateAccess.glNamedBufferData(elementArrayBuffer, data, 35044);
        ARBDirectStateAccess.glVertexArrayElementBuffer(this.f8756id, elementArrayBuffer);
    }

    @Override // foundry.veil.api.client.render.vertex.VertexArray
    public void uploadIndexBuffer(MeshData.DrawState drawState) {
        this.indexBuffer = RenderSystem.getSequentialBuffer(drawState.mode());
        AutoStorageIndexBufferExtension ext = this.indexBuffer;
        ext.veil$ensureStorage(drawState.indexCount());
        ARBDirectStateAccess.glVertexArrayElementBuffer(this.f8756id, ext.veil$getBuffer());
    }
}
