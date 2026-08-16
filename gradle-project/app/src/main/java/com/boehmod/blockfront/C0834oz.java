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

/* JADX INFO: renamed from: com.boehmod.blockfront.oz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oz.class */
public class C0834oz extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4500a;

    public C0834oz(EntityType<? extends C0834oz> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6939bP.get(), ((Block) C1295xi.f7099ez.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6940bQ.get(), ((Block) C1295xi.f7100eA.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        AbstractC0818oj abstractC0818ojM3780b = new C0816oh("head", this).m3758a().m3759a(2.0f).mo3755a(64).m3757a((EntityType<? extends C0731nB>) C1307xu.f7622la.get()).mo3755a(0).m3780b(1);
        C0755nZ c0755nZM3511b = new C0755nZ().m3503b().m3504c().m3502a().m3507a(10.0f, 45.0f).m3510b(new Vector3f(0.0f, 0.0f, 0.0f)).m3509a(new Vector3f(-1.7f, 0.3f, -1.25f)).m3500a(C0755nZ.f4173dv).m3511b(0.8f);
        C0755nZ c0755nZM3511b2 = new C0755nZ().m3503b().m3502a().m3507a(10.0f, 45.0f).m3510b(new Vector3f(0.0f, 0.0f, 0.0f)).m3509a(new Vector3f(1.7f, 0.3f, -1.25f)).m3500a(C0755nZ.f4176dy).m3511b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0809oa().m3714a(64).m3715b(1.5f).m3716b(5).m3717a(0.025f, 0.015f).m3719b(0.15f, 0.075f).m3720c(0.1f, 0.1f).m3723d(1.85f, 1.85f).m3727g(8.0f).m3726f(1.5f).m3722e(0.75f).m3724a(c0755nZM3511b).m3724a(c0755nZM3511b2).m3725a(abstractC0818ojM3780b).m3713a((AbstractC0814of) new C0813oe(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.4000000953674316d, 0.0d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3748a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4500a == null) {
            this.f4500a = new C0819ok(this);
        }
        this.f4500a.m3786b(C1312xz.f8121sm, C1312xz.f8122sn, C1312xz.f8123so, C1312xz.f8124sp);
        this.f4500a.m3783a(C1312xz.f8125sq, C1312xz.f8094rL, C1312xz.f8095rM, C1312xz.f8126sr);
        this.f4500a.mo3784a((DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f4500a.m3791d(null, null);
        this.f4500a.mo3785a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f4500a.m3789c(null, null);
        this.f4500a.m3792a(null, null, null, null, null, null);
        this.f4500a.mo3785a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        return this.f4500a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
