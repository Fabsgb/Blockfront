package com.boehmod.blockfront;

import java.util.Objects;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xq.class */
public class C1303xq {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final DeferredRegister<CreativeModeTab> f7496d = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "bf");

    /* JADX INFO: renamed from: ke */
    @NotNull
    private static final Component f7497ke = Component.translatable("bf.tab.shutters", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kf */
    @NotNull
    private static final Component f7498kf = Component.translatable("bf.tab.planks", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kg */
    @NotNull
    private static final Component f7499kg = Component.translatable("bf.tab.crates", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kh */
    @NotNull
    private static final Component f7500kh = Component.translatable("bf.tab.building_blocks", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: ki */
    @NotNull
    private static final Component f7501ki = Component.translatable("bf.tab.blocks", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kj */
    @NotNull
    private static final Component f7502kj = Component.translatable("bf.tab.items", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kk */
    @NotNull
    private static final Component f7503kk = Component.translatable("bf.tab.woodset", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kl */
    @NotNull
    private static final Component f7504kl = Component.translatable("bf.tab.boards", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: kq */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7505kq = f7496d.register("item_tab", () -> {
        return CreativeModeTab.builder().title(f7502kj).icon(() -> {
            return new ItemStack((ItemLike) C1308xv.f7770lQ.get());
        }).displayItems((itemDisplayParameters, output) -> {
            C1308xv.f7668a.getEntries().forEach(deferredHolder -> {
                Item item = (Item) deferredHolder.get();
                if ((item instanceof BlockItem) || (item instanceof C1068tT)) {
                    return;
                }
                output.accept(item);
            });
        }).build();
    });

    /* JADX INFO: renamed from: kr */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7506kr = f7496d.register("block_tab", () -> {
        return CreativeModeTab.builder().title(f7501ki).withTabsBefore(new ResourceLocation[]{f7505kq.getId()}).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7023db.get());
        }).displayItems((itemDisplayParameters, output) -> {
            C1295xi.f6988b.getEntries().forEach(deferredHolder -> {
                output.accept((ItemLike) deferredHolder.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: ks */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7507ks = f7496d.register("building_block_tab", () -> {
        return CreativeModeTab.builder().title(f7500kh).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7431p.f3902c.f3886o.get());
        }).withTabsBefore(new ResourceLocation[]{f7506kr.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0704mb.f3881P.forEach(c0704mb -> {
                output.accept((ItemLike) c0704mb.f3886o.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kt */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7508kt = f7496d.register("building_slab_tab", () -> {
        return CreativeModeTab.builder().title(f7500kh).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7431p.f3902c.f3887p.get());
        }).withTabsBefore(new ResourceLocation[]{f7507ks.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0704mb.f3881P.forEach(c0704mb -> {
                output.accept((ItemLike) c0704mb.f3887p.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: ku */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7509ku = f7496d.register("building_stair_tab", () -> {
        return CreativeModeTab.builder().title(f7500kh).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7431p.f3902c.f3888q.get());
        }).withTabsBefore(new ResourceLocation[]{f7508kt.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0704mb.f3881P.forEach(c0704mb -> {
                output.accept((ItemLike) c0704mb.f3888q.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kv */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7510kv = f7496d.register("building_wall_tab", () -> {
        return CreativeModeTab.builder().title(f7500kh).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7431p.f3902c.f3889r.get());
        }).withTabsBefore(new ResourceLocation[]{f7509ku.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0704mb.f3881P.forEach(c0704mb -> {
                output.accept((ItemLike) c0704mb.f3889r.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kw */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7511kw = f7496d.register("crate_tab", () -> {
        return CreativeModeTab.builder().title(f7499kg).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f6999a.f3895v.get());
        }).withTabsBefore(new ResourceLocation[]{f7510kv.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0705mc.f3890Q.forEach(c0705mc -> {
                output.accept((ItemLike) c0705mc.f3892s.get());
                output.accept((ItemLike) c0705mc.f3893t.get());
                output.accept((ItemLike) c0705mc.f3894u.get());
                output.accept((ItemLike) c0705mc.f3895v.get());
                output.accept((ItemLike) c0705mc.f3896w.get());
                output.accept((ItemLike) c0705mc.f3897x.get());
                output.accept((ItemLike) c0705mc.f3898y.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kx */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7512kx = f7496d.register("plank_tab", () -> {
        return CreativeModeTab.builder().title(f7498kf).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7216a.f3925E.get());
        }).withTabsBefore(new ResourceLocation[]{f7511kw.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0707me.f3918R.forEach(c0707me -> {
                output.accept((ItemLike) c0707me.f3920z.get());
                output.accept((ItemLike) c0707me.f3921A.get());
                output.accept((ItemLike) c0707me.f3922B.get());
                output.accept((ItemLike) c0707me.f3923C.get());
                output.accept((ItemLike) c0707me.f3924D.get());
                output.accept((ItemLike) c0707me.f3925E.get());
                output.accept((ItemLike) c0707me.f3926F.get());
                output.accept((ItemLike) c0707me.f3927G.get());
                output.accept((ItemLike) c0707me.f3928H.get());
                output.accept((ItemLike) c0707me.f3929I.get());
                output.accept((ItemLike) c0707me.f3930J.get());
                output.accept((ItemLike) c0707me.f3931K.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: ky */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7513ky = f7496d.register("shutter_tab", () -> {
        return CreativeModeTab.builder().title(f7497ke).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7130a.f3934L.get());
        }).withTabsBefore(new ResourceLocation[]{f7512kx.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0708mf.f3932S.forEach(c0708mf -> {
                output.accept((ItemLike) c0708mf.f3934L.get());
                output.accept((ItemLike) c0708mf.f3935M.get());
                output.accept((ItemLike) c0708mf.f3936N.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kz */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7514kz = f7496d.register("woodset_tab", () -> {
        return CreativeModeTab.builder().title(f7503kk).icon(() -> {
            return new ItemStack((ItemLike) ((DeferredHolder) Objects.requireNonNull(C1295xi.f7447c.f3947V)).get());
        }).withTabsBefore(new ResourceLocation[]{f7513ky.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0709mg.f3937T.forEach(c0709mg -> {
                output.accept((ItemLike) c0709mg.f3940O.get());
                output.accept((ItemLike) c0709mg.f3941P.get());
                output.accept((ItemLike) c0709mg.f3942Q.get());
                output.accept((ItemLike) c0709mg.f3943R.get());
                output.accept((ItemLike) c0709mg.f3944S.get());
                output.accept((ItemLike) c0709mg.f3945T.get());
                output.accept((ItemLike) c0709mg.f3946U.get());
                if (c0709mg.f3938en) {
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(c0709mg.f3947V)).get());
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(c0709mg.f3948W)).get());
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(c0709mg.f3949X)).get());
                }
            });
        }).build();
    });

    /* JADX INFO: renamed from: kA */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f7515kA = f7496d.register("board_tab", () -> {
        return CreativeModeTab.builder().title(f7504kl).icon(() -> {
            return new ItemStack((ItemLike) C1295xi.f7451d.f3880n.get());
        }).withTabsBefore(new ResourceLocation[]{f7514kz.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0703ma.f3877O.forEach(c0703ma -> {
                output.accept((ItemLike) c0703ma.f3880n.get());
            });
        }).build();
    });
}
