package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cK.class */
public class cK extends dM {
    private static final int ew = 12;
    private static final int ex = 10;
    private static final int ey = 2;
    private static final int ez = 8;
    private static final int eA = 16;
    private static final int eB = 4;
    private static final int eC = 16;
    private static final int eD = -1;
    private static final int eE = 36;
    private static final int eF = 4;
    private static final int eG = 1090519039;
    private static final int eH = -5592406;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final pA f80a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final b f81a;

    @Nullable
    private final String N;

    @NotNull
    private List<pQ<?>> r;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f82a;
    private boolean bd;
    private int eI;
    private boolean be;
    private int eJ;
    private int eK;
    private static final Component cN = Component.translatable("bf.menu.title.edit.map.effect");
    private static final Component cO = Component.translatable("bf.menu.title.create.map.effect");
    private static final Component cP = Component.translatable("bf.menu.button.confirm");
    private static final Component cQ = Component.translatable("bf.menu.button.create");
    private static final Component cR = Component.translatable("bf.menu.button.close");
    private static final Component cS = Component.translatable("bf.menu.button.convert.to.template");
    private static final Component cT = Component.translatable("bf.menu.button.copy.uuid");
    private static final ResourceLocation bb = C0265jv.d("textures/gui/menu/icons/copy.png");
    private static final Component cU = Component.translatable("bf.menu.label.none");
    private static final Component cV = Component.translatable("bf.menu.picker.sound");
    private static final Component cW = Component.translatable("bf.menu.boolean.on").withStyle(ChatFormatting.GREEN);
    private static final Component cX = Component.translatable("bf.menu.boolean.off").withStyle(ChatFormatting.RED);
    private static final Pattern a = Pattern.compile("^-?[0-9]*\\.?[0-9]*$");
    private static final Pattern b = Pattern.compile("^-?[0-9]*$");

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cK$a.class */
    @FunctionalInterface
    private interface a {
        void accept(float f);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cK$b.class */
    public enum b {
        EDIT,
        CREATE,
        EDIT_TEMPLATE
    }

    public cK(@Nullable Screen screen, @NotNull pA pAVar) {
        this(screen, pAVar, b.EDIT, null);
    }

    public cK(@Nullable Screen screen, @NotNull pA pAVar, @NotNull b bVar) {
        this(screen, pAVar, bVar, null);
    }

    public cK(@Nullable Screen screen, @NotNull pA pAVar, @NotNull b bVar, @Nullable String str) {
        super(screen, a(bVar, str));
        this.bd = false;
        this.eI = 0;
        this.be = false;
        this.f80a = pAVar;
        this.f81a = bVar;
        this.N = str;
        this.r = pAVar.H();
        this.f82a = a(pAVar);
        a();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    private static Component a(@NotNull b bVar, @Nullable String str) throws MatchException {
        switch (bVar) {
            case EDIT:
                return cN;
            case CREATE:
                return cO;
            case EDIT_TEMPLATE:
                Object[] objArr = new Object[1];
                objArr[0] = str != null ? str : "?";
                return Component.translatable("bf.menu.title.edit.template", objArr);
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @NotNull
    private static byte[] a(@NotNull pA pAVar) {
        ByteBuf byteBufBuffer = Unpooled.buffer();
        pB.d.encode(byteBufBuffer, pAVar);
        byte[] bArr = new byte[byteBufBuffer.readableBytes()];
        byteBufBuffer.readBytes(bArr);
        return bArr;
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        this.r = this.f80a.H();
        this.eI = Mth.clamp(this.eI, 0, D());
        clearWidgets();
        super.init();
        int i = (this.width / 2) - 95;
        int iA = A();
        int iC = iA + C();
        int iBn = iA - this.eI;
        for (pQ<?> pQVar : this.r) {
            int iBn2 = iBn + pQVar.bn();
            if (iBn2 > iA && iBn2 <= iC) {
                a(pQVar, i, iBn);
            }
            iBn += pQVar.bn() + 8;
        }
    }

    private void a(@NotNull pQ<?> pQVar, int i, int i2) {
        Objects.requireNonNull(pQVar);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), pY.class, pX.class, pN.class, pO.class, pT.class, pS.class, pW.class, pP.class, pR.class, pU.class, pV.class, pM.class).dynamicInvoker().invoke(pQVar, 0) /* invoke-custom */) {
            case 0:
                a((pY) pQVar, i, i2);
                break;
            case 1:
                a((pX) pQVar, i, i2);
                break;
            case 2:
                a((pN) pQVar, i, i2);
                break;
            case 3:
                a((pO) pQVar, i, i2);
                break;
            case 4:
                a((pT) pQVar, i, i2);
                break;
            case 5:
                a((pS) pQVar, i, i2);
                break;
            case 6:
                a((pW) pQVar, i, i2);
                break;
            case 7:
                a((pP) pQVar, i, i2);
                break;
            case 8:
                a((pR) pQVar, i, i2);
                break;
            case C0407pb.nv /* 9 */:
                a((pU) pQVar, i, i2);
                break;
            case 10:
                a((pV) pQVar, i, i2);
                break;
            case AbstractC0422pq.nO /* 11 */:
                a((pM) pQVar, i, i2);
                break;
        }
    }

