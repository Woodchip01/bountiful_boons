package com.arcticio.bountifulboons.core.interfaces;


/**
 *  Capability to track favor with specific gods
 */


public interface IFavor {
    public void setFavor(int godId, int favorLevel);
    public void resetFavor(int godId);
    public void maxFavor(int godId);

    public int getFavor(int godId);

    public void setFavor(String godName, int favorLevel);
    public void resetFavor(String godName);
    public void maxFavor(String godName);

    public int getFavor(String godName);

    public Integer[] getIntArray();
}
