package com.boehmod.blockfront;

import com.boehmod.blockfront.C0940r;
import java.util.Collections;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.u */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/u.class */
public final class C1100u implements InterfaceC1305z<C0940r> {

    /* JADX INFO: renamed from: w */
    public static final int f5782w = 5;

    @Override // com.boehmod.blockfront.InterfaceC1305z
    /* JADX INFO: renamed from: a */
    public boolean mo6058a(@NotNull Minecraft minecraft, @NotNull C0940r c0940r) {
        if (Collections.unmodifiableList(ModList.get().getMods()).size() != 5) {
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1305z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0940r.a mo6057a() {
        return C0940r.a.STARTUP;
    }
}
