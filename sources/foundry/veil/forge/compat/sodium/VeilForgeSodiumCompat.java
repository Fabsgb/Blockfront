package foundry.veil.forge.compat.sodium;

import foundry.veil.api.compat.SodiumCompat;
import foundry.veil.forge.ext.ShaderChunkRendererExtension;
import foundry.veil.forge.ext.SodiumWorldRendererExtension;
import foundry.veil.forge.mixin.compat.sodium.RenderSectionManagerAccessor;
import foundry.veil.forge.mixin.compat.sodium.SodiumWorldRendererAccessor;
import it.unimi.dsi.fastutil.longs.Long2ReferenceMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import java.util.ArrayDeque;
import java.util.EnumMap;
import java.util.Map;
import net.caffeinemc.mods.sodium.client.gl.shader.GlProgram;
import net.caffeinemc.mods.sodium.client.render.SodiumWorldRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.TaskQueueType;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.SortedRenderLists;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkFogMode;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/compat/sodium/VeilForgeSodiumCompat.class */
public class VeilForgeSodiumCompat implements SodiumCompat {
    @NotNull
    private static StringBuilder getShaderName(ChunkShaderOptions options) {
        StringBuilder name = new StringBuilder("chunk_shader");
        if (options.fog() == ChunkFogMode.SMOOTH) {
            name.append("_fog_smooth");
        }
        TerrainRenderPass pass = options.pass();
        if (pass.isTranslucent()) {
            name.append("_translucent");
        }
        if (pass.supportsFragmentDiscard()) {
            name.append("_cutout");
        }
        return name;
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public Object2IntMap<ResourceLocation> getLoadedShaders() {
        RenderSectionManagerAccessor renderSectionManager;
        SodiumWorldRendererAccessor sodiumWorldRendererAccessorInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererAccessorInstanceNullable != null && (renderSectionManager = sodiumWorldRendererAccessorInstanceNullable.getRenderSectionManager()) != null) {
            ShaderChunkRendererExtension chunkRenderer = renderSectionManager.getChunkRenderer();
            if (chunkRenderer instanceof ShaderChunkRendererExtension) {
                ShaderChunkRendererExtension extension = chunkRenderer;
                Object2IntArrayMap object2IntArrayMap = new Object2IntArrayMap(extension.veil$getPrograms().size());
                for (Map.Entry<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> entry : extension.veil$getPrograms().entrySet()) {
                    StringBuilder name = getShaderName(entry.getKey());
                    object2IntArrayMap.put(ResourceLocation.fromNamespaceAndPath("sodium", name.toString()), entry.getValue().handle());
                }
                return object2IntArrayMap;
            }
        }
        return Object2IntMaps.emptyMap();
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public void recompile() {
        RenderSectionManagerAccessor renderSectionManager;
        SodiumWorldRendererAccessor sodiumWorldRendererAccessorInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererAccessorInstanceNullable == null || (renderSectionManager = sodiumWorldRendererAccessorInstanceNullable.getRenderSectionManager()) == null) {
            return;
        }
        ShaderChunkRendererExtension chunkRenderer = renderSectionManager.getChunkRenderer();
        if (chunkRenderer instanceof ShaderChunkRendererExtension) {
            ShaderChunkRendererExtension extension = chunkRenderer;
            extension.veil$recompile();
        }
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public void setActiveBuffers(int activeBuffers) {
        RenderSectionManagerAccessor renderSectionManager;
        SodiumWorldRendererAccessor sodiumWorldRendererAccessorInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererAccessorInstanceNullable == null || (renderSectionManager = sodiumWorldRendererAccessorInstanceNullable.getRenderSectionManager()) == null) {
            return;
        }
        ShaderChunkRendererExtension chunkRenderer = renderSectionManager.getChunkRenderer();
        if (chunkRenderer instanceof ShaderChunkRendererExtension) {
            ShaderChunkRendererExtension extension = chunkRenderer;
            extension.veil$setActiveBuffers(activeBuffers);
        }
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public void markChunksDirty() {
        RenderSectionManagerAccessor renderSectionManager;
        SodiumWorldRendererAccessor sodiumWorldRendererAccessorInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererAccessorInstanceNullable != null && (renderSectionManager = sodiumWorldRendererAccessorInstanceNullable.getRenderSectionManager()) != null) {
            Long2ReferenceMap<RenderSection> map = renderSectionManager.getSectionByPosition();
            LongIterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                long sectionPos = iterator.nextLong();
                renderSectionManager.scheduleRebuild(SectionPos.x(sectionPos), SectionPos.y(sectionPos), SectionPos.z(sectionPos), true);
            }
        }
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public Object getSortedRenderLists() {
        SodiumWorldRendererExtension sodiumWorldRendererExtensionInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererExtensionInstanceNullable == null) {
            return SortedRenderLists.empty();
        }
        return sodiumWorldRendererExtensionInstanceNullable.veil$getSortedRenderLists();
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public void setSortedRenderLists(@Nullable Object sortedRenderLists) {
        SodiumWorldRendererExtension sodiumWorldRendererExtensionInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererExtensionInstanceNullable != null) {
            SortedRenderLists renderLists = sortedRenderLists != null ? (SortedRenderLists) sortedRenderLists : SortedRenderLists.empty();
            sodiumWorldRendererExtensionInstanceNullable.veil$setSortedRenderLists(renderLists);
        }
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public Object getTaskLists() {
        SodiumWorldRendererExtension sodiumWorldRendererExtensionInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererExtensionInstanceNullable != null) {
            return sodiumWorldRendererExtensionInstanceNullable.veil$getTaskLists();
        }
        Map<TaskQueueType, ArrayDeque<?>> taskLists = new EnumMap<>(TaskQueueType.class);
        for (TaskQueueType type : TaskQueueType.values()) {
            taskLists.put(type, new ArrayDeque<>());
        }
        return taskLists;
    }

    @Override // foundry.veil.api.compat.SodiumCompat
    public void setTaskList(@Nullable Object taskList) {
        SodiumWorldRendererExtension sodiumWorldRendererExtensionInstanceNullable = SodiumWorldRenderer.instanceNullable();
        if (sodiumWorldRendererExtensionInstanceNullable != null) {
            if (taskList != null) {
                sodiumWorldRendererExtensionInstanceNullable.veil$setTaskLists((Map) taskList);
                return;
            }
            Map<TaskQueueType, ArrayDeque<RenderSection>> taskLists = new EnumMap<>(TaskQueueType.class);
            for (TaskQueueType type : TaskQueueType.values()) {
                taskLists.put(type, new ArrayDeque<>());
            }
            sodiumWorldRendererExtensionInstanceNullable.veil$setTaskLists(taskLists);
        }
    }
}
