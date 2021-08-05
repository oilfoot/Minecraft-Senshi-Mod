package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageEntity;
import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.items.throwables.shuriken.shurikenEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.example.registry.EntityRegistryBuilder;
import net.minecraft.entity.Entity;

public class ModEntities {

    public static void RegisterEntities(){

    }
    public static final EntityType<OgreRageEntity> OGRE_RAGE_ENTITY = buildEntity(OgreRageEntity::new,
            OgreRageEntity.class, 1.0F, 2.0F);

    public static void init(){
        FabricDefaultAttributeRegistry.register(OGRE_RAGE_ENTITY, OgreRageEntity.createAttrubites());
    }

    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass, float width, float height) {
        String name = entityClass.getSimpleName().toLowerCase();
        return EntityRegistryBuilder.<T>createBuilder(new Identifier(Senshi.MOD_ID, name)).entity(entity)
                .category(SpawnGroup.CREATURE).dimensions(EntityDimensions.changing(width, height)).build();

    }

    public static final EntityType<shurikenEntity> SHURIKEN_ENTITY_ENTITY_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Senshi.MOD_ID, "shuriken"),
            FabricEntityTypeBuilder.<shurikenEntity>create(SpawnGroup.MISC, shurikenEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    );

   /*public static final EntityType<shurikenEntity> SHURIKEN_ENTITY = buildEntity(shurikenEntity::new,
            shurikenEntity.class, 1.0F, 2.0F);*/

}
