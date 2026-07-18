package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.te */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/te.class */
public class C1078te {

    /* JADX INFO: renamed from: bS */
    @NotNull
    public final List<AbstractC1077td> f5656bS = new ObjectArrayList();

    /* JADX INFO: renamed from: oW */
    private int f5657oW = 0;

    /* JADX INFO: renamed from: a */
    private AbstractC1077td f5658a;

    public C1078te() {
        this.f5656bS.add(new C1075tb());
        this.f5656bS.add(new C1076tc());
        this.f5658a = this.f5656bS.get(this.f5657oW);
    }

    public void onUpdate() {
        if (this.f5658a != null && this.f5658a.m5984k()) {
            this.f5657oW++;
            if (this.f5657oW >= this.f5656bS.size()) {
                this.f5657oW = 0;
            }
            this.f5658a.m5985bf();
            this.f5658a = this.f5656bS.get(this.f5657oW);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5987a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (this.f5658a != null && this.f5658a.m5986B(f) > 0.0f) {
            C0119bk.m517a(guiGraphics, i, i2, i3, i4);
            this.f5658a.mo5983a(poseStack, font, guiGraphics, abstractC0787oF, i, i2, i3, i4, i5, i6, f);
            guiGraphics.disableScissor();
        }
    }
}
