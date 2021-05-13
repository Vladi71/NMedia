package ru.netology.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lru/netology/repository/PostRepositoryImpl;", "Lru/netology/repository/PostRepository;", "()V", "getAllAsync", "", "callback", "Lru/netology/repository/PostRepository$Callback;", "", "Lru/netology/dto/Post;", "getPostAsync", "id", "", "likeById", "removeById", "save", "post", "unLikeById", "app_debug"})
public final class PostRepositoryImpl implements ru.netology.repository.PostRepository {
    
    @java.lang.Override()
    public void getAllAsync(@org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<java.util.List<ru.netology.dto.Post>> callback) {
    }
    
    @java.lang.Override()
    public void getPostAsync(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback) {
    }
    
    @java.lang.Override()
    public void likeById(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback) {
    }
    
    @java.lang.Override()
    public void unLikeById(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback) {
    }
    
    @java.lang.Override()
    public void save(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<ru.netology.dto.Post> callback) {
    }
    
    @java.lang.Override()
    public void removeById(long id, @org.jetbrains.annotations.NotNull()
    ru.netology.repository.PostRepository.Callback<kotlin.Unit> callback) {
    }
    
    public PostRepositoryImpl() {
        super();
    }
}