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

/* JADX INFO: renamed from: com.boehmod.blockfront.od */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/od.class */
public class C0811od extends AbstractC0729nA {

    /* JADX INFO: renamed from: a */
    public C0743nO f4436a;

    public C0811od(EntityType<? extends C0811od> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1216wJ.f6376bP.get(), ((Block) C1218wL.f6536ez.get()).defaultBlockState(), (BlockEntityType) C1216wJ.f6377bQ.get(), ((Block) C1218wL.f6537eA.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0733nE<AbstractC0779ny> mo3422a() {
        AbstractC0742nN abstractC0742nNM3408b = new C0740nL("head", this).m3386a().m3387a(2.0f).mo3383a(64).m3385a((EntityType<? extends C0760nf>) C1230wX.f7057la.get()).mo3383a(0).m3408b(1);
        C0732nD c0732nDM3324b = new C0732nD().m3316b().m3317c().m3315a().m3320a(10.0f, 45.0f).m3323b(new Vector3f(0.0f, 0.0f, 0.0f)).m3322a(new Vector3f(-1.7f, 0.3f, -1.25f)).m3313a(C0732nD.f3925dx).m3324b(0.8f);
        C0732nD c0732nDM3324b2 = new C0732nD().m3316b().m3315a().m3320a(10.0f, 45.0f).m3323b(new Vector3f(0.0f, 0.0f, 0.0f)).m3322a(new Vector3f(1.7f, 0.3f, -1.25f)).m3313a(C0732nD.f3928dA).m3324b(0.8f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0733nE().m3336a(64).m3337b(1.5f).m3338b(5).m3339a(0.025f, 0.015f).m3341b(0.15f, 0.075f).m3342c(0.1f, 0.1f).m3345d(1.85f, 1.85f).m3349g(8.0f).m3348f(1.5f).m3344e(0.75f).m3346a(c0732nDM3324b).m3346a(c0732nDM3324b2).m3347a(abstractC0742nNM3408b).m3335a((AbstractC0738nJ) new C0737nI(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.4000000953674316d, 0.0d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0729nA, com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public C0743nO mo3293a() {
        if (this.f4436a == null) {
            this.f4436a = new C0743nO(this);
        }
        this.f4436a.m3414b(C1280xc.f7710sl, C1280xc.f7711sm, C1280xc.f7712sn, C1280xc.f7713so);
        this.f4436a.m3411a(C1280xc.f7714sp, C1280xc.f7683rK, C1280xc.f7684rL, C1280xc.f7715sq);
        this.f4436a.mo3412a((DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f4436a.m3419d(null, null);
        this.f4436a.mo3413a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f4436a.m3417c(null, null);
        this.f4436a.m3420a(null, null, null, null, null, null);
        this.f4436a.mo3413a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
        return this.f4436a;
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3423a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
