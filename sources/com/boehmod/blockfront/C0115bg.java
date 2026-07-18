package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.reward.RewardType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bg.class */
public class C0115bg extends AbstractC0193cv {

    /* JADX INFO: renamed from: bo */
    private static final int f690bo = 256;

    /* JADX INFO: renamed from: bp */
    private static final int f691bp = 128;

    /* JADX INFO: renamed from: bq */
    private static final int f692bq = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final MutableComponent f693a = Component.translatable("bf.daily_reward.title").withColor(ColorReferences.COLOR_WHITE).withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: u */
    @NotNull
    private final ResourceLocation f694u;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final ResourceLocation f695v;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final Component f696v;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final ObjectList<RewardType> f697g;

    /* JADX INFO: renamed from: aD */
    private float f698aD;

    /* JADX INFO: renamed from: aE */
    private float f699aE;

    /* JADX INFO: renamed from: al */
    private boolean f700al;

    public C0115bg(@Nullable Screen screen, int i, boolean z, @NotNull ObjectList<RewardType> objectList) {
        super(screen, Component.empty());
        this.f698aD = 0.0f;
        this.f699aE = 0.0f;
        this.f700al = false;
        int i2 = (i - 1) % 4;
        this.f694u = C0564jv.m2555d("textures/gui/dailyreward/bg_" + i2 + ".png");
        this.f695v = C0564jv.m2555d("textures/gui/dailyreward/bg_character_" + i2 + ".png");
        this.f696v = Component.translatable(z ? "bf.daily_reward.message.grace" : "bf.daily_reward.message", new Object[]{Component.literal(C1293xp.m7912a(i)).withColor(9633658)});
        this.f697g = objectList;
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        this.f699aE = this.f698aD;
        this.f698aD = Mth.lerp(0.15f, this.f698aD, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    protected boolean mo344a(double d, double d2) {
        int i = (this.width / 2) - 128;
        int i2 = (this.height / 2) - 64;
        return d < ((double) i) || d > ((double) (i + 256)) || d2 < ((double) i2) || d2 > ((double) (i2 + 128));
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        if (!this.f700al) {
            this.f700al = true;
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7546pd.get(), 1.0f, 1.0f));
        }
        int i = this.width / 2;
        addRenderableWidget(new C0127bs(((i - 128) + 64) - 40, ((((this.height / 2) - 64) + 128) - 16) - 10, 80, 16, Component.translatable("bf.daily_reward.confirm"), button -> {
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            m1184J();
        }).m653a(C0127bs.a.SHADOW));
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7843e = C1290xm.m7843e(this.f698aD, this.f699aE, f);
        int i3 = (this.width / 2) - 128;
        int i4 = (this.height / 2) - 64;
        float f2 = i / this.width;
        C0119bk.m491c(guiGraphics, i3, i4, 256, 128, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, i3, i4, 256, 128, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m517a(guiGraphics, i3, i4, 256, 128);
        C0119bk.m432a(poseStackPose, guiGraphics, this.f694u, i3 + (30.0f * (1.0f - fM7843e)) + (5.0f * f2), i4, 256.0f, 128.0f, 0.2f + (0.2f * fM7843e));
        C0119bk.m430a(poseStackPose, guiGraphics, this.f695v, i3 + (50.0f * (1.0f - fM7843e)) + (10.0f * f2), i4, 256.0f, 128.0f);
        guiGraphics.disableScissor();
        C0119bk.m367a(poseStackPose, guiGraphics, i3 + 2, i4 + 2, 252, 124);
        int i5 = i3 + 12;
        int i6 = i4 + 12;
        C0119bk.m389b(poseStackPose, this.font, guiGraphics, (Component) f693a, i5, i6, -1, 1.5f);
        int i7 = i6 + 19;
        ObjectArrayList objectArrayList = new ObjectArrayList(this.font.split(this.f696v, 158));
        C0119bk.m373a(poseStackPose, this.font, (MultiBufferSource) bufferSource, (List<FormattedCharSequence>) objectArrayList, i5, i7, 11);
        if (!this.f697g.isEmpty()) {
            int size = i7 + (objectArrayList.size() * 11) + 1;
            int i8 = 0;
            ObjectListIterator it = this.f697g.iterator();
            while (it.hasNext()) {
                RewardType rewardType = (RewardType) it.next();
                AbstractC0558jp<?> abstractC0558jpM2511a = C0559jq.m2511a(rewardType);
                abstractC0558jpM2511a.mo2505a(rewardType, guiGraphics, i5 + i8, size, 32, 32);
                int i9 = i5 + i8;
                if (i >= i9 && i <= i9 + 32 && i2 >= size && i2 <= size + 32) {
                    guiGraphics.renderTooltip(this.font, abstractC0558jpM2511a.mo2506a(rewardType), i, i2);
                }
                i8 += 34;
            }
        }
    }
}
