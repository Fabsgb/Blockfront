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

/* JADX INFO: renamed from: com.boehmod.blockfront.oe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oe.class */
public class C0383oe extends nA {
    public nO a;

    public C0383oe(EntityType<? extends C0383oe> entityType, Level level) {
        super(entityType, level, (BlockEntityType) wJ.cx.get(), ((Block) wL.is.get()).defaultBlockState(), (BlockEntityType) wJ.cA.get(), ((Block) wL.it.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected nE<AbstractC0376ny> mo739a() {
        nD nDVarB = new nD().b().c().a(35.0f, 120.0f).a(nD.dy).b(new Vector3f(0.5f, 0.15f, -0.3f));
        nD nDVarB2 = new nD().a(35.0f, 120.0f).a(nD.dA).b(new Vector3f(-0.5f, 0.15f, -0.3f));
        return new nE().a(true).a(new nF()).b(1.5f).a(0.02f, 0.01f).c(0.95f).b(0.3f, 0.075f).c(0.25f, 0.25f).d(1.85f, 1.85f).d(0.6f).g(8.0f).f(1.25f).e(0.85f).a(nDVarB).a(nDVarB2).a(new nD().a(35.0f, 200.0f).a(nD.dA).b(new Vector3f(0.15f, 0.55f, -1.75f)));
    }

    @Override // com.boehmod.blockfront.nA, com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public nO mo740a() {
        if (this.a == null) {
            this.a = new nO(this).a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
            this.a.a(C0624xc.rU, C0624xc.rV);
            this.a.a(C0624xc.rl);
            this.a.a(C0624xc.sj, C0624xc.sk);
            this.a.a(C0624xc.rW, C0624xc.rX, C0624xc.rY, C0624xc.rZ, C0624xc.sa, C0624xc.sb);
            this.a.b(C0624xc.sc);
            this.a.c(C0624xc.se, C0624xc.sg);
            this.a.b(C0624xc.si, null, null, null);
        }
        return this.a;
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    public Packet<ClientGamePacketListener> a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
