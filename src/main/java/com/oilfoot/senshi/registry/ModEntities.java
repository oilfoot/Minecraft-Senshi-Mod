package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageEntity;
import com.oilfoot.senshi.Senshi;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
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
}
