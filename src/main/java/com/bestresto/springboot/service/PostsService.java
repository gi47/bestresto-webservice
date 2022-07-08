package com.bestresto.springboot.service;

import com.bestresto.springboot.domain.posts.Posts;
import com.bestresto.springboot.domain.posts.PostsRepository;
import com.bestresto.springboot.web.PostsListResponseDto;
import com.bestresto.springboot.web.PostsResponseDto;
import com.bestresto.springboot.web.PostsSaveRequestDto;
import com.bestresto.springboot.web.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    // 게시글 저장
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // ** 더티체킹(상태변경검사)
    // update- 쿼리를 날리지 X <- JPA의 영속성 컨텍스트 : 엔티티를 영구 저장하는 환경
    // (Spring Data Jpa 디폴트)JPA의 엔티티 매니저가 활성화 된 상태 >> 트랜잭션 시작 - 엔티티 조회 - 엔티티 변경 - 트랜잭션 커밋
    // Entity값만 변경시 , 쿼리 날릴 필요 X


    // 게시글 수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = "+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // read 조회
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    // 게시물 리스트
    @Transactional(readOnly = true)	// readonly: 트랜잭션 유지, 조회속도 향상
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());

    }

    // 게시글 삭제
    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);	//JpaRepository- delete 메소드 지원 / 이외의 방법 아래
        // 1. deleteById 메소드 >>  id로 삭제  가능
        // 2. 엔티티 파라미터로 삭제 가능
    }

}
