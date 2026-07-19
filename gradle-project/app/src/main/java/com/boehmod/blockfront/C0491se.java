package com.boehmod.blockfront;

import java.util.Locale;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.se, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/se.class */
public final class C0491se {
    private final int qk;

    @NotNull
    private final String cy;

    @NotNull
    private final ResourceLocation fi;

    public C0491se(int i, @NotNull String str) {
        this.qk = i;
        this.cy = str;
        this.fi = C0265jv.d("textures/skins/game/infected/" + str.toLowerCase(Locale.ROOT) + ".png");
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.fi;
    }

    public int bA() {
        return this.qk;
    }

    @NotNull
    public String g() {
        return this.cy;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C0491se c0491se = (C0491se) obj;
        return this.qk == c0491se.qk && Objects.equals(this.cy, c0491se.cy);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.qk), this.cy);
    }

    public String toString() {
        return "InfectedCharacter[id=" + this.qk + ", name=" + this.cy + "]";
    }
}
