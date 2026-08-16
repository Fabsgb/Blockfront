package com.boehmod.blockfront;

import com.boehmod.blockfront.cloud.connection.ModConnection;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ya */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ya.class */
public class C1314ya {
    /* JADX INFO: renamed from: f */
    public static void m8246f(@NotNull C1280xT c1280xT) {
        C0881pt c0881pt = new C0881pt(1.0d, 2.0d, 0.0d, 45.0f, 90.0f);
        C0679mC c0679mCM2990a = new C0679mC().m2993a(EnumC0684mH.POSITION).m2994b(EnumC0684mH.POSITION).m2987a(c0881pt).m2988b(new C0881pt(5.0d, 32.0d, 5.0d, 75.0f, 135.0f)).m2983a(-10.0f).m2984b(10.0f).m2989c(10.0f).m2991d(2.0f).m2992e(1.0f).m2990a(EnumC0682mF.EASE_IN);
        for (C0868pg c0868pg : c1280xT.m7289b().m2737a(C0868pg.class).m2720d().values()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = c0868pg.m4272a();
            if (abstractC0863pbM4272a instanceof C0966rY) {
                C0966rY c0966rY = (C0966rY) abstractC0863pbM4272a;
                if (c0868pg.m4272a().m4025S().equals("dom_bastogne")) {
                    C0680mD c0680mDM3050a = C0680mD.m3030a().m3046b(true).m3048d(true).m3044a(new C0679mC().m2987a(new C0881pt(4935.7001953125d, 35.099998474121094d, 2875.89990234375d, -2.7f, 18.9f)).m2988b(new C0881pt(4930.60009765625d, 37.29999923706055d, 2876.60009765625d, -0.7f, 11.0f)).m2989c(8.0f).m2990a(EnumC0682mF.LINEAR).m2991d(3.0f).m2982a(40)).m3044a(new C0679mC().m2987a(new C0881pt(4926.2998046875d, 35.79999923706055d, 2928.800048828125d, -12.9f, 175.2f)).m2988b(new C0881pt(4924.7001953125d, 35.79999923706055d, 2928.89990234375d, -13.8f, 177.7f)).m2989c(8.0f).m2990a(EnumC0682mF.LINEAR).m2982a(30)).m3044a(new C0679mC().m2987a(new C0881pt(4826.39990234375d, 39.900001525878906d, 2888.5d, 8.2f, -58.4f)).m2988b(new C0881pt(4824.5d, 39.900001525878906d, 2893.300048828125d, 7.2f, -65.4f)).m2989c(8.0f).m2990a(EnumC0682mF.LINEAR).m2982a(30)).m3044a(new C0679mC().m2987a(new C0881pt(4920.2001953125d, 75.19999694824219d, 2823.0d, 39.8f, -26.3f)).m2988b(new C0881pt(4928.89990234375d, 75.19999694824219d, 2820.300048828125d, 38.4f, -16.6f)).m2989c(8.0f).m2992e(2.0f).m2990a(EnumC0682mF.LINEAR).m2982a(30)).m3050a();
                    C0680mD c0680mDM3050a2 = C0680mD.m3030a().m3044a(c0679mCM2990a).m3044a(new C0679mC().m2987a(new C0881pt(4919.89990234375d, 38.099998474121094d, 2885.199951171875d, 0.1f, -146.9f)).m2988b(new C0881pt(4928.7998046875d, 38.099998474121094d, 2890.5d, 0.0f, -153.3f)).m2995a("summary").m2989c(60.0f).m2991d(4.0f).m2990a(EnumC0682mF.LINEAR).m2982a(50)).m3050a();
                    c0966rY.m5325a(c0680mDM3050a);
                    c0966rY.m5326b(c0680mDM3050a2);
                }
            }
        }
        for (C1095tu c1095tu : c1280xT.m7289b().m2737a(C1095tu.class).m2720d().values()) {
            if (c1095tu.getName().equals("Zemsta")) {
                for (C1096tv c1096tv : c1095tu.f5933X.values()) {
                    c1096tv.m6107az().removeIf(abstractC0858pW -> {
                        return abstractC0858pW instanceof C0898qJ;
                    });
                    c1096tv.m6093a(new C0898qJ(16740864, new Vec3(6636.5d, 91.5d, 1244.5d)).m4799a(4.0f).m4800b(15.0f));
                    c1096tv.m6093a(new C0898qJ(16740864, new Vec3(6603.5d, 88.05d, 1251.5d)).m4799a(4.0f).m4800b(15.0f));
                }
            }
            if (c1095tu.getName().equals("Castle")) {
                for (C1096tv c1096tv2 : c1095tu.f5933X.values()) {
                    c1096tv2.m6107az().removeIf(abstractC0858pW2 -> {
                        return abstractC0858pW2 instanceof C0939qy;
                    });
                    c1096tv2.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(4135.0d, 131.0d, -1698.0d), InterfaceC1274xN.f6852vU, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6951cb, (Supplier<? extends Block>) C1295xi.f7305hW));
                }
            }
            if (c1095tu.getName().equals("Argentan")) {
                for (C1096tv c1096tv3 : c1095tu.f5933X.values()) {
                    c1096tv3.m6107az().removeIf(abstractC0858pW3 -> {
                        return abstractC0858pW3 instanceof C0939qy;
                    });
                    c1096tv3.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(5017.0d, 115.0d, -2533.0d), InterfaceC1274xN.f6852vU, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT));
                }
            }
            if (c1095tu.getName().equals("Storm")) {
                for (C1096tv c1096tv4 : c1095tu.f5933X.values()) {
                    c1096tv4.m6107az().removeIf(abstractC0858pW4 -> {
                        return abstractC0858pW4 instanceof C0939qy;
                    });
                    c1096tv4.m6107az().add(new C0939qy(100, 6.0f, new Vec3(2087.0d, 130.0d, -780.0d), InterfaceC1274xN.f6852vU, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(160.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT));
                }
            }
            if (c1095tu.getName().equals("Anzio")) {
                for (C1096tv c1096tv5 : c1095tu.f5933X.values()) {
                    c1096tv5.m6107az().removeIf(abstractC0858pW5 -> {
                        return abstractC0858pW5 instanceof C0939qy;
                    });
                    c1096tv5.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(4312.0d, 62.0d, 3204.0d), InterfaceC1274xN.f6852vU, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6953cd, (Supplier<? extends Block>) C1295xi.f7307hY));
                }
            }
            if (c1095tu.getName().equals("Brittany")) {
                for (C1096tv c1096tv6 : c1095tu.f5933X.values()) {
                    c1096tv6.m6107az().removeIf(abstractC0858pW6 -> {
                        return abstractC0858pW6 instanceof C0939qy;
                    });
                    c1096tv6.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(-107.0d, 61.0d, 659.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT));
                }
            }
            if (c1095tu.getName().equals("Donner")) {
                for (C1096tv c1096tv7 : c1095tu.f5933X.values()) {
                    c1096tv7.m6107az().removeIf(abstractC0858pW7 -> {
                        return abstractC0858pW7 instanceof C0939qy;
                    });
                    c1096tv7.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(5542.0d, 82.0d, 2643.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT));
                }
            }
            if (c1095tu.getName().equals("Dunkirk")) {
                for (C1096tv c1096tv8 : c1095tu.f5933X.values()) {
                    c1096tv8.m6107az().removeIf(abstractC0858pW8 -> {
                        return abstractC0858pW8 instanceof C0939qy;
                    });
                    c1096tv8.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(3405.0d, 69.0d, 253.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Flakturm")) {
                for (C1096tv c1096tv9 : c1095tu.f5933X.values()) {
                    c1096tv9.m6107az().removeIf(abstractC0858pW9 -> {
                        return abstractC0858pW9 instanceof C0939qy;
                    });
                    c1096tv9.m6107az().add(new C0939qy(300, 6.0f, new Vec3(4301.0d, 38.0d, 4367.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT));
                }
            }
            if (c1095tu.getName().equals("Flash")) {
                for (C1096tv c1096tv10 : c1095tu.f5933X.values()) {
                    c1096tv10.m6107az().removeIf(abstractC0858pW10 -> {
                        return abstractC0858pW10 instanceof C0939qy;
                    });
                    c1096tv10.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(4693.0d, 86.0d, -1151.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Fortress")) {
                for (C1096tv c1096tv11 : c1095tu.f5933X.values()) {
                    c1096tv11.m6107az().removeIf(abstractC0858pW11 -> {
                        return abstractC0858pW11 instanceof C0939qy;
                    });
                    c1096tv11.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(7425.0d, 136.0d, -930.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Meadows")) {
                for (C1096tv c1096tv12 : c1095tu.f5933X.values()) {
                    c1096tv12.m6107az().removeIf(abstractC0858pW12 -> {
                        return abstractC0858pW12 instanceof C0939qy;
                    });
                    c1096tv12.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(2287.0d, 71.0d, 127.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Monte")) {
                for (C1096tv c1096tv13 : c1095tu.f5933X.values()) {
                    c1096tv13.m6107az().removeIf(abstractC0858pW13 -> {
                        return abstractC0858pW13 instanceof C0939qy;
                    });
                    c1096tv13.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(2287.0d, 71.0d, 127.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Ortona")) {
                for (C1096tv c1096tv14 : c1095tu.f5933X.values()) {
                    if (c1096tv14.getName().equals("default")) {
                        c1096tv14.m6107az().removeIf(abstractC0858pW14 -> {
                            return abstractC0858pW14 instanceof C0939qy;
                        });
                        c1096tv14.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(1749.0d, 67.0d, 4758.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                    }
                }
            }
            if (c1095tu.getName().equals("Palermo")) {
                for (C1096tv c1096tv15 : c1095tu.f5933X.values()) {
                    c1096tv15.m6107az().removeIf(abstractC0858pW15 -> {
                        return abstractC0858pW15 instanceof C0939qy;
                    });
                    c1096tv15.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(8557.0d, 66.0d, 4513.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6953cd, (Supplier<? extends Block>) C1295xi.f7307hY));
                }
            }
            if (c1095tu.getName().equals("Reichstag")) {
                for (C1096tv c1096tv16 : c1095tu.f5933X.values()) {
                    c1096tv16.m6107az().removeIf(abstractC0858pW16 -> {
                        return abstractC0858pW16 instanceof C0939qy;
                    });
                    c1096tv16.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(3090.0d, 93.0d, 1295.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Salerno")) {
                for (C1096tv c1096tv17 : c1095tu.f5933X.values()) {
                    c1096tv17.m6107az().removeIf(abstractC0858pW17 -> {
                        return abstractC0858pW17 instanceof C0939qy;
                    });
                    c1096tv17.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(4901.0d, 98.0d, 3386.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                }
            }
            if (c1095tu.getName().equals("Torch")) {
                for (C1096tv c1096tv18 : c1095tu.f5933X.values()) {
                    if (c1096tv18.getName().equals("day")) {
                        c1096tv18.m6107az().removeIf(abstractC0858pW18 -> {
                            return abstractC0858pW18 instanceof C0939qy;
                        });
                        c1096tv18.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(2198.0d, 130.0d, 5672.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV));
                    }
                }
            }
            if (c1095tu.getName().equals("Vicoli")) {
                for (C1096tv c1096tv19 : c1095tu.f5933X.values()) {
                    c1096tv19.m6107az().removeIf(abstractC0858pW19 -> {
                        return abstractC0858pW19 instanceof C0939qy;
                    });
                    c1096tv19.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(7168.0d, 133.0d, -2022.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6948bY, (Supplier<? extends Block>) C1295xi.f7302hT).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6953cd, (Supplier<? extends Block>) C1295xi.f7307hY));
                }
            }
            if (c1095tu.getName().equals("Zemsta")) {
                for (C1096tv c1096tv20 : c1095tu.f5933X.values()) {
                    c1096tv20.m6107az().removeIf(abstractC0858pW20 -> {
                        return abstractC0858pW20 instanceof C0939qy;
                    });
                    c1096tv20.m6107az().add(new C0939qy(ModConnection.CONNECT_TIME_MAX_TICKS, 6.0f, new Vec3(7168.0d, 133.0d, -2022.0d), 400, 15).m5137a((Supplier<? extends SoundEvent>) C1312xz.f8050qT).m5138a(128.0d).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6950ca, (Supplier<? extends Block>) C1295xi.f7304hV).m5139a((Supplier<? extends BlockEntityType<?>>) C1293xg.f6949bZ, (Supplier<? extends Block>) C1295xi.f7303hU));
                }
            }
        }
    }
}
