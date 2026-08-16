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

/* JADX INFO: renamed from: com.boehmod.blockfront.mb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mb.class */
public class C0704mb {

    /* JADX INFO: renamed from: P */
    @NotNull
    public static final ObjectList<C0704mb> f3881P = new ObjectArrayList();

    /* JADX INFO: renamed from: ag */
    @NotNull
    private static final List<String> f3882ag = Arrays.asList("deepslate_cobbled_tiles", "feldspar_bricks", "limestone_polished", "limestone_polished_brick", "stone_brick", "stone_cobbled", "stone_cracked_brick", "stone_stone");

    /* JADX INFO: renamed from: el */
    public final boolean f3883el;

    /* JADX INFO: renamed from: em */
    public final boolean f3884em;

    /* JADX INFO: renamed from: bs */
    @NotNull
    public final String f3885bs;

    /* JADX INFO: renamed from: o */
    @NotNull
    public final DeferredHolder<Block, ? extends Block> f3886o;

    /* JADX INFO: renamed from: p */
    @NotNull
    public final DeferredHolder<Block, ? extends SlabBlock> f3887p;

    /* JADX INFO: renamed from: q */
    @NotNull
    public final DeferredHolder<Block, ? extends StairBlock> f3888q;

    /* JADX INFO: renamed from: r */
    @NotNull
    public final DeferredHolder<Block, ? extends WallBlock> f3889r;

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0704mb m3160a(@NotNull String str, @NotNull BlockBehaviour.Properties properties, boolean z) {
        if (f3882ag.contains(str)) {
            return null;
        }
        return new C0704mb(str, properties, true, z);
    }

    public C0704mb(@NotNull String str, @NotNull BlockBehaviour.Properties properties) {
        this(str, properties, true, false);
    }

    public C0704mb(@NotNull String str, @NotNull BlockBehaviour.Properties properties, boolean z, boolean z2) {
        this.f3885bs = str;
        this.f3883el = z;
        this.f3884em = z2;
        this.f3886o = C1295xi.f6989c.register(str, () -> {
            return new Block(properties);
        });
        this.f3887p = C1295xi.f6989c.register(str + "_slab", () -> {
            return new SlabBlock(properties);
        });
        this.f3888q = C1295xi.f6989c.register(str + "_stair", () -> {
            return new StairBlock(((Block) this.f3886o.get()).defaultBlockState(), properties);
        });
        this.f3889r = C1295xi.f6989c.register(str + "_wall", () -> {
            return new WallBlock(properties);
        });
        f3881P.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m3161a(@NotNull C0727my c0727my) {
        if (this.f3883el && this.f3884em) {
            c0727my.getVariantBuilder((Block) this.f3886o.get()).partialState().addModels(new ConfiguredModel[]{m3165a(c0727my, this.f3886o.getId().getPath(), false, 0), m3165a(c0727my, this.f3886o.getId().getPath() + "_mirrored", true, 0), m3165a(c0727my, this.f3886o.getId().getPath(), false, 90), m3165a(c0727my, this.f3886o.getId().getPath() + "_mirrored", true, 90), m3165a(c0727my, this.f3886o.getId().getPath(), false, 180), m3165a(c0727my, this.f3886o.getId().getPath() + "_mirrored", true, 180), m3165a(c0727my, this.f3886o.getId().getPath(), false, Token.IDENTIFIER), m3165a(c0727my, this.f3886o.getId().getPath() + "_mirrored", true, Token.IDENTIFIER)});
        } else if (this.f3883el) {
            c0727my.simpleBlock((Block) this.f3886o.get());
        }
        c0727my.slabBlock((SlabBlock) this.f3887p.get(), c0727my.blockTexture((Block) this.f3886o.get()), c0727my.blockTexture((Block) this.f3886o.get()));
        c0727my.stairsBlock((StairBlock) this.f3888q.get(), c0727my.blockTexture((Block) this.f3886o.get()));
        c0727my.wallBlock((WallBlock) this.f3889r.get(), c0727my.blockTexture((Block) this.f3886o.get()));
    }

    /* JADX INFO: renamed from: a */
    public void m3162a(@NotNull C0677mA c0677mA) {
        c0677mA.withExistingParent(this.f3886o.getId().getPath(), this.f3886o.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3887p.getId().getPath(), this.f3887p.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3888q.getId().getPath(), this.f3888q.getId().withPrefix("block/"));
        c0677mA.wallInventory(this.f3889r.getId().getPath(), this.f3886o.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m3163a(C0678mB c0678mB) {
        String strM3164J = m3164J();
        c0678mB.add((Block) this.f3886o.get(), strM3164J);
        c0678mB.add((Block) this.f3887p.get(), strM3164J + " Slab");
        c0678mB.add((Block) this.f3888q.get(), strM3164J + " Stairs");
        c0678mB.add((Block) this.f3889r.get(), strM3164J + " Wall");
    }

    @NotNull
    /* JADX INFO: renamed from: J */
    public String m3164J() {
        return (String) Arrays.stream(this.f3885bs.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ConfiguredModel m3165a(@NotNull C0727my c0727my, @NotNull String str, boolean z, int i) {
        return new ConfiguredModel(c0727my.models().withExistingParent(str, z ? "minecraft:block/cube_mirrored_all" : "minecraft:block/cube_all").texture("all", c0727my.modLoc("block/" + this.f3885bs)), 0, i, false);
    }
}
