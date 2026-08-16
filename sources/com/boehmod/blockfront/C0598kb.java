package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kb.class */
public final class C0598kb extends Record {

    /* JADX INFO: renamed from: x */
    private final long f3393x;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ServerPlayer f3394a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1280xT f3395a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1328yo f3396a;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final ItemStack f3397d;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C1117uP f3398c;

    /* JADX INFO: renamed from: dM */
    private final boolean f3399dM;

    /* JADX INFO: renamed from: ac */
    @NotNull
    private final List<C1120uS> f3400ac;

    /* JADX INFO: renamed from: D */
    @NotNull
    private final Vec3 f3401D;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Vec2 f3402g;

    /* JADX INFO: renamed from: hM */
    private final float f3403hM;

    /* JADX INFO: renamed from: hN */
    private final float f3404hN;

    public C0598kb(long j, @NotNull ServerPlayer serverPlayer, @NotNull C1280xT c1280xT, @NotNull C1328yo c1328yo, @NotNull ItemStack itemStack, @NotNull C1117uP c1117uP, boolean z, @NotNull List<C1120uS> list, @NotNull Vec3 vec3, @NotNull Vec2 vec2, float f, float f2) {
        this.f3393x = j;
        this.f3394a = serverPlayer;
        this.f3395a = c1280xT;
        this.f3396a = c1328yo;
        this.f3397d = itemStack;
        this.f3398c = c1117uP;
        this.f3399dM = z;
        this.f3400ac = list;
        this.f3401D = vec3;
        this.f3402g = vec2;
        this.f3403hM = f;
        this.f3404hN = f2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0598kb.class), C0598kb.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;weaponStack;gunItem;skipSpread;pellets;position;direction;reportedItemSpread;shootBackPitch", "FIELD:Lcom/boehmod/blockfront/kb;->x:J", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lcom/boehmod/blockfront/xT;", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lcom/boehmod/blockfront/yo;", "FIELD:Lcom/boehmod/blockfront/kb;->d:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/kb;->c:Lcom/boehmod/blockfront/uP;", "FIELD:Lcom/boehmod/blockfront/kb;->dM:Z", "FIELD:Lcom/boehmod/blockfront/kb;->ac:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/kb;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/kb;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/kb;->hM:F", "FIELD:Lcom/boehmod/blockfront/kb;->hN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0598kb.class), C0598kb.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;weaponStack;gunItem;skipSpread;pellets;position;direction;reportedItemSpread;shootBackPitch", "FIELD:Lcom/boehmod/blockfront/kb;->x:J", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lcom/boehmod/blockfront/xT;", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lcom/boehmod/blockfront/yo;", "FIELD:Lcom/boehmod/blockfront/kb;->d:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/kb;->c:Lcom/boehmod/blockfront/uP;", "FIELD:Lcom/boehmod/blockfront/kb;->dM:Z", "FIELD:Lcom/boehmod/blockfront/kb;->ac:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/kb;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/kb;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/kb;->hM:F", "FIELD:Lcom/boehmod/blockfront/kb;->hN:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0598kb.class, Object.class), C0598kb.class, "shootTick;serverPlayer;serverModManager;playerDataHandler;weaponStack;gunItem;skipSpread;pellets;position;direction;reportedItemSpread;shootBackPitch", "FIELD:Lcom/boehmod/blockfront/kb;->x:J", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lnet/minecraft/server/level/ServerPlayer;", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lcom/boehmod/blockfront/xT;", "FIELD:Lcom/boehmod/blockfront/kb;->a:Lcom/boehmod/blockfront/yo;", "FIELD:Lcom/boehmod/blockfront/kb;->d:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lcom/boehmod/blockfront/kb;->c:Lcom/boehmod/blockfront/uP;", "FIELD:Lcom/boehmod/blockfront/kb;->dM:Z", "FIELD:Lcom/boehmod/blockfront/kb;->ac:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/kb;->D:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lcom/boehmod/blockfront/kb;->g:Lnet/minecraft/world/phys/Vec2;", "FIELD:Lcom/boehmod/blockfront/kb;->hM:F", "FIELD:Lcom/boehmod/blockfront/kb;->hN:F").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: g */
    public long m2622g() {
        return this.f3393x;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ServerPlayer m2623a() {
        return this.f3394a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1280xT m2624a() {
        return this.f3395a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1328yo m2625a() {
        return this.f3396a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public ItemStack m2626b() {
        return this.f3397d;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1117uP m2627b() {
        return this.f3398c;
    }

    /* JADX INFO: renamed from: al */
    public boolean m2628al() {
        return this.f3399dM;
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    public List<C1120uS> m2629r() {
        return this.f3400ac;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public Vec3 m2630h() {
        return this.f3401D;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vec2 m2631a() {
        return this.f3402g;
    }

    /* JADX INFO: renamed from: ae */
    public float m2632ae() {
        return this.f3403hM;
    }

    /* JADX INFO: renamed from: af */
    public float m2633af() {
        return this.f3404hN;
    }
}
