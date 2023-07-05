package com.example.finaltask.mapping;

import com.example.finaltask.model.dto.CommentDTO;
import com.example.finaltask.model.dto.CreateCommentDTO;
import com.example.finaltask.model.dto.FullAdsDTO;
import com.example.finaltask.model.dto.UserDTO;
import com.example.finaltask.model.entity.Ads;
import com.example.finaltask.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment toEntity(CommentDTO dto);

    CommentDTO toDto(Comment entity);

    CommentDTO toEntityCCD(CreateCommentDTO createCommentDTO);

//    Comment  toEntity (CreateCommentDTO createCommentDTO);

    CreateCommentDTO toDto1 (Comment entity);

//    @Mapping(source = "authorId.id", target = "author")
//    @Mapping(source = "authorId", target = "authorImage", qualifiedByName = "getAvatar")
//    @Mapping(source = "authorId", target = "authorFirstName")
//    @Mapping(source = "ads.id", target = "pk")
//    CommentDTO toDtoWithAuthorInfo(Comment comment);


//    @Mapping(target = "author", source = "userDto.id")
//    @Mapping(target = "authorImage", source = "authorId.lastName")
//    @Mapping(target = "authorFirstName", source = "authorId.email")
//    @Mapping(target = "createdAt", expression="java(getImage(ads))")
//    @Mapping(target = "pk", source = "authorId.phone")
//    @Mapping(target = "text", source = "id")
//    CommentDTO mergeCommentAndUser(UserDTO userDTO);
}
//    private Integer author;
//    private String authorImage;
//    private String authorFirstName;
//    private Long createdAt;
//    private Integer pk;
//    private String text;