package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xi.class */
public final class C1295xi {

    /* JADX INFO: renamed from: vo */
    private static final int f6987vo = 15;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final DeferredRegister<Block> f6988b = DeferredRegister.createBlocks("bf");

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final DeferredRegister<Block> f6989c = DeferredRegister.createBlocks("bf");

    /* JADX INFO: renamed from: a */
    public static final C0645lV f6990a = new C0645lV("map_barrier", false, false, entity -> {
        if (entity == null) {
            return false;
        }
        return (((entity instanceof Player) && ((Player) entity).isCreative()) || (entity instanceof AbstractC0699mW) || (entity instanceof C0737nH)) ? false : true;
    });

    /* JADX INFO: renamed from: b */
    public static final C0645lV f6991b = new C0645lV("map_barrier_solid", true, false, entity -> {
        return ((entity instanceof Player) && ((Player) entity).isCreative()) ? false : true;
    });

    /* JADX INFO: renamed from: c */
    public static final C0645lV f6992c = new C0645lV("map_barrier_bots", false, false, entity -> {
        return entity instanceof C0756na;
    });

    /* JADX INFO: renamed from: d */
    public static final C0645lV f6993d = new C0645lV("map_barrier_players", false, true, entity -> {
        return (entity instanceof Player) && !((Player) entity).isCreative();
    });

