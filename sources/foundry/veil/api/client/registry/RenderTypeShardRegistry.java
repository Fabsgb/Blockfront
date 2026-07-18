package foundry.veil.api.client.registry;

import foundry.veil.api.client.render.rendertype.VeilRenderType;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Predicate;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/RenderTypeShardRegistry.class */
public final class RenderTypeShardRegistry {
    private static final Map<String, List<RenderStateShard>> SHARDS = new HashMap();
    private static final Set<GenericShard> GENERIC_SHARDS = new HashSet();
    private static final Set<RenderType.CompositeRenderType> CREATED_RENDER_TYPES = Collections.newSetFromMap(new WeakHashMap());

    private RenderTypeShardRegistry() {
    }

    public static synchronized void addShard(RenderType renderType, RenderStateShard... shards) {
        if (shards.length == 0) {
            return;
        }
        if (!(renderType instanceof RenderType.CompositeRenderType)) {
            throw new IllegalArgumentException("RenderType must be CompositeRenderType");
        }
        RenderType.CompositeRenderType compositeRenderType = (RenderType.CompositeRenderType) renderType;
        compositeRenderType.state().veil$addShards(Arrays.asList(shards));
    }

    public static synchronized void addShard(String name, RenderStateShard... shards) {
        if (shards.length == 0) {
            throw new IllegalArgumentException("No shards provided");
        }
        List<RenderStateShard> newShards = Arrays.asList(shards);
        SHARDS.computeIfAbsent(name, unused -> {
            return new ArrayList();
        }).addAll(newShards);
        for (RenderType.CompositeRenderType renderType : CREATED_RENDER_TYPES) {
            if (name.equals(VeilRenderType.getName(renderType))) {
                renderType.state().veil$addShards(newShards);
            }
        }
    }

    public static synchronized void addGenericShard(Predicate<RenderType.CompositeRenderType> filter, RenderStateShard... shards) {
        if (shards.length == 0) {
            throw new IllegalArgumentException("No shards provided");
        }
        GENERIC_SHARDS.add(new GenericShard(filter, shards));
        for (RenderType.CompositeRenderType renderType : CREATED_RENDER_TYPES) {
            if (filter.test(renderType)) {
                renderType.state().veil$addShards(Arrays.asList(shards));
            }
        }
    }

    @ApiStatus.Internal
    public static void inject(RenderType.CompositeRenderType renderType) {
        List<RenderStateShard> shards = SHARDS.get(VeilRenderType.getName(renderType));
        if (shards != null) {
            shards = new ArrayList(shards);
        }
        for (GenericShard stage : GENERIC_SHARDS) {
            if (stage.filter.test(renderType)) {
                if (shards == null) {
                    shards = new ArrayList(Arrays.asList(stage.shards));
                } else {
                    shards.addAll(Arrays.asList(stage.shards));
                }
            }
        }
        if (shards != null) {
            renderType.state().veil$addShards(shards);
        }
        CREATED_RENDER_TYPES.add(renderType);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard.class */
    private static final class GenericShard extends Record {
        private final Predicate<RenderType.CompositeRenderType> filter;
        private final RenderStateShard[] shards;

        private GenericShard(Predicate<RenderType.CompositeRenderType> filter, RenderStateShard[] shards) {
            this.filter = filter;
            this.shards = shards;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GenericShard.class), GenericShard.class, "filter;shards", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard;->filter:Ljava/util/function/Predicate;", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard;->shards:[Lnet/minecraft/client/renderer/RenderStateShard;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GenericShard.class), GenericShard.class, "filter;shards", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard;->filter:Ljava/util/function/Predicate;", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard;->shards:[Lnet/minecraft/client/renderer/RenderStateShard;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GenericShard.class, Object.class), GenericShard.class, "filter;shards", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard;->filter:Ljava/util/function/Predicate;", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeShardRegistry$GenericShard;->shards:[Lnet/minecraft/client/renderer/RenderStateShard;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public Predicate<RenderType.CompositeRenderType> filter() {
            return this.filter;
        }

        public RenderStateShard[] shards() {
            return this.shards;
        }
    }
}
