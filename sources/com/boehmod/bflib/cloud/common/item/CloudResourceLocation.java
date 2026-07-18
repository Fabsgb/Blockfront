package com.boehmod.bflib.cloud.common.item;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CloudResourceLocation.class */
public final class CloudResourceLocation extends Record implements Comparable<CloudResourceLocation> {
    private final String namespace;
    private final String path;

    public CloudResourceLocation(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public String namespace() {
        return this.namespace;
    }

    public String path() {
        return this.path;
    }

    public void writeToByteBuffer(@NotNull ByteBuf byteBuffer) {
        IPacket.writeString(byteBuffer, this.namespace);
        IPacket.writeString(byteBuffer, this.path);
    }

    public void writeToJson(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty("namespace", this.namespace);
        jsonObject.addProperty("path", this.path);
    }

    @NotNull
    public static CloudResourceLocation readFromByteBuffer(@NotNull ByteBuf byteBuffer) {
        String namespace = IPacket.readString(byteBuffer);
        String path = IPacket.readString(byteBuffer);
        return new CloudResourceLocation(namespace, path);
    }

    @NotNull
    public static CloudResourceLocation readFromJson(@NotNull JsonObject jsonObject) {
        String namespace = jsonObject.get("namespace").getAsString();
        String path = jsonObject.get("path").getAsString();
        return new CloudResourceLocation(namespace, path);
    }

    @Override // java.lang.Record
    @NotNull
    public String toString() {
        return this.namespace + ":" + this.path;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull CloudResourceLocation other) {
        int namespaceComparison = this.namespace.compareTo(other.namespace);
        return namespaceComparison != 0 ? namespaceComparison : this.path.compareTo(other.path);
    }

    @Override // java.lang.Record
    public int hashCode() {
        return Objects.hash(this.namespace, this.path);
    }

    @Override // java.lang.Record
    public boolean equals(Object o) throws MatchException {
        boolean b;
        if (this == o) {
            return true;
        }
        if (o instanceof CloudResourceLocation) {
            CloudResourceLocation cloudResourceLocation = (CloudResourceLocation) o;
            try {
                String ns = cloudResourceLocation.namespace();
                String p = cloudResourceLocation.path();
                b = this.namespace.equals(ns) && this.path.equals(p);
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        } else {
            b = false;
        }
        return b;
    }
}
