package com.iut.sorbonne.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ENiveau {
    BUT1(1),
    BUT2(2),
    BUT3(3),

    LP(4),

    M1(5),
    M2(6);

    private final long index;
}
