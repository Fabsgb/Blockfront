package com.boehmod.blockfront;

import net.minecraft.util.StringRepresentable;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.pV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pV.class */
public enum EnumC0857pV implements StringRepresentable {
    DEFAULT("default"),
    FIRE_FLICKER("fire_flicker");


    @NotNull
    private static final Vector3f SCRATCH = new Vector3f();

    @NotNull
    private final String name;

    EnumC0857pV(String str) {
        this.name = str;
    }

    @NotNull
    public String getSerializedName() {
        return this.name;
    }

    @OnlyIn(Dist.CLIENT)
    public float applyTo(float f, float f2, float f3) {
        if (this == FIRE_FLICKER) {
            return f + C0400gp.f2593d.m1904a(f2 + f3, 1.0f, SCRATCH).y;
        }
        return f;
    }
}
