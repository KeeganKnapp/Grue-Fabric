package me.suplexgod.grue;

import me.suplexgod.grue.sound.SpiritSounds;
import me.suplexgod.grue.util.ModRegistries;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.EventListener;



public class Grue implements ModInitializer {

    public static final String MOD_ID = "grue";

    @Override
    public void onInitialize() {
        ModRegistries.registerModStuffs();




    }


}
