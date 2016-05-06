package com.dedotatedwam.jjhorticulture;

import com.dedotatedwam.jjhorticulture.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JJTabs extends CreativeTabs {

    public JJTabs(String tabName)
    {
        super(tabName);
        this.setBackgroundImageName("dedotatedwam.png");
    }

    @Override
    public Item getTabIconItem()
    {
        return CommonProxy.pH_tester;
    }
}
