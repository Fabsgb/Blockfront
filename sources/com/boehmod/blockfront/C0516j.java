package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.j */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/j.class */
public class C0516j {

    /* JADX INFO: renamed from: a */
    private final C0622l f3053a;

    /* JADX INFO: renamed from: a */
    private final ObjectList<C0026X> f3054a = new ObjectArrayList();

    public C0516j(@NotNull C0622l c0622l) {
        this.f3053a = c0622l;
    }

    /* JADX INFO: renamed from: a */
    public void m2270a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel) {
        if (clientLevel == null) {
            return;
        }
        this.f3054a.removeIf(c0026x -> {
            return !c0026x.mo162a(minecraft, this.f3053a, clientLevel);
        });
    }

    /* JADX INFO: renamed from: a */
    public void m2271a(@NotNull Minecraft minecraft) {
        this.f3054a.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m2272a(C0026X c0026x) {
        this.f3054a.add(c0026x);
    }
}
