package foundry.veil.api.quasar.particle;

import com.google.common.base.Suppliers;
import foundry.veil.api.TickTaskScheduler;
import foundry.veil.api.quasar.data.ParticleSettings;
import foundry.veil.api.quasar.data.QuasarParticleData;
import foundry.veil.api.quasar.emitters.module.CollisionParticleModule;
import foundry.veil.api.quasar.emitters.module.ForceParticleModule;
import foundry.veil.api.quasar.emitters.module.InitParticleModule;
import foundry.veil.api.quasar.emitters.module.ParticleModule;
import foundry.veil.api.quasar.emitters.module.RenderParticleModule;
import foundry.veil.api.quasar.emitters.module.UpdateParticleModule;
import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Vector3d;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/particle/QuasarParticle.class */
public class QuasarParticle {
    private static final double MAXIMUM_COLLISION_VELOCITY_SQUARED = Mth.square(100.0d);
    private final ClientLevel level;
    private final RandomSource randomSource;
    private final TickTaskScheduler scheduler;
    private final QuasarParticleData data;
    private final ParticleSettings settings;
    private final ParticleEmitter emitter;
    private final ParticleModuleSet modules;
    private final Vector3d position = new Vector3d();
    private final Vector3d velocity = new Vector3d();
    private final Vector3f rotation = new Vector3f();
    private final BlockPos.MutableBlockPos blockPosition = new BlockPos.MutableBlockPos();
    private final boolean hasCollision;
    private float radius;
    private final int lifetime;
    private int age;
    private AABB boundingBox;
    private boolean stoppedByCollision;
    private final Supplier<MolangRuntime> environment;
    private final RenderData renderData;

