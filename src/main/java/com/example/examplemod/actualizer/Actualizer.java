package com.example.examplemod.actualizer;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.example.examplemod.Template;
import com.example.examplemod.actualizer.actions.CreateBlock;
import com.example.examplemod.actualizer.actions.CreateMob;

public class Actualizer 
{
    private Template template;
    private Actualizer(Template template) {
        this.template = template;
    }

    public static Actualizer create(Template template) {
        return new Actualizer(template);
    }
    
    public void buildFromTemplate(World world, BlockPos pos) {
        for (int y = 0; y < this.template.getLayers().length; y++) {
            String[] rows = this.template.getLayer(y);
            for (int x = 0; x < rows.length; x++) {
                for (int z = 0; z < rows[x].length(); z++) {
                    char c = rows[x].charAt(z);

                    if (c == '#')
                        new CreateBlock().apply(world, pos.getX() + x, pos.getY() + y, pos.getZ() + z, "");
                }
            }
        }

        //        new CreateMob().apply(world, pos.getX(), pos.getY(), pos.getZ(), "asdf");
    }



}