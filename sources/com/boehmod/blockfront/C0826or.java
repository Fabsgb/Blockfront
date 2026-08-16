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

/* JADX INFO: renamed from: com.boehmod.blockfront.or */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/or.class */
public class C0826or extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4492a;

    public C0826or(EntityType<? extends C0826or> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6971cv.get(), ((Block) C1295xi.f7324ip.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6972cw.get(), ((Block) C1295xi.f7325iq.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        AbstractC0818oj abstractC0818ojA = new C0816oh("turret", this).m3758a().mo3755a(64).m3759a(3.5f).mo3755a(0);
        C0755nZ c0755nZM3511b = new C0755nZ().m3502a().m3503b().m3506e().m3505d().m3504c().m3507a(15.0f, 45.0f).m3510b(new Vector3f(0.0f, 2.25f, -1.0f)).m3513a("tank_driver").m3500a(C0755nZ.f4173dv).m3511b(0.6f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0809oa().m3709a(true).m3711a(new C0810ob()).m3714a(64).m3715b(1.5f).m3717a(0.05f, 0.03f).m3718c(0.95f).m3719b(0.2f, 0.075f).m3720c(0.25f, 0.25f).m3723d(1.85f, 1.85f).m3721d(0.6f).m3727g(8.0f).m3726f(1.25f).m3722e(0.85f).m3724a(c0755nZM3511b).m3725a(abstractC0818ojA).m3713a((AbstractC0814of) new C0815og(new Vec3(2.0999999046325684d, 0.10000000149011612d, 1.0499999523162842d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(2.0999999046325684d, 0.10000000149011612d, -1.0499999523162842d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.399999976158142d, 0.10000000149011612d, 1.0499999523162842d)).m3748a(vec3)).m3713a((AbstractC0814of) new C0815og(new Vec3(-1.399999976158142d, 0.10000000149011612d, -1.0499999523162842d)).m3748a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4492a == null) {
            this.f4492a = new C0819ok(this).mo3785a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
            this.f4492a.mo3784a(C1312xz.f8069rm);
            this.f4492a.mo3785a(C1312xz.f8119sk, C1312xz.f8120sl);
            this.f4492a.m3792a(C1312xz.f8106rX, C1312xz.f8107rY, C1312xz.f8108rZ, C1312xz.f8109sa, C1312xz.f8110sb, C1312xz.f8111sc);
            this.f4492a.m3790b(C1312xz.f8112sd);
            this.f4492a.m3789c(C1312xz.f8114sf, C1312xz.f8116sh);
            this.f4492a.m3786b(C1312xz.f8118sj, null, null, null);
        }
        return this.f4492a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
