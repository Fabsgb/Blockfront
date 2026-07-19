package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nX.class */
public class nX extends nA {
    public nO a;

    public nX(EntityType<? extends nX> entityType, Level level) {
        super(entityType, level, (BlockEntityType) wJ.cF.get(), ((Block) wL.iz.get()).defaultBlockState(), (BlockEntityType) wJ.cG.get(), ((Block) wL.iA.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected nE<AbstractC0376ny> mo739a() {
        nN<?> nNVarA = new nL("turret0", this).a().a(new Vector3f(0.0f, 2.75f, 0.0f)).a(64).a(0);
        nD nDVarB = new nD().a().b().e().d().c().a(nNVarA).a(15.0f, 45.0f).b(new Vector3f(0.0f, 0.75f, 0.2f)).a(new Vector3f(-0.75f, 0.0f, 1.4f)).a("tank_chiha_gunner").a(nD.dy).b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new nE().a(true).a(new nH()).a(64).a(0.025f, 0.015f).b(0.15f, 0.075f).c(0.1f, 0.1f).d(1.85f, 1.85f).g(8.0f).f(1.5f).e(0.75f).a(nDVarB).a(nNVarA).c().a((nJ) new nI(ParticleTypes.LARGE_SMOKE, new Vec3(-2.0d, 1.7999999523162842d, -1.2999999523162842d)).a(vec3)).a((nJ) new nK(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(0.0d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(0.0d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).a(vec3));
    }

    @Override // com.boehmod.blockfront.nA, com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public nO mo740a() {
        if (this.a == null) {
            this.a = new nO(this).a(C0624xc.rT, C0624xc.rE);
            this.a.a(C0624xc.rN, C0624xc.rr, C0624xc.rO, C0624xc.rs, C0624xc.rP, C0624xc.rt);
            this.a.b(C0624xc.rQ);
            this.a.c(C0624xc.rR, C0624xc.rS);
        }
        return this.a;
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    public Packet<ClientGamePacketListener> a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
