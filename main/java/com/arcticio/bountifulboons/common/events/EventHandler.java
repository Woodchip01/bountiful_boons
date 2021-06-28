package com.arcticio.bountifulboons.common.events;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.gods.Favor;
import com.arcticio.bountifulboons.common.gods.FavorProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BountifulBoons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onCritHit(final CriticalHitEvent event) {
        PlayerEntity player = event.getPlayer();

        if (event.isVanillaCritical() && getFavor(player,"zeus") > 1) {
            event.setDamageModifier(event.getOldDamageModifier() * 4);

            ArmorStandEntity armorStand = new ArmorStandEntity(EntityType.ARMOR_STAND,
                    player.getCommandSenderWorld());
            armorStand.setPos(player.getPosition(1).x, player.getPosition(1).y, player.getPosition(1).z);
            player.getCommandSenderWorld().addFreshEntity(armorStand);
        }
    }

    @SubscribeEvent
    public static void onThrow(final ItemTossEvent event) {
        setFavor(event.getPlayer(), "zeus", 3);
    }
    @SubscribeEvent
    public static void onPickup(final PlayerEvent.ItemPickupEvent event) {
        setFavor(event.getPlayer(), "zeus", 0);
    }

    private static Favor getFavorData(PlayerEntity player) {
        return player.getCapability(FavorProvider.FAVOR_CAPABILITY).resolve().get();
    }

    private static int getFavor(PlayerEntity player, String godName) {
        return getFavorData(player).getFavor(godName);
    }
    private static void setFavor(PlayerEntity player, String godName, int level) {
        getFavorData(player).setFavor(godName, level);
    }
}
