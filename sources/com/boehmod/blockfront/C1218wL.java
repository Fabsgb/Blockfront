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

/* JADX INFO: renamed from: com.boehmod.blockfront.wL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wL.class */
public final class C1218wL {

    /* JADX INFO: renamed from: tk */
    private static final int f6424tk = 15;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final DeferredRegister<Block> f6425b = DeferredRegister.createBlocks("bf");

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final DeferredRegister<Block> f6426c = DeferredRegister.createBlocks("bf");

    /* JADX INFO: renamed from: a */
    public static final C0674lz f6427a = new C0674lz("map_barrier", false, false, entity -> {
        if (entity == null) {
            return false;
        }
        return (((entity instanceof Player) && ((Player) entity).isCreative()) || (entity instanceof AbstractC0676mA) || (entity instanceof C0766nl)) ? false : true;
    });

    /* JADX INFO: renamed from: b */
    public static final C0674lz f6428b = new C0674lz("map_barrier_solid", true, false, entity -> {
        return ((entity instanceof Player) && ((Player) entity).isCreative()) ? false : true;
    });

    /* JADX INFO: renamed from: c */
    public static final C0674lz f6429c = new C0674lz("map_barrier_bots", false, false, entity -> {
        return entity instanceof C0680mE;
    });

    /* JADX INFO: renamed from: d */
    public static final C0674lz f6430d = new C0674lz("map_barrier_players", false, true, entity -> {
        return (entity instanceof Player) && !((Player) entity).isCreative();
    });

