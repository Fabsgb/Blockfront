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

/* JADX INFO: renamed from: com.boehmod.blockfront.lK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lK.class */
public class C0633lK {

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final ObjectList<C0633lK> f3463K = new ObjectArrayList();

    /* JADX INFO: renamed from: dU */
    public final boolean f3464dU;

    /* JADX INFO: renamed from: bo */
    @NotNull
    public final String f3465bo;

    /* JADX INFO: renamed from: O */
    @NotNull
    public final DeferredHolder<Block, ? extends Block> f3466O;

    /* JADX INFO: renamed from: P */
    @NotNull
    public final DeferredHolder<Block, ? extends SlabBlock> f3467P;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public final DeferredHolder<Block, ? extends StairBlock> f3468Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    public final DeferredHolder<Block, ? extends FenceBlock> f3469R;

    /* JADX INFO: renamed from: S */
    @NotNull
    public final DeferredHolder<Block, ? extends FenceGateBlock> f3470S;

    /* JADX INFO: renamed from: T */
    @NotNull
    public final DeferredHolder<Block, ? extends ButtonBlock> f3471T;

    /* JADX INFO: renamed from: U */
    @NotNull
    public final DeferredHolder<Block, ? extends PressurePlateBlock> f3472U;

    /* JADX INFO: renamed from: V */
    @Nullable
    public DeferredHolder<Block, ? extends RotatedPillarBlock> f3473V;

    /* JADX INFO: renamed from: W */
    @Nullable
    public DeferredHolder<Block, ? extends RotatedPillarBlock> f3474W;

    /* JADX INFO: renamed from: X */
    @Nullable
    public DeferredHolder<Block, ? extends LeavesBlock> f3475X;

    public C0633lK(@NotNull String str, boolean z, BlockBehaviour.Properties properties, @Nullable BlockBehaviour.Properties properties2) {
        this.f3464dU = z;
        this.f3465bo = str;
        this.f3466O = C1218wL.f6426c.register(str + "_planks", () -> {
            return new Block(properties);
        });
        this.f3467P = C1218wL.f6426c.register(str + "_slab", () -> {
            return new SlabBlock(properties);
        });
        this.f3468Q = C1218wL.f6426c.register(str + "_stair", () -> {
            return new StairBlock(((Block) this.f3466O.get()).defaultBlockState(), properties);
        });
        this.f3469R = C1218wL.f6426c.register(str + "_fence", () -> {
            return new FenceBlock(properties);
        });
        this.f3470S = C1218wL.f6426c.register(str + "_fence_gate", () -> {
            return new FenceGateBlock(WoodType.OAK, properties);
        });
        if (z) {
            this.f3473V = C1218wL.f6426c.register(str + "_log", () -> {
                return new RotatedPillarBlock(properties);
            });
            this.f3474W = C1218wL.f6426c.register("stripped_" + str + "_log", () -> {
                return new RotatedPillarBlock(properties);
            });
            this.f3475X = C1218wL.f6426c.register(str + "_leaves", () -> {
                return new LeavesBlock(((BlockBehaviour.Properties) Objects.requireNonNull(properties2)).noOcclusion());
            });
        }
        this.f3471T = C1218wL.f6426c.register(str + "_button", () -> {
            return new ButtonBlock(BlockSetType.OAK, 30, properties.noCollission());
        });
        this.f3472U = C1218wL.f6426c.register(str + "_pressure_plate", () -> {
            return new PressurePlateBlock(BlockSetType.OAK, properties.noCollission());
        });
        f3463K.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m2788a(@NotNull C0704mc c0704mc) {
        c0704mc.simpleBlock((Block) this.f3466O.get());
        c0704mc.slabBlock((SlabBlock) this.f3467P.get(), c0704mc.blockTexture((Block) this.f3466O.get()), c0704mc.blockTexture((Block) this.f3466O.get()));
        c0704mc.stairsBlock((StairBlock) this.f3468Q.get(), c0704mc.blockTexture((Block) this.f3466O.get()));
        c0704mc.fenceBlock((FenceBlock) this.f3469R.get(), c0704mc.blockTexture((Block) this.f3466O.get()));
        c0704mc.fenceGateBlock((FenceGateBlock) this.f3470S.get(), c0704mc.blockTexture((Block) this.f3466O.get()));
        c0704mc.buttonBlock((ButtonBlock) this.f3471T.get(), c0704mc.blockTexture((Block) this.f3466O.get()));
        c0704mc.pressurePlateBlock((PressurePlateBlock) this.f3472U.get(), c0704mc.blockTexture((Block) this.f3466O.get()));
        if (this.f3464dU) {
            c0704mc.logBlock((RotatedPillarBlock) ((DeferredHolder) Objects.requireNonNull(this.f3473V)).get());
            c0704mc.logBlock((RotatedPillarBlock) ((DeferredHolder) Objects.requireNonNull(this.f3474W)).get());
            c0704mc.simpleBlock((Block) ((DeferredHolder) Objects.requireNonNull(this.f3475X)).get(), new ConfiguredModel[]{new ConfiguredModel(c0704mc.models().withExistingParent(this.f3475X.getId().getPath(), "minecraft:block/leaves").texture("all", ResourceLocation.fromNamespaceAndPath("bf", "block/" + this.f3465bo + "_leaves")))});
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2789a(@NotNull C0706me c0706me) {
        c0706me.withExistingParent(this.f3466O.getId().getPath(), this.f3466O.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3467P.getId().getPath(), this.f3467P.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3468Q.getId().getPath(), this.f3468Q.getId().withPrefix("block/"));
        c0706me.fenceInventory(this.f3469R.getId().getPath(), this.f3466O.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3470S.getId().getPath(), this.f3470S.getId().withPrefix("block/"));
        c0706me.buttonInventory(this.f3471T.getId().getPath(), this.f3466O.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3472U.getId().getPath(), this.f3472U.getId().withPrefix("block/"));
        if (this.f3464dU) {
            c0706me.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.f3473V)).getId().getPath(), this.f3473V.getId().withPrefix("block/"));
            c0706me.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.f3474W)).getId().getPath(), this.f3474W.getId().withPrefix("block/"));
            c0706me.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.f3475X)).getId().getPath(), this.f3475X.getId().withPrefix("block/"));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2790a(C0707mf c0707mf) {
        String strM2791C = m2791C();
        c0707mf.add((Block) this.f3466O.get(), strM2791C + " Planks");
        c0707mf.add((Block) this.f3467P.get(), strM2791C + " Slab");
        c0707mf.add((Block) this.f3468Q.get(), strM2791C + " Stairs");
        c0707mf.add((Block) this.f3469R.get(), strM2791C + " Fence");
        c0707mf.add((Block) this.f3470S.get(), strM2791C + " Fence Gate");
        c0707mf.add((Block) this.f3471T.get(), strM2791C + " Button");
        c0707mf.add((Block) this.f3472U.get(), strM2791C + " Pressure Plate");
        if (this.f3464dU) {
            c0707mf.add((Block) ((DeferredHolder) Objects.requireNonNull(this.f3473V)).get(), strM2791C + " Log");
            c0707mf.add((Block) ((DeferredHolder) Objects.requireNonNull(this.f3474W)).get(), "Stripped " + strM2791C + " Log");
            c0707mf.add((Block) ((DeferredHolder) Objects.requireNonNull(this.f3475X)).get(), strM2791C + " Leaves");
        }
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public String m2791C() {
        return (String) Arrays.stream(this.f3465bo.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }
}
