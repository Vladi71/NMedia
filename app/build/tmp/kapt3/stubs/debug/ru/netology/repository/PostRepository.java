package ru.netology.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lru/netology/repository/PostRepository;", "", "getAllAsync", "", "callback", "Lru/netology/repository/PostRepository$Callback;", "", "Lru/netology/dto/Post;", "getPostAsync", "id", "", "likeById", "removeById", "save", "post", "unLikeById", "Callback", "app_debug"})
public abstract interface PostRepository {
    
    public abstract void likeById(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback);
    
    public abstract void unLikeById(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback);
    
    public abstract void removeById(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<kotlin.Unit> callback);
    
    public abstract void save(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback);
    
    public abstract void getAllAsync(@org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<java.util.List<ru.netology.dto.Post>> callback);
    
    public abstract void getPostAsync(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lru/netology/repository/PostRepository$Callback;", "T", "", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "posts", "(Ljava/lang/Object;)V", "app_debug"})
    public static abstract interface Callback<T extends java.lang.Object> {
        
        public abstract void onSuccess(T posts);
        
        public abstract void onError(@org.jetbrains.annotations.NotNull()
        java.lang.Exception e);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static <T extends java.lang.Object>void onSuccess(@org.jetbrains.annotations.NotNull()
            ru.netology.repository.PostRepository.Callback<T> $this, T posts) {
            }
            
            public static <T extends java.lang.Object>void onError(@org.jetbrains.annotations.NotNull()
            ru.netology.repository.PostRepository.Callback<T> $this, @org.jetbrains.annotations.NotNull()
            java.lang.Exception e) {
            }
        }
    }
}