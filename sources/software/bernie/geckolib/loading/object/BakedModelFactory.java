package software.bernie.geckolib.loading.object;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.cache.object.GeoQuad;
import software.bernie.geckolib.cache.object.GeoVertex;
import software.bernie.geckolib.loading.json.raw.Bone;
import software.bernie.geckolib.loading.json.raw.Cube;
import software.bernie.geckolib.loading.json.raw.FaceUV;
import software.bernie.geckolib.loading.json.raw.ModelProperties;
import software.bernie.geckolib.loading.json.raw.UVUnion;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/object/BakedModelFactory.class */
public interface BakedModelFactory {
    public static final Map<String, BakedModelFactory> FACTORIES = new Object2ObjectOpenHashMap(1);
    public static final BakedModelFactory DEFAULT_FACTORY = new Builtin();

    BakedGeoModel constructGeoModel(GeometryTree geometryTree);

    GeoBone constructBone(BoneStructure boneStructure, ModelProperties modelProperties, @Nullable GeoBone geoBone);

    GeoCube constructCube(Cube cube, ModelProperties modelProperties, GeoBone geoBone);

    default GeoQuad[] buildQuads(UVUnion uvUnion, VertexSet vertices, Cube cube, float textureWidth, float textureHeight, boolean mirror) {
        GeoQuad[] quads = {buildQuad(vertices, cube, uvUnion, textureWidth, textureHeight, mirror, Direction.WEST), buildQuad(vertices, cube, uvUnion, textureWidth, textureHeight, mirror, Direction.EAST), buildQuad(vertices, cube, uvUnion, textureWidth, textureHeight, mirror, Direction.NORTH), buildQuad(vertices, cube, uvUnion, textureWidth, textureHeight, mirror, Direction.SOUTH), buildQuad(vertices, cube, uvUnion, textureWidth, textureHeight, mirror, Direction.UP), buildQuad(vertices, cube, uvUnion, textureWidth, textureHeight, mirror, Direction.DOWN)};
        return quads;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    default GeoQuad buildQuad(VertexSet vertices, Cube cube, UVUnion uvUnion, float textureWidth, float textureHeight, boolean mirror, Direction direction) throws MatchException {
        double[][] dArr;
        if (!uvUnion.isBoxUV()) {
            FaceUV faceUV = uvUnion.faceUV().fromDirection(direction);
            if (faceUV == null) {
                return null;
            }
            return GeoQuad.build(vertices.verticesForQuad(direction, false, mirror || cube.mirror() == Boolean.TRUE), faceUV.m8361uv(), faceUV.uvSize(), faceUV.uvRotation(), textureWidth, textureHeight, mirror, direction);
        }
        double[] uv = cube.m8360uv().boxUVCoords();
        double[] uvSize = cube.size();
        Vec3 uvSizeVec = new Vec3(Math.floor(uvSize[0]), Math.floor(uvSize[1]), Math.floor(uvSize[2]));
        switch (C14981.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 1:
                dArr = new double[][]{new double[]{uv[0] + uvSizeVec.z + uvSizeVec.x, uv[1] + uvSizeVec.z}, new double[]{uvSizeVec.z, uvSizeVec.y}};
                break;
            case 2:
                dArr = new double[][]{new double[]{uv[0], uv[1] + uvSizeVec.z}, new double[]{uvSizeVec.z, uvSizeVec.y}};
                break;
            case 3:
                dArr = new double[][]{new double[]{uv[0] + uvSizeVec.z, uv[1] + uvSizeVec.z}, new double[]{uvSizeVec.x, uvSizeVec.y}};
                break;
            case 4:
                dArr = new double[][]{new double[]{uv[0] + uvSizeVec.z + uvSizeVec.x + uvSizeVec.z, uv[1] + uvSizeVec.z}, new double[]{uvSizeVec.x, uvSizeVec.y}};
                break;
            case 5:
                dArr = new double[][]{new double[]{uv[0] + uvSizeVec.z, uv[1]}, new double[]{uvSizeVec.x, uvSizeVec.z}};
                break;
            case 6:
                dArr = new double[][]{new double[]{uv[0] + uvSizeVec.z + uvSizeVec.x, uv[1] + uvSizeVec.z}, new double[]{uvSizeVec.x, -uvSizeVec.z}};
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        double[][] uvData = dArr;
        return GeoQuad.build(vertices.verticesForQuad(direction, true, mirror || cube.mirror() == Boolean.TRUE), uvData[0], uvData[1], FaceUV.Rotation.NONE, textureWidth, textureHeight, mirror, direction);
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.loading.object.BakedModelFactory$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/object/BakedModelFactory$1.class */
    static /* synthetic */ class C14981 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static BakedModelFactory getForNamespace(String namespace) {
        return FACTORIES.getOrDefault(namespace, DEFAULT_FACTORY);
    }

    static void register(String namespace, BakedModelFactory factory) {
        FACTORIES.put(namespace, factory);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/object/BakedModelFactory$Builtin.class */
    public static final class Builtin implements BakedModelFactory {
        @Override // software.bernie.geckolib.loading.object.BakedModelFactory
        public BakedGeoModel constructGeoModel(GeometryTree geometryTree) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (BoneStructure boneStructure : geometryTree.topLevelBones().values()) {
                objectArrayList.add(constructBone(boneStructure, geometryTree.properties(), null));
            }
            return new BakedGeoModel(objectArrayList, geometryTree.properties());
        }

        @Override // software.bernie.geckolib.loading.object.BakedModelFactory
        public GeoBone constructBone(BoneStructure boneStructure, ModelProperties properties, GeoBone parent) {
            Bone bone = boneStructure.self();
            GeoBone newBone = new GeoBone(parent, bone.name(), bone.mirror(), bone.inflate(), bone.neverRender(), bone.reset());
            Vec3 rotation = RenderUtil.arrayToVec(bone.rotation());
            Vec3 pivot = RenderUtil.arrayToVec(bone.pivot());
            newBone.updateRotation((float) Math.toRadians(-rotation.x), (float) Math.toRadians(-rotation.y), (float) Math.toRadians(rotation.z));
            newBone.updatePivot((float) (-pivot.x), (float) pivot.y, (float) pivot.z);
            for (Cube cube : bone.cubes()) {
                newBone.getCubes().add(constructCube(cube, properties, newBone));
            }
            for (BoneStructure child : boneStructure.children().values()) {
                newBone.getChildBones().add(constructBone(child, properties, newBone));
            }
            return newBone;
        }

        @Override // software.bernie.geckolib.loading.object.BakedModelFactory
        public GeoCube constructCube(Cube cube, ModelProperties properties, GeoBone bone) {
            double dDoubleValue;
            boolean mirror = cube.mirror() == Boolean.TRUE;
            if (cube.inflate() != null) {
                dDoubleValue = cube.inflate().doubleValue() / 16.0d;
            } else {
                dDoubleValue = bone.getInflate() == null ? 0.0d : bone.getInflate().doubleValue() / 16.0d;
            }
            double inflate = dDoubleValue;
            Vec3 size = RenderUtil.arrayToVec(cube.size());
            Vec3 origin = RenderUtil.arrayToVec(cube.origin());
            Vec3 rotation = RenderUtil.arrayToVec(cube.rotation());
            Vec3 pivot = RenderUtil.arrayToVec(cube.pivot());
            Vec3 origin2 = new Vec3((-(origin.x + size.x)) / 16.0d, origin.y / 16.0d, origin.z / 16.0d);
            Vec3 vertexSize = size.multiply(0.0625d, 0.0625d, 0.0625d);
            Vec3 pivot2 = pivot.multiply(-1.0d, 1.0d, 1.0d);
            Vec3 rotation2 = new Vec3(Math.toRadians(-rotation.x), Math.toRadians(-rotation.y), Math.toRadians(rotation.z));
            GeoQuad[] quads = buildQuads(cube.m8360uv(), new VertexSet(origin2, vertexSize, inflate), cube, (float) properties.textureWidth(), (float) properties.textureHeight(), mirror);
            return new GeoCube(quads, pivot2, rotation2, size, inflate, mirror);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/object/BakedModelFactory$VertexSet.class */
    public static final class VertexSet extends Record {
        private final GeoVertex bottomLeftBack;
        private final GeoVertex bottomRightBack;
        private final GeoVertex topLeftBack;
        private final GeoVertex topRightBack;
        private final GeoVertex topLeftFront;
        private final GeoVertex topRightFront;
        private final GeoVertex bottomLeftFront;
        private final GeoVertex bottomRightFront;

        public VertexSet(GeoVertex bottomLeftBack, GeoVertex bottomRightBack, GeoVertex topLeftBack, GeoVertex topRightBack, GeoVertex topLeftFront, GeoVertex topRightFront, GeoVertex bottomLeftFront, GeoVertex bottomRightFront) {
            this.bottomLeftBack = bottomLeftBack;
            this.bottomRightBack = bottomRightBack;
            this.topLeftBack = topLeftBack;
            this.topRightBack = topRightBack;
            this.topLeftFront = topLeftFront;
            this.topRightFront = topRightFront;
            this.bottomLeftFront = bottomLeftFront;
            this.bottomRightFront = bottomRightFront;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VertexSet.class), VertexSet.class, "bottomLeftBack;bottomRightBack;topLeftBack;topRightBack;topLeftFront;topRightFront;bottomLeftFront;bottomRightFront", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomLeftBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomRightBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topLeftBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topRightBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topLeftFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topRightFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomLeftFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomRightFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VertexSet.class), VertexSet.class, "bottomLeftBack;bottomRightBack;topLeftBack;topRightBack;topLeftFront;topRightFront;bottomLeftFront;bottomRightFront", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomLeftBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomRightBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topLeftBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topRightBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topLeftFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topRightFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomLeftFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomRightFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VertexSet.class, Object.class), VertexSet.class, "bottomLeftBack;bottomRightBack;topLeftBack;topRightBack;topLeftFront;topRightFront;bottomLeftFront;bottomRightFront", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomLeftBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomRightBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topLeftBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topRightBack:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topLeftFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->topRightFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomLeftFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedModelFactory$VertexSet;->bottomRightFront:Lsoftware/bernie/geckolib/cache/object/GeoVertex;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public GeoVertex bottomLeftBack() {
            return this.bottomLeftBack;
        }

        public GeoVertex bottomRightBack() {
            return this.bottomRightBack;
        }

        public GeoVertex topLeftBack() {
            return this.topLeftBack;
        }

        public GeoVertex topRightBack() {
            return this.topRightBack;
        }

        public GeoVertex topLeftFront() {
            return this.topLeftFront;
        }

        public GeoVertex topRightFront() {
            return this.topRightFront;
        }

        public GeoVertex bottomLeftFront() {
            return this.bottomLeftFront;
        }

        public GeoVertex bottomRightFront() {
            return this.bottomRightFront;
        }

        public VertexSet(Vec3 origin, Vec3 vertexSize, double inflation) {
            this(new GeoVertex(origin.x - inflation, origin.y - inflation, origin.z - inflation), new GeoVertex(origin.x - inflation, origin.y - inflation, origin.z + vertexSize.z + inflation), new GeoVertex(origin.x - inflation, origin.y + vertexSize.y + inflation, origin.z - inflation), new GeoVertex(origin.x - inflation, origin.y + vertexSize.y + inflation, origin.z + vertexSize.z + inflation), new GeoVertex(origin.x + vertexSize.x + inflation, origin.y + vertexSize.y + inflation, origin.z - inflation), new GeoVertex(origin.x + vertexSize.x + inflation, origin.y + vertexSize.y + inflation, origin.z + vertexSize.z + inflation), new GeoVertex(origin.x + vertexSize.x + inflation, origin.y - inflation, origin.z - inflation), new GeoVertex(origin.x + vertexSize.x + inflation, origin.y - inflation, origin.z + vertexSize.z + inflation));
        }

        public GeoVertex[] quadWest() {
            return new GeoVertex[]{this.topRightBack, this.topLeftBack, this.bottomLeftBack, this.bottomRightBack};
        }

        public GeoVertex[] quadEast() {
            return new GeoVertex[]{this.topLeftFront, this.topRightFront, this.bottomRightFront, this.bottomLeftFront};
        }

        public GeoVertex[] quadNorth() {
            return new GeoVertex[]{this.topLeftBack, this.topLeftFront, this.bottomLeftFront, this.bottomLeftBack};
        }

        public GeoVertex[] quadSouth() {
            return new GeoVertex[]{this.topRightFront, this.topRightBack, this.bottomRightBack, this.bottomRightFront};
        }

        public GeoVertex[] quadUp() {
            return new GeoVertex[]{this.topRightBack, this.topRightFront, this.topLeftFront, this.topLeftBack};
        }

        public GeoVertex[] quadDown() {
            return new GeoVertex[]{this.bottomLeftBack, this.bottomLeftFront, this.bottomRightFront, this.bottomRightBack};
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public GeoVertex[] verticesForQuad(Direction direction, boolean boxUv, boolean mirror) throws MatchException {
            switch (C14981.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
                case 1:
                    return mirror ? quadEast() : quadWest();
                case 2:
                    return mirror ? quadWest() : quadEast();
                case 3:
                    return quadNorth();
                case 4:
                    return quadSouth();
                case 5:
                    return (!mirror || boxUv) ? quadUp() : quadDown();
                case 6:
                    return (!mirror || boxUv) ? quadDown() : quadUp();
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }
}
