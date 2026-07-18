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

/* JADX INFO: renamed from: com.boehmod.blockfront.qr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qr.class */
public class C0931qr extends AbstractC0835pA {

    /* JADX INFO: renamed from: eu */
    @NotNull
    private static final ResourceLocation f4941eu = C0564jv.m2555d("textures/misc/debug/mapeffect/rocket_positioned.png");

    /* JADX INFO: renamed from: D */
    @NotNull
    public static final MapCodec<C0931qr> f4942D = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("interval").forGetter(c0931qr -> {
            return Integer.valueOf(c0931qr.f4943oB);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0931qr2 -> {
            return Float.valueOf(c0931qr2.f4944fZ);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0931qr3 -> {
            return Float.valueOf(c0931qr3.f4945ga);
        }), Codec.FLOAT.fieldOf("pitchWidth").forGetter(c0931qr4 -> {
            return Float.valueOf(c0931qr4.f4947lq);
        }), Codec.FLOAT.fieldOf("yawWidth").forGetter(c0931qr5 -> {
            return Float.valueOf(c0931qr5.f4948lr);
        })).apply(instance, (num, f, f2, f3, f4) -> {
            C0931qr c0931qr6 = new C0931qr(Vec3.ZERO, num.intValue(), f.floatValue(), f2.floatValue());
            c0931qr6.f4947lq = f3.floatValue();
            c0931qr6.f4948lr = f4.floatValue();
            return c0931qr6;
        });
    });

    /* JADX INFO: renamed from: oB */
    private int f4943oB;

    /* JADX INFO: renamed from: fZ */
    private float f4944fZ;

    /* JADX INFO: renamed from: ga */
    private float f4945ga;

    /* JADX INFO: renamed from: oD */
    private int f4946oD;

    /* JADX INFO: renamed from: lq */
    private float f4947lq;

    /* JADX INFO: renamed from: lr */
    private float f4948lr;

    /* JADX INFO: renamed from: o */
    @NotNull
    private final ItemStack f4949o;

    public C0931qr() {
        this(Vec3.ZERO, 0, 0.0f, 0.0f);
    }

    public C0931qr(@NotNull Vec3 vec3, int i, float f, float f2) {
        super(vec3);
        this.f4946oD = 0;
        this.f4948lr = 0.0f;
        this.f4949o = new ItemStack((ItemLike) C1231wY.f7271mZ.get());
        this.f4943oB = i;
        this.f4944fZ = f;
        this.f4945ga = f2;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4946oD;
        this.f4946oD = i + 1;
        if (i >= this.f4943oB) {
            this.f4946oD = 0;
            if (clientLevel.isLoaded(BlockPos.containing(this.f4464c))) {
                m5013a(minecraft, c0622l, clientLevel, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Rocket: pitch=%.1f (±%.1f), yaw=%.1f (±%.1f)", Float.valueOf(this.f4944fZ), Float.valueOf(this.f4947lq), Float.valueOf(this.f4945ga), Float.valueOf(this.f4948lr))));
        list.add(Component.literal("Fire timer: " + this.f4946oD + "/" + this.f4943oB));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0854pT(Component.literal("Interval"), () -> {
            return Integer.valueOf(this.f4943oB);
        }, num -> {
            this.f4943oB = num.intValue();
        }, 0, 1200));
        objectArrayList.add(new C0853pS(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f4944fZ);
        }, f -> {
            this.f4944fZ = f.floatValue();
        }, -90.0f, 90.0f));
        objectArrayList.add(new C0853pS(Component.literal("Yaw"), () -> {
            return Float.valueOf(this.f4945ga);
        }, f2 -> {
            this.f4945ga = f2.floatValue();
        }, -180.0f, 180.0f));
        objectArrayList.add(new C0853pS(Component.literal("Pitch Width"), () -> {
            return Float.valueOf(this.f4947lq);
        }, f3 -> {
            this.f4947lq = f3.floatValue();
        }, 0.0f, 90.0f));
        objectArrayList.add(new C0853pS(Component.literal("Yaw Width"), () -> {
            return Float.valueOf(this.f4948lr);
        }, f4 -> {
            this.f4948lr = f4.floatValue();
        }, 0.0f, 180.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4941eu;
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
        this.f4946oD = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5013a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
        InterfaceC0724mw interfaceC0724mwCreate;
        float fM7849a = this.f4944fZ + C1290xm.m7849a(randomSource, this.f4947lq);
        float fM7849a2 = this.f4945ga + C1290xm.m7849a(randomSource, this.f4948lr);
        if (this.f4949o.isEmpty()) {
            return;
        }
        Item item = this.f4949o.getItem();
        if (item instanceof C1144ur) {
            C1119uS c1119uSM6347a = ((C1144ur) item).m6347a();
            if (c1119uSM6347a.m6224a() == EnumC1121uU.ENTITY) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, ParticleTypes.FLASH, this.f4464c.x + 0.10000000149011612d, this.f4464c.y, this.f4464c.z + 0.10000000149011612d, 0.0d, 0.0d, 0.0d);
                Supplier<EntityType<? extends InterfaceC0724mw>> supplierM6223b = c1119uSM6347a.m6223b();
                if (supplierM6223b != null && (interfaceC0724mwCreate = supplierM6223b.get().create(clientLevel)) != null) {
                    interfaceC0724mwCreate.mo3284a(this.f4464c, 2.0f, this.f4949o, fM7849a2, fM7849a);
                    interfaceC0724mwCreate.setPos(this.f4464c);
                    C0470iG.m2121a((Entity) interfaceC0724mwCreate, clientLevel);
                    clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, (SoundEvent) C1280xc.f7934wB.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
                }
            }
        }
    }
}
