package com.boehmod.blockfront;

import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lJ.class */
public class lJ {
    public static final ObjectList<lJ> J = new ObjectArrayList();
    public final String bn;
    public final DeferredHolder<Block, Block> L;
    public final DeferredHolder<Block, Block> M;
    public final DeferredHolder<Block, Block> N;

    public lJ(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.bn = str;
        this.L = wL.c.register(str, () -> {
            return new C0319lv(properties);
        });
        this.M = wL.c.register(str + "_left", () -> {
            return new C0319lv(properties);
        });
        this.N = wL.c.register(str + "_right", () -> {
            return new C0319lv(properties);
        });
        J.add(this);
    }

    public void a(@Nonnull C0327mc c0327mc) {
        c(c0327mc, this.L, "");
        c(c0327mc, this.M, "_left");
        c(c0327mc, this.N, "_right");
    }

    public void a(@Nonnull C0329me c0329me) {
        c0329me.withExistingParent(this.L.getId().getPath(), this.L.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.M.getId().getPath(), this.M.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.N.getId().getPath(), this.N.getId().withPrefix("block/"));
    }

    public void a(C0330mf c0330mf) {
        String strC = C();
        c0330mf.add((Block) this.L.get(), strC);
        c0330mf.add((Block) this.M.get(), strC + " (Left)");
        c0330mf.add((Block) this.N.get(), strC + " (Right)");
    }

    public String C() {
        return (String) Arrays.stream(this.bn.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    private void c(C0327mc c0327mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0327mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 0)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 90)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 180)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, Token.IDENTIFIER)});
    }

    private ConfiguredModel a(C0327mc c0327mc, String str, String str2, int i) {
        return new ConfiguredModel(c0327mc.models().withExistingParent(str, c0327mc.modLoc(str2)).texture("0", c0327mc.modLoc("block/" + this.bn)).texture("particle", c0327mc.modLoc("block/" + this.bn)), 0, i, false);
    }
}
