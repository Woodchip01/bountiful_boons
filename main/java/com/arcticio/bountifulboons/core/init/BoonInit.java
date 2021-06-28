package com.arcticio.bountifulboons.core.init;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.gods.Boon;
import com.arcticio.bountifulboons.common.gods.Boons;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collection;
import java.util.List;

public class BoonInit {
    public static Collection<Boon> REGISTRY;
    //private static final DeferredRegister<Boon> BOONS = DeferredRegister.create(ForgeRegistries.BOONS, BountifulBoons.MOD_ID);


    public static Boon FORTITUDE;

    @SubscribeEvent
    public static void registerMeals(RegistryEvent.Register<Boon> e) {
        FORTITUDE = new Boon("fortitude", 13775519);
        Boon[] boons = {
                FORTITUDE,
                //DISGUSTING,
        };
        e.getRegistry().registerAll(boons);
        REGISTRY = e.getRegistry().getValues();
        //Log.getLogger().info("Registered " + meals.length + " Meals");
    }
    @SubscribeEvent
    public static void registerRegistries(RegistryEvent.NewRegistry e) {
        net.minecraftforge.registries.RegistryBuilder<Boon> builder =
                new net.minecraftforge.registries.RegistryBuilder<Boon>();
        builder.setType(Boon.class);
        ResourceLocation key = new ResourceLocation(BountifulBoons.MOD_ID, "cooking_meal");
        builder.setName(key);
        builder.setDefaultKey(key);
        builder.create();
    }

    /*
    public static void registerBoons() {
       // event.getRegistry().registerAll(new Block(...), new Block(...), ...);
    }


    private static void registerBoon(Boon boon) {
        //RegistryEvent.Register
    }*/


}