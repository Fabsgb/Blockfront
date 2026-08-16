package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerDataType;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt.class */
public final class C0129bt {

    /* JADX INFO: renamed from: cy */
    private static final float f857cy = 0.003921569f;

    /* JADX INFO: renamed from: ct */
    @Unique
    public static final int f860ct = 3;

    /* JADX INFO: renamed from: cz */
    public static final float f862cz = 400.0f;

    /* JADX INFO: renamed from: cv */
    public static final int f863cv = 16;

    /* JADX INFO: renamed from: cw */
    public static final int f864cw = 8;

    /* JADX INFO: renamed from: cx */
    private static final int f875cx = 1996488704;

    /* JADX INFO: renamed from: cy */
    private static final int f879cy = 256;

    /* JADX INFO: renamed from: cz */
    private static final int f880cz = 15616;

    /* JADX INFO: renamed from: cA */
    private static final int f881cA = 61;

    /* JADX INFO: renamed from: cA */
    private static final float f883cA = 0.3f;

    /* JADX INFO: renamed from: cB */
    private static final int f885cB = 32;

    /* JADX INFO: renamed from: cC */
    public static final int f886cC = -125;

    /* JADX INFO: renamed from: z */
    private static final ResourceLocation f858z = ResourceLocation.withDefaultNamespace("hud/crosshair_attack_indicator_background");

    /* JADX INFO: renamed from: A */
    private static final ResourceLocation f859A = ResourceLocation.withDefaultNamespace("hud/crosshair_attack_indicator_progress");

    /* JADX INFO: renamed from: cu */
    public static final int f861cu = ChatFormatting.RED.getColor().intValue();

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final ResourceLocation f865B = C0532jO.m2378d("textures/gui/emitter/ember.png");

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final ResourceLocation f866C = C0532jO.m2378d("textures/skins/debug.png");

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final ResourceLocation f867D = C0532jO.m2378d("textures/misc/ranks/bg.png");

    /* JADX INFO: renamed from: E */
    @NotNull
    private static final ResourceLocation f868E = C0532jO.m2378d("textures/gui/dead.png");

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final ResourceLocation f869F = C0532jO.m2378d("textures/gui/callingcard/default.png");

    /* JADX INFO: renamed from: G */
    @NotNull
    private static final ResourceLocation f870G = C0532jO.m2378d("textures/gui/shadoweffect.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0163ca f871a = new C0163ca(Minecraft.getInstance().getGameProfile());

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final Component f872w = Component.translatable("bf.message.party.leader").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final Vector3f f873c = new Vector3f(-0.5f, 1.0f, -0.7f).normalize();

    /* JADX INFO: renamed from: d */
    private static final Vector3f f874d = new Vector3f(-0.5f, 1.0f, 0.7f).normalize();

    /* JADX INFO: renamed from: H */
    @NotNull
    private static final ResourceLocation f876H = C0532jO.m2378d("textures/gui/animated/running.png");

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final Component f877x = Component.literal("[PL]").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final Component f878y = Component.literal("[P]").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: z */
    private static final Component f882z = Component.translatable("bf.message.username");

    /* JADX INFO: renamed from: I */
    @NotNull
    private static final ResourceLocation f884I = C0532jO.m2378d("textures/gui/gamemode/corner.png");

    /* JADX INFO: renamed from: cD */
    private static int f887cD = 0;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bt$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt$b.class */
    public enum b {
        NONE,
        TOP,
        BOTTOM
    }

    /* JADX INFO: renamed from: t */
    public static int m465t() {
        return f875cx;
    }

    public static void onUpdate() {
        if (f887cD > 0) {
            f887cD--;
        }
    }

    /* JADX INFO: renamed from: g */
    public static float m466g() {
        return Util.getMillis() / 20.0f;
    }

    /* JADX INFO: renamed from: a */
    public static void m467a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        m533a(poseStack, guiGraphics, f884I, i, i2, 8, 8, 0.25f);
        m535a(poseStack, guiGraphics, f884I, (i + i3) - 8, i2, 8, 8, 90.0f, 0.25f);
        m535a(poseStack, guiGraphics, f884I, i, (i2 + i4) - 8, 8, 8, -90.0f, 0.25f);
        m535a(poseStack, guiGraphics, f884I, (i + i3) - 8, (i2 + i4) - 8, 8, 8, 180.0f, 0.25f);
        m517a(guiGraphics, i + 8, i2, i3 - 16, 1, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        m517a(guiGraphics, i + 8, (i2 + i4) - 1, i3 - 16, 1, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        m517a(guiGraphics, i, i2 + 8, 1, i4 - 16, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        m517a(guiGraphics, (i + i3) - 1, i2 + 8, 1, i4 - 16, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m468a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m469a(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m469a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, component, 0, 0, i, false);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m470a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m471a(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m471a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        guiGraphics.drawString(font, component, i, i2, i3, false);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m472a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i) {
        int i2 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        Iterator<FormattedCharSequence> it = list.iterator();
        while (it.hasNext()) {
            font.drawInBatch(it.next(), f2, f3 + i2, ColorReferences.COLOR_WHITE, false, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i2 += i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m473a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, int i, int i2, int i3) {
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
    public static void m474a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, boolean z) {
        float f4 = 0.0f;
        Matrix4f matrix4fPose = poseStack.last().pose();
        for (FormattedCharSequence formattedCharSequence : list) {
            font.drawInBatch(formattedCharSequence, f2 - (font.width(formattedCharSequence) / 2.0f), f3 + f4, ColorReferences.COLOR_WHITE, z, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            f4 += i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m475a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, int i, int i2, int i3, boolean z) {
        int i4 = 0;
        Matrix4f matrix4fPose = poseStack.last().pose();
        for (FormattedCharSequence formattedCharSequence : list) {
            font.drawInBatch(formattedCharSequence, i - (font.width(formattedCharSequence) / 2.0f), i2 + i4, ColorReferences.COLOR_WHITE, z, matrix4fPose, multiBufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            i4 += i3;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m476a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, float f4) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 0.1f);
        m473a(poseStack, font, multiBufferSource, list, 0, 0, (int) (i / f4));
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m477a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull MultiBufferSource multiBufferSource, @NotNull List<FormattedCharSequence> list, float f2, float f3, int i, float f4, boolean z) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 0.1f);
        m475a(poseStack, font, multiBufferSource, list, 0, 0, (int) (i / f4), z);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m478b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m480b(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    public static void m479b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m481b(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m480b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, component, 0, 0, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    public static void m481b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        guiGraphics.drawString(font, component, i, i2, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m482c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m484c(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: c */
    public static void m483c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m485c(font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m484c(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        m469a(poseStack, font, guiGraphics, component, f2 - (font.width(component) / 2.0f), f3, i);
    }

    /* JADX INFO: renamed from: c */
    public static void m485c(Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        m471a(font, guiGraphics, component, i - (font.width(component) / 2), i2, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m486a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        m488a(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m487a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        m488a(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m488a(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m471a(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    public static void m489b(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m481b(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m490b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        m492c(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    /* JADX INFO: renamed from: b */
    public static void m491b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        m492c(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m492c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m485c(font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m493c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, float f4) {
        m495d(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE, f4);
    }

    /* JADX INFO: renamed from: c */
    public static void m494c(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, float f2) {
        m495d(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m495d(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m501a(poseStack, font, guiGraphics, component, 0, 0, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m496a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m497a(poseStack, font, guiGraphics, component, 0.0f, 0.0f, i, i2);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m497a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2) {
        int iWidth = font.width(component) / 2;
        m469a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3 + 1.0f, i2);
        m469a(poseStack, font, guiGraphics, component, f2 - iWidth, f3 + 1.0f, i2);
        m469a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3 + 1.0f, i2);
        m469a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3, i2);
        m469a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3, i2);
        m469a(poseStack, font, guiGraphics, component, (f2 - 1.0f) - iWidth, f3 - 1.0f, i2);
        m469a(poseStack, font, guiGraphics, component, f2 - iWidth, f3 - 1.0f, i2);
        m469a(poseStack, font, guiGraphics, component, (f2 + 1.0f) - iWidth, f3 - 1.0f, i2);
        m469a(poseStack, font, guiGraphics, component, f2 - iWidth, f3, i);
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m498d(@NotNull PoseStack poseStack, Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3) {
        m500d(poseStack, font, guiGraphics, component, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m499a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2) {
        m501a(poseStack, font, guiGraphics, component, i, i2, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m500d(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i) {
        m480b(poseStack, font, guiGraphics, component, f2 - (font.width(component) / 2.0f), f3, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m501a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, int i, int i2, int i3) {
        m480b(poseStack, font, guiGraphics, component, i - (font.width(component) / 2.0f), i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m502a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        m503a(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m503a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        guiGraphics.drawString(font, formattedCharSequence, i, i2, i3, false);
    }

    /* JADX INFO: renamed from: b */
    public static void m504b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        m505b(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    public static void m505b(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        guiGraphics.drawString(font, formattedCharSequence, i, i2, i3, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m506a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i) {
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.drawString(font, formattedCharSequence, 0, 0, i, true);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: c */
    public static void m507c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        m508c(font, guiGraphics, formattedCharSequence, i, i2, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: c */
    public static void m508c(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2, int i3) {
        m503a(font, guiGraphics, formattedCharSequence, i - (font.width(formattedCharSequence) / 2), i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m509a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3) {
        m510b(poseStack, font, guiGraphics, formattedCharSequence, f2, f3, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: b */
    public static void m510b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i) {
        m506a(poseStack, font, guiGraphics, formattedCharSequence, f2 - (font.width(formattedCharSequence) / 2.0f), f3, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m511a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m507c(font, guiGraphics, formattedCharSequence, 0, 0);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m512a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, float f2, float f3, int i, float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f4, 1.0f);
        m510b(poseStack, font, guiGraphics, formattedCharSequence, 0.0f, 0.0f, i);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m513a(@NotNull PoseStack poseStack, float f2, float f3, float f4, float f5, int i, int i2) {
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
        float fRed = FastColor.ARGB32.red(i) * f857cy;
        float fGreen = FastColor.ARGB32.green(i) * f857cy;
        float fBlue = FastColor.ARGB32.blue(i) * f857cy;
        float fAlpha = FastColor.ARGB32.alpha(i) * f857cy;
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
    public static void m514a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i) {
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
    public static void m515a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fill(i, i2, i + i3, i2 + i4, i5);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m516a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        guiGraphics.fill(0, 0, 1, 1, C1270xJ.m7159a(i, f6));
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m517a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fill(i, i2, i + i3, i2 + i4, C1270xJ.m7159a(i5, f2));
    }

    /* JADX INFO: renamed from: b */
    public static void m518b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        guiGraphics.drawManaged(() -> {
            m515a(guiGraphics, i + 1, i2, i3 - 2, 1, i5);
            m515a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5);
            m515a(guiGraphics, i + 1, (i2 + i4) - 1, i3 - 2, 1, i5);
        });
    }

    /* JADX INFO: renamed from: b */
    public static void m519b(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        guiGraphics.drawManaged(() -> {
            m517a(guiGraphics, i + 1, i2, i3 - 2, 1, i5, f2);
            m517a(guiGraphics, i, i2 + 1, i3, i4 - 2, i5, f2);
            m517a(guiGraphics, i + 1, (i2 + i4) - 1, i3 - 2, 1, i5, f2);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m520a(@NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, int i) {
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
        m514a(poseStackPose, guiGraphics, 0.0f, (-f6) / 2.0f, fSqrt, f6, i);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static void m521a(@NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, float f6, int i, float f7) {
        m520a(guiGraphics, f2, f3, f4, f5, f6, C1270xJ.m7159a(i, f7));
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m522a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2) {
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
    public static void m523a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        guiGraphics.fillGradient(i, i2, i + i3, i2 + i4, i5, i6);
    }

    /* JADX INFO: renamed from: b */
    public static void m524b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f4, f5, 1.0f);
        m525a(poseStack, guiGraphics, 1.0f, 1.0f, i, i2);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    private static void m525a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, int i, int i2) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        VertexConsumer buffer = guiGraphics.bufferSource().getBuffer(RenderType.gui());
        float fRed = FastColor.ARGB32.red(i) * f857cy;
        float fGreen = FastColor.ARGB32.green(i) * f857cy;
        float fBlue = FastColor.ARGB32.blue(i) * f857cy;
        float fAlpha = FastColor.ARGB32.alpha(i) * f857cy;
        float fRed2 = FastColor.ARGB32.red(i2) * f857cy;
        float fGreen2 = FastColor.ARGB32.green(i2) * f857cy;
        float fBlue2 = FastColor.ARGB32.blue(i2) * f857cy;
        float fAlpha2 = FastColor.ARGB32.alpha(i2) * f857cy;
        buffer.addVertex(matrix4fPose, 0.0f, 0.0f, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
        buffer.addVertex(matrix4fPose, 0.0f, f3, 0.0f).setColor(fRed, fGreen, fBlue, fAlpha);
        buffer.addVertex(matrix4fPose, f2, f3, 0.0f).setColor(fRed2, fGreen2, fBlue2, fAlpha2);
        buffer.addVertex(matrix4fPose, f2, 0.0f, 0.0f).setColor(fRed2, fGreen2, fBlue2, fAlpha2);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m526a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, int i2, float f6, float f7) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        m522a(poseStack, guiGraphics, f2, f3, f4, f5, C1270xJ.m7159a(i, Mth.clamp(f6, 0.0f, 1.0f)), C1270xJ.m7159a(i2, Mth.clamp(f7, 0.0f, 1.0f)));
    }

    /* JADX INFO: renamed from: a */
    public static void m527a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6, float f2, float f3) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        m523a(guiGraphics, i, i2, i3, i4, C1270xJ.m7159a(i5, Mth.clamp(f2, 0.0f, 1.0f)), C1270xJ.m7159a(i6, Mth.clamp(f3, 0.0f, 1.0f)));
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m528a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4) {
        m530a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m529a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3) {
        m531a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m530a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5) {
        m534a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m531a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        m535a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m532a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        m534a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, f6);
    }

    /* JADX INFO: renamed from: a */
    public static void m533a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2) {
        m535a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m534a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        m536a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public static void m535a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3) {
        m537a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, f2, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m536a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        m551a(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, 0.0f, f6, f7, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m537a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, int i5) {
        m552a(poseStack, guiGraphics, resourceLocation, i, i2, i3, i4, 0.0f, f2, f3, i5);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m538b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4) {
        m540b(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f4);
    }

    /* JADX INFO: renamed from: b */
    public static void m539b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3) {
        m541b(poseStack, guiGraphics, resourceLocation, i, i2, i3, i3);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m540b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5) {
        m530a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5);
    }

    /* JADX INFO: renamed from: b */
    public static void m541b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4) {
        m531a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m542b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        m534a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public static void m543b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2) {
        m535a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4, f2, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m544b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        m534a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7);
    }

    /* JADX INFO: renamed from: b */
    public static void m545b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3) {
        m534a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2.0f), i2 - (i4 / 2.0f), i3, i4, f2, f3);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m546b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        m536a(poseStack, guiGraphics, resourceLocation, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7, i);
    }

    /* JADX INFO: renamed from: b */
    public static void m547b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, int i5) {
        m537a(poseStack, guiGraphics, resourceLocation, i - (i3 / 2), i2 - (i4 / 2), i3, i4, f2, f3, i5);
    }

    /* JADX INFO: renamed from: c */
    public static void m548c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6) {
        m550c(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: c */
    public static void m549c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        m550c(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m550c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (f6 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        poseStack.scale(f6, f6, 1.0f);
        m546b(poseStack, guiGraphics, resourceLocation, 0.0f, 0.0f, f4, f5, 0.0f, f7, i);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m551a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        RenderSystem.enableBlend();
        m640a(i, f8);
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
        m642B();
    }

    /* JADX INFO: renamed from: a */
    public static void m552a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, int i3, int i4, float f2, float f3, float f4, int i5) {
        if (f4 <= 0.0f || i3 <= 0 || i4 <= 0) {
            return;
        }
        RenderSystem.enableBlend();
        m640a(i5, f4);
        poseStack.pushPose();
        if (f2 != 0.0f || f3 != 0.0f) {
            int i6 = i + (i3 / 2);
            int i7 = i2 + (i4 / 2);
            poseStack.translate(i6, i7, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(f2));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f3));
            poseStack.translate(-i6, -i7, 0.0f);
        }
        guiGraphics.blit(resourceLocation, i, i2, 0.0f, 0.0f, i3, i4, i3, i4);
        poseStack.popPose();
        RenderSystem.disableBlend();
        m642B();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m553a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5) {
        m556a(poseStack, i, f2, f3, f4, f5, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m554a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5) {
        m556a(poseStack, i, i2, i3, i4, i5, 0.0f, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m555a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        m556a(poseStack, i, f2, f3, f4, f5, 0.0f, f6);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m556a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        m558a(poseStack, i, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m557a(@NotNull PoseStack poseStack, int i, float f2, int i2, int i3, int i4, int i5, float f3) {
        m558a(poseStack, i, f2, i2, i3, i4, i5, f3, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m558a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        m571a(poseStack, i, f2, f3, f4, f5, f6, 0.0f, f7, i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m559a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5, float f2, float f3, int i6) {
        m572a(poseStack, i, i2, i3, i4, i5, f2, 0.0f, f3, i6);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m560a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4) {
        m563b(poseStack, i, f2, f3, f4, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m561a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4) {
        m564b(poseStack, i, i2, i3, i4, i4);
    }

    /* JADX INFO: renamed from: a */
    public static void m562a(@NotNull PoseStack poseStack, int i, int i2, int i3, float f2) {
        m563b(poseStack, i, i2, i3, f2, f2);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m563b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5) {
        m553a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5);
    }

    /* JADX INFO: renamed from: b */
    public static void m564b(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5) {
        m554a(poseStack, i, i2 - (i4 / 2), i3 - (i5 / 2), i4, i5);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m565b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        m556a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, 1.0f);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m566b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        m556a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m567b(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        m558a(poseStack, i, f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), f4, f5, f6, f7, i2);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m568c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6) {
        m570c(poseStack, i, f2, f3, f4, f5, f6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m569c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        m570c(poseStack, i, f2, f3, f4, f5, f6, f7, ColorReferences.COLOR_WHITE);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m570c(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, int i2) {
        poseStack.pushPose();
        poseStack.translate(f2 - (f2 * f6), f3 - (f3 * f6), 0.0f);
        poseStack.scale(f6, f6, f6);
        m567b(poseStack, i, f2, f3, f4, f5, 0.0f, f7, i2);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m571a(@NotNull PoseStack poseStack, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        m640a(i2, f8);
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
        m642B();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: a */
    public static void m572a(@NotNull PoseStack poseStack, int i, int i2, int i3, int i4, int i5, float f2, float f3, float f4, int i6) {
        m640a(i6, f4);
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture(0, i);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        poseStack.pushPose();
        if (f3 != 0.0f || f2 != 0.0f) {
            int i7 = i2 + (i4 / 2);
            int i8 = i3 + (i5 / 2);
            poseStack.translate(i7, i8, 0.0f);
            poseStack.mulPose(Axis.XP.rotationDegrees(f3));
            poseStack.mulPose(Axis.ZP.rotationDegrees(f2));
            poseStack.translate(-i7, -i8, 0.0f);
        }
        Matrix4f matrix4fPose = poseStack.last().pose();
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilderBegin.addVertex(matrix4fPose, i2, i3 + i5, 0.0f).setUv(0.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, i2 + i4, i3 + i5, 0.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, i2 + i4, i3, 0.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(matrix4fPose, i2, i3, 0.0f).setUv(0.0f, 1.0f);
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        poseStack.popPose();
        m642B();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m573b(double d2, double d3, double d4, double d5, double d6, double d7) {
        return d6 >= d2 && d7 >= d3 && d6 <= d2 + d4 && d7 <= d3 + d5;
    }

    /* JADX INFO: renamed from: a */
    public static void m574a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f2, int i) {
        m575a(camera, poseStack, vec3, vec4, f2, i, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m575a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f2, int i, float f3) {
        m576a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec4.x, vec4.y, vec4.z, f2, i, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m576a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, float f3) {
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
        float fRed = FastColor.ARGB32.red(i) * f857cy;
        float fGreen = FastColor.ARGB32.green(i) * f857cy;
        float fBlue = FastColor.ARGB32.blue(i) * f857cy;
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
    public static void m577a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull C0882pu c0882pu, double d2, double d3, @NotNull d dVar) {
        if (c0882pu.m4608bE()) {
            return;
        }
        a aVar = new a(camera, c0882pu, d2, d3, dVar);
        aVar.mo660C();
        aVar.m686a(poseStack);
    }

    /* JADX INFO: renamed from: a */
    public static void m578a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f2, int i, int i2) {
        m580a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec4.x, vec4.y, vec4.z, f2, i, i2, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m579a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f2, int i, int i2, float f3) {
        m580a(camera, poseStack, vec3.x, vec3.y, vec3.z, vec4.x, vec4.y, vec4.z, f2, i, i2, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m580a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, int i2, float f3) {
        m581a(camera, poseStack, d2, d3, d4, d5, d6, d7, f2, i, i2, f3, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m581a(@NotNull Camera camera, @NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, float f2, int i, int i2, float f3, float f4) {
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
        float fRed = FastColor.ARGB32.red(i) * f857cy;
        float fGreen = FastColor.ARGB32.green(i) * f857cy;
        float fBlue = FastColor.ARGB32.blue(i) * f857cy;
        float fRed2 = FastColor.ARGB32.red(i2) * f857cy;
        float fGreen2 = FastColor.ARGB32.green(i2) * f857cy;
        float fBlue2 = FastColor.ARGB32.blue(i2) * f857cy;
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
    public static void m582a(@NotNull PoseStack poseStack, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, int i, float f2) {
        float fRed = FastColor.ARGB32.red(i) * f857cy;
        float fGreen = FastColor.ARGB32.green(i) * f857cy;
        float fBlue = FastColor.ARGB32.blue(i) * f857cy;
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
    public static void m583a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull AABB aabb, @NotNull d dVar) {
        c cVar = new c(camera, aabb, dVar);
        cVar.mo660C();
        cVar.m686a(poseStack);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bt$d */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt$d.class */
    public static final class d {

        /* JADX INFO: renamed from: cE */
        private int f892cE = ColorReferences.COLOR_WHITE;

        /* JADX INFO: renamed from: cB */
        private float f893cB = 0.0f;

        /* JADX INFO: renamed from: cF */
        private int f894cF = ColorReferences.COLOR_WHITE;

        /* JADX INFO: renamed from: cC */
        private float f895cC = 1.0f;

        /* JADX INFO: renamed from: cD */
        private float f896cD = 1.5f;

        /* JADX INFO: renamed from: Q */
        private double f897Q = 0.0d;

        /* JADX INFO: renamed from: a */
        private b f898a = b.NONE;

        /* JADX INFO: renamed from: R */
        private double f899R = 0.0d;

        /* JADX INFO: renamed from: ar */
        private boolean f900ar = false;

        /* JADX INFO: renamed from: h */
        @Nullable
        private Vec3 f901h = null;

        /* JADX INFO: renamed from: S */
        private double f902S = 8.0d;

        /* JADX INFO: renamed from: cE */
        private float f903cE = 1.0f;

        /* JADX INFO: renamed from: as */
        private boolean f904as = true;

        /* JADX INFO: renamed from: at */
        private boolean f905at = true;

        /* JADX INFO: renamed from: au */
        private boolean f906au = true;

        /* JADX INFO: renamed from: cF */
        private float f907cF = 1.0f;

        private d() {
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public static d m675a() {
            return new d();
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m676a(int i, float f) {
            this.f892cE = i;
            this.f893cB = f;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m677a(int i, float f, float f2) {
            this.f894cF = i;
            this.f895cC = f;
            this.f896cD = f2;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public d m678b() {
            this.f895cC = 0.0f;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m679a(double d) {
            this.f897Q = d;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m680a(@NotNull b bVar) {
            return m681a(bVar, 0.0d);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m681a(@NotNull b bVar, double d) {
            this.f898a = bVar;
            this.f899R = d;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m682a(@Nullable Vec3 vec3, double d) {
            this.f900ar = true;
            this.f901h = vec3;
            this.f902S = d;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m683a(float f) {
            this.f903cE = f;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public d m684a(boolean z, boolean z2, boolean z3) {
            this.f904as = z;
            this.f905at = z2;
            this.f906au = z3;
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public d m685b(float f) {
            this.f907cF = f;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bt$e */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt$e.class */
    private static abstract class e {

        /* JADX INFO: renamed from: T */
        private static final double f908T = 0.01d;

        /* JADX INFO: renamed from: U */
        private static final double f909U = 0.002d;

        /* JADX INFO: renamed from: V */
        static final double f910V = 1.0E-4d;

        /* JADX INFO: renamed from: cG */
        private static final int f911cG = 7;

        /* JADX INFO: renamed from: b */
        final d f912b;

        /* JADX INFO: renamed from: W */
        final double f913W;

        /* JADX INFO: renamed from: X */
        final double f914X;

        /* JADX INFO: renamed from: Y */
        final double f915Y;

        /* JADX INFO: renamed from: Z */
        final double f916Z;

        /* JADX INFO: renamed from: aa */
        final double f917aa;

        /* JADX INFO: renamed from: ab */
        final double f918ab;

        /* JADX INFO: renamed from: ac */
        final double f919ac;

        /* JADX INFO: renamed from: av */
        final boolean f920av;

        /* JADX INFO: renamed from: aw */
        final boolean f921aw;

        /* JADX INFO: renamed from: ad */
        private final double f922ad;

        /* JADX INFO: renamed from: ae */
        private final double f923ae;

        /* JADX INFO: renamed from: a */
        private final FloatArrayList f924a = new FloatArrayList();

        /* JADX INFO: renamed from: C */
        abstract void mo660C();

        e(@NotNull Camera camera, @NotNull d dVar, double d, double d2) {
            this.f912b = dVar;
            this.f922ad = d;
            this.f923ae = d2;
            Vec3 position = camera.getPosition();
            this.f913W = position.x;
            this.f914X = position.y;
            this.f915Y = position.z;
            Vec3 vec3 = dVar.f901h != null ? dVar.f901h : position;
            this.f916Z = vec3.x;
            this.f917aa = vec3.y;
            this.f918ab = vec3.z;
            this.f919ac = dVar.f897Q > 0.0d ? dVar.f897Q : 1.0d;
            this.f920av = dVar.f903cE < 1.0f;
            this.f921aw = dVar.f900ar;
        }

        /* JADX INFO: renamed from: a */
        void m686a(@NotNull PoseStack poseStack) {
            if (this.f924a.isEmpty()) {
                return;
            }
            float fClamp = Mth.clamp(this.f912b.f903cE, 0.0f, 1.0f);
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            RenderSystem.disableCull();
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.depthMask(false);
            Matrix4f matrix4fPose = poseStack.last().pose();
            if (fClamp >= 1.0f) {
                RenderSystem.disableDepthTest();
                m687a(matrix4fPose, 1.0f);
            } else {
                RenderSystem.enableDepthTest();
                m687a(matrix4fPose, 1.0f);
                if (fClamp > 0.0f) {
                    RenderSystem.depthFunc(516);
                    m687a(matrix4fPose, fClamp);
                    RenderSystem.depthFunc(515);
                }
            }
            RenderSystem.depthMask(true);
            RenderSystem.enableCull();
            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
        }

        /* JADX INFO: renamed from: a */
        private void m687a(@NotNull Matrix4f matrix4f, float f) {
            BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
            float[] fArrElements = this.f924a.elements();
            int size = this.f924a.size();
            for (int i = 0; i < size; i += 7) {
                bufferBuilderBegin.addVertex(matrix4f, fArrElements[i], fArrElements[i + 1], fArrElements[i + 2]).setColor(fArrElements[i + 3], fArrElements[i + 4], fArrElements[i + 5], fArrElements[i + 6] * f);
            }
            BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        }

        /* JADX INFO: renamed from: c */
        void m688c(double d, double d2, double d3, double d4, double d5, double d6) {
            d dVar = this.f912b;
            float f = dVar.f895cC * dVar.f907cF;
            if (!this.f921aw) {
                m689a(d, d2, d3, d4, d5, d6, f);
                return;
            }
            double d7 = d4 - d;
            double d8 = d5 - d2;
            double d9 = d6 - d3;
            int iMax = Math.max(1, (int) Math.ceil(Math.sqrt(((d7 * d7) + (d8 * d8)) + (d9 * d9)) / this.f919ac));
            for (int i = 0; i < iMax; i++) {
                double d10 = ((double) i) / ((double) iMax);
                double d11 = ((double) (i + 1)) / ((double) iMax);
                m689a(d + (d7 * d10), d2 + (d8 * d10), d3 + (d9 * d10), d + (d7 * d11), d2 + (d8 * d11), d3 + (d9 * d11), f);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m689a(double d, double d2, double d3, double d4, double d5, double d6, float f) {
            float fM690a = f * m690a(d, d2, d3);
            float fM690a2 = f * m690a(d4, d5, d6);
            if (fM690a > 0.0f || fM690a2 > 0.0f) {
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
                double d13 = this.f913W - d;
                double d14 = this.f914X - d2;
                double d15 = this.f915Y - d3;
                double d16 = (d11 * d15) - (d12 * d14);
                double d17 = (d12 * d13) - (d10 * d15);
                double d18 = (d10 * d14) - (d11 * d13);
                double dSqrt2 = Math.sqrt((d16 * d16) + (d17 * d17) + (d18 * d18));
                if (dSqrt2 < 1.0E-7d) {
                    return;
                }
                double d19 = (((double) this.f912b.f896cD) * 0.01d) / dSqrt2;
                double d20 = d16 * d19;
                double d21 = d17 * d19;
                double d22 = d18 * d19;
                float fRed = FastColor.ARGB32.red(this.f912b.f894cF) * C0129bt.f857cy;
                float fGreen = FastColor.ARGB32.green(this.f912b.f894cF) * C0129bt.f857cy;
                float fBlue = FastColor.ARGB32.blue(this.f912b.f894cF) * C0129bt.f857cy;
                m693a(d + d20, d2 + d21, d3 + d22, fRed, fGreen, fBlue, fM690a);
                m693a(d4 + d20, d5 + d21, d6 + d22, fRed, fGreen, fBlue, fM690a2);
                m693a(d4 - d20, d5 - d21, d6 - d22, fRed, fGreen, fBlue, fM690a2);
                m693a(d - d20, d2 - d21, d3 - d22, fRed, fGreen, fBlue, fM690a);
            }
        }

        /* JADX INFO: renamed from: a */
        float m690a(double d, double d2, double d3) {
            float fClamp = 1.0f;
            switch (this.f912b.f898a.ordinal()) {
                case 1:
                    fClamp = (float) Mth.clamp((this.f923ae - d2) / m691n(), 0.0d, 1.0d);
                    break;
                case 2:
                    fClamp = (float) Mth.clamp((d2 - this.f922ad) / m691n(), 0.0d, 1.0d);
                    break;
            }
            if (this.f921aw && fClamp > 0.0f) {
                double d4 = d - this.f916Z;
                double d5 = d2 - this.f917aa;
                double d6 = d3 - this.f918ab;
                fClamp *= (float) Mth.clamp(1.0d - (Math.sqrt(((d4 * d4) + (d5 * d5)) + (d6 * d6)) / this.f912b.f902S), 0.0d, 1.0d);
            }
            return fClamp;
        }

        /* JADX INFO: renamed from: n */
        private double m691n() {
            double dMax = Math.max(f910V, this.f923ae - this.f922ad);
            double d = this.f912b.f899R;
            return d > 0.0d ? Math.min(d, dMax) : dMax;
        }

        /* JADX INFO: renamed from: a */
        double m692a(double d) {
            return (Math.floor((d / this.f919ac) + 1.0E-7d) * this.f919ac) + this.f919ac;
        }

        /* JADX INFO: renamed from: a */
        void m693a(double d, double d2, double d3, float f, float f2, float f3, float f4) {
            if (this.f920av) {
                d += (this.f913W - d) * f909U;
                d2 += (this.f914X - d2) * f909U;
                d3 += (this.f915Y - d3) * f909U;
            }
            this.f924a.add((float) d);
            this.f924a.add((float) d2);
            this.f924a.add((float) d3);
            this.f924a.add(f);
            this.f924a.add(f2);
            this.f924a.add(f3);
            this.f924a.add(f4);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bt$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt$c.class */
    private static final class c extends e {

        /* JADX INFO: renamed from: b */
        private final AABB f891b;

        c(@NotNull Camera camera, @NotNull AABB aabb, @NotNull d dVar) {
            super(camera, dVar, aabb.minY, aabb.maxY);
            this.f891b = aabb;
        }

        @Override // com.boehmod.blockfront.C0129bt.e
        /* JADX INFO: renamed from: C */
        void mo660C() {
            d dVar = this.f912b;
            AABB aabb = this.f891b;
            if (dVar.f893cB * dVar.f907cF > 0.0f) {
                if (dVar.f904as) {
                    m666a(0, aabb.minX, aabb.minY, aabb.maxY, aabb.minZ, aabb.maxZ);
                    m666a(0, aabb.maxX, aabb.minY, aabb.maxY, aabb.minZ, aabb.maxZ);
                    m666a(2, aabb.minZ, aabb.minX, aabb.maxX, aabb.minY, aabb.maxY);
                    m666a(2, aabb.maxZ, aabb.minX, aabb.maxX, aabb.minY, aabb.maxY);
                }
                if (dVar.f906au) {
                    m666a(1, aabb.minY, aabb.minX, aabb.maxX, aabb.minZ, aabb.maxZ);
                }
                if (dVar.f905at) {
                    m666a(1, aabb.maxY, aabb.minX, aabb.maxX, aabb.minZ, aabb.maxZ);
                }
            }
            if (dVar.f895cC * dVar.f907cF > 0.0f) {
                m670D();
                if (dVar.f897Q > 0.0d) {
                    m671F();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m666a(int i, double d, double d2, double d3, double d4, double d5) {
            d dVar = this.f912b;
            float fRed = FastColor.ARGB32.red(dVar.f892cE) * C0129bt.f857cy;
            float fGreen = FastColor.ARGB32.green(dVar.f892cE) * C0129bt.f857cy;
            float fBlue = FastColor.ARGB32.blue(dVar.f892cE) * C0129bt.f857cy;
            float f = dVar.f893cB * dVar.f907cF;
            if (!this.f921aw) {
                m667a(i, d, d2, d3, d4, d5, fRed, fGreen, fBlue, f);
                return;
            }
            double d6 = d2;
            while (true) {
                double d7 = d6;
                if (d7 < d3) {
                    double dMin = Math.min(d3, m692a(d7));
                    double d8 = d4;
                    while (true) {
                        double d9 = d8;
                        if (d9 < d5) {
                            double dMin2 = Math.min(d5, m692a(d9));
                            if (m668a(i, d, d7, dMin, d9, dMin2)) {
                                m667a(i, d, d7, dMin, d9, dMin2, fRed, fGreen, fBlue, f);
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
        private void m667a(int i, double d, double d2, double d3, double d4, double d5, float f, float f2, float f3, float f4) {
            m669a(i, d, d2, d4, f, f2, f3, f4);
            m669a(i, d, d3, d4, f, f2, f3, f4);
            m669a(i, d, d3, d5, f, f2, f3, f4);
            m669a(i, d, d2, d5, f, f2, f3, f4);
        }

        /* JADX INFO: renamed from: a */
        private boolean m668a(int i, double d, double d2, double d3, double d4, double d5) {
            double dM674a = m674a(m672a(i));
            double dM674a2 = m674a(m673b(i));
            double dClamp = dM674a - Mth.clamp(dM674a, d2, d3);
            double dClamp2 = dM674a2 - Mth.clamp(dM674a2, d4, d5);
            double dM674a3 = m674a(i) - d;
            double d6 = this.f912b.f902S;
            return ((dClamp * dClamp) + (dClamp2 * dClamp2)) + (dM674a3 * dM674a3) < d6 * d6;
        }

        /* JADX INFO: renamed from: a */
        private void m669a(int i, double d, double d2, double d3, float f, float f2, float f3, float f4) {
            double d4;
            double d5 = i == 0 ? d : d2;
            if (i == 0) {
                d4 = d2;
            } else {
                d4 = i == 1 ? d : d3;
            }
            double d6 = d4;
            double d7 = i == 2 ? d : d3;
            m693a(d5, d6, d7, f, f2, f3, f4 * m690a(d5, d6, d7));
        }

        /* JADX INFO: renamed from: D */
        private void m670D() {
            AABB aabb = this.f891b;
            m688c(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ);
            m688c(aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
            m688c(aabb.maxX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ);
            m688c(aabb.minX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.minZ);
            m688c(aabb.minX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ);
            m688c(aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            m688c(aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ);
            m688c(aabb.minX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.minZ);
            m688c(aabb.minX, aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ);
            m688c(aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ);
            m688c(aabb.maxX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.maxY, aabb.maxZ);
            m688c(aabb.minX, aabb.minY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ);
        }

        /* JADX INFO: renamed from: F */
        private void m671F() {
            d dVar = this.f912b;
            AABB aabb = this.f891b;
            if (dVar.f904as) {
                double dA = m692a(aabb.minZ);
                while (true) {
                    double d = dA;
                    if (d >= aabb.maxZ - 1.0E-4d) {
                        break;
                    }
                    m688c(aabb.minX, aabb.minY, d, aabb.minX, aabb.maxY, d);
                    m688c(aabb.maxX, aabb.minY, d, aabb.maxX, aabb.maxY, d);
                    dA = m692a(d);
                }
                double dA2 = m692a(aabb.minX);
                while (true) {
                    double d2 = dA2;
                    if (d2 >= aabb.maxX - 1.0E-4d) {
                        break;
                    }
                    m688c(d2, aabb.minY, aabb.minZ, d2, aabb.maxY, aabb.minZ);
                    m688c(d2, aabb.minY, aabb.maxZ, d2, aabb.maxY, aabb.maxZ);
                    dA2 = m692a(d2);
                }
                double dA3 = m692a(aabb.minY);
                while (true) {
                    double d3 = dA3;
                    if (d3 >= aabb.maxY - 1.0E-4d) {
                        break;
                    }
                    m688c(aabb.minX, d3, aabb.minZ, aabb.maxX, d3, aabb.minZ);
                    m688c(aabb.maxX, d3, aabb.minZ, aabb.maxX, d3, aabb.maxZ);
                    m688c(aabb.maxX, d3, aabb.maxZ, aabb.minX, d3, aabb.maxZ);
                    m688c(aabb.minX, d3, aabb.maxZ, aabb.minX, d3, aabb.minZ);
                    dA3 = m692a(d3);
                }
            }
            if (dVar.f905at || dVar.f906au) {
                double dA4 = m692a(aabb.minX);
                while (true) {
                    double d4 = dA4;
                    if (d4 >= aabb.maxX - 1.0E-4d) {
                        break;
                    }
                    if (dVar.f906au) {
                        m688c(d4, aabb.minY, aabb.minZ, d4, aabb.minY, aabb.maxZ);
                    }
                    if (dVar.f905at) {
                        m688c(d4, aabb.maxY, aabb.minZ, d4, aabb.maxY, aabb.maxZ);
                    }
                    dA4 = m692a(d4);
                }
                double dA5 = m692a(aabb.minZ);
                while (true) {
                    double d5 = dA5;
                    if (d5 < aabb.maxZ - 1.0E-4d) {
                        if (dVar.f906au) {
                            m688c(aabb.minX, aabb.minY, d5, aabb.maxX, aabb.minY, d5);
                        }
                        if (dVar.f905at) {
                            m688c(aabb.minX, aabb.maxY, d5, aabb.maxX, aabb.maxY, d5);
                        }
                        dA5 = m692a(d5);
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static int m672a(int i) {
            return i == 0 ? 1 : 0;
        }

        /* JADX INFO: renamed from: b */
        private static int m673b(int i) {
            return i == 2 ? 1 : 2;
        }

        /* JADX INFO: renamed from: a */
        private double m674a(int i) {
            if (i == 0) {
                return this.f916Z;
            }
            return i == 1 ? this.f917aa : this.f918ab;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bt$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt$a.class */
    private static final class a extends e {

        /* JADX INFO: renamed from: b */
        private final C0882pu f888b;

        /* JADX INFO: renamed from: O */
        private final double f889O;

        /* JADX INFO: renamed from: P */
        private final double f890P;

        a(@NotNull Camera camera, @NotNull C0882pu c0882pu, double d, double d2, @NotNull d dVar) {
            super(camera, dVar, d, d2);
            this.f888b = c0882pu;
            this.f889O = d;
            this.f890P = d2;
        }

        @Override // com.boehmod.blockfront.C0129bt.e
        /* JADX INFO: renamed from: C */
        void mo660C() {
            d dVar = this.f912b;
            if (dVar.f893cB * dVar.f907cF > 0.0f) {
                ObjectListIterator it = this.f888b.m4601j().iterator();
                while (it.hasNext()) {
                    m661a((C0882pu.a) it.next());
                }
            }
            if (dVar.f895cC * dVar.f907cF > 0.0f) {
                m664D();
                if (dVar.f897Q > 0.0d) {
                    m665E();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m661a(@NotNull C0882pu.a aVar) {
            Vec2 vec2M4611c = aVar.m4611c();
            Vec2 vec2M4612d = aVar.m4612d();
            double d = vec2M4612d.x - vec2M4611c.x;
            double d2 = vec2M4612d.y - vec2M4611c.y;
            double dSqrt = Math.sqrt((d * d) + (d2 * d2));
            if (dSqrt < 1.0E-4d) {
                return;
            }
            d dVar = this.f912b;
            float fRed = FastColor.ARGB32.red(dVar.f892cE) * C0129bt.f857cy;
            float fGreen = FastColor.ARGB32.green(dVar.f892cE) * C0129bt.f857cy;
            float fBlue = FastColor.ARGB32.blue(dVar.f892cE) * C0129bt.f857cy;
            float f = dVar.f893cB * dVar.f907cF;
            double d3 = d / dSqrt;
            double d4 = d2 / dSqrt;
            if (!this.f921aw) {
                m662a(vec2M4611c.x, vec2M4611c.y, d3, d4, 0.0d, dSqrt, this.f889O, this.f890P, fRed, fGreen, fBlue, f);
                return;
            }
            double d5 = 0.0d;
            while (true) {
                double d6 = d5;
                if (d6 < dSqrt) {
                    double dMin = Math.min(dSqrt, d6 + this.f919ac);
                    double d7 = this.f889O;
                    while (true) {
                        double d8 = d7;
                        if (d8 < this.f890P) {
                            double dMin2 = Math.min(this.f890P, d8 + this.f919ac);
                            if (m663a(vec2M4611c.x, vec2M4611c.y, d3, d4, d6, dMin, d8, dMin2)) {
                                m662a(vec2M4611c.x, vec2M4611c.y, d3, d4, d6, dMin, d8, dMin2, fRed, fGreen, fBlue, f);
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
        private void m662a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, float f, float f2, float f3, float f4) {
            double d9 = d + (d3 * d5);
            double d10 = d2 + (d4 * d5);
            double d11 = d + (d3 * d6);
            double d12 = d2 + (d4 * d6);
            m693a(d9, d7, d10, f, f2, f3, f4 * m690a(d9, d7, d10));
            m693a(d11, d7, d12, f, f2, f3, f4 * m690a(d11, d7, d12));
            m693a(d11, d8, d12, f, f2, f3, f4 * m690a(d11, d8, d12));
            m693a(d9, d8, d10, f, f2, f3, f4 * m690a(d9, d8, d10));
        }

        /* JADX INFO: renamed from: a */
        private boolean m663a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            double dClamp = Mth.clamp(((this.f916Z - d) * d3) + ((this.f918ab - d2) * d4), d5, d6);
            double d9 = this.f916Z - (d + (d3 * dClamp));
            double d10 = this.f918ab - (d2 + (d4 * dClamp));
            double dClamp2 = this.f917aa - Mth.clamp(this.f917aa, d7, d8);
            double d11 = this.f912b.f902S;
            return ((d9 * d9) + (dClamp2 * dClamp2)) + (d10 * d10) < d11 * d11;
        }

        /* JADX INFO: renamed from: D */
        private void m664D() {
            ObjectListIterator it = this.f888b.m4601j().iterator();
            while (it.hasNext()) {
                C0882pu.a aVar = (C0882pu.a) it.next();
                Vec2 vec2M4611c = aVar.m4611c();
                Vec2 vec2M4612d = aVar.m4612d();
                m688c(vec2M4611c.x, this.f889O, vec2M4611c.y, vec2M4612d.x, this.f889O, vec2M4612d.y);
                m688c(vec2M4611c.x, this.f890P, vec2M4611c.y, vec2M4612d.x, this.f890P, vec2M4612d.y);
                m688c(vec2M4611c.x, this.f889O, vec2M4611c.y, vec2M4611c.x, this.f890P, vec2M4611c.y);
            }
        }

        /* JADX INFO: renamed from: E */
        private void m665E() {
            ObjectList<C0882pu.a> objectListM4601j = this.f888b.m4601j();
            double dA = m692a(this.f889O);
            while (true) {
                double d = dA;
                if (d >= this.f890P - 1.0E-4d) {
                    break;
                }
                ObjectListIterator it = objectListM4601j.iterator();
                while (it.hasNext()) {
                    C0882pu.a aVar = (C0882pu.a) it.next();
                    Vec2 vec2M4611c = aVar.m4611c();
                    Vec2 vec2M4612d = aVar.m4612d();
                    m688c(vec2M4611c.x, d, vec2M4611c.y, vec2M4612d.x, d, vec2M4612d.y);
                }
                dA = m692a(d);
            }
            ObjectListIterator it2 = objectListM4601j.iterator();
            while (it2.hasNext()) {
                C0882pu.a aVar2 = (C0882pu.a) it2.next();
                Vec2 vec2M4611c2 = aVar2.m4611c();
                Vec2 vec2M4612d2 = aVar2.m4612d();
                double d2 = vec2M4612d2.x - vec2M4611c2.x;
                double d3 = vec2M4612d2.y - vec2M4611c2.y;
                double dSqrt = Math.sqrt((d2 * d2) + (d3 * d3));
                if (dSqrt >= 1.0E-4d) {
                    double d4 = d2 / dSqrt;
                    double d5 = d3 / dSqrt;
                    double d6 = this.f919ac;
                    while (true) {
                        double d7 = d6;
                        if (d7 < dSqrt - 1.0E-4d) {
                            double d8 = ((double) vec2M4611c2.x) + (d4 * d7);
                            double d9 = ((double) vec2M4611c2.y) + (d5 * d7);
                            m688c(d8, this.f889O, d9, d8, this.f890P, d9);
                            d6 = d7 + this.f919ac;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m584a(@NotNull PoseStack poseStack, @NotNull Vec3[] vec3Arr, float f2, float f3, float f4, float f5) {
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
    public static void m585a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GameProfile gameProfile, float f2, float f3, int i) {
        ResourceLocation resourceLocationM630a = m630a(minecraft, c0623l, gameProfile);
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.blit(resourceLocationM630a, 0, 0, i, i, 8.0f, 8.0f, 8, 8, 64, 64);
        guiGraphics.blit(resourceLocationM630a, 0, 0, i, i, 40.0f, 8.0f, 8, 8, 64, 64);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m586a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, int i, int i2, float f4) {
        RenderSystem.enableBlend();
        m641a(i2);
        poseStack.pushPose();
        poseStack.translate(f2, f3, 0.0f);
        guiGraphics.blit(f876H, 0, 0, i, i, 0.0f, (int) ((((long) f4) % 61) * 256.0f), 256, 256, 256, f880cz);
        poseStack.popPose();
        RenderSystem.disableBlend();
        m642B();
    }

    /* JADX INFO: renamed from: a */
    public static void m587a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f2) {
        RenderSystem.enableBlend();
        m641a(i4);
        guiGraphics.blit(f876H, i, i2, i3, i3, 0.0f, (int) ((((long) f2) % 61) * 256.0f), 256, 256, 256, f880cz);
        m642B();
        RenderSystem.disableBlend();
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public static void m588d(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = 0.25f;
        float f9 = 0.25f / f7;
        m540b(poseStack, guiGraphics, resourceLocation, f2, f3, f4, f5);
        for (int i = 0; i < f7; i++) {
            float f10 = f8 - f9;
            m544b(poseStack, guiGraphics, resourceLocation, f2 + (f6 * i), f3, f4, f5, 0.0f, f10);
            m544b(poseStack, guiGraphics, resourceLocation, f2 - (f6 * i), f3, f4, f5, 0.0f, f10 - f9);
            f8 = 0.25f;
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m589b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        poseStack.pushPose();
        poseStack.translate(-(f4 / 2.0f), -(f5 / 2.0f), 0.0f);
        m516a(poseStack, guiGraphics, f2 - 1.0f, f3 - 1.0f, f4 + 2.0f, f5 + 2.0f, i, 0.3f);
        m516a(poseStack, guiGraphics, f2, f3, f4, f5, i, f6);
        poseStack.popPose();
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m590b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i) {
        m592c(poseStack, guiGraphics, f2, f3, f4, f5, i, FastColor.ARGB32.alpha(i) * f857cy);
    }

    /* JADX INFO: renamed from: c */
    public static void m591c(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5) {
        m593c(guiGraphics, i, i2, i3, i4, i5, FastColor.ARGB32.alpha(i5) * f857cy);
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public static void m592c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f2, float f3, float f4, float f5, int i, float f6) {
        m516a(poseStack, guiGraphics, f2 - 1.0f, f3 - 1.0f, f4 + 2.0f, f5 + 2.0f, 0, 0.3f);
        m516a(poseStack, guiGraphics, f2, f3, f4, f5, i, f6);
    }

    /* JADX INFO: renamed from: c */
    public static void m593c(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, float f2) {
        m517a(guiGraphics, i - 1, i2 - 1, i3 + 2, i4 + 2, 0, 0.3f);
        m517a(guiGraphics, i, i2, i3, i4, i5, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m594a(@NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, int i, int i2, float f2, float f3, float f4, float f5) {
        m595a(c0396gl, poseStack, guiGraphics, minecraft, livingEntity, i, i2, f2, f3, f4, f5, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m595a(@NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        C0394gj c0394gjB = livingEntity instanceof Player ? (C0394gj) c0396gl.m1150a((Player) livingEntity) : c0396gl.m1152b(livingEntity.getUUID());
        boolean zDt = c0394gjB.m1104dt();
        int iM1862as = c0394gjB.m1862as();
        boolean zIsInvisible = livingEntity.isInvisible();
        float f9 = livingEntity.yBodyRotO;
        float f10 = livingEntity.yBodyRot;
        float f11 = livingEntity.yHeadRotO;
        float f12 = livingEntity.yHeadRot;
        float f13 = livingEntity.xRotO;
        c0394gjB.m1105Y(false);
        c0394gjB.m1863m(0);
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
        c0394gjB.m1105Y(zDt);
        c0394gjB.m1863m(iM1862as);
        livingEntity.setInvisible(zIsInvisible);
    }

    /* JADX INFO: renamed from: a */
    public static void m596a(@NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, Font font, @NotNull UUID uuid, @NotNull C0292en.b bVar, int i, int i2, int i3, boolean z) {
        C0292en.a slotInfo = bVar.getSlotInfo();
        int iMo1599a = slotInfo.mo1599a(c0396gl, uuid, z);
        Component componentMo1598a = slotInfo.mo1598a(c0396gl, uuid, z);
        Component componentMo1597a = slotInfo.mo1597a(c0396gl, uuid);
        m515a(guiGraphics, i + 2, i2 + 1, 1, i3 - 2, iMo1599a);
        m470a(font, guiGraphics, componentMo1597a, i + 5, i2 + 2);
        m471a(font, guiGraphics, componentMo1598a, i + 5, (i2 + i3) - 9, iMo1599a);
    }

    /* JADX INFO: renamed from: b */
    public static void m597b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, float f2, float f3, int i, int i2) {
        int iM465t = m465t();
        float f4 = i / 2.0f;
        float f5 = f2 - f4;
        m513a(poseStack, f5 - 5.0f, f3, 5.0f, i2, iM465t, 2);
        m513a(poseStack, f2 + f4, f3, 5.0f, i2, iM465t, 4);
        m514a(poseStack, guiGraphics, f5, f3, i, i2, iM465t);
        m482c(poseStack, font, guiGraphics, component, f2, f3 + 1.5f);
    }

    /* JADX INFO: renamed from: a */
    public static void m598a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, C0555jl c0555jl, @NotNull C0555jl c0555jl2, float f2, float f3, boolean z) {
        CloudRegistry cloudRegistryA = c0623l.m2855a();
        Optional<MatchParty> party = c0555jl.getParty();
        int prestigeLevel = c0555jl2.getPrestigeLevel();
        UUID uuid = c0555jl2.getUUID();
        C0550jg inventory = c0555jl2.getInventory();
        boolean zBooleanValue = ((Boolean) party.map(matchParty -> {
            return Boolean.valueOf(matchParty.isHost(uuid));
        }).orElse(false)).booleanValue();
        MutableComponent mutableComponentAppend = C0548je.m2477a(c0555jl2).append(Component.literal(prestigeLevel > 0 ? "P" + prestigeLevel + " " : "").withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)).append(c0555jl2.m2515b());
        if (c0555jl2.m2510a() == PlayerDataType.DISPLAY) {
            mutableComponentAppend.withStyle(ChatFormatting.GRAY);
        }
        if (z) {
            mutableComponentAppend.withStyle(ChatFormatting.YELLOW);
        }
        int iWidth = font.width(mutableComponentAppend);
        m597b(poseStack, font, guiGraphics, (Component) mutableComponentAppend, f2, f3, iWidth, 10);
        CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.COIN);
        if (cloudItemStackM2487a != null) {
            CloudItem<?> cloudItem = cloudItemStackM2487a.getCloudItem(cloudRegistryA);
            if (cloudItem instanceof AbstractCloudItemCoin) {
                AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                C0564ju.m2556a(abstractCloudItemCoin).mo2310a(abstractCloudItemCoin, cloudItemStackM2487a, poseStack, minecraft, guiGraphics, (f2 - (iWidth / 2.0f)) - 5.0f, f3, 9.0f, 9.0f, 1.0f);
            }
        }
        if (zBooleanValue) {
            m490b(poseStack, font, guiGraphics, (Component) f872w.copy(), f2, f3 + 12.0f, 0.5f);
        }
        if (c0555jl2.m2510a() != PlayerDataType.DISPLAY) {
            float f4 = f2 - 8.0f;
            float f5 = (f3 - 16.0f) - 5.0f;
            ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/misc/ranks/" + c0555jl2.getRank().getTexture() + ".png");
            m530a(poseStack, guiGraphics, C0143cG.f1039aJ, f4 - 7.0f, f5 - 7.0f, 31.0f, 31.0f);
            m530a(poseStack, guiGraphics, C0143cG.f1044aO, f4, f5, 16.0f, 16.0f);
            m530a(poseStack, guiGraphics, resourceLocationM2378d, f4, f5, 16.0f, 16.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m599a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @Nullable UUID uuid, @NotNull Style style, @NotNull Collection<String> collection, float f2, float f3, float f4, float f5, int i) {
        C1093ts c1093tsM6016a;
        CloudItem<?> cloudItem;
        CloudRegistry cloudRegistryA = c0623l.m2855a();
        Optional<MatchParty> party = c0555jl.getParty();
        C0555jl c0555jlA = null;
        C0550jg inventory = null;
        C0394gj c0394gjB = null;
        if (uuid != null) {
            c0555jlA = c0396gl.mo1154a(uuid);
            inventory = c0555jlA.getInventory();
            c0394gjB = c0396gl.m1152b(uuid);
            if (uuid.equals(c0555jl.getUUID())) {
                style = Style.EMPTY;
            }
        }
        float size = f4 - (collection.size() * 30);
        int i2 = (int) f2;
        int i3 = (int) f3;
        int i4 = (int) size;
        int i5 = (int) f5;
        m517a(guiGraphics, i2, i3, i4, i5, 0, 0.5f);
        if (uuid != null) {
            ResourceLocation resourceLocationM2378d = f869F;
            CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.CARD);
            if (cloudItemStackM2487a != null && (cloudItem = cloudItemStackM2487a.getCloudItem(cloudRegistryA)) != null) {
                resourceLocationM2378d = C0532jO.m2378d("textures/gui/callingcard/" + cloudItem.getSuffixForDisplay() + ".png");
            }
            m618a(guiGraphics, i2 + 1, i3 + 1, i4 - 2, i5 - 2);
            m534a(poseStack, guiGraphics, resourceLocationM2378d, i2, i3 - 25.0f, 220.0f, 50.0f, 0.0f, 0.1f);
            guiGraphics.disableScissor();
            int i6 = 0;
            MutableComponent mutableComponentAppend = C0548je.m2477a(c0555jlA).append(c0555jlA.m2515b());
            party.ifPresent(matchParty -> {
                if (matchParty.isPresent(uuid)) {
                    mutableComponentAppend.append(" ").append(matchParty.isHost(uuid) ? f877x : f878y);
                }
            });
            PlayerRank rank = c0555jlA.getRank();
            C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(uuid);
            int color = c0872pkM4229a != null ? c0872pkM4229a.getColor() : ColorReferences.COLOR_WHITE;
            ResourceLocation resourceLocationM2378d2 = C0532jO.m2378d("textures/misc/ranks/" + rank.getTexture() + ".png");
            float f6 = f2 + 14.5f;
            float f7 = f3 + i + 0.5f;
            m536a(poseStack, guiGraphics, f867D, f6, f7, 7.0f, 7.0f, 0.0f, 1.0f, color);
            m530a(poseStack, guiGraphics, resourceLocationM2378d2, f6, f7, 7.0f, 7.0f);
            int prestigeLevel = c0555jlA.getPrestigeLevel();
            if (prestigeLevel > 0) {
                m496a(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(prestigeLevel)), f6 + 3.5f, f3 + 7.0f, ColorReferences.COLOR_WHITE, 0, 0.5f);
            }
            CloudItemStack cloudItemStackM2487a2 = inventory.m2487a(CloudItemType.COIN);
            if (cloudItemStackM2487a2 != null) {
                CloudItem<?> cloudItem2 = cloudItemStackM2487a2.getCloudItem(cloudRegistryA);
                if (cloudItem2 instanceof AbstractCloudItemCoin) {
                    AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem2;
                    C0564ju.m2556a(abstractCloudItemCoin).mo2311a(abstractCloudItemCoin, cloudItemStackM2487a2, minecraft, poseStack, guiGraphics, f2 + 24.0f + 4.0f, f3 + i + 0.1f + 4.0f, 8.0f, 8.0f, 1.0f);
                }
                i6 = 0 + 10;
            }
            int iM4290a = abstractC0863pb.m4034a(uuid).m4290a(C1062tN.f5745i.getKey(), -1);
            if (iM4290a != -1 && (c1093tsM6016a = C1093ts.m6016a(iM4290a)) != null) {
                int iM4290a2 = abstractC0863pb.m4034a(uuid).m4290a(C1062tN.f5746j.getKey(), 0);
                float f8 = (f2 + size) - f5;
                m528a(poseStack, guiGraphics, c1093tsM6016a.getIcon(), f8, f3, f5);
                MutableComponent mutableComponentWithColor = Component.translatable(c1093tsM6016a.m6004as()).withStyle(ChatFormatting.BOLD).withColor(c1093tsM6016a.m6010ce() ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID);
                if (iM4290a2 > 0) {
                    mutableComponentWithColor = mutableComponentWithColor.append(" ").append(Component.translatable("enchantment.level." + (iM4290a2 + 1)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID));
                }
                m486a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, (f8 - (font.width(mutableComponentWithColor) / 2.0f)) - 1.0f, f3 + 3.0f, 0.5f);
            }
            float f9 = f2 + 3.0f;
            float f10 = f3 + i + 0.1f;
            AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
            C0872pk c0872pkM4229a2 = abstractC0866peM4018b.m4229a(c0555jl.getUUID());
            boolean z = (c0394gjB.m1104dt() || c0394gjB.m1116r() != null) && !abstractC0866peM4018b.m4247g(uuid);
            boolean z2 = c0872pkM4229a2 != null && c0872pkM4229a2.equals(c0872pkM4229a);
            if (z && abstractC0863pb.mo4049a().shouldShow(z2)) {
                m530a(poseStack, guiGraphics, f868E, f9, f10, 8.0f, 8.0f);
            } else {
                m585a(minecraft, c0623l, poseStack, guiGraphics, c0555jlA.m2522a(), f9, f10, 8);
                abstractC0864pc.m4138a(poseStack, guiGraphics, c0394gjB, f9, f10, 8);
            }
            m468a(poseStack, font, guiGraphics, (Component) mutableComponentAppend, f2 + 25.0f + i6, f3 + i + 0.5f);
        } else {
            m468a(poseStack, font, guiGraphics, (Component) f882z.copy().withStyle(style), f2 + 2.0f, f3 + i);
        }
        float f11 = f2 + i4;
        int i7 = 0;
        for (String str : collection) {
            float f12 = f11 + (i7 * 30) + 1.0f;
            MutableComponent mutableComponentWithStyle = Component.literal(str).withStyle(style);
            m516a(poseStack, guiGraphics, f12, f3, 29.0f, f5, i7 % 2 == 0 ? 1118481 : 0, 0.5f);
            m482c(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, f12 + 15.0f, f3 + i);
            i7++;
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m600a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f2, float f3) {
        m601b(poseStack, guiGraphics, itemStack, f2, f3, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public static void m601b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, float f2, float f3, float f4) {
        RenderSystem.setupGuiFlatDiffuseLighting(f873c, f874d);
        poseStack.pushPose();
        poseStack.translate(f2 - (8.0f * f4), f3 - (8.0f * f4), 0.0f);
        poseStack.scale(f4, f4, f4);
        guiGraphics.renderItem(itemStack, 0, 0, 0, f886cC);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    public static String m602a(int i) {
        int i2 = i % 60;
        return (i / 60) + ":" + (i2 < 10 ? "0" : "") + i2;
    }

    /* JADX INFO: renamed from: a */
    public static void m603a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m604a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, boolean z) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m605a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, int i, boolean z) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, vec3.x, vec3.y, vec3.z, i, i, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m606a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull BlockPos blockPos, int i, boolean z) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, blockPos.getX(), blockPos.getY(), blockPos.getZ(), i, i, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m607a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m608a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, boolean z) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, 1.0f, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m609a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m610a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, boolean z) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, ColorReferences.COLOR_WHITE, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m611a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, int i, int i2, float f2, int i3, boolean z) {
        m612a(poseStack, camera, guiGraphics, resourceLocation, vec3.x, vec3.y, vec3.z, i, i2, f2, i3, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m612a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z) {
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
        m537a(poseStack, guiGraphics, resourceLocation, (-i) / 2, (-i2) / 2, i, i2, 0.0f, f2, i3);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m613a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z, float f3) {
        m614a(poseStack, camera, guiGraphics, resourceLocation, d2, d3, d4, i, i2, f2, i3, z, f3, false);
    }

    /* JADX INFO: renamed from: a */
    public static void m614a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, int i, int i2, float f2, int i3, boolean z, float f3, boolean z2) {
        if (f2 <= 0.0f) {
            return;
        }
        float fClamp = Mth.clamp(f3, 0.0f, 1.0f);
        int iMax = fClamp <= 0.0f ? 0 : Math.max(1, Math.round(i * fClamp));
        int i4 = z2 ? ((-i) / 2) + iMax : (-i) / 2;
        float f4 = z2 ? iMax : 0.0f;
        int i5 = z2 ? i - iMax : iMax;
        if (i5 <= 0) {
            return;
        }
        RenderSystem.depthMask(false);
        if (z) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        RenderSystem.enableBlend();
        m640a(i3, f2);
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(-0.02f, -0.02f, 0.02f);
        guiGraphics.blit(resourceLocation, i4, (-i2) / 2, i5, i2, f4, 0.0f, i5, i2, i, i2);
        poseStack.popPose();
        RenderSystem.disableBlend();
        m642B();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, int i, boolean z) {
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
        m536a(poseStack, guiGraphics, resourceLocation, (-f2) / 2.0f, (-f3) / 2.0f, f2, f3, 0.0f, f4, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m616a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, float f5, float f6) {
        m617a(poseStack, guiGraphics, resourceLocation, d2, d3, d4, f2, f3, f4, ColorReferences.COLOR_WHITE, true, f5, f6);
    }

    /* JADX INFO: renamed from: a */
    public static void m617a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, double d2, double d3, double d4, float f2, float f3, float f4, int i, boolean z, float f5, float f6) {
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
        m536a(poseStack, guiGraphics, resourceLocation, (-f2) / 2.0f, (-f3) / 2.0f, f2, f3, 0.0f, f4, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m618a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        guiGraphics.enableScissor(i, i2, i + i3, i2 + i4);
    }

    /* JADX INFO: renamed from: a */
    public static void m619a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        m623a(poseStack, font, camera, guiGraphics, component, d2, d3, d4, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: b */
    public static void m620b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        m625b(poseStack, font, camera, guiGraphics, component, d2, d3, d4, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m621a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2) {
        m623a(poseStack, font, camera, guiGraphics, component, d2, d3, d4, f2, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: b */
    public static void m622b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2) {
        m625b(poseStack, font, camera, guiGraphics, component, d2, d3, d4, f2, ColorReferences.COLOR_WHITE, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m623a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2, int i, boolean z) {
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
        m469a(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m624a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull MultiBufferSource multiBufferSource, @NotNull FormattedCharSequence formattedCharSequence, float f2, double d2, double d3, double d4, float f3, int i, boolean z) {
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(2.0f, 2.0f, 1.0f);
        poseStack.scale(-0.016f, -0.016f, 1.0f);
        poseStack.scale(f3, f3, 1.0f);
        font.drawInBatch(formattedCharSequence, (-f2) / 2.0f, 0.0f, i, false, poseStack.last().pose(), multiBufferSource, z ? Font.DisplayMode.NORMAL : Font.DisplayMode.SEE_THROUGH, 0, 15728880);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    public static void m625b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4, float f2, int i, boolean z) {
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
        m480b(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f, i);
        poseStack.popPose();
        if (!z) {
            RenderSystem.enableDepthTest();
        }
        RenderSystem.depthMask(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m626a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Component component, double d2, double d3, double d4) {
        poseStack.pushPose();
        poseStack.translate(d2, d3, d4);
        poseStack.mulPose(Axis.YP.rotationDegrees(-camera.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(camera.getXRot()));
        poseStack.scale(2.0f, 2.0f, 1.0f);
        poseStack.translate(0.0f, 0.0f, -1.0f);
        poseStack.scale(-0.016f, -0.016f, 1.0f);
        m468a(poseStack, font, guiGraphics, component, (-font.width(component)) / 2.0f, 0.0f);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: l */
    public static void m627l(@NotNull Minecraft minecraft) {
        m628b(minecraft, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public static void m628b(@NotNull Minecraft minecraft, float f2) {
        m629a(minecraft, f2, minecraft.options.getMenuBackgroundBlurriness());
    }

    /* JADX INFO: renamed from: a */
    public static void m629a(@NotNull Minecraft minecraft, float f2, int i) {
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
    public static ResourceLocation m630a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GameProfile gameProfile) {
        return m631a(minecraft, c0623l, gameProfile.getId());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m631a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull UUID uuid) {
        return c0623l.m2889a().m2464a(minecraft, uuid);
    }

    /* JADX INFO: renamed from: a */
    public static void m632a(@NotNull Camera camera, @NotNull PoseStack poseStack) {
        Vec3 position = camera.getPosition();
        poseStack.translate(-position.x, -position.y, -position.z);
    }

    /* JADX INFO: renamed from: a */
    public static void m633a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, @NotNull PoseStack poseStack, double d2, double d3, double d4) {
        m634a(clientLevel, blockRenderDispatcher, bufferSource, blockState, poseStack, d2, d3, d4, 0.0f, 0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m634a(@NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull BlockState blockState, @NotNull PoseStack poseStack, double d2, double d3, double d4, float f2, float f3, float f4) {
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
    public static void m635a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull BlockEntity blockEntity, double d2, double d3, double d4, float f2, float f3, float f4) {
        m636a(minecraft, clientLevel, poseStack, blockEntity, d2, d3, d4, f2, f3, f4, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m636a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull BlockEntity blockEntity, double d2, double d3, double d4, float f2, float f3, float f4, boolean z) {
        BlockEntityRenderer renderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
        if (renderer == null) {
            return;
        }
        if (z && (!(blockEntity instanceof C0712mj) || !((C0712mj) blockEntity).m3238ax())) {
            int viewDistance = renderer.getViewDistance();
            if (minecraft.gameRenderer.getMainCamera().getPosition().distanceToSqr(d2, d3, d4) > ((double) viewDistance) * ((double) viewDistance)) {
                return;
            }
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
    public static void m637a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0010G c0010g, float f2, float f3, float f4, boolean z, boolean z2, float f5) {
        Window window = Minecraft.getInstance().getWindow();
        double width = ((double) window.getWidth()) / ((double) guiGraphics.guiWidth());
        double height = ((double) window.getHeight()) / ((double) guiGraphics.guiHeight());
        if (z) {
            m638a(poseStack, guiGraphics, c0010g.m37e(), f2, f3, f4, width, height);
        }
        if (z2) {
            m638a(poseStack, guiGraphics, c0010g.m33a(), f2, ((f3 - 8.0f) - f5) + 2.0f, f4, width, height);
            m638a(poseStack, guiGraphics, c0010g.m34b(), f2, ((f3 + 8.0f) + f5) - 2.0f, f4, width, height);
            m638a(poseStack, guiGraphics, c0010g.m35c(), ((f2 - 8.0f) - f5) + 2.0f, f3, f4, width, height);
            m638a(poseStack, guiGraphics, c0010g.m36d(), ((f2 + 8.0f) + f5) - 2.0f, f3, f4, width, height);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m638a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2, float f3, float f4, double d2, double d3) {
        m534a(poseStack, guiGraphics, resourceLocation, (float) (Math.round(((double) (f2 - 8.0f)) * d2) / d2), (float) (Math.round(((double) (f3 - 8.0f)) * d3) / d3), 16.0f, 16.0f, 0.0f, f4);
    }

    /* JADX INFO: renamed from: a */
    public static void m639a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull LocalPlayer localPlayer, float f2, float f3) {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        if (minecraft.options.attackIndicator().get() == AttackIndicatorStatus.CROSSHAIR) {
            float attackStrengthScale = localPlayer.getAttackStrengthScale(0.0f);
            float f4 = (f3 - 7.0f) + 24.0f;
            float f5 = f2 - 8.0f;
            if (attackStrengthScale < 1.0f) {
                poseStack.translate(f5, f4, 0.0f);
                guiGraphics.blitSprite(f858z, 0, 0, 16, 4);
                guiGraphics.blitSprite(f859A, 16, 4, 0, 0, 0, 0, (int) (attackStrengthScale * 17.0f), 4);
                poseStack.translate(-f5, -f4, 0.0f);
            }
        }
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
    }

    /* JADX INFO: renamed from: a */
    public static void m640a(int i, float f2) {
        RenderSystem.setShaderColor(FastColor.ARGB32.red(i) * f857cy, FastColor.ARGB32.green(i) * f857cy, FastColor.ARGB32.blue(i) * f857cy, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m641a(int i) {
        RenderSystem.setShaderColor(FastColor.ARGB32.red(i) * f857cy, FastColor.ARGB32.green(i) * f857cy, FastColor.ARGB32.blue(i) * f857cy, 1.0f);
    }

    /* JADX INFO: renamed from: B */
    public static void m642B() {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static void m643a(@NotNull C0842pG c0842pG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f2) {
        if (clientLevel.clip(new ClipContext(localPlayer.getEyePosition(), c0842pG.f4827c, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.MISS) {
            float fM644a = m644a(c0842pG, localPlayer);
            float f3 = f2 + ((float) (c0842pG.f4827c.x + c0842pG.f4827c.y + c0842pG.f4827c.z));
            float fSin = Mth.sin(f3 / 15.0f);
            float fSin2 = fM644a * (1.5f + Mth.sin(f3 / 5.0f));
            if (fSin2 < 0.0f) {
                fSin2 = 0.0f;
            }
            m612a(poseStack, camera, guiGraphics, c0842pG.m3872A(), c0842pG.f4827c.x, c0842pG.f4827c.y + ((double) (0.15f * fSin)), c0842pG.f4827c.z, 32, 32, fSin2, ColorReferences.COLOR_WHITE_SOLID, true);
        }
    }

    /* JADX INFO: renamed from: a */
    private static float m644a(@NotNull C0842pG c0842pG, @NotNull LocalPlayer localPlayer) {
        float x = (float) (c0842pG.f4827c.x - localPlayer.getX());
        float y = (float) (c0842pG.f4827c.y - localPlayer.getY());
        float z = (float) (c0842pG.f4827c.z - localPlayer.getZ());
        float fSqrt = Mth.sqrt((x * x) + (y * y) + (z * z));
        float f2 = (fSqrt * 100.0f) / 8.0f;
        if (fSqrt > 8.0f) {
            f2 = 200.0f - f2;
        }
        return 0.01f * f2;
    }

    /* JADX INFO: renamed from: a */
    public static void m645a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, int i, int i2, float f2) {
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
        m515a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        m549c(poseStack, guiGraphics, resourceLocation, i5, i6, i4, i3, 1.2f, 0.5f);
        m531a(poseStack, guiGraphics, f870G, 0, 0, i, i2);
        m628b(minecraft, f2);
        m467a(poseStack, guiGraphics, 5, 5, i - 10, i2 - 10);
    }

    /* JADX INFO: renamed from: a */
    public static int m646a(int i, int i2, double d2) {
        double dClamp = Math.clamp(d2, 0.0d, 1.0d);
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        int iRound = (int) Math.round(((double) i3) + (((double) (((i2 >> 16) & 255) - i3)) * dClamp));
        int iRound2 = (int) Math.round(((double) i4) + (((double) (((i2 >> 8) & 255) - i4)) * dClamp));
        return (iRound << 16) | (iRound2 << 8) | ((int) Math.round(((double) i5) + (((double) ((i2 & 255) - i5)) * dClamp)));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bt$f */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bt$f.class */
    public static final class f extends Record {

        /* JADX INFO: renamed from: cG */
        private final float f925cG;

        /* JADX INFO: renamed from: cH */
        private final float f926cH;

        /* JADX INFO: renamed from: ax */
        private final boolean f927ax;

        /* JADX INFO: renamed from: ay */
        private final boolean f928ay;

        /* JADX INFO: renamed from: cI */
        private final float f929cI;

        /* JADX INFO: renamed from: af */
        private final double f930af;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "screenX;screenY;isOnScreen;isBehindCamera;directionAngle;distance", "FIELD:Lcom/boehmod/blockfront/bt$f;->cG:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->cH:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->ax:Z", "FIELD:Lcom/boehmod/blockfront/bt$f;->ay:Z", "FIELD:Lcom/boehmod/blockfront/bt$f;->cI:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->af:D").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "screenX;screenY;isOnScreen;isBehindCamera;directionAngle;distance", "FIELD:Lcom/boehmod/blockfront/bt$f;->cG:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->cH:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->ax:Z", "FIELD:Lcom/boehmod/blockfront/bt$f;->ay:Z", "FIELD:Lcom/boehmod/blockfront/bt$f;->cI:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->af:D").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "screenX;screenY;isOnScreen;isBehindCamera;directionAngle;distance", "FIELD:Lcom/boehmod/blockfront/bt$f;->cG:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->cH:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->ax:Z", "FIELD:Lcom/boehmod/blockfront/bt$f;->ay:Z", "FIELD:Lcom/boehmod/blockfront/bt$f;->cI:F", "FIELD:Lcom/boehmod/blockfront/bt$f;->af:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: h */
        public float m694h() {
            return this.f925cG;
        }

        /* JADX INFO: renamed from: i */
        public float m695i() {
            return this.f926cH;
        }

        /* JADX INFO: renamed from: o */
        public boolean m696o() {
            return this.f927ax;
        }

        /* JADX INFO: renamed from: p */
        public boolean m697p() {
            return this.f928ay;
        }

        /* JADX INFO: renamed from: j */
        public float m698j() {
            return this.f929cI;
        }

        /* JADX INFO: renamed from: o */
        public double m699o() {
            return this.f930af;
        }

        public f(float f, float f2, boolean z, boolean z2, float f3, double d) {
            this.f925cG = f;
            this.f926cH = f2;
            this.f927ax = z;
            this.f928ay = z2;
            this.f929cI = f3;
            this.f930af = d;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m647a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2) {
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
    public static f m648a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3) {
        return m647a(vec3, camera, i, i2, i3, Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m649a(@NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2) {
        return m648a(vec3, camera, i, i2, 20);
    }

    /* JADX INFO: renamed from: a */
    public static void m650a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2) {
        m653a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i3, 1.0f, ColorReferences.COLOR_WHITE, 20, false, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m651a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, float f2, float f3) {
        m653a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i3, f2, ColorReferences.COLOR_WHITE, 20, false, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m652a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, float f3) {
        m653a(poseStack, guiGraphics, resourceLocation, vec3, camera, i, i2, i3, i4, f2, i5, 20, false, f3);
    }

    /* JADX INFO: renamed from: a */
    public static void m653a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, int i6, boolean z, float f3) {
        f fVarM647a = m647a(vec3, camera, i, i2, i6, f3);
        float f4 = (fVarM647a.f927ax || !z) ? 0.0f : fVarM647a.f929cI + 90.0f;
        poseStack.pushPose();
        poseStack.translate(fVarM647a.f925cG, fVarM647a.f926cH, 0.0f);
        m547b(poseStack, guiGraphics, resourceLocation, 0, 0, i3, i4, f4, f2, i5);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static f m654a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3, @NotNull Camera camera, int i, int i2, int i3, int i4, float f2, int i5, int i6, boolean z, float f3) {
        f fVarM647a = m647a(vec3, camera, i, i2, i6, f3);
        m547b(poseStack, guiGraphics, resourceLocation, (int) fVarM647a.f925cG, (int) fVarM647a.f926cH, i3, i4, (fVarM647a.f927ax || !z) ? 0.0f : fVarM647a.f929cI + 90.0f, f2, i5);
        return fVarM647a;
    }

    /* JADX INFO: renamed from: a */
    public static void m655a(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation resourceLocation, float f2) {
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
