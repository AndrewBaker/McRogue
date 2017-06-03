package com.example.examplemod.actualizer.actions;

import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.world.World;

public class CreateMob implements IActualizerAction {    
    public void apply(World world, double px, double py, double pz, String arg) {
        // determine entity type from arg
        
        EntityPolarBear entity = new EntityPolarBear(world);
        entity.setLocationAndAngles( px, py, pz, 0.0f, 0.0f);
        world.spawnEntityInWorld(entity);
    }
}