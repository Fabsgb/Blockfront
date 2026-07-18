package com.boehmod.blockfront;

import com.boehmod.blockfront.C1136uj;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mJ.class */
public class C0685mJ extends AbstractC0683mH<C0774nt> {
    public C0685mJ(@NotNull C0680mE c0680mE, float f) {
        super(c0680mE, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0683mH
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Class<C0774nt> mo3091a() {
        return C0774nt.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0683mH
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo3092g(@NotNull C0774nt c0774nt) {
        Player playerA = c0774nt.m2992a();
        return playerA == null || !this.f3696b.m3047d(playerA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0683mH
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean mo3093h(C0774nt c0774nt) {
        if (c0774nt.tickCount < 10 || !this.f3696b.hasLineOfSight(c0774nt)) {
            return false;
        }
        ItemStack item = c0774nt.getItem();
        if (item.isEmpty()) {
            return false;
        }
        Item item2 = item.getItem();
        if (!(item2 instanceof C1136uj)) {
            return false;
        }
        C1136uj.a aVarMo5959a = ((C1136uj) item2).mo5959a();
        if (aVarMo5959a != C1136uj.a.FRAG && aVarMo5959a != C1136uj.a.FIRE) {
            return false;
        }
        this.f3696b.m3031bF();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0683mH
    public void start() {
        super.start();
        C0799oR.m4043a((LivingEntity) this.f3696b, (ParticleOptions) C1232wZ.f7313nO.get(), this.f3696b.getRandom(), 0.0f, 1.0f, 0.0f, 5);
    }
}
