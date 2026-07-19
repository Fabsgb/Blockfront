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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wL.class */
public final class wL {
    private static final int tk = 15;

    @NotNull
    public static final DeferredRegister<Block> b = DeferredRegister.createBlocks("bf");

    @NotNull
    public static final DeferredRegister<Block> c = DeferredRegister.createBlocks("bf");
    public static final C0323lz a = new C0323lz("map_barrier", false, false, entity -> {
        if (entity == null) {
            return false;
        }
        return (((entity instanceof Player) && ((Player) entity).isCreative()) || (entity instanceof mA) || (entity instanceof C0363nl)) ? false : true;
    });

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final C0323lz f324b = new C0323lz("map_barrier_solid", true, false, entity -> {
        return ((entity instanceof Player) && ((Player) entity).isCreative()) ? false : true;
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final C0323lz f325c = new C0323lz("map_barrier_bots", false, false, entity -> {
        return entity instanceof mE;
    });
    public static final C0323lz d = new C0323lz("map_barrier_players", false, true, entity -> {
        return (entity instanceof Player) && !((Player) entity).isCreative();
    });
    public static final DeferredHolder<Block, ? extends Block> cJ = b.register("shisa", () -> {
        return new kU(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cK = b.register("power_line", () -> {
        return new kM(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cL = b.register("power_line_wall", () -> {
        return new kN(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cM = b.register("wall_stand", () -> {
        return new C0315lr(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cN = b.register("industrial_lamp", () -> {
        return new C0288kr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final lG f326a = new lG("crate", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final lG f327b = new lG("crate_black", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final lG f328c = new lG("crate_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final lG f329d = new lG("crate_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG e = new lG("crate_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG f = new lG("crate_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG g = new lG("crate_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG h = new lG("crate_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG i = new lG("crate_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG j = new lG("crate_walnut_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final lG k = new lG("crate_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final DeferredHolder<Block, ? extends Block> cO = b.register("sandbag", () -> {
        return new kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cP = b.register("sandbag_snow", () -> {
        return new kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cQ = b.register("sandbag_green", () -> {
        return new kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cR = b.register("sandbag_green_snow", () -> {
        return new kT(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cS = b.register("dead_horse_1", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cT = b.register("dead_horse_2", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cU = b.register("dead_horse_3", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cV = b.register("dead_horse_4", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cW = b.register("bronze_horse_statue", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cX = b.register("stone_horse_statue", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cY = b.register("monte_statue_1", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> cZ = b.register("monte_statue_2", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> da = b.register("fountain", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> db = b.register("oil_barrel_red", () -> {
        return new kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dc = b.register("oil_barrel_white", () -> {
        return new kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dd = b.register("oil_barrel_green", () -> {
        return new kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    public static final DeferredHolder<Block, ? extends Block> f423de = b.register("oil_barrel_yellow", () -> {
        return new kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> df = b.register("oil_barrel_gray", () -> {
        return new kJ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dg = b.register("telephone", () -> {
        return new C0304lg(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dh = b.register("wall_telephone", () -> {
        return new C0316ls(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> di = b.register("wall_telephone_black", () -> {
        return new C0316ls(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dj = b.register("radio_civilian", () -> {
        return new kP(1.0f, 0.0f, 4.0f, 15.0f, 10.0f, 12.0f, null, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dk = b.register("radio_german", () -> {
        return new kP(1.0f, 0.0f, 4.0f, 15.0f, 10.0f, 12.0f, C0624xc.tb, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dl = b.register("radio_american", () -> {
        return new kP(0.0f, 0.0f, 6.0f, 16.0f, 13.0f, 16.0f, C0624xc.tc, BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dm = b.register("typewriter", () -> {
        return new C0308lk(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noCollission().noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dn = b.register("shop_wall_sign_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final DeferredHolder<Block, ? extends Block> f330do = b.register("shop_wall_sign_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dp = b.register("shop_wall_sign_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dq = b.register("shop_wall_sign_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dr = b.register("shop_wall_sign_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ds = b.register("shop_wall_sign_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dt = b.register("shop_wall_sign_6", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> du = b.register("shop_wall_sign_7", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dv = b.register("shop_wall_sign_8", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dw = b.register("shop_wall_sign_9", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dx = b.register("shop_wall_sign_10", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dy = b.register("shop_wall_sign_11", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dz = b.register("shop_wall_sign_12", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dA = b.register("shop_wall_sign_13", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dB = b.register("metal_ladder", () -> {
        return new LadderBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dC = b.register("metal_bars", () -> {
        return new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dD = b.register("metal_grate", () -> {
        return new kH(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dE = b.register("white_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dF = b.register("orange_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dG = b.register("magenta_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dH = b.register("light_blue_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dI = b.register("yellow_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dJ = b.register("lime_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dK = b.register("pink_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dL = b.register("gray_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dM = b.register("light_gray_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dN = b.register("cyan_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dO = b.register("purple_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dP = b.register("blue_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dQ = b.register("brown_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dR = b.register("green_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dS = b.register("red_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dT = b.register("black_wool_slab", () -> {
        return new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> dU = b.register("street_lamp", () -> {
        return new kZ(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> dV = b.register("wall_lamp", () -> {
        return new C0313lp(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> dW = b.register("desk_lamp", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return 12;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> dX = b.register("desk_microphone", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> dY = b.register("ceiling_light", () -> {
        return new C0288kr(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> dZ = b.register("barbed_wire_end", () -> {
        return new C0282kl(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ea = b.register("barbed_wire_mid", () -> {
        return new C0282kl(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eb = b.register("barbed_wire_mid_cross", () -> {
        return new C0282kl(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ec = b.register("mine_sign_0", () -> {
        return new kI(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ed = b.register("mine_sign_1", () -> {
        return new kI(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ee = b.register("mine_sign_small_0", () -> {
        return new kI(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ef = b.register("military_document_one", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eg = b.register("military_document_few", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eh = b.register("military_document_stack", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ei = b.register("piano", () -> {
        return new kK(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> ej = b.register("bunker_light", () -> {
        return new C0286kp(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> ek = b.register("bunker_light_2", () -> {
        return new C0286kp(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission().lightLevel(blockState -> {
            return ((Boolean) blockState.getValue(BlockStateProperties.LIT)).booleanValue() ? 15 : 0;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> el = b.register("marble_railing", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> em = b.register("wall_postbox", () -> {
        return new C0314lq(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> en = b.register("watering_can", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eo = b.register("support_beam", () -> {
        return new C0298la(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ep = b.register("swinging_log", () -> {
        return new C0299lb(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eq = b.register("wind_chime", () -> {
        return new C0318lu(BlockBehaviour.Properties.of().sound(SoundType.CHAIN).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> er = b.register("fusebox", () -> {
        return new kA(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> es = b.register("fusebox_open", () -> {
        return new kA(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> et = b.register("fusebox_doorless", () -> {
        return new kA(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eu = b.register("flak88_shield", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bL);
    });
    public static final DeferredHolder<Block, ? extends Block> ev = b.register("flak88_shield_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bM);
    });
    public static final DeferredHolder<Block, ? extends Block> ew = b.register("flak88_noshield", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bN);
    });
    public static final DeferredHolder<Block, ? extends Block> ex = b.register("flak88_noshield_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bO);
    });
    public static final DeferredHolder<Block, ? extends Block> ey = b.register("flak38", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bT);
    });
    public static final DeferredHolder<Block, ? extends Block> ez = b.register("type96_shield", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bP);
    });
    public static final DeferredHolder<Block, ? extends Block> eA = b.register("type96_shield_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bQ);
    });
    public static final DeferredHolder<Block, ? extends Block> eB = b.register("type96_noshield", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bR);
    });
    public static final DeferredHolder<Block, ? extends Block> eC = b.register("type96_noshield_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bS);
    });
    public static final DeferredHolder<Block, ? extends Block> eD = b.register("suitcases_0", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eE = b.register("suitcases_1", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eF = b.register("suitcases_2", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eG = b.register("suitcases_3", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eH = b.register("suitcases_4", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eI = b.register("suitcases_5", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eJ = b.register("grid", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eK = b.register("grid_broken", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eL = b.register("rod_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eM = b.register("rod_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eN = b.register("rod_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eO = b.register("rod_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eP = b.register("rod_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eQ = b.register("rod_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> eR = b.register("rubble_bricks_0", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eS = b.register("rubble_bricks_1", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eT = b.register("rubble_bricks_2", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eU = b.register("rubble_bricks_3", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eV = b.register("rubble_stones_0", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eW = b.register("rubble_stones_1", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eX = b.register("rubble_stones_2", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eY = b.register("rubble_stones_3", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> eZ = b.register("rubble_stone_bricks_0", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fa = b.register("rubble_stone_bricks_1", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fb = b.register("rubble_stone_bricks_2", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fc = b.register("rubble_stone_bricks_3", () -> {
        return new kS(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fd = b.register("wall_samurai", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final lJ f331a = new lJ("window_shutters", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final lJ f332b = new lJ("window_shutters_brown", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final lJ f333c = new lJ("window_shutters_white", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final lJ f334d = new lJ("window_shutters_green", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final lJ f335e = new lJ("window_shutters_blue", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final lJ f336f = new lJ("window_shutters_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final lJ f337g = new lJ("window_shutters_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final lJ f338h = new lJ("window_shutters_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final lJ f339i = new lJ("window_shutters_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final lJ f340j = new lJ("window_shutters_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final lJ f341k = new lJ("window_shutters_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    public static final lJ l = new lJ("window_shutters_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    public static final lJ m = new lJ("window_shutters_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    public static final lJ n = new lJ("window_shutters_walnut", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    public static final lJ o = new lJ("window_shutters_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    public static final DeferredHolder<Block, ? extends Block> fe = b.register("hedgehog", () -> {
        return new kC(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> ff = b.register("hedgehog_mossy", () -> {
        return new kC(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> fg = b.register("tank_shells", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> fh = b.register("wall_wire_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fi = b.register("wall_wire_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fj = b.register("wall_wire_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fk = b.register("wall_wire_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fl = b.register("wall_wire_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fm = b.register("wall_wire_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fn = b.register("wall_wire_6", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fo = b.register("wall_wire_7", () -> {
        return new kV(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fp = b.register("wall_wire_8", () -> {
        return new kV(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fq = b.register("wall_wire_9", () -> {
        return new kV(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fr = b.register("wall_wire_button_1", () -> {
        return new C0317lt(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C0624xc.tj, C0624xc.tk);
    });
    public static final DeferredHolder<Block, ? extends Block> fs = b.register("wall_wire_button_2", () -> {
        return new C0317lt(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), C0624xc.tj, C0624xc.tk);
    });
    public static final DeferredHolder<Block, ? extends Block> ft = b.register("wall_wire_alarm", () -> {
        return new C0281kk(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), wJ.bV);
    });
    public static final DeferredHolder<Block, ? extends Block> fu = b.register("wall_alarm", () -> {
        return new C0281kk(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), wJ.bX);
    });
    public static final DeferredHolder<Block, ? extends Block> fv = b.register("ceiling_alarm", () -> {
        return new C0287kq(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), wJ.bW);
    });
    public static final DeferredHolder<Block, ? extends Block> fw = b.register("wall_shop_sign_france_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fx = b.register("wall_shop_sign_france_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fy = b.register("wall_shop_sign_france_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fz = b.register("wall_shop_sign_france_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fA = b.register("wall_shop_sign_france_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fB = b.register("wall_shop_sign_france_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fC = b.register("wall_shop_sign_france_6", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fD = b.register("wall_shop_sign_france_7", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fE = b.register("wall_shop_sign_france_8", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fF = b.register("wall_shop_sign_france_9", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fG = b.register("wall_shop_sign_france_10", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fH = b.register("wall_shop_sign_france_11", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fI = b.register("wall_shop_sign_france_12", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fJ = b.register("wall_shop_sign_france_13", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fK = b.register("wall_shop_sign_france_14", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fL = b.register("wall_shop_sign_france_15", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fM = b.register("wall_shop_sign_france_16", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fN = b.register("wall_shop_sign_france_17", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fO = b.register("wall_shop_sign_france_18", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fP = b.register("wall_shop_sign_france_19", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fQ = b.register("wall_shop_sign_france_20", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fR = b.register("wall_shop_sign_france_21", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fS = b.register("wall_shop_sign_france_22", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fT = b.register("wall_shop_sign_france_23", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fU = b.register("wall_shop_sign_france_24", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fV = b.register("wall_shop_sign_big_france_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fW = b.register("wall_shop_sign_big_france_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fX = b.register("wall_shop_sign_france_carentan_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fY = b.register("wall_shop_sign_france_carentan_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> fZ = b.register("wall_shop_sign_france_carentan_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ga = b.register("wall_shop_sign_france_carentan_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gb = b.register("wall_shop_sign_france_carentan_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gc = b.register("wall_anchor_x", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gd = b.register("wall_anchor_s", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ge = b.register("wall_decal_bulletholes_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gf = b.register("wall_decal_bulletholes_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: gg, reason: collision with root package name */
    public static final DeferredHolder<Block, ? extends Block> f424gg = b.register("wall_decal_bulletholes_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gh = b.register("wall_decal_bulletholes_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gi = b.register("wall_decal_bulletholes_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gj = b.register("wall_decal_bulletholes_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gk = b.register("wall_decal_bulletholes_6", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gl = b.register("wall_decal_bulletholes_7", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gm = b.register("wall_decal_bulletholes_8", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gn = b.register("blood", () -> {
        return new kY(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> go = b.register("dead_fish", () -> {
        return new kY(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gp = b.register("floor_decal_grate", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gq = b.register("floor_decal_manhole", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gr = b.register("book_open_red", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gs = b.register("book_open_green", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gt = b.register("book_open_blue", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gu = b.register("book_closed_red", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gv = b.register("book_closed_green", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gw = b.register("book_closed_blue", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final lI f342a = new lI("plank", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final lI f343b = new lI("plank_acacia", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final lI f344c = new lI("plank_birch", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final lI f345d = new lI("plank_blue", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final lI f346e = new lI("plank_crimson", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final lI f347f = new lI("plank_dark_oak", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final lI f348g = new lI("plank_green", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final lI f349h = new lI("plank_jungle", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final lI f350i = new lI("plank_mangrove", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final lI f351j = new lI("plank_spruce", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final lI f352k = new lI("plank_walnut", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final lI f353l = new lI("plank_warped", BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion());
    public static final DeferredHolder<Block, ? extends Block> gx = b.register("flower_box_empty", () -> {
        return new C0296kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gy = b.register("flower_box_poppies", () -> {
        return new C0296kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gz = b.register("flower_box_azure_bluet", () -> {
        return new C0296kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gA = b.register("flower_box_dandelions", () -> {
        return new C0296kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gB = b.register("flower_box_sweet_berry_bush", () -> {
        return new C0296kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gC = b.register("flower_box_sweet_berry_bush_grown", () -> {
        return new C0296kz(BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gD = b.register("food_french_0", () -> {
        return new C0300lc(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gE = b.register("wall_flag_france", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gF = b.register("wall_flag_france_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gG = b.register("wall_flag_germany", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> gH = b.register("wall_flag_germany_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gI = b.register("wall_flag_japan", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gJ = b.register("wall_flag_japan_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gK = b.register("wall_flag_japan_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gL = b.register("wall_flag_japan_2_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gM = b.register("wall_flag_poland", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gN = b.register("wall_flag_poland_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gO = b.register("wall_flag_russia", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gP = b.register("wall_flag_russia_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gQ = b.register("wall_flag_italy", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gR = b.register("wall_flag_italy_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gS = b.register("wall_flag_netherlands", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gT = b.register("wall_flag_netherlands_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gU = b.register("wall_flag_us", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gV = b.register("wall_flag_us_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gW = b.register("wall_flag_britain", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gX = b.register("wall_flag_britain_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gY = b.register("wall_flag_surrender", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> gZ = b.register("wall_flag_surrender_ripped", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ha = b.register("wall_flag_greece", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hb = b.register("wall_poster_ger_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hc = b.register("wall_poster_ger_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hd = b.register("wall_poster_ger_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> he = b.register("wall_poster_ger_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hf = b.register("wall_poster_ger_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hg = b.register("wall_poster_ger_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hh = b.register("wall_poster_fr_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hi = b.register("wall_poster_fr_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hj = b.register("wall_poster_fr_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hk = b.register("wall_poster_fr_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hl = b.register("wall_poster_fr_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hm = b.register("wall_poster_fr_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hn = b.register("wall_poster_rus_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ho = b.register("wall_poster_rus_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hp = b.register("wall_poster_rus_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hq = b.register("wall_poster_rus_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hr = b.register("wall_poster_rus_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hs = b.register("wall_poster_rus_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ht = b.register("wall_poster_pol_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hu = b.register("wall_poster_pol_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hv = b.register("wall_poster_pol_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hw = b.register("wall_poster_pol_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hx = b.register("wall_poster_pol_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hy = b.register("wall_poster_pol_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hz = b.register("wall_poster_gb_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hA = b.register("wall_poster_gb_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hB = b.register("wall_poster_gb_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hC = b.register("wall_poster_gb_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hD = b.register("wall_poster_gb_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hE = b.register("wall_poster_gb_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hF = b.register("wall_poster_jpn_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hG = b.register("wall_poster_jpn_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hH = b.register("wall_poster_jpn_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hI = b.register("wall_poster_jpn_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hJ = b.register("wall_poster_jpn_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hK = b.register("wall_poster_jpn_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hL = b.register("wall_poster_us_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hM = b.register("wall_poster_us_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hN = b.register("wall_poster_us_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hO = b.register("wall_poster_us_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hP = b.register("wall_poster_us_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hQ = b.register("wall_poster_us_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> hR = b.register("black_plane", () -> {
        return new C0292kv(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> hS = b.register("bicycle", () -> {
        return new C0307lj(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), wJ.bU);
    });
    public static final DeferredHolder<Block, ? extends Block> hT = b.register("p51_mustang", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bY);
    });
    public static final DeferredHolder<Block, ? extends Block> hU = b.register("pzl11c", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.bZ);
    });
    public static final DeferredHolder<Block, ? extends Block> hV = b.register("junkers_ju87", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.ca);
    });
    public static final DeferredHolder<Block, ? extends Block> hW = b.register("a6m_zero", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cb);
    });
    public static final DeferredHolder<Block, ? extends Block> hX = b.register("a6m_zero_parked", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cc);
    });
    public static final DeferredHolder<Block, ? extends Block> hY = b.register("reggiane_re2005", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cd);
    });
    public static final DeferredHolder<Block, ? extends Block> hZ = b.register(wX.eo, () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.ce);
    });
    public static final DeferredHolder<Block, ? extends Block> ia = b.register("sherman_tank_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cg);
    });
    public static final DeferredHolder<Block, ? extends Block> ib = b.register("sherman_tank_snorkel", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.ch);
    });
    public static final DeferredHolder<Block, ? extends Block> ic = b.register("sherman_tank_snorkel_destroyed", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.ci);
    });
    public static final DeferredHolder<Block, ? extends Block> id = b.register(wX.eC, () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cf);
    });
    public static final DeferredHolder<Block, ? extends Block> ie = b.register(wX.es, () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.ck);
    });

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static final DeferredHolder<Block, ? extends Block> f354if = b.register("t34_tank_destroyed", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cl);
    });
    public static final DeferredHolder<Block, ? extends Block> ig = b.register(wX.ey, () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cm);
    });
    public static final DeferredHolder<Block, ? extends Block> ih = b.register("panzeriv_tank_destroyed", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cn);
    });
    public static final DeferredHolder<Block, ? extends Block> ii = b.register(wX.et, () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.co);
    });
    public static final DeferredHolder<Block, ? extends Block> ij = b.register("chiha_tank_destroyed", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cp);
    });
    public static final DeferredHolder<Block, ? extends Block> ik = b.register("kurogane", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cq);
    });
    public static final DeferredHolder<Block, ? extends Block> il = b.register("kubel", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cr);
    });
    public static final DeferredHolder<Block, ? extends Block> im = b.register(wX.ep, () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cs);
    });
    public static final DeferredHolder<Block, ? extends Block> in = b.register(wX.eq, () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.ct);
    });

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    public static final DeferredHolder<Block, ? extends Block> f425io = b.register("citroen_11cv_traction_avant_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cu);
    });
    public static final DeferredHolder<Block, ? extends Block> ip = b.register("lancia_1zm", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cv);
    });
    public static final DeferredHolder<Block, ? extends Block> iq = b.register("lancia_1zm_destroyed", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cw);
    });
    public static final DeferredHolder<Block, ? extends Block> ir = b.register(wX.er, () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cj);
    });
    public static final DeferredHolder<Block, ? extends Block> is = b.register("willys_jeep", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cx);
    });
    public static final DeferredHolder<Block, ? extends Block> it = b.register("willys_jeep_destroyed", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cA);
    });
    public static final DeferredHolder<Block, ? extends Block> iu = b.register("150mm_tbtsk_c36_gun", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cB);
    });
    public static final DeferredHolder<Block, ? extends Block> iv = b.register("150cm_flakscheinwerfer", () -> {
        return new C0310lm(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cC);
    });
    public static final DeferredHolder<Block, ? extends Block> iw = b.register("lcvp", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cD);
    });
    public static final DeferredHolder<Block, ? extends Block> ix = b.register("lcvp_open", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cE);
    });
    public static final DeferredHolder<Block, ? extends Block> iy = b.register("kimino", () -> {
        return new C0295ky(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> iz = b.register("7tp_pelican", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cF);
    });
    public static final DeferredHolder<Block, ? extends Block> iA = b.register("7tp_pelican_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cG);
    });
    public static final DeferredHolder<Block, ? extends Block> iB = b.register("opel_blitz", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cy);
    });
    public static final DeferredHolder<Block, ? extends Block> iC = b.register("opel_blitz_destroyed", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cz);
    });
    public static final DeferredHolder<Block, ? extends Block> iD = b.register("ju52", () -> {
        return new C0306li(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion(), wJ.cI);
    });
    public static final DeferredHolder<Block, ? extends Block> iE = b.register("wall_flag_tall", () -> {
        return new C0307lj(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission(), wJ.cH);
    });
    public static final DeferredHolder<Block, ? extends Block> iF = b.register("decoration_block", () -> {
        return new C0291ku(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> iG = b.register("configurable_geo_block", () -> {
        return new C0289ks(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> iH = b.register("rafter_tail_spruce", () -> {
        return new kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iI = b.register("rafter_tail_walnut", () -> {
        return new kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iJ = b.register("rafter_tail_oak", () -> {
        return new kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iK = b.register("rafter_tail_dark_oak", () -> {
        return new kQ(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iL = b.register("frame_11_civilian_0", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iM = b.register("frame_11_civilian_1", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iN = b.register("frame_11_civilian_2", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iO = b.register("frame_11_civilian_3", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iP = b.register("frame_11_civilian_4", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iQ = b.register("frame_11_civilian_5", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iR = b.register("frame_11_civilian_6", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iS = b.register("frame_11_civilian_7", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iT = b.register("frame_11_civilian_8", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iU = b.register("frame_11_civilian_9", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iV = b.register("frame_11_civilian_10", () -> {
        return new kR(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iW = b.register("frame_14_civilian_0", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iX = b.register("frame_14_civilian_1", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iY = b.register("frame_14_civilian_2", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> iZ = b.register("frame_14_civilian_3", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ja = b.register("frame_14_civilian_4", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jb = b.register("frame_14_civilian_5", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jc = b.register("frame_14_civilian_6", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jd = b.register("frame_14_civilian_7", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> je = b.register("frame_14_civilian_8", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jf = b.register("frame_14_civilian_9", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jg = b.register("frame_14_civilian_10", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jh = b.register("frame_14_german_0", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ji = b.register("frame_14_german_1", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jj = b.register("frame_14_german_2", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jk = b.register("frame_14_german_3", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jl = b.register("frame_14_german_4", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jm = b.register("frame_14_german_5", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jn = b.register("frame_14_german_6", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jo = b.register("frame_14_german_7", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jp = b.register("frame_14_german_8", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jq = b.register("frame_14_german_9", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jr = b.register("frame_14_german_10", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> js = b.register("frame_14_japanese_0", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jt = b.register("frame_14_japanese_1", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ju = b.register("frame_14_japanese_2", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jv = b.register("frame_14_japanese_3", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jw = b.register("frame_14_japanese_4", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jx = b.register("frame_14_japanese_5", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jy = b.register("frame_14_japanese_6", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jz = b.register("frame_14_japanese_7", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jA = b.register("frame_14_japanese_8", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jB = b.register("frame_14_japanese_9", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jC = b.register("frame_14_japanese_10", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jD = b.register("frame_14_scotteh", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jE = b.register("frame_14_madman", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jF = b.register("frame_14_warmonger", () -> {
        return new kX(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jG = b.register("wooden_target", () -> {
        return new C0301ld(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jH = b.register("wall_sign_bootcamp_reception", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jI = b.register("wall_sign_bootcamp_a", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jJ = b.register("wall_sign_bootcamp_b", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jK = b.register("wall_sign_bootcamp_c", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jL = b.register("wall_sign_bootcamp_d", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jM = b.register("wall_sign_bootcamp_e", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jN = b.register("tarp_top_green", () -> {
        return new C0303lf(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> jO = b.register("tarp_side_green", () -> {
        return new C0302le(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jP = b.register("tarp_top_tan", () -> {
        return new C0303lf(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> jQ = b.register("tarp_side_tan", () -> {
        return new C0302le(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jR = b.register("wall_sign_0", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jS = b.register("wall_sign_1", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jT = b.register("wall_sign_2", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jU = b.register("wall_sign_3", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jV = b.register("wall_sign_4", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jW = b.register("wall_sign_5", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jX = b.register("wall_sign_6", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jY = b.register("wall_sign_7", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> jZ = b.register("wall_sign_8", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> ka = b.register("wall_sign_9", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> kb = b.register("wall_sign_10", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });
    public static final DeferredHolder<Block, ? extends Block> kc = b.register("wall_sign_11", () -> {
        return new C0311ln(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion().noCollission());
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final lH f355a = new lH("arenite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final lH f356b = new lH("arkose", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final lH f357c = new lH("augite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final lH f358d = new lH("breccia", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final lH f359e = new lH("chert", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final lH f360f = new lH("coquina", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final lH f361g = new lH("deep_rock", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final lH f362h = new lH("deepslate", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final lH f363i = new lH("feldspar", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final lH f364j = new lH("fossil", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final lH f365k = new lH("hematite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final lH f366l = new lH("limestone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final lH f367m = new lH("limonite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final lH f368n = new lH("moonrock", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public static final lH f369o = new lH("mud", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));
    public static final lH p = new lH("ozark", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH q = new lH("pumice", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH r = new lH("quartzite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH s = new lH("sandstone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH t = new lH("scoria", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH u = new lH("shale", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH v = new lH("slate", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH w = new lH("soapstone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH x = new lH("stone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH y = new lH("tuff", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));
    public static final lH z = new lH("calcite", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    public static final lF f370s = new lF("assorted_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    public static final lF f371t = new lF("half_n_half_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    public static final lF f372u = new lF("reverse_half_n_half_bricks", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1.0f, 3600000.0f), false, false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final lK f373a = new lK("green", false, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), null);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final lK f374b = new lK("blue", false, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), null);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final lK f375c = new lK("walnut", true, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(-1.0f, 3600000.0f), BlockBehaviour.Properties.of().sound(SoundType.GRASS).strength(-1.0f, 3600000.0f).noOcclusion());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final lE f376a = new lE("green", ResourceLocation.fromNamespaceAndPath("bf", "block/green_planks"));

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final lE f377b = new lE("blue", ResourceLocation.fromNamespaceAndPath("bf", "block/blue_planks"));

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final lE f378c = new lE("walnut", ResourceLocation.fromNamespaceAndPath("bf", "block/walnut_planks"));

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final lE f379d = new lE("oak", ResourceLocation.withDefaultNamespace("block/oak_planks"));

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final lE f380e = new lE("birch", ResourceLocation.withDefaultNamespace("block/birch_planks"));

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final lE f381f = new lE("spruce", ResourceLocation.withDefaultNamespace("block/spruce_planks"));

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final lE f382g = new lE("jungle", ResourceLocation.withDefaultNamespace("block/jungle_planks"));

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final lE f383h = new lE("acacia", ResourceLocation.withDefaultNamespace("block/acacia_planks"));

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final lE f384i = new lE("dark_oak", ResourceLocation.withDefaultNamespace("block/dark_oak_planks"));

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final lE f385j = new lE("mangrove", ResourceLocation.withDefaultNamespace("block/mangrove_planks"));

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final lE f386k = new lE("cherry", ResourceLocation.withDefaultNamespace("block/cherry_planks"));

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final lE f387l = new lE("bamboo", ResourceLocation.withDefaultNamespace("block/bamboo_planks"));

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static final lE f388m = new lE("crimson", ResourceLocation.withDefaultNamespace("block/crimson_planks"));

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public static final lE f389n = new lE("warped", ResourceLocation.withDefaultNamespace("block/warped_planks"));

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    public static final lF f390v = new lF("steel", BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    public static final lF f391w = new lF("mud", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));

    /* JADX INFO: renamed from: x, reason: collision with other field name */
    public static final lF f392x = new lF("mud_dark", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).sound(SoundType.ROOTED_DIRT).strength(-1.0f, 3600000.0f));
    public static final DeferredHolder<Block, ? extends Block> kd = b.register("wet_sand", () -> {
        return new ColoredFallingBlock(new ColorRGBA(5656388), BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });
    public static final DeferredHolder<Block, ? extends Block> ke = b.register("wet_sand2", () -> {
        return new ColoredFallingBlock(new ColorRGBA(7890255), BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });
    public static final DeferredHolder<Block, ? extends Block> kf = b.register("spice_gold", () -> {
        return new kW(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });
    public static final DeferredHolder<Block, ? extends Block> kg = b.register("spice_red", () -> {
        return new kW(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });
    public static final DeferredHolder<Block, ? extends Block> kh = b.register("spice_white", () -> {
        return new kW(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(-1.0f, 3600000.0f));
    });
    public static final DeferredHolder<Block, ? extends Block> ki = b.register("door_wooden_green", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });
    public static final DeferredHolder<Block, ? extends Block> kj = b.register("door_wooden_blue", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });
    public static final DeferredHolder<Block, ? extends Block> kk = b.register("door_wooden_red", () -> {
        return new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });
    public static final DeferredHolder<Block, ? extends Block> kl = b.register("door_bunker", () -> {
        return new DoorBlock(wK.a, BlockBehaviour.Properties.of().mapColor(Blocks.IRON_DOOR.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    });
    public static final DeferredHolder<Block, ? extends Block> km = b.register("door_blast", () -> {
        return new wW(wK.b, BlockBehaviour.Properties.of().mapColor(Blocks.IRON_DOOR.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), true);
    });
    public static final DeferredHolder<Block, ? extends Block> kn = b.register("large_bell", () -> {
        return new C0284kn(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(-1.0f, 3600000.0f).noOcclusion());
    });
    public static final DeferredHolder<Block, ? extends Block> ko = b.register("ground_fire", () -> {
        return new kB(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noCollission().noOcclusion().lightLevel(blockState -> {
            return 15;
        }));
    });
    public static final DeferredHolder<Block, ? extends Block> kp = b.register("ground_fire_small", () -> {
        return new kB(BlockBehaviour.Properties.of().strength(-1.0f, 3600000.0f).noCollission().noOcclusion().lightLevel(blockState -> {
            return 15;
        }));
    });
}
