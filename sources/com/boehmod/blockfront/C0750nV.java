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

/* JADX INFO: renamed from: com.boehmod.blockfront.nV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nV.class */
public class C0750nV extends AbstractC0729nA {

    /* JADX INFO: renamed from: a */
    public C0743nO f4064a;

    public C0750nV(EntityType<? extends C0750nV> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1216wJ.f6408cv.get(), ((Block) C1218wL.f6761ip.get()).defaultBlockState(), (BlockEntityType) C1216wJ.f6409cw.get(), ((Block) C1218wL.f6762iq.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0733nE<AbstractC0779ny> mo3422a() {
        AbstractC0742nN abstractC0742nNA = new C0740nL("turret", this).m3386a().mo3383a(64).m3387a(3.5f).mo3383a(0);
        C0732nD c0732nDM3324b = new C0732nD().m3315a().m3316b().m3319e().m3318d().m3317c().m3320a(15.0f, 45.0f).m3323b(new Vector3f(0.0f, 2.25f, -1.0f)).m3326a("tank_driver").m3313a(C0732nD.f3925dx).m3324b(0.6f);
        Vec3 vec3 = new Vec3(0.0d, 0.10000000149011612d, 0.0d);
        return new C0733nE().m3331a(true).m3333a(new C0734nF()).m3336a(64).m3337b(1.5f).m3339a(0.05f, 0.03f).m3340c(0.95f).m3341b(0.2f, 0.075f).m3342c(0.25f, 0.25f).m3345d(1.85f, 1.85f).m3343d(0.6f).m3349g(8.0f).m3348f(1.25f).m3344e(0.85f).m3346a(c0732nDM3324b).m3347a(abstractC0742nNA).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(2.0999999046325684d, 0.10000000149011612d, 1.0499999523162842d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(2.0999999046325684d, 0.10000000149011612d, -1.0499999523162842d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-1.399999976158142d, 0.10000000149011612d, 1.0499999523162842d)).m3376a(vec3)).m3335a((AbstractC0738nJ) new C0739nK(new Vec3(-1.399999976158142d, 0.10000000149011612d, -1.0499999523162842d)).m3376a(vec3));
    }

    @Override // com.boehmod.blockfront.AbstractC0729nA, com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public C0743nO mo3293a() {
        if (this.f4064a == null) {
            this.f4064a = new C0743nO(this).mo3413a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
            this.f4064a.mo3412a(C1280xc.f7658rl);
            this.f4064a.mo3413a(C1280xc.f7708sj, C1280xc.f7709sk);
            this.f4064a.m3420a(C1280xc.f7695rW, C1280xc.f7696rX, C1280xc.f7697rY, C1280xc.f7698rZ, C1280xc.f7699sa, C1280xc.f7700sb);
            this.f4064a.m3418b(C1280xc.f7701sc);
            this.f4064a.m3417c(C1280xc.f7703se, C1280xc.f7705sg);
            this.f4064a.m3414b(C1280xc.f7707si, null, null, null);
        }
        return this.f4064a;
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3423a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
