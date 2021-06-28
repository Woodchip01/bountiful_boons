package com.arcticio.bountifulboons.common.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.world.World;

public class ArtemisToken extends Item {

    public ArtemisToken(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        ZombieEntity zom = new ZombieEntity(player.getCommandSenderWorld());
        zom.setPos(player.getX(),player.getY(),player.getZ());
        player.getCommandSenderWorld().addFreshEntity(zom);
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        ZombieEntity zom = new ZombieEntity(player.getCommandSenderWorld());
        zom.setPos(player.getX(),player.getY(),player.getZ());
        player.getCommandSenderWorld().addFreshEntity(zom);
        stack.setCount(stack.getCount()-1);
        return ActionResultType.CONSUME;
    }

    /*@Override
    public void onUseTick(World p_219972_1_, LivingEntity p_219972_2_, ItemStack p_219972_3_, int p_219972_4_) {
        ZombieEntity zom = new ZombieEntity(p_219972_1_);
        zom.setPos(p_219972_2_.getX(),p_219972_2_.getY(),p_219972_2_.getZ());
        p_219972_1_.addFreshEntity(zom);
        //return ActionResult.consume(p_219972_2_.getMainHandItem());
    }*/
}
