package foundry.veil.api.client.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/util/DebugRenderHelper.class */
public final class DebugRenderHelper {
    private DebugRenderHelper() {
    }

    public static void renderCube(PoseStack pPoseStack, VertexConsumer pConsumer, float pRed, float pGreen, float pBlue, float pAlpha) {
        renderBox(pPoseStack, pConsumer, 0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 1.0d, pRed, pGreen, pBlue, pAlpha);
    }

    public static void renderBox(PoseStack pPoseStack, VertexConsumer pConsumer, double pMinX, double pMinY, double pMinZ, double pMaxX, double pMaxY, double pMaxZ, float pRed, float pGreen, float pBlue, float pAlpha) {
        PoseStack.Pose pose = pPoseStack.last();
        float iX = (float) pMinX;
        float iY = (float) pMinY;
        float iZ = (float) pMinZ;
        float aX = (float) pMaxX;
        float aY = (float) pMaxY;
        float aZ = (float) pMaxZ;
        pConsumer.addVertex(pose, iX, iY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, aX, iY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, iX, iY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 1.0f, 0.0f);
        pConsumer.addVertex(pose, iX, aY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 1.0f, 0.0f);
        pConsumer.addVertex(pose, iX, iY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, 1.0f);
        pConsumer.addVertex(pose, iX, iY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, 1.0f);
        pConsumer.addVertex(pose, aX, iY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 1.0f, 0.0f);
        pConsumer.addVertex(pose, aX, aY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 1.0f, 0.0f);
        pConsumer.addVertex(pose, aX, aY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, -1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, iX, aY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, -1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, iX, aY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, 1.0f);
        pConsumer.addVertex(pose, iX, aY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, 1.0f);
        pConsumer.addVertex(pose, iX, aY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, -1.0f, 0.0f);
        pConsumer.addVertex(pose, iX, iY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, -1.0f, 0.0f);
        pConsumer.addVertex(pose, iX, iY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, aX, iY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, aX, iY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, -1.0f);
        pConsumer.addVertex(pose, aX, iY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, -1.0f);
        pConsumer.addVertex(pose, iX, aY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, aX, aY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 1.0f, 0.0f, 0.0f);
        pConsumer.addVertex(pose, aX, iY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 1.0f, 0.0f);
        pConsumer.addVertex(pose, aX, aY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 1.0f, 0.0f);
        pConsumer.addVertex(pose, aX, aY, iZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, 1.0f);
        pConsumer.addVertex(pose, aX, aY, aZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, 0.0f, 0.0f, 1.0f);
    }

    public static void renderBox(PoseStack pPoseStack, VertexConsumer pConsumer, AABB box, float pRed, float pGreen, float pBlue, float pAlpha) {
        renderBox(pPoseStack, pConsumer, box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ, pRed, pGreen, pBlue, pAlpha);
    }

    public static void renderSphere(PoseStack pPoseStack, VertexConsumer pConsumer, int resolution, float radius, double x, double y, double z, float pRed, float pGreen, float pBlue, float pAlpha) {
        pPoseStack.pushPose();
        pPoseStack.translate(x, y, z);
        for (int i = 0; i < 3; i++) {
            pPoseStack.pushPose();
            switch (i) {
                case 1:
                    pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
                    break;
                case 2:
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
                    break;
            }
            PoseStack.Pose pose = pPoseStack.last();
            pPoseStack.popPose();
            for (int segment = 0; segment < resolution; segment++) {
                float angle1 = (segment / resolution) * 6.2831855f;
                float angle2 = ((segment + 1) / resolution) * 6.2831855f;
                float s1 = Mth.sin(angle1) * radius;
                float c1 = Mth.cos(angle1) * radius;
                float s2 = Mth.sin(angle2) * radius;
                float c2 = Mth.cos(angle2) * radius;
                Vector3f normal = new Vector3f(s1, 0.0f, c1);
                normal.sub(new Vector3f(s2, 0.0f, c2));
                normal.normalize();
                renderLine(pose, pConsumer, s1, c1, 0.0f, s2, c2, 0.0f, pRed, pGreen, pBlue, pAlpha);
            }
        }
        pPoseStack.popPose();
    }