    /* JADX INFO: renamed from: cJ */
    public static final DeferredHolder<Block, ? extends Block> f6994cJ = f6988b.register("shisa", () -> {
        return new C0666lq(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cK */
    public static final DeferredHolder<Block, ? extends Block> f6995cK = f6988b.register("power_line", () -> {
        return new C0658li(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cL */
    public static final DeferredHolder<Block, ? extends Block> f6996cL = f6988b.register("power_line_wall", () -> {
        return new C0659lj(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cM */
    public static final DeferredHolder<Block, ? extends Block> f6997cM = f6988b.register("wall_stand", () -> {
        return new C0637lN(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cN */
    public static final DeferredHolder<Block, ? extends Block> f6998cN = f6988b.register("industrial_lamp", () -> {
        return new C0584kN(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: a */
    public static final C0705mc f6999a = new C0705mc("crate", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: b */
    public static final C0705mc f7000b = new C0705mc("crate_black", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: c */
    public static final C0705mc f7001c = new C0705mc("crate_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: d */
    public static final C0705mc f7002d = new C0705mc("crate_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: e */
    public static final C0705mc f7003e = new C0705mc("crate_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: f */
    public static final C0705mc f7004f = new C0705mc("crate_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: g */
    public static final C0705mc f7005g = new C0705mc("crate_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: h */
    public static final C0705mc f7006h = new C0705mc("crate_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: i */
    public static final C0705mc f7007i = new C0705mc("crate_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: j */
    public static final C0705mc f7008j = new C0705mc("crate_walnut_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: k */
    public static final C0705mc f7009k = new C0705mc("crate_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: cO */
    public static final DeferredHolder<Block, ? extends Block> f7010cO = f6988b.register("sandbag", () -> {
        return new C0665lp(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cP */
    public static final DeferredHolder<Block, ? extends Block> f7011cP = f6988b.register("sandbag_snow", () -> {
        return new C0665lp(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cQ */
    public static final DeferredHolder<Block, ? extends Block> f7012cQ = f6988b.register("sandbag_green", () -> {
        return new C0665lp(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cR */
    public static final DeferredHolder<Block, ? extends Block> f7013cR = f6988b.register("sandbag_green_snow", () -> {
        return new C0665lp(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cS */
    public static final DeferredHolder<Block, ? extends Block> f7014cS = f6988b.register("dead_horse_1", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cT */
    public static final DeferredHolder<Block, ? extends Block> f7015cT = f6988b.register("dead_horse_2", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cU */
    public static final DeferredHolder<Block, ? extends Block> f7016cU = f6988b.register("dead_horse_3", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cV */
    public static final DeferredHolder<Block, ? extends Block> f7017cV = f6988b.register("dead_horse_4", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cW */
    public static final DeferredHolder<Block, ? extends Block> f7018cW = f6988b.register("bronze_horse_statue", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cX */
    public static final DeferredHolder<Block, ? extends Block> f7019cX = f6988b.register("stone_horse_statue", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cY */
    public static final DeferredHolder<Block, ? extends Block> f7020cY = f6988b.register("monte_statue_1", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cZ */
    public static final DeferredHolder<Block, ? extends Block> f7021cZ = f6988b.register("monte_statue_2", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: da */
    public static final DeferredHolder<Block, ? extends Block> f7022da = f6988b.register("fountain", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: db */
    public static final DeferredHolder<Block, ? extends Block> f7023db = f6988b.register("oil_barrel_red", () -> {
        return new C0655lf(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dc */
    public static final DeferredHolder<Block, ? extends Block> f7024dc = f6988b.register("oil_barrel_white", () -> {
        return new C0655lf(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dd */
    public static final DeferredHolder<Block, ? extends Block> f7025dd = f6988b.register("oil_barrel_green", () -> {
        return new C0655lf(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: de */
    public static final DeferredHolder<Block, ? extends Block> f7026de = f6988b.register("oil_barrel_yellow", () -> {
        return new C0655lf(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: df */
    public static final DeferredHolder<Block, ? extends Block> f7027df = f6988b.register("oil_barrel_gray", () -> {
        return new C0655lf(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dg */
    public static final DeferredHolder<Block, ? extends Block> f7028dg = f6988b.register("telephone", () -> {
        return new C0626lC(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dh */
    public static final DeferredHolder<Block, ? extends Block> f7029dh = f6988b.register("wall_telephone", () -> {
        return new C0638lO(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: di */
    public static final DeferredHolder<Block, ? extends Block> f7030di = f6988b.register("wall_telephone_black", () -> {
        return new C0638lO(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dj */
    public static final DeferredHolder<Block, ? extends Block> f7031dj = f6988b.register("radio_civilian", () -> {
        return new C0661ll(1.0f, 0.0f, 4.0f, 15.0f, 10.0f, 12.0f, null, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dk */
    public static final DeferredHolder<Block, ? extends Block> f7032dk = f6988b.register("radio_german", () -> {
        return new C0661ll(1.0f, 0.0f, 4.0f, 15.0f, 10.0f, 12.0f, C1312xz.f8163tc, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dl */
    public static final DeferredHolder<Block, ? extends Block> f7033dl = f6988b.register("radio_american", () -> {
        return new C0661ll(0.0f, 0.0f, 6.0f, 16.0f, 13.0f, 16.0f, C1312xz.f8164td, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dm */
    public static final DeferredHolder<Block, ? extends Block> f7034dm = f6988b.register("typewriter", () -> {
        return new C0630lG(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dn */
    public static final DeferredHolder<Block, ? extends Block> f7035dn = f6988b.register("shop_wall_sign_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: do */
    public static final DeferredHolder<Block, ? extends Block> f7036do = f6988b.register("shop_wall_sign_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dp */
    public static final DeferredHolder<Block, ? extends Block> f7037dp = f6988b.register("shop_wall_sign_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dq */
    public static final DeferredHolder<Block, ? extends Block> f7038dq = f6988b.register("shop_wall_sign_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dr */
    public static final DeferredHolder<Block, ? extends Block> f7039dr = f6988b.register("shop_wall_sign_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ds */
    public static final DeferredHolder<Block, ? extends Block> f7040ds = f6988b.register("shop_wall_sign_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dt */
    public static final DeferredHolder<Block, ? extends Block> f7041dt = f6988b.register("shop_wall_sign_6", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: du */
    public static final DeferredHolder<Block, ? extends Block> f7042du = f6988b.register("shop_wall_sign_7", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dv */
    public static final DeferredHolder<Block, ? extends Block> f7043dv = f6988b.register("shop_wall_sign_8", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dw */
    public static final DeferredHolder<Block, ? extends Block> f7044dw = f6988b.register("shop_wall_sign_9", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dx */
    public static final DeferredHolder<Block, ? extends Block> f7045dx = f6988b.register("shop_wall_sign_10", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dy */
    public static final DeferredHolder<Block, ? extends Block> f7046dy = f6988b.register("shop_wall_sign_11", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dz */
    public static final DeferredHolder<Block, ? extends Block> f7047dz = f6988b.register("shop_wall_sign_12", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dA */
    public static final DeferredHolder<Block, ? extends Block> f7048dA = f6988b.register("shop_wall_sign_13", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dB */
    public static final DeferredHolder<Block, ? extends Block> f7049dB = f6988b.register("metal_ladder", () -> {
        return new LadderBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dC */
    public static final DeferredHolder<Block, ? extends Block> f7050dC = f6988b.register("metal_bars", () -> {
        return new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dD */
    public static final DeferredHolder<Block, ? extends Block> f7051dD = f6988b.register("metal_grate", () -> {
        return new C0653ld(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dE */
    public static final DeferredHolder<Block, ? extends Block> f7052dE = f6988b.register("white_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dF */
    public static final DeferredHolder<Block, ? extends Block> f7053dF = f6988b.register("orange_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dG */
    public static final DeferredHolder<Block, ? extends Block> f7054dG = f6988b.register("magenta_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dH */
    public static final DeferredHolder<Block, ? extends Block> f7055dH = f6988b.register("light_blue_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dI */
    public static final DeferredHolder<Block, ? extends Block> f7056dI = f6988b.register("yellow_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dJ */
    public static final DeferredHolder<Block, ? extends Block> f7057dJ = f6988b.register("lime_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dK */
    public static final DeferredHolder<Block, ? extends Block> f7058dK = f6988b.register("pink_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dL */
    public static final DeferredHolder<Block, ? extends Block> f7059dL = f6988b.register("gray_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dM */
    public static final DeferredHolder<Block, ? extends Block> f7060dM = f6988b.register("light_gray_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dN */
    public static final DeferredHolder<Block, ? extends Block> f7061dN = f6988b.register("cyan_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dO */
    public static final DeferredHolder<Block, ? extends Block> f7062dO = f6988b.register("purple_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dP */
    public static final DeferredHolder<Block, ? extends Block> f7063dP = f6988b.register("blue_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dQ */
    public static final DeferredHolder<Block, ? extends Block> f7064dQ = f6988b.register("brown_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dR */
    public static final DeferredHolder<Block, ? extends Block> f7065dR = f6988b.register("green_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dS */
    public static final DeferredHolder<Block, ? extends Block> f7066dS = f6988b.register("red_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dT */
    public static final DeferredHolder<Block, ? extends Block> f7067dT = f6988b.register("black_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dU */
    public static final DeferredHolder<Block, ? extends Block> f7068dU = f6988b.register("street_lamp", () -> {
        return new C0671lv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: dV */
    public static final DeferredHolder<Block, ? extends Block> f7069dV = f6988b.register("wall_lamp", () -> {
        return new C0635lL(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: dW */
    public static final DeferredHolder<Block, ? extends Block> f7070dW = f6988b.register("desk_lamp", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return 12;
        }));
    });

    /* JADX INFO: renamed from: dX */
    public static final DeferredHolder<Block, ? extends Block> f7071dX = f6988b.register("desk_microphone", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dY */
    public static final DeferredHolder<Block, ? extends Block> f7072dY = f6988b.register("ceiling_light", () -> {
        return new C0584kN(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: dZ */
    public static final DeferredHolder<Block, ? extends Block> f7073dZ = f6988b.register("barbed_wire_end", () -> {
        return new C0578kH(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ea */
    public static final DeferredHolder<Block, ? extends Block> f7074ea = f6988b.register("barbed_wire_mid", () -> {
        return new C0578kH(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eb */
    public static final DeferredHolder<Block, ? extends Block> f7075eb = f6988b.register("barbed_wire_mid_cross", () -> {
        return new C0578kH(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ec */
    public static final DeferredHolder<Block, ? extends Block> f7076ec = f6988b.register("mine_sign_0", () -> {
        return new C0654le(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ed */
    public static final DeferredHolder<Block, ? extends Block> f7077ed = f6988b.register("mine_sign_1", () -> {
        return new C0654le(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ee */
    public static final DeferredHolder<Block, ? extends Block> f7078ee = f6988b.register("mine_sign_small_0", () -> {
        return new C0654le(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ef */
    public static final DeferredHolder<Block, ? extends Block> f7079ef = f6988b.register("military_document_one", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eg */
    public static final DeferredHolder<Block, ? extends Block> f7080eg = f6988b.register("military_document_few", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eh */
    public static final DeferredHolder<Block, ? extends Block> f7081eh = f6988b.register("military_document_stack", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ei */
    public static final DeferredHolder<Block, ? extends Block> f7082ei = f6988b.register("piano", () -> {
        return new C0656lg(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: ej */
    public static final DeferredHolder<Block, ? extends Block> f7083ej = f6988b.register("bunker_light", () -> {
        return new C0582kL(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: ek */
    public static final DeferredHolder<Block, ? extends Block> f7084ek = f6988b.register("bunker_light_2", () -> {
        return new C0582kL(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: el */
    public static final DeferredHolder<Block, ? extends Block> f7085el = f6988b.register("marble_railing", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: em */
    public static final DeferredHolder<Block, ? extends Block> f7086em = f6988b.register("wall_postbox", () -> {
        return new C0636lM(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: en */
    public static final DeferredHolder<Block, ? extends Block> f7087en = f6988b.register("watering_can", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eo */
    public static final DeferredHolder<Block, ? extends Block> f7088eo = f6988b.register("support_beam", () -> {
        return new C0672lw(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ep */
    public static final DeferredHolder<Block, ? extends Block> f7089ep = f6988b.register("swinging_log", () -> {
        return new C0673lx(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eq */
    public static final DeferredHolder<Block, ? extends Block> f7090eq = f6988b.register("wind_chime", () -> {
        return new C0640lQ(BlockBehaviour.Properties.of().sound(SoundType.CHAIN).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: er */
    public static final DeferredHolder<Block, ? extends Block> f7091er = f6988b.register("fusebox", () -> {
        return new C0593kW(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: es */
    public static final DeferredHolder<Block, ? extends Block> f7092es = f6988b.register("fusebox_open", () -> {
        return new C0593kW(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: et */
    public static final DeferredHolder<Block, ? extends Block> f7093et = f6988b.register("fusebox_doorless", () -> {
        return new C0593kW(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eu */
    public static final DeferredHolder<Block, ? extends Block> f7094eu = f6988b.register("flak88_shield", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6935bL);
    });

    /* JADX INFO: renamed from: ev */
    public static final DeferredHolder<Block, ? extends Block> f7095ev = f6988b.register("flak88_shield_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6936bM);
    });

    /* JADX INFO: renamed from: ew */
    public static final DeferredHolder<Block, ? extends Block> f7096ew = f6988b.register("flak88_noshield", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6937bN);
    });

    /* JADX INFO: renamed from: ex */
    public static final DeferredHolder<Block, ? extends Block> f7097ex = f6988b.register("flak88_noshield_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6938bO);
    });

    /* JADX INFO: renamed from: ey */
    public static final DeferredHolder<Block, ? extends Block> f7098ey = f6988b.register("flak38", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6943bT);
    });

    /* JADX INFO: renamed from: ez */
    public static final DeferredHolder<Block, ? extends Block> f7099ez = f6988b.register("type96_shield", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6939bP);
    });

    /* JADX INFO: renamed from: eA */
    public static final DeferredHolder<Block, ? extends Block> f7100eA = f6988b.register("type96_shield_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6940bQ);
    });

    /* JADX INFO: renamed from: eB */
    public static final DeferredHolder<Block, ? extends Block> f7101eB = f6988b.register("type96_noshield", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6941bR);
    });

    /* JADX INFO: renamed from: eC */
    public static final DeferredHolder<Block, ? extends Block> f7102eC = f6988b.register("type96_noshield_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6942bS);
    });

    /* JADX INFO: renamed from: eD */
    public static final DeferredHolder<Block, ? extends Block> f7103eD = f6988b.register("suitcases_0", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eE */
    public static final DeferredHolder<Block, ? extends Block> f7104eE = f6988b.register("suitcases_1", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eF */
    public static final DeferredHolder<Block, ? extends Block> f7105eF = f6988b.register("suitcases_2", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eG */
    public static final DeferredHolder<Block, ? extends Block> f7106eG = f6988b.register("suitcases_3", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eH */
    public static final DeferredHolder<Block, ? extends Block> f7107eH = f6988b.register("suitcases_4", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eI */
    public static final DeferredHolder<Block, ? extends Block> f7108eI = f6988b.register("suitcases_5", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eJ */
    public static final DeferredHolder<Block, ? extends Block> f7109eJ = f6988b.register("grid", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eK */
    public static final DeferredHolder<Block, ? extends Block> f7110eK = f6988b.register("grid_broken", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eL */
    public static final DeferredHolder<Block, ? extends Block> f7111eL = f6988b.register("rod_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eM */
    public static final DeferredHolder<Block, ? extends Block> f7112eM = f6988b.register("rod_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eN */
    public static final DeferredHolder<Block, ? extends Block> f7113eN = f6988b.register("rod_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eO */
    public static final DeferredHolder<Block, ? extends Block> f7114eO = f6988b.register("rod_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eP */
    public static final DeferredHolder<Block, ? extends Block> f7115eP = f6988b.register("rod_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eQ */
    public static final DeferredHolder<Block, ? extends Block> f7116eQ = f6988b.register("rod_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eR */
    public static final DeferredHolder<Block, ? extends Block> f7117eR = f6988b.register("rubble_bricks_0", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eS */
    public static final DeferredHolder<Block, ? extends Block> f7118eS = f6988b.register("rubble_bricks_1", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eT */
    public static final DeferredHolder<Block, ? extends Block> f7119eT = f6988b.register("rubble_bricks_2", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eU */
    public static final DeferredHolder<Block, ? extends Block> f7120eU = f6988b.register("rubble_bricks_3", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eV */
    public static final DeferredHolder<Block, ? extends Block> f7121eV = f6988b.register("rubble_stones_0", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eW */
    public static final DeferredHolder<Block, ? extends Block> f7122eW = f6988b.register("rubble_stones_1", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eX */
    public static final DeferredHolder<Block, ? extends Block> f7123eX = f6988b.register("rubble_stones_2", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eY */
    public static final DeferredHolder<Block, ? extends Block> f7124eY = f6988b.register("rubble_stones_3", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eZ */
    public static final DeferredHolder<Block, ? extends Block> f7125eZ = f6988b.register("rubble_stone_bricks_0", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fa */
    public static final DeferredHolder<Block, ? extends Block> f7126fa = f6988b.register("rubble_stone_bricks_1", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fb */
    public static final DeferredHolder<Block, ? extends Block> f7127fb = f6988b.register("rubble_stone_bricks_2", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fc */
    public static final DeferredHolder<Block, ? extends Block> f7128fc = f6988b.register("rubble_stone_bricks_3", () -> {
        return new C0664lo(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fd */
    public static final DeferredHolder<Block, ? extends Block> f7129fd = f6988b.register("wall_samurai", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: a */
    public static final C0708mf f7130a = new C0708mf("window_shutters", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: b */
    public static final C0708mf f7131b = new C0708mf("window_shutters_brown", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: c */
    public static final C0708mf f7132c = new C0708mf("window_shutters_white", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: d */
    public static final C0708mf f7133d = new C0708mf("window_shutters_green", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: e */
    public static final C0708mf f7134e = new C0708mf("window_shutters_blue", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: f */
    public static final C0708mf f7135f = new C0708mf("window_shutters_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: g */
    public static final C0708mf f7136g = new C0708mf("window_shutters_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: h */
    public static final C0708mf f7137h = new C0708mf("window_shutters_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: i */
    public static final C0708mf f7138i = new C0708mf("window_shutters_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: j */
    public static final C0708mf f7139j = new C0708mf("window_shutters_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: k */
    public static final C0708mf f7140k = new C0708mf("window_shutters_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: l */
    public static final C0708mf f7141l = new C0708mf("window_shutters_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: m */
    public static final C0708mf f7142m = new C0708mf("window_shutters_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: n */
    public static final C0708mf f7143n = new C0708mf("window_shutters_walnut", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: o */
    public static final C0708mf f7144o = new C0708mf("window_shutters_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: fe */
    public static final DeferredHolder<Block, ? extends Block> f7145fe = f6988b.register("hedgehog", () -> {
        return new C0595kY(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: ff */
    public static final DeferredHolder<Block, ? extends Block> f7146ff = f6988b.register("hedgehog_mossy", () -> {
        return new C0595kY(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: fg */
    public static final DeferredHolder<Block, ? extends Block> f7147fg = f6988b.register("tank_shells", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: fh */
    public static final DeferredHolder<Block, ? extends Block> f7148fh = f6988b.register("wall_wire_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fi */
    public static final DeferredHolder<Block, ? extends Block> f7149fi = f6988b.register("wall_wire_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fj */
    public static final DeferredHolder<Block, ? extends Block> f7150fj = f6988b.register("wall_wire_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fk */
    public static final DeferredHolder<Block, ? extends Block> f7151fk = f6988b.register("wall_wire_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fl */
    public static final DeferredHolder<Block, ? extends Block> f7152fl = f6988b.register("wall_wire_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fm */
    public static final DeferredHolder<Block, ? extends Block> f7153fm = f6988b.register("wall_wire_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fn */
    public static final DeferredHolder<Block, ? extends Block> f7154fn = f6988b.register("wall_wire_6", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fo */
    public static final DeferredHolder<Block, ? extends Block> f7155fo = f6988b.register("wall_wire_7", () -> {
        return new C0667lr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fp */
    public static final DeferredHolder<Block, ? extends Block> f7156fp = f6988b.register("wall_wire_8", () -> {
        return new C0667lr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fq */
    public static final DeferredHolder<Block, ? extends Block> f7157fq = f6988b.register("wall_wire_9", () -> {
        return new C0667lr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fr */
    public static final DeferredHolder<Block, ? extends Block> f7158fr = f6988b.register("wall_wire_button_1", () -> {
        return new C0639lP(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1312xz.f8171tk, C1312xz.f8172tl);
    });

    /* JADX INFO: renamed from: fs */
    public static final DeferredHolder<Block, ? extends Block> f7159fs = f6988b.register("wall_wire_button_2", () -> {
        return new C0639lP(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1312xz.f8171tk, C1312xz.f8172tl);
    });

    /* JADX INFO: renamed from: ft */
    public static final DeferredHolder<Block, ? extends Block> f7160ft = f6988b.register("wall_wire_alarm", () -> {
        return new C0577kG(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1293xg.f6945bV);
    });

    /* JADX INFO: renamed from: fu */
    public static final DeferredHolder<Block, ? extends Block> f7161fu = f6988b.register("wall_alarm", () -> {
        return new C0577kG(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1293xg.f6947bX);
    });

    /* JADX INFO: renamed from: fv */
    public static final DeferredHolder<Block, ? extends Block> f7162fv = f6988b.register("ceiling_alarm", () -> {
        return new C0583kM(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1293xg.f6946bW);
    });

    /* JADX INFO: renamed from: fw */
    public static final DeferredHolder<Block, ? extends Block> f7163fw = f6988b.register("wall_shop_sign_france_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fx */
    public static final DeferredHolder<Block, ? extends Block> f7164fx = f6988b.register("wall_shop_sign_france_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fy */
    public static final DeferredHolder<Block, ? extends Block> f7165fy = f6988b.register("wall_shop_sign_france_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fz */
    public static final DeferredHolder<Block, ? extends Block> f7166fz = f6988b.register("wall_shop_sign_france_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fA */
    public static final DeferredHolder<Block, ? extends Block> f7167fA = f6988b.register("wall_shop_sign_france_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fB */
    public static final DeferredHolder<Block, ? extends Block> f7168fB = f6988b.register("wall_shop_sign_france_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fC */
    public static final DeferredHolder<Block, ? extends Block> f7169fC = f6988b.register("wall_shop_sign_france_6", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fD */
    public static final DeferredHolder<Block, ? extends Block> f7170fD = f6988b.register("wall_shop_sign_france_7", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fE */
    public static final DeferredHolder<Block, ? extends Block> f7171fE = f6988b.register("wall_shop_sign_france_8", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fF */
    public static final DeferredHolder<Block, ? extends Block> f7172fF = f6988b.register("wall_shop_sign_france_9", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fG */
    public static final DeferredHolder<Block, ? extends Block> f7173fG = f6988b.register("wall_shop_sign_france_10", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fH */
    public static final DeferredHolder<Block, ? extends Block> f7174fH = f6988b.register("wall_shop_sign_france_11", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fI */
    public static final DeferredHolder<Block, ? extends Block> f7175fI = f6988b.register("wall_shop_sign_france_12", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fJ */
    public static final DeferredHolder<Block, ? extends Block> f7176fJ = f6988b.register("wall_shop_sign_france_13", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fK */
    public static final DeferredHolder<Block, ? extends Block> f7177fK = f6988b.register("wall_shop_sign_france_14", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fL */
    public static final DeferredHolder<Block, ? extends Block> f7178fL = f6988b.register("wall_shop_sign_france_15", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fM */
    public static final DeferredHolder<Block, ? extends Block> f7179fM = f6988b.register("wall_shop_sign_france_16", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fN */
    public static final DeferredHolder<Block, ? extends Block> f7180fN = f6988b.register("wall_shop_sign_france_17", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fO */
    public static final DeferredHolder<Block, ? extends Block> f7181fO = f6988b.register("wall_shop_sign_france_18", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fP */
    public static final DeferredHolder<Block, ? extends Block> f7182fP = f6988b.register("wall_shop_sign_france_19", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fQ */
    public static final DeferredHolder<Block, ? extends Block> f7183fQ = f6988b.register("wall_shop_sign_france_20", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fR */
    public static final DeferredHolder<Block, ? extends Block> f7184fR = f6988b.register("wall_shop_sign_france_21", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fS */
    public static final DeferredHolder<Block, ? extends Block> f7185fS = f6988b.register("wall_shop_sign_france_22", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fT */
    public static final DeferredHolder<Block, ? extends Block> f7186fT = f6988b.register("wall_shop_sign_france_23", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fU */
    public static final DeferredHolder<Block, ? extends Block> f7187fU = f6988b.register("wall_shop_sign_france_24", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fV */
    public static final DeferredHolder<Block, ? extends Block> f7188fV = f6988b.register("wall_shop_sign_big_france_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fW */
    public static final DeferredHolder<Block, ? extends Block> f7189fW = f6988b.register("wall_shop_sign_big_france_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fX */
    public static final DeferredHolder<Block, ? extends Block> f7190fX = f6988b.register("wall_shop_sign_france_carentan_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fY */
    public static final DeferredHolder<Block, ? extends Block> f7191fY = f6988b.register("wall_shop_sign_france_carentan_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fZ */
    public static final DeferredHolder<Block, ? extends Block> f7192fZ = f6988b.register("wall_shop_sign_france_carentan_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ga */
    public static final DeferredHolder<Block, ? extends Block> f7193ga = f6988b.register("wall_shop_sign_france_carentan_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gb */
    public static final DeferredHolder<Block, ? extends Block> f7194gb = f6988b.register("wall_shop_sign_france_carentan_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gc */
    public static final DeferredHolder<Block, ? extends Block> f7195gc = f6988b.register("wall_anchor_x", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gd */
    public static final DeferredHolder<Block, ? extends Block> f7196gd = f6988b.register("wall_anchor_s", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ge */
    public static final DeferredHolder<Block, ? extends Block> f7197ge = f6988b.register("wall_decal_bulletholes_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gf */
    public static final DeferredHolder<Block, ? extends Block> f7198gf = f6988b.register("wall_decal_bulletholes_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gg */
    public static final DeferredHolder<Block, ? extends Block> f7199gg = f6988b.register("wall_decal_bulletholes_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gh */
    public static final DeferredHolder<Block, ? extends Block> f7200gh = f6988b.register("wall_decal_bulletholes_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gi */
    public static final DeferredHolder<Block, ? extends Block> f7201gi = f6988b.register("wall_decal_bulletholes_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gj */
    public static final DeferredHolder<Block, ? extends Block> f7202gj = f6988b.register("wall_decal_bulletholes_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gk */
    public static final DeferredHolder<Block, ? extends Block> f7203gk = f6988b.register("wall_decal_bulletholes_6", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gl */
    public static final DeferredHolder<Block, ? extends Block> f7204gl = f6988b.register("wall_decal_bulletholes_7", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gm */
    public static final DeferredHolder<Block, ? extends Block> f7205gm = f6988b.register("wall_decal_bulletholes_8", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gn */
    public static final DeferredHolder<Block, ? extends Block> f7206gn = f6988b.register("blood", () -> {
        return new C0670lu(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: go */
    public static final DeferredHolder<Block, ? extends Block> f7207go = f6988b.register("dead_fish", () -> {
        return new C0670lu(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gp */
    public static final DeferredHolder<Block, ? extends Block> f7208gp = f6988b.register("floor_decal_grate", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gq */
    public static final DeferredHolder<Block, ? extends Block> f7209gq = f6988b.register("floor_decal_manhole", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gr */
    public static final DeferredHolder<Block, ? extends Block> f7210gr = f6988b.register("book_open_red", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gs */
    public static final DeferredHolder<Block, ? extends Block> f7211gs = f6988b.register("book_open_green", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gt */
    public static final DeferredHolder<Block, ? extends Block> f7212gt = f6988b.register("book_open_blue", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gu */
    public static final DeferredHolder<Block, ? extends Block> f7213gu = f6988b.register("book_closed_red", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gv */
    public static final DeferredHolder<Block, ? extends Block> f7214gv = f6988b.register("book_closed_green", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gw */
    public static final DeferredHolder<Block, ? extends Block> f7215gw = f6988b.register("book_closed_blue", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: a */
    public static final C0707me f7216a = new C0707me("plank", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: b */
    public static final C0707me f7217b = new C0707me("plank_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: c */
    public static final C0707me f7218c = new C0707me("plank_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: d */
    public static final C0707me f7219d = new C0707me("plank_blue", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: e */
    public static final C0707me f7220e = new C0707me("plank_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: f */
    public static final C0707me f7221f = new C0707me("plank_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: g */
    public static final C0707me f7222g = new C0707me("plank_green", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: h */
    public static final C0707me f7223h = new C0707me("plank_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: i */
    public static final C0707me f7224i = new C0707me("plank_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: j */
    public static final C0707me f7225j = new C0707me("plank_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: k */
    public static final C0707me f7226k = new C0707me("plank_walnut", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: l */
    public static final C0707me f7227l = new C0707me("plank_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: gx */
    public static final DeferredHolder<Block, ? extends Block> f7228gx = f6988b.register("flower_box_empty", () -> {
        return new C0592kV(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gy */
    public static final DeferredHolder<Block, ? extends Block> f7229gy = f6988b.register("flower_box_poppies", () -> {
        return new C0592kV(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gz */
    public static final DeferredHolder<Block, ? extends Block> f7230gz = f6988b.register("flower_box_azure_bluet", () -> {
        return new C0592kV(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gA */
    public static final DeferredHolder<Block, ? extends Block> f7231gA = f6988b.register("flower_box_dandelions", () -> {
        return new C0592kV(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gB */
    public static final DeferredHolder<Block, ? extends Block> f7232gB = f6988b.register("flower_box_sweet_berry_bush", () -> {
        return new C0592kV(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gC */
    public static final DeferredHolder<Block, ? extends Block> f7233gC = f6988b.register("flower_box_sweet_berry_bush_grown", () -> {
        return new C0592kV(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gD */
    public static final DeferredHolder<Block, ? extends Block> f7234gD = f6988b.register("food_french_0", () -> {
        return new C0674ly(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gE */
    public static final DeferredHolder<Block, ? extends Block> f7235gE = f6988b.register("wall_flag_france", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gF */
    public static final DeferredHolder<Block, ? extends Block> f7236gF = f6988b.register("wall_flag_france_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gG */
    public static final DeferredHolder<Block, ? extends Block> f7237gG = f6988b.register("wall_flag_germany", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gH */
    public static final DeferredHolder<Block, ? extends Block> f7238gH = f6988b.register("wall_flag_germany_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gI */
    public static final DeferredHolder<Block, ? extends Block> f7239gI = f6988b.register("wall_flag_japan", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gJ */
    public static final DeferredHolder<Block, ? extends Block> f7240gJ = f6988b.register("wall_flag_japan_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gK */
    public static final DeferredHolder<Block, ? extends Block> f7241gK = f6988b.register("wall_flag_japan_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gL */
    public static final DeferredHolder<Block, ? extends Block> f7242gL = f6988b.register("wall_flag_japan_2_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gM */
    public static final DeferredHolder<Block, ? extends Block> f7243gM = f6988b.register("wall_flag_poland", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gN */
    public static final DeferredHolder<Block, ? extends Block> f7244gN = f6988b.register("wall_flag_poland_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gO */
    public static final DeferredHolder<Block, ? extends Block> f7245gO = f6988b.register("wall_flag_russia", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gP */
    public static final DeferredHolder<Block, ? extends Block> f7246gP = f6988b.register("wall_flag_russia_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gQ */
    public static final DeferredHolder<Block, ? extends Block> f7247gQ = f6988b.register("wall_flag_italy", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gR */
    public static final DeferredHolder<Block, ? extends Block> f7248gR = f6988b.register("wall_flag_italy_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gS */
    public static final DeferredHolder<Block, ? extends Block> f7249gS = f6988b.register("wall_flag_netherlands", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gT */
    public static final DeferredHolder<Block, ? extends Block> f7250gT = f6988b.register("wall_flag_netherlands_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gU */
    public static final DeferredHolder<Block, ? extends Block> f7251gU = f6988b.register("wall_flag_us", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gV */
    public static final DeferredHolder<Block, ? extends Block> f7252gV = f6988b.register("wall_flag_us_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gW */
    public static final DeferredHolder<Block, ? extends Block> f7253gW = f6988b.register("wall_flag_britain", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gX */
    public static final DeferredHolder<Block, ? extends Block> f7254gX = f6988b.register("wall_flag_britain_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gY */
    public static final DeferredHolder<Block, ? extends Block> f7255gY = f6988b.register("wall_flag_surrender", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gZ */
    public static final DeferredHolder<Block, ? extends Block> f7256gZ = f6988b.register("wall_flag_surrender_ripped", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ha */
    public static final DeferredHolder<Block, ? extends Block> f7257ha = f6988b.register("wall_flag_greece", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hb */
    public static final DeferredHolder<Block, ? extends Block> f7258hb = f6988b.register("wall_poster_ger_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hc */
    public static final DeferredHolder<Block, ? extends Block> f7259hc = f6988b.register("wall_poster_ger_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hd */
    public static final DeferredHolder<Block, ? extends Block> f7260hd = f6988b.register("wall_poster_ger_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: he */
    public static final DeferredHolder<Block, ? extends Block> f7261he = f6988b.register("wall_poster_ger_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hf */
    public static final DeferredHolder<Block, ? extends Block> f7262hf = f6988b.register("wall_poster_ger_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hg */
    public static final DeferredHolder<Block, ? extends Block> f7263hg = f6988b.register("wall_poster_ger_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hh */
    public static final DeferredHolder<Block, ? extends Block> f7264hh = f6988b.register("wall_poster_fr_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hi */
    public static final DeferredHolder<Block, ? extends Block> f7265hi = f6988b.register("wall_poster_fr_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hj */
    public static final DeferredHolder<Block, ? extends Block> f7266hj = f6988b.register("wall_poster_fr_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hk */
    public static final DeferredHolder<Block, ? extends Block> f7267hk = f6988b.register("wall_poster_fr_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hl */
    public static final DeferredHolder<Block, ? extends Block> f7268hl = f6988b.register("wall_poster_fr_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hm */
    public static final DeferredHolder<Block, ? extends Block> f7269hm = f6988b.register("wall_poster_fr_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hn */
    public static final DeferredHolder<Block, ? extends Block> f7270hn = f6988b.register("wall_poster_rus_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ho */
    public static final DeferredHolder<Block, ? extends Block> f7271ho = f6988b.register("wall_poster_rus_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hp */
    public static final DeferredHolder<Block, ? extends Block> f7272hp = f6988b.register("wall_poster_rus_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hq */
    public static final DeferredHolder<Block, ? extends Block> f7273hq = f6988b.register("wall_poster_rus_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hr */
    public static final DeferredHolder<Block, ? extends Block> f7274hr = f6988b.register("wall_poster_rus_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hs */
    public static final DeferredHolder<Block, ? extends Block> f7275hs = f6988b.register("wall_poster_rus_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ht */
    public static final DeferredHolder<Block, ? extends Block> f7276ht = f6988b.register("wall_poster_pol_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hu */
    public static final DeferredHolder<Block, ? extends Block> f7277hu = f6988b.register("wall_poster_pol_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hv */
    public static final DeferredHolder<Block, ? extends Block> f7278hv = f6988b.register("wall_poster_pol_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hw */
    public static final DeferredHolder<Block, ? extends Block> f7279hw = f6988b.register("wall_poster_pol_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hx */
    public static final DeferredHolder<Block, ? extends Block> f7280hx = f6988b.register("wall_poster_pol_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hy */
    public static final DeferredHolder<Block, ? extends Block> f7281hy = f6988b.register("wall_poster_pol_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hz */
    public static final DeferredHolder<Block, ? extends Block> f7282hz = f6988b.register("wall_poster_gb_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hA */
    public static final DeferredHolder<Block, ? extends Block> f7283hA = f6988b.register("wall_poster_gb_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hB */
    public static final DeferredHolder<Block, ? extends Block> f7284hB = f6988b.register("wall_poster_gb_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hC */
    public static final DeferredHolder<Block, ? extends Block> f7285hC = f6988b.register("wall_poster_gb_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hD */
    public static final DeferredHolder<Block, ? extends Block> f7286hD = f6988b.register("wall_poster_gb_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hE */
    public static final DeferredHolder<Block, ? extends Block> f7287hE = f6988b.register("wall_poster_gb_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hF */
    public static final DeferredHolder<Block, ? extends Block> f7288hF = f6988b.register("wall_poster_jpn_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hG */
    public static final DeferredHolder<Block, ? extends Block> f7289hG = f6988b.register("wall_poster_jpn_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hH */
    public static final DeferredHolder<Block, ? extends Block> f7290hH = f6988b.register("wall_poster_jpn_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hI */
    public static final DeferredHolder<Block, ? extends Block> f7291hI = f6988b.register("wall_poster_jpn_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hJ */
    public static final DeferredHolder<Block, ? extends Block> f7292hJ = f6988b.register("wall_poster_jpn_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hK */
    public static final DeferredHolder<Block, ? extends Block> f7293hK = f6988b.register("wall_poster_jpn_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hL */
    public static final DeferredHolder<Block, ? extends Block> f7294hL = f6988b.register("wall_poster_us_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hM */
    public static final DeferredHolder<Block, ? extends Block> f7295hM = f6988b.register("wall_poster_us_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hN */
    public static final DeferredHolder<Block, ? extends Block> f7296hN = f6988b.register("wall_poster_us_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hO */
    public static final DeferredHolder<Block, ? extends Block> f7297hO = f6988b.register("wall_poster_us_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hP */
    public static final DeferredHolder<Block, ? extends Block> f7298hP = f6988b.register("wall_poster_us_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hQ */
    public static final DeferredHolder<Block, ? extends Block> f7299hQ = f6988b.register("wall_poster_us_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hR */
    public static final DeferredHolder<Block, ? extends Block> f7300hR = f6988b.register("black_plane", () -> {
        return new C0588kR(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: hS */
    public static final DeferredHolder<Block, ? extends Block> f7301hS = f6988b.register("bicycle", () -> {
        return new C0629lF(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1293xg.f6944bU);
    });

    /* JADX INFO: renamed from: hT */
    public static final DeferredHolder<Block, ? extends Block> f7302hT = f6988b.register("p51_mustang", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6948bY);
    });

    /* JADX INFO: renamed from: hU */
    public static final DeferredHolder<Block, ? extends Block> f7303hU = f6988b.register("pzl11c", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6949bZ);
    });

    /* JADX INFO: renamed from: hV */
    public static final DeferredHolder<Block, ? extends Block> f7304hV = f6988b.register("junkers_ju87", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6950ca);
    });

    /* JADX INFO: renamed from: hW */
    public static final DeferredHolder<Block, ? extends Block> f7305hW = f6988b.register("a6m_zero", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6951cb);
    });

    /* JADX INFO: renamed from: hX */
    public static final DeferredHolder<Block, ? extends Block> f7306hX = f6988b.register("a6m_zero_parked", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6952cc);
    });

    /* JADX INFO: renamed from: hY */
    public static final DeferredHolder<Block, ? extends Block> f7307hY = f6988b.register("reggiane_re2005", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6953cd);
    });

    /* JADX INFO: renamed from: hZ */
    public static final DeferredHolder<Block, ? extends Block> f7308hZ = f6988b.register(C1307xu.f7579ez, () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6954ce);
    });

    /* JADX INFO: renamed from: ia */
    public static final DeferredHolder<Block, ? extends Block> f7309ia = f6988b.register("sherman_tank_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6956cg);
    });

    /* JADX INFO: renamed from: ib */
    public static final DeferredHolder<Block, ? extends Block> f7310ib = f6988b.register("sherman_tank_snorkel", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6957ch);
    });

    /* JADX INFO: renamed from: ic */
    public static final DeferredHolder<Block, ? extends Block> f7311ic = f6988b.register("sherman_tank_snorkel_destroyed", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6958ci);
    });

    /* JADX INFO: renamed from: id */
    public static final DeferredHolder<Block, ? extends Block> f7312id = f6988b.register(C1307xu.f7593eN, () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6955cf);
    });

    /* JADX INFO: renamed from: ie */
    public static final DeferredHolder<Block, ? extends Block> f7313ie = f6988b.register(C1307xu.f7583eD, () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6960ck);
    });

    /* JADX INFO: renamed from: if */
    public static final DeferredHolder<Block, ? extends Block> f7314if = f6988b.register("t34_tank_destroyed", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6961cl);
    });

    /* JADX INFO: renamed from: ig */
    public static final DeferredHolder<Block, ? extends Block> f7315ig = f6988b.register(C1307xu.f7589eJ, () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6962cm);
    });

    /* JADX INFO: renamed from: ih */
    public static final DeferredHolder<Block, ? extends Block> f7316ih = f6988b.register("panzeriv_tank_destroyed", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6963cn);
    });

    /* JADX INFO: renamed from: ii */
    public static final DeferredHolder<Block, ? extends Block> f7317ii = f6988b.register(C1307xu.f7584eE, () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6964co);
    });

    /* JADX INFO: renamed from: ij */
    public static final DeferredHolder<Block, ? extends Block> f7318ij = f6988b.register("chiha_tank_destroyed", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6965cp);
    });

    /* JADX INFO: renamed from: ik */
    public static final DeferredHolder<Block, ? extends Block> f7319ik = f6988b.register("kurogane", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6966cq);
    });

    /* JADX INFO: renamed from: il */
    public static final DeferredHolder<Block, ? extends Block> f7320il = f6988b.register("kubel", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6967cr);
    });

    /* JADX INFO: renamed from: im */
    public static final DeferredHolder<Block, ? extends Block> f7321im = f6988b.register(C1307xu.f7580eA, () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6968cs);
    });

    /* JADX INFO: renamed from: in */
    public static final DeferredHolder<Block, ? extends Block> f7322in = f6988b.register(C1307xu.f7581eB, () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6969ct);
    });

    /* JADX INFO: renamed from: io */
    public static final DeferredHolder<Block, ? extends Block> f7323io = f6988b.register("citroen_11cv_traction_avant_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6970cu);
    });

    /* JADX INFO: renamed from: ip */
    public static final DeferredHolder<Block, ? extends Block> f7324ip = f6988b.register("lancia_1zm", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6971cv);
    });

    /* JADX INFO: renamed from: iq */
    public static final DeferredHolder<Block, ? extends Block> f7325iq = f6988b.register("lancia_1zm_destroyed", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6972cw);
    });

    /* JADX INFO: renamed from: ir */
    public static final DeferredHolder<Block, ? extends Block> f7326ir = f6988b.register(C1307xu.f7582eC, () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6959cj);
    });

    /* JADX INFO: renamed from: is */
    public static final DeferredHolder<Block, ? extends Block> f7327is = f6988b.register("willys_jeep", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6973cx);
    });

    /* JADX INFO: renamed from: it */
    public static final DeferredHolder<Block, ? extends Block> f7328it = f6988b.register("willys_jeep_destroyed", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6976cA);
    });

    /* JADX INFO: renamed from: iu */
    public static final DeferredHolder<Block, ? extends Block> f7329iu = f6988b.register("150mm_tbtsk_c36_gun", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6977cB);
    });

    /* JADX INFO: renamed from: iv */
    public static final DeferredHolder<Block, ? extends Block> f7330iv = f6988b.register("150cm_flakscheinwerfer", () -> {
        return new C0632lI(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6978cC);
    });

    /* JADX INFO: renamed from: iw */
    public static final DeferredHolder<Block, ? extends Block> f7331iw = f6988b.register("lcvp", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6979cD);
    });

    /* JADX INFO: renamed from: ix */
    public static final DeferredHolder<Block, ? extends Block> f7332ix = f6988b.register("lcvp_open", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6980cE);
    });

    /* JADX INFO: renamed from: iy */
    public static final DeferredHolder<Block, ? extends Block> f7333iy = f6988b.register("kimino", () -> {
        return new C0591kU(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: iz */
    public static final DeferredHolder<Block, ? extends Block> f7334iz = f6988b.register("7tp_pelican", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6981cF);
    });

    /* JADX INFO: renamed from: iA */
    public static final DeferredHolder<Block, ? extends Block> f7335iA = f6988b.register("7tp_pelican_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6982cG);
    });

    /* JADX INFO: renamed from: iB */
    public static final DeferredHolder<Block, ? extends Block> f7336iB = f6988b.register("opel_blitz", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6974cy);
    });

    /* JADX INFO: renamed from: iC */
    public static final DeferredHolder<Block, ? extends Block> f7337iC = f6988b.register("opel_blitz_destroyed", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6975cz);
    });

    /* JADX INFO: renamed from: iD */
    public static final DeferredHolder<Block, ? extends Block> f7338iD = f6988b.register("ju52", () -> {
        return new C0628lE(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1293xg.f6984cI);
    });

    /* JADX INFO: renamed from: iE */
    public static final DeferredHolder<Block, ? extends Block> f7339iE = f6988b.register("wall_flag_tall", () -> {
        return new C0629lF(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1293xg.f6983cH);
    });

    /* JADX INFO: renamed from: iF */
    public static final DeferredHolder<Block, ? extends Block> f7340iF = f6988b.register("decoration_block", () -> {
        return new C0587kQ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: iG */
    public static final DeferredHolder<Block, ? extends Block> f7341iG = f6988b.register("configurable_geo_block", () -> {
        return new C0585kO(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: iH */
    public static final DeferredHolder<Block, ? extends Block> f7342iH = f6988b.register("rafter_tail_spruce", () -> {
        return new C0662lm(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iI */
    public static final DeferredHolder<Block, ? extends Block> f7343iI = f6988b.register("rafter_tail_walnut", () -> {
        return new C0662lm(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iJ */
    public static final DeferredHolder<Block, ? extends Block> f7344iJ = f6988b.register("rafter_tail_oak", () -> {
        return new C0662lm(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iK */
    public static final DeferredHolder<Block, ? extends Block> f7345iK = f6988b.register("rafter_tail_dark_oak", () -> {
        return new C0662lm(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iL */
    public static final DeferredHolder<Block, ? extends Block> f7346iL = f6988b.register("frame_11_civilian_0", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iM */
    public static final DeferredHolder<Block, ? extends Block> f7347iM = f6988b.register("frame_11_civilian_1", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iN */
    public static final DeferredHolder<Block, ? extends Block> f7348iN = f6988b.register("frame_11_civilian_2", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iO */
    public static final DeferredHolder<Block, ? extends Block> f7349iO = f6988b.register("frame_11_civilian_3", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iP */
    public static final DeferredHolder<Block, ? extends Block> f7350iP = f6988b.register("frame_11_civilian_4", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iQ */
    public static final DeferredHolder<Block, ? extends Block> f7351iQ = f6988b.register("frame_11_civilian_5", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iR */
    public static final DeferredHolder<Block, ? extends Block> f7352iR = f6988b.register("frame_11_civilian_6", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iS */
    public static final DeferredHolder<Block, ? extends Block> f7353iS = f6988b.register("frame_11_civilian_7", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iT */
    public static final DeferredHolder<Block, ? extends Block> f7354iT = f6988b.register("frame_11_civilian_8", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iU */
    public static final DeferredHolder<Block, ? extends Block> f7355iU = f6988b.register("frame_11_civilian_9", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iV */
    public static final DeferredHolder<Block, ? extends Block> f7356iV = f6988b.register("frame_11_civilian_10", () -> {
        return new C0663ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iW */
    public static final DeferredHolder<Block, ? extends Block> f7357iW = f6988b.register("frame_14_civilian_0", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iX */
    public static final DeferredHolder<Block, ? extends Block> f7358iX = f6988b.register("frame_14_civilian_1", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iY */
    public static final DeferredHolder<Block, ? extends Block> f7359iY = f6988b.register("frame_14_civilian_2", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iZ */
    public static final DeferredHolder<Block, ? extends Block> f7360iZ = f6988b.register("frame_14_civilian_3", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ja */
    public static final DeferredHolder<Block, ? extends Block> f7361ja = f6988b.register("frame_14_civilian_4", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jb */
    public static final DeferredHolder<Block, ? extends Block> f7362jb = f6988b.register("frame_14_civilian_5", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jc */
    public static final DeferredHolder<Block, ? extends Block> f7363jc = f6988b.register("frame_14_civilian_6", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jd */
    public static final DeferredHolder<Block, ? extends Block> f7364jd = f6988b.register("frame_14_civilian_7", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: je */
    public static final DeferredHolder<Block, ? extends Block> f7365je = f6988b.register("frame_14_civilian_8", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jf */
    public static final DeferredHolder<Block, ? extends Block> f7366jf = f6988b.register("frame_14_civilian_9", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jg */
    public static final DeferredHolder<Block, ? extends Block> f7367jg = f6988b.register("frame_14_civilian_10", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jh */
    public static final DeferredHolder<Block, ? extends Block> f7368jh = f6988b.register("frame_14_german_0", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ji */
    public static final DeferredHolder<Block, ? extends Block> f7369ji = f6988b.register("frame_14_german_1", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jj */
    public static final DeferredHolder<Block, ? extends Block> f7370jj = f6988b.register("frame_14_german_2", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jk */
    public static final DeferredHolder<Block, ? extends Block> f7371jk = f6988b.register("frame_14_german_3", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jl */
    public static final DeferredHolder<Block, ? extends Block> f7372jl = f6988b.register("frame_14_german_4", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jm */
    public static final DeferredHolder<Block, ? extends Block> f7373jm = f6988b.register("frame_14_german_5", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jn */
    public static final DeferredHolder<Block, ? extends Block> f7374jn = f6988b.register("frame_14_german_6", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jo */
    public static final DeferredHolder<Block, ? extends Block> f7375jo = f6988b.register("frame_14_german_7", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jp */
    public static final DeferredHolder<Block, ? extends Block> f7376jp = f6988b.register("frame_14_german_8", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jq */
    public static final DeferredHolder<Block, ? extends Block> f7377jq = f6988b.register("frame_14_german_9", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jr */
    public static final DeferredHolder<Block, ? extends Block> f7378jr = f6988b.register("frame_14_german_10", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: js */
    public static final DeferredHolder<Block, ? extends Block> f7379js = f6988b.register("frame_14_japanese_0", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jt */
    public static final DeferredHolder<Block, ? extends Block> f7380jt = f6988b.register("frame_14_japanese_1", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ju */
    public static final DeferredHolder<Block, ? extends Block> f7381ju = f6988b.register("frame_14_japanese_2", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jv */
    public static final DeferredHolder<Block, ? extends Block> f7382jv = f6988b.register("frame_14_japanese_3", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jw */
    public static final DeferredHolder<Block, ? extends Block> f7383jw = f6988b.register("frame_14_japanese_4", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jx */
    public static final DeferredHolder<Block, ? extends Block> f7384jx = f6988b.register("frame_14_japanese_5", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jy */
    public static final DeferredHolder<Block, ? extends Block> f7385jy = f6988b.register("frame_14_japanese_6", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jz */
    public static final DeferredHolder<Block, ? extends Block> f7386jz = f6988b.register("frame_14_japanese_7", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jA */
    public static final DeferredHolder<Block, ? extends Block> f7387jA = f6988b.register("frame_14_japanese_8", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jB */
    public static final DeferredHolder<Block, ? extends Block> f7388jB = f6988b.register("frame_14_japanese_9", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jC */
    public static final DeferredHolder<Block, ? extends Block> f7389jC = f6988b.register("frame_14_japanese_10", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jD */
    public static final DeferredHolder<Block, ? extends Block> f7390jD = f6988b.register("frame_14_scotteh", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jE */
    public static final DeferredHolder<Block, ? extends Block> f7391jE = f6988b.register("frame_14_madman", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jF */
    public static final DeferredHolder<Block, ? extends Block> f7392jF = f6988b.register("frame_14_warmonger", () -> {
        return new C0669lt(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jG */
    public static final DeferredHolder<Block, ? extends Block> f7393jG = f6988b.register("wooden_target", () -> {
        return new C0675lz(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jH */
    public static final DeferredHolder<Block, ? extends Block> f7394jH = f6988b.register("wall_sign_bootcamp_reception", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jI */
    public static final DeferredHolder<Block, ? extends Block> f7395jI = f6988b.register("wall_sign_bootcamp_a", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jJ */
    public static final DeferredHolder<Block, ? extends Block> f7396jJ = f6988b.register("wall_sign_bootcamp_b", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jK */
    public static final DeferredHolder<Block, ? extends Block> f7397jK = f6988b.register("wall_sign_bootcamp_c", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jL */
    public static final DeferredHolder<Block, ? extends Block> f7398jL = f6988b.register("wall_sign_bootcamp_d", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jM */
    public static final DeferredHolder<Block, ? extends Block> f7399jM = f6988b.register("wall_sign_bootcamp_e", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jN */
    public static final DeferredHolder<Block, ? extends Block> f7400jN = f6988b.register("tarp_top_green", () -> {
        return new C0625lB(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: jO */
    public static final DeferredHolder<Block, ? extends Block> f7401jO = f6988b.register("tarp_side_green", () -> {
        return new C0624lA(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jP */
    public static final DeferredHolder<Block, ? extends Block> f7402jP = f6988b.register("tarp_top_tan", () -> {
        return new C0625lB(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: jQ */
    public static final DeferredHolder<Block, ? extends Block> f7403jQ = f6988b.register("tarp_side_tan", () -> {
        return new C0624lA(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jR */
    public static final DeferredHolder<Block, ? extends Block> f7404jR = f6988b.register("wall_sign_0", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jS */
    public static final DeferredHolder<Block, ? extends Block> f7405jS = f6988b.register("wall_sign_1", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jT */
    public static final DeferredHolder<Block, ? extends Block> f7406jT = f6988b.register("wall_sign_2", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jU */
    public static final DeferredHolder<Block, ? extends Block> f7407jU = f6988b.register("wall_sign_3", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jV */
    public static final DeferredHolder<Block, ? extends Block> f7408jV = f6988b.register("wall_sign_4", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jW */
    public static final DeferredHolder<Block, ? extends Block> f7409jW = f6988b.register("wall_sign_5", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jX */
    public static final DeferredHolder<Block, ? extends Block> f7410jX = f6988b.register("wall_sign_6", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jY */
    public static final DeferredHolder<Block, ? extends Block> f7411jY = f6988b.register("wall_sign_7", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jZ */
    public static final DeferredHolder<Block, ? extends Block> f7412jZ = f6988b.register("wall_sign_8", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ka */
    public static final DeferredHolder<Block, ? extends Block> f7413ka = f6988b.register("wall_sign_9", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: kb */
    public static final DeferredHolder<Block, ? extends Block> f7414kb = f6988b.register("wall_sign_10", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: kc */
    public static final DeferredHolder<Block, ? extends Block> f7415kc = f6988b.register("wall_sign_11", () -> {
        return new C0633lJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: a */
    public static final C0706md f7416a = new C0706md("arenite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: b */
    public static final C0706md f7417b = new C0706md("arkose", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: c */
    public static final C0706md f7418c = new C0706md("augite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: d */
    public static final C0706md f7419d = new C0706md("breccia", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: e */
    public static final C0706md f7420e = new C0706md("chert", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: f */
    public static final C0706md f7421f = new C0706md("coquina", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: g */
    public static final C0706md f7422g = new C0706md("deep_rock", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: h */
    public static final C0706md f7423h = new C0706md("deepslate", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: i */
    public static final C0706md f7424i = new C0706md("feldspar", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: j */
    public static final C0706md f7425j = new C0706md("fossil", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: k */
    public static final C0706md f7426k = new C0706md("hematite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: l */
    public static final C0706md f7427l = new C0706md("limestone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: m */
    public static final C0706md f7428m = new C0706md("limonite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: n */
    public static final C0706md f7429n = new C0706md("moonrock", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: o */
    public static final C0706md f7430o = new C0706md("mud", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: p */
    public static final C0706md f7431p = new C0706md("ozark", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: q */
    public static final C0706md f7432q = new C0706md("pumice", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: r */
    public static final C0706md f7433r = new C0706md("quartzite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: s */
    public static final C0706md f7434s = new C0706md("sandstone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: t */
    public static final C0706md f7435t = new C0706md("scoria", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: u */
    public static final C0706md f7436u = new C0706md("shale", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: v */
    public static final C0706md f7437v = new C0706md("slate", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: w */
    public static final C0706md f7438w = new C0706md("soapstone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: x */
    public static final C0706md f7439x = new C0706md("stone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: y */
    public static final C0706md f7440y = new C0706md("tuff", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: z */
    public static final C0706md f7441z = new C0706md("calcite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: s */
    public static final C0704mb f7442s = new C0704mb("assorted_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: t */
    public static final C0704mb f7443t = new C0704mb("half_n_half_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: u */
    public static final C0704mb f7444u = new C0704mb("reverse_half_n_half_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: a */
    public static final C0709mg f7445a = new C0709mg("green", false, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), null);

    /* JADX INFO: renamed from: b */
    public static final C0709mg f7446b = new C0709mg("blue", false, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), null);

    /* JADX INFO: renamed from: c */
    public static final C0709mg f7447c = new C0709mg("walnut", true, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: a */
    public static final C0703ma f7448a = new C0703ma("green", ResourceLocation.fromNamespaceAndPath("bf", "block/green_planks"));

    /* JADX INFO: renamed from: b */
    public static final C0703ma f7449b = new C0703ma("blue", ResourceLocation.fromNamespaceAndPath("bf", "block/blue_planks"));

    /* JADX INFO: renamed from: c */
    public static final C0703ma f7450c = new C0703ma("walnut", ResourceLocation.fromNamespaceAndPath("bf", "block/walnut_planks"));

    /* JADX INFO: renamed from: d */
    public static final C0703ma f7451d = new C0703ma("oak", ResourceLocation.withDefaultNamespace("block/oak_planks"));

    /* JADX INFO: renamed from: e */
    public static final C0703ma f7452e = new C0703ma("birch", ResourceLocation.withDefaultNamespace("block/birch_planks"));

    /* JADX INFO: renamed from: f */
    public static final C0703ma f7453f = new C0703ma("spruce", ResourceLocation.withDefaultNamespace("block/spruce_planks"));

    /* JADX INFO: renamed from: g */
    public static final C0703ma f7454g = new C0703ma("jungle", ResourceLocation.withDefaultNamespace("block/jungle_planks"));

    /* JADX INFO: renamed from: h */
    public static final C0703ma f7455h = new C0703ma("acacia", ResourceLocation.withDefaultNamespace("block/acacia_planks"));

    /* JADX INFO: renamed from: i */
    public static final C0703ma f7456i = new C0703ma("dark_oak", ResourceLocation.withDefaultNamespace("block/dark_oak_planks"));

    /* JADX INFO: renamed from: j */
    public static final C0703ma f7457j = new C0703ma("mangrove", ResourceLocation.withDefaultNamespace("block/mangrove_planks"));

    /* JADX INFO: renamed from: k */
    public static final C0703ma f7458k = new C0703ma("cherry", ResourceLocation.withDefaultNamespace("block/cherry_planks"));

    /* JADX INFO: renamed from: l */
    public static final C0703ma f7459l = new C0703ma("bamboo", ResourceLocation.withDefaultNamespace("block/bamboo_planks"));

    /* JADX INFO: renamed from: m */
    public static final C0703ma f7460m = new C0703ma("crimson", ResourceLocation.withDefaultNamespace("block/crimson_planks"));

    /* JADX INFO: renamed from: n */
    public static final C0703ma f7461n = new C0703ma("warped", ResourceLocation.withDefaultNamespace("block/warped_planks"));

    /* JADX INFO: renamed from: v */
    public static final C0704mb f7462v = new C0704mb("steel", BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: w */
    public static final C0704mb f7463w = new C0704mb("mud", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: x */
    public static final C0704mb f7464x = new C0704mb("mud_dark", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: kd */
    public static final DeferredHolder<Block, ? extends Block> f7465kd = f6988b.register("wet_sand", () -> {
        return new ColoredFallingBlock(new ColorRGBA(5656388), BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: ke */
    public static final DeferredHolder<Block, ? extends Block> f7466ke = f6988b.register("wet_sand2", () -> {
        return new ColoredFallingBlock(new ColorRGBA(7890255), BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: kf */
    public static final DeferredHolder<Block, ? extends Block> f7467kf = f6988b.register("spice_gold", () -> {
        return new C0668ls(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: kg */
    public static final DeferredHolder<Block, ? extends Block> f7468kg = f6988b.register("spice_red", () -> {
        return new C0668ls(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: kh */
    public static final DeferredHolder<Block, ? extends Block> f7469kh = f6988b.register("spice_white", () -> {
        return new C0668ls(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: ki */
    public static final DeferredHolder<Block, ? extends Block> f7470ki = f6988b.register("door_wooden_green", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: kj */
    public static final DeferredHolder<Block, ? extends Block> f7471kj = f6988b.register("door_wooden_blue", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: kk */
    public static final DeferredHolder<Block, ? extends Block> f7472kk = f6988b.register("door_wooden_red", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: kl */
    public static final DeferredHolder<Block, ? extends Block> f7473kl = f6988b.register("door_bunker", () -> {
        return new DoorBlock(C1294xh.f6985a, BlockBehaviour.Properties.of().mapColor(Blocks.IRON_DOOR.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: km */
    public static final DeferredHolder<Block, ? extends Block> f7474km = f6988b.register("door_blast", () -> {
        return new C1306xt(C1294xh.f6986b, BlockBehaviour.Properties.of().mapColor(Blocks.IRON_DOOR.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), true);
    });

    /* JADX INFO: renamed from: kn */
    public static final DeferredHolder<Block, ? extends Block> f7475kn = f6988b.register("large_bell", () -> {
        return new C0580kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: ko */
    public static final DeferredHolder<Block, ? extends Block> f7476ko = f6988b.register("ground_fire", () -> {
        return new C0594kX(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noCollission().noOcclusion().lightLevel(blockState -> {
            return 15;
        }));
    });

    /* JADX INFO: renamed from: kp */
    public static final DeferredHolder<Block, ? extends Block> f7477kp = f6988b.register("ground_fire_small", () -> {
        return new C0594kX(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noCollission().noOcclusion().lightLevel(blockState -> {
            return 15;
        }));
    });
}
