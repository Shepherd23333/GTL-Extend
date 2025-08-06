package cn.qiuye.gtl_extend.utils;

import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.text.NumberFormat;


@SuppressWarnings("UnnecessaryUnicodeEscape")
public class FormattingUtil {
    public static final DecimalFormat DECIMAL_FORMAT_1F = new DecimalFormat("#,##0.#");
    public static final DecimalFormat DECIMAL_FORMAT_2F = new DecimalFormat("#,##0.##");
    public static final DecimalFormat DECIMAL_FORMAT_SIC_2F = new DecimalFormat("0.00E00");

    public static String formatNumberReadable(long number) {
        return formatNumberReadable(number, false);
    }

    public static String formatNumberReadable(long number, boolean milli) {
        return formatNumberReadable(number, milli, DECIMAL_FORMAT_1F, null);
    }

    public static String formatNumberReadable(double number, boolean milli, NumberFormat fmt, @Nullable String unit) {
        StringBuilder sb = new StringBuilder();
        if (number < 0) {
            number = -number;
            sb.append('-');
        }

        if (milli && number >= 1e3) {
            milli = false;
            number /= 1e3;
        }

        int exp = 0;
        if (number >= 1e3) {
            exp = (int) Math.log10(number) / 3;
            if (exp > 7) exp = 7;
            if (exp > 0) number /= Math.pow(1e3, exp);
        }

        sb.append(fmt.format(number));
        if (exp > 0) sb.append("kMGTPEZ".charAt(exp - 1));
        else if (milli && number != 0) sb.append('m');

        if (unit != null) sb.append(unit);
        return sb.toString();
    }
}
