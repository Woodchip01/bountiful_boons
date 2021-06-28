package com.arcticio.bountifulboons.core.init;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.containers.OlympianAltarContainer;
import net.minecraft.block.Block;
import net.minecraft.block.ContainerBlock;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeInit {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, BountifulBoons.MOD_ID);

    public static final RegistryObject<ContainerType<OlympianAltarContainer>> OLYMPIAN_ALTAR = CONTAINERS.register(
            "olympian_altar", () -> IForgeContainerType.create(OlympianAltarContainer::new));
}
