package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.my */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/my.class */
public class C0727my extends BlockStateProvider {
    public C0727my(@NotNull PackOutput packOutput, @NotNull ExistingFileHelper existingFileHelper) {
        super(packOutput, "bf", existingFileHelper);
    }

    protected void registerStatesAndModels() {
        ObjectListIterator it = C0704mb.f3881P.iterator();
        while (it.hasNext()) {
            ((C0704mb) it.next()).m3161a(this);
        }
        ObjectListIterator it2 = C0705mc.f3890Q.iterator();
        while (it2.hasNext()) {
            ((C0705mc) it2.next()).m3171a(this);
        }
        ObjectListIterator it3 = C0707me.f3918R.iterator();
        while (it3.hasNext()) {
            ((C0707me) it3.next()).m3190a(this);
        }
        ObjectListIterator it4 = C0708mf.f3932S.iterator();
        while (it4.hasNext()) {
            ((C0708mf) it4.next()).m3209a(this);
        }
        ObjectListIterator it5 = C0709mg.f3937T.iterator();
        while (it5.hasNext()) {
            ((C0709mg) it5.next()).m3219a(this);
        }
    }
}
