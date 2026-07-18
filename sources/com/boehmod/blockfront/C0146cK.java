package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cK.class */
public class C0146cK extends AbstractC0211dM {

    /* JADX INFO: renamed from: ew */
    private static final int f1140ew = 12;

    /* JADX INFO: renamed from: ex */
    private static final int f1141ex = 10;

    /* JADX INFO: renamed from: ey */
    private static final int f1142ey = 2;

    /* JADX INFO: renamed from: ez */
    private static final int f1143ez = 8;

    /* JADX INFO: renamed from: eA */
    private static final int f1144eA = 16;

    /* JADX INFO: renamed from: eB */
    private static final int f1145eB = 4;

    /* JADX INFO: renamed from: eC */
    private static final int f1146eC = 16;

    /* JADX INFO: renamed from: eD */
    private static final int f1151eD = -1;

    /* JADX INFO: renamed from: eE */
    private static final int f1152eE = 36;

    /* JADX INFO: renamed from: eF */
    private static final int f1153eF = 4;

    /* JADX INFO: renamed from: eG */
    private static final int f1154eG = 1090519039;

    /* JADX INFO: renamed from: eH */
    private static final int f1155eH = -5592406;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0835pA f1158a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final b f1159a;

    /* JADX INFO: renamed from: N */
    @Nullable
    private final String f1160N;

    /* JADX INFO: renamed from: r */
    @NotNull
    private List<AbstractC0851pQ<?>> f1161r;

    /* JADX INFO: renamed from: a */
    private final byte[] f1162a;

    /* JADX INFO: renamed from: bd */
    private boolean f1163bd;

    /* JADX INFO: renamed from: eI */
    private int f1164eI;

    /* JADX INFO: renamed from: be */
    private boolean f1165be;

    /* JADX INFO: renamed from: eJ */
    private int f1166eJ;

    /* JADX INFO: renamed from: eK */
    private int f1167eK;

    /* JADX INFO: renamed from: cN */
    private static final Component f1132cN = Component.translatable("bf.menu.title.edit.map.effect");

    /* JADX INFO: renamed from: cO */
    private static final Component f1133cO = Component.translatable("bf.menu.title.create.map.effect");

    /* JADX INFO: renamed from: cP */
    private static final Component f1134cP = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: cQ */
    private static final Component f1135cQ = Component.translatable("bf.menu.button.create");

    /* JADX INFO: renamed from: cR */
    private static final Component f1136cR = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: cS */
    private static final Component f1137cS = Component.translatable("bf.menu.button.convert.to.template");

    /* JADX INFO: renamed from: cT */
    private static final Component f1138cT = Component.translatable("bf.menu.button.copy.uuid");

    /* JADX INFO: renamed from: bb */
    private static final ResourceLocation f1139bb = C0564jv.m2555d("textures/gui/menu/icons/copy.png");

    /* JADX INFO: renamed from: cU */
    private static final Component f1147cU = Component.translatable("bf.menu.label.none");

    /* JADX INFO: renamed from: cV */
    private static final Component f1148cV = Component.translatable("bf.menu.picker.sound");

    /* JADX INFO: renamed from: cW */
    private static final Component f1149cW = Component.translatable("bf.menu.boolean.on").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: cX */
    private static final Component f1150cX = Component.translatable("bf.menu.boolean.off").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: a */
    private static final Pattern f1156a = Pattern.compile("^-?[0-9]*\\.?[0-9]*$");

    /* JADX INFO: renamed from: b */
    private static final Pattern f1157b = Pattern.compile("^-?[0-9]*$");

    /* JADX INFO: renamed from: com.boehmod.blockfront.cK$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cK$a.class */
    @FunctionalInterface
    private interface a {
        void accept(float f);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cK$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cK$b.class */
    public enum b {
        EDIT,
        CREATE,
        EDIT_TEMPLATE
    }

    public C0146cK(@Nullable Screen screen, @NotNull AbstractC0835pA abstractC0835pA) {
        this(screen, abstractC0835pA, b.EDIT, null);
    }

    public C0146cK(@Nullable Screen screen, @NotNull AbstractC0835pA abstractC0835pA, @NotNull b bVar) {
        this(screen, abstractC0835pA, bVar, null);
    }

