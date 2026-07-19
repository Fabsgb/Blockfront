package com.boehmod.blockfront;

import com.boehmod.blockfront.C0410pe;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mC.class */
public final class mC extends C0350mz {
    private static final EntityDataAccessor<String> d = SynchedEntityData.defineId(mC.class, EntityDataSerializers.STRING);
    public int kO;
    private List<C0410pe.a> ag;

    public mC(EntityType<? extends mC> entityType, Level level) {
        super(entityType, level);
        this.kO = 0;
        this.ag = new ObjectArrayList();
    }

    public static AttributeSupplier.Builder a() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5d).add(Attributes.MAX_HEALTH, 20.0d);
    }

    public void a(@NotNull Level level, @NotNull C0410pe c0410pe) {
        r(c0410pe.skin);
        setPos(c0410pe.c);
        setRot(c0410pe.h.y, c0410pe.h.x);
        setYHeadRot(c0410pe.ky);
        oR.a(level, (LivingEntity) this, c0410pe.a);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new mD(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(d, "us_soldier_0");
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("skin", getSkin());
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        r(compoundTag.getString("skin"));
    }

    public String getSkin() {
        return (String) this.entityData.get(d);
    }

    public void r(@NotNull String str) {
        this.entityData.set(d, str);
    }

    public List<C0410pe.a> t() {
        return this.ag;
    }

    public void f(@NotNull List<C0410pe.a> list) {
        this.ag = list;
    }

    public ResourceLocation r() {
        return C0265jv.d("textures/models/entities/human/" + getSkin().toLowerCase(Locale.ROOT) + ".png");
    }
}
