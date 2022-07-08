package com.bestresto.springboot.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 모든 final 필드가 포함된 생성자 생성 (final만, 그외는 생성X)
public class HelloResponseDTO {
    private final String name;
    private final int amount;
}
