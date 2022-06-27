package me.suplexgod.grue.client;

import me.suplexgod.grue.entity.ModEntities;
import me.suplexgod.grue.entity.client.SpiritRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class GrueClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.SPIRIT, SpiritRenderer::new);


    }
}
