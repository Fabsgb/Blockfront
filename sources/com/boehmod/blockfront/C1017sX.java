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

/* JADX INFO: renamed from: com.boehmod.blockfront.sX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sX.class */
public final class C1017sX implements InterfaceC0537jU {

    /* JADX INFO: renamed from: cP */
    private static final String f5364cP = "europe";

    /* JADX INFO: renamed from: cQ */
    private static final String f5365cQ = "us_airborne";

    /* JADX INFO: renamed from: cR */
    private static final String f5366cR = "ger_wehrmacht";

    /* JADX INFO: renamed from: X */
    @NotNull
    public Map<String, C1018sY> f5369X;

    /* JADX INFO: renamed from: bG */
    @NotNull
    private final List<AbstractC0835pA> f5370bG;

    /* JADX INFO: renamed from: hv */
    public boolean f5371hv;

    /* JADX INFO: renamed from: s */
    @NotNull
    private String f5372s;

    /* JADX INFO: renamed from: bX */
    @NotNull
    private String f5373bX;

    /* JADX INFO: renamed from: bZ */
    @NotNull
    private String f5374bZ;

    /* JADX INFO: renamed from: c */
    @NotNull
    private C1074ta f5375c;

    /* JADX INFO: renamed from: d */
    @NotNull
    private C1074ta f5376d;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final C0597kb f5377k;

    /* JADX INFO: renamed from: cN */
    private static final String f5362cN = "Custom";

    /* JADX INFO: renamed from: cO */
    private static final String f5363cO = "Unknown";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C1017sX f5367b = new C1017sX(f5362cN, f5363cO).m5561a(false);

