package com.example.examplemod.actualizer;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.example.examplemod.Template;
import com.example.examplemod.actualizer.actions.CreateBlock;
import com.example.examplemod.actualizer.actions.CreateMob;

public class Actualizer 
{
    public static void buildFromTemplate(World world, BlockPos pos, Template template) {
        for (int y = 0; y < template.getLayers().length; y++) {
            String[] rows = template.getLayers()[y].split("\n");
            for (int x = 0; x < rows.length; x++) {
                for (int z = 0; z < rows[x].length(); z++) {
                    char c = rows[x].charAt(z);
                    // TODO: lookup in template defintion for this symbol
                    // TODO: pick one of the choices for that defintion randomly
                    // TODO: run command for that option.
                       if (c == '#')
                        new CreateBlock().apply(world, pos.getX() + x, pos.getY() + y, pos.getZ() + z, "");
                }
            }
        }

        //        new CreateMob().apply(world, pos.getX(), pos.getY(), pos.getZ(), "asdf");
    }
}