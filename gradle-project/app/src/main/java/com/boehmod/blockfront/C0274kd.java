package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kd.class */
public class C0274kd {

    @NotNull
    public static final MutableComponent p = Component.translatable("bf.message.command.assets.error.validator.player");

    @NotNull
    public static final C0273kc a = new C0273kc((commandContext, strArr) -> {
        return ((CommandSourceStack) commandContext.getSource()).source instanceof Player;
    }, p);

    @NotNull
    public static C0273kc a(@NotNull String[] strArr) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            mutableComponentEmpty.append(Component.literal(strArr[i]));
            if (i < length - 1) {
                mutableComponentEmpty.append(", ");
            }
        }
        return new C0273kc((commandContext, strArr2) -> {
            return strArr2.length >= length;
        }, Component.translatable("bf.message.command.assets.error.validator.args.count", new Object[]{mutableComponentEmpty.withStyle(ChatFormatting.GRAY)}));
    }

    @NotNull
    public static C0273kc b(@NotNull String[] strArr) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            mutableComponentEmpty.append(Component.literal(strArr[i]));
            if (i < length - 1) {
                mutableComponentEmpty.append(", ");
            }
        }
        return new C0273kc((commandContext, strArr2) -> {
            for (String str : strArr2) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }, Component.translatable("bf.message.command.assets.error.validator.args.onlyAllowed", new Object[]{mutableComponentEmpty.withStyle(ChatFormatting.GRAY)}));
    }
}
