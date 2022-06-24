package me.suplexgod.grue.entity;

import me.suplexgod.grue.Grue;
import me.suplexgod.grue.entity.custom.SpiritEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<SpiritEntity> SPIRIT = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Grue.MOD_ID, "spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SpiritEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f,1.95f)).build());


}
