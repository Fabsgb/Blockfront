package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.j */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/j.class */
public class C0517j {

    /* JADX INFO: renamed from: a */
    private final C0623l f3154a;

    /* JADX INFO: renamed from: a */
    private final ObjectList<C0060ad> f3155a = new ObjectArrayList();

    public C0517j(@NotNull C0623l c0623l) {
        this.f3154a = c0623l;
    }

    /* JADX INFO: renamed from: a */
    public void m2295a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel) {
        if (clientLevel == null) {
            return;
        }
        this.f3155a.removeIf(c0060ad -> {
            return !c0060ad.mo276a(minecraft, this.f3154a, clientLevel);
        });
    }

    /* JADX INFO: renamed from: a */
    public void m2296a(@NotNull Minecraft minecraft) {
        this.f3155a.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m2297a(C0060ad c0060ad) {
        this.f3155a.add(c0060ad);
    }
}
