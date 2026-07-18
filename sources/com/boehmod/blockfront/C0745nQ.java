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

/* JADX INFO: renamed from: com.boehmod.blockfront.nQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nQ.class */
public class C0745nQ extends AbstractC0729nA {

    /* JADX INFO: renamed from: a */
    public C0743nO f4059a;

    public C0745nQ(EntityType<? extends C0745nQ> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1216wJ.f6401co.get(), ((Block) C1218wL.f6754ii.get()).defaultBlockState(), (BlockEntityType) C1216wJ.f6402cp.get(), ((Block) C1218wL.f6755ij.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0733nE<AbstractC0779ny> mo3422a() {
        AbstractC0742nN abstractC0742nNA = new C0740nL("turret", this).m3386a().mo3383a(64).m3384a(new Vector3f(0.0f, 2.75f, 0.0f)).mo3383a(0);
        C0732nD c0732nDM3324b = new C0732nD().m3315a().m3316b().m3319e().m3318d().m3317c().m3320a(15.0f, 45.0f).m3323b(new Vector3f(0.0f, 1.4f, 0.4f)).m3322a(new Vector3f(-1.3f, 0.0f, 1.3f)).m3326a("tank_chiha_gunner").m3324b(0.8f);
        C0732nD c0732nDM3322a = new C0732nD().m3313a(C0732nD.f3927dz).m3323b(new Vector3f(0.0f, 1.4f, 0.4f)).m3322a(new Vector3f(-0.85f, 1.6f, -0.5f));
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0733nE().m3331a(true).m3333a(new C0736nH()).m3336a(64).m3339a(0.025f, 0.015f).m3341b(0.15f, 0.075f).m3342c(0.1f, 0.1f).m3345d(1.85f, 1.85f).m3349g(8.0f).m3348f(1.5f).m3344e(0.75f).m3346a(c0732nDM3324b).m3346a(c0732nDM3322a).m3347a(abstractC0742nNA).m3350c().m3335a((AbstractC0738nJ) new C0737nI(ParticleTypes.LARGE_SMOKE, new Vec3(-2.5999999046325684d, 2.200000047683716d, 0.0d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-2.200000047683716d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(0.0d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(0.0d, 0.10000000149011612d, 1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-1.2000000476837158d, 0.10000000149011612d, -1.649999976158142d)).m3376a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0729nA, com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public C0743nO mo3293a() {
        if (this.f4059a == null) {
            this.f4059a = new C0743nO(this).mo3413a(C1280xc.f7692rT, C1280xc.f7677rE);
            this.f4059a.m3420a(C1280xc.f7686rN, C1280xc.f7664rr, C1280xc.f7687rO, C1280xc.f7665rs, C1280xc.f7688rP, C1280xc.f7666rt);
            this.f4059a.m3418b(C1280xc.f7689rQ);
            this.f4059a.m3417c(C1280xc.f7690rR, C1280xc.f7691rS);
        }
        return this.f4059a;
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3423a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
