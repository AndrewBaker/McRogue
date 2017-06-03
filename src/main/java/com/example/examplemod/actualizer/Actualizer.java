package com.example.examplemod.actualizer;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.example.examplemod.Template;
import com.example.examplemod.actualizer.actions.CreateBlock;
import com.example.examplemod.actualizer.actions.CreateMob;;
public class Actualizer 
{
    public static void buildFromTemplate(World world, BlockPos pos, Template template) {
        for (int x = pos.getX();x<pos.getX()+10;x++)
            for (int z = pos.getZ();z<pos.getZ()+10;z++)
                new CreateBlock().apply(world, x, pos.getY(), z, "asdf");
            
        new CreateMob().apply(world, pos.getX(), pos.getY(), pos.getZ(), "asdf");
    }    
}