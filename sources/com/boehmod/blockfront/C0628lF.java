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

/* JADX INFO: renamed from: com.boehmod.blockfront.lF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lF.class */
public class C0628lF {

    /* JADX INFO: renamed from: G */
    @NotNull
    public static final ObjectList<C0628lF> f3407G = new ObjectArrayList();

    /* JADX INFO: renamed from: Z */
    @NotNull
    private static final List<String> f3408Z = Arrays.asList("deepslate_cobbled_tiles", "feldspar_bricks", "limestone_polished", "limestone_polished_brick", "stone_brick", "stone_cobbled", "stone_cracked_brick", "stone_stone");

    /* JADX INFO: renamed from: dS */
    public final boolean f3409dS;

    /* JADX INFO: renamed from: dT */
    public final boolean f3410dT;

    /* JADX INFO: renamed from: bj */
    @NotNull
    public final String f3411bj;

    /* JADX INFO: renamed from: o */
    @NotNull
    public final DeferredHolder<Block, ? extends Block> f3412o;

    /* JADX INFO: renamed from: p */
    @NotNull
    public final DeferredHolder<Block, ? extends SlabBlock> f3413p;

    /* JADX INFO: renamed from: q */
    @NotNull
    public final DeferredHolder<Block, ? extends StairBlock> f3414q;

    /* JADX INFO: renamed from: r */
    @NotNull
    public final DeferredHolder<Block, ? extends WallBlock> f3415r;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0628lF m2729a(@NotNull String str, @NotNull BlockBehaviour.Properties properties, boolean z) {
        if (f3408Z.contains(str)) {
            return null;
        }
        return new C0628lF(str, properties, true, z);
    }

    public C0628lF(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this(str, properties, true, false);
    }

    public C0628lF(@NotNull String str, @NotNull BlockBehaviour.Properties properties, boolean z, boolean z2) {
        this.f3411bj = str;
        this.f3409dS = z;
        this.f3410dT = z2;
        this.f3412o = C1218wL.f6426c.register(str, () -> {
            return new Block(properties);
        });
        this.f3413p = C1218wL.f6426c.register(str + "_slab", () -> {
            return new SlabBlock(properties);
        });
        this.f3414q = C1218wL.f6426c.register(str + "_stair", () -> {
            return new StairBlock(((Block) this.f3412o.get()).defaultBlockState(), properties);
        });
        this.f3415r = C1218wL.f6426c.register(str + "_wall", () -> {
            return new WallBlock(properties);
        });
        f3407G.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m2730a(@NotNull C0704mc c0704mc) {
        if (this.f3409dS && this.f3410dT) {
            c0704mc.getVariantBuilder((Block) this.f3412o.get()).partialState().addModels(new ConfiguredModel[]{m2734a(c0704mc, this.f3412o.getId().getPath(), false, 0), m2734a(c0704mc, this.f3412o.getId().getPath() + "_mirrored", true, 0), m2734a(c0704mc, this.f3412o.getId().getPath(), false, 90), m2734a(c0704mc, this.f3412o.getId().getPath() + "_mirrored", true, 90), m2734a(c0704mc, this.f3412o.getId().getPath(), false, 180), m2734a(c0704mc, this.f3412o.getId().getPath() + "_mirrored", true, 180), m2734a(c0704mc, this.f3412o.getId().getPath(), false, Token.IDENTIFIER), m2734a(c0704mc, this.f3412o.getId().getPath() + "_mirrored", true, Token.IDENTIFIER)});
        } else if (this.f3409dS) {
            c0704mc.simpleBlock((Block) this.f3412o.get());
        }
        c0704mc.slabBlock((SlabBlock) this.f3413p.get(), c0704mc.blockTexture((Block) this.f3412o.get()), c0704mc.blockTexture((Block) this.f3412o.get()));
        c0704mc.stairsBlock((StairBlock) this.f3414q.get(), c0704mc.blockTexture((Block) this.f3412o.get()));
        c0704mc.wallBlock((WallBlock) this.f3415r.get(), c0704mc.blockTexture((Block) this.f3412o.get()));
    }

    /* JADX INFO: renamed from: a */
    public void m2731a(@NotNull C0706me c0706me) {
        c0706me.withExistingParent(this.f3412o.getId().getPath(), this.f3412o.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3413p.getId().getPath(), this.f3413p.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3414q.getId().getPath(), this.f3414q.getId().withPrefix("block/"));
        c0706me.wallInventory(this.f3415r.getId().getPath(), this.f3412o.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m2732a(C0707mf c0707mf) {
        String strM2733C = m2733C();
        c0707mf.add((Block) this.f3412o.get(), strM2733C);
        c0707mf.add((Block) this.f3413p.get(), strM2733C + " Slab");
        c0707mf.add((Block) this.f3414q.get(), strM2733C + " Stairs");
        c0707mf.add((Block) this.f3415r.get(), strM2733C + " Wall");
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public String m2733C() {
        return (String) Arrays.stream(this.f3411bj.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ConfiguredModel m2734a(@NotNull C0704mc c0704mc, @NotNull String str, boolean z, int i) {
        return new ConfiguredModel(c0704mc.models().withExistingParent(str, z ? "minecraft:block/cube_mirrored_all" : "minecraft:block/cube_all").texture("all", c0704mc.modLoc("block/" + this.f3411bj)), 0, i, false);
    }
}
