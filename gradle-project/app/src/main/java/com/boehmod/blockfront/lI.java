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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lI.class */
public class lI {
    public static final ObjectList<lI> I = new ObjectArrayList();
    public final String bm;
    public final DeferredHolder<Block, Block> z;
    public final DeferredHolder<Block, Block> A;
    public final DeferredHolder<Block, Block> B;
    public final DeferredHolder<Block, Block> C;
    public final DeferredHolder<Block, Block> D;
    public final DeferredHolder<Block, Block> E;
    public final DeferredHolder<Block, Block> F;
    public final DeferredHolder<Block, Block> G;
    public final DeferredHolder<Block, Block> H;

    /* JADX INFO: renamed from: I, reason: collision with other field name */
    public final DeferredHolder<Block, Block> f230I;
    public final DeferredHolder<Block, Block> J;
    public final DeferredHolder<Block, Block> K;

    public lI(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.bm = str;
        this.z = wL.c.register(str + "_leaning_0", () -> {
            return new kL(properties);
        });
        this.A = wL.c.register(str + "_leaning_1", () -> {
            return new kL(properties);
        });
        this.B = wL.c.register(str + "_leaning_2", () -> {
            return new kL(properties);
        });
        this.C = wL.c.register(str + "_leaning_3", () -> {
            return new kL(properties);
        });
        this.D = wL.c.register(str + "_leaning_4", () -> {
            return new kL(properties);
        });
        this.E = wL.c.register(str + "_pile_0", () -> {
            return new kL(properties);
        });
        this.F = wL.c.register(str + "_pile_1", () -> {
            return new kL(properties);
        });
        this.G = wL.c.register(str + "_pile_2", () -> {
            return new kL(properties);
        });
        this.H = wL.c.register(str + "_pile_3", () -> {
            return new kL(properties);
        });
        this.f230I = wL.c.register(str + "_single_0", () -> {
            return new kL(properties);
        });
        this.J = wL.c.register(str + "_single_1", () -> {
            return new kL(properties);
        });
        this.K = wL.c.register(str + "_single_2", () -> {
            return new kL(properties);
        });
        I.add(this);
    }

    public void a(@Nonnull C0327mc c0327mc) {
        c(c0327mc, this.z, "_leaning_0");
        c(c0327mc, this.A, "_leaning_1");
        c(c0327mc, this.B, "_leaning_2");
        c(c0327mc, this.C, "_leaning_3");
        c(c0327mc, this.D, "_leaning_4");
        c(c0327mc, this.E, "_pile_0");
        c(c0327mc, this.F, "_pile_1");
        c(c0327mc, this.G, "_pile_2");
        c(c0327mc, this.H, "_pile_3");
        c(c0327mc, this.f230I, "_single_0");
        c(c0327mc, this.J, "_single_1");
        c(c0327mc, this.K, "_single_2");
    }

    public void a(@Nonnull C0329me c0329me) {
        c0329me.withExistingParent(this.z.getId().getPath(), this.z.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.A.getId().getPath(), this.A.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.B.getId().getPath(), this.B.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.C.getId().getPath(), this.C.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.D.getId().getPath(), this.D.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.E.getId().getPath(), this.E.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.F.getId().getPath(), this.F.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.G.getId().getPath(), this.G.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.H.getId().getPath(), this.H.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.f230I.getId().getPath(), this.f230I.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.J.getId().getPath(), this.J.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.K.getId().getPath(), this.K.getId().withPrefix("block/"));
    }

    public void a(C0330mf c0330mf) {
        String strC = C();
        c0330mf.add((Block) this.z.get(), strC + " Leaning 0");
        c0330mf.add((Block) this.A.get(), strC + " Leaning 1");
        c0330mf.add((Block) this.B.get(), strC + " Leaning 2");
        c0330mf.add((Block) this.C.get(), strC + " Leaning 3");
        c0330mf.add((Block) this.D.get(), strC + " Leaning 4");
        c0330mf.add((Block) this.E.get(), strC + " Pile 0");
        c0330mf.add((Block) this.F.get(), strC + " Pile 1");
        c0330mf.add((Block) this.G.get(), strC + " Pile 2");
        c0330mf.add((Block) this.H.get(), strC + " Pile 3");
        c0330mf.add((Block) this.f230I.get(), strC + " Single 0");
        c0330mf.add((Block) this.J.get(), strC + " Single 1");
        c0330mf.add((Block) this.K.get(), strC + " Single 2");
    }

    public String C() {
        return (String) Arrays.stream(this.bm.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    private void c(C0327mc c0327mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0327mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/plank_base" + str, 180)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/plank_base" + str, Token.IDENTIFIER)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/plank_base" + str, 0)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST).addModels(new ConfiguredModel[]{a(c0327mc, deferredHolder.getId().getPath(), "block/plank_base" + str, 90)});
    }

    private ConfiguredModel a(C0327mc c0327mc, String str, String str2, int i) {
        return new ConfiguredModel(c0327mc.models().withExistingParent(str, c0327mc.modLoc(str2)).texture("0", c0327mc.modLoc("block/" + this.bm)).texture("particle", c0327mc.modLoc("block/" + this.bm)), 0, i, false);
    }
}
