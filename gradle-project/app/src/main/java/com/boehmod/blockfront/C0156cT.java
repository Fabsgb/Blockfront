package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cT.class */
public class C0156cT extends AbstractC0223dX {

    /* JADX INFO: renamed from: fw */
    private static final int f1230fw = 12;

    /* JADX INFO: renamed from: fx */
    private static final int f1231fx = 10;

    /* JADX INFO: renamed from: fy */
    private static final int f1232fy = 2;

    /* JADX INFO: renamed from: fz */
    private static final int f1233fz = 8;

    /* JADX INFO: renamed from: fA */
    private static final int f1234fA = 16;

    /* JADX INFO: renamed from: fB */
    private static final int f1235fB = 4;

    /* JADX INFO: renamed from: fC */
    private static final int f1236fC = 16;

    /* JADX INFO: renamed from: fD */
    private static final int f1241fD = -1;

    /* JADX INFO: renamed from: fE */
    private static final int f1242fE = 36;

    /* JADX INFO: renamed from: fF */
    private static final int f1243fF = 4;

    /* JADX INFO: renamed from: fG */
    private static final int f1244fG = 1090519039;

    /* JADX INFO: renamed from: fH */
    private static final int f1245fH = -5592406;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0858pW f1248a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final b f1249a;

    /* JADX INFO: renamed from: T */
    @Nullable
    private final String f1250T;

    /* JADX INFO: renamed from: t */
    @NotNull
    private List<AbstractC0927qm<?>> f1251t;

    /* JADX INFO: renamed from: a */
    private final byte[] f1252a;

    /* JADX INFO: renamed from: bh */
    private boolean f1253bh;

    /* JADX INFO: renamed from: fI */
    private int f1254fI;

    /* JADX INFO: renamed from: bi */
    private boolean f1255bi;

    /* JADX INFO: renamed from: fJ */
    private int f1256fJ;

    /* JADX INFO: renamed from: fK */
    private int f1257fK;

    /* JADX INFO: renamed from: cP */
    private static final Component f1222cP = Component.translatable("bf.menu.title.edit.map.effect");

    /* JADX INFO: renamed from: cQ */
    private static final Component f1223cQ = Component.translatable("bf.menu.title.create.map.effect");

    /* JADX INFO: renamed from: cR */
    private static final Component f1224cR = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: cS */
    private static final Component f1225cS = Component.translatable("bf.menu.button.create");

    /* JADX INFO: renamed from: cT */
    private static final Component f1226cT = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: cU */
    private static final Component f1227cU = Component.translatable("bf.menu.button.convert.to.template");

    /* JADX INFO: renamed from: cV */
    private static final Component f1228cV = Component.translatable("bf.menu.button.copy.uuid");

    /* JADX INFO: renamed from: aZ */
    private static final ResourceLocation f1229aZ = C0532jO.m2378d("textures/gui/menu/icons/copy.png");

    /* JADX INFO: renamed from: cW */
    private static final Component f1237cW = Component.translatable("bf.menu.label.none");

    /* JADX INFO: renamed from: cX */
    private static final Component f1238cX = Component.translatable("bf.menu.picker.sound");

    /* JADX INFO: renamed from: cY */
    private static final Component f1239cY = Component.translatable("bf.menu.boolean.on").withStyle(ChatFormatting.GREEN);

    /* JADX INFO: renamed from: cZ */
    private static final Component f1240cZ = Component.translatable("bf.menu.boolean.off").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: a */
    private static final Pattern f1246a = Pattern.compile("^-?[0-9]*\\.?[0-9]*$");

    /* JADX INFO: renamed from: b */
    private static final Pattern f1247b = Pattern.compile("^-?[0-9]*$");

    /* JADX INFO: renamed from: com.boehmod.blockfront.cT$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cT$a.class */
    @FunctionalInterface
    private interface a {
        void accept(float f);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cT$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cT$b.class */
    public enum b {
        EDIT,
        CREATE,
        EDIT_TEMPLATE
    }

    public C0156cT(@Nullable Screen screen, @NotNull AbstractC0858pW abstractC0858pW) {
        this(screen, abstractC0858pW, b.EDIT, null);
    }

