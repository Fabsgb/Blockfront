package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.d */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/d.class */
public class C0198d {

    /* JADX INFO: renamed from: c */
    public static final int f1604c = 100;

    /* JADX INFO: renamed from: d */
    private int f1605d;

    /* JADX INFO: renamed from: e */
    private int f1606e = 0;

    /* JADX INFO: renamed from: a */
    public void m1201a(@NotNull Minecraft minecraft, @NotNull C0357g c0357g) {
        this.f1606e = this.f1605d;
        int i = this.f1605d;
        this.f1605d = i + 1;
        if (i >= 100) {
            this.f1605d = 0;
            c0357g.m1716a().m2165b(RequestType.PLAYER_CHALLENGES, minecraft.getUser().getProfileId());
        }
    }

    /* JADX INFO: renamed from: a */
    public float m1202a(float f) {
        return C1290xm.m7843e(this.f1605d, this.f1606e, f) / 100.0f;
    }

    /* JADX INFO: renamed from: a */
    public int m1203a() {
        return ((-(this.f1605d - 100)) / 20) + 1;
    }
}
