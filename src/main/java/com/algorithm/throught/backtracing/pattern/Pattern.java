package com.algorithm.throught.backtracing.pattern;

/**
 * @author dongfengfeng on 2020-02-16
 */
public class Pattern {
    private boolean matched = false;

    private char[] pattern;

    private int plen;

    public Pattern(String patternStr) {
        char[] pattern = patternStr.toCharArray();
        this.pattern = pattern;
        this.plen = pattern.length;
    }

    public boolean match(String targetStr) {
        matched = false;
        char[] texts = targetStr.toCharArray();
        rmatch(0, 0, texts, texts.length);
        return matched;
    }

    private void rmatch(int ti, int pi, char[] texts, int tlen) {
        if (matched) {
            return;
        }
        if (pi == plen) {
            if (ti == tlen) {
                matched = true;
            }
            return;
        }

        if (pattern[pi] == '*') {
            for (int i=ti; i<tlen; i++) {
                rmatch(i, pi+1, texts, tlen);
            }
        }
        else if (pattern[pi] == '?') {
            rmatch(ti, pi+1, texts, tlen);
            rmatch(ti+1, pi+1, texts, tlen);
        }
        else if (ti < tlen && pattern[pi] == texts[ti]) {
            rmatch(ti+1, pi+1, texts, tlen);
        }
    }
}
