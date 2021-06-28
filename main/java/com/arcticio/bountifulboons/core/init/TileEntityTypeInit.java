package com.arcticio.bountifulboons.core.init;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.blocks.OlympianPedestal;
import com.arcticio.bountifulboons.common.tiles.OlympianAltarTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,
            BountifulBoons.MOD_ID);

    public static final RegistryObject<TileEntityType<OlympianAltarTileEntity>> OLYMPIAN_ALTAR = TILE_ENTITIES.register(
            "olympian_pedestal",
            () -> {
                return TileEntityType.Builder.of(OlympianAltarTileEntity::new, BlockInit.OLYMPIAN_ALTAR.get()).build(null);
            });
            //TileEntityType.Builder.of(,
            //        BlockInit.OLYMPIAN_ALTAR).build());
}