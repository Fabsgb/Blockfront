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

/* JADX INFO: renamed from: com.boehmod.blockfront.lG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lG.class */
public class C0629lG {

    /* JADX INFO: renamed from: H */
    public static final ObjectList<C0629lG> f3416H = new ObjectArrayList();

    /* JADX INFO: renamed from: bk */
    public final String f3417bk;

    /* JADX INFO: renamed from: s */
    public final DeferredHolder<Block, Block> f3418s;

    /* JADX INFO: renamed from: t */
    public final DeferredHolder<Block, Block> f3419t;

    /* JADX INFO: renamed from: u */
    public final DeferredHolder<Block, Block> f3420u;

    /* JADX INFO: renamed from: v */
    public final DeferredHolder<Block, Block> f3421v;

    /* JADX INFO: renamed from: w */
    public final DeferredHolder<Block, Block> f3422w;

    /* JADX INFO: renamed from: x */
    public final DeferredHolder<Block, Block> f3423x;

    /* JADX INFO: renamed from: y */
    public final DeferredHolder<Block, Block> f3424y;

    public C0629lG(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.f3417bk = str;
        this.f3418s = C1218wL.f6426c.register(str + "1", () -> {
            return new C0615kt(properties);
        });
        this.f3419t = C1218wL.f6426c.register(str + "2", () -> {
            return new C0615kt(properties);
        });
        this.f3420u = C1218wL.f6426c.register("small_" + str, () -> {
            return new C0615kt(properties);
        });
        this.f3421v = C1218wL.f6426c.register(str + "_open1", () -> {
            return new C0660ll(properties);
        });
        this.f3422w = C1218wL.f6426c.register(str + "_open2", () -> {
            return new C0660ll(properties);
        });
        this.f3423x = C1218wL.f6426c.register("small_" + str + "_open", () -> {
            return new C0660ll(properties);
        });
        this.f3424y = C1218wL.f6426c.register(str + "_field_open", () -> {
            return new C0619kx(this, str, properties) { // from class: com.boehmod.blockfront.lG.1
                @Override // com.boehmod.blockfront.C0619kx
                @Nullable
                public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
                    return BaseEntityBlock.createTickerHelper(blockEntityType, (BlockEntityType) C1216wJ.f6368as.get(str).get(), (level2, blockPos, blockState2, c0638lP) -> {
                        C0638lP.m2830a(level2, c0638lP);
                    });
                }
            };
        });
        f3416H.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m2740a(@Nonnull C0704mc c0704mc) {
        m2744a(c0704mc, this.f3418s, "1");
        m2744a(c0704mc, this.f3419t, "2");
        m2745a(c0704mc, this.f3420u);
        m2746b(c0704mc, this.f3421v, "1");
        m2746b(c0704mc, this.f3422w, "2");
        m2747b(c0704mc, this.f3423x);
        m2746b(c0704mc, this.f3424y, "_field");
    }

    /* JADX INFO: renamed from: a */
    public void m2741a(@Nonnull C0706me c0706me) {
        c0706me.withExistingParent(this.f3418s.getId().getPath(), this.f3418s.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3419t.getId().getPath(), this.f3419t.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3420u.getId().getPath(), this.f3420u.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3421v.getId().getPath(), this.f3421v.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3422w.getId().getPath(), this.f3422w.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3423x.getId().getPath(), this.f3423x.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3424y.getId().getPath(), this.f3424y.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m2742a(C0707mf c0707mf) {
        String strM2743C = m2743C();
        c0707mf.add((Block) this.f3418s.get(), strM2743C);
        c0707mf.add((Block) this.f3419t.get(), strM2743C + " (Squint)");
        c0707mf.add((Block) this.f3421v.get(), "Open " + strM2743C + " (Empty)");
        c0707mf.add((Block) this.f3422w.get(), "Open " + strM2743C + " (Bullets)");
        c0707mf.add((Block) this.f3424y.get(), "Open " + strM2743C + " (Gun)");
        if (strM2743C.equals("Crate Black")) {
            c0707mf.add((Block) this.f3420u.get(), "Small Crate Oak");
            c0707mf.add((Block) this.f3423x.get(), "Small Crate Oak (Open)");
        } else {
            c0707mf.add((Block) this.f3420u.get(), "Small " + strM2743C);
            c0707mf.add((Block) this.f3423x.get(), "Small " + strM2743C + " (Open)");
        }
    }

    /* JADX INFO: renamed from: C */
    public String m2743C() {
        return (String) Arrays.stream(this.f3417bk.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    /* JADX INFO: renamed from: a */
    private void m2744a(C0704mc c0704mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0704mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{m2749a(c0704mc, deferredHolder.getId().getPath(), "block/crate_base" + str)}).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{m2749a(c0704mc, deferredHolder.getId().getPath(), "block/crate_base" + str)}).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{m2749a(c0704mc, deferredHolder.getId().getPath() + "_double", "block/crate_double_base" + str), m2749a(c0704mc, deferredHolder.getId().getPath() + "_double_var", "block/crate_double_base" + str + "_var")});
    }

    /* JADX INFO: renamed from: a */
    private void m2745a(C0704mc c0704mc, DeferredHolder<Block, Block> deferredHolder) {
        c0704mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{m2748a(c0704mc, deferredHolder.getId().getPath(), "block/crate_base_small", "_small")}).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{m2748a(c0704mc, deferredHolder.getId().getPath(), "block/crate_base_small", "_small")}).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{m2748a(c0704mc, deferredHolder.getId().getPath() + "_double", "block/crate_double_base_small", "_small")});
    }

    /* JADX INFO: renamed from: b */
    private void m2746b(C0704mc c0704mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0704mc.horizontalBlock((Block) deferredHolder.get(), m2749a(c0704mc, deferredHolder.getId().getPath(), "block/crate_open_base" + str).model);
    }

    /* JADX INFO: renamed from: b */
    private void m2747b(C0704mc c0704mc, DeferredHolder<Block, Block> deferredHolder) {
        c0704mc.horizontalBlock((Block) deferredHolder.get(), m2748a(c0704mc, deferredHolder.getId().getPath(), "block/crate_open_base_small", "_small").model);
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m2748a(C0704mc c0704mc, String str, String str2, String str3) {
        return new ConfiguredModel(c0704mc.models().withExistingParent(str, c0704mc.modLoc(str2)).texture("0", c0704mc.modLoc("block/" + this.f3417bk + str3)).texture("particle", c0704mc.modLoc("block/" + this.f3417bk + str3)));
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m2749a(C0704mc c0704mc, String str, String str2) {
        return m2748a(c0704mc, str, str2, "");
    }
}
