package foundry.veil.impl.client.render.shader.injection;

import foundry.veil.impl.client.render.shader.injection.util.Diagnostic;
import foundry.veil.impl.client.render.shader.injection.util.Severity;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import foundry.veil.impl.client.render.shader.injection.util.ValidationResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/injection/ShaderInjectionValidator.class */
@ApiStatus.Internal
public final class ShaderInjectionValidator {
    public static ValidationResult validate(ShaderInjectionDefinition injection) {
        return validate(injection, (String) null);
    }

    public static ValidationResult validate(ShaderInjectionDefinition injection, @Nullable String resourcePath) {
        List<Diagnostic> diagnostics = new ArrayList<>();
        validateInjection(injection, resourcePath, diagnostics);
        return new ValidationResult(diagnostics);
    }

    public static ValidationResult validate(Collection<ShaderInjectionDefinition> injections) {
        return validate(injections, (String) null);
    }

    public static ValidationResult validate(Collection<ShaderInjectionDefinition> injections, @Nullable String resourcePath) {
        List<Diagnostic> diagnostics = new ArrayList<>();
        for (ShaderInjectionDefinition injection : injections) {
            validateInjection(injection, resourcePath, diagnostics);
        }
        return new ValidationResult(diagnostics);
    }

    private static void validateInjection(ShaderInjectionDefinition injection, @Nullable String resourcePath, List<Diagnostic> diagnostics) {
        if (injection == null) {
            diagnostics.add(new Diagnostic(resourcePath, null, null, "injection", "Injection definition is null", Severity.ERROR));
            return;
        }
        if (injection.targets().isEmpty()) {
            diagnostics.add(new Diagnostic(resourcePath, injection.m7997id(), null, "targets", "Missing targets", Severity.ERROR));
        }
        boolean hasReplace = injection.replace() != null;
        boolean hasRedirects = !injection.redirects().isEmpty();
        if (hasReplace && hasRedirects) {
            diagnostics.add(new Diagnostic(resourcePath, injection.m7997id(), injection.target(), "replace", "Replace cannot be combined with redirect", Severity.ERROR));
        }
        if (!hasReplace && !hasRedirects) {
            diagnostics.add(new Diagnostic(resourcePath, injection.m7997id(), injection.target(), "redirect", "No redirect or replace specified", Severity.ERROR));
        }
    }
}
