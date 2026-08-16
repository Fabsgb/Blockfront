package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tB.class */
public class C1050tB {

    /* JADX INFO: renamed from: bZ */
    @NotNull
    public final List<AbstractC1049tA> f5703bZ = new ObjectArrayList();

    /* JADX INFO: renamed from: qV */
    private int f5704qV = 0;

    /* JADX INFO: renamed from: a */
    private AbstractC1049tA f5705a;

    public C1050tB() {
        this.f5703bZ.add(new C1099ty());
        this.f5703bZ.add(new C1100tz());
        this.f5705a = this.f5703bZ.get(this.f5704qV);
    }

    public void onUpdate() {
        if (this.f5705a != null && this.f5705a.m5863l()) {
            this.f5704qV++;
            if (this.f5704qV >= this.f5703bZ.size()) {
                this.f5704qV = 0;
            }
            this.f5705a.m5864bd();
            this.f5705a = this.f5703bZ.get(this.f5704qV);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5867a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (this.f5705a != null && this.f5705a.m5866E(f) > 0.0f) {
            C0129bt.m618a(guiGraphics, i, i2, i3, i4);
            this.f5705a.mo5865a(poseStack, font, guiGraphics, abstractC0863pb, i, i2, i3, i4, i5, i6, f);
            guiGraphics.disableScissor();
        }
    }
}
