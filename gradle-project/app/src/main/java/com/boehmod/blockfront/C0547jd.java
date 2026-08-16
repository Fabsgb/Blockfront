package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.cloud.common.player.challenge.ItemKillChallenge;
import com.boehmod.bflib.cloud.common.player.challenge.KillCountChallenge;
import com.boehmod.bflib.cloud.common.player.challenge.WeaponTypeKillChallenge;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jd.class */
public class C0547jd {

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final MutableComponent f3264n = Component.translatable("bf.message.error");

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Component m2475a(@NotNull Challenge challenge) {
        Objects.requireNonNull(challenge);
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), ItemKillChallenge.class, WeaponTypeKillChallenge.class, KillCountChallenge.class).dynamicInvoker().invoke(challenge, 0) /* invoke-custom */) {
            case 0:
                ItemKillChallenge itemKillChallenge = (ItemKillChallenge) challenge;
                Optional<Item> optionalM8000a = C1308xv.m8000a(itemKillChallenge.getItem());
                if (optionalM8000a.isPresent()) {
                    Item item = optionalM8000a.get();
                    MutableComponent mutableComponentLiteral = Component.literal(String.valueOf(itemKillChallenge.getAmountRequired()));
                    return Component.translatable("bf.challenge.kills.item", new Object[]{mutableComponentLiteral, Component.translatable(item.getDescriptionId()), Component.literal(String.valueOf(itemKillChallenge.getAmount())), mutableComponentLiteral});
                }
                break;
            case 1:
                WeaponTypeKillChallenge weaponTypeKillChallenge = (WeaponTypeKillChallenge) challenge;
                MutableComponent mutableComponentTranslatable = Component.translatable(weaponTypeKillChallenge.getGunType().translationKey());
                MutableComponent mutableComponentLiteral2 = Component.literal(String.valueOf(weaponTypeKillChallenge.getAmountRequired()));
                return Component.translatable("bf.challenge.kills.guntype", new Object[]{mutableComponentLiteral2, mutableComponentTranslatable, Component.literal(String.valueOf(weaponTypeKillChallenge.getAmount())), mutableComponentLiteral2});
            case 2:
                KillCountChallenge killCountChallenge = (KillCountChallenge) challenge;
                MutableComponent mutableComponentLiteral3 = Component.literal(String.valueOf(killCountChallenge.getAmountRequired()));
                return Component.translatable("bf.challenge.kills", new Object[]{mutableComponentLiteral3, Component.literal(String.valueOf(killCountChallenge.getAmount())), mutableComponentLiteral3});
        }
        return f3264n;
    }
}
