package foundry.veil.api.quasar.particle;

import foundry.veil.Veil;
import foundry.veil.api.TickTaskScheduler;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.quasar.data.ParticleEmitterData;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.impl.TickTaskSchedulerImpl;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/ParticleSystemManager.class */
public class ParticleSystemManager {
    private static final int MAX_PARTICLES = 10000;
    private static final double PERSISTENT_DISTANCE_SQ = 1024.0d;
    private static final double REMOVAL_DISTANCE_SQ = 16384.0d;
    private final List<ParticleEmitter> particleEmitters = new ArrayList();
    private final Set<ResourceLocation> invalidEmitters = new HashSet();
    private final AtomicInteger particleCount = new AtomicInteger();
    private ClientLevel level = null;
    private TickTaskSchedulerImpl scheduler = null;

    @ApiStatus.Internal
    public void setLevel(@Nullable ClientLevel level) {
        clear();
        if (this.scheduler != null) {
            this.scheduler.shutdown();
        }
        this.level = level;
        this.scheduler = new TickTaskSchedulerImpl();
    }

    @Nullable
    public ParticleEmitter createEmitter(ResourceLocation name) {
        if (this.level == null) {
            return null;
        }
        ParticleEmitterData data = (ParticleEmitterData) QuasarParticles.registryAccess().registry(QuasarParticles.EMITTER).map(registry -> {
            return (ParticleEmitterData) registry.get(name);
        }).orElse(null);
        if (data == null) {
            if (this.invalidEmitters.add(name)) {
                Veil.LOGGER.error("Unknown Quasar Particle Emitter: {}", name);
                return null;
            }
            return null;
        }
        return new ParticleEmitter(this, this.level, data);
    }

    public void addParticleSystem(ParticleEmitter particleEmitter) {
        this.particleEmitters.add(particleEmitter);
        particleEmitter.onAdd();
    }

    public void clear() {
        for (ParticleEmitter particleEmitter : this.particleEmitters) {
            particleEmitter.onRemoved();
        }
        this.particleEmitters.clear();
    }

    @ApiStatus.Internal
    public void tick() {
        if (this.level == null) {
            return;
        }
        this.scheduler.run();
        this.particleCount.set(0);
        Iterator<ParticleEmitter> iterator = this.particleEmitters.iterator();
        while (iterator.hasNext()) {
            ParticleEmitter emitter = iterator.next();
            emitter.tick();
            if (emitter.isRemoved()) {
                emitter.onRemoved();
                iterator.remove();
            } else {
                this.particleCount.addAndGet(emitter.getParticleCount());
            }
        }
    }

    @ApiStatus.Internal
    public void render(MatrixStack matrixStack, MultiBufferSource bufferSource, Camera camera, CullFrustum frustum, float partialTicks) {
        this.particleEmitters.sort(Comparator.comparingDouble(a -> {
            return -a.getPosition().distanceSquared(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z);
        }));
        for (ParticleEmitter emitter : this.particleEmitters) {
            emitter.render(matrixStack, bufferSource, camera, partialTicks);
        }
    }

    public void reserve(int particles) {
        int freeSpace = MAX_PARTICLES - this.particleCount.getAndAdd(-particles);
        if (particles <= freeSpace) {
            return;
        }
        int particles2 = particles - freeSpace;
        Entity cameraEntity = Minecraft.getInstance().cameraEntity;
        for (ParticleEmitter emitter : this.particleEmitters) {
            Vector3d pos = emitter.getPosition();
            double scaleFactor = Math.min(cameraEntity != null ? (cameraEntity.distanceToSqr(pos.x, pos.y, pos.z) - PERSISTENT_DISTANCE_SQ) / REMOVAL_DISTANCE_SQ : 1.0d, 1.0d);
            if (scaleFactor > 0.0d) {
                particles2 -= emitter.trim(Math.min(particles2, Mth.ceil(((double) emitter.getParticleCount()) * scaleFactor)));
                if (particles2 <= 0) {
                    return;
                }
            }
        }
    }

    public ClientLevel getLevel() {
        return this.level;
    }

    public TickTaskScheduler getScheduler() {
        return this.scheduler;
    }

    public int getEmitterCount() {
        return this.particleEmitters.size();
    }

    public int getParticleCount() {
        return this.particleCount.get();
    }
}
