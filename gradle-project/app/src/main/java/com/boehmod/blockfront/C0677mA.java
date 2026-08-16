package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mA.class */
public class C0677mA extends ItemModelProvider {
    public C0677mA(@NotNull PackOutput packOutput, @NotNull ExistingFileHelper existingFileHelper) {
        super(packOutput, "bf", existingFileHelper);
    }

    protected void registerModels() {
        ObjectListIterator it = C0704mb.f3881P.iterator();
        while (it.hasNext()) {
            ((C0704mb) it.next()).m3162a(this);
        }
        ObjectListIterator it2 = C0705mc.f3890Q.iterator();
        while (it2.hasNext()) {
            ((C0705mc) it2.next()).m3172a(this);
        }
        ObjectListIterator it3 = C0707me.f3918R.iterator();
        while (it3.hasNext()) {
            ((C0707me) it3.next()).m3191a(this);
        }
        ObjectListIterator it4 = C0708mf.f3932S.iterator();
        while (it4.hasNext()) {
            ((C0708mf) it4.next()).m3210a(this);
        }
        ObjectListIterator it5 = C0709mg.f3937T.iterator();
        while (it5.hasNext()) {
            ((C0709mg) it5.next()).m3220a(this);
        }
    }
}
