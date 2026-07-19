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
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qq.class */
public class C0449qq extends pA {

    @NotNull
    private static final ResourceLocation et = C0265jv.d("textures/misc/debug/mapeffect/rocket_barrage.png");

    @NotNull
    public static final MapCodec<C0449qq> C = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("interval").forGetter(c0449qq -> {
            return Integer.valueOf(c0449qq.oB);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0449qq2 -> {
            return Float.valueOf(c0449qq2.fZ);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0449qq3 -> {
            return Float.valueOf(c0449qq3.ga);
        }), Codec.INT.fieldOf("fireRate").forGetter(c0449qq4 -> {
            return Integer.valueOf(c0449qq4.oC);
        }), Codec.INT.fieldOf("amount").forGetter(c0449qq5 -> {
            return Integer.valueOf(c0449qq5.nD);
        }), Codec.STRING.optionalFieldOf("fireSound", "").forGetter(c0449qq6 -> {
            return c0449qq6.p != null ? C0636xo.f(c0449qq6.p.get()) : "";
        }), Codec.FLOAT.fieldOf("pitchWidth").forGetter(c0449qq7 -> {
            return Float.valueOf(c0449qq7.lq);
        }), Codec.FLOAT.fieldOf("yawWidth").forGetter(c0449qq8 -> {
            return Float.valueOf(c0449qq8.lr);
        })).apply(instance, (num, f, f2, num2, num3, str, f3, f4) -> {
            C0449qq c0449qq9 = new C0449qq(Vec3.ZERO, num.intValue(), f.floatValue(), f2.floatValue(), num2.intValue(), num3.intValue(), str.isEmpty() ? C0624xc.De : C0636xo.d(str));
            c0449qq9.lq = f3.floatValue();
            c0449qq9.lr = f4.floatValue();
            return c0449qq9;
        });
    });
    private int oB;
    private float fZ;
    private float ga;

    @Nullable
    private Supplier<SoundEvent> p;
    private int oC;
    private int nD;
    private int oD;
    private float lq;
    private float lr;

    @NotNull
    private final ItemStack n;
    private int oE;
    private int oF;

    public C0449qq() {
        this(Vec3.ZERO, 0, 0.0f, 0.0f, 0, 0, C0624xc.De);
    }

    public C0449qq(@NotNull Vec3 vec3, int i, float f, float f2, int i2, int i3, @NotNull Supplier<SoundEvent> supplier) {
        super(vec3);
        this.oD = 0;
        this.lr = 0.0f;
        this.n = new ItemStack((ItemLike) wY.mZ.get());
        this.oE = 0;
        this.oB = i;
        this.fZ = f;
        this.ga = f2;
        this.oC = i2;
        this.nD = i3;
        this.oF = i3;
        this.p = supplier;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.oD;
        this.oD = i + 1;
        if (i >= this.oB) {
            if (this.oF > 0) {
                int i2 = this.oE;
                this.oE = i2 + 1;
                if (i2 >= this.oC) {
                    this.oE = 0;
                    this.oF--;
                    if (clientLevel.isLoaded(BlockPos.containing(this.c))) {
                        a(minecraft, c0297l, clientLevel, randomSource);
                        return;
                    }
                    return;
                }
                return;
            }
            this.oD = 0;
            this.oF = this.nD;
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Rocket Barrage: pitch=%.1f (±%.1f), yaw=%.1f (±%.1f)", Float.valueOf(this.fZ), Float.valueOf(this.lq), Float.valueOf(this.ga), Float.valueOf(this.lr))));
        list.add(Component.literal("Fire timer: " + this.oD + "/" + this.oB + ", fireRate " + this.oE + "/" + this.oC));
        list.add(Component.literal("Remaining: " + this.oF + "/" + this.nD));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pT(Component.literal("Interval"), () -> {
            return Integer.valueOf(this.oB);
        }, num -> {
            this.oB = num.intValue();
        }, 0, 12000));
        objectArrayList.add(new pS(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.fZ);
        }, f -> {
            this.fZ = f.floatValue();
        }, -90.0f, 90.0f));
        objectArrayList.add(new pS(Component.literal("Yaw"), () -> {
            return Float.valueOf(this.ga);
        }, f2 -> {
            this.ga = f2.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new pT(Component.literal("Fire Rate"), () -> {
            return Integer.valueOf(this.oC);
        }, num2 -> {
            this.oC = num2.intValue();
        }, 0, 1200));
        objectArrayList.add(new pT(Component.literal("Amount"), () -> {
            return Integer.valueOf(this.nD);
        }, num3 -> {
            this.nD = num3.intValue();
        }, 0, 256));
        objectArrayList.add(new pV(Component.literal("Fire Sound"), () -> {
            if (this.p != null) {
                return this.p.get();
            }
            return null;
        }, soundEvent -> {
            this.p = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new pS(Component.literal("Pitch Width"), () -> {
            return Float.valueOf(this.lq);
        }, f3 -> {
            this.lq = f3.floatValue();
        }, 0.0f, 90.0f));
        objectArrayList.add(new pS(Component.literal("Yaw Width"), () -> {
            return Float.valueOf(this.lr);
        }, f4 -> {
            this.lr = f4.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return et;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.oD = 0;
        this.oE = 0;
        this.oF = this.nD;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
        C0357nf c0357nfCreate;
        if (this.p != null) {
            clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, this.p.get(), SoundSource.AMBIENT, 100.0f, 0.9f + (0.2f * randomSource.nextFloat()), false);
        }
        float fA = this.fZ + C0634xm.a(randomSource, this.lq);
        float fA2 = this.ga + C0634xm.a(randomSource, this.lr);
        if (this.n.isEmpty()) {
            return;
        }
        Item item = this.n.getItem();
        if (item instanceof C0558ur) {
            uS uSVarM1210a = ((C0558ur) item).m1210a();
            if (uSVarM1210a.m1177a() == uU.ENTITY) {
                iG.a(minecraft, c0297l, clientLevel, ParticleTypes.FLASH, this.c.x + 0.10000000149011612d, this.c.y, this.c.z + 0.10000000149011612d, 0.0d, 0.0d, 0.0d);
                Supplier<EntityType<? extends InterfaceC0347mw>> supplierB = uSVarM1210a.b();
                if (supplierB == null || (c0357nfCreate = supplierB.get().create(clientLevel)) == null) {
                    return;
                }
                if (c0357nfCreate instanceof C0357nf) {
                    c0357nfCreate.bt();
                }
                c0357nfCreate.a(this.c, 6.0f, this.n, fA2, fA);
                c0357nfCreate.setPos(this.c);
                iG.a((Entity) c0357nfCreate, clientLevel);
            }
        }
    }
}
