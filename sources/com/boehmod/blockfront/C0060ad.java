package com.boehmod.blockfront;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ad */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ad.class */
public class C0060ad {

    /* JADX INFO: renamed from: aU */
    private final int f423aU;

    /* JADX INFO: renamed from: aV */
    private int f424aV = 0;

    /* JADX INFO: renamed from: c */
    protected Vec3 f425c;

    public C0060ad(@NotNull Vec3 vec3, int i) {
        this.f425c = vec3;
        this.f423aU = i;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public boolean mo276a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel) {
        if (this.f424aV >= this.f423aU) {
            return false;
        }
        this.f424aV++;
        return true;
    }
}
