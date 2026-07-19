package com.boehmod.blockfront;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nS.class */
public class nS extends nA {
    public nO a;

    public nS(EntityType<? extends nS> entityType, Level level) {
        super(entityType, level, (BlockEntityType) wJ.bT.get(), ((Block) wL.ey.get()).defaultBlockState(), (BlockEntityType) wJ.bT.get(), ((Block) wL.ey.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected nE<AbstractC0376ny> mo739a() {
        nN<?> nNVarA = new nL("turret0", this).a(nM.BULLET).a(wY.nm).a().a(100).a(new Vector3f(0.0f, 1.0f, -0.2f)).a(0);
        return new nE().b(1.5f).a(0.025f, 0.015f).b(0.15f, 0.075f).c(0.1f, 0.1f).d(1.85f, 1.85f).g(8.0f).f(1.5f).e(0.75f).a(new nD().a(nNVarA).b().a().c().b(new Vector3f(0.0f, 0.0f, 0.0f)).a(new Vector3f(-0.5f, -0.15f, -0.8f)).a(nD.dx).b(0.8f)).a(nNVarA);
    }

    @Override // com.boehmod.blockfront.nA, com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public nO mo740a() {
        if (this.a == null) {
            this.a = new nO(this);
        }
        this.a.b(C0624xc.sl, C0624xc.sm, C0624xc.sn, C0624xc.so);
        this.a.d(null, null);
        this.a.a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        this.a.c(null, null);
        this.a.a(null, null, null, null, null, null);
        this.a.a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        return this.a;
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    public Packet<ClientGamePacketListener> a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
