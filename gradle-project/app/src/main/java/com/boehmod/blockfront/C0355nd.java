package com.boehmod.blockfront;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nd.class */
public class C0355nd extends mA implements InterfaceC0347mw {
    private int lA;
    static final /* synthetic */ boolean eO;

    static {
        eO = !C0355nd.class.desiredAssertionStatus();
    }

    public C0355nd(EntityType<? extends C0355nd> entityType, Level level) {
        super(entityType, level);
        this.lA = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0347mw
    public void a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.f236a = player;
        a(itemStack);
        float f4 = f;
        if (((int) (player.getDeltaMovement().x * 100.0d)) + 7 < 0) {
            f4 += 0.3f;
        }
        a(player.getEyePosition(), player.getYRot(), player.getXRot(), f, f4);
    }

    @Override // com.boehmod.blockfront.InterfaceC0347mw
    public void a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        a(itemStack);
        a(vec3, f2, f3, f, f);
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (eO || abstractC0264juM166a != null) {
                return !abstractC0264juM166a.m531a().m305a(player).dk();
            }
            throw new AssertionError("Mod manager is null!");
        }
        return true;
    }

    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Player entity = entityHitResult.getEntity();
        if (entity.isRemoved()) {
            return;
        }
        if (entity instanceof Player) {
            Player player = entity;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!eO && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0264juM166a.m531a().m305a(player).dk()) {
                return;
            }
        }
        bu();
    }

    @Override // com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        int i = this.lA;
        this.lA = i + 1;
        if (i >= aG()) {
            bu();
        }
    }

    @Override // com.boehmod.blockfront.mA
    public float ar() {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.mA
    public float as() {
        return 0.0f;
    }

    public int aG() {
        return 60;
    }

    @Override // com.boehmod.blockfront.mA
    protected void onHit(@NotNull HitResult hitResult) {
        Level level = level();
        if (hitResult instanceof EntityHitResult) {
            LivingEntity entity = ((EntityHitResult) hitResult).getEntity();
            if (entity instanceof LivingEntity) {
                entity.hurt(new C0326mb(level.damageSources().generic().typeHolder(), this.f236a, getItem()), 40.0f);
            }
        }
        setDeltaMovement(0.0d, 0.0d, 0.0d);
        if (!this.ew) {
            bu();
        }
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        discard();
    }

    @Override // com.boehmod.blockfront.mA
    protected boolean aA() {
        return false;
    }
}