    public QuasarParticle(ClientLevel level, RandomSource randomSource, TickTaskScheduler scheduler, QuasarParticleData data, ParticleModuleSet modules, ParticleSettings settings, ParticleEmitter emitter) {
        this.level = level;
        this.randomSource = randomSource;
        this.scheduler = scheduler;
        this.data = data;
        this.settings = settings;
        this.emitter = emitter;
        this.modules = modules;
        this.hasCollision = this.modules.getCollisionModules().length > 0;
        this.radius = settings.particleSize(this.randomSource);
        this.lifetime = settings.particleLifetime(this.randomSource);
        this.age = 0;
        this.renderData = new RenderData(this, data);
        this.environment = Suppliers.memoize(() -> {
            MolangRuntime.Builder query = MolangRuntime.runtime().setQuery("x", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.renderData.getRenderPosition().x());
            })).setQuery("y", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.renderData.getRenderPosition().y());
            })).setQuery("z", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.renderData.getRenderPosition().z());
            })).setQuery("velX", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.velocity.x());
            })).setQuery("velY", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.velocity.y());
            })).setQuery("velZ", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.velocity.z());
            })).setQuery("speedSq", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.velocity.lengthSquared());
            })).setQuery("speed", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) this.velocity.length());
            })).setQuery("xRot", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) Math.toDegrees(this.renderData.getRenderRotation().x()));
            })).setQuery("yRot", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) Math.toDegrees(this.renderData.getRenderRotation().y()));
            })).setQuery("zRot", MolangExpression.of((Supplier<Float>) () -> {
                return Float.valueOf((float) Math.toDegrees(this.renderData.getRenderRotation().z()));
            }));
            RenderData renderData = this.renderData;
            Objects.requireNonNull(renderData);
            MolangRuntime.Builder query2 = query.setQuery("scale", MolangExpression.of((Supplier<Float>) renderData::getRenderRadius));
            RenderData renderData2 = this.renderData;
            Objects.requireNonNull(renderData2);
            MolangRuntime.Builder query3 = query2.setQuery("age", MolangExpression.of((Supplier<Float>) renderData2::getRenderAge));
            RenderData renderData3 = this.renderData;
            Objects.requireNonNull(renderData3);
            return (MolangRuntime) query3.setQuery("agePercent", MolangExpression.of((Supplier<Float>) renderData3::getAgePercent)).setQuery("lifetime", this.lifetime).create();
        });
    }

    private void move(double dx, double dy, double dz) {
        if (this.stoppedByCollision) {
            return;
        }
        if (dx == 0.0d && dy == 0.0d && dz == 0.0d) {
            return;
        }
        AABB box = getBoundingBox();
        if (this.hasCollision && (dx * dx) + (dy * dy) + (dz * dz) < MAXIMUM_COLLISION_VELOCITY_SQUARED) {
            Vec3 vec3 = Entity.collideBoundingBox((Entity) null, new Vec3(dx, dy, dz), box, this.level, List.of());
            dx = vec3.x;
            dy = vec3.y;
            dz = vec3.z;
        }
        if (dx != 0.0d || dy != 0.0d || dz != 0.0d) {
            this.position.add(dx, dy, dz);
            updateBoundingBox();
        }
        if (!this.hasCollision) {
            return;
        }
        List<Entity> entities = this.level.getEntities((Entity) null, box);
        Iterator<Entity> it = entities.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entity next = it.next();
            if (next instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) next;
                if (livingEntity.isAlive()) {
                    this.stoppedByCollision = true;
                    break;
                }
            }
        }
        if (Math.abs(dy) >= 9.999999747378752E-6d && Math.abs(dy) < 9.999999747378752E-6d) {
            this.stoppedByCollision = true;
        }
        if (dx != dx) {
            this.velocity.x = 0.0d;
            this.stoppedByCollision = true;
        }
        if (dy != dy) {
            this.velocity.y = 0.0d;
            this.stoppedByCollision = true;
        }
        if (dz != dz) {
            this.velocity.z = 0.0d;
            this.stoppedByCollision = true;
        }
        if (this.stoppedByCollision) {
            for (CollisionParticleModule collisionParticle : this.modules.getCollisionModules()) {
                collisionParticle.collide(this);
            }
        }
    }

    private void updateBoundingBox() {
        double r = ((double) this.radius) / 2.0d;
        this.boundingBox = new AABB(this.position.x - r, this.position.y - r, this.position.z - r, this.position.x + r, this.position.y + r, this.position.z + r);
    }

    private int getLightColor() {
        return LevelRenderer.getLightColor(this.level, getBlockPosition());
    }

    @ApiStatus.Internal
    public void init() {
        for (InitParticleModule initModule : this.modules.getInitModules()) {
            initModule.init(this);
        }
        int packedLight = this.renderData.getFixedPackedLight();
        this.renderData.tick(this, packedLight == -1 ? getLightColor() : packedLight);
        updateBoundingBox();
    }

    @ApiStatus.Internal
    public void tick() {
        int packedLight = this.renderData.getFixedPackedLight();
        this.renderData.tick(this, packedLight == -1 ? getLightColor() : packedLight);
        this.modules.updateEnabled();
        for (UpdateParticleModule updateModule : this.modules.getUpdateModules()) {
            updateModule.update(this);
        }
        for (ForceParticleModule updateModule2 : this.modules.getForceModules()) {
            updateModule2.applyForce(this);
        }
        move(this.velocity.x, this.velocity.y, this.velocity.z);
        this.age++;
        if (this.age >= this.lifetime) {
            remove();
        }
    }

    @ApiStatus.Internal
    public void render(float partialTicks) {
        int count = this.modules.getEnabledRenderModuleCount();
        RenderParticleModule[] modules = this.modules.getEnabledRenderModulesArray();
        for (int i = 0; i < count; i++) {
            modules[i].render(this, partialTicks);
        }
        this.renderData.render(this, partialTicks);
    }

    @ApiStatus.Internal
    public void onRemove() {
        remove();
        for (ParticleModule module : this.modules.getAllModules()) {
            module.onRemove();
        }
    }

    public void remove() {
        this.age = Integer.MIN_VALUE;
    }

    public boolean isRemoved() {
        return this.age < 0;
    }

    public ClientLevel getLevel() {
        return this.level;
    }

    public RandomSource getRandomSource() {
        return this.randomSource;
    }

    public TickTaskScheduler getScheduler() {
        return this.scheduler;
    }

    public QuasarParticleData getData() {
        return this.data;
    }

    public ParticleSettings getSettings() {
        return this.settings;
    }

    public ParticleEmitter getEmitter() {
        return this.emitter;
    }

    public ParticleModuleSet getModules() {
        return this.modules;
    }

    public Vector3d getPosition() {
        return this.position;
    }

    public BlockPos getBlockPosition() {
        return this.blockPosition.set(this.position.x, this.position.y, this.position.z);
    }

    public Vector3d getVelocity() {
        return this.velocity;
    }

    public BlockState getBlockStateInOrUnder() {
        BlockState in = this.level.getBlockState(BlockPos.containing(this.position.x, this.position.y + 0.5d, this.position.z));
        if (!in.isAir()) {
            return in;
        }
        return this.level.getBlockState(BlockPos.containing(this.position.x, this.position.y - 0.5d, this.position.z));
    }

    public Vector3f getRotation() {
        return this.rotation;
    }

    public float getRadius() {
        return this.radius;
    }

    public int getAge() {
        return this.age;
    }

    public int getLifetime() {
        return this.lifetime;
    }

    public AABB getBoundingBox() {
        return this.boundingBox;
    }

    public RenderData getRenderData() {
        return this.renderData;
    }

    public MolangEnvironment getEnvironment() {
        return this.environment.get();
    }

    public void vectorToRotation(double x, double y, double z) {
        this.rotation.set((float) Math.asin(y), (float) Math.atan2(x, z), 0.0f);
    }

    public void setRadius(float radius) {
        this.radius = radius;
        updateBoundingBox();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
