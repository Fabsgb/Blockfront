package com.boehmod.blockfront;

import com.boehmod.blockfront.C0459r;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/y.class */
public class C0640y implements InterfaceC0641z<C0459r> {
    private final ObjectList<ResourceLocation> d = new ObjectArrayList();

    public C0640y() {
        this.d.add(ResourceLocation.withDefaultNamespace("block/stone"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/smooth_stone"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/cobblestone"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/sandstone"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/smooth_sandstone"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/sand"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/dirt"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/grass_block"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/oak_planks"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/stone_bricks"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/smooth_stone"));
        this.d.add(ResourceLocation.withDefaultNamespace("block/gravel"));
    }

    private static boolean a(@NotNull TextureAtlasSprite textureAtlasSprite) {
        SpriteContents spriteContentsContents = textureAtlasSprite.contents();
        int iWidth = spriteContentsContents.width();
        int iHeight = spriteContentsContents.height();
        for (int i = 0; i < iHeight; i++) {
            for (int i2 = 0; i2 < iWidth; i2++) {
                try {
                    if (((textureAtlasSprite.getPixelRGBA(0, i2, i) >> 24) & 255) < 255) {
                        return true;
                    }
                } catch (IllegalStateException e) {
                    return false;
                }
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0641z
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0459r c0459r) {
        TextureAtlas texture = minecraft.getTextureManager().getTexture(InventoryMenu.BLOCK_ATLAS);
        if (!(texture instanceof TextureAtlas)) {
            return false;
        }
        TextureAtlas textureAtlas = texture;
        ObjectListIterator it = this.d.iterator();
        while (it.hasNext()) {
            try {
                TextureAtlasSprite sprite = textureAtlas.getSprite((ResourceLocation) it.next());
                if (sprite != null && !sprite.contents().name().getPath().equals("missingno") && a(sprite)) {
                    return true;
                }
            } catch (IllegalStateException e) {
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0641z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0459r.a mo1294a() {
        return C0459r.a.STARTUP;
    }
}
