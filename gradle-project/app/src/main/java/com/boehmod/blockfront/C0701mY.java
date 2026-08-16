package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.mY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mY.class */
public final class C0701mY extends C0698mV {

    /* JADX INFO: renamed from: d */
    private static final EntityDataAccessor<String> f3870d = SynchedEntityData.defineId(C0701mY.class, EntityDataSerializers.STRING);

    /* JADX INFO: renamed from: mM */
    public int f3871mM;

    /* JADX INFO: renamed from: an */
    private List<C0836pA.a> f3872an;

    public C0701mY(EntityType<? extends C0701mY> entityType, Level level) {
        super(entityType, level);
        this.f3871mM = 0;
        this.f3872an = new ObjectArrayList();
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3153a() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5d).add(Attributes.MAX_HEALTH, 20.0d);
    }

    /* JADX INFO: renamed from: a */
    public void m3154a(@NotNull Level level, @NotNull C0836pA c0836pA) {
        m3155r(c0836pA.skin);
        setPos(c0836pA.f4827c);
        setRot(c0836pA.f4826h.y, c0836pA.f4826h.x);
        setYHeadRot(c0836pA.f4505lt);
        C0875pn.m4459a(level, (LivingEntity) this, c0836pA.f4506a);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new C0702mZ(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3870d, "us_soldier_0");
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("skin", getSkin());
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        m3155r(compoundTag.getString("skin"));
    }

    public String getSkin() {
        return (String) this.entityData.get(f3870d);
    }

    /* JADX INFO: renamed from: r */
    public void m3155r(@NotNull String str) {
        this.entityData.set(f3870d, str);
    }

    /* JADX INFO: renamed from: v */
    public List<C0836pA.a> m3156v() {
        return this.f3872an;
    }

    /* JADX INFO: renamed from: g */
    public void m3157g(@NotNull List<C0836pA.a> list) {
        this.f3872an = list;
    }

    /* JADX INFO: renamed from: s */
    public ResourceLocation m3158s() {
        return C0532jO.m2378d("textures/models/entities/human/" + getSkin().toLowerCase(Locale.ROOT) + ".png");
    }
}
