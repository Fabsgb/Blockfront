package foundry.veil.api.quasar.particle;

import foundry.veil.Veil;
import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.quasar.data.QuasarParticleData;
import foundry.veil.api.quasar.p002fx.Trail;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/RenderData.class */
public final class RenderData {

    @Deprecated
    public static final ResourceLocation BLANK = Veil.veilPath("textures/special/blank.png");
    private final QuasarParticle particle;
    private boolean additive;
    private SpriteData spriteData;
    private RenderType renderType;
    private boolean renderTypeDirty;
    private final List<Trail> trails;
    private final Vector3d prevPosition = new Vector3d();
    private final Vector3d renderPosition = new Vector3d();
    private final Vector3f prevRotation = new Vector3f();
    private final Vector3f renderRotation = new Vector3f();
    private float prevRadius = 1.0f;
    private float renderRadius = 1.0f;
    private int packedLight = 15728880;
    private int fixedPackedLight = -1;
    private float red = 1.0f;
    private float green = 1.0f;
    private float blue = 1.0f;
    private float alpha = 1.0f;
    public float renderAge = 0.0f;
    public float agePercent = 0.0f;
    private TextureAtlasSprite atlasSprite = null;

    public RenderData(QuasarParticle particle, QuasarParticleData data) {
        this.particle = particle;
        this.additive = data.additive();
        this.spriteData = data.spriteData();
        markDirty();
        this.trails = new ArrayList();
    }

    @ApiStatus.Internal
    public void tick(QuasarParticle particle, int packedLight) {
        this.prevPosition.set(particle.getPosition());
        this.prevRotation.set(particle.getRotation());
        this.prevRadius = particle.getRadius();
        this.packedLight = packedLight;
        tickTrails();
    }

    @ApiStatus.Internal
    public void render(QuasarParticle particle, float partialTicks) {
        this.prevPosition.lerp(particle.getPosition(), partialTicks, this.renderPosition);
        this.prevRotation.lerp(particle.getRotation(), partialTicks, this.renderRotation);
        this.renderRadius = Mth.lerp(partialTicks, this.prevRadius, particle.getRadius());
        this.renderAge = particle.getAge() + partialTicks;
        this.agePercent = Math.min(this.renderAge / particle.getLifetime(), 1.0f);
    }

    public void markDirty() {
        this.renderTypeDirty = true;
    }

    public Vector3dc getRenderPosition() {
        return this.renderPosition;
    }

    public Vector3fc getRenderRotation() {
        return this.renderRotation;
    }

    public float getRenderRadius() {
        return this.renderRadius;
    }

    public float getRenderAge() {
        return this.renderAge;
    }

    public float getAgePercent() {
        return this.agePercent;
    }

    public int getPackedLight() {
        return this.packedLight;
    }

    public int getFixedPackedLight() {
        return this.fixedPackedLight;
    }

    public float getRed() {
        return this.red;
    }

    public float getGreen() {
        return this.green;
    }

    public float getBlue() {
        return this.blue;
    }

    public float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public SpriteData getSpriteData() {
        return this.spriteData;
    }

    public TextureAtlasSprite getAtlasSprite() {
        return this.atlasSprite;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public RenderType getRenderType() {
        if (this.renderTypeDirty) {
            this.renderType = this.particle.getData().renderStyle().getRenderType(this.particle, this);
        }
        return this.renderType;
    }

    public List<Trail> getTrails() {
        return this.trails;
    }

    private void tickTrails() {
        if (this.trails.isEmpty()) {
            return;
        }
        for (Trail trail : this.trails) {
            trail.pushRotatedPoint(new Vec3(this.particle.getPosition().x, this.particle.getPosition().y, this.particle.getPosition().z), new Vec3(this.particle.getRotation()));
        }
    }

    @ApiStatus.Internal
    public void renderTrails(MatrixStack matrixStack, MultiBufferSource bufferSource, Vec3 cameraPos, int packedLight, float partialTicks) {
        if (this.trails.isEmpty()) {
            return;
        }
        matrixStack.matrixPush();
        matrixStack.translate(-cameraPos.x(), -cameraPos.y(), -cameraPos.z());
        for (Trail trail : this.trails) {
            trail.render(matrixStack, bufferSource.getBuffer(VeilRenderType.quasarTrail(trail.getTexture(), trail.isAdditive())), packedLight, partialTicks, new Vec3(this.particle.getPosition().x, this.particle.getPosition().y, this.particle.getPosition().z), new Vec3(this.particle.getRotation()));
        }
        matrixStack.matrixPop();
    }

    public void setRed(float red) {
        this.red = red;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setColor(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public void setColor(Vector4fc color) {
        this.red = color.x();
        this.green = color.y();
        this.blue = color.z();
        this.alpha = color.w();
    }

    public void setColor(Colorc color) {
        this.red = color.red();
        this.green = color.green();
        this.blue = color.blue();
        this.alpha = color.alpha();
    }

    public void setFixedPackedLight(int fixedPackedLight) {
        this.fixedPackedLight = fixedPackedLight;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
        markDirty();
    }

    public void setSpriteData(@Nullable SpriteData spriteData) {
        this.spriteData = spriteData;
        markDirty();
    }

    public void setAtlasSprite(@Nullable TextureAtlasSprite atlasSprite) {
        this.atlasSprite = atlasSprite;
        markDirty();
    }
}
