package com.dedotatedwam.jjhorticulture.proxy;

import com.dedotatedwam.jjhorticulture.block.BlockFertilizerApplier;
import com.dedotatedwam.jjhorticulture.item.ItemJJBasic;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    // Items
    public static ItemJJBasic pH_tester;                        // pH tester item
    public static ItemJJBasic nutrient_tester;                  // Nutrient tester item

    // Blocks

    public static BlockFertilizerApplier fertilizerApplier;     // Fertilizer applier block


    public void preInit()
    {
        //Items
        pH_tester = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("pH_tester"));
        GameRegistry.registerItem(pH_tester, "pH_tester");

        nutrient_tester = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("nutrient_tester"));
        GameRegistry.registerItem(nutrient_tester, "nutrient_tester");

        //Blocks
        fertilizerApplier = (BlockFertilizerApplier)(new BlockFertilizerApplier(Material.rock).setUnlocalizedName("fertilizer_applier"));
        GameRegistry.registerBlock(fertilizerApplier, "fertilizer_applier");
    }

    public void init()
    {

    }

    public void postInit()
    {

    }
}
