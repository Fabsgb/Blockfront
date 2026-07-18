package com.boehmod.bflib.cloud.common.profanity;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.google.gson.annotations.SerializedName;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/profanity/Profanity.class */
public class Profanity {

    /* JADX INFO: renamed from: id */
    @SerializedName("id")
    private String f18id;

    @SerializedName("match")
    private String match;

    @SerializedName("severity")
    private int severity;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("allowPartial")
    private Boolean allowPartial;

    @SerializedName("exceptions")
    private List<String> exceptions;

    @SerializedName("ignoreStandalone")
    private Boolean ignoreStandalone;
    private transient Pattern pattern;

    public Profanity() {
    }

    public Profanity(@NotNull ByteBuf byteBuffer) {
        this.f18id = IPacket.readString(byteBuffer);
        this.match = IPacket.readString(byteBuffer);
        this.severity = byteBuffer.readInt();
        this.allowPartial = Boolean.valueOf(IPacket.readBoolean(byteBuffer));
        int tagsSize = byteBuffer.readInt();
        this.tags = new ObjectArrayList(tagsSize);
        for (int i = 0; i < tagsSize; i++) {
            this.tags.add(IPacket.readString(byteBuffer));
        }
        int exceptionsSize = byteBuffer.readInt();
        this.exceptions = new ObjectArrayList(exceptionsSize);
        for (int i2 = 0; i2 < exceptionsSize; i2++) {
            this.exceptions.add(IPacket.readString(byteBuffer));
        }
        this.ignoreStandalone = Boolean.valueOf(IPacket.readBoolean(byteBuffer));
    }

    public void write(@NotNull ByteBuf byteBuffer) {
        IPacket.writeString(byteBuffer, this.f18id);
        IPacket.writeString(byteBuffer, this.match);
        byteBuffer.writeInt(this.severity);
        IPacket.writeBoolean(byteBuffer, getAllowPartial().booleanValue());
        List<String> tagsList = getTags();
        byteBuffer.writeInt(tagsList.size());
        for (String tag : tagsList) {
            IPacket.writeString(byteBuffer, tag);
        }
        List<String> exceptionsList = getExceptions();
        byteBuffer.writeInt(exceptionsList.size());
        for (String exception : exceptionsList) {
            IPacket.writeString(byteBuffer, exception);
        }
        IPacket.writeBoolean(byteBuffer, getIgnoreStandalone());
    }

    public void initPattern() {
        String patternString = "\\b(" + this.match + ")\\b";
        this.pattern = Pattern.compile(patternString, 2);
    }

    @NotNull
    public Pattern getPattern() {
        return this.pattern;
    }

    @NotNull
    public String getId() {
        return this.f18id;
    }

    public void setId(@NotNull String id) {
        this.f18id = id;
    }

    @NotNull
    public String getMatch() {
        return this.match;
    }

    public void setMatch(@NotNull String match) {
        this.match = match;
    }

    public int getSeverity() {
        return this.severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @NotNull
    public List<String> getTags() {
        return this.tags == null ? new ObjectArrayList() : this.tags;
    }

    public void setTags(@NotNull List<String> tags) {
        this.tags = tags;
    }

    @NotNull
    public Boolean getAllowPartial() {
        return Boolean.valueOf(this.allowPartial == null || this.allowPartial.booleanValue());
    }

    public void setAllowPartial(@NotNull Boolean allowPartial) {
        this.allowPartial = allowPartial;
    }

    @NotNull
    public List<String> getExceptions() {
        return this.exceptions == null ? new ObjectArrayList() : this.exceptions;
    }

    public void setExceptions(@NotNull List<String> exceptions) {
        this.exceptions = exceptions;
    }

    public boolean getIgnoreStandalone() {
        return this.ignoreStandalone != null && this.ignoreStandalone.booleanValue();
    }

    public void setIgnoreStandalone(boolean ignoreStandalone) {
        this.ignoreStandalone = Boolean.valueOf(ignoreStandalone);
    }
}
