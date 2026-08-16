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

/* JADX INFO: renamed from: com.boehmod.blockfront.mg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mg.class */
public class C0709mg {

    /* JADX INFO: renamed from: T */
    @NotNull
    public static final ObjectList<C0709mg> f3937T = new ObjectArrayList();

    /* JADX INFO: renamed from: en */
    public final boolean f3938en;

    /* JADX INFO: renamed from: bx */
    @NotNull
    public final String f3939bx;

    /* JADX INFO: renamed from: O */
    @NotNull
    public final DeferredHolder<Block, ? extends Block> f3940O;

    /* JADX INFO: renamed from: P */
    @NotNull
    public final DeferredHolder<Block, ? extends SlabBlock> f3941P;

    /* JADX INFO: renamed from: Q */
    @NotNull
    public final DeferredHolder<Block, ? extends StairBlock> f3942Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    public final DeferredHolder<Block, ? extends FenceBlock> f3943R;

    /* JADX INFO: renamed from: S */
    @NotNull
    public final DeferredHolder<Block, ? extends FenceGateBlock> f3944S;

    /* JADX INFO: renamed from: T */
    @NotNull
    public final DeferredHolder<Block, ? extends ButtonBlock> f3945T;

    /* JADX INFO: renamed from: U */
    @NotNull
    public final DeferredHolder<Block, ? extends PressurePlateBlock> f3946U;

    /* JADX INFO: renamed from: V */
    @Nullable
    public DeferredHolder<Block, ? extends RotatedPillarBlock> f3947V;

    /* JADX INFO: renamed from: W */
    @Nullable
    public DeferredHolder<Block, ? extends RotatedPillarBlock> f3948W;

    /* JADX INFO: renamed from: X */
    @Nullable
    public DeferredHolder<Block, ? extends LeavesBlock> f3949X;

    public C0709mg(@NotNull String str, boolean z, BlockBehaviour.Properties properties, @Nullable BlockBehaviour.Properties properties2) {
        this.f3938en = z;
        this.f3939bx = str;
        this.f3940O = C1295xi.f6989c.register(str + "_planks", () -> {
            return new Block(properties);
        });
        this.f3941P = C1295xi.f6989c.register(str + "_slab", () -> {
            return new SlabBlock(properties);
        });
        this.f3942Q = C1295xi.f6989c.register(str + "_stair", () -> {
            return new StairBlock(((Block) this.f3940O.get()).defaultBlockState(), properties);
        });
        this.f3943R = C1295xi.f6989c.register(str + "_fence", () -> {
            return new FenceBlock(properties);
        });
        this.f3944S = C1295xi.f6989c.register(str + "_fence_gate", () -> {
            return new FenceGateBlock(WoodType.OAK, properties);
        });
        if (z) {
            this.f3947V = C1295xi.f6989c.register(str + "_log", () -> {
                return new RotatedPillarBlock(properties);
            });
            this.f3948W = C1295xi.f6989c.register("stripped_" + str + "_log", () -> {
                return new RotatedPillarBlock(properties);
            });
            this.f3949X = C1295xi.f6989c.register(str + "_leaves", () -> {
                return new LeavesBlock(((BlockBehaviour.Properties) Objects.requireNonNull(properties2)).noOcclusion());
            });
        }
        this.f3945T = C1295xi.f6989c.register(str + "_button", () -> {
            return new ButtonBlock(BlockSetType.OAK, 30, properties.noCollission());
        });
        this.f3946U = C1295xi.f6989c.register(str + "_pressure_plate", () -> {
            return new PressurePlateBlock(BlockSetType.OAK, properties.noCollission());
        });
        f3937T.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m3219a(@NotNull C0727my c0727my) {
        c0727my.simpleBlock((Block) this.f3940O.get());
        c0727my.slabBlock((SlabBlock) this.f3941P.get(), c0727my.blockTexture((Block) this.f3940O.get()), c0727my.blockTexture((Block) this.f3940O.get()));
        c0727my.stairsBlock((StairBlock) this.f3942Q.get(), c0727my.blockTexture((Block) this.f3940O.get()));
        c0727my.fenceBlock((FenceBlock) this.f3943R.get(), c0727my.blockTexture((Block) this.f3940O.get()));
        c0727my.fenceGateBlock((FenceGateBlock) this.f3944S.get(), c0727my.blockTexture((Block) this.f3940O.get()));
        c0727my.buttonBlock((ButtonBlock) this.f3945T.get(), c0727my.blockTexture((Block) this.f3940O.get()));
        c0727my.pressurePlateBlock((PressurePlateBlock) this.f3946U.get(), c0727my.blockTexture((Block) this.f3940O.get()));
        if (this.f3938en) {
            c0727my.logBlock((RotatedPillarBlock) ((DeferredHolder) Objects.requireNonNull(this.f3947V)).get());
            c0727my.logBlock((RotatedPillarBlock) ((DeferredHolder) Objects.requireNonNull(this.f3948W)).get());
            c0727my.simpleBlock((Block) ((DeferredHolder) Objects.requireNonNull(this.f3949X)).get(), new ConfiguredModel[]{new ConfiguredModel(c0727my.models().withExistingParent(this.f3949X.getId().getPath(), "minecraft:block/leaves").texture("all", ResourceLocation.fromNamespaceAndPath("bf", "block/" + this.f3939bx + "_leaves")))});
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3220a(@NotNull C0677mA c0677mA) {
        c0677mA.withExistingParent(this.f3940O.getId().getPath(), this.f3940O.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3941P.getId().getPath(), this.f3941P.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3942Q.getId().getPath(), this.f3942Q.getId().withPrefix("block/"));
        c0677mA.fenceInventory(this.f3943R.getId().getPath(), this.f3940O.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3944S.getId().getPath(), this.f3944S.getId().withPrefix("block/"));
        c0677mA.buttonInventory(this.f3945T.getId().getPath(), this.f3940O.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3946U.getId().getPath(), this.f3946U.getId().withPrefix("block/"));
        if (this.f3938en) {
            c0677mA.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.f3947V)).getId().getPath(), this.f3947V.getId().withPrefix("block/"));
            c0677mA.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.f3948W)).getId().getPath(), this.f3948W.getId().withPrefix("block/"));
            c0677mA.withExistingParent(((DeferredHolder) Objects.requireNonNull(this.f3949X)).getId().getPath(), this.f3949X.getId().withPrefix("block/"));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3221a(C0678mB c0678mB) {
        String strM3222J = m3222J();
        c0678mB.add((Block) this.f3940O.get(), strM3222J + " Planks");
        c0678mB.add((Block) this.f3941P.get(), strM3222J + " Slab");
        c0678mB.add((Block) this.f3942Q.get(), strM3222J + " Stairs");
        c0678mB.add((Block) this.f3943R.get(), strM3222J + " Fence");
        c0678mB.add((Block) this.f3944S.get(), strM3222J + " Fence Gate");
        c0678mB.add((Block) this.f3945T.get(), strM3222J + " Button");
        c0678mB.add((Block) this.f3946U.get(), strM3222J + " Pressure Plate");
        if (this.f3938en) {
            c0678mB.add((Block) ((DeferredHolder) Objects.requireNonNull(this.f3947V)).get(), strM3222J + " Log");
            c0678mB.add((Block) ((DeferredHolder) Objects.requireNonNull(this.f3948W)).get(), "Stripped " + strM3222J + " Log");
            c0678mB.add((Block) ((DeferredHolder) Objects.requireNonNull(this.f3949X)).get(), strM3222J + " Leaves");
        }
    }

    @NotNull
    /* JADX INFO: renamed from: J */
    public String m3222J() {
        return (String) Arrays.stream(this.f3939bx.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }
}
