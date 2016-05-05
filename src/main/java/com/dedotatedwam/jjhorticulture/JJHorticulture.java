package com.dedotatedwam.jjhorticulture;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = JJHorticulture.MODID, name = JJHorticulture.NAME, version = JJHorticulture.VERSION)
public class JJHorticulture
{
    public static final String MODID = "jjhorticulture";
    public static final String VERSION = "0.0.1";
    public static final String NAME = "Jiving Janko Horticulture";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
