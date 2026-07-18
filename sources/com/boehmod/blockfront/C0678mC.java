package com.boehmod.blockfront;

import com.boehmod.blockfront.C0865pe;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mC.class */
public final class C0678mC extends C0727mz {

    /* JADX INFO: renamed from: d */
    private static final EntityDataAccessor<String> f3620d = SynchedEntityData.defineId(C0678mC.class, EntityDataSerializers.STRING);

    /* JADX INFO: renamed from: kO */
    public int f3621kO;

    /* JADX INFO: renamed from: ag */
    private List<C0865pe.a> f3622ag;

    public C0678mC(EntityType<? extends C0678mC> entityType, Level level) {
        super(entityType, level);
        this.f3621kO = 0;
        this.f3622ag = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3002a() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5d).add(Attributes.MAX_HEALTH, 20.0d);
    }

    /* JADX INFO: renamed from: a */
    public void m3003a(@NotNull Level level, @NotNull C0865pe c0865pe) {
        m3004r(c0865pe.skin);
        setPos(c0865pe.f4424c);
        setRot(c0865pe.f4423h.y, c0865pe.f4423h.x);
        setYHeadRot(c0865pe.f4536ky);
        C0799oR.m4023a(level, (LivingEntity) this, c0865pe.f4537a);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new C0679mD(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3620d, "us_soldier_0");
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("skin", getSkin());
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        m3004r(compoundTag.getString("skin"));
    }

    public String getSkin() {
        return (String) this.entityData.get(f3620d);
    }

    /* JADX INFO: renamed from: r */
    public void m3004r(@NotNull String str) {
        this.entityData.set(f3620d, str);
    }

    /* JADX INFO: renamed from: t */
    public List<C0865pe.a> m3005t() {
        return this.f3622ag;
    }

    /* JADX INFO: renamed from: f */
    public void m3006f(@NotNull List<C0865pe.a> list) {
        this.f3622ag = list;
    }

    /* JADX INFO: renamed from: r */
    public ResourceLocation m3007r() {
        return C0564jv.m2555d("textures/models/entities/human/" + getSkin().toLowerCase(Locale.ROOT) + ".png");
    }
}
