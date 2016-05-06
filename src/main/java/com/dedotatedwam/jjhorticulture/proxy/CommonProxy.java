package com.dedotatedwam.jjhorticulture.proxy;


import com.dedotatedwam.jjhorticulture.item.ItemJJBasic;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public static ItemJJBasic pH_tester;

    public void preInit()
    {
        pH_tester = (ItemJJBasic)(new ItemJJBasic().setUnlocalizedName("pH_tester"));
        GameRegistry.registerItem(pH_tester, "pH_tester");
    }

    public void init()
    {

    }

    public void postInit()
    {

    }
}
