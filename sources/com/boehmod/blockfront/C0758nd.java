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

/* JADX INFO: renamed from: com.boehmod.blockfront.nd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nd.class */
public class C0758nd extends AbstractC0676mA implements InterfaceC0724mw {

    /* JADX INFO: renamed from: lA */
    private int f4069lA;

    /* JADX INFO: renamed from: eO */
    static final /* synthetic */ boolean f4070eO;

    static {
        f4070eO = !C0758nd.class.desiredAssertionStatus();
    }

    public C0758nd(EntityType<? extends C0758nd> entityType, Level level) {
        super(entityType, level);
        this.f4069lA = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0724mw
    /* JADX INFO: renamed from: a */
    public void mo3283a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.f3611a = player;
        mo2971a(itemStack);
        float f4 = f;
        if (((int) (player.getDeltaMovement().x * 100.0d)) + 7 < 0) {
            f4 += 0.3f;
        }
        m2978a(player.getEyePosition(), player.getYRot(), player.getXRot(), f, f4);
    }

    @Override // com.boehmod.blockfront.InterfaceC0724mw
    /* JADX INFO: renamed from: a */
    public void mo3284a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        mo2971a(itemStack);
        m2978a(vec3, f2, f3, f, f);
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (f4070eO || abstractC0563juM168a != null) {
                return !abstractC0563juM168a.m2528a().m1136a(player).m1087dk();
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
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f4070eO && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0563juM168a.m2528a().m1136a(player).m1087dk()) {
                return;
            }
        }
        mo2981bu();
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        int i = this.f4069lA;
        this.f4069lA = i + 1;
        if (i >= m3427aG()) {
            mo2981bu();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: as */
    public float mo2989as() {
        return 0.0f;
    }

    /* JADX INFO: renamed from: aG */
    public int m3427aG() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    protected void onHit(@NotNull HitResult hitResult) {
        Level level = level();
        if (hitResult instanceof EntityHitResult) {
            LivingEntity entity = ((EntityHitResult) hitResult).getEntity();
            if (entity instanceof LivingEntity) {
                entity.hurt(new C0703mb(level.damageSources().generic().typeHolder(), this.f3611a, getItem()), 40.0f);
            }
        }
        setDeltaMovement(0.0d, 0.0d, 0.0d);
        if (!this.f3612ew) {
            mo2981bu();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        discard();
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: aA */
    protected boolean mo2984aA() {
        return false;
    }
}
