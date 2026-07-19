package com.boehmod.blockfront;

import com.boehmod.blockfront.C0459r;
import java.util.Collections;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/u.class */
public final class C0540u implements InterfaceC0641z<C0459r> {
    public static final int w = 5;

    @Override // com.boehmod.blockfront.InterfaceC0641z
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0459r c0459r) {
        if (Collections.unmodifiableList(ModList.get().getMods()).size() != 5) {
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0641z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0459r.a mo1294a() {
        return C0459r.a.STARTUP;
    }
}
