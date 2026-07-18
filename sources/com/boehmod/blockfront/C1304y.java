package com.boehmod.blockfront;

import com.boehmod.blockfront.C0940r;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.y */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/y.class */
public class C1304y implements InterfaceC1305z<C0940r> {

    /* JADX INFO: renamed from: d */
    private final ObjectList<ResourceLocation> f8711d = new ObjectArrayList();

    public C1304y() {
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/stone"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/smooth_stone"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/cobblestone"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/sandstone"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/smooth_sandstone"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/sand"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/dirt"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/grass_block"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/oak_planks"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/stone_bricks"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/smooth_stone"));
        this.f8711d.add(ResourceLocation.withDefaultNamespace("block/gravel"));
    }

    /* JADX INFO: renamed from: a */
    private static boolean m7975a(@NotNull TextureAtlasSprite textureAtlasSprite) {
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

    @Override // com.boehmod.blockfront.InterfaceC1305z
    /* JADX INFO: renamed from: a */
    public boolean mo6058a(@NotNull Minecraft minecraft, @NotNull C0940r c0940r) {
        TextureAtlas texture = minecraft.getTextureManager().getTexture(InventoryMenu.BLOCK_ATLAS);
        if (!(texture instanceof TextureAtlas)) {
            return false;
        }
        TextureAtlas textureAtlas = texture;
        ObjectListIterator it = this.f8711d.iterator();
        while (it.hasNext()) {
            try {
                TextureAtlasSprite sprite = textureAtlas.getSprite((ResourceLocation) it.next());
                if (sprite != null && !sprite.contents().name().getPath().equals("missingno") && m7975a(sprite)) {
                    return true;
                }
            } catch (IllegalStateException e) {
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1305z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0940r.a mo6057a() {
        return C0940r.a.STARTUP;
    }
}
