package com.boehmod.blockfront;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tu.class */
public final class C1095tu implements InterfaceC0613kq {

    /* JADX INFO: renamed from: cZ */
    private static final String f5928cZ = "europe";

    /* JADX INFO: renamed from: da */
    private static final String f5929da = "us_airborne";

    /* JADX INFO: renamed from: db */
    private static final String f5930db = "ger_wehrmacht";

    /* JADX INFO: renamed from: X */
    @NotNull
    public Map<String, C1096tv> f5933X;

    /* JADX INFO: renamed from: bN */
    @NotNull
    private final List<AbstractC0858pW> f5934bN;

    /* JADX INFO: renamed from: hP */
    public boolean f5935hP;

    /* JADX INFO: renamed from: x */
    @NotNull
    private String f5936x;

    /* JADX INFO: renamed from: ch */
    @NotNull
    private String f5937ch;

    /* JADX INFO: renamed from: cj */
    @NotNull
    private String f5938cj;

    /* JADX INFO: renamed from: c */
    @NotNull
    private C1098tx f5939c;

    /* JADX INFO: renamed from: d */
    @NotNull
    private C1098tx f5940d;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final C0620kx f5941k;

    /* JADX INFO: renamed from: cX */
    private static final String f5926cX = "Custom";

    /* JADX INFO: renamed from: cY */
    private static final String f5927cY = "Unknown";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C1095tu f5931b = new C1095tu(f5926cX, f5927cY).m6049a(false);

