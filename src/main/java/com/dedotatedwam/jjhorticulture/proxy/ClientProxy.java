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
        System.out.println("NIGGA JAMES");
        System.out.println("IS THIS THING ON???");
        System.out.println("NIGGA JAMES");
        //Items with only one texture (pH tester, nutrient tester, etc.)
        ModelResourceLocation res = new ModelResourceLocation(Reference.MODID + ":" + pH_tester.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(CommonProxy.pH_tester, Reference.DEFAULT_ITEM_SUBTYPE, res);

        res = new ModelResourceLocation(Reference.MODID + ":" + nutrient_tester.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(CommonProxy.nutrient_tester, Reference.DEFAULT_ITEM_SUBTYPE, res);

        res = new ModelResourceLocation(Reference.MODID + ":" + hand_fertilizer_applier.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(CommonProxy.hand_fertilizer_applier, Reference.DEFAULT_ITEM_SUBTYPE, res);

        //Blocks
        Item item_fertilizer_applier = GameRegistry.findItem(Reference.MODID, "fertilizer_applier");
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Reference.MODID + ":" + item_fertilizer_applier.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(item_fertilizer_applier, Reference.DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
    }

    public void init()
    {
        super.init();
    }

    public void postInit()
    {
        super.postInit();
    }
}
