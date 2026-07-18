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

/* JADX INFO: renamed from: com.boehmod.blockfront.wT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wT.class */
public class C1226wT {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final DeferredRegister<CreativeModeTab> f6933d = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "bf");

    /* JADX INFO: renamed from: jR */
    @NotNull
    private static final Component f6934jR = Component.translatable("bf.tab.shutters", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jS */
    @NotNull
    private static final Component f6935jS = Component.translatable("bf.tab.planks", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jT */
    @NotNull
    private static final Component f6936jT = Component.translatable("bf.tab.crates", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jU */
    @NotNull
    private static final Component f6937jU = Component.translatable("bf.tab.building_blocks", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jV */
    @NotNull
    private static final Component f6938jV = Component.translatable("bf.tab.blocks", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jW */
    @NotNull
    private static final Component f6939jW = Component.translatable("bf.tab.items", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jX */
    @NotNull
    private static final Component f6940jX = Component.translatable("bf.tab.woodset", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: jY */
    @NotNull
    private static final Component f6941jY = Component.translatable("bf.tab.boards", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: kq */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6942kq = f6933d.register("item_tab", () -> {
        return CreativeModeTab.builder().title(f6939jW).icon(() -> {
            return new ItemStack((ItemLike) C1231wY.f7205lQ.get());
        }).displayItems((itemDisplayParameters, output) -> {
            C1231wY.f7103a.getEntries().forEach(deferredHolder -> {
                Item item = (Item) deferredHolder.get();
                if ((item instanceof BlockItem) || (item instanceof C1095tv)) {
                    return;
                }
                output.accept(item);
            });
        }).build();
    });

    /* JADX INFO: renamed from: kr */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6943kr = f6933d.register("block_tab", () -> {
        return CreativeModeTab.builder().title(f6938jV).withTabsBefore(new ResourceLocation[]{f6942kq.getId()}).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6460db.get());
        }).displayItems((itemDisplayParameters, output) -> {
            C1218wL.f6425b.getEntries().forEach(deferredHolder -> {
                output.accept((ItemLike) deferredHolder.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: ks */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6944ks = f6933d.register("building_block_tab", () -> {
        return CreativeModeTab.builder().title(f6937jU).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6868p.f3428c.f3412o.get());
        }).withTabsBefore(new ResourceLocation[]{f6943kr.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0628lF.f3407G.forEach(c0628lF -> {
                output.accept((ItemLike) c0628lF.f3412o.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kt */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6945kt = f6933d.register("building_slab_tab", () -> {
        return CreativeModeTab.builder().title(f6937jU).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6868p.f3428c.f3413p.get());
        }).withTabsBefore(new ResourceLocation[]{f6944ks.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0628lF.f3407G.forEach(c0628lF -> {
                output.accept((ItemLike) c0628lF.f3413p.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: ku */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6946ku = f6933d.register("building_stair_tab", () -> {
        return CreativeModeTab.builder().title(f6937jU).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6868p.f3428c.f3414q.get());
        }).withTabsBefore(new ResourceLocation[]{f6945kt.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0628lF.f3407G.forEach(c0628lF -> {
                output.accept((ItemLike) c0628lF.f3414q.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kv */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6947kv = f6933d.register("building_wall_tab", () -> {
        return CreativeModeTab.builder().title(f6937jU).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6868p.f3428c.f3415r.get());
        }).withTabsBefore(new ResourceLocation[]{f6946ku.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0628lF.f3407G.forEach(c0628lF -> {
                output.accept((ItemLike) c0628lF.f3415r.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kw */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6948kw = f6933d.register("crate_tab", () -> {
        return CreativeModeTab.builder().title(f6936jT).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6436a.f3421v.get());
        }).withTabsBefore(new ResourceLocation[]{f6947kv.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0629lG.f3416H.forEach(c0629lG -> {
                output.accept((ItemLike) c0629lG.f3418s.get());
                output.accept((ItemLike) c0629lG.f3419t.get());
                output.accept((ItemLike) c0629lG.f3420u.get());
                output.accept((ItemLike) c0629lG.f3421v.get());
                output.accept((ItemLike) c0629lG.f3422w.get());
                output.accept((ItemLike) c0629lG.f3423x.get());
                output.accept((ItemLike) c0629lG.f3424y.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kx */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6949kx = f6933d.register("plank_tab", () -> {
        return CreativeModeTab.builder().title(f6935jS).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6653a.f3451E.get());
        }).withTabsBefore(new ResourceLocation[]{f6948kw.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0631lI.f3444I.forEach(c0631lI -> {
                output.accept((ItemLike) c0631lI.f3446z.get());
                output.accept((ItemLike) c0631lI.f3447A.get());
                output.accept((ItemLike) c0631lI.f3448B.get());
                output.accept((ItemLike) c0631lI.f3449C.get());
                output.accept((ItemLike) c0631lI.f3450D.get());
                output.accept((ItemLike) c0631lI.f3451E.get());
                output.accept((ItemLike) c0631lI.f3452F.get());
                output.accept((ItemLike) c0631lI.f3453G.get());
                output.accept((ItemLike) c0631lI.f3454H.get());
                output.accept((ItemLike) c0631lI.f3455I.get());
                output.accept((ItemLike) c0631lI.f3456J.get());
                output.accept((ItemLike) c0631lI.f3457K.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: ky */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6950ky = f6933d.register("shutter_tab", () -> {
        return CreativeModeTab.builder().title(f6934jR).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6567a.f3460L.get());
        }).withTabsBefore(new ResourceLocation[]{f6949kx.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0632lJ.f3458J.forEach(c0632lJ -> {
                output.accept((ItemLike) c0632lJ.f3460L.get());
                output.accept((ItemLike) c0632lJ.f3461M.get());
                output.accept((ItemLike) c0632lJ.f3462N.get());
            });
        }).build();
    });

    /* JADX INFO: renamed from: kz */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6951kz = f6933d.register("woodset_tab", () -> {
        return CreativeModeTab.builder().title(f6940jX).icon(() -> {
            return new ItemStack((ItemLike) ((DeferredHolder) Objects.requireNonNull(C1218wL.f6884c.f3473V)).get());
        }).withTabsBefore(new ResourceLocation[]{f6950ky.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0633lK.f3463K.forEach(c0633lK -> {
                output.accept((ItemLike) c0633lK.f3466O.get());
                output.accept((ItemLike) c0633lK.f3467P.get());
                output.accept((ItemLike) c0633lK.f3468Q.get());
                output.accept((ItemLike) c0633lK.f3469R.get());
                output.accept((ItemLike) c0633lK.f3470S.get());
                output.accept((ItemLike) c0633lK.f3471T.get());
                output.accept((ItemLike) c0633lK.f3472U.get());
                if (c0633lK.f3464dU) {
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(c0633lK.f3473V)).get());
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(c0633lK.f3474W)).get());
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(c0633lK.f3475X)).get());
                }
            });
        }).build();
    });

    /* JADX INFO: renamed from: kA */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> f6952kA = f6933d.register("board_tab", () -> {
        return CreativeModeTab.builder().title(f6941jY).icon(() -> {
            return new ItemStack((ItemLike) C1218wL.f6888d.f3406n.get());
        }).withTabsBefore(new ResourceLocation[]{f6951kz.getId()}).displayItems((itemDisplayParameters, output) -> {
            C0627lE.f3403F.forEach(c0627lE -> {
                output.accept((ItemLike) c0627lE.f3406n.get());
            });
        }).build();
    });
}
