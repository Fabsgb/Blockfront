package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pA.class */
public abstract class pA {

    @NotNull
    private static final ResourceLocation dV = C0265jv.d("textures/misc/debug/mapeffect/default.png");

    @NotNull
    public UUID y;

    @NotNull
    public Vec3 c;

    @Nullable
    public String bW;
    public boolean gk;
    public boolean gl;

    @Nullable
    private transient AABB h;

    @Nullable
    private transient Vec3 O;

    public abstract void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set);

    @OnlyIn(Dist.CLIENT)
    public abstract void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f);

    public pA() {
        this.y = UUID.randomUUID();
        this.c = Vec3.ZERO;
        this.bW = null;
        this.gk = true;
        this.gl = true;
    }

    public pA(@NotNull Vec3 vec3) {
        this.y = UUID.randomUUID();
        this.c = Vec3.ZERO;
        this.bW = null;
        this.gk = true;
        this.gl = true;
        this.c = vec3;
    }

    @NotNull
    public Vec3 c() {
        return this.c;
    }

    @NotNull
    public AABB i() {
        if (this.h == null || this.O != this.c) {
            this.O = this.c;
            this.h = AABB.ofSize(this.c, 1.0d, 1.0d, 1.0d);
        }
        return this.h;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public ResourceLocation x() {
        return dV;
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull sY sYVar) {
    }

    public void b(@NotNull sX sXVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.lines());
        AABB aabbI = i();
        AABB aabbInflate = aabbI.inflate(-0.019999999552965164d);
        int i = C0378o.b(this.y) ? ColorReferences.COLOR_MAP_EFFECT_REFERENCE : ColorReferences.COLOR_WHITE;
        a(poseStack, buffer, aabbI, i);
        if (this.gl) {
            a(poseStack, buffer, aabbInflate, 9633658);
        } else {
            LevelRenderer.renderLineBox(poseStack, buffer, aabbInflate, 1.0f, 0.0f, 0.0f, 1.0f);
        }
        C0040bk.a(poseStack, camera, guiGraphics, x(), this.c, 32, 32, 1.0f, i, false);
        if (this instanceof pJ) {
            Vec3 vec3Normalize = ((pJ) this).m().normalize();
            Vec3 vec3Add = this.c.add(vec3Normalize.scale(2.0d));
            C0040bk.a(camera, poseStack, this.c, vec3Add, 1.0f, 16776960);
            Vec3 vec3Normalize2 = vec3Normalize.cross(Math.abs(vec3Normalize.y) < 0.99d ? new Vec3(0.0d, 1.0d, 0.0d) : new Vec3(1.0d, 0.0d, 0.0d)).normalize();
            Vec3 vec3Normalize3 = vec3Normalize2.cross(vec3Normalize).normalize();
            Vec3 vec3Scale = vec3Normalize.scale(-0.4000000059604645d);
            C0040bk.a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize3.scale(0.20000000298023224d)), 1.0f, 16776960);
            C0040bk.a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize3.scale(-0.20000000298023224d)), 1.0f, 16776960);
            C0040bk.a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize2.scale(0.20000000298023224d)), 1.0f, 16776960);
            C0040bk.a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize2.scale(-0.20000000298023224d)), 1.0f, 16776960);
        }
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        MutableComponent mutableComponentWithStyle;
        MutableComponent mutableComponentWithStyle2;
        String strA;
        String strA2 = pC.a(getClass());
        if (C0378o.b(this.y) && (strA = C0378o.a(this.y)) != null) {
            MutableComponent mutableComponentWithStyle3 = Component.literal(strA).withStyle(ChatFormatting.GRAY);
            list.add(Component.literal("Referenced Map Effect").withColor(ColorReferences.COLOR_MAP_EFFECT_REFERENCE));
            list.add(Component.literal("Ref: ").withColor(ColorReferences.COLOR_MAP_EFFECT_REFERENCE).append(mutableComponentWithStyle3));
            list.add(Component.empty());
        }
        list.add(Component.literal("Type: ").append(Component.literal(strA2).withStyle(ChatFormatting.GRAY)));
        list.add(Component.empty());
        if (this.gl) {
            mutableComponentWithStyle = Component.literal("True").withColor(9633658);
        } else {
            mutableComponentWithStyle = Component.literal("False").withStyle(ChatFormatting.RED);
        }
        list.add(Component.literal("Currently Enabled: ").append(mutableComponentWithStyle));
        list.add(Component.empty());
        if (this.gk) {
            mutableComponentWithStyle2 = Component.literal("True").withColor(9633658);
        } else {
            mutableComponentWithStyle2 = Component.literal("False").withStyle(ChatFormatting.RED);
        }
        list.add(Component.literal("Starts Enabled: ").append(mutableComponentWithStyle2));
        if (this.bW != null) {
            list.add(Component.literal("Unique Effect ID: ").append(Component.literal(this.bW).withStyle(ChatFormatting.GRAY)));
            list.add(Component.empty());
        }
        list.add(Component.literal(String.format("Position: [%.2f, %.2f, %.2f]", Double.valueOf(this.c.x), Double.valueOf(this.c.y), Double.valueOf(this.c.z))));
    }

    @OnlyIn(Dist.CLIENT)
    public boolean bw() {
        return false;
    }

    @OverridingMethodsMustInvokeSuper
    public void cA() {
        this.gl = this.gk;
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        this.gl = this.gk;
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull AABB aabb, int i) {
        LevelRenderer.renderLineBox(poseStack, vertexConsumer, aabb, ((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, 1.0f);
    }

    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new pY(Component.literal("Position"), () -> {
            return this.c;
        }, vec3 -> {
            this.c = vec3;
        }));
        objectArrayList.add(new pO(Component.literal("Enabled by Default"), () -> {
            return Boolean.valueOf(this.gk);
        }, bool -> {
            this.gk = bool.booleanValue();
        }));
        return objectArrayList;
    }
}
