package com.boehmod.blockfront;

import java.util.Locale;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sB.class */
public final class C0996sB {

    /* JADX INFO: renamed from: sl */
    private final int f5484sl;

    /* JADX INFO: renamed from: cI */
    @NotNull
    private final String f5485cI;

    /* JADX INFO: renamed from: fh */
    @NotNull
    private final ResourceLocation f5486fh;

    public C0996sB(int i, @NotNull String str) {
        this.f5484sl = i;
        this.f5485cI = str;
        this.f5486fh = C0532jO.m2378d("textures/skins/game/infected/" + str.toLowerCase(Locale.ROOT) + ".png");
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.f5486fh;
    }

    /* JADX INFO: renamed from: bP */
    public int m5600bP() {
        return this.f5484sl;
    }

    @NotNull
    /* JADX INFO: renamed from: k */
    public String m5601k() {
        return this.f5485cI;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C0996sB c0996sB = (C0996sB) obj;
        return this.f5484sl == c0996sB.f5484sl && Objects.equals(this.f5485cI, c0996sB.f5485cI);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f5484sl), this.f5485cI);
    }

    public String toString() {
        return "InfectedCharacter[id=" + this.f5484sl + ", name=" + this.f5485cI + "]";
    }
}
