package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uQ.class */
public class C1117uQ extends AbstractC1115uO {

    /* JADX INFO: renamed from: nG */
    private final float f5869nG;

    /* JADX INFO: renamed from: nH */
    private final float f5870nH;

    /* JADX INFO: renamed from: iB */
    private final boolean f5871iB;

    public C1117uQ(float f) {
        this(f, -1.0f, false);
    }

    public C1117uQ(float f, float f2) {
        this(f, f2, true);
    }

    private C1117uQ(float f, float f2, boolean z) {
        this.f5869nG = f;
        this.f5870nH = f2;
        this.f5871iB = z;
    }

    @Override // com.boehmod.blockfront.AbstractC1115uO
    /* JADX INFO: renamed from: a */
    public void mo6143a(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull List<String> list) {
        list.add(this.f5871iB && C1144ur.m6301a(itemStack) <= 0 ? "reload_empty" : "reload");
        list.add("idle");
    }

    @Override // com.boehmod.blockfront.AbstractC1115uO
    /* JADX INFO: renamed from: a */
    public float mo6144a(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack) {
        return (this.f5871iB && C1144ur.m6301a(itemStack) <= 0 ? this.f5870nH : this.f5869nG) * 20.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC1115uO
    /* JADX INFO: renamed from: cK */
    public boolean mo6145cK() {
        return this.f5871iB;
    }
}
