package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.ToolMaterials.BoToolMaterial;
import com.oilfoot.senshi.ToolMaterials.KatanaToolMaterial;
import com.oilfoot.senshi.ToolMaterials.NaginataToolMaterial;
import com.oilfoot.senshi.ToolMaterials.SaiToolMaterial;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorMaterial;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorItem;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorMaterial;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorMaterial;
import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.items.throwables.shuriken.shurikenItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems{

//basicItems
    public static final Item RED_SCALES = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item BLUE_SCALES = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item ENHANCEMENT_DUST = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

//Special Items
    public static final Item SHURIKEN = new shurikenItem(new Item.Settings().group(ItemGroup.COMBAT).maxCount(256));
    public static final Item KUNAI = new shurikenItem(new Item.Settings().group(ItemGroup.COMBAT));

//BlockItems
    public static final BlockItem CHAINS = new BlockItem(ModBlocks.CHAINS, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockItem KATANABLOCK = new BlockItem(ModBlocks.KATANABLOCK, new Item.Settings());
    public static final BlockItem ENHANCEMENT_ORE = new BlockItem(ModBlocks.ENHANCEMENT_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

//ToolItems
    public static final ToolItem KATANA = new SwordItem(KatanaToolMaterial.INSTANCE, 2, -1.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem SAI = new SwordItem(SaiToolMaterial.INSTANCE, -2, -0.5F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem NAGINATA = new SwordItem(NaginataToolMaterial.INSTANCE, 2, -3.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem BO = new SwordItem(BoToolMaterial.INSTANCE, 0, -1.8F, new Item.Settings().group(ItemGroup.COMBAT));

//ArmorItems

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

    //Shinobi Armor
    public static final Item SHINOBI_HOOD = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SHINOBI_ROBE = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SHINOBI_HAIDATE = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item SHINOBI_SHOES = new ShinobiArmorItem(ShinobiArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static void RegisterItems() {

    //basicItems
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "red_scales"), RED_SCALES);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "blue_scales"), BLUE_SCALES);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "enhancement_dust"), ENHANCEMENT_DUST);

    //specialItems
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shuriken"), SHURIKEN);
        Registry.register(Registry.ITEM,new Identifier(Senshi.MOD_ID, "kunai"), KUNAI);

    //BlockItems
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "chains"), CHAINS);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "katanablock"), KATANABLOCK);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "enhancement_ore"), ENHANCEMENT_ORE);

    //ToolItems//
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "katana"), KATANA);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "sai"), SAI);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "naginata"), NAGINATA);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "bo"), BO);

    //ArmorItems//

        //Mapple Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_kabuto"), MAPPLE_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_do"), MAPPLE_DO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_haidate"), MAPPLE_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "mapple_waraji"), MAPPLE_WARAJI);

        //Tadeka Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_kabuto"), TAKEDA_KABUTO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_do"), TAKEDA_DO);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_haidate"), TAKEDA_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "takeda_waraji"), TAKEDA_WARAJI);

        //Shinobi Armor
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_hood"), SHINOBI_HOOD);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_robe"), SHINOBI_ROBE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_haidate"), SHINOBI_HAIDATE);
        Registry.register(Registry.ITEM, new Identifier(Senshi.MOD_ID, "shinobi_shoes"), SHINOBI_SHOES);

    }
}
