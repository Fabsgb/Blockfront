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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sX.class */
public final class sX implements jU {
    private static final String cP = "europe";
    private static final String cQ = "us_airborne";
    private static final String cR = "ger_wehrmacht";

    @NotNull
    public Map<String, sY> X;

    @NotNull
    private final List<pA> bG;
    public boolean hv;

    @NotNull
    private String s;

    @NotNull
    private String bX;

    @NotNull
    private String bZ;

    @NotNull
    private C0514ta c;

    @NotNull
    private C0514ta d;

    @NotNull
    private final C0272kb k;
    private static final String cN = "Custom";
    private static final String cO = "Unknown";

    @NotNull
    public static final sX b = new sX(cN, cO).a(false);

    @NotNull
    public static final Codec<sX> ab = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("isMatchMaking", true).forGetter(sXVar -> {
            return Boolean.valueOf(sXVar.hv);
        }), Codec.unboundedMap(Codec.STRING, sY.ac).fieldOf("environments").forGetter(sXVar2 -> {
            return sXVar2.X;
        }), pB.H.listOf().optionalFieldOf("mapEffects", List.of()).forGetter((v0) -> {
            return v0.ax();
        })).apply(instance, (v0, v1, v2) -> {
            return a(v0, v1, v2);
        });
    });

    @NotNull
    private static sX a(boolean z, Map<String, sY> map, List<pA> list) {
        sX sXVar = new sX();
        sXVar.hv = z;
        sXVar.X.clear();
        sXVar.X.putAll(map);
        sXVar.bG.clear();
        sXVar.bG.addAll(list);
        sXVar.cV();
        return sXVar;
    }

    public sX() {
        this.X = new Object2ObjectOpenHashMap();
        this.bG = new ObjectArrayList();
        this.hv = true;
        this.s = cN;
        this.bX = cO;
        this.bZ = cP;
        this.c = C0514ta.a(cQ);
        this.d = C0514ta.a(cR);
        this.k = new C0272kb().a("musicSet", new C0272kb((commandContext, strArr) -> {
            String str = strArr[0];
            E(str);
            cZ();
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.musicSet.success", new Object[]{Component.literal(this.s).withStyle(C0266jw.e), Component.literal(str).withStyle(C0266jw.e)}));
        }).a(C0274kd.b(uY.b())).a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? List.of((Object[]) uY.b()) : List.of();
        })).a("teams", new C0272kb().a("set", new C0272kb((commandContext3, strArr3) -> {
            String str = strArr3[0];
            String str2 = strArr3[1];
            String str3 = strArr3[2];
            MutableComponent mutableComponentWithStyle = Component.literal(str2).withStyle(C0266jw.e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0266jw.e);
            sZ sZVarA = sZ.a(str2);
            if (sZVarA == null) {
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.nation", new Object[]{mutableComponentWithStyle}));
                return;
            }
            C0514ta c0514taA = C0514ta.a(sZVarA, str3);
            if (c0514taA == null) {
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.team", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
                return;
            }
            if (str.equalsIgnoreCase(C0529tp.da)) {
                e(c0514taA);
            } else {
                d(c0514taA);
            }
            cY();
            lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.success", new Object[]{Component.literal(str).withStyle(C0266jw.e), mutableComponentWithStyle2, mutableComponentWithStyle}));
        }).a(C0274kd.a(new String[]{"team", "nation", "skin"})).a((commandContext4, strArr4) -> {
            switch (strArr4.length) {
                case 0:
                    return List.of(C0529tp.cZ, C0529tp.da);
                case 1:
                    return sZ.av().stream().map((v0) -> {
                        return v0.ao();
                    }).toList();
                case 2:
                    return C0514ta.bR.stream().filter(c0514ta -> {
                        return c0514ta.m1156a().ao().equalsIgnoreCase(strArr4[1]);
                    }).map((v0) -> {
                        return v0.getSkin();
                    }).toList();
                default:
                    return List.of();
            }
        }))).a("author", new C0272kb((commandContext5, strArr5) -> {
            String strJoin = String.join(" ", strArr5);
            D(strJoin);
            cX();
            lW.b(((CommandSourceStack) commandContext5.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.author.success", new Object[]{Component.literal(this.s).withStyle(C0266jw.e), Component.literal(strJoin).withStyle(C0266jw.e)}));
        }).a(C0274kd.a(new String[]{"author"}))).a("environment", new C0272kb().a("edit", new C0272kb((commandContext6, strArr6) -> {
            String str = strArr6[0];
            sY sYVar = this.X.get(str);
            if (sYVar == null) {
                MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
                lW.b(((CommandSourceStack) commandContext6.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.notFound", new Object[]{Component.literal(str).withStyle(C0266jw.e), mutableComponentWithStyle}));
                return;
            }
            sYVar.a().a((CommandContext<CommandSourceStack>) commandContext6, (String[]) Arrays.copyOfRange(strArr6, 1, strArr6.length));
        }).a(C0274kd.a(new String[]{"environment"})).a((commandContext7, strArr7) -> {
            if (strArr7.length == 0) {
                return this.X.keySet();
            }
            sY sYVar = this.X.get(strArr7[0]);
            return sYVar == null ? List.of() : sYVar.a().m562a((CommandContext<CommandSourceStack>) commandContext7, (String[]) Arrays.copyOfRange(strArr7, 1, strArr7.length));
        })).a("list", new C0272kb((commandContext8, strArr8) -> {
            MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
            if (this.X.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.empty", new Object[]{mutableComponentWithStyle}));
            } else {
                lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.list", new Object[]{mutableComponentWithStyle, String.join(", ", new ObjectArrayList(this.X.values()).stream().map(sYVar -> {
                    return Component.literal(sYVar.getName()).withStyle(C0266jw.e);
                }).toList().stream().map((v0) -> {
                    return v0.getString();
                }).toList())}));
            }
        })).a("add", new C0272kb((commandContext9, strArr9) -> {
            String str = strArr9[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str).withStyle(C0266jw.e);
            if (this.X.containsKey(str)) {
                lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.X.put(str, new sY(str));
                lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.add.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).a(C0274kd.a(new String[]{"environment"}))).a("remove", new C0272kb((commandContext10, strArr10) -> {
            String str = strArr10[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str).withStyle(C0266jw.e);
            if (this.X.size() <= 1) {
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.remove.last", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else if (!this.X.containsKey(str)) {
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.not.found", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.X.remove(str);
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.remove.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).a(C0274kd.a(new String[]{"environment"})).a((commandContext11, strArr11) -> {
            return strArr11.length == 0 ? this.X.keySet() : List.of();
        })));
    }

    public sX(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju) {
        this();
    }

    public sX(@NotNull String str, @NotNull String str2) {
        this.X = new Object2ObjectOpenHashMap();
        this.bG = new ObjectArrayList();
        this.hv = true;
        this.s = cN;
        this.bX = cO;
        this.bZ = cP;
        this.c = C0514ta.a(cQ);
        this.d = C0514ta.a(cR);
        this.k = new C0272kb().a("musicSet", new C0272kb((commandContext, strArr) -> {
            String str3 = strArr[0];
            E(str3);
            cZ();
            lW.b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.musicSet.success", new Object[]{Component.literal(this.s).withStyle(C0266jw.e), Component.literal(str3).withStyle(C0266jw.e)}));
        }).a(C0274kd.b(uY.b())).a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? List.of((Object[]) uY.b()) : List.of();
        })).a("teams", new C0272kb().a("set", new C0272kb((commandContext3, strArr3) -> {
            String str3 = strArr3[0];
            String str22 = strArr3[1];
            String str32 = strArr3[2];
            MutableComponent mutableComponentWithStyle = Component.literal(str22).withStyle(C0266jw.e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str32).withStyle(C0266jw.e);
            sZ sZVarA = sZ.a(str22);
            if (sZVarA == null) {
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.nation", new Object[]{mutableComponentWithStyle}));
                return;
            }
            C0514ta c0514taA = C0514ta.a(sZVarA, str32);
            if (c0514taA == null) {
                lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.team", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
                return;
            }
            if (str3.equalsIgnoreCase(C0529tp.da)) {
                e(c0514taA);
            } else {
                d(c0514taA);
            }
            cY();
            lW.b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.success", new Object[]{Component.literal(str3).withStyle(C0266jw.e), mutableComponentWithStyle2, mutableComponentWithStyle}));
        }).a(C0274kd.a(new String[]{"team", "nation", "skin"})).a((commandContext4, strArr4) -> {
            switch (strArr4.length) {
                case 0:
                    return List.of(C0529tp.cZ, C0529tp.da);
                case 1:
                    return sZ.av().stream().map((v0) -> {
                        return v0.ao();
                    }).toList();
                case 2:
                    return C0514ta.bR.stream().filter(c0514ta -> {
                        return c0514ta.m1156a().ao().equalsIgnoreCase(strArr4[1]);
                    }).map((v0) -> {
                        return v0.getSkin();
                    }).toList();
                default:
                    return List.of();
            }
        }))).a("author", new C0272kb((commandContext5, strArr5) -> {
            String strJoin = String.join(" ", strArr5);
            D(strJoin);
            cX();
            lW.b(((CommandSourceStack) commandContext5.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.author.success", new Object[]{Component.literal(this.s).withStyle(C0266jw.e), Component.literal(strJoin).withStyle(C0266jw.e)}));
        }).a(C0274kd.a(new String[]{"author"}))).a("environment", new C0272kb().a("edit", new C0272kb((commandContext6, strArr6) -> {
            String str3 = strArr6[0];
            sY sYVar = this.X.get(str3);
            if (sYVar == null) {
                MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
                lW.b(((CommandSourceStack) commandContext6.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.notFound", new Object[]{Component.literal(str3).withStyle(C0266jw.e), mutableComponentWithStyle}));
                return;
            }
            sYVar.a().a((CommandContext<CommandSourceStack>) commandContext6, (String[]) Arrays.copyOfRange(strArr6, 1, strArr6.length));
        }).a(C0274kd.a(new String[]{"environment"})).a((commandContext7, strArr7) -> {
            if (strArr7.length == 0) {
                return this.X.keySet();
            }
            sY sYVar = this.X.get(strArr7[0]);
            return sYVar == null ? List.of() : sYVar.a().m562a((CommandContext<CommandSourceStack>) commandContext7, (String[]) Arrays.copyOfRange(strArr7, 1, strArr7.length));
        })).a("list", new C0272kb((commandContext8, strArr8) -> {
            MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
            if (this.X.isEmpty()) {
                lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.empty", new Object[]{mutableComponentWithStyle}));
            } else {
                lW.b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.list", new Object[]{mutableComponentWithStyle, String.join(", ", new ObjectArrayList(this.X.values()).stream().map(sYVar -> {
                    return Component.literal(sYVar.getName()).withStyle(C0266jw.e);
                }).toList().stream().map((v0) -> {
                    return v0.getString();
                }).toList())}));
            }
        })).a("add", new C0272kb((commandContext9, strArr9) -> {
            String str3 = strArr9[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0266jw.e);
            if (this.X.containsKey(str3)) {
                lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.X.put(str3, new sY(str3));
                lW.b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.add.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).a(C0274kd.a(new String[]{"environment"}))).a("remove", new C0272kb((commandContext10, strArr10) -> {
            String str3 = strArr10[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.s).withStyle(C0266jw.e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0266jw.e);
            if (this.X.size() <= 1) {
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.remove.last", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else if (!this.X.containsKey(str3)) {
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.not.found", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.X.remove(str3);
                lW.b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.remove.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).a(C0274kd.a(new String[]{"environment"})).a((commandContext11, strArr11) -> {
            return strArr11.length == 0 ? this.X.keySet() : List.of();
        })));
        C(str);
        cW();
        D(str2);
        cX();
        this.X.put("default", new sY("default"));
    }

    public void a(@NotNull jO jOVar) {
        Iterator<sY> it = this.X.values().iterator();
        while (it.hasNext()) {
            it.next().b(jOVar);
        }
    }

    public void cV() {
        this.s = cN;
        this.bX = cO;
        this.bZ = cP;
        this.c = C0514ta.a(cQ);
        this.d = C0514ta.a(cR);
        Iterator<pA> it = this.bG.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    private void cW() {
        this.bG.removeIf(pAVar -> {
            return pAVar instanceof C0437qe;
        });
        this.bG.add(new C0437qe(this.s));
    }

    private void cX() {
        this.bG.removeIf(pAVar -> {
            return pAVar instanceof pZ;
        });
        this.bG.add(new pZ(this.bX));
    }

    private void cY() {
        this.bG.removeIf(pAVar -> {
            return pAVar instanceof C0458qz;
        });
        this.bG.add(new C0458qz(this.c, this.d));
    }

    private void cZ() {
        this.bG.removeIf(pAVar -> {
            return pAVar instanceof C0439qg;
        });
        this.bG.add(new C0439qg(this.bZ));
    }

    @NotNull
    public List<pA> ax() {
        return this.bG;
    }

    public void C(@NotNull String str) {
        this.s = str;
    }

    public void D(@NotNull String str) {
        this.bX = str;
    }

    public void d(@NotNull C0514ta c0514ta) {
        this.c = c0514ta;
    }

    public void e(@NotNull C0514ta c0514ta) {
        this.d = c0514ta;
    }

    public void E(@NotNull String str) {
        this.bZ = str;
    }

    @NotNull
    public C0514ta e() {
        return this.c;
    }

    @NotNull
    public C0514ta f() {
        return this.d;
    }

    @NotNull
    public sX a(boolean z) {
        this.hv = z;
        return this;
    }

    @NotNull
    public String getName() {
        return this.s;
    }

    @NotNull
    public String an() {
        return this.bX;
    }

    @Override // com.boehmod.blockfront.jU
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0272kb mo565a() {
        return this.k;
    }

    @Override // com.boehmod.blockfront.jU
    public void c(@NotNull CommandSource commandSource) {
    }

    @Override // com.boehmod.blockfront.jU
    public void bp() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof sX) {
            return ((sX) obj).s.equals(this.s);
        }
        return false;
    }

    @NotNull
    public Map<String, sY> o() {
        return this.X;
    }

    @Nullable
    public uX a() {
        return uY.ar.get(this.bZ);
    }

    public void k(@NotNull ByteBuf byteBuf) {
        int size = this.bG.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            pB.d.encode(byteBuf, this.bG.get(i));
        }
    }

    public void l(@NotNull ByteBuf byteBuf) {
        this.bG.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.bG.add((pA) pB.d.decode(byteBuf));
        }
        cV();
    }

    public void cA() {
        Iterator<sY> it = this.X.values().iterator();
        while (it.hasNext()) {
            it.next().cA();
        }
    }
}
