package foundry.veil.api.quasar.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.Veil;
import foundry.veil.api.TickTaskScheduler;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.quasar.data.EmitterSettings;
import foundry.veil.api.quasar.data.EmitterShapeSettings;
import foundry.veil.api.quasar.data.ParticleEmitterData;
import foundry.veil.api.quasar.data.ParticleSettings;
import foundry.veil.api.quasar.data.QuasarParticleData;
import foundry.veil.api.quasar.data.module.CodeModule;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.module.update.FaceVelocityModule;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.slf4j.Logger;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/ParticleEmitter.class */
@ApiStatus.NonExtendable
public class ParticleEmitter {
    private static final Set<Holder<ParticleModuleData>> REPORTED_MODULES = new HashSet();
    protected final ParticleSystemManager particleManager;
    private final ClientLevel level;
    private final ParticleEmitterData emitterData;
    private final List<ParticleModuleData> modules;
    private final List<ParticleModuleData> modulesView;
    private final RandomSource randomSource = RandomSource.create();
    private final Vector3d position = new Vector3d();
    private final Vector3d offset = new Vector3d();
    private final List<QuasarParticle> particles = new LinkedList();
    private int maxLifetime;
    private boolean loop;
    private int rate;
    private int count;
    private int maxParticles;
    private List<EmitterShapeSettings> emitterShapeSettings;
    private ParticleSettings particleSettings;
    private boolean forceSpawn;
    protected QuasarParticleData particleData;

    @Nullable
    private Entity attachedEntity;
    protected CompletableFuture<?> spawnTask;
    protected CompletableFuture<?> removeTask;
    private boolean removed;

    protected ParticleEmitter(ParticleSystemManager particleManager, ClientLevel level, ParticleEmitterData data) {
        this.particleManager = particleManager;
        this.level = level;
        this.emitterData = data;
        this.modules = createModuleSet(data.particleData());
        this.modulesView = Collections.unmodifiableList(this.modules);
        this.maxLifetime = data.maxLifetime();
        this.loop = data.loop();
        this.rate = data.rate();
        this.count = data.count();
        this.maxParticles = data.maxParticles();
        EmitterSettings emitterSettings = data.emitterSettings();
        this.emitterShapeSettings = new ArrayList(emitterSettings.emitterShapeSettings());
        this.particleSettings = emitterSettings.particleSettings();
        this.forceSpawn = emitterSettings.forceSpawn();
        this.particleData = data.particleData();
        reset();
        TickTaskScheduler scheduler = particleManager.getScheduler();
        this.spawnTask = scheduler.scheduleAtFixedRate(this::spawn, 1L, data.rate()).toCompletableFuture();
    }

    @ApiStatus.Internal
    void onAdd() {
        spawn();
    }

    @ApiStatus.Internal
    public static void clearErrors() {
        REPORTED_MODULES.clear();
    }

    protected void spawn() {
        int count = Math.min(this.maxParticles, this.count);
        this.particleManager.reserve(count);
        for (int i = 0; i < count; i++) {
            Vector3d pos = this.emitterShapeSettings.get(i % this.emitterShapeSettings.size()).getPos(this.randomSource, this.position);
            Vector3f vector3fParticleDirection = this.particleSettings.particleDirection(this.randomSource);
            Vector3f vector3fMul = this.particleSettings.initialRotation(this.randomSource).mul(0.017453292f, new Vector3f());
            ParticleModuleSet.Builder builder = ParticleModuleSet.builder();
            for (ParticleModuleData module : this.modules) {
                module.addModules(builder);
            }
            if (this.particleData.faceVelocity()) {
                builder.addModule(new FaceVelocityModule());
            }
            QuasarParticle particle = new QuasarParticle(this.level, this.randomSource, this.particleManager.getScheduler(), this.particleData, builder.build(), this.particleSettings, this);
            particle.getPosition().set(pos);
            particle.getVelocity().set(vector3fParticleDirection);
            particle.getRotation().set(vector3fMul);
            particle.init();
            this.particles.add(particle);
        }
    }

    protected static List<ParticleModuleData> createModuleSet(QuasarParticleData data) {
        ResourceLocation name;
        List<Holder<ParticleModuleData>> allModules = data.modules();
        ArrayList<ParticleModuleData> list = new ArrayList<>(allModules.size());
        Iterator<Holder<ParticleModuleData>> it = allModules.iterator();
        while (it.hasNext()) {
            Holder.Reference<ParticleModuleData> reference = (Holder) it.next();
            if (!reference.isBound()) {
                if (REPORTED_MODULES.add(reference)) {
                    Logger logger = Veil.LOGGER;
                    if (reference instanceof Holder.Reference) {
                        Holder.Reference<ParticleModuleData> ref = reference;
                        name = ref.key().location();
                    } else {
                        name = reference.getClass().getName();
                    }
                    logger.error("Unknown module: {}", name);
                }
            } else {
                list.add((ParticleModuleData) reference.value());
            }
        }
        list.trimToSize();
        return list;
    }

    private void expire() {
        if (this.loop) {
            reset();
        } else {
            remove();
        }
    }

    private void cancelTasks() {
        if (this.spawnTask != null) {
            this.spawnTask.cancel(false);
            this.spawnTask = null;
        }
        if (this.removeTask != null) {
            this.removeTask.cancel(false);
            this.removeTask = null;
        }
    }

