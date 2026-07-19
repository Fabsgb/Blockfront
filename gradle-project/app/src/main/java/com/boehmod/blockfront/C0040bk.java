package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0111eb;
import com.boehmod.blockfront.oY;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.AttackIndicatorStatus;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: renamed from: com.boehmod.blockfront.bk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk.class */
public final class C0040bk {
    private static final float cs = 0.003921569f;

    @Unique
    public static final int bB = 3;
    public static final float ct = 400.0f;
    public static final int bD = 16;
    public static final int bE = 8;
    private static final int bF = 1996488704;
    private static final int bG = 256;
    private static final int bH = 15616;
    private static final int bI = 61;
    private static final float cu = 0.3f;
    private static final int bJ = 32;
    public static final int bK = -125;
    private static final ResourceLocation z = ResourceLocation.withDefaultNamespace("hud/crosshair_attack_indicator_background");
    private static final ResourceLocation A = ResourceLocation.withDefaultNamespace("hud/crosshair_attack_indicator_progress");
    public static final int bC = ChatFormatting.RED.getColor().intValue();

    @NotNull
    public static final ResourceLocation B = C0265jv.d("textures/gui/emitter/ember.png");

    @NotNull
    public static final ResourceLocation C = C0265jv.d("textures/skins/debug.png");

    @NotNull
    public static final ResourceLocation D = C0265jv.d("textures/misc/ranks/bg.png");

    @NotNull
    private static final ResourceLocation E = C0265jv.d("textures/gui/dead.png");

    @NotNull
    public static final ResourceLocation F = C0265jv.d("textures/gui/callingcard/default.png");

    @NotNull
    private static final ResourceLocation G = C0265jv.d("textures/gui/shadoweffect.png");

    @NotNull
    public static final bR a = new bR(Minecraft.getInstance().getGameProfile());

    @NotNull
    private static final Component w = Component.translatable("bf.message.party.leader").withStyle(ChatFormatting.AQUA);

    @NotNull
    private static final Vector3f c = new Vector3f(-0.5f, 1.0f, -0.7f).normalize();
    private static final Vector3f d = new Vector3f(-0.5f, 1.0f, 0.7f).normalize();

    @NotNull
    private static final ResourceLocation H = C0265jv.d("textures/gui/animated/running.png");

    @NotNull
    public static final Component x = Component.literal("[PL]").withStyle(ChatFormatting.AQUA);

    @NotNull
    public static final Component y = Component.literal("[P]").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: z, reason: collision with other field name */
    private static final Component f63z = Component.translatable("bf.message.username");

    @NotNull
    private static final ResourceLocation I = C0265jv.d("textures/gui/gamemode/corner.png");
    private static int bL = 0;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$b.class */
    public enum b {
        NONE,
        TOP,
        BOTTOM
    }

    public static int p() {
        return bF;
    }

    public static void onUpdate() {
        if (bL > 0) {
            bL--;
        }
    }

