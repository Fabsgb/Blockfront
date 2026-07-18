package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xf.class */
public class C1283xf implements InterfaceC1281xd {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Level f8619a;

    /* JADX INFO: renamed from: tD */
    private final int f8620tD;

    public C1283xf(@NotNull Level level, int i) {
        this.f8619a = level;
        this.f8620tD = i;
    }

    @Override // com.boehmod.blockfront.InterfaceC1281xd
    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0523jG> mo7802a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AABB aabb, @Nullable LivingEntity livingEntity) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Entity entity : this.f8619a.getEntities(livingEntity, aabb)) {
            if (entity instanceof LivingEntity) {
                objectArrayList.add(C0523jG.m2307a(abstractC0563ju, this.f8620tD, entity, livingEntity));
            } else if (entity instanceof AbstractC0676mA) {
                objectArrayList.add(C0523jG.m2307a(abstractC0563ju, this.f8620tD, entity, livingEntity));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.InterfaceC1281xd
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0523jG mo7803a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, int i, @Nullable LivingEntity livingEntity) {
        Entity entity = this.f8619a.getEntity(i);
        if ((entity instanceof LivingEntity) && entity.isAlive()) {
            return C0523jG.m2307a(abstractC0563ju, this.f8620tD, entity, livingEntity);
        }
        return null;
    }
}
