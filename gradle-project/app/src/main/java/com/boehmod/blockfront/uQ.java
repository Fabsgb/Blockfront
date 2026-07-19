package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uQ.class */
public class uQ extends uO {
    private final float nG;
    private final float nH;
    private final boolean iB;

    public uQ(float f) {
        this(f, -1.0f, false);
    }

    public uQ(float f, float f2) {
        this(f, f2, true);
    }

    private uQ(float f, float f2, boolean z) {
        this.nG = f;
        this.nH = f2;
        this.iB = z;
    }

    @Override // com.boehmod.blockfront.uO
    public void a(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull List<String> list) {
        list.add(this.iB && C0558ur.a(itemStack) <= 0 ? "reload_empty" : "reload");
        list.add("idle");
    }

    @Override // com.boehmod.blockfront.uO
    /* JADX INFO: renamed from: a */
    public float mo1175a(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack) {
        return (this.iB && C0558ur.a(itemStack) <= 0 ? this.nH : this.nG) * 20.0f;
    }

    @Override // com.boehmod.blockfront.uO
    public boolean cK() {
        return this.iB;
    }
}
