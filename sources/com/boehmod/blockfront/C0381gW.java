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

/* JADX INFO: renamed from: com.boehmod.blockfront.gW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gW.class */
public class C0381gW extends AbstractC0438ha<C0756na> {
    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ C1093ts mo1818a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb) {
        return m1817a((C0756na) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ String mo1819a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb) {
        return m1816a((C0756na) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1820a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull C0872pk c0872pk) {
        return m1815a(renderNameTagEvent, minecraft, c0396gl, localPlayer, (C0756na) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, c0872pk);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha, com.boehmod.blockfront.AbstractC0383gY
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1821a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull C0872pk c0872pk) {
        return m1815a(renderNameTagEvent, minecraft, c0396gl, localPlayer, (C0756na) entity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, c0872pk);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1815a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull C0756na c0756na, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull C0872pk c0872pk) {
        if (!super.mo1820a(renderNameTagEvent, minecraft, c0396gl, localPlayer, c0756na, abstractC0863pb, abstractC0864pc, c0872pk)) {
            return false;
        }
        MutableComponent mutableComponentLiteral = Component.literal(c0756na.getScoreboardName());
        C0872pk c0872pkM4242a = abstractC0863pb.m4018b().m4242a(c0756na.m3560L());
        if (c0872pkM4242a != null) {
            mutableComponentLiteral.withStyle(c0872pkM4242a.m4312a());
        }
        renderNameTagEvent.setContent(Component.literal("BOT ").append(mutableComponentLiteral));
        return true;
    }

    /* JADX INFO: renamed from: a */
    public String m1816a(@NotNull C0756na c0756na, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return c0756na.m3560L();
    }

    /* JADX INFO: renamed from: a */
    public C1093ts m1817a(@NotNull C0756na c0756na, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return c0756na.m3579b();
    }
}
