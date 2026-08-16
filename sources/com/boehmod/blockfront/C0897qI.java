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

/* JADX INFO: renamed from: com.boehmod.blockfront.qI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qI.class */
public class C0897qI extends AbstractC0858pW {

    /* JADX INFO: renamed from: en */
    @NotNull
    private static final ResourceLocation f4976en = C0532jO.m2378d("textures/misc/debug/mapeffect/entity.png");

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final MapCodec<C0897qI> f4977y = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("entity").forGetter(c0897qI -> {
            return C1272xL.m7221a(c0897qI.f4979c);
        }), Codec.INT.fieldOf("count").forGetter(c0897qI2 -> {
            return Integer.valueOf(c0897qI2.f4980aA);
        }), BlockPos.CODEC.optionalFieldOf("leashPosition").forGetter(c0897qI3 -> {
            return Optional.ofNullable(c0897qI3.f4981c);
        })).apply(instance, (resourceLocation, num, optional) -> {
            C0897qI c0897qI4 = new C0897qI(Vec3.ZERO, C1272xL.m7222a(resourceLocation), num.intValue());
            optional.ifPresent(blockPos -> {
                c0897qI4.f4981c = blockPos;
            });
            return c0897qI4;
        });
    });

    /* JADX INFO: renamed from: gN */
    private boolean f4978gN;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Supplier<? extends EntityType<?>> f4979c;

    /* JADX INFO: renamed from: aA */
    private int f4980aA;

    /* JADX INFO: renamed from: c */
    @Nullable
    private BlockPos f4981c;

    /* JADX INFO: renamed from: a */
    @Nullable
    private LeashFenceKnotEntity f4982a;

    public C0897qI() {
        this(Vec3.ZERO, () -> {
            return EntityType.CHICKEN;
        }, 1);
    }

    public C0897qI(@NotNull Vec3 vec3, @NotNull Supplier<? extends EntityType<?>> supplier, int i) {
        super(vec3);
        this.f4978gN = false;
        this.f4979c = supplier;
        this.f4980aA = i;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4778a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (this.f4979c.get() == null) {
            return false;
        }
        EntityType<?> entityType = this.f4979c.get();
        BlockPos blockPosContaining = BlockPos.containing(this.f4593c);
        if (this.f4981c != null) {
            this.f4982a = LeashFenceKnotEntity.getOrCreateKnot(serverLevel, this.f4981c);
            CompoundTag persistentData = this.f4982a.getPersistentData();
            persistentData.putUUID(C0875pn.f4773bU, abstractC0863pb.m4064e());
            persistentData.putInt(C0875pn.f4775bW, abstractC0863pb.m4003bi());
        }
        for (int i = 0; i < this.f4980aA; i++) {
            Leashable leashableSpawn = entityType.spawn(serverLevel, (ItemStack) null, (Player) null, blockPosContaining, MobSpawnType.COMMAND, false, false);
            if (leashableSpawn != null) {
                leashableSpawn.setPos(this.f4593c);
                CompoundTag persistentData2 = leashableSpawn.getPersistentData();
                persistentData2.putUUID(C0875pn.f4773bU, abstractC0863pb.m4064e());
                persistentData2.putBoolean(C0875pn.f4774bV, true);
                persistentData2.putInt(C0875pn.f4775bW, abstractC0863pb.m4003bi());
                if (this.f4982a != null && (leashableSpawn instanceof Leashable)) {
                    leashableSpawn.setLeashedTo(this.f4982a, true);
                    serverLevel.gameEvent(GameEvent.BLOCK_ATTACH, this.f4981c, GameEvent.Context.of(leashableSpawn));
                }
                if (leashableSpawn instanceof Saddleable) {
                    ((Saddleable) leashableSpawn).equipSaddle(new ItemStack(Items.SADDLE), (SoundSource) null);
                }
            }
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        if (!this.f4978gN) {
            this.f4978gN = m4778a(serverLevel, abstractC0863pb);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Entity: " + (this.f4979c.get() != null ? C1272xL.m7212c(this.f4979c) : "none") + " x" + this.f4980aA + (this.f4978gN ? " (spawned)" : "")));
        if (this.f4981c != null) {
            list.add(Component.literal("Leashed to: " + this.f4981c.toShortString()));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0931qq(Component.literal("Entity Type"), () -> {
            return this.f4979c.get();
        }, entityType -> {
            this.f4979c = () -> {
                return entityType;
            };
        }, Component.literal("Select Entity Type"), () -> {
            return new ObjectArrayList(BuiltInRegistries.ENTITY_TYPE.stream().toList());
        }, entityType2 -> {
            return BuiltInRegistries.ENTITY_TYPE.getKey(entityType2).toString();
        }, entityType3 -> {
            return Component.literal(BuiltInRegistries.ENTITY_TYPE.getKey(entityType3).toString());
        }));
        objectArrayList.add(new C0930qp(Component.literal("Count"), () -> {
            return Integer.valueOf(this.f4980aA);
        }, num -> {
            this.f4980aA = num.intValue();
        }, 1, 100));
        objectArrayList.add(new C0925qk(Component.literal("Has Leash Position"), () -> {
            return Boolean.valueOf(this.f4981c != null);
        }, bool -> {
            if (!bool.booleanValue()) {
                this.f4981c = null;
            } else if (this.f4981c == null) {
                this.f4981c = BlockPos.ZERO;
            }
        }));
        objectArrayList.add(new C0924qj(Component.literal("Leash Position"), () -> {
            return this.f4981c != null ? this.f4981c : BlockPos.ZERO;
        }, blockPos -> {
            this.f4981c = blockPos;
        }));
        objectArrayList.add(new C0923qi(Component.literal("Clear Leash Position"), () -> {
            this.f4981c = null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4976en;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
        this.f4978gN = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
    }
}
