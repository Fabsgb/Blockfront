package foundry.veil.impl;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/ClientEnumArgument.class */
public class ClientEnumArgument<T extends Enum<T>> implements ArgumentType<T> {
    private static final Dynamic2CommandExceptionType INVALID_ENUM = new Dynamic2CommandExceptionType((found, constants) -> {
        return Component.translatable("commands.veil.arguments.enum.invalid", new Object[]{found, constants});
    });
    private final Class<T> enumClass;

    private ClientEnumArgument(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    public static <R extends Enum<R>> ClientEnumArgument<R> enumArgument(Class<R> enumClass) {
        return new ClientEnumArgument<>(enumClass);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.mojang.brigadier.exceptions.CommandSyntaxException */
    /* JADX INFO: renamed from: parse, reason: merged with bridge method [inline-methods] */
    public T m9517parse(StringReader stringReader) throws CommandSyntaxException {
        String unquotedString = stringReader.readUnquotedString();
        try {
            return (T) Enum.valueOf(this.enumClass, unquotedString.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw INVALID_ENUM.createWithContext(stringReader, unquotedString, Arrays.stream(this.enumClass.getEnumConstants()).map(value -> {
                return value.name().toLowerCase(Locale.ROOT);
            }).collect(Collectors.joining(", ")));
        }
    }

    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return SharedSuggestionProvider.suggest(Arrays.stream(this.enumClass.getEnumConstants()).map(value -> {
            return value.name().toLowerCase(Locale.ROOT);
        }), builder);
    }

    public Collection<String> getExamples() {
        return (Collection) Arrays.stream(this.enumClass.getEnumConstants()).map((v0) -> {
            return v0.name();
        }).collect(Collectors.toList());
    }
}
