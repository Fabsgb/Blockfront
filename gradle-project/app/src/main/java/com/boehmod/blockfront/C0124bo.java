package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bo.class */
public class C0124bo extends AbstractC0141cE {

    /* JADX INFO: renamed from: ce */
    private static final int f821ce = 256;

    /* JADX INFO: renamed from: cf */
    private static final int f822cf = 128;

    /* JADX INFO: renamed from: cg */
    private static final int f823cg = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final MutableComponent f824a = Component.translatable("bf.daily_reward.title").withColor(ColorReferences.COLOR_WHITE).withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: u */
    @NotNull
    private final ResourceLocation f825u;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final ResourceLocation f826v;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final Component f827v;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final ObjectList<RewardType> f828p;

    /* JADX INFO: renamed from: aI */
    private float f829aI;

    /* JADX INFO: renamed from: aJ */
    private float f830aJ;

    /* JADX INFO: renamed from: aq */
    private boolean f831aq;

    public C0124bo(@Nullable Screen screen, int i, boolean z, @NotNull ObjectList<RewardType> objectList) {
        super(screen, Component.empty());
        this.f829aI = 0.0f;
        this.f830aJ = 0.0f;
        this.f831aq = false;
        int i2 = (i - 1) % 4;
        this.f825u = C0532jO.m2378d("textures/gui/dailyreward/bg_" + i2 + ".png");
        this.f826v = C0532jO.m2378d("textures/gui/dailyreward/bg_character_" + i2 + ".png");
        this.f827v = Component.translatable(z ? "bf.daily_reward.message.grace" : "bf.daily_reward.message", new Object[]{Component.literal(C1273xM.m7239b(i)).withColor(9633658)});
        this.f828p = objectList;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        this.f830aJ = this.f829aI;
        this.f829aI = Mth.lerp(0.15f, this.f829aI, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    protected boolean mo437a(double d, double d2) {
        int i = (this.width / 2) - 128;
        int i2 = (this.height / 2) - 64;
        return d < ((double) i) || d > ((double) (i + 256)) || d2 < ((double) i2) || d2 > ((double) (i2 + 128));
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        if (!this.f831aq) {
            this.f831aq = true;
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7958pf.get(), 1.0f, 1.0f));
        }
        int i = this.width / 2;
        addRenderableWidget(new C0085bB(((i - 128) + 64) - 40, ((((this.height / 2) - 64) + 128) - 16) - 10, 80, 16, Component.translatable("bf.daily_reward.confirm"), button -> {
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            m782N();
        }).m328a(C0085bB.a.SHADOW));
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE, com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7170f = C1270xJ.m7170f(this.f829aI, this.f830aJ, f);
        int i3 = (this.width / 2) - 128;
        int i4 = (this.height / 2) - 64;
        float f2 = i / this.width;
        C0129bt.m591c(guiGraphics, i3, i4, 256, 128, C0129bt.m465t());
        C0129bt.m515a(guiGraphics, i3, i4, 256, 128, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m618a(guiGraphics, i3, i4, 256, 128);
        C0129bt.m532a(poseStackPose, guiGraphics, this.f825u, i3 + (30.0f * (1.0f - fM7170f)) + (5.0f * f2), i4, 256.0f, 128.0f, 0.2f + (0.2f * fM7170f));
        C0129bt.m530a(poseStackPose, guiGraphics, this.f826v, i3 + (50.0f * (1.0f - fM7170f)) + (10.0f * f2), i4, 256.0f, 128.0f);
        guiGraphics.disableScissor();
        C0129bt.m467a(poseStackPose, guiGraphics, i3 + 2, i4 + 2, 252, 124);
        int i5 = i3 + 12;
        int i6 = i4 + 12;
        C0129bt.m489b(poseStackPose, this.font, guiGraphics, (Component) f824a, i5, i6, -1, 1.5f);
        int i7 = i6 + 19;
        ObjectArrayList objectArrayList = new ObjectArrayList(this.font.split(this.f827v, 158));
        C0129bt.m473a(poseStackPose, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) objectArrayList, i5, i7, 11);
        if (!this.f828p.isEmpty()) {
            int size = i7 + (objectArrayList.size() * 11) + 1;
            int i8 = 0;
            ObjectListIterator it = this.f828p.iterator();
            while (it.hasNext()) {
                RewardType rewardType = (RewardType) it.next();
                AbstractC0526jI<?> abstractC0526jIM2331a = C0527jJ.m2331a(rewardType);
                abstractC0526jIM2331a.mo2325a(rewardType, guiGraphics, i5 + i8, size, 32, 32);
                int i9 = i5 + i8;
                if (i >= i9 && i <= i9 + 32 && i2 >= size && i2 <= size + 32) {
                    guiGraphics.renderTooltip(this.font, abstractC0526jIM2331a.mo2326a(rewardType), i, i2);
                }
                i8 += 34;
            }
        }
    }
}
