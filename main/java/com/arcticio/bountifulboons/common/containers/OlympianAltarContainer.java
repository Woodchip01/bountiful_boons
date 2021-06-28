package com.arcticio.bountifulboons.common.containers;

import com.arcticio.bountifulboons.common.tiles.OlympianAltarTileEntity;
import com.arcticio.bountifulboons.core.init.BlockInit;
import com.arcticio.bountifulboons.core.init.ContainerTypeInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;


public class OlympianAltarContainer extends Container {

    //public
    public final OlympianAltarTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public OlympianAltarContainer(final int windowId,
                                  final PlayerInventory playerInventory,
                                  //final IIntArray fields,
                                  final OlympianAltarTileEntity tileEntity) {
        super(ContainerTypeInit.OLYMPIAN_ALTAR.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.create(tileEntity.getLevel(), tileEntity.getBlockPos());

        // Main Inventory
        int startX = 80;//
        int startY = 152;//
        int slotSizePlus2 = 18;//

        this.addSlot(new Slot(tileEntity, 0, startX, startY));

        // Main Player Inventory
        int startPlayerInvX = 8;
        int startPlayerInvY = 174;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9+ (row * 9) + column,
                        startPlayerInvX + (column * slotSizePlus2),
                        startPlayerInvY + (row * slotSizePlus2)));
            }
        }

        // Hotbar
        int hotbarY = 232;
        for (int column = 0; column < 9; ++ column) {
            this.addSlot(new Slot(playerInventory, column, startPlayerInvX + (column * slotSizePlus2), hotbarY));
        }
    }

    public OlympianAltarContainer(int windowId, PlayerInventory playerInventory, PacketBuffer data) {
        this(windowId, playerInventory,/*fields,*/ getTileEntity(playerInventory, data));
    }

    private static OlympianAltarTileEntity getTileEntity(final PlayerInventory playerInventory,
                                                        final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if(tileAtPos instanceof OlympianAltarTileEntity) {
            return (OlympianAltarTileEntity)tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public OlympianAltarContainer(final int windowId, final PlayerInventory playerInventory,
                                  final IIntArray fields, final PacketBuffer data) {
        this(windowId, playerInventory, /*fields,*/ getTileEntity(playerInventory, data));
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(canInteractWithCallable, player, BlockInit.OLYMPIAN_ALTAR.get());
    }

    /*public IWorldPosCallable getCanInteractWithCallable() {
        return canInteractWithCallable;
    }TODO:hmmm no canInteractWith method, perhaps stillValid is the necessary method then...*/

}
