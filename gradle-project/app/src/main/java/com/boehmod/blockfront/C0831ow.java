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

/* JADX INFO: renamed from: com.boehmod.blockfront.ow */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ow.class */
public class C0831ow extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4497a;

    public C0831ow(EntityType<? extends C0831ow> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6954ce.get(), ((Block) C1295xi.f7308hZ.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6956cg.get(), ((Block) C1295xi.f7309ia.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        AbstractC0818oj<?> abstractC0818ojA = new C0816oh("turret0", this).m3758a().mo3755a(64).m3756a(new Vector3f(0.0f, 3.0f, -0.2f)).mo3755a(0);
        C0755nZ c0755nZM3511b = new C0755nZ().m3502a().m3506e().m3505d().m3503b().m3504c().m3507a(15.0f, 45.0f).m3510b(new Vector3f(0.0f, 1.4f, -0.2f)).m3509a(new Vector3f(-0.6f, 0.0f, 1.6f)).m3513a("tank_sherman_gunner").m3501a(abstractC0818ojA).m3500a(C0755nZ.f4174dw).m3511b(0.8f);
        AbstractC0818oj<?> abstractC0818ojA2 = new C0816oh("turret1", this).m3752a(15.0f, 45.0f).m3753a(EnumC0817oi.BULLET).m3758a().mo3755a(256).m3756a(new Vector3f(0.0f, 3.0f, -0.2f)).mo3755a(1);
        C0755nZ c0755nZM3511b2 = new C0755nZ().m3502a().m3506e().m3505d().m3503b().m3504c().m3507a(15.0f, 35.0f).m3510b(new Vector3f(-0.7f, 1.1f, 2.6f)).m3513a("tank_sherman_gunner").m3501a(abstractC0818ojA2).m3500a(C0755nZ.f4173dv).m3511b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0809oa().m3709a(true).m3711a(new C0812od()).m3714a(64).m3717a(0.025f, 0.015f).m3719b(0.15f, 0.075f).m3720c(0.1f, 0.1f).m3723d(1.85f, 1.85f).m3727g(8.0f).m3726f(1.5f).m3722e(0.75f).m3724a(c0755nZM3511b).m3724a(c0755nZM3511b2).m3725a(abstractC0818ojA).m3725a(abstractC0818ojA2).m3728c().m3713a((AbstractC0814of) new C0813oe(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.4000000953674316d, 0.0d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4497a == null) {
            this.f4497a = new C0819ok(this);
        }
        return this.f4497a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