    public C0146cK(@Nullable Screen screen, @NotNull AbstractC0835pA abstractC0835pA, @NotNull b bVar, @Nullable String str) {
        super(screen, m818a(bVar, str));
        this.f1163bd = false;
        this.f1164eI = 0;
        this.f1165be = false;
        this.f1158a = abstractC0835pA;
        this.f1159a = bVar;
        this.f1160N = str;
        this.f1161r = abstractC0835pA.mo4227H();
        this.f1162a = m819a(abstractC0835pA);
        mo1272a();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m818a(@NotNull b bVar, @Nullable String str) throws MatchException {
        switch (bVar) {
            case EDIT:
                return f1132cN;
            case CREATE:
                return f1133cO;
            case EDIT_TEMPLATE:
                Object[] objArr = new Object[1];
                objArr[0] = str != null ? str : "?";
                return Component.translatable("bf.menu.title.edit.template", objArr);
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static byte[] m819a(@NotNull AbstractC0835pA abstractC0835pA) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        C0836pB.f4477d.encode(byteBufBuffer, abstractC0835pA);
        byte[] bArr = new byte[byteBufBuffer.readableBytes()];
        byteBufBuffer.readBytes(bArr);
        return bArr;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        this.f1161r = this.f1158a.mo4227H();
        this.f1164eI = Mth.clamp(this.f1164eI, 0, m857D());
        clearWidgets();
        super.init();
        int i = (this.width / 2) - 95;
        int iM853A = m853A();
        int iM856C = iM853A + m856C();
        int iM4283bn = iM853A - this.f1164eI;
        for (AbstractC0851pQ<?> abstractC0851pQ : this.f1161r) {
            int iM4283bn2 = iM4283bn + abstractC0851pQ.m4283bn();
            if (iM4283bn2 > iM853A && iM4283bn2 <= iM856C) {
                m820a(abstractC0851pQ, i, iM4283bn);
            }
            iM4283bn += abstractC0851pQ.m4283bn() + 8;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m820a(@NotNull AbstractC0851pQ<?> abstractC0851pQ, int i, int i2) {
        Objects.requireNonNull(abstractC0851pQ);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0859pY.class, C0858pX.class, C0848pN.class, C0849pO.class, C0854pT.class, C0853pS.class, C0857pW.class, C0850pP.class, C0852pR.class, C0855pU.class, C0856pV.class, C0847pM.class).dynamicInvoker().invoke(abstractC0851pQ, 0) /* invoke-custom */) {
            case 0:
                m821a((C0859pY) abstractC0851pQ, i, i2);
                break;
            case 1:
                m822a((C0858pX) abstractC0851pQ, i, i2);
                break;
            case 2:
                m823a((C0848pN) abstractC0851pQ, i, i2);
                break;
            case 3:
                m824a((C0849pO) abstractC0851pQ, i, i2);
                break;
            case 4:
                m825a((C0854pT) abstractC0851pQ, i, i2);
                break;
            case 5:
                m826a((C0853pS) abstractC0851pQ, i, i2);
                break;
            case 6:
                m827a((C0857pW) abstractC0851pQ, i, i2);
                break;
            case 7:
                m828a((C0850pP) abstractC0851pQ, i, i2);
                break;
            case 8:
                m830a((C0852pR) abstractC0851pQ, i, i2);
                break;
            case C0862pb.f4509nv /* 9 */:
                m833a((C0855pU) abstractC0851pQ, i, i2);
                break;
            case 10:
                m837a((C0856pV) abstractC0851pQ, i, i2);
                break;
            case AbstractC0877pq.f4599nO /* 11 */:
                m836a((C0847pM) abstractC0851pQ, i, i2);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m821a(@NotNull C0859pY c0859pY, int i, int i2) {
        int iM854c = m854c(i2);
        Vec3 vec3 = (Vec3) c0859pY.f4485d.get();
        addRenderableWidget(m843a(i, iM854c, 60, vec3.x, d -> {
            Vec3 vec32 = (Vec3) c0859pY.f4485d.get();
            c0859pY.f4486d.accept((T) new Vec3(d, vec32.y, vec32.z));
        }));
        addRenderableWidget(m843a(i + 60 + 4, iM854c, 60, vec3.y, d2 -> {
            Vec3 vec32 = (Vec3) c0859pY.f4485d.get();
            c0859pY.f4486d.accept((T) new Vec3(vec32.x, d2, vec32.z));
        }));
        addRenderableWidget(m843a(i + 128, iM854c, 60, vec3.z, d3 -> {
            Vec3 vec32 = (Vec3) c0859pY.f4485d.get();
            c0859pY.f4486d.accept((T) new Vec3(vec32.x, vec32.y, d3));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m822a(@NotNull C0858pX c0858pX, int i, int i2) {
        int iM854c = m854c(i2);
        Vec2 vec2 = (Vec2) c0858pX.f4485d.get();
        addRenderableWidget(m843a(i, iM854c, 93, vec2.x, d -> {
            c0858pX.f4486d.accept((T) new Vec2((float) d, ((Vec2) c0858pX.f4485d.get()).y));
        }));
        addRenderableWidget(m843a(i + 93 + 4, iM854c, 93, vec2.y, d2 -> {
            c0858pX.f4486d.accept((T) new Vec2(((Vec2) c0858pX.f4485d.get()).x, (float) d2));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m823a(@NotNull C0848pN c0848pN, int i, int i2) {
        int iM854c = m854c(i2);
        BlockPos blockPos = (BlockPos) c0848pN.f4485d.get();
        addRenderableWidget(m844a(i, iM854c, 60, blockPos.getX(), Integer.MIN_VALUE, Integer.MAX_VALUE, i3 -> {
            BlockPos blockPos2 = (BlockPos) c0848pN.f4485d.get();
            c0848pN.f4486d.accept((T) new BlockPos(i3, blockPos2.getY(), blockPos2.getZ()));
        }));
        addRenderableWidget(m844a(i + 60 + 4, iM854c, 60, blockPos.getY(), Integer.MIN_VALUE, Integer.MAX_VALUE, i4 -> {
            BlockPos blockPos2 = (BlockPos) c0848pN.f4485d.get();
            c0848pN.f4486d.accept((T) new BlockPos(blockPos2.getX(), i4, blockPos2.getZ()));
        }));
        addRenderableWidget(m844a(i + 128, iM854c, 60, blockPos.getZ(), Integer.MIN_VALUE, Integer.MAX_VALUE, i5 -> {
            BlockPos blockPos2 = (BlockPos) c0848pN.f4485d.get();
            c0848pN.f4486d.accept((T) new BlockPos(blockPos2.getX(), blockPos2.getY(), i5));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m824a(@NotNull C0849pO c0849pO, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m854c(i2), AbstractC0211dM.f1737gZ, 16, m841a(((Boolean) c0849pO.f4485d.get()).booleanValue()), button -> {
            boolean z = !((Boolean) c0849pO.f4485d.get()).booleanValue();
            c0849pO.f4486d.accept((T) Boolean.valueOf(z));
            button.setMessage(m841a(z));
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m825a(@NotNull C0854pT c0854pT, int i, int i2) {
        int iM854c = m854c(i2);
        int iIntValue = ((Integer) c0854pT.f4485d.get()).intValue();
        int i3 = c0854pT.f4492nW;
        int i4 = c0854pT.f4493nX;
        Consumer<T> consumer = c0854pT.f4486d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m844a(i, iM854c, AbstractC0211dM.f1737gZ, iIntValue, i3, i4, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m826a(@NotNull C0853pS c0853pS, int i, int i2) {
        int iM854c = m854c(i2);
        float fFloatValue = ((Float) c0853pS.f4485d.get()).floatValue();
        float f = c0853pS.f4490kG;
        float f2 = c0853pS.f4491kH;
        Consumer<T> consumer = c0853pS.f4486d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m845a(i, iM854c, AbstractC0211dM.f1737gZ, fFloatValue, f, f2, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m827a(@NotNull C0857pW c0857pW, int i, int i2) {
        EditBox editBox = new EditBox(this.font, i, m854c(i2), AbstractC0211dM.f1737gZ, 16, Component.empty());
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
    private void m828a(@NotNull C0850pP c0850pP, int i, int i2) {
        int iM854c = m854c(i2);
        int iIntValue = ((Integer) c0850pP.f4485d.get()).intValue();
        addRenderableWidget(m844a(i, iM854c, 39, (iIntValue >> 16) & 255, 0, 255, i3 -> {
            m829b(c0850pP, 16, i3);
        }));
        addRenderableWidget(m844a(i + 43, iM854c, 39, (iIntValue >> 8) & 255, 0, 255, i4 -> {
            m829b(c0850pP, 8, i4);
        }));
        addRenderableWidget(m844a(i + 86, iM854c, 39, iIntValue & 255, 0, 255, i5 -> {
            m829b(c0850pP, 0, i5);
        }));
        addRenderableWidget(m844a(i + 129, iM854c, 39, (iIntValue >> 24) & 255, 0, 255, i6 -> {
            m829b(c0850pP, 24, i6);
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: b */
    public static void m829b(@NotNull C0850pP c0850pP, int i, int i2) {
        c0850pP.f4486d.accept((T) Integer.valueOf((((Integer) c0850pP.f4485d.get()).intValue() & ((255 << i) ^ (-1))) | ((i2 & 255) << i)));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m830a(@NotNull C0852pR<E> c0852pR, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m854c(i2), AbstractC0211dM.f1737gZ, 16, m832a((C0852pR) c0852pR), button -> {
            m831a(c0852pR);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m831a(@NotNull C0852pR<E> c0852pR) {
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
    private static <E extends Enum<E>> Component m832a(@NotNull C0852pR<E> c0852pR) {
        Enum r0 = (Enum) c0852pR.f4485d.get();
        return r0 == null ? f1147cU : c0852pR.f4489g.apply((E) r0);
    }

    /* JADX INFO: renamed from: a */
    private <T> void m833a(@NotNull C0855pU<T> c0855pU, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m854c(i2), AbstractC0211dM.f1737gZ, 16, m835a((C0855pU) c0855pU), button -> {
            m834a(c0855pU);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <T> void m834a(@NotNull C0855pU<T> c0855pU) {
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
    private static <T> Component m835a(@NotNull C0855pU<T> c0855pU) {
        T t = c0855pU.f4485d.get();
        return t == null ? f1147cU : c0855pU.f4497i.apply(t);
    }

    /* JADX INFO: renamed from: a */
    private void m836a(@NotNull C0847pM c0847pM, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m854c(i2), AbstractC0211dM.f1737gZ, 16, c0847pM.f4480iT, button -> {
            c0847pM.f4481a.run();
            init();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m837a(@NotNull C0856pV c0856pV, int i, int i2) {
        addRenderableWidget(new C0127bs(i, m854c(i2), AbstractC0211dM.f1737gZ, 16, m840a((SoundEvent) c0856pV.f4485d.get()), button -> {
            m838a(c0856pV);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m838a(@NotNull C0856pV c0856pV) {
        List list = BuiltInRegistries.SOUND_EVENT.stream().toList();
        Minecraft minecraft = this.f1587b;
        Component component = f1148cV;
        Function function = C0146cK::m839c;
        Function function2 = soundEvent -> {
            return m842a(m839c(soundEvent));
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
    private static String m839c(@Nullable SoundEvent soundEvent) {
        ResourceLocation key;
        return (soundEvent == null || (key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent)) == null) ? "" : key.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m840a(@Nullable SoundEvent soundEvent) {
        String strM839c = m839c(soundEvent);
        return strM839c.isEmpty() ? f1147cU : m842a(strM839c);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m841a(boolean z) {
        return z ? f1149cW : f1150cX;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m842a(@NotNull String str) {
        MutableComponent mutableComponentEmpty = Component.empty();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' || cCharAt == ':') {
                if (sb.length() > 0) {
                    mutableComponentEmpty.append(Component.literal(sb.toString()).withStyle(ChatFormatting.GRAY));
                    sb.setLength(0);
                }
                mutableComponentEmpty.append(Component.literal(String.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        if (sb.length() > 0) {
            mutableComponentEmpty.append(Component.literal(sb.toString()).withStyle(ChatFormatting.GRAY));
        }
        return mutableComponentEmpty;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m843a(int i, int i2, int i3, double d, @NotNull DoubleConsumer doubleConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m846a(d));
        editBox.setFilter(str -> {
            return f1156a.matcher(str).matches();
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
    private EditBox m844a(int i, int i2, int i3, int i4, int i5, int i6, @NotNull IntConsumer intConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(Integer.toString(i4));
        editBox.setFilter(str -> {
            return f1157b.matcher(str).matches();
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
    private EditBox m845a(int i, int i2, int i3, float f, float f2, float f3, @NotNull a aVar) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m847c(f));
        editBox.setFilter(str -> {
            return f1156a.matcher(str).matches();
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
    private static String m846a(double d) {
        return (d != ((double) ((long) d)) || Double.isInfinite(d)) ? Double.toString(d) : Long.toString((long) d);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m847c(float f) {
        return (f != ((float) ((long) f)) || Float.isInfinite(f)) ? Float.toString(f) : Long.toString((long) f);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i = (this.width / 2) - 95;
        int iM853A = m853A() + m856C() + 6;
        addRenderableWidget(new C0127bs(i + 2, iM853A, 80, 20, f1136cR, button -> {
            mo1276J();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        addRenderableWidget(new C0127bs(((i + AbstractC0211dM.f1737gZ) - 80) - 2, iM853A, 80, 20, this.f1159a == b.CREATE ? f1135cQ : f1134cP, button2 -> {
            m850N();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
        if (this.f1159a == b.EDIT && !C0781o.m3544b(this.f1158a.f4463y)) {
            addRenderableWidget(new C0127bs((i + 95) - 40, iM853A + 20 + 4, 80, 20, f1137cS, button3 -> {
                m849T();
            }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        }
        addRenderableWidget(new C0127bs((i + AbstractC0211dM.f1737gZ) - 12, f1152eE, 12, 12, Component.empty(), button4 -> {
            m848S();
        }).m645a(f1139bb).m647a(12, 12).m653a(C0127bs.a.NONE).m651a(f1138cT));
    }

    /* JADX INFO: renamed from: S */
    private void m848S() {
        this.f1587b.keyboardHandler.setClipboard(this.f1158a.f4463y.toString());
    }

    /* JADX INFO: renamed from: T */
    private void m849T() {
        final AbstractC0835pA abstractC0835pA = this.f1158a;
        this.f1587b.setScreen(new AbstractC0213dO(this, null, Component.translatable("bf.menu.button.convert.to.template")) { // from class: com.boehmod.blockfront.cK.1
            @Override // com.boehmod.blockfront.AbstractC0213dO
            /* JADX INFO: renamed from: U */
            public void mo888U() {
                String strTrim = m1283o().trim();
                if (!strTrim.isEmpty()) {
                    C1194vo.m6653c(new C1186vg(abstractC0835pA.f4463y, strTrim));
                }
            }
        });
    }

    /* JADX INFO: renamed from: N */
    private void m850N() {
        byte[] bArrM819a = m819a(this.f1158a);
        switch (this.f1159a) {
            case EDIT:
                C1194vo.m6653c(new C1196vq(this.f1158a.f4463y, bArrM819a));
                break;
            case CREATE:
                C1194vo.m6653c(new C1188vi(bArrM819a));
                break;
            case EDIT_TEMPLATE:
                if (this.f1160N != null) {
                    C1194vo.m6653c(new C1197vr(this.f1160N, bArrM819a));
                }
                break;
        }
        this.f1163bd = true;
        mo1276J();
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        int iClamp;
        if (i == 0 && m858w()) {
            int i2 = ((this.width / 2) - 95) + AbstractC0211dM.f1737gZ + 2;
            int iM853A = m853A();
            int iM856C = m856C();
            if (d >= i2 && d < i2 + 4 && d2 >= iM853A && d2 < iM853A + iM856C) {
                int iMax = Math.max(10, (iM856C * iM856C) / m855B());
                int i3 = iM856C - iMax;
                int i4 = (((int) d2) - iM853A) - (iMax / 2);
                if (i3 > 0) {
                    iClamp = Mth.clamp((i4 * m857D()) / i3, 0, m857D());
                } else {
                    iClamp = 0;
                }
                int i5 = iClamp;
                this.f1165be = true;
                this.f1166eJ = (int) d2;
                this.f1167eK = i5;
                if (i5 != this.f1164eI) {
                    this.f1164eI = i5;
                    init();
                    return true;
                }
                return true;
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        if (i == 0 && this.f1165be) {
            int iM856C = m856C();
            int iMax = iM856C - Math.max(10, (iM856C * iM856C) / m855B());
            if (iMax > 0) {
                int iClamp = Mth.clamp(this.f1167eK + (((((int) d2) - this.f1166eJ) * m857D()) / iMax), 0, m857D());
                if (iClamp != this.f1164eI) {
                    this.f1164eI = iClamp;
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
        if (i == 0 && this.f1165be) {
            this.f1165be = false;
            return true;
        }
        return super.mouseReleased(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (!m858w()) {
            return super.mouseScrolled(d, d2, d3, d4);
        }
        int iClamp = Mth.clamp(this.f1164eI - ((int) (d4 * 36.0d)), 0, m857D());
        if (iClamp != this.f1164eI) {
            this.f1164eI = iClamp;
            init();
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    public void onClose() {
        if (this.f1159a == b.EDIT && !this.f1163bd) {
            AbstractC0835pA abstractC0835pA = (AbstractC0835pA) C0836pB.f4477d.decode(Unpooled.wrappedBuffer(this.f1162a));
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
        int iM853A = m853A();
        int iM856C = iM853A + m856C();
        int iM4283bn = iM853A - this.f1164eI;
        if (m858w()) {
            guiGraphics.enableScissor(i3, iM853A, i3 + AbstractC0211dM.f1737gZ, iM856C);
        }
        for (AbstractC0851pQ<?> abstractC0851pQ : this.f1161r) {
            guiGraphics.drawString(this.font, abstractC0851pQ.f4484iU, i3, iM4283bn, abstractC0851pQ.f4487nV);
            if (abstractC0851pQ instanceof C0850pP) {
                m852a(guiGraphics, (C0850pP) abstractC0851pQ, i3, iM4283bn);
            }
            iM4283bn += abstractC0851pQ.m4283bn() + 8;
        }
        if (m858w()) {
            guiGraphics.disableScissor();
            m851a(guiGraphics, i3, iM853A, m856C());
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m851a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3) {
        int iM855B = m855B();
        if (iM855B <= 0 || i3 <= 0) {
            return;
        }
        int i4 = i + AbstractC0211dM.f1737gZ + 2;
        C0119bk.m415a(guiGraphics, i4, i2, 4, i3, f1154eG);
        int iMax = Math.max(10, (i3 * i3) / iM855B);
        int i5 = i3 - iMax;
        int iM857D = m857D();
        C0119bk.m415a(guiGraphics, i4, i2 + (iM857D > 0 ? (i5 * this.f1164eI) / iM857D : 0), 4, iMax, f1155eH);
    }

    /* JADX INFO: renamed from: a */
    private void m852a(@NotNull GuiGraphics guiGraphics, @NotNull C0850pP c0850pP, int i, int i2) {
        int i3 = (i + AbstractC0211dM.f1737gZ) - 16;
        int iM854c = m854c(i2);
        C0119bk.m415a(guiGraphics, i3 - 1, iM854c - 1, 18, 18, -1);
        C0119bk.m415a(guiGraphics, i3, iM854c, 16, 16, ((Integer) c0850pP.f4485d.get()).intValue());
    }

    /* JADX INFO: renamed from: A */
    private int m853A() {
        return 85 + (11 * this.f1744B.size());
    }

    /* JADX INFO: renamed from: c */
    private static int m854c(int i) {
        return i + 10 + 2;
    }

    /* JADX INFO: renamed from: B */
    private int m855B() {
        int iM4283bn = 0;
        Iterator<AbstractC0851pQ<?>> it = this.f1161r.iterator();
        while (it.hasNext()) {
            iM4283bn += it.next().m4283bn() + 8;
        }
        if (iM4283bn > 0) {
            return iM4283bn - 8;
        }
        return 0;
    }

    /* JADX INFO: renamed from: C */
    private int m856C() {
        return Mth.clamp(m855B(), 0, Math.max(80, ((this.height - m853A()) - 20) - 18));
    }

    /* JADX INFO: renamed from: D */
    private int m857D() {
        return Math.max(0, m855B() - m856C());
    }

    /* JADX INFO: renamed from: w */
    private boolean m858w() {
        return m857D() > 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: E */
    protected int mo859E() {
        return m856C() + ((this.f1159a != b.EDIT || C0781o.m3544b(this.f1158a.f4463y)) ? 0 : 24);
    }
}
