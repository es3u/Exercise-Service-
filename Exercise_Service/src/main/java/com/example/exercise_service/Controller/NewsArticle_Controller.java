package com.example.exercise_service.Controller;

import com.example.exercise_service.ApiResponse.ApiResponse;
import com.example.exercise_service.Model.NewsArticle_Model;
import com.example.exercise_service.Service.NewsArticle_Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/newsArticle")
@RequiredArgsConstructor
public class NewsArticle_Controller {

   private final NewsArticle_Service newsArticle_Service;

   @GetMapping("/display")
    public ResponseEntity getNewsArticle(){
        return ResponseEntity.status(200).body(newsArticle_Service.getNewsArticle());
    }
    @PostMapping("/add")
    public ResponseEntity addNewsArticle(@RequestBody@Valid NewsArticle_Model newsArticle_Model , Errors errors){
       if (errors.hasErrors()){
           return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
       }

        newsArticle_Service.addNewsArticle(newsArticle_Model);
       return
               ResponseEntity.status(200).body("Added new article");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticle(@PathVariable String id, @RequestBody@Valid NewsArticle_Model newsArticle_Model , Errors errors){
       if (errors.hasErrors()){
           return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
       }
       if (newsArticle_Service.updateNewsArticle(id, newsArticle_Model) == true){
           return ResponseEntity.status(200).body("Updated new article");
       }
       return ResponseEntity.status(200).body("Not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticle(@PathVariable String id){
      if (newsArticle_Service.deleteNewsArticle(id) == true){
          return ResponseEntity.status(200).body("Deleted new article");
      }
      return ResponseEntity.status(200).body("Not found");
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity publish(@PathVariable String id){
        newsArticle_Service.publish(id);
        return ResponseEntity.status(200).body("Published new article");
    }
@GetMapping("/getAllPublished")
public ResponseEntity getAllPublished(){

       if(newsArticle_Service.getAllPublished()==null){
           return ResponseEntity.status(400).body("Not found");
       }
       return ResponseEntity.status(200).body(newsArticle_Service.getAllPublished());
}

@GetMapping("/getCategory")
public ResponseEntity getCategory(@PathVariable String category){

       if (newsArticle_Service.getCategory(category) == null){
           return ResponseEntity.status(400).body(new ApiResponse("Not found"));
       }
       return ResponseEntity.status(200).body(newsArticle_Service.getCategory(category));
}





}
