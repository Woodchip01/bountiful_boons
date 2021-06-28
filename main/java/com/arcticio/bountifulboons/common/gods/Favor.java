package com.arcticio.bountifulboons.common.gods;

import com.arcticio.bountifulboons.core.interfaces.IFavor;

import java.util.HashMap;
import java.util.Map;

public class Favor implements IFavor {

    private Map<String, Integer> favors = new HashMap<String, Integer>() {{
        put("aphrodite", 0);
        put("ares", 0);
        put("artemis", 0);
        put("athena", 0);
        put("demeter", 0);
        put("dionysus", 0);
        put("hades", 0);
        put("hephaestus", 0);
        put("hermes", 0);
        put("poseidon", 0);
        put("zeus", 0);
    }};


    private String getGodNameFromId(int id) {
        return favors.keySet().toArray()[id].toString();
    }

    @Override
    public void setFavor(int godId, int favorLevel) {
        setFavor(getGodNameFromId(godId), favorLevel);
    }

    @Override
    public void resetFavor(int godId) {
        resetFavor(getGodNameFromId(godId));
    }

    @Override
    public void maxFavor(int godId) {
        maxFavor(getGodNameFromId(godId));
    }

    @Override
    public int getFavor(int godId) {
        return getFavor(getGodNameFromId(godId));
    }

    @Override
    public void setFavor(String godName, int favorLevel) {
        this.favors.replace(godName, favorLevel);
    }

    @Override
    public void resetFavor(String godName) {
        this.favors.replace(godName, 0);
    }

    @Override
    public void maxFavor(String godName) {
        this.favors.replace(godName, 10);
    }

    @Override
    public int getFavor(String godName) {
        return this.favors.get(godName);
    }

    @Override
    public Integer[] getIntArray() {
        Integer[] intArray = (Integer[]) favors.entrySet().toArray();
        return intArray;
    }
}
