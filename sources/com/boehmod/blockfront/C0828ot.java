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

/* JADX INFO: renamed from: com.boehmod.blockfront.ot */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ot.class */
public class C0828ot extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4494a;

    public C0828ot(EntityType<? extends C0828ot> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6981cF.get(), ((Block) C1295xi.f7334iz.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6982cG.get(), ((Block) C1295xi.f7335iA.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        AbstractC0818oj<?> abstractC0818ojA = new C0816oh("turret0", this).m3758a().m3756a(new Vector3f(0.0f, 2.75f, 0.0f)).mo3755a(64).mo3755a(0);
        C0755nZ c0755nZM3511b = new C0755nZ().m3502a().m3503b().m3506e().m3505d().m3504c().m3501a(abstractC0818ojA).m3507a(15.0f, 45.0f).m3510b(new Vector3f(0.0f, 0.75f, 0.2f)).m3509a(new Vector3f(-0.75f, 0.0f, 1.4f)).m3513a("tank_chiha_gunner").m3500a(C0755nZ.f4174dw).m3511b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0809oa().m3709a(true).m3711a(new C0812od()).m3714a(64).m3717a(0.025f, 0.015f).m3719b(0.15f, 0.075f).m3720c(0.1f, 0.1f).m3723d(1.85f, 1.85f).m3727g(8.0f).m3726f(1.5f).m3722e(0.75f).m3724a(c0755nZM3511b).m3725a(abstractC0818ojA).m3728c().m3713a((AbstractC0814of) new C0813oe(ParticleTypes.LARGE_SMOKE, new Vec3(-2.0d, 1.7999999523162842d, -1.2999999523162842d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(0.0d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(0.0d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4494a == null) {
            this.f4494a = new C0819ok(this).mo3785a(C1312xz.f8103rU, C1312xz.f8088rF);
            this.f4494a.m3792a(C1312xz.f8097rO, C1312xz.f8075rs, C1312xz.f8098rP, C1312xz.f8076rt, C1312xz.f8099rQ, C1312xz.f8077ru);
            this.f4494a.m3790b(C1312xz.f8100rR);
            this.f4494a.m3789c(C1312xz.f8101rS, C1312xz.f8102rT);
        }
        return this.f4494a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
