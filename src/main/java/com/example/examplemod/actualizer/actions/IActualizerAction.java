package com.example.examplemod.actualizer.actions;

import net.minecraft.world.World;

interface IActualizerAction {
    void apply(World world, double px, double py, double pz, String arg);
}