package software.bernie.geckolib.constant.dataticket;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/DataTicket.class */
public class DataTicket<D> {
    private final String id;
    private final Class<? extends D> objectType;

    public DataTicket(String id, Class<? extends D> objectType) {
        this.id = id;
        this.objectType = objectType;
    }

    public String id() {
        return this.id;
    }

    public Class<? extends D> objectType() {
        return this.objectType;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.objectType);
    }

    public <D> D getData(Map<? extends DataTicket<?>, ?> map) {
        return (D) map.get(this);
    }
}
