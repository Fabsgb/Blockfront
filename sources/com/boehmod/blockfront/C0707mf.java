package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/* JADX INFO: renamed from: com.boehmod.blockfront.mf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mf.class */
public class C0707mf extends LanguageProvider {
    public C0707mf(PackOutput packOutput) {
        super(packOutput, "bf_gen", "en_us");
    }

    protected void addTranslations() {
        ObjectListIterator it = C0628lF.f3407G.iterator();
        while (it.hasNext()) {
            ((C0628lF) it.next()).m2732a(this);
        }
        ObjectListIterator it2 = C0629lG.f3416H.iterator();
        while (it2.hasNext()) {
            ((C0629lG) it2.next()).m2742a(this);
        }
        ObjectListIterator it3 = C0631lI.f3444I.iterator();
        while (it3.hasNext()) {
            ((C0631lI) it3.next()).m2761a(this);
        }
        ObjectListIterator it4 = C0632lJ.f3458J.iterator();
        while (it4.hasNext()) {
            ((C0632lJ) it4.next()).m2780a(this);
        }
        ObjectListIterator it5 = C0633lK.f3463K.iterator();
        while (it5.hasNext()) {
            ((C0633lK) it5.next()).m2790a(this);
        }
    }
}
