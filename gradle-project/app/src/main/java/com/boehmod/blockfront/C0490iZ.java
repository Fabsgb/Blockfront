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

/* JADX INFO: renamed from: com.boehmod.blockfront.iZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iZ.class */
public class C0490iZ {

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final AtomicInteger f2997c = new AtomicInteger(1073741823);

    /* JADX INFO: renamed from: a */
    public static void m2213a(@NotNull Entity entity, @NotNull ClientLevel clientLevel) {
        try {
            entity.setId(f2997c.getAndIncrement());
            clientLevel.addEntity(entity);
        } catch (ArrayIndexOutOfBoundsException e) {
            C0530jM.m2338a("Failed to spawn client-side entity!", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2214a(@NotNull Entity entity) {
        return entity.getId() > 1073741823;
    }

    /* JADX INFO: renamed from: a */
    public static void m2215a(@NotNull Minecraft minecraft, @NotNull Entity entity) {
        if (minecraft.getCameraEntity() == entity) {
            return;
        }
        C0530jM.log("Setting camera entity to %s", entity);
        minecraft.setCameraEntity(entity);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static void m2216a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(clientLevel.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * clientLevel.random.nextDouble();
            double dAcos = Math.acos((2.0d * clientLevel.random.nextDouble()) - 1.0d);
            m2218a(minecraft, c0623l, clientLevel, particleOptions, vec3.x + (dCbrt * Math.sin(dAcos) * Math.cos(dNextDouble)), vec3.y + (dCbrt * Math.sin(dAcos) * Math.sin(dNextDouble)), vec3.z + (dCbrt * Math.cos(dAcos)), ((double) f3) * Math.sin(dAcos) * Math.cos(dNextDouble), ((double) f3) * Math.sin(dAcos) * Math.sin(dNextDouble), ((double) f3) * Math.cos(dAcos));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2217b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull ParticleOptions particleOptions, @NotNull Vec3 vec3, float f, float f2, int i, float f3) {
        for (int i2 = 0; i2 < i; i2++) {
            double dCbrt = ((double) f) + (((double) (f2 - f)) * Math.cbrt(clientLevel.random.nextDouble()));
            double dNextDouble = 6.283185307179586d * clientLevel.random.nextDouble();
            double dAcos = Math.acos(clientLevel.random.nextDouble());
            m2218a(minecraft, c0623l, clientLevel, particleOptions, vec3.x + (dCbrt * Math.sin(dAcos) * Math.cos(dNextDouble)), vec3.y + (dCbrt * Math.sin(dAcos) * Math.sin(dNextDouble)), vec3.z + (dCbrt * Math.cos(dAcos)), ((double) f3) * Math.sin(dAcos) * Math.cos(dNextDouble), ((double) f3) * Math.sin(dAcos) * Math.sin(dNextDouble), ((double) f3) * Math.cos(dAcos));
        }
    }

    /* JADX INFO: renamed from: a */
    public static <T extends ParticleOptions> void m2218a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull T t, double d, double d2, double d3, double d4, double d5, double d6) {
        Particle particleCreateParticle = ((ParticleProvider) minecraft.particleEngine.providers.get(BuiltInRegistries.PARTICLE_TYPE.getKey(t.getType()))).createParticle(t, clientLevel, d, d2, d3, d4, d5, d6);
        C0389ge c0389geM2872a = c0623l.m2872a();
        if (particleCreateParticle instanceof InterfaceC0388gd) {
            c0389geM2872a.m1839a((InterfaceC0388gd) particleCreateParticle);
            return;
        }
        if (particleCreateParticle instanceof InterfaceC0328fW) {
            c0389geM2872a.m1840a((InterfaceC0328fW) particleCreateParticle);
        } else if (particleCreateParticle instanceof InterfaceC0319fN) {
            c0389geM2872a.m1841a((InterfaceC0319fN) particleCreateParticle);
        } else {
            clientLevel.addParticle(t, true, d, d2, d3, d4, d5, d6);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: a */
    public static void m2219a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull ParticleOptions particleOptions, float f) throws MatchException {
        m2220a(minecraft, c0623l, clientLevel, vec3, direction, particleOptions, f, 0.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: a */
    public static void m2220a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull ParticleOptions particleOptions, float f, float f2) throws MatchException {
        Vec3 vec3Add = vec3.add(new Vec3(direction.getStepX(), direction.getStepY(), direction.getStepZ()).scale(f2));
        Vec3 vec3M7195a = C1270xJ.m7195a(direction, f);
        m2218a(minecraft, c0623l, clientLevel, particleOptions, vec3Add.x, vec3Add.y, vec3Add.z, vec3M7195a.x, vec3M7195a.y, vec3M7195a.z);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: a */
    public static void m2221a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull Vec3 vec3, @NotNull Direction direction, @NotNull BlockState blockState, float f) throws MatchException {
        Vec3 vec3M7195a = C1270xJ.m7195a(direction, f);
        if (!blockState.isAir()) {
            BlockParticleOption pos = new BlockParticleOption(ParticleTypes.BLOCK, blockState).setPos(blockPos);
            for (int i = 0; i < 5; i++) {
                m2218a(minecraft, c0623l, clientLevel, pos, vec3.x, vec3.y, vec3.z, vec3M7195a.x, vec3M7195a.y, vec3M7195a.z);
            }
        }
    }
}
