package me.suplexgod.grue.util;

import me.suplexgod.grue.entity.ModEntities;
import me.suplexgod.grue.entity.custom.SpiritEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.jetbrains.annotations.NotNull;

public class ModRegistries{
    public static void registerModStuffs(){
        registerAttributes();


    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SPIRIT, SpiritEntity.setAttributes());
    }


}
