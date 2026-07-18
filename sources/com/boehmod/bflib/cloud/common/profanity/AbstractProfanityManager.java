package com.boehmod.bflib.cloud.common.profanity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.unimi.dsi.fastutil.chars.Char2CharOpenHashMap;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/profanity/AbstractProfanityManager.class */
public abstract class AbstractProfanityManager {
    private static final Char2CharOpenHashMap NORMALIZATION_MAP = new Char2CharOpenHashMap();
    private static final int MAX_REPEATED_CHARACTERS = 9;
    private static final int MAX_WORD_LENGTH = 20;
    private static final int STRUCTURAL_VIOLATION_SEVERITY = 2;

    @Nullable
    private List<Profanity> profanities;
    private boolean isActive;

    protected abstract void handleProfanityImmediately(@NotNull UUID uuid, @NotNull Profanity profanity, @NotNull String str);

    protected abstract void log(@NotNull String str, Object... objArr);

    protected abstract void logError(@NotNull String str, Object... objArr);

    static {
        NORMALIZATION_MAP.put('0', 'o');
        NORMALIZATION_MAP.put('1', 'i');
        NORMALIZATION_MAP.put('!', 'i');
        NORMALIZATION_MAP.put('3', 'e');
        NORMALIZATION_MAP.put('4', 'a');
        NORMALIZATION_MAP.put('@', 'a');
        NORMALIZATION_MAP.put('5', 's');
        NORMALIZATION_MAP.put('$', 's');
        NORMALIZATION_MAP.put('7', 't');
        NORMALIZATION_MAP.put('8', 'b');
        NORMALIZATION_MAP.put('#', 'h');
    }

    public AbstractProfanityManager() {
        this.isActive = false;
        this.profanities = Collections.emptyList();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager$1] */
    public AbstractProfanityManager(@NotNull Path profanitiesFilePath) {
        File profanitiesFile = profanitiesFilePath.toFile();
        if (!profanitiesFile.exists()) {
            this.isActive = false;
            log("The profanity filter has been disabled. ('%s' file not found)", profanitiesFile.getAbsolutePath());
            return;
        }
        try {
            FileReader fileReader = new FileReader(profanitiesFile);
            try {
                Gson gson = new Gson();
                this.profanities = (List) gson.fromJson(fileReader, new TypeToken<List<Profanity>>(this) { // from class: com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager.1
                }.getType());
                this.profanities.forEach((v0) -> {
                    v0.initPattern();
                });
                this.isActive = true;
                log("The profanity filter has been enabled. ('%s' file found)", profanitiesFile.getAbsolutePath());
                fileReader.close();
            } finally {
            }
        } catch (IOException e) {
            this.isActive = false;
            logError("The profanity filter has been disabled. (%s)", e.getMessage());
        }
    }

    public void setProfanities(@NotNull List<Profanity> profanities) {
        this.profanities = profanities;
        this.profanities.forEach((v0) -> {
            v0.initPattern();
        });
        this.isActive = !profanities.isEmpty();
        log("Profanity filter updated with %d entries. Active: %s", Integer.valueOf(profanities.size()), Boolean.valueOf(this.isActive));
    }

    public boolean isActive() {
        return this.isActive;
    }

    public int processMessage(@NotNull UUID playerUUID, @NotNull String message) {
        if (!this.isActive || this.profanities == null) {
            return 0;
        }
        if (hasStructuralViolation(message)) {
            return 2;
        }
        String normalizedMessage = normalizeMessage(message);
        boolean isSingleWord = !normalizedMessage.contains(" ");
        int maxSeverity = 0;
        for (Profanity profanity : this.profanities) {
            if (!isSingleWord || !profanity.getIgnoreStandalone()) {
                Pattern pattern = profanity.getPattern();
                Matcher matcher = pattern.matcher(normalizedMessage);
                while (matcher.find()) {
                    String matched = matcher.group();
                    boolean allowPartial = profanity.getAllowPartial().booleanValue();
                    if (!isException(profanity, matched) && (allowPartial || matched.equalsIgnoreCase(profanity.getMatch()))) {
                        handleProfanityImmediately(playerUUID, profanity, message);
                        maxSeverity = Math.max(maxSeverity, profanity.getSeverity());
                    }
                }
            }
        }
        return maxSeverity;
    }

    private boolean hasStructuralViolation(@NotNull String message) {
        return hasExcessiveCharacterRun(message) || hasOverlyLongWord(message);
    }

    private boolean hasExcessiveCharacterRun(@NotNull String message) {
        int runLength = 1;
        for (int i = 1; i < message.length(); i++) {
            char current = Character.toLowerCase(message.charAt(i));
            char previous = Character.toLowerCase(message.charAt(i - 1));
            if (current == previous && !Character.isWhitespace(current)) {
                runLength++;
                if (runLength > 9) {
                    return true;
                }
            } else {
                runLength = 1;
            }
        }
        return false;
    }

    private boolean hasOverlyLongWord(@NotNull String message) {
        for (String word : message.split(" ")) {
            if (word.length() > 20) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    private String normalizeMessage(@NotNull String message) {
        StringBuilder normalized = new StringBuilder(message.length());
        for (char c : message.toCharArray()) {
            char replacement = NORMALIZATION_MAP.getOrDefault(c, c);
            if (Character.isLetter(replacement) || Character.isWhitespace(replacement)) {
                normalized.append(Character.toLowerCase(replacement));
            }
        }
        return normalized.toString();
    }

    private boolean isException(@NotNull Profanity profanity, @NotNull String matched) {
        Stream<R> map = profanity.getExceptions().stream().map(exception -> {
            return exception.replace("*", matched);
        });
        Objects.requireNonNull(matched);
        return map.anyMatch(matched::matches);
    }
}
