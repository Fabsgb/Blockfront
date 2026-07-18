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

/* JADX INFO: renamed from: com.boehmod.blockfront.qq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qq.class */
public class C0930qq extends AbstractC0835pA {

    /* JADX INFO: renamed from: et */
    @NotNull
    private static final ResourceLocation f4927et = C0564jv.m2555d("textures/misc/debug/mapeffect/rocket_barrage.png");

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final MapCodec<C0930qq> f4928C = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("interval").forGetter(c0930qq -> {
            return Integer.valueOf(c0930qq.f4929oB);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0930qq2 -> {
            return Float.valueOf(c0930qq2.f4930fZ);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0930qq3 -> {
            return Float.valueOf(c0930qq3.f4931ga);
        }), Codec.INT.fieldOf("fireRate").forGetter(c0930qq4 -> {
            return Integer.valueOf(c0930qq4.f4933oC);
        }), Codec.INT.fieldOf("amount").forGetter(c0930qq5 -> {
            return Integer.valueOf(c0930qq5.f4934nD);
        }), Codec.STRING.optionalFieldOf("fireSound", "").forGetter(c0930qq6 -> {
            return c0930qq6.f4932p != null ? C1292xo.m7889f(c0930qq6.f4932p.get()) : "";
        }), Codec.FLOAT.fieldOf("pitchWidth").forGetter(c0930qq7 -> {
            return Float.valueOf(c0930qq7.f4936lq);
        }), Codec.FLOAT.fieldOf("yawWidth").forGetter(c0930qq8 -> {
            return Float.valueOf(c0930qq8.f4937lr);
        })).apply(instance, (num, f, f2, num2, num3, str, f3, f4) -> {
            C0930qq c0930qq9 = new C0930qq(Vec3.ZERO, num.intValue(), f.floatValue(), f2.floatValue(), num2.intValue(), num3.intValue(), str.isEmpty() ? C1280xc.f8275De : C1292xo.m7888d(str));
            c0930qq9.f4936lq = f3.floatValue();
            c0930qq9.f4937lr = f4.floatValue();
            return c0930qq9;
        });
    });

    /* JADX INFO: renamed from: oB */
    private int f4929oB;

    /* JADX INFO: renamed from: fZ */
    private float f4930fZ;

    /* JADX INFO: renamed from: ga */
    private float f4931ga;

    /* JADX INFO: renamed from: p */
    @Nullable
    private Supplier<SoundEvent> f4932p;

    /* JADX INFO: renamed from: oC */
    private int f4933oC;

    /* JADX INFO: renamed from: nD */
    private int f4934nD;

    /* JADX INFO: renamed from: oD */
    private int f4935oD;

    /* JADX INFO: renamed from: lq */
    private float f4936lq;

    /* JADX INFO: renamed from: lr */
    private float f4937lr;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final ItemStack f4938n;

    /* JADX INFO: renamed from: oE */
    private int f4939oE;

    /* JADX INFO: renamed from: oF */
    private int f4940oF;

    public C0930qq() {
        this(Vec3.ZERO, 0, 0.0f, 0.0f, 0, 0, C1280xc.f8275De);
    }

    public C0930qq(@NotNull Vec3 vec3, int i, float f, float f2, int i2, int i3, @NotNull Supplier<SoundEvent> supplier) {
        super(vec3);
        this.f4935oD = 0;
        this.f4937lr = 0.0f;
        this.f4938n = new ItemStack((ItemLike) C1231wY.f7271mZ.get());
        this.f4939oE = 0;
        this.f4929oB = i;
        this.f4930fZ = f;
        this.f4931ga = f2;
        this.f4933oC = i2;
        this.f4934nD = i3;
        this.f4940oF = i3;
        this.f4932p = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4935oD;
        this.f4935oD = i + 1;
        if (i >= this.f4929oB) {
            if (this.f4940oF > 0) {
                int i2 = this.f4939oE;
                this.f4939oE = i2 + 1;
                if (i2 >= this.f4933oC) {
                    this.f4939oE = 0;
                    this.f4940oF--;
                    if (clientLevel.isLoaded(BlockPos.containing(this.f4464c))) {
                        m4985a(minecraft, c0622l, clientLevel, randomSource);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f4935oD = 0;
            this.f4940oF = this.f4934nD;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Rocket Barrage: pitch=%.1f (±%.1f), yaw=%.1f (±%.1f)", Float.valueOf(this.f4930fZ), Float.valueOf(this.f4936lq), Float.valueOf(this.f4931ga), Float.valueOf(this.f4937lr))));
        list.add(Component.literal("Fire timer: " + this.f4935oD + "/" + this.f4929oB + ", fireRate " + this.f4939oE + "/" + this.f4933oC));
        list.add(Component.literal("Remaining: " + this.f4940oF + "/" + this.f4934nD));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0854pT(Component.literal("Interval"), () -> {
            return Integer.valueOf(this.f4929oB);
        }, num -> {
            this.f4929oB = num.intValue();
        }, 0, 12000));
        objectArrayList.add(new C0853pS(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f4930fZ);
        }, f -> {
            this.f4930fZ = f.floatValue();
        }, -90.0f, 90.0f));
        objectArrayList.add(new C0853pS(Component.literal("Yaw"), () -> {
            return Float.valueOf(this.f4931ga);
        }, f2 -> {
            this.f4931ga = f2.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0854pT(Component.literal("Fire Rate"), () -> {
            return Integer.valueOf(this.f4933oC);
        }, num2 -> {
            this.f4933oC = num2.intValue();
        }, 0, 1200));
        objectArrayList.add(new C0854pT(Component.literal("Amount"), () -> {
            return Integer.valueOf(this.f4934nD);
        }, num3 -> {
            this.f4934nD = num3.intValue();
        }, 0, 256));
        objectArrayList.add(new C0856pV(Component.literal("Fire Sound"), () -> {
            if (this.f4932p != null) {
                return this.f4932p.get();
            }
            return null;
        }, soundEvent -> {
            this.f4932p = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0853pS(Component.literal("Pitch Width"), () -> {
            return Float.valueOf(this.f4936lq);
        }, f3 -> {
            this.f4936lq = f3.floatValue();
        }, 0.0f, 90.0f));
        objectArrayList.add(new C0853pS(Component.literal("Yaw Width"), () -> {
            return Float.valueOf(this.f4937lr);
        }, f4 -> {
            this.f4937lr = f4.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4927et;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        this.f4935oD = 0;
        this.f4939oE = 0;
        this.f4940oF = this.f4934nD;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4985a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
        C0760nf c0760nfCreate;
        if (this.f4932p != null) {
            clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, this.f4932p.get(), SoundSource.AMBIENT, 100.0f, 0.9f + (0.2f * randomSource.nextFloat()), false);
        }
        float fM7849a = this.f4930fZ + C1290xm.m7849a(randomSource, this.f4936lq);
        float fM7849a2 = this.f4931ga + C1290xm.m7849a(randomSource, this.f4937lr);
        if (this.f4938n.isEmpty()) {
            return;
        }
        Item item = this.f4938n.getItem();
        if (item instanceof C1144ur) {
            C1119uS c1119uSM6347a = ((C1144ur) item).m6347a();
            if (c1119uSM6347a.m6224a() == EnumC1121uU.ENTITY) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, ParticleTypes.FLASH, this.f4464c.x + 0.10000000149011612d, this.f4464c.y, this.f4464c.z + 0.10000000149011612d, 0.0d, 0.0d, 0.0d);
                Supplier<EntityType<? extends InterfaceC0724mw>> supplierM6223b = c1119uSM6347a.m6223b();
                if (supplierM6223b == null || (c0760nfCreate = supplierM6223b.get().create(clientLevel)) == null) {
                    return;
                }
                if (c0760nfCreate instanceof C0760nf) {
                    c0760nfCreate.m2976bt();
                }
                c0760nfCreate.mo3284a(this.f4464c, 6.0f, this.f4938n, fM7849a2, fM7849a);
                c0760nfCreate.setPos(this.f4464c);
                C0470iG.m2121a((Entity) c0760nfCreate, clientLevel);
            }
        }
    }
}
