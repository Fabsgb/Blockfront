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
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.oA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oA.class */
public class C0783oA extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4328a;

    public C0783oA(EntityType<? extends C0783oA> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6973cx.get(), ((Block) C1295xi.f7327is.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6976cA.get(), ((Block) C1295xi.f7328it.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        C0755nZ c0755nZM3510b = new C0755nZ().m3503b().m3504c().m3507a(35.0f, 120.0f).m3500a(C0755nZ.f4174dw).m3510b(new Vector3f(0.5f, 0.15f, -0.3f));
        C0755nZ c0755nZM3510b2 = new C0755nZ().m3507a(35.0f, 120.0f).m3500a(C0755nZ.f4176dy).m3510b(new Vector3f(-0.5f, 0.15f, -0.3f));
        return new C0809oa().m3709a(true).m3711a(new C0810ob()).m3715b(1.5f).m3717a(0.02f, 0.01f).m3718c(0.95f).m3719b(0.3f, 0.075f).m3720c(0.25f, 0.25f).m3723d(1.85f, 1.85f).m3721d(0.6f).m3727g(8.0f).m3726f(1.25f).m3722e(0.85f).m3724a(c0755nZM3510b).m3724a(c0755nZM3510b2).m3724a(new C0755nZ().m3507a(35.0f, 200.0f).m3500a(C0755nZ.f4176dy).m3510b(new Vector3f(0.15f, 0.55f, -1.75f)));
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4328a == null) {
            this.f4328a = new C0819ok(this).mo3785a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
            this.f4328a.mo3785a(C1312xz.f8104rV, C1312xz.f8105rW);
            this.f4328a.mo3784a(C1312xz.f8069rm);
            this.f4328a.mo3785a(C1312xz.f8119sk, C1312xz.f8120sl);
            this.f4328a.m3792a(C1312xz.f8106rX, C1312xz.f8107rY, C1312xz.f8108rZ, C1312xz.f8109sa, C1312xz.f8110sb, C1312xz.f8111sc);
            this.f4328a.m3790b(C1312xz.f8112sd);
            this.f4328a.m3789c(C1312xz.f8114sf, C1312xz.f8116sh);
            this.f4328a.m3786b(C1312xz.f8118sj, null, null, null);
        }
        return this.f4328a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
