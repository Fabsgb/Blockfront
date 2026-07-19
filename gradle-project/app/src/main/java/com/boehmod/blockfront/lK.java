package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lK.class */
public class lK {

    @NotNull
    public static final ObjectList<lK> K = new ObjectArrayList();
    public final boolean dU;

    @NotNull
    public final String bo;

    @NotNull
    public final DeferredHolder<Block, ? extends Block> O;

    @NotNull
    public final DeferredHolder<Block, ? extends SlabBlock> P;

    @NotNull
    public final DeferredHolder<Block, ? extends StairBlock> Q;

    @NotNull
    public final DeferredHolder<Block, ? extends FenceBlock> R;

    @NotNull
    public final DeferredHolder<Block, ? extends FenceGateBlock> S;

    @NotNull
    public final DeferredHolder<Block, ? extends ButtonBlock> T;

    @NotNull
    public final DeferredHolder<Block, ? extends PressurePlateBlock> U;

    @Nullable
    public DeferredHolder<Block, ? extends RotatedPillarBlock> V;

    @Nullable
    public DeferredHolder<Block, ? extends RotatedPillarBlock> W;

    @Nullable
    public DeferredHolder<Block, ? extends LeavesBlock> X;

    public lK(@NotNull String str, boolean z, BlockBehaviour.Properties properties, @Nullable BlockBehaviour.Properties properties2) {
        this.dU = z;
        this.bo = str;
        this.O = wL.c.register(str + "_planks", () -> {
            return new Block(properties);
        });
        this.P = wL.c.register(str + "_slab", () -> {
            return new SlabBlock(properties);
        });
        this.Q = wL.c.register(str + "_stair", () -> {
            return new StairBlock(((Block) this.O.get()).defaultBlockState(), properties);
        });
        this.R = wL.c.register(str + "_fence", () -> {
            return new FenceBlock(properties);
        });
        this.S = wL.c.register(str + "_fence_gate", () -> {
            return new FenceGateBlock(WoodType.OAK, properties);
        });
        if (z) {
            this.V = wL.c.register(str + "_log", () -> {
                return new RotatedPillarBlock(properties);
            });
            this.W = wL.c.register("stripped_" + str + "_log", () -> {
                return new RotatedPillarBlock(properties);
            });
            this.X = wL.c.register(str + "_leaves", () -> {
                return new LeavesBlock(((BlockBehaviour.Properties) Objects.requireNonNull(properties2)).noOcclusion());
            });
        }
        this.T = wL.c.register(str + "_button", () -> {
            return new ButtonBlock(BlockSetType.OAK, 30, properties.noCollission());
        });
        this.U = wL.c.register(str + "_pressure_plate", () -> {
            return new PressurePlateBlock(BlockSetType.OAK, properties.noCollission());
        });
        K.add(this);
    }

    public void a(@NotNull C0327mc c0327mc) {
        c0327mc.simpleBlock((Block) this.O.get());
        c0327mc.slabBlock((SlabBlock) this.P.get(), c0327mc.blockTexture((Block) this.O.get()), c0327mc.blockTexture((Block) this.O.get()));
        c0327mc.stairsBlock((StairBlock) this.Q.get(), c0327mc.blockTexture((Block) this.O.get()));
        c0327mc.fenceBlock((FenceBlock) this.R.get(), c0327mc.blockTexture((Block) this.O.get()));
        c0327mc.fenceGateBlock((FenceGateBlock) this.S.get(), c0327mc.blockTexture((Block) this.O.get()));
        c0327mc.buttonBlock((ButtonBlock) this.T.get(), c0327mc.blockTexture((Block) this.O.get()));
        c0327mc.pressurePlateBlock((PressurePlateBlock) this.U.get(), c0327mc.blockTexture((Block) this.O.get()));
        if (this.dU) {
            c0327mc.logBlock((RotatedPillarBlock) ((DeferredHolder) Objects.requireNonNull(this.V)).get());
            c0327mc.logBlock((RotatedPillarBlock) ((DeferredHolder) Objects.requireNonNull(this.W)).get());
            c0327mc.simpleBlock((Block) ((DeferredHolder) Objects.requireNonNull(this.X)).get(), new ConfiguredModel[]{new ConfiguredModel(c0327mc.models().withExistingParent(this.X.getId().getPath(), "minecraft:block/leaves").texture("all", ResourceLocation.fromNamespaceAndPath("bf", "block/" + this.bo + "_leaves")))});
        }
    }

    public void a(@NotNull C0329me c0329me) {
        c0329me.withExistingParent(this.O.getId().getPath(), this.O.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.P.getId().getPath(), this.P.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.Q.getId().getPath(), this.Q.getId().withPrefix("block/"));
        c0329me.fenceInventory(this.R.getId().getPath(), this.O.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.S.getId().getPath(), this.S.getId().withPrefix("block/"));
        c0329me.buttonInventory(this.T.getId().getPath(), this.O.getId().withPrefix("block/"));
        c0329me.withExistingParent(this.U.getId().getPath(), this.U.getId().withPrefix("block/"));
        if (this.dU) {
            c0329me.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.V)).getId().getPath(), this.V.getId().withPrefix("block/"));
            c0329me.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.W)).getId().getPath(), this.W.getId().withPrefix("block/"));
            c0329me.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.X)).getId().getPath(), this.X.getId().withPrefix("block/"));
        }
    }

    public void a(C0330mf c0330mf) {
        String strC = C();
        c0330mf.add((Block) this.O.get(), strC + " Planks");
        c0330mf.add((Block) this.P.get(), strC + " Slab");
        c0330mf.add((Block) this.Q.get(), strC + " Stairs");
        c0330mf.add((Block) this.R.get(), strC + " Fence");
        c0330mf.add((Block) this.S.get(), strC + " Fence Gate");
        c0330mf.add((Block) this.T.get(), strC + " Button");
        c0330mf.add((Block) this.U.get(), strC + " Pressure Plate");
        if (this.dU) {
            c0330mf.add((Block) ((DeferredHolder) Objects.requireNonNull(this.V)).get(), strC + " Log");
            c0330mf.add((Block) ((DeferredHolder) Objects.requireNonNull(this.W)).get(), "Stripped " + strC + " Log");
            c0330mf.add((Block) ((DeferredHolder) Objects.requireNonNull(this.X)).get(), strC + " Leaves");
        }
    }

    @NotNull
    public String C() {
        return (String) Arrays.stream(this.bo.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }
}
