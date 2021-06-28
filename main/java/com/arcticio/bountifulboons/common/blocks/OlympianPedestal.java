package com.arcticio.bountifulboons.common.blocks;

import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.EnchantmentContainer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tileentity.EnchantingTableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.INameable;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

public class OlympianPedestal extends ContainerBlock{

    protected static final VoxelShape field_196322_a = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    //protected static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction, VoxelShape>();

    public OlympianPedestal(AbstractBlock.Properties properties) {
        super(properties);
    }
    public boolean func_220074_n(BlockState p_220074_1_) {
        return true;
    }

    public VoxelShape func_220053_a(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return field_196322_a;
    }

    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(BlockState state, World worldIn, BlockPos blockPos, Random random) {
        super.animateTick(state, worldIn, blockPos, random);

        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                if (i > -2 && i < 2 && j == -1) {
                    j = 2;
                }

                /*if (random.nextInt(16) == 0) {
                    for(int k = 0; k <= 1; ++k) {
                        BlockPos blockpos = blockPos.offset(i, k, j);
                        if (worldIn.func_180495_p(blockpos).func_203425_a(Blocks.ENCHANTING_TABLE)) {
                            if (!worldIn.func_175623_d(blockPos.func_177982_a(i / 2, 0, j / 2))) {
                                break;
                            }

                            worldIn.func_195594_a(ParticleTypes.field_197623_p, (double)blockPos.func_177958_n() + 0
                            .5D,
                             (double)blockPos.func_177956_o() + 2.0D, (double)blockPos.func_177952_p() + 0.5D, (double)(
                             (float)i + random.nextFloat()) - 0.5D, (double)((float)k - random.nextFloat() - 1.0F),
                             (double)((float)j + random.nextFloat()) - 0.5D);
                        }
                    }
                }*/
            }
        }

    }

    public BlockRenderType func_149645_b(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    public TileEntity func_196283_a_(IBlockReader p_196283_1_) {
        return new EnchantingTableTileEntity();
    }

    public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos blockPos,
                                           PlayerEntity player, Hand hand, BlockRayTraceResult raytrace) {
        if (worldIn.isClientSide/*MAY BE DIFFERENT | field_72995_K*/) {
            return ActionResultType.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(worldIn, blockPos));
            return ActionResultType.CONSUME;
        }
    }

    @Nullable
    public INamedContainerProvider func_220052_b(BlockState p_220052_1_, World p_220052_2_, BlockPos p_220052_3_) {
        TileEntity tileentity = p_220052_2_.getBlockEntity(p_220052_3_);
        if (tileentity instanceof EnchantingTableTileEntity) {
            ITextComponent itextcomponent = ((INameable)tileentity).getCustomName(); //.getCustomName may be a different get
            return new SimpleNamedContainerProvider((p_220147_2_, p_220147_3_, p_220147_4_) -> {
                return new EnchantmentContainer(p_220147_2_, p_220147_3_, IWorldPosCallable.create(p_220052_2_, p_220052_3_));
            }, itextcomponent);
        } else {
            return null;
        }
    }
            //          ???????
    public void func_180633_a(World worldIn, BlockPos blockPos, BlockState state, LivingEntity livEnt,
                              ItemStack stack) {
        if (stack.hasContainerItem()) {
            TileEntity tileentity = worldIn.getBlockEntity(blockPos);
            if (tileentity instanceof EnchantingTableTileEntity) {
                //((EnchantingTableTileEntity)tileentity).func_200229_a(stack.hasContainerItem());
            }
        }

    }

    public boolean func_196266_a(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return null;
    }
}

