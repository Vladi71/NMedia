package ru.netology.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003H\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\'\u00a8\u0006\u0010"}, d2 = {"Lru/netology/api/PostsApiService;", "", "dislikeById", "Lretrofit2/Call;", "Lru/netology/dto/Post;", "id", "", "getAll", "", "getById", "likeById", "removeById", "", "save", "post", "Companion", "app_debug"})
public abstract interface PostsApiService {
    @org.jetbrains.annotations.NotNull()
    public static final ru.netology.api.PostsApiService.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "posts")
    public abstract retrofit2.Call<java.util.List<ru.netology.dto.Post>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "posts/{id}")
    public abstract retrofit2.Call<ru.netology.dto.Post> getById(@retrofit2.http.Path(value = "id")
    long id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "posts")
    public abstract retrofit2.Call<ru.netology.dto.Post> save(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.netology.dto.Post post);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "posts/{id}")
    public abstract retrofit2.Call<kotlin.Unit> removeById(@retrofit2.http.Path(value = "id")
    long id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "posts/{id}/likes")
    public abstract retrofit2.Call<ru.netology.dto.Post> likeById(@retrofit2.http.Path(value = "id")
    long id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.DELETE(value = "posts/{id}/likes")
    public abstract retrofit2.Call<ru.netology.dto.Post> dislikeById(@retrofit2.http.Path(value = "id")
    long id);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lru/netology/api/PostsApiService$Companion;", "", "()V", "instance", "Lru/netology/api/PostsApiService;", "getInstance", "()Lru/netology/api/PostsApiService;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "okhttp", "Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        private static final okhttp3.logging.HttpLoggingInterceptor logging = null;
        private static final okhttp3.OkHttpClient okhttp = null;
        private static final retrofit2.Retrofit retrofit = null;
        @org.jetbrains.annotations.NotNull()
        private static final ru.netology.api.PostsApiService instance = null;
        
        @org.jetbrains.annotations.NotNull()
        public final ru.netology.api.PostsApiService getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}