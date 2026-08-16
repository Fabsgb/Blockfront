package com.boehmod.blockfront;

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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.C */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/C.class */
public class C0006C implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: m */
    private final ObjectList<ResourceLocation> f138m = new ObjectArrayList();

    public C0006C() {
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/stone"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/smooth_stone"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/cobblestone"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/sandstone"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/smooth_sandstone"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/sand"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/dirt"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/grass_block"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/oak_planks"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/stone_bricks"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/smooth_stone"));
        this.f138m.add(ResourceLocation.withDefaultNamespace("block/gravel"));
    }

    /* JADX INFO: renamed from: a */
    private static boolean m26a(@NotNull TextureAtlasSprite textureAtlasSprite) {
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

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        TextureAtlas texture = minecraft.getTextureManager().getTexture(InventoryMenu.BLOCK_ATLAS);
        if (!(texture instanceof TextureAtlas)) {
            return null;
        }
        TextureAtlas textureAtlas = texture;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectListIterator it = this.f138m.iterator();
        while (it.hasNext()) {
            ResourceLocation resourceLocation = (ResourceLocation) it.next();
            try {
                TextureAtlasSprite sprite = textureAtlas.getSprite(resourceLocation);
                if (sprite != null) {
                    ResourceLocation resourceLocationName = sprite.contents().name();
                    if (!resourceLocationName.getPath().equals("missingno")) {
                        if (m26a(sprite)) {
                            objectArrayList.add(String.valueOf(resourceLocation) + " (" + String.valueOf(resourceLocationName) + ")");
                        }
                    }
                }
            } catch (IllegalStateException e) {
            }
        }
        if (objectArrayList.isEmpty()) {
            return null;
        }
        return String.join(", ", (Iterable<? extends CharSequence>) objectArrayList);
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.STARTUP;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 4;
    }
}
