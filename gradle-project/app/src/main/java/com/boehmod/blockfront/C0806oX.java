package com.boehmod.blockfront;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oX.class */
public class C0806oX {

    /* JADX INFO: renamed from: com.boehmod.blockfront.oX$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oX$c.class */
    private static class c extends Event {

        /* JADX INFO: renamed from: e */
        @NotNull
        private final C1117uP f4354e;

        /* JADX INFO: renamed from: g */
        @NotNull
        private final ItemStack f4355g;

        public c(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack) {
            this.f4354e = c1117uP;
            this.f4355g = itemStack;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public C1117uP mo3701a() {
            return this.f4354e;
        }

        @NotNull
        /* JADX INFO: renamed from: c */
        public ItemStack mo3700c() {
            return this.f4355g;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oX$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oX$b.class */
    public static class b extends c {

        /* JADX INFO: renamed from: c */
        @NotNull
        private final LivingEntity f4353c;

        @Override // com.boehmod.blockfront.C0806oX.c
        @NotNull
        /* JADX INFO: renamed from: c */
        public /* bridge */ /* synthetic */ ItemStack mo3700c() {
            return super.mo3700c();
        }

        @Override // com.boehmod.blockfront.C0806oX.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ C1117uP mo3701a() {
            return super.mo3701a();
        }

        public b(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity) {
            super(c1117uP, itemStack);
            this.f4353c = livingEntity;
        }

        @NotNull
        /* JADX INFO: renamed from: b */
        public LivingEntity m3702b() {
            return this.f4353c;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oX$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oX$a.class */
    public static class a extends c {

        /* JADX INFO: renamed from: on */
        private int f4352on;

        @Override // com.boehmod.blockfront.C0806oX.c
        @NotNull
        /* JADX INFO: renamed from: c */
        public /* bridge */ /* synthetic */ ItemStack mo3700c() {
            return super.mo3700c();
        }

        @Override // com.boehmod.blockfront.C0806oX.c
        @NotNull
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ C1117uP mo3701a() {
            return super.mo3701a();
        }

        public a(@NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, int i) {
            super(c1117uP, itemStack);
            this.f4352on = i;
        }

        /* JADX INFO: renamed from: bg */
        public int m3698bg() {
            return this.f4352on;
        }

        /* JADX INFO: renamed from: A */
        public void m3699A(int i) {
            this.f4352on = i;
        }
    }
}
