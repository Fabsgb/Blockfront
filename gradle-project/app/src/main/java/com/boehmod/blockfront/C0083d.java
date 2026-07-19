package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/d.class */
public class C0083d {
    public static final int c = 100;
    private int d;
    private int e = 0;

    public void a(@NotNull Minecraft minecraft, @NotNull C0163g c0163g) {
        this.e = this.d;
        int i = this.d;
        this.d = i + 1;
        if (i >= 100) {
            this.d = 0;
            c0163g.a().b(RequestType.PLAYER_CHALLENGES, minecraft.getUser().getProfileId());
        }
    }

    public float a(float f) {
        return C0634xm.e(this.d, this.e, f) / 100.0f;
    }

    public int a() {
        return ((-(this.d - 100)) / 20) + 1;
    }
}
