package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mz.class */
public class C0728mz extends BlockTagsProvider {
    public C0728mz(@NotNull PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @NotNull ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, "bf", existingFileHelper);
    }

    protected void addTags(@NotNull HolderLookup.Provider provider) {
        ObjectListIterator it = C0704mb.f3881P.iterator();
        while (it.hasNext()) {
            tag(BlockTags.WALLS).add((Block) ((C0704mb) it.next()).f3889r.get());
        }
        ObjectListIterator it2 = C0645lV.f3638N.iterator();
        while (it2.hasNext()) {
            tag(BlockTags.WALLS).add((Block) ((C0645lV) it2.next()).f3642m.get());
        }
        ObjectListIterator it3 = C0709mg.f3937T.iterator();
        while (it3.hasNext()) {
            C0709mg c0709mg = (C0709mg) it3.next();
            tag(BlockTags.FENCES).add((Block) c0709mg.f3943R.get());
            tag(BlockTags.FENCE_GATES).add((Block) c0709mg.f3944S.get());
        }
        tag(BlockTags.CLIMBABLE).add((Block) C1295xi.f7049dB.get());
    }
}
