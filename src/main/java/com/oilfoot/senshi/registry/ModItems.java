package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.ToolMaterials.KatanaToolMaterial;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorMaterial;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorMaterial;
import com.oilfoot.senshi.senshi;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems{

//basicItems
    public static final Item RED_SCALES = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item BLUE_SCALES = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item ENHANCEMENT_DUST = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

//ToolItems//
    public static final ToolItem KATANA = new SwordItem(KatanaToolMaterial.INSTANCE, 2, -1.5F, new Item.Settings().group(ItemGroup.COMBAT));

//ArmorItems//

    //Mapple Armor
    public static final Item MAPPLE_KABUTO = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MAPPLE_DO = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MAPPLE_HAIDATE = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MAPPLE_WARAJI = new MappleSamuraiArmorItem(MappleSamuraiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    //Takeda Armor
    public static final Item TAKEDA_KABUTO = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TAKEDA_DO = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TAKEDA_HAIDATE = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item TAKEDA_WARAJI = new TakedaSamuraiArmorItem(TakedaSamuraiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static void RegisterItems() {

    //basicItems
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "red_scales"), RED_SCALES);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "blue_scales"), BLUE_SCALES);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "enhancement_dust"), ENHANCEMENT_DUST);

    //ToolItems//
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "katana"), KATANA);

    //ArmorItems//

        //Mapple Armor
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "mapple_kabuto"), MAPPLE_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "mapple_do"), MAPPLE_DO);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "mapple_haidate"), MAPPLE_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "mapple_waraji"), MAPPLE_WARAJI);

        //Tadeka Armor
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "takeda_kabuto"), TAKEDA_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "takeda_do"), TAKEDA_DO);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "takeda_haidate"), TAKEDA_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(senshi.MOD_ID, "takeda_waraji"), TAKEDA_WARAJI);
    }
}
