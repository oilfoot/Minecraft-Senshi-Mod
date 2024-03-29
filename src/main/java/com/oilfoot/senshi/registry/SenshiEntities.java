package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.entities.kappa.KappaEntity;
import com.oilfoot.senshi.entities.kumocrawler.KumoCrawlerEntity;
import com.oilfoot.senshi.entities.kumotoko.KumotokoEntity;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageEntity;
import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.entities.samurai.SamuraiEntity;
import com.oilfoot.senshi.items.throwables.shuriken.EnderShurikenEntity;
import com.oilfoot.senshi.items.throwables.shuriken.ShurikenEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.example.registry.EntityRegistryBuilder;
import net.minecraft.entity.Entity;

public class SenshiEntities {

    public static void RegisterEntities(){

    }
    public static final EntityType<OgreRageEntity> OGRE_RAGE_ENTITY = buildEntity(OgreRageEntity::new,
            OgreRageEntity.class, 1.0F, 2.0F);

    public static final EntityType<KappaEntity> KAPPA_ENTITY = buildEntity(KappaEntity::new,
            KappaEntity.class, 1.0F, 2.0F);

    public static final EntityType<KumotokoEntity> KUMOTOKO_ENTITY = buildEntity(KumotokoEntity::new,
            KumotokoEntity.class, 1.0F, 2.0F);

    public static final EntityType<KumoCrawlerEntity> KUMOCRAWLER_ENTITY = buildEntity(KumoCrawlerEntity::new,
            KumoCrawlerEntity.class, 1.0F, 2.0F);

    public static final EntityType<SamuraiEntity> SAMURAI_ENTITY = buildEntity(SamuraiEntity::new,
            SamuraiEntity.class, 1.0F, 2.0F);

    public static void init(){
        FabricDefaultAttributeRegistry.register(OGRE_RAGE_ENTITY, OgreRageEntity.createAttrubites());
        FabricDefaultAttributeRegistry.register(KAPPA_ENTITY, KappaEntity.createAttrubites());
        FabricDefaultAttributeRegistry.register(KUMOTOKO_ENTITY, KumotokoEntity.createAttrubites());
        FabricDefaultAttributeRegistry.register(KUMOCRAWLER_ENTITY, KumoCrawlerEntity.createAttrubites());
        FabricDefaultAttributeRegistry.register(SAMURAI_ENTITY, SamuraiEntity.createAttrubites());

    }

    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass, float width, float height) {
        String name = entityClass.getSimpleName().toLowerCase();
        return EntityRegistryBuilder.<T>createBuilder(new Identifier(Senshi.MOD_ID, name)).entity(entity)
                .category(SpawnGroup.CREATURE).dimensions(EntityDimensions.changing(width, height)).build();

    }


    public static final EntityType<ShurikenEntity> SHURIKEN_ENTITY_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Senshi.MOD_ID, "shuriken"),
            FabricEntityTypeBuilder.<ShurikenEntity>create(SpawnGroup.MISC, ShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    );

    public static final EntityType<EnderShurikenEntity> ENDER_SHURIKEN_ENTITY_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Senshi.MOD_ID, "ender_shuriken"),
            FabricEntityTypeBuilder.<EnderShurikenEntity>create(SpawnGroup.MISC, EnderShurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    );

}
