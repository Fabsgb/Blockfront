package com.boehmod.blockfront;

import com.boehmod.blockfront.oI;
import com.boehmod.blockfront.oV;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qN.class */
public interface qN<P extends oI<?>, C extends oV<P>> {
    int a(@NotNull C c);

    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull Level level, @NotNull C c, @NotNull String str, @NotNull String str2, @NotNull Set<UUID> set);

    List<C> O();
}
