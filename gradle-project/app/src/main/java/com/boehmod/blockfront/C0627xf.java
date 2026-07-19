package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xf.class */
public class C0627xf implements InterfaceC0625xd {

    @NotNull
    private final Level a;
    private final int tD;

    public C0627xf(@NotNull Level level, int i) {
        this.a = level;
        this.tD = i;
    }

    @Override // com.boehmod.blockfront.InterfaceC0625xd
    @NotNull
    public List<jG> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull AABB aabb, @Nullable LivingEntity livingEntity) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Entity entity : this.a.getEntities(livingEntity, aabb)) {
            if (entity instanceof LivingEntity) {
                objectArrayList.add(jG.a(abstractC0264ju, this.tD, entity, livingEntity));
            } else if (entity instanceof mA) {
                objectArrayList.add(jG.a(abstractC0264ju, this.tD, entity, livingEntity));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.InterfaceC0625xd
    @Nullable
    public jG a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, int i, @Nullable LivingEntity livingEntity) {
        Entity entity = this.a.getEntity(i);
        if ((entity instanceof LivingEntity) && entity.isAlive()) {
            return jG.a(abstractC0264ju, this.tD, entity, livingEntity);
        }
        return null;
    }
}
