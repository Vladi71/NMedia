package ru.netology.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lru/netology/adapter/OnInteractionListener;", "", "onCancelEdit", "", "post", "Lru/netology/dto/Post;", "onEdit", "onLike", "onOpenPost", "onRemove", "app_debug"})
public abstract interface OnInteractionListener {
    
    public abstract void onLike(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post);
    
    public abstract void onRemove(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post);
    
    public abstract void onEdit(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post);
    
    public abstract void onCancelEdit(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post);
    
    public abstract void onOpenPost(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void onLike(@org.jetbrains.annotations.NotNull()
        ru.netology.adapter.OnInteractionListener $this, @org.jetbrains.annotations.NotNull()
        ru.netology.dto.Post post) {
        }
        
        public static void onRemove(@org.jetbrains.annotations.NotNull()
        ru.netology.adapter.OnInteractionListener $this, @org.jetbrains.annotations.NotNull()
        ru.netology.dto.Post post) {
        }
        
        public static void onEdit(@org.jetbrains.annotations.NotNull()
        ru.netology.adapter.OnInteractionListener $this, @org.jetbrains.annotations.NotNull()
        ru.netology.dto.Post post) {
        }
        
        public static void onCancelEdit(@org.jetbrains.annotations.NotNull()
        ru.netology.adapter.OnInteractionListener $this, @org.jetbrains.annotations.NotNull()
        ru.netology.dto.Post post) {
        }
        
        public static void onOpenPost(@org.jetbrains.annotations.NotNull()
        ru.netology.adapter.OnInteractionListener $this, @org.jetbrains.annotations.NotNull()
        ru.netology.dto.Post post) {
        }
    }
}