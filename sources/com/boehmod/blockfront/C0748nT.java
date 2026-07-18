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

/* JADX INFO: renamed from: com.boehmod.blockfront.nT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nT.class */
public class C0748nT extends AbstractC0729nA {

    /* JADX INFO: renamed from: a */
    public C0743nO f4062a;

    public C0748nT(EntityType<? extends C0748nT> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1216wJ.f6372bL.get(), ((Block) C1218wL.f6531eu.get()).defaultBlockState(), (BlockEntityType) C1216wJ.f6373bM.get(), ((Block) C1218wL.f6532ev.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0733nE<AbstractC0779ny> mo3422a() {
        AbstractC0742nN<?> abstractC0742nNM3408b = new C0740nL("turret0", this).m3386a().mo3383a(64).m3384a(new Vector3f(0.0f, 1.8f, 0.0f)).m3387a(2.0f).mo3383a(0).m3408b(1);
        C0732nD c0732nDM3324b = new C0732nD().m3314a(abstractC0742nNM3408b).m3316b().m3315a().m3317c().m3320a(10.0f, 45.0f).m3323b(new Vector3f(0.0f, 0.0f, 0.0f)).m3322a(new Vector3f(-0.95f, 0.1f, -0.65f)).m3313a(C0732nD.f3925dx).m3324b(0.8f);
        return new C0733nE().m3336a(64).m3337b(1.5f).m3339a(0.025f, 0.015f).m3341b(0.15f, 0.075f).m3342c(0.1f, 0.1f).m3345d(1.85f, 1.85f).m3349g(8.0f).m3348f(1.5f).m3344e(0.75f).m3346a(c0732nDM3324b).m3346a(new C0732nD().m3314a(abstractC0742nNM3408b).m3316b().m3315a().m3320a(10.0f, 45.0f).m3323b(new Vector3f(0.0f, 0.0f, 0.0f)).m3322a(new Vector3f(0.8f, 0.2f, 0.4f)).m3313a(C0732nD.f3925dx).m3324b(0.8f)).m3347a(abstractC0742nNM3408b);
    }

    @Override // com.boehmod.blockfront.AbstractC0729nA, com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public C0743nO mo3293a() {
        if (this.f4062a == null) {
            this.f4062a = new C0743nO(this);
        }
        this.f4062a.m3414b(C1280xc.f7710sl, C1280xc.f7711sm, C1280xc.f7712sn, C1280xc.f7713so);
        this.f4062a.m3411a(C1280xc.f7714sp, C1280xc.f7683rK, C1280xc.f7684rL, C1280xc.f7715sq);
        this.f4062a.m3419d(null, null);
        this.f4062a.mo3413a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f4062a.m3417c(null, null);
        this.f4062a.m3420a(null, null, null, null, null, null);
        this.f4062a.mo3413a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        return this.f4062a;
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3423a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
