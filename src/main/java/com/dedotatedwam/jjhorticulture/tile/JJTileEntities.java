package com.dedotatedwam.jjhorticulture.tile;


import com.dedotatedwam.jjhorticulture.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class JJTileEntities {

    public static void init() {
        GameRegistry.registerTileEntity(NutrientsTileEntity.class, Reference.MODID + ":" + "block_nutrients");
    }
}
