package foundry.veil.forge.mixin.client.perspective.vanilla;

import com.llamalad7.mixinextras.sugar.Local;
import foundry.veil.impl.client.render.perspective.LevelPerspectiveCamera;
import foundry.veil.impl.client.render.perspective.VeilSectionOcclusionGraph;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.ViewArea;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.Mth;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/perspective/vanilla/LevelRendererMixin.class */
@Mixin({LevelRenderer.class})
public abstract class LevelRendererMixin {

    @Shadow
    @Nullable
    private SectionRenderDispatcher sectionRenderDispatcher;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Mutable
    @Shadow
    @Final
    private ObjectArrayList<SectionRenderDispatcher.RenderSection> visibleSections;

    @Shadow
    @Nullable
    private ViewArea viewArea;

    @Unique
    private final VeilSectionOcclusionGraph veil$perspectiveOcclusionGraph = new VeilSectionOcclusionGraph();

    @Unique
    private final ObjectArrayList<SectionRenderDispatcher.RenderSection> veil$visibleSections = new ObjectArrayList<>(10000);

    @Unique
    private ObjectArrayList<SectionRenderDispatcher.RenderSection> veil$backupVisibleSections;

    @Inject(method = {"setupRender"}, at = {@At(value = "INVOKE_STRING", target = "Lnet/minecraft/util/profiling/ProfilerFiller;push(Ljava/lang/String;)V", shift = At.Shift.AFTER, args = {"ldc=camera"})}, cancellable = true)
    public void setupRender(Camera camera, Frustum frustum, boolean hasCapturedFrustum, boolean isSpectator, CallbackInfo ci, @Local Vec3 cameraPos) {
        if (!(camera instanceof LevelPerspectiveCamera)) {
            return;
        }
        LevelPerspectiveCamera perspectiveCamera = (LevelPerspectiveCamera) camera;
        ci.cancel();
        Entity.setViewScale(Mth.clamp(((double) perspectiveCamera.getRenderDistance()) / 8.0d, 1.0d, 2.5d));
        this.sectionRenderDispatcher.setCamera(cameraPos);
        ProfilerFiller profiler = this.minecraft.getProfiler();
        profiler.push("veil_section_occlusion_graph");
        this.veil$visibleSections.clear();
        this.veil$perspectiveOcclusionGraph.update((ViewArea) Objects.requireNonNull(this.viewArea), this.minecraft.smartCull, perspectiveCamera, frustum, this.veil$visibleSections);
        profiler.pop();
        profiler.pop();
        this.veil$backupVisibleSections = this.visibleSections;
        this.visibleSections = this.veil$visibleSections;
    }

    @Inject(method = {"renderLevel"}, at = {@At("TAIL")})
    public void resetSections(DeltaTracker deltaTracker, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f frustumMatrix, Matrix4f projectionMatrix, CallbackInfo ci) {
        if (camera instanceof LevelPerspectiveCamera) {
            Entity.setViewScale(Mth.clamp(((double) this.minecraft.options.getEffectiveRenderDistance()) / 8.0d, 1.0d, 2.5d) * ((Double) this.minecraft.options.entityDistanceScaling().get()).doubleValue());
            this.visibleSections = this.veil$backupVisibleSections;
            this.veil$visibleSections.clear();
        }
    }
}
