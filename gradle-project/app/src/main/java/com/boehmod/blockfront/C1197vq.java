package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vq.class */
public class C1197vq extends AbstractC1195vo {

    /* JADX INFO: renamed from: oE */
    private final float f6508oE;

    /* JADX INFO: renamed from: oF */
    private final float f6509oF;

    /* JADX INFO: renamed from: iV */
    private final boolean f6510iV;

    public C1197vq(float f) {
        this(f, -1.0f, false);
    }

    public C1197vq(float f, float f2) {
        this(f, f2, true);
    }

    private C1197vq(float f, float f2, boolean z) {
        this.f6508oE = f;
        this.f6509oF = f2;
        this.f6510iV = z;
    }

    @Override // com.boehmod.blockfront.AbstractC1195vo
    /* JADX INFO: renamed from: a */
    public void mo6796a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2, @NotNull List<String> list) {
        list.add(this.f6510iV && i <= 0 ? "reload_empty" : "reload");
        list.add("idle");
    }

    @Override // com.boehmod.blockfront.AbstractC1195vo
    /* JADX INFO: renamed from: a */
    public float mo6797a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i, int i2) {
        return (this.f6510iV && i <= 0 ? this.f6509oF : this.f6508oE) * 20.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC1195vo
    /* JADX INFO: renamed from: cT */
    public boolean mo6798cT() {
        return this.f6510iV;
    }
}
