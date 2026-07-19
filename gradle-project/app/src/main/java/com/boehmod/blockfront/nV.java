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
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nV.class */
public class nV extends nA {
    public nO a;

    public nV(EntityType<? extends nV> entityType, Level level) {
        super(entityType, level, (BlockEntityType) wJ.cv.get(), ((Block) wL.ip.get()).defaultBlockState(), (BlockEntityType) wJ.cw.get(), ((Block) wL.iq.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected nE<AbstractC0376ny> mo739a() {
        nN nNVarA = new nL("turret", this).a().a(64).a(3.5f).a(0);
        nD nDVarB = new nD().a().b().e().d().c().a(15.0f, 45.0f).b(new Vector3f(0.0f, 2.25f, -1.0f)).a("tank_driver").a(nD.dx).b(0.6f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new nE().a(true).a(new nF()).a(64).b(1.5f).a(0.05f, 0.03f).c(0.95f).b(0.2f, 0.075f).c(0.25f, 0.25f).d(1.85f, 1.85f).d(0.6f).g(8.0f).f(1.25f).e(0.85f).a(nDVarB).a(nNVarA).a((nJ) new nK(new Vec3(2.0999999046325684d, 0.10000000149011612d, 1.0499999523162842d)).a(vec3)).a((nJ) new nK(new Vec3(2.0999999046325684d, 0.10000000149011612d, -1.0499999523162842d)).a(vec3)).a((nJ) new nK(new Vec3(-1.399999976158142d, 0.10000000149011612d, 1.0499999523162842d)).a(vec3)).a((nJ) new nK(new Vec3(-1.399999976158142d, 0.10000000149011612d, -1.0499999523162842d)).a(vec3));
    }

    @Override // com.boehmod.blockfront.nA, com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public nO mo740a() {
        if (this.a == null) {
            this.a = new nO(this).a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
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
