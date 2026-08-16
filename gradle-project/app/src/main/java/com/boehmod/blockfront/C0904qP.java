package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qP.class */
public final class C0904qP extends AbstractC0858pW {

    /* JADX INFO: renamed from: F */
    @NotNull
    public static final MapCodec<C0904qP> f5046F = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("sound", "").forGetter(c0904qP -> {
            return c0904qP.f5048a != null ? C1272xL.m7216f(c0904qP.f5048a.get()) : "";
        }), Codec.INT.fieldOf("maxTime").forGetter(c0904qP2 -> {
            return Integer.valueOf(c0904qP2.f5049pd);
        }), Codec.FLOAT.fieldOf("volume").forGetter(c0904qP3 -> {
            return Float.valueOf(c0904qP3.f5051gM);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0904qP4 -> {
            return Float.valueOf(c0904qP4.f5052gN);
        }), Codec.FLOAT.fieldOf("activationDistance").forGetter(c0904qP5 -> {
            return Float.valueOf(c0904qP5.f5053lA);
        })).apply(instance, (str, num, f, f2, f3) -> {
            C0904qP c0904qP6 = new C0904qP();
            c0904qP6.f5048a = str.isEmpty() ? null : C1272xL.m7215d(str);
            c0904qP6.f5049pd = num.intValue();
            c0904qP6.f5051gM = f.floatValue();
            c0904qP6.f5052gN = f2.floatValue();
            c0904qP6.f5053lA = f3.floatValue();
            return c0904qP6;
        });
    });

    /* JADX INFO: renamed from: eu */
    @NotNull
    private static final ResourceLocation f5047eu = C0532jO.m2378d("textures/misc/debug/mapeffect/sound_looping.png");

    /* JADX INFO: renamed from: a */
    @Nullable
    public Supplier<SoundEvent> f5048a;

    /* JADX INFO: renamed from: pd */
    public int f5049pd;

    /* JADX INFO: renamed from: aN */
    public int f5050aN;

    /* JADX INFO: renamed from: gM */
    public float f5051gM;

    /* JADX INFO: renamed from: gN */
    public float f5052gN;

    /* JADX INFO: renamed from: lA */
    public float f5053lA;

    /* JADX INFO: renamed from: c */
    private SimpleSoundInstance f5054c;

    public C0904qP() {
        this(C1312xz.f8701Du, Vec3.ZERO, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0904qP(@NotNull Supplier<SoundEvent> supplier, @NotNull Vec3 vec3, int i) {
        super(vec3);
        this.f5050aN = 0;
        this.f5051gM = 1.5f;
        this.f5052gN = 1.0f;
        this.f5053lA = 25.0f;
        this.f5048a = supplier;
        this.f5049pd = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5050aN;
        this.f5050aN = i - 1;
        if (i > 0) {
            return;
        }
        this.f5050aN = this.f5049pd;
        if (this.f5048a != null && Mth.sqrt((float) localPlayer.distanceToSqr(this.f4593c)) <= this.f5053lA) {
            this.f5054c = new SimpleSoundInstance(this.f5048a.get(), SoundSource.AMBIENT, this.f5051gM, this.f5052gN, clientLevel.random, this.f4593c.x, this.f4593c.y, this.f4593c.z);
            minecraft.getSoundManager().play(this.f5054c);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0932qr(Component.literal("Sound"), () -> {
            if (this.f5048a != null) {
                return this.f5048a.get();
            }
            return null;
        }, soundEvent -> {
            this.f5048a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0930qp(Component.literal("Max Time"), () -> {
            return Integer.valueOf(this.f5049pd);
        }, num -> {
            this.f5049pd = num.intValue();
        }, 0, 24000));
        objectArrayList.add(new C0929qo(Component.literal("Volume"), () -> {
            return Float.valueOf(this.f5051gM);
        }, f -> {
            this.f5051gM = f.floatValue();
        }, 0.0f, 2560.0f));
        objectArrayList.add(new C0929qo(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f5052gN);
        }, f2 -> {
            this.f5052gN = f2.floatValue();
        }, 0.0f, 2.0f));
        objectArrayList.add(new C0929qo(Component.literal("Activation Distance"), () -> {
            return Float.valueOf(this.f5053lA);
        }, f3 -> {
            this.f5053lA = f3.floatValue();
        }, 0.0f, 512.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        SoundEvent soundEvent = this.f5048a != null ? this.f5048a.get() : null;
        list.add(Component.literal("Timed Sound: " + (soundEvent != null ? C1272xL.m7216f(soundEvent) : "none")));
        list.add(Component.literal(String.format("Volume: %.2f, Pitch: %.2f, Distance: %.1f", Float.valueOf(this.f5051gM), Float.valueOf(this.f5052gN), Float.valueOf(this.f5053lA))));
        list.add(Component.literal("Timer: " + this.f5050aN + "/" + this.f5049pd));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5047eu;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return true;
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
        if (this.f5054c != null) {
            minecraft.getSoundManager().stop(this.f5054c);
            this.f5054c = null;
        }
        this.f5050aN = 0;
    }
}
