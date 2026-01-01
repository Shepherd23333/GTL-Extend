package cn.qiuye.gtlextend.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.logic.OCParams;
import com.gregtechceu.gtceu.api.recipe.logic.OCResult;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import com.hepdd.gtmthings.api.misc.WirelessEnergyManager;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static org.gtlcore.gtlcore.common.data.GTLMaterials.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PlanetaryEngineMachine extends WorkableElectricMultiblockMachine {

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            PlanetaryEngineMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    public PlanetaryEngineMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Persisted
    private UUID uuid;// 绑定用户ID
    private boolean eut = false;

    // 玩家交互绑定
    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.uuid == null || !this.uuid.equals(player.getUUID())) {
            this.uuid = player.getUUID();
        }
        return true;
    }

    private static List<Material> getMaterial() {
        var materials = new Material[] { Argon, Helium, Iron, Nickel, Nitrogen, Oxygen, Silver, Adamantium, Vibranium, Chaos, Mithril, Crystalmatrix,
                Echoite, Legendarium, DraconiumAwakened, Starmetal, Orichalcum, Infuscolium, Enderium, DegenerateRhenium, HeavyQuarkDegenerateMatter,
                MetastableHassium, QuantumChromodynamicallyConfinedMatter, AstralTitanium, CelestialTungsten, Quasifissioning,
                Flyb, TaraniumRichLiquidHelium4, QuarkGluon, DenseNeutron, HighEnergyQuarkGluon, RawStarMatter, CosmicMesh, ActiniumSuperhydride };

        Random random = new Random();
        List<Material> selectedMaterials = new ObjectArrayList<>();

        for (Material material : materials) {
            int randomValue = random.nextInt(100) + 1;
            if (randomValue > 50) {
                selectedMaterials.add(material);
            }
        }

        return selectedMaterials;
    }

    public static GTRecipe PERecipeModifier(MetaMachine machine, GTRecipe recipe,
                                            OCParams params, OCResult result) {
        if (machine instanceof IMultiController controller && controller.isFormed()) {
            final var itemInputs = new ObjectArrayList<Content>();
            final var itemOutputs = new ObjectArrayList<Content>();
            final var fluidOutputs = new ObjectArrayList<Content>();
            var iteminput = recipe.inputs.get(ItemRecipeCapability.CAP);
            if (iteminput != null) itemInputs.addAll(iteminput);
            var itemoutput = recipe.outputs.get(ItemRecipeCapability.CAP);
            if (itemoutput != null) itemOutputs.addAll(itemoutput);
            var fluidoutput = recipe.outputs.get(FluidRecipeCapability.CAP);
            if (fluidoutput != null) fluidOutputs.addAll(fluidoutput);
            GTRecipe recipe1 = recipe.copy();
            recipe1.inputs.clear();
            recipe1.outputs.clear();
            recipe1.inputs.put(ItemRecipeCapability.CAP, itemInputs);
            final var materials = getMaterial();
            if (fluidoutput != null) {
                var tierChanceBoost = fluidoutput.get(0).tierChanceBoost;
                var slotName = fluidoutput.get(0).slotName;
                var uiName = fluidoutput.get(0).uiName;

                if (!materials.isEmpty()) {
                    for (Material material : materials) {
                        fluidOutputs.add(new Content(material.getFluid(FluidStorageKeys.PLASMA, 131072000), 100, 100, tierChanceBoost, slotName, uiName));
                    }
                }
            }
            recipe1.outputs.put(ItemRecipeCapability.CAP, itemOutputs);
            recipe1.outputs.put(FluidRecipeCapability.CAP, fluidOutputs);
            return recipe1;
        }
        return recipe;
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        boolean value = false;
        if (this.uuid != null) {
            this.eut = true;
            value = true;
        } else {
            this.eut = false;
        }
        return value;
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        if (this.eut && this.uuid != null) {
            value = WirelessEnergyManager.addEUToGlobalEnergyMap(uuid, BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(100)), this);
        }
        return value;
    }
}
