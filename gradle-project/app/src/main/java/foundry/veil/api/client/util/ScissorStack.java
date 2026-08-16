package foundry.veil.api.client.util;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/util/ScissorStack.class */
public final class ScissorStack {
    private final Deque<ScreenRectangle> regions = new ArrayDeque();

    private void apply(ScreenRectangle rectangle) {
        RenderSystem.enableScissor(rectangle.left(), Minecraft.getInstance().getWindow().getHeight() - rectangle.bottom(), rectangle.width(), rectangle.height());
    }

    public void push(int x, int y, int width, int height) {
        push(x, y, width, height);
    }

    public void push(float x, float y, float width, float height) {
        if (!this.regions.isEmpty()) {
            float scale = (float) Minecraft.getInstance().getWindow().getGuiScale();
            float x2 = x + width;
            float y2 = y + height;
            ScreenRectangle parent = this.regions.peek();
            x = Mth.clamp(x * scale, parent.left(), parent.right());
            width = Mth.clamp(x2 * scale, parent.left(), parent.right()) - x;
            y = Mth.clamp(y * scale, parent.top(), parent.bottom());
            height = Mth.clamp(y2 * scale, parent.top(), parent.bottom()) - y;
        }
        ScreenRectangle region = new ScreenRectangle((int) x, (int) y, (int) width, (int) height);
        this.regions.push(region);
        apply(region);
    }

    public void pop() {
        this.regions.pop();
        if (this.regions.isEmpty()) {
            RenderSystem.disableScissor();
        } else {
            apply(this.regions.peek());
        }
    }

    @Nullable
    public ScreenRectangle getTop() {
        if (this.regions.isEmpty()) {
            return null;
        }
        return this.regions.peek();
    }

    public boolean containsPoint(float x, float y) {
        if (this.regions.isEmpty()) {
            return true;
        }
        float scale = (float) Minecraft.getInstance().getWindow().getGuiScale();
        return this.regions.peek().containsPoint((int) (x * scale), (int) (y * scale));
    }

    public int size() {
        return this.regions.size();
    }

    public boolean isEmpty() {
        return this.regions.isEmpty();
    }

    public void clear() {
        this.regions.clear();
        RenderSystem.disableScissor();
    }
}
