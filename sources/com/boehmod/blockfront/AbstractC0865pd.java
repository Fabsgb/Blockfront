package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pd.class */
public abstract class AbstractC0865pd<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0864pc<G, P> {

    /* JADX INFO: renamed from: bQ */
    @NotNull
    private static final String f4710bQ = "bf.message.gamemode.capturepoint.capturing";

    /* JADX INFO: renamed from: bR */
    @NotNull
    private static final String f4711bR = "bf.message.gamemode.capturepoint.defending";

    /* JADX INFO: renamed from: bS */
    @NotNull
    private static final String f4712bS = "bf.message.gamemode.capturepoint.blocking";

    /* JADX INFO: renamed from: dH */
    @NotNull
    private static final ResourceLocation f4713dH = C0532jO.m2378d("textures/gui/game/capturepoint/progress.png");

    /* JADX INFO: renamed from: dI */
    @NotNull
    private static final ResourceLocation f4714dI = C0532jO.m2378d("textures/gui/game/capturepoint/progress_axis.png");

    /* JADX INFO: renamed from: dJ */
    @NotNull
    private static final ResourceLocation f4715dJ = C0532jO.m2378d("textures/gui/game/capturepoint/progress_allies.png");

    /* JADX INFO: renamed from: oM */
    private static final int f4716oM = 28;

    /* JADX INFO: renamed from: oN */
    private static final int f4717oN = 120;

    /* JADX INFO: renamed from: lj */
    private static final float f4718lj = 5.0f;

    /* JADX INFO: renamed from: lk */
    protected static final float f4719lk = 0.0f;

    /* JADX INFO: renamed from: b */
    @Nullable
    protected AbstractC0879pr<?> f4720b;

    /* JADX INFO: renamed from: iX */
    @Nullable
    private Component f4721iX;

    /* JADX INFO: renamed from: dK */
    @Nullable
    private ResourceLocation f4722dK;

    /* JADX INFO: renamed from: gw */
    private boolean f4723gw;

    public AbstractC0865pd(@NotNull C0623l c0623l, @NotNull G g, @NotNull C0396gl c0396gl) {
        super(c0623l, g, c0396gl);
        this.f4720b = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4118a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.mo4118a(minecraft, random, randomSource, localPlayer, clientLevel, c0623l, c0394gj, set, f, vec3, blockPos);
        AbstractC0879pr<?> abstractC0879pr = this.f4720b;
        C0872pk c0872pkM4229a = abstractC0879pr != null ? this.f4666f.m4018b().m4229a(localPlayer.getUUID()) : null;
        if (abstractC0879pr != null && c0872pkM4229a != null) {
            m4203a(abstractC0879pr, c0872pkM4229a);
        } else {
            this.f4721iX = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4203a(@NotNull AbstractC0879pr<?> abstractC0879pr, @NotNull C0872pk c0872pk) {
        String str;
        C0872pk c0872pkMo4204a = mo4204a(abstractC0879pr, c0872pk);
        this.f4723gw = c0872pkMo4204a.equals(abstractC0879pr.f4803d);
        String name = c0872pkMo4204a.getName();
        if (name.equalsIgnoreCase(C1062tN.f5783dl)) {
            this.f4722dK = f4714dI;
        } else if (name.equalsIgnoreCase(C1062tN.f5782dk)) {
            this.f4722dK = f4715dJ;
        } else {
            this.f4722dK = f4713dH;
        }
        C0872pk c0872pkM4552d = abstractC0879pr.m4552d();
        MutableComponent mutableComponentWithStyle = Component.literal(abstractC0879pr.f4796bZ.toUpperCase(Locale.ROOT)).withStyle(c0872pkM4552d != null ? c0872pkM4552d.m4312a() : Style.EMPTY.withColor(ChatFormatting.GRAY));
        C0872pk c0872pkMo4542c = abstractC0879pr.mo4542c();
        if (c0872pk.equals(c0872pkMo4542c)) {
            str = f4710bQ;
        } else if (abstractC0879pr.m4553e() == null && c0872pkMo4542c != null) {
            str = f4712bS;
        } else {
            str = f4711bR;
        }
        this.f4721iX = Component.translatable(str, new Object[]{mutableComponentWithStyle}).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0872pk mo4204a(@NotNull AbstractC0879pr<?> abstractC0879pr, @NotNull C0872pk c0872pk) {
        C0872pk c0872pkMo4542c = abstractC0879pr.mo4542c();
        return c0872pkMo4542c != null ? c0872pkMo4542c : c0872pk;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        if (!C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj) && this.f4666f.m4023a() == EnumC0871pj.GAME) {
            m4205a(poseStack, guiGraphics, font, i2, i3, f2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4205a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        AbstractC0879pr<?> abstractC0879pr = this.f4720b;
        Component component = this.f4721iX;
        ResourceLocation resourceLocation = this.f4722dK;
        if (abstractC0879pr == null || component == null || resourceLocation == null) {
            return;
        }
        int iM465t = C0129bt.m465t();
        boolean z = this.f4723gw;
        float fM7170f = C1270xJ.m7170f(abstractC0879pr.f4813lp, abstractC0879pr.f4814lq, f);
        int i3 = (i - 56) - 30;
        C0129bt.m518b(guiGraphics, i2 - 64, (i3 - 4) - 1, 128, 30, iM465t);
        int i4 = i2 - 60;
        int i5 = i3 + 12;
        C0129bt.m518b(guiGraphics, i4, i5 - 1, 120, 10, ColorReferences.COLOR_BLACK_SOLID);
        int i6 = i4 + 1;
        int i7 = (i5 + 1) - 1;
        float fMo4544bs = z ? 118.0f : ((fM7170f * 118.0f) / abstractC0879pr.mo4544bs()) - 2.0f;
        C0129bt.m515a(guiGraphics, i6, i7, 118, 8, iM465t);
        C0129bt.m618a(guiGraphics, i4, i5, ((int) fMo4544bs) + 1, 8);
        C0129bt.m531a(poseStack, guiGraphics, resourceLocation, i6, i7, 118, 8);
        guiGraphics.disableScissor();
        C0129bt.m499a(poseStack, font, guiGraphics, component, i2, i3);
    }

    /* JADX INFO: renamed from: D */
    protected static float m4206D(float f) {
        return C1270xJ.m7190j(f, 5.0f, 0.0f);
    }
}
