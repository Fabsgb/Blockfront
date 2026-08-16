package software.bernie.geckolib.util;

import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.ints.IntIntImmutablePair;
import it.unimi.dsi.fastutil.ints.IntIntPair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/util/RenderUtil.class */
public final class RenderUtil {
    public static void translateMatrixToBone(PoseStack poseStack, GeoBone bone) {
        poseStack.translate((-bone.getPosX()) / 16.0f, bone.getPosY() / 16.0f, bone.getPosZ() / 16.0f);
    }

    public static void rotateMatrixAroundBone(PoseStack poseStack, GeoBone bone) {
        if (bone.getRotZ() != 0.0f) {
            poseStack.mulPose(Axis.ZP.rotation(bone.getRotZ()));
        }
        if (bone.getRotY() != 0.0f) {
            poseStack.mulPose(Axis.YP.rotation(bone.getRotY()));
        }
        if (bone.getRotX() != 0.0f) {
            poseStack.mulPose(Axis.XP.rotation(bone.getRotX()));
        }
    }

    public static void rotateMatrixAroundCube(PoseStack poseStack, GeoCube cube) {
        Vec3 rotation = cube.rotation();
        poseStack.mulPose(new Quaternionf().rotationXYZ(0.0f, 0.0f, (float) rotation.z()));
        poseStack.mulPose(new Quaternionf().rotationXYZ(0.0f, (float) rotation.y(), 0.0f));
        poseStack.mulPose(new Quaternionf().rotationXYZ((float) rotation.x(), 0.0f, 0.0f));
    }

    public static void scaleMatrixForBone(PoseStack poseStack, GeoBone bone) {
        poseStack.scale(bone.getScaleX(), bone.getScaleY(), bone.getScaleZ());
    }

    public static void translateToPivotPoint(PoseStack poseStack, GeoCube cube) {
        Vec3 pivot = cube.pivot();
        poseStack.translate(pivot.x() / 16.0d, pivot.y() / 16.0d, pivot.z() / 16.0d);
    }

    public static void translateToPivotPoint(PoseStack poseStack, GeoBone bone) {
        poseStack.translate(bone.getPivotX() / 16.0f, bone.getPivotY() / 16.0f, bone.getPivotZ() / 16.0f);
    }

    public static void translateAwayFromPivotPoint(PoseStack poseStack, GeoCube cube) {
        Vec3 pivot = cube.pivot();
        poseStack.translate((-pivot.x()) / 16.0d, (-pivot.y()) / 16.0d, (-pivot.z()) / 16.0d);
    }

    public static void translateAwayFromPivotPoint(PoseStack poseStack, GeoBone bone) {
        poseStack.translate((-bone.getPivotX()) / 16.0f, (-bone.getPivotY()) / 16.0f, (-bone.getPivotZ()) / 16.0f);
    }

    public static void translateAndRotateMatrixForBone(PoseStack poseStack, GeoBone bone) {
        translateToPivotPoint(poseStack, bone);
        rotateMatrixAroundBone(poseStack, bone);
    }

    public static void prepMatrixForBone(PoseStack poseStack, GeoBone bone) {
        translateMatrixToBone(poseStack, bone);
        translateToPivotPoint(poseStack, bone);
        rotateMatrixAroundBone(poseStack, bone);
        scaleMatrixForBone(poseStack, bone);
        translateAwayFromPivotPoint(poseStack, bone);
    }

    public static Matrix4f invertAndMultiplyMatrices(Matrix4f baseMatrix, Matrix4f inputMatrix) {
        Matrix4f inputMatrix2 = new Matrix4f(inputMatrix);
        inputMatrix2.invert();
        inputMatrix2.mul(baseMatrix);
        return inputMatrix2;
    }

    public static void faceRotation(PoseStack poseStack, Entity animatable, float partialTick) {
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, animatable.yRotO, animatable.getYRot()) - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot())));
    }

    public static Matrix4f translateMatrix(Matrix4f matrix, Vector3f vector) {
        return matrix.add(new Matrix4f().m30(vector.x).m31(vector.y).m32(vector.z));
    }

    @Nullable
    public static IntIntPair getTextureDimensions(ResourceLocation texture) {
        NativeImage pixels;
        if (texture == null) {
            return null;
        }
        AbstractTexture originalTexture = null;
        Minecraft mc = Minecraft.getInstance();
        try {
            originalTexture = (AbstractTexture) mc.submit(() -> {
                return mc.getTextureManager().getTexture(texture);
            }).get();
        } catch (Exception e) {
            GeckoLibConstants.LOGGER.warn("Failed to load image for id {}", texture);
            e.printStackTrace();
        }
        if (originalTexture == null) {
            return null;
        }
        NativeImage image = null;
        try {
            if (originalTexture instanceof DynamicTexture) {
                DynamicTexture dynamicTexture = (DynamicTexture) originalTexture;
                pixels = dynamicTexture.getPixels();
            } else {
                pixels = NativeImage.read(((Resource) mc.getResourceManager().getResource(texture).get()).open());
            }
            image = pixels;
        } catch (Exception e2) {
            GeckoLibConstants.LOGGER.error("Failed to read image for id {}", texture);
            e2.printStackTrace();
        }
        if (image == null) {
            return null;
        }
        return IntIntImmutablePair.of(image.getWidth(), image.getHeight());
    }

    public static double getCurrentSystemTick() {
        return (System.nanoTime() / 1000000.0d) / 50.0d;
    }

    public static double getCurrentTick() {
        return Blaze3D.getTime() * 20.0d;
    }

    public static float booleanToFloat(boolean input) {
        return input ? 1.0f : 0.0f;
    }

    public static Vec3 arrayToVec(double[] array) {
        return new Vec3(array[0], array[1], array[2]);
    }

    public static void matchModelPartRot(ModelPart from, GeoBone to) {
        to.updateRotation(-from.xRot, -from.yRot, from.zRot);
    }

    public static void fixInvertedFlatCube(GeoCube cube, Vector3f normal) {
        if (normal.x() < 0.0f && (cube.size().y() == 0.0d || cube.size().z() == 0.0d)) {
            normal.mul(-1.0f, 1.0f, 1.0f);
        }
        if (normal.y() < 0.0f && (cube.size().x() == 0.0d || cube.size().z() == 0.0d)) {
            normal.mul(1.0f, -1.0f, 1.0f);
        }
        if (normal.z() < 0.0f) {
            if (cube.size().x() == 0.0d || cube.size().y() == 0.0d) {
                normal.mul(1.0f, 1.0f, -1.0f);
            }
        }
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.util.RenderUtil$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/util/RenderUtil$1.class */
    static /* synthetic */ class C15061 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static float getDirectionAngle(Direction direction) {
        switch (C15061.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 1:
                return 90.0f;
            case 2:
                return 270.0f;
            case 3:
                return 180.0f;
            default:
                return 0.0f;
        }
    }

    public static double lerpYaw(double delta, double start, double end) {
        double start2 = Mth.wrapDegrees(start);
        double end2 = Mth.wrapDegrees(end);
        double diff = start2 - end2;
        return Mth.lerp(delta, start2, (diff > 180.0d || diff < -180.0d) ? start2 + Math.copySign(360.0d - Math.abs(diff), diff) : end2);
    }

    @Nullable
    public static GeoModel<?> getGeoModelForEntityType(EntityType<?> entityType) {
        GeoRenderer<?> geoRenderer = (EntityRenderer) Minecraft.getInstance().getEntityRenderDispatcher().renderers.get(entityType);
        if (!(geoRenderer instanceof GeoRenderer)) {
            return null;
        }
        GeoRenderer<?> geoRenderer2 = geoRenderer;
        return geoRenderer2.getGeoModel();
    }

    @Nullable
    public static GeoAnimatable getReplacedAnimatable(EntityType<?> entityType) {
        EntityRenderer<?> renderer = (EntityRenderer) Minecraft.getInstance().getEntityRenderDispatcher().renderers.get(entityType);
        if (!(renderer instanceof GeoReplacedEntityRenderer)) {
            return null;
        }
        GeoReplacedEntityRenderer<?, ?> replacedEntityRenderer = (GeoReplacedEntityRenderer) renderer;
        return replacedEntityRenderer.mo9710getAnimatable();
    }

    @Nullable
    public static GeoModel<?> getGeoModelForEntity(Entity entity) {
        GeoRenderer<?> renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(entity);
        if (!(renderer instanceof GeoRenderer)) {
            return null;
        }
        GeoRenderer<?> geoRenderer = renderer;
        return geoRenderer.getGeoModel();
    }

    @Nullable
    public static GeoModel<?> getGeoModelForItem(ItemStack item) {
        return GeckoLibServices.Client.ITEM_RENDERING.getGeoModelForItem(item);
    }

    @Nullable
    public static GeoModel<?> getGeoModelForBlock(BlockEntity blockEntity) {
        GeoRenderer<?> renderer = Minecraft.getInstance().getBlockEntityRenderDispatcher().getRenderer(blockEntity);
        if (!(renderer instanceof GeoRenderer)) {
            return null;
        }
        GeoRenderer<?> geoRenderer = renderer;
        return geoRenderer.getGeoModel();
    }

    @Nullable
    public static GeoModel<?> getGeoModelForArmor(ItemStack stack) {
        return GeckoLibServices.Client.ITEM_RENDERING.getGeoModelForArmor(stack);
    }
}
