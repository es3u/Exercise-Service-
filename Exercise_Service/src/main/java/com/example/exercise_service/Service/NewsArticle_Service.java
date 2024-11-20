package com.example.exercise_service.Service;


import com.example.exercise_service.Model.NewsArticle_Model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticle_Service {

    ArrayList<NewsArticle_Model> newsArticle = new ArrayList<>();

    public ArrayList<NewsArticle_Model> getNewsArticle(){
        return newsArticle;
    }

    public void addNewsArticle(NewsArticle_Model newsArticle){
        this.newsArticle.add(newsArticle);
    }

    public boolean updateNewsArticle(String id,NewsArticle_Model newsArticle){
        for (int i =0 ; i<this.newsArticle.size() ; i++){
            if (this.newsArticle.get(i).getId().equals(id)){
                this.newsArticle.set(i,newsArticle);
            }else
                return false;
        }
        return true;

    }

    public boolean deleteNewsArticle(String id){
        for (int i =0 ; i<this.newsArticle.size() ; i++){
            if (this.newsArticle.get(i).getId().equals(id)){
                this.newsArticle.remove(i);return true;
            }
        }
        return false;
    }


    public void publish(String id){
        for (int i =0 ; i<this.newsArticle.size() ; i++){
            if (this.newsArticle.get(i).getId().equals(id)){
                if (this.newsArticle.get(i).isPublished()==false){
                    this.newsArticle.get(i).setPublished(true);
                }
            }

        }
    }

    public ArrayList<String> getAllPublished(){
        ArrayList<String> newsArticle_models1 = new ArrayList<>();
        for (int i =0 ; i<this.newsArticle.size() ; i++){
            if (this.newsArticle.get(i).isPublished()==true){
                newsArticle_models1.add(this.newsArticle.get(i).getContent());
            }else
                return null;
        }
        return newsArticle_models1;
    }

    public ArrayList<String> getCategory(String category){
        ArrayList<String> newsArticle_models1 = new ArrayList<>();
        for (int i =0 ; i<this.newsArticle.size() ; i++){
            if (this.newsArticle.get(i).getCategory().equals(category)){
                newsArticle_models1.add(this.newsArticle.get(i).getContent());

            }else
                return null;
        }
        return newsArticle_models1;
    }








}
