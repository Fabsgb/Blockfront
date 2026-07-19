package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/j.class */
public class C0243j {
    private final C0297l a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ObjectList<X> f175a = new ObjectArrayList();

    public C0243j(@NotNull C0297l c0297l) {
        this.a = c0297l;
    }

    public void a(@NotNull Minecraft minecraft, @Nullable ClientLevel clientLevel) {
        if (clientLevel == null) {
            return;
        }
        this.f175a.removeIf(x -> {
            return !x.a(minecraft, this.a, clientLevel);
        });
    }

    public void a(@NotNull Minecraft minecraft) {
        this.f175a.clear();
    }

    public void a(X x) {
        this.f175a.add(x);
    }
}
