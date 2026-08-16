package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xB.class */
public class C1262xB implements InterfaceC1261xA {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C1264xD f6806e;

    /* JADX INFO: renamed from: Z */
    private final long f6807Z;

    /* JADX INFO: renamed from: vG */
    private final int f6808vG;

    public C1262xB(@NotNull C1264xD c1264xD, long j, int i) {
        this.f6806e = c1264xD;
        this.f6807Z = j;
        this.f6808vG = i;
    }

    @Override // com.boehmod.blockfront.InterfaceC1261xA
    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0543jZ> mo7124a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AABB aabb, @Nullable LivingEntity livingEntity) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        long j = this.f6807Z - ((long) this.f6808vG);
        while (true) {
            long j2 = j;
            if (j2 <= this.f6807Z + ((long) this.f6808vG)) {
                if (!this.f6806e.m7133f(j2)) {
                    for (C0543jZ c0543jZ : this.f6806e.m7138a(j2)) {
                        if (livingEntity == null || c0543jZ.m2445aB() != livingEntity.getId()) {
                            if (c0543jZ.m2451aj() && c0543jZ.m2447g().intersects(aabb)) {
                                objectArrayList.add(c0543jZ);
                            }
                        }
                    }
                }
                j = j2 + 1;
            } else {
                return objectArrayList;
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC1261xA
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0543jZ mo7125a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, int i, @Nullable LivingEntity livingEntity) {
        return this.f6806e.m7132a(this.f6807Z, i, this.f6808vG);
    }
}
