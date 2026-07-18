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

/* JADX INFO: renamed from: com.boehmod.blockfront.nA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nA.class */
public abstract class AbstractC0729nA extends AbstractC0779ny {

    /* JADX INFO: renamed from: ah */
    private static final List<a> f3903ah = new ObjectArrayList<a>() { // from class: com.boehmod.blockfront.nA.1
        {
            for (int i = 0; i < 5; i++) {
                add(new a());
            }
        }
    };

    /* JADX INFO: renamed from: fk */
    public static boolean f3904fk = false;

    /* JADX INFO: renamed from: mf */
    public int f3905mf;

    /* JADX INFO: renamed from: fl */
    private boolean f3906fl;

    /* JADX INFO: renamed from: fm */
    private boolean f3907fm;

    /* JADX INFO: renamed from: fn */
    private boolean f3908fn;

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: a */
    public abstract C0743nO mo3293a();

    public AbstractC0729nA(EntityType<? extends AbstractC0729nA> entityType, Level level, BlockEntityType<? extends C0636lN> blockEntityType, BlockState blockState, BlockEntityType<? extends C0636lN> blockEntityType2, BlockState blockState2) {
        super(entityType, level, blockEntityType, blockState, blockEntityType2, blockState2);
        this.f3905mf = 0;
        this.f3906fl = false;
        this.f3907fm = false;
        this.f3908fn = false;
    }

    /* JADX INFO: renamed from: a */
    public a m3290a(@NotNull C0740nL c0740nL) {
        int i = 0;
        Iterator it = m3498b().f3945ak.iterator();
        while (it.hasNext()) {
            if (((AbstractC0742nN) it.next()) == c0740nL) {
                return m3291a(i);
            }
            i++;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static a m3291a(int i) {
        return f3903ah.get(i);
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny, com.boehmod.blockfront.C0726my
    public void tick() {
        super.tick();
        Level level = level();
        int i = 0;
        Iterator it = m3498b().f3945ak.iterator();
        while (it.hasNext()) {
            AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
            if (abstractC0742nN instanceof C0740nL) {
                ((C0740nL) abstractC0742nN).m3401a(m3291a(i).f3909I);
                i++;
            }
        }
        if (level.isClientSide) {
            m3292cj();
        } else if (this.f3905mf > 0) {
            this.f3905mf--;
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cj */
    public void m3292cj() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        C0743nO c0743nOMo3293a = mo3293a();
        if (minecraft.mouseHandler.isLeftPressed()) {
            if (!this.f3906fl) {
                this.f3906fl = true;
                C1194vo.m6653c(new C1236wd());
            }
        } else {
            this.f3906fl = false;
        }
        if (localPlayer != null && hasPassenger(localPlayer)) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (f3904fk) {
                this.f3908fn = false;
                if (!this.f3907fm) {
                    this.f3907fm = true;
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) c0743nOMo3293a.f4020ai.get(), 1.0f, 1.0f));
                }
            } else {
                this.f3907fm = false;
                if (!this.f3908fn) {
                    this.f3908fn = true;
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) c0743nOMo3293a.f4021aj.get(), 1.0f, 1.0f));
                }
            }
        }
        int i = 0;
        Iterator it = m3498b().f3945ak.iterator();
        while (it.hasNext()) {
            AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
            if (abstractC0742nN instanceof C0740nL) {
                ((C0740nL) abstractC0742nN).m3402b(m3291a(i).f3909I);
                i++;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny, com.boehmod.blockfront.C0726my
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        Iterator<a> it = f3903ah.iterator();
        while (it.hasNext()) {
            it.next().defineSynchedData(builder);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0779ny
    /* JADX INFO: renamed from: ax */
    public float mo3294ax() {
        C0733nE c0733nEB = m3498b();
        float fAy = m3505ay();
        return fAy / (fAy < 0.0f ? c0733nEB.f3958jJ : c0733nEB.f3957jI);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nA$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nA$a.class */
    public static class a {

        /* JADX INFO: renamed from: I */
        EntityDataAccessor<Float> f3909I = SynchedEntityData.defineId(AbstractC0729nA.class, EntityDataSerializers.FLOAT);

        /* JADX INFO: renamed from: J */
        EntityDataAccessor<Integer> f3910J = SynchedEntityData.defineId(AbstractC0729nA.class, EntityDataSerializers.INT);

        /* JADX INFO: renamed from: K */
        EntityDataAccessor<Boolean> f3911K = SynchedEntityData.defineId(AbstractC0729nA.class, EntityDataSerializers.BOOLEAN);

        public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
            builder.define(this.f3909I, Float.valueOf(0.0f)).define(this.f3910J, 32).define(this.f3911K, false);
        }

        /* JADX INFO: renamed from: a */
        public float m3295a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Float) synchedEntityData.get(this.f3909I)).floatValue();
        }

        /* JADX INFO: renamed from: a */
        public void m3296a(@NotNull SynchedEntityData synchedEntityData, float f) {
            synchedEntityData.set(this.f3909I, Float.valueOf(f));
        }

        /* JADX INFO: renamed from: a */
        public int m3297a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Integer) synchedEntityData.get(this.f3910J)).intValue();
        }

        /* JADX INFO: renamed from: a */
        public void m3298a(@NotNull SynchedEntityData synchedEntityData, int i) {
            synchedEntityData.set(this.f3910J, Integer.valueOf(i));
        }

        /* JADX INFO: renamed from: a */
        public boolean m3299a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Boolean) synchedEntityData.get(this.f3911K)).booleanValue();
        }

        /* JADX INFO: renamed from: a */
        public void m3300a(@NotNull SynchedEntityData synchedEntityData, boolean z) {
            synchedEntityData.set(this.f3911K, Boolean.valueOf(z));
        }
    }
}
