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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lG.class */
public class lG {
    public static final ObjectList<lG> H = new ObjectArrayList();
    public final String bk;
    public final DeferredHolder<Block, Block> s;
    public final DeferredHolder<Block, Block> t;
    public final DeferredHolder<Block, Block> u;
    public final DeferredHolder<Block, Block> v;
    public final DeferredHolder<Block, Block> w;
    public final DeferredHolder<Block, Block> x;
    public final DeferredHolder<Block, Block> y;

    public lG(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.bk = str;
        this.s = wL.c.register(str + "1", () -> {
            return new C0290kt(properties);
        });
        this.t = wL.c.register(str + "2", () -> {
            return new C0290kt(properties);
        });
        this.u = wL.c.register("small_" + str, () -> {
            return new C0290kt(properties);
        });
        this.v = wL.c.register(str + "_open1", () -> {
            return new C0309ll(properties);
        });
        this.w = wL.c.register(str + "_open2", () -> {
            return new C0309ll(properties);
        });
        this.x = wL.c.register("small_" + str + "_open", () -> {
            return new C0309ll(properties);
        });
        this.y = wL.c.register(str + "_field_open", () -> {
            return new C0294kx(this, str, properties) { // from class: com.boehmod.blockfront.lG.1
                @Override // com.boehmod.blockfront.C0294kx
                @Nullable
                public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
                    return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) wJ.as.get(str).get(), (level2, blockPos, blockState2, lPVar) -> {
                        lP.a(level2, lPVar);
                    });
                }
            };
        });
        H.add(this);
    }

    public void a(@Nonnull C0327mc c0327mc) {
        a(c0327mc, this.s, "1");
        a(c0327mc, this.t, "2");
        a(c0327mc, this.u);
        b(c0327mc, this.v, "1");
        b(c0327mc, this.w, "2");
        b(c0327mc, this.x);
        b(c0327mc, this.y, "_field");
    }

    public void a(@Nonnull C0329me c0329me) {
        c0329me.withExistingParent(this.s.getId().getPath(), this.s.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.t.getId().getPath(), this.t.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.u.getId().getPath(), this.u.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.v.getId().getPath(), this.v.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.w.getId().getPath(), this.w.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.x.getId().getPath(), this.x.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.y.getId().getPath(), this.y.getId().withPrefix("block/"));
    }

    public void a(C0330mf c0330mf) {
        String strC = C();
        c0330mf.add((Block) this.s.get(), strC);
        c0330mf.add((Block) this.t.get(), strC + " (Squint)");
        c0330mf.add((Block) this.v.get(), "Open " + strC + " (Empty)");
        c0330mf.add((Block) this.w.get(), "Open " + strC + " (Bullets)");
        c0330mf.add((Block) this.y.get(), "Open " + strC + " (Gun)");
        if (strC.equals("Crate Black")) {
            c0330mf.add((Block) this.u.get(), "Small Crate Oak");
            c0330mf.add((Block) this.x.get(), "Small Crate Oak (Open)");
        } else {
            c0330mf.add((Block) this.u.get(), "Small " + strC);
            c0330mf.add((Block) this.x.get(), "Small " + strC + " (Open)");
        }
    }

    public String C() {
        return (String) Arrays.stream(this.bk.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    private void a(C0327mc c0327mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0327mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/crate_base" + str)}).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/crate_base" + str)}).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath() + "_double", "block/crate_double_base" + str), a(c0327mc, deferredHolder.getId().getPath() + "_double_var", "block/crate_double_base" + str + "_var")});
    }

    private void a(C0327mc c0327mc, DeferredHolder<Block, Block> deferredHolder) {
        c0327mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/crate_base_small", "_small")}).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/crate_base_small", "_small")}).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath() + "_double", "block/crate_double_base_small", "_small")});
    }

    private void b(C0327mc c0327mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0327mc.horizontalBlock((Block) deferredHolder.get(), a(c0327mc, deferredHolder.getId().getPath(), "block/crate_open_base" + str).model);
    }

    private void b(C0327mc c0327mc, DeferredHolder<Block, Block> deferredHolder) {
        c0327mc.horizontalBlock((Block) deferredHolder.get(), a(c0327mc, deferredHolder.getId().getPath(), "block/crate_open_base_small", "_small").model);
    }

    private ConfiguredModel a(C0327mc c0327mc, String str, String str2, String str3) {
        return new ConfiguredModel(c0327mc.models().withExistingParent(str, c0327mc.modLoc(str2)).texture("0", c0327mc.modLoc("block/" + this.bk + str3)).texture("particle", c0327mc.modLoc("block/" + this.bk + str3)));
    }

    private ConfiguredModel a(C0327mc c0327mc, String str, String str2) {
        return a(c0327mc, str, str2, "");
    }
}
