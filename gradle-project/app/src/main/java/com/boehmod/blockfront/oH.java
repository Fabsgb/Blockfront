package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oH.class */
public abstract class oH<G extends oF<G, P, ?>, P extends oI<G>> extends oG<G, P> {

    @NotNull
    private static final String bH = "bf.message.gamemode.capturepoint.capturing";

    @NotNull
    private static final String bI = "bf.message.gamemode.capturepoint.defending";

    @NotNull
    private static final ResourceLocation dJ = C0265jv.d("textures/gui/game/capturepoint/progress.png");

    @NotNull
    private static final ResourceLocation dK = C0265jv.d("textures/gui/game/capturepoint/progress_axis.png");

    @NotNull
    private static final ResourceLocation dL = C0265jv.d("textures/gui/game/capturepoint/progress_allies.png");
    private static final int mO = 28;
    private static final int mP = 120;
    private static final float kq = 5.0f;
    protected static final float kr = 0.0f;

    @Nullable
    protected oV<?> b;

    @Nullable
    private Component iL;

    @Nullable
    private ResourceLocation dM;
    private boolean gc;

    public oH(@NotNull C0297l c0297l, @NotNull G g, @NotNull fV fVVar) {
        super(c0297l, g, fVVar);
        this.b = null;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.a(minecraft, random, randomSource, localPlayer, clientLevel, c0297l, fTVar, set, f, vec3, blockPos);
        oV<?> oVVar = this.b;
        oO oOVarA = oVVar != null ? this.f.b().a(localPlayer.getUUID()) : null;
        if (oVVar != null && oOVarA != null) {
            a(oVVar, oOVarA);
        } else {
            this.iL = null;
        }
    }

    private void a(@NotNull oV<?> oVVar, @NotNull oO oOVar) {
        oO oOVarMo779a = mo779a(oVVar, oOVar);
        this.gc = oOVarMo779a.equals(oVVar.d);
        String name = oOVarMo779a.getName();
        if (name.equalsIgnoreCase(C0529tp.da)) {
            this.dM = dK;
        } else if (name.equalsIgnoreCase(C0529tp.cZ)) {
            this.dM = dL;
        } else {
            this.dM = dJ;
        }
        oO oOVarM801d = oVVar.m801d();
        this.iL = Component.translatable(!oOVar.equals(oOVarMo779a) || oOVar.equals(oVVar.d) ? bI : bH, new Object[]{Component.literal(oVVar.bP.toUpperCase(Locale.ROOT)).withStyle(oOVarM801d != null ? oOVarM801d.a() : Style.EMPTY.withColor(ChatFormatting.GRAY))}).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected oO mo779a(@NotNull oV<?> oVVar, @NotNull oO oOVar) {
        return oOVar;
    }

    @Override // com.boehmod.blockfront.oG
    @OnlyIn(Dist.CLIENT)
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        if (!oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar) && this.f.m750a() == oN.GAME) {
            a(poseStack, guiGraphics, font, i2, i3, f2);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        oV<?> oVVar = this.b;
        Component component = this.iL;
        ResourceLocation resourceLocation = this.dM;
        if (oVVar == null || component == null || resourceLocation == null) {
            return;
        }
        int iP = C0040bk.p();
        boolean z = this.gc;
        float fE = C0634xm.e(oVVar.ku, oVVar.kv, f);
        int i3 = (i - 56) - 30;
        int i4 = i2 - 64;
        int i5 = i3 - 4;
        C0040bk.a(guiGraphics, i4 + 1, i5 - 1, 126, 1, iP);
        C0040bk.a(guiGraphics, i4, i5, 128, 28, iP);
        C0040bk.a(guiGraphics, i4 + 1, i5 + 28, 126, 1, iP);
        int i6 = i2 - 60;
        int i7 = i3 + 12;
        C0040bk.a(guiGraphics, i6 + 1, i7 - 1, 118, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, i6, i7, 120, 8, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, i6 + 1, i7 + 8, 118, 1, ColorReferences.COLOR_BLACK_SOLID);
        int i8 = i6 + 1;
        int i9 = (i7 + 1) - 1;
        float fBd = z ? 118.0f : ((fE * 118.0f) / oVVar.bd()) - 2.0f;
        C0040bk.a(guiGraphics, i8, i9, 118, 8, iP);
        C0040bk.a(guiGraphics, i6, i7, ((int) fBd) + 1, 8);
        C0040bk.a(poseStack, guiGraphics, resourceLocation, i8, i9, 118, 8);
        guiGraphics.disableScissor();
        C0040bk.a(poseStack, font, guiGraphics, component, i2, i3);
    }

    protected static float A(float f) {
        return C0634xm.i(f, 5.0f, 0.0f);
    }
}
