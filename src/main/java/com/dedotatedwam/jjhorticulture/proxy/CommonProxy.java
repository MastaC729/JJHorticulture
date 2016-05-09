package com.dedotatedwam.jjhorticulture.proxy;

import com.dedotatedwam.jjhorticulture.Recipes;
import com.dedotatedwam.jjhorticulture.block.BlockFertilizerApplier;
import com.dedotatedwam.jjhorticulture.item.ItemJJBasic;
import com.dedotatedwam.jjhorticulture.item.ItemNutrientTester;
import com.dedotatedwam.jjhorticulture.tile.JJTileEntities;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    // Items
    public static ItemJJBasic pH_tester;                        // pH tester item
    public static ItemNutrientTester nutrient_tester = new ItemNutrientTester();                  // Nutrient tester item
    public static ItemJJBasic hand_fertilizer_applier;          // Applies fertilizer by hand, can store up to XX of each nutrient TODO figure this number (XX) out

    // Blocks

    public static BlockFertilizerApplier fertilizer_applier;     // Fertilizer applier block

    public void preInit()
    {
        //Items
        pH_tester = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("pH_tester"));
        GameRegistry.registerItem(pH_tester, "pH_tester");

        nutrient_tester = (ItemNutrientTester) (new ItemNutrientTester().setUnlocalizedName("nutrient_tester"));
        GameRegistry.registerItem(nutrient_tester, "nutrient_tester");

        hand_fertilizer_applier = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("hand_fertilizer_applier"));
        GameRegistry.registerItem(hand_fertilizer_applier, "hand_fertilizer_applier");

        //Blocks
        fertilizer_applier = (BlockFertilizerApplier)(new BlockFertilizerApplier(Material.rock).setUnlocalizedName("fertilizer_applier"));
        GameRegistry.registerBlock(fertilizer_applier, "fertilizer_applier");

        //Tile Entites
        JJTileEntities.init();
    }

    public void init()
    {
        Recipes.register();
    }

    public void postInit()
    {

    }
}
