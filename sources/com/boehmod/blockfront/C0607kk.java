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

/* JADX INFO: renamed from: com.boehmod.blockfront.kk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kk.class */
public class C0607kk {

    /* JADX INFO: renamed from: b */
    private static C0607kk f3515b;

    /* JADX INFO: renamed from: w */
    @NotNull
    private final Map<Class<? extends InterfaceC0613kq>, C0605ki<? extends InterfaceC0613kq>> f3516w;

    /* JADX INFO: renamed from: me */
    private int f3517me = 0;

    /* JADX INFO: renamed from: b */
    @Nullable
    private RunnableC0603kg f3518b;

    /* JADX INFO: renamed from: dW */
    private final boolean f3519dW;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AbstractC0531jN<?, ?, ?> f3520d;

    public C0607kk(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, boolean z) {
        f3515b = this;
        this.f3520d = abstractC0531jN;
        this.f3519dW = z;
        this.f3516w = new Object2ObjectOpenHashMap();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static C0607kk m2734c() {
        return f3515b;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public RunnableC0603kg m2735a() {
        return this.f3518b;
    }

    public void init() {
    }

    /* JADX INFO: renamed from: a */
    public <T extends InterfaceC0613kq> void m2736a(@NotNull Class<T> cls, @NotNull String str, @NotNull Supplier<AbstractC0571kA<T>> supplier) {
        C0530jM.log("[Asset Store] Registering new asset type '%s'", str);
        if (!this.f3516w.containsKey(cls)) {
            this.f3516w.put(cls, new C0605ki<>(this.f3520d, this, str, supplier.get()));
        }
    }

    /* JADX INFO: renamed from: a */
    public <T extends InterfaceC0613kq> C0605ki<T> m2737a(@NotNull Class<T> cls) {
        return (C0605ki) this.f3516w.get(cls);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public <T extends InterfaceC0613kq> C0605ki<T> m2738a(@NotNull String str) {
        Iterator<C0605ki<? extends InterfaceC0613kq>> it = this.f3516w.values().iterator();
        while (it.hasNext()) {
            C0605ki<T> c0605ki = (C0605ki) it.next();
            if (c0605ki.m2719E().equalsIgnoreCase(str)) {
                return c0605ki;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m2739a(@NotNull CommandSource commandSource) {
        Iterator<C0605ki<? extends InterfaceC0613kq>> it = this.f3516w.values().iterator();
        while (it.hasNext()) {
            it.next().m2703a(commandSource);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2740b(@Nullable CommandSource commandSource) throws Exception {
        C0530jM.log("[Asset Store] Saving all assets for %d asset types", Integer.valueOf(this.f3516w.size()));
        try {
            for (C0605ki<? extends InterfaceC0613kq> c0605ki : this.f3516w.values()) {
                C0530jM.log("[Asset Store] Saving all assets for asset type '%s' ('%s')", c0605ki.m2719E(), c0605ki.m2718D());
                c0605ki.m2709b(commandSource);
                c0605ki.m2715bx();
            }
        } catch (Exception e) {
            C0530jM.m2338a("[Asset Store] An error occurred while saving all assets.", e, new Object[0]);
            if (commandSource != null) {
                C0721ms.m3328a(commandSource, (Component) Component.translatable("bf.message.command.assets.saveall.error", new Object[]{Component.literal(e.getMessage()).withStyle(ChatFormatting.GRAY)}));
            }
            throw e;
        }
    }

    /* JADX INFO: renamed from: aC */
    public int m2741aC() {
        return this.f3516w.values().stream().mapToInt(c0605ki -> {
            return c0605ki.m2720d().size();
        }).sum();
    }

    /* JADX INFO: renamed from: aD */
    public int m2742aD() {
        return this.f3516w.size();
    }

    /* JADX INFO: renamed from: by */
    public void m2743by() {
        this.f3517me++;
        Iterator<C0605ki<? extends InterfaceC0613kq>> it = this.f3516w.values().iterator();
        while (it.hasNext()) {
            it.next().m2702bv();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0605ki<? extends InterfaceC0613kq> m2744b(@NotNull String str) {
        C0605ki<? extends InterfaceC0613kq> c0605kiM2738a = m2738a(str);
        if (c0605kiM2738a == null) {
            return null;
        }
        this.f3517me++;
        c0605kiM2738a.m2702bv();
        return c0605kiM2738a;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Set<String> m2745d() {
        return (Set) this.f3516w.values().stream().map((v0) -> {
            return v0.m2719E();
        }).collect(Collectors.toSet());
    }

    /* JADX INFO: renamed from: aE */
    public int m2746aE() {
        return this.f3517me;
    }

    @NotNull
    /* JADX INFO: renamed from: F */
    public String m2747F() {
        return C0030a.f263a.toLowerCase(Locale.ROOT) + "/assets/" + (this.f3519dW ? "client" : "server");
    }

    /* JADX INFO: renamed from: ae */
    public boolean m2748ae() {
        return this.f3519dW;
    }
}
