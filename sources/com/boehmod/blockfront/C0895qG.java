package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.qG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qG.class */
public class C0895qG extends AbstractC0858pW implements InterfaceC0919qe, InterfaceC0920qf {

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final MapCodec<C0895qG> f4947w = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("rotation").forGetter(c0895qG -> {
            return Float.valueOf(c0895qG.f4960cU);
        }), Codec.INT.fieldOf("color").forGetter(c0895qG2 -> {
            return Integer.valueOf(c0895qG2.f4962aM);
        }), Codec.FLOAT.fieldOf("scale").forGetter(c0895qG3 -> {
            return Float.valueOf(c0895qG3.f4961aG);
        }), Codec.STRING.fieldOf("sound").forGetter(c0895qG4 -> {
            return C1272xL.m7216f(c0895qG4.f4965j.get());
        })).apply(instance, (f, num, f2, str) -> {
            C0895qG c0895qG5 = new C0895qG(Vec3.ZERO, f.floatValue(), C1272xL.m7215d(str));
            c0895qG5.f4962aM = num.intValue();
            c0895qG5.f4961aG = f2.floatValue();
            return c0895qG5;
        });
    });

    /* JADX INFO: renamed from: ei */
    private static final ResourceLocation f4948ei = C0532jO.m2378d("textures/misc/world/bombing.png");

    /* JADX INFO: renamed from: ej */
    private static final ResourceLocation f4949ej = C0532jO.m2378d("textures/misc/debug/mapeffect/bombing_flash.png");

    /* JADX INFO: renamed from: mb */
    private static final float f4950mb = 8000.0f;

    /* JADX INFO: renamed from: mc */
    private static final float f4951mc = 4000.0f;

    /* JADX INFO: renamed from: qv */
    private static final int f4952qv = 16777215;

    /* JADX INFO: renamed from: md */
    private static final float f4953md = 1.0f;

    /* JADX INFO: renamed from: me */
    private static final float f4954me = 0.02f;

    /* JADX INFO: renamed from: mf */
    private static final float f4955mf = 0.02f;

    /* JADX INFO: renamed from: mg */
    private static final float f4956mg = 0.8f;

    /* JADX INFO: renamed from: mh */
    private static final float f4957mh = 0.1f;

    /* JADX INFO: renamed from: qw */
    private static final int f4958qw = 4;

    /* JADX INFO: renamed from: mi */
    private static final float f4959mi = 30.0f;

    /* JADX INFO: renamed from: cU */
    private float f4960cU;

    /* JADX INFO: renamed from: aG */
    private float f4961aG;

    /* JADX INFO: renamed from: aM */
    private int f4962aM;

    /* JADX INFO: renamed from: aI */
    private float f4963aI;

    /* JADX INFO: renamed from: aJ */
    private float f4964aJ;

    /* JADX INFO: renamed from: j */
    private Supplier<SoundEvent> f4965j;

    public C0895qG() {
        this(Vec3.ZERO, 0.0f, C1312xz.f8685De);
    }

    public C0895qG(Vec3 vec3, float f, Supplier<SoundEvent> supplier) {
        super(vec3);
        this.f4961aG = 1.0f;
        this.f4962aM = 16777215;
        this.f4963aI = 0.0f;
        this.f4964aJ = 0.0f;
        this.f4960cU = f;
        this.f4965j = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.f4964aJ = this.f4963aI;
        this.f4963aI = C1270xJ.m7161d(this.f4963aI, 0.0f, 0.02f);
        if (randomSource.nextFloat() < 0.02f) {
            this.f4963aI = 1.0f;
            if (this.f4965j != null) {
                minecraft.getSoundManager().playDelayed(new SimpleSoundInstance(this.f4965j.get(), SoundSource.AMBIENT, f4959mi, f4956mg + (0.1f * randomSource.nextInt(4)), RandomSource.create(clientLevel.random.nextLong()), this.f4593c.x, this.f4593c.y, this.f4593c.z), 20);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        float fM7170f = C1270xJ.m7170f(this.f4963aI, this.f4964aJ, f2);
        C0129bt.m617a(poseStack, guiGraphics, f4948ei, this.f4593c.x, this.f4593c.y, this.f4593c.z, f4950mb * this.f4961aG, f4951mc * this.f4961aG, fM7170f, this.f4962aM, true, 0.0f, this.f4960cU);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Bombing Flash: pos=(%.1f, %.1f, %.1f)", Double.valueOf(this.f4593c.x), Double.valueOf(this.f4593c.y), Double.valueOf(this.f4593c.z))));
        list.add(Component.literal(String.format("Rotation: %.1f, Scale: %.2f, Color: #%06X", Float.valueOf(this.f4960cU), Float.valueOf(this.f4961aG), Integer.valueOf(this.f4962aM & 16777215))));
        SoundEvent soundEvent = this.f4965j != null ? this.f4965j.get() : null;
        list.add(Component.literal("Sound: " + (soundEvent != null ? C1272xL.m7216f(soundEvent) : "none")));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0929qo(Component.literal("Rotation"), () -> {
            return Float.valueOf(this.f4960cU);
        }, f -> {
            this.f4960cU = f.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0926ql(Component.literal("Color"), () -> {
            return Integer.valueOf(this.f4962aM);
        }, num -> {
            this.f4962aM = num.intValue();
        }));
        objectArrayList.add(new C0929qo(Component.literal("Scale"), () -> {
            return Float.valueOf(this.f4961aG);
        }, f2 -> {
            this.f4961aG = f2.floatValue();
        }, 0.0f, 16.0f));
        objectArrayList.add(new C0932qr(Component.literal("Sound"), () -> {
            if (this.f4965j != null) {
                return this.f4965j.get();
            }
            return null;
        }, soundEvent -> {
            this.f4965j = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4949ej;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aU */
    public float mo4682aU() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aV */
    public float mo4683aV() {
        return this.f4960cU;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: aW */
    public float mo4684aW() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: a */
    public void mo4685a(float f, float f2, float f3) {
        this.f4960cU = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    /* JADX INFO: renamed from: g */
    public void mo4686g(@NotNull Vec3 vec3) {
        this.f4960cU = (float) Math.toDegrees(Math.atan2(-vec3.x, -vec3.z));
    }

    @Override // com.boehmod.blockfront.InterfaceC0920qf
    @NotNull
    /* JADX INFO: renamed from: n */
    public Vec3 mo4687n() {
        double radians = Math.toRadians(this.f4960cU);
        return new Vec3(-Math.sin(radians), 0.0d, -Math.cos(radians));
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
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }
}
