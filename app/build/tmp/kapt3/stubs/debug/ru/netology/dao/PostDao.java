package ru.netology.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\'\u00a8\u0006\u0011"}, d2 = {"Lru/netology/dao/PostDao;", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lru/netology/entity/PostEntity;", "insert", "", "post", "likeById", "id", "", "removeById", "save", "updateContentById", "content", "", "app_debug"})
public abstract interface PostDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM PostEntity ORDER BY id DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<ru.netology.entity.PostEntity>> getAll();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    ru.netology.entity.PostEntity post);
    
    @androidx.room.Query(value = "UPDATE PostEntity SET content = :content WHERE id = :id")
    public abstract void updateContentById(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String content);
    
    public abstract void save(@org.jetbrains.annotations.NotNull()
    ru.netology.entity.PostEntity post);
    
    @androidx.room.Query(value = "\n        UPDATE PostEntity SET\n        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,\n        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END\n        WHERE id = :id\n        ")
    public abstract void likeById(long id);
    
    @androidx.room.Query(value = "DELETE FROM PostEntity WHERE id = :id")
    public abstract void removeById(long id);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void save(@org.jetbrains.annotations.NotNull()
        ru.netology.dao.PostDao $this, @org.jetbrains.annotations.NotNull()
        ru.netology.entity.PostEntity post) {
        }
    }
}