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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iG.class */
public class iG {

    @NotNull
    private static final AtomicInteger b = new AtomicInteger(1073741823);

    public static void a(@NotNull Entity entity, @NotNull ClientLevel clientLevel) {
        try {
            entity.setId(b.getAndIncrement());
            clientLevel.addEntity(entity);
        } catch (ArrayIndexOutOfBoundsException e) {
            C0263jt.a("Failed to spawn client-side entity!", e, new Object[0]);
        }
    }

    public static boolean a(@NotNull Entity entity) {
        return entity.getId() > 1073741823;
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull Entity entity) {
        if (minecraft.getCameraEntity() == entity) {
            return;
        }
        C0263jt.log("Setting camera entity to %s", entity);
        minecraft.setCameraEntity(entity);
    }

    @OnlyIn(Dist.CLIENT)
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(clientLevel.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * clientLevel.random.nextDouble();
            double dAcos = Math.acos((2.0d * clientLevel.random.nextDouble()) - 1.0d);
            a(minecraft, c0297l, clientLevel, particleOptions, vec3.x + (dCbrt * Math.sin(dAcos) * Math.cos(dNextDouble)), vec3.y + (dCbrt * Math.sin(dAcos) * Math.sin(dNextDouble)), vec3.z + (dCbrt * Math.cos(dAcos)), ((double) f3) * Math.sin(dAcos) * Math.cos(dNextDouble), ((double) f3) * Math.sin(dAcos) * Math.sin(dNextDouble), ((double) f3) * Math.cos(dAcos));
        }
    }

    public static void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(clientLevel.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * clientLevel.random.nextDouble();
            double dAcos = Math.acos(clientLevel.random.nextDouble());
            a(minecraft, c0297l, clientLevel, particleOptions, vec3.x + (dCbrt * Math.sin(dAcos) * Math.cos(dNextDouble)), vec3.y + (dCbrt * Math.sin(dAcos) * Math.sin(dNextDouble)), vec3.z + (dCbrt * Math.cos(dAcos)), ((double) f3) * Math.sin(dAcos) * Math.cos(dNextDouble), ((double) f3) * Math.sin(dAcos) * Math.sin(dNextDouble), ((double) f3) * Math.cos(dAcos));
        }
    }

    public static <T extends ParticleOptions> void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull T t, double d, double d2, double d3, double d4, double d5, double d6) {
        Particle particleCreateParticle = ((ParticleProvider) minecraft.particleEngine.providers.get(BuiltInRegistries.PARTICLE_TYPE.getKey(t.getType()))).createParticle(t, clientLevel, d, d2, d3, d4, d5, d6);
        fO fOVarM590a = c0297l.m590a();
        if (particleCreateParticle instanceof fN) {
            fOVarM590a.a((fN) particleCreateParticle);
            return;
        }
        if (particleCreateParticle instanceof fG) {
            fOVarM590a.a((fG) particleCreateParticle);
        } else if (particleCreateParticle instanceof InterfaceC0160fx) {
            fOVarM590a.a((InterfaceC0160fx) particleCreateParticle);
        } else {
            clientLevel.addParticle(t, true, d, d2, d3, d4, d5, d6);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull ParticleOptions particleOptions, float f) throws MatchException {
        a(minecraft, c0297l, clientLevel, vec3, direction, particleOptions, f, 0.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull ParticleOptions particleOptions, float f, float f2) throws MatchException {
        Vec3 vec3Add = vec3.add(new Vec3(direction.getStepX(), direction.getStepY(), direction.getStepZ()).scale(f2));
        Vec3 vec3A = C0634xm.a(direction, f);
        a(minecraft, c0297l, clientLevel, particleOptions, vec3Add.x, vec3Add.y, vec3Add.z, vec3A.x, vec3A.y, vec3A.z);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull BlockState blockState, float f) throws MatchException {
        Vec3 vec3A = C0634xm.a(direction, f);
        if (!blockState.isAir()) {
            BlockParticleOption pos = new BlockParticleOption(ParticleTypes.BLOCK, blockState).setPos(blockPos);
            for (int i = 0; i < 5; i++) {
                a(minecraft, c0297l, clientLevel, pos, vec3.x, vec3.y, vec3.z, vec3A.x, vec3A.y, vec3A.z);
            }
        }
    }
}