    public C0156cT(@Nullable Screen screen, @NotNull AbstractC0858pW abstractC0858pW, @NotNull b bVar) {
        this(screen, abstractC0858pW, bVar, null);
    }

    public C0156cT(@Nullable Screen screen, @NotNull AbstractC0858pW abstractC0858pW, @NotNull b bVar, @Nullable String str) {
        super(screen, m872a(bVar, str));
        this.f1253bh = false;
        this.f1254fI = 0;
        this.f1255bi = false;
        this.f1248a = abstractC0858pW;
        this.f1249a = bVar;
        this.f1250T = str;
        this.f1251t = abstractC0858pW.mo3946J();
        this.f1252a = m873a(abstractC0858pW);
        mo1323a();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m872a(@NotNull b bVar, @Nullable String str) throws MatchException {
        switch (bVar) {
            case EDIT:
                return f1222cP;
            case CREATE:
                return f1223cQ;
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
    private static byte[] m873a(@NotNull AbstractC0858pW abstractC0858pW) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        C0859pX.f4606d.encode(byteBufBuffer, abstractC0858pW);
        byte[] bArr = new byte[byteBufBuffer.readableBytes()];
        byteBufBuffer.readBytes(bArr);
        return bArr;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        this.f1251t = this.f1248a.mo3946J();
        this.f1254fI = Mth.clamp(this.f1254fI, 0, m911H());
        clearWidgets();
        super.init();
        int i = (this.width / 2) - 95;
        int iM907E = m907E();
        int iM910G = iM907E + m910G();
        int iM5077bC = iM907E - this.f1254fI;
        for (AbstractC0927qm<?> abstractC0927qm : this.f1251t) {
            int iM5077bC2 = iM5077bC + abstractC0927qm.m5077bC();
            if (iM5077bC2 > iM907E && iM5077bC2 <= iM910G) {
                m874a(abstractC0927qm, i, iM5077bC);
            }
            iM5077bC += abstractC0927qm.m5077bC() + 8;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m874a(@NotNull AbstractC0927qm<?> abstractC0927qm, int i, int i2) {
        Objects.requireNonNull(abstractC0927qm);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0935qu.class, C0934qt.class, C0924qj.class, C0925qk.class, C0930qp.class, C0929qo.class, C0933qs.class, C0926ql.class, C0928qn.class, C0931qq.class, C0932qr.class, C0923qi.class).dynamicInvoker().invoke(abstractC0927qm, 0) /* invoke-custom */) {
            case 0:
                m875a((C0935qu) abstractC0927qm, i, i2);
                break;
            case 1:
                m876a((C0934qt) abstractC0927qm, i, i2);
                break;
            case 2:
                m877a((C0924qj) abstractC0927qm, i, i2);
                break;
            case 3:
                m878a((C0925qk) abstractC0927qm, i, i2);
                break;
            case 4:
                m879a((C0930qp) abstractC0927qm, i, i2);
                break;
            case 5:
                m880a((C0929qo) abstractC0927qm, i, i2);
                break;
            case 6:
                m881a((C0933qs) abstractC0927qm, i, i2);
                break;
            case C0994s.f5462C /* 7 */:
                m882a((C0926ql) abstractC0927qm, i, i2);
                break;
            case 8:
                m884a((C0928qn) abstractC0927qm, i, i2);
                break;
            case 9:
                m887a((C0931qq) abstractC0927qm, i, i2);
                break;
            case 10:
                m891a((C0932qr) abstractC0927qm, i, i2);
                break;
            case 11:
                m890a((C0923qi) abstractC0927qm, i, i2);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m875a(@NotNull C0935qu c0935qu, int i, int i2) {
        int iM908c = m908c(i2);
        Vec3 vec3 = (Vec3) c0935qu.f5124d.get();
        addRenderableWidget(m897a(i, iM908c, 60, vec3.x, d -> {
            Vec3 vec4 = (Vec3) c0935qu.f5124d.get();
            c0935qu.f5125d.accept((T) new Vec3(d, vec4.y, vec4.z));
        }));
        addRenderableWidget(m897a(i + 60 + 4, iM908c, 60, vec3.y, d2 -> {
            Vec3 vec4 = (Vec3) c0935qu.f5124d.get();
            c0935qu.f5125d.accept((T) new Vec3(vec4.x, d2, vec4.z));
        }));
        addRenderableWidget(m897a(i + 128, iM908c, 60, vec3.z, d3 -> {
            Vec3 vec4 = (Vec3) c0935qu.f5124d.get();
            c0935qu.f5125d.accept((T) new Vec3(vec4.x, vec4.y, d3));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m876a(@NotNull C0934qt c0934qt, int i, int i2) {
        int iM908c = m908c(i2);
        Vec2 vec2 = (Vec2) c0934qt.f5124d.get();
        addRenderableWidget(m897a(i, iM908c, 93, vec2.x, d -> {
            c0934qt.f5125d.accept((T) new Vec2((float) d, ((Vec2) c0934qt.f5124d.get()).y));
        }));
        addRenderableWidget(m897a(i + 93 + 4, iM908c, 93, vec2.y, d2 -> {
            c0934qt.f5125d.accept((T) new Vec2(((Vec2) c0934qt.f5124d.get()).x, (float) d2));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m877a(@NotNull C0924qj c0924qj, int i, int i2) {
        int iM908c = m908c(i2);
        BlockPos blockPos = (BlockPos) c0924qj.f5124d.get();
        addRenderableWidget(m898a(i, iM908c, 60, blockPos.getX(), Integer.MIN_VALUE, Integer.MAX_VALUE, i3 -> {
            BlockPos blockPos2 = (BlockPos) c0924qj.f5124d.get();
            c0924qj.f5125d.accept((T) new BlockPos(i3, blockPos2.getY(), blockPos2.getZ()));
        }));
        addRenderableWidget(m898a(i + 60 + 4, iM908c, 60, blockPos.getY(), Integer.MIN_VALUE, Integer.MAX_VALUE, i4 -> {
            BlockPos blockPos2 = (BlockPos) c0924qj.f5124d.get();
            c0924qj.f5125d.accept((T) new BlockPos(blockPos2.getX(), i4, blockPos2.getZ()));
        }));
        addRenderableWidget(m898a(i + 128, iM908c, 60, blockPos.getZ(), Integer.MIN_VALUE, Integer.MAX_VALUE, i5 -> {
            BlockPos blockPos2 = (BlockPos) c0924qj.f5124d.get();
            c0924qj.f5125d.accept((T) new BlockPos(blockPos2.getX(), blockPos2.getY(), i5));
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m878a(@NotNull C0925qk c0925qk, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m908c(i2), AbstractC0223dX.f1766ij, 16, m895a(((Boolean) c0925qk.f5124d.get()).booleanValue()), button -> {
            boolean z = !((Boolean) c0925qk.f5124d.get()).booleanValue();
            c0925qk.f5125d.accept((T) Boolean.valueOf(z));
            button.setMessage(m895a(z));
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m879a(@NotNull C0930qp c0930qp, int i, int i2) {
        int iM908c = m908c(i2);
        int iIntValue = ((Integer) c0930qp.f5124d.get()).intValue();
        int i3 = c0930qp.f5131pV;
        int i4 = c0930qp.f5132pW;
        Consumer<T> consumer = c0930qp.f5125d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m898a(i, iM908c, AbstractC0223dX.f1766ij, iIntValue, i3, i4, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m880a(@NotNull C0929qo c0929qo, int i, int i2) {
        int iM908c = m908c(i2);
        float fFloatValue = ((Float) c0929qo.f5124d.get()).floatValue();
        float f = c0929qo.f5129lB;
        float f2 = c0929qo.f5130lC;
        Consumer<T> consumer = c0929qo.f5125d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(m899a(i, iM908c, AbstractC0223dX.f1766ij, fFloatValue, f, f2, (v1) -> {
            r8.accept(v1);
        }));
    }

    /* JADX INFO: renamed from: a */
    private void m881a(@NotNull C0933qs c0933qs, int i, int i2) {
        EditBox editBox = new EditBox(this.font, i, m908c(i2), AbstractC0223dX.f1766ij, 16, Component.empty());
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
    private void m882a(@NotNull C0926ql c0926ql, int i, int i2) {
        int iM908c = m908c(i2);
        int iIntValue = ((Integer) c0926ql.f5124d.get()).intValue();
        addRenderableWidget(m898a(i, iM908c, 39, (iIntValue >> 16) & 255, 0, 255, i3 -> {
            m883b(c0926ql, 16, i3);
        }));
        addRenderableWidget(m898a(i + 43, iM908c, 39, (iIntValue >> 8) & 255, 0, 255, i4 -> {
            m883b(c0926ql, 8, i4);
        }));
        addRenderableWidget(m898a(i + 86, iM908c, 39, iIntValue & 255, 0, 255, i5 -> {
            m883b(c0926ql, 0, i5);
        }));
        addRenderableWidget(m898a(i + 129, iM908c, 39, (iIntValue >> 24) & 255, 0, 255, i6 -> {
            m883b(c0926ql, 24, i6);
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: b */
    public static void m883b(@NotNull C0926ql c0926ql, int i, int i2) {
        c0926ql.f5125d.accept((T) Integer.valueOf((((Integer) c0926ql.f5124d.get()).intValue() & ((255 << i) ^ (-1))) | ((i2 & 255) << i)));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m884a(@NotNull C0928qn<E> c0928qn, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m908c(i2), AbstractC0223dX.f1766ij, 16, m886a((C0928qn) c0928qn), button -> {
            m885a(c0928qn);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <E extends Enum<E>> void m885a(@NotNull C0928qn<E> c0928qn) {
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
    private static <E extends Enum<E>> Component m886a(@NotNull C0928qn<E> c0928qn) {
        Enum r0 = (Enum) c0928qn.f5124d.get();
        return r0 == null ? f1237cW : c0928qn.f5128g.apply((E) r0);
    }

    /* JADX INFO: renamed from: a */
    private <T> void m887a(@NotNull C0931qq<T> c0931qq, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m908c(i2), AbstractC0223dX.f1766ij, 16, m889a((C0931qq) c0931qq), button -> {
            m888a(c0931qq);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private <T> void m888a(@NotNull C0931qq<T> c0931qq) {
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
    private static <T> Component m889a(@NotNull C0931qq<T> c0931qq) {
        T t = c0931qq.f5124d.get();
        return t == null ? f1237cW : c0931qq.f5136i.apply(t);
    }

    /* JADX INFO: renamed from: a */
    private void m890a(@NotNull C0923qi c0923qi, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m908c(i2), AbstractC0223dX.f1766ij, 16, c0923qi.f5119jg, button -> {
            c0923qi.f5120a.run();
            init();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m891a(@NotNull C0932qr c0932qr, int i, int i2) {
        addRenderableWidget(new C0085bB(i, m908c(i2), AbstractC0223dX.f1766ij, 16, m894a((SoundEvent) c0932qr.f5124d.get()), button -> {
            m892a(c0932qr);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: a */
    private void m892a(@NotNull C0932qr c0932qr) {
        List list = BuiltInRegistries.SOUND_EVENT.stream().toList();
        Minecraft minecraft = this.f1058a;
        Component component = f1238cX;
        Function function = C0156cT::m893c;
        Function function2 = soundEvent -> {
            return m896a(m893c(soundEvent));
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
    private static String m893c(@Nullable SoundEvent soundEvent) {
        ResourceLocation key;
        return (soundEvent == null || (key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent)) == null) ? "" : key.toString();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m894a(@Nullable SoundEvent soundEvent) {
        String strM893c = m893c(soundEvent);
        return strM893c.isEmpty() ? f1237cW : m896a(strM893c);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m895a(boolean z) {
        return z ? f1239cY : f1240cZ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m896a(@NotNull String str) {
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
    private EditBox m897a(int i, int i2, int i3, double d, @NotNull DoubleConsumer doubleConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m900a(d));
        editBox.setFilter(str -> {
            return f1246a.matcher(str).matches();
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
    private EditBox m898a(int i, int i2, int i3, int i4, int i5, int i6, @NotNull IntConsumer intConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(Integer.toString(i4));
        editBox.setFilter(str -> {
            return f1247b.matcher(str).matches();
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
    private EditBox m899a(int i, int i2, int i3, float f, float f2, float f3, @NotNull a aVar) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(m901c(f));
        editBox.setFilter(str -> {
            return f1246a.matcher(str).matches();
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
    private static String m900a(double d) {
        return (d != ((double) ((long) d)) || Double.isInfinite(d)) ? Double.toString(d) : Long.toString((long) d);
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m901c(float f) {
        return (f != ((float) ((long) f)) || Float.isInfinite(f)) ? Float.toString(f) : Long.toString((long) f);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i = (this.width / 2) - 95;
        int iM907E = m907E() + m910G() + 6;
        addRenderableWidget(new C0085bB(i + 2, iM907E, 80, 20, f1226cT, button -> {
            m1327N();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        addRenderableWidget(new C0085bB(((i + AbstractC0223dX.f1766ij) - 80) - 2, iM907E, 80, 20, this.f1249a == b.CREATE ? f1225cS : f1224cR, button2 -> {
            m904R();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
        if (this.f1249a == b.EDIT && !C0782o.m3660b(this.f1248a.f4592y)) {
            addRenderableWidget(new C0085bB((i + 95) - 40, iM907E + 20 + 4, 80, 20, f1227cU, button3 -> {
                m903X();
            }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        }
        addRenderableWidget(new C0085bB((i + AbstractC0223dX.f1766ij) - 12, f1242fE, 12, 12, Component.empty(), button4 -> {
            m902W();
        }).m320a(f1229aZ).m322a(12, 12).m328a(C0085bB.a.NONE).m326a(f1228cV));
    }

    /* JADX INFO: renamed from: W */
    private void m902W() {
        this.f1058a.keyboardHandler.setClipboard(this.f1248a.f4592y.toString());
    }

    /* JADX INFO: renamed from: X */
    private void m903X() {
        final AbstractC0858pW abstractC0858pW = this.f1248a;
        this.f1058a.setScreen(new AbstractC0225dZ(this, null, Component.translatable("bf.menu.button.convert.to.template")) { // from class: com.boehmod.blockfront.cT.1
            @Override // com.boehmod.blockfront.AbstractC0225dZ
            /* JADX INFO: renamed from: Y */
            public void mo942Y() {
                String strTrim = m1333s().trim();
                if (!strTrim.isEmpty()) {
                    C1169vO.m6648c(new C1161vG(abstractC0858pW.f4592y, strTrim));
                }
            }
        });
    }

    /* JADX INFO: renamed from: R */
    private void m904R() {
        byte[] bArrM873a = m873a(this.f1248a);
        switch (this.f1249a) {
            case EDIT:
                C1169vO.m6648c(new C1171vQ(this.f1248a.f4592y, bArrM873a));
                break;
            case CREATE:
                C1169vO.m6648c(new C1163vI(bArrM873a));
                break;
            case EDIT_TEMPLATE:
                if (this.f1250T != null) {
                    C1169vO.m6648c(new C1172vR(this.f1250T, bArrM873a));
                }
                break;
        }
        this.f1253bh = true;
        m1327N();
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        int iClamp;
        if (i == 0 && m912x()) {
            int i2 = ((this.width / 2) - 95) + AbstractC0223dX.f1766ij + 2;
            int iM907E = m907E();
            int iM910G = m910G();
            if (d >= i2 && d < i2 + 4 && d2 >= iM907E && d2 < iM907E + iM910G) {
                int iMax = Math.max(10, (iM910G * iM910G) / m909F());
                int i3 = iM910G - iMax;
                int i4 = (((int) d2) - iM907E) - (iMax / 2);
                if (i3 > 0) {
                    iClamp = Mth.clamp((i4 * m911H()) / i3, 0, m911H());
                } else {
                    iClamp = 0;
                }
                int i5 = iClamp;
                this.f1255bi = true;
                this.f1256fJ = (int) d2;
                this.f1257fK = i5;
                if (i5 != this.f1254fI) {
                    this.f1254fI = i5;
                    init();
                    return true;
                }
                return true;
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        if (i == 0 && this.f1255bi) {
            int iM910G = m910G();
            int iMax = iM910G - Math.max(10, (iM910G * iM910G) / m909F());
            if (iMax > 0) {
                int iClamp = Mth.clamp(this.f1257fK + (((((int) d2) - this.f1256fJ) * m911H()) / iMax), 0, m911H());
                if (iClamp != this.f1254fI) {
                    this.f1254fI = iClamp;
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
        if (i == 0 && this.f1255bi) {
            this.f1255bi = false;
            return true;
        }
        return super.mouseReleased(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (!m912x()) {
            return super.mouseScrolled(d, d2, d3, d4);
        }
        int iClamp = Mth.clamp(this.f1254fI - ((int) (d4 * 36.0d)), 0, m911H());
        if (iClamp != this.f1254fI) {
            this.f1254fI = iClamp;
            init();
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    public void onClose() {
        if (this.f1249a == b.EDIT && !this.f1253bh) {
            AbstractC0858pW abstractC0858pW = (AbstractC0858pW) C0859pX.f4606d.decode(Unpooled.wrappedBuffer(this.f1252a));
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
        int iM907E = m907E();
        int iM910G = iM907E + m910G();
        int iM5077bC = iM907E - this.f1254fI;
        if (m912x()) {
            guiGraphics.enableScissor(i3, iM907E, i3 + AbstractC0223dX.f1766ij, iM910G);
        }
        for (AbstractC0927qm<?> abstractC0927qm : this.f1251t) {
            guiGraphics.drawString(this.font, abstractC0927qm.f5123jh, i3, iM5077bC, abstractC0927qm.f5126pU);
            if (abstractC0927qm instanceof C0926ql) {
                m906a(guiGraphics, (C0926ql) abstractC0927qm, i3, iM5077bC);
            }
            iM5077bC += abstractC0927qm.m5077bC() + 8;
        }
        if (m912x()) {
            guiGraphics.disableScissor();
            m905a(guiGraphics, i3, iM907E, m910G());
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m905a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3) {
        int iM909F = m909F();
        if (iM909F <= 0 || i3 <= 0) {
            return;
        }
        int i4 = i + AbstractC0223dX.f1766ij + 2;
        C0129bt.m515a(guiGraphics, i4, i2, 4, i3, f1244fG);
        int iMax = Math.max(10, (i3 * i3) / iM909F);
        int i5 = i3 - iMax;
        int iM911H = m911H();
        C0129bt.m515a(guiGraphics, i4, i2 + (iM911H > 0 ? (i5 * this.f1254fI) / iM911H : 0), 4, iMax, f1245fH);
    }

    /* JADX INFO: renamed from: a */
    private void m906a(@NotNull GuiGraphics guiGraphics, @NotNull C0926ql c0926ql, int i, int i2) {
        int i3 = (i + AbstractC0223dX.f1766ij) - 16;
        int iM908c = m908c(i2);
        C0129bt.m515a(guiGraphics, i3 - 1, iM908c - 1, 18, 18, -1);
        C0129bt.m515a(guiGraphics, i3, iM908c, 16, 16, ((Integer) c0926ql.f5124d.get()).intValue());
    }

    /* JADX INFO: renamed from: E */
    private int m907E() {
        return 85 + (11 * this.f1773D.size());
    }

    /* JADX INFO: renamed from: c */
    private static int m908c(int i) {
        return i + 10 + 2;
    }

    /* JADX INFO: renamed from: F */
    private int m909F() {
        int iM5077bC = 0;
        Iterator<AbstractC0927qm<?>> it = this.f1251t.iterator();
        while (it.hasNext()) {
            iM5077bC += it.next().m5077bC() + 8;
        }
        if (iM5077bC > 0) {
            return iM5077bC - 8;
        }
        return 0;
    }

    /* JADX INFO: renamed from: G */
    private int m910G() {
        return Mth.clamp(m909F(), 0, Math.max(80, ((this.height - m907E()) - 20) - 18));
    }

    /* JADX INFO: renamed from: H */
    private int m911H() {
        return Math.max(0, m909F() - m910G());
    }

    /* JADX INFO: renamed from: x */
    private boolean m912x() {
        return m911H() > 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: I */
    protected int mo913I() {
        return m910G() + ((this.f1249a != b.EDIT || C0782o.m3660b(this.f1248a.f4592y)) ? 0 : 24);
    }
}
