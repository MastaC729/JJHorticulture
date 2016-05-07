package com.dedotatedwam.jjhorticulture.proxy;

import com.dedotatedwam.jjhorticulture.JJHorticulture;
import com.dedotatedwam.jjhorticulture.block.BlockFertilizerApplier;
import com.dedotatedwam.jjhorticulture.item.ItemJJBasic;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    // Items
    public static ItemJJBasic pH_tester;                        // pH tester item
    public static ItemJJBasic nutrient_tester;                  // Nutrient tester item
    public static ItemJJBasic hand_fertilizer_applier;          // Applies fertilizer by hand, can store up to XX of each nutrient TODO figure this number (XX) out

    // Blocks

    public static BlockFertilizerApplier fertilizer_applier;     // Fertilizer applier block


    public void preInit()
    {
        //Items
        pH_tester = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("pH_tester"));
        GameRegistry.registerItem(pH_tester, "pH_tester");

        nutrient_tester = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("nutrient_tester"));
        GameRegistry.registerItem(nutrient_tester, "nutrient_tester");

        hand_fertilizer_applier = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("hand_fertilizer_applier"));
        GameRegistry.registerItem(hand_fertilizer_applier, "hand_fertilizer_applier");

        //Blocks
        fertilizer_applier = (BlockFertilizerApplier)(new BlockFertilizerApplier(Material.rock).setUnlocalizedName("fertilizer_applier"));
        GameRegistry.registerBlock(fertilizer_applier, "fertilizer_applier");
    }

    public void init()
    {
        final int BONEMEAL_DAMAGE_VALUE = EnumDyeColor.WHITE.getDyeDamage();
        GameRegistry.addRecipe(new ItemStack(hand_fertilizer_applier,1), new Object[]{
                "ADA",
                "AAA",
                ".A.",
                'A', Items.iron_ingot, 'D', new ItemStack(Items.dye, 1, BONEMEAL_DAMAGE_VALUE)
        });

        GameRegistry.addRecipe(new ItemStack(fertilizer_applier,1), new Object[]{
                "BBB",
                "BAB",
                "BCB",
                    'A', Items.iron_ingot, 'B', Blocks.cobblestone, 'C', hand_fertilizer_applier
        });
    }

    public void postInit()
    {

    }
}
