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

/* JADX INFO: renamed from: com.boehmod.blockfront.nR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nR.class */
public class C0746nR extends AbstractC0729nA {

    /* JADX INFO: renamed from: a */
    public C0743nO f4060a;

    public C0746nR(EntityType<? extends C0746nR> entityType, Level level) {
        super(entityType, level, (BlockEntityType) C1216wJ.f6406ct.get(), ((Block) C1218wL.f6759in.get()).defaultBlockState(), (BlockEntityType) C1216wJ.f6407cu.get(), ((Block) C1218wL.f6760io.get()).defaultBlockState());
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0733nE<AbstractC0779ny> mo3422a() {
        C0732nD c0732nDM3323b = new C0732nD().m3316b().m3317c().m3320a(35.0f, 120.0f).m3313a(C0732nD.f3926dy).m3323b(new Vector3f(0.35f, 0.05f, -0.3f));
        C0732nD c0732nDM3323b2 = new C0732nD().m3320a(35.0f, 120.0f).m3313a(C0732nD.f3928dA).m3323b(new Vector3f(-0.35f, 0.05f, -0.3f));
        C0732nD c0732nDM3323b3 = new C0732nD().m3320a(35.0f, 200.0f).m3313a(C0732nD.f3928dA).m3323b(new Vector3f(0.35f, 0.05f, -1.25f));
        return new C0733nE().m3331a(true).m3333a(new C0734nF()).m3337b(1.5f).m3339a(0.02f, 0.01f).m3340c(0.95f).m3341b(0.3f, 0.075f).m3342c(0.25f, 0.25f).m3345d(1.85f, 1.85f).m3343d(0.6f).m3349g(8.0f).m3348f(1.25f).m3344e(0.85f).m3346a(c0732nDM3323b).m3346a(c0732nDM3323b2).m3346a(c0732nDM3323b3).m3346a(new C0732nD().m3320a(35.0f, 200.0f).m3313a(C0732nD.f3928dA).m3323b(new Vector3f(-0.35f, 0.05f, -1.25f)));
    }

    @Override // com.boehmod.blockfront.AbstractC0729nA, com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public C0743nO mo3293a() {
        if (this.f4060a == null) {
            this.f4060a = new C0743nO(this).mo3413a((DeferredHolder<SoundEvent, SoundEvent>) null, (DeferredHolder<SoundEvent, SoundEvent>) null);
            this.f4060a.mo3413a(C1280xc.f7693rU, C1280xc.f7694rV);
            this.f4060a.mo3412a(C1280xc.f7658rl);
            this.f4060a.mo3413a(C1280xc.f7708sj, C1280xc.f7709sk);
            this.f4060a.m3420a(C1280xc.f7695rW, C1280xc.f7696rX, C1280xc.f7697rY, C1280xc.f7698rZ, C1280xc.f7699sa, C1280xc.f7700sb);
            this.f4060a.m3418b(C1280xc.f7701sc);
            this.f4060a.m3417c(C1280xc.f7703se, C1280xc.f7705sg);
            this.f4060a.m3414b(C1280xc.f7707si, null, null, null);
        }
        return this.f4060a;
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public Packet<ClientGamePacketListener> mo3423a(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
