package com.example.examplemod.actualizer.actions;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class CreateBlock implements IActualizerAction {    
    public void apply(World world, double px, double py, double pz, String arg) {
        // TODO: blockstate should be resolve from arg
        IBlockState blockState = Blocks.BRICK_BLOCK.getDefaultState();
        world.setBlockState(new BlockPos(px, py, pz), blockState, 2);
    }
}