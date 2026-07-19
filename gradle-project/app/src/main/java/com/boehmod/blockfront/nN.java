package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nN.class */
public abstract class nN<V extends AbstractC0376ny> {
    public final String bD;
    public int mm = -1;
    public IntList b = new IntArrayList();
    public Vector3f e = new Vector3f(0.0f, 0.0f, 0.0f);
    public V a;

    public abstract void c(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    public abstract void f(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    public abstract void y(@NotNull Minecraft minecraft);

    @NotNull
    public abstract ResourceLocation x();

    public nN(@NotNull String str, @NotNull V v) {
        this.bD = str;
        this.a = v;
    }

    public nN<V> a(int i) {
        this.mm = i;
        return this;
    }

    public nN<V> b(int i) {
        this.b.add(i);
        return this;
    }

    public float aE() {
        return w(1.0f);
    }

    public float w(float f) {
        return 0.0f;
    }

    @Nullable
    public Entity b() {
        List passengers = this.a.getPassengers();
        if (!passengers.isEmpty() && this.mm > -1 && this.mm < passengers.size()) {
            return (Entity) passengers.get(this.mm);
        }
        return null;
    }
}
