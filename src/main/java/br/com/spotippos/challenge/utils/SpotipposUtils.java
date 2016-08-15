
package br.com.spotippos.challenge.utils;

import com.google.common.collect.Range;

import java.util.Arrays;

/**
 * @author Elton Moraes
 * @Since 12/08/2016.
 */
public abstract class SpotipposUtils {

    public static Range<Long> setRange(final long a, final long b){
        long[] range = {a, b};
        Arrays.sort(range);
        return Range.closed(range[0], range[1]);
    }
}
