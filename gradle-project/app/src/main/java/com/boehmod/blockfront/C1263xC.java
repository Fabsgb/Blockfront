package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xC.class */
public class C1263xC implements InterfaceC1261xA {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Level f6809a;

    /* JADX INFO: renamed from: vH */
    private final int f6810vH;

    public C1263xC(@NotNull Level level, int i) {
        this.f6809a = level;
        this.f6810vH = i;
    }

    @Override // com.boehmod.blockfront.InterfaceC1261xA
    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0543jZ> mo7124a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AABB aabb, @Nullable LivingEntity livingEntity) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Entity entity : this.f6809a.getEntities(livingEntity, aabb)) {
            if (entity instanceof LivingEntity) {
                objectArrayList.add(C0543jZ.m2453a(abstractC0531jN, this.f6810vH, entity, livingEntity));
            } else if (entity instanceof AbstractC0699mW) {
                objectArrayList.add(C0543jZ.m2453a(abstractC0531jN, this.f6810vH, entity, livingEntity));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.InterfaceC1261xA
    @Nullable
    /* JADX INFO: renamed from: a */
    public C0543jZ mo7125a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, int i, @Nullable LivingEntity livingEntity) {
        Entity entity = this.f6809a.getEntity(i);
        if ((entity instanceof LivingEntity) && entity.isAlive()) {
            return C0543jZ.m2453a(abstractC0531jN, this.f6810vH, entity, livingEntity);
        }
        return null;
    }
}
