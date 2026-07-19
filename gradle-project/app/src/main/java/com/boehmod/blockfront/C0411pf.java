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

/* JADX INFO: renamed from: com.boehmod.blockfront.pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pf.class */
public final class C0411pf {

    @NotNull
    public static final Codec<C0411pf> w = RecordCodecBuilder.create(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("items", List.of()).forGetter(c0411pf -> {
            return c0411pf.G().stream().filter(itemStack -> {
                return !itemStack.isEmpty();
            }).toList();
        }), Codec.INT.optionalFieldOf("cost", 0).forGetter((v0) -> {
            return v0.bk();
        }), Codec.INT.optionalFieldOf("exp", 0).forGetter((v0) -> {
            return v0.bl();
        }), Codec.STRING.optionalFieldOf("template").forGetter(c0411pf2 -> {
            return Optional.ofNullable(c0411pf2.A());
        })).apply(instance, (list, num, num2, optional) -> {
            C0411pf c0411pf3 = new C0411pf();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0411pf3.e(((ItemStack) it.next()).copy());
            }
            c0411pf3.a(num.intValue());
            c0411pf3.b(num2.intValue());
            Objects.requireNonNull(c0411pf3);
            optional.ifPresent(c0411pf3::a);
            return c0411pf3;
        });
    });
    public static final int nE = 4;

    @NotNull
    private final List<ItemStack> aC;

    @Nullable
    private ItemStack f;

    @Nullable
    private ItemStack g;
    private ItemStack h;
    private ItemStack i;

    @Nullable
    private ItemStack j;

    @Nullable
    private ItemStack k;

    @Nullable
    private ItemStack l;

    @Nullable
    private ItemStack m;
    private int ns;
    private int nt;

    @Nullable
    private String N;

    public C0411pf() {
        this.aC = new ObjectArrayList();
        this.ns = 0;
        this.nt = 0;
    }

    public C0411pf(@Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, ItemStack itemStack3, ItemStack itemStack4, @Nullable ItemStack itemStack5, @Nullable ItemStack itemStack6, @Nullable ItemStack itemStack7, @Nullable ItemStack itemStack8) {
        this.aC = new ObjectArrayList();
        this.ns = 0;
        this.nt = 0;
        this.f = itemStack;
        this.g = itemStack2;
        this.h = itemStack3;
        this.i = itemStack4;
        this.j = itemStack5;
        this.k = itemStack6;
        this.l = itemStack7;
        this.m = itemStack8;
    }

    public C0411pf(@Nullable ItemStack itemStack, @Nullable ItemStack itemStack2, @Nullable ItemStack itemStack3) {
        this(itemStack, itemStack2, itemStack3, null, null, null, null, null);
    }

    public static C0411pf a(@NotNull ServerPlayer serverPlayer) {
        C0411pf c0411pf = new C0411pf();
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (itemStack != null && !itemStack.isEmpty()) {
                c0411pf.e(itemStack.copy());
            }
        }
        return c0411pf;
    }

    public C0411pf a(@NotNull ItemStack itemStack) {
        this.aC.add(itemStack);
        return this;
    }

    public C0411pf a(@NotNull Collection<ItemStack> collection) {
        this.aC.addAll(collection);
        return this;
    }

    public C0411pf b(@NotNull ItemStack itemStack) {
        this.k = itemStack;
        return this;
    }

    public void e(@NotNull ItemStack itemStack) {
        ShieldItem item = itemStack.getItem();
        Objects.requireNonNull(item);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0558ur.class, tI.class, ShieldItem.class, ArmorItem.class, tW.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
            case 0:
                if (this.f == null) {
                    this.f = itemStack;
                } else {
                    this.g = itemStack;
                }
                break;
            case 1:
                this.h = itemStack;
                break;
            case 2:
                this.i = itemStack;
                break;
            case 3:
                switch (AnonymousClass1.r[((ArmorItem) item).getType().getSlot().ordinal()]) {
                    case 1:
                        this.j = itemStack;
                        break;
                    case 2:
                        this.k = itemStack;
                        break;
                    case 3:
                        this.l = itemStack;
                        break;
                    case 4:
                        this.m = itemStack;
                        break;
                }
                break;
            case 4:
                this.aC.add(itemStack);
                if (this.aC.size() > 4) {
                    this.aC.removeFirst();
                }
                break;
            default:
                C0263jt.logError("LoadOut does not know how to handle item: %s", BuiltInRegistries.ITEM.getKey(itemStack.getItem()));
                break;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pf$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pf$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] r = new int[EquipmentSlot.values().length];

        static {
            try {
                r[EquipmentSlot.HEAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                r[EquipmentSlot.CHEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                r[EquipmentSlot.LEGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                r[EquipmentSlot.FEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public int bk() {
        return this.ns;
    }

    public C0411pf a(int i) {
        this.ns = i;
        return this;
    }

    public int bl() {
        return this.nt;
    }

    public C0411pf b(int i) {
        this.nt = i;
        return this;
    }

    @Nullable
    public String A() {
        return this.N;
    }

    public C0411pf a(@Nullable String str) {
        this.N = str;
        return this;
    }

    public boolean bv() {
        return !G().isEmpty();
    }

    @NotNull
    public List<ItemStack> F() {
        return Collections.unmodifiableList(this.aC);
    }

    public ItemStack c() {
        return this.f != null ? this.f : ItemStack.EMPTY;
    }

    public ItemStack d() {
        return this.g != null ? this.g : ItemStack.EMPTY;
    }

    public ItemStack e() {
        return this.h != null ? this.h : ItemStack.EMPTY;
    }

    public ItemStack f() {
        return this.i != null ? this.i : ItemStack.EMPTY;
    }

    public ItemStack g() {
        return this.j != null ? this.j : ItemStack.EMPTY;
    }

    public ItemStack h() {
        return this.k != null ? this.k : ItemStack.EMPTY;
    }

    public ItemStack i() {
        return this.l != null ? this.l : ItemStack.EMPTY;
    }

    public ItemStack j() {
        return this.m != null ? this.m : ItemStack.EMPTY;
    }

    public List<ItemStack> G() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f != null) {
            objectArrayList.add(this.f);
        }
        if (this.g != null) {
            objectArrayList.add(this.g);
        }
        if (this.h != null) {
            objectArrayList.add(this.h);
        }
        if (this.i != null) {
            objectArrayList.add(this.i);
        }
        if (this.j != null) {
            objectArrayList.add(this.j);
        }
        if (this.k != null) {
            objectArrayList.add(this.k);
        }
        if (this.l != null) {
            objectArrayList.add(this.l);
        }
        if (this.m != null) {
            objectArrayList.add(this.m);
        }
        if (!this.aC.isEmpty()) {
            objectArrayList.addAll(this.aC);
        }
        return objectArrayList;
    }

    public void d(@NotNull Player player) {
        Iterator it = player.getInventory().items.iterator();
        while (it.hasNext()) {
            e(((ItemStack) it.next()).copy());
        }
    }

    public C0411pf b() {
        C0411pf c0411pf = new C0411pf();
        Iterator<ItemStack> it = G().iterator();
        while (it.hasNext()) {
            c0411pf.e(it.next().copy());
        }
        return c0411pf;
    }
}
