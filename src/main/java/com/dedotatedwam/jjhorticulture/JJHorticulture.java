package com.dedotatedwam.jjhorticulture;


import com.dedotatedwam.jjhorticulture.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class JJHorticulture
{
    public static JJTabs myTab;

    @SidedProxy(clientSide = Reference.PROXY_CLIENT_CLASS, serverSide = Reference.PROXY_SERVER_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        /*GameRegistry.addRecipe(new ItemStack(pH_tester,1), new Object[]{
            "A  ",
            "A  ",
            'A', Items.iron_ingot
    });*/
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
