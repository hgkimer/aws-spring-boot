package com.hgkimer.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
// 이것은 테이블과 매핑된 클래스!
@Entity
public class Posts {

	//이건 PK
	@Id
	// PK 생성 규칙
	// GenerationType.IDENTITY
	//	Indicates that the persistence provider "must assign primary keys for the entity" using a database identity column.
	// Spring boot 2.0 부터 GenerationType.IDENTITY 설정되어야 Auto_increment가 가능하다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	private String author;

	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
