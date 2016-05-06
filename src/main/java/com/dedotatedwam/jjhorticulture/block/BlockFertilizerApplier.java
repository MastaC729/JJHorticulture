package com.dedotatedwam.jjhorticulture.block;


import com.dedotatedwam.jjhorticulture.JJHorticulture;
import com.dedotatedwam.jjhorticulture.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockFertilizerApplier extends Block
{
    public BlockFertilizerApplier(Material i_material)
    {
        super(i_material);
        this.setCreativeTab(JJHorticulture.tabJJHorticulture);
        final float STONE_HARDNESS = 1.5F;
        this.setHardness(STONE_HARDNESS);
        final int WOOD_HARVEST_LEVEL = 0;
        this.setHarvestLevel("pickaxe", WOOD_HARVEST_LEVEL);
    }

    // Called when the block is destroyed
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    // Get a list of items that might drop when the block is harvested normally.
    // In simple cases, you can just override quantityDropped() and getItemDropped()
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state) {
        List<ItemStack> result = super.getDrops(world, pos, state, 0);  //0 indicating no effect from Fortune enchantment
        String resultString = "";
        for (ItemStack itemStack : result) {
            resultString += String.valueOf(itemStack) + "; ";
        }
        return result;
    }

    // -----------------------------

    // Used in some special cases to drop extra items (eg skulls) or destroy other parts of a multiblock (eg bed)
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        return;
    }

    // Used in some special cases to override default harvesting behaviour (for example - shearing a tree to increase the
    //   sapling drop rate and trigger a special achievement)
    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te) {
        super.harvestBlock(worldIn, player, pos, state, te);
        return;
    }

    // Used in some special cases set the type of drop for silk enchantment harvesting.
    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        ItemStack result = super.createStackedBlock(state);
        return result;
    }

    // Used in some special cases to customise the random dropping - for example ignoring the effect of fortune enchantment
    //   when harvesting wheat.
    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
        return;
    }

    // ----------------------------\

    // This method is not generally useful for overriding but it can be useful for logging to show the rate of block damage per tick
    @Override
    public float getPlayerRelativeBlockHardness(EntityPlayer playerIn, World worldIn, BlockPos pos) {
        Float result = super.getPlayerRelativeBlockHardness(playerIn, worldIn, pos);
        return result;
    }

    // Renders the block in the SOLID layer
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.SOLID;   // A solid block
    }

    // Used by the renderer to control lighting and visibility of other blocks
    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    // Used by the renderer to control lighting and visibility of other blocks, also by
    // (eg) wall or fence to control whether the fence joins itself to this block
    @Override
    public boolean isFullCube() {
        return true;
    }

    // Render using a BakedModel
    // Not strictly required because the default (super method) is 3
    @Override
    public int getRenderType() {
        return 3;
    }

    // Property for which direction the block is facing in (N, S, E, or W)
    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    // getStateFromMeta, getMetaFromState are used to interconvert between the block's property values and
    //  the stored metadata (which must be an integer in the range 0 - 15 inclusive)
    // The property is encoded as:
    // - Two bits = facing direction (i.e. 0, 1, 2, 3)
    @Override
    public IBlockState getStateFromMeta (int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return this.getDefaultState().withProperty(PROPERTYFACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

        int facingbits = facing.getHorizontalIndex();
        return facingbits;
    }

    // Necessary to define which properties the block uses
    // Will also affect the variants listed in the blockstates model file
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {PROPERTYFACING});
    }

    // Sets the appropriate facing direction based on which way the player is looking
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        // find the quadrant the player is facing
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

        return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
    }
}
