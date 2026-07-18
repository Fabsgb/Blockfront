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

/* JADX INFO: renamed from: com.boehmod.blockfront.pA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pA.class */
public abstract class AbstractC0835pA {

    /* JADX INFO: renamed from: dV */
    @NotNull
    private static final ResourceLocation f4462dV = C0564jv.m2555d("textures/misc/debug/mapeffect/default.png");

    /* JADX INFO: renamed from: y */
    @NotNull
    public UUID f4463y;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Vec3 f4464c;

    /* JADX INFO: renamed from: bW */
    @Nullable
    public String f4465bW;

    /* JADX INFO: renamed from: gk */
    public boolean f4466gk;

    /* JADX INFO: renamed from: gl */
    public boolean f4467gl;

    /* JADX INFO: renamed from: h */
    @Nullable
    private transient AABB f4468h;

    /* JADX INFO: renamed from: O */
    @Nullable
    private transient Vec3 f4469O;

    /* JADX INFO: renamed from: a */
    public abstract void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f);

    public AbstractC0835pA() {
        this.f4463y = UUID.randomUUID();
        this.f4464c = Vec3.ZERO;
        this.f4465bW = null;
        this.f4466gk = true;
        this.f4467gl = true;
    }

    public AbstractC0835pA(@NotNull Vec3 vec3) {
        this.f4463y = UUID.randomUUID();
        this.f4464c = Vec3.ZERO;
        this.f4465bW = null;
        this.f4466gk = true;
        this.f4467gl = true;
        this.f4464c = vec3;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m4214c() {
        return this.f4464c;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public AABB m4215i() {
        if (this.f4468h == null || this.f4469O != this.f4464c) {
            this.f4469O = this.f4464c;
            this.f4468h = AABB.ofSize(this.f4464c, 1.0d, 1.0d, 1.0d);
        }
        return this.f4468h;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4462dV;
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4218a(@NotNull Minecraft minecraft, @NotNull C1018sY c1018sY) {
    }

    /* JADX INFO: renamed from: b */
    public void mo4219b(@NotNull C1017sX c1017sX) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.lines());
        AABB aabbM4215i = m4215i();
        AABB aabbInflate = aabbM4215i.inflate(-0.019999999552965164d);
        int i = C0781o.m3544b(this.f4463y) ? ColorReferences.COLOR_MAP_EFFECT_REFERENCE : ColorReferences.COLOR_WHITE;
        m4226a(poseStack, buffer, aabbM4215i, i);
        if (this.f4467gl) {
            m4226a(poseStack, buffer, aabbInflate, 9633658);
        } else {
            LevelRenderer.renderLineBox(poseStack, buffer, aabbInflate, 1.0f, 0.0f, 0.0f, 1.0f);
        }
        C0119bk.m511a(poseStack, camera, guiGraphics, mo4216x(), this.f4464c, 32, 32, 1.0f, i, false);
        if (this instanceof InterfaceC0844pJ) {
            Vec3 vec3Normalize = ((InterfaceC0844pJ) this).mo4276m().normalize();
            Vec3 vec3Add = this.f4464c.add(vec3Normalize.scale(2.0d));
            C0119bk.m474a(camera, poseStack, this.f4464c, vec3Add, 1.0f, 16776960);
            Vec3 vec3Normalize2 = vec3Normalize.cross(Math.abs(vec3Normalize.y) < 0.99d ? new Vec3(0.0d, 1.0d, 0.0d) : new Vec3(1.0d, 0.0d, 0.0d)).normalize();
            Vec3 vec3Normalize3 = vec3Normalize2.cross(vec3Normalize).normalize();
            Vec3 vec3Scale = vec3Normalize.scale(-0.4000000059604645d);
            C0119bk.m474a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize3.scale(0.20000000298023224d)), 1.0f, 16776960);
            C0119bk.m474a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize3.scale(-0.20000000298023224d)), 1.0f, 16776960);
            C0119bk.m474a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize2.scale(0.20000000298023224d)), 1.0f, 16776960);
            C0119bk.m474a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize2.scale(-0.20000000298023224d)), 1.0f, 16776960);
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        MutableComponent mutableComponentWithStyle;
        MutableComponent mutableComponentWithStyle2;
        String strM3545a;
        String strM4262a = C0837pC.m4262a(getClass());
        if (C0781o.m3544b(this.f4463y) && (strM3545a = C0781o.m3545a(this.f4463y)) != null) {
            MutableComponent mutableComponentWithStyle3 = Component.literal(strM3545a).withStyle(ChatFormatting.GRAY);
            list.add(Component.literal("Referenced Map Effect").withColor(ColorReferences.COLOR_MAP_EFFECT_REFERENCE));
            list.add(Component.literal("Ref: ").withColor(ColorReferences.COLOR_MAP_EFFECT_REFERENCE).append(mutableComponentWithStyle3));
            list.add(Component.empty());
        }
        list.add(Component.literal("Type: ").append(Component.literal(strM4262a).withStyle(ChatFormatting.GRAY)));
        list.add(Component.empty());
        if (this.f4467gl) {
            mutableComponentWithStyle = Component.literal("True").withColor(9633658);
        } else {
            mutableComponentWithStyle = Component.literal("False").withStyle(ChatFormatting.RED);
        }
        list.add(Component.literal("Currently Enabled: ").append(mutableComponentWithStyle));
        list.add(Component.empty());
        if (this.f4466gk) {
            mutableComponentWithStyle2 = Component.literal("True").withColor(9633658);
        } else {
            mutableComponentWithStyle2 = Component.literal("False").withStyle(ChatFormatting.RED);
        }
        list.add(Component.literal("Starts Enabled: ").append(mutableComponentWithStyle2));
        if (this.f4465bW != null) {
            list.add(Component.literal("Unique Effect ID: ").append(Component.literal(this.f4465bW).withStyle(ChatFormatting.GRAY)));
            list.add(Component.empty());
        }
        list.add(Component.literal(String.format("Position: [%.2f, %.2f, %.2f]", Double.valueOf(this.f4464c.x), Double.valueOf(this.f4464c.y), Double.valueOf(this.f4464c.z))));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return false;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        this.f4467gl = this.f4466gk;
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        this.f4467gl = this.f4466gk;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4226a(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull AABB aabb, int i) {
        LevelRenderer.renderLineBox(poseStack, vertexConsumer, aabb, ((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, 1.0f);
    }

    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0859pY(Component.literal("Position"), () -> {
            return this.f4464c;
        }, vec3 -> {
            this.f4464c = vec3;
        }));
        objectArrayList.add(new C0849pO(Component.literal("Enabled by Default"), () -> {
            return Boolean.valueOf(this.f4466gk);
        }, bool -> {
            this.f4466gk = bool.booleanValue();
        }));
        return objectArrayList;
    }
}
