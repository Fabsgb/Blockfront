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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nA.class */
public abstract class nA extends AbstractC0376ny {
    private static final List<a> ah = new ObjectArrayList<a>() { // from class: com.boehmod.blockfront.nA.1
        {
            for (int i = 0; i < 5; i++) {
                add(new a());
            }
        }
    };
    public static boolean fk = false;
    public int mf;
    private boolean fl;
    private boolean fm;
    private boolean fn;

    @Override // com.boehmod.blockfront.AbstractC0376ny
    /* JADX INFO: renamed from: a */
    public abstract nO mo740a();

    public nA(EntityType<? extends nA> entityType, Level level, BlockEntityType<? extends lN> blockEntityType, BlockState blockState, BlockEntityType<? extends lN> blockEntityType2, BlockState blockState2) {
        super(entityType, level, blockEntityType, blockState, blockEntityType2, blockState2);
        this.mf = 0;
        this.fl = false;
        this.fm = false;
        this.fn = false;
    }

    public a a(@NotNull nL nLVar) {
        int i = 0;
        Iterator it = b().ak.iterator();
        while (it.hasNext()) {
            if (((nN) it.next()) == nLVar) {
                return a(i);
            }
            i++;
        }
        return null;
    }

    public static a a(int i) {
        return ah.get(i);
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny, com.boehmod.blockfront.C0349my
    public void tick() {
        super.tick();
        Level level = level();
        int i = 0;
        Iterator it = b().ak.iterator();
        while (it.hasNext()) {
            nN nNVar = (nN) it.next();
            if (nNVar instanceof nL) {
                ((nL) nNVar).a(a(i).I);
                i++;
            }
        }
        if (level.isClientSide) {
            cj();
        } else if (this.mf > 0) {
            this.mf--;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void cj() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        nO nOVarMo740a = mo740a();
        if (minecraft.mouseHandler.isLeftPressed()) {
            if (!this.fl) {
                this.fl = true;
                C0582vo.c(new C0598wd());
            }
        } else {
            this.fl = false;
        }
        if (localPlayer != null && hasPassenger(localPlayer)) {
            SoundManager soundManager = minecraft.getSoundManager();
            if (fk) {
                this.fn = false;
                if (!this.fm) {
                    this.fm = true;
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) nOVarMo740a.ai.get(), 1.0f, 1.0f));
                }
            } else {
                this.fm = false;
                if (!this.fn) {
                    this.fn = true;
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) nOVarMo740a.aj.get(), 1.0f, 1.0f));
                }
            }
        }
        int i = 0;
        Iterator it = b().ak.iterator();
        while (it.hasNext()) {
            nN nNVar = (nN) it.next();
            if (nNVar instanceof nL) {
                ((nL) nNVar).b(a(i).I);
                i++;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny, com.boehmod.blockfront.C0349my
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        Iterator<a> it = ah.iterator();
        while (it.hasNext()) {
            it.next().defineSynchedData(builder);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0376ny
    public float ax() {
        nE nEVarB = b();
        float fAy = ay();
        return fAy / (fAy < 0.0f ? nEVarB.jJ : nEVarB.jI);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nA$a.class */
    public static class a {
        EntityDataAccessor<Float> I = SynchedEntityData.defineId(nA.class, EntityDataSerializers.FLOAT);
        EntityDataAccessor<Integer> J = SynchedEntityData.defineId(nA.class, EntityDataSerializers.INT);
        EntityDataAccessor<Boolean> K = SynchedEntityData.defineId(nA.class, EntityDataSerializers.BOOLEAN);

        public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
            builder.define(this.I, Float.valueOf(0.0f)).define(this.J, 32).define(this.K, false);
        }

        public float a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Float) synchedEntityData.get(this.I)).floatValue();
        }

        public void a(@NotNull SynchedEntityData synchedEntityData, float f) {
            synchedEntityData.set(this.I, Float.valueOf(f));
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public int m711a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Integer) synchedEntityData.get(this.J)).intValue();
        }

        public void a(@NotNull SynchedEntityData synchedEntityData, int i) {
            synchedEntityData.set(this.J, Integer.valueOf(i));
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m712a(@NotNull SynchedEntityData synchedEntityData) {
            return ((Boolean) synchedEntityData.get(this.K)).booleanValue();
        }

        public void a(@NotNull SynchedEntityData synchedEntityData, boolean z) {
            synchedEntityData.set(this.K, Boolean.valueOf(z));
        }
    }
}