    public static void renderCircle(PoseStack pPoseStack, VertexConsumer pConsumer, int resolution, float radius, double x, double y, double z, float pRed, float pGreen, float pBlue, float pAlpha) {
        Minecraft mc = Minecraft.getInstance();
        Camera pRenderInfo = mc.gameRenderer.getMainCamera();
        Quaternionf rotation = pRenderInfo.rotation();
        pPoseStack.pushPose();
        pPoseStack.translate(x, y, z);
        pPoseStack.mulPose(rotation);
        PoseStack.Pose pose = pPoseStack.last();
        for (int segment = 0; segment < resolution; segment++) {
            float angle1 = (segment / resolution) * 6.2831855f;
            float angle2 = ((segment + 1) / resolution) * 6.2831855f;
            float s1 = Mth.sin(angle1) * radius;
            float c1 = Mth.cos(angle1) * radius;
            float s2 = Mth.sin(angle2) * radius;
            float c2 = Mth.cos(angle2) * radius;
            Vector3f normal = new Vector3f(s1, 0.0f, c1);
            normal.sub(new Vector3f(s2, 0.0f, c2));
            normal.normalize();
            renderLine(pose, pConsumer, s1, c1, 0.0f, s2, c2, 0.0f, pRed, pGreen, pBlue, pAlpha);
        }
        pPoseStack.popPose();
    }

    public static void renderLine(PoseStack pPoseStack, VertexConsumer pConsumer, double pMinX, double pMinY, double pMinZ, double pMaxX, double pMaxY, double pMaxZ, float pRed, float pGreen, float pBlue, float pAlpha) {
        PoseStack.Pose pose = pPoseStack.last();
        float minX = (float) pMinX;
        float minY = (float) pMinY;
        float minZ = (float) pMinZ;
        float maxX = (float) pMaxX;
        float maxY = (float) pMaxY;
        float maxZ = (float) pMaxZ;
        Vector3f normal = new Vector3f(minX, minY, minZ);
        normal.sub(new Vector3f(maxX, maxY, maxZ));
        normal.normalize();
        pConsumer.addVertex(pose, minX, minY, minZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, normal.x(), normal.y(), normal.z());
        pConsumer.addVertex(pose, maxX, maxY, maxZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, normal.x(), normal.y(), normal.z());
    }

    public static void renderLine(PoseStack pPoseStack, VertexConsumer pConsumer, double pMinX, double pMinY, double pMinZ, double pMaxX, double pMaxY, double pMaxZ, float r1, float g1, float b1, float a1, float r2, float g2, float b2, float a2) {
        PoseStack.Pose pose = pPoseStack.last();
        float minX = (float) pMinX;
        float minY = (float) pMinY;
        float minZ = (float) pMinZ;
        float maxX = (float) pMaxX;
        float maxY = (float) pMaxY;
        float maxZ = (float) pMaxZ;
        Vector3f normal = new Vector3f(minX, minY, minZ);
        normal.sub(new Vector3f(maxX, maxY, maxZ));
        normal.normalize();
        pConsumer.addVertex(pose, minX, minY, minZ).setColor(r1, g1, b1, a1).setNormal(pose, normal.x(), normal.y(), normal.z());
        pConsumer.addVertex(pose, maxX, maxY, maxZ).setColor(r2, g2, b2, a2).setNormal(pose, normal.x(), normal.y(), normal.z());
    }

    public static void renderLine(PoseStack.Pose pose, VertexConsumer pConsumer, float minX, float minY, float minZ, float maxX, float maxY, float maxZ, float pRed, float pGreen, float pBlue, float pAlpha) {
        Vector3f normal = new Vector3f(minX, minY, minZ);
        normal.sub(new Vector3f(maxX, maxY, maxZ));
        normal.normalize();
        pConsumer.addVertex(pose, minX, minY, minZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, normal.x(), normal.y(), normal.z());
        pConsumer.addVertex(pose, maxX, maxY, maxZ).setColor(pRed, pGreen, pBlue, pAlpha).setNormal(pose, normal.x(), normal.y(), normal.z());
    }
}
