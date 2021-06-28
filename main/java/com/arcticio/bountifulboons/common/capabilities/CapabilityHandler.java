package com.arcticio.bountifulboons.common.capabilities;

import com.arcticio.bountifulboons.BountifulBoons;
import com.arcticio.bountifulboons.common.gods.FavorProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 *  This class attaches our capabilities
 */
public class CapabilityHandler {
    public static final ResourceLocation FAVOR_CAPABILITY = new ResourceLocation(BountifulBoons.MOD_ID, "favor");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent event) {
        if (!(event.getObject() instanceof PlayerEntity)) return;

        event.addCapability(FAVOR_CAPABILITY, new FavorProvider());
    }
}
