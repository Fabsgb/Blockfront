package com.boehmod.blockfront;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mN.class */
public class mN extends mK {
    private int lm;

    public mN(@NotNull mE mEVar) {
        super(mEVar);
        this.lm = 0;
    }

    public void start() {
        super.start();
        this.b.D(true);
        this.b.setAggressive(false);
        this.b.c().ifPresent(sUVar -> {
            this.b.a(sUVar.g());
        });
        ItemStack mainHandItem = this.b.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            this.lm = c0558ur.m1207e(mainHandItem);
            SoundEvent soundEventM1213a = c0558ur.m1213a(mainHandItem);
            if (soundEventM1213a != null) {
                this.b.a(Holder.direct(soundEventM1213a), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
        }
    }

    public void stop() {
        super.stop();
        bK();
        this.b.D(false);
        this.b.setAggressive(true);
    }

    @Override // com.boehmod.blockfront.mK
    public boolean canUse() {
        ItemStack mainHandItem = this.b.getMainHandItem();
        return (mainHandItem.getItem() instanceof C0558ur) && C0558ur.a(mainHandItem) <= 0;
    }

    public boolean canContinueToUse() {
        return this.lm > 0;
    }

    public void tick() {
        super.tick();
        this.lm--;
    }

    private void bK() {
        ItemStack mainHandItem = this.b.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            C0558ur.b(mainHandItem, ((C0558ur) item).m1206a(mainHandItem).cb());
        }
    }
}
