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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jO.class */
public class jO {
    private static jO b;

    @NotNull
    private final Map<Class<? extends jU>, jM<? extends jU>> w;
    private int ki = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private jK f184b;
    private final boolean dD;

    @NotNull
    private final AbstractC0264ju<?, ?, ?> d;

    public jO(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, boolean z) {
        b = this;
        this.d = abstractC0264ju;
        this.dD = z;
        this.w = new Object2ObjectOpenHashMap();
    }

    @NotNull
    public static jO c() {
        return b;
    }

    @Nullable
    public jK a() {
        return this.f184b;
    }

    public void init() {
    }

    public <T extends jU> void a(@NotNull Class<T> cls, @NotNull String str, @NotNull Supplier<AbstractC0275ke<T>> supplier) {
        C0263jt.log("[Asset Store] Registering new asset type '%s'", str);
        if (!this.w.containsKey(cls)) {
            this.w.put(cls, new jM<>(this.d, this, str, supplier.get()));
        }
    }

    public <T extends jU> jM<T> a(@NotNull Class<T> cls) {
        return (jM) this.w.get(cls);
    }

    @Nullable
    public <T extends jU> jM<T> a(@NotNull String str) {
        Iterator<jM<? extends jU>> it = this.w.values().iterator();
        while (it.hasNext()) {
            jM<T> jMVar = (jM) it.next();
            if (jMVar.x().equalsIgnoreCase(str)) {
                return jMVar;
            }
        }
        return null;
    }

    public void a(@NotNull CommandSource commandSource) {
        Iterator<jM<? extends jU>> it = this.w.values().iterator();
        while (it.hasNext()) {
            it.next().a(commandSource);
        }
    }

    public void b(@Nullable CommandSource commandSource) throws Exception {
        C0263jt.log("[Asset Store] Saving all assets for %d asset types", Integer.valueOf(this.w.size()));
        try {
            for (jM<? extends jU> jMVar : this.w.values()) {
                C0263jt.log("[Asset Store] Saving all assets for asset type '%s' ('%s')", jMVar.x(), jMVar.w());
                jMVar.b(commandSource);
                jMVar.bm();
            }
        } catch (Exception e) {
            C0263jt.a("[Asset Store] An error occurred while saving all assets.", e, new Object[0]);
            if (commandSource != null) {
                lW.a(commandSource, (Component) Component.translatable("bf.message.command.assets.saveall.error", new Object[]{Component.literal(e.getMessage()).withStyle(ChatFormatting.GRAY)}));
            }
            throw e;
        }
    }

    public int an() {
        return this.w.values().stream().mapToInt(jMVar -> {
            return jMVar.d().size();
        }).sum();
    }

    public int ao() {
        return this.w.size();
    }

    public void bn() {
        this.ki++;
        Iterator<jM<? extends jU>> it = this.w.values().iterator();
        while (it.hasNext()) {
            it.next().bk();
        }
    }

    @Nullable
    public jM<? extends jU> b(@NotNull String str) {
        jM<? extends jU> jMVarA = a(str);
        if (jMVarA == null) {
            return null;
        }
        this.ki++;
        jMVarA.bk();
        return jMVarA;
    }

    @NotNull
    public Set<String> d() {
        return (Set) this.w.values().stream().map((v0) -> {
            return v0.x();
        }).collect(Collectors.toSet());
    }

    public int ap() {
        return this.ki;
    }

    @NotNull
    public String y() {
        return C0002a.a.toLowerCase(Locale.ROOT) + "/assets/" + (this.dD ? "client" : "server");
    }

    public boolean ab() {
        return this.dD;
    }
}
