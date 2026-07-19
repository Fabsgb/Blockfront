package com.boehmod.blockfront;

import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lF.class */
public class lF {

    @NotNull
    public static final ObjectList<lF> G = new ObjectArrayList();

    @NotNull
    private static final List<String> Z = Arrays.asList("deepslate_cobbled_tiles", "feldspar_bricks", "limestone_polished", "limestone_polished_brick", "stone_brick", "stone_cobbled", "stone_cracked_brick", "stone_stone");
    public final boolean dS;
    public final boolean dT;

    @NotNull
    public final String bj;

    @NotNull
    public final DeferredHolder<Block, ? extends Block> o;

    @NotNull
    public final DeferredHolder<Block, ? extends SlabBlock> p;

    @NotNull
    public final DeferredHolder<Block, ? extends StairBlock> q;

    @NotNull
    public final DeferredHolder<Block, ? extends WallBlock> r;

    @Nullable
    public static lF a(@NotNull String str, @NotNull BlockBehaviour.Properties properties, boolean z) {
        if (Z.contains(str)) {
            return null;
        }
        return new lF(str, properties, true, z);
    }

    public lF(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this(str, properties, true, false);
    }

    public lF(@NotNull String str, @NotNull BlockBehaviour.Properties properties, boolean z, boolean z2) {
        this.bj = str;
        this.dS = z;
        this.dT = z2;
        this.o = wL.c.register(str, () -> {
            return new Block(properties);
        });
        this.p = wL.c.register(str + "_slab", () -> {
            return new SlabBlock(properties);
        });
        this.q = wL.c.register(str + "_stair", () -> {
            return new StairBlock(((Block) this.o.get()).defaultBlockState(), properties);
        });
        this.r = wL.c.register(str + "_wall", () -> {
            return new WallBlock(properties);
        });
        G.add(this);
    }

    public void a(@NotNull C0327mc c0327mc) {
        if (this.dS && this.dT) {
            c0327mc.getVariantBuilder((Block) this.o.get()).partialState().addModels(new ConfiguredModel[]{a(c0327mc, this.o.getId().getPath(), false, 0), a(c0327mc, this.o.getId().getPath() + "_mirrored", true, 0), a(c0327mc, this.o.getId().getPath(), false, 90), a(c0327mc, this.o.getId().getPath() + "_mirrored", true, 90), a(c0327mc, this.o.getId().getPath(), false, 180), a(c0327mc, this.o.getId().getPath() + "_mirrored", true, 180), a(c0327mc, this.o.getId().getPath(), false, Token.IDENTIFIER), a(c0327mc, this.o.getId().getPath() + "_mirrored", true, Token.IDENTIFIER)});
        } else if (this.dS) {
            c0327mc.simpleBlock((Block) this.o.get());
        }
        c0327mc.slabBlock((SlabBlock) this.p.get(), c0327mc.blockTexture((Block) this.o.get()), c0327mc.blockTexture((Block) this.o.get()));
        c0327mc.stairsBlock((StairBlock) this.q.get(), c0327mc.blockTexture((Block) this.o.get()));
        c0327mc.wallBlock((WallBlock) this.r.get(), c0327mc.blockTexture((Block) this.o.get()));
    }

    public void a(@NotNull C0329me c0329me) {
        c0329me.withExistingParent(this.o.getId().getPath(), this.o.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.p.getId().getPath(), this.p.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.q.getId().getPath(), this.q.getId().withPrefix("block/"));
        c0329me.wallInventory(this.r.getId().getPath(), this.o.getId().withPrefix("block/"));
    }

    public void a(C0330mf c0330mf) {
        String strC = C();
        c0330mf.add((Block) this.o.get(), strC);
        c0330mf.add((Block) this.p.get(), strC + " Slab");
        c0330mf.add((Block) this.q.get(), strC + " Stairs");
        c0330mf.add((Block) this.r.get(), strC + " Wall");
    }

    @NotNull
    public String C() {
        return (String) Arrays.stream(this.bj.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    @NotNull
    public ConfiguredModel a(@NotNull C0327mc c0327mc, @NotNull String str, boolean z, int i) {
        return new ConfiguredModel(c0327mc.models().withExistingParent(str, z ? "minecraft:block/cube_mirrored_all" : "minecraft:block/cube_all").texture("all", c0327mc.modLoc("block/" + this.bj)), 0, i, false);
    }
}
