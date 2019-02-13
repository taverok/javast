package com.taverok.javast.domain;

import lombok.Getter;

@Getter
public enum Version{
    V2_0(2.0), V3_0(3.0);

    private String str;
    private double num;

    Version(double num) {
        this.str = String.format("%.1f", num);
        this.num = num;
    }
}
