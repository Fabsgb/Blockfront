package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import foundry.veil.api.client.util.VertexFormatCodec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData.class */
public final class CompositeRenderTypeData extends Record {
    private final VertexFormat format;
    private final VertexFormat.Mode mode;
    private final int bufferSize;
    private final boolean affectsCrumbling;
    private final boolean sort;
    private final boolean outline;
    private final List<RenderTypeLayer[]> layers;
    private static final Codec<List<List<RenderTypeLayer>>> LAYER_CODEC = Codec.withAlternative(RenderTypeLayer.CODEC.listOf().listOf().flatXmap(list -> {
        return list.size() < 2 ? DataResult.error(() -> {
            return "Expected at least 2 layers";
        }) : DataResult.success(list);
    }, list2 -> {
        return list2.size() < 2 ? DataResult.error(() -> {
            return "Expected at least 2 layers";
        }) : DataResult.success(list2);
    }), RenderTypeLayer.CODEC.listOf().flatXmap(layers -> {
        return DataResult.success(Collections.singletonList(layers));
    }, list3 -> {
        return list3.size() == 1 ? DataResult.success((List) list3.getFirst()) : DataResult.error(() -> {
            return "Expected 1 shard";
        });
    })).flatXmap(list4 -> {
        return list4.isEmpty() ? DataResult.error(() -> {
            return "Expected at least 1 layer";
        }) : DataResult.success(list4);
    }, list5 -> {
        return list5.isEmpty() ? DataResult.error(() -> {
            return "Expected at least 1 layer";
        }) : DataResult.success(list5);
    });
    public static final Codec<CompositeRenderTypeData> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(VertexFormatCodec.CODEC.fieldOf("format").forGetter((v0) -> {
            return v0.format();
        }), VertexFormatCodec.MODE_CODEC.fieldOf("mode").forGetter((v0) -> {
            return v0.mode();
        }), VertexFormatCodec.BUFFER_SIZE_CODEC.fieldOf("bufferSize").forGetter((v0) -> {
            return v0.bufferSize();
        }), Codec.BOOL.optionalFieldOf("affectsCrumbling", false).forGetter((v0) -> {
            return v0.sort();
        }), Codec.BOOL.optionalFieldOf("sort", false).forGetter((v0) -> {
            return v0.sort();
        }), Codec.BOOL.optionalFieldOf("outline", false).forGetter((v0) -> {
            return v0.outline();
        }), LAYER_CODEC.fieldOf("layers").forGetter(state -> {
            return state.layers().stream().map((v0) -> {
                return Arrays.asList(v0);
            }).toList();
        })).apply(instance, (format, mode, bufferSize, affectsCrumbling, sort, outline, layersList) -> {
            List<RenderTypeLayer[]> layers = new ArrayList<>(layersList.size());
            Iterator it = layersList.iterator();
            while (it.hasNext()) {
                List<RenderTypeLayer> shards = (List) it.next();
                layers.add((RenderTypeLayer[]) shards.toArray(x$0 -> {
                    return new RenderTypeLayer[x$0];
                }));
            }
            return new CompositeRenderTypeData(format, mode, bufferSize.intValue(), affectsCrumbling.booleanValue(), sort.booleanValue(), outline.booleanValue(), Collections.unmodifiableList(layers));
        });
    });

    public CompositeRenderTypeData(VertexFormat format, VertexFormat.Mode mode, int bufferSize, boolean affectsCrumbling, boolean sort, boolean outline, List<RenderTypeLayer[]> layers) {
        this.format = format;
        this.mode = mode;
        this.bufferSize = bufferSize;
        this.affectsCrumbling = affectsCrumbling;
        this.sort = sort;
        this.outline = outline;
        this.layers = layers;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CompositeRenderTypeData.class), CompositeRenderTypeData.class, "format;mode;bufferSize;affectsCrumbling;sort;outline;layers", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->format:Lcom/mojang/blaze3d/vertex/VertexFormat;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->mode:Lcom/mojang/blaze3d/vertex/VertexFormat$Mode;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->bufferSize:I", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->affectsCrumbling:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->sort:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->outline:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->layers:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CompositeRenderTypeData.class), CompositeRenderTypeData.class, "format;mode;bufferSize;affectsCrumbling;sort;outline;layers", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->format:Lcom/mojang/blaze3d/vertex/VertexFormat;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->mode:Lcom/mojang/blaze3d/vertex/VertexFormat$Mode;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->bufferSize:I", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->affectsCrumbling:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->sort:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->outline:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->layers:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CompositeRenderTypeData.class, Object.class), CompositeRenderTypeData.class, "format;mode;bufferSize;affectsCrumbling;sort;outline;layers", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->format:Lcom/mojang/blaze3d/vertex/VertexFormat;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->mode:Lcom/mojang/blaze3d/vertex/VertexFormat$Mode;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->bufferSize:I", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->affectsCrumbling:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->sort:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->outline:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CompositeRenderTypeData;->layers:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public VertexFormat format() {
        return this.format;
    }

    public VertexFormat.Mode mode() {
        return this.mode;
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public boolean affectsCrumbling() {
        return this.affectsCrumbling;
    }

    public boolean sort() {
        return this.sort;
    }

    public boolean outline() {
        return this.outline;
    }

    public List<RenderTypeLayer[]> layers() {
        return this.layers;
    }

    @ApiStatus.Internal
    public RenderType createRenderType(String name, Object... params) {
        RenderType[] renderTypes = new RenderType[this.layers.size()];
        for (int i = 0; i < this.layers.size(); i++) {
            RenderTypeLayer[] shards = this.layers.get(i);
            VeilRenderTypeBuilder builder = VeilRenderBridge.create(RenderType.CompositeState.builder());
            for (RenderTypeLayer shard : shards) {
                shard.addShard(builder, params);
            }
            RenderType.CompositeState state = builder.create(this.outline);
            renderTypes[i] = RenderType.create(name, this.format, this.mode, this.bufferSize, this.affectsCrumbling, this.sort, state);
        }
        return VeilRenderType.layered(renderTypes);
    }
}
