package software.bernie.geckolib.loading.json.raw;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Direction;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/UVFaces.class */
public final class UVFaces extends Record {

    @Nullable
    private final FaceUV north;

    @Nullable
    private final FaceUV south;

    @Nullable
    private final FaceUV east;

    @Nullable
    private final FaceUV west;

    /* JADX INFO: renamed from: up */
    @Nullable
    private final FaceUV f8812up;

    @Nullable
    private final FaceUV down;

    public UVFaces(@Nullable FaceUV north, @Nullable FaceUV south, @Nullable FaceUV east, @Nullable FaceUV west, @Nullable FaceUV up, @Nullable FaceUV down) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.f8812up = up;
        this.down = down;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, UVFaces.class), UVFaces.class, "north;south;east;west;up;down", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->north:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->south:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->east:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->west:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->up:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->down:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, UVFaces.class), UVFaces.class, "north;south;east;west;up;down", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->north:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->south:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->east:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->west:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->up:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->down:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, UVFaces.class, Object.class), UVFaces.class, "north;south;east;west;up;down", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->north:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->south:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->east:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->west:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->up:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;", "FIELD:Lsoftware/bernie/geckolib/loading/json/raw/UVFaces;->down:Lsoftware/bernie/geckolib/loading/json/raw/FaceUV;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public FaceUV north() {
        return this.north;
    }

    @Nullable
    public FaceUV south() {
        return this.south;
    }

    @Nullable
    public FaceUV east() {
        return this.east;
    }

    @Nullable
    public FaceUV west() {
        return this.west;
    }

    @Nullable
    /* JADX INFO: renamed from: up */
    public FaceUV m8011up() {
        return this.f8812up;
    }

    @Nullable
    public FaceUV down() {
        return this.down;
    }

    public static JsonDeserializer<UVFaces> deserializer() {
        return (json, type, context) -> {
            JsonObject obj = json.getAsJsonObject();
            FaceUV north = (FaceUV) GsonHelper.getAsObject(obj, "north", (Object) null, context, FaceUV.class);
            FaceUV south = (FaceUV) GsonHelper.getAsObject(obj, "south", (Object) null, context, FaceUV.class);
            FaceUV east = (FaceUV) GsonHelper.getAsObject(obj, "east", (Object) null, context, FaceUV.class);
            FaceUV west = (FaceUV) GsonHelper.getAsObject(obj, "west", (Object) null, context, FaceUV.class);
            FaceUV up = (FaceUV) GsonHelper.getAsObject(obj, "up", (Object) null, context, FaceUV.class);
            FaceUV down = (FaceUV) GsonHelper.getAsObject(obj, "down", (Object) null, context, FaceUV.class);
            return new UVFaces(north, south, east, west, up, down);
        };
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.loading.json.raw.UVFaces$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/json/raw/UVFaces$1.class */
    static /* synthetic */ class C14711 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 4;
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public FaceUV fromDirection(Direction direction) throws MatchException {
        switch (C14711.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 1:
                return this.north;
            case 2:
                return this.south;
            case 3:
                return this.east;
            case 4:
                return this.west;
            case 5:
                return this.f8812up;
            case 6:
                return this.down;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
