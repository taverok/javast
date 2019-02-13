package com.taverok.javast.service;

import com.taverok.javast.domain.Version;

public class VastFactory {
    public static com.taverok.javast.domain.base.Vast getInstance(Version v){
        switch (v) {
            case V2_0:
                return new com.taverok.javast.domain.base.Vast();
            case V3_0:
                return new com.taverok.javast.domain.v3.Vast();
            default:
                return new com.taverok.javast.domain.base.Vast();
        }
    }
}
