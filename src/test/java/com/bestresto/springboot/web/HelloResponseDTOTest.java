package com.bestresto.springboot.web;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDTOTest {
    @Test
    public void lombok_functioning_T(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDTO dto = new HelloResponseDTO(name, amount);

        //then
        //assertThat(): 1. 테스트 검증 메서드 2.  검증할 대상을 인자로
        //isEqualTo(): 1. assertThat의 동등 비교 메서드 2. 1.과 값이 같을 때만 성공
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
