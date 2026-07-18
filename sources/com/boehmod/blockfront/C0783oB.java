package com.boehmod.blockfront;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB.class */
public class C0783oB {

    /* JADX INFO: renamed from: com.boehmod.blockfront.oB$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB$c.class */
    private static class c extends Event {

        /* JADX INFO: renamed from: c */
        @NotNull
        private final C1144ur f4199c;

        /* JADX INFO: renamed from: e */
        @NotNull
        private final ItemStack f4200e;

        public c(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack) {
            this.f4199c = c1144ur;
            this.f4200e = itemStack;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public C1144ur mo3553a() {
            return this.f4199c;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ItemStack mo3552a() {
            return this.f4200e;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oB$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB$b.class */
    public static class b extends c {

        /* JADX INFO: renamed from: c */
        @NotNull
        private final LivingEntity f4198c;

        @Override // com.boehmod.blockfront.C0783oB.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ ItemStack mo3552a() {
            return super.mo3552a();
        }

        @Override // com.boehmod.blockfront.C0783oB.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ C1144ur mo3553a() {
            return super.mo3553a();
        }

        public b(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity) {
            super(c1144ur, itemStack);
            this.f4198c = livingEntity;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public LivingEntity m3554b() {
            return this.f4198c;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oB$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB$a.class */
    public static class a extends c {

        /* JADX INFO: renamed from: mp */
        private int f4197mp;

        @Override // com.boehmod.blockfront.C0783oB.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ ItemStack mo3552a() {
            return super.mo3552a();
        }

        @Override // com.boehmod.blockfront.C0783oB.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ C1144ur mo3553a() {
            return super.mo3553a();
        }

        public a(@NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, int i) {
            super(c1144ur, itemStack);
            this.f4197mp = i;
        }

        /* JADX INFO: renamed from: aR */
        public int m3550aR() {
            return this.f4197mp;
        }

        /* JADX INFO: renamed from: z */
        public void m3551z(int i) {
            this.f4197mp = i;
        }
    }
}
