package me.suplexgod.grue.entity.client;

import me.suplexgod.grue.Grue;
import me.suplexgod.grue.entity.custom.SpiritEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GrueRenderer extends GeoEntityRenderer<SpiritEntity> {
    public GrueRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GrueModel());
    }

    @Override
    public Identifier getTextureLocation(SpiritEntity object) {
        return new Identifier(Grue.MOD_ID, "textures/entity/spirit/spirit.png");
    }
}
