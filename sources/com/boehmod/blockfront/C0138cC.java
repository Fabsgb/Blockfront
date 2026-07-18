package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cC.class */
public final class C0138cC {

    /* JADX INFO: renamed from: eh */
    private static final int f1053eh = 180;

    /* JADX INFO: renamed from: L */
    @NotNull
    private final String f1054L;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final UUID f1055d;

    /* JADX INFO: renamed from: M */
    @NotNull
    private final String f1056M;

    /* JADX INFO: renamed from: ei */
    private int f1057ei = 0;

    /* JADX INFO: renamed from: aD */
    private float f1058aD = 1.0f;

    /* JADX INFO: renamed from: aE */
    private float f1059aE = 1.0f;

    public C0138cC(@NotNull UUID uuid, @NotNull String str, @NotNull String str2) {
        this.f1055d = uuid;
        this.f1054L = str;
        this.f1056M = str2;
    }

    /* JADX INFO: renamed from: d */
    public boolean m769d(@NotNull Minecraft minecraft) {
        if (this.f1057ei == 0) {
            minecraft.getNarrator().sayNow(Component.literal(this.f1054L + ". " + Component.translatable(this.f1056M).getString()));
        }
        int i = this.f1057ei;
        this.f1057ei = i + 1;
        if (i >= f1053eh) {
            return true;
        }
        this.f1059aE = this.f1058aD;
        this.f1058aD = Mth.lerp(0.075f, this.f1058aD, ((double) this.f1057ei) > 135.0d ? 1.0f : 0.0f);
        return false;
    }

    @NotNull
    public UUID getUUID() {
        return this.f1055d;
    }

    @NotNull
    public String getName() {
        return this.f1054L;
    }

    @NotNull
    /* JADX INFO: renamed from: l */
    public String m770l() {
        return this.f1056M;
    }

    /* JADX INFO: renamed from: j */
    public float m771j(float f) {
        return C1290xm.m7843e(this.f1058aD, this.f1059aE, f);
    }
}
