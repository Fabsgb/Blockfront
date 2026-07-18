package com.boehmod.blockfront;

import java.util.Locale;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.se */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/se.class */
public final class C1024se {

    /* JADX INFO: renamed from: qk */
    private final int f5436qk;

    /* JADX INFO: renamed from: cy */
    @NotNull
    private final String f5437cy;

    /* JADX INFO: renamed from: fi */
    @NotNull
    private final ResourceLocation f5438fi;

    public C1024se(int i, @NotNull String str) {
        this.f5436qk = i;
        this.f5437cy = str;
        this.f5438fi = C0564jv.m2555d("textures/skins/game/infected/" + str.toLowerCase(Locale.ROOT) + ".png");
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.f5438fi;
    }

    /* JADX INFO: renamed from: bA */
    public int m5715bA() {
        return this.f5436qk;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public String m5716g() {
        return this.f5437cy;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C1024se c1024se = (C1024se) obj;
        return this.f5436qk == c1024se.f5436qk && Objects.equals(this.f5437cy, c1024se.f5437cy);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f5436qk), this.f5437cy);
    }

    public String toString() {
        return "InfectedCharacter[id=" + this.f5436qk + ", name=" + this.f5437cy + "]";
    }
}
