package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.bg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bg.class */
public class C0036bg extends AbstractC0078cv {
    private static final int bo = 256;
    private static final int bp = 128;
    private static final int bq = 4;

    @NotNull
    private static final MutableComponent a = Component.translatable("bf.daily_reward.title").withColor(ColorReferences.COLOR_WHITE).withStyle(C0266jw.b);

    @NotNull
    private final ResourceLocation u;

    @NotNull
    private final ResourceLocation v;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    @NotNull
    private final Component f60v;

    @NotNull
    private final ObjectList<RewardType> g;
    private float aD;
    private float aE;
    private boolean al;

    public C0036bg(@Nullable Screen screen, int i, boolean z, @NotNull ObjectList<RewardType> objectList) {
        super(screen, Component.empty());
        this.aD = 0.0f;
        this.aE = 0.0f;
        this.al = false;
        int i2 = (i - 1) % 4;
        this.u = C0265jv.d("textures/gui/dailyreward/bg_" + i2 + ".png");
        this.v = C0265jv.d("textures/gui/dailyreward/bg_character_" + i2 + ".png");
        this.f60v = Component.translatable(z ? "bf.daily_reward.message.grace" : "bf.daily_reward.message", new Object[]{Component.literal(C0637xp.a(i)).withColor(9633658)});
        this.g = objectList;
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        this.aE = this.aD;
        this.aD = Mth.lerp(0.15f, this.aD, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    protected boolean a(double d, double d2) {
        int i = (this.width / 2) - 128;
        int i2 = (this.height / 2) - 64;
        return d < ((double) i) || d > ((double) (i + 256)) || d2 < ((double) i2) || d2 > ((double) (i2 + 128));
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        if (!this.al) {
            this.al = true;
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pd.get(), 1.0f, 1.0f));
        }
        int i = this.width / 2;
        addRenderableWidget(new C0048bs(((i - 128) + 64) - 40, ((((this.height / 2) - 64) + 128) - 16) - 10, 80, 16, Component.translatable("bf.daily_reward.confirm"), button -> {
            this.b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            J();
        }).a(C0048bs.a.SHADOW));
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        PoseStack poseStackPose = guiGraphics.pose();
        float fE = C0634xm.e(this.aD, this.aE, f);
        int i3 = (this.width / 2) - 128;
        int i4 = (this.height / 2) - 64;
        float f2 = i / this.width;
        C0040bk.c(guiGraphics, i3, i4, 256, 128, C0040bk.p());
        C0040bk.a(guiGraphics, i3, i4, 256, 128, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, i3, i4, 256, 128);
        C0040bk.a(poseStackPose, guiGraphics, this.u, i3 + (30.0f * (1.0f - fE)) + (5.0f * f2), i4, 256.0f, 128.0f, 0.2f + (0.2f * fE));
        C0040bk.a(poseStackPose, guiGraphics, this.v, i3 + (50.0f * (1.0f - fE)) + (10.0f * f2), i4, 256.0f, 128.0f);
        guiGraphics.disableScissor();
        C0040bk.a(poseStackPose, guiGraphics, i3 + 2, i4 + 2, 252, 124);
        int i5 = i3 + 12;
        int i6 = i4 + 12;
        C0040bk.b(poseStackPose, this.font, guiGraphics, (Component) a, i5, i6, -1, 1.5f);
        int i7 = i6 + 19;
        ObjectArrayList objectArrayList = new ObjectArrayList(this.font.split(this.f60v, 158));
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) objectArrayList, i5, i7, 11);
        if (!this.g.isEmpty()) {
            int size = i7 + (objectArrayList.size() * 11) + 1;
            int i8 = 0;
            ObjectListIterator it = this.g.iterator();
            while (it.hasNext()) {
                RewardType rewardType = (RewardType) it.next();
                AbstractC0259jp<?> abstractC0259jpA = C0260jq.a(rewardType);
                abstractC0259jpA.a(rewardType, guiGraphics, i5 + i8, size, 32, 32);
                int i9 = i5 + i8;
                if (i >= i9 && i <= i9 + 32 && i2 >= size && i2 <= size + 32) {
                    guiGraphics.renderTooltip(this.font, abstractC0259jpA.a(rewardType), i, i2);
                }
                i8 += 34;
            }
        }
    }
}
