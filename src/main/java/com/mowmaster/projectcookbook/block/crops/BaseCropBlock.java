package com.mowmaster.projectcookbook.block.crops;

import com.mowmaster.projectcookbook.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class BaseCropBlock extends CropBlock {


    public static final int MAX_AGE = 7;
    public static final IntProperty AGE = Properties.AGE_7;
    //public static final IntProperty AGE = IntProperty.of("age",0,7);

    public BaseCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.ITEM_CROP_SEED;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
