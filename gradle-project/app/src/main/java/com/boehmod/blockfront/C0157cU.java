package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.regex.Pattern;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cU.class */
public class C0157cU extends AbstractC0223dX {

    /* JADX INFO: renamed from: fL */
    private static final int f1261fL = 10;

    /* JADX INFO: renamed from: fM */
    private static final int f1262fM = 2;

    /* JADX INFO: renamed from: fN */
    private static final int f1263fN = 8;

    /* JADX INFO: renamed from: fO */
    private static final int f1264fO = 16;

    /* JADX INFO: renamed from: fP */
    private static final int f1265fP = 4;

    /* JADX INFO: renamed from: fQ */
    private static final int f1266fQ = 16;

    /* JADX INFO: renamed from: fR */
    private static final int f1267fR = 36;

    /* JADX INFO: renamed from: fS */
    private static final int f1268fS = 4;

    /* JADX INFO: renamed from: fT */
    private static final int f1269fT = 1090519039;

    /* JADX INFO: renamed from: fU */
    private static final int f1270fU = -5592406;

    /* JADX INFO: renamed from: fV */
    private static final int f1271fV = -1;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AbstractC0858pW f1280c;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AbstractC0858pW f1281d;

    /* JADX INFO: renamed from: U */
    @NotNull
    private final String f1282U;

    /* JADX INFO: renamed from: t */
    @NotNull
    private List<AbstractC0927qm<?>> f1283t;

    /* JADX INFO: renamed from: u */
    @NotNull
    private final List<AbstractC0927qm<?>> f1284u;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final Vec3 f1285l;

    /* JADX INFO: renamed from: b */
    private final byte[] f1286b;

    /* JADX INFO: renamed from: bh */
    private boolean f1287bh;

    /* JADX INFO: renamed from: fI */
    private int f1288fI;

    /* JADX INFO: renamed from: bi */
    private boolean f1289bi;

    /* JADX INFO: renamed from: fJ */
    private int f1290fJ;

    /* JADX INFO: renamed from: fK */
    private int f1291fK;

    /* JADX INFO: renamed from: da */
    private static final Component f1259da = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: db */
    private static final Component f1260db = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: dc */
    private static final Component f1272dc = Component.translatable("bf.menu.label.none");

    /* JADX INFO: renamed from: dd */
    private static final Component f1273dd = Component.translatable("bf.menu.picker.sound");

    /* JADX INFO: renamed from: de */
    private static final Component f1274de = Component.translatable("bf.menu.boolean.on").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: df */
    private static final Component f1275df = Component.translatable("bf.menu.boolean.off").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: dg */
    private static final Component f1276dg = Component.translatable("bf.menu.label.template.override");

    /* JADX INFO: renamed from: dh */
    private static final Component f1277dh = Component.translatable("bf.menu.label.template.reference");

    /* JADX INFO: renamed from: c */
    private static final Pattern f1278c = Pattern.compile("^-?[0-9]*\\.?[0-9]*$");

    /* JADX INFO: renamed from: d */
    private static final Pattern f1279d = Pattern.compile("^-?[0-9]*$");

    /* JADX INFO: renamed from: com.boehmod.blockfront.cU$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cU$a.class */
    @FunctionalInterface
    private interface a {
        void accept(float f);
    }

