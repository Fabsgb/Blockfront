package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.d */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/d.class */
public class C0199d {

    /* JADX INFO: renamed from: c */
    public static final int f1577c = 100;

    /* JADX INFO: renamed from: d */
    private int f1578d;

    /* JADX INFO: renamed from: e */
    private int f1579e = 0;

    /* JADX INFO: renamed from: a */
    public void m1233a(@NotNull Minecraft minecraft, @NotNull C0358g c0358g) {
        this.f1579e = this.f1578d;
        int i = this.f1578d;
        this.f1578d = i + 1;
        if (i >= 100) {
            this.f1578d = 0;
            c0358g.m1722a().m2492b(RequestType.PLAYER_CHALLENGES, minecraft.getUser().getProfileId());
        }
    }

    /* JADX INFO: renamed from: a */
    public float m1234a(float f) {
        return C1270xJ.m7170f(this.f1578d, this.f1579e, f) / 100.0f;
    }

    /* JADX INFO: renamed from: a */
    public int m1235a() {
        return ((-(this.f1578d - 100)) / 20) + 1;
    }
}
