package foundry.veil.forge.compat.sodium;

import foundry.veil.ext.sodium.ChunkVertexEncoderVertexExtension;
import net.caffeinemc.mods.sodium.api.util.ColorARGB;
import net.caffeinemc.mods.sodium.client.gl.attribute.GlVertexAttributeFormat;
import net.caffeinemc.mods.sodium.client.gl.attribute.GlVertexFormat;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexEncoder;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexType;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.impl.DefaultChunkMeshAttributes;
import net.caffeinemc.mods.sodium.client.render.vertex.VertexFormatAttribute;
import net.minecraft.util.Mth;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/compat/sodium/VeilChunkVertex.class */
public class VeilChunkVertex implements ChunkVertexType {
    public static final int STRIDE = 24;
    public static final GlVertexFormat VERTEX_FORMAT = GlVertexFormat.builder(24).addElement(DefaultChunkMeshAttributes.POSITION, 0, 0).addElement(DefaultChunkMeshAttributes.COLOR, 1, 8).addElement(DefaultChunkMeshAttributes.TEXTURE, 2, 12).addElement(DefaultChunkMeshAttributes.LIGHT_MATERIAL_INDEX, 3, 16).addElement(new VertexFormatAttribute("NORMAL_INDEX", GlVertexAttributeFormat.BYTE, 4, false, true), 4, 20).build();
    private static final int POSITION_MAX_VALUE = 1048576;
    private static final int TEXTURE_MAX_VALUE = 32768;
    private static final float MODEL_ORIGIN = 8.0f;
    private static final float MODEL_RANGE = 32.0f;

    public GlVertexFormat getVertexFormat() {
        return VERTEX_FORMAT;
    }

    public ChunkVertexEncoder getEncoder() {
        return (ptr, materialBits, vertices, section) -> {
            float texCentroidU = 0.0f;
            float texCentroidV = 0.0f;
            for (ChunkVertexEncoder.Vertex vertex : vertices) {
                texCentroidU += vertex.u;
                texCentroidV += vertex.v;
            }
            float texCentroidU2 = texCentroidU * 0.25f;
            float texCentroidV2 = texCentroidV * 0.25f;
            for (int i = 0; i < 4; i++) {
                ChunkVertexEncoder.Vertex vertex2 = vertices[i];
                int x = quantizePosition(vertex2.x);
                int y = quantizePosition(vertex2.y);
                int z = quantizePosition(vertex2.z);
                int u = encodeTexture(texCentroidU2, vertex2.u);
                int v = encodeTexture(texCentroidV2, vertex2.v);
                int light = encodeLight(vertex2.light);
                MemoryUtil.memPutInt(ptr, packPositionHi(x, y, z));
                MemoryUtil.memPutInt(ptr + 4, packPositionLo(x, y, z));
                MemoryUtil.memPutInt(ptr + 8, ColorARGB.mulRGB(vertex2.color, vertex2.ao));
                MemoryUtil.memPutInt(ptr + 12, packTexture(u, v));
                MemoryUtil.memPutInt(ptr + 16, packLightAndData(light, materialBits, section));
                ChunkVertexEncoderVertexExtension ext = (ChunkVertexEncoderVertexExtension) vertex2;
                MemoryUtil.memPutInt(ptr + 20, ext.veil$getPackedNormal());
                ptr += 24;
            }
            return ptr;
        };
    }

    private static int packPositionHi(int x, int y, int z) {
        return ((x >>> 10) & 1023) | (((y >>> 10) & 1023) << 10) | (((z >>> 10) & 1023) << 20);
    }

    private static int packPositionLo(int x, int y, int z) {
        return (x & 1023) | ((y & 1023) << 10) | ((z & 1023) << 20);
    }

    private static int quantizePosition(float position) {
        return ((int) (normalizePosition(position) * 1048576.0f)) & 1048575;
    }

    private static float normalizePosition(float v) {
        return (8.0f + v) / MODEL_RANGE;
    }

    private static int packTexture(int u, int v) {
        return (u & 65535) | ((v & 65535) << 16);
    }

    private static int encodeTexture(float center, float x) {
        int bias = x < center ? 1 : -1;
        int quantized = floorInt(x * 32768.0f) + bias;
        return (quantized & 32767) | (sign(bias) << 15);
    }

    private static int encodeLight(int light) {
        int sky = Mth.clamp((light >>> 16) & 255, 8, 248);
        int block = Mth.clamp(light & 255, 8, 248);
        return block | (sky << 8);
    }

    private static int packLightAndData(int light, int material, int section) {
        return (light & 65535) | ((material & 255) << 16) | ((section & 255) << 24);
    }

    private static int sign(int x) {
        return x >>> 31;
    }

    private static int floorInt(float x) {
        return (int) Math.floor(x);
    }
}
