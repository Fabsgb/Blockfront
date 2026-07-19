package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.od, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/od.class */
public class C0382od extends nA {
    public nO a;

    public C0382od(EntityType<? extends C0382od> entityType, Level level) {
        super(entityType, level, (BlockEntityType) wJ.bP.get(), ((Block) wL.ez.get()).defaultBlockState(), (BlockEntityType) wJ.bQ.get(), ((Block) wL.eA.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected nE<AbstractC0376ny> mo739a() {
        nN nNVarB = new nL("head", this).a().a(2.0f).a(64).a((EntityType<? extends C0357nf>) wX.la.get()).a(0).b(1);
        nD nDVarB = new nD().b().c().a().a(10.0f, 45.0f).b(new Vector3f(0.0f, 0.0f, 0.0f)).a(new Vector3f(-1.7f, 0.3f, -1.25f)).a(nD.dx).b(0.8f);
        nD nDVarB2 = new nD().b().a().a(10.0f, 45.0f).b(new Vector3f(0.0f, 0.0f, 0.0f)).a(new Vector3f(1.7f, 0.3f, -1.25f)).a(nD.dA).b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new nE().a(64).b(1.5f).b(5).a(0.025f, 0.015f).b(0.15f, 0.075f).c(0.1f, 0.1f).d(1.85f, 1.85f).g(8.0f).f(1.5f).e(0.75f).a(nDVarB).a(nDVarB2).a(nNVarB).a((nJ) new nI(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.4000000953674316d, 0.0d)).a(vec3)).a((nJ) new nK(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).a(vec3));
    }

    @Override // com.boehmod.blockfront.nA, com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public nO mo740a() {
        if (this.a == null) {
            this.a = new nO(this);
        }
        this.a.b(C0624xc.sl, C0624xc.sm, C0624xc.sn, C0624xc.so);
        this.a.a(C0624xc.sp, C0624xc.rK, C0624xc.rL, C0624xc.sq);
        this.a.a((DeferredHolder<SoundEvent, SoundEvent>) null);
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
