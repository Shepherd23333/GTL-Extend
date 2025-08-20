package cn.qiuye.gtl_extend.common.machine.multiblock.electric;

import cn.qiuye.gtl_extend.utils.NumberUtils;

import org.gtlcore.gtlcore.api.machine.multiblock.NoEnergyMultiblockMachine;
import org.gtlcore.gtlcore.utils.MachineIO;

import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

import com.hepdd.gtmthings.api.misc.WirelessEnergyManager;
import com.hepdd.gtmthings.utils.TeamUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DimensionalPower extends NoEnergyMultiblockMachine implements IMachineLife {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            DimensionalPower.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    // 常量定义
    private static final int BASE_PARALLEL = 64;
    private final BigInteger longmax = BigInteger.valueOf(Long.MAX_VALUE);
    protected ConditionalSubscriptionHandler machineStorage;
    BigInteger two = BigInteger.valueOf(2);
    private final BigInteger MAX = two.pow(4194304);
    @Persisted
    private UUID userid;
    @Persisted
    private int oc = 0;     // 当前电路配置编号
    private BigInteger eut = BigInteger.ZERO;

    public DimensionalPower(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.machineStorage = new ConditionalSubscriptionHandler(this, this::StartupUpdate, this::isFormed);
    }

    // 电路配置更新逻辑
    public void StartupUpdate() {
        if (getOffsetTimer() % 20 == 0) {
            oc = 0;
            int[] priorityOrder = { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
            for (int config : priorityOrder) {
                if (MachineIO.notConsumableCircuit(this, config)) {
                    this.oc = config;
                    return;
                }
            }
        }
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        machineStorage.initialize(getLevel());
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    /// //////////////////////////////////////
    /// // ******* Recipe Logic ******** /////
    /// //////////////////////////////////////

    @Override
    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.userid == null || !this.userid.equals(player.getUUID())) {
            this.userid = player.getUUID();
        }
        return true;
    }

    @Override
    public boolean onWorking() {
        boolean value = super.onWorking();
        int result = eut.compareTo(BigInteger.ZERO);
        if (result == 0) {
            WirelessEnergyManager.addEUToGlobalEnergyMap(userid, outEUt(), this);
        } else {
            return false;
        }
        return value;
    }

    @Override
    public void afterWorking() {
        eut = BigInteger.ZERO;
        super.afterWorking();
    }

    @Override
    public boolean dampingWhenWaiting() {
        return false;
    }

    @Nullable
    public GTRecipe recipeModifier(@NotNull GTRecipe recipe) {
        if (this.oc == 0) return null;
        int parallel = getBaseParallel(); // 直接调用实例方法
        if (this.userid != null) {
            GTRecipe recipe1 = recipe.copy();
            recipe1.duration = recipe.duration * parallel;
            return GTRecipeModifiers.accurateParallel(
                    this, // 传入当前实例
                    recipe1,
                    parallel,
                    false).getFirst();
        }
        return null;
    }

    // 获取超频次数（电路配置映射）
    private int calculateOverclockTimes(int circuitConfig) {
        return switch (Math.min(circuitConfig, 12)) {
            case 2 -> 4;
            case 3 -> 8;
            case 4 -> 16;
            case 5 -> 32;
            case 6 -> 64;
            case 7 -> 128;
            case 8 -> 256;
            case 9 -> 512;
            case 10 -> 1024;
            case 11 -> 32768;
            case 12 -> 65536;
            default -> 2;
        };
    }

    private BigInteger outEUt() {
        int ocTimes = calculateOverclockTimes(oc);
        BigInteger parallel = BigInteger.valueOf(getBaseParallel());
        BigInteger eut = longmax.multiply(parallel.pow(ocTimes));
        return eut.min(MAX).max(longmax);
    }

    // 计算并行（电路编号的8次方，1号特殊处理）
    private int getBaseParallel() {
        return (oc == 1) ? BASE_PARALLEL : (int) Math.pow(oc, 8);
    }

    /////////////////////////////////////
    ////// ******** Gui ******** ////////
    /// /////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (!this.isFormed) return;
        // 用户无线电网信息（公共显示部分）
        if (userid != null) {
            textList.add(Component.translatable("gtmthings.machine.wireless_energy_monitor.tooltip.0",
                    TeamUtil.GetName(getLevel(), userid)));
            textList.add(Component.translatable("gtmthings.machine.wireless_energy_monitor.tooltip.1",
                    NumberUtils.formatBigIntegerNumberOrSic(WirelessEnergyManager.getUserEU(userid))));
        }
        textList.add(Component.translatable("gtl_extend_machine_circuit",
                oc,  // 直接显示原始电路编号
                calculateOverclockTimes(oc) // 仅计算倍率
        ));
    }
}
