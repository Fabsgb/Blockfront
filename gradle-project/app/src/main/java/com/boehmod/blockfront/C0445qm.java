package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Leashable;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qm.class */
public class C0445qm extends pA {

    @NotNull
    private static final ResourceLocation ep = C0265jv.d("textures/misc/debug/mapeffect/entity.png");

    @NotNull
    public static final MapCodec<C0445qm> y = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("entity").forGetter(c0445qm -> {
            return C0636xo.a(c0445qm.c);
        }), Codec.INT.fieldOf("count").forGetter(c0445qm2 -> {
            return Integer.valueOf(c0445qm2.M);
        }), BlockPos.CODEC.optionalFieldOf("leashPosition").forGetter(c0445qm3 -> {
            return Optional.ofNullable(c0445qm3.f295c);
        })).apply(instance, (resourceLocation, num, optional) -> {
            C0445qm c0445qm4 = new C0445qm(Vec3.ZERO, C0636xo.a(resourceLocation), num.intValue());
            optional.ifPresent(blockPos -> {
                c0445qm4.f295c = blockPos;
            });
            return c0445qm4;
        });
    });
    private boolean gt;

    @NotNull
    public Supplier<? extends EntityType<?>> c;
    private int M;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    private BlockPos f295c;

    @Nullable
    private LeashFenceKnotEntity a;

    public C0445qm() {
        this(Vec3.ZERO, () -> {
            return EntityType.CHICKEN;
        }, 1);
    }

    public C0445qm(@NotNull Vec3 vec3, @NotNull Supplier<? extends EntityType<?>> supplier, int i) {
        super(vec3);
        this.gt = false;
        this.c = supplier;
        this.M = i;
    }

    private boolean a(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar) {
        if (this.c.get() == null) {
            return false;
        }
        EntityType<?> entityType = this.c.get();
        BlockPos blockPosContaining = BlockPos.containing(this.c);
        if (this.f295c != null) {
            this.a = LeashFenceKnotEntity.getOrCreateKnot(serverLevel, this.f295c);
            CompoundTag persistentData = this.a.getPersistentData();
            persistentData.putUUID(oR.bK, oFVar.m757e());
            persistentData.putInt(oR.bM, oFVar.aT());
        }
        for (int i = 0; i < this.M; i++) {
            Leashable leashableSpawn = entityType.spawn(serverLevel, (ItemStack) null, (Player) null, blockPosContaining, MobSpawnType.COMMAND, false, false);
            if (leashableSpawn != null) {
                leashableSpawn.setPos(this.c);
                CompoundTag persistentData2 = leashableSpawn.getPersistentData();
                persistentData2.putUUID(oR.bK, oFVar.m757e());
                persistentData2.putBoolean(oR.bL, true);
                persistentData2.putInt(oR.bM, oFVar.aT());
                if (this.a != null && (leashableSpawn instanceof Leashable)) {
                    leashableSpawn.setLeashedTo(this.a, true);
                    serverLevel.gameEvent(GameEvent.BLOCK_ATTACH, this.f295c, GameEvent.Context.of(leashableSpawn));
                }
                if (leashableSpawn instanceof Saddleable) {
                    ((Saddleable) leashableSpawn).equipSaddle(new ItemStack(Items.SADDLE), (SoundSource) null);
                }
            }
        }
        return true;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        if (!this.gt) {
            this.gt = a(serverLevel, oFVar);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Entity: " + (this.c.get() != null ? C0636xo.c(this.c) : "none") + " x" + this.M + (this.gt ? " (spawned)" : "")));
        if (this.f295c != null) {
            list.add(Component.literal("Leashed to: " + this.f295c.toShortString()));
        }
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pU(Component.literal("Entity Type"), () -> {
            return this.c.get();
        }, entityType -> {
            this.c = () -> {
                return entityType;
            };
        }, Component.literal("Select Entity Type"), () -> {
            return new ObjectArrayList(BuiltInRegistries.ENTITY_TYPE.stream().toList());
        }, entityType2 -> {
            return BuiltInRegistries.ENTITY_TYPE.getKey(entityType2).toString();
        }, entityType3 -> {
            return Component.literal(BuiltInRegistries.ENTITY_TYPE.getKey(entityType3).toString());
        }));
        objectArrayList.add(new pT(Component.literal("Count"), () -> {
            return Integer.valueOf(this.M);
        }, num -> {
            this.M = num.intValue();
        }, 1, 100));
        objectArrayList.add(new pO(Component.literal("Has Leash Position"), () -> {
            return Boolean.valueOf(this.f295c != null);
        }, bool -> {
            if (!bool.booleanValue()) {
                this.f295c = null;
            } else if (this.f295c == null) {
                this.f295c = BlockPos.ZERO;
            }
        }));
        objectArrayList.add(new pN(Component.literal("Leash Position"), () -> {
            return this.f295c != null ? this.f295c : BlockPos.ZERO;
        }, blockPos -> {
            this.f295c = blockPos;
        }));
        objectArrayList.add(new pM(Component.literal("Clear Leash Position"), () -> {
            this.f295c = null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ep;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
        this.gt = false;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
    }
}
