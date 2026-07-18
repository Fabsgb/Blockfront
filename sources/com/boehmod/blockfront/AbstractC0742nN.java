package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.nN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nN.class */
public abstract class AbstractC0742nN<V extends AbstractC0779ny> {

    /* JADX INFO: renamed from: bD */
    public final String f4006bD;

    /* JADX INFO: renamed from: mm */
    public int f4007mm = -1;

    /* JADX INFO: renamed from: b */
    public IntList f4008b = new IntArrayList();

    /* JADX INFO: renamed from: e */
    public Vector3f f4009e = new Vector3f(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: a */
    public V f4010a;

    /* JADX INFO: renamed from: c */
    public abstract void mo3407c(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: f */
    public abstract void mo3406f(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: y */
    public abstract void mo3396y(@NotNull Minecraft minecraft);

    @NotNull
    /* JADX INFO: renamed from: x */
    public abstract ResourceLocation mo3397x();

    public AbstractC0742nN(@NotNull String str, @NotNull V v) {
        this.f4006bD = str;
        this.f4010a = v;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0742nN<V> mo3383a(int i) {
        this.f4007mm = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC0742nN<V> m3408b(int i) {
        this.f4008b.add(i);
        return this;
    }

    /* JADX INFO: renamed from: aE */
    public float m3409aE() {
        return mo3398w(1.0f);
    }

    /* JADX INFO: renamed from: w */
    public float mo3398w(float f) {
        return 0.0f;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public Entity m3410b() {
        List passengers = this.f4010a.getPassengers();
        if (!passengers.isEmpty() && this.f4007mm > -1 && this.f4007mm < passengers.size()) {
            return (Entity) passengers.get(this.f4007mm);
        }
        return null;
    }
}
