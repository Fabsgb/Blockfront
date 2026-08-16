package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kz.class */
public class C0622kz {

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final MutableComponent f3553p = Component.translatable("bf.message.command.assets.error.validator.player");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0621ky f3554a = new C0621ky((commandContext, strArr) -> {
        return ((CommandSourceStack) commandContext.getSource()).source instanceof Player;
    }, f3553p);

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0621ky m2847a(@NotNull String[] strArr) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            mutableComponentEmpty.append(Component.literal(strArr[i]));
            if (i < length - 1) {
                mutableComponentEmpty.append(", ");
            }
        }
        return new C0621ky((commandContext, strArr2) -> {
            return strArr2.length >= length;
        }, Component.translatable("bf.message.command.assets.error.validator.args.count", new Object[]{mutableComponentEmpty.withStyle(ChatFormatting.GRAY)}));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static C0621ky m2848b(@NotNull String[] strArr) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            mutableComponentEmpty.append(Component.literal(strArr[i]));
            if (i < length - 1) {
                mutableComponentEmpty.append(", ");
            }
        }
        return new C0621ky((commandContext, strArr2) -> {
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
