package com.arcticio.bountifulboons.core.registries;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.gods.Boon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = BountifulBoons.MOD_ID)
public class Registries {
    public static final ResourceLocation BOONS_ID = new ResourceLocation("bountiful_boons:boons");
    public static final IForgeRegistry<Boon> BOONS;

    static {
        BOONS = makeRegistry(BOONS_ID, Boon.class, Integer.MAX_VALUE >> 5);
    }





    private static <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> makeRegistry(ResourceLocation name,
                                                                                     Class<T> type, int max) {
        return new RegistryBuilder<T>().setName(name).setType(type).setMaxID(max).create();

    }
}
