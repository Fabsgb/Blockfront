package com.boehmod.blockfront;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.X */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/X.class */
public class C0026X {

    /* JADX INFO: renamed from: ag */
    private final int f239ag;

    /* JADX INFO: renamed from: ah */
    private int f240ah = 0;

    /* JADX INFO: renamed from: c */
    protected Vec3 f241c;

    public C0026X(@NotNull Vec3 vec3, int i) {
        this.f241c = vec3;
        this.f239ag = i;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public boolean mo162a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel) {
        if (this.f240ah >= this.f239ag) {
            return false;
        }
        this.f240ah++;
        return true;
    }
}