    public C0157cU(@Nullable Screen screen, @NotNull AbstractC0858pW abstractC0858pW, @NotNull AbstractC0858pW abstractC0858pW2, @NotNull String str) {
        super(screen, Component.translatable("bf.menu.title.edit.template.reference", new Object[]{str}));
        this.f1287bh = false;
        this.f1288fI = 0;
        this.f1289bi = false;
        this.f1280c = abstractC0858pW;
        this.f1281d = abstractC0858pW2;
        this.f1282U = str;
        this.f1283t = abstractC0858pW.mo3946J();
        this.f1284u = abstractC0858pW2.mo3946J();
        this.f1285l = abstractC0858pW.f4593c;
        this.f1286b = m943a(abstractC0858pW);
        m972a();
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m943a(@NotNull AbstractC0858pW abstractC0858pW) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        C0859pX.f4606d.encode(byteBufBuffer, abstractC0858pW);
        byte[] bArr = new byte[byteBufBuffer.readableBytes()];
        byteBufBuffer.readBytes(bArr);
        return bArr;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        this.f1283t = this.f1280c.mo3946J();
        this.f1288fI = Mth.clamp(this.f1288fI, 0, m982H());
        clearWidgets();
        super.init();
        int i = (this.width / 2) - 95;
        int iM978E = m978E();
        int iM981G = iM978E + m981G();
        int iM5077bC = iM978E - this.f1288fI;
        for (AbstractC0927qm<?> abstractC0927qm : this.f1283t) {
            int iM5077bC2 = iM5077bC + abstractC0927qm.m5077bC();
            if (iM5077bC2 > iM978E && iM5077bC2 <= iM981G) {
                m944a(abstractC0927qm, i, iM5077bC);
            }
            iM5077bC += abstractC0927qm.m5077bC() + 8;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m944a(@NotNull AbstractC0927qm<?> abstractC0927qm, int i, int i2) {
        Objects.requireNonNull(abstractC0927qm);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0935qu.class, C0934qt.class, C0924qj.class, C0925qk.class, C0930qp.class, C0929qo.class, C0933qs.class, C0926ql.class, C0928qn.class, C0931qq.class, C0932qr.class, C0923qi.class).dynamicInvoker().invoke(abstractC0927qm, 0) /* invoke-custom */) {
            case 0:
                m945a((C0935qu) abstractC0927qm, i, i2);
                break;
            case 1:
                m946a((C0934qt) abstractC0927qm, i, i2);
                break;
            case 2:
                m947a((C0924qj) abstractC0927qm, i, i2);
                break;
            case 3:
                m948a((C0925qk) abstractC0927qm, i, i2);
                break;
            case 4:
                m949a((C0930qp) abstractC0927qm, i, i2);
                break;
            case 5:
                m950a((C0929qo) abstractC0927qm, i, i2);
                break;
            case 6:
                m951a((C0933qs) abstractC0927qm, i, i2);
                break;
            case C0994s.f5462C /* 7 */:
                m952a((C0926ql) abstractC0927qm, i, i2);
                break;
            case 8:
                m954a((C0928qn) abstractC0927qm, i, i2);
                break;
            case 9:
                m957a((C0931qq) abstractC0927qm, i, i2);
                break;
            case 10:
                m961a((C0932qr) abstractC0927qm, i, i2);
                break;
            case 11:
                m960a((C0923qi) abstractC0927qm, i, i2);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m945a(@NotNull C0935qu c0935qu, int i, int i2) {
        int iM979c = m979c(i2);
        Vec3 vec3 = (Vec3) c0935qu.f5124d.get();
        addRenderableWidget(m966a(i, iM979c, 60, vec3.x, d -> {
            Vec3 vec4 = (Vec3) c0935qu.f5124d.get();
            c0935qu.f5125d.accept((T) new Vec3(d, vec4.y, vec4.z));
        }));
        addRenderableWidget(m966a(i + 60 + 4, iM979c, 60, vec3.y, d2 -> {
            Vec3 vec4 = (Vec3) c0935qu.f5124d.get();
            c0935qu.f5125d.accept((T) new Vec3(vec4.x, d2, vec4.z));
        }));
        addRenderableWidget(m966a(i + 128, iM979c, 60, vec3.z, d3 -> {
            Vec3 vec4 = (Vec3) c0935qu.f5124d.get();
            c0935qu.f5125d.accept((T) new Vec3(vec4.x, vec4.y, d3));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m946a(@NotNull C0934qt c0934qt, int i, int i2) {
        int iM979c = m979c(i2);
        Vec2 vec2 = (Vec2) c0934qt.f5124d.get();
        addRenderableWidget(m966a(i, iM979c, 93, vec2.x, d -> {
            c0934qt.f5125d.accept((T) new Vec2((float) d, ((Vec2) c0934qt.f5124d.get()).y));
        }));
        addRenderableWidget(m966a(i + 93 + 4, iM979c, 93, vec2.y, d2 -> {
            c0934qt.f5125d.accept((T) new Vec2(((Vec2) c0934qt.f5124d.get()).x, (float) d2));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m947a(@NotNull C0924qj c0924qj, int i, int i2) {
        int iM979c = m979c(i2);
        BlockPos blockPos = (BlockPos) c0924qj.f5124d.get();
        addRenderableWidget(m967a(i, iM979c, 60, blockPos.getX(), Integer.MIN_VALUE, Integer.MAX_VALUE, i3 -> {
            BlockPos blockPos2 = (BlockPos) c0924qj.f5124d.get();
            c0924qj.f5125d.accept((T) new BlockPos(i3, blockPos2.getY(), blockPos2.getZ()));
        }));
        addRenderableWidget(m967a(i + 60 + 4, iM979c, 60, blockPos.getY(), Integer.MIN_VALUE, Integer.MAX_VALUE, i4 -> {
            BlockPos blockPos2 = (BlockPos) c0924qj.f5124d.get();
            c0924qj.f5125d.accept((T) new BlockPos(blockPos2.getX(), i4, blockPos2.getZ()));
        }));
        addRenderableWidget(m967a(i + 128, iM979c, 60, blockPos.getZ(), Integer.MIN_VALUE, Integer.MAX_VALUE, i5 -> {
            BlockPos blockPos2 = (BlockPos) c0924qj.f5124d.get();
            c0924qj.f5125d.accept((T) new BlockPos(blockPos2.getX(), blockPos2.getY(), i5));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m948a(@NotNull C0925qk c0925qk, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m979c(i2), AbstractC0223dX.f1766ij, 16, m965a(((Boolean) c0925qk.f5124d.get()).booleanValue()), button -> {
            boolean z = !((Boolean) c0925qk.f5124d.get()).booleanValue();
            c0925qk.f5125d.accept((T) Boolean.valueOf(z));
            button.setMessage(m965a(z));
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m949a(@NotNull C0930qp c0930qp, int i, int i2) {
        int iM979c = m979c(i2);
        int iIntValue = ((Integer) c0930qp.f5124d.get()).intValue();
        int i3 = c0930qp.f5131pV;
        int i4 = c0930qp.f5132pW;
        Consumer<T> consumer = c0930qp.f5125d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m967a(i, iM979c, AbstractC0223dX.f1766ij, iIntValue, i3, i4, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m950a(@NotNull C0929qo c0929qo, int i, int i2) {
        int iM979c = m979c(i2);
        float fFloatValue = ((Float) c0929qo.f5124d.get()).floatValue();
        float f = c0929qo.f5129lB;
        float f2 = c0929qo.f5130lC;
        Consumer<T> consumer = c0929qo.f5125d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m968a(i, iM979c, AbstractC0223dX.f1766ij, fFloatValue, f, f2, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m951a(@NotNull C0933qs c0933qs, int i, int i2) {
        EditBox editBox = new EditBox(this.font, i, m979c(i2), AbstractC0223dX.f1766ij, 16, Component.empty());
        editBox.setMaxLength(c0933qs.f5138pY);
        editBox.setValue((String) c0933qs.f5124d.get());
        Consumer<T> consumer = c0933qs.f5125d;
        Objects.requireNonNull(consumer);
        editBox.setResponder((v1) -> {
            r1.accept(v1);
        });
        addRenderableWidget(editBox);
    }

    /* JADX INFO: renamed from: a */
    private void m952a(@NotNull C0926ql c0926ql, int i, int i2) {
        int iM979c = m979c(i2);
        int iIntValue = ((Integer) c0926ql.f5124d.get()).intValue();
        addRenderableWidget(m967a(i, iM979c, 39, (iIntValue >> 16) & 255, 0, 255, i3 -> {
            m953b(c0926ql, 16, i3);
        }));
        addRenderableWidget(m967a(i + 43, iM979c, 39, (iIntValue >> 8) & 255, 0, 255, i4 -> {
            m953b(c0926ql, 8, i4);
        }));
        addRenderableWidget(m967a(i + 86, iM979c, 39, iIntValue & 255, 0, 255, i5 -> {
            m953b(c0926ql, 0, i5);
        }));
        addRenderableWidget(m967a(i + 129, iM979c, 39, (iIntValue >> 24) & 255, 0, 255, i6 -> {
            m953b(c0926ql, 24, i6);
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: b */
    public static void m953b(@NotNull C0926ql c0926ql, int i, int i2) {
        c0926ql.f5125d.accept((T) Integer.valueOf((((Integer) c0926ql.f5124d.get()).intValue() & ((255 << i) ^ (-1))) | ((i2 & 255) << i)));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m954a(@NotNull C0928qn<E> c0928qn, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m979c(i2), AbstractC0223dX.f1766ij, 16, m956a((C0928qn) c0928qn), button -> {
            m955a(c0928qn);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m955a(@NotNull C0928qn<E> c0928qn) {
        List listOf = List.of((Object[]) c0928qn.f5127b.getEnumConstants());
        Minecraft minecraft = this.f1058a;
        MutableComponent mutableComponentLiteral = Component.literal("Select " + c0928qn.f5127b.getSimpleName());
        Function function = (v0) -> {
            return v0.name();
        };
        Function<E, Component> function2 = c0928qn.f5128g;
        Enum r8 = (Enum) c0928qn.f5124d.get();
        Consumer<T> consumer = c0928qn.f5125d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new C0159cW(this, mutableComponentLiteral, listOf, function, function2, r8, (v1) -> {
            r9.accept(v1);
        }));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static <E extends Enum<E>> Component m956a(@NotNull C0928qn<E> c0928qn) {
        Enum r0 = (Enum) c0928qn.f5124d.get();
        return r0 == null ? f1272dc : c0928qn.f5128g.apply((E) r0);
    }

    /* JADX INFO: renamed from: a */
    private <T> void m957a(@NotNull C0931qq<T> c0931qq, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m979c(i2), AbstractC0223dX.f1766ij, 16, m959a((C0931qq) c0931qq), button -> {
            m958a(c0931qq);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <T> void m958a(@NotNull C0931qq<T> c0931qq) {
        Minecraft minecraft = this.f1058a;
        Component component = c0931qq.f5133ji;
        List<T> list = c0931qq.f5134e.get();
        Function<T, String> function = c0931qq.f5135h;
        Function<T, Component> function2 = c0931qq.f5136i;
        T t = c0931qq.f5124d.get();
        Consumer<T> consumer = c0931qq.f5125d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new C0159cW(this, component, list, function, function2, t, consumer::accept));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T> Component m959a(@NotNull C0931qq<T> c0931qq) {
        T t = c0931qq.f5124d.get();
        return t == null ? f1272dc : c0931qq.f5136i.apply(t);
    }

    /* JADX INFO: renamed from: a */
    private void m960a(@NotNull C0923qi c0923qi, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m979c(i2), AbstractC0223dX.f1766ij, 16, c0923qi.f5119jg, button -> {
            c0923qi.f5120a.run();
            init();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m961a(@NotNull C0932qr c0932qr, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m979c(i2), AbstractC0223dX.f1766ij, 16, m964a((SoundEvent) c0932qr.f5124d.get()), button -> {
            m962a(c0932qr);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m962a(@NotNull C0932qr c0932qr) {
        List list = BuiltInRegistries.SOUND_EVENT.stream().toList();
        Minecraft minecraft = this.f1058a;
        Component component = f1273dd;
        Function function = C0157cU::m963c;
        Function function2 = soundEvent -> {
            return C0156cT.m896a(m963c(soundEvent));
        };
        SoundEvent soundEvent2 = (SoundEvent) c0932qr.f5124d.get();
        Consumer<T> consumer = c0932qr.f5125d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new C0159cW(this, component, list, function, function2, soundEvent2, (v1) -> {
            r9.accept(v1);
        }));
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m963c(@Nullable SoundEvent soundEvent) {
        ResourceLocation key;
        return (soundEvent == null || (key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent)) == null) ? "" : key.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m964a(@Nullable SoundEvent soundEvent) {
        String strM963c = m963c(soundEvent);
        return strM963c.isEmpty() ? f1272dc : C0156cT.m896a(strM963c);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m965a(boolean z) {
        return z ? f1274de : f1275df;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m966a(int i, int i2, int i3, double d, @NotNull DoubleConsumer doubleConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m969a(d));
        editBox.setFilter(str -> {
            return f1278c.matcher(str).matches();
        });
        editBox.setResponder(str2 -> {
            if (str2.isEmpty() || str2.equals("-") || str2.equals(".") || str2.equals("-.")) {
                return;
            }
            try {
                doubleConsumer.accept(Double.parseDouble(str2));
            } catch (NumberFormatException e) {
            }
        });
        return editBox;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m967a(int i, int i2, int i3, int i4, int i5, int i6, @NotNull IntConsumer intConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(Integer.toString(i4));
        editBox.setFilter(str -> {
            return f1279d.matcher(str).matches();
        });
        editBox.setResponder(str2 -> {
            if (str2.isEmpty() || str2.equals("-")) {
                return;
            }
            try {
                intConsumer.accept(Mth.clamp(Integer.parseInt(str2), i5, i6));
            } catch (NumberFormatException e) {
            }
        });
        return editBox;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m968a(int i, int i2, int i3, float f, float f2, float f3, @NotNull a aVar) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m970c(f));
        editBox.setFilter(str -> {
            return f1278c.matcher(str).matches();
        });
        editBox.setResponder(str2 -> {
            if (str2.isEmpty() || str2.equals("-") || str2.equals(".") || str2.equals("-.")) {
                return;
            }
            try {
                aVar.accept(Mth.clamp(Float.parseFloat(str2), f2, f3));
            } catch (NumberFormatException e) {
            }
        });
        return editBox;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m969a(double d) {
        return (d != ((double) ((long) d)) || Double.isInfinite(d)) ? Double.toString(d) : Long.toString((long) d);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m970c(float f) {
        return (f != ((float) ((long) f)) || Float.isInfinite(f)) ? Float.toString(f) : Long.toString((long) f);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i = (this.width / 2) - 95;
        int iM978E = m978E() + m981G() + 6;
        addRenderableWidget(new C0085bB(i + 2, iM978E, 80, 20, f1260db, button -> {
            m1327N();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        addRenderableWidget(new C0085bB(((i + AbstractC0223dX.f1766ij) - 80) - 2, iM978E, 80, 20, f1259da, button2 -> {
            m971R();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: R */
    private void m971R() {
        UUID uuid = this.f1280c.f4592y;
        if (!Objects.equals(this.f1280c.f4593c, this.f1285l)) {
            C1169vO.m6648c(new C1236wc(uuid, this.f1280c.f4593c));
        }
        C1169vO.m6648c(C1173vS.m6669a(uuid, m972a()));
        this.f1287bh = true;
        m1327N();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private JsonObject m972a() {
        DataResult dataResultEncodeStart = C0859pX.f4605H.encodeStart(JsonOps.INSTANCE, this.f1280c);
        DataResult dataResultEncodeStart2 = C0859pX.f4605H.encodeStart(JsonOps.INSTANCE, this.f1281d);
        if (dataResultEncodeStart.isError() || dataResultEncodeStart2.isError()) {
            return null;
        }
        JsonObject asJsonObject = ((JsonElement) dataResultEncodeStart.getOrThrow()).getAsJsonObject();
        JsonObject asJsonObject2 = ((JsonElement) dataResultEncodeStart2.getOrThrow()).getAsJsonObject();
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : asJsonObject.entrySet()) {
            String str = (String) entry.getKey();
            if (!"position".equals(str) && !"type".equals(str)) {
                if (!Objects.equals(entry.getValue(), asJsonObject2.get(str))) {
                    jsonObject.add(str, (JsonElement) entry.getValue());
                }
            }
        }
        if (jsonObject.entrySet().isEmpty()) {
            return null;
        }
        return jsonObject;
    }

    /* JADX INFO: renamed from: a */
    private boolean m973a(int i) {
        return i < this.f1283t.size() && i < this.f1284u.size() && !Objects.equals(this.f1283t.get(i).f5124d.get(), this.f1284u.get(i).f5124d.get());
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        int iM974a;
        if (i == 1 && (iM974a = m974a(d2)) >= 0) {
            m975h(iM974a);
            return true;
        }
        if (i == 0 && m983x()) {
            int i2 = ((this.width / 2) - 95) + AbstractC0223dX.f1766ij + 2;
            int iM978E = m978E();
            int iM981G = m981G();
            if (d >= i2 && d < i2 + 4 && d2 >= iM978E && d2 < iM978E + iM981G) {
                int iMax = Math.max(10, (iM981G * iM981G) / m980F());
                int i3 = iM981G - iMax;
                int iClamp = i3 > 0 ? Mth.clamp((((((int) d2) - iM978E) - (iMax / 2)) * m982H()) / i3, 0, m982H()) : 0;
                this.f1289bi = true;
                this.f1290fJ = (int) d2;
                this.f1291fK = iClamp;
                if (iClamp != this.f1288fI) {
                    this.f1288fI = iClamp;
                    init();
                    return true;
                }
                return true;
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    /* JADX INFO: renamed from: a */
    private int m974a(double d) {
        int iM978E = m978E();
        int iM981G = iM978E + m981G();
        if (d < iM978E || d >= iM981G) {
            return -1;
        }
        int iM5077bC = iM978E - this.f1288fI;
        for (int i = 0; i < this.f1283t.size(); i++) {
            AbstractC0927qm<?> abstractC0927qm = this.f1283t.get(i);
            int iM5077bC2 = iM5077bC + abstractC0927qm.m5077bC();
            if (d >= iM5077bC && d < iM5077bC2) {
                return i;
            }
            iM5077bC += abstractC0927qm.m5077bC() + 8;
        }
        return -1;
    }

    /* JADX INFO: renamed from: h */
    private <T> void m975h(int i) {
        if (i >= this.f1283t.size() || i >= this.f1284u.size()) {
            return;
        }
        this.f1283t.get(i).f5125d.accept(this.f1284u.get(i).f5124d.get());
        init();
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        if (i == 0 && this.f1289bi) {
            int iM981G = m981G();
            int iMax = iM981G - Math.max(10, (iM981G * iM981G) / m980F());
            if (iMax > 0) {
                int iClamp = Mth.clamp(this.f1291fK + (((((int) d2) - this.f1290fJ) * m982H()) / iMax), 0, m982H());
                if (iClamp != this.f1288fI) {
                    this.f1288fI = iClamp;
                    init();
                    return true;
                }
                return true;
            }
            return true;
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean mouseReleased(double d, double d2, int i) {
        if (i == 0 && this.f1289bi) {
            this.f1289bi = false;
            return true;
        }
        return super.mouseReleased(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (!m983x()) {
            return super.mouseScrolled(d, d2, d3, d4);
        }
        int iClamp = Mth.clamp(this.f1288fI - ((int) (d4 * 36.0d)), 0, m982H());
        if (iClamp != this.f1288fI) {
            this.f1288fI = iClamp;
            init();
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    public void onClose() {
        if (!this.f1287bh) {
            AbstractC0858pW abstractC0858pW = (AbstractC0858pW) C0859pX.f4606d.decode(Unpooled.wrappedBuffer(this.f1286b));
            C0623l c0623lM2852b = C0623l.m2852b();
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b != null ? c0623lM2852b.m2874a() : null;
            if (abstractC0863pbM2874a != null) {
                abstractC0863pbM2874a.m4089a().m6098c(abstractC0858pW);
            }
        }
        super.onClose();
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        int i3 = (this.width / 2) - 95;
        int iM978E = m978E();
        int iM981G = iM978E + m981G();
        int iM5077bC = iM978E - this.f1288fI;
        if (m983x()) {
            C0129bt.m618a(guiGraphics, i3, iM978E, AbstractC0223dX.f1766ij, m981G());
        }
        for (int i4 = 0; i4 < this.f1283t.size(); i4++) {
            AbstractC0927qm<?> abstractC0927qm = this.f1283t.get(i4);
            C0129bt.m471a(this.font, guiGraphics, abstractC0927qm.f5123jh, i3, iM5077bC, abstractC0927qm.f5126pU);
            int iWidth = this.font.width(abstractC0927qm.f5123jh);
            if (m973a(i4)) {
                C0129bt.m471a(this.font, guiGraphics, f1276dg, i3 + iWidth, iM5077bC, ColorReferences.COLOR_MAP_EFFECT_REFERENCE_OVERRIDE);
            } else {
                C0129bt.m471a(this.font, guiGraphics, f1277dh, i3 + iWidth, iM5077bC, ColorReferences.COLOR_MAP_EFFECT_REFERENCE);
            }
            if (abstractC0927qm instanceof C0926ql) {
                m977a(guiGraphics, (C0926ql) abstractC0927qm, i3, iM5077bC);
            }
            iM5077bC += abstractC0927qm.m5077bC() + 8;
        }
        if (m983x()) {
            guiGraphics.disableScissor();
            m976a(guiGraphics, i3, iM978E, m981G());
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m976a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3) {
        int iM980F = m980F();
        if (iM980F <= 0 || i3 <= 0) {
            return;
        }
        int i4 = i + AbstractC0223dX.f1766ij + 2;
        C0129bt.m515a(guiGraphics, i4, i2, 4, i3, f1269fT);
        int iMax = Math.max(10, (i3 * i3) / iM980F);
        int i5 = i3 - iMax;
        int iM982H = m982H();
        C0129bt.m515a(guiGraphics, i4, i2 + (iM982H > 0 ? (i5 * this.f1288fI) / iM982H : 0), 4, iMax, f1270fU);
    }

    /* JADX INFO: renamed from: a */
    private void m977a(@NotNull GuiGraphics guiGraphics, @NotNull C0926ql c0926ql, int i, int i2) {
        int i3 = (i + AbstractC0223dX.f1766ij) - 16;
        int iM979c = m979c(i2);
        C0129bt.m515a(guiGraphics, i3 - 1, iM979c - 1, 18, 18, -1);
        C0129bt.m515a(guiGraphics, i3, iM979c, 16, 16, ((Integer) c0926ql.f5124d.get()).intValue());
    }

    /* JADX INFO: renamed from: E */
    private int m978E() {
        return 85 + (11 * this.f1773D.size());
    }

    /* JADX INFO: renamed from: c */
    private static int m979c(int i) {
        return i + 10 + 2;
    }

    /* JADX INFO: renamed from: F */
    private int m980F() {
        int iM5077bC = 0;
        Iterator<AbstractC0927qm<?>> it = this.f1283t.iterator();
        while (it.hasNext()) {
            iM5077bC += it.next().m5077bC() + 8;
        }
        if (iM5077bC > 0) {
            return iM5077bC - 8;
        }
        return 0;
    }

    /* JADX INFO: renamed from: G */
    private int m981G() {
        return Mth.clamp(m980F(), 0, Math.max(80, ((this.height - m978E()) - 20) - 18));
    }

    /* JADX INFO: renamed from: H */
    private int m982H() {
        return Math.max(0, m980F() - m981G());
    }

    /* JADX INFO: renamed from: x */
    private boolean m983x() {
        return m982H() > 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: I */
    protected int mo913I() {
        return m981G();
    }
}