    /* JADX INFO: renamed from: ab */
    @NotNull
    public static final Codec<C1095tu> f5932ab = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("isMatchMaking", true).forGetter(c1095tu -> {
            return Boolean.valueOf(c1095tu.f5935hP);
        }), Codec.unboundedMap(Codec.STRING, C1096tv.f5943ac).fieldOf("environments").forGetter(c1095tu2 -> {
            return c1095tu2.f5933X;
        }), C0859pX.f4605H.listOf().optionalFieldOf("mapEffects", List.of()).forGetter((v0) -> {
            return v0.m6041az();
        })).apply(instance, (v0, v1, v2) -> {
            return m6034a(v0, v1, v2);
        });
    });

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1095tu m6034a(boolean z, Map<String, C1096tv> map, List<AbstractC0858pW> list) {
        C1095tu c1095tu = new C1095tu();
        c1095tu.f5935hP = z;
        c1095tu.f5933X.clear();
        c1095tu.f5933X.putAll(map);
        c1095tu.f5934bN.clear();
        c1095tu.f5934bN.addAll(list);
        c1095tu.m6036dh();
        return c1095tu;
    }

    public C1095tu() {
        this.f5933X = new Object2ObjectOpenHashMap();
        this.f5934bN = new ObjectArrayList();
        this.f5935hP = true;
        this.f5936x = f5926cX;
        this.f5937ch = f5927cY;
        this.f5938cj = f5928cZ;
        this.f5939c = C1098tx.m6172a(f5929da);
        this.f5940d = C1098tx.m6172a(f5930db);
        this.f5941k = new C0620kx().m2840a("musicSet", new C0620kx((commandContext, strArr) -> {
            String str = strArr[0];
            m6046E(str);
            m6040dl();
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.musicSet.success", new Object[]{Component.literal(this.f5936x).withStyle(C0533jP.f3188e), Component.literal(str).withStyle(C0533jP.f3188e)}));
        }).m2836a(C0622kz.m2848b(C1205vy.m6895b())).m2842a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? List.of((Object[]) C1205vy.m6895b()) : List.of();
        })).m2840a("teams", new C0620kx().m2840a("set", new C0620kx((commandContext3, strArr3) -> {
            String str = strArr3[0];
            String str2 = strArr3[1];
            String str3 = strArr3[2];
            MutableComponent mutableComponentWithStyle = Component.literal(str2).withStyle(C0533jP.f3188e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0533jP.f3188e);
            C1097tw c1097twM6153a = C1097tw.m6153a(str2);
            if (c1097twM6153a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.nation", new Object[]{mutableComponentWithStyle}));
                return;
            }
            C1098tx c1098txM6174a = C1098tx.m6174a(c1097twM6153a, str3);
            if (c1098txM6174a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.team", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
                return;
            }
            if (str.equalsIgnoreCase(C1062tN.f5783dl)) {
                m6045e(c1098txM6174a);
            } else {
                m6044d(c1098txM6174a);
            }
            m6039dk();
            C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.success", new Object[]{Component.literal(str).withStyle(C0533jP.f3188e), mutableComponentWithStyle2, mutableComponentWithStyle}));
        }).m2836a(C0622kz.m2847a(new String[]{"team", "nation", "skin"})).m2842a((commandContext4, strArr4) -> {
            switch (strArr4.length) {
                case 0:
                    return List.of(C1062tN.f5782dk, C1062tN.f5783dl);
                case 1:
                    return C1097tw.m6154ax().stream().map((v0) -> {
                        return v0.m6157av();
                    }).toList();
                case 2:
                    return C1098tx.f5986bY.stream().filter(c1098tx -> {
                        return c1098tx.m6179a().m6157av().equalsIgnoreCase(strArr4[1]);
                    }).map((v0) -> {
                        return v0.getSkin();
                    }).toList();
                default:
                    return List.of();
            }
        }))).m2840a("author", new C0620kx((commandContext5, strArr5) -> {
            String strJoin = String.join(" ", strArr5);
            m6043D(strJoin);
            m6038dj();
            C0721ms.m3329b(((CommandSourceStack) commandContext5.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.author.success", new Object[]{Component.literal(this.f5936x).withStyle(C0533jP.f3188e), Component.literal(strJoin).withStyle(C0533jP.f3188e)}));
        }).m2836a(C0622kz.m2847a(new String[]{"author"}))).m2840a("environment", new C0620kx().m2840a("edit", new C0620kx((commandContext6, strArr6) -> {
            String str = strArr6[0];
            C1096tv c1096tv = this.f5933X.get(str);
            if (c1096tv == null) {
                MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
                C0721ms.m3329b(((CommandSourceStack) commandContext6.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.notFound", new Object[]{Component.literal(str).withStyle(C0533jP.f3188e), mutableComponentWithStyle}));
                return;
            }
            c1096tv.m6078a().m2837a((CommandContext<CommandSourceStack>) commandContext6, (String[]) Arrays.copyOfRange(strArr6, 1, strArr6.length));
        }).m2836a(C0622kz.m2847a(new String[]{"environment"})).m2842a((commandContext7, strArr7) -> {
            if (strArr7.length == 0) {
                return this.f5933X.keySet();
            }
            C1096tv c1096tv = this.f5933X.get(strArr7[0]);
            return c1096tv == null ? List.of() : c1096tv.m6078a().m2843a((CommandContext<CommandSourceStack>) commandContext7, (String[]) Arrays.copyOfRange(strArr7, 1, strArr7.length));
        })).m2840a("list", new C0620kx((commandContext8, strArr8) -> {
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
            if (this.f5933X.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.empty", new Object[]{mutableComponentWithStyle}));
            } else {
                C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.list", new Object[]{mutableComponentWithStyle, String.join(", ", new ObjectArrayList(this.f5933X.values()).stream().map(c1096tv -> {
                    return Component.literal(c1096tv.getName()).withStyle(C0533jP.f3188e);
                }).toList().stream().map((v0) -> {
                    return v0.getString();
                }).toList())}));
            }
        })).m2840a("add", new C0620kx((commandContext9, strArr9) -> {
            String str = strArr9[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str).withStyle(C0533jP.f3188e);
            if (this.f5933X.containsKey(str)) {
                C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5933X.put(str, new C1096tv(str));
                C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.add.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"environment"}))).m2840a("remove", new C0620kx((commandContext10, strArr10) -> {
            String str = strArr10[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str).withStyle(C0533jP.f3188e);
            if (this.f5933X.size() <= 1) {
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.remove.last", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else if (!this.f5933X.containsKey(str)) {
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.not.found", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5933X.remove(str);
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.remove.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"environment"})).m2842a((commandContext11, strArr11) -> {
            return strArr11.length == 0 ? this.f5933X.keySet() : List.of();
        })));
    }

    public C1095tu(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN) {
        this();
    }

    public C1095tu(@NotNull String str, @NotNull String str2) {
        this.f5933X = new Object2ObjectOpenHashMap();
        this.f5934bN = new ObjectArrayList();
        this.f5935hP = true;
        this.f5936x = f5926cX;
        this.f5937ch = f5927cY;
        this.f5938cj = f5928cZ;
        this.f5939c = C1098tx.m6172a(f5929da);
        this.f5940d = C1098tx.m6172a(f5930db);
        this.f5941k = new C0620kx().m2840a("musicSet", new C0620kx((commandContext, strArr) -> {
            String str3 = strArr[0];
            m6046E(str3);
            m6040dl();
            C0721ms.m3329b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.musicSet.success", new Object[]{Component.literal(this.f5936x).withStyle(C0533jP.f3188e), Component.literal(str3).withStyle(C0533jP.f3188e)}));
        }).m2836a(C0622kz.m2848b(C1205vy.m6895b())).m2842a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? List.of((Object[]) C1205vy.m6895b()) : List.of();
        })).m2840a("teams", new C0620kx().m2840a("set", new C0620kx((commandContext3, strArr3) -> {
            String str3 = strArr3[0];
            String str4 = strArr3[1];
            String str5 = strArr3[2];
            MutableComponent mutableComponentWithStyle = Component.literal(str4).withStyle(C0533jP.f3188e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str5).withStyle(C0533jP.f3188e);
            C1097tw c1097twM6153a = C1097tw.m6153a(str4);
            if (c1097twM6153a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.nation", new Object[]{mutableComponentWithStyle}));
                return;
            }
            C1098tx c1098txM6174a = C1098tx.m6174a(c1097twM6153a, str5);
            if (c1098txM6174a == null) {
                C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.team", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
                return;
            }
            if (str3.equalsIgnoreCase(C1062tN.f5783dl)) {
                m6045e(c1098txM6174a);
            } else {
                m6044d(c1098txM6174a);
            }
            m6039dk();
            C0721ms.m3329b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.success", new Object[]{Component.literal(str3).withStyle(C0533jP.f3188e), mutableComponentWithStyle2, mutableComponentWithStyle}));
        }).m2836a(C0622kz.m2847a(new String[]{"team", "nation", "skin"})).m2842a((commandContext4, strArr4) -> {
            switch (strArr4.length) {
                case 0:
                    return List.of(C1062tN.f5782dk, C1062tN.f5783dl);
                case 1:
                    return C1097tw.m6154ax().stream().map((v0) -> {
                        return v0.m6157av();
                    }).toList();
                case 2:
                    return C1098tx.f5986bY.stream().filter(c1098tx -> {
                        return c1098tx.m6179a().m6157av().equalsIgnoreCase(strArr4[1]);
                    }).map((v0) -> {
                        return v0.getSkin();
                    }).toList();
                default:
                    return List.of();
            }
        }))).m2840a("author", new C0620kx((commandContext5, strArr5) -> {
            String strJoin = String.join(" ", strArr5);
            m6043D(strJoin);
            m6038dj();
            C0721ms.m3329b(((CommandSourceStack) commandContext5.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.author.success", new Object[]{Component.literal(this.f5936x).withStyle(C0533jP.f3188e), Component.literal(strJoin).withStyle(C0533jP.f3188e)}));
        }).m2836a(C0622kz.m2847a(new String[]{"author"}))).m2840a("environment", new C0620kx().m2840a("edit", new C0620kx((commandContext6, strArr6) -> {
            String str3 = strArr6[0];
            C1096tv c1096tv = this.f5933X.get(str3);
            if (c1096tv == null) {
                MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
                C0721ms.m3329b(((CommandSourceStack) commandContext6.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.notFound", new Object[]{Component.literal(str3).withStyle(C0533jP.f3188e), mutableComponentWithStyle}));
                return;
            }
            c1096tv.m6078a().m2837a((CommandContext<CommandSourceStack>) commandContext6, (String[]) Arrays.copyOfRange(strArr6, 1, strArr6.length));
        }).m2836a(C0622kz.m2847a(new String[]{"environment"})).m2842a((commandContext7, strArr7) -> {
            if (strArr7.length == 0) {
                return this.f5933X.keySet();
            }
            C1096tv c1096tv = this.f5933X.get(strArr7[0]);
            return c1096tv == null ? List.of() : c1096tv.m6078a().m2843a((CommandContext<CommandSourceStack>) commandContext7, (String[]) Arrays.copyOfRange(strArr7, 1, strArr7.length));
        })).m2840a("list", new C0620kx((commandContext8, strArr8) -> {
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
            if (this.f5933X.isEmpty()) {
                C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.empty", new Object[]{mutableComponentWithStyle}));
            } else {
                C0721ms.m3329b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.list", new Object[]{mutableComponentWithStyle, String.join(", ", new ObjectArrayList(this.f5933X.values()).stream().map(c1096tv -> {
                    return Component.literal(c1096tv.getName()).withStyle(C0533jP.f3188e);
                }).toList().stream().map((v0) -> {
                    return v0.getString();
                }).toList())}));
            }
        })).m2840a("add", new C0620kx((commandContext9, strArr9) -> {
            String str3 = strArr9[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0533jP.f3188e);
            if (this.f5933X.containsKey(str3)) {
                C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5933X.put(str3, new C1096tv(str3));
                C0721ms.m3329b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.add.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"environment"}))).m2840a("remove", new C0620kx((commandContext10, strArr10) -> {
            String str3 = strArr10[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5936x).withStyle(C0533jP.f3188e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0533jP.f3188e);
            if (this.f5933X.size() <= 1) {
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.remove.last", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else if (!this.f5933X.containsKey(str3)) {
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.not.found", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5933X.remove(str3);
                C0721ms.m3329b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.remove.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2836a(C0622kz.m2847a(new String[]{"environment"})).m2842a((commandContext11, strArr11) -> {
            return strArr11.length == 0 ? this.f5933X.keySet() : List.of();
        })));
        m6042C(str);
        m6037di();
        m6043D(str2);
        m6038dj();
        this.f5933X.put("default", new C1096tv("default"));
    }

    /* JADX INFO: renamed from: a */
    public void m6035a(@NotNull C0607kk c0607kk) {
        Iterator<C1096tv> it = this.f5933X.values().iterator();
        while (it.hasNext()) {
            it.next().m6099b(c0607kk);
        }
    }

    /* JADX INFO: renamed from: dh */
    public void m6036dh() {
        this.f5936x = f5926cX;
        this.f5937ch = f5927cY;
        this.f5938cj = f5928cZ;
        this.f5939c = C1098tx.m6172a(f5929da);
        this.f5940d = C1098tx.m6172a(f5930db);
        Iterator<AbstractC0858pW> it = this.f5934bN.iterator();
        while (it.hasNext()) {
            it.next().mo3954b(this);
        }
    }

    /* JADX INFO: renamed from: di */
    private void m6037di() {
        this.f5934bN.removeIf(abstractC0858pW -> {
            return abstractC0858pW instanceof C0889qA;
        });
        this.f5934bN.add(new C0889qA(this.f5936x));
    }

    /* JADX INFO: renamed from: dj */
    private void m6038dj() {
        this.f5934bN.removeIf(abstractC0858pW -> {
            return abstractC0858pW instanceof C0936qv;
        });
        this.f5934bN.add(new C0936qv(this.f5937ch));
    }

    /* JADX INFO: renamed from: dk */
    private void m6039dk() {
        this.f5934bN.removeIf(abstractC0858pW -> {
            return abstractC0858pW instanceof C0911qW;
        });
        this.f5934bN.add(new C0911qW(this.f5939c, this.f5940d));
    }

    /* JADX INFO: renamed from: dl */
    private void m6040dl() {
        this.f5934bN.removeIf(abstractC0858pW -> {
            return abstractC0858pW instanceof C0891qC;
        });
        this.f5934bN.add(new C0891qC(this.f5938cj));
    }

    @NotNull
    /* JADX INFO: renamed from: az */
    public List<AbstractC0858pW> m6041az() {
        return this.f5934bN;
    }

    /* JADX INFO: renamed from: C */
    public void m6042C(@NotNull String str) {
        this.f5936x = str;
    }

    /* JADX INFO: renamed from: D */
    public void m6043D(@NotNull String str) {
        this.f5937ch = str;
    }

    /* JADX INFO: renamed from: d */
    public void m6044d(@NotNull C1098tx c1098tx) {
        this.f5939c = c1098tx;
    }

    /* JADX INFO: renamed from: e */
    public void m6045e(@NotNull C1098tx c1098tx) {
        this.f5940d = c1098tx;
    }

    /* JADX INFO: renamed from: E */
    public void m6046E(@NotNull String str) {
        this.f5938cj = str;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1098tx m6047e() {
        return this.f5939c;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1098tx m6048f() {
        return this.f5940d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1095tu m6049a(boolean z) {
        this.f5935hP = z;
        return this;
    }

    @NotNull
    public String getName() {
        return this.f5936x;
    }

    @NotNull
    /* JADX INFO: renamed from: au */
    public String m6050au() {
        return this.f5937ch;
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo2596a() {
        return this.f5941k;
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    /* JADX INFO: renamed from: c */
    public void mo2597c(@NotNull CommandSource commandSource) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    /* JADX INFO: renamed from: bA */
    public void mo2598bA() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1095tu) {
            return ((C1095tu) obj).f5936x.equals(this.f5936x);
        }
        return false;
    }

    public int hashCode() {
        return this.f5936x.hashCode();
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public Map<String, C1096tv> m6051o() {
        return this.f5933X;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1204vx m6052a() {
        return C1205vy.f6565ar.get(this.f5938cj);
    }

    /* JADX INFO: renamed from: k */
    public void m6053k(@NotNull ByteBuf byteBuf) {
        int size = this.f5934bN.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            C0859pX.f4606d.encode(byteBuf, this.f5934bN.get(i));
        }
    }

    /* JADX INFO: renamed from: l */
    public void m6054l(@NotNull ByteBuf byteBuf) {
        this.f5934bN.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f5934bN.add((AbstractC0858pW) C0859pX.f4606d.decode(byteBuf));
        }
        m6036dh();
    }

    /* JADX INFO: renamed from: cM */
    public void m6055cM() {
        Iterator<C1096tv> it = this.f5933X.values().iterator();
        while (it.hasNext()) {
            it.next().m6145cM();
        }
    }
}
