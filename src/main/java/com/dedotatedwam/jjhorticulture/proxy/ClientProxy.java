package com.dedotatedwam.jjhorticulture.proxy;


import com.dedotatedwam.jjhorticulture.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;


public class ClientProxy extends CommonProxy {

    public void preInit()
    {
        super.preInit();

        ModelResourceLocation res = new ModelResourceLocation(Reference.MODID + ":" + pH_tester.getUnlocalizedName().substring(5), "inventory");
        ModelLoader.setCustomModelResourceLocation(CommonProxy.pH_tester, Reference.DEFAULT_ITEM_SUBTYPE, res);
    }

    public void init()
    {

    }

    public void postInit()
    {

    }
}
