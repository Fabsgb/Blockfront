package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nf.class */
public class C0761nf extends AbstractC0759nd<C0745nP> {
    public C0761nf(@NotNull C0756na c0756na, float f) {
        super(c0756na, f);
    }

    @Override // com.boehmod.blockfront.AbstractC0759nd
    @NotNull
    /* JADX INFO: renamed from: a */
    protected Class<C0745nP> mo3598a() {
        return C0745nP.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0759nd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo3599g(@NotNull C0745nP c0745nP) {
        Player playerA = c0745nP.m3143a();
        return playerA == null || !this.f4259b.m3554d(playerA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0759nd
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean mo3600h(C0745nP c0745nP) {
        if (c0745nP.tickCount < 10 || !this.f4259b.hasLineOfSight(c0745nP)) {
            return false;
        }
        ItemStack item = c0745nP.getItem();
        if (item.isEmpty()) {
            return false;
        }
        Item item2 = item.getItem();
        if (!(item2 instanceof C1109uH)) {
            return false;
        }
        C1109uH.a aVarMo6211a = ((C1109uH) item2).mo6211a();
        if (aVarMo6211a != C1109uH.a.FRAG && aVarMo6211a != C1109uH.a.FIRE) {
            return false;
        }
        this.f4259b.m3539bQ();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0759nd
    public void start() {
        super.start();
        C0875pn.m4479a((LivingEntity) this.f4259b, (ParticleOptions) C1309xw.f7878nO.get(), this.f4259b.getRandom(), 0.0f, 1.0f, 0.0f, 5);
    }
}
