package foundry.veil.forge.mixin.client.perspective.sodium;

import foundry.veil.api.client.render.VeilLevelPerspectiveRenderer;
import foundry.veil.forge.ext.RenderSectionExtension;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSection;
import net.caffeinemc.mods.sodium.client.render.chunk.lists.RenderSectionVisitor;
import net.caffeinemc.mods.sodium.client.render.chunk.occlusion.OcclusionCuller;
import net.caffeinemc.mods.sodium.client.render.chunk.occlusion.VisibilityEncoding;
import net.caffeinemc.mods.sodium.client.render.viewport.Viewport;
import net.caffeinemc.mods.sodium.client.util.collections.WriteQueue;
import net.minecraft.core.SectionPos;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/perspective/sodium/OcclusionCullerMixin.class */
@Mixin({OcclusionCuller.class})
public abstract class OcclusionCullerMixin {
    @Shadow(remap = false)
    protected abstract RenderSection getRenderSection(int i, int i2, int i3);

    @Shadow(remap = false)
    private static void visitNeighbors(WriteQueue<RenderSection> queue, RenderSection section, int outgoing, int frame) {
    }

    @Inject(method = {"visitNode"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    private static void visitNode(WriteQueue<RenderSection> queue, @NotNull RenderSection render, int incoming, int frame, CallbackInfo ci) {
        if (!VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            return;
        }
        ci.cancel();
        RenderSectionExtension ext = (RenderSectionExtension) render;
        if (ext.veil$hasNotRendered()) {
            ext.veil$markRendered();
            render.setIncomingDirections(0);
            queue.enqueue(render);
        }
        ext.veil$addIncomingDirections(incoming);
    }

    @Inject(method = {"addNearbySections"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    public void addNearbySections(RenderSectionVisitor visitor, Viewport viewport, int frame, CallbackInfo ci) {
        if (!VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            return;
        }
        ci.cancel();
        SectionPos origin = viewport.getChunkCoord();
        int originX = origin.getX();
        int originY = origin.getY();
        int originZ = origin.getZ();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (dx != 0 || dy != 0 || dz != 0) {
                        RenderSectionExtension renderSection = getRenderSection(originX + dx, originY + dy, originZ + dz);
                        RenderSectionExtension ext = renderSection;
                        if (renderSection != null && ext.veil$hasNotRendered() && OcclusionCuller.isWithinNearbySectionFrustum(viewport, renderSection)) {
                            ext.veil$markRendered();
                            visitor.visit(renderSection);
                        }
                    }
                }
            }
        }
    }

    @Inject(method = {"initWithinWorld"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    public void initWithinWorld(RenderSectionVisitor visitor, WriteQueue<RenderSection> queue, Viewport viewport, boolean useOcclusionCulling, int frame, CallbackInfo ci) {
        int outgoing;
        if (!VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            return;
        }
        ci.cancel();
        SectionPos origin = viewport.getChunkCoord();
        RenderSectionExtension renderSection = getRenderSection(origin.getX(), origin.getY(), origin.getZ());
        RenderSectionExtension ext = renderSection;
        if (renderSection != null) {
            ext.veil$markRendered();
            visitor.visit(renderSection);
            if (useOcclusionCulling) {
                outgoing = VisibilityEncoding.getConnections(renderSection.getVisibilityData());
            } else {
                outgoing = 63;
            }
            visitNeighbors(queue, renderSection, outgoing, frame);
        }
    }
}
