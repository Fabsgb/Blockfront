package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sn.class */
public class C1035sn {

    /* JADX INFO: renamed from: bu */
    @NotNull
    public static final List<List<Supplier<? extends C1117uP>>> f5644bu = new ObjectArrayList();

    static {
        List<Supplier<? extends C1117uP>> objectArrayList = new ObjectArrayList<>();
        objectArrayList.add(C1308xv.f7822mL);
        objectArrayList.add(C1308xv.f7825mO);
        objectArrayList.add(C1308xv.f7794mj);
        objectArrayList.add(C1308xv.f7823mM);
        objectArrayList.add(C1308xv.f7824mN);
        objectArrayList.add(C1308xv.f7826mP);
        objectArrayList.add(C1308xv.f7827mQ);
        objectArrayList.add(C1308xv.f7828mR);
        objectArrayList.add(C1308xv.f7829mS);
        objectArrayList.add(C1308xv.f7830mT);
        f5644bu.add(objectArrayList);
        List<Supplier<? extends C1117uP>> objectArrayList2 = new ObjectArrayList<>();
        objectArrayList2.add(C1308xv.f7806mv);
        objectArrayList2.add(C1308xv.f7808mx);
        objectArrayList2.add(C1308xv.f7750lw);
        objectArrayList2.add(C1308xv.f7805mu);
        objectArrayList2.add(C1308xv.f7802mr);
        f5644bu.add(objectArrayList2);
        List<Supplier<? extends C1117uP>> objectArrayList3 = new ObjectArrayList<>();
        objectArrayList3.add(C1308xv.f7796ml);
        objectArrayList3.add(C1308xv.f7798mn);
        objectArrayList3.add(C1308xv.f7801mq);
        objectArrayList3.add(C1308xv.f7795mk);
        objectArrayList3.add(C1308xv.f7803ms);
        f5644bu.add(objectArrayList3);
        List<Supplier<? extends C1117uP>> objectArrayList4 = new ObjectArrayList<>();
        objectArrayList4.add(C1308xv.f7771lR);
        objectArrayList4.add(C1308xv.f7775lT);
        objectArrayList4.add(C1308xv.f7784ma);
        objectArrayList4.add(C1308xv.f7776lU);
        objectArrayList4.add(C1308xv.f7780lY);
        objectArrayList4.add(C1308xv.f7843ng);
        f5644bu.add(objectArrayList4);
        List<Supplier<? extends C1117uP>> objectArrayList5 = new ObjectArrayList<>();
        objectArrayList5.add(C1308xv.f7760lG);
        objectArrayList5.add(C1308xv.f7765lL);
        objectArrayList5.add(C1308xv.f7761lH);
        objectArrayList5.add(C1308xv.f7762lI);
        objectArrayList5.add(C1308xv.f7763lJ);
        objectArrayList5.add(C1308xv.f7764lK);
        objectArrayList5.add(C1308xv.f7766lM);
        f5644bu.add(objectArrayList5);
        List<Supplier<? extends C1117uP>> objectArrayList6 = new ObjectArrayList<>();
        objectArrayList6.add(C1308xv.f7754lA);
        objectArrayList6.add(C1308xv.f7755lB);
        objectArrayList6.add(C1308xv.f7751lx);
        objectArrayList6.add(C1308xv.f7756lC);
        objectArrayList6.add(C1308xv.f7757lD);
        objectArrayList6.add(C1308xv.f7758lE);
        f5644bu.add(objectArrayList6);
        List<Supplier<? extends C1117uP>> objectArrayList7 = new ObjectArrayList<>();
        objectArrayList7.add(C1308xv.f7790mg);
        objectArrayList7.add(C1308xv.f7791mh);
        objectArrayList7.add(C1308xv.f7792mi);
        objectArrayList7.add(C1308xv.f7844nh);
        objectArrayList7.add(C1308xv.f7846nj);
        f5644bu.add(objectArrayList7);
        List<Supplier<? extends C1117uP>> objectArrayList8 = new ObjectArrayList<>();
        objectArrayList8.add(C1308xv.f7835mY);
        objectArrayList8.add(C1308xv.f7836mZ);
        objectArrayList8.add(C1308xv.f7837na);
        objectArrayList8.add(C1308xv.f7838nb);
        objectArrayList8.add(C1308xv.f7847nk);
        f5644bu.add(objectArrayList8);
    }

    @NotNull
    /* JADX INFO: renamed from: at */
    public static List<Supplier<? extends C1117uP>> m5778at() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (List<Supplier<? extends C1117uP>> list : f5644bu) {
            objectArrayList.add(list.get((int) (Math.random() * ((double) list.size()))));
        }
        return objectArrayList;
    }
}