    /* JADX INFO: renamed from: cJ */
    public static final DeferredHolder<Block, ? extends Block> f6431cJ = f6425b.register("shisa", () -> {
        return new C0590kU(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cK */
    public static final DeferredHolder<Block, ? extends Block> f6432cK = f6425b.register("power_line", () -> {
        return new C0582kM(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cL */
    public static final DeferredHolder<Block, ? extends Block> f6433cL = f6425b.register("power_line_wall", () -> {
        return new C0583kN(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cM */
    public static final DeferredHolder<Block, ? extends Block> f6434cM = f6425b.register("wall_stand", () -> {
        return new C0666lr(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cN */
    public static final DeferredHolder<Block, ? extends Block> f6435cN = f6425b.register("industrial_lamp", () -> {
        return new C0613kr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: a */
    public static final C0629lG f6436a = new C0629lG("crate", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: b */
    public static final C0629lG f6437b = new C0629lG("crate_black", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: c */
    public static final C0629lG f6438c = new C0629lG("crate_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: d */
    public static final C0629lG f6439d = new C0629lG("crate_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: e */
    public static final C0629lG f6440e = new C0629lG("crate_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: f */
    public static final C0629lG f6441f = new C0629lG("crate_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: g */
    public static final C0629lG f6442g = new C0629lG("crate_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: h */
    public static final C0629lG f6443h = new C0629lG("crate_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: i */
    public static final C0629lG f6444i = new C0629lG("crate_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: j */
    public static final C0629lG f6445j = new C0629lG("crate_walnut_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: k */
    public static final C0629lG f6446k = new C0629lG("crate_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: cO */
    public static final DeferredHolder<Block, ? extends Block> f6447cO = f6425b.register("sandbag", () -> {
        return new C0589kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cP */
    public static final DeferredHolder<Block, ? extends Block> f6448cP = f6425b.register("sandbag_snow", () -> {
        return new C0589kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cQ */
    public static final DeferredHolder<Block, ? extends Block> f6449cQ = f6425b.register("sandbag_green", () -> {
        return new C0589kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cR */
    public static final DeferredHolder<Block, ? extends Block> f6450cR = f6425b.register("sandbag_green_snow", () -> {
        return new C0589kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cS */
    public static final DeferredHolder<Block, ? extends Block> f6451cS = f6425b.register("dead_horse_1", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cT */
    public static final DeferredHolder<Block, ? extends Block> f6452cT = f6425b.register("dead_horse_2", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cU */
    public static final DeferredHolder<Block, ? extends Block> f6453cU = f6425b.register("dead_horse_3", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cV */
    public static final DeferredHolder<Block, ? extends Block> f6454cV = f6425b.register("dead_horse_4", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cW */
    public static final DeferredHolder<Block, ? extends Block> f6455cW = f6425b.register("bronze_horse_statue", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cX */
    public static final DeferredHolder<Block, ? extends Block> f6456cX = f6425b.register("stone_horse_statue", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cY */
    public static final DeferredHolder<Block, ? extends Block> f6457cY = f6425b.register("monte_statue_1", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: cZ */
    public static final DeferredHolder<Block, ? extends Block> f6458cZ = f6425b.register("monte_statue_2", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: da */
    public static final DeferredHolder<Block, ? extends Block> f6459da = f6425b.register("fountain", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: db */
    public static final DeferredHolder<Block, ? extends Block> f6460db = f6425b.register("oil_barrel_red", () -> {
        return new C0579kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dc */
    public static final DeferredHolder<Block, ? extends Block> f6461dc = f6425b.register("oil_barrel_white", () -> {
        return new C0579kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dd */
    public static final DeferredHolder<Block, ? extends Block> f6462dd = f6425b.register("oil_barrel_green", () -> {
        return new C0579kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: de */
    public static final DeferredHolder<Block, ? extends Block> f6463de = f6425b.register("oil_barrel_yellow", () -> {
        return new C0579kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: df */
    public static final DeferredHolder<Block, ? extends Block> f6464df = f6425b.register("oil_barrel_gray", () -> {
        return new C0579kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dg */
    public static final DeferredHolder<Block, ? extends Block> f6465dg = f6425b.register("telephone", () -> {
        return new C0655lg(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dh */
    public static final DeferredHolder<Block, ? extends Block> f6466dh = f6425b.register("wall_telephone", () -> {
        return new C0667ls(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: di */
    public static final DeferredHolder<Block, ? extends Block> f6467di = f6425b.register("wall_telephone_black", () -> {
        return new C0667ls(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dj */
    public static final DeferredHolder<Block, ? extends Block> f6468dj = f6425b.register("radio_civilian", () -> {
        return new C0585kP(1.0f, 0.0f, 4.0f, 15.0f, 10.0f, 12.0f, null, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dk */
    public static final DeferredHolder<Block, ? extends Block> f6469dk = f6425b.register("radio_german", () -> {
        return new C0585kP(1.0f, 0.0f, 4.0f, 15.0f, 10.0f, 12.0f, C1280xc.f7752tb, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dl */
    public static final DeferredHolder<Block, ? extends Block> f6470dl = f6425b.register("radio_american", () -> {
        return new C0585kP(0.0f, 0.0f, 6.0f, 16.0f, 13.0f, 16.0f, C1280xc.f7753tc, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dm */
    public static final DeferredHolder<Block, ? extends Block> f6471dm = f6425b.register("typewriter", () -> {
        return new C0659lk(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });

    /* JADX INFO: renamed from: dn */
    public static final DeferredHolder<Block, ? extends Block> f6472dn = f6425b.register("shop_wall_sign_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: do */
    public static final DeferredHolder<Block, ? extends Block> f6473do = f6425b.register("shop_wall_sign_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dp */
    public static final DeferredHolder<Block, ? extends Block> f6474dp = f6425b.register("shop_wall_sign_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dq */
    public static final DeferredHolder<Block, ? extends Block> f6475dq = f6425b.register("shop_wall_sign_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dr */
    public static final DeferredHolder<Block, ? extends Block> f6476dr = f6425b.register("shop_wall_sign_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ds */
    public static final DeferredHolder<Block, ? extends Block> f6477ds = f6425b.register("shop_wall_sign_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dt */
    public static final DeferredHolder<Block, ? extends Block> f6478dt = f6425b.register("shop_wall_sign_6", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: du */
    public static final DeferredHolder<Block, ? extends Block> f6479du = f6425b.register("shop_wall_sign_7", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dv */
    public static final DeferredHolder<Block, ? extends Block> f6480dv = f6425b.register("shop_wall_sign_8", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dw */
    public static final DeferredHolder<Block, ? extends Block> f6481dw = f6425b.register("shop_wall_sign_9", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dx */
    public static final DeferredHolder<Block, ? extends Block> f6482dx = f6425b.register("shop_wall_sign_10", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dy */
    public static final DeferredHolder<Block, ? extends Block> f6483dy = f6425b.register("shop_wall_sign_11", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dz */
    public static final DeferredHolder<Block, ? extends Block> f6484dz = f6425b.register("shop_wall_sign_12", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dA */
    public static final DeferredHolder<Block, ? extends Block> f6485dA = f6425b.register("shop_wall_sign_13", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dB */
    public static final DeferredHolder<Block, ? extends Block> f6486dB = f6425b.register("metal_ladder", () -> {
        return new LadderBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dC */
    public static final DeferredHolder<Block, ? extends Block> f6487dC = f6425b.register("metal_bars", () -> {
        return new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dD */
    public static final DeferredHolder<Block, ? extends Block> f6488dD = f6425b.register("metal_grate", () -> {
        return new C0577kH(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dE */
    public static final DeferredHolder<Block, ? extends Block> f6489dE = f6425b.register("white_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dF */
    public static final DeferredHolder<Block, ? extends Block> f6490dF = f6425b.register("orange_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dG */
    public static final DeferredHolder<Block, ? extends Block> f6491dG = f6425b.register("magenta_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dH */
    public static final DeferredHolder<Block, ? extends Block> f6492dH = f6425b.register("light_blue_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dI */
    public static final DeferredHolder<Block, ? extends Block> f6493dI = f6425b.register("yellow_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dJ */
    public static final DeferredHolder<Block, ? extends Block> f6494dJ = f6425b.register("lime_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dK */
    public static final DeferredHolder<Block, ? extends Block> f6495dK = f6425b.register("pink_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dL */
    public static final DeferredHolder<Block, ? extends Block> f6496dL = f6425b.register("gray_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dM */
    public static final DeferredHolder<Block, ? extends Block> f6497dM = f6425b.register("light_gray_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dN */
    public static final DeferredHolder<Block, ? extends Block> f6498dN = f6425b.register("cyan_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dO */
    public static final DeferredHolder<Block, ? extends Block> f6499dO = f6425b.register("purple_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dP */
    public static final DeferredHolder<Block, ? extends Block> f6500dP = f6425b.register("blue_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dQ */
    public static final DeferredHolder<Block, ? extends Block> f6501dQ = f6425b.register("brown_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dR */
    public static final DeferredHolder<Block, ? extends Block> f6502dR = f6425b.register("green_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dS */
    public static final DeferredHolder<Block, ? extends Block> f6503dS = f6425b.register("red_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dT */
    public static final DeferredHolder<Block, ? extends Block> f6504dT = f6425b.register("black_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: dU */
    public static final DeferredHolder<Block, ? extends Block> f6505dU = f6425b.register("street_lamp", () -> {
        return new C0595kZ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: dV */
    public static final DeferredHolder<Block, ? extends Block> f6506dV = f6425b.register("wall_lamp", () -> {
        return new C0664lp(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: dW */
    public static final DeferredHolder<Block, ? extends Block> f6507dW = f6425b.register("desk_lamp", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return 12;
        }));
    });

    /* JADX INFO: renamed from: dX */
    public static final DeferredHolder<Block, ? extends Block> f6508dX = f6425b.register("desk_microphone", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: dY */
    public static final DeferredHolder<Block, ? extends Block> f6509dY = f6425b.register("ceiling_light", () -> {
        return new C0613kr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: dZ */
    public static final DeferredHolder<Block, ? extends Block> f6510dZ = f6425b.register("barbed_wire_end", () -> {
        return new C0607kl(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ea */
    public static final DeferredHolder<Block, ? extends Block> f6511ea = f6425b.register("barbed_wire_mid", () -> {
        return new C0607kl(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eb */
    public static final DeferredHolder<Block, ? extends Block> f6512eb = f6425b.register("barbed_wire_mid_cross", () -> {
        return new C0607kl(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ec */
    public static final DeferredHolder<Block, ? extends Block> f6513ec = f6425b.register("mine_sign_0", () -> {
        return new C0578kI(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ed */
    public static final DeferredHolder<Block, ? extends Block> f6514ed = f6425b.register("mine_sign_1", () -> {
        return new C0578kI(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ee */
    public static final DeferredHolder<Block, ? extends Block> f6515ee = f6425b.register("mine_sign_small_0", () -> {
        return new C0578kI(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ef */
    public static final DeferredHolder<Block, ? extends Block> f6516ef = f6425b.register("military_document_one", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eg */
    public static final DeferredHolder<Block, ? extends Block> f6517eg = f6425b.register("military_document_few", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eh */
    public static final DeferredHolder<Block, ? extends Block> f6518eh = f6425b.register("military_document_stack", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ei */
    public static final DeferredHolder<Block, ? extends Block> f6519ei = f6425b.register("piano", () -> {
        return new C0580kK(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: ej */
    public static final DeferredHolder<Block, ? extends Block> f6520ej = f6425b.register("bunker_light", () -> {
        return new C0611kp(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: ek */
    public static final DeferredHolder<Block, ? extends Block> f6521ek = f6425b.register("bunker_light_2", () -> {
        return new C0611kp(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: el */
    public static final DeferredHolder<Block, ? extends Block> f6522el = f6425b.register("marble_railing", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: em */
    public static final DeferredHolder<Block, ? extends Block> f6523em = f6425b.register("wall_postbox", () -> {
        return new C0665lq(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: en */
    public static final DeferredHolder<Block, ? extends Block> f6524en = f6425b.register("watering_can", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eo */
    public static final DeferredHolder<Block, ? extends Block> f6525eo = f6425b.register("support_beam", () -> {
        return new C0649la(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ep */
    public static final DeferredHolder<Block, ? extends Block> f6526ep = f6425b.register("swinging_log", () -> {
        return new C0650lb(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eq */
    public static final DeferredHolder<Block, ? extends Block> f6527eq = f6425b.register("wind_chime", () -> {
        return new C0669lu(BlockBehaviour.Properties.of().sound(SoundType.CHAIN).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: er */
    public static final DeferredHolder<Block, ? extends Block> f6528er = f6425b.register("fusebox", () -> {
        return new C0570kA(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: es */
    public static final DeferredHolder<Block, ? extends Block> f6529es = f6425b.register("fusebox_open", () -> {
        return new C0570kA(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: et */
    public static final DeferredHolder<Block, ? extends Block> f6530et = f6425b.register("fusebox_doorless", () -> {
        return new C0570kA(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eu */
    public static final DeferredHolder<Block, ? extends Block> f6531eu = f6425b.register("flak88_shield", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6372bL);
    });

    /* JADX INFO: renamed from: ev */
    public static final DeferredHolder<Block, ? extends Block> f6532ev = f6425b.register("flak88_shield_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6373bM);
    });

    /* JADX INFO: renamed from: ew */
    public static final DeferredHolder<Block, ? extends Block> f6533ew = f6425b.register("flak88_noshield", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6374bN);
    });

    /* JADX INFO: renamed from: ex */
    public static final DeferredHolder<Block, ? extends Block> f6534ex = f6425b.register("flak88_noshield_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6375bO);
    });

    /* JADX INFO: renamed from: ey */
    public static final DeferredHolder<Block, ? extends Block> f6535ey = f6425b.register("flak38", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6380bT);
    });

    /* JADX INFO: renamed from: ez */
    public static final DeferredHolder<Block, ? extends Block> f6536ez = f6425b.register("type96_shield", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6376bP);
    });

    /* JADX INFO: renamed from: eA */
    public static final DeferredHolder<Block, ? extends Block> f6537eA = f6425b.register("type96_shield_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6377bQ);
    });

    /* JADX INFO: renamed from: eB */
    public static final DeferredHolder<Block, ? extends Block> f6538eB = f6425b.register("type96_noshield", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6378bR);
    });

    /* JADX INFO: renamed from: eC */
    public static final DeferredHolder<Block, ? extends Block> f6539eC = f6425b.register("type96_noshield_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6379bS);
    });

    /* JADX INFO: renamed from: eD */
    public static final DeferredHolder<Block, ? extends Block> f6540eD = f6425b.register("suitcases_0", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eE */
    public static final DeferredHolder<Block, ? extends Block> f6541eE = f6425b.register("suitcases_1", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eF */
    public static final DeferredHolder<Block, ? extends Block> f6542eF = f6425b.register("suitcases_2", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eG */
    public static final DeferredHolder<Block, ? extends Block> f6543eG = f6425b.register("suitcases_3", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eH */
    public static final DeferredHolder<Block, ? extends Block> f6544eH = f6425b.register("suitcases_4", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eI */
    public static final DeferredHolder<Block, ? extends Block> f6545eI = f6425b.register("suitcases_5", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eJ */
    public static final DeferredHolder<Block, ? extends Block> f6546eJ = f6425b.register("grid", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eK */
    public static final DeferredHolder<Block, ? extends Block> f6547eK = f6425b.register("grid_broken", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eL */
    public static final DeferredHolder<Block, ? extends Block> f6548eL = f6425b.register("rod_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eM */
    public static final DeferredHolder<Block, ? extends Block> f6549eM = f6425b.register("rod_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eN */
    public static final DeferredHolder<Block, ? extends Block> f6550eN = f6425b.register("rod_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eO */
    public static final DeferredHolder<Block, ? extends Block> f6551eO = f6425b.register("rod_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eP */
    public static final DeferredHolder<Block, ? extends Block> f6552eP = f6425b.register("rod_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eQ */
    public static final DeferredHolder<Block, ? extends Block> f6553eQ = f6425b.register("rod_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: eR */
    public static final DeferredHolder<Block, ? extends Block> f6554eR = f6425b.register("rubble_bricks_0", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eS */
    public static final DeferredHolder<Block, ? extends Block> f6555eS = f6425b.register("rubble_bricks_1", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eT */
    public static final DeferredHolder<Block, ? extends Block> f6556eT = f6425b.register("rubble_bricks_2", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eU */
    public static final DeferredHolder<Block, ? extends Block> f6557eU = f6425b.register("rubble_bricks_3", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eV */
    public static final DeferredHolder<Block, ? extends Block> f6558eV = f6425b.register("rubble_stones_0", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eW */
    public static final DeferredHolder<Block, ? extends Block> f6559eW = f6425b.register("rubble_stones_1", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eX */
    public static final DeferredHolder<Block, ? extends Block> f6560eX = f6425b.register("rubble_stones_2", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eY */
    public static final DeferredHolder<Block, ? extends Block> f6561eY = f6425b.register("rubble_stones_3", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: eZ */
    public static final DeferredHolder<Block, ? extends Block> f6562eZ = f6425b.register("rubble_stone_bricks_0", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fa */
    public static final DeferredHolder<Block, ? extends Block> f6563fa = f6425b.register("rubble_stone_bricks_1", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fb */
    public static final DeferredHolder<Block, ? extends Block> f6564fb = f6425b.register("rubble_stone_bricks_2", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fc */
    public static final DeferredHolder<Block, ? extends Block> f6565fc = f6425b.register("rubble_stone_bricks_3", () -> {
        return new C0588kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fd */
    public static final DeferredHolder<Block, ? extends Block> f6566fd = f6425b.register("wall_samurai", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: a */
    public static final C0632lJ f6567a = new C0632lJ("window_shutters", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: b */
    public static final C0632lJ f6568b = new C0632lJ("window_shutters_brown", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: c */
    public static final C0632lJ f6569c = new C0632lJ("window_shutters_white", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: d */
    public static final C0632lJ f6570d = new C0632lJ("window_shutters_green", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: e */
    public static final C0632lJ f6571e = new C0632lJ("window_shutters_blue", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: f */
    public static final C0632lJ f6572f = new C0632lJ("window_shutters_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: g */
    public static final C0632lJ f6573g = new C0632lJ("window_shutters_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: h */
    public static final C0632lJ f6574h = new C0632lJ("window_shutters_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: i */
    public static final C0632lJ f6575i = new C0632lJ("window_shutters_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: j */
    public static final C0632lJ f6576j = new C0632lJ("window_shutters_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: k */
    public static final C0632lJ f6577k = new C0632lJ("window_shutters_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: l */
    public static final C0632lJ f6578l = new C0632lJ("window_shutters_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: m */
    public static final C0632lJ f6579m = new C0632lJ("window_shutters_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: n */
    public static final C0632lJ f6580n = new C0632lJ("window_shutters_walnut", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: o */
    public static final C0632lJ f6581o = new C0632lJ("window_shutters_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: fe */
    public static final DeferredHolder<Block, ? extends Block> f6582fe = f6425b.register("hedgehog", () -> {
        return new C0572kC(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: ff */
    public static final DeferredHolder<Block, ? extends Block> f6583ff = f6425b.register("hedgehog_mossy", () -> {
        return new C0572kC(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: fg */
    public static final DeferredHolder<Block, ? extends Block> f6584fg = f6425b.register("tank_shells", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: fh */
    public static final DeferredHolder<Block, ? extends Block> f6585fh = f6425b.register("wall_wire_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fi */
    public static final DeferredHolder<Block, ? extends Block> f6586fi = f6425b.register("wall_wire_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fj */
    public static final DeferredHolder<Block, ? extends Block> f6587fj = f6425b.register("wall_wire_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fk */
    public static final DeferredHolder<Block, ? extends Block> f6588fk = f6425b.register("wall_wire_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fl */
    public static final DeferredHolder<Block, ? extends Block> f6589fl = f6425b.register("wall_wire_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fm */
    public static final DeferredHolder<Block, ? extends Block> f6590fm = f6425b.register("wall_wire_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fn */
    public static final DeferredHolder<Block, ? extends Block> f6591fn = f6425b.register("wall_wire_6", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fo */
    public static final DeferredHolder<Block, ? extends Block> f6592fo = f6425b.register("wall_wire_7", () -> {
        return new C0591kV(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fp */
    public static final DeferredHolder<Block, ? extends Block> f6593fp = f6425b.register("wall_wire_8", () -> {
        return new C0591kV(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fq */
    public static final DeferredHolder<Block, ? extends Block> f6594fq = f6425b.register("wall_wire_9", () -> {
        return new C0591kV(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fr */
    public static final DeferredHolder<Block, ? extends Block> f6595fr = f6425b.register("wall_wire_button_1", () -> {
        return new C0668lt(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1280xc.f7760tj, C1280xc.f7761tk);
    });

    /* JADX INFO: renamed from: fs */
    public static final DeferredHolder<Block, ? extends Block> f6596fs = f6425b.register("wall_wire_button_2", () -> {
        return new C0668lt(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1280xc.f7760tj, C1280xc.f7761tk);
    });

    /* JADX INFO: renamed from: ft */
    public static final DeferredHolder<Block, ? extends Block> f6597ft = f6425b.register("wall_wire_alarm", () -> {
        return new C0606kk(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1216wJ.f6382bV);
    });

    /* JADX INFO: renamed from: fu */
    public static final DeferredHolder<Block, ? extends Block> f6598fu = f6425b.register("wall_alarm", () -> {
        return new C0606kk(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1216wJ.f6384bX);
    });

    /* JADX INFO: renamed from: fv */
    public static final DeferredHolder<Block, ? extends Block> f6599fv = f6425b.register("ceiling_alarm", () -> {
        return new C0612kq(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1216wJ.f6383bW);
    });

    /* JADX INFO: renamed from: fw */
    public static final DeferredHolder<Block, ? extends Block> f6600fw = f6425b.register("wall_shop_sign_france_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fx */
    public static final DeferredHolder<Block, ? extends Block> f6601fx = f6425b.register("wall_shop_sign_france_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fy */
    public static final DeferredHolder<Block, ? extends Block> f6602fy = f6425b.register("wall_shop_sign_france_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fz */
    public static final DeferredHolder<Block, ? extends Block> f6603fz = f6425b.register("wall_shop_sign_france_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fA */
    public static final DeferredHolder<Block, ? extends Block> f6604fA = f6425b.register("wall_shop_sign_france_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fB */
    public static final DeferredHolder<Block, ? extends Block> f6605fB = f6425b.register("wall_shop_sign_france_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fC */
    public static final DeferredHolder<Block, ? extends Block> f6606fC = f6425b.register("wall_shop_sign_france_6", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fD */
    public static final DeferredHolder<Block, ? extends Block> f6607fD = f6425b.register("wall_shop_sign_france_7", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fE */
    public static final DeferredHolder<Block, ? extends Block> f6608fE = f6425b.register("wall_shop_sign_france_8", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fF */
    public static final DeferredHolder<Block, ? extends Block> f6609fF = f6425b.register("wall_shop_sign_france_9", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fG */
    public static final DeferredHolder<Block, ? extends Block> f6610fG = f6425b.register("wall_shop_sign_france_10", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fH */
    public static final DeferredHolder<Block, ? extends Block> f6611fH = f6425b.register("wall_shop_sign_france_11", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fI */
    public static final DeferredHolder<Block, ? extends Block> f6612fI = f6425b.register("wall_shop_sign_france_12", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fJ */
    public static final DeferredHolder<Block, ? extends Block> f6613fJ = f6425b.register("wall_shop_sign_france_13", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fK */
    public static final DeferredHolder<Block, ? extends Block> f6614fK = f6425b.register("wall_shop_sign_france_14", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fL */
    public static final DeferredHolder<Block, ? extends Block> f6615fL = f6425b.register("wall_shop_sign_france_15", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fM */
    public static final DeferredHolder<Block, ? extends Block> f6616fM = f6425b.register("wall_shop_sign_france_16", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fN */
    public static final DeferredHolder<Block, ? extends Block> f6617fN = f6425b.register("wall_shop_sign_france_17", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fO */
    public static final DeferredHolder<Block, ? extends Block> f6618fO = f6425b.register("wall_shop_sign_france_18", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fP */
    public static final DeferredHolder<Block, ? extends Block> f6619fP = f6425b.register("wall_shop_sign_france_19", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fQ */
    public static final DeferredHolder<Block, ? extends Block> f6620fQ = f6425b.register("wall_shop_sign_france_20", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fR */
    public static final DeferredHolder<Block, ? extends Block> f6621fR = f6425b.register("wall_shop_sign_france_21", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fS */
    public static final DeferredHolder<Block, ? extends Block> f6622fS = f6425b.register("wall_shop_sign_france_22", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fT */
    public static final DeferredHolder<Block, ? extends Block> f6623fT = f6425b.register("wall_shop_sign_france_23", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fU */
    public static final DeferredHolder<Block, ? extends Block> f6624fU = f6425b.register("wall_shop_sign_france_24", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fV */
    public static final DeferredHolder<Block, ? extends Block> f6625fV = f6425b.register("wall_shop_sign_big_france_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fW */
    public static final DeferredHolder<Block, ? extends Block> f6626fW = f6425b.register("wall_shop_sign_big_france_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fX */
    public static final DeferredHolder<Block, ? extends Block> f6627fX = f6425b.register("wall_shop_sign_france_carentan_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fY */
    public static final DeferredHolder<Block, ? extends Block> f6628fY = f6425b.register("wall_shop_sign_france_carentan_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: fZ */
    public static final DeferredHolder<Block, ? extends Block> f6629fZ = f6425b.register("wall_shop_sign_france_carentan_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ga */
    public static final DeferredHolder<Block, ? extends Block> f6630ga = f6425b.register("wall_shop_sign_france_carentan_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gb */
    public static final DeferredHolder<Block, ? extends Block> f6631gb = f6425b.register("wall_shop_sign_france_carentan_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gc */
    public static final DeferredHolder<Block, ? extends Block> f6632gc = f6425b.register("wall_anchor_x", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gd */
    public static final DeferredHolder<Block, ? extends Block> f6633gd = f6425b.register("wall_anchor_s", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ge */
    public static final DeferredHolder<Block, ? extends Block> f6634ge = f6425b.register("wall_decal_bulletholes_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gf */
    public static final DeferredHolder<Block, ? extends Block> f6635gf = f6425b.register("wall_decal_bulletholes_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gg */
    public static final DeferredHolder<Block, ? extends Block> f6636gg = f6425b.register("wall_decal_bulletholes_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gh */
    public static final DeferredHolder<Block, ? extends Block> f6637gh = f6425b.register("wall_decal_bulletholes_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gi */
    public static final DeferredHolder<Block, ? extends Block> f6638gi = f6425b.register("wall_decal_bulletholes_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gj */
    public static final DeferredHolder<Block, ? extends Block> f6639gj = f6425b.register("wall_decal_bulletholes_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gk */
    public static final DeferredHolder<Block, ? extends Block> f6640gk = f6425b.register("wall_decal_bulletholes_6", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gl */
    public static final DeferredHolder<Block, ? extends Block> f6641gl = f6425b.register("wall_decal_bulletholes_7", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gm */
    public static final DeferredHolder<Block, ? extends Block> f6642gm = f6425b.register("wall_decal_bulletholes_8", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gn */
    public static final DeferredHolder<Block, ? extends Block> f6643gn = f6425b.register("blood", () -> {
        return new C0594kY(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: go */
    public static final DeferredHolder<Block, ? extends Block> f6644go = f6425b.register("dead_fish", () -> {
        return new C0594kY(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gp */
    public static final DeferredHolder<Block, ? extends Block> f6645gp = f6425b.register("floor_decal_grate", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gq */
    public static final DeferredHolder<Block, ? extends Block> f6646gq = f6425b.register("floor_decal_manhole", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gr */
    public static final DeferredHolder<Block, ? extends Block> f6647gr = f6425b.register("book_open_red", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gs */
    public static final DeferredHolder<Block, ? extends Block> f6648gs = f6425b.register("book_open_green", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gt */
    public static final DeferredHolder<Block, ? extends Block> f6649gt = f6425b.register("book_open_blue", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gu */
    public static final DeferredHolder<Block, ? extends Block> f6650gu = f6425b.register("book_closed_red", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gv */
    public static final DeferredHolder<Block, ? extends Block> f6651gv = f6425b.register("book_closed_green", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gw */
    public static final DeferredHolder<Block, ? extends Block> f6652gw = f6425b.register("book_closed_blue", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: a */
    public static final C0631lI f6653a = new C0631lI("plank", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: b */
    public static final C0631lI f6654b = new C0631lI("plank_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: c */
    public static final C0631lI f6655c = new C0631lI("plank_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: d */
    public static final C0631lI f6656d = new C0631lI("plank_blue", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: e */
    public static final C0631lI f6657e = new C0631lI("plank_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: f */
    public static final C0631lI f6658f = new C0631lI("plank_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: g */
    public static final C0631lI f6659g = new C0631lI("plank_green", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: h */
    public static final C0631lI f6660h = new C0631lI("plank_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: i */
    public static final C0631lI f6661i = new C0631lI("plank_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: j */
    public static final C0631lI f6662j = new C0631lI("plank_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: k */
    public static final C0631lI f6663k = new C0631lI("plank_walnut", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: l */
    public static final C0631lI f6664l = new C0631lI("plank_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: gx */
    public static final DeferredHolder<Block, ? extends Block> f6665gx = f6425b.register("flower_box_empty", () -> {
        return new C0621kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gy */
    public static final DeferredHolder<Block, ? extends Block> f6666gy = f6425b.register("flower_box_poppies", () -> {
        return new C0621kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gz */
    public static final DeferredHolder<Block, ? extends Block> f6667gz = f6425b.register("flower_box_azure_bluet", () -> {
        return new C0621kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gA */
    public static final DeferredHolder<Block, ? extends Block> f6668gA = f6425b.register("flower_box_dandelions", () -> {
        return new C0621kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gB */
    public static final DeferredHolder<Block, ? extends Block> f6669gB = f6425b.register("flower_box_sweet_berry_bush", () -> {
        return new C0621kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gC */
    public static final DeferredHolder<Block, ? extends Block> f6670gC = f6425b.register("flower_box_sweet_berry_bush_grown", () -> {
        return new C0621kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gD */
    public static final DeferredHolder<Block, ? extends Block> f6671gD = f6425b.register("food_french_0", () -> {
        return new C0651lc(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gE */
    public static final DeferredHolder<Block, ? extends Block> f6672gE = f6425b.register("wall_flag_france", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gF */
    public static final DeferredHolder<Block, ? extends Block> f6673gF = f6425b.register("wall_flag_france_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gG */
    public static final DeferredHolder<Block, ? extends Block> f6674gG = f6425b.register("wall_flag_germany", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: gH */
    public static final DeferredHolder<Block, ? extends Block> f6675gH = f6425b.register("wall_flag_germany_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gI */
    public static final DeferredHolder<Block, ? extends Block> f6676gI = f6425b.register("wall_flag_japan", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gJ */
    public static final DeferredHolder<Block, ? extends Block> f6677gJ = f6425b.register("wall_flag_japan_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gK */
    public static final DeferredHolder<Block, ? extends Block> f6678gK = f6425b.register("wall_flag_japan_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gL */
    public static final DeferredHolder<Block, ? extends Block> f6679gL = f6425b.register("wall_flag_japan_2_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gM */
    public static final DeferredHolder<Block, ? extends Block> f6680gM = f6425b.register("wall_flag_poland", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gN */
    public static final DeferredHolder<Block, ? extends Block> f6681gN = f6425b.register("wall_flag_poland_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gO */
    public static final DeferredHolder<Block, ? extends Block> f6682gO = f6425b.register("wall_flag_russia", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gP */
    public static final DeferredHolder<Block, ? extends Block> f6683gP = f6425b.register("wall_flag_russia_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gQ */
    public static final DeferredHolder<Block, ? extends Block> f6684gQ = f6425b.register("wall_flag_italy", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gR */
    public static final DeferredHolder<Block, ? extends Block> f6685gR = f6425b.register("wall_flag_italy_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gS */
    public static final DeferredHolder<Block, ? extends Block> f6686gS = f6425b.register("wall_flag_netherlands", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gT */
    public static final DeferredHolder<Block, ? extends Block> f6687gT = f6425b.register("wall_flag_netherlands_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gU */
    public static final DeferredHolder<Block, ? extends Block> f6688gU = f6425b.register("wall_flag_us", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gV */
    public static final DeferredHolder<Block, ? extends Block> f6689gV = f6425b.register("wall_flag_us_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gW */
    public static final DeferredHolder<Block, ? extends Block> f6690gW = f6425b.register("wall_flag_britain", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gX */
    public static final DeferredHolder<Block, ? extends Block> f6691gX = f6425b.register("wall_flag_britain_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gY */
    public static final DeferredHolder<Block, ? extends Block> f6692gY = f6425b.register("wall_flag_surrender", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gZ */
    public static final DeferredHolder<Block, ? extends Block> f6693gZ = f6425b.register("wall_flag_surrender_ripped", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ha */
    public static final DeferredHolder<Block, ? extends Block> f6694ha = f6425b.register("wall_flag_greece", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hb */
    public static final DeferredHolder<Block, ? extends Block> f6695hb = f6425b.register("wall_poster_ger_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hc */
    public static final DeferredHolder<Block, ? extends Block> f6696hc = f6425b.register("wall_poster_ger_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hd */
    public static final DeferredHolder<Block, ? extends Block> f6697hd = f6425b.register("wall_poster_ger_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: he */
    public static final DeferredHolder<Block, ? extends Block> f6698he = f6425b.register("wall_poster_ger_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hf */
    public static final DeferredHolder<Block, ? extends Block> f6699hf = f6425b.register("wall_poster_ger_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hg */
    public static final DeferredHolder<Block, ? extends Block> f6700hg = f6425b.register("wall_poster_ger_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hh */
    public static final DeferredHolder<Block, ? extends Block> f6701hh = f6425b.register("wall_poster_fr_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hi */
    public static final DeferredHolder<Block, ? extends Block> f6702hi = f6425b.register("wall_poster_fr_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hj */
    public static final DeferredHolder<Block, ? extends Block> f6703hj = f6425b.register("wall_poster_fr_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hk */
    public static final DeferredHolder<Block, ? extends Block> f6704hk = f6425b.register("wall_poster_fr_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hl */
    public static final DeferredHolder<Block, ? extends Block> f6705hl = f6425b.register("wall_poster_fr_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hm */
    public static final DeferredHolder<Block, ? extends Block> f6706hm = f6425b.register("wall_poster_fr_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hn */
    public static final DeferredHolder<Block, ? extends Block> f6707hn = f6425b.register("wall_poster_rus_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ho */
    public static final DeferredHolder<Block, ? extends Block> f6708ho = f6425b.register("wall_poster_rus_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hp */
    public static final DeferredHolder<Block, ? extends Block> f6709hp = f6425b.register("wall_poster_rus_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hq */
    public static final DeferredHolder<Block, ? extends Block> f6710hq = f6425b.register("wall_poster_rus_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hr */
    public static final DeferredHolder<Block, ? extends Block> f6711hr = f6425b.register("wall_poster_rus_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hs */
    public static final DeferredHolder<Block, ? extends Block> f6712hs = f6425b.register("wall_poster_rus_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ht */
    public static final DeferredHolder<Block, ? extends Block> f6713ht = f6425b.register("wall_poster_pol_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hu */
    public static final DeferredHolder<Block, ? extends Block> f6714hu = f6425b.register("wall_poster_pol_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hv */
    public static final DeferredHolder<Block, ? extends Block> f6715hv = f6425b.register("wall_poster_pol_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hw */
    public static final DeferredHolder<Block, ? extends Block> f6716hw = f6425b.register("wall_poster_pol_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hx */
    public static final DeferredHolder<Block, ? extends Block> f6717hx = f6425b.register("wall_poster_pol_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hy */
    public static final DeferredHolder<Block, ? extends Block> f6718hy = f6425b.register("wall_poster_pol_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hz */
    public static final DeferredHolder<Block, ? extends Block> f6719hz = f6425b.register("wall_poster_gb_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hA */
    public static final DeferredHolder<Block, ? extends Block> f6720hA = f6425b.register("wall_poster_gb_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hB */
    public static final DeferredHolder<Block, ? extends Block> f6721hB = f6425b.register("wall_poster_gb_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hC */
    public static final DeferredHolder<Block, ? extends Block> f6722hC = f6425b.register("wall_poster_gb_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hD */
    public static final DeferredHolder<Block, ? extends Block> f6723hD = f6425b.register("wall_poster_gb_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hE */
    public static final DeferredHolder<Block, ? extends Block> f6724hE = f6425b.register("wall_poster_gb_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hF */
    public static final DeferredHolder<Block, ? extends Block> f6725hF = f6425b.register("wall_poster_jpn_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hG */
    public static final DeferredHolder<Block, ? extends Block> f6726hG = f6425b.register("wall_poster_jpn_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hH */
    public static final DeferredHolder<Block, ? extends Block> f6727hH = f6425b.register("wall_poster_jpn_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hI */
    public static final DeferredHolder<Block, ? extends Block> f6728hI = f6425b.register("wall_poster_jpn_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hJ */
    public static final DeferredHolder<Block, ? extends Block> f6729hJ = f6425b.register("wall_poster_jpn_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hK */
    public static final DeferredHolder<Block, ? extends Block> f6730hK = f6425b.register("wall_poster_jpn_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hL */
    public static final DeferredHolder<Block, ? extends Block> f6731hL = f6425b.register("wall_poster_us_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hM */
    public static final DeferredHolder<Block, ? extends Block> f6732hM = f6425b.register("wall_poster_us_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hN */
    public static final DeferredHolder<Block, ? extends Block> f6733hN = f6425b.register("wall_poster_us_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hO */
    public static final DeferredHolder<Block, ? extends Block> f6734hO = f6425b.register("wall_poster_us_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hP */
    public static final DeferredHolder<Block, ? extends Block> f6735hP = f6425b.register("wall_poster_us_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hQ */
    public static final DeferredHolder<Block, ? extends Block> f6736hQ = f6425b.register("wall_poster_us_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: hR */
    public static final DeferredHolder<Block, ? extends Block> f6737hR = f6425b.register("black_plane", () -> {
        return new C0617kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: hS */
    public static final DeferredHolder<Block, ? extends Block> f6738hS = f6425b.register("bicycle", () -> {
        return new C0658lj(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1216wJ.f6381bU);
    });

    /* JADX INFO: renamed from: hT */
    public static final DeferredHolder<Block, ? extends Block> f6739hT = f6425b.register("p51_mustang", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6385bY);
    });

    /* JADX INFO: renamed from: hU */
    public static final DeferredHolder<Block, ? extends Block> f6740hU = f6425b.register("pzl11c", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6386bZ);
    });

    /* JADX INFO: renamed from: hV */
    public static final DeferredHolder<Block, ? extends Block> f6741hV = f6425b.register("junkers_ju87", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6387ca);
    });

    /* JADX INFO: renamed from: hW */
    public static final DeferredHolder<Block, ? extends Block> f6742hW = f6425b.register("a6m_zero", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6388cb);
    });

    /* JADX INFO: renamed from: hX */
    public static final DeferredHolder<Block, ? extends Block> f6743hX = f6425b.register("a6m_zero_parked", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6389cc);
    });

    /* JADX INFO: renamed from: hY */
    public static final DeferredHolder<Block, ? extends Block> f6744hY = f6425b.register("reggiane_re2005", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6390cd);
    });

    /* JADX INFO: renamed from: hZ */
    public static final DeferredHolder<Block, ? extends Block> f6745hZ = f6425b.register(C1230wX.f7014eo, () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6391ce);
    });

    /* JADX INFO: renamed from: ia */
    public static final DeferredHolder<Block, ? extends Block> f6746ia = f6425b.register("sherman_tank_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6393cg);
    });

    /* JADX INFO: renamed from: ib */
    public static final DeferredHolder<Block, ? extends Block> f6747ib = f6425b.register("sherman_tank_snorkel", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6394ch);
    });

    /* JADX INFO: renamed from: ic */
    public static final DeferredHolder<Block, ? extends Block> f6748ic = f6425b.register("sherman_tank_snorkel_destroyed", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6395ci);
    });

    /* JADX INFO: renamed from: id */
    public static final DeferredHolder<Block, ? extends Block> f6749id = f6425b.register(C1230wX.f7028eC, () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6392cf);
    });

    /* JADX INFO: renamed from: ie */
    public static final DeferredHolder<Block, ? extends Block> f6750ie = f6425b.register(C1230wX.f7018es, () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6397ck);
    });

    /* JADX INFO: renamed from: if */
    public static final DeferredHolder<Block, ? extends Block> f6751if = f6425b.register("t34_tank_destroyed", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6398cl);
    });

    /* JADX INFO: renamed from: ig */
    public static final DeferredHolder<Block, ? extends Block> f6752ig = f6425b.register(C1230wX.f7024ey, () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6399cm);
    });

    /* JADX INFO: renamed from: ih */
    public static final DeferredHolder<Block, ? extends Block> f6753ih = f6425b.register("panzeriv_tank_destroyed", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6400cn);
    });

    /* JADX INFO: renamed from: ii */
    public static final DeferredHolder<Block, ? extends Block> f6754ii = f6425b.register(C1230wX.f7019et, () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6401co);
    });

    /* JADX INFO: renamed from: ij */
    public static final DeferredHolder<Block, ? extends Block> f6755ij = f6425b.register("chiha_tank_destroyed", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6402cp);
    });

    /* JADX INFO: renamed from: ik */
    public static final DeferredHolder<Block, ? extends Block> f6756ik = f6425b.register("kurogane", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6403cq);
    });

    /* JADX INFO: renamed from: il */
    public static final DeferredHolder<Block, ? extends Block> f6757il = f6425b.register("kubel", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6404cr);
    });

    /* JADX INFO: renamed from: im */
    public static final DeferredHolder<Block, ? extends Block> f6758im = f6425b.register(C1230wX.f7015ep, () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6405cs);
    });

    /* JADX INFO: renamed from: in */
    public static final DeferredHolder<Block, ? extends Block> f6759in = f6425b.register(C1230wX.f7016eq, () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6406ct);
    });

    /* JADX INFO: renamed from: io */
    public static final DeferredHolder<Block, ? extends Block> f6760io = f6425b.register("citroen_11cv_traction_avant_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6407cu);
    });

    /* JADX INFO: renamed from: ip */
    public static final DeferredHolder<Block, ? extends Block> f6761ip = f6425b.register("lancia_1zm", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6408cv);
    });

    /* JADX INFO: renamed from: iq */
    public static final DeferredHolder<Block, ? extends Block> f6762iq = f6425b.register("lancia_1zm_destroyed", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6409cw);
    });

    /* JADX INFO: renamed from: ir */
    public static final DeferredHolder<Block, ? extends Block> f6763ir = f6425b.register(C1230wX.f7017er, () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6396cj);
    });

    /* JADX INFO: renamed from: is */
    public static final DeferredHolder<Block, ? extends Block> f6764is = f6425b.register("willys_jeep", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6410cx);
    });

    /* JADX INFO: renamed from: it */
    public static final DeferredHolder<Block, ? extends Block> f6765it = f6425b.register("willys_jeep_destroyed", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6413cA);
    });

    /* JADX INFO: renamed from: iu */
    public static final DeferredHolder<Block, ? extends Block> f6766iu = f6425b.register("150mm_tbtsk_c36_gun", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6414cB);
    });

    /* JADX INFO: renamed from: iv */
    public static final DeferredHolder<Block, ? extends Block> f6767iv = f6425b.register("150cm_flakscheinwerfer", () -> {
        return new C0661lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6415cC);
    });

    /* JADX INFO: renamed from: iw */
    public static final DeferredHolder<Block, ? extends Block> f6768iw = f6425b.register("lcvp", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6416cD);
    });

    /* JADX INFO: renamed from: ix */
    public static final DeferredHolder<Block, ? extends Block> f6769ix = f6425b.register("lcvp_open", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6417cE);
    });

    /* JADX INFO: renamed from: iy */
    public static final DeferredHolder<Block, ? extends Block> f6770iy = f6425b.register("kimino", () -> {
        return new C0620ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: iz */
    public static final DeferredHolder<Block, ? extends Block> f6771iz = f6425b.register("7tp_pelican", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6418cF);
    });

    /* JADX INFO: renamed from: iA */
    public static final DeferredHolder<Block, ? extends Block> f6772iA = f6425b.register("7tp_pelican_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6419cG);
    });

    /* JADX INFO: renamed from: iB */
    public static final DeferredHolder<Block, ? extends Block> f6773iB = f6425b.register("opel_blitz", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6411cy);
    });

    /* JADX INFO: renamed from: iC */
    public static final DeferredHolder<Block, ? extends Block> f6774iC = f6425b.register("opel_blitz_destroyed", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6412cz);
    });

    /* JADX INFO: renamed from: iD */
    public static final DeferredHolder<Block, ? extends Block> f6775iD = f6425b.register("ju52", () -> {
        return new C0657li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), C1216wJ.f6421cI);
    });

    /* JADX INFO: renamed from: iE */
    public static final DeferredHolder<Block, ? extends Block> f6776iE = f6425b.register("wall_flag_tall", () -> {
        return new C0658lj(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C1216wJ.f6420cH);
    });

    /* JADX INFO: renamed from: iF */
    public static final DeferredHolder<Block, ? extends Block> f6777iF = f6425b.register("decoration_block", () -> {
        return new C0616ku(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: iG */
    public static final DeferredHolder<Block, ? extends Block> f6778iG = f6425b.register("configurable_geo_block", () -> {
        return new C0614ks(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: iH */
    public static final DeferredHolder<Block, ? extends Block> f6779iH = f6425b.register("rafter_tail_spruce", () -> {
        return new C0586kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iI */
    public static final DeferredHolder<Block, ? extends Block> f6780iI = f6425b.register("rafter_tail_walnut", () -> {
        return new C0586kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iJ */
    public static final DeferredHolder<Block, ? extends Block> f6781iJ = f6425b.register("rafter_tail_oak", () -> {
        return new C0586kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iK */
    public static final DeferredHolder<Block, ? extends Block> f6782iK = f6425b.register("rafter_tail_dark_oak", () -> {
        return new C0586kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iL */
    public static final DeferredHolder<Block, ? extends Block> f6783iL = f6425b.register("frame_11_civilian_0", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iM */
    public static final DeferredHolder<Block, ? extends Block> f6784iM = f6425b.register("frame_11_civilian_1", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iN */
    public static final DeferredHolder<Block, ? extends Block> f6785iN = f6425b.register("frame_11_civilian_2", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iO */
    public static final DeferredHolder<Block, ? extends Block> f6786iO = f6425b.register("frame_11_civilian_3", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iP */
    public static final DeferredHolder<Block, ? extends Block> f6787iP = f6425b.register("frame_11_civilian_4", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iQ */
    public static final DeferredHolder<Block, ? extends Block> f6788iQ = f6425b.register("frame_11_civilian_5", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iR */
    public static final DeferredHolder<Block, ? extends Block> f6789iR = f6425b.register("frame_11_civilian_6", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iS */
    public static final DeferredHolder<Block, ? extends Block> f6790iS = f6425b.register("frame_11_civilian_7", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iT */
    public static final DeferredHolder<Block, ? extends Block> f6791iT = f6425b.register("frame_11_civilian_8", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iU */
    public static final DeferredHolder<Block, ? extends Block> f6792iU = f6425b.register("frame_11_civilian_9", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iV */
    public static final DeferredHolder<Block, ? extends Block> f6793iV = f6425b.register("frame_11_civilian_10", () -> {
        return new C0587kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iW */
    public static final DeferredHolder<Block, ? extends Block> f6794iW = f6425b.register("frame_14_civilian_0", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iX */
    public static final DeferredHolder<Block, ? extends Block> f6795iX = f6425b.register("frame_14_civilian_1", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iY */
    public static final DeferredHolder<Block, ? extends Block> f6796iY = f6425b.register("frame_14_civilian_2", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: iZ */
    public static final DeferredHolder<Block, ? extends Block> f6797iZ = f6425b.register("frame_14_civilian_3", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ja */
    public static final DeferredHolder<Block, ? extends Block> f6798ja = f6425b.register("frame_14_civilian_4", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jb */
    public static final DeferredHolder<Block, ? extends Block> f6799jb = f6425b.register("frame_14_civilian_5", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jc */
    public static final DeferredHolder<Block, ? extends Block> f6800jc = f6425b.register("frame_14_civilian_6", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jd */
    public static final DeferredHolder<Block, ? extends Block> f6801jd = f6425b.register("frame_14_civilian_7", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: je */
    public static final DeferredHolder<Block, ? extends Block> f6802je = f6425b.register("frame_14_civilian_8", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jf */
    public static final DeferredHolder<Block, ? extends Block> f6803jf = f6425b.register("frame_14_civilian_9", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jg */
    public static final DeferredHolder<Block, ? extends Block> f6804jg = f6425b.register("frame_14_civilian_10", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jh */
    public static final DeferredHolder<Block, ? extends Block> f6805jh = f6425b.register("frame_14_german_0", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ji */
    public static final DeferredHolder<Block, ? extends Block> f6806ji = f6425b.register("frame_14_german_1", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jj */
    public static final DeferredHolder<Block, ? extends Block> f6807jj = f6425b.register("frame_14_german_2", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jk */
    public static final DeferredHolder<Block, ? extends Block> f6808jk = f6425b.register("frame_14_german_3", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jl */
    public static final DeferredHolder<Block, ? extends Block> f6809jl = f6425b.register("frame_14_german_4", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jm */
    public static final DeferredHolder<Block, ? extends Block> f6810jm = f6425b.register("frame_14_german_5", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jn */
    public static final DeferredHolder<Block, ? extends Block> f6811jn = f6425b.register("frame_14_german_6", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jo */
    public static final DeferredHolder<Block, ? extends Block> f6812jo = f6425b.register("frame_14_german_7", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jp */
    public static final DeferredHolder<Block, ? extends Block> f6813jp = f6425b.register("frame_14_german_8", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jq */
    public static final DeferredHolder<Block, ? extends Block> f6814jq = f6425b.register("frame_14_german_9", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jr */
    public static final DeferredHolder<Block, ? extends Block> f6815jr = f6425b.register("frame_14_german_10", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: js */
    public static final DeferredHolder<Block, ? extends Block> f6816js = f6425b.register("frame_14_japanese_0", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jt */
    public static final DeferredHolder<Block, ? extends Block> f6817jt = f6425b.register("frame_14_japanese_1", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ju */
    public static final DeferredHolder<Block, ? extends Block> f6818ju = f6425b.register("frame_14_japanese_2", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jv */
    public static final DeferredHolder<Block, ? extends Block> f6819jv = f6425b.register("frame_14_japanese_3", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jw */
    public static final DeferredHolder<Block, ? extends Block> f6820jw = f6425b.register("frame_14_japanese_4", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jx */
    public static final DeferredHolder<Block, ? extends Block> f6821jx = f6425b.register("frame_14_japanese_5", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jy */
    public static final DeferredHolder<Block, ? extends Block> f6822jy = f6425b.register("frame_14_japanese_6", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jz */
    public static final DeferredHolder<Block, ? extends Block> f6823jz = f6425b.register("frame_14_japanese_7", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jA */
    public static final DeferredHolder<Block, ? extends Block> f6824jA = f6425b.register("frame_14_japanese_8", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jB */
    public static final DeferredHolder<Block, ? extends Block> f6825jB = f6425b.register("frame_14_japanese_9", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jC */
    public static final DeferredHolder<Block, ? extends Block> f6826jC = f6425b.register("frame_14_japanese_10", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jD */
    public static final DeferredHolder<Block, ? extends Block> f6827jD = f6425b.register("frame_14_scotteh", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jE */
    public static final DeferredHolder<Block, ? extends Block> f6828jE = f6425b.register("frame_14_madman", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jF */
    public static final DeferredHolder<Block, ? extends Block> f6829jF = f6425b.register("frame_14_warmonger", () -> {
        return new C0593kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jG */
    public static final DeferredHolder<Block, ? extends Block> f6830jG = f6425b.register("wooden_target", () -> {
        return new C0652ld(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jH */
    public static final DeferredHolder<Block, ? extends Block> f6831jH = f6425b.register("wall_sign_bootcamp_reception", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jI */
    public static final DeferredHolder<Block, ? extends Block> f6832jI = f6425b.register("wall_sign_bootcamp_a", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jJ */
    public static final DeferredHolder<Block, ? extends Block> f6833jJ = f6425b.register("wall_sign_bootcamp_b", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jK */
    public static final DeferredHolder<Block, ? extends Block> f6834jK = f6425b.register("wall_sign_bootcamp_c", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jL */
    public static final DeferredHolder<Block, ? extends Block> f6835jL = f6425b.register("wall_sign_bootcamp_d", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jM */
    public static final DeferredHolder<Block, ? extends Block> f6836jM = f6425b.register("wall_sign_bootcamp_e", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jN */
    public static final DeferredHolder<Block, ? extends Block> f6837jN = f6425b.register("tarp_top_green", () -> {
        return new C0654lf(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: jO */
    public static final DeferredHolder<Block, ? extends Block> f6838jO = f6425b.register("tarp_side_green", () -> {
        return new C0653le(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jP */
    public static final DeferredHolder<Block, ? extends Block> f6839jP = f6425b.register("tarp_top_tan", () -> {
        return new C0654lf(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: jQ */
    public static final DeferredHolder<Block, ? extends Block> f6840jQ = f6425b.register("tarp_side_tan", () -> {
        return new C0653le(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jR */
    public static final DeferredHolder<Block, ? extends Block> f6841jR = f6425b.register("wall_sign_0", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jS */
    public static final DeferredHolder<Block, ? extends Block> f6842jS = f6425b.register("wall_sign_1", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jT */
    public static final DeferredHolder<Block, ? extends Block> f6843jT = f6425b.register("wall_sign_2", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jU */
    public static final DeferredHolder<Block, ? extends Block> f6844jU = f6425b.register("wall_sign_3", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jV */
    public static final DeferredHolder<Block, ? extends Block> f6845jV = f6425b.register("wall_sign_4", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jW */
    public static final DeferredHolder<Block, ? extends Block> f6846jW = f6425b.register("wall_sign_5", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jX */
    public static final DeferredHolder<Block, ? extends Block> f6847jX = f6425b.register("wall_sign_6", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jY */
    public static final DeferredHolder<Block, ? extends Block> f6848jY = f6425b.register("wall_sign_7", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: jZ */
    public static final DeferredHolder<Block, ? extends Block> f6849jZ = f6425b.register("wall_sign_8", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: ka */
    public static final DeferredHolder<Block, ? extends Block> f6850ka = f6425b.register("wall_sign_9", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: kb */
    public static final DeferredHolder<Block, ? extends Block> f6851kb = f6425b.register("wall_sign_10", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: kc */
    public static final DeferredHolder<Block, ? extends Block> f6852kc = f6425b.register("wall_sign_11", () -> {
        return new C0662ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: a */
    public static final C0630lH f6853a = new C0630lH("arenite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: b */
    public static final C0630lH f6854b = new C0630lH("arkose", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: c */
    public static final C0630lH f6855c = new C0630lH("augite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: d */
    public static final C0630lH f6856d = new C0630lH("breccia", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: e */
    public static final C0630lH f6857e = new C0630lH("chert", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: f */
    public static final C0630lH f6858f = new C0630lH("coquina", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: g */
    public static final C0630lH f6859g = new C0630lH("deep_rock", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: h */
    public static final C0630lH f6860h = new C0630lH("deepslate", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: i */
    public static final C0630lH f6861i = new C0630lH("feldspar", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: j */
    public static final C0630lH f6862j = new C0630lH("fossil", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: k */
    public static final C0630lH f6863k = new C0630lH("hematite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: l */
    public static final C0630lH f6864l = new C0630lH("limestone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: m */
    public static final C0630lH f6865m = new C0630lH("limonite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: n */
    public static final C0630lH f6866n = new C0630lH("moonrock", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: o */
    public static final C0630lH f6867o = new C0630lH("mud", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: p */
    public static final C0630lH f6868p = new C0630lH("ozark", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: q */
    public static final C0630lH f6869q = new C0630lH("pumice", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: r */
    public static final C0630lH f6870r = new C0630lH("quartzite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: s */
    public static final C0630lH f6871s = new C0630lH("sandstone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: t */
    public static final C0630lH f6872t = new C0630lH("scoria", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: u */
    public static final C0630lH f6873u = new C0630lH("shale", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: v */
    public static final C0630lH f6874v = new C0630lH("slate", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: w */
    public static final C0630lH f6875w = new C0630lH("soapstone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: x */
    public static final C0630lH f6876x = new C0630lH("stone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: y */
    public static final C0630lH f6877y = new C0630lH("tuff", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: z */
    public static final C0630lH f6878z = new C0630lH("calcite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: s */
    public static final C0628lF f6879s = new C0628lF("assorted_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: t */
    public static final C0628lF f6880t = new C0628lF("half_n_half_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: u */
    public static final C0628lF f6881u = new C0628lF("reverse_half_n_half_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: a */
    public static final C0633lK f6882a = new C0633lK("green", false, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), null);

    /* JADX INFO: renamed from: b */
    public static final C0633lK f6883b = new C0633lK("blue", false, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), null);

    /* JADX INFO: renamed from: c */
    public static final C0633lK f6884c = new C0633lK("walnut", true, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: a */
    public static final C0627lE f6885a = new C0627lE("green", ResourceLocation.fromNamespaceAndPath("bf", "block/green_planks"));

    /* JADX INFO: renamed from: b */
    public static final C0627lE f6886b = new C0627lE("blue", ResourceLocation.fromNamespaceAndPath("bf", "block/blue_planks"));

    /* JADX INFO: renamed from: c */
    public static final C0627lE f6887c = new C0627lE("walnut", ResourceLocation.fromNamespaceAndPath("bf", "block/walnut_planks"));

    /* JADX INFO: renamed from: d */
    public static final C0627lE f6888d = new C0627lE("oak", ResourceLocation.withDefaultNamespace("block/oak_planks"));

    /* JADX INFO: renamed from: e */
    public static final C0627lE f6889e = new C0627lE("birch", ResourceLocation.withDefaultNamespace("block/birch_planks"));

    /* JADX INFO: renamed from: f */
    public static final C0627lE f6890f = new C0627lE("spruce", ResourceLocation.withDefaultNamespace("block/spruce_planks"));

    /* JADX INFO: renamed from: g */
    public static final C0627lE f6891g = new C0627lE("jungle", ResourceLocation.withDefaultNamespace("block/jungle_planks"));

    /* JADX INFO: renamed from: h */
    public static final C0627lE f6892h = new C0627lE("acacia", ResourceLocation.withDefaultNamespace("block/acacia_planks"));

    /* JADX INFO: renamed from: i */
    public static final C0627lE f6893i = new C0627lE("dark_oak", ResourceLocation.withDefaultNamespace("block/dark_oak_planks"));

    /* JADX INFO: renamed from: j */
    public static final C0627lE f6894j = new C0627lE("mangrove", ResourceLocation.withDefaultNamespace("block/mangrove_planks"));

    /* JADX INFO: renamed from: k */
    public static final C0627lE f6895k = new C0627lE("cherry", ResourceLocation.withDefaultNamespace("block/cherry_planks"));

    /* JADX INFO: renamed from: l */
    public static final C0627lE f6896l = new C0627lE("bamboo", ResourceLocation.withDefaultNamespace("block/bamboo_planks"));

    /* JADX INFO: renamed from: m */
    public static final C0627lE f6897m = new C0627lE("crimson", ResourceLocation.withDefaultNamespace("block/crimson_planks"));

    /* JADX INFO: renamed from: n */
    public static final C0627lE f6898n = new C0627lE("warped", ResourceLocation.withDefaultNamespace("block/warped_planks"));

    /* JADX INFO: renamed from: v */
    public static final C0628lF f6899v = new C0628lF("steel", BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: w */
    public static final C0628lF f6900w = new C0628lF("mud", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: x */
    public static final C0628lF f6901x = new C0628lF("mud_dark", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: kd */
    public static final DeferredHolder<Block, ? extends Block> f6902kd = f6425b.register("wet_sand", () -> {
        return new ColoredFallingBlock(new ColorRGBA(5656388), BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: ke */
    public static final DeferredHolder<Block, ? extends Block> f6903ke = f6425b.register("wet_sand2", () -> {
        return new ColoredFallingBlock(new ColorRGBA(7890255), BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: kf */
    public static final DeferredHolder<Block, ? extends Block> f6904kf = f6425b.register("spice_gold", () -> {
        return new C0592kW(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: kg */
    public static final DeferredHolder<Block, ? extends Block> f6905kg = f6425b.register("spice_red", () -> {
        return new C0592kW(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: kh */
    public static final DeferredHolder<Block, ? extends Block> f6906kh = f6425b.register("spice_white", () -> {
        return new C0592kW(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });

    /* JADX INFO: renamed from: ki */
    public static final DeferredHolder<Block, ? extends Block> f6907ki = f6425b.register("door_wooden_green", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: kj */
    public static final DeferredHolder<Block, ? extends Block> f6908kj = f6425b.register("door_wooden_blue", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: kk */
    public static final DeferredHolder<Block, ? extends Block> f6909kk = f6425b.register("door_wooden_red", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: kl */
    public static final DeferredHolder<Block, ? extends Block> f6910kl = f6425b.register("door_bunker", () -> {
        return new DoorBlock(C1217wK.f6422a, BlockBehaviour.Properties.of().mapColor(Blocks.IRON_DOOR.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });

    /* JADX INFO: renamed from: km */
    public static final DeferredHolder<Block, ? extends Block> f6911km = f6425b.register("door_blast", () -> {
        return new C1229wW(C1217wK.f6423b, BlockBehaviour.Properties.of().mapColor(Blocks.IRON_DOOR.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), true);
    });

    /* JADX INFO: renamed from: kn */
    public static final DeferredHolder<Block, ? extends Block> f6912kn = f6425b.register("large_bell", () -> {
        return new C0609kn(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: ko */
    public static final DeferredHolder<Block, ? extends Block> f6913ko = f6425b.register("ground_fire", () -> {
        return new C0571kB(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noCollission().noOcclusion().lightLevel(blockState -> {
            return 15;
        }));
    });

    /* JADX INFO: renamed from: kp */
    public static final DeferredHolder<Block, ? extends Block> f6914kp = f6425b.register("ground_fire_small", () -> {
        return new C0571kB(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noCollission().noOcclusion().lightLevel(blockState -> {
            return 15;
        }));
    });
}
