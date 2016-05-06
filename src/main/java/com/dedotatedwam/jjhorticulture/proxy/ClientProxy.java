package com.dedotatedwam.jjhorticulture.proxy;


import com.dedotatedwam.jjhorticulture.Reference;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ClientProxy extends CommonProxy {

    public void preInit()
    {
        super.preInit();

        //Items with only one texture (pH tester, nutrient tester, etc.)
        ModelResourceLocation res = new ModelResourceLocation(Reference.MODID + ":" + pH_tester.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(CommonProxy.pH_tester, Reference.DEFAULT_ITEM_SUBTYPE, res);

        res = new ModelResourceLocation(Reference.MODID + ":" + nutrient_tester.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(CommonProxy.nutrient_tester, Reference.DEFAULT_ITEM_SUBTYPE, res);

        //Blocks
        Item itemFertilizerApplier = GameRegistry.findItem(Reference.MODID, "fertilizer_applier");
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Reference.MODID + ":" + itemFertilizerApplier.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(itemFertilizerApplier, Reference.DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
    }

    public void init()
    {

    }

    public void postInit()
    {

    }
}
