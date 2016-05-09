package com.dedotatedwam.jjhorticulture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class NutrientsTileEntity extends TileEntity {

    private float nitrogen;             //Nitrogen aspect of nutrients
    private float phosphorous;          //Phosphorous aspect of nutrients
    private float potassium;            //Potassium aspect of nutrients
    private float pH;                   //pH aspect of soil, determines if crop can grow at all regardless of nutrients

    public NutrientsTileEntity()
    {
        nitrogen = 1;
        phosphorous = 2;
        potassium = 3;
        pH = 7.0F;
        // TODO implement a constructor that will change these nutrient values based on where the TileEntity was created
    }
    //Set the values on the TileEntity so it saves when it unloads
    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        compound.setFloat("nitrogen", this.nitrogen);
        compound.setFloat("phosphorous", this.phosphorous);
        compound.setFloat("potassium", this.potassium);
        compound.setFloat("pH", this.pH);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        this.nitrogen = compound.getFloat("nitrogen");
        this.phosphorous = compound.getFloat("phosphorous");
        this.potassium = compound.getFloat("potassium");
        this.pH = compound.getFloat("pH");
    }
}
