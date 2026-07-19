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

/* JADX INFO: renamed from: com.boehmod.blockfront.qr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qr.class */
public class C0450qr extends pA {

    @NotNull
    private static final ResourceLocation eu = C0265jv.d("textures/misc/debug/mapeffect/rocket_positioned.png");

    @NotNull
    public static final MapCodec<C0450qr> D = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("interval").forGetter(c0450qr -> {
            return Integer.valueOf(c0450qr.oB);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0450qr2 -> {
            return Float.valueOf(c0450qr2.fZ);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0450qr3 -> {
            return Float.valueOf(c0450qr3.ga);
        }), Codec.FLOAT.fieldOf("pitchWidth").forGetter(c0450qr4 -> {
            return Float.valueOf(c0450qr4.lq);
        }), Codec.FLOAT.fieldOf("yawWidth").forGetter(c0450qr5 -> {
            return Float.valueOf(c0450qr5.lr);
        })).apply(instance, (num, f, f2, f3, f4) -> {
            C0450qr c0450qr6 = new C0450qr(Vec3.ZERO, num.intValue(), f.floatValue(), f2.floatValue());
            c0450qr6.lq = f3.floatValue();
            c0450qr6.lr = f4.floatValue();
            return c0450qr6;
        });
    });
    private int oB;
    private float fZ;
    private float ga;
    private int oD;
    private float lq;
    private float lr;

    @NotNull
    private final ItemStack o;

    public C0450qr() {
        this(Vec3.ZERO, 0, 0.0f, 0.0f);
    }

    public C0450qr(@NotNull Vec3 vec3, int i, float f, float f2) {
        super(vec3);
        this.oD = 0;
        this.lr = 0.0f;
        this.o = new ItemStack((ItemLike) wY.mZ.get());
        this.oB = i;
        this.fZ = f;
        this.ga = f2;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.oD;
        this.oD = i + 1;
        if (i >= this.oB) {
            this.oD = 0;
            if (clientLevel.isLoaded(BlockPos.containing(this.c))) {
                a(minecraft, c0297l, clientLevel, randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal(String.format("Rocket: pitch=%.1f (±%.1f), yaw=%.1f (±%.1f)", Float.valueOf(this.fZ), Float.valueOf(this.lq), Float.valueOf(this.ga), Float.valueOf(this.lr))));
        list.add(Component.literal("Fire timer: " + this.oD + "/" + this.oB));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pT(Component.literal("Interval"), () -> {
            return Integer.valueOf(this.oB);
        }, num -> {
            this.oB = num.intValue();
        }, 0, 1200));
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
        return eu;
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
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
        InterfaceC0347mw interfaceC0347mwCreate;
        float fA = this.fZ + C0634xm.a(randomSource, this.lq);
        float fA2 = this.ga + C0634xm.a(randomSource, this.lr);
        if (this.o.isEmpty()) {
            return;
        }
        Item item = this.o.getItem();
        if (item instanceof C0558ur) {
            uS uSVarM1210a = ((C0558ur) item).m1210a();
            if (uSVarM1210a.m1177a() == uU.ENTITY) {
                iG.a(minecraft, c0297l, clientLevel, ParticleTypes.FLASH, this.c.x + 0.10000000149011612d, this.c.y, this.c.z + 0.10000000149011612d, 0.0d, 0.0d, 0.0d);
                Supplier<EntityType<? extends InterfaceC0347mw>> supplierB = uSVarM1210a.b();
                if (supplierB != null && (interfaceC0347mwCreate = supplierB.get().create(clientLevel)) != null) {
                    interfaceC0347mwCreate.a(this.c, 2.0f, this.o, fA2, fA);
                    interfaceC0347mwCreate.setPos(this.c);
                    iG.a((Entity) interfaceC0347mwCreate, clientLevel);
                    clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.wB.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
                }
            }
        }
    }
}
