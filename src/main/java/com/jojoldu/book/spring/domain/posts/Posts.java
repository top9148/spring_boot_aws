package com.jojoldu.book.spring.domain.posts;

import com.jojoldu.book.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity // JPA 테이블과 링크될 클래스(클래스의 카멜 케이스 언더스코어 네이밍으로 테이블 이름 매칭)
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙 스프링 2.0에서는 GenerationType.IDENTITY(auto_increment)
    private Long id;

    @NotEmpty(message = "비정상 데이터")
    @Column(length = 500, nullable = false) // 테이블 컬럼 - 기본값 문자열 VARCHAR(255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
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
