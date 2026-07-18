package com.boehmod.blockfront;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mN.class */
public class C0689mN extends C0686mK {

    /* JADX INFO: renamed from: lm */
    private int f3719lm;

    public C0689mN(@NotNull C0680mE c0680mE) {
        super(c0680mE);
        this.f3719lm = 0;
    }

    public void start() {
        super.start();
        this.f3696b.m3067D(true);
        this.f3696b.setAggressive(false);
        this.f3696b.m3077c().ifPresent(c1014sU -> {
            this.f3696b.m3029a(c1014sU.m5506g());
        });
        ItemStack mainHandItem = this.f3696b.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            this.f3719lm = c1144ur.m6319e(mainHandItem);
            SoundEvent soundEventM6383a = c1144ur.m6383a(mainHandItem);
            if (soundEventM6383a != null) {
                this.f3696b.m3036a(Holder.direct(soundEventM6383a), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
        }
    }

    public void stop() {
        super.stop();
        m3105bK();
        this.f3696b.m3067D(false);
        this.f3696b.setAggressive(true);
    }

    @Override // com.boehmod.blockfront.C0686mK
    public boolean canUse() {
        ItemStack mainHandItem = this.f3696b.getMainHandItem();
        return (mainHandItem.getItem() instanceof C1144ur) && C1144ur.m6301a(mainHandItem) <= 0;
    }

    public boolean canContinueToUse() {
        return this.f3719lm > 0;
    }

    public void tick() {
        super.tick();
        this.f3719lm--;
    }

    /* JADX INFO: renamed from: bK */
    private void m3105bK() {
        ItemStack mainHandItem = this.f3696b.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            C1144ur.m6302b(mainHandItem, ((C1144ur) item).m6318a(mainHandItem).m6424cb());
        }
    }
}
