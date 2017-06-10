package com.example.examplemod;

import java.io.InputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.example.examplemod.actualizer.Actualizer;

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
    
     public Template loadTemplate() {
        try {
            YAMLMapper mapper = new YAMLMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("templates/house.yaml");
            Template template = mapper.readValue(is, Template.class);
            return template;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }

    @SubscribeEvent
    public void onEntityEnteringChunk(EntityEvent.EnteringChunk event)
    {
        if (event.getEntity() instanceof EntityPlayer && !event.getEntity().worldObj.isRemote)
        {
            EntityPlayer player = (EntityPlayer)event.getEntity();
            World world = player.getEntityWorld();
            Template template = loadTemplate();

            Actualizer.create(template)
                      .buildFromTemplate(world, player.getPosition());
        }
    }
}
