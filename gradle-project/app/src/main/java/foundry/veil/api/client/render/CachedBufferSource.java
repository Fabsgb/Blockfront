package foundry.veil.api.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/CachedBufferSource.class */
public class CachedBufferSource implements MultiBufferSource, NativeResource {
    private final Object2ObjectMap<RenderType, ByteBufferBuilder> buffers = new Object2ObjectArrayMap();
    private final Object2ObjectMap<RenderType, BufferBuilder> startedBuilders = new Object2ObjectArrayMap();

    @Nullable
    private RenderType lastSharedType;

    private void clearBuffers() {
        this.buffers.values().forEach((v0) -> {
            v0.close();
        });
        this.buffers.clear();
    }

    @NotNull
    public VertexConsumer getBuffer(@NotNull RenderType renderType) {
        BufferBuilder last = (BufferBuilder) this.startedBuilders.get(renderType);
        if (last != null && !renderType.canConsolidateConsecutiveGeometry()) {
            endBatch(renderType, last);
            last = null;
        }
        if (last != null) {
            return last;
        }
        ByteBufferBuilder bytebufferbuilder = (ByteBufferBuilder) this.buffers.computeIfAbsent(renderType, unused -> {
            return new ByteBufferBuilder(renderType.bufferSize());
        });
        BufferBuilder builder = new BufferBuilder(bytebufferbuilder, renderType.mode(), renderType.format());
        this.startedBuilders.put(renderType, builder);
        return builder;
    }

    public void free() {
        clearBuffers();
        this.startedBuilders.clear();
        this.lastSharedType = null;
    }

    public void endLastBatch() {
        if (this.lastSharedType != null) {
            endBatch(this.lastSharedType);
            this.lastSharedType = null;
        }
    }

    public void endBatch() {
        endLastBatch();
        ObjectIterator it = this.buffers.keySet().iterator();
        while (it.hasNext()) {
            RenderType rendertype = (RenderType) it.next();
            endBatch(rendertype);
        }
        clearBuffers();
    }

    public void endBatch(RenderType renderType) {
        BufferBuilder bufferbuilder = (BufferBuilder) this.startedBuilders.remove(renderType);
        if (bufferbuilder != null) {
            endBatch(renderType, bufferbuilder);
        }
    }

    private void endBatch(RenderType renderType, BufferBuilder builder) {
        MeshData meshdata = builder.build();
        if (meshdata != null) {
            if (renderType.sortOnUpload()) {
                ByteBufferBuilder bytebufferbuilder = (ByteBufferBuilder) this.buffers.computeIfAbsent(renderType, unused -> {
                    return new ByteBufferBuilder(renderType.bufferSize());
                });
                meshdata.sortQuads(bytebufferbuilder, RenderSystem.getVertexSorting());
            }
            renderType.draw(meshdata);
        }
        if (renderType.equals(this.lastSharedType)) {
            this.lastSharedType = null;
        }
    }
}
