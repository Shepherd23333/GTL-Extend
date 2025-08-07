package cn.qiuye.gtl_extend.mixin.gtl;

import org.gtlcore.gtlcore.utils.NumberUtils;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import static cn.qiuye.gtl_extend.utils.NumberUtils.formatNumber;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(NumberUtils.class)
public class NumberUtilsMixin {

    /**
     * @author .
     */
    @Unique
    public static String formatLong(long number) {
        return formatNumber(number);
    }

    /**
     * @author .
     */
    @Unique
    public static String formatDouble(double number) {
        return formatNumber(number);
    }

    /**
     * @author .
     */
    @Unique
    public static MutableComponent numberText(double number) {
        return Component.literal(formatDouble(number));
    }

    /**
     * @author .
     */
    @Unique
    public static MutableComponent numberText(long number) {
        return Component.literal(formatLong(number));
    }
}
