package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mx.class */
public class C0726mx extends DamageSource {

    /* JADX INFO: renamed from: f */
    @NotNull
    private final ItemStack f4020f;

    public C0726mx(@NotNull Holder<DamageType> holder, @Nullable Entity entity, @NotNull ItemStack itemStack) {
        super(holder, entity);
        this.f4020f = itemStack;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public ItemStack m3343c() {
        return this.f4020f;
    }

    public boolean scalesWithDifficulty() {
        return false;
    }
}
