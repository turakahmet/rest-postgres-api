package com.postgrerest.entity.hataMessages.hataMesaj;

import lombok.Getter;

@Getter
public enum HataMesaj implements ITextEnum{
    KAYIT_EKLERKEN_HATA("hataMesaj.kayitHatasi", "201"),
    KAYIT_SILERKEN_HATA("hataMesaj.silmeHatasi", "404");

    private final String etiket;
    private final String kod;

    HataMesaj(String etiket, String kod) {
        this.etiket = etiket;
        this.kod = kod;
    }
}
