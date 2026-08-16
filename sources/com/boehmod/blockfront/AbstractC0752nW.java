package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nW.class */
public abstract class AbstractC0752nW extends AbstractC0750nU {

    /* JADX INFO: renamed from: ao */
    private static final List<a> f4151ao = new ObjectArrayList<a>() { // from class: com.boehmod.blockfront.nW.1
        {
            for (int i = 0; i < 5; i++) {
                add(new a());
            }
        }
    };

    /* JADX INFO: renamed from: fE */
    public static boolean f4152fE = false;

    /* JADX INFO: renamed from: od */
    public int f4153od;

    /* JADX INFO: renamed from: fF */
    private boolean f4154fF;

    /* JADX INFO: renamed from: fG */
    private boolean f4155fG;

    /* JADX INFO: renamed from: fH */
    private boolean f4156fH;

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: a */
    public abstract C0819ok mo3433a();

    public AbstractC0752nW(EntityType<? extends AbstractC0752nW> entityType, Level level, BlockEntityType<? extends C0712mj> blockEntityType, BlockState blockState, BlockEntityType<? extends C0712mj> blockEntityType2, BlockState blockState2) {
        super(entityType, level, blockEntityType, blockState, blockEntityType2, blockState2);
        this.f4153od = 0;
        this.f4154fF = false;
        this.f4155fG = false;
        this.f4156fH = false;
    }

    /* JADX INFO: renamed from: a */
    public a m3479a(@NotNull C0816oh c0816oh) {
        int i = 0;
        Iterator it = m3431b().f4373ar.iterator();
        while (it.hasNext()) {
            if (((AbstractC0818oj) it.next()) == c0816oh) {
                return m3480a(i);
            }
            i++;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static a m3480a(int i) {
        return f4151ao.get(i);
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU, com.boehmod.blockfront.C0697mU
    public void tick() {
        super.tick();
        Level level = level();
        int i = 0;
        Iterator it = m3431b().f4373ar.iterator();
        while (it.hasNext()) {
            AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
            if (abstractC0818oj instanceof C0816oh) {
                ((C0816oh) abstractC0818oj).m3773a(m3480a(i).f4157I);
                i++;
            }
        }
        if (level.isClientSide) {
            m3481cv();
        } else if (this.f4153od > 0) {
            this.f4153od--;
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cv */
    public void m3481cv() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        C0819ok c0819okMo3433a = mo3433a();
        if (minecraft.mouseHandler.isLeftPressed()) {
            if (!this.f4154fF) {
                this.f4154fF = true;
                C1169vO.m6648c(new C1210wC());
            }
        } else {
            this.f4154fF = false;
        }
        if (localPlayer != null && hasPassenger(localPlayer)) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (f4152fE) {
                this.f4156fH = false;
                if (!this.f4155fG) {
                    this.f4155fG = true;
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) c0819okMo3433a.f4448ai.get(), 1.0f, 1.0f));
                }
            } else {
                this.f4155fG = false;
                if (!this.f4156fH) {
                    this.f4156fH = true;
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) c0819okMo3433a.f4449aj.get(), 1.0f, 1.0f));
                }
            }
        }
        int i = 0;
        Iterator it = m3431b().f4373ar.iterator();
        while (it.hasNext()) {
            AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
            if (abstractC0818oj instanceof C0816oh) {
                ((C0816oh) abstractC0818oj).m3774b(m3480a(i).f4157I);
                i++;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU, com.boehmod.blockfront.C0697mU
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        Iterator<a> it = f4151ao.iterator();
        while (it.hasNext()) {
            it.next().defineSynchedData(builder);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0750nU
    /* JADX INFO: renamed from: aD */
    public float mo3435aD() {
        C0809oa c0809oaB = m3431b();
        float fAE = m3442aE();
        return fAE / (fAE < 0.0f ? c0809oaB.f4386kC : c0809oaB.f4385kB);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nW$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nW$a.class */
    public static class a {

        /* JADX INFO: renamed from: I */
        EntityDataAccessor<Float> f4157I = SynchedEntityData.defineId(AbstractC0752nW.class, EntityDataSerializers.FLOAT);

        /* JADX INFO: renamed from: J */
        EntityDataAccessor<Integer> f4158J = SynchedEntityData.defineId(AbstractC0752nW.class, EntityDataSerializers.INT);

        /* JADX INFO: renamed from: K */
        EntityDataAccessor<Boolean> f4159K = SynchedEntityData.defineId(AbstractC0752nW.class, EntityDataSerializers.BOOLEAN);

        public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
            builder.define(this.f4157I, Float.valueOf(0.0f)).define(this.f4158J, 32).define(this.f4159K, false);
        }

        /* JADX INFO: renamed from: a */
        public float m3482a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Float) synchedEntityData.get(this.f4157I)).floatValue();
        }

        /* JADX INFO: renamed from: a */
        public void m3483a(@NotNull SynchedEntityData synchedEntityData, float f) {
            synchedEntityData.set(this.f4157I, Float.valueOf(f));
        }

        /* JADX INFO: renamed from: a */
        public int m3484a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Integer) synchedEntityData.get(this.f4158J)).intValue();
        }

        /* JADX INFO: renamed from: a */
        public void m3485a(@NotNull SynchedEntityData synchedEntityData, int i) {
            synchedEntityData.set(this.f4158J, Integer.valueOf(i));
        }

        /* JADX INFO: renamed from: a */
        public boolean m3486a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Boolean) synchedEntityData.get(this.f4159K)).booleanValue();
        }

        /* JADX INFO: renamed from: a */
        public void m3487a(@NotNull SynchedEntityData synchedEntityData, boolean z) {
            synchedEntityData.set(this.f4159K, Boolean.valueOf(z));
        }
    }
}
