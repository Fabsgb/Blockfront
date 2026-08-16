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

/* JADX INFO: renamed from: com.boehmod.blockfront.qN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qN.class */
public class C0902qN extends AbstractC0858pW {

    /* JADX INFO: renamed from: es */
    @NotNull
    private static final ResourceLocation f5022es = C0532jO.m2378d("textures/misc/debug/mapeffect/rocket_positioned.png");

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final MapCodec<C0902qN> f5023D = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("interval").forGetter(c0902qN -> {
            return Integer.valueOf(c0902qN.f5024qA);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0902qN2 -> {
            return Float.valueOf(c0902qN2.f5025gN);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0902qN3 -> {
            return Float.valueOf(c0902qN3.f5026lZ);
        }), Codec.FLOAT.fieldOf("pitchWidth").forGetter(c0902qN4 -> {
            return Float.valueOf(c0902qN4.f5028mn);
        }), Codec.FLOAT.fieldOf("yawWidth").forGetter(c0902qN5 -> {
            return Float.valueOf(c0902qN5.f5029mo);
        })).apply(instance, (num, f, f2, f3, f4) -> {
            C0902qN c0902qN6 = new C0902qN(Vec3.ZERO, num.intValue(), f.floatValue(), f2.floatValue());
            c0902qN6.f5028mn = f3.floatValue();
            c0902qN6.f5029mo = f4.floatValue();
            return c0902qN6;
        });
    });

    /* JADX INFO: renamed from: qA */
    private int f5024qA;

    /* JADX INFO: renamed from: gN */
    private float f5025gN;

    /* JADX INFO: renamed from: lZ */
    private float f5026lZ;

    /* JADX INFO: renamed from: qC */
    private int f5027qC;

    /* JADX INFO: renamed from: mn */
    private float f5028mn;

    /* JADX INFO: renamed from: mo */
    private float f5029mo;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final ItemStack f5030q;

    public C0902qN() {
        this(Vec3.ZERO, 0, 0.0f, 0.0f);
    }

    public C0902qN(@NotNull Vec3 vec3, int i, float f, float f2) {
        super(vec3);
        this.f5027qC = 0;
        this.f5029mo = 0.0f;
        this.f5030q = new ItemStack((ItemLike) C1308xv.f7836mZ.get());
        this.f5024qA = i;
        this.f5025gN = f;
        this.f5026lZ = f2;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5027qC;
        this.f5027qC = i + 1;
        if (i >= this.f5024qA) {
            this.f5027qC = 0;
            if (clientLevel.isLoaded(BlockPos.containing(this.f4593c))) {
                m4890a(minecraft, c0623l, clientLevel, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Rocket: pitch=%.1f (±%.1f), yaw=%.1f (±%.1f)", Float.valueOf(this.f5025gN), Float.valueOf(this.f5028mn), Float.valueOf(this.f5026lZ), Float.valueOf(this.f5029mo))));
        list.add(Component.literal("Fire timer: " + this.f5027qC + "/" + this.f5024qA));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0930qp(Component.literal("Interval"), () -> {
            return Integer.valueOf(this.f5024qA);
        }, num -> {
            this.f5024qA = num.intValue();
        }, 0, 1200));
        objectArrayList.add(new C0929qo(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f5025gN);
        }, f -> {
            this.f5025gN = f.floatValue();
        }, -90.0f, 90.0f));
        objectArrayList.add(new C0929qo(Component.literal("Yaw"), () -> {
            return Float.valueOf(this.f5026lZ);
        }, f2 -> {
            this.f5026lZ = f2.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0929qo(Component.literal("Pitch Width"), () -> {
            return Float.valueOf(this.f5028mn);
        }, f3 -> {
            this.f5028mn = f3.floatValue();
        }, 0.0f, 90.0f));
        objectArrayList.add(new C0929qo(Component.literal("Yaw Width"), () -> {
            return Float.valueOf(this.f5029mo);
        }, f4 -> {
            this.f5029mo = f4.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5022es;
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
        this.f5027qC = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4890a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
        InterfaceC0695mS interfaceC0695mSCreate;
        float fM7176a = this.f5025gN + C1270xJ.m7176a(randomSource, this.f5028mn);
        float fM7176a2 = this.f5026lZ + C1270xJ.m7176a(randomSource, this.f5029mo);
        if (this.f5030q.isEmpty()) {
            return;
        }
        Item item = this.f5030q.getItem();
        if (item instanceof C1117uP) {
            C1199vs c1199vsM6316a = ((C1117uP) item).m6316a();
            if (c1199vsM6316a.m6877a() == EnumC1201vu.ENTITY) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, ParticleTypes.FLASH, this.f4593c.x + 0.10000000149011612d, this.f4593c.y, this.f4593c.z + 0.10000000149011612d, 0.0d, 0.0d, 0.0d);
                Supplier<EntityType<? extends InterfaceC0695mS>> supplierM6876b = c1199vsM6316a.m6876b();
                if (supplierM6876b != null && (interfaceC0695mSCreate = supplierM6876b.get().create(clientLevel)) != null) {
                    interfaceC0695mSCreate.mo3119a(this.f4593c, 2.0f, this.f5030q, fM7176a2, fM7176a);
                    interfaceC0695mSCreate.setPos(this.f4593c);
                    C0490iZ.m2213a((Entity) interfaceC0695mSCreate, clientLevel);
                    clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, (SoundEvent) C1312xz.f8347wE.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
                }
            }
        }
    }
}
