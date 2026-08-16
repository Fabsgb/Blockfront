package foundry.veil.api.client.render.vertex;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.util.Arrays;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/vertex/VeilVertexFormat.class */
public class VeilVertexFormat {
    public static final VertexFormatElement BONE_INDEX = register(0, VertexFormatElement.Type.USHORT, VertexFormatElement.Usage.GENERIC, 1);
    public static final VertexFormat SKINNED_MESH = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("Color", VertexFormatElement.COLOR).add("UV0", VertexFormatElement.UV0).add("UV1", VertexFormatElement.UV1).add("UV2", VertexFormatElement.UV2).add("Normal", VertexFormatElement.NORMAL).add("BoneIndex", BONE_INDEX).build();
    public static final VertexFormat QUASAR_PARTICLE = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("Normal", VertexFormatElement.NORMAL).build();

    public static VertexFormatElement register(int index, VertexFormatElement.Type type, VertexFormatElement.Usage usage, int count) {
        for (int i = 0; i < VertexFormatElement.BY_ID.length; i++) {
            if (VertexFormatElement.BY_ID[i] == null) {
                return VertexFormatElement.register(i, index, type, usage, count);
            }
        }
        VertexFormatElement.BY_ID = (VertexFormatElement[]) Arrays.copyOf(VertexFormatElement.BY_ID, VertexFormatElement.BY_ID.length + 1);
        return VertexFormatElement.register(VertexFormatElement.BY_ID.length - 2, index, type, usage, count);
    }
}
