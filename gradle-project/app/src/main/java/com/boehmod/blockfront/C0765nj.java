package com.boehmod.blockfront;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nj.class */
public class C0765nj extends C0762ng {

    /* JADX INFO: renamed from: nk */
    private int f4282nk;

    public C0765nj(@NotNull C0756na c0756na) {
        super(c0756na);
        this.f4282nk = 0;
    }

    public void start() {
        super.start();
        this.f4259b.m3574D(true);
        this.f4259b.setAggressive(false);
        this.f4259b.m3584c().ifPresent(c1092tr -> {
            this.f4259b.m3537a(c1092tr.m5994g());
        });
        ItemStack mainHandItem = this.f4259b.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            this.f4282nk = c1117uP.m6284f(mainHandItem);
            SoundEvent soundEventM6357a = c1117uP.m6357a(mainHandItem);
            if (soundEventM6357a != null) {
                this.f4259b.m3544a(Holder.direct(soundEventM6357a), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
        }
    }

    public void stop() {
        super.stop();
        m3612bV();
        this.f4259b.m3574D(false);
        this.f4259b.setAggressive(true);
    }

    @Override // com.boehmod.blockfront.C0762ng
    public boolean canUse() {
        ItemStack mainHandItem = this.f4259b.getMainHandItem();
        return (mainHandItem.getItem() instanceof C1117uP) && C1117uP.m6265c(mainHandItem) <= 0;
    }

    public boolean canContinueToUse() {
        return this.f4282nk > 0;
    }

    public void tick() {
        super.tick();
        this.f4282nk--;
    }

    /* JADX INFO: renamed from: bV */
    private void m3612bV() {
        ItemStack mainHandItem = this.f4259b.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            C1117uP.m6266b(mainHandItem, ((C1117uP) item).m6283a(mainHandItem).m6402cq());
        }
    }
}
