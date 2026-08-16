package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mc.class */
public class C0705mc {

    /* JADX INFO: renamed from: Q */
    public static final ObjectList<C0705mc> f3890Q = new ObjectArrayList();

    /* JADX INFO: renamed from: bt */
    public final String f3891bt;

    /* JADX INFO: renamed from: s */
    public final DeferredHolder<Block, Block> f3892s;

    /* JADX INFO: renamed from: t */
    public final DeferredHolder<Block, Block> f3893t;

    /* JADX INFO: renamed from: u */
    public final DeferredHolder<Block, Block> f3894u;

    /* JADX INFO: renamed from: v */
    public final DeferredHolder<Block, Block> f3895v;

    /* JADX INFO: renamed from: w */
    public final DeferredHolder<Block, Block> f3896w;

    /* JADX INFO: renamed from: x */
    public final DeferredHolder<Block, Block> f3897x;

    /* JADX INFO: renamed from: y */
    public final DeferredHolder<Block, Block> f3898y;

    public C0705mc(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.f3891bt = str;
        this.f3892s = C1295xi.f6989c.register(str + "1", () -> {
            return new C0586kP(properties);
        });
        this.f3893t = C1295xi.f6989c.register(str + "2", () -> {
            return new C0586kP(properties);
        });
        this.f3894u = C1295xi.f6989c.register("small_" + str, () -> {
            return new C0586kP(properties);
        });
        this.f3895v = C1295xi.f6989c.register(str + "_open1", () -> {
            return new C0631lH(properties);
        });
        this.f3896w = C1295xi.f6989c.register(str + "_open2", () -> {
            return new C0631lH(properties);
        });
        this.f3897x = C1295xi.f6989c.register("small_" + str + "_open", () -> {
            return new C0631lH(properties);
        });
        this.f3898y = C1295xi.f6989c.register(str + "_field_open", () -> {
            return new C0590kT(this, str, properties) { // from class: com.boehmod.blockfront.mc.1
                @Override // com.boehmod.blockfront.C0590kT
                @Nullable
                public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
                    return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) C1293xg.f6931as.get(str).get(), (level2, blockPos, blockState2, c0714ml) -> {
                        C0714ml.m3261a(level2, c0714ml);
                    });
                }
            };
        });
        f3890Q.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m3171a(@Nonnull C0727my c0727my) {
        m3175a(c0727my, this.f3892s, "1");
        m3175a(c0727my, this.f3893t, "2");
        m3176a(c0727my, this.f3894u);
        m3177b(c0727my, this.f3895v, "1");
        m3177b(c0727my, this.f3896w, "2");
        m3178b(c0727my, this.f3897x);
        m3177b(c0727my, this.f3898y, "_field");
    }

    /* JADX INFO: renamed from: a */
    public void m3172a(@Nonnull C0677mA c0677mA) {
        c0677mA.withExistingParent(this.f3892s.getId().getPath(), this.f3892s.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3893t.getId().getPath(), this.f3893t.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3894u.getId().getPath(), this.f3894u.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3895v.getId().getPath(), this.f3895v.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3896w.getId().getPath(), this.f3896w.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3897x.getId().getPath(), this.f3897x.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3898y.getId().getPath(), this.f3898y.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m3173a(C0678mB c0678mB) {
        String strM3174J = m3174J();
        c0678mB.add((Block) this.f3892s.get(), strM3174J);
        c0678mB.add((Block) this.f3893t.get(), strM3174J + " (Squint)");
        c0678mB.add((Block) this.f3895v.get(), "Open " + strM3174J + " (Empty)");
        c0678mB.add((Block) this.f3896w.get(), "Open " + strM3174J + " (Bullets)");
        c0678mB.add((Block) this.f3898y.get(), "Open " + strM3174J + " (Gun)");
        if (strM3174J.equals("Crate Black")) {
            c0678mB.add((Block) this.f3894u.get(), "Small Crate Oak");
            c0678mB.add((Block) this.f3897x.get(), "Small Crate Oak (Open)");
        } else {
            c0678mB.add((Block) this.f3894u.get(), "Small " + strM3174J);
            c0678mB.add((Block) this.f3897x.get(), "Small " + strM3174J + " (Open)");
        }
    }

    /* JADX INFO: renamed from: J */
    public String m3174J() {
        return (String) Arrays.stream(this.f3891bt.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    /* JADX INFO: renamed from: a */
    private void m3175a(C0727my c0727my, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0727my.getVariantBuilder((Block) deferredHolder.get()).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{m3180a(c0727my, deferredHolder.getId().getPath(), "block/crate_base" + str)}).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{m3180a(c0727my, deferredHolder.getId().getPath(), "block/crate_base" + str)}).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{m3180a(c0727my, deferredHolder.getId().getPath() + "_double", "block/crate_double_base" + str), m3180a(c0727my, deferredHolder.getId().getPath() + "_double_var", "block/crate_double_base" + str + "_var")});
    }

    /* JADX INFO: renamed from: a */
    private void m3176a(C0727my c0727my, DeferredHolder<Block, Block> deferredHolder) {
        c0727my.getVariantBuilder((Block) deferredHolder.get()).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{m3179a(c0727my, deferredHolder.getId().getPath(), "block/crate_base_small", "_small")}).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{m3179a(c0727my, deferredHolder.getId().getPath(), "block/crate_base_small", "_small")}).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{m3179a(c0727my, deferredHolder.getId().getPath() + "_double", "block/crate_double_base_small", "_small")});
    }

    /* JADX INFO: renamed from: b */
    private void m3177b(C0727my c0727my, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0727my.horizontalBlock((Block) deferredHolder.get(), m3180a(c0727my, deferredHolder.getId().getPath(), "block/crate_open_base" + str).model);
    }

    /* JADX INFO: renamed from: b */
    private void m3178b(C0727my c0727my, DeferredHolder<Block, Block> deferredHolder) {
        c0727my.horizontalBlock((Block) deferredHolder.get(), m3179a(c0727my, deferredHolder.getId().getPath(), "block/crate_open_base_small", "_small").model);
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m3179a(C0727my c0727my, String str, String str2, String str3) {
        return new ConfiguredModel(c0727my.models().withExistingParent(str, c0727my.modLoc(str2)).texture("0", c0727my.modLoc("block/" + this.f3891bt + str3)).texture("particle", c0727my.modLoc("block/" + this.f3891bt + str3)));
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m3180a(C0727my c0727my, String str, String str2) {
        return m3179a(c0727my, str, str2, "");
    }
}
