package com.arcticio.bountifulboons.common.gods;

import com.arcticio.bountifulboons.core.interfaces.IFavor;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FavorProvider implements ICapabilitySerializable<INBT> {
    public static final Capability<Favor> FAVOR_CAPABILITY = null;

    //private Favor instance = FAVOR_CAPABILITY.getDefaultInstance();
                                    //IFavor ???? I guess not?
    private static final LazyOptional<Favor> holder = LazyOptional.of(Favor::new);


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        // TODO Figure out how to return this shit
        return cap == FAVOR_CAPABILITY ? holder.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {

        return FAVOR_CAPABILITY.getStorage().writeNBT(FAVOR_CAPABILITY, this.holder.resolve().get(), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        FAVOR_CAPABILITY.getStorage().readNBT(FAVOR_CAPABILITY, this.holder.resolve().get(), null, nbt);
    }
}
