package software.bernie.geckolib.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.GeoObjectRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent.class */
public interface GeoRenderEvent {
    GeoRenderer<?> getRenderer();

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Armor.class */
    public static abstract class Armor extends Event implements GeoRenderEvent {
        private final GeoArmorRenderer<?> renderer;

        public Armor(GeoArmorRenderer<?> renderer) {
            this.renderer = renderer;
        }

        @Override // software.bernie.geckolib.event.GeoRenderEvent
        public GeoArmorRenderer<?> getRenderer() {
            return this.renderer;
        }

        @Nullable
        public net.minecraft.world.entity.Entity getEntity() {
            return getRenderer().getCurrentEntity();
        }

        @Nullable
        public ItemStack getItemStack() {
            return getRenderer().getCurrentStack();
        }

        @Nullable
        public EquipmentSlot getEquipmentSlot() {
            return getRenderer().getCurrentSlot();
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Armor$Pre.class */
        public static class Pre extends Armor implements ICancellableEvent {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Armor, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Pre(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Armor$Post.class */
        public static class Post extends Armor {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Armor, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Post(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Armor$CompileRenderLayers.class */
        public static class CompileRenderLayers extends Armor {
            @Override // software.bernie.geckolib.event.GeoRenderEvent.Armor, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public CompileRenderLayers(GeoArmorRenderer<?> renderer) {
                super(renderer);
            }

            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Block.class */
    public static abstract class Block extends Event implements GeoRenderEvent {
        private final GeoBlockRenderer<?> renderer;

        public Block(GeoBlockRenderer<?> renderer) {
            this.renderer = renderer;
        }

        @Override // software.bernie.geckolib.event.GeoRenderEvent
        public GeoBlockRenderer<?> getRenderer() {
            return this.renderer;
        }

        public BlockEntity getBlockEntity() {
            return getRenderer().mo9710getAnimatable();
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Block$Pre.class */
        public static class Pre extends Block implements ICancellableEvent {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Block, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Pre(GeoBlockRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Block$Post.class */
        public static class Post extends Block {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Block, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Post(GeoBlockRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Block$CompileRenderLayers.class */
        public static class CompileRenderLayers extends Block {
            @Override // software.bernie.geckolib.event.GeoRenderEvent.Block, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public CompileRenderLayers(GeoBlockRenderer<?> renderer) {
                super(renderer);
            }

            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Entity.class */
    public static abstract class Entity extends Event implements GeoRenderEvent {
        private final GeoEntityRenderer<?> renderer;

        public Entity(GeoEntityRenderer<?> renderer) {
            this.renderer = renderer;
        }

        @Override // software.bernie.geckolib.event.GeoRenderEvent
        public GeoEntityRenderer<?> getRenderer() {
            return this.renderer;
        }

        public net.minecraft.world.entity.Entity getEntity() {
            return this.renderer.mo9710getAnimatable();
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Entity$Pre.class */
        public static class Pre extends Entity implements ICancellableEvent {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Entity, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Pre(GeoEntityRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Entity$Post.class */
        public static class Post extends Entity {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Entity, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Post(GeoEntityRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Entity$CompileRenderLayers.class */
        public static class CompileRenderLayers extends Entity {
            @Override // software.bernie.geckolib.event.GeoRenderEvent.Entity, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public CompileRenderLayers(GeoEntityRenderer<?> renderer) {
                super(renderer);
            }

            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Item.class */
    public static abstract class Item extends Event implements GeoRenderEvent {
        private final GeoItemRenderer<?> renderer;

        public Item(GeoItemRenderer<?> renderer) {
            this.renderer = renderer;
        }

        @Override // software.bernie.geckolib.event.GeoRenderEvent
        public GeoItemRenderer<?> getRenderer() {
            return this.renderer;
        }

        public ItemStack getItemStack() {
            return getRenderer().getCurrentItemStack();
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Item$Pre.class */
        public static class Pre extends Item implements ICancellableEvent {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Item, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Pre(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Item$Post.class */
        public static class Post extends Item {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Item, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Post(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Item$CompileRenderLayers.class */
        public static class CompileRenderLayers extends Item {
            @Override // software.bernie.geckolib.event.GeoRenderEvent.Item, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public CompileRenderLayers(GeoItemRenderer<?> renderer) {
                super(renderer);
            }

            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Object.class */
    public static abstract class Object extends Event implements GeoRenderEvent {
        private final GeoObjectRenderer<?> renderer;

        public Object(GeoObjectRenderer<?> renderer) {
            this.renderer = renderer;
        }

        @Override // software.bernie.geckolib.event.GeoRenderEvent
        public GeoObjectRenderer<?> getRenderer() {
            return this.renderer;
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Object$Pre.class */
        public static class Pre extends Object implements ICancellableEvent {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Object, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Pre(GeoObjectRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Object$Post.class */
        public static class Post extends Object {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.Object, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Post(GeoObjectRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$Object$CompileRenderLayers.class */
        public static class CompileRenderLayers extends Object {
            @Override // software.bernie.geckolib.event.GeoRenderEvent.Object, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public CompileRenderLayers(GeoObjectRenderer<?> renderer) {
                super(renderer);
            }

            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$ReplacedEntity.class */
    public static abstract class ReplacedEntity extends Event implements GeoRenderEvent {
        private final GeoReplacedEntityRenderer<?, ?> renderer;

        public ReplacedEntity(GeoReplacedEntityRenderer<?, ?> renderer) {
            this.renderer = renderer;
        }

        @Override // software.bernie.geckolib.event.GeoRenderEvent
        public GeoReplacedEntityRenderer<?, ?> getRenderer() {
            return this.renderer;
        }

        public net.minecraft.world.entity.Entity getReplacedEntity() {
            return getRenderer().getCurrentEntity();
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$ReplacedEntity$Pre.class */
        public static class Pre extends ReplacedEntity implements ICancellableEvent {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.ReplacedEntity, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Pre(GeoReplacedEntityRenderer<?, ?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$ReplacedEntity$Post.class */
        public static class Post extends ReplacedEntity {
            private final PoseStack poseStack;
            private final BakedGeoModel model;
            private final MultiBufferSource bufferSource;
            private final float partialTick;
            private final int packedLight;

            @Override // software.bernie.geckolib.event.GeoRenderEvent.ReplacedEntity, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public Post(GeoReplacedEntityRenderer<?, ?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
                super(renderer);
                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/event/GeoRenderEvent$ReplacedEntity$CompileRenderLayers.class */
        public static class CompileRenderLayers extends ReplacedEntity {
            @Override // software.bernie.geckolib.event.GeoRenderEvent.ReplacedEntity, software.bernie.geckolib.event.GeoRenderEvent
            public /* bridge */ /* synthetic */ GeoRenderer getRenderer() {
                return super.getRenderer();
            }

            public CompileRenderLayers(GeoReplacedEntityRenderer<?, ?> renderer) {
                super(renderer);
            }

            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }
}
