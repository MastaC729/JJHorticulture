package com.dedotatedwam.jjhorticulture;


import com.dedotatedwam.jjhorticulture.tile.NutrientsTileEntity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.UseHoeEvent;


public class JJEventHandler {

    public void onUseHoeEvent(UseHoeEvent event)
    {
        // For reference:
        // current: hoe the player was using
        // world: the current world the player is in
        // pos: the position of the tilled block

        ItemStack onHoeCurrent = event.current;
        World onHoeWorld = event.world;
        BlockPos onHoePos = event.pos;

        if (onHoeWorld.getBlockState(onHoePos).getBlock() == Blocks.dirt)
        {
            event.setCanceled(true);
            event.world.setTileEntity(event.pos, new NutrientsTileEntity());    //Create our nutrients tile entity
            System.out.println("NIGGA JAMES");
            System.out.println("I think it made the tile entity here at " + event.pos.toLong());
            System.out.println("NIGGA JAMES");              //TODO Remove this after it works
        }
    }
}
