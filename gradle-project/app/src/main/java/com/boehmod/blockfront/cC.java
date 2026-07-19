package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cC.class */
public final class cC {
    private static final int eh = 180;

    @NotNull
    private final String L;

    @NotNull
    private final UUID d;

    @NotNull
    private final String M;
    private int ei = 0;
    private float aD = 1.0f;
    private float aE = 1.0f;

    public cC(@NotNull UUID uuid, @NotNull String str, @NotNull String str2) {
        this.d = uuid;
        this.L = str;
        this.M = str2;
    }

    public boolean d(@NotNull Minecraft minecraft) {
        if (this.ei == 0) {
            minecraft.getNarrator().sayNow(Component.literal(this.L + ". " + Component.translatable(this.M).getString()));
        }
        int i = this.ei;
        this.ei = i + 1;
        if (i >= eh) {
            return true;
        }
        this.aE = this.aD;
        this.aD = Mth.lerp(0.075f, this.aD, ((double) this.ei) > 135.0d ? 1.0f : 0.0f);
        return false;
    }

    @NotNull
    public UUID getUUID() {
        return this.d;
    }

    @NotNull
    public String getName() {
        return this.L;
    }

    @NotNull
    public String l() {
        return this.M;
    }

    public float j(float f) {
        return C0634xm.e(this.aD, this.aE, f);
    }
}
