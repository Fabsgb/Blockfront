package com.boehmod.blockfront;

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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qz.class */
public class C0940qz extends AbstractC0858pW {

    /* JADX INFO: renamed from: ea */
    @NotNull
    private static final ResourceLocation f5202ea = C0532jO.m2378d("textures/misc/debug/mapeffect/lightning.png");

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final MapCodec<C0940qz> f5203p = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4600D.fieldOf("startPos").forGetter(c0940qz -> {
            return c0940qz.f5205l;
        }), C0859pX.f4600D.fieldOf("endPos").forGetter(c0940qz2 -> {
            return c0940qz2.f5206m;
        }), Codec.INT.optionalFieldOf("lightningTimeMax", Integer.valueOf(C1062tN.f5737tA)).forGetter(c0940qz3 -> {
            return Integer.valueOf(c0940qz3.f5204qh);
        })).apply(instance, (vec2, vec3, num) -> {
            C0940qz c0940qz4 = new C0940qz(vec2, vec3);
            c0940qz4.f5204qh = Math.max(1, num.intValue());
            return c0940qz4;
        });
    });

    /* JADX INFO: renamed from: qh */
    private int f5204qh;

    /* JADX INFO: renamed from: l */
    @NotNull
    private Vec2 f5205l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private Vec2 f5206m;

    /* JADX INFO: renamed from: qi */
    private int f5207qi;

    public C0940qz(@NotNull Vec2 vec2, @NotNull Vec2 vec3) {
        this.f5204qh = C1062tN.f5737tA;
        this.f5207qi = ThreadLocalRandom.current().nextInt(this.f5204qh);
        this.f5205l = vec2;
        this.f5206m = vec3;
    }

    public C0940qz() {
        this(Vec2.ZERO, Vec2.ZERO);
    }

    /* JADX INFO: renamed from: a */
    private void m5159a(@NotNull RandomSource randomSource, @NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        Vec2 vec2 = new Vec2(this.f5205l.x + (randomSource.nextFloat() * (this.f5206m.x - this.f5205l.x)), this.f5205l.y + (randomSource.nextFloat() * (this.f5206m.y - this.f5205l.y)));
        Vec3 bottomCenter = C0875pn.m4478a(serverLevel, new BlockPos((int) vec2.x, 0, (int) vec2.y)).getBottomCenter();
        C0875pn.m4353c((Level) serverLevel, bottomCenter);
        Vec3 vec3Add = bottomCenter.add(0.0d, 5.0d, 0.0d);
        C0875pn.m4377a((Level) serverLevel, vec3Add, (SoundEvent) C1312xz.f8696Dp.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0875pn.m4377a((Level) serverLevel, vec3Add, (SoundEvent) C1312xz.f8697Dq.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0875pn.m4377a((Level) serverLevel, vec3Add, (SoundEvent) C1312xz.f8698Dr.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C0875pn.m4377a((Level) serverLevel, vec3Add, (SoundEvent) C1312xz.f8765EG.get(), SoundSource.AMBIENT, 5.0f, 1.0f);
        C1169vO.m6646a(new C1213wF(2), abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        int i = this.f5207qi;
        this.f5207qi = i - 1;
        if (i <= 0) {
            this.f5207qi = randomSource.nextInt(Math.max(1, this.f5204qh));
            m5159a(randomSource, serverLevel, abstractC0863pb);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        DebugRenderer.renderFilledBox(poseStack, bufferSource, this.f5205l.x, 255.0d, this.f5205l.y, this.f5206m.x, 255.0d, this.f5206m.y, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0934qt(Component.literal("Start Position"), () -> {
            return this.f5205l;
        }, vec2 -> {
            this.f5205l = vec2;
        }));
        objectArrayList.add(new C0934qt(Component.literal("End Position"), () -> {
            return this.f5206m;
        }, vec3 -> {
            this.f5206m = vec3;
        }));
        objectArrayList.add(new C0930qp(Component.literal("Interval (ticks)"), () -> {
            return Integer.valueOf(this.f5204qh);
        }, num -> {
            this.f5204qh = num.intValue();
        }, 1, 144000));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Lightning: " + this.f5205l.x + ", " + this.f5205l.y + " -> " + this.f5206m.x + ", " + this.f5206m.y));
        list.add(Component.literal("Next strike in: " + this.f5207qi + " / " + this.f5204qh + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5202ea;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
        this.f5207qi = ThreadLocalRandom.current().nextInt(Math.max(1, this.f5204qh));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
    }
}
