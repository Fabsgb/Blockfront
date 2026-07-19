package com.boehmod.blockfront;

import com.mojang.datafixers.types.Type;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Map;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wJ.class */
public class wJ {

    @NotNull
    public static final DeferredRegister<BlockEntityType<?>> a = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "bf");
    public static final Map<String, DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lP>>> as = new Object2ObjectOpenHashMap();
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bI;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lO>> bJ;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lM>> bK;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bL;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bM;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bN;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bO;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bP;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bQ;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bR;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bS;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bT;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bU;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lL>> bV;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lR>> bW;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lL>> bX;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bY;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> bZ;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> ca;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cb;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cc;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cd;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> ce;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cf;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cg;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> ch;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> ci;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cj;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> ck;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cl;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cm;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cn;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> co;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cp;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cq;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cr;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cs;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> ct;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cu;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cv;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cw;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cx;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cy;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cz;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cA;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cB;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cC;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cD;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cE;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cF;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cG;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cH;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lN>> cI;

    static {
        ObjectListIterator it = lG.H.iterator();
        while (it.hasNext()) {
            lG lGVar = (lG) it.next();
            as.put(lGVar.bk, a.register(lGVar.y.getId().getPath(), () -> {
                return BlockEntityType.Builder.of((blockPos, blockState) -> {
                    return new lP(lGVar.bk, blockPos, blockState);
                }, new Block[]{(Block) lGVar.y.get()}).build((Type) null);
            }));
        }
        bI = a.register(wL.iF.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bI.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iF.get()}).build((Type) null);
        });
        bJ = a.register(wL.iG.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lO((BlockEntityType) bJ.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iG.get()}).build((Type) null);
        });
        bK = a.register(wL.ep.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lM((BlockEntityType) bK.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ep.get()}).build((Type) null);
        });
        bL = a.register(wL.eu.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bL.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.eu.get()}).build((Type) null);
        });
        bM = a.register(wL.ev.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bM.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ev.get()}).build((Type) null);
        });
        bN = a.register(wL.ew.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bN.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ew.get()}).build((Type) null);
        });
        bO = a.register(wL.ex.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bO.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ex.get()}).build((Type) null);
        });
        bP = a.register(wL.ez.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bP.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ez.get()}).build((Type) null);
        });
        bQ = a.register(wL.eA.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bQ.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.eA.get()}).build((Type) null);
        });
        bR = a.register(wL.eB.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bR.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.eB.get()}).build((Type) null);
        });
        bS = a.register(wL.eC.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bS.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.eC.get()}).build((Type) null);
        });
        bT = a.register(wL.ey.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bT.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ey.get()}).build((Type) null);
        });
        bU = a.register(wL.hS.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bU.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hS.get()}).build((Type) null);
        });
        bV = a.register(wL.ft.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lL((BlockEntityType) bV.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ft.get()}).build((Type) null);
        });
        bW = a.register(wL.fv.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lR((BlockEntityType) bW.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.fv.get()}).build((Type) null);
        });
        bX = a.register(wL.fu.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lL((BlockEntityType) bX.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.fu.get()}).build((Type) null);
        });
        bY = a.register(wL.hT.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bY.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hT.get()}).build((Type) null);
        });
        bZ = a.register(wL.hU.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) bZ.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hU.get()}).build((Type) null);
        });
        ca = a.register(wL.hV.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) ca.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hV.get()}).build((Type) null);
        });
        cb = a.register(wL.hW.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cb.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hW.get()}).build((Type) null);
        });
        cc = a.register(wL.hX.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cc.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hX.get()}).build((Type) null);
        });
        cd = a.register(wL.hY.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cd.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hY.get()}).build((Type) null);
        });
        ce = a.register(wL.hZ.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) ce.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.hZ.get()}).build((Type) null);
        });
        cf = a.register(wL.id.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cf.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.id.get()}).build((Type) null);
        });
        cg = a.register(wL.ia.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cg.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ia.get()}).build((Type) null);
        });
        ch = a.register(wL.ib.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) ch.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ib.get()}).build((Type) null);
        });
        ci = a.register(wL.ic.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) ci.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ic.get()}).build((Type) null);
        });
        cj = a.register(wL.ir.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cj.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ir.get()}).build((Type) null);
        });
        ck = a.register(wL.ie.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) ck.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ie.get()}).build((Type) null);
        });
        cl = a.register(wL.f354if.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cl.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.f354if.get()}).build((Type) null);
        });
        cm = a.register(wL.ig.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cm.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ig.get()}).build((Type) null);
        });
        cn = a.register(wL.ih.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cn.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ih.get()}).build((Type) null);
        });
        co = a.register(wL.ii.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) co.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ii.get()}).build((Type) null);
        });
        cp = a.register(wL.ij.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cp.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ij.get()}).build((Type) null);
        });
        cq = a.register(wL.ik.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cq.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ik.get()}).build((Type) null);
        });
        cr = a.register(wL.il.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cr.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.il.get()}).build((Type) null);
        });
        cs = a.register(wL.im.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cs.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.im.get()}).build((Type) null);
        });
        ct = a.register(wL.in.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) ct.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.in.get()}).build((Type) null);
        });
        cu = a.register(wL.f425io.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cu.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.f425io.get()}).build((Type) null);
        });
        cv = a.register(wL.ip.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cv.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ip.get()}).build((Type) null);
        });
        cw = a.register(wL.iq.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cw.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iq.get()}).build((Type) null);
        });
        cx = a.register(wL.is.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cx.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.is.get()}).build((Type) null);
        });
        cy = a.register(wL.iB.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cy.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iB.get()}).build((Type) null);
        });
        cz = a.register(wL.iC.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cz.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iC.get()}).build((Type) null);
        });
        cA = a.register(wL.it.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cA.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.it.get()}).build((Type) null);
        });
        cB = a.register(wL.iu.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cB.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iu.get()}).build((Type) null);
        });
        cC = a.register(wL.iv.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cC.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iv.get()}).build((Type) null);
        });
        cD = a.register(wL.iw.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cD.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iw.get()}).build((Type) null);
        });
        cE = a.register(wL.ix.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cE.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.ix.get()}).build((Type) null);
        });
        cF = a.register(wL.iz.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cF.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iz.get()}).build((Type) null);
        });
        cG = a.register(wL.iA.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cG.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iA.get()}).build((Type) null);
        });
        cH = a.register(wL.iE.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cH.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iE.get()}).build((Type) null);
        });
        cI = a.register(wL.iD.getId().getPath(), () -> {
            return BlockEntityType.Builder.of((blockPos, blockState) -> {
                return new lN((BlockEntityType) cI.get(), blockPos, blockState);
            }, new Block[]{(Block) wL.iD.get()}).build((Type) null);
        });
    }
}
