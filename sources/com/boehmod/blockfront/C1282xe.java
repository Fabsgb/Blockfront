package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xe */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xe.class */
public class C1282xe implements InterfaceC1281xd {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C1284xg f8616d;

    /* JADX INFO: renamed from: E */
    private final long f8617E;

    /* JADX INFO: renamed from: tC */
    private final int f8618tC;

    public C1282xe(@NotNull C1284xg c1284xg, long j, int i) {
        this.f8616d = c1284xg;
        this.f8617E = j;
        this.f8618tC = i;
    }

    @Override // com.boehmod.blockfront.InterfaceC1281xd
    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0523jG> mo7802a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AABB aabb, @Nullable LivingEntity livingEntity) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        long j = this.f8617E - ((long) this.f8618tC);
        while (true) {
            long j2 = j;
            if (j2 <= this.f8617E + ((long) this.f8618tC)) {
                if (!this.f8616d.m7810b(j2)) {
                    for (C0523jG c0523jG : this.f8616d.m7815a(j2)) {
                        if (livingEntity == null || c0523jG.m2299al() != livingEntity.getId()) {
                            if (c0523jG.m2305af() && c0523jG.m2301g().intersects(aabb)) {
                                objectArrayList.add(c0523jG);
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

    @Override // com.boehmod.blockfront.InterfaceC1281xd
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0523jG mo7803a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, int i, @Nullable LivingEntity livingEntity) {
        return this.f8616d.m7809a(this.f8617E, i, this.f8618tC);
    }
}
