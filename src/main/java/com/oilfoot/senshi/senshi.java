package com.oilfoot.senshi;

import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import software.bernie.geckolib3.GeckoLib;

public class senshi  implements ModInitializer {

    public static final String MOD_ID = "senshi";

    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModItems.RegisterItems();
        new ModEntities();
        ModEntities.init();
    }
}
