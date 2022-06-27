package me.suplexgod.grue.util;

import me.suplexgod.grue.entity.ModEntities;
import me.suplexgod.grue.entity.custom.SpiritEntity;
import me.suplexgod.grue.sound.SpiritSounds;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

import static me.suplexgod.grue.sound.SpiritSounds.SPIRIT_AMBIENT;

public class ModRegistries{
    public static void registerModStuffs(){
        registerAttributes();
        registerSounds();

    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SPIRIT, SpiritEntity.setAttributes());
    }

    private static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, SpiritSounds.SPIRIT_AMBIENT_ID, SPIRIT_AMBIENT);
    }
}
