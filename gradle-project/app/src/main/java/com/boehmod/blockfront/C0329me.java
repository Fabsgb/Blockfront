package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.me, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/me.class */
public class C0329me extends ItemModelProvider {
    public C0329me(@NotNull PackOutput packOutput, @NotNull ExistingFileHelper existingFileHelper) {
        super(packOutput, "bf", existingFileHelper);
    }

    protected void registerModels() {
        ObjectListIterator it = lF.G.iterator();
        while (it.hasNext()) {
            ((lF) it.next()).a(this);
        }
        ObjectListIterator it2 = lG.H.iterator();
        while (it2.hasNext()) {
            ((lG) it2.next()).a(this);
        }
        ObjectListIterator it3 = lI.I.iterator();
        while (it3.hasNext()) {
            ((lI) it3.next()).a(this);
        }
        ObjectListIterator it4 = lJ.J.iterator();
        while (it4.hasNext()) {
            ((lJ) it4.next()).a(this);
        }
        ObjectListIterator it5 = lK.K.iterator();
        while (it5.hasNext()) {
            ((lK) it5.next()).a(this);
        }
    }
}
