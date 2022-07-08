package com.bestresto.springboot.domain.posts;

import com.bestresto.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// @순서: 주요 어노테이션을 클래스에 가깝게(Lombok은 필수@가 아니므로, JPA@인 @Entity가 클래스에 더 가깝다)
@Getter	// Lombok@ - 클래스 내 모든 필드의 Getter 메서드 자동 생성
@NoArgsConstructor	// Lombok@ - 기본 생성자 자동 추가 = public Posts(){}
@Entity	// JPA@ - 실제 DB 테이블과 매칭될 클래스, "Entity class", 기본값 두 단어 사이 '_'
public class Posts extends BaseTimeEntity {
//
    @Id	// 매칭될 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)	// PK의 생성규칙, GenerationType.IDENTITY : auto_increment(스프링부트 2.0)
    private Long id;

    @Column(length = 500, nullable = false)	// 테이블의 칼럼, 기본값 외의 설정이 있을 때 사용(varchar255 >> 500)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder	// 빌더 패턴 클래스 생성, 생성자가 상단에 선언된 경우 >> 생성자에 포함된 필드만 빌드에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
