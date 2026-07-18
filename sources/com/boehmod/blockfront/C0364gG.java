package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gG.class */
public class C0364gG extends AbstractC0368gK<C0680mE> {
    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ C1015sV mo1751a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF) {
        return m1750a((C0680mE) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ String mo1752a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF) {
        return m1749a((C0680mE) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1753a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull C0796oO c0796oO) {
        return m1748a(renderNameTagEvent, minecraft, c0326fV, localPlayer, (C0680mE) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, c0796oO);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK, com.boehmod.blockfront.AbstractC0366gI
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1754a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull C0796oO c0796oO) {
        return m1748a(renderNameTagEvent, minecraft, c0326fV, localPlayer, (C0680mE) entity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, c0796oO);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1748a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull C0680mE c0680mE, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull C0796oO c0796oO) {
        if (!super.mo1753a(renderNameTagEvent, minecraft, c0326fV, localPlayer, c0680mE, abstractC0787oF, abstractC0788oG, c0796oO)) {
            return false;
        }
        MutableComponent mutableComponentLiteral = Component.literal(c0680mE.getScoreboardName());
        C0796oO c0796oOM3806a = abstractC0787oF.m3582b().m3806a(c0680mE.m3053E());
        if (c0796oOM3806a != null) {
            mutableComponentLiteral.withStyle(c0796oOM3806a.m3876a());
        }
        renderNameTagEvent.setContent(Component.literal("BOT ").append(mutableComponentLiteral));
        return true;
    }

    /* JADX INFO: renamed from: a */
    public String m1749a(@NotNull C0680mE c0680mE, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return c0680mE.m3053E();
    }

    /* JADX INFO: renamed from: a */
    public C1015sV m1750a(@NotNull C0680mE c0680mE, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return c0680mE.m3072b();
    }
}
