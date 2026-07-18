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

/* JADX INFO: renamed from: com.boehmod.blockfront.qm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qm.class */
public class C0926qm extends AbstractC0835pA {

    /* JADX INFO: renamed from: ep */
    @NotNull
    private static final ResourceLocation f4896ep = C0564jv.m2555d("textures/misc/debug/mapeffect/entity.png");

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final MapCodec<C0926qm> f4897y = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("entity").forGetter(c0926qm -> {
            return C1292xo.m7894a(c0926qm.f4899c);
        }), Codec.INT.fieldOf("count").forGetter(c0926qm2 -> {
            return Integer.valueOf(c0926qm2.f4900M);
        }), BlockPos.CODEC.optionalFieldOf("leashPosition").forGetter(c0926qm3 -> {
            return Optional.ofNullable(c0926qm3.f4901c);
        })).apply(instance, (resourceLocation, num, optional) -> {
            C0926qm c0926qm4 = new C0926qm(Vec3.ZERO, C1292xo.m7895a(resourceLocation), num.intValue());
            optional.ifPresent(blockPos -> {
                c0926qm4.f4901c = blockPos;
            });
            return c0926qm4;
        });
    });

    /* JADX INFO: renamed from: gt */
    private boolean f4898gt;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Supplier<? extends EntityType<?>> f4899c;

    /* JADX INFO: renamed from: M */
    private int f4900M;

    /* JADX INFO: renamed from: c */
    @Nullable
    private BlockPos f4901c;

    /* JADX INFO: renamed from: a */
    @Nullable
    private LeashFenceKnotEntity f4902a;

    public C0926qm() {
        this(Vec3.ZERO, () -> {
            return EntityType.CHICKEN;
        }, 1);
    }

    public C0926qm(@NotNull Vec3 vec3, @NotNull Supplier<? extends EntityType<?>> supplier, int i) {
        super(vec3);
        this.f4898gt = false;
        this.f4899c = supplier;
        this.f4900M = i;
    }

    /* JADX INFO: renamed from: a */
    private boolean m4906a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (this.f4899c.get() == null) {
            return false;
        }
        EntityType<?> entityType = this.f4899c.get();
        BlockPos blockPosContaining = BlockPos.containing(this.f4464c);
        if (this.f4901c != null) {
            this.f4902a = LeashFenceKnotEntity.getOrCreateKnot(serverLevel, this.f4901c);
            CompoundTag persistentData = this.f4902a.getPersistentData();
            persistentData.putUUID(C0799oR.f4377bK, abstractC0787oF.m3628e());
            persistentData.putInt(C0799oR.f4379bM, abstractC0787oF.m3567aT());
        }
        for (int i = 0; i < this.f4900M; i++) {
            Leashable leashableSpawn = entityType.spawn(serverLevel, (ItemStack) null, (Player) null, blockPosContaining, MobSpawnType.COMMAND, false, false);
            if (leashableSpawn != null) {
                leashableSpawn.setPos(this.f4464c);
                CompoundTag persistentData2 = leashableSpawn.getPersistentData();
                persistentData2.putUUID(C0799oR.f4377bK, abstractC0787oF.m3628e());
                persistentData2.putBoolean(C0799oR.f4378bL, true);
                persistentData2.putInt(C0799oR.f4379bM, abstractC0787oF.m3567aT());
                if (this.f4902a != null && (leashableSpawn instanceof Leashable)) {
                    leashableSpawn.setLeashedTo(this.f4902a, true);
                    serverLevel.gameEvent(GameEvent.BLOCK_ATTACH, this.f4901c, GameEvent.Context.of(leashableSpawn));
                }
                if (leashableSpawn instanceof Saddleable) {
                    ((Saddleable) leashableSpawn).equipSaddle(new ItemStack(Items.SADDLE), (SoundSource) null);
                }
            }
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        if (!this.f4898gt) {
            this.f4898gt = m4906a(serverLevel, abstractC0787oF);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Entity: " + (this.f4899c.get() != null ? C1292xo.m7885c(this.f4899c) : "none") + " x" + this.f4900M + (this.f4898gt ? " (spawned)" : "")));
        if (this.f4901c != null) {
            list.add(Component.literal("Leashed to: " + this.f4901c.toShortString()));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0855pU(Component.literal("Entity Type"), () -> {
            return this.f4899c.get();
        }, entityType -> {
            this.f4899c = () -> {
                return entityType;
            };
        }, Component.literal("Select Entity Type"), () -> {
            return new ObjectArrayList(BuiltInRegistries.ENTITY_TYPE.stream().toList());
        }, entityType2 -> {
            return BuiltInRegistries.ENTITY_TYPE.getKey(entityType2).toString();
        }, entityType3 -> {
            return Component.literal(BuiltInRegistries.ENTITY_TYPE.getKey(entityType3).toString());
        }));
        objectArrayList.add(new C0854pT(Component.literal("Count"), () -> {
            return Integer.valueOf(this.f4900M);
        }, num -> {
            this.f4900M = num.intValue();
        }, 1, 100));
        objectArrayList.add(new C0849pO(Component.literal("Has Leash Position"), () -> {
            return Boolean.valueOf(this.f4901c != null);
        }, bool -> {
            if (!bool.booleanValue()) {
                this.f4901c = null;
            } else if (this.f4901c == null) {
                this.f4901c = BlockPos.ZERO;
            }
        }));
        objectArrayList.add(new C0848pN(Component.literal("Leash Position"), () -> {
            return this.f4901c != null ? this.f4901c : BlockPos.ZERO;
        }, blockPos -> {
            this.f4901c = blockPos;
        }));
        objectArrayList.add(new C0847pM(Component.literal("Clear Leash Position"), () -> {
            this.f4901c = null;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4896ep;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
        this.f4898gt = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
    }
}
