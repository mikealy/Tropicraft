package net.tropicraft.core.common.dimension.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public enum TropicraftRiverInitLayer implements IC0Transformer {
    INSTANCE;

    @Override
    public int apply(INoiseRandom iNoiseRandom, int center) {
        return iNoiseRandom.random(4) + 1;
    }
}