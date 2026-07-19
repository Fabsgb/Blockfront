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

/* JADX INFO: renamed from: com.boehmod.blockfront.oc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oc.class */
public class C0381oc extends nA {
    public nO a;

    public C0381oc(EntityType<? extends C0381oc> entityType, Level level) {
        super(entityType, level, (BlockEntityType) wJ.cj.get(), ((Block) wL.ir.get()).defaultBlockState(), (BlockEntityType) wJ.cj.get(), ((Block) wL.ir.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected nE<AbstractC0376ny> mo739a() {
        nN<?> nNVarB = new nL("turret0", this).a().a(64).a(new Vector3f(0.0f, 2.75f, 0.0f)).a(0).b(1);
        nD nDVarB = new nD().a().e().d().b().c().a(nNVarB).a(15.0f, 45.0f).b(new Vector3f(0.0f, 1.4f, -0.2f)).a(new Vector3f(-0.8f, 0.0f, 2.0f)).a("tank_panzeriv_gunner").a(nD.dy).b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new nE().b(8.0f).a(true).a(new nH()).a(64).a(0.025f, 0.015f).b(0.15f, 0.075f).c(0.1f, 0.1f).d(1.85f, 1.85f).g(8.0f).f(1.5f).e(0.75f).a(nDVarB).a(nNVarB).c().a((nJ) new nI(ParticleTypes.LARGE_SMOKE, new Vec3(-3.950000047683716d, 2.4000000953674316d, 0.4000000059604645d)).a(vec3)).a((nJ) new nI(ParticleTypes.LARGE_SMOKE, new Vec3(-3.950000047683716d, 2.4000000953674316d, -0.4000000059604645d)).a(vec3)).a((nJ) new nK(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).a(vec3)).a((nJ) new nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).a(vec3));
    }

    @Override // com.boehmod.blockfront.nA, com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public nO mo740a() {
        if (this.a == null) {
            this.a = new nO(this);
        }
        return this.a;
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    public Packet<ClientGamePacketListener> a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
