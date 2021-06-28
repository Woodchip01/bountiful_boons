package com.arcticio.bountifulboons.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class DionysusToken extends Item {

    public DionysusToken(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        // TODO functionality
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        // TODO functionality
        stack.setCount(stack.getCount()-1);
        return ActionResultType.CONSUME;
    }
}
