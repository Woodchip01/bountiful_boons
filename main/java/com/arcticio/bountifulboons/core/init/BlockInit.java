package com.arcticio.bountifulboons.core.init;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.blocks.OlympianAltar;
import com.arcticio.bountifulboons.common.blocks.OlympianPedestal;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BountifulBoons.MOD_ID);

    public static final RegistryObject<OlympianPedestal> OLYMPIAN_PEDESTAL = BLOCKS.register("olympian_pedestal",
            () -> new OlympianPedestal(AbstractBlock.Properties.of(Material.STONE)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(1)
            .sound(SoundType.STONE)
            .strength(3,5)
            .requiresCorrectToolForDrops()));

    public static final RegistryObject<OlympianAltar> OLYMPIAN_ALTAR = BLOCKS.register("olympian_altar",
            () -> new OlympianAltar(AbstractBlock.Properties.of(Material.STONE)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(1)
            .strength(3,20)
            .sound(SoundType.STONE)));
}
