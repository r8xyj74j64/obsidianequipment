# 黒曜石ツールMod (obsidianequipment)

対象: **NeoForge 1.21.1** / Java 21

(防具は実装コストが高いため見送り、ツールのみに絞っています)

## クラフトフロー
1. 黒曜石 → かまど or 溶鉱炉で精錬 → **黒曜石の粉**
2. 黒曜石の粉 ×4(作業台2×2) → **精製黒曜石インゴット**
3. 精製黒曜石インゴット + 棒 → 作業台でヴァニラ道具と同じ配置のシェイプドレシピで **精製黒曜石の道具**
   - 剣・ツルハシ・斧・シャベル・クワ 全5種(配置はダイヤ/ネザライト道具と同じ形)

## 性能(SimpleTier)
| 項目 | ネザライト | 精製黒曜石 |
|---|---|---|
| level | 4 | 5 |
| 耐久値 | 2031 | 3200 |
| 採掘速度 | 9.0 | 8.5 |
| 追加攻撃力 | +4.0 | +4.5 |
| エンチャント適性 | 15 | 15 |

## コード内容
- `ModToolTiers.java` : `net.neoforged.neoforge.common.SimpleTier` を使用(公式ドキュメントで確認済み)
- `ModItems.java` : ツール5種+中間素材2種を`DeferredRegister`で登録
- `ObsidianEquipmentMod.java` : NeoForge 1.21.1のモッドコンストラクタは `IEventBus` を直接引数で受け取る方式(`FMLJavaModLoadingContext`は不使用)
- レシピJSON(`data/obsidianequipment/recipe/`)7種(精錬2+クラフト5。道具5種のファイル名に`_upgrade`が残っていますが、中身は通常のシェイプドクラフトです)
- 日本語(ja_jp)・英語(en_us)言語ファイル
- アイテムモデルJSON(道具は`item/handheld`、粉・インゴットは`item/generated`を継承)

## 補足: ツールの採掘レベル(順序)について
`level`引数がなくなったため、「このツールはネザライトより上位」という順序づけはコンストラクタでは指定できません。もし「特定ブロックはこのツールでしか壊せない」といった順序制御が必要になった場合は、`TierSortingRegistry.registerTier(...)`で別途登録する形になります(現状は`INCORRECT_FOR_NETHERITE_TOOL`タグを流用しているため、ネザライト以上の性能で掘れる範囲は実質最上位として機能します)。
