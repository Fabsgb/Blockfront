package foundry.veil.api.client.render;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.compat.FlashbackCompat;
import foundry.veil.api.compat.SodiumCompat;
import foundry.veil.ext.RenderTargetExtension;
import foundry.veil.impl.client.render.perspective.FlashbackAccess;
import foundry.veil.impl.client.render.perspective.IrisPipelineAccess;
import foundry.veil.impl.client.render.perspective.LevelPerspectiveCamera;
import foundry.veil.mixin.perspective.accessor.GameRendererAccessor;
import foundry.veil.mixin.perspective.accessor.LevelRendererAccessor;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3dc;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/VeilLevelPerspectiveRenderer.class */
public final class VeilLevelPerspectiveRenderer {
    private static final LevelPerspectiveCamera CAMERA = new LevelPerspectiveCamera();
    private static final Matrix4f TRANSFORM = new Matrix4f();
    private static final AtomicInteger ID = new AtomicInteger();
    private static final CameraMatrices BACKUP_CAMERA_MATRICES = new CameraMatrices();
    private static final Matrix4f BACKUP_PROJECTION = new Matrix4f();
    private static final Vector3f BACKUP_LIGHT0_POSITION = new Vector3f();
    private static final Vector3f BACKUP_LIGHT1_POSITION = new Vector3f();
    private static final Matrix4f BACKUP_FLASHBACK_PROJECTION = new Matrix4f();
    private static final Quaternionf BACKUP_FLASHBACK_CAMERA = new Quaternionf();
    private static boolean renderingPerspective = false;

    private VeilLevelPerspectiveRenderer() {
    }

    public static AdvancedFbo render(AdvancedFbo framebuffer, Matrix4fc modelView, Matrix4fc projection, Vector3dc cameraPosition, Quaternionfc cameraOrientation, float renderDistance, DeltaTracker deltaTracker, boolean drawLights) {
        return render(framebuffer, Minecraft.getInstance().cameraEntity, modelView, projection, cameraPosition, cameraOrientation, renderDistance, deltaTracker, drawLights);
    }

