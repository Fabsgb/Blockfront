package software.bernie.geckolib.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.StringJoiner;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/util/CompoundException.class */
public class CompoundException extends RuntimeException {
    private final List<String> messages = new ObjectArrayList();

    public CompoundException(String message) {
        this.messages.add(message);
    }

    public CompoundException withMessage(String message) {
        this.messages.add(message);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        StringJoiner joiner = new StringJoiner("\n");
        int count = this.messages.size() - 1;
        int i = count;
        while (i >= 0) {
            joiner.add((i == count ? "" : "\t".repeat(Math.max(0, count - i)) + "-> ") + this.messages.get(i));
            i--;
        }
        return joiner.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        String message = getLocalizedMessage();
        return message != null ? "Geckolib.CompoundException: " + message : "Geckolib.CompoundException";
    }
}
