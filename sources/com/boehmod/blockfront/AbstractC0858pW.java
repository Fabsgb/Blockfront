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

/* JADX INFO: renamed from: com.boehmod.blockfront.pW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pW.class */
public abstract class AbstractC0858pW {

    /* JADX INFO: renamed from: dT */
    @NotNull
    private static final ResourceLocation f4591dT = C0532jO.m2378d("textures/misc/debug/mapeffect/default.png");

    /* JADX INFO: renamed from: y */
    @NotNull
    public UUID f4592y;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Vec3 f4593c;

    /* JADX INFO: renamed from: cg */
    @Nullable
    public String f4594cg;

    /* JADX INFO: renamed from: gE */
    public boolean f4595gE;

    /* JADX INFO: renamed from: gF */
    public boolean f4596gF;

    /* JADX INFO: renamed from: h */
    @Nullable
    private transient AABB f4597h;

    /* JADX INFO: renamed from: P */
    @Nullable
    private transient Vec3 f4598P;

    /* JADX INFO: renamed from: a */
    public abstract void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f);

    public AbstractC0858pW() {
        this.f4592y = UUID.randomUUID();
        this.f4593c = Vec3.ZERO;
        this.f4594cg = null;
        this.f4595gE = true;
        this.f4596gF = true;
    }

    public AbstractC0858pW(@NotNull Vec3 vec3) {
        this.f4592y = UUID.randomUUID();
        this.f4593c = Vec3.ZERO;
        this.f4594cg = null;
        this.f4595gE = true;
        this.f4596gF = true;
        this.f4593c = vec3;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m3949c() {
        return this.f4593c;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public AABB m3950i() {
        if (this.f4597h == null || this.f4598P != this.f4593c) {
            this.f4598P = this.f4593c;
            this.f4597h = AABB.ofSize(this.f4593c, 1.0d, 1.0d, 1.0d);
        }
        return this.f4597h;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4591dT;
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3953a(@NotNull Minecraft minecraft, @NotNull C1096tv c1096tv) {
    }

    /* JADX INFO: renamed from: b */
    public void mo3954b(@NotNull C1095tu c1095tu) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.lines());
        AABB aabbM3950i = m3950i();
        AABB aabbInflate = aabbM3950i.inflate(-0.019999999552965164d);
        int i = C0782o.m3660b(this.f4592y) ? ColorReferences.COLOR_MAP_EFFECT_REFERENCE : ColorReferences.COLOR_WHITE;
        m3957a(poseStack, buffer, aabbM3950i, i);
        if (this.f4596gF) {
            m3957a(poseStack, buffer, aabbInflate, 9633658);
        } else {
            LevelRenderer.renderLineBox(poseStack, buffer, aabbInflate, 1.0f, 0.0f, 0.0f, 1.0f);
        }
        C0129bt.m611a(poseStack, camera, guiGraphics, mo3951y(), this.f4593c, 32, 32, 1.0f, i, false);
        if (this instanceof InterfaceC0920qf) {
            Vec3 vec3Normalize = ((InterfaceC0920qf) this).mo4687n().normalize();
            Vec3 vec3Add = this.f4593c.add(vec3Normalize.scale(2.0d));
            C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add, 1.0f, 16776960);
            Vec3 vec3Normalize2 = vec3Normalize.cross(Math.abs(vec3Normalize.y) < 0.99d ? new Vec3(0.0d, 1.0d, 0.0d) : new Vec3(1.0d, 0.0d, 0.0d)).normalize();
            Vec3 vec3Normalize3 = vec3Normalize2.cross(vec3Normalize).normalize();
            Vec3 vec3Scale = vec3Normalize.scale(-0.4000000059604645d);
            C0129bt.m574a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize3.scale(0.20000000298023224d)), 1.0f, 16776960);
            C0129bt.m574a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize3.scale(-0.20000000298023224d)), 1.0f, 16776960);
            C0129bt.m574a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize2.scale(0.20000000298023224d)), 1.0f, 16776960);
            C0129bt.m574a(camera, poseStack, vec3Add, vec3Add.add(vec3Scale).add(vec3Normalize2.scale(-0.20000000298023224d)), 1.0f, 16776960);
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        MutableComponent mutableComponentWithStyle;
        MutableComponent mutableComponentWithStyle2;
        String strM3661a;
        String strM3992a = C0860pY.m3992a(getClass());
        if (C0782o.m3660b(this.f4592y) && (strM3661a = C0782o.m3661a(this.f4592y)) != null) {
            MutableComponent mutableComponentWithStyle3 = Component.literal(strM3661a).withStyle(ChatFormatting.GRAY);
            list.add(Component.literal("Referenced Map Effect").withColor(ColorReferences.COLOR_MAP_EFFECT_REFERENCE));
            list.add(Component.literal("Ref: ").withColor(ColorReferences.COLOR_MAP_EFFECT_REFERENCE).append(mutableComponentWithStyle3));
            list.add(Component.empty());
        }
        list.add(Component.literal("Type: ").append(Component.literal(strM3992a).withStyle(ChatFormatting.GRAY)));
        list.add(Component.empty());
        if (this.f4596gF) {
            mutableComponentWithStyle = Component.literal("True").withColor(9633658);
        } else {
            mutableComponentWithStyle = Component.literal("False").withStyle(ChatFormatting.RED);
        }
        list.add(Component.literal("Currently Enabled: ").append(mutableComponentWithStyle));
        list.add(Component.empty());
        if (this.f4595gE) {
            mutableComponentWithStyle2 = Component.literal("True").withColor(9633658);
        } else {
            mutableComponentWithStyle2 = Component.literal("False").withStyle(ChatFormatting.RED);
        }
        list.add(Component.literal("Starts Enabled: ").append(mutableComponentWithStyle2));
        if (this.f4594cg != null) {
            list.add(Component.literal("Unique Effect ID: ").append(Component.literal(this.f4594cg).withStyle(ChatFormatting.GRAY)));
            list.add(Component.empty());
        }
        list.add(Component.literal(String.format("Position: [%.2f, %.2f, %.2f]", Double.valueOf(this.f4593c.x), Double.valueOf(this.f4593c.y), Double.valueOf(this.f4593c.z))));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return false;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        this.f4596gF = this.f4595gE;
    }

    @OverridingMethodsMustInvokeSuper
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        this.f4596gF = this.f4595gE;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m3957a(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull AABB aabb, int i) {
        LevelRenderer.renderLineBox(poseStack, vertexConsumer, aabb, ((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, 1.0f);
    }

    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0935qu(Component.literal("Position"), () -> {
            return this.f4593c;
        }, vec3 -> {
            this.f4593c = vec3;
        }));
        objectArrayList.add(new C0925qk(Component.literal("Enabled by Default"), () -> {
            return Boolean.valueOf(this.f4595gE);
        }, bool -> {
            this.f4595gE = bool.booleanValue();
        }));
        return objectArrayList;
    }
}
