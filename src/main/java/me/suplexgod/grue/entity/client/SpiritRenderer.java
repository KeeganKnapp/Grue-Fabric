package me.suplexgod.grue.entity.client;

import me.suplexgod.grue.Grue;
import me.suplexgod.grue.entity.custom.SpiritEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SpiritRenderer extends GeoEntityRenderer<SpiritEntity> {
    public SpiritRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SpiritModel());
    }

    @Override
    public Identifier getTextureLocation(SpiritEntity object) {
        return new Identifier(Grue.MOD_ID, "textures/entity/spirit/spirit.png");
    }
}