    public static float g() {
        return Util.getMillis() / 20.0f;
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        a(poseStack, guiGraphics, I, i, i2, 8, 8, 0.25f);
        a(poseStack, guiGraphics, I, (i + i3) - 8, i2, 8, 8, 90.0f, 0.25f);
        a(poseStack, guiGraphics, I, i, (i2 + i4) - 8, 8, 8, -90.0f, 0.25f);
        a(poseStack, guiGraphics, I, (i + i3) - 8, (i2 + i4) - 8, 8, 8, 180.0f, 0.25f);
        a(guiGraphics, i + 8, i2, i3 - 16, 1, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        a(guiGraphics, i + 8, (i2 + i4) - 1, i3 - 16, 1, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        a(guiGraphics, i, i2 + 8, 1, i4 - 16, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        a(guiGraphics, (i + i3) - 1, i2 + 8, 1, i4 - 16, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        a(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, component, 0, 0, i, false);
        poseStack.popPose();
    }

    public static void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        a(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    public static void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        guiGraphics.drawString(font, component, i, i2, i3, false);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i) {
        int i2 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), f2, f3 + i2, ColorReferences.COLOR_WHITE, false, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i2 += i;
        }
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, int i, int i2, int i3) {
        int i4 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), i, i2 + i4, ColorReferences.COLOR_WHITE, false, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i4 += i3;
        }
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, boolean z2) {
        float f4 = 0.0f;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), f2 - (font.width(r0) / 2.0f), f3 + f4, ColorReferences.COLOR_WHITE, z2, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            f4 += i;
        }
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, int i, int i2, int i3, boolean z2) {
        int i4 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), i - (font.width(r0) / 2.0f), i2 + i4, ColorReferences.COLOR_WHITE, z2, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i4 += i3;
        }
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, float f4) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 0.1f);
        a(poseStack, font, multiBufferSource, list, 0, 0, (int) (i / f4));
        poseStack.popPose();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, float f4, boolean z2) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 0.1f);
        a(poseStack, font, multiBufferSource, list, 0, 0, (int) (i / f4), z2);
        poseStack.popPose();
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        b(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    public static void b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        b(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, component, 0, 0, i);
        poseStack.popPose();
    }

    public static void b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        guiGraphics.drawString(font, component, i, i2, i3);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        c(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    public static void c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        c(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        a(poseStack, font, guiGraphics, component, f2 - (font.width(component) / 2.0f), f3, i);
    }

    public static void c(Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        a(font, guiGraphics, component, i - (font.width(component) / 2), i2, i3);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        a(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        a(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    public static void a(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        a(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    public static void b(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        b(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        c(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        c(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        c(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        d(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    public static void c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        d(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    @Deprecated
    public static void d(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        a(poseStack, font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        a(poseStack, font, guiGraphics, component, 0.0f, 0.0f, i, i2);
        poseStack.popPose();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2) {
        int iWidth = font.width(component) / 2;
        a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3 + 1.0f, i2);
        a(poseStack, font, guiGraphics, component, f2 - iWidth, f3 + 1.0f, i2);
        a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3 + 1.0f, i2);
        a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3, i2);
        a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3, i2);
        a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3 - 1.0f, i2);
        a(poseStack, font, guiGraphics, component, f2 - iWidth, f3 - 1.0f, i2);
        a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3 - 1.0f, i2);
        a(poseStack, font, guiGraphics, component, f2 - iWidth, f3, i);
    }

    @Deprecated
    public static void d(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        d(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        a(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void d(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        b(poseStack, font, guiGraphics, component, f2 - (font.width(component) / 2.0f), f3, i);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        b(poseStack, font, guiGraphics, component, i - (font.width(component) / 2.0f), i2, i3);
    }

    public static void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        a(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    public static void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        guiGraphics.drawString(font, formattedCharSequence, i, i2, i3, false);
    }

    public static void b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        b(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    public static void b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        guiGraphics.drawString(font, formattedCharSequence, i, i2, i3, true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, formattedCharSequence, 0, 0, i, true);
        poseStack.popPose();
    }

    public static void c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        c(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    public static void c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        a(font, guiGraphics, formattedCharSequence, i - (font.width(formattedCharSequence) / 2), i2, i3);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3) {
        b(poseStack, font, guiGraphics, formattedCharSequence, f2, f3, ColorReferences.COLOR_WHITE);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i) {
        a(poseStack, font, guiGraphics, formattedCharSequence, f2 - (font.width(formattedCharSequence) / 2.0f), f3, i);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        c(font, guiGraphics, formattedCharSequence, 0, 0);
        poseStack.popPose();
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        b(poseStack, font, guiGraphics, formattedCharSequence, 0.0f, 0.0f, i);
        poseStack.popPose();
    }

    public static void a(@NotNull PoseStack poseStack, float f2, float f3, float f4, float f5, int i, int i2) {
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (f2 < f6) {
            f2 = f6;
            f6 = f2;
        }
        if (f3 < f7) {
            f3 = f7;
            f7 = f3;
        }
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        float fRed = FastColor.ARGB32.red(i) * cs;
        float fGreen = FastColor.ARGB32.green(i) * cs;
        float fBlue = FastColor.ARGB32.blue(i) * cs;
        float fAlpha = FastColor.ARGB32.alpha(i) * cs;
        switch (i2) {
            case 0:
            default:
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                break;
            case 1:
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                break;
            case 2:
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                break;
            case 3:
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f7, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f6, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
                break;
        }
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.disableBlend();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fill(0, 0, 1, 1, i);
        poseStack.popPose();
    }

    public static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fill(i, i2, i + i3, i2 + i4, i5);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fill(0, 0, 1, 1, C0634xm.a(i, f6));
        poseStack.popPose();
    }

    public static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fill(i, i2, i + i3, i2 + i4, C0634xm.a(i5, f2));
    }

    public static void b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        a(guiGraphics, i + 1, i2, i3 - 2, 1, i5);
        a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5);
        a(guiGraphics, i + 1, (i2 + i4) - 1, i3 - 2, 1, i5);
    }

    public static void b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        a(guiGraphics, i + 1, i2, i3 - 2, 1, i5, f2);
        a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5, f2);
        a(guiGraphics, i + 1, (i2 + i4) - 1, i3 - 2, 1, i5, f2);
    }

    public static void a(@NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, int i) {
        float f7 = f4 - f2;
        float f8 = f5 - f3;
        float fSqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8));
        if (fSqrt < 0.001f) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(f2, f3, 0.0f);
        poseStackPose.mulPose(Axis.ZP.rotation((float) Math.atan2(f8, f7)));
        a(poseStackPose, guiGraphics, 0.0f, (-f6) / 2.0f, fSqrt, f6, i);
        poseStackPose.popPose();
    }

    public static void a(@NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, int i, float f7) {
        a(guiGraphics, f2, f3, f4, f5, f6, C0634xm.a(i, f7));
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fillGradient(0, 0, 1, 1, i, i2);
        poseStack.popPose();
    }

    public static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fillGradient(i, i2, i + i3, i2 + i4, i5, i6);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        a(poseStack, guiGraphics, 1.0f, 1.0f, i, i2);
        poseStack.popPose();
    }

    @Deprecated
    private static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, int i, int i2) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        VertexConsumer buffer = guiGraphics.bufferSource().getBuffer(RenderType.gui());
        float fRed = FastColor.ARGB32.red(i) * cs;
        float fGreen = FastColor.ARGB32.green(i) * cs;
        float fBlue = FastColor.ARGB32.blue(i) * cs;
        float fAlpha = FastColor.ARGB32.alpha(i) * cs;
        float fRed2 = FastColor.ARGB32.red(i2) * cs;
        float fGreen2 = FastColor.ARGB32.green(i2) * cs;
        float fBlue2 = FastColor.ARGB32.blue(i2) * cs;
        float fAlpha2 = FastColor.ARGB32.alpha(i2) * cs;
        buffer.addVertex(matrix4fPose, 0.0f, 0.0f, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
        buffer.addVertex(matrix4fPose, 0.0f, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
        buffer.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed2, fGreen2, fBlue2, fAlpha2);
        buffer.addVertex(matrix4fPose, f2, 0.0f, 0.0f).setColor(fRed2, fGreen2, fBlue2, fAlpha2);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2, float f6, float f7) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        a(poseStack, guiGraphics, f2, f3, f4, f5, C0634xm.a(i, Mth.clamp(f6, 0.0f, 1.0f)), C0634xm.a(i2, Mth.clamp(f7, 0.0f, 1.0f)));
    }

    public static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6, float f2, float f3) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        a(guiGraphics, i, i2, i3, i4, C0634xm.a(i5, Mth.clamp(f2, 0.0f, 1.0f)), C0634xm.a(i6, Mth.clamp(f3, 0.0f, 1.0f)));
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4) {
        a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f4);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3) {
        a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i3);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5) {
        a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, 1.0f);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, 1.0f);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, f6);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2) {
        a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, f2);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3) {
        a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, f2, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, f6, f7, i);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, int i5) {
        a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, f2, f3, i5);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4) {
        b(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f4);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3) {
        b(poseStack, guiGraphics, resourceLocation, i, i2, i3, i3);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5) {
        a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, 1.0f);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2) {
        a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4, f2, 1.0f);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3) {
        a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2.0f), i2 - (i4 / 2.0f), i3, i4, f2, f3);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7, i);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, int i5) {
        a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4, f2, f3, i5);
    }

    public static void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        c(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    public static void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        c(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (f6 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f6, f6, 1.0f);
        b(poseStack, guiGraphics, resourceLocation, 0.0f, 0.0f, f4, f5, 0.0f, f7, i);
        poseStack.popPose();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        RenderSystem.enableBlend();
        a(i, f8);
        poseStack.pushPose();
        if (f6 != 0.0f || f7 != 0.0f) {
            float f9 = f2 + (f4 / 2.0f);
            float f10 = f3 + (f5 / 2.0f);
            poseStack.translate(f9, f10, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(f6));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f7));
            poseStack.translate(-f9, -f10, 0.0f);
        }
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.blit(resourceLocation, 0, 0, 0.0f, 0.0f, 1, 1, 1, 1);
        poseStack.popPose();
        RenderSystem.disableBlend();
        y();
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, float f4, int i5) {
        if (f4 <= 0.0f || i3 <= 0 || i4 <= 0) {
            return;
        }
        RenderSystem.enableBlend();
        a(i5, f4);
        poseStack.pushPose();
        if (f2 != 0.0f || f3 != 0.0f) {
            poseStack.translate(i + (i3 / 2), i2 + (i4 / 2), 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(f2));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f3));
            poseStack.translate(-r0, -r0, 0.0f);
        }
        guiGraphics.blit(resourceLocation, i, i2, 0.0f, 0.0f, i3, i4, i3, i4);
        poseStack.popPose();
        RenderSystem.disableBlend();
        y();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5) {
        a(poseStack, i, f2, f3, f4, f5, 0.0f, 1.0f);
    }

    public static void a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5) {
        a(poseStack, i, i2, i3, i4, i5, 0.0f, 1.0f);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        a(poseStack, i, f2, f3, f4, f5, 0.0f, f6);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        a(poseStack, i, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, int i2, int i3, int i4, int i5, float f3) {
        a(poseStack, i, f2, i2, i3, i4, i5, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        a(poseStack, i, f2, f3, f4, f5, f6, 0.0f, f7, i2);
    }

    public static void a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5, float f2, float f3, int i6) {
        a(poseStack, i, i2, i3, i4, i5, f2, 0.0f, f3, i6);
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4) {
        b(poseStack, i, f2, f3, f4, f4);
    }

    public static void a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4) {
        b(poseStack, i, i2, i3, i4, i4);
    }

    public static void a(@NotNull PoseStack poseStack, int i, int i2, int i3, float f2) {
        b(poseStack, i, i2, i3, f2, f2);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5) {
        a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5);
    }

    public static void b(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5) {
        a(poseStack, i, i2 - (i4 / 2), i3 - (i5 / 2), i4, i5);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, 1.0f);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7);
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7, i2);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        c(poseStack, i, f2, f3, f4, f5, f6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        c(poseStack, i, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        poseStack.pushPose();
        poseStack.translate(f2 - (f2 * f6), f3 - (f3 * f6), 0.0f);
        poseStack.scale(f6, f6, f6);
        b(poseStack, i, f2, f3, f4, f5, 0.0f, f7, i2);
        poseStack.popPose();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        a(i2, f8);
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture(0, i);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        poseStack.pushPose();
        if (f7 != 0.0f || f6 != 0.0f) {
            float f9 = f2 + (f4 / 2.0f);
            float f10 = f3 + (f5 / 2.0f);
            poseStack.translate(f9, f10, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(f7));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f6));
            poseStack.translate(-f9, -f10, 0.0f);
        }
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3 + f5, 0.0f).setUv(0.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3 + f5, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2 + f4, f3, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, f2, f3, 0.0f).setUv(0.0f, 1.0f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        poseStack.popPose();
        y();
        RenderSystem.disableBlend();
    }

    public static void a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5, float f2, float f3, float f4, int i6) {
        a(i6, f4);
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture(0, i);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        poseStack.pushPose();
        if (f3 != 0.0f || f2 != 0.0f) {
            poseStack.translate(i2 + (i4 / 2), i3 + (i5 / 2), 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(f3));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f2));
            poseStack.translate(-r0, -r0, 0.0f);
        }
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilderBegin.addVertex(matrix4fPose, i2, i3 + i5, 0.0f).setUv(0.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, i2 + i4, i3 + i5, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, i2 + i4, i3, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, i2, i3, 0.0f).setUv(0.0f, 1.0f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        poseStack.popPose();
        y();
        RenderSystem.disableBlend();
    }

    public static boolean b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return d6 >= d2 && d7 >= d3 && d6 <= d2 + d4 && d7 <= d3 + d5;
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i) {
        a(camera, poseStack, vec3, vec32, f2, i, 1.0f);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i, float f3) {
        a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f2, i, f3);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, float f3) {
        RenderSystem.disableDepthTest();
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = d7 - d4;
        double dSqrt = Math.sqrt((d8 * d8) + (d9 * d9) + (d10 * d10));
        double d11 = d8 / dSqrt;
        double d12 = d9 / dSqrt;
        double d13 = d10 / dSqrt;
        Vec3 position = camera.getPosition();
        double d14 = position.x - d2;
        double d15 = position.y - d3;
        double d16 = position.z - d4;
        double d17 = (d12 * d16) - (d13 * d15);
        double d18 = (d13 * d14) - (d11 * d16);
        double d19 = (d11 * d15) - (d12 * d14);
        double dSqrt2 = (((double) f2) * 0.01d) / Math.sqrt(((d17 * d17) + (d18 * d18)) + (d19 * d19));
        double d20 = d17 * dSqrt2;
        double d21 = d18 * dSqrt2;
        double d22 = d19 * dSqrt2;
        float fRed = FastColor.ARGB32.red(i) * cs;
        float fGreen = FastColor.ARGB32.green(i) * cs;
        float fBlue = FastColor.ARGB32.blue(i) * cs;
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        float f4 = (float) d2;
        float f5 = (float) d3;
        float f6 = (float) d4;
        float f7 = (float) d5;
        float f8 = (float) d6;
        float f9 = (float) d7;
        float f10 = (float) d20;
        float f11 = (float) d21;
        float f12 = (float) d22;
        bufferBuilderBegin.addVertex(matrix4fPose, f4 + f10, f5 + f11, f6 + f12).setColor(fRed, fGreen, fBlue, f3);
        bufferBuilderBegin.addVertex(matrix4fPose, f7 + f10, f8 + f11, f9 + f12).setColor(fRed, fGreen, fBlue, f3);
        bufferBuilderBegin.addVertex(matrix4fPose, f7 - f10, f8 - f11, f9 - f12).setColor(fRed, fGreen, fBlue, f3);
        bufferBuilderBegin.addVertex(matrix4fPose, f4 - f10, f5 - f11, f6 - f12).setColor(fRed, fGreen, fBlue, f3);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull oY oYVar, double d2, double d3, @NotNull d dVar) {
        if (oYVar.bu()) {
            return;
        }
        a aVar = new a(camera, oYVar, d2, d3, dVar);
        aVar.z();
        aVar.a(poseStack);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i, int i2) {
        a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f2, i, i2, 1.0f);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i, int i2, float f3) {
        a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f2, i, i2, f3);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, int i2, float f3) {
        a(camera, poseStack, d2, d3, d4, d5, d6, d7, f2, i, i2, f3, f3);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, int i2, float f3, float f4) {
        RenderSystem.disableDepthTest();
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = d7 - d4;
        double dSqrt = Math.sqrt((d8 * d8) + (d9 * d9) + (d10 * d10));
        double d11 = d8 / dSqrt;
        double d12 = d9 / dSqrt;
        double d13 = d10 / dSqrt;
        Vec3 position = camera.getPosition();
        double d14 = position.x - d2;
        double d15 = position.y - d3;
        double d16 = position.z - d4;
        double d17 = (d12 * d16) - (d13 * d15);
        double d18 = (d13 * d14) - (d11 * d16);
        double d19 = (d11 * d15) - (d12 * d14);
        double dSqrt2 = (((double) f2) * 0.01d) / Math.sqrt(((d17 * d17) + (d18 * d18)) + (d19 * d19));
        double d20 = d17 * dSqrt2;
        double d21 = d18 * dSqrt2;
        double d22 = d19 * dSqrt2;
        float fRed = FastColor.ARGB32.red(i) * cs;
        float fGreen = FastColor.ARGB32.green(i) * cs;
        float fBlue = FastColor.ARGB32.blue(i) * cs;
        float fRed2 = FastColor.ARGB32.red(i2) * cs;
        float fGreen2 = FastColor.ARGB32.green(i2) * cs;
        float fBlue2 = FastColor.ARGB32.blue(i2) * cs;
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        float f5 = (float) d2;
        float f6 = (float) d3;
        float f7 = (float) d4;
        float f8 = (float) d5;
        float f9 = (float) d6;
        float f10 = (float) d7;
        float f11 = (float) d20;
        float f12 = (float) d21;
        float f13 = (float) d22;
        bufferBuilderBegin.addVertex(matrix4fPose, f5 + f11, f6 + f12, f7 + f13).setColor(fRed, fGreen, fBlue, f3);
        bufferBuilderBegin.addVertex(matrix4fPose, f8 + f11, f9 + f12, f10 + f13).setColor(fRed2, fGreen2, fBlue2, f4);
        bufferBuilderBegin.addVertex(matrix4fPose, f8 - f11, f9 - f12, f10 - f13).setColor(fRed2, fGreen2, fBlue2, f4);
        bufferBuilderBegin.addVertex(matrix4fPose, f5 - f11, f6 - f12, f7 - f13).setColor(fRed, fGreen, fBlue, f3);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
    }

    public static void a(@NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, int i, float f2) {
        float fRed = FastColor.ARGB32.red(i) * cs;
        float fGreen = FastColor.ARGB32.green(i) * cs;
        float fBlue = FastColor.ARGB32.blue(i) * cs;
        RenderSystem.disableDepthTest();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bufferBuilderBegin.addVertex(matrix4fPose, (float) d2, (float) d3, (float) d4).setColor(fRed, fGreen, fBlue, f2);
        bufferBuilderBegin.addVertex(matrix4fPose, (float) d5, (float) d6, (float) d7).setColor(fRed, fGreen, fBlue, f2);
        bufferBuilderBegin.addVertex(matrix4fPose, (float) d8, (float) d9, (float) d10).setColor(fRed, fGreen, fBlue, f2);
        bufferBuilderBegin.addVertex(matrix4fPose, (float) d11, (float) d12, (float) d13).setColor(fRed, fGreen, fBlue, f2);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull AABB aabb, @NotNull d dVar) {
        c cVar = new c(camera, aabb, dVar);
        cVar.z();
        cVar.a(poseStack);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$d.class */
    public static final class d {
        private int bM = ColorReferences.COLOR_WHITE;
        private float cv = 0.0f;
        private int bN = ColorReferences.COLOR_WHITE;
        private float cw = 1.0f;
        private float cx = 1.5f;
        private double J = 0.0d;
        private b a = b.NONE;
        private double K = 0.0d;
        private boolean am = false;

        @Nullable
        private Vec3 h = null;
        private double L = 8.0d;
        private float cy = 1.0f;
        private boolean an = true;
        private boolean ao = true;
        private boolean ap = true;
        private float cz = 1.0f;

        private d() {
        }

        @NotNull
        public static d a() {
            return new d();
        }

        @NotNull
        public d a(int i, float f) {
            this.bM = i;
            this.cv = f;
            return this;
        }

        @NotNull
        public d a(int i, float f, float f2) {
            this.bN = i;
            this.cw = f;
            this.cx = f2;
            return this;
        }

        @NotNull
        public d b() {
            this.cw = 0.0f;
            return this;
        }

        @NotNull
        public d a(double d) {
            this.J = d;
            return this;
        }

        @NotNull
        public d a(@NotNull b bVar) {
            return a(bVar, 0.0d);
        }

        @NotNull
        public d a(@NotNull b bVar, double d) {
            this.a = bVar;
            this.K = d;
            return this;
        }

        @NotNull
        public d a(@Nullable Vec3 vec3, double d) {
            this.am = true;
            this.h = vec3;
            this.L = d;
            return this;
        }

        @NotNull
        public d a(float f) {
            this.cy = f;
            return this;
        }

        @NotNull
        public d a(boolean z, boolean z2, boolean z3) {
            this.an = z;
            this.ao = z2;
            this.ap = z3;
            return this;
        }

        @NotNull
        public d b(float f) {
            this.cz = f;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$e */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$e.class */
    private static abstract class e {
        private static final double M = 0.01d;
        private static final double N = 0.002d;
        static final double O = 1.0E-4d;
        private static final int bO = 7;
        final d b;
        final double P;
        final double Q;
        final double R;
        final double S;
        final double T;
        final double U;
        final double V;
        final boolean aq;
        final boolean ar;
        private final double W;
        private final double X;
        private final FloatArrayList a = new FloatArrayList();

        abstract void z();

        e(@NotNull Camera camera, @NotNull d dVar, double d, double d2) {
            this.b = dVar;
            this.W = d;
            this.X = d2;
            Vec3 position = camera.getPosition();
            this.P = position.x;
            this.Q = position.y;
            this.R = position.z;
            Vec3 vec3 = dVar.h != null ? dVar.h : position;
            this.S = vec3.x;
            this.T = vec3.y;
            this.U = vec3.z;
            this.V = dVar.J > 0.0d ? dVar.J : 1.0d;
            this.aq = dVar.cy < 1.0f;
            this.ar = dVar.am;
        }

        void a(@NotNull PoseStack poseStack) {
            if (this.a.isEmpty()) {
                return;
            }
            float fClamp = Mth.clamp(this.b.cy, 0.0f, 1.0f);
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.depthMask(false);
            Matrix4f matrix4fPose = poseStack.last().pose();
            if (fClamp >= 1.0f) {
                RenderSystem.disableDepthTest();
                a(matrix4fPose, 1.0f);
            } else {
                RenderSystem.enableDepthTest();
                a(matrix4fPose, 1.0f);
                if (fClamp > 0.0f) {
                    RenderSystem.depthFunc(516);
                    a(matrix4fPose, fClamp);
                    RenderSystem.depthFunc(515);
                }
            }
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
        }

        private void a(@NotNull Matrix4f matrix4f, float f) {
            BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
            float[] fArrElements = this.a.elements();
            int size = this.a.size();
            for (int i = 0; i < size; i += bO) {
                bufferBuilderBegin.addVertex(matrix4f, fArrElements[i], fArrElements[i + 1], fArrElements[i + 2]).setColor(fArrElements[i + 3], fArrElements[i + 4], fArrElements[i + 5], fArrElements[i + 6] * f);
            }
            BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        }

        void c(double d, double d2, double d3, double d4, double d5, double d6) {
            d dVar = this.b;
            float f = dVar.cw * dVar.cz;
            if (!this.ar) {
                a(d, d2, d3, d4, d5, d6, f);
                return;
            }
            double d7 = d4 - d;
            double d8 = d5 - d2;
            double d9 = d6 - d3;
            int iMax = Math.max(1, (int) Math.ceil(Math.sqrt(((d7 * d7) + (d8 * d8)) + (d9 * d9)) / this.V));
            for (int i = 0; i < iMax; i++) {
                double d10 = ((double) i) / ((double) iMax);
                double d11 = ((double) (i + 1)) / ((double) iMax);
                a(d + (d7 * d10), d2 + (d8 * d10), d3 + (d9 * d10), d + (d7 * d11), d2 + (d8 * d11), d3 + (d9 * d11), f);
            }
        }

        private void a(double d, double d2, double d3, double d4, double d5, double d6, float f) {
            float fA = f * a(d, d2, d3);
            float fA2 = f * a(d4, d5, d6);
            if (fA > 0.0f || fA2 > 0.0f) {
                double d7 = d4 - d;
                double d8 = d5 - d2;
                double d9 = d6 - d3;
                double dSqrt = Math.sqrt((d7 * d7) + (d8 * d8) + (d9 * d9));
                if (dSqrt < 1.0E-7d) {
                    return;
                }
                double d10 = d7 / dSqrt;
                double d11 = d8 / dSqrt;
                double d12 = d9 / dSqrt;
                double d13 = this.P - d;
                double d14 = this.Q - d2;
                double d15 = this.R - d3;
                double d16 = (d11 * d15) - (d12 * d14);
                double d17 = (d12 * d13) - (d10 * d15);
                double d18 = (d10 * d14) - (d11 * d13);
                double dSqrt2 = Math.sqrt((d16 * d16) + (d17 * d17) + (d18 * d18));
                if (dSqrt2 < 1.0E-7d) {
                    return;
                }
                double d19 = (((double) this.b.cx) * 0.01d) / dSqrt2;
                double d20 = d16 * d19;
                double d21 = d17 * d19;
                double d22 = d18 * d19;
                float fRed = FastColor.ARGB32.red(this.b.bN) * C0040bk.cs;
                float fGreen = FastColor.ARGB32.green(this.b.bN) * C0040bk.cs;
                float fBlue = FastColor.ARGB32.blue(this.b.bN) * C0040bk.cs;
                a(d + d20, d2 + d21, d3 + d22, fRed, fGreen, fBlue, fA);
                a(d4 + d20, d5 + d21, d6 + d22, fRed, fGreen, fBlue, fA2);
                a(d4 - d20, d5 - d21, d6 - d22, fRed, fGreen, fBlue, fA2);
                a(d - d20, d2 - d21, d3 - d22, fRed, fGreen, fBlue, fA);
            }
        }

        float a(double d, double d2, double d3) {
            float fClamp = 1.0f;
            switch (this.b.a.ordinal()) {
                case 1:
                    fClamp = (float) Mth.clamp((this.X - d2) / l(), 0.0d, 1.0d);
                    break;
                case 2:
                    fClamp = (float) Mth.clamp((d2 - this.W) / l(), 0.0d, 1.0d);
                    break;
            }
            if (this.ar && fClamp > 0.0f) {
                double d4 = d - this.S;
                double d5 = d2 - this.T;
                double d6 = d3 - this.U;
                fClamp *= (float) Mth.clamp(1.0d - (Math.sqrt(((d4 * d4) + (d5 * d5)) + (d6 * d6)) / this.b.L), 0.0d, 1.0d);
            }
            return fClamp;
        }

        private double l() {
            double dMax = Math.max(O, this.X - this.W);
            double d = this.b.K;
            return d > 0.0d ? Math.min(d, dMax) : dMax;
        }

        double a(double d) {
            return (Math.floor((d / this.V) + 1.0E-7d) * this.V) + this.V;
        }

        void a(double d, double d2, double d3, float f, float f2, float f3, float f4) {
            if (this.aq) {
                d += (this.P - d) * N;
                d2 += (this.Q - d2) * N;
                d3 += (this.R - d3) * N;
            }
            this.a.add((float) d);
            this.a.add((float) d2);
            this.a.add((float) d3);
            this.a.add(f);
            this.a.add(f2);
            this.a.add(f3);
            this.a.add(f4);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$c.class */
    private static final class c extends e {
        private final AABB b;

        c(@NotNull Camera camera, @NotNull AABB aabb, @NotNull d dVar) {
            super(camera, dVar, aabb.minY, aabb.maxY);
            this.b = aabb;
        }

        @Override // com.boehmod.blockfront.C0040bk.e
        void z() {
            d dVar = this.b;
            AABB aabb = this.b;
            if (dVar.cv * dVar.cz > 0.0f) {
                if (dVar.an) {
                    a(0, aabb.minX, aabb.minY, aabb.maxY, aabb.minZ, aabb.maxZ);
                    a(0, aabb.maxX, aabb.minY, aabb.maxY, aabb.minZ, aabb.maxZ);
                    a(2, aabb.minZ, aabb.minX, aabb.maxX, aabb.minY, aabb.maxY);
                    a(2, aabb.maxZ, aabb.minX, aabb.maxX, aabb.minY, aabb.maxY);
                }
                if (dVar.ap) {
                    a(1, aabb.minY, aabb.minX, aabb.maxX, aabb.minZ, aabb.maxZ);
                }
                if (dVar.ao) {
                    a(1, aabb.maxY, aabb.minX, aabb.maxX, aabb.minZ, aabb.maxZ);
                }
            }
            if (dVar.cw * dVar.cz > 0.0f) {
                A();
                if (dVar.J > 0.0d) {
                    C();
                }
            }
        }

        private void a(int i, double d, double d2, double d3, double d4, double d5) {
            d dVar = this.b;
            float fRed = FastColor.ARGB32.red(dVar.bM) * C0040bk.cs;
            float fGreen = FastColor.ARGB32.green(dVar.bM) * C0040bk.cs;
            float fBlue = FastColor.ARGB32.blue(dVar.bM) * C0040bk.cs;
            float f = dVar.cv * dVar.cz;
            if (!this.ar) {
                a(i, d, d2, d3, d4, d5, fRed, fGreen, fBlue, f);
                return;
            }
            double d6 = d2;
            while (true) {
                double d7 = d6;
                if (d7 < d3) {
                    double dMin = Math.min(d3, a(d7));
                    double d8 = d4;
                    while (true) {
                        double d9 = d8;
                        if (d9 < d5) {
                            double dMin2 = Math.min(d5, a(d9));
                            if (m233a(i, d, d7, dMin, d9, dMin2)) {
                                a(i, d, d7, dMin, d9, dMin2, fRed, fGreen, fBlue, f);
                            }
                            d8 = dMin2;
                        }
                    }
                    d6 = dMin;
                } else {
                    return;
                }
            }
        }

        private void a(int i, double d, double d2, double d3, double d4, double d5, float f, float f2, float f3, float f4) {
            a(i, d, d2, d4, f, f2, f3, f4);
            a(i, d, d3, d4, f, f2, f3, f4);
            a(i, d, d3, d5, f, f2, f3, f4);
            a(i, d, d2, d5, f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        private boolean m233a(int i, double d, double d2, double d3, double d4, double d5) {
            double dM234a = m234a(a(i));
            double dM234a2 = m234a(b(i));
            double dClamp = dM234a - Mth.clamp(dM234a, d2, d3);
            double dClamp2 = dM234a2 - Mth.clamp(dM234a2, d4, d5);
            double dM234a3 = m234a(i) - d;
            double d6 = this.b.L;
            return ((dClamp * dClamp) + (dClamp2 * dClamp2)) + (dM234a3 * dM234a3) < d6 * d6;
        }

        private void a(int i, double d, double d2, double d3, float f, float f2, float f3, float f4) {
            double d4 = i == 0 ? d : d2;
            double d5 = i == 0 ? d2 : i == 1 ? d : d3;
            double d6 = i == 2 ? d : d3;
            a(d4, d5, d6, f, f2, f3, f4 * a(d4, d5, d6));
        }

        private void A() {
            AABB aabb = this.b;
            c(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ);
            c(aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
            c(aabb.maxX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ);
            c(aabb.minX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.minZ);
            c(aabb.minX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ);
            c(aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            c(aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ);
            c(aabb.minX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.minZ);
            c(aabb.minX, aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ);
            c(aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ);
            c(aabb.maxX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            c(aabb.minX, aabb.minY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ);
        }

        private void C() {
            d dVar = this.b;
            AABB aabb = this.b;
            if (dVar.an) {
                double dA = a(aabb.minZ);
                while (true) {
                    double d = dA;
                    if (d >= aabb.maxZ - 1.0E-4d) {
                        break;
                    }
                    c(aabb.minX, aabb.minY, d, aabb.minX, aabb.maxY, d);
                    c(aabb.maxX, aabb.minY, d, aabb.maxX, aabb.maxY, d);
                    dA = a(d);
                }
                double dA2 = a(aabb.minX);
                while (true) {
                    double d2 = dA2;
                    if (d2 >= aabb.maxX - 1.0E-4d) {
                        break;
                    }
                    c(d2, aabb.minY, aabb.minZ, d2, aabb.maxY, aabb.minZ);
                    c(d2, aabb.minY, aabb.maxZ, d2, aabb.maxY, aabb.maxZ);
                    dA2 = a(d2);
                }
                double dA3 = a(aabb.minY);
                while (true) {
                    double d3 = dA3;
                    if (d3 >= aabb.maxY - 1.0E-4d) {
                        break;
                    }
                    c(aabb.minX, d3, aabb.minZ, aabb.maxX, d3, aabb.minZ);
                    c(aabb.maxX, d3, aabb.minZ, aabb.maxX, d3, aabb.maxZ);
                    c(aabb.maxX, d3, aabb.maxZ, aabb.minX, d3, aabb.maxZ);
                    c(aabb.minX, d3, aabb.maxZ, aabb.minX, d3, aabb.minZ);
                    dA3 = a(d3);
                }
            }
            if (dVar.ao || dVar.ap) {
                double dA4 = a(aabb.minX);
                while (true) {
                    double d4 = dA4;
                    if (d4 >= aabb.maxX - 1.0E-4d) {
                        break;
                    }
                    if (dVar.ap) {
                        c(d4, aabb.minY, aabb.minZ, d4, aabb.minY, aabb.maxZ);
                    }
                    if (dVar.ao) {
                        c(d4, aabb.maxY, aabb.minZ, d4, aabb.maxY, aabb.maxZ);
                    }
                    dA4 = a(d4);
                }
                double dA5 = a(aabb.minZ);
                while (true) {
                    double d5 = dA5;
                    if (d5 < aabb.maxZ - 1.0E-4d) {
                        if (dVar.ap) {
                            c(aabb.minX, aabb.minY, d5, aabb.maxX, aabb.minY, d5);
                        }
                        if (dVar.ao) {
                            c(aabb.minX, aabb.maxY, d5, aabb.maxX, aabb.maxY, d5);
                        }
                        dA5 = a(d5);
                    } else {
                        return;
                    }
                }
            }
        }

        private static int a(int i) {
            return i == 0 ? 1 : 0;
        }

        private static int b(int i) {
            return i == 2 ? 1 : 2;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        private double m234a(int i) {
            return i == 0 ? this.S : i == 1 ? this.T : this.U;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$a.class */
    private static final class a extends e {
        private final oY b;
        private final double H;
        private final double I;

        a(@NotNull Camera camera, @NotNull oY oYVar, double d, double d2, @NotNull d dVar) {
            super(camera, dVar, d, d2);
            this.b = oYVar;
            this.H = d;
            this.I = d2;
        }

        @Override // com.boehmod.blockfront.C0040bk.e
        void z() {
            d dVar = this.b;
            if (dVar.cv * dVar.cz > 0.0f) {
                ObjectListIterator it = this.b.f().iterator();
                while (it.hasNext()) {
                    a((oY.a) it.next());
                }
            }
            if (dVar.cw * dVar.cz > 0.0f) {
                A();
                if (dVar.J > 0.0d) {
                    B();
                }
            }
        }

        private void a(@NotNull oY.a aVar) {
            Vec2 vec2C = aVar.c();
            Vec2 vec2D = aVar.d();
            double d = vec2D.x - vec2C.x;
            double d2 = vec2D.y - vec2C.y;
            double dSqrt = Math.sqrt((d * d) + (d2 * d2));
            if (dSqrt < 1.0E-4d) {
                return;
            }
            d dVar = this.b;
            float fRed = FastColor.ARGB32.red(dVar.bM) * C0040bk.cs;
            float fGreen = FastColor.ARGB32.green(dVar.bM) * C0040bk.cs;
            float fBlue = FastColor.ARGB32.blue(dVar.bM) * C0040bk.cs;
            float f = dVar.cv * dVar.cz;
            double d3 = d / dSqrt;
            double d4 = d2 / dSqrt;
            if (!this.ar) {
                a(vec2C.x, vec2C.y, d3, d4, 0.0d, dSqrt, this.H, this.I, fRed, fGreen, fBlue, f);
                return;
            }
            double d5 = 0.0d;
            while (true) {
                double d6 = d5;
                if (d6 < dSqrt) {
                    double dMin = Math.min(dSqrt, d6 + this.V);
                    double d7 = this.H;
                    while (true) {
                        double d8 = d7;
                        if (d8 < this.I) {
                            double dMin2 = Math.min(this.I, d8 + this.V);
                            if (a(vec2C.x, vec2C.y, d3, d4, d6, dMin, d8, dMin2)) {
                                a(vec2C.x, vec2C.y, d3, d4, d6, dMin, d8, dMin2, fRed, fGreen, fBlue, f);
                            }
                            d7 = dMin2;
                        }
                    }
                    d5 = dMin;
                } else {
                    return;
                }
            }
        }

        private void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, float f, float f2, float f3, float f4) {
            double d9 = d + (d3 * d5);
            double d10 = d2 + (d4 * d5);
            double d11 = d + (d3 * d6);
            double d12 = d2 + (d4 * d6);
            a(d9, d7, d10, f, f2, f3, f4 * a(d9, d7, d10));
            a(d11, d7, d12, f, f2, f3, f4 * a(d11, d7, d12));
            a(d11, d8, d12, f, f2, f3, f4 * a(d11, d8, d12));
            a(d9, d8, d10, f, f2, f3, f4 * a(d9, d8, d10));
        }

        private boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double dClamp = Mth.clamp(((this.S - d) * d3) + ((this.U - d2) * d4), d5, d6);
            double d9 = this.S - (d + (d3 * dClamp));
            double d10 = this.U - (d2 + (d4 * dClamp));
            double dClamp2 = this.T - Mth.clamp(this.T, d7, d8);
            double d11 = this.b.L;
            return ((d9 * d9) + (dClamp2 * dClamp2)) + (d10 * d10) < d11 * d11;
        }

        private void A() {
            ObjectListIterator it = this.b.f().iterator();
            while (it.hasNext()) {
                oY.a aVar = (oY.a) it.next();
                Vec2 vec2C = aVar.c();
                Vec2 vec2D = aVar.d();
                c(vec2C.x, this.H, vec2C.y, vec2D.x, this.H, vec2D.y);
                c(vec2C.x, this.I, vec2C.y, vec2D.x, this.I, vec2D.y);
                c(vec2C.x, this.H, vec2C.y, vec2C.x, this.I, vec2C.y);
            }
        }

        private void B() {
            ObjectList<oY.a> objectListF = this.b.f();
            double dA = a(this.H);
            while (true) {
                double d = dA;
                if (d >= this.I - 1.0E-4d) {
                    break;
                }
                ObjectListIterator it = objectListF.iterator();
                while (it.hasNext()) {
                    oY.a aVar = (oY.a) it.next();
                    Vec2 vec2C = aVar.c();
                    Vec2 vec2D = aVar.d();
                    c(vec2C.x, d, vec2C.y, vec2D.x, d, vec2D.y);
                }
                dA = a(d);
            }
            ObjectListIterator it2 = objectListF.iterator();
            while (it2.hasNext()) {
                oY.a aVar2 = (oY.a) it2.next();
                Vec2 vec2C2 = aVar2.c();
                Vec2 vec2D2 = aVar2.d();
                double d2 = vec2D2.x - vec2C2.x;
                double d3 = vec2D2.y - vec2C2.y;
                double dSqrt = Math.sqrt((d2 * d2) + (d3 * d3));
                if (dSqrt >= 1.0E-4d) {
                    double d4 = d2 / dSqrt;
                    double d5 = d3 / dSqrt;
                    double d6 = this.V;
                    while (true) {
                        double d7 = d6;
                        if (d7 < dSqrt - 1.0E-4d) {
                            double d8 = ((double) vec2C2.x) + (d4 * d7);
                            double d9 = ((double) vec2C2.y) + (d5 * d7);
                            c(d8, this.H, d9, d8, this.I, d9);
                            d6 = d7 + this.V;
                        }
                    }
                }
            }
        }
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Vec3[] vec3Arr, float f2, float f3, float f4, float f5) {
        if (vec3Arr.length != 4) {
            throw new IllegalArgumentException("Must provide 4 corners for a face");
        }
        RenderSystem.setShader(GameRenderer::getRendertypeLinesShader);
        RenderSystem.depthMask(true);
        RenderSystem.disableCull();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION_COLOR);
        for (int i = 0; i < 4; i++) {
            Vec3 vec3 = vec3Arr[i];
            bufferBuilderBegin.addVertex(matrix4fPose, (float) vec3.x, (float) vec3.y, (float) vec3.z).setColor(f2, f3, f4, f5);
        }
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GameProfile gameProfile, float f2, float f3, int i) {
        ResourceLocation resourceLocationA = a(minecraft, c0297l, gameProfile);
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.blit(resourceLocationA, 0, 0, i, i, 8.0f, 8.0f, 8, 8, 64, 64);
        guiGraphics.blit(resourceLocationA, 0, 0, i, i, 40.0f, 8.0f, 8, 8, 64, 64);
        poseStack.popPose();
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, int i, int i2, float f4) {
        RenderSystem.enableBlend();
        m230a(i2);
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.blit(H, 0, 0, i, i, 0.0f, (int) ((((long) f4) % 61) * 256.0f), 256, 256, 256, bH);
        poseStack.popPose();
        RenderSystem.disableBlend();
        y();
    }

    public static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f2) {
        RenderSystem.enableBlend();
        m230a(i4);
        guiGraphics.blit(H, i, i2, i3, i3, 0.0f, (int) ((((long) f2) % 61) * 256.0f), 256, 256, 256, bH);
        y();
        RenderSystem.disableBlend();
    }

    @Deprecated
    public static void d(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = 0.25f;
        float f9 = 0.25f / f7;
        b(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5);
        for (int i = 0; i < f7; i++) {
            float f10 = f8 - f9;
            b(poseStack, guiGraphics, resourceLocation, f2 + (f6 * i), f3, f4, f5, 0.0f, f10);
            b(poseStack, guiGraphics, resourceLocation, f2 - (f6 * i), f3, f4, f5, 0.0f, f10 - f9);
            f8 = 0.25f;
        }
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(-(f4 / 2.0f), -(f5 / 2.0f), 0.0f);
        a(poseStack, guiGraphics, f2 - 1.0f, f3 - 1.0f, f4 + 2.0f, f5 + 2.0f, i, 0.3f);
        a(poseStack, guiGraphics, f2, f3, f4, f5, i, f6);
        poseStack.popPose();
    }

    @Deprecated
    public static void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i) {
        c(poseStack, guiGraphics, f2, f3, f4, f5, i, FastColor.ARGB32.alpha(i) * cs);
    }

    public static void c(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        c(guiGraphics, i, i2, i3, i4, i5, FastColor.ARGB32.alpha(i5) * cs);
    }

    @Deprecated
    public static void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        a(poseStack, guiGraphics, f2 - 1.0f, f3 - 1.0f, f4 + 2.0f, f5 + 2.0f, 0, 0.3f);
        a(poseStack, guiGraphics, f2, f3, f4, f5, i, f6);
    }

    public static void c(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        a(guiGraphics, i - 1, i2 - 1, i3 + 2, i4 + 2, 0, 0.3f);
        a(guiGraphics, i, i2, i3, i4, i5, f2);
    }

    public static void a(@NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, int i, int i2, float f2, float f3, float f4, float f5) {
        a(fVVar, poseStack, guiGraphics, minecraft, livingEntity, i, i2, f2, f3, f4, f5, 1.0f);
    }

    public static void a(@NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fT fTVarB = livingEntity instanceof Player ? (fT) fVVar.a((Player) livingEntity) : fVVar.b(livingEntity.getUUID());
        boolean zDk = fTVarB.dk();
        int iAg = fTVarB.ag();
        boolean zIsInvisible = livingEntity.isInvisible();
        float f9 = livingEntity.yBodyRotO;
        float f10 = livingEntity.yBodyRot;
        float f11 = livingEntity.yHeadRotO;
        float f12 = livingEntity.yHeadRot;
        float f13 = livingEntity.xRotO;
        fTVarB.X(false);
        fTVarB.m(0);
        livingEntity.setInvisible(false);
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        if (entityRenderDispatcher.camera == null) {
            entityRenderDispatcher.camera = new Camera();
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3 + (livingEntity.isShiftKeyDown() ? -11.0f : 0.0f), 50.0f);
        poseStack.scale(f4, f4, -f4);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
        float f14 = -f6;
        livingEntity.yBodyRot = f14;
        livingEntity.yBodyRotO = f14;
        float f15 = (-f6) + (-f7);
        livingEntity.yHeadRot = f15;
        livingEntity.yHeadRotO = f15;
        livingEntity.xRotO = f5;
        livingEntity.setXRot(f5);
        Lighting.setupForEntityInInventory();
        entityRenderDispatcher.render(livingEntity, 0.0d, 0.0d, 0.0d, 1.0f, f8, poseStack, bufferSource, 15728880);
        minecraft.gameRenderer.lightTexture().turnOffLightLayer();
        bufferSource.endBatch();
        poseStack.popPose();
        livingEntity.yBodyRotO = f9;
        livingEntity.yBodyRot = f10;
        livingEntity.yHeadRotO = f11;
        livingEntity.yHeadRot = f12;
        livingEntity.xRotO = f13;
        livingEntity.setXRot(f13);
        fTVarB.X(zDk);
        fTVarB.m(iAg);
        livingEntity.setInvisible(zIsInvisible);
    }

    public static void a(@NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, Font font, @NotNull UUID uuid, @NotNull C0111eb.b bVar, int i, int i2, int i3, boolean z2) {
        C0111eb.a slotInfo = bVar.getSlotInfo();
        int iMo377a = slotInfo.mo377a(fVVar, uuid, z2);
        Component componentA = slotInfo.a(fVVar, uuid, z2);
        Component componentA2 = slotInfo.a(fVVar, uuid);
        a(guiGraphics, i + 2, i2 + 1, 1, i3 - 2, iMo377a);
        a(font, guiGraphics, componentA2, i + 5, i2 + 2);
        a(font, guiGraphics, componentA, i + 5, (i2 + i3) - 9, iMo377a);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2) {
        int iP = p();
        float f4 = i / 2.0f;
        float f5 = f2 - f4;
        a(poseStack, f5 - 5.0f, f3, 5.0f, i2, iP, 2);
        a(poseStack, f2 + f4, f3, 5.0f, i2, iP, 4);
        a(poseStack, guiGraphics, f5, f3, i, i2, iP);
        c(poseStack, font, guiGraphics, component, f2, f3 + 1.5f);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, iS iSVar, @NotNull iS iSVar2, float f2, float f3, boolean z2) {
        CloudRegistry cloudRegistryA = c0297l.a();
        Optional<MatchParty> party = iSVar.getParty();
        int prestigeLevel = iSVar2.getPrestigeLevel();
        UUID uuid = iSVar2.getUUID();
        iN inventory = iSVar2.getInventory();
        boolean zBooleanValue = ((Boolean) party.map(matchParty -> {
            return Boolean.valueOf(matchParty.isHost(uuid));
        }).orElse(false)).booleanValue();
        MutableComponent mutableComponentAppend = iL.a(iSVar2).append(Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)).append(iSVar2.b());
        if (iSVar2.a() == PlayerDataType.DISPLAY) {
            mutableComponentAppend.withStyle(ChatFormatting.GRAY);
        }
        if (z2) {
            mutableComponentAppend.withStyle(ChatFormatting.YELLOW);
        }
        int iWidth = font.width(mutableComponentAppend);
        b(poseStack, font, guiGraphics, (Component) mutableComponentAppend, f2, f3, iWidth, 10);
        CloudItemStack cloudItemStackA = inventory.a(CloudItemType.COIN);
        if (cloudItemStackA != null) {
            CloudItem<?> cloudItem = cloudItemStackA.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA, poseStack, minecraft, guiGraphics, (f2 - (iWidth / 2.0f)) - 5.0f, f3, 9.0f, 9.0f, 1.0f);
            }
        }
        if (zBooleanValue) {
            b(poseStack, font, guiGraphics, (Component) w.copy(), f2, f3 + 12.0f, 0.5f);
        }
        if (iSVar2.a() != PlayerDataType.DISPLAY) {
            float f4 = f2 - 8.0f;
            float f5 = (f3 - 16.0f) - 5.0f;
            ResourceLocation resourceLocationD = C0265jv.d("textures/misc/ranks/" + iSVar2.getRank().getTexture() + ".png");
            a(poseStack, guiGraphics, C0080cx.aJ, f4 - 7.0f, f5 - 7.0f, 31.0f, 31.0f);
            a(poseStack, guiGraphics, C0080cx.aP, f4, f5, 16.0f, 16.0f);
            a(poseStack, guiGraphics, resourceLocationD, f4, f5, 16.0f, 16.0f);
        }
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @Nullable UUID uuid, @NotNull Style style, @NotNull Collection<String> collection, float f2, float f3, float f4, float f5, int i) {
        sV sVVarA;
        CloudItem<?> cloudItem;
        CloudRegistry cloudRegistryA = c0297l.a();
        Optional<MatchParty> party = iSVar.getParty();
        iS iSVarA = null;
        iN inventory = null;
        fT fTVarB = null;
        if (uuid != null) {
            iSVarA = fVVar.mo306a(uuid);
            inventory = iSVarA.getInventory();
            fTVarB = fVVar.b(uuid);
            if (uuid.equals(iSVar.getUUID())) {
                style = Style.EMPTY;
            }
        }
        float size = f4 - (collection.size() * 30);
        int i2 = (int) f2;
        int i3 = (int) f3;
        int i4 = (int) size;
        int i5 = (int) f5;
        a(guiGraphics, i2, i3, i4, i5, 0, 0.5f);
        if (uuid != null) {
            ResourceLocation resourceLocationD = F;
            CloudItemStack cloudItemStackA = inventory.a(CloudItemType.CARD);
            if (cloudItemStackA != null && (cloudItem = cloudItemStackA.getCloudItem(cloudRegistryA)) != null) {
                resourceLocationD = C0265jv.d("textures/gui/callingcard/" + cloudItem.getSuffixForDisplay() + ".png");
            }
            a(guiGraphics, i2 + 1, i3 + 1, i4 - 2, i5 - 2);
            a(poseStack, guiGraphics, resourceLocationD, i2, i3 - 25.0f, 220.0f, 50.0f, 0.0f, 0.1f);
            guiGraphics.disableScissor();
            int i6 = 0;
            MutableComponent mutableComponentAppend = iL.a(iSVarA).append(iSVarA.b());
            party.ifPresent(matchParty -> {
                if (matchParty.isPresent(uuid)) {
                    mutableComponentAppend.append(" ").append(matchParty.isHost(uuid) ? x : y);
                }
            });
            PlayerRank rank = iSVarA.getRank();
            oO oOVarA = oFVar.b().a(uuid);
            int color = oOVarA != null ? oOVarA.getColor() : ColorReferences.COLOR_WHITE;
            ResourceLocation resourceLocationD2 = C0265jv.d("textures/misc/ranks/" + rank.getTexture() + ".png");
            float f6 = f2 + 14.5f;
            float f7 = f3 + i + 0.5f;
            a(poseStack, guiGraphics, D, f6, f7, 7.0f, 7.0f, 0.0f, 1.0f, color);
            a(poseStack, guiGraphics, resourceLocationD2, f6, f7, 7.0f, 7.0f);
            int prestigeLevel = iSVarA.getPrestigeLevel();
            if (prestigeLevel > 0) {
                a(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(prestigeLevel)), f6 + 3.5f, f3 + 7.0f, ColorReferences.COLOR_WHITE, 0, 0.5f);
            }
            CloudItemStack cloudItemStackA2 = inventory.a(CloudItemType.COIN);
            if (cloudItemStackA2 != null) {
                CloudItem<?> cloudItem2 = cloudItemStackA2.getCloudItem(cloudRegistryA);
                if (cloudItem2 instanceof AbstractCloudItemCoin) {
                    AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem2;
                    C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA2, minecraft, poseStack, guiGraphics, f2 + 24.0f + 4.0f, f3 + i + 0.1f + 4.0f, 8.0f, 8.0f, 1.0f);
                }
                i6 = 0 + 10;
            }
            int iA = oFVar.a(uuid).a(C0529tp.i.getKey(), -1);
            if (iA != -1 && (sVVarA = sV.a(iA)) != null) {
                int iA2 = oFVar.a(uuid).a(C0529tp.j.getKey(), 0);
                float f8 = (f2 + size) - f5;
                a(poseStack, guiGraphics, sVVarA.getIcon(), f8, f3, f5);
                MutableComponent mutableComponentWithColor = Component.translatable(sVVarA.al()).withStyle(ChatFormatting.BOLD).withColor(sVVarA.bU() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
                if (iA2 > 0) {
                    mutableComponentWithColor = mutableComponentWithColor.append(" ").append(Component.translatable("enchantment.level." + (iA2 + 1)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID));
                }
                a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, (f8 - (font.width(mutableComponentWithColor) / 2.0f)) - 1.0f, f3 + 3.0f, 0.5f);
            }
            float f9 = f2 + 3.0f;
            float f10 = f3 + i + 0.1f;
            oI oIVarB = oFVar.b();
            oO oOVarA2 = oIVarB.a(iSVar.getUUID());
            boolean z2 = (fTVarB.dk() || fTVarB.q() != null) && !oIVarB.g(uuid);
            boolean z3 = oOVarA2 != null && oOVarA2.equals(oOVarA);
            if (z2 && oFVar.mo754a().shouldShow(z3)) {
                a(poseStack, guiGraphics, E, f9, f10, 8.0f, 8.0f);
            } else {
                a(minecraft, c0297l, poseStack, guiGraphics, iSVarA.m491a(), f9, f10, 8);
                oGVar.a(poseStack, guiGraphics, fTVarB, f9, f10, 8);
            }
            a(poseStack, font, guiGraphics, (Component) mutableComponentAppend, f2 + 25.0f + i6, f3 + i + 0.5f);
        } else {
            a(poseStack, font, guiGraphics, (Component) f63z.copy().withStyle(style), f2 + 2.0f, f3 + i);
        }
        float f11 = f2 + i4;
        int i7 = 0;
        for (String str : collection) {
            float f12 = f11 + (i7 * 30) + 1.0f;
            MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(style);
            a(poseStack, guiGraphics, f12, f3, 29.0f, f5, i7 % 2 == 0 ? 1118481 : 0, 0.5f);
            c(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, f12 + 15.0f, f3 + i);
            i7++;
        }
    }

    @Deprecated
    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f2, float f3) {
        a(poseStack, guiGraphics, itemStack, f2, f3, 1.0f);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f2, float f3, float f4) {
        RenderSystem.setupGuiFlatDiffuseLighting(c, d);
        poseStack.pushPose();
        poseStack.translate(f2 - (8.0f * f4), f3 - (8.0f * f4), 0.0f);
        poseStack.scale(f4, f4, f4);
        guiGraphics.renderItem(itemStack, 0, 0, 0, bK);
        poseStack.popPose();
    }

    public static String a(int i) {
        int i2 = i % 60;
        return (i / 60) + ":" + (i2 < 10 ? "0" : "") + i2;
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i) {
        a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, boolean z2) {
        a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i, 1.0f, ColorReferences.COLOR_WHITE, z2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, int i, boolean z2) {
        a(poseStack, camera, guiGraphics, resourceLocation, vec3.x, vec3.y, vec3.z, i, i, 1.0f, ColorReferences.COLOR_WHITE, z2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull BlockPos blockPos, int i, boolean z2) {
        a(poseStack, camera, guiGraphics, resourceLocation, blockPos.getX(), blockPos.getY(), blockPos.getZ(), i, i, 1.0f, ColorReferences.COLOR_WHITE, z2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2) {
        a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, boolean z2) {
        a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, 1.0f, ColorReferences.COLOR_WHITE, z2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2) {
        a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, ColorReferences.COLOR_WHITE, true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, boolean z2) {
        a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, ColorReferences.COLOR_WHITE, z2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, int i, int i2, float f2, int i3, boolean z2) {
        a(poseStack, camera, guiGraphics, resourceLocation, vec3.x, vec3.y, vec3.z, i, i2, f2, i3, z2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z2) {
        RenderSystem.depthMask(false);
        if (z2) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        a(poseStack, guiGraphics, resourceLocation, (-i) / 2, (-i2) / 2, i, i2, 0.0f, f2, i3);
        poseStack.popPose();
        if (!z2) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z2, float f3) {
        float fClamp = Mth.clamp(f3, 0.0f, 1.0f);
        if (fClamp <= 0.0f || f2 <= 0.0f) {
            return;
        }
        int iMax = Math.max(1, Math.round(i * fClamp));
        RenderSystem.depthMask(false);
        if (z2) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        RenderSystem.enableBlend();
        a(i3, f2);
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        guiGraphics.blit(resourceLocation, (-i) / 2, (-i2) / 2, iMax, i2, 0.0f, 0.0f, iMax, i2, i, i2);
        poseStack.popPose();
        RenderSystem.disableBlend();
        y();
        if (!z2) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, int i, boolean z2) {
        RenderSystem.depthMask(false);
        if (z2) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        poseStack.scale(-0.02f, -0.02f, -0.02f);
        a(poseStack, guiGraphics, resourceLocation, (-f2) / 2.0f, (-f3) / 2.0f, f2, f3, 0.0f, f4, i);
        poseStack.popPose();
        if (!z2) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, float f5, float f6) {
        a(poseStack, guiGraphics, resourceLocation, d2, d3, d4, f2, f3, f4, ColorReferences.COLOR_WHITE, true, f5, f6);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, int i, boolean z2, float f5, float f6) {
        RenderSystem.depthMask(false);
        if (z2) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(f6));
        poseStack.mulPose(Axis.XP.rotationDegrees(f5));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        a(poseStack, guiGraphics, resourceLocation, (-f2) / 2.0f, (-f3) / 2.0f, f2, f3, 0.0f, f4, i);
        poseStack.popPose();
        if (!z2) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    public static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        guiGraphics.enableScissor(i, i2, i + i3, i2 + i4);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        a(poseStack, font, camera, guiGraphics, component, d2, d3, d4, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        b(poseStack, font, camera, guiGraphics, component, d2, d3, d4, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2) {
        a(poseStack, font, camera, guiGraphics, component, d2, d3, d4, f2, ColorReferences.COLOR_WHITE, true);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2) {
        b(poseStack, font, camera, guiGraphics, component, d2, d3, d4, f2, ColorReferences.COLOR_WHITE, true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2, int i, boolean z2) {
        RenderSystem.depthMask(false);
        if (z2) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(2.0f, 2.0f, 1.0f);
        poseStack.scale(-0.016f, -0.016f, 1.0f);
        poseStack.scale(f2, f2, 1.0f);
        a(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f, i);
        poseStack.popPose();
        if (!z2) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    public static void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2, int i, boolean z2) {
        RenderSystem.depthMask(false);
        if (z2) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(2.0f, 2.0f, 1.0f);
        poseStack.scale(-0.016f, -0.016f, 1.0f);
        poseStack.scale(f2, f2, 1.0f);
        b(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f, i);
        poseStack.popPose();
        if (!z2) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(2.0f, 2.0f, 1.0f);
        poseStack.translate(0.0f, 0.0f, -1.0f);
        poseStack.scale(-0.016f, -0.016f, 1.0f);
        a(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f);
        poseStack.popPose();
    }

    public static void k(@NotNull Minecraft minecraft) {
        b(minecraft, 1.0f);
    }

    public static void b(@NotNull Minecraft minecraft, float f2) {
        a(minecraft, f2, minecraft.options.getMenuBackgroundBlurriness());
    }

    public static void a(@NotNull Minecraft minecraft, float f2, int i) {
        Options options = minecraft.options;
        int menuBackgroundBlurriness = options.getMenuBackgroundBlurriness();
        OptionInstance optionInstanceMenuBackgroundBlurriness = options.menuBackgroundBlurriness();
        optionInstanceMenuBackgroundBlurriness.set(Integer.valueOf(i));
        options.getMenuBackgroundBlurriness();
        minecraft.gameRenderer.processBlurEffect(f2);
        minecraft.getMainRenderTarget().bindWrite(false);
        optionInstanceMenuBackgroundBlurriness.set(Integer.valueOf(menuBackgroundBlurriness));
    }

    @NotNull
    public static ResourceLocation a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GameProfile gameProfile) {
        return a(minecraft, c0297l, gameProfile.getId());
    }

    @NotNull
    public static ResourceLocation a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull UUID uuid) {
        return c0297l.m599a().a(minecraft, uuid);
    }

    public static void a(@NotNull Camera camera, @NotNull PoseStack poseStack) {
        Vec3 position = camera.getPosition();
        poseStack.translate(-position.x, -position.y, -position.z);
    }

    public static void a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, @NotNull PoseStack poseStack, double d2, double d3, double d4) {
        a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d2, d3, d4, 0.0f, 0.0f, 0.0f);
    }

    public static void a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, @NotNull PoseStack poseStack, double d2, double d3, double d4, float f2, float f3, float f4) {
        int lightColor = LevelRenderer.getLightColor(clientLevel, BlockPos.containing(d2, d3, d4).offset(0, 1, 0));
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.XP.rotationDegrees(f2));
        poseStack.mulPose(Axis.ZP.rotationDegrees(f4));
        poseStack.mulPose(Axis.YP.rotationDegrees(f3));
        blockRenderDispatcher.renderSingleBlock(blockState, poseStack, bufferSource, lightColor, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.cutout());
        bufferSource.endBatch();
        poseStack.popPose();
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull BlockEntity blockEntity, double d2, double d3, double d4, float f2, float f3, float f4) {
        BlockEntityRenderer renderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
        if (renderer == null) {
            return;
        }
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        AABB aabbMove = renderer.getRenderBoundingBox(blockEntity).move(d2, d3, d4);
        if (minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes()) {
            LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), aabbMove, 1.0f, 1.0f, 1.0f, 1.0f);
        }
        if (!renderer.shouldRenderOffScreen(blockEntity) && !minecraft.levelRenderer.getFrustum().isVisible(aabbMove)) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(f3 + 180.0f));
        poseStack.mulPose(Axis.XP.rotationDegrees(f2));
        renderer.render(blockEntity, f4, poseStack, bufferSource, LevelRenderer.getLightColor(clientLevel, BlockPos.containing(d2, d3, d4).offset(0, 1, 0)), OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull A a2, float f2, float f3, float f4, boolean z2, boolean z3, float f5) {
        Window window = Minecraft.getInstance().getWindow();
        double width = ((double) window.getWidth()) / ((double) guiGraphics.guiWidth());
        double height = ((double) window.getHeight()) / ((double) guiGraphics.guiHeight());
        if (z2) {
            a(poseStack, guiGraphics, a2.e(), f2, f3, f4, width, height);
        }
        if (z3) {
            a(poseStack, guiGraphics, a2.a(), f2, ((f3 - 8.0f) - f5) + 2.0f, f4, width, height);
            a(poseStack, guiGraphics, a2.b(), f2, ((f3 + 8.0f) + f5) - 2.0f, f4, width, height);
            a(poseStack, guiGraphics, a2.c(), ((f2 - 8.0f) - f5) + 2.0f, f3, f4, width, height);
            a(poseStack, guiGraphics, a2.d(), ((f2 + 8.0f) + f5) - 2.0f, f3, f4, width, height);
        }
    }

    private static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, double d2, double d3) {
        a(poseStack, guiGraphics, resourceLocation, (float) (Math.round(((double) (f2 - 8.0f)) * d2) / d2), (float) (Math.round(((double) (f3 - 8.0f)) * d3) / d3), 16.0f, 16.0f, 0.0f, f4);
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull LocalPlayer localPlayer, float f2, float f3) {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        if (minecraft.options.attackIndicator().get() == AttackIndicatorStatus.CROSSHAIR) {
            float attackStrengthScale = localPlayer.getAttackStrengthScale(0.0f);
            float f4 = (f3 - 7.0f) + 24.0f;
            float f5 = f2 - 8.0f;
            if (attackStrengthScale < 1.0f) {
                poseStack.translate(f5, f4, 0.0f);
                guiGraphics.blitSprite(z, 0, 0, 16, 4);
                guiGraphics.blitSprite(A, 16, 4, 0, 0, 0, 0, (int) (attackStrengthScale * 17.0f), 4);
                poseStack.translate(-f5, -f4, 0.0f);
            }
        }
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }

    public static void a(int i, float f2) {
        RenderSystem.setShaderColor(FastColor.ARGB32.red(i) * cs, FastColor.ARGB32.green(i) * cs, FastColor.ARGB32.blue(i) * cs, f2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m230a(int i) {
        RenderSystem.setShaderColor(FastColor.ARGB32.red(i) * cs, FastColor.ARGB32.green(i) * cs, FastColor.ARGB32.blue(i) * cs, 1.0f);
    }

    public static void y() {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public static void a(@NotNull C0416pk c0416pk, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f2) {
        if (clientLevel.clip(new ClipContext(localPlayer.getEyePosition(), c0416pk.c, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.MISS) {
            float fA = a(c0416pk, localPlayer);
            float f3 = f2 + ((float) (c0416pk.c.x + c0416pk.c.y + c0416pk.c.z));
            float fSin = Mth.sin(f3 / 15.0f);
            float fSin2 = fA * (1.5f + Mth.sin(f3 / 5.0f));
            if (fSin2 < 0.0f) {
                fSin2 = 0.0f;
            }
            a(poseStack, camera, guiGraphics, c0416pk.z(), c0416pk.c.x, c0416pk.c.y + ((double) (0.15f * fSin)), c0416pk.c.z, 32, 32, fSin2, ColorReferences.COLOR_WHITE_SOLID, true);
        }
    }

    private static float a(@NotNull C0416pk c0416pk, @NotNull LocalPlayer localPlayer) {
        float x2 = (float) (c0416pk.c.x - localPlayer.getX());
        float y2 = (float) (c0416pk.c.y - localPlayer.getY());
        float z2 = (float) (c0416pk.c.z - localPlayer.getZ());
        float fSqrt = Mth.sqrt((x2 * x2) + (y2 * y2) + (z2 * z2));
        float f2 = (fSqrt * 100.0f) / 8.0f;
        if (fSqrt > 8.0f) {
            f2 = 200.0f - f2;
        }
        return 0.01f * f2;
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, float f2) {
        int i3;
        int i4;
        int i5 = i / 2;
        int i6 = i2 / 2;
        float f3 = i / 1920.0f;
        float f4 = i2 / 1080.0f;
        if (1080.0f * f3 < i2) {
            i3 = (int) (1080.0f * f4);
            i4 = (int) (1920.0f * f4);
        } else {
            i3 = (int) (1080.0f * f3);
            i4 = (int) (1920.0f * f3);
        }
        a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        c(poseStack, guiGraphics, resourceLocation, i5, i6, i4, i3, 1.2f, 0.5f);
        a(poseStack, guiGraphics, G, 0, 0, i, i2);
        b(minecraft, f2);
        a(poseStack, guiGraphics, 5, 5, i - 10, i2 - 10);
    }

    public static int a(int i, int i2, double d2) {
        double dClamp = Math.clamp(d2, 0.0d, 1.0d);
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        int iRound = (int) Math.round(((double) i3) + (((double) (((i2 >> 16) & 255) - i3)) * dClamp));
        int iRound2 = (int) Math.round(((double) i4) + (((double) (((i2 >> 8) & 255) - i4)) * dClamp));
        return (iRound << 16) | (iRound2 << 8) | ((int) Math.round(((double) i5) + (((double) ((i2 & 255) - i5)) * dClamp)));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$f */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$f.class */
    public static final class f extends Record {
        private final float cA;
        private final float cB;
        private final boolean as;
        private final boolean at;
        private final float cC;
        private final double Y;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "screenX;screenY;isOnScreen;isBehindCamera;directionAngle;distance", "FIELD:Lcom/boehmod/blockfront/bk$f;->cA:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->cB:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->as:Z", "FIELD:Lcom/boehmod/blockfront/bk$f;->at:Z", "FIELD:Lcom/boehmod/blockfront/bk$f;->cC:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->Y:D").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "screenX;screenY;isOnScreen;isBehindCamera;directionAngle;distance", "FIELD:Lcom/boehmod/blockfront/bk$f;->cA:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->cB:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->as:Z", "FIELD:Lcom/boehmod/blockfront/bk$f;->at:Z", "FIELD:Lcom/boehmod/blockfront/bk$f;->cC:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->Y:D").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "screenX;screenY;isOnScreen;isBehindCamera;directionAngle;distance", "FIELD:Lcom/boehmod/blockfront/bk$f;->cA:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->cB:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->as:Z", "FIELD:Lcom/boehmod/blockfront/bk$f;->at:Z", "FIELD:Lcom/boehmod/blockfront/bk$f;->cC:F", "FIELD:Lcom/boehmod/blockfront/bk$f;->Y:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public float h() {
            return this.cA;
        }

        public float i() {
            return this.cB;
        }

        public boolean n() {
            return this.as;
        }

        public boolean o() {
            return this.at;
        }

        public float j() {
            return this.cC;
        }

        public double m() {
            return this.Y;
        }

        public f(float f, float f2, boolean z, boolean z2, float f3, double d) {
            this.cA = f;
            this.cB = f2;
            this.as = z;
            this.at = z2;
            this.cC = f3;
            this.Y = d;
        }
    }

    @NotNull
    public static f a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2) {
        float fClamp;
        float fClamp2;
        GameRenderer gameRenderer = Minecraft.getInstance().gameRenderer;
        Vec3 eyePosition = camera.getEntity().getEyePosition(f2);
        double d2 = vec3.x - eyePosition.x;
        double d3 = vec3.y - eyePosition.y;
        double d4 = vec3.z - eyePosition.z;
        double dSqrt = Math.sqrt((d2 * d2) + (d3 * d3) + (d4 * d4));
        Quaternionf quaternionfConjugate = camera.rotation().conjugate(new Quaternionf());
        Vector3f vector3f = new Vector3f((float) d2, (float) d3, (float) d4);
        quaternionfConjugate.transform(vector3f);
        boolean z2 = vector3f.z > 0.0f;
        float f3 = i * 0.5f;
        float f4 = i2 * 0.5f;
        boolean z3 = false;
        if (!z2 && Math.abs(vector3f.z) > 0.001f) {
            Matrix4f projectionMatrix = gameRenderer.getProjectionMatrix(gameRenderer.getFov(camera, f2, true));
            Vector4f vector4f = new Vector4f(vector3f.x, vector3f.y, vector3f.z, 1.0f);
            projectionMatrix.transform(vector4f);
            fClamp = ((vector4f.x / vector4f.w) + 1.0f) * 0.5f * i;
            fClamp2 = (1.0f - (vector4f.y / vector4f.w)) * 0.5f * i2;
            z3 = fClamp >= ((float) i3) && fClamp <= ((float) (i - i3)) && fClamp2 >= ((float) i3) && fClamp2 <= ((float) (i2 - i3));
        } else {
            fClamp = f3;
            fClamp2 = f4;
        }
        float f5 = vector3f.x;
        float f6 = -vector3f.y;
        float degrees = (float) Math.toDegrees(Math.atan2(f6, f5));
        if (!z3) {
            float f7 = i - i3;
            float f8 = i2 - i3;
            if (Math.abs(f5) > 0.001f || Math.abs(f6) > 0.001f) {
                float f9 = Float.MAX_VALUE;
                float f10 = Float.MAX_VALUE;
                float f11 = f3 - i3;
                float f12 = f4 - i3;
                if (f5 > 0.001f) {
                    f9 = f11 / f5;
                } else if (f5 < -0.001f) {
                    f9 = (-f11) / f5;
                }
                if (f6 > 0.001f) {
                    f10 = f12 / f6;
                } else if (f6 < -0.001f) {
                    f10 = (-f12) / f6;
                }
                float fMin = Math.min(f9, f10);
                fClamp = f3 + (f5 * fMin);
                fClamp2 = f4 + (f6 * fMin);
            }
            fClamp = Mth.clamp(fClamp, i3, f7);
            fClamp2 = Mth.clamp(fClamp2, i3, f8);
        }
        return new f(fClamp, fClamp2, z3, z2, degrees, dSqrt);
    }

    @NotNull
    public static f a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3) {
        return a(vec3, camera, i, i2, i3, Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true));
    }

    @NotNull
    public static f a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2) {
        return a(vec3, camera, i, i2, 20);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2) {
        a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i3, 1.0f, ColorReferences.COLOR_WHITE, 20, false, f2);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2, float f3) {
        a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i3, f2, ColorReferences.COLOR_WHITE, 20, false, f3);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, float f3) {
        a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i4, f2, i5, 20, false, f3);
    }

    public static void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, int i6, boolean z2, float f3) {
        f fVarA = a(vec3, camera, i, i2, i6, f3);
        float f4 = (fVarA.as || !z2) ? 0.0f : fVarA.cC + 90.0f;
        poseStack.pushPose();
        poseStack.translate(fVarA.cA, fVarA.cB, 0.0f);
        b(poseStack, guiGraphics, resourceLocation, 0, 0, i3, i4, f4, f2, i5);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static f m231a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, int i6, boolean z2, float f3) {
        f fVarA = a(vec3, camera, i, i2, i6, f3);
        b(poseStack, guiGraphics, resourceLocation, (int) fVarA.cA, (int) fVarA.cB, i3, i4, (fVarA.as || !z2) ? 0.0f : fVarA.cC + 90.0f, f2, i5);
        return fVarA;
    }

    public static void a(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, f2);
        guiGraphics.blit(resourceLocation, 0, 0, -90, 0.0f, 0.0f, guiGraphics.guiWidth(), guiGraphics.guiHeight(), guiGraphics.guiWidth(), guiGraphics.guiHeight());
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
