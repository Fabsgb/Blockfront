package foundry.veil.api.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.registry.VeilShaderBufferRegistry;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/CameraMatrices.class */
public class CameraMatrices {
    private final Matrix4f projectionMatrix = new Matrix4f();
    private final Matrix4f inverseProjectionMatrix = new Matrix4f();
    private final Matrix4f viewMatrix = new Matrix4f();
    private final Matrix4f inverseViewMatrix = new Matrix4f();
    private final Matrix3f inverseViewRotMatrix = new Matrix3f();
    private final Vector3f cameraPosition = new Vector3f();
    private final Vector3f cameraBobOffset = new Vector3f();
    private float nearPlane = 0.0f;
    private float farPlane = 0.0f;

    public static VeilShaderBufferLayout<CameraMatrices> createLayout() {
        return VeilShaderBufferLayout.builder().mat4("ProjMat", (v0) -> {
            return v0.getProjectionMatrix();
        }).mat4("IProjMat", (v0) -> {
            return v0.getInverseProjectionMatrix();
        }).mat4("ViewMat", (v0) -> {
            return v0.getViewMatrix();
        }).mat4("IViewMat", (v0) -> {
            return v0.getInverseViewMatrix();
        }).mat3("IViewRotMat", (v0) -> {
            return v0.getInverseViewRotMatrix();
        }).vec3("CameraPosition", (v0) -> {
            return v0.getCameraPosition();
        }).f32("NearPlane", (v0) -> {
            return v0.getNearPlane();
        }).vec3("CameraBobOffset", (v0) -> {
            return v0.getCameraBobOffset();
        }).f32("FarPlane", (v0) -> {
            return v0.getFarPlane();
        }).build();
    }

    private void extractPlanes() {
        if ((this.projectionMatrix.properties() & 1) != 0) {
            this.nearPlane = this.projectionMatrix.perspectiveNear();
            this.farPlane = this.projectionMatrix.perspectiveFar();
        } else {
            this.nearPlane = this.inverseProjectionMatrix.transformPosition(0.0f, 0.0f, -1.0f, this.cameraPosition).z();
            this.farPlane = this.inverseProjectionMatrix.transformPosition(0.0f, 0.0f, 1.0f, this.cameraPosition).z();
        }
    }

    public void update(Matrix4fc projection, Matrix4fc modelView, double x, double y, double z) {
        ShaderBlock<CameraMatrices> block = VeilRenderSystem.getBlock(VeilShaderBufferRegistry.CAMERA.get());
        if (block == null) {
            return;
        }
        this.projectionMatrix.set(projection);
        this.projectionMatrix.invertPerspective(this.inverseProjectionMatrix);
        if (VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            this.cameraBobOffset.set(0.0f);
        } else {
            modelView.invert(this.viewMatrix).transformPosition(VeilRenderSystem.getCameraBobOffset(), this.cameraBobOffset);
        }
        this.viewMatrix.set(modelView).mulLocal(this.inverseProjectionMatrix.mul(RenderSystem.getProjectionMatrix(), new Matrix4f()));
        this.viewMatrix.invert(this.inverseViewMatrix);
        this.inverseViewMatrix.normal(this.inverseViewRotMatrix);
        extractPlanes();
        this.cameraPosition.set(x, y, z);
        block.set(this);
        VeilRenderSystem.bind(VeilShaderBufferRegistry.CAMERA.get());
    }

    public void updateRenderSystem() {
        ShaderBlock<CameraMatrices> block = VeilRenderSystem.getBlock(VeilShaderBufferRegistry.CAMERA.get());
        if (block == null) {
            return;
        }
        this.projectionMatrix.set(RenderSystem.getProjectionMatrix());
        this.projectionMatrix.invertAffine(this.inverseProjectionMatrix);
        this.viewMatrix.identity();
        this.inverseViewMatrix.identity();
        this.inverseViewRotMatrix.identity();
        extractPlanes();
        this.cameraPosition.set(0.0f);
        this.cameraBobOffset.set(0.0f);
        block.set(this);
        VeilRenderSystem.bind(VeilShaderBufferRegistry.CAMERA.get());
    }

    public void backup(CameraMatrices store) {
        store.projectionMatrix.set(this.projectionMatrix);
        store.inverseProjectionMatrix.set(this.inverseProjectionMatrix);
        store.viewMatrix.set(this.viewMatrix);
        store.inverseViewMatrix.set(this.inverseViewMatrix);
        store.inverseViewRotMatrix.set(this.inverseViewRotMatrix);
        store.cameraPosition.set(this.cameraPosition);
        store.cameraBobOffset.set(this.cameraBobOffset);
        store.nearPlane = this.nearPlane;
        store.farPlane = this.farPlane;
    }

    public void restore(CameraMatrices load) {
        ShaderBlock<CameraMatrices> block = VeilRenderSystem.getBlock(VeilShaderBufferRegistry.CAMERA.get());
        if (block == null) {
            return;
        }
        this.projectionMatrix.set(load.projectionMatrix);
        this.inverseProjectionMatrix.set(load.inverseProjectionMatrix);
        this.viewMatrix.set(load.viewMatrix);
        this.inverseViewMatrix.set(load.inverseViewMatrix);
        this.inverseViewRotMatrix.set(load.inverseViewRotMatrix);
        this.cameraPosition.set(load.cameraPosition);
        this.cameraBobOffset.set(load.cameraBobOffset);
        this.nearPlane = load.nearPlane;
        this.farPlane = load.farPlane;
        block.set(this);
        VeilRenderSystem.bind(VeilShaderBufferRegistry.CAMERA.get());
    }

    public Matrix4f getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public Matrix4f getInverseProjectionMatrix() {
        return this.inverseProjectionMatrix;
    }

    public Matrix4f getViewMatrix() {
        return this.viewMatrix;
    }

    public Matrix4f getInverseViewMatrix() {
        return this.inverseViewMatrix;
    }

    public Matrix3f getInverseViewRotMatrix() {
        return this.inverseViewRotMatrix;
    }

    public Vector3f getCameraPosition() {
        return this.cameraPosition;
    }

    public Vector3f getCameraBobOffset() {
        return this.cameraBobOffset;
    }

    public float getNearPlane() {
        return this.nearPlane;
    }

    public float getFarPlane() {
        return this.farPlane;
    }

    public void setNearPlane(float nearPlane) {
        this.nearPlane = nearPlane;
    }

    public void setFarPlane(float farPlane) {
        this.farPlane = farPlane;
    }
}
