package com.boehmod.blockfront;

import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iG.class */
public class C0470iG {

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final AtomicInteger f2908b = new AtomicInteger(1073741823);

    /* JADX INFO: renamed from: a */
    public static void m2121a(@NotNull Entity entity, @NotNull ClientLevel clientLevel) {
        try {
            entity.setId(f2908b.getAndIncrement());
            clientLevel.addEntity(entity);
        } catch (ArrayIndexOutOfBoundsException e) {
            C0562jt.m2516a("Failed to spawn client-side entity!", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2122a(@NotNull Entity entity) {
        return entity.getId() > 1073741823;
    }

    /* JADX INFO: renamed from: a */
    public static void m2123a(@NotNull Minecraft minecraft, @NotNull Entity entity) {
        if (minecraft.getCameraEntity() == entity) {
            return;
        }
        C0562jt.log("Setting camera entity to %s", entity);
        minecraft.setCameraEntity(entity);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2124a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(clientLevel.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * clientLevel.random.nextDouble();
            double dAcos = Math.acos((2.0d * clientLevel.random.nextDouble()) - 1.0d);
            m2126a(minecraft, c0622l, clientLevel, particleOptions, vec3.x + (dCbrt * Math.sin(dAcos) * Math.cos(dNextDouble)), vec3.y + (dCbrt * Math.sin(dAcos) * Math.sin(dNextDouble)), vec3.z + (dCbrt * Math.cos(dAcos)), ((double) f3) * Math.sin(dAcos) * Math.cos(dNextDouble), ((double) f3) * Math.sin(dAcos) * Math.sin(dNextDouble), ((double) f3) * Math.cos(dAcos));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2125b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(clientLevel.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * clientLevel.random.nextDouble();
            double dAcos = Math.acos(clientLevel.random.nextDouble());
            m2126a(minecraft, c0622l, clientLevel, particleOptions, vec3.x + (dCbrt * Math.sin(dAcos) * Math.cos(dNextDouble)), vec3.y + (dCbrt * Math.sin(dAcos) * Math.sin(dNextDouble)), vec3.z + (dCbrt * Math.cos(dAcos)), ((double) f3) * Math.sin(dAcos) * Math.cos(dNextDouble), ((double) f3) * Math.sin(dAcos) * Math.sin(dNextDouble), ((double) f3) * Math.cos(dAcos));
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T extends ParticleOptions> void m2126a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull T t, double d, double d2, double d3, double d4, double d5, double d6) {
        Particle particleCreateParticle = ((ParticleProvider) minecraft.particleEngine.providers.get(BuiltInRegistries.PARTICLE_TYPE.getKey(t.getType()))).createParticle(t, clientLevel, d, d2, d3, d4, d5, d6);
        C0319fO c0319fOM2686a = c0622l.m2686a();
        if (particleCreateParticle instanceof InterfaceC0318fN) {
            c0319fOM2686a.m1629a((InterfaceC0318fN) particleCreateParticle);
            return;
        }
        if (particleCreateParticle instanceof InterfaceC0311fG) {
            c0319fOM2686a.m1630a((InterfaceC0311fG) particleCreateParticle);
        } else if (particleCreateParticle instanceof InterfaceC0354fx) {
            c0319fOM2686a.m1631a((InterfaceC0354fx) particleCreateParticle);
        } else {
            clientLevel.addParticle(t, true, d, d2, d3, d4, d5, d6);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2127a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull ParticleOptions particleOptions, float f) throws MatchException {
        m2128a(minecraft, c0622l, clientLevel, vec3, direction, particleOptions, f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m2128a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull ParticleOptions particleOptions, float f, float f2) throws MatchException {
        Vec3 vec3Add = vec3.add(new Vec3(direction.getStepX(), direction.getStepY(), direction.getStepZ()).scale(f2));
        Vec3 vec3M7868a = C1290xm.m7868a(direction, f);
        m2126a(minecraft, c0622l, clientLevel, particleOptions, vec3Add.x, vec3Add.y, vec3Add.z, vec3M7868a.x, vec3M7868a.y, vec3M7868a.z);
    }

    /* JADX INFO: renamed from: a */
    public static void m2129a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull BlockState blockState, float f) throws MatchException {
        Vec3 vec3M7868a = C1290xm.m7868a(direction, f);
        if (!blockState.isAir()) {
            BlockParticleOption pos = new BlockParticleOption(ParticleTypes.BLOCK, blockState).setPos(blockPos);
            for (int i = 0; i < 5; i++) {
                m2126a(minecraft, c0622l, clientLevel, pos, vec3.x, vec3.y, vec3.z, vec3M7868a.x, vec3M7868a.y, vec3M7868a.z);
            }
        }
    }
}
