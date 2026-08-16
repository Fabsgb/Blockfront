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

/* JADX INFO: renamed from: com.boehmod.blockfront.ox */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ox.class */
public class C0832ox extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4498a;

    public C0832ox(EntityType<? extends C0832ox> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6960ck.get(), ((Block) C1295xi.f7313ie.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6961cl.get(), ((Block) C1295xi.f7314if.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        C0755nZ c0755nZM3511b = new C0755nZ().m3502a().m3506e().m3505d().m3503b().m3504c().m3507a(15.0f, 45.0f).m3510b(new Vector3f(0.0f, 1.4f, 0.7f)).m3509a(new Vector3f(-0.8f, 0.0f, 2.0f)).m3513a("tank_sherman_gunner").m3500a(C0755nZ.f4174dw).m3511b(0.8f);
        AbstractC0818oj abstractC0818ojM3780b = new C0816oh("turret", this).m3758a().mo3755a(64).m3756a(new Vector3f(0.0f, 2.7f, 0.7f)).mo3755a(0).m3780b(1);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0809oa().m3709a(true).m3711a(new C0812od()).m3714a(64).m3717a(0.025f, 0.015f).m3719b(0.15f, 0.075f).m3720c(0.1f, 0.1f).m3723d(1.85f, 1.85f).m3727g(8.0f).m3726f(1.5f).m3722e(0.75f).m3724a(c0755nZM3511b).m3725a(abstractC0818ojM3780b).m3728c().m3713a((AbstractC0814of) new C0813oe(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.4000000953674316d, 0.0d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4498a == null) {
            this.f4498a = new C0819ok(this);
        }
        return this.f4498a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
