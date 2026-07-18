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

/* JADX INFO: renamed from: com.boehmod.blockfront.pf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pf.class */
public final class C0866pf {

    /* JADX INFO: renamed from: w */
    @NotNull
    public static final Codec<C0866pf> f4539w = RecordCodecBuilder.create(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("items", List.of()).forGetter(c0866pf -> {
            return c0866pf.m4347G().stream().filter(itemStack -> {
                return !itemStack.isEmpty();
            }).toList();
        }), Codec.INT.optionalFieldOf("cost", 0).forGetter((v0) -> {
            return v0.m4331bk();
        }), Codec.INT.optionalFieldOf("exp", 0).forGetter((v0) -> {
            return v0.m4333bl();
        }), Codec.STRING.optionalFieldOf("template").forGetter(c0866pf2 -> {
            return Optional.ofNullable(c0866pf2.m4335A());
        })).apply(instance, (list, num, num2, optional) -> {
            C0866pf c0866pf3 = new C0866pf();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0866pf3.m4330e(((ItemStack) it.next()).copy());
            }
            c0866pf3.m4332a(num.intValue());
            c0866pf3.m4334b(num2.intValue());
            Objects.requireNonNull(c0866pf3);
            optional.ifPresent(c0866pf3::m4336a);
            return c0866pf3;
        });
    });

    /* JADX INFO: renamed from: nE */
    public static final int f4540nE = 4;

    /* JADX INFO: renamed from: aC */
    @NotNull
    private final List<ItemStack> f4541aC;

    /* JADX INFO: renamed from: f */
    @Nullable
    private ItemStack f4542f;

    /* JADX INFO: renamed from: g */
    @Nullable
    private ItemStack f4543g;

    /* JADX INFO: renamed from: h */
    private ItemStack f4544h;

    /* JADX INFO: renamed from: i */
    private ItemStack f4545i;

    /* JADX INFO: renamed from: j */
    @Nullable
    private ItemStack f4546j;

    /* JADX INFO: renamed from: k */
    @Nullable
    private ItemStack f4547k;

    /* JADX INFO: renamed from: l */
    @Nullable
    private ItemStack f4548l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private ItemStack f4549m;

    /* JADX INFO: renamed from: ns */
    private int f4550ns;

    /* JADX INFO: renamed from: nt */
    private int f4551nt;

    /* JADX INFO: renamed from: N */
    @Nullable
    private String f4552N;

    public C0866pf() {
        this.f4541aC = new ObjectArrayList();
        this.f4550ns = 0;
        this.f4551nt = 0;
    }

    public C0866pf(@Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, ItemStack itemStack3, ItemStack itemStack4, @Nullable ItemStack itemStack5, @Nullable ItemStack itemStack6, @Nullable ItemStack itemStack7, @Nullable ItemStack itemStack8) {
        this.f4541aC = new ObjectArrayList();
        this.f4550ns = 0;
        this.f4551nt = 0;
        this.f4542f = itemStack;
        this.f4543g = itemStack2;
        this.f4544h = itemStack3;
        this.f4545i = itemStack4;
        this.f4546j = itemStack5;
        this.f4547k = itemStack6;
        this.f4548l = itemStack7;
        this.f4549m = itemStack8;
    }

    public C0866pf(@Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, @Nullable ItemStack itemStack3) {
        this(itemStack, itemStack2, itemStack3, null, null, null, null, null);
    }

    /* JADX INFO: renamed from: a */
    public static C0866pf m4326a(@NotNull ServerPlayer serverPlayer) {
        C0866pf c0866pf = new C0866pf();
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (itemStack != null && !itemStack.isEmpty()) {
                c0866pf.m4330e(itemStack.copy());
            }
        }
        return c0866pf;
    }

    /* JADX INFO: renamed from: a */
    public C0866pf m4327a(@NotNull ItemStack itemStack) {
        this.f4541aC.add(itemStack);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0866pf m4328a(@NotNull Collection<ItemStack> collection) {
        this.f4541aC.addAll(collection);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0866pf m4329b(@NotNull ItemStack itemStack) {
        this.f4547k = itemStack;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public void m4330e(@NotNull ItemStack itemStack) {
        ShieldItem item = itemStack.getItem();
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1144ur.class, C1056tI.class, ShieldItem.class, ArmorItem.class, InterfaceC1070tW.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                if (this.f4542f == null) {
                    this.f4542f = itemStack;
                } else {
                    this.f4543g = itemStack;
                }
                break;
            case 1:
                this.f4544h = itemStack;
                break;
            case 2:
                this.f4545i = itemStack;
                break;
            case 3:
                switch (AnonymousClass1.f4553r[((ArmorItem) item).getType().getSlot().ordinal()]) {
                    case 1:
                        this.f4546j = itemStack;
                        break;
                    case 2:
                        this.f4547k = itemStack;
                        break;
                    case 3:
                        this.f4548l = itemStack;
                        break;
                    case 4:
                        this.f4549m = itemStack;
                        break;
                }
                break;
            case 4:
                this.f4541aC.add(itemStack);
                if (this.f4541aC.size() > 4) {
                    this.f4541aC.removeFirst();
                }
                break;
            default:
                C0562jt.logError("LoadOut does not know how to handle item: %s", BuiltInRegistries.ITEM.getKey(itemStack.getItem()));
                break;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pf$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pf$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: r */
        static final /* synthetic */ int[] f4553r = new int[EquipmentSlot.values().length];

        static {
            try {
                f4553r[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4553r[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4553r[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4553r[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: renamed from: bk */
    public int m4331bk() {
        return this.f4550ns;
    }

    /* JADX INFO: renamed from: a */
    public C0866pf m4332a(int i) {
        this.f4550ns = i;
        return this;
    }

    /* JADX INFO: renamed from: bl */
    public int m4333bl() {
        return this.f4551nt;
    }

    /* JADX INFO: renamed from: b */
    public C0866pf m4334b(int i) {
        this.f4551nt = i;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: A */
    public String m4335A() {
        return this.f4552N;
    }

    /* JADX INFO: renamed from: a */
    public C0866pf m4336a(@Nullable String str) {
        this.f4552N = str;
        return this;
    }

    /* JADX INFO: renamed from: bv */
    public boolean m4337bv() {
        return !m4347G().isEmpty();
    }

    @NotNull
    /* JADX INFO: renamed from: F */
    public List<ItemStack> m4338F() {
        return Collections.unmodifiableList(this.f4541aC);
    }

    /* JADX INFO: renamed from: c */
    public ItemStack m4339c() {
        return this.f4542f != null ? this.f4542f : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: d */
    public ItemStack m4340d() {
        return this.f4543g != null ? this.f4543g : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: e */
    public ItemStack m4341e() {
        return this.f4544h != null ? this.f4544h : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: f */
    public ItemStack m4342f() {
        return this.f4545i != null ? this.f4545i : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: g */
    public ItemStack m4343g() {
        return this.f4546j != null ? this.f4546j : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: h */
    public ItemStack m4344h() {
        return this.f4547k != null ? this.f4547k : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: i */
    public ItemStack m4345i() {
        return this.f4548l != null ? this.f4548l : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: j */
    public ItemStack m4346j() {
        return this.f4549m != null ? this.f4549m : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: G */
    public List<ItemStack> m4347G() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f4542f != null) {
            objectArrayList.add(this.f4542f);
        }
        if (this.f4543g != null) {
            objectArrayList.add(this.f4543g);
        }
        if (this.f4544h != null) {
            objectArrayList.add(this.f4544h);
        }
        if (this.f4545i != null) {
            objectArrayList.add(this.f4545i);
        }
        if (this.f4546j != null) {
            objectArrayList.add(this.f4546j);
        }
        if (this.f4547k != null) {
            objectArrayList.add(this.f4547k);
        }
        if (this.f4548l != null) {
            objectArrayList.add(this.f4548l);
        }
        if (this.f4549m != null) {
            objectArrayList.add(this.f4549m);
        }
        if (!this.f4541aC.isEmpty()) {
            objectArrayList.addAll(this.f4541aC);
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: d */
    public void m4348d(@NotNull Player player) {
        Iterator it = player.getInventory().items.iterator();
        while (it.hasNext()) {
            m4330e(((ItemStack) it.next()).copy());
        }
    }

    /* JADX INFO: renamed from: b */
    public C0866pf m4349b() {
        C0866pf c0866pf = new C0866pf();
        Iterator<ItemStack> it = m4347G().iterator();
        while (it.hasNext()) {
            c0866pf.m4330e(it.next().copy());
        }
        return c0866pf;
    }
}
