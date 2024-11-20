package com.example.exercise_service.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle_Model {

    @NotEmpty(message = "id can not be empty")
    @Size(min = 2 , max = 10 )
    private String id ;

    @NotEmpty(message = "title ccan not be empty")
    @Size(min = 2 , max = 100 )
    private String title;

    @NotEmpty(message = "author name van not be empty")
    @Size(min = 4 , max = 20 )
    private String author;

    @NotEmpty(message = "content can not be empty")
    @Min(value = 200, message = "Must be more than 200 characters.")
    private String content;

    @NotEmpty(message = "category can not be Empty")
    @Pattern(regexp = "^(politics|sports|technology)$" , message = "Must be either politics,  sports or  technology only.")
    private String category;
    @NotEmpty(message = "image url can not be empty")
    private String imageUrl ;

    private boolean isPublished = false ;
    @PastOrPresent
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate publishDate ;

}
