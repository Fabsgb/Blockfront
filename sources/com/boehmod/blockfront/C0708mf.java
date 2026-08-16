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

/* JADX INFO: renamed from: com.boehmod.blockfront.mf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mf.class */
public class C0708mf {

    /* JADX INFO: renamed from: S */
    public static final ObjectList<C0708mf> f3932S = new ObjectArrayList();

    /* JADX INFO: renamed from: bw */
    public final String f3933bw;

    /* JADX INFO: renamed from: L */
    public final DeferredHolder<Block, Block> f3934L;

    /* JADX INFO: renamed from: M */
    public final DeferredHolder<Block, Block> f3935M;

    /* JADX INFO: renamed from: N */
    public final DeferredHolder<Block, Block> f3936N;

    public C0708mf(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.f3933bw = str;
        this.f3934L = C1295xi.f6989c.register(str, () -> {
            return new C0641lR(properties);
        });
        this.f3935M = C1295xi.f6989c.register(str + "_left", () -> {
            return new C0641lR(properties);
        });
        this.f3936N = C1295xi.f6989c.register(str + "_right", () -> {
            return new C0641lR(properties);
        });
        f3932S.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m3209a(@Nonnull C0727my c0727my) {
        m3213c(c0727my, this.f3934L, "");
        m3213c(c0727my, this.f3935M, "_left");
        m3213c(c0727my, this.f3936N, "_right");
    }

    /* JADX INFO: renamed from: a */
    public void m3210a(@Nonnull C0677mA c0677mA) {
        c0677mA.withExistingParent(this.f3934L.getId().getPath(), this.f3934L.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3935M.getId().getPath(), this.f3935M.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3936N.getId().getPath(), this.f3936N.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m3211a(C0678mB c0678mB) {
        String strM3212J = m3212J();
        c0678mB.add((Block) this.f3934L.get(), strM3212J);
        c0678mB.add((Block) this.f3935M.get(), strM3212J + " (Left)");
        c0678mB.add((Block) this.f3936N.get(), strM3212J + " (Right)");
    }

    /* JADX INFO: renamed from: J */
    public String m3212J() {
        return (String) Arrays.stream(this.f3933bw.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    /* JADX INFO: renamed from: c */
    private void m3213c(C0727my c0727my, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0727my.getVariantBuilder((Block) deferredHolder.get()).partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel[]{m3214a(c0727my, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 0)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST).addModels(new ConfiguredModel[]{m3214a(c0727my, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 90)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel[]{m3214a(c0727my, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, 180)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST).addModels(new ConfiguredModel[]{m3214a(c0727my, deferredHolder.getId().getPath(), "block/window_shutters_base" + str, Token.IDENTIFIER)});
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m3214a(C0727my c0727my, String str, String str2, int i) {
        return new ConfiguredModel(c0727my.models().withExistingParent(str, c0727my.modLoc(str2)).texture("0", c0727my.modLoc("block/" + this.f3933bw)).texture("particle", c0727my.modLoc("block/" + this.f3933bw)), 0, i, false);
    }
}
