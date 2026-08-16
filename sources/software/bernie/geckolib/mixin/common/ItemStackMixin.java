package software.bernie.geckolib.mixin.common;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.util.InternalUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/mixin/common/ItemStackMixin.class */
@Mixin({ItemStack.class})
public class ItemStackMixin {
    @WrapOperation(method = {"split"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;copyWithCount(I)Lnet/minecraft/world/item/ItemStack;")})
    public ItemStack geckolib$removeGeckolibIdOnCopy(ItemStack instance, int count, Operation<ItemStack> original) {
        ItemStack copy = (ItemStack) original.call(new Object[]{instance, Integer.valueOf(count)});
        if (count < instance.getCount() && copy.has(GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get())) {
            copy.remove(GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get());
        }
        return copy;
    }

    @WrapOperation(method = {"isSameItemSameComponents"}, at = {@At(value = "INVOKE", target = "Ljava/util/Objects;equals(Ljava/lang/Object;Ljava/lang/Object;)Z")})
    private static boolean geckolib$skipGeckolibIdOnCompare(Object a, Object b, Operation<Boolean> original) {
        if (((Boolean) original.call(new Object[]{a, b})).booleanValue()) {
            return true;
        }
        if (!(a instanceof PatchedDataComponentMap)) {
            return false;
        }
        PatchedDataComponentMap components = (PatchedDataComponentMap) a;
        if (!(b instanceof PatchedDataComponentMap)) {
            return false;
        }
        PatchedDataComponentMap components2 = (PatchedDataComponentMap) b;
        return InternalUtil.areComponentsMatchingIgnoringGeckoLibId(components, components2);
    }
}
