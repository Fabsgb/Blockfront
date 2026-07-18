package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rQ.class */
public class C0957rQ {

    /* JADX INFO: renamed from: bn */
    @NotNull
    public static final List<List<Supplier<? extends C1144ur>>> f5067bn = new ObjectArrayList();

    static {
        List<Supplier<? extends C1144ur>> objectArrayList = new ObjectArrayList<>();
        objectArrayList.add(C1231wY.f7257mL);
        objectArrayList.add(C1231wY.f7260mO);
        objectArrayList.add(C1231wY.f7229mj);
        objectArrayList.add(C1231wY.f7258mM);
        objectArrayList.add(C1231wY.f7259mN);
        objectArrayList.add(C1231wY.f7261mP);
        objectArrayList.add(C1231wY.f7262mQ);
        objectArrayList.add(C1231wY.f7263mR);
        objectArrayList.add(C1231wY.f7264mS);
        objectArrayList.add(C1231wY.f7265mT);
        f5067bn.add(objectArrayList);
        List<Supplier<? extends C1144ur>> objectArrayList2 = new ObjectArrayList<>();
        objectArrayList2.add(C1231wY.f7241mv);
        objectArrayList2.add(C1231wY.f7243mx);
        objectArrayList2.add(C1231wY.f7185lw);
        objectArrayList2.add(C1231wY.f7240mu);
        objectArrayList2.add(C1231wY.f7237mr);
        f5067bn.add(objectArrayList2);
        List<Supplier<? extends C1144ur>> objectArrayList3 = new ObjectArrayList<>();
        objectArrayList3.add(C1231wY.f7231ml);
        objectArrayList3.add(C1231wY.f7233mn);
        objectArrayList3.add(C1231wY.f7236mq);
        objectArrayList3.add(C1231wY.f7230mk);
        objectArrayList3.add(C1231wY.f7238ms);
        f5067bn.add(objectArrayList3);
        List<Supplier<? extends C1144ur>> objectArrayList4 = new ObjectArrayList<>();
        objectArrayList4.add(C1231wY.f7206lR);
        objectArrayList4.add(C1231wY.f7210lT);
        objectArrayList4.add(C1231wY.f7219ma);
        objectArrayList4.add(C1231wY.f7211lU);
        objectArrayList4.add(C1231wY.f7215lY);
        objectArrayList4.add(C1231wY.f7278ng);
        f5067bn.add(objectArrayList4);
        List<Supplier<? extends C1144ur>> objectArrayList5 = new ObjectArrayList<>();
        objectArrayList5.add(C1231wY.f7195lG);
        objectArrayList5.add(C1231wY.f7200lL);
        objectArrayList5.add(C1231wY.f7196lH);
        objectArrayList5.add(C1231wY.f7197lI);
        objectArrayList5.add(C1231wY.f7198lJ);
        objectArrayList5.add(C1231wY.f7199lK);
        objectArrayList5.add(C1231wY.f7201lM);
        f5067bn.add(objectArrayList5);
        List<Supplier<? extends C1144ur>> objectArrayList6 = new ObjectArrayList<>();
        objectArrayList6.add(C1231wY.f7189lA);
        objectArrayList6.add(C1231wY.f7190lB);
        objectArrayList6.add(C1231wY.f7186lx);
        objectArrayList6.add(C1231wY.f7191lC);
        objectArrayList6.add(C1231wY.f7192lD);
        objectArrayList6.add(C1231wY.f7193lE);
        f5067bn.add(objectArrayList6);
        List<Supplier<? extends C1144ur>> objectArrayList7 = new ObjectArrayList<>();
        objectArrayList7.add(C1231wY.f7225mg);
        objectArrayList7.add(C1231wY.f7226mh);
        objectArrayList7.add(C1231wY.f7227mi);
        objectArrayList7.add(C1231wY.f7279nh);
        objectArrayList7.add(C1231wY.f7281nj);
        f5067bn.add(objectArrayList7);
        List<Supplier<? extends C1144ur>> objectArrayList8 = new ObjectArrayList<>();
        objectArrayList8.add(C1231wY.f7270mY);
        objectArrayList8.add(C1231wY.f7271mZ);
        objectArrayList8.add(C1231wY.f7272na);
        objectArrayList8.add(C1231wY.f7273nb);
        objectArrayList8.add(C1231wY.f7282nk);
        f5067bn.add(objectArrayList8);
    }

    @NotNull
    /* JADX INFO: renamed from: ar */
    public static List<Supplier<? extends C1144ur>> m5241ar() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (List<Supplier<? extends C1144ur>> list : f5067bn) {
            objectArrayList.add(list.get((int) (Math.random() * ((double) list.size()))));
        }
        return objectArrayList;
    }
}
