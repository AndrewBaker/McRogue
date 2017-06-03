package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;

import com.example.examplemod.actualizer.Actualizer;

import net.minecraft.world.World;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod( modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod 
{
    public static final String MODID = "mcrogue";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityEnteringChunk(EntityEvent.EnteringChunk event)
    {
        if (event.getEntity() instanceof EntityPlayer && !event.getEntity().worldObj.isRemote)
        {
            EntityPlayer player = (EntityPlayer)event.getEntity();
            World world = player.getEntityWorld();

            Actualizer.buildFromTemplate(world, player.getPosition(), "fakeTemplateData");
        }
    }
}