    private void a(@NotNull pY pYVar, int i, int i2) {
        int iC = c(i2);
        Vec3 vec3 = (Vec3) pYVar.d.get();
        addRenderableWidget(a(i, iC, 60, vec3.x, d -> {
            Vec3 vec32 = (Vec3) pYVar.d.get();
            pYVar.f278d.accept((T) new Vec3(d, vec32.y, vec32.z));
        }));
        addRenderableWidget(a(i + 60 + 4, iC, 60, vec3.y, d2 -> {
            Vec3 vec32 = (Vec3) pYVar.d.get();
            pYVar.f278d.accept((T) new Vec3(vec32.x, d2, vec32.z));
        }));
        addRenderableWidget(a(i + 128, iC, 60, vec3.z, d3 -> {
            Vec3 vec32 = (Vec3) pYVar.d.get();
            pYVar.f278d.accept((T) new Vec3(vec32.x, vec32.y, d3));
        }));
    }

    private void a(@NotNull pX pXVar, int i, int i2) {
        int iC = c(i2);
        Vec2 vec2 = (Vec2) pXVar.d.get();
        addRenderableWidget(a(i, iC, 93, vec2.x, d -> {
            pXVar.f278d.accept((T) new Vec2((float) d, ((Vec2) pXVar.d.get()).y));
        }));
        addRenderableWidget(a(i + 93 + 4, iC, 93, vec2.y, d2 -> {
            pXVar.f278d.accept((T) new Vec2(((Vec2) pXVar.d.get()).x, (float) d2));
        }));
    }

    private void a(@NotNull pN pNVar, int i, int i2) {
        int iC = c(i2);
        BlockPos blockPos = (BlockPos) pNVar.d.get();
        addRenderableWidget(a(i, iC, 60, blockPos.getX(), Integer.MIN_VALUE, Integer.MAX_VALUE, i3 -> {
            BlockPos blockPos2 = (BlockPos) pNVar.d.get();
            pNVar.f278d.accept((T) new BlockPos(i3, blockPos2.getY(), blockPos2.getZ()));
        }));
        addRenderableWidget(a(i + 60 + 4, iC, 60, blockPos.getY(), Integer.MIN_VALUE, Integer.MAX_VALUE, i4 -> {
            BlockPos blockPos2 = (BlockPos) pNVar.d.get();
            pNVar.f278d.accept((T) new BlockPos(blockPos2.getX(), i4, blockPos2.getZ()));
        }));
        addRenderableWidget(a(i + 128, iC, 60, blockPos.getZ(), Integer.MIN_VALUE, Integer.MAX_VALUE, i5 -> {
            BlockPos blockPos2 = (BlockPos) pNVar.d.get();
            pNVar.f278d.accept((T) new BlockPos(blockPos2.getX(), blockPos2.getY(), i5));
        }));
    }

