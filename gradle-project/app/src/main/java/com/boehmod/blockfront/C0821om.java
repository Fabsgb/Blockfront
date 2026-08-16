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

/* JADX INFO: renamed from: com.boehmod.blockfront.om */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/om.class */
public class C0821om extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4487a;

    public C0821om(EntityType<? extends C0821om> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6964co.get(), ((Block) C1295xi.f7317ii.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6965cp.get(), ((Block) C1295xi.f7318ij.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        AbstractC0818oj abstractC0818ojA = new C0816oh("turret", this).m3758a().mo3755a(64).m3756a(new Vector3f(0.0f, 2.75f, 0.0f)).mo3755a(0);
        C0755nZ c0755nZM3511b = new C0755nZ().m3502a().m3503b().m3506e().m3505d().m3504c().m3507a(15.0f, 45.0f).m3510b(new Vector3f(0.0f, 1.4f, 0.4f)).m3509a(new Vector3f(-1.3f, 0.0f, 1.3f)).m3513a("tank_chiha_gunner").m3511b(0.8f);
        C0755nZ c0755nZM3509a = new C0755nZ().m3500a(C0755nZ.f4175dx).m3510b(new Vector3f(0.0f, 1.4f, 0.4f)).m3509a(new Vector3f(-0.85f, 1.6f, -0.5f));
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0809oa().m3709a(true).m3711a(new C0812od()).m3714a(64).m3717a(0.025f, 0.015f).m3719b(0.15f, 0.075f).m3720c(0.1f, 0.1f).m3723d(1.85f, 1.85f).m3727g(8.0f).m3726f(1.5f).m3722e(0.75f).m3724a(c0755nZM3511b).m3724a(c0755nZM3509a).m3725a(abstractC0818ojA).m3728c().m3713a((AbstractC0814of) new C0813oe(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.200000047683716d, 0.0d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(0.0d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(0.0d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4487a == null) {
            this.f4487a = new C0819ok(this).mo3785a(C1312xz.f8103rU, C1312xz.f8088rF);
            this.f4487a.m3792a(C1312xz.f8097rO, C1312xz.f8075rs, C1312xz.f8098rP, C1312xz.f8076rt, C1312xz.f8099rQ, C1312xz.f8077ru);
            this.f4487a.m3790b(C1312xz.f8100rR);
            this.f4487a.m3789c(C1312xz.f8101rS, C1312xz.f8102rT);
        }
        return this.f4487a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
