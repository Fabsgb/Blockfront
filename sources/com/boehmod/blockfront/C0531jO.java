package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.jO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jO.class */
public class C0531jO {

    /* JADX INFO: renamed from: b */
    private static C0531jO f3137b;

    /* JADX INFO: renamed from: w */
    @NotNull
    private final Map<Class<? extends InterfaceC0537jU>, C0529jM<? extends InterfaceC0537jU>> f3138w;

    /* JADX INFO: renamed from: ki */
    private int f3139ki = 0;

    /* JADX INFO: renamed from: b */
    @Nullable
    private RunnableC0527jK f3140b;

    /* JADX INFO: renamed from: dD */
    private final boolean f3141dD;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AbstractC0563ju<?, ?, ?> f3142d;

    public C0531jO(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, boolean z) {
        f3137b = this;
        this.f3142d = abstractC0563ju;
        this.f3141dD = z;
        this.f3138w = new Object2ObjectOpenHashMap();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static C0531jO m2372c() {
        return f3137b;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public RunnableC0527jK m2373a() {
        return this.f3140b;
    }

    public void init() {
    }

    /* JADX INFO: renamed from: a */
    public <T extends InterfaceC0537jU> void m2374a(@NotNull Class<T> cls, @NotNull String str, @NotNull Supplier<AbstractC0600ke<T>> supplier) {
        C0562jt.log("[Asset Store] Registering new asset type '%s'", str);
        if (!this.f3138w.containsKey(cls)) {
            this.f3138w.put(cls, new C0529jM<>(this.f3142d, this, str, supplier.get()));
        }
    }

    /* JADX INFO: renamed from: a */
    public <T extends InterfaceC0537jU> C0529jM<T> m2375a(@NotNull Class<T> cls) {
        return (C0529jM) this.f3138w.get(cls);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public <T extends InterfaceC0537jU> C0529jM<T> m2376a(@NotNull String str) {
        Iterator<C0529jM<? extends InterfaceC0537jU>> it = this.f3138w.values().iterator();
        while (it.hasNext()) {
            C0529jM<T> c0529jM = (C0529jM) it.next();
            if (c0529jM.m2357x().equalsIgnoreCase(str)) {
                return c0529jM;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m2377a(@NotNull CommandSource commandSource) {
        Iterator<C0529jM<? extends InterfaceC0537jU>> it = this.f3138w.values().iterator();
        while (it.hasNext()) {
            it.next().m2343a(commandSource);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2378b(@Nullable CommandSource commandSource) throws Exception {
        C0562jt.log("[Asset Store] Saving all assets for %d asset types", Integer.valueOf(this.f3138w.size()));
        try {
            for (C0529jM<? extends InterfaceC0537jU> c0529jM : this.f3138w.values()) {
                C0562jt.log("[Asset Store] Saving all assets for asset type '%s' ('%s')", c0529jM.m2357x(), c0529jM.m2356w());
                c0529jM.m2349b(commandSource);
                c0529jM.m2353bm();
            }
        } catch (Exception e) {
            C0562jt.m2516a("[Asset Store] An error occurred while saving all assets.", e, new Object[0]);
            if (commandSource != null) {
                C0645lW.m2897a(commandSource, (Component) Component.translatable("bf.message.command.assets.saveall.error", new Object[]{Component.literal(e.getMessage()).withStyle(ChatFormatting.GRAY)}));
            }
            throw e;
        }
    }

    /* JADX INFO: renamed from: an */
    public int m2379an() {
        return this.f3138w.values().stream().mapToInt(c0529jM -> {
            return c0529jM.m2358d().size();
        }).sum();
    }

    /* JADX INFO: renamed from: ao */
    public int m2380ao() {
        return this.f3138w.size();
    }

    /* JADX INFO: renamed from: bn */
    public void m2381bn() {
        this.f3139ki++;
        Iterator<C0529jM<? extends InterfaceC0537jU>> it = this.f3138w.values().iterator();
        while (it.hasNext()) {
            it.next().m2342bk();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0529jM<? extends InterfaceC0537jU> m2382b(@NotNull String str) {
        C0529jM<? extends InterfaceC0537jU> c0529jMM2376a = m2376a(str);
        if (c0529jMM2376a == null) {
            return null;
        }
        this.f3139ki++;
        c0529jMM2376a.m2342bk();
        return c0529jMM2376a;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Set<String> m2383d() {
        return (Set) this.f3138w.values().stream().map((v0) -> {
            return v0.m2357x();
        }).collect(Collectors.toSet());
    }

    /* JADX INFO: renamed from: ap */
    public int m2384ap() {
        return this.f3139ki;
    }

    @NotNull
    /* JADX INFO: renamed from: y */
    public String m2385y() {
        return C0029a.f246a.toLowerCase(Locale.ROOT) + "/assets/" + (this.f3141dD ? "client" : "server");
    }

    /* JADX INFO: renamed from: ab */
    public boolean m2386ab() {
        return this.f3141dD;
    }
}
