package com.boehmod.blockfront;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.px, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/px.class */
public abstract class AbstractC0429px extends pA {
    private static final int nP = 5;
    private int nQ;
    private boolean eR;

    public AbstractC0429px() {
        this.nQ = ThreadLocalRandom.current().nextInt(5);
        this.eR = false;
    }

    public AbstractC0429px(@NotNull Vec3 vec3) {
        super(vec3);
        this.nQ = ThreadLocalRandom.current().nextInt(5);
        this.eR = false;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public final void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.nQ;
        this.nQ = i - 1;
        if (i <= 0) {
            this.nQ = 5;
            boolean zB = b(clientLevel);
            if (zB != this.eR) {
                this.eR = zB;
                if (zB) {
                    a(minecraft, c0297l, oFVar, localPlayer, clientLevel);
                } else {
                    b(minecraft, c0297l, oFVar, localPlayer, clientLevel);
                }
            }
        }
        if (this.eR) {
            b(minecraft, c0297l, randomSource, oFVar, localPlayer, clientLevel, f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected boolean b(@NotNull ClientLevel clientLevel) {
        return clientLevel.hasChunkAt(BlockPos.containing(this.c));
    }

    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pA
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        Object[] objArr = new Object[1];
        objArr[0] = this.eR ? "loaded" : "unloaded";
        list.add(Component.literal(String.format("Chunk: %s", objArr)));
    }

    @Override // com.boehmod.blockfront.pA
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.eR = false;
        this.nQ = randomSource.nextInt(5);
    }
}
