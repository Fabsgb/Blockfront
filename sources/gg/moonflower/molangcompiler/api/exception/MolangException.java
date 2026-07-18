package gg.moonflower.molangcompiler.api.exception;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/exception/MolangException.class */
public class MolangException extends Exception {
    public MolangException(String message) {
        super(message, null, true, true);
    }

    public MolangException(String message, Throwable cause) {
        super(message, cause, true, true);
    }

    public MolangException(Throwable cause) {
        super(null, cause, true, true);
    }
}
