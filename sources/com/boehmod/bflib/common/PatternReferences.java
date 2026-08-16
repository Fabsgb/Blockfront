package com.boehmod.bflib.common;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/common/PatternReferences.class */
public class PatternReferences {

    @NotNull
    public static final Pattern MINECRAFT_USERNAME = Pattern.compile("^[a-zA-Z0-9_]{2,16}$");

    @NotNull
    public static final Pattern UUID = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    @NotNull
    public static final Pattern LINK = Pattern.compile("^(http|https)://");

    @NotNull
    public static final Pattern CLAN_NAME = Pattern.compile("^[a-zA-Z0-9_-]{2,4}$");

    @NotNull
    public static final Pattern IP_ADDRESS = Pattern.compile("^([0-9]{1,3}\\.){3}[0-9]{1,3}$");

    @NotNull
    public static final Pattern XRAY = Pattern.compile("x[\\-_]?ray", 2);

    @NotNull
    public static final Pattern ANYTHING = Pattern.compile("(.*?)");

    @NotNull
    public static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]*$");

    @NotNull
    public static final Pattern NUMERIC = Pattern.compile("^[0-9]*$");

    @NotNull
    public static final Pattern COMMON = Pattern.compile("^[a-zA-Z0-9~!@#$£%^&*()`\\[\\]{};':,./<>?| ]*$");

    @NotNull
    public static final Pattern NO_UPPERCASE = Pattern.compile("^[^A-Z]*$");

    @NotNull
    public static final Pattern NO_LOWERCASE = Pattern.compile("^[^a-z]*$");

    @NotNull
    public static final Pattern MINECRAFT_RESOURCE = Pattern.compile("^[a-z0-9/._-]*$");
}
