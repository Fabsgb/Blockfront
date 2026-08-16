package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cL.class */
public final class C0148cL {

    /* JADX INFO: renamed from: fh */
    private static final int f1143fh = 180;

    /* JADX INFO: renamed from: R */
    @NotNull
    private final String f1144R;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final UUID f1145d;

    /* JADX INFO: renamed from: S */
    @NotNull
    private final String f1146S;

    /* JADX INFO: renamed from: fi */
    private int f1147fi = 0;

    /* JADX INFO: renamed from: aI */
    private float f1148aI = 1.0f;

    /* JADX INFO: renamed from: aJ */
    private float f1149aJ = 1.0f;

    public C0148cL(@NotNull UUID uuid, @NotNull String str, @NotNull String str2) {
        this.f1145d = uuid;
        this.f1144R = str;
        this.f1146S = str2;
    }

    /* JADX INFO: renamed from: d */
    public boolean m824d(@NotNull Minecraft minecraft) {
        if (this.f1147fi == 0) {
            minecraft.getNarrator().sayNow(Component.literal(this.f1144R + ". " + Component.translatable(this.f1146S).getString()));
        }
        int i = this.f1147fi;
        this.f1147fi = i + 1;
        if (i >= f1143fh) {
            return true;
        }
        this.f1149aJ = this.f1148aI;
        this.f1148aI = Mth.lerp(0.075f, this.f1148aI, ((double) this.f1147fi) > 135.0d ? 1.0f : 0.0f);
        return false;
    }

    @NotNull
    public UUID getUUID() {
        return this.f1145d;
    }

    @NotNull
    public String getName() {
        return this.f1144R;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public String m825p() {
        return this.f1146S;
    }

    /* JADX INFO: renamed from: i */
    public float m826i(float f) {
        return C1270xJ.m7170f(this.f1148aI, this.f1149aJ, f);
    }
}
