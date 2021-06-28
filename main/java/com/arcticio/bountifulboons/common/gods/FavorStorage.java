package com.arcticio.bountifulboons.common.gods;

import com.arcticio.bountifulboons.core.interfaces.IFavor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.nbt.NBTTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.IntArray;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.Arrays;

public class FavorStorage implements Capability.IStorage<IFavor> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IFavor> capability, IFavor instance, Direction side) {
        int[] favorLevels = Arrays.stream(instance.getIntArray()).mapToInt(Integer::intValue).toArray();
        return new IntArrayNBT(favorLevels);
    }

    @Override
    public void readNBT(Capability<IFavor> capability, IFavor instance, Direction side, INBT nbt) {
        int[] favorLevels = ((IntArrayNBT) nbt).getAsIntArray();
        int i = 0;
        for (int favor : favorLevels) {
            if (favor > 0) {instance.setFavor(0,favor);}
            i++;
        }
    }
}
