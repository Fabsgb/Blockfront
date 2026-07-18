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

/* JADX INFO: renamed from: com.boehmod.blockfront.lJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lJ.class */
public class C0632lJ {

    /* JADX INFO: renamed from: J */
    public static final ObjectList<C0632lJ> f3458J = new ObjectArrayList();

    /* JADX INFO: renamed from: bn */
    public final String f3459bn;

    /* JADX INFO: renamed from: L */
    public final DeferredHolder<Block, Block> f3460L;

    /* JADX INFO: renamed from: M */
    public final DeferredHolder<Block, Block> f3461M;

    /* JADX INFO: renamed from: N */
    public final DeferredHolder<Block, Block> f3462N;

    public C0632lJ(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.f3459bn = str;
        this.f3460L = C1218wL.f6426c.register(str, () -> {
            return new C0670lv(properties);
        });
        this.f3461M = C1218wL.f6426c.register(str + "_left", () -> {
            return new C0670lv(properties);
        });
        this.f3462N = C1218wL.f6426c.register(str + "_right", () -> {
            return new C0670lv(properties);
        });
        f3458J.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m2778a(@Nonnull C0704mc c0704mc) {
        m2782c(c0704mc, this.f3460L, "");
        m2782c(c0704mc, this.f3461M, "_left");
        m2782c(c0704mc, this.f3462N, "_right");
    }

    /* JADX INFO: renamed from: a */
    public void m2779a(@Nonnull C0706me c0706me) {
        c0706me.withExistingParent(this.f3460L.getId().getPath(), this.f3460L.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3461M.getId().getPath(), this.f3461M.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3462N.getId().getPath(), this.f3462N.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m2780a(C0707mf c0707mf) {
        String strM2781C = m2781C();
        c0707mf.add((Block) this.f3460L.get(), strM2781C);
        c0707mf.add((Block) this.f3461M.get(), strM2781C + " (Left)");
        c0707mf.add((Block) this.f3462N.get(), strM2781C + " (Right)");
    }

    /* JADX INFO: renamed from: C */
    public String m2781C() {
        return (String) Arrays.stream(this.f3459bn.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    /* JADX INFO: renamed from: c */
    private void m2782c(C0704mc c0704mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0704mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel[]{m2783a(c0704mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 0)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST).addModels(new ConfiguredModel[]{m2783a(c0704mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 90)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel[]{m2783a(c0704mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 180)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST).addModels(new ConfiguredModel[]{m2783a(c0704mc, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, Token.IDENTIFIER)});
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m2783a(C0704mc c0704mc, String str, String str2, int i) {
        return new ConfiguredModel(c0704mc.models().withExistingParent(str, c0704mc.modLoc(str2)).texture("0", c0704mc.modLoc("block/" + this.f3459bn)).texture("particle", c0704mc.modLoc("block/" + this.f3459bn)), 0, i, false);
    }
}
