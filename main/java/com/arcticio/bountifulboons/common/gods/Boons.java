package com.arcticio.bountifulboons.common.gods;

import com.mojang.serialization.Lifecycle;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import org.apache.commons.lang3.Validate;

import java.util.function.Supplier;

public class Boons {
    public static final Boon FORTITUDE = register(1, "", (new Boon("fortitude", 8171462)));

    private static Boon register(int index, String p_220308_1_, Boon boon) {
        return FORTITUDE;
    }

}
