package com.boehmod.blockfront;

import net.minecraft.util.StringRepresentable;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.pz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pz.class */
public enum EnumC0431pz implements StringRepresentable {
    DEFAULT("default"),
    FIRE_FLICKER("fire_flicker");


    @NotNull
    private static final Vector3f SCRATCH = new Vector3f();

    @NotNull
    private final String name;

    EnumC0431pz(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getSerializedName() {
        return this.name;
    }

    @OnlyIn(Dist.CLIENT)
    public float applyTo(float f, float f2, float f3) {
        if (this == FIRE_FLICKER) {
            return f + fZ.d.a(f2 + f3, 1.0f, SCRATCH).y;
        }
        return f;
    }
}
