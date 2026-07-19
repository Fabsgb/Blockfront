package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.te, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/te.class */
public class C0518te {

    @NotNull
    public final List<AbstractC0517td> bS = new ObjectArrayList();
    private int oW = 0;
    private AbstractC0517td a;

    public C0518te() {
        this.bS.add(new C0515tb());
        this.bS.add(new C0516tc());
        this.a = this.bS.get(this.oW);
    }

    public void onUpdate() {
        if (this.a != null && this.a.k()) {
            this.oW++;
            if (this.oW >= this.bS.size()) {
                this.oW = 0;
            }
            this.a.bf();
            this.a = this.bS.get(this.oW);
        }
    }

    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (this.a != null && this.a.B(f) > 0.0f) {
            C0040bk.a(guiGraphics, i, i2, i3, i4);
            this.a.a(poseStack, font, guiGraphics, oFVar, i, i2, i3, i4, i5, i6, f);
            guiGraphics.disableScissor();
        }
    }
}
