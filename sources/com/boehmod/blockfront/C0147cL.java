package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cL.class */
public class C0147cL extends AbstractC0211dM {

    /* JADX INFO: renamed from: eL */
    private static final int f1171eL = 10;

    /* JADX INFO: renamed from: eM */
    private static final int f1172eM = 2;

    /* JADX INFO: renamed from: eN */
    private static final int f1173eN = 8;

    /* JADX INFO: renamed from: eO */
    private static final int f1174eO = 16;

    /* JADX INFO: renamed from: eP */
    private static final int f1175eP = 4;

    /* JADX INFO: renamed from: eQ */
    private static final int f1176eQ = 16;

    /* JADX INFO: renamed from: eR */
    private static final int f1177eR = 36;

    /* JADX INFO: renamed from: eS */
    private static final int f1178eS = 4;

    /* JADX INFO: renamed from: eT */
    private static final int f1179eT = 1090519039;

    /* JADX INFO: renamed from: eU */
    private static final int f1180eU = -5592406;

    /* JADX INFO: renamed from: eV */
    private static final int f1181eV = -1;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final AbstractC0835pA f1190c;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AbstractC0835pA f1191d;

    /* JADX INFO: renamed from: O */
    @NotNull
    private final String f1192O;

    /* JADX INFO: renamed from: r */
    @NotNull
    private List<AbstractC0851pQ<?>> f1193r;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final List<AbstractC0851pQ<?>> f1194s;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final Vec3 f1195l;

    /* JADX INFO: renamed from: b */
    private final byte[] f1196b;

    /* JADX INFO: renamed from: bd */
    private boolean f1197bd;

    /* JADX INFO: renamed from: eI */
    private int f1198eI;

    /* JADX INFO: renamed from: be */
    private boolean f1199be;

    /* JADX INFO: renamed from: eJ */
    private int f1200eJ;

    /* JADX INFO: renamed from: eK */
    private int f1201eK;

    /* JADX INFO: renamed from: cY */
    private static final Component f1169cY = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: cZ */
    private static final Component f1170cZ = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: da */
    private static final Component f1182da = Component.translatable("bf.menu.label.none");

    /* JADX INFO: renamed from: db */
    private static final Component f1183db = Component.translatable("bf.menu.picker.sound");

    /* JADX INFO: renamed from: dc */
    private static final Component f1184dc = Component.translatable("bf.menu.boolean.on").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: dd */
    private static final Component f1185dd = Component.translatable("bf.menu.boolean.off").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: de */
    private static final Component f1186de = Component.translatable("bf.menu.label.template.override");

    /* JADX INFO: renamed from: df */
    private static final Component f1187df = Component.translatable("bf.menu.label.template.reference");

    /* JADX INFO: renamed from: c */
    private static final Pattern f1188c = Pattern.compile("^-?[0-9]*\\.?[0-9]*$");

    /* JADX INFO: renamed from: d */
    private static final Pattern f1189d = Pattern.compile("^-?[0-9]*$");

    /* JADX INFO: renamed from: com.boehmod.blockfront.cL$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cL$a.class */
    @FunctionalInterface
    private interface a {
        void accept(float f);
    }

