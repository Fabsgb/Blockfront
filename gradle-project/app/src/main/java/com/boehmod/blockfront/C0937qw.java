package com.boehmod.blockfront;

import com.boehmod.blockfront.cloud.connection.ModConnection;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qw.class */
public class C0937qw extends AbstractC0858pW {

    /* JADX INFO: renamed from: dV */
    @NotNull
    private static final ResourceLocation f5142dV = C0532jO.m2378d("textures/misc/debug/mapeffect/falling_artillery.png");

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final MapCodec<C0937qw> f5143m = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4600D.fieldOf("startPos").forGetter(c0937qw -> {
            return c0937qw.f5145l;
        }), C0859pX.f4600D.fieldOf("endPos").forGetter(c0937qw2 -> {
            return c0937qw2.f5146m;
        }), Codec.INT.optionalFieldOf("artilleryTimeMax", Integer.valueOf(ModConnection.CONNECT_TIME_MAX_TICKS)).forGetter(c0937qw3 -> {
            return Integer.valueOf(c0937qw3.f5144pZ);
        })).apply(instance, (vec2, vec3, num) -> {
            C0937qw c0937qw4 = new C0937qw(vec2, vec3);
            c0937qw4.f5144pZ = Math.max(1, num.intValue());
            return c0937qw4;
        });
    });

    /* JADX INFO: renamed from: pZ */
    private int f5144pZ;

    /* JADX INFO: renamed from: l */
    private Vec2 f5145l;

    /* JADX INFO: renamed from: m */
    private Vec2 f5146m;

    /* JADX INFO: renamed from: qa */
    private int f5147qa;

    public C0937qw() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    public C0937qw(@NotNull Vec2 vec2, @NotNull Vec2 vec3) {
        this.f5144pZ = ModConnection.CONNECT_TIME_MAX_TICKS;
        this.f5147qa = ThreadLocalRandom.current().nextInt(this.f5144pZ);
        this.f5145l = vec2;
        this.f5146m = vec3;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5147qa;
        this.f5147qa = i - 1;
        if (i <= 0) {
            this.f5147qa = randomSource.nextInt(this.f5144pZ);
            m5083a(randomSource, clientLevel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5083a(@NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        Vec2 vec2 = new Vec2(this.f5145l.x + (randomSource.nextFloat() * (this.f5146m.x - this.f5145l.x)), this.f5145l.y + (randomSource.nextFloat() * (this.f5146m.y - this.f5145l.y)));
        if (clientLevel.isLoaded(new BlockPos((int) vec2.x, 255, (int) vec2.y))) {
            Vec3 vec3 = new Vec3(vec2.x, 255.0d, vec2.y);
            C0779nx c0779nxCreate = ((EntityType) C1307xu.f7619kX.get()).create(clientLevel);
            if (c0779nxCreate != null) {
                c0779nxCreate.mo3119a(vec3, 2.0f, new ItemStack((ItemLike) C1308xv.f7836mZ.get()), 0.0f, 0.0f);
                c0779nxCreate.setDeltaMovement(0.0d, -1.0d, 0.0d);
                c0779nxCreate.setPos(vec3.x, vec3.y, vec3.z);
                C0490iZ.m2213a((Entity) c0779nxCreate, clientLevel);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.f5145l.x, 255.0d, this.f5145l.y, this.f5146m.x, 255.0d, this.f5146m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0934qt(Component.literal("Start Position"), () -> {
            return this.f5145l;
        }, vec2 -> {
            this.f5145l = vec2;
        }));
        objectArrayList.add(new C0934qt(Component.literal("End Position"), () -> {
            return this.f5146m;
        }, vec3 -> {
            this.f5146m = vec3;
        }));
        objectArrayList.add(new C0930qp(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.f5144pZ);
        }, num -> {
            this.f5144pZ = num.intValue();
        }, 1, 72000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Falling Artillery: " + this.f5145l.x + ", " + this.f5145l.y + " -> " + this.f5146m.x + ", " + this.f5146m.y));
        list.add(Component.literal("Artillery: next strike in " + this.f5147qa + " / " + this.f5144pZ + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5142dV;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        this.f5147qa = randomSource.nextInt(this.f5144pZ);
    }
}
