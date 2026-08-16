package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/* JADX INFO: renamed from: com.boehmod.blockfront.mB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mB.class */
public class C0678mB extends LanguageProvider {
    public C0678mB(PackOutput packOutput) {
        super(packOutput, "bf_gen", "en_us");
    }

    protected void addTranslations() {
        ObjectListIterator it = C0704mb.f3881P.iterator();
        while (it.hasNext()) {
            ((C0704mb) it.next()).m3163a(this);
        }
        ObjectListIterator it2 = C0705mc.f3890Q.iterator();
        while (it2.hasNext()) {
            ((C0705mc) it2.next()).m3173a(this);
        }
        ObjectListIterator it3 = C0707me.f3918R.iterator();
        while (it3.hasNext()) {
            ((C0707me) it3.next()).m3192a(this);
        }
        ObjectListIterator it4 = C0708mf.f3932S.iterator();
        while (it4.hasNext()) {
            ((C0708mf) it4.next()).m3211a(this);
        }
        ObjectListIterator it5 = C0709mg.f3937T.iterator();
        while (it5.hasNext()) {
            ((C0709mg) it5.next()).m3221a(this);
        }
    }
}
