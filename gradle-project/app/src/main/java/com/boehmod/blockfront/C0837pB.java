package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pB.class */
public final class C0837pB {

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final Codec<C0837pB> f4508w = RecordCodecBuilder.create(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("items", List.of()).forGetter(c0837pB -> {
            return c0837pB.m3832I().stream().filter(itemStack -> {
                return !itemStack.isEmpty();
            }).toList();
        }), Codec.INT.optionalFieldOf("cost", 0).forGetter((v0) -> {
            return v0.m3816bz();
        }), Codec.INT.optionalFieldOf("exp", 0).forGetter((v0) -> {
            return v0.m3818bA();
        }), Codec.STRING.optionalFieldOf("template").forGetter(c0837pB2 -> {
            return Optional.ofNullable(c0837pB2.m3820H());
        })).apply(instance, (list, num, num2, optional) -> {
            C0837pB c0837pB3 = new C0837pB();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0837pB3.m3815e(((ItemStack) it.next()).copy());
            }
            c0837pB3.m3817a(num.intValue());
            c0837pB3.m3819b(num2.intValue());
            Objects.requireNonNull(c0837pB3);
            optional.ifPresent(c0837pB3::m3821a);
            return c0837pB3;
        });
    });

    /* JADX INFO: renamed from: pD */
    public static final int f4509pD = 4;

    /* JADX INFO: renamed from: aJ */
    @NotNull
    private final List<ItemStack> f4510aJ;

    /* JADX INFO: renamed from: h */
    @Nullable
    private ItemStack f4511h;

    /* JADX INFO: renamed from: i */
    @Nullable
    private ItemStack f4512i;

    /* JADX INFO: renamed from: j */
    private ItemStack f4513j;

    /* JADX INFO: renamed from: k */
    private ItemStack f4514k;

    /* JADX INFO: renamed from: l */
    @Nullable
    private ItemStack f4515l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private ItemStack f4516m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private ItemStack f4517n;

    /* JADX INFO: renamed from: o */
    @Nullable
    private ItemStack f4518o;

    /* JADX INFO: renamed from: pr */
    private int f4519pr;

    /* JADX INFO: renamed from: ps */
    private int f4520ps;

    /* JADX INFO: renamed from: T */
    @Nullable
    private String f4521T;

    public C0837pB() {
        this.f4510aJ = new ObjectArrayList();
        this.f4519pr = 0;
        this.f4520ps = 0;
    }

    public C0837pB(@Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, ItemStack itemStack3, ItemStack itemStack4, @Nullable ItemStack itemStack5, @Nullable ItemStack itemStack6, @Nullable ItemStack itemStack7, @Nullable ItemStack itemStack8) {
        this.f4510aJ = new ObjectArrayList();
        this.f4519pr = 0;
        this.f4520ps = 0;
        this.f4511h = itemStack;
        this.f4512i = itemStack2;
        this.f4513j = itemStack3;
        this.f4514k = itemStack4;
        this.f4515l = itemStack5;
        this.f4516m = itemStack6;
        this.f4517n = itemStack7;
        this.f4518o = itemStack8;
    }

    public C0837pB(@Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, @Nullable ItemStack itemStack3) {
        this(itemStack, itemStack2, itemStack3, null, null, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    public static C0837pB m3811a(@NotNull ServerPlayer serverPlayer) {
        C0837pB c0837pB = new C0837pB();
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (itemStack != null && !itemStack.isEmpty()) {
                c0837pB.m3815e(itemStack.copy());
            }
        }
        return c0837pB;
    }

    /* JADX INFO: renamed from: a */
    public C0837pB m3812a(@NotNull ItemStack itemStack) {
        this.f4510aJ.add(itemStack);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0837pB m3813a(@NotNull Collection<ItemStack> collection) {
        this.f4510aJ.addAll(collection);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0837pB m3814b(@NotNull ItemStack itemStack) {
        this.f4516m = itemStack;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public void m3815e(@NotNull ItemStack itemStack) {
        ShieldItem item = itemStack.getItem();
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1117uP.class, C1134ug.class, ShieldItem.class, ArmorItem.class, InterfaceC1148uu.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                if (this.f4511h == null) {
                    this.f4511h = itemStack;
                } else {
                    this.f4512i = itemStack;
                }
                break;
            case 1:
                this.f4513j = itemStack;
                break;
            case 2:
                this.f4514k = itemStack;
                break;
            case 3:
                switch (AnonymousClass1.f4522t[((ArmorItem) item).getType().getSlot().ordinal()]) {
                    case 1:
                        this.f4515l = itemStack;
                        break;
                    case 2:
                        this.f4516m = itemStack;
                        break;
                    case 3:
                        this.f4517n = itemStack;
                        break;
                    case 4:
                        this.f4518o = itemStack;
                        break;
                }
                break;
            case 4:
                this.f4510aJ.add(itemStack);
                if (this.f4510aJ.size() > 4) {
                    this.f4510aJ.removeFirst();
                }
                break;
            default:
                C0530jM.logError("LoadOut does not know how to handle item: %s", BuiltInRegistries.ITEM.getKey(itemStack.getItem()));
                break;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pB$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pB$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: t */
        static final /* synthetic */ int[] f4522t = new int[EquipmentSlot.values().length];

        static {
            try {
                f4522t[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4522t[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4522t[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4522t[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: renamed from: bz */
    public int m3816bz() {
        return this.f4519pr;
    }

    /* JADX INFO: renamed from: a */
    public C0837pB m3817a(int i) {
        this.f4519pr = i;
        return this;
    }

    /* JADX INFO: renamed from: bA */
    public int m3818bA() {
        return this.f4520ps;
    }

    /* JADX INFO: renamed from: b */
    public C0837pB m3819b(int i) {
        this.f4520ps = i;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: H */
    public String m3820H() {
        return this.f4521T;
    }

    /* JADX INFO: renamed from: a */
    public C0837pB m3821a(@Nullable String str) {
        this.f4521T = str;
        return this;
    }

    /* JADX INFO: renamed from: bF */
    public boolean m3822bF() {
        return !m3832I().isEmpty();
    }

    @NotNull
    /* JADX INFO: renamed from: H */
    public List<ItemStack> m3823H() {
        return Collections.unmodifiableList(this.f4510aJ);
    }

    /* JADX INFO: renamed from: e */
    public ItemStack m3824e() {
        return this.f4511h != null ? this.f4511h : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: f */
    public ItemStack m3825f() {
        return this.f4512i != null ? this.f4512i : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: g */
    public ItemStack m3826g() {
        return this.f4513j != null ? this.f4513j : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: h */
    public ItemStack m3827h() {
        return this.f4514k != null ? this.f4514k : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: i */
    public ItemStack m3828i() {
        return this.f4515l != null ? this.f4515l : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: j */
    public ItemStack m3829j() {
        return this.f4516m != null ? this.f4516m : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: k */
    public ItemStack m3830k() {
        return this.f4517n != null ? this.f4517n : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: l */
    public ItemStack m3831l() {
        return this.f4518o != null ? this.f4518o : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: I */
    public List<ItemStack> m3832I() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f4511h != null) {
            objectArrayList.add(this.f4511h);
        }
        if (this.f4512i != null) {
            objectArrayList.add(this.f4512i);
        }
        if (this.f4513j != null) {
            objectArrayList.add(this.f4513j);
        }
        if (this.f4514k != null) {
            objectArrayList.add(this.f4514k);
        }
        if (this.f4515l != null) {
            objectArrayList.add(this.f4515l);
        }
        if (this.f4516m != null) {
            objectArrayList.add(this.f4516m);
        }
        if (this.f4517n != null) {
            objectArrayList.add(this.f4517n);
        }
        if (this.f4518o != null) {
            objectArrayList.add(this.f4518o);
        }
        if (!this.f4510aJ.isEmpty()) {
            objectArrayList.addAll(this.f4510aJ);
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: d */
    public void m3833d(@NotNull Player player) {
        Iterator it = player.getInventory().items.iterator();
        while (it.hasNext()) {
            m3815e(((ItemStack) it.next()).copy());
        }
    }

    /* JADX INFO: renamed from: b */
    public C0837pB m3834b() {
        C0837pB c0837pB = new C0837pB();
        Iterator<ItemStack> it = m3832I().iterator();
        while (it.hasNext()) {
            c0837pB.m3815e(it.next().copy());
        }
        return c0837pB;
    }
}
