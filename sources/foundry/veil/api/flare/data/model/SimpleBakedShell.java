package foundry.veil.api.flare.data.model;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.flare.model.BakedShell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/data/model/SimpleBakedShell.class */
public class SimpleBakedShell implements BakedShell {
    protected final List<FlareBakedQuad> faces;
    private VertexArray vertexArray;

    public SimpleBakedShell(List<FlareBakedQuad> faces) {
        this.faces = Collections.unmodifiableList(faces);
    }

    @Override // foundry.veil.api.flare.model.BakedShell
    public List<FlareBakedQuad> getQuads() {
        return this.faces;
    }

    @Override // foundry.veil.api.flare.model.BakedShell
    public VertexArray getVertexArray() {
        if (this.vertexArray == null) {
            VertexConsumer vertexConsumerBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.BLOCK);
            for (FlareBakedQuad quad : this.faces) {
                quad.putBakedQuadInto(vertexConsumerBegin);
            }
            this.vertexArray = VertexArray.create();
            this.vertexArray.upload(vertexConsumerBegin.buildOrThrow(), VertexArray.DrawUsage.STATIC);
        }
        return this.vertexArray;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void free() {
        if (this.vertexArray != null) {
            this.vertexArray.free();
            this.vertexArray = null;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/data/model/SimpleBakedShell$Builder.class */
    public static class Builder {
        protected final List<FlareBakedQuad> faces = new ArrayList();

        public Builder addFace(FlareBakedQuad face) {
            this.faces.add(face);
            return this;
        }

        public SimpleBakedShell build() {
            return new SimpleBakedShell(this.faces);
        }
    }
}
