package com.boehmod.blockfront;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB.class */
public class oB {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB$c.class */
    private static class c extends Event {

        @NotNull
        private final C0558ur c;

        @NotNull
        private final ItemStack e;

        public c(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack) {
            this.c = c0558ur;
            this.e = itemStack;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public C0558ur mo745a() {
            return this.c;
        }

        @NotNull
        public ItemStack a() {
            return this.e;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB$b.class */
    public static class b extends c {

        @NotNull
        private final LivingEntity c;

        @Override // com.boehmod.blockfront.oB.c
        @NotNull
        public /* bridge */ /* synthetic */ ItemStack a() {
            return super.a();
        }

        @Override // com.boehmod.blockfront.oB.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ C0558ur mo745a() {
            return super.mo745a();
        }

        public b(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity) {
            super(c0558ur, itemStack);
            this.c = livingEntity;
        }

        @NotNull
        public LivingEntity b() {
            return this.c;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oB$a.class */
    public static class a extends c {
        private int mp;

        @Override // com.boehmod.blockfront.oB.c
        @NotNull
        public /* bridge */ /* synthetic */ ItemStack a() {
            return super.a();
        }

        @Override // com.boehmod.blockfront.oB.c
        @NotNull
        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ C0558ur mo745a() {
            return super.mo745a();
        }

        public a(@NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, int i) {
            super(c0558ur, itemStack);
            this.mp = i;
        }

        public int aR() {
            return this.mp;
        }

        public void z(int i) {
            this.mp = i;
        }
    }
}
