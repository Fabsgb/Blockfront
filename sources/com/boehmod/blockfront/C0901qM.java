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

/* JADX INFO: renamed from: com.boehmod.blockfront.qM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qM.class */
public class C0901qM extends AbstractC0858pW {

    /* JADX INFO: renamed from: er */
    @NotNull
    private static final ResourceLocation f5008er = C0532jO.m2378d("textures/misc/debug/mapeffect/rocket_barrage.png");

    /* JADX INFO: renamed from: C */
    @NotNull
    public static final MapCodec<C0901qM> f5009C = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("interval").forGetter(c0901qM -> {
            return Integer.valueOf(c0901qM.f5010qA);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0901qM2 -> {
            return Float.valueOf(c0901qM2.f5011gN);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0901qM3 -> {
            return Float.valueOf(c0901qM3.f5012lZ);
        }), Codec.INT.fieldOf("fireRate").forGetter(c0901qM4 -> {
            return Integer.valueOf(c0901qM4.f5014qB);
        }), Codec.INT.fieldOf("amount").forGetter(c0901qM5 -> {
            return Integer.valueOf(c0901qM5.f5015pC);
        }), Codec.STRING.optionalFieldOf("fireSound", "").forGetter(c0901qM6 -> {
            return c0901qM6.f5013p != null ? C1272xL.m7216f(c0901qM6.f5013p.get()) : "";
        }), Codec.FLOAT.fieldOf("pitchWidth").forGetter(c0901qM7 -> {
            return Float.valueOf(c0901qM7.f5017mn);
        }), Codec.FLOAT.fieldOf("yawWidth").forGetter(c0901qM8 -> {
            return Float.valueOf(c0901qM8.f5018mo);
        })).apply(instance, (num, f, f2, num2, num3, str, f3, f4) -> {
            C0901qM c0901qM9 = new C0901qM(Vec3.ZERO, num.intValue(), f.floatValue(), f2.floatValue(), num2.intValue(), num3.intValue(), str.isEmpty() ? C1312xz.f8688Dh : C1272xL.m7215d(str));
            c0901qM9.f5017mn = f3.floatValue();
            c0901qM9.f5018mo = f4.floatValue();
            return c0901qM9;
        });
    });

    /* JADX INFO: renamed from: qA */
    private int f5010qA;

    /* JADX INFO: renamed from: gN */
    private float f5011gN;

    /* JADX INFO: renamed from: lZ */
    private float f5012lZ;

    /* JADX INFO: renamed from: p */
    @Nullable
    private Supplier<SoundEvent> f5013p;

    /* JADX INFO: renamed from: qB */
    private int f5014qB;

    /* JADX INFO: renamed from: pC */
    private int f5015pC;

    /* JADX INFO: renamed from: qC */
    private int f5016qC;

    /* JADX INFO: renamed from: mn */
    private float f5017mn;

    /* JADX INFO: renamed from: mo */
    private float f5018mo;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final ItemStack f5019p;

    /* JADX INFO: renamed from: qD */
    private int f5020qD;

    /* JADX INFO: renamed from: qE */
    private int f5021qE;

    public C0901qM() {
        this(Vec3.ZERO, 0, 0.0f, 0.0f, 0, 0, C1312xz.f8688Dh);
    }

    public C0901qM(@NotNull Vec3 vec3, int i, float f, float f2, int i2, int i3, @NotNull Supplier<SoundEvent> supplier) {
        super(vec3);
        this.f5016qC = 0;
        this.f5018mo = 0.0f;
        this.f5019p = new ItemStack((ItemLike) C1308xv.f7836mZ.get());
        this.f5020qD = 0;
        this.f5010qA = i;
        this.f5011gN = f;
        this.f5012lZ = f2;
        this.f5014qB = i2;
        this.f5015pC = i3;
        this.f5021qE = i3;
        this.f5013p = supplier;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5016qC;
        this.f5016qC = i + 1;
        if (i >= this.f5010qA) {
            if (this.f5021qE > 0) {
                int i2 = this.f5020qD;
                this.f5020qD = i2 + 1;
                if (i2 >= this.f5014qB) {
                    this.f5020qD = 0;
                    this.f5021qE--;
                    if (clientLevel.isLoaded(BlockPos.containing(this.f4593c))) {
                        m4862a(minecraft, c0623l, clientLevel, randomSource);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f5016qC = 0;
            this.f5021qE = this.f5015pC;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Rocket Barrage: pitch=%.1f (±%.1f), yaw=%.1f (±%.1f)", Float.valueOf(this.f5011gN), Float.valueOf(this.f5017mn), Float.valueOf(this.f5012lZ), Float.valueOf(this.f5018mo))));
        list.add(Component.literal("Fire timer: " + this.f5016qC + "/" + this.f5010qA + ", fireRate " + this.f5020qD + "/" + this.f5014qB));
        list.add(Component.literal("Remaining: " + this.f5021qE + "/" + this.f5015pC));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0930qp(Component.literal("Interval"), () -> {
            return Integer.valueOf(this.f5010qA);
        }, num -> {
            this.f5010qA = num.intValue();
        }, 0, 12000));
        objectArrayList.add(new C0929qo(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f5011gN);
        }, f -> {
            this.f5011gN = f.floatValue();
        }, -90.0f, 90.0f));
        objectArrayList.add(new C0929qo(Component.literal("Yaw"), () -> {
            return Float.valueOf(this.f5012lZ);
        }, f2 -> {
            this.f5012lZ = f2.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0930qp(Component.literal("Fire Rate"), () -> {
            return Integer.valueOf(this.f5014qB);
        }, num2 -> {
            this.f5014qB = num2.intValue();
        }, 0, 1200));
        objectArrayList.add(new C0930qp(Component.literal("Amount"), () -> {
            return Integer.valueOf(this.f5015pC);
        }, num3 -> {
            this.f5015pC = num3.intValue();
        }, 0, 256));
        objectArrayList.add(new C0932qr(Component.literal("Fire Sound"), () -> {
            if (this.f5013p != null) {
                return this.f5013p.get();
            }
            return null;
        }, soundEvent -> {
            this.f5013p = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0929qo(Component.literal("Pitch Width"), () -> {
            return Float.valueOf(this.f5017mn);
        }, f3 -> {
            this.f5017mn = f3.floatValue();
        }, 0.0f, 90.0f));
        objectArrayList.add(new C0929qo(Component.literal("Yaw Width"), () -> {
            return Float.valueOf(this.f5018mo);
        }, f4 -> {
            this.f5018mo = f4.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5008er;
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
        this.f5016qC = 0;
        this.f5020qD = 0;
        this.f5021qE = this.f5015pC;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4862a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
        C0731nB c0731nBCreate;
        if (this.f5013p != null) {
            clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, this.f5013p.get(), SoundSource.AMBIENT, 100.0f, 0.9f + (0.2f * randomSource.nextFloat()), false);
        }
        float fM7176a = this.f5011gN + C1270xJ.m7176a(randomSource, this.f5017mn);
        float fM7176a2 = this.f5012lZ + C1270xJ.m7176a(randomSource, this.f5018mo);
        if (this.f5019p.isEmpty()) {
            return;
        }
        Item item = this.f5019p.getItem();
        if (item instanceof C1117uP) {
            C1199vs c1199vsM6316a = ((C1117uP) item).m6316a();
            if (c1199vsM6316a.m6877a() == EnumC1201vu.ENTITY) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, ParticleTypes.FLASH, this.f4593c.x + 0.10000000149011612d, this.f4593c.y, this.f4593c.z + 0.10000000149011612d, 0.0d, 0.0d, 0.0d);
                Supplier<EntityType<? extends InterfaceC0695mS>> supplierM6876b = c1199vsM6316a.m6876b();
                if (supplierM6876b == null || (c0731nBCreate = supplierM6876b.get().create(clientLevel)) == null) {
                    return;
                }
                if (c0731nBCreate instanceof C0731nB) {
                    c0731nBCreate.m3127bE();
                }
                c0731nBCreate.mo3119a(this.f4593c, 6.0f, this.f5019p, fM7176a2, fM7176a);
                c0731nBCreate.setPos(this.f4593c);
                C0490iZ.m2213a((Entity) c0731nBCreate, clientLevel);
            }
        }
    }
}
