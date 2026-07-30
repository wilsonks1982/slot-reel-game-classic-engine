package org.wilsonks.slotreelgameclassicengine.api;

import java.util.regex.Pattern;

public record PayRule(String originalPattern, Pattern regexPattern, int payout) implements Comparable<PayRule> {
    @Override
    public int compareTo(PayRule o) {
        return Integer.compare(o.payout(), this.payout());
    }
}