    @ApiStatus.Internal
    protected void tick() {
        this.position.set(0.0d);
        if (this.attachedEntity != null) {
            if (this.attachedEntity.isAlive()) {
                Vec3 pos = this.attachedEntity.position();
                this.position.set(pos.x, pos.y, pos.z);
            } else {
                this.attachedEntity = null;
                remove();
            }
        }
        this.position.add(this.offset);
        Iterator<QuasarParticle> iterator = this.particles.iterator();
        while (iterator.hasNext()) {
            QuasarParticle particle = iterator.next();
            particle.tick();
            if (particle.isRemoved()) {
                iterator.remove();
                particle.onRemove();
            }
        }
    }

    @ApiStatus.Internal
    public void render(MatrixStack matrixStack, MultiBufferSource bufferSource, Camera camera, float partialTicks) {
        if (this.particles.isEmpty()) {
            return;
        }
        RenderStyle renderStyle = this.particleData.renderStyle();
        if (!renderStyle.setup(this.particles.size())) {
            return;
        }
        Vec3 projectedView = camera.getPosition();
        Vector3f renderOffset = new Vector3f();
        RenderType lastRenderType = null;
        VertexConsumer builder = null;
        for (QuasarParticle particle : this.particles) {
            RenderData renderData = particle.getRenderData();
            particle.render(partialTicks);
            renderData.renderTrails(matrixStack, bufferSource, projectedView, 15728880, partialTicks);
            Vector3dc renderPosition = renderData.getRenderPosition();
            renderOffset.set((float) (renderPosition.x() - projectedView.x()), (float) (renderPosition.y() - projectedView.y()), (float) (renderPosition.z() - projectedView.z()));
            RenderType renderType = renderData.getRenderType();
            if (!renderType.equals(lastRenderType)) {
                lastRenderType = renderType;
                builder = bufferSource.getBuffer(renderType);
                TextureAtlasSprite sprite = renderData.getAtlasSprite();
                if (sprite != null) {
                    builder = sprite.wrap(builder);
                }
            }
            renderStyle.render(matrixStack, particle, renderData, renderOffset, builder, 1.0d, partialTicks);
        }
        renderStyle.clear();
    }

    @ApiStatus.Internal
    void onRemoved() {
        remove();
        Iterator<QuasarParticle> iterator = this.particles.iterator();
        while (iterator.hasNext()) {
            iterator.next().onRemove();
            iterator.remove();
        }
    }

    public void addCodeModule(CodeModule module) {
        addModule(module);
    }

    public void addModule(ParticleModuleData module) {
        this.modules.add(module);
    }

    public void removeModule(ParticleModuleData module) {
        this.modules.remove(module);
    }

    public int trim(int count) {
        if (this.forceSpawn) {
            return 0;
        }
        Iterator<QuasarParticle> iterator = this.particles.iterator();
        int removeCount = 0;
        while (iterator.hasNext() && removeCount < count) {
            iterator.next().onRemove();
            iterator.remove();
            removeCount++;
        }
        return removeCount;
    }

    public void remove() {
        this.removed = true;
        cancelTasks();
    }

    public void reset() {
        this.removed = false;
        if (this.removeTask != null) {
            this.removeTask.cancel(false);
        }
        this.removeTask = this.particleManager.getScheduler().schedule(this::expire, this.maxLifetime).toCompletableFuture();
    }

    @Nullable
    public ResourceLocation getRegistryName() {
        return this.emitterData.getRegistryId();
    }

    public boolean isRemoved() {
        return this.removed && this.particles.isEmpty();
    }

    public Vector3d getPosition() {
        return this.position;
    }

    public ParticleEmitterData getData() {
        return this.emitterData;
    }

    public int getParticleCount() {
        return this.particles.size();
    }

    public int getMaxLifetime() {
        return this.maxLifetime;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public int getRate() {
        return this.rate;
    }

    public int getCount() {
        return this.count;
    }

    public int getMaxParticles() {
        return this.maxParticles;
    }

    public List<EmitterShapeSettings> getEmitterShapeSettings() {
        return this.emitterShapeSettings;
    }

    public ParticleSettings getParticleSettings() {
        return this.particleSettings;
    }

    public boolean isForceSpawn() {
        return this.forceSpawn;
    }

    public QuasarParticleData getParticleData() {
        return this.particleData;
    }

    @Nullable
    public Entity getAttachedEntity() {
        return this.attachedEntity;
    }

    public void setPosition(Vec3 position) {
        setPosition(position.x, position.y, position.z);
    }

    public void setPosition(Vector3dc position) {
        setPosition(position.x(), position.y(), position.z());
    }

    public void setPosition(double x, double y, double z) {
        this.offset.set(x, y, z);
        if (this.attachedEntity != null) {
            this.position.set(this.attachedEntity.getX(), this.attachedEntity.getY(), this.attachedEntity.getZ()).add(this.offset);
        } else {
            this.position.set(this.offset);
        }
    }

    public void setMaxLifetime(int maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMaxParticles(int maxParticles) {
        this.maxParticles = maxParticles;
    }

    public void setEmitterShapeSettings(List<EmitterShapeSettings> emitterShapeSettings) {
        this.emitterShapeSettings = emitterShapeSettings;
    }

    public void setParticleSettings(ParticleSettings particleSettings) {
        this.particleSettings = particleSettings;
    }

    public void setForceSpawn(boolean forceSpawn) {
        this.forceSpawn = forceSpawn;
    }

    public void setParticleData(QuasarParticleData particleData) {
        this.particleData = particleData;
    }

    public List<ParticleModuleData> getModules() {
        return this.modulesView;
    }

    public void setAttachedEntity(@Nullable Entity entity) {
        this.attachedEntity = entity;
        if (entity != null) {
            this.position.set(entity.getX(), entity.getY(), entity.getZ()).add(this.offset);
        } else {
            this.position.set(this.offset);
        }
    }
}
