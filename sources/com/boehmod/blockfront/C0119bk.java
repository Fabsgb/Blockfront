package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0279eb;
import com.boehmod.blockfront.C0806oY;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk.class */
public final class C0119bk {

    /* JADX INFO: renamed from: cs */
    private static final float f722cs = 0.003921569f;

    /* JADX INFO: renamed from: bB */
    @Unique
    public static final int f725bB = 3;

    /* JADX INFO: renamed from: ct */
    public static final float f727ct = 400.0f;

    /* JADX INFO: renamed from: bD */
    public static final int f728bD = 16;

    /* JADX INFO: renamed from: bE */
    public static final int f729bE = 8;

    /* JADX INFO: renamed from: bF */
    private static final int f740bF = 1996488704;

    /* JADX INFO: renamed from: bG */
    private static final int f744bG = 256;

    /* JADX INFO: renamed from: bH */
    private static final int f745bH = 15616;

    /* JADX INFO: renamed from: bI */
    private static final int f746bI = 61;

    /* JADX INFO: renamed from: cu */
    private static final float f748cu = 0.3f;

    /* JADX INFO: renamed from: bJ */
    private static final int f750bJ = 32;

    /* JADX INFO: renamed from: bK */
    public static final int f751bK = -125;

    /* JADX INFO: renamed from: z */
    private static final ResourceLocation f723z = ResourceLocation.withDefaultNamespace("hud/crosshair_attack_indicator_background");

    /* JADX INFO: renamed from: A */
    private static final ResourceLocation f724A = ResourceLocation.withDefaultNamespace("hud/crosshair_attack_indicator_progress");

    /* JADX INFO: renamed from: bC */
    public static final int f726bC = ChatFormatting.RED.getColor().intValue();

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final ResourceLocation f730B = C0564jv.m2555d("textures/gui/emitter/ember.png");

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final ResourceLocation f731C = C0564jv.m2555d("textures/skins/debug.png");

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final ResourceLocation f732D = C0564jv.m2555d("textures/misc/ranks/bg.png");

