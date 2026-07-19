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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wT.class */
public class wT {

    @NotNull
    public static final DeferredRegister<CreativeModeTab> d = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "bf");

    @NotNull
    private static final Component jR = Component.translatable("bf.tab.shutters", new Object[]{C0002a.a});

    @NotNull
    private static final Component jS = Component.translatable("bf.tab.planks", new Object[]{C0002a.a});

    @NotNull
    private static final Component jT = Component.translatable("bf.tab.crates", new Object[]{C0002a.a});

    @NotNull
    private static final Component jU = Component.translatable("bf.tab.building_blocks", new Object[]{C0002a.a});

    @NotNull
    private static final Component jV = Component.translatable("bf.tab.blocks", new Object[]{C0002a.a});

    @NotNull
    private static final Component jW = Component.translatable("bf.tab.items", new Object[]{C0002a.a});

    @NotNull
    private static final Component jX = Component.translatable("bf.tab.woodset", new Object[]{C0002a.a});

    @NotNull
    private static final Component jY = Component.translatable("bf.tab.boards", new Object[]{C0002a.a});
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kq = d.register("item_tab", () -> {
        return CreativeModeTab.builder().title(jW).icon(() -> {
            return new ItemStack((ItemLike) wY.lQ.get());
        }).displayItems((itemDisplayParameters, output) -> {
            wY.a.getEntries().forEach(deferredHolder -> {
                Item item = (Item) deferredHolder.get();
                if ((item instanceof BlockItem) || (item instanceof C0535tv)) {
                    return;
                }
                output.accept(item);
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kr = d.register("block_tab", () -> {
        return CreativeModeTab.builder().title(jV).withTabsBefore(new ResourceLocation[]{kq.getId()}).icon(() -> {
            return new ItemStack((ItemLike) wL.db.get());
        }).displayItems((itemDisplayParameters, output) -> {
            wL.b.getEntries().forEach(deferredHolder -> {
                output.accept((ItemLike) deferredHolder.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ks = d.register("building_block_tab", () -> {
        return CreativeModeTab.builder().title(jU).icon(() -> {
            return new ItemStack((ItemLike) wL.p.c.o.get());
        }).withTabsBefore(new ResourceLocation[]{kr.getId()}).displayItems((itemDisplayParameters, output) -> {
            lF.G.forEach(lFVar -> {
                output.accept((ItemLike) lFVar.o.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kt = d.register("building_slab_tab", () -> {
        return CreativeModeTab.builder().title(jU).icon(() -> {
            return new ItemStack((ItemLike) wL.p.c.p.get());
        }).withTabsBefore(new ResourceLocation[]{ks.getId()}).displayItems((itemDisplayParameters, output) -> {
            lF.G.forEach(lFVar -> {
                output.accept((ItemLike) lFVar.p.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ku = d.register("building_stair_tab", () -> {
        return CreativeModeTab.builder().title(jU).icon(() -> {
            return new ItemStack((ItemLike) wL.p.c.q.get());
        }).withTabsBefore(new ResourceLocation[]{kt.getId()}).displayItems((itemDisplayParameters, output) -> {
            lF.G.forEach(lFVar -> {
                output.accept((ItemLike) lFVar.q.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kv = d.register("building_wall_tab", () -> {
        return CreativeModeTab.builder().title(jU).icon(() -> {
            return new ItemStack((ItemLike) wL.p.c.r.get());
        }).withTabsBefore(new ResourceLocation[]{ku.getId()}).displayItems((itemDisplayParameters, output) -> {
            lF.G.forEach(lFVar -> {
                output.accept((ItemLike) lFVar.r.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kw = d.register("crate_tab", () -> {
        return CreativeModeTab.builder().title(jT).icon(() -> {
            return new ItemStack((ItemLike) wL.f326a.v.get());
        }).withTabsBefore(new ResourceLocation[]{kv.getId()}).displayItems((itemDisplayParameters, output) -> {
            lG.H.forEach(lGVar -> {
                output.accept((ItemLike) lGVar.s.get());
                output.accept((ItemLike) lGVar.t.get());
                output.accept((ItemLike) lGVar.u.get());
                output.accept((ItemLike) lGVar.v.get());
                output.accept((ItemLike) lGVar.w.get());
                output.accept((ItemLike) lGVar.x.get());
                output.accept((ItemLike) lGVar.y.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kx = d.register("plank_tab", () -> {
        return CreativeModeTab.builder().title(jS).icon(() -> {
            return new ItemStack((ItemLike) wL.f342a.E.get());
        }).withTabsBefore(new ResourceLocation[]{kw.getId()}).displayItems((itemDisplayParameters, output) -> {
            lI.I.forEach(lIVar -> {
                output.accept((ItemLike) lIVar.z.get());
                output.accept((ItemLike) lIVar.A.get());
                output.accept((ItemLike) lIVar.B.get());
                output.accept((ItemLike) lIVar.C.get());
                output.accept((ItemLike) lIVar.D.get());
                output.accept((ItemLike) lIVar.E.get());
                output.accept((ItemLike) lIVar.F.get());
                output.accept((ItemLike) lIVar.G.get());
                output.accept((ItemLike) lIVar.H.get());
                output.accept((ItemLike) lIVar.f230I.get());
                output.accept((ItemLike) lIVar.J.get());
                output.accept((ItemLike) lIVar.K.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ky = d.register("shutter_tab", () -> {
        return CreativeModeTab.builder().title(jR).icon(() -> {
            return new ItemStack((ItemLike) wL.f331a.L.get());
        }).withTabsBefore(new ResourceLocation[]{kx.getId()}).displayItems((itemDisplayParameters, output) -> {
            lJ.J.forEach(lJVar -> {
                output.accept((ItemLike) lJVar.L.get());
                output.accept((ItemLike) lJVar.M.get());
                output.accept((ItemLike) lJVar.N.get());
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kz = d.register("woodset_tab", () -> {
        return CreativeModeTab.builder().title(jX).icon(() -> {
            return new ItemStack((ItemLike) ((DeferredHolder) Objects.requireNonNull(wL.f375c.V)).get());
        }).withTabsBefore(new ResourceLocation[]{ky.getId()}).displayItems((itemDisplayParameters, output) -> {
            lK.K.forEach(lKVar -> {
                output.accept((ItemLike) lKVar.O.get());
                output.accept((ItemLike) lKVar.P.get());
                output.accept((ItemLike) lKVar.Q.get());
                output.accept((ItemLike) lKVar.R.get());
                output.accept((ItemLike) lKVar.S.get());
                output.accept((ItemLike) lKVar.T.get());
                output.accept((ItemLike) lKVar.U.get());
                if (lKVar.dU) {
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(lKVar.V)).get());
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(lKVar.W)).get());
                    output.accept((ItemLike) ((DeferredHolder) Objects.requireNonNull(lKVar.X)).get());
                }
            });
        }).build();
    });
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> kA = d.register("board_tab", () -> {
        return CreativeModeTab.builder().title(jY).icon(() -> {
            return new ItemStack((ItemLike) wL.f379d.n.get());
        }).withTabsBefore(new ResourceLocation[]{kz.getId()}).displayItems((itemDisplayParameters, output) -> {
            lE.F.forEach(lEVar -> {
                output.accept((ItemLike) lEVar.n.get());
            });
        }).build();
    });
}