    private void a(@NotNull pO pOVar, int i, int i2) {
        addRenderableWidget(new C0048bs(i, c(i2), dM.gZ, 16, a(((Boolean) pOVar.d.get()).booleanValue()), button -> {
            boolean z = !((Boolean) pOVar.d.get()).booleanValue();
            pOVar.f278d.accept((T) Boolean.valueOf(z));
            button.setMessage(a(z));
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
    }

    private void a(@NotNull pT pTVar, int i, int i2) {
        int iC = c(i2);
        int iIntValue = ((Integer) pTVar.d.get()).intValue();
        int i3 = pTVar.nW;
        int i4 = pTVar.nX;
        Consumer<T> consumer = pTVar.f278d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(a(i, iC, dM.gZ, iIntValue, i3, i4, (v1) -> {
            r8.accept(v1);
        }));
    }

    private void a(@NotNull pS pSVar, int i, int i2) {
        int iC = c(i2);
        float fFloatValue = ((Float) pSVar.d.get()).floatValue();
        float f = pSVar.kG;
        float f2 = pSVar.kH;
        Consumer<T> consumer = pSVar.f278d;
        Objects.requireNonNull(consumer);
        addRenderableWidget(a(i, iC, dM.gZ, fFloatValue, f, f2, (v1) -> {
            r8.accept(v1);
        }));
    }

    private void a(@NotNull pW pWVar, int i, int i2) {
        EditBox editBox = new EditBox(this.font, i, c(i2), dM.gZ, 16, Component.empty());
        editBox.setMaxLength(pWVar.nZ);
        editBox.setValue((String) pWVar.d.get());
        Consumer<T> consumer = pWVar.f278d;
        Objects.requireNonNull(consumer);
        editBox.setResponder((v1) -> {
            r1.accept(v1);
        });
        addRenderableWidget(editBox);
    }

    private void a(@NotNull pP pPVar, int i, int i2) {
        int iC = c(i2);
        int iIntValue = ((Integer) pPVar.d.get()).intValue();
        addRenderableWidget(a(i, iC, 39, (iIntValue >> 16) & 255, 0, 255, i3 -> {
            b(pPVar, 16, i3);
        }));
        addRenderableWidget(a(i + 43, iC, 39, (iIntValue >> 8) & 255, 0, 255, i4 -> {
            b(pPVar, 8, i4);
        }));
        addRenderableWidget(a(i + 86, iC, 39, iIntValue & 255, 0, 255, i5 -> {
            b(pPVar, 0, i5);
        }));
        addRenderableWidget(a(i + 129, iC, 39, (iIntValue >> 24) & 255, 0, 255, i6 -> {
            b(pPVar, 24, i6);
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void b(@NotNull pP pPVar, int i, int i2) {
        pPVar.f278d.accept((T) Integer.valueOf((((Integer) pPVar.d.get()).intValue() & ((255 << i) ^ (-1))) | ((i2 & 255) << i)));
    }

    private <E extends Enum<E>> void a(@NotNull pR<E> pRVar, int i, int i2) {
        addRenderableWidget(new C0048bs(i, c(i2), dM.gZ, 16, m267a((pR) pRVar), button -> {
            a(pRVar);
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
    }

    private <E extends Enum<E>> void a(@NotNull pR<E> pRVar) {
        List listOf = List.of((Object[]) pRVar.b.getEnumConstants());
        Minecraft minecraft = this.b;
        MutableComponent mutableComponentLiteral = Component.literal("Select " + pRVar.b.getSimpleName());
        Function function = (v0) -> {
            return v0.name();
        };
        Function<E, Component> function2 = pRVar.g;
        Enum r8 = (Enum) pRVar.d.get();
        Consumer<T> consumer = pRVar.f278d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new cN(this, mutableComponentLiteral, listOf, function, function2, r8, (v1) -> {
            r9.accept(v1);
        }));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static <E extends Enum<E>> Component m267a(@NotNull pR<E> pRVar) {
        Enum r0 = (Enum) pRVar.d.get();
        return r0 == null ? cU : pRVar.g.apply((E) r0);
    }

    private <T> void a(@NotNull pU<T> pUVar, int i, int i2) {
        addRenderableWidget(new C0048bs(i, c(i2), dM.gZ, 16, m268a((pU) pUVar), button -> {
            a(pUVar);
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
    }

    private <T> void a(@NotNull pU<T> pUVar) {
        Minecraft minecraft = this.b;
        Component component = pUVar.iV;
        List<T> list = pUVar.e.get();
        Function<T, String> function = pUVar.h;
        Function<T, Component> function2 = pUVar.i;
        T t = pUVar.d.get();
        Consumer<T> consumer = pUVar.f278d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new cN(this, component, list, function, function2, t, consumer::accept));
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static <T> Component m268a(@NotNull pU<T> pUVar) {
        T t = pUVar.d.get();
        return t == null ? cU : pUVar.i.apply(t);
    }

    private void a(@NotNull pM pMVar, int i, int i2) {
        addRenderableWidget(new C0048bs(i, c(i2), dM.gZ, 16, pMVar.iT, button -> {
            pMVar.a.run();
            init();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
    }

    private void a(@NotNull pV pVVar, int i, int i2) {
        addRenderableWidget(new C0048bs(i, c(i2), dM.gZ, 16, a((SoundEvent) pVVar.d.get()), button -> {
            a(pVVar);
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
    }

    private void a(@NotNull pV pVVar) {
        List list = BuiltInRegistries.SOUND_EVENT.stream().toList();
        Minecraft minecraft = this.b;
        Component component = cV;
        Function function = cK::c;
        Function function2 = soundEvent -> {
            return a(c(soundEvent));
        };
        SoundEvent soundEvent2 = (SoundEvent) pVVar.d.get();
        Consumer<T> consumer = pVVar.f278d;
        Objects.requireNonNull(consumer);
        minecraft.setScreen(new cN(this, component, list, function, function2, soundEvent2, (v1) -> {
            r9.accept(v1);
        }));
    }

    @NotNull
    private static String c(@Nullable SoundEvent soundEvent) {
        ResourceLocation key;
        return (soundEvent == null || (key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent)) == null) ? "" : key.toString();
    }

    @NotNull
    private static Component a(@Nullable SoundEvent soundEvent) {
        String strC = c(soundEvent);
        return strC.isEmpty() ? cU : a(strC);
    }

    @NotNull
    private static Component a(boolean z) {
        return z ? cW : cX;
    }

    @NotNull
    public static Component a(@NotNull String str) {
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
    private EditBox a(int i, int i2, int i3, double d, @NotNull DoubleConsumer doubleConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(a(d));
        editBox.setFilter(str -> {
            return a.matcher(str).matches();
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
    private EditBox a(int i, int i2, int i3, int i4, int i5, int i6, @NotNull IntConsumer intConsumer) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(Integer.toString(i4));
        editBox.setFilter(str -> {
            return b.matcher(str).matches();
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
    private EditBox a(int i, int i2, int i3, float f, float f2, float f3, @NotNull a aVar) {
        EditBox editBox = new EditBox(this.font, i, i2, i3, 16, Component.empty());
        editBox.setMaxLength(20);
        editBox.setValue(c(f));
        editBox.setFilter(str -> {
            return a.matcher(str).matches();
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
    private static String a(double d) {
        return (d != ((double) ((long) d)) || Double.isInfinite(d)) ? Double.toString(d) : Long.toString((long) d);
    }

    @NotNull
    private static String c(float f) {
        return (f != ((float) ((long) f)) || Float.isInfinite(f)) ? Float.toString(f) : Long.toString((long) f);
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        int i = (this.width / 2) - 95;
        int iA = A() + C() + 6;
        addRenderableWidget(new C0048bs(i + 2, iA, 80, 20, cR, button -> {
            J();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
        addRenderableWidget(new C0048bs(((i + dM.gZ) - 80) - 2, iA, 80, 20, this.f81a == b.CREATE ? cQ : cP, button2 -> {
            N();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
        if (this.f81a == b.EDIT && !C0378o.b(this.f80a.y)) {
            addRenderableWidget(new C0048bs((i + 95) - 40, iA + 20 + 4, 80, 20, cS, button3 -> {
                T();
            }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
        }
        addRenderableWidget(new C0048bs((i + dM.gZ) - 12, eE, 12, 12, Component.empty(), button4 -> {
            S();
        }).a(bb).a(12, 12).a(C0048bs.a.NONE).a(cT));
    }

    private void S() {
        this.b.keyboardHandler.setClipboard(this.f80a.y.toString());
    }

    private void T() {
        final pA pAVar = this.f80a;
        this.b.setScreen(new dO(this, null, Component.translatable("bf.menu.button.convert.to.template")) { // from class: com.boehmod.blockfront.cK.1
            @Override // com.boehmod.blockfront.dO
            public void U() {
                String strTrim = o().trim();
                if (!strTrim.isEmpty()) {
                    C0582vo.c(new C0574vg(pAVar.y, strTrim));
                }
            }
        });
    }

    private void N() {
        byte[] bArrA = a(this.f80a);
        switch (this.f81a) {
            case EDIT:
                C0582vo.c(new C0584vq(this.f80a.y, bArrA));
                break;
            case CREATE:
                C0582vo.c(new C0576vi(bArrA));
                break;
            case EDIT_TEMPLATE:
                if (this.N != null) {
                    C0582vo.c(new C0585vr(this.N, bArrA));
                }
                break;
        }
        this.bd = true;
        J();
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.C0080cx
    public boolean mouseClicked(double d, double d2, int i) {
        int iClamp;
        if (i == 0 && w()) {
            int i2 = ((this.width / 2) - 95) + dM.gZ + 2;
            int iA = A();
            int iC = C();
            if (d >= i2 && d < i2 + 4 && d2 >= iA && d2 < iA + iC) {
                int iMax = Math.max(10, (iC * iC) / B());
                int i3 = iC - iMax;
                int i4 = (((int) d2) - iA) - (iMax / 2);
                if (i3 > 0) {
                    iClamp = Mth.clamp((i4 * D()) / i3, 0, D());
                } else {
                    iClamp = 0;
                }
                int i5 = iClamp;
                this.be = true;
                this.eJ = (int) d2;
                this.eK = i5;
                if (i5 != this.eI) {
                    this.eI = i5;
                    init();
                    return true;
                }
                return true;
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        if (i == 0 && this.be) {
            int iC = C();
            int iMax = iC - Math.max(10, (iC * iC) / B());
            if (iMax > 0) {
                int iClamp = Mth.clamp(this.eK + (((((int) d2) - this.eJ) * D()) / iMax), 0, D());
                if (iClamp != this.eI) {
                    this.eI = iClamp;
                    init();
                    return true;
                }
                return true;
            }
            return true;
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean mouseReleased(double d, double d2, int i) {
        if (i == 0 && this.be) {
            this.be = false;
            return true;
        }
        return super.mouseReleased(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (!w()) {
            return super.mouseScrolled(d, d2, d3, d4);
        }
        int iClamp = Mth.clamp(this.eI - ((int) (d4 * 36.0d)), 0, D());
        if (iClamp != this.eI) {
            this.eI = iClamp;
            init();
            return true;
        }
        return true;
    }

    @Override // com.boehmod.blockfront.dM
    public void onClose() {
        if (this.f81a == b.EDIT && !this.bd) {
            pA pAVar = (pA) pB.d.decode(Unpooled.wrappedBuffer(this.f82a));
            C0297l c0297lB = C0297l.b();
            oF<?, ?, ?> oFVarM591a = c0297lB != null ? c0297lB.m591a() : null;
            if (oFVarM591a != null) {
                oFVarM591a.m767a().c(pAVar);
            }
        }
        super.onClose();
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        int i3 = (this.width / 2) - 95;
        int iA = A();
        int iC = iA + C();
        int iBn = iA - this.eI;
        if (w()) {
            guiGraphics.enableScissor(i3, iA, i3 + dM.gZ, iC);
        }
        for (pQ<?> pQVar : this.r) {
            guiGraphics.drawString(this.font, pQVar.iU, i3, iBn, pQVar.nV);
            if (pQVar instanceof pP) {
                a(guiGraphics, (pP) pQVar, i3, iBn);
            }
            iBn += pQVar.bn() + 8;
        }
        if (w()) {
            guiGraphics.disableScissor();
            a(guiGraphics, i3, iA, C());
        }
        poseStackPose.popPose();
    }

    private void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3) {
        int iB = B();
        if (iB <= 0 || i3 <= 0) {
            return;
        }
        int i4 = i + dM.gZ + 2;
        C0040bk.a(guiGraphics, i4, i2, 4, i3, eG);
        int iMax = Math.max(10, (i3 * i3) / iB);
        int i5 = i3 - iMax;
        int iD = D();
        C0040bk.a(guiGraphics, i4, i2 + (iD > 0 ? (i5 * this.eI) / iD : 0), 4, iMax, eH);
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull pP pPVar, int i, int i2) {
        int i3 = (i + dM.gZ) - 16;
        int iC = c(i2);
        C0040bk.a(guiGraphics, i3 - 1, iC - 1, 18, 18, -1);
        C0040bk.a(guiGraphics, i3, iC, 16, 16, ((Integer) pPVar.d.get()).intValue());
    }

    private int A() {
        return 85 + (11 * this.B.size());
    }

    private static int c(int i) {
        return i + 10 + 2;
    }

    private int B() {
        int iBn = 0;
        Iterator<pQ<?>> it = this.r.iterator();
        while (it.hasNext()) {
            iBn += it.next().bn() + 8;
        }
        if (iBn > 0) {
            return iBn - 8;
        }
        return 0;
    }

    private int C() {
        return Mth.clamp(B(), 0, Math.max(80, ((this.height - A()) - 20) - 18));
    }

    private int D() {
        return Math.max(0, B() - C());
    }

    private boolean w() {
        return D() > 0;
    }

    @Override // com.boehmod.blockfront.dM
    protected int E() {
        return C() + ((this.f81a != b.EDIT || C0378o.b(this.f80a.y)) ? 0 : 24);
    }
}
