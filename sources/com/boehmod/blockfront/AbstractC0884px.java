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

/* JADX INFO: renamed from: com.boehmod.blockfront.px */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/px.class */
public abstract class AbstractC0884px extends AbstractC0835pA {

    /* JADX INFO: renamed from: nP */
    private static final int f4613nP = 5;

    /* JADX INFO: renamed from: nQ */
    private int f4614nQ;

    /* JADX INFO: renamed from: eR */
    private boolean f4615eR;

    public AbstractC0884px() {
        this.f4614nQ = ThreadLocalRandom.current().nextInt(5);
        this.f4615eR = false;
    }

    public AbstractC0884px(@NotNull Vec3 vec3) {
        super(vec3);
        this.f4614nQ = ThreadLocalRandom.current().nextInt(5);
        this.f4615eR = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public final void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4614nQ;
        this.f4614nQ = i - 1;
        if (i <= 0) {
            this.f4614nQ = 5;
            boolean zM4445b = m4445b(clientLevel);
            if (zM4445b != this.f4615eR) {
                this.f4615eR = zM4445b;
                if (zM4445b) {
                    mo4446a(minecraft, c0622l, abstractC0787oF, localPlayer, clientLevel);
                } else {
                    mo4447b(minecraft, c0622l, abstractC0787oF, localPlayer, clientLevel);
                }
            }
        }
        if (this.f4615eR) {
            mo4448b(minecraft, c0622l, randomSource, abstractC0787oF, localPlayer, clientLevel, f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected boolean m4445b(@NotNull ClientLevel clientLevel) {
        return clientLevel.hasChunkAt(BlockPos.containing(this.f4464c));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo4446a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4447b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4448b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        Object[] objArr = new Object[1];
        objArr[0] = this.f4615eR ? "loaded" : "unloaded";
        list.add(Component.literal(String.format("Chunk: %s", objArr)));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        this.f4615eR = false;
        this.f4614nQ = randomSource.nextInt(5);
    }
}
