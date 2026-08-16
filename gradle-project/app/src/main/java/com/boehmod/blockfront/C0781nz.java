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

/* JADX INFO: renamed from: com.boehmod.blockfront.nz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nz.class */
public class C0781nz extends AbstractC0699mW implements InterfaceC0695mS {

    /* JADX INFO: renamed from: ny */
    private int f4324ny;

    /* JADX INFO: renamed from: fi */
    static final /* synthetic */ boolean f4325fi;

    static {
        f4325fi = !C0781nz.class.desiredAssertionStatus();
    }

    public C0781nz(EntityType<? extends C0781nz> entityType, Level level) {
        super(entityType, level);
        this.f4324ny = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0695mS
    /* JADX INFO: renamed from: a */
    public void mo3118a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.f3861a = player;
        mo3122a(itemStack);
        float f4 = f;
        if (((int) (player.getDeltaMovement().x * 100.0d)) + 7 < 0) {
            f4 += 0.3f;
        }
        m3129a(player.getEyePosition(), player.getYRot(), player.getXRot(), f, f4);
    }

    @Override // com.boehmod.blockfront.InterfaceC0695mS
    /* JADX INFO: renamed from: a */
    public void mo3119a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        mo3122a(itemStack);
        m3129a(vec3, f2, f3, f, f);
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (f4325fi || abstractC0531jNM179a != null) {
                return !abstractC0531jNM179a.m2351a().m1153a(player).m1104dt();
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
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!f4325fi && abstractC0531jNM179a == null) {
                throw new AssertionError("Mod manager is null!");
            }
            if (abstractC0531jNM179a.m2351a().m1153a(player).m1104dt()) {
                return;
            }
        }
        mo3132bF();
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        int i = this.f4324ny;
        this.f4324ny = i + 1;
        if (i >= m3657aV()) {
            mo3132bF();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 1.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ay */
    public float mo3140ay() {
        return 0.0f;
    }

    /* JADX INFO: renamed from: aV */
    public int m3657aV() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    protected void onHit(@NotNull HitResult hitResult) {
        Level level = level();
        if (hitResult instanceof EntityHitResult) {
            LivingEntity entity = ((EntityHitResult) hitResult).getEntity();
            if (entity instanceof LivingEntity) {
                entity.hurt(new C0726mx(level.damageSources().generic().typeHolder(), this.f3861a, getItem()), 40.0f);
            }
        }
        setDeltaMovement(0.0d, 0.0d, 0.0d);
        if (!this.f3862eQ) {
            mo3132bF();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        discard();
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: aL */
    protected boolean mo3135aL() {
        return false;
    }
}
