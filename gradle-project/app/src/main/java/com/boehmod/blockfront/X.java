package com.boehmod.blockfront;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/X.class */
public class X {
    private final int ag;
    private int ah = 0;
    protected Vec3 c;

    public X(@NotNull Vec3 vec3, int i) {
        this.c = vec3;
        this.ag = i;
    }

    @OverridingMethodsMustInvokeSuper
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel) {
        if (this.ah >= this.ag) {
            return false;
        }
        this.ah++;
        return true;
    }
}
