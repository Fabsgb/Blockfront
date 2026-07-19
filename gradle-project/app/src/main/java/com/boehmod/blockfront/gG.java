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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gG.class */
public class gG extends gK<mE> {
    @Override // com.boehmod.blockfront.gK
    public /* bridge */ /* synthetic */ sV a(@NotNull LivingEntity livingEntity, @NotNull oF oFVar) {
        return m417a((mE) livingEntity, (oF<?, ?, ?>) oFVar);
    }

    @Override // com.boehmod.blockfront.gK
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ String mo418a(@NotNull LivingEntity livingEntity, @NotNull oF oFVar) {
        return a((mE) livingEntity, (oF<?, ?, ?>) oFVar);
    }

    @Override // com.boehmod.blockfront.gK
    public /* bridge */ /* synthetic */ boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oO oOVar) {
        return a(renderNameTagEvent, minecraft, fVVar, localPlayer, (mE) livingEntity, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, oOVar);
    }

    @Override // com.boehmod.blockfront.gK, com.boehmod.blockfront.gI
    public /* bridge */ /* synthetic */ boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oO oOVar) {
        return a(renderNameTagEvent, minecraft, fVVar, localPlayer, (mE) entity, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, oOVar);
    }

    public boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull mE mEVar, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oO oOVar) {
        if (!super.a(renderNameTagEvent, minecraft, fVVar, localPlayer, mEVar, oFVar, oGVar, oOVar)) {
            return false;
        }
        MutableComponent mutableComponentLiteral = Component.literal(mEVar.getScoreboardName());
        oO oOVarA = oFVar.b().a(mEVar.E());
        if (oOVarA != null) {
            mutableComponentLiteral.withStyle(oOVarA.a());
        }
        renderNameTagEvent.setContent(Component.literal("BOT ").append(mutableComponentLiteral));
        return true;
    }

    public String a(@NotNull mE mEVar, @NotNull oF<?, ?, ?> oFVar) {
        return mEVar.E();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sV m417a(@NotNull mE mEVar, @NotNull oF<?, ?, ?> oFVar) {
        return mEVar.m673b();
    }
}
