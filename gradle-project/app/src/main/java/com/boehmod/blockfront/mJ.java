package com.boehmod.blockfront;

import com.boehmod.blockfront.C0550uj;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mJ.class */
public class mJ extends mH<C0371nt> {
    public mJ(@NotNull mE mEVar, float f) {
        super(mEVar, f);
    }

    @Override // com.boehmod.blockfront.mH
    @NotNull
    protected Class<C0371nt> a() {
        return C0371nt.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.mH
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean g(@NotNull C0371nt c0371nt) {
        Player playerA = c0371nt.a();
        return playerA == null || !this.b.d(playerA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.mH
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean h(C0371nt c0371nt) {
        if (c0371nt.tickCount < 10 || !this.b.hasLineOfSight(c0371nt)) {
            return false;
        }
        ItemStack item = c0371nt.getItem();
        if (item.isEmpty()) {
            return false;
        }
        Item item2 = item.getItem();
        if (!(item2 instanceof C0550uj)) {
            return false;
        }
        C0550uj.a aVarA = ((C0550uj) item2).a();
        if (aVarA != C0550uj.a.FRAG && aVarA != C0550uj.a.FIRE) {
            return false;
        }
        this.b.bF();
        return true;
    }

    @Override // com.boehmod.blockfront.mH
    public void start() {
        super.start();
        oR.a((LivingEntity) this.b, (ParticleOptions) wZ.nO.get(), this.b.getRandom(), 0.0f, 1.0f, 0.0f, 5);
    }
}
