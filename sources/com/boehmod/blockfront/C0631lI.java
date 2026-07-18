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

/* JADX INFO: renamed from: com.boehmod.blockfront.lI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lI.class */
public class C0631lI {

    /* JADX INFO: renamed from: I */
    public static final ObjectList<C0631lI> f3444I = new ObjectArrayList();

    /* JADX INFO: renamed from: bm */
    public final String f3445bm;

    /* JADX INFO: renamed from: z */
    public final DeferredHolder<Block, Block> f3446z;

    /* JADX INFO: renamed from: A */
    public final DeferredHolder<Block, Block> f3447A;

    /* JADX INFO: renamed from: B */
    public final DeferredHolder<Block, Block> f3448B;

    /* JADX INFO: renamed from: C */
    public final DeferredHolder<Block, Block> f3449C;

    /* JADX INFO: renamed from: D */
    public final DeferredHolder<Block, Block> f3450D;

    /* JADX INFO: renamed from: E */
    public final DeferredHolder<Block, Block> f3451E;

    /* JADX INFO: renamed from: F */
    public final DeferredHolder<Block, Block> f3452F;

    /* JADX INFO: renamed from: G */
    public final DeferredHolder<Block, Block> f3453G;

    /* JADX INFO: renamed from: H */
    public final DeferredHolder<Block, Block> f3454H;

    /* JADX INFO: renamed from: I */
    public final DeferredHolder<Block, Block> f3455I;

    /* JADX INFO: renamed from: J */
    public final DeferredHolder<Block, Block> f3456J;

    /* JADX INFO: renamed from: K */
    public final DeferredHolder<Block, Block> f3457K;

    public C0631lI(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.f3445bm = str;
        this.f3446z = C1218wL.f6426c.register(str + "_leaning_0", () -> {
            return new C0581kL(properties);
        });
        this.f3447A = C1218wL.f6426c.register(str + "_leaning_1", () -> {
            return new C0581kL(properties);
        });
        this.f3448B = C1218wL.f6426c.register(str + "_leaning_2", () -> {
            return new C0581kL(properties);
        });
        this.f3449C = C1218wL.f6426c.register(str + "_leaning_3", () -> {
            return new C0581kL(properties);
        });
        this.f3450D = C1218wL.f6426c.register(str + "_leaning_4", () -> {
            return new C0581kL(properties);
        });
        this.f3451E = C1218wL.f6426c.register(str + "_pile_0", () -> {
            return new C0581kL(properties);
        });
        this.f3452F = C1218wL.f6426c.register(str + "_pile_1", () -> {
            return new C0581kL(properties);
        });
        this.f3453G = C1218wL.f6426c.register(str + "_pile_2", () -> {
            return new C0581kL(properties);
        });
        this.f3454H = C1218wL.f6426c.register(str + "_pile_3", () -> {
            return new C0581kL(properties);
        });
        this.f3455I = C1218wL.f6426c.register(str + "_single_0", () -> {
            return new C0581kL(properties);
        });
        this.f3456J = C1218wL.f6426c.register(str + "_single_1", () -> {
            return new C0581kL(properties);
        });
        this.f3457K = C1218wL.f6426c.register(str + "_single_2", () -> {
            return new C0581kL(properties);
        });
        f3444I.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m2759a(@Nonnull C0704mc c0704mc) {
        m2763c(c0704mc, this.f3446z, "_leaning_0");
        m2763c(c0704mc, this.f3447A, "_leaning_1");
        m2763c(c0704mc, this.f3448B, "_leaning_2");
        m2763c(c0704mc, this.f3449C, "_leaning_3");
        m2763c(c0704mc, this.f3450D, "_leaning_4");
        m2763c(c0704mc, this.f3451E, "_pile_0");
        m2763c(c0704mc, this.f3452F, "_pile_1");
        m2763c(c0704mc, this.f3453G, "_pile_2");
        m2763c(c0704mc, this.f3454H, "_pile_3");
        m2763c(c0704mc, this.f3455I, "_single_0");
        m2763c(c0704mc, this.f3456J, "_single_1");
        m2763c(c0704mc, this.f3457K, "_single_2");
    }

    /* JADX INFO: renamed from: a */
    public void m2760a(@Nonnull C0706me c0706me) {
        c0706me.withExistingParent(this.f3446z.getId().getPath(), this.f3446z.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3447A.getId().getPath(), this.f3447A.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3448B.getId().getPath(), this.f3448B.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3449C.getId().getPath(), this.f3449C.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3450D.getId().getPath(), this.f3450D.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3451E.getId().getPath(), this.f3451E.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3452F.getId().getPath(), this.f3452F.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3453G.getId().getPath(), this.f3453G.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3454H.getId().getPath(), this.f3454H.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3455I.getId().getPath(), this.f3455I.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3456J.getId().getPath(), this.f3456J.getId().withPrefix("block/"));
        c0706me.withExistingParent(this.f3457K.getId().getPath(), this.f3457K.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m2761a(C0707mf c0707mf) {
        String strM2762C = m2762C();
        c0707mf.add((Block) this.f3446z.get(), strM2762C + " Leaning 0");
        c0707mf.add((Block) this.f3447A.get(), strM2762C + " Leaning 1");
        c0707mf.add((Block) this.f3448B.get(), strM2762C + " Leaning 2");
        c0707mf.add((Block) this.f3449C.get(), strM2762C + " Leaning 3");
        c0707mf.add((Block) this.f3450D.get(), strM2762C + " Leaning 4");
        c0707mf.add((Block) this.f3451E.get(), strM2762C + " Pile 0");
        c0707mf.add((Block) this.f3452F.get(), strM2762C + " Pile 1");
        c0707mf.add((Block) this.f3453G.get(), strM2762C + " Pile 2");
        c0707mf.add((Block) this.f3454H.get(), strM2762C + " Pile 3");
        c0707mf.add((Block) this.f3455I.get(), strM2762C + " Single 0");
        c0707mf.add((Block) this.f3456J.get(), strM2762C + " Single 1");
        c0707mf.add((Block) this.f3457K.get(), strM2762C + " Single 2");
    }

    /* JADX INFO: renamed from: C */
    public String m2762C() {
        return (String) Arrays.stream(this.f3445bm.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    /* JADX INFO: renamed from: c */
    private void m2763c(C0704mc c0704mc, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0704mc.getVariantBuilder((Block) deferredHolder.get()).partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel[]{m2764a(c0704mc, deferredHolder.getId().getPath(), "block/plank_base" + str, 180)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST).addModels(new ConfiguredModel[]{m2764a(c0704mc, deferredHolder.getId().getPath(), "block/plank_base" + str, Token.IDENTIFIER)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel[]{m2764a(c0704mc, deferredHolder.getId().getPath(), "block/plank_base" + str, 0)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST).addModels(new ConfiguredModel[]{m2764a(c0704mc, deferredHolder.getId().getPath(), "block/plank_base" + str, 90)});
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m2764a(C0704mc c0704mc, String str, String str2, int i) {
        return new ConfiguredModel(c0704mc.models().withExistingParent(str, c0704mc.modLoc(str2)).texture("0", c0704mc.modLoc("block/" + this.f3445bm)).texture("particle", c0704mc.modLoc("block/" + this.f3445bm)), 0, i, false);
    }
}
