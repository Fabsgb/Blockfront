package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rQ.class */
public class rQ {

    @NotNull
    public static final List<List<Supplier<? extends C0558ur>>> bn = new ObjectArrayList();

    static {
        List<Supplier<? extends C0558ur>> objectArrayList = new ObjectArrayList<>();
        objectArrayList.add(wY.mL);
        objectArrayList.add(wY.mO);
        objectArrayList.add(wY.mj);
        objectArrayList.add(wY.mM);
        objectArrayList.add(wY.mN);
        objectArrayList.add(wY.mP);
        objectArrayList.add(wY.mQ);
        objectArrayList.add(wY.mR);
        objectArrayList.add(wY.mS);
        objectArrayList.add(wY.mT);
        bn.add(objectArrayList);
        List<Supplier<? extends C0558ur>> objectArrayList2 = new ObjectArrayList<>();
        objectArrayList2.add(wY.mv);
        objectArrayList2.add(wY.mx);
        objectArrayList2.add(wY.lw);
        objectArrayList2.add(wY.mu);
        objectArrayList2.add(wY.mr);
        bn.add(objectArrayList2);
        List<Supplier<? extends C0558ur>> objectArrayList3 = new ObjectArrayList<>();
        objectArrayList3.add(wY.ml);
        objectArrayList3.add(wY.mn);
        objectArrayList3.add(wY.mq);
        objectArrayList3.add(wY.mk);
        objectArrayList3.add(wY.ms);
        bn.add(objectArrayList3);
        List<Supplier<? extends C0558ur>> objectArrayList4 = new ObjectArrayList<>();
        objectArrayList4.add(wY.lR);
        objectArrayList4.add(wY.lT);
        objectArrayList4.add(wY.ma);
        objectArrayList4.add(wY.lU);
        objectArrayList4.add(wY.lY);
        objectArrayList4.add(wY.ng);
        bn.add(objectArrayList4);
        List<Supplier<? extends C0558ur>> objectArrayList5 = new ObjectArrayList<>();
        objectArrayList5.add(wY.lG);
        objectArrayList5.add(wY.lL);
        objectArrayList5.add(wY.lH);
        objectArrayList5.add(wY.lI);
        objectArrayList5.add(wY.lJ);
        objectArrayList5.add(wY.lK);
        objectArrayList5.add(wY.lM);
        bn.add(objectArrayList5);
        List<Supplier<? extends C0558ur>> objectArrayList6 = new ObjectArrayList<>();
        objectArrayList6.add(wY.lA);
        objectArrayList6.add(wY.lB);
        objectArrayList6.add(wY.lx);
        objectArrayList6.add(wY.lC);
        objectArrayList6.add(wY.lD);
        objectArrayList6.add(wY.lE);
        bn.add(objectArrayList6);
        List<Supplier<? extends C0558ur>> objectArrayList7 = new ObjectArrayList<>();
        objectArrayList7.add(wY.mg);
        objectArrayList7.add(wY.mh);
        objectArrayList7.add(wY.mi);
        objectArrayList7.add(wY.nh);
        objectArrayList7.add(wY.nj);
        bn.add(objectArrayList7);
        List<Supplier<? extends C0558ur>> objectArrayList8 = new ObjectArrayList<>();
        objectArrayList8.add(wY.mY);
        objectArrayList8.add(wY.mZ);
        objectArrayList8.add(wY.na);
        objectArrayList8.add(wY.nb);
        objectArrayList8.add(wY.nk);
        bn.add(objectArrayList8);
    }

    @NotNull
    public static List<Supplier<? extends C0558ur>> ar() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (List<Supplier<? extends C0558ur>> list : bn) {
            objectArrayList.add(list.get((int) (Math.random() * ((double) list.size()))));
        }
        return objectArrayList;
    }
}
