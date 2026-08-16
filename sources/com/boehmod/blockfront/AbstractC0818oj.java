package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oj.class */
public abstract class AbstractC0818oj<V extends AbstractC0750nU> {

    /* JADX INFO: renamed from: bM */
    public final String f4434bM;

    /* JADX INFO: renamed from: ok */
    public int f4435ok = -1;

    /* JADX INFO: renamed from: b */
    public IntList f4436b = new IntArrayList();

    /* JADX INFO: renamed from: e */
    public Vector3f f4437e = new Vector3f(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: a */
    public V f4438a;

    /* JADX INFO: renamed from: c */
    public abstract void mo3779c(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: f */
    public abstract void mo3778f(@NotNull V v);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: A */
    public abstract void mo3768A(@NotNull Minecraft minecraft);

    @NotNull
    /* JADX INFO: renamed from: y */
    public abstract ResourceLocation mo3769y();

    public AbstractC0818oj(@NotNull String str, @NotNull V v) {
        this.f4434bM = str;
        this.f4438a = v;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0818oj<V> mo3755a(int i) {
        this.f4435ok = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC0818oj<V> m3780b(int i) {
        this.f4436b.add(i);
        return this;
    }

    /* JADX INFO: renamed from: aK */
    public float m3781aK() {
        return mo3770z(1.0f);
    }

    /* JADX INFO: renamed from: z */
    public float mo3770z(float f) {
        return 0.0f;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public Entity m3782b() {
        List passengers = this.f4438a.getPassengers();
        if (!passengers.isEmpty() && this.f4435ok > -1 && this.f4435ok < passengers.size()) {
            return (Entity) passengers.get(this.f4435ok);
        }
        return null;
    }
}
