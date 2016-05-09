package com.dedotatedwam.jjhorticulture.item;

import com.dedotatedwam.jjhorticulture.tile.NutrientsTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class ItemNutrientTester extends ItemJJBasic {

    // Used to pull NutrientsTileEntity on the block (if it exists), then print the nutrient values to chat
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        //Need some way of preventing this from crashing the game
            if (worldIn.getTileEntity(pos).getClass() == NutrientsTileEntity.class) {
                NBTTagCompound compound = new NBTTagCompound();

                float nitrogen = -1;

                worldIn.getTileEntity(pos).readFromNBT(compound);

                float n = compound.getFloat("nitrogen");
                float p = compound.getFloat("phosphorous");
                float k = compound.getFloat("potassium");

                playerIn.addChatMessage(new ChatComponentText("Amount of nutrients in this farmland:"));
                playerIn.addChatMessage(new ChatComponentText("Nitrogen: " + n));
                playerIn.addChatMessage(new ChatComponentText("Phosphorous: " + p));
                playerIn.addChatMessage(new ChatComponentText("Potassium: " + k));
            } else
                playerIn.addChatMessage(new ChatComponentText("THIS IS NOT FARMLAND YA DANGUS"));        //TODO remove this after it works

        return false;
    }

}
