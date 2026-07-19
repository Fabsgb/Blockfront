package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xe.class */
public class C0626xe implements InterfaceC0625xd {

    @NotNull
    private final C0628xg d;
    private final long E;
    private final int tC;

    public C0626xe(@NotNull C0628xg c0628xg, long j, int i) {
        this.d = c0628xg;
        this.E = j;
        this.tC = i;
    }

    @Override // com.boehmod.blockfront.InterfaceC0625xd
    @NotNull
    public List<jG> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull AABB aabb, @Nullable LivingEntity livingEntity) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        long j = this.E - ((long) this.tC);
        while (true) {
            long j2 = j;
            if (j2 <= this.E + ((long) this.tC)) {
                if (!this.d.b(j2)) {
                    for (jG jGVar : this.d.a(j2)) {
                        if (livingEntity == null || jGVar.al() != livingEntity.getId()) {
                            if (jGVar.af() && jGVar.m513g().intersects(aabb)) {
                                objectArrayList.add(jGVar);
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

    @Override // com.boehmod.blockfront.InterfaceC0625xd
    @Nullable
    public jG a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, int i, @Nullable LivingEntity livingEntity) {
        return this.d.a(this.E, i, this.tC);
    }
}
