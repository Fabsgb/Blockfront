package software.bernie.geckolib.constant.dataticket;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/DataTicket.class */
public class DataTicket<D> {

    /* JADX INFO: renamed from: id */
    private final String f8809id;
    private final Class<? extends D> objectType;

    public DataTicket(String id, Class<? extends D> objectType) {
        this.f8809id = id;
        this.objectType = objectType;
    }

    /* JADX INFO: renamed from: id */
    public String m8008id() {
        return this.f8809id;
    }

    public Class<? extends D> objectType() {
        return this.objectType;
    }

    public int hashCode() {
        return Objects.hash(this.f8809id, this.objectType);
    }

    public <D> D getData(Map<? extends DataTicket<?>, ?> map) {
        return (D) map.get(this);
    }
}
