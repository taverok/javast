package com.taverok.javast.service;

import com.taverok.javast.domain.Version;

public class VastFactory {
    public static com.taverok.javast.domain.base.Vast getInstance(Version v){
        switch (v) {
            default:
                return new com.taverok.javast.domain.base.Vast();
        }
    }
}
