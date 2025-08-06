package cn.qiuye.gtl_extend.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.text.DecimalFormat;

import static cn.qiuye.gtl_extend.utils.FormattingUtil.DECIMAL_FORMAT_SIC_2F;
import static cn.qiuye.gtl_extend.utils.FormattingUtil.formatNumberReadable;

public class NumberUtils {

    public static @NotNull String formatNumber(double number) {
        final String[] UNITS = {"", "K", "M", "G", "T", "P", "E", "Z", "Y", "B", "N", "D"};
        DecimalFormat df = new DecimalFormat("#.##");
        double temp = number;
        int unitIndex = 0;
        while (temp >= 1000 && unitIndex < UNITS.length - 1) {
            temp /= 1000;
            unitIndex++;
        }
        return df.format(temp) + UNITS[unitIndex];
    }

    public static String formatLong(long number) {
        return formatNumber(number);
    }

    public static String formatDouble(double number) {
        return formatNumber(number);
    }

    public static MutableComponent numberText(double number) {
        return Component.literal(formatDouble(number));
    }

    public static MutableComponent numberText(long number) {
        return Component.literal(formatLong(number));
    }

    public static String formatBigIntegerNumberOrSic(BigInteger number) {
        return number.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 ? DECIMAL_FORMAT_SIC_2F.format(number) : formatNumberReadable(number.longValue());
    }
}
