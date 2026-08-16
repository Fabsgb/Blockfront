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

/* JADX INFO: renamed from: com.boehmod.blockfront.pT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pT.class */
public abstract class AbstractC0855pT extends AbstractC0858pW {

    /* JADX INFO: renamed from: pO */
    private static final int f4582pO = 5;

    /* JADX INFO: renamed from: pP */
    private int f4583pP;

    /* JADX INFO: renamed from: fl */
    private boolean f4584fl;

    public AbstractC0855pT() {
        this.f4583pP = ThreadLocalRandom.current().nextInt(5);
        this.f4584fl = false;
    }

    public AbstractC0855pT(@NotNull Vec3 vec3) {
        super(vec3);
        this.f4583pP = ThreadLocalRandom.current().nextInt(5);
        this.f4584fl = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public final void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4583pP;
        this.f4583pP = i - 1;
        if (i <= 0) {
            this.f4583pP = 5;
            boolean zM3934b = m3934b(clientLevel);
            if (zM3934b != this.f4584fl) {
                this.f4584fl = zM3934b;
                if (zM3934b) {
                    mo3935a(minecraft, c0623l, abstractC0863pb, localPlayer, clientLevel);
                } else {
                    mo3936b(minecraft, c0623l, abstractC0863pb, localPlayer, clientLevel);
                }
            }
        }
        if (this.f4584fl) {
            mo3937b(minecraft, c0623l, randomSource, abstractC0863pb, localPlayer, clientLevel, f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected boolean m3934b(@NotNull ClientLevel clientLevel) {
        return clientLevel.hasChunkAt(BlockPos.containing(this.f4593c));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3935a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3936b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3937b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        Object[] objArr = new Object[1];
        objArr[0] = this.f4584fl ? "loaded" : "unloaded";
        list.add(Component.literal(String.format("Chunk: %s", objArr)));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        this.f4584fl = false;
        this.f4583pP = randomSource.nextInt(5);
    }
}
