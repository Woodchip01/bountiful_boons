package com.arcticio.bountifulboons.core.init;
import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.blocks.OlympianAltar;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.arcticio.bountifulboons.common.items.*;


public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BountifulBoons.MOD_ID);

    //public static final RegistryObject<Item> TOKEN_OF_ZEUS = ITEMS.register("token_of_zeus",
    //        () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<AphroditeToken> TOKEN_OF_APHRODITE = ITEMS.register("token_of_aphrodite",
            () -> new AphroditeToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<AresToken> TOKEN_OF_ARES = ITEMS.register("token_of_ares",
            () -> new AresToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<ArtemisToken> TOKEN_OF_ARTEMIS = ITEMS.register("token_of_artemis",
            () -> new ArtemisToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<AthenaToken> TOKEN_OF_ATHENA = ITEMS.register("token_of_athena",
            () -> new AthenaToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<DemeterToken> TOKEN_OF_DEMETER = ITEMS.register("token_of_demeter",
            () -> new DemeterToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<DionysusToken> TOKEN_OF_DIONYSUS = ITEMS.register("token_of_dionysus",
            () -> new DionysusToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<HadesToken> TOKEN_OF_HADES = ITEMS.register("token_of_hades",
            () -> new HadesToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<HephaestusToken> TOKEN_OF_HEPHAESTUS = ITEMS.register("token_of_hephaestus",
            () -> new HephaestusToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<HermesToken> TOKEN_OF_HERMES = ITEMS.register("token_of_hermes",
            () -> new HermesToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<PoseidonToken> TOKEN_OF_POSEIDON = ITEMS.register("token_of_poseidon",
            () -> new PoseidonToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<ZeusToken> TOKEN_OF_ZEUS = ITEMS.register("token_of_zeus",
            () -> new ZeusToken(new Item.Properties().tab(ItemGroup.TAB_MISC)));


    // Block Items

    public static final RegistryObject<BlockItem> OLYMPIAN_PEDESTAL = ITEMS.register("olympian_pedestal", () -> new BlockItem(BlockInit.OLYMPIAN_PEDESTAL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> OLYMPIAN_ALTAR = ITEMS.register("olympian_altar",
            () -> new BlockItem(BlockInit.OLYMPIAN_ALTAR.get(),
                    new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    //public static final RegistryObject<OlympianAltar> OLYMPIAN_ALTAR = ITEMS.register("olympian_altar",
     //       () -> new OlympianAltar(AbstractBlock.Properties.of(Material.STONE)));
}


