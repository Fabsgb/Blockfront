package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oH.class */
public abstract class AbstractC0789oH<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0788oG<G, P> {

    /* JADX INFO: renamed from: bH */
    @NotNull
    private static final String f4316bH = "bf.message.gamemode.capturepoint.capturing";

    /* JADX INFO: renamed from: bI */
    @NotNull
    private static final String f4317bI = "bf.message.gamemode.capturepoint.defending";

    /* JADX INFO: renamed from: dJ */
    @NotNull
    private static final ResourceLocation f4318dJ = C0564jv.m2555d("textures/gui/game/capturepoint/progress.png");

    /* JADX INFO: renamed from: dK */
    @NotNull
    private static final ResourceLocation f4319dK = C0564jv.m2555d("textures/gui/game/capturepoint/progress_axis.png");

    /* JADX INFO: renamed from: dL */
    @NotNull
    private static final ResourceLocation f4320dL = C0564jv.m2555d("textures/gui/game/capturepoint/progress_allies.png");

    /* JADX INFO: renamed from: mO */
    private static final int f4321mO = 28;

    /* JADX INFO: renamed from: mP */
    private static final int f4322mP = 120;

    /* JADX INFO: renamed from: kq */
    private static final float f4323kq = 5.0f;

    /* JADX INFO: renamed from: kr */
    protected static final float f4324kr = 0.0f;

    /* JADX INFO: renamed from: b */
    @Nullable
    protected AbstractC0803oV<?> f4325b;

    /* JADX INFO: renamed from: iL */
    @Nullable
    private Component f4326iL;

    /* JADX INFO: renamed from: dM */
    @Nullable
    private ResourceLocation f4327dM;

    /* JADX INFO: renamed from: gc */
    private boolean f4328gc;

    public AbstractC0789oH(@NotNull C0622l c0622l, @NotNull G g, @NotNull C0326fV c0326fV) {
        super(c0622l, g, c0326fV);
        this.f4325b = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3682a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.mo3682a(minecraft, random, randomSource, localPlayer, clientLevel, c0622l, c0324fT, set, f, vec3, blockPos);
        AbstractC0803oV<?> abstractC0803oV = this.f4325b;
        C0796oO c0796oOM3793a = abstractC0803oV != null ? this.f4272f.m3582b().m3793a(localPlayer.getUUID()) : null;
        if (abstractC0803oV != null && c0796oOM3793a != null) {
            m3767a(abstractC0803oV, c0796oOM3793a);
        } else {
            this.f4326iL = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3767a(@NotNull AbstractC0803oV<?> abstractC0803oV, @NotNull C0796oO c0796oO) {
        C0796oO c0796oOMo3768a = mo3768a(abstractC0803oV, c0796oO);
        this.f4328gc = c0796oOMo3768a.equals(abstractC0803oV.f4402d);
        String name = c0796oOMo3768a.getName();
        if (name.equalsIgnoreCase(C1089tp.f5730da)) {
            this.f4327dM = f4319dK;
        } else if (name.equalsIgnoreCase(C1089tp.f5729cZ)) {
            this.f4327dM = f4320dL;
        } else {
            this.f4327dM = f4318dJ;
        }
        C0796oO c0796oOM4114d = abstractC0803oV.m4114d();
        this.f4326iL = Component.translatable(!c0796oO.equals(c0796oOMo3768a) || c0796oO.equals(abstractC0803oV.f4402d) ? f4317bI : f4316bH, new Object[]{Component.literal(abstractC0803oV.f4399bP.toUpperCase(Locale.ROOT)).withStyle(c0796oOM4114d != null ? c0796oOM4114d.m3876a() : Style.EMPTY.withColor(ChatFormatting.GRAY))}).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0796oO mo3768a(@NotNull AbstractC0803oV<?> abstractC0803oV, @NotNull C0796oO c0796oO) {
        return c0796oO;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        if (!C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT) && this.f4272f.m3587a() == EnumC0795oN.GAME) {
            m3769a(poseStack, guiGraphics, font, i2, i3, f2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3769a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        AbstractC0803oV<?> abstractC0803oV = this.f4325b;
        Component component = this.f4326iL;
        ResourceLocation resourceLocation = this.f4327dM;
        if (abstractC0803oV == null || component == null || resourceLocation == null) {
            return;
        }
        int iM365p = C0119bk.m365p();
        boolean z = this.f4328gc;
        float fM7843e = C1290xm.m7843e(abstractC0803oV.f4411ku, abstractC0803oV.f4412kv, f);
        int i3 = (i - 56) - 30;
        int i4 = i2 - 64;
        int i5 = i3 - 4;
        C0119bk.m415a(guiGraphics, i4 + 1, i5 - 1, 126, 1, iM365p);
        C0119bk.m415a(guiGraphics, i4, i5, 128, 28, iM365p);
        C0119bk.m415a(guiGraphics, i4 + 1, i5 + 28, 126, 1, iM365p);
        int i6 = i2 - 60;
        int i7 = i3 + 12;
        C0119bk.m415a(guiGraphics, i6 + 1, i7 - 1, 118, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, i6, i7, 120, 8, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, i6 + 1, i7 + 8, 118, 1, ColorReferences.COLOR_BLACK_SOLID);
        int i8 = i6 + 1;
        int i9 = (i7 + 1) - 1;
        float fMo4107bd = z ? 118.0f : ((fM7843e * 118.0f) / abstractC0803oV.mo4107bd()) - 2.0f;
        C0119bk.m415a(guiGraphics, i8, i9, 118, 8, iM365p);
        C0119bk.m517a(guiGraphics, i6, i7, ((int) fMo4107bd) + 1, 8);
        C0119bk.m431a(poseStack, guiGraphics, resourceLocation, i8, i9, 118, 8);
        guiGraphics.disableScissor();
        C0119bk.m399a(poseStack, font, guiGraphics, component, i2, i3);
    }

    /* JADX INFO: renamed from: A */
    protected static float m3770A(float f) {
        return C1290xm.m7863i(f, 5.0f, 0.0f);
    }
}
