package com.r8xyj74j64.obsidianequipment;

import com.r8xyj74j64.obsidianequipment.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * 黒曜石の道具・武器を追加するMOD。
 * MOD ID: obsidianequipment
 */
@Mod(ObsidianEquipmentMod.MOD_ID)
public class ObsidianEquipmentMod {

    public static final String MOD_ID = "obsidianequipment";

    // NeoForge 1.21.1: コンストラクタ引数にIEventBusを直接受け取れる
    // (FMLJavaModLoadingContextは不要)
    public ObsidianEquipmentMod(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModItems.CREATIVE_TABS.register(modEventBus);
    }
}
