package com.dedotatedwam.jjhorticulture;


import com.dedotatedwam.jjhorticulture.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {

    public static void register() {
        final int BONEMEAL_DAMAGE_VALUE = EnumDyeColor.WHITE.getDyeDamage();
        GameRegistry.addRecipe(new ItemStack(CommonProxy.hand_fertilizer_applier),
                "ADA",
                "AAA",
                " A ",
                'A', Items.iron_ingot, 'D', new ItemStack(Items.dye, 1, BONEMEAL_DAMAGE_VALUE)
        );

        GameRegistry.addRecipe(new ItemStack(CommonProxy.fertilizer_applier),
                "BBB",
                "BAB",
                "BCB",
                'A', Items.iron_ingot, 'B', Blocks.cobblestone, 'C', CommonProxy.hand_fertilizer_applier
        );
    }
}