    /* JADX INFO: renamed from: ab */
    @NotNull
    public static final Codec<C1017sX> f5368ab = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("isMatchMaking", true).forGetter(c1017sX -> {
            return Boolean.valueOf(c1017sX.f5371hv);
        }), Codec.unboundedMap(Codec.STRING, C1018sY.f5379ac).fieldOf("environments").forGetter(c1017sX2 -> {
            return c1017sX2.f5369X;
        }), C0836pB.f4476H.listOf().optionalFieldOf("mapEffects", List.of()).forGetter((v0) -> {
            return v0.m5553ax();
        })).apply(instance, (v0, v1, v2) -> {
            return m5546a(v0, v1, v2);
        });
    });

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1017sX m5546a(boolean z, Map<String, C1018sY> map, List<AbstractC0835pA> list) {
        C1017sX c1017sX = new C1017sX();
        c1017sX.f5371hv = z;
        c1017sX.f5369X.clear();
        c1017sX.f5369X.putAll(map);
        c1017sX.f5370bG.clear();
        c1017sX.f5370bG.addAll(list);
        c1017sX.m5548cV();
        return c1017sX;
    }

    public C1017sX() {
        this.f5369X = new Object2ObjectOpenHashMap();
        this.f5370bG = new ObjectArrayList();
        this.f5371hv = true;
        this.f5372s = f5362cN;
        this.f5373bX = f5363cO;
        this.f5374bZ = f5364cP;
        this.f5375c = C1074ta.m5969a(f5365cQ);
        this.f5376d = C1074ta.m5969a(f5366cR);
        this.f5377k = new C0597kb().m2628a("musicSet", new C0597kb((commandContext, strArr) -> {
            String str = strArr[0];
            m5558E(str);
            m5552cZ();
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.musicSet.success", new Object[]{Component.literal(this.f5372s).withStyle(C0565jw.f3204e), Component.literal(str).withStyle(C0565jw.f3204e)}));
        }).m2624a(C0599kd.m2636b(C1125uY.m6242b())).m2630a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? List.of((Object[]) C1125uY.m6242b()) : List.of();
        })).m2628a("teams", new C0597kb().m2628a("set", new C0597kb((commandContext3, strArr3) -> {
            String str = strArr3[0];
            String str2 = strArr3[1];
            String str3 = strArr3[2];
            MutableComponent mutableComponentWithStyle = Component.literal(str2).withStyle(C0565jw.f3204e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0565jw.f3204e);
            C1019sZ c1019sZM5665a = C1019sZ.m5665a(str2);
            if (c1019sZM5665a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.nation", new Object[]{mutableComponentWithStyle}));
                return;
            }
            C1074ta c1074taM5971a = C1074ta.m5971a(c1019sZM5665a, str3);
            if (c1074taM5971a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.team", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
                return;
            }
            if (str.equalsIgnoreCase(C1089tp.f5730da)) {
                m5557e(c1074taM5971a);
            } else {
                m5556d(c1074taM5971a);
            }
            m5551cY();
            C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.success", new Object[]{Component.literal(str).withStyle(C0565jw.f3204e), mutableComponentWithStyle2, mutableComponentWithStyle}));
        }).m2624a(C0599kd.m2635a(new String[]{"team", "nation", "skin"})).m2630a((commandContext4, strArr4) -> {
            switch (strArr4.length) {
                case 0:
                    return List.of(C1089tp.f5729cZ, C1089tp.f5730da);
                case 1:
                    return C1019sZ.m5666av().stream().map((v0) -> {
                        return v0.m5669ao();
                    }).toList();
                case 2:
                    return C1074ta.f5641bR.stream().filter(c1074ta -> {
                        return c1074ta.m5976a().m5669ao().equalsIgnoreCase(strArr4[1]);
                    }).map((v0) -> {
                        return v0.getSkin();
                    }).toList();
                default:
                    return List.of();
            }
        }))).m2628a("author", new C0597kb((commandContext5, strArr5) -> {
            String strJoin = String.join(" ", strArr5);
            m5555D(strJoin);
            m5550cX();
            C0645lW.m2898b(((CommandSourceStack) commandContext5.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.author.success", new Object[]{Component.literal(this.f5372s).withStyle(C0565jw.f3204e), Component.literal(strJoin).withStyle(C0565jw.f3204e)}));
        }).m2624a(C0599kd.m2635a(new String[]{"author"}))).m2628a("environment", new C0597kb().m2628a("edit", new C0597kb((commandContext6, strArr6) -> {
            String str = strArr6[0];
            C1018sY c1018sY = this.f5369X.get(str);
            if (c1018sY == null) {
                MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
                C0645lW.m2898b(((CommandSourceStack) commandContext6.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.notFound", new Object[]{Component.literal(str).withStyle(C0565jw.f3204e), mutableComponentWithStyle}));
                return;
            }
            c1018sY.m5590a().m2625a((CommandContext<CommandSourceStack>) commandContext6, (String[]) Arrays.copyOfRange(strArr6, 1, strArr6.length));
        }).m2624a(C0599kd.m2635a(new String[]{"environment"})).m2630a((commandContext7, strArr7) -> {
            if (strArr7.length == 0) {
                return this.f5369X.keySet();
            }
            C1018sY c1018sY = this.f5369X.get(strArr7[0]);
            return c1018sY == null ? List.of() : c1018sY.m5590a().m2631a((CommandContext<CommandSourceStack>) commandContext7, (String[]) Arrays.copyOfRange(strArr7, 1, strArr7.length));
        })).m2628a("list", new C0597kb((commandContext8, strArr8) -> {
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
            if (this.f5369X.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.empty", new Object[]{mutableComponentWithStyle}));
            } else {
                C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.list", new Object[]{mutableComponentWithStyle, String.join(", ", new ObjectArrayList(this.f5369X.values()).stream().map(c1018sY -> {
                    return Component.literal(c1018sY.getName()).withStyle(C0565jw.f3204e);
                }).toList().stream().map((v0) -> {
                    return v0.getString();
                }).toList())}));
            }
        })).m2628a("add", new C0597kb((commandContext9, strArr9) -> {
            String str = strArr9[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str).withStyle(C0565jw.f3204e);
            if (this.f5369X.containsKey(str)) {
                C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5369X.put(str, new C1018sY(str));
                C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.add.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"environment"}))).m2628a("remove", new C0597kb((commandContext10, strArr10) -> {
            String str = strArr10[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str).withStyle(C0565jw.f3204e);
            if (this.f5369X.size() <= 1) {
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.remove.last", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else if (!this.f5369X.containsKey(str)) {
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.not.found", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5369X.remove(str);
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.remove.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"environment"})).m2630a((commandContext11, strArr11) -> {
            return strArr11.length == 0 ? this.f5369X.keySet() : List.of();
        })));
    }

    public C1017sX(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju) {
        this();
    }

    public C1017sX(@NotNull String str, @NotNull String str2) {
        this.f5369X = new Object2ObjectOpenHashMap();
        this.f5370bG = new ObjectArrayList();
        this.f5371hv = true;
        this.f5372s = f5362cN;
        this.f5373bX = f5363cO;
        this.f5374bZ = f5364cP;
        this.f5375c = C1074ta.m5969a(f5365cQ);
        this.f5376d = C1074ta.m5969a(f5366cR);
        this.f5377k = new C0597kb().m2628a("musicSet", new C0597kb((commandContext, strArr) -> {
            String str3 = strArr[0];
            m5558E(str3);
            m5552cZ();
            C0645lW.m2898b(((CommandSourceStack) commandContext.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.musicSet.success", new Object[]{Component.literal(this.f5372s).withStyle(C0565jw.f3204e), Component.literal(str3).withStyle(C0565jw.f3204e)}));
        }).m2624a(C0599kd.m2636b(C1125uY.m6242b())).m2630a((commandContext2, strArr2) -> {
            return strArr2.length == 0 ? List.of((Object[]) C1125uY.m6242b()) : List.of();
        })).m2628a("teams", new C0597kb().m2628a("set", new C0597kb((commandContext3, strArr3) -> {
            String str3 = strArr3[0];
            String str22 = strArr3[1];
            String str32 = strArr3[2];
            MutableComponent mutableComponentWithStyle = Component.literal(str22).withStyle(C0565jw.f3204e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str32).withStyle(C0565jw.f3204e);
            C1019sZ c1019sZM5665a = C1019sZ.m5665a(str22);
            if (c1019sZM5665a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.nation", new Object[]{mutableComponentWithStyle}));
                return;
            }
            C1074ta c1074taM5971a = C1074ta.m5971a(c1019sZM5665a, str32);
            if (c1074taM5971a == null) {
                C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.error.team", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
                return;
            }
            if (str3.equalsIgnoreCase(C1089tp.f5730da)) {
                m5557e(c1074taM5971a);
            } else {
                m5556d(c1074taM5971a);
            }
            m5551cY();
            C0645lW.m2898b(((CommandSourceStack) commandContext3.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.team.set.success", new Object[]{Component.literal(str3).withStyle(C0565jw.f3204e), mutableComponentWithStyle2, mutableComponentWithStyle}));
        }).m2624a(C0599kd.m2635a(new String[]{"team", "nation", "skin"})).m2630a((commandContext4, strArr4) -> {
            switch (strArr4.length) {
                case 0:
                    return List.of(C1089tp.f5729cZ, C1089tp.f5730da);
                case 1:
                    return C1019sZ.m5666av().stream().map((v0) -> {
                        return v0.m5669ao();
                    }).toList();
                case 2:
                    return C1074ta.f5641bR.stream().filter(c1074ta -> {
                        return c1074ta.m5976a().m5669ao().equalsIgnoreCase(strArr4[1]);
                    }).map((v0) -> {
                        return v0.getSkin();
                    }).toList();
                default:
                    return List.of();
            }
        }))).m2628a("author", new C0597kb((commandContext5, strArr5) -> {
            String strJoin = String.join(" ", strArr5);
            m5555D(strJoin);
            m5550cX();
            C0645lW.m2898b(((CommandSourceStack) commandContext5.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.author.success", new Object[]{Component.literal(this.f5372s).withStyle(C0565jw.f3204e), Component.literal(strJoin).withStyle(C0565jw.f3204e)}));
        }).m2624a(C0599kd.m2635a(new String[]{"author"}))).m2628a("environment", new C0597kb().m2628a("edit", new C0597kb((commandContext6, strArr6) -> {
            String str3 = strArr6[0];
            C1018sY c1018sY = this.f5369X.get(str3);
            if (c1018sY == null) {
                MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
                C0645lW.m2898b(((CommandSourceStack) commandContext6.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.notFound", new Object[]{Component.literal(str3).withStyle(C0565jw.f3204e), mutableComponentWithStyle}));
                return;
            }
            c1018sY.m5590a().m2625a((CommandContext<CommandSourceStack>) commandContext6, (String[]) Arrays.copyOfRange(strArr6, 1, strArr6.length));
        }).m2624a(C0599kd.m2635a(new String[]{"environment"})).m2630a((commandContext7, strArr7) -> {
            if (strArr7.length == 0) {
                return this.f5369X.keySet();
            }
            C1018sY c1018sY = this.f5369X.get(strArr7[0]);
            return c1018sY == null ? List.of() : c1018sY.m5590a().m2631a((CommandContext<CommandSourceStack>) commandContext7, (String[]) Arrays.copyOfRange(strArr7, 1, strArr7.length));
        })).m2628a("list", new C0597kb((commandContext8, strArr8) -> {
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
            if (this.f5369X.isEmpty()) {
                C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.empty", new Object[]{mutableComponentWithStyle}));
            } else {
                C0645lW.m2898b(((CommandSourceStack) commandContext8.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.list", new Object[]{mutableComponentWithStyle, String.join(", ", new ObjectArrayList(this.f5369X.values()).stream().map(c1018sY -> {
                    return Component.literal(c1018sY.getName()).withStyle(C0565jw.f3204e);
                }).toList().stream().map((v0) -> {
                    return v0.getString();
                }).toList())}));
            }
        })).m2628a("add", new C0597kb((commandContext9, strArr9) -> {
            String str3 = strArr9[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0565jw.f3204e);
            if (this.f5369X.containsKey(str3)) {
                C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.exists", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5369X.put(str3, new C1018sY(str3));
                C0645lW.m2898b(((CommandSourceStack) commandContext9.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.add.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"environment"}))).m2628a("remove", new C0597kb((commandContext10, strArr10) -> {
            String str3 = strArr10[0];
            MutableComponent mutableComponentWithStyle = Component.literal(this.f5372s).withStyle(C0565jw.f3204e);
            MutableComponent mutableComponentWithStyle2 = Component.literal(str3).withStyle(C0565jw.f3204e);
            if (this.f5369X.size() <= 1) {
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.remove.last", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else if (!this.f5369X.containsKey(str3)) {
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.error.not.found", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            } else {
                this.f5369X.remove(str3);
                C0645lW.m2898b(((CommandSourceStack) commandContext10.getSource()).source, Component.translatable("bf.message.command.assets.edit.maps.environment.remove.success", new Object[]{mutableComponentWithStyle2, mutableComponentWithStyle}));
            }
        }).m2624a(C0599kd.m2635a(new String[]{"environment"})).m2630a((commandContext11, strArr11) -> {
            return strArr11.length == 0 ? this.f5369X.keySet() : List.of();
        })));
        m5554C(str);
        m5549cW();
        m5555D(str2);
        m5550cX();
        this.f5369X.put("default", new C1018sY("default"));
    }

    /* JADX INFO: renamed from: a */
    public void m5547a(@NotNull C0531jO c0531jO) {
        Iterator<C1018sY> it = this.f5369X.values().iterator();
        while (it.hasNext()) {
            it.next().m5611b(c0531jO);
        }
    }

    /* JADX INFO: renamed from: cV */
    public void m5548cV() {
        this.f5372s = f5362cN;
        this.f5373bX = f5363cO;
        this.f5374bZ = f5364cP;
        this.f5375c = C1074ta.m5969a(f5365cQ);
        this.f5376d = C1074ta.m5969a(f5366cR);
        Iterator<AbstractC0835pA> it = this.f5370bG.iterator();
        while (it.hasNext()) {
            it.next().mo4219b(this);
        }
    }

    /* JADX INFO: renamed from: cW */
    private void m5549cW() {
        this.f5370bG.removeIf(abstractC0835pA -> {
            return abstractC0835pA instanceof C0918qe;
        });
        this.f5370bG.add(new C0918qe(this.f5372s));
    }

    /* JADX INFO: renamed from: cX */
    private void m5550cX() {
        this.f5370bG.removeIf(abstractC0835pA -> {
            return abstractC0835pA instanceof C0860pZ;
        });
        this.f5370bG.add(new C0860pZ(this.f5373bX));
    }

    /* JADX INFO: renamed from: cY */
    private void m5551cY() {
        this.f5370bG.removeIf(abstractC0835pA -> {
            return abstractC0835pA instanceof C0939qz;
        });
        this.f5370bG.add(new C0939qz(this.f5375c, this.f5376d));
    }

    /* JADX INFO: renamed from: cZ */
    private void m5552cZ() {
        this.f5370bG.removeIf(abstractC0835pA -> {
            return abstractC0835pA instanceof C0920qg;
        });
        this.f5370bG.add(new C0920qg(this.f5374bZ));
    }

    @NotNull
    /* JADX INFO: renamed from: ax */
    public List<AbstractC0835pA> m5553ax() {
        return this.f5370bG;
    }

    /* JADX INFO: renamed from: C */
    public void m5554C(@NotNull String str) {
        this.f5372s = str;
    }

    /* JADX INFO: renamed from: D */
    public void m5555D(@NotNull String str) {
        this.f5373bX = str;
    }

    /* JADX INFO: renamed from: d */
    public void m5556d(@NotNull C1074ta c1074ta) {
        this.f5375c = c1074ta;
    }

    /* JADX INFO: renamed from: e */
    public void m5557e(@NotNull C1074ta c1074ta) {
        this.f5376d = c1074ta;
    }

    /* JADX INFO: renamed from: E */
    public void m5558E(@NotNull String str) {
        this.f5374bZ = str;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1074ta m5559e() {
        return this.f5375c;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1074ta m5560f() {
        return this.f5376d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1017sX m5561a(boolean z) {
        this.f5371hv = z;
        return this;
    }

    @NotNull
    public String getName() {
        return this.f5372s;
    }

    @NotNull
    /* JADX INFO: renamed from: an */
    public String m5562an() {
        return this.f5373bX;
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo2429a() {
        return this.f5377k;
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    /* JADX INFO: renamed from: c */
    public void mo2430c(@NotNull CommandSource commandSource) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    /* JADX INFO: renamed from: bp */
    public void mo2431bp() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1017sX) {
            return ((C1017sX) obj).f5372s.equals(this.f5372s);
        }
        return false;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public Map<String, C1018sY> m5563o() {
        return this.f5369X;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1124uX m5564a() {
        return C1125uY.f5926ar.get(this.f5374bZ);
    }

    /* JADX INFO: renamed from: k */
    public void m5565k(@NotNull ByteBuf byteBuf) {
        int size = this.f5370bG.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            C0836pB.f4477d.encode(byteBuf, this.f5370bG.get(i));
        }
    }

    /* JADX INFO: renamed from: l */
    public void m5566l(@NotNull ByteBuf byteBuf) {
        this.f5370bG.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f5370bG.add((AbstractC0835pA) C0836pB.f4477d.decode(byteBuf));
        }
        m5548cV();
    }

    /* JADX INFO: renamed from: cA */
    public void m5567cA() {
        Iterator<C1018sY> it = this.f5369X.values().iterator();
        while (it.hasNext()) {
            it.next().m5657cA();
        }
    }
}