    /* JADX INFO: renamed from: E */
    @NotNull
    private static final ResourceLocation f733E = C0564jv.m2555d("textures/gui/dead.png");

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final ResourceLocation f734F = C0564jv.m2555d("textures/gui/callingcard/default.png");

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final ResourceLocation f735G = C0564jv.m2555d("textures/gui/shadoweffect.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0100bR f736a = new C0100bR(Minecraft.getInstance().getGameProfile());

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final Component f737w = Component.translatable("bf.message.party.leader").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final Vector3f f738c = new Vector3f(-0.5f, 1.0f, -0.7f).normalize();

    /* JADX INFO: renamed from: d */
    private static final Vector3f f739d = new Vector3f(-0.5f, 1.0f, 0.7f).normalize();

    /* JADX INFO: renamed from: H */
    @NotNull
    private static final ResourceLocation f741H = C0564jv.m2555d("textures/gui/animated/running.png");

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final Component f742x = Component.literal("[PL]").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final Component f743y = Component.literal("[P]").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: z */
    private static final Component f747z = Component.translatable("bf.message.username");

    /* JADX INFO: renamed from: I */
    @NotNull
    private static final ResourceLocation f749I = C0564jv.m2555d("textures/gui/gamemode/corner.png");

    /* JADX INFO: renamed from: bL */
    private static int f752bL = 0;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$b.class */
    public enum b {
        NONE,
        TOP,
        BOTTOM
    }

    /* JADX INFO: renamed from: p */
    public static int m365p() {
        return f740bF;
    }

    public static void onUpdate() {
        if (f752bL > 0) {
            f752bL--;
        }
    }

    /* JADX INFO: renamed from: g */
    public static float m366g() {
        return Util.getMillis() / 20.0f;
    }

    /* JADX INFO: renamed from: a */
    public static void m367a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        m433a(poseStack, guiGraphics, f749I, i, i2, 8, 8, 0.25f);
        m435a(poseStack, guiGraphics, f749I, (i + i3) - 8, i2, 8, 8, 90.0f, 0.25f);
        m435a(poseStack, guiGraphics, f749I, i, (i2 + i4) - 8, 8, 8, -90.0f, 0.25f);
        m435a(poseStack, guiGraphics, f749I, (i + i3) - 8, (i2 + i4) - 8, 8, 8, 180.0f, 0.25f);
        m417a(guiGraphics, i + 8, i2, i3 - 16, 1, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        m417a(guiGraphics, i + 8, (i2 + i4) - 1, i3 - 16, 1, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        m417a(guiGraphics, i, i2 + 8, 1, i4 - 16, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        m417a(guiGraphics, (i + i3) - 1, i2 + 8, 1, i4 - 16, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m368a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m369a(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m369a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, component, 0, 0, i, false);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m370a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m371a(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m371a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        guiGraphics.drawString(font, component, i, i2, i3, false);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m372a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i) {
        int i2 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), f2, f3 + i2, ColorReferences.COLOR_WHITE, false, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i2 += i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m373a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, int i, int i2, int i3) {
        int i4 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), i, i2 + i4, ColorReferences.COLOR_WHITE, false, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i4 += i3;
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m374a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, boolean z) {
        float f4 = 0.0f;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), f2 - (font.width(r0) / 2.0f), f3 + f4, ColorReferences.COLOR_WHITE, z, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            f4 += i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m375a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, int i, int i2, int i3, boolean z) {
        int i4 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), i - (font.width(r0) / 2.0f), i2 + i4, ColorReferences.COLOR_WHITE, z, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i4 += i3;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m376a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, float f4) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 0.1f);
        m373a(poseStack, font, multiBufferSource, list, 0, 0, (int) (i / f4));
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m377a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, float f4, boolean z) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 0.1f);
        m375a(poseStack, font, multiBufferSource, list, 0, 0, (int) (i / f4), z);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m378b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m380b(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    public static void m379b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m381b(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m380b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, component, 0, 0, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    public static void m381b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        guiGraphics.drawString(font, component, i, i2, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m382c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m384c(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: c */
    public static void m383c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m385c(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m384c(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        m369a(poseStack, font, guiGraphics, component, f2 - (font.width(component) / 2.0f), f3, i);
    }

    /* JADX INFO: renamed from: c */
    public static void m385c(Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        m371a(font, guiGraphics, component, i - (font.width(component) / 2), i2, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m386a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        m388a(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m387a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        m388a(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m388a(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m371a(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    public static void m389b(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m381b(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m390b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        m392c(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    /* JADX INFO: renamed from: b */
    public static void m391b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        m392c(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m392c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m385c(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m393c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        m395d(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    /* JADX INFO: renamed from: c */
    public static void m394c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        m395d(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m395d(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m401a(poseStack, font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m396a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m397a(poseStack, font, guiGraphics, component, 0.0f, 0.0f, i, i2);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m397a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2) {
        int iWidth = font.width(component) / 2;
        m369a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3 + 1.0f, i2);
        m369a(poseStack, font, guiGraphics, component, f2 - iWidth, f3 + 1.0f, i2);
        m369a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3 + 1.0f, i2);
        m369a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3, i2);
        m369a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3, i2);
        m369a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3 - 1.0f, i2);
        m369a(poseStack, font, guiGraphics, component, f2 - iWidth, f3 - 1.0f, i2);
        m369a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3 - 1.0f, i2);
        m369a(poseStack, font, guiGraphics, component, f2 - iWidth, f3, i);
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m398d(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m400d(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m399a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m401a(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m400d(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        m380b(poseStack, font, guiGraphics, component, f2 - (font.width(component) / 2.0f), f3, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m401a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        m380b(poseStack, font, guiGraphics, component, i - (font.width(component) / 2.0f), i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m402a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        m403a(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m403a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        guiGraphics.drawString(font, formattedCharSequence, i, i2, i3, false);
    }

    /* JADX INFO: renamed from: b */
    public static void m404b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        m405b(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    public static void m405b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        guiGraphics.drawString(font, formattedCharSequence, i, i2, i3, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m406a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, formattedCharSequence, 0, 0, i, true);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: c */
    public static void m407c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        m408c(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: c */
    public static void m408c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        m403a(font, guiGraphics, formattedCharSequence, i - (font.width(formattedCharSequence) / 2), i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m409a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3) {
        m410b(poseStack, font, guiGraphics, formattedCharSequence, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    public static void m410b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i) {
        m406a(poseStack, font, guiGraphics, formattedCharSequence, f2 - (font.width(formattedCharSequence) / 2.0f), f3, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m411a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m407c(font, guiGraphics, formattedCharSequence, 0, 0);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m412a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m410b(poseStack, font, guiGraphics, formattedCharSequence, 0.0f, 0.0f, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m413a(@NotNull PoseStack poseStack, float f2, float f3, float f4, float f5, int i, int i2) {
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
        float fRed = FastColor.ARGB32.red(i) * f722cs;
        float fGreen = FastColor.ARGB32.green(i) * f722cs;
        float fBlue = FastColor.ARGB32.blue(i) * f722cs;
        float fAlpha = FastColor.ARGB32.alpha(i) * f722cs;
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
    /* JADX INFO: renamed from: a */
    public static void m414a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fill(0, 0, 1, 1, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m415a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fill(i, i2, i + i3, i2 + i4, i5);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m416a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fill(0, 0, 1, 1, C1290xm.m7833a(i, f6));
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m417a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fill(i, i2, i + i3, i2 + i4, C1290xm.m7833a(i5, f2));
    }

    /* JADX INFO: renamed from: b */
    public static void m418b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        m415a(guiGraphics, i + 1, i2, i3 - 2, 1, i5);
        m415a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5);
        m415a(guiGraphics, i + 1, (i2 + i4) - 1, i3 - 2, 1, i5);
    }

    /* JADX INFO: renamed from: b */
    public static void m419b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        m417a(guiGraphics, i + 1, i2, i3 - 2, 1, i5, f2);
        m417a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5, f2);
        m417a(guiGraphics, i + 1, (i2 + i4) - 1, i3 - 2, 1, i5, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m420a(@NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, int i) {
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
        m414a(poseStackPose, guiGraphics, 0.0f, (-f6) / 2.0f, fSqrt, f6, i);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m421a(@NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, int i, float f7) {
        m420a(guiGraphics, f2, f3, f4, f5, f6, C1290xm.m7833a(i, f7));
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m422a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fillGradient(0, 0, 1, 1, i, i2);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m423a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fillGradient(i, i2, i + i3, i2 + i4, i5, i6);
    }

    /* JADX INFO: renamed from: b */
    public static void m424b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        m425a(poseStack, guiGraphics, 1.0f, 1.0f, i, i2);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    private static void m425a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, int i, int i2) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        VertexConsumer buffer = guiGraphics.bufferSource().getBuffer(RenderType.gui());
        float fRed = FastColor.ARGB32.red(i) * f722cs;
        float fGreen = FastColor.ARGB32.green(i) * f722cs;
        float fBlue = FastColor.ARGB32.blue(i) * f722cs;
        float fAlpha = FastColor.ARGB32.alpha(i) * f722cs;
        float fRed2 = FastColor.ARGB32.red(i2) * f722cs;
        float fGreen2 = FastColor.ARGB32.green(i2) * f722cs;
        float fBlue2 = FastColor.ARGB32.blue(i2) * f722cs;
        float fAlpha2 = FastColor.ARGB32.alpha(i2) * f722cs;
        buffer.addVertex(matrix4fPose, 0.0f, 0.0f, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
        buffer.addVertex(matrix4fPose, 0.0f, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
        buffer.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed2, fGreen2, fBlue2, fAlpha2);
        buffer.addVertex(matrix4fPose, f2, 0.0f, 0.0f).setColor(fRed2, fGreen2, fBlue2, fAlpha2);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m426a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2, float f6, float f7) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        m422a(poseStack, guiGraphics, f2, f3, f4, f5, C1290xm.m7833a(i, Mth.clamp(f6, 0.0f, 1.0f)), C1290xm.m7833a(i2, Mth.clamp(f7, 0.0f, 1.0f)));
    }

    /* JADX INFO: renamed from: a */
    public static void m427a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6, float f2, float f3) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        m423a(guiGraphics, i, i2, i3, i4, C1290xm.m7833a(i5, Mth.clamp(f2, 0.0f, 1.0f)), C1290xm.m7833a(i6, Mth.clamp(f3, 0.0f, 1.0f)));
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m428a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4) {
        m430a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m429a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3) {
        m431a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m430a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5) {
        m434a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m431a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        m435a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m432a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        m434a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, f6);
    }

    /* JADX INFO: renamed from: a */
    public static void m433a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2) {
        m435a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m434a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        m436a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m435a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3) {
        m437a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, f2, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m436a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        m451a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, f6, f7, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m437a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, int i5) {
        m452a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, f2, f3, i5);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m438b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4) {
        m440b(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f4);
    }

    /* JADX INFO: renamed from: b */
    public static void m439b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3) {
        m441b(poseStack, guiGraphics, resourceLocation, i, i2, i3, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m440b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5) {
        m430a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5);
    }

    /* JADX INFO: renamed from: b */
    public static void m441b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        m431a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m442b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        m434a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public static void m443b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2) {
        m435a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4, f2, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m444b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        m434a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7);
    }

    /* JADX INFO: renamed from: b */
    public static void m445b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3) {
        m434a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2.0f), i2 - (i4 / 2.0f), i3, i4, f2, f3);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m446b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        m436a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7, i);
    }

    /* JADX INFO: renamed from: b */
    public static void m447b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, int i5) {
        m437a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4, f2, f3, i5);
    }

    /* JADX INFO: renamed from: c */
    public static void m448c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        m450c(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: c */
    public static void m449c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        m450c(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m450c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (f6 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f6, f6, 1.0f);
        m446b(poseStack, guiGraphics, resourceLocation, 0.0f, 0.0f, f4, f5, 0.0f, f7, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m451a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        RenderSystem.enableBlend();
        m537a(i, f8);
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
        m539y();
    }

    /* JADX INFO: renamed from: a */
    public static void m452a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, float f4, int i5) {
        if (f4 <= 0.0f || i3 <= 0 || i4 <= 0) {
            return;
        }
        RenderSystem.enableBlend();
        m537a(i5, f4);
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
        m539y();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m453a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5) {
        m456a(poseStack, i, f2, f3, f4, f5, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m454a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5) {
        m456a(poseStack, i, i2, i3, i4, i5, 0.0f, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m455a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        m456a(poseStack, i, f2, f3, f4, f5, 0.0f, f6);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m456a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        m458a(poseStack, i, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m457a(@NotNull PoseStack poseStack, int i, float f2, int i2, int i3, int i4, int i5, float f3) {
        m458a(poseStack, i, f2, i2, i3, i4, i5, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m458a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        m471a(poseStack, i, f2, f3, f4, f5, f6, 0.0f, f7, i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m459a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5, float f2, float f3, int i6) {
        m472a(poseStack, i, i2, i3, i4, i5, f2, 0.0f, f3, i6);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m460a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4) {
        m463b(poseStack, i, f2, f3, f4, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m461a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4) {
        m464b(poseStack, i, i2, i3, i4, i4);
    }

    /* JADX INFO: renamed from: a */
    public static void m462a(@NotNull PoseStack poseStack, int i, int i2, int i3, float f2) {
        m463b(poseStack, i, i2, i3, f2, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m463b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5) {
        m453a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5);
    }

    /* JADX INFO: renamed from: b */
    public static void m464b(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5) {
        m454a(poseStack, i, i2 - (i4 / 2), i3 - (i5 / 2), i4, i5);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m465b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        m456a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m466b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        m456a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m467b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        m458a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7, i2);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m468c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        m470c(poseStack, i, f2, f3, f4, f5, f6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m469c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        m470c(poseStack, i, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m470c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        poseStack.pushPose();
        poseStack.translate(f2 - (f2 * f6), f3 - (f3 * f6), 0.0f);
        poseStack.scale(f6, f6, f6);
        m467b(poseStack, i, f2, f3, f4, f5, 0.0f, f7, i2);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m471a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        m537a(i2, f8);
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
        m539y();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: a */
    public static void m472a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5, float f2, float f3, float f4, int i6) {
        m537a(i6, f4);
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
        m539y();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m473b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return d6 >= d2 && d7 >= d3 && d6 <= d2 + d4 && d7 <= d3 + d5;
    }

    /* JADX INFO: renamed from: a */
    public static void m474a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i) {
        m475a(camera, poseStack, vec3, vec32, f2, i, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m475a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i, float f3) {
        m476a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f2, i, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m476a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, float f3) {
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
        float fRed = FastColor.ARGB32.red(i) * f722cs;
        float fGreen = FastColor.ARGB32.green(i) * f722cs;
        float fBlue = FastColor.ARGB32.blue(i) * f722cs;
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

    /* JADX INFO: renamed from: a */
    public static void m477a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull C0806oY c0806oY, double d2, double d3, @NotNull d dVar) {
        if (c0806oY.m4171bu()) {
            return;
        }
        a aVar = new a(camera, c0806oY, d2, d3, dVar);
        aVar.mo555z();
        aVar.m581a(poseStack);
    }

    /* JADX INFO: renamed from: a */
    public static void m478a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i, int i2) {
        m480a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f2, i, i2, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m479a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f2, int i, int i2, float f3) {
        m480a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f2, i, i2, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m480a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, int i2, float f3) {
        m481a(camera, poseStack, d2, d3, d4, d5, d6, d7, f2, i, i2, f3, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m481a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, int i2, float f3, float f4) {
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
        float fRed = FastColor.ARGB32.red(i) * f722cs;
        float fGreen = FastColor.ARGB32.green(i) * f722cs;
        float fBlue = FastColor.ARGB32.blue(i) * f722cs;
        float fRed2 = FastColor.ARGB32.red(i2) * f722cs;
        float fGreen2 = FastColor.ARGB32.green(i2) * f722cs;
        float fBlue2 = FastColor.ARGB32.blue(i2) * f722cs;
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

    /* JADX INFO: renamed from: a */
    public static void m482a(@NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, int i, float f2) {
        float fRed = FastColor.ARGB32.red(i) * f722cs;
        float fGreen = FastColor.ARGB32.green(i) * f722cs;
        float fBlue = FastColor.ARGB32.blue(i) * f722cs;
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

    /* JADX INFO: renamed from: a */
    public static void m483a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull AABB aabb, @NotNull d dVar) {
        c cVar = new c(camera, aabb, dVar);
        cVar.mo555z();
        cVar.m581a(poseStack);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$d.class */
    public static final class d {

        /* JADX INFO: renamed from: bM */
        private int f757bM = ColorReferences.COLOR_WHITE;

        /* JADX INFO: renamed from: cv */
        private float f758cv = 0.0f;

        /* JADX INFO: renamed from: bN */
        private int f759bN = ColorReferences.COLOR_WHITE;

        /* JADX INFO: renamed from: cw */
        private float f760cw = 1.0f;

        /* JADX INFO: renamed from: cx */
        private float f761cx = 1.5f;

        /* JADX INFO: renamed from: J */
        private double f762J = 0.0d;

        /* JADX INFO: renamed from: a */
        private b f763a = b.NONE;

        /* JADX INFO: renamed from: K */
        private double f764K = 0.0d;

        /* JADX INFO: renamed from: am */
        private boolean f765am = false;

        /* JADX INFO: renamed from: h */
        @Nullable
        private Vec3 f766h = null;

        /* JADX INFO: renamed from: L */
        private double f767L = 8.0d;

        /* JADX INFO: renamed from: cy */
        private float f768cy = 1.0f;

        /* JADX INFO: renamed from: an */
        private boolean f769an = true;

        /* JADX INFO: renamed from: ao */
        private boolean f770ao = true;

        /* JADX INFO: renamed from: ap */
        private boolean f771ap = true;

        /* JADX INFO: renamed from: cz */
        private float f772cz = 1.0f;

        private d() {
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static d m570a() {
            return new d();
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m571a(int i, float f) {
            this.f757bM = i;
            this.f758cv = f;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m572a(int i, float f, float f2) {
            this.f759bN = i;
            this.f760cw = f;
            this.f761cx = f2;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public d m573b() {
            this.f760cw = 0.0f;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m574a(double d) {
            this.f762J = d;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m575a(@NotNull b bVar) {
            return m576a(bVar, 0.0d);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m576a(@NotNull b bVar, double d) {
            this.f763a = bVar;
            this.f764K = d;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m577a(@Nullable Vec3 vec3, double d) {
            this.f765am = true;
            this.f766h = vec3;
            this.f767L = d;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m578a(float f) {
            this.f768cy = f;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m579a(boolean z, boolean z2, boolean z3) {
            this.f769an = z;
            this.f770ao = z2;
            this.f771ap = z3;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public d m580b(float f) {
            this.f772cz = f;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$e */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$e.class */
    private static abstract class e {

        /* JADX INFO: renamed from: M */
        private static final double f773M = 0.01d;

        /* JADX INFO: renamed from: N */
        private static final double f774N = 0.002d;

        /* JADX INFO: renamed from: O */
        static final double f775O = 1.0E-4d;

        /* JADX INFO: renamed from: bO */
        private static final int f776bO = 7;

        /* JADX INFO: renamed from: b */
        final d f777b;

        /* JADX INFO: renamed from: P */
        final double f778P;

        /* JADX INFO: renamed from: Q */
        final double f779Q;

        /* JADX INFO: renamed from: R */
        final double f780R;

        /* JADX INFO: renamed from: S */
        final double f781S;

        /* JADX INFO: renamed from: T */
        final double f782T;

        /* JADX INFO: renamed from: U */
        final double f783U;

        /* JADX INFO: renamed from: V */
        final double f784V;

        /* JADX INFO: renamed from: aq */
        final boolean f785aq;

        /* JADX INFO: renamed from: ar */
        final boolean f786ar;

        /* JADX INFO: renamed from: W */
        private final double f787W;

        /* JADX INFO: renamed from: X */
        private final double f788X;

        /* JADX INFO: renamed from: a */
        private final FloatArrayList f789a = new FloatArrayList();

        /* JADX INFO: renamed from: z */
        abstract void mo555z();

        e(@NotNull Camera camera, @NotNull d dVar, double d, double d2) {
            this.f777b = dVar;
            this.f787W = d;
            this.f788X = d2;
            Vec3 position = camera.getPosition();
            this.f778P = position.x;
            this.f779Q = position.y;
            this.f780R = position.z;
            Vec3 vec3 = dVar.f766h != null ? dVar.f766h : position;
            this.f781S = vec3.x;
            this.f782T = vec3.y;
            this.f783U = vec3.z;
            this.f784V = dVar.f762J > 0.0d ? dVar.f762J : 1.0d;
            this.f785aq = dVar.f768cy < 1.0f;
            this.f786ar = dVar.f765am;
        }

        /* JADX INFO: renamed from: a */
        void m581a(@NotNull PoseStack poseStack) {
            if (this.f789a.isEmpty()) {
                return;
            }
            float fClamp = Mth.clamp(this.f777b.f768cy, 0.0f, 1.0f);
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.depthMask(false);
            Matrix4f matrix4fPose = poseStack.last().pose();
            if (fClamp >= 1.0f) {
                RenderSystem.disableDepthTest();
                m582a(matrix4fPose, 1.0f);
            } else {
                RenderSystem.enableDepthTest();
                m582a(matrix4fPose, 1.0f);
                if (fClamp > 0.0f) {
                    RenderSystem.depthFunc(516);
                    m582a(matrix4fPose, fClamp);
                    RenderSystem.depthFunc(515);
                }
            }
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
        }

        /* JADX INFO: renamed from: a */
        private void m582a(@NotNull Matrix4f matrix4f, float f) {
            BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
            float[] fArrElements = this.f789a.elements();
            int size = this.f789a.size();
            for (int i = 0; i < size; i += f776bO) {
                bufferBuilderBegin.addVertex(matrix4f, fArrElements[i], fArrElements[i + 1], fArrElements[i + 2]).setColor(fArrElements[i + 3], fArrElements[i + 4], fArrElements[i + 5], fArrElements[i + 6] * f);
            }
            BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        }

        /* JADX INFO: renamed from: c */
        void m583c(double d, double d2, double d3, double d4, double d5, double d6) {
            d dVar = this.f777b;
            float f = dVar.f760cw * dVar.f772cz;
            if (!this.f786ar) {
                m584a(d, d2, d3, d4, d5, d6, f);
                return;
            }
            double d7 = d4 - d;
            double d8 = d5 - d2;
            double d9 = d6 - d3;
            int iMax = Math.max(1, (int) Math.ceil(Math.sqrt(((d7 * d7) + (d8 * d8)) + (d9 * d9)) / this.f784V));
            for (int i = 0; i < iMax; i++) {
                double d10 = ((double) i) / ((double) iMax);
                double d11 = ((double) (i + 1)) / ((double) iMax);
                m584a(d + (d7 * d10), d2 + (d8 * d10), d3 + (d9 * d10), d + (d7 * d11), d2 + (d8 * d11), d3 + (d9 * d11), f);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m584a(double d, double d2, double d3, double d4, double d5, double d6, float f) {
            float fM585a = f * m585a(d, d2, d3);
            float fM585a2 = f * m585a(d4, d5, d6);
            if (fM585a > 0.0f || fM585a2 > 0.0f) {
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
                double d13 = this.f778P - d;
                double d14 = this.f779Q - d2;
                double d15 = this.f780R - d3;
                double d16 = (d11 * d15) - (d12 * d14);
                double d17 = (d12 * d13) - (d10 * d15);
                double d18 = (d10 * d14) - (d11 * d13);
                double dSqrt2 = Math.sqrt((d16 * d16) + (d17 * d17) + (d18 * d18));
                if (dSqrt2 < 1.0E-7d) {
                    return;
                }
                double d19 = (((double) this.f777b.f761cx) * 0.01d) / dSqrt2;
                double d20 = d16 * d19;
                double d21 = d17 * d19;
                double d22 = d18 * d19;
                float fRed = FastColor.ARGB32.red(this.f777b.f759bN) * C0119bk.f722cs;
                float fGreen = FastColor.ARGB32.green(this.f777b.f759bN) * C0119bk.f722cs;
                float fBlue = FastColor.ARGB32.blue(this.f777b.f759bN) * C0119bk.f722cs;
                m588a(d + d20, d2 + d21, d3 + d22, fRed, fGreen, fBlue, fM585a);
                m588a(d4 + d20, d5 + d21, d6 + d22, fRed, fGreen, fBlue, fM585a2);
                m588a(d4 - d20, d5 - d21, d6 - d22, fRed, fGreen, fBlue, fM585a2);
                m588a(d - d20, d2 - d21, d3 - d22, fRed, fGreen, fBlue, fM585a);
            }
        }

        /* JADX INFO: renamed from: a */
        float m585a(double d, double d2, double d3) {
            float fClamp = 1.0f;
            switch (this.f777b.f763a.ordinal()) {
                case 1:
                    fClamp = (float) Mth.clamp((this.f788X - d2) / m586l(), 0.0d, 1.0d);
                    break;
                case 2:
                    fClamp = (float) Mth.clamp((d2 - this.f787W) / m586l(), 0.0d, 1.0d);
                    break;
            }
            if (this.f786ar && fClamp > 0.0f) {
                double d4 = d - this.f781S;
                double d5 = d2 - this.f782T;
                double d6 = d3 - this.f783U;
                fClamp *= (float) Mth.clamp(1.0d - (Math.sqrt(((d4 * d4) + (d5 * d5)) + (d6 * d6)) / this.f777b.f767L), 0.0d, 1.0d);
            }
            return fClamp;
        }

        /* JADX INFO: renamed from: l */
        private double m586l() {
            double dMax = Math.max(f775O, this.f788X - this.f787W);
            double d = this.f777b.f764K;
            return d > 0.0d ? Math.min(d, dMax) : dMax;
        }

        /* JADX INFO: renamed from: a */
        double m587a(double d) {
            return (Math.floor((d / this.f784V) + 1.0E-7d) * this.f784V) + this.f784V;
        }

        /* JADX INFO: renamed from: a */
        void m588a(double d, double d2, double d3, float f, float f2, float f3, float f4) {
            if (this.f785aq) {
                d += (this.f778P - d) * f774N;
                d2 += (this.f779Q - d2) * f774N;
                d3 += (this.f780R - d3) * f774N;
            }
            this.f789a.add((float) d);
            this.f789a.add((float) d2);
            this.f789a.add((float) d3);
            this.f789a.add(f);
            this.f789a.add(f2);
            this.f789a.add(f3);
            this.f789a.add(f4);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$c.class */
    private static final class c extends e {

        /* JADX INFO: renamed from: b */
        private final AABB f756b;

        c(@NotNull Camera camera, @NotNull AABB aabb, @NotNull d dVar) {
            super(camera, dVar, aabb.minY, aabb.maxY);
            this.f756b = aabb;
        }

        @Override // com.boehmod.blockfront.C0119bk.e
        /* JADX INFO: renamed from: z */
        void mo555z() {
            d dVar = this.f777b;
            AABB aabb = this.f756b;
            if (dVar.f758cv * dVar.f772cz > 0.0f) {
                if (dVar.f769an) {
                    m561a(0, aabb.minX, aabb.minY, aabb.maxY, aabb.minZ, aabb.maxZ);
                    m561a(0, aabb.maxX, aabb.minY, aabb.maxY, aabb.minZ, aabb.maxZ);
                    m561a(2, aabb.minZ, aabb.minX, aabb.maxX, aabb.minY, aabb.maxY);
                    m561a(2, aabb.maxZ, aabb.minX, aabb.maxX, aabb.minY, aabb.maxY);
                }
                if (dVar.f771ap) {
                    m561a(1, aabb.minY, aabb.minX, aabb.maxX, aabb.minZ, aabb.maxZ);
                }
                if (dVar.f770ao) {
                    m561a(1, aabb.maxY, aabb.minX, aabb.maxX, aabb.minZ, aabb.maxZ);
                }
            }
            if (dVar.f760cw * dVar.f772cz > 0.0f) {
                m565A();
                if (dVar.f762J > 0.0d) {
                    m566C();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m561a(int i, double d, double d2, double d3, double d4, double d5) {
            d dVar = this.f777b;
            float fRed = FastColor.ARGB32.red(dVar.f757bM) * C0119bk.f722cs;
            float fGreen = FastColor.ARGB32.green(dVar.f757bM) * C0119bk.f722cs;
            float fBlue = FastColor.ARGB32.blue(dVar.f757bM) * C0119bk.f722cs;
            float f = dVar.f758cv * dVar.f772cz;
            if (!this.f786ar) {
                m562a(i, d, d2, d3, d4, d5, fRed, fGreen, fBlue, f);
                return;
            }
            double d6 = d2;
            while (true) {
                double d7 = d6;
                if (d7 < d3) {
                    double dMin = Math.min(d3, m587a(d7));
                    double d8 = d4;
                    while (true) {
                        double d9 = d8;
                        if (d9 < d5) {
                            double dMin2 = Math.min(d5, m587a(d9));
                            if (m563a(i, d, d7, dMin, d9, dMin2)) {
                                m562a(i, d, d7, dMin, d9, dMin2, fRed, fGreen, fBlue, f);
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

        /* JADX INFO: renamed from: a */
        private void m562a(int i, double d, double d2, double d3, double d4, double d5, float f, float f2, float f3, float f4) {
            m564a(i, d, d2, d4, f, f2, f3, f4);
            m564a(i, d, d3, d4, f, f2, f3, f4);
            m564a(i, d, d3, d5, f, f2, f3, f4);
            m564a(i, d, d2, d5, f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: a */
        private boolean m563a(int i, double d, double d2, double d3, double d4, double d5) {
            double dM569a = m569a(m567a(i));
            double dM569a2 = m569a(m568b(i));
            double dClamp = dM569a - Mth.clamp(dM569a, d2, d3);
            double dClamp2 = dM569a2 - Mth.clamp(dM569a2, d4, d5);
            double dM569a3 = m569a(i) - d;
            double d6 = this.f777b.f767L;
            return ((dClamp * dClamp) + (dClamp2 * dClamp2)) + (dM569a3 * dM569a3) < d6 * d6;
        }

        /* JADX INFO: renamed from: a */
        private void m564a(int i, double d, double d2, double d3, float f, float f2, float f3, float f4) {
            double d4 = i == 0 ? d : d2;
            double d5 = i == 0 ? d2 : i == 1 ? d : d3;
            double d6 = i == 2 ? d : d3;
            m588a(d4, d5, d6, f, f2, f3, f4 * m585a(d4, d5, d6));
        }

        /* JADX INFO: renamed from: A */
        private void m565A() {
            AABB aabb = this.f756b;
            m583c(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ);
            m583c(aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
            m583c(aabb.maxX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ);
            m583c(aabb.minX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.minZ);
            m583c(aabb.minX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ);
            m583c(aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            m583c(aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ);
            m583c(aabb.minX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.minZ);
            m583c(aabb.minX, aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ);
            m583c(aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ);
            m583c(aabb.maxX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            m583c(aabb.minX, aabb.minY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ);
        }

        /* JADX INFO: renamed from: C */
        private void m566C() {
            d dVar = this.f777b;
            AABB aabb = this.f756b;
            if (dVar.f769an) {
                double dA = m587a(aabb.minZ);
                while (true) {
                    double d = dA;
                    if (d >= aabb.maxZ - 1.0E-4d) {
                        break;
                    }
                    m583c(aabb.minX, aabb.minY, d, aabb.minX, aabb.maxY, d);
                    m583c(aabb.maxX, aabb.minY, d, aabb.maxX, aabb.maxY, d);
                    dA = m587a(d);
                }
                double dA2 = m587a(aabb.minX);
                while (true) {
                    double d2 = dA2;
                    if (d2 >= aabb.maxX - 1.0E-4d) {
                        break;
                    }
                    m583c(d2, aabb.minY, aabb.minZ, d2, aabb.maxY, aabb.minZ);
                    m583c(d2, aabb.minY, aabb.maxZ, d2, aabb.maxY, aabb.maxZ);
                    dA2 = m587a(d2);
                }
                double dA3 = m587a(aabb.minY);
                while (true) {
                    double d3 = dA3;
                    if (d3 >= aabb.maxY - 1.0E-4d) {
                        break;
                    }
                    m583c(aabb.minX, d3, aabb.minZ, aabb.maxX, d3, aabb.minZ);
                    m583c(aabb.maxX, d3, aabb.minZ, aabb.maxX, d3, aabb.maxZ);
                    m583c(aabb.maxX, d3, aabb.maxZ, aabb.minX, d3, aabb.maxZ);
                    m583c(aabb.minX, d3, aabb.maxZ, aabb.minX, d3, aabb.minZ);
                    dA3 = m587a(d3);
                }
            }
            if (dVar.f770ao || dVar.f771ap) {
                double dA4 = m587a(aabb.minX);
                while (true) {
                    double d4 = dA4;
                    if (d4 >= aabb.maxX - 1.0E-4d) {
                        break;
                    }
                    if (dVar.f771ap) {
                        m583c(d4, aabb.minY, aabb.minZ, d4, aabb.minY, aabb.maxZ);
                    }
                    if (dVar.f770ao) {
                        m583c(d4, aabb.maxY, aabb.minZ, d4, aabb.maxY, aabb.maxZ);
                    }
                    dA4 = m587a(d4);
                }
                double dA5 = m587a(aabb.minZ);
                while (true) {
                    double d5 = dA5;
                    if (d5 < aabb.maxZ - 1.0E-4d) {
                        if (dVar.f771ap) {
                            m583c(aabb.minX, aabb.minY, d5, aabb.maxX, aabb.minY, d5);
                        }
                        if (dVar.f770ao) {
                            m583c(aabb.minX, aabb.maxY, d5, aabb.maxX, aabb.maxY, d5);
                        }
                        dA5 = m587a(d5);
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static int m567a(int i) {
            return i == 0 ? 1 : 0;
        }

        /* JADX INFO: renamed from: b */
        private static int m568b(int i) {
            return i == 2 ? 1 : 2;
        }

        /* JADX INFO: renamed from: a */
        private double m569a(int i) {
            return i == 0 ? this.f781S : i == 1 ? this.f782T : this.f783U;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bk$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bk$a.class */
    private static final class a extends e {

        /* JADX INFO: renamed from: b */
        private final C0806oY f753b;

        /* JADX INFO: renamed from: H */
        private final double f754H;

        /* JADX INFO: renamed from: I */
        private final double f755I;

        a(@NotNull Camera camera, @NotNull C0806oY c0806oY, double d, double d2, @NotNull d dVar) {
            super(camera, dVar, d, d2);
            this.f753b = c0806oY;
            this.f754H = d;
            this.f755I = d2;
        }

        @Override // com.boehmod.blockfront.C0119bk.e
        /* JADX INFO: renamed from: z */
        void mo555z() {
            d dVar = this.f777b;
            if (dVar.f758cv * dVar.f772cz > 0.0f) {
                ObjectListIterator it = this.f753b.m4164f().iterator();
                while (it.hasNext()) {
                    m556a((C0806oY.a) it.next());
                }
            }
            if (dVar.f760cw * dVar.f772cz > 0.0f) {
                m559A();
                if (dVar.f762J > 0.0d) {
                    m560B();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m556a(@NotNull C0806oY.a aVar) {
            Vec2 vec2M4174c = aVar.m4174c();
            Vec2 vec2M4175d = aVar.m4175d();
            double d = vec2M4175d.x - vec2M4174c.x;
            double d2 = vec2M4175d.y - vec2M4174c.y;
            double dSqrt = Math.sqrt((d * d) + (d2 * d2));
            if (dSqrt < 1.0E-4d) {
                return;
            }
            d dVar = this.f777b;
            float fRed = FastColor.ARGB32.red(dVar.f757bM) * C0119bk.f722cs;
            float fGreen = FastColor.ARGB32.green(dVar.f757bM) * C0119bk.f722cs;
            float fBlue = FastColor.ARGB32.blue(dVar.f757bM) * C0119bk.f722cs;
            float f = dVar.f758cv * dVar.f772cz;
            double d3 = d / dSqrt;
            double d4 = d2 / dSqrt;
            if (!this.f786ar) {
                m557a(vec2M4174c.x, vec2M4174c.y, d3, d4, 0.0d, dSqrt, this.f754H, this.f755I, fRed, fGreen, fBlue, f);
                return;
            }
            double d5 = 0.0d;
            while (true) {
                double d6 = d5;
                if (d6 < dSqrt) {
                    double dMin = Math.min(dSqrt, d6 + this.f784V);
                    double d7 = this.f754H;
                    while (true) {
                        double d8 = d7;
                        if (d8 < this.f755I) {
                            double dMin2 = Math.min(this.f755I, d8 + this.f784V);
                            if (m558a(vec2M4174c.x, vec2M4174c.y, d3, d4, d6, dMin, d8, dMin2)) {
                                m557a(vec2M4174c.x, vec2M4174c.y, d3, d4, d6, dMin, d8, dMin2, fRed, fGreen, fBlue, f);
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

        /* JADX INFO: renamed from: a */
        private void m557a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, float f, float f2, float f3, float f4) {
            double d9 = d + (d3 * d5);
            double d10 = d2 + (d4 * d5);
            double d11 = d + (d3 * d6);
            double d12 = d2 + (d4 * d6);
            m588a(d9, d7, d10, f, f2, f3, f4 * m585a(d9, d7, d10));
            m588a(d11, d7, d12, f, f2, f3, f4 * m585a(d11, d7, d12));
            m588a(d11, d8, d12, f, f2, f3, f4 * m585a(d11, d8, d12));
            m588a(d9, d8, d10, f, f2, f3, f4 * m585a(d9, d8, d10));
        }

        /* JADX INFO: renamed from: a */
        private boolean m558a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double dClamp = Mth.clamp(((this.f781S - d) * d3) + ((this.f783U - d2) * d4), d5, d6);
            double d9 = this.f781S - (d + (d3 * dClamp));
            double d10 = this.f783U - (d2 + (d4 * dClamp));
            double dClamp2 = this.f782T - Mth.clamp(this.f782T, d7, d8);
            double d11 = this.f777b.f767L;
            return ((d9 * d9) + (dClamp2 * dClamp2)) + (d10 * d10) < d11 * d11;
        }

        /* JADX INFO: renamed from: A */
        private void m559A() {
            ObjectListIterator it = this.f753b.m4164f().iterator();
            while (it.hasNext()) {
                C0806oY.a aVar = (C0806oY.a) it.next();
                Vec2 vec2M4174c = aVar.m4174c();
                Vec2 vec2M4175d = aVar.m4175d();
                m583c(vec2M4174c.x, this.f754H, vec2M4174c.y, vec2M4175d.x, this.f754H, vec2M4175d.y);
                m583c(vec2M4174c.x, this.f755I, vec2M4174c.y, vec2M4175d.x, this.f755I, vec2M4175d.y);
                m583c(vec2M4174c.x, this.f754H, vec2M4174c.y, vec2M4174c.x, this.f755I, vec2M4174c.y);
            }
        }

        /* JADX INFO: renamed from: B */
        private void m560B() {
            ObjectList<C0806oY.a> objectListM4164f = this.f753b.m4164f();
            double dA = m587a(this.f754H);
            while (true) {
                double d = dA;
                if (d >= this.f755I - 1.0E-4d) {
                    break;
                }
                ObjectListIterator it = objectListM4164f.iterator();
                while (it.hasNext()) {
                    C0806oY.a aVar = (C0806oY.a) it.next();
                    Vec2 vec2M4174c = aVar.m4174c();
                    Vec2 vec2M4175d = aVar.m4175d();
                    m583c(vec2M4174c.x, d, vec2M4174c.y, vec2M4175d.x, d, vec2M4175d.y);
                }
                dA = m587a(d);
            }
            ObjectListIterator it2 = objectListM4164f.iterator();
            while (it2.hasNext()) {
                C0806oY.a aVar2 = (C0806oY.a) it2.next();
                Vec2 vec2M4174c2 = aVar2.m4174c();
                Vec2 vec2M4175d2 = aVar2.m4175d();
                double d2 = vec2M4175d2.x - vec2M4174c2.x;
                double d3 = vec2M4175d2.y - vec2M4174c2.y;
                double dSqrt = Math.sqrt((d2 * d2) + (d3 * d3));
                if (dSqrt >= 1.0E-4d) {
                    double d4 = d2 / dSqrt;
                    double d5 = d3 / dSqrt;
                    double d6 = this.f784V;
                    while (true) {
                        double d7 = d6;
                        if (d7 < dSqrt - 1.0E-4d) {
                            double d8 = ((double) vec2M4174c2.x) + (d4 * d7);
                            double d9 = ((double) vec2M4174c2.y) + (d5 * d7);
                            m583c(d8, this.f754H, d9, d8, this.f755I, d9);
                            d6 = d7 + this.f784V;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m484a(@NotNull PoseStack poseStack, @NotNull Vec3[] vec3Arr, float f2, float f3, float f4, float f5) {
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

    /* JADX INFO: renamed from: a */
    public static void m485a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GameProfile gameProfile, float f2, float f3, int i) {
        ResourceLocation resourceLocationM528a = m528a(minecraft, c0622l, gameProfile);
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.blit(resourceLocationM528a, 0, 0, i, i, 8.0f, 8.0f, 8, 8, 64, 64);
        guiGraphics.blit(resourceLocationM528a, 0, 0, i, i, 40.0f, 8.0f, 8, 8, 64, 64);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m486a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, int i, int i2, float f4) {
        RenderSystem.enableBlend();
        m538a(i2);
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.blit(f741H, 0, 0, i, i, 0.0f, (int) ((((long) f4) % 61) * 256.0f), 256, 256, 256, f745bH);
        poseStack.popPose();
        RenderSystem.disableBlend();
        m539y();
    }

    /* JADX INFO: renamed from: a */
    public static void m487a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f2) {
        RenderSystem.enableBlend();
        m538a(i4);
        guiGraphics.blit(f741H, i, i2, i3, i3, 0.0f, (int) ((((long) f2) % 61) * 256.0f), 256, 256, 256, f745bH);
        m539y();
        RenderSystem.disableBlend();
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m488d(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = 0.25f;
        float f9 = 0.25f / f7;
        m440b(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5);
        for (int i = 0; i < f7; i++) {
            float f10 = f8 - f9;
            m444b(poseStack, guiGraphics, resourceLocation, f2 + (f6 * i), f3, f4, f5, 0.0f, f10);
            m444b(poseStack, guiGraphics, resourceLocation, f2 - (f6 * i), f3, f4, f5, 0.0f, f10 - f9);
            f8 = 0.25f;
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m489b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(-(f4 / 2.0f), -(f5 / 2.0f), 0.0f);
        m416a(poseStack, guiGraphics, f2 - 1.0f, f3 - 1.0f, f4 + 2.0f, f5 + 2.0f, i, 0.3f);
        m416a(poseStack, guiGraphics, f2, f3, f4, f5, i, f6);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m490b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i) {
        m492c(poseStack, guiGraphics, f2, f3, f4, f5, i, FastColor.ARGB32.alpha(i) * f722cs);
    }

    /* JADX INFO: renamed from: c */
    public static void m491c(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        m493c(guiGraphics, i, i2, i3, i4, i5, FastColor.ARGB32.alpha(i5) * f722cs);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m492c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        m416a(poseStack, guiGraphics, f2 - 1.0f, f3 - 1.0f, f4 + 2.0f, f5 + 2.0f, 0, 0.3f);
        m416a(poseStack, guiGraphics, f2, f3, f4, f5, i, f6);
    }

    /* JADX INFO: renamed from: c */
    public static void m493c(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        m417a(guiGraphics, i - 1, i2 - 1, i3 + 2, i4 + 2, 0, 0.3f);
        m417a(guiGraphics, i, i2, i3, i4, i5, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m494a(@NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, int i, int i2, float f2, float f3, float f4, float f5) {
        m495a(c0326fV, poseStack, guiGraphics, minecraft, livingEntity, i, i2, f2, f3, f4, f5, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m495a(@NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        C0324fT c0324fTB = livingEntity instanceof Player ? (C0324fT) c0326fV.m1133a((Player) livingEntity) : c0326fV.m1135b(livingEntity.getUUID());
        boolean zDk = c0324fTB.m1087dk();
        int iM1652ag = c0324fTB.m1652ag();
        boolean zIsInvisible = livingEntity.isInvisible();
        float f9 = livingEntity.yBodyRotO;
        float f10 = livingEntity.yBodyRot;
        float f11 = livingEntity.yHeadRotO;
        float f12 = livingEntity.yHeadRot;
        float f13 = livingEntity.xRotO;
        c0324fTB.m1088X(false);
        c0324fTB.m1653m(0);
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
        c0324fTB.m1088X(zDk);
        c0324fTB.m1653m(iM1652ag);
        livingEntity.setInvisible(zIsInvisible);
    }

    /* JADX INFO: renamed from: a */
    public static void m496a(@NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, Font font, @NotNull UUID uuid, @NotNull C0279eb.b bVar, int i, int i2, int i3, boolean z) {
        C0279eb.a slotInfo = bVar.getSlotInfo();
        int iMo1483a = slotInfo.mo1483a(c0326fV, uuid, z);
        Component componentMo1482a = slotInfo.mo1482a(c0326fV, uuid, z);
        Component componentMo1481a = slotInfo.mo1481a(c0326fV, uuid);
        m415a(guiGraphics, i + 2, i2 + 1, 1, i3 - 2, iMo1483a);
        m370a(font, guiGraphics, componentMo1481a, i + 5, i2 + 2);
        m371a(font, guiGraphics, componentMo1482a, i + 5, (i2 + i3) - 9, iMo1483a);
    }

    /* JADX INFO: renamed from: b */
    public static void m497b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2) {
        int iM365p = m365p();
        float f4 = i / 2.0f;
        float f5 = f2 - f4;
        m413a(poseStack, f5 - 5.0f, f3, 5.0f, i2, iM365p, 2);
        m413a(poseStack, f2 + f4, f3, 5.0f, i2, iM365p, 4);
        m414a(poseStack, guiGraphics, f5, f3, i, i2, iM365p);
        m382c(poseStack, font, guiGraphics, component, f2, f3 + 1.5f);
    }

    /* JADX INFO: renamed from: a */
    public static void m498a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, C0482iS c0482iS, @NotNull C0482iS c0482iS2, float f2, float f3, boolean z) {
        CloudRegistry cloudRegistryA = c0622l.m2670a();
        Optional<MatchParty> party = c0482iS.getParty();
        int prestigeLevel = c0482iS2.getPrestigeLevel();
        UUID uuid = c0482iS2.getUUID();
        C0477iN inventory = c0482iS2.getInventory();
        boolean zBooleanValue = ((Boolean) party.map(matchParty -> {
            return Boolean.valueOf(matchParty.isHost(uuid));
        }).orElse(false)).booleanValue();
        MutableComponent mutableComponentAppend = C0475iL.m2150a(c0482iS2).append(Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)).append(c0482iS2.m2188b());
        if (c0482iS2.m2183a() == PlayerDataType.DISPLAY) {
            mutableComponentAppend.withStyle(ChatFormatting.GRAY);
        }
        if (z) {
            mutableComponentAppend.withStyle(ChatFormatting.YELLOW);
        }
        int iWidth = font.width(mutableComponentAppend);
        m497b(poseStack, font, guiGraphics, (Component) mutableComponentAppend, f2, f3, iWidth, 10);
        CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.COIN);
        if (cloudItemStackM2160a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2160a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0544jb.m2468a(abstractCloudItemCoin).mo2466a(abstractCloudItemCoin, cloudItemStackM2160a, poseStack, minecraft, guiGraphics, (f2 - (iWidth / 2.0f)) - 5.0f, f3, 9.0f, 9.0f, 1.0f);
            }
        }
        if (zBooleanValue) {
            m390b(poseStack, font, guiGraphics, (Component) f737w.copy(), f2, f3 + 12.0f, 0.5f);
        }
        if (c0482iS2.m2183a() != PlayerDataType.DISPLAY) {
            float f4 = f2 - 8.0f;
            float f5 = (f3 - 16.0f) - 5.0f;
            ResourceLocation resourceLocationM2555d = C0564jv.m2555d("textures/misc/ranks/" + c0482iS2.getRank().getTexture() + ".png");
            m430a(poseStack, guiGraphics, C0195cx.f1566aJ, f4 - 7.0f, f5 - 7.0f, 31.0f, 31.0f);
            m430a(poseStack, guiGraphics, C0195cx.f1572aP, f4, f5, 16.0f, 16.0f);
            m430a(poseStack, guiGraphics, resourceLocationM2555d, f4, f5, 16.0f, 16.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m499a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @Nullable UUID uuid, @NotNull Style style, @NotNull Collection<String> collection, float f2, float f3, float f4, float f5, int i) {
        C1015sV c1015sVM5528a;
        CloudItem<?> cloudItem;
        CloudRegistry cloudRegistryA = c0622l.m2670a();
        Optional<MatchParty> party = c0482iS.getParty();
        C0482iS c0482iSA = null;
        C0477iN inventory = null;
        C0324fT c0324fTB = null;
        if (uuid != null) {
            c0482iSA = c0326fV.mo1137a(uuid);
            inventory = c0482iSA.getInventory();
            c0324fTB = c0326fV.m1135b(uuid);
            if (uuid.equals(c0482iS.getUUID())) {
                style = Style.EMPTY;
            }
        }
        float size = f4 - (collection.size() * 30);
        int i2 = (int) f2;
        int i3 = (int) f3;
        int i4 = (int) size;
        int i5 = (int) f5;
        m417a(guiGraphics, i2, i3, i4, i5, 0, 0.5f);
        if (uuid != null) {
            ResourceLocation resourceLocationM2555d = f734F;
            CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.CARD);
            if (cloudItemStackM2160a != null && (cloudItem = cloudItemStackM2160a.getCloudItem(cloudRegistryA)) != null) {
                resourceLocationM2555d = C0564jv.m2555d("textures/gui/callingcard/" + cloudItem.getSuffixForDisplay() + ".png");
            }
            m517a(guiGraphics, i2 + 1, i3 + 1, i4 - 2, i5 - 2);
            m434a(poseStack, guiGraphics, resourceLocationM2555d, i2, i3 - 25.0f, 220.0f, 50.0f, 0.0f, 0.1f);
            guiGraphics.disableScissor();
            int i6 = 0;
            MutableComponent mutableComponentAppend = C0475iL.m2150a(c0482iSA).append(c0482iSA.m2188b());
            party.ifPresent(matchParty -> {
                if (matchParty.isPresent(uuid)) {
                    mutableComponentAppend.append(" ").append(matchParty.isHost(uuid) ? f742x : f743y);
                }
            });
            PlayerRank rank = c0482iSA.getRank();
            C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(uuid);
            int color = c0796oOM3793a != null ? c0796oOM3793a.getColor() : ColorReferences.COLOR_WHITE;
            ResourceLocation resourceLocationM2555d2 = C0564jv.m2555d("textures/misc/ranks/" + rank.getTexture() + ".png");
            float f6 = f2 + 14.5f;
            float f7 = f3 + i + 0.5f;
            m436a(poseStack, guiGraphics, f732D, f6, f7, 7.0f, 7.0f, 0.0f, 1.0f, color);
            m430a(poseStack, guiGraphics, resourceLocationM2555d2, f6, f7, 7.0f, 7.0f);
            int prestigeLevel = c0482iSA.getPrestigeLevel();
            if (prestigeLevel > 0) {
                m396a(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(prestigeLevel)), f6 + 3.5f, f3 + 7.0f, ColorReferences.COLOR_WHITE, 0, 0.5f);
            }
            CloudItemStack cloudItemStackM2160a2 = inventory.m2160a(CloudItemType.COIN);
            if (cloudItemStackM2160a2 != null) {
                CloudItem<?> cloudItem2 = cloudItemStackM2160a2.getCloudItem(cloudRegistryA);
                if (cloudItem2 instanceof AbstractCloudItemCoin) {
                    AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem2;
                    C0544jb.m2468a(abstractCloudItemCoin).mo2465a(abstractCloudItemCoin, cloudItemStackM2160a2, minecraft, poseStack, guiGraphics, f2 + 24.0f + 4.0f, f3 + i + 0.1f + 4.0f, 8.0f, 8.0f, 1.0f);
                }
                i6 = 0 + 10;
            }
            int iM3854a = abstractC0787oF.m3598a(uuid).m3854a(C1089tp.f5692i.getKey(), -1);
            if (iM3854a != -1 && (c1015sVM5528a = C1015sV.m5528a(iM3854a)) != null) {
                int iM3854a2 = abstractC0787oF.m3598a(uuid).m3854a(C1089tp.f5693j.getKey(), 0);
                float f8 = (f2 + size) - f5;
                m428a(poseStack, guiGraphics, c1015sVM5528a.getIcon(), f8, f3, f5);
                MutableComponent mutableComponentWithColor = Component.translatable(c1015sVM5528a.m5516al()).withStyle(ChatFormatting.BOLD).withColor(c1015sVM5528a.m5522bU() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
                if (iM3854a2 > 0) {
                    mutableComponentWithColor = mutableComponentWithColor.append(" ").append(Component.translatable("enchantment.level." + (iM3854a2 + 1)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID));
                }
                m386a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, (f8 - (font.width(mutableComponentWithColor) / 2.0f)) - 1.0f, f3 + 3.0f, 0.5f);
            }
            float f9 = f2 + 3.0f;
            float f10 = f3 + i + 0.1f;
            AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
            C0796oO c0796oOM3793a2 = abstractC0790oIM3582b.m3793a(c0482iS.getUUID());
            boolean z = (c0324fTB.m1087dk() || c0324fTB.m1099q() != null) && !abstractC0790oIM3582b.m3811g(uuid);
            boolean z2 = c0796oOM3793a2 != null && c0796oOM3793a2.equals(c0796oOM3793a);
            if (z && abstractC0787oF.mo3613a().shouldShow(z2)) {
                m430a(poseStack, guiGraphics, f733E, f9, f10, 8.0f, 8.0f);
            } else {
                m485a(minecraft, c0622l, poseStack, guiGraphics, c0482iSA.m2195a(), f9, f10, 8);
                abstractC0788oG.m3702a(poseStack, guiGraphics, c0324fTB, f9, f10, 8);
            }
            m368a(poseStack, font, guiGraphics, (Component) mutableComponentAppend, f2 + 25.0f + i6, f3 + i + 0.5f);
        } else {
            m368a(poseStack, font, guiGraphics, (Component) f747z.copy().withStyle(style), f2 + 2.0f, f3 + i);
        }
        float f11 = f2 + i4;
        int i7 = 0;
        for (String str : collection) {
            float f12 = f11 + (i7 * 30) + 1.0f;
            MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(style);
            m416a(poseStack, guiGraphics, f12, f3, 29.0f, f5, i7 % 2 == 0 ? 1118481 : 0, 0.5f);
            m382c(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, f12 + 15.0f, f3 + i);
            i7++;
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m500a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f2, float f3) {
        m501a(poseStack, guiGraphics, itemStack, f2, f3, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m501a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f2, float f3, float f4) {
        RenderSystem.setupGuiFlatDiffuseLighting(f738c, f739d);
        poseStack.pushPose();
        poseStack.translate(f2 - (8.0f * f4), f3 - (8.0f * f4), 0.0f);
        poseStack.scale(f4, f4, f4);
        guiGraphics.renderItem(itemStack, 0, 0, 0, f751bK);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static String m502a(int i) {
        int i2 = i % 60;
        return (i / 60) + ":" + (i2 < 10 ? "0" : "") + i2;
    }

    /* JADX INFO: renamed from: a */
    public static void m503a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m504a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, boolean z) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m505a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, int i, boolean z) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, vec3.x, vec3.y, vec3.z, i, i, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m506a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull BlockPos blockPos, int i, boolean z) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, blockPos.getX(), blockPos.getY(), blockPos.getZ(), i, i, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m507a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m508a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, boolean z) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m509a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m510a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, boolean z) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m511a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, int i, int i2, float f2, int i3, boolean z) {
        m512a(poseStack, camera, guiGraphics, resourceLocation, vec3.x, vec3.y, vec3.z, i, i2, f2, i3, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m512a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z) {
        RenderSystem.depthMask(false);
        if (z) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        m437a(poseStack, guiGraphics, resourceLocation, (-i) / 2, (-i2) / 2, i, i2, 0.0f, f2, i3);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m513a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z, float f3) {
        float fClamp = Mth.clamp(f3, 0.0f, 1.0f);
        if (fClamp <= 0.0f || f2 <= 0.0f) {
            return;
        }
        int iMax = Math.max(1, Math.round(i * fClamp));
        RenderSystem.depthMask(false);
        if (z) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        RenderSystem.enableBlend();
        m537a(i3, f2);
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        guiGraphics.blit(resourceLocation, (-i) / 2, (-i2) / 2, iMax, i2, 0.0f, 0.0f, iMax, i2, i, i2);
        poseStack.popPose();
        RenderSystem.disableBlend();
        m539y();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m514a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, int i, boolean z) {
        RenderSystem.depthMask(false);
        if (z) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        poseStack.scale(-0.02f, -0.02f, -0.02f);
        m436a(poseStack, guiGraphics, resourceLocation, (-f2) / 2.0f, (-f3) / 2.0f, f2, f3, 0.0f, f4, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m515a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, float f5, float f6) {
        m516a(poseStack, guiGraphics, resourceLocation, d2, d3, d4, f2, f3, f4, ColorReferences.COLOR_WHITE, true, f5, f6);
    }

    /* JADX INFO: renamed from: a */
    public static void m516a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, int i, boolean z, float f5, float f6) {
        RenderSystem.depthMask(false);
        if (z) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(f6));
        poseStack.mulPose(Axis.XP.rotationDegrees(f5));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        m436a(poseStack, guiGraphics, resourceLocation, (-f2) / 2.0f, (-f3) / 2.0f, f2, f3, 0.0f, f4, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m517a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        guiGraphics.enableScissor(i, i2, i + i3, i2 + i4);
    }

    /* JADX INFO: renamed from: a */
    public static void m518a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        m522a(poseStack, font, camera, guiGraphics, component, d2, d3, d4, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: b */
    public static void m519b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        m523b(poseStack, font, camera, guiGraphics, component, d2, d3, d4, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m520a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2) {
        m522a(poseStack, font, camera, guiGraphics, component, d2, d3, d4, f2, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: b */
    public static void m521b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2) {
        m523b(poseStack, font, camera, guiGraphics, component, d2, d3, d4, f2, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m522a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2, int i, boolean z) {
        RenderSystem.depthMask(false);
        if (z) {
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
        m369a(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: b */
    public static void m523b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2, int i, boolean z) {
        RenderSystem.depthMask(false);
        if (z) {
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
        m380b(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m524a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(2.0f, 2.0f, 1.0f);
        poseStack.translate(0.0f, 0.0f, -1.0f);
        poseStack.scale(-0.016f, -0.016f, 1.0f);
        m368a(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: k */
    public static void m525k(@NotNull Minecraft minecraft) {
        m526b(minecraft, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public static void m526b(@NotNull Minecraft minecraft, float f2) {
        m527a(minecraft, f2, minecraft.options.getMenuBackgroundBlurriness());
    }

    /* JADX INFO: renamed from: a */
    public static void m527a(@NotNull Minecraft minecraft, float f2, int i) {
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
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m528a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GameProfile gameProfile) {
        return m529a(minecraft, c0622l, gameProfile.getId());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m529a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull UUID uuid) {
        return c0622l.m2703a().m2137a(minecraft, uuid);
    }

    /* JADX INFO: renamed from: a */
    public static void m530a(@NotNull Camera camera, @NotNull PoseStack poseStack) {
        Vec3 position = camera.getPosition();
        poseStack.translate(-position.x, -position.y, -position.z);
    }

    /* JADX INFO: renamed from: a */
    public static void m531a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, @NotNull PoseStack poseStack, double d2, double d3, double d4) {
        m532a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d2, d3, d4, 0.0f, 0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m532a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, @NotNull PoseStack poseStack, double d2, double d3, double d4, float f2, float f3, float f4) {
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

    /* JADX INFO: renamed from: a */
    public static void m533a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull BlockEntity blockEntity, double d2, double d3, double d4, float f2, float f3, float f4) {
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

    /* JADX INFO: renamed from: a */
    public static void m534a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0003A c0003a, float f2, float f3, float f4, boolean z, boolean z2, float f5) {
        Window window = Minecraft.getInstance().getWindow();
        double width = ((double) window.getWidth()) / ((double) guiGraphics.guiWidth());
        double height = ((double) window.getHeight()) / ((double) guiGraphics.guiHeight());
        if (z) {
            m535a(poseStack, guiGraphics, c0003a.m5e(), f2, f3, f4, width, height);
        }
        if (z2) {
            m535a(poseStack, guiGraphics, c0003a.m1a(), f2, ((f3 - 8.0f) - f5) + 2.0f, f4, width, height);
            m535a(poseStack, guiGraphics, c0003a.m2b(), f2, ((f3 + 8.0f) + f5) - 2.0f, f4, width, height);
            m535a(poseStack, guiGraphics, c0003a.m3c(), ((f2 - 8.0f) - f5) + 2.0f, f3, f4, width, height);
            m535a(poseStack, guiGraphics, c0003a.m4d(), ((f2 + 8.0f) + f5) - 2.0f, f3, f4, width, height);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m535a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, double d2, double d3) {
        m434a(poseStack, guiGraphics, resourceLocation, (float) (Math.round(((double) (f2 - 8.0f)) * d2) / d2), (float) (Math.round(((double) (f3 - 8.0f)) * d3) / d3), 16.0f, 16.0f, 0.0f, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m536a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull LocalPlayer localPlayer, float f2, float f3) {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        if (minecraft.options.attackIndicator().get() == AttackIndicatorStatus.CROSSHAIR) {
            float attackStrengthScale = localPlayer.getAttackStrengthScale(0.0f);
            float f4 = (f3 - 7.0f) + 24.0f;
            float f5 = f2 - 8.0f;
            if (attackStrengthScale < 1.0f) {
                poseStack.translate(f5, f4, 0.0f);
                guiGraphics.blitSprite(f723z, 0, 0, 16, 4);
                guiGraphics.blitSprite(f724A, 16, 4, 0, 0, 0, 0, (int) (attackStrengthScale * 17.0f), 4);
                poseStack.translate(-f5, -f4, 0.0f);
            }
        }
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: a */
    public static void m537a(int i, float f2) {
        RenderSystem.setShaderColor(FastColor.ARGB32.red(i) * f722cs, FastColor.ARGB32.green(i) * f722cs, FastColor.ARGB32.blue(i) * f722cs, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m538a(int i) {
        RenderSystem.setShaderColor(FastColor.ARGB32.red(i) * f722cs, FastColor.ARGB32.green(i) * f722cs, FastColor.ARGB32.blue(i) * f722cs, 1.0f);
    }

    /* JADX INFO: renamed from: y */
    public static void m539y() {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m540a(@NotNull C0871pk c0871pk, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f2) {
        if (clientLevel.clip(new ClipContext(localPlayer.getEyePosition(), c0871pk.f4424c, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.MISS) {
            float fM541a = m541a(c0871pk, localPlayer);
            float f3 = f2 + ((float) (c0871pk.f4424c.x + c0871pk.f4424c.y + c0871pk.f4424c.z));
            float fSin = Mth.sin(f3 / 15.0f);
            float fSin2 = fM541a * (1.5f + Mth.sin(f3 / 5.0f));
            if (fSin2 < 0.0f) {
                fSin2 = 0.0f;
            }
            m512a(poseStack, camera, guiGraphics, c0871pk.m4384z(), c0871pk.f4424c.x, c0871pk.f4424c.y + ((double) (0.15f * fSin)), c0871pk.f4424c.z, 32, 32, fSin2, ColorReferences.COLOR_WHITE_SOLID, true);
        }
    }

    /* JADX INFO: renamed from: a */
    private static float m541a(@NotNull C0871pk c0871pk, @NotNull LocalPlayer localPlayer) {
        float x = (float) (c0871pk.f4424c.x - localPlayer.getX());
        float y = (float) (c0871pk.f4424c.y - localPlayer.getY());
        float z = (float) (c0871pk.f4424c.z - localPlayer.getZ());
        float fSqrt = Mth.sqrt((x * x) + (y * y) + (z * z));
        float f2 = (fSqrt * 100.0f) / 8.0f;
        if (fSqrt > 8.0f) {
            f2 = 200.0f - f2;
        }
        return 0.01f * f2;
    }

    /* JADX INFO: renamed from: a */
    public static void m542a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, float f2) {
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
        m415a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        m449c(poseStack, guiGraphics, resourceLocation, i5, i6, i4, i3, 1.2f, 0.5f);
        m431a(poseStack, guiGraphics, f735G, 0, 0, i, i2);
        m526b(minecraft, f2);
        m367a(poseStack, guiGraphics, 5, 5, i - 10, i2 - 10);
    }

    /* JADX INFO: renamed from: a */
    public static int m543a(int i, int i2, double d2) {
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

        /* JADX INFO: renamed from: cA */
        private final float f790cA;

        /* JADX INFO: renamed from: cB */
        private final float f791cB;

        /* JADX INFO: renamed from: as */
        private final boolean f792as;

        /* JADX INFO: renamed from: at */
        private final boolean f793at;

        /* JADX INFO: renamed from: cC */
        private final float f794cC;

        /* JADX INFO: renamed from: Y */
        private final double f795Y;

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

        /* JADX INFO: renamed from: h */
        public float m589h() {
            return this.f790cA;
        }

        /* JADX INFO: renamed from: i */
        public float m590i() {
            return this.f791cB;
        }

        /* JADX INFO: renamed from: n */
        public boolean m591n() {
            return this.f792as;
        }

        /* JADX INFO: renamed from: o */
        public boolean m592o() {
            return this.f793at;
        }

        /* JADX INFO: renamed from: j */
        public float m593j() {
            return this.f794cC;
        }

        /* JADX INFO: renamed from: m */
        public double m594m() {
            return this.f795Y;
        }

        public f(float f, float f2, boolean z, boolean z2, float f3, double d) {
            this.f790cA = f;
            this.f791cB = f2;
            this.f792as = z;
            this.f793at = z2;
            this.f794cC = f3;
            this.f795Y = d;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m544a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2) {
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
        boolean z = vector3f.z > 0.0f;
        float f3 = i * 0.5f;
        float f4 = i2 * 0.5f;
        boolean z2 = false;
        if (!z && Math.abs(vector3f.z) > 0.001f) {
            Matrix4f projectionMatrix = gameRenderer.getProjectionMatrix(gameRenderer.getFov(camera, f2, true));
            Vector4f vector4f = new Vector4f(vector3f.x, vector3f.y, vector3f.z, 1.0f);
            projectionMatrix.transform(vector4f);
            fClamp = ((vector4f.x / vector4f.w) + 1.0f) * 0.5f * i;
            fClamp2 = (1.0f - (vector4f.y / vector4f.w)) * 0.5f * i2;
            z2 = fClamp >= ((float) i3) && fClamp <= ((float) (i - i3)) && fClamp2 >= ((float) i3) && fClamp2 <= ((float) (i2 - i3));
        } else {
            fClamp = f3;
            fClamp2 = f4;
        }
        float f5 = vector3f.x;
        float f6 = -vector3f.y;
        float degrees = (float) Math.toDegrees(Math.atan2(f6, f5));
        if (!z2) {
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
        return new f(fClamp, fClamp2, z2, z, degrees, dSqrt);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m545a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3) {
        return m544a(vec3, camera, i, i2, i3, Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m546a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2) {
        return m545a(vec3, camera, i, i2, 20);
    }

    /* JADX INFO: renamed from: a */
    public static void m547a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2) {
        m550a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i3, 1.0f, ColorReferences.COLOR_WHITE, 20, false, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m548a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2, float f3) {
        m550a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i3, f2, ColorReferences.COLOR_WHITE, 20, false, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m549a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, float f3) {
        m550a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i4, f2, i5, 20, false, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m550a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, int i6, boolean z, float f3) {
        f fVarM544a = m544a(vec3, camera, i, i2, i6, f3);
        float f4 = (fVarM544a.f792as || !z) ? 0.0f : fVarM544a.f794cC + 90.0f;
        poseStack.pushPose();
        poseStack.translate(fVarM544a.f790cA, fVarM544a.f791cB, 0.0f);
        m447b(poseStack, guiGraphics, resourceLocation, 0, 0, i3, i4, f4, f2, i5);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m551a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, int i6, boolean z, float f3) {
        f fVarM544a = m544a(vec3, camera, i, i2, i6, f3);
        m447b(poseStack, guiGraphics, resourceLocation, (int) fVarM544a.f790cA, (int) fVarM544a.f791cB, i3, i4, (fVarM544a.f792as || !z) ? 0.0f : fVarM544a.f794cC + 90.0f, f2, i5);
        return fVarM544a;
    }

    /* JADX INFO: renamed from: a */
    public static void m552a(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2) {
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
