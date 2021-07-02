package com.hgkimer.springboot.web.domain.posts;

import com.hgkimer.springboot.domain.posts.Posts;
import com.hgkimer.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	private PostsRepository postsRepository;

	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}

	@Test
	public void savePosts() {
		String title = "테스트 게시글";
		String content = "테스트 본문";

		postsRepository.save(Posts.builder().title(title).content(content).author("hgkiemr@gmail.com").build());

		List<Posts> postsList = postsRepository.findAll();

		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);

	}
}
