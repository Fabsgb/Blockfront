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

/* JADX INFO: renamed from: com.boehmod.blockfront.me */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/me.class */
public class C0707me {

    /* JADX INFO: renamed from: R */
    public static final ObjectList<C0707me> f3918R = new ObjectArrayList();

    /* JADX INFO: renamed from: bv */
    public final String f3919bv;

    /* JADX INFO: renamed from: z */
    public final DeferredHolder<Block, Block> f3920z;

    /* JADX INFO: renamed from: A */
    public final DeferredHolder<Block, Block> f3921A;

    /* JADX INFO: renamed from: B */
    public final DeferredHolder<Block, Block> f3922B;

    /* JADX INFO: renamed from: C */
    public final DeferredHolder<Block, Block> f3923C;

    /* JADX INFO: renamed from: D */
    public final DeferredHolder<Block, Block> f3924D;

    /* JADX INFO: renamed from: E */
    public final DeferredHolder<Block, Block> f3925E;

    /* JADX INFO: renamed from: F */
    public final DeferredHolder<Block, Block> f3926F;

    /* JADX INFO: renamed from: G */
    public final DeferredHolder<Block, Block> f3927G;

    /* JADX INFO: renamed from: H */
    public final DeferredHolder<Block, Block> f3928H;

    /* JADX INFO: renamed from: I */
    public final DeferredHolder<Block, Block> f3929I;

    /* JADX INFO: renamed from: J */
    public final DeferredHolder<Block, Block> f3930J;

    /* JADX INFO: renamed from: K */
    public final DeferredHolder<Block, Block> f3931K;

    public C0707me(@Nonnull String str, @Nonnull BlockBehaviour.Properties properties) {
        this.f3919bv = str;
        this.f3920z = C1295xi.f6989c.register(str + "_leaning_0", () -> {
            return new C0657lh(properties);
        });
        this.f3921A = C1295xi.f6989c.register(str + "_leaning_1", () -> {
            return new C0657lh(properties);
        });
        this.f3922B = C1295xi.f6989c.register(str + "_leaning_2", () -> {
            return new C0657lh(properties);
        });
        this.f3923C = C1295xi.f6989c.register(str + "_leaning_3", () -> {
            return new C0657lh(properties);
        });
        this.f3924D = C1295xi.f6989c.register(str + "_leaning_4", () -> {
            return new C0657lh(properties);
        });
        this.f3925E = C1295xi.f6989c.register(str + "_pile_0", () -> {
            return new C0657lh(properties);
        });
        this.f3926F = C1295xi.f6989c.register(str + "_pile_1", () -> {
            return new C0657lh(properties);
        });
        this.f3927G = C1295xi.f6989c.register(str + "_pile_2", () -> {
            return new C0657lh(properties);
        });
        this.f3928H = C1295xi.f6989c.register(str + "_pile_3", () -> {
            return new C0657lh(properties);
        });
        this.f3929I = C1295xi.f6989c.register(str + "_single_0", () -> {
            return new C0657lh(properties);
        });
        this.f3930J = C1295xi.f6989c.register(str + "_single_1", () -> {
            return new C0657lh(properties);
        });
        this.f3931K = C1295xi.f6989c.register(str + "_single_2", () -> {
            return new C0657lh(properties);
        });
        f3918R.add(this);
    }

    /* JADX INFO: renamed from: a */
    public void m3190a(@Nonnull C0727my c0727my) {
        m3194c(c0727my, this.f3920z, "_leaning_0");
        m3194c(c0727my, this.f3921A, "_leaning_1");
        m3194c(c0727my, this.f3922B, "_leaning_2");
        m3194c(c0727my, this.f3923C, "_leaning_3");
        m3194c(c0727my, this.f3924D, "_leaning_4");
        m3194c(c0727my, this.f3925E, "_pile_0");
        m3194c(c0727my, this.f3926F, "_pile_1");
        m3194c(c0727my, this.f3927G, "_pile_2");
        m3194c(c0727my, this.f3928H, "_pile_3");
        m3194c(c0727my, this.f3929I, "_single_0");
        m3194c(c0727my, this.f3930J, "_single_1");
        m3194c(c0727my, this.f3931K, "_single_2");
    }

    /* JADX INFO: renamed from: a */
    public void m3191a(@Nonnull C0677mA c0677mA) {
        c0677mA.withExistingParent(this.f3920z.getId().getPath(), this.f3920z.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3921A.getId().getPath(), this.f3921A.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3922B.getId().getPath(), this.f3922B.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3923C.getId().getPath(), this.f3923C.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3924D.getId().getPath(), this.f3924D.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3925E.getId().getPath(), this.f3925E.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3926F.getId().getPath(), this.f3926F.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3927G.getId().getPath(), this.f3927G.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3928H.getId().getPath(), this.f3928H.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3929I.getId().getPath(), this.f3929I.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3930J.getId().getPath(), this.f3930J.getId().withPrefix("block/"));
        c0677mA.withExistingParent(this.f3931K.getId().getPath(), this.f3931K.getId().withPrefix("block/"));
    }

    /* JADX INFO: renamed from: a */
    public void m3192a(C0678mB c0678mB) {
        String strM3193J = m3193J();
        c0678mB.add((Block) this.f3920z.get(), strM3193J + " Leaning 0");
        c0678mB.add((Block) this.f3921A.get(), strM3193J + " Leaning 1");
        c0678mB.add((Block) this.f3922B.get(), strM3193J + " Leaning 2");
        c0678mB.add((Block) this.f3923C.get(), strM3193J + " Leaning 3");
        c0678mB.add((Block) this.f3924D.get(), strM3193J + " Leaning 4");
        c0678mB.add((Block) this.f3925E.get(), strM3193J + " Pile 0");
        c0678mB.add((Block) this.f3926F.get(), strM3193J + " Pile 1");
        c0678mB.add((Block) this.f3927G.get(), strM3193J + " Pile 2");
        c0678mB.add((Block) this.f3928H.get(), strM3193J + " Pile 3");
        c0678mB.add((Block) this.f3929I.get(), strM3193J + " Single 0");
        c0678mB.add((Block) this.f3930J.get(), strM3193J + " Single 1");
        c0678mB.add((Block) this.f3931K.get(), strM3193J + " Single 2");
    }

    /* JADX INFO: renamed from: J */
    public String m3193J() {
        return (String) Arrays.stream(this.f3919bv.split("_")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));
    }

    /* JADX INFO: renamed from: c */
    private void m3194c(C0727my c0727my, DeferredHolder<Block, Block> deferredHolder, String str) {
        c0727my.getVariantBuilder((Block) deferredHolder.get()).partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel[]{m3195a(c0727my, deferredHolder.getId().getPath(), "block/plank_base" + str, 180)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST).addModels(new ConfiguredModel[]{m3195a(c0727my, deferredHolder.getId().getPath(), "block/plank_base" + str, Token.IDENTIFIER)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel[]{m3195a(c0727my, deferredHolder.getId().getPath(), "block/plank_base" + str, 0)}).partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST).addModels(new ConfiguredModel[]{m3195a(c0727my, deferredHolder.getId().getPath(), "block/plank_base" + str, 90)});
    }

    /* JADX INFO: renamed from: a */
    private ConfiguredModel m3195a(C0727my c0727my, String str, String str2, int i) {
        return new ConfiguredModel(c0727my.models().withExistingParent(str, c0727my.modLoc(str2)).texture("0", c0727my.modLoc("block/" + this.f3919bv)).texture("particle", c0727my.modLoc("block/" + this.f3919bv)), 0, i, false);
    }
}
