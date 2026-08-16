package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.light.data.PointLightData;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qH.class */
public class C0896qH extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: x */
    @NotNull
    public static final MapCodec<C0896qH> f4966x = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4599C.fieldOf("endPos").forGetter(c0896qH -> {
            return c0896qH.f4970b;
        }), Codec.FLOAT.fieldOf("chance").forGetter(c0896qH2 -> {
            return Float.valueOf(c0896qH2.f4971mj);
        }), Codec.BOOL.fieldOf("playSound").forGetter(c0896qH3 -> {
            return Boolean.valueOf(c0896qH3.f4974gM);
        }), C0859pX.f4599C.fieldOf("spread").forGetter(c0896qH4 -> {
            return c0896qH4.f4975ac;
        })).apply(instance, (vec3, f, bool, vec4) -> {
            C0896qH c0896qH5 = new C0896qH(Vec3.ZERO, vec3);
            c0896qH5.f4971mj = f.floatValue();
            c0896qH5.f4974gM = bool.booleanValue();
            c0896qH5.f4975ac = vec4;
            return c0896qH5;
        });
    });

    /* JADX INFO: renamed from: ek */
    @NotNull
    private static final ResourceLocation f4967ek = C0532jO.m2378d("textures/misc/debug/mapeffect/bullet_tracer_start.png");

    /* JADX INFO: renamed from: el */
    @NotNull
    private static final ResourceLocation f4968el = C0532jO.m2378d("textures/misc/debug/mapeffect/bullet_tracer_end.png");

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final ResourceLocation[] f4969f = {C0532jO.m2378d("textures/misc/muzzleflash/flash0.png"), C0532jO.m2378d("textures/misc/muzzleflash/flash1.png"), C0532jO.m2378d("textures/misc/muzzleflash/flash2.png")};

    /* JADX INFO: renamed from: b */
    private Vec3 f4970b;

    /* JADX INFO: renamed from: mj */
    private float f4971mj;

    /* JADX INFO: renamed from: qx */
    private int f4972qx;

    /* JADX INFO: renamed from: em */
    @NotNull
    private ResourceLocation f4973em;

    /* JADX INFO: renamed from: gM */
    private boolean f4974gM;

    /* JADX INFO: renamed from: ac */
    @NotNull
    private Vec3 f4975ac;

    public C0896qH() {
        this(Vec3.ZERO, Vec3.ZERO);
    }

    public C0896qH(Vec3 vec3, Vec3 vec4) {
        super(vec3);
        this.f4971mj = 0.08f;
        this.f4972qx = 0;
        this.f4973em = f4969f[0];
        this.f4974gM = false;
        this.f4975ac = new Vec3(8.0d, 8.0d, 8.0d);
        this.f4970b = vec4;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (randomSource.nextFloat() <= this.f4971mj) {
            m4762b(randomSource, clientLevel);
        } else if (this.f4972qx > 0) {
            this.f4972qx--;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4762b(@NotNull RandomSource randomSource, @NotNull ClientLevel clientLevel) {
        this.f4972qx = 1;
        this.f4973em = f4969f[randomSource.nextInt(3)];
        C0113bd.f766m.add(new C0403gs(C1308xv.f7754lA, this.f4593c, this.f4970b.add(((int) (((double) randomSource.nextInt((int) (this.f4975ac.x + this.f4975ac.x))) + this.f4975ac.x)) - ((int) (((double) randomSource.nextInt((int) (this.f4975ac.x + this.f4975ac.x))) + this.f4975ac.x)), ((int) (((double) randomSource.nextInt((int) (this.f4975ac.y + this.f4975ac.y))) + this.f4975ac.y)) - ((int) (((double) randomSource.nextInt((int) (this.f4975ac.y + this.f4975ac.y))) + this.f4975ac.y)), ((int) (((double) randomSource.nextInt((int) (this.f4975ac.z + this.f4975ac.z))) + this.f4975ac.z)) - ((int) (((double) randomSource.nextInt((int) (this.f4975ac.z + this.f4975ac.z))) + this.f4975ac.z)))));
        if (this.f4974gM) {
            clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, (SoundEvent) C1312xz.f8272vh.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
        m4763c(randomSource);
    }

    /* JADX INFO: renamed from: c */
    private void m4763c(@NotNull RandomSource randomSource) {
        float fNextFloat = randomSource.nextFloat();
        C1193vm c1193vmM6373a = ((C1117uP) C1308xv.f7775lT.get()).m6373a();
        int color = c1193vmM6373a.getColor();
        boolean z = C0549jf.f3274dw;
        C0401gq.m1906a(new PointLightData().setOcclusionEnabled(z).setPosition(this.f4593c.x, this.f4593c.y, this.f4593c.z).setBrightness(c1193vmM6373a.m6789bM() * fNextFloat).setRadius(c1193vmM6373a.m6787bL()).setColor(color), 1);
        C0401gq.m1906a(new PointLightData().setOcclusionEnabled(z).setPosition(this.f4593c.x, this.f4593c.y, this.f4593c.z).setBrightness(c1193vmM6373a.m6785bK() * fNextFloat).setRadius(c1193vmM6373a.m6783bJ()).setColor(color), 1);
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        if (this.f4972qx > 0) {
            C0129bt.m603a(poseStack, camera, guiGraphics, this.f4973em, this.f4593c.x, this.f4593c.y, this.f4593c.z, 48);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        C0129bt.m605a(poseStack, camera, guiGraphics, f4968el, this.f4970b, 64, false);
        C0129bt.m574a(camera, poseStack, this.f4593c, this.f4970b, 1.0f, ColorReferences.COLOR_WHITE);
        Vec3 vec3Add = this.f4970b.add(this.f4975ac.x, 0.0d, 0.0d);
        Vec3 vec3Add2 = this.f4970b.add(-this.f4975ac.x, 0.0d, 0.0d);
        Vec3 vec3Add3 = this.f4970b.add(0.0d, this.f4975ac.y, 0.0d);
        Vec3 vec3Add4 = this.f4970b.add(0.0d, -this.f4975ac.y, 0.0d);
        Vec3 vec3Add5 = this.f4970b.add(0.0d, 0.0d, this.f4975ac.z);
        Vec3 vec3Add6 = this.f4970b.add(0.0d, 0.0d, -this.f4975ac.z);
        C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add, 1.0f, ColorReferences.COLOR_WHITE);
        C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add2, 1.0f, ColorReferences.COLOR_WHITE);
        C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add3, 1.0f, ColorReferences.COLOR_WHITE);
        C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add4, 1.0f, ColorReferences.COLOR_WHITE);
        C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add5, 1.0f, ColorReferences.COLOR_WHITE);
        C0129bt.m574a(camera, poseStack, this.f4593c, vec3Add6, 1.0f, ColorReferences.COLOR_WHITE);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Bullet Tracer: chance=%.3f, playSound=%s", Float.valueOf(this.f4971mj), Boolean.valueOf(this.f4974gM))));
        list.add(Component.literal(String.format("Spread: x=%.1f, y=%.1f, z=%.1f", Double.valueOf(this.f4975ac.x), Double.valueOf(this.f4975ac.y), Double.valueOf(this.f4975ac.z))));
        list.add(Component.literal(String.format("End: (%.1f, %.1f, %.1f)", Double.valueOf(this.f4970b.x), Double.valueOf(this.f4970b.y), Double.valueOf(this.f4970b.z))));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0935qu(Component.literal("End Position"), () -> {
            return this.f4970b;
        }, vec3 -> {
            this.f4970b = vec3;
        }));
        objectArrayList.add(new C0929qo(Component.literal("Chance"), () -> {
            return Float.valueOf(this.f4971mj);
        }, f -> {
            this.f4971mj = f.floatValue();
        }, 0.0f, 1.0f));
        objectArrayList.add(new C0925qk(Component.literal("Play Sound"), () -> {
            return Boolean.valueOf(this.f4974gM);
        }, bool -> {
            this.f4974gM = bool.booleanValue();
        }));
        objectArrayList.add(new C0935qu(Component.literal("Spread"), () -> {
            return this.f4975ac;
        }, vec4 -> {
            this.f4975ac = vec4;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4967ek;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return false;
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
        this.f4972qx = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