    public C0147cL(@Nullable Screen screen, @NotNull AbstractC0835pA abstractC0835pA, @NotNull AbstractC0835pA abstractC0835pA2, @NotNull String str) {
        super(screen, Component.translatable("bf.menu.title.edit.template.reference", new Object[]{str}));
        this.f1197bd = false;
        this.f1198eI = 0;
        this.f1199be = false;
        this.f1190c = abstractC0835pA;
        this.f1191d = abstractC0835pA2;
        this.f1192O = str;
        this.f1193r = abstractC0835pA.mo4227H();
        this.f1194s = abstractC0835pA2.mo4227H();
        this.f1195l = abstractC0835pA.f4464c;
        this.f1196b = m889a(abstractC0835pA);
        m918a();
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m889a(@NotNull AbstractC0835pA abstractC0835pA) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        C0836pB.f4477d.encode(byteBufBuffer, abstractC0835pA);
        byte[] bArr = new byte[byteBufBuffer.readableBytes()];
        byteBufBuffer.readBytes(bArr);
        return bArr;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        this.f1193r = this.f1190c.mo4227H();
        this.f1198eI = Mth.clamp(this.f1198eI, 0, m928D());
        clearWidgets();
        super.init();
        int i = (this.width / 2) - 95;
        int iM924A = m924A();
        int iM927C = iM924A + m927C();
        int iM4283bn = iM924A - this.f1198eI;
        for (AbstractC0851pQ<?> abstractC0851pQ : this.f1193r) {
            int iM4283bn2 = iM4283bn + abstractC0851pQ.m4283bn();
            if (iM4283bn2 > iM924A && iM4283bn2 <= iM927C) {
                m890a(abstractC0851pQ, i, iM4283bn);
            }
            iM4283bn += abstractC0851pQ.m4283bn() + 8;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m890a(@NotNull AbstractC0851pQ<?> abstractC0851pQ, int i, int i2) {
        Objects.requireNonNull(abstractC0851pQ);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0859pY.class, C0858pX.class, C0848pN.class, C0849pO.class, C0854pT.class, C0853pS.class, C0857pW.class, C0850pP.class, C0852pR.class, C0855pU.class, C0856pV.class, C0847pM.class).dynamicInvoker().invoke(abstractC0851pQ, 0) /* invoke-custom */) {
            case 0:
                m891a((C0859pY) abstractC0851pQ, i, i2);
                break;
            case 1:
                m892a((C0858pX) abstractC0851pQ, i, i2);
                break;
            case 2:
                m893a((C0848pN) abstractC0851pQ, i, i2);
                break;
            case 3:
                m894a((C0849pO) abstractC0851pQ, i, i2);
                break;
            case 4:
                m895a((C0854pT) abstractC0851pQ, i, i2);
                break;
            case 5:
                m896a((C0853pS) abstractC0851pQ, i, i2);
                break;
            case 6:
                m897a((C0857pW) abstractC0851pQ, i, i2);
                break;
            case 7:
                m898a((C0850pP) abstractC0851pQ, i, i2);
                break;
            case 8:
                m900a((C0852pR) abstractC0851pQ, i, i2);
                break;
            case C0862pb.f4509nv /* 9 */:
                m903a((C0855pU) abstractC0851pQ, i, i2);
                break;
            case 10:
                m907a((C0856pV) abstractC0851pQ, i, i2);
                break;
            case AbstractC0877pq.f4599nO /* 11 */:
                m906a((C0847pM) abstractC0851pQ, i, i2);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m891a(@NotNull C0859pY c0859pY, int i, int i2) {
        int iM925c = m925c(i2);
        Vec3 vec3 = (Vec3) c0859pY.f4485d.get();
        addRenderableWidget(m912a(i, iM925c, 60, vec3.x, d -> {
            Vec3 vec32 = (Vec3) c0859pY.f4485d.get();
            c0859pY.f4486d.accept((T) new Vec3(d, vec32.y, vec32.z));
        }));
        addRenderableWidget(m912a(i + 60 + 4, iM925c, 60, vec3.y, d2 -> {
            Vec3 vec32 = (Vec3) c0859pY.f4485d.get();
            c0859pY.f4486d.accept((T) new Vec3(vec32.x, d2, vec32.z));
        }));
        addRenderableWidget(m912a(i + 128, iM925c, 60, vec3.z, d3 -> {
            Vec3 vec32 = (Vec3) c0859pY.f4485d.get();
            c0859pY.f4486d.accept((T) new Vec3(vec32.x, vec32.y, d3));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m892a(@NotNull C0858pX c0858pX, int i, int i2) {
        int iM925c = m925c(i2);
        Vec2 vec2 = (Vec2) c0858pX.f4485d.get();
        addRenderableWidget(m912a(i, iM925c, 93, vec2.x, d -> {
            c0858pX.f4486d.accept((T) new Vec2((float) d, ((Vec2) c0858pX.f4485d.get()).y));
        }));
        addRenderableWidget(m912a(i + 93 + 4, iM925c, 93, vec2.y, d2 -> {
            c0858pX.f4486d.accept((T) new Vec2(((Vec2) c0858pX.f4485d.get()).x, (float) d2));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m893a(@NotNull C0848pN c0848pN, int i, int i2) {
        int iM925c = m925c(i2);
        BlockPos blockPos = (BlockPos) c0848pN.f4485d.get();
        addRenderableWidget(m913a(i, iM925c, 60, blockPos.getX(), Integer.MIN_VALUE, Integer.MAX_VALUE, i3 -> {
            BlockPos blockPos2 = (BlockPos) c0848pN.f4485d.get();
            c0848pN.f4486d.accept((T) new BlockPos(i3, blockPos2.getY(), blockPos2.getZ()));
        }));
        addRenderableWidget(m913a(i + 60 + 4, iM925c, 60, blockPos.getY(), Integer.MIN_VALUE, Integer.MAX_VALUE, i4 -> {
            BlockPos blockPos2 = (BlockPos) c0848pN.f4485d.get();
            c0848pN.f4486d.accept((T) new BlockPos(blockPos2.getX(), i4, blockPos2.getZ()));
        }));
        addRenderableWidget(m913a(i + 128, iM925c, 60, blockPos.getZ(), Integer.MIN_VALUE, Integer.MAX_VALUE, i5 -> {
            BlockPos blockPos2 = (BlockPos) c0848pN.f4485d.get();
            c0848pN.f4486d.accept((T) new BlockPos(blockPos2.getX(), blockPos2.getY(), i5));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m894a(@NotNull C0849pO c0849pO, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m925c(i2), AbstractC0211dM.f1737gZ, 16, m911a(((Boolean) c0849pO.f4485d.get()).booleanValue()), button -> {
            boolean z = !((Boolean) c0849pO.f4485d.get()).booleanValue();
            c0849pO.f4486d.accept((T) Boolean.valueOf(z));
            button.setMessage(m911a(z));
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m895a(@NotNull C0854pT c0854pT, int i, int i2) {
        int iM925c = m925c(i2);
        int iIntValue = ((Integer) c0854pT.f4485d.get()).intValue();
        int i3 = c0854pT.f4492nW;
        int i4 = c0854pT.f4493nX;
        Consumer<T> consumer = c0854pT.f4486d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m913a(i, iM925c, AbstractC0211dM.f1737gZ, iIntValue, i3, i4, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m896a(@NotNull C0853pS c0853pS, int i, int i2) {
        int iM925c = m925c(i2);
        float fFloatValue = ((Float) c0853pS.f4485d.get()).floatValue();
        float f = c0853pS.f4490kG;
        float f2 = c0853pS.f4491kH;
        Consumer<T> consumer = c0853pS.f4486d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m914a(i, iM925c, AbstractC0211dM.f1737gZ, fFloatValue, f, f2, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m897a(@NotNull C0857pW c0857pW, int i, int i2) {
        EditBox editBox = new EditBox(this.font, i, m925c(i2), AbstractC0211dM.f1737gZ, 16, Component.empty());
        editBox.setMaxLength(c0857pW.f4499nZ);
        editBox.setValue((String) c0857pW.f4485d.get());
        Consumer<T> consumer = c0857pW.f4486d;
        Objects.requireNonNull(consumer);
        editBox.setResponder((v1) -> {
            r1.accept(v1);
        });
        addRenderableWidget(editBox);
    }

    /* JADX INFO: renamed from: a */
    private void m898a(@NotNull C0850pP c0850pP, int i, int i2) {
        int iM925c = m925c(i2);
        int iIntValue = ((Integer) c0850pP.f4485d.get()).intValue();
        addRenderableWidget(m913a(i, iM925c, 39, (iIntValue >> 16) & 255, 0, 255, i3 -> {
            m899b(c0850pP, 16, i3);
        }));
        addRenderableWidget(m913a(i + 43, iM925c, 39, (iIntValue >> 8) & 255, 0, 255, i4 -> {
            m899b(c0850pP, 8, i4);
        }));
        addRenderableWidget(m913a(i + 86, iM925c, 39, iIntValue & 255, 0, 255, i5 -> {
            m899b(c0850pP, 0, i5);
        }));
        addRenderableWidget(m913a(i + 129, iM925c, 39, (iIntValue >> 24) & 255, 0, 255, i6 -> {
            m899b(c0850pP, 24, i6);
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: b */
    public static void m899b(@NotNull C0850pP c0850pP, int i, int i2) {
        c0850pP.f4486d.accept((T) Integer.valueOf((((Integer) c0850pP.f4485d.get()).intValue() & ((255 << i) ^ (-1))) | ((i2 & 255) << i)));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m900a(@NotNull C0852pR<E> c0852pR, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m925c(i2), AbstractC0211dM.f1737gZ, 16, m902a((C0852pR) c0852pR), button -> {
            m901a(c0852pR);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m901a(@NotNull C0852pR<E> c0852pR) {
        List listOf = List.of((Object[]) c0852pR.f4488b.getEnumConstants());
        Minecraft minecraft = this.f1587b;
        MutableComponent mutableComponentLiteral = Component.literal("Select " + c0852pR.f4488b.getSimpleName());
        Function function = (v0) -> {
            return v0.name();
        };
        Function<E, Component> function2 = c0852pR.f4489g;
        Enum r8 = (Enum) c0852pR.f4485d.get();
        Consumer<T> consumer = c0852pR.f4486d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new C0149cN(this, mutableComponentLiteral, listOf, function, function2, r8, (v1) -> {
            r9.accept(v1);
        }));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static <E extends Enum<E>> Component m902a(@NotNull C0852pR<E> c0852pR) {
        Enum r0 = (Enum) c0852pR.f4485d.get();
        return r0 == null ? f1182da : c0852pR.f4489g.apply((E) r0);
    }

    /* JADX INFO: renamed from: a */
    private <T> void m903a(@NotNull C0855pU<T> c0855pU, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m925c(i2), AbstractC0211dM.f1737gZ, 16, m905a((C0855pU) c0855pU), button -> {
            m904a(c0855pU);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <T> void m904a(@NotNull C0855pU<T> c0855pU) {
        Minecraft minecraft = this.f1587b;
        Component component = c0855pU.f4494iV;
        List<T> list = c0855pU.f4495e.get();
        Function<T, String> function = c0855pU.f4496h;
        Function<T, Component> function2 = c0855pU.f4497i;
        T t = c0855pU.f4485d.get();
        Consumer<T> consumer = c0855pU.f4486d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new C0149cN(this, component, list, function, function2, t, consumer::accept));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static <T> Component m905a(@NotNull C0855pU<T> c0855pU) {
        T t = c0855pU.f4485d.get();
        return t == null ? f1182da : c0855pU.f4497i.apply(t);
    }

    /* JADX INFO: renamed from: a */
    private void m906a(@NotNull C0847pM c0847pM, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m925c(i2), AbstractC0211dM.f1737gZ, 16, c0847pM.f4480iT, button -> {
            c0847pM.f4481a.run();
            init();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m907a(@NotNull C0856pV c0856pV, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m925c(i2), AbstractC0211dM.f1737gZ, 16, m910a((SoundEvent) c0856pV.f4485d.get()), button -> {
            m908a(c0856pV);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m908a(@NotNull C0856pV c0856pV) {
        List list = BuiltInRegistries.SOUND_EVENT.stream().toList();
        Minecraft minecraft = this.f1587b;
        Component component = f1183db;
        Function function = C0147cL::m909c;
        Function function2 = soundEvent -> {
            return C0146cK.m842a(m909c(soundEvent));
        };
        SoundEvent soundEvent2 = (SoundEvent) c0856pV.f4485d.get();
        Consumer<T> consumer = c0856pV.f4486d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new C0149cN(this, component, list, function, function2, soundEvent2, (v1) -> {
            r9.accept(v1);
        }));
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m909c(@Nullable SoundEvent soundEvent) {
        ResourceLocation key;
        return (soundEvent == null || (key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent)) == null) ? "" : key.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m910a(@Nullable SoundEvent soundEvent) {
        String strM909c = m909c(soundEvent);
        return strM909c.isEmpty() ? f1182da : C0146cK.m842a(strM909c);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m911a(boolean z) {
        return z ? f1184dc : f1185dd;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m912a(int i, int i2, int i3, double d, @NotNull DoubleConsumer doubleConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m915a(d));
        editBox.setFilter(str -> {
            return f1188c.matcher(str).matches();
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
    private EditBox m913a(int i, int i2, int i3, int i4, int i5, int i6, @NotNull IntConsumer intConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(Integer.toString(i4));
        editBox.setFilter(str -> {
            return f1189d.matcher(str).matches();
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
    private EditBox m914a(int i, int i2, int i3, float f, float f2, float f3, @NotNull a aVar) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m916c(f));
        editBox.setFilter(str -> {
            return f1188c.matcher(str).matches();
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
    private static String m915a(double d) {
        return (d != ((double) ((long) d)) || Double.isInfinite(d)) ? Double.toString(d) : Long.toString((long) d);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m916c(float f) {
        return (f != ((float) ((long) f)) || Float.isInfinite(f)) ? Float.toString(f) : Long.toString((long) f);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i = (this.width / 2) - 95;
        int iM924A = m924A() + m927C() + 6;
        addRenderableWidget(new C0127bs(i + 2, iM924A, 80, 20, f1170cZ, button -> {
            mo1276J();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        addRenderableWidget(new C0127bs(((i + AbstractC0211dM.f1737gZ) - 80) - 2, iM924A, 80, 20, f1169cY, button2 -> {
            m917N();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: N */
    private void m917N() {
        UUID uuid = this.f1190c.f4463y;
        if (!Objects.equals(this.f1190c.f4464c, this.f1195l)) {
            C1194vo.m6653c(new C1157vD(uuid, this.f1190c.f4464c));
        }
        C1194vo.m6653c(C1198vs.m6674a(uuid, m918a()));
        this.f1197bd = true;
        mo1276J();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private JsonObject m918a() {
        DataResult dataResultEncodeStart = C0836pB.f4476H.encodeStart(JsonOps.INSTANCE, this.f1190c);
        DataResult dataResultEncodeStart2 = C0836pB.f4476H.encodeStart(JsonOps.INSTANCE, this.f1191d);
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
    private boolean m919a(int i) {
        return i < this.f1193r.size() && i < this.f1194s.size() && !Objects.equals(this.f1193r.get(i).f4485d.get(), this.f1194s.get(i).f4485d.get());
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        int iM920a;
        if (i == 1 && (iM920a = m920a(d2)) >= 0) {
            m921h(iM920a);
            return true;
        }
        if (i == 0 && m929w()) {
            int i2 = ((this.width / 2) - 95) + AbstractC0211dM.f1737gZ + 2;
            int iM924A = m924A();
            int iM927C = m927C();
            if (d >= i2 && d < i2 + 4 && d2 >= iM924A && d2 < iM924A + iM927C) {
                int iMax = Math.max(10, (iM927C * iM927C) / m926B());
                int i3 = iM927C - iMax;
                int iClamp = i3 > 0 ? Mth.clamp((((((int) d2) - iM924A) - (iMax / 2)) * m928D()) / i3, 0, m928D()) : 0;
                this.f1199be = true;
                this.f1200eJ = (int) d2;
                this.f1201eK = iClamp;
                if (iClamp != this.f1198eI) {
                    this.f1198eI = iClamp;
                    init();
                    return true;
                }
                return true;
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    /* JADX INFO: renamed from: a */
    private int m920a(double d) {
        int iM924A = m924A();
        int iM927C = iM924A + m927C();
        if (d < iM924A || d >= iM927C) {
            return -1;
        }
        int iM4283bn = iM924A - this.f1198eI;
        for (int i = 0; i < this.f1193r.size(); i++) {
            AbstractC0851pQ<?> abstractC0851pQ = this.f1193r.get(i);
            int iM4283bn2 = iM4283bn + abstractC0851pQ.m4283bn();
            if (d >= iM4283bn && d < iM4283bn2) {
                return i;
            }
            iM4283bn += abstractC0851pQ.m4283bn() + 8;
        }
        return -1;
    }

    /* JADX INFO: renamed from: h */
    private <T> void m921h(int i) {
        if (i >= this.f1193r.size() || i >= this.f1194s.size()) {
            return;
        }
        this.f1193r.get(i).f4486d.accept(this.f1194s.get(i).f4485d.get());
        init();
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        if (i == 0 && this.f1199be) {
            int iM927C = m927C();
            int iMax = iM927C - Math.max(10, (iM927C * iM927C) / m926B());
            if (iMax > 0) {
                int iClamp = Mth.clamp(this.f1201eK + (((((int) d2) - this.f1200eJ) * m928D()) / iMax), 0, m928D());
                if (iClamp != this.f1198eI) {
                    this.f1198eI = iClamp;
                    init();
                    return true;
                }
                return true;
            }
            return true;
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean mouseReleased(double d, double d2, int i) {
        if (i == 0 && this.f1199be) {
            this.f1199be = false;
            return true;
        }
        return super.mouseReleased(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (!m929w()) {
            return super.mouseScrolled(d, d2, d3, d4);
        }
        int iClamp = Mth.clamp(this.f1198eI - ((int) (d4 * 36.0d)), 0, m928D());
        if (iClamp != this.f1198eI) {
            this.f1198eI = iClamp;
            init();
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    public void onClose() {
        if (!this.f1197bd) {
            AbstractC0835pA abstractC0835pA = (AbstractC0835pA) C0836pB.f4477d.decode(Unpooled.wrappedBuffer(this.f1196b));
            C0622l c0622lM2667b = C0622l.m2667b();
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b != null ? c0622lM2667b.m2688a() : null;
            if (abstractC0787oFM2688a != null) {
                abstractC0787oFM2688a.m3653a().m5610c(abstractC0835pA);
            }
        }
        super.onClose();
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        int i3 = (this.width / 2) - 95;
        int iM924A = m924A();
        int iM927C = iM924A + m927C();
        int iM4283bn = iM924A - this.f1198eI;
        if (m929w()) {
            C0119bk.m517a(guiGraphics, i3, iM924A, AbstractC0211dM.f1737gZ, m927C());
        }
        for (int i4 = 0; i4 < this.f1193r.size(); i4++) {
            AbstractC0851pQ<?> abstractC0851pQ = this.f1193r.get(i4);
            C0119bk.m371a(this.font, guiGraphics, abstractC0851pQ.f4484iU, i3, iM4283bn, abstractC0851pQ.f4487nV);
            int iWidth = this.font.width(abstractC0851pQ.f4484iU);
            if (m919a(i4)) {
                C0119bk.m371a(this.font, guiGraphics, f1186de, i3 + iWidth, iM4283bn, ColorReferences.COLOR_MAP_EFFECT_REFERENCE_OVERRIDE);
            } else {
                C0119bk.m371a(this.font, guiGraphics, f1187df, i3 + iWidth, iM4283bn, ColorReferences.COLOR_MAP_EFFECT_REFERENCE);
            }
            if (abstractC0851pQ instanceof C0850pP) {
                m923a(guiGraphics, (C0850pP) abstractC0851pQ, i3, iM4283bn);
            }
            iM4283bn += abstractC0851pQ.m4283bn() + 8;
        }
        if (m929w()) {
            guiGraphics.disableScissor();
            m922a(guiGraphics, i3, iM924A, m927C());
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m922a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3) {
        int iM926B = m926B();
        if (iM926B <= 0 || i3 <= 0) {
            return;
        }
        int i4 = i + AbstractC0211dM.f1737gZ + 2;
        C0119bk.m415a(guiGraphics, i4, i2, 4, i3, f1179eT);
        int iMax = Math.max(10, (i3 * i3) / iM926B);
        int i5 = i3 - iMax;
        int iM928D = m928D();
        C0119bk.m415a(guiGraphics, i4, i2 + (iM928D > 0 ? (i5 * this.f1198eI) / iM928D : 0), 4, iMax, f1180eU);
    }

    /* JADX INFO: renamed from: a */
    private void m923a(@NotNull GuiGraphics guiGraphics, @NotNull C0850pP c0850pP, int i, int i2) {
        int i3 = (i + AbstractC0211dM.f1737gZ) - 16;
        int iM925c = m925c(i2);
        C0119bk.m415a(guiGraphics, i3 - 1, iM925c - 1, 18, 18, -1);
        C0119bk.m415a(guiGraphics, i3, iM925c, 16, 16, ((Integer) c0850pP.f4485d.get()).intValue());
    }

    /* JADX INFO: renamed from: A */
    private int m924A() {
        return 85 + (11 * this.f1744B.size());
    }

    /* JADX INFO: renamed from: c */
    private static int m925c(int i) {
        return i + 10 + 2;
    }

    /* JADX INFO: renamed from: B */
    private int m926B() {
        int iM4283bn = 0;
        Iterator<AbstractC0851pQ<?>> it = this.f1193r.iterator();
        while (it.hasNext()) {
            iM4283bn += it.next().m4283bn() + 8;
        }
        if (iM4283bn > 0) {
            return iM4283bn - 8;
        }
        return 0;
    }

    /* JADX INFO: renamed from: C */
    private int m927C() {
        return Mth.clamp(m926B(), 0, Math.max(80, ((this.height - m924A()) - 20) - 18));
    }

    /* JADX INFO: renamed from: D */
    private int m928D() {
        return Math.max(0, m926B() - m927C());
    }

    /* JADX INFO: renamed from: w */
    private boolean m929w() {
        return m928D() > 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: E */
    protected int mo859E() {
        return m927C();
    }
}