    public static AdvancedFbo render(AdvancedFbo framebuffer, @Nullable Entity cameraEntity, Matrix4fc modelView, Matrix4fc projection, Vector3dc cameraPosition, Quaternionfc cameraOrientation, float renderDistance, DeltaTracker deltaTracker, boolean drawLights) {
        Object backupRenderLists;
        Object backupTaskLists;
        if (renderingPerspective) {
            return framebuffer;
        }
        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        bufferSource.endBatch();
        Minecraft minecraft = Minecraft.getInstance();
        GameRendererAccessor gameRendererAccessor = minecraft.gameRenderer;
        LevelRendererAccessor levelRendererAccessor = minecraft.levelRenderer;
        LevelRendererAccessor levelRendererAccessor2 = levelRendererAccessor;
        Window window = minecraft.getWindow();
        GameRendererAccessor accessor = gameRendererAccessor;
        RenderTargetExtension renderTargetExtension = minecraft.getMainRenderTarget();
        PoseStack poseStack = new PoseStack();
        CAMERA.setup(cameraPosition, cameraEntity, minecraft.level, cameraOrientation, renderDistance);
        poseStack.mulPose(TRANSFORM.set(modelView));
        poseStack.mulPose(CAMERA.rotation());
        float backupRenderDistance = gameRendererAccessor.getRenderDistance();
        accessor.setRenderDistance(renderDistance * 16.0f);
        float backupFogStart = RenderSystem.getShaderFogStart();
        float backupFogEnd = RenderSystem.getShaderFogEnd();
        FogShape backupFogShape = RenderSystem.getShaderFogShape();
        int backupWidth = window.getWidth();
        int backupHeight = window.getHeight();
        if (!FlashbackCompat.isLoaded()) {
            window.setWidth(framebuffer.getWidth());
            window.setHeight(framebuffer.getHeight());
        } else {
            FlashbackAccess.backup(BACKUP_FLASHBACK_PROJECTION, BACKUP_FLASHBACK_CAMERA);
        }
        Object backupPipeline = IrisPipelineAccess.getPipeline(levelRendererAccessor);
        if (SodiumCompat.isLoaded()) {
            backupRenderLists = SodiumCompat.INSTANCE.getSortedRenderLists();
            backupTaskLists = SodiumCompat.INSTANCE.getTaskLists();
            ID.getAndIncrement();
        } else {
            backupRenderLists = null;
            backupTaskLists = null;
        }
        BACKUP_PROJECTION.set(RenderSystem.getProjectionMatrix());
        gameRendererAccessor.resetProjectionMatrix(TRANSFORM.set(projection));
        BACKUP_LIGHT0_POSITION.set(VeilRenderSystem.getLight0Direction());
        BACKUP_LIGHT1_POSITION.set(VeilRenderSystem.getLight1Direction());
        Matrix4fStack matrix4fstack = RenderSystem.getModelViewStack();
        matrix4fstack.pushMatrix();
        matrix4fstack.identity();
        RenderSystem.applyModelViewMatrix();
        HitResult backupHitResult = minecraft.hitResult;
        Entity backupCrosshairPickEntity = minecraft.crosshairPickEntity;
        renderingPerspective = true;
        AdvancedFbo drawFbo = VeilRenderSystem.renderer().getDynamicBufferManger().getDynamicFbo(framebuffer);
        drawFbo.bind(true);
        renderTargetExtension.veil$setWrapper(drawFbo);
        Frustum backupFrustum = levelRendererAccessor2.getCullingFrustum();
        CameraMatrices matrices = VeilRenderSystem.renderer().getCameraMatrices();
        matrices.backup(BACKUP_CAMERA_MATRICES);
        try {
            levelRendererAccessor.prepareCullFrustum(new Vec3(cameraPosition.x(), cameraPosition.y(), cameraPosition.z()), poseStack.last().pose(), TRANSFORM);
            levelRendererAccessor.renderLevel(deltaTracker, false, CAMERA, gameRendererAccessor, gameRendererAccessor.lightTexture(), poseStack.last().pose(), TRANSFORM);
            bufferSource.endBatch();
            levelRendererAccessor.doEntityOutline();
            if (drawLights) {
                ProfilerFiller profiler = Minecraft.getInstance().getProfiler();
                if (VeilRenderSystem.drawLights(profiler, VeilRenderSystem.getCullingFrustum())) {
                    VeilRenderSystem.compositeLights(profiler);
                } else {
                    AdvancedFbo.unbind();
                }
            }
            return drawFbo;
        } finally {
            matrices.restore(BACKUP_CAMERA_MATRICES);
            levelRendererAccessor2.setCullingFrustum(backupFrustum);
            renderTargetExtension.veil$setWrapper(null);
            AdvancedFbo.unbind();
            renderingPerspective = false;
            minecraft.crosshairPickEntity = backupCrosshairPickEntity;
            minecraft.hitResult = backupHitResult;
            matrix4fstack.popMatrix();
            RenderSystem.applyModelViewMatrix();
            RenderSystem.setShaderLights(BACKUP_LIGHT0_POSITION, BACKUP_LIGHT1_POSITION);
            gameRendererAccessor.resetProjectionMatrix(BACKUP_PROJECTION);
            IrisPipelineAccess.setPipeline(levelRendererAccessor, backupPipeline);
            if (SodiumCompat.isLoaded()) {
                SodiumCompat.INSTANCE.setSortedRenderLists(backupRenderLists);
                SodiumCompat.INSTANCE.setTaskList(backupTaskLists);
            }
            RenderSystem.setShaderFogStart(backupFogStart);
            RenderSystem.setShaderFogEnd(backupFogEnd);
            RenderSystem.setShaderFogShape(backupFogShape);
            if (!FlashbackCompat.isLoaded()) {
                window.setWidth(backupWidth);
                window.setHeight(backupHeight);
            } else {
                FlashbackAccess.restore(BACKUP_FLASHBACK_PROJECTION, BACKUP_FLASHBACK_CAMERA);
            }
            accessor.setRenderDistance(backupRenderDistance);
            Camera mainCamera = gameRendererAccessor.getMainCamera();
            minecraft.getBlockEntityRenderDispatcher().prepare(minecraft.level, mainCamera, minecraft.hitResult);
            minecraft.getEntityRenderDispatcher().prepare(minecraft.level, mainCamera, minecraft.crosshairPickEntity);
        }
    }

    public static boolean isRenderingPerspective() {
        return renderingPerspective;
    }

    @ApiStatus.Internal
    public static int getID() {
        return ID.get();
    }
}
