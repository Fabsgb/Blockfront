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

/* JADX INFO: renamed from: com.boehmod.blockfront.oo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oo.class */
public class C0823oo extends AbstractC0752nW {

    /* JADX INFO: renamed from: a */
    public C0819ok f4489a;

    public C0823oo(EntityType<? extends C0823oo> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1293xg.f6943bT.get(), ((Block) C1295xi.f7098ey.get()).defaultBlockState(), (BlockEntityType) C1293xg.f6943bT.get(), ((Block) C1295xi.f7098ey.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0809oa<AbstractC0750nU> mo3432a() {
        AbstractC0818oj<?> abstractC0818ojA = new C0816oh("turret0", this).m3753a(EnumC0817oi.BULLET).m3754a(C1308xv.f7849nm).m3758a().mo3755a(100).m3756a(new Vector3f(0.0f, 1.0f, -0.2f)).mo3755a(0);
        return new C0809oa().m3715b(1.5f).m3717a(0.025f, 0.015f).m3719b(0.15f, 0.075f).m3720c(0.1f, 0.1f).m3723d(1.85f, 1.85f).m3727g(8.0f).m3726f(1.5f).m3722e(0.75f).m3724a(new C0755nZ().m3501a(abstractC0818ojA).m3503b().m3502a().m3504c().m3510b(new Vector3f(0.0f, 0.0f, 0.0f)).m3509a(new Vector3f(-0.5f, -0.15f, -0.8f)).m3500a(C0755nZ.f4173dv).m3511b(0.8f)).m3725a(abstractC0818ojA);
    }

    @Override // com.boehmod.blockfront.AbstractC0752nW, com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public C0819ok mo3433a() {
        if (this.f4489a == null) {
            this.f4489a = new C0819ok(this);
        }
        this.f4489a.m3786b(C1312xz.f8121sm, C1312xz.f8122sn, C1312xz.f8123so, C1312xz.f8124sp);
        this.f4489a.m3791d(null, null);
        this.f4489a.mo3785a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f4489a.m3789c(null, null);
        this.f4489a.m3792a(null, null, null, null, null, null);
        this.f4489a.mo3785a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        return this.f4489a;
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
