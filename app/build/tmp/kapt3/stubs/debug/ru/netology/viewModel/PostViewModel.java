package ru.netology.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010\'\u001a\u00020%J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#J\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lru/netology/viewModel/PostViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_dataState", "Landroidx/lifecycle/MutableLiveData;", "Lru/netology/model/FeedModelState;", "_postCreated", "Lru/netology/SingleLiveEvent;", "", "data", "Landroidx/lifecycle/LiveData;", "Lru/netology/model/FeedModel;", "getData", "()Landroidx/lifecycle/LiveData;", "dataState", "getDataState", "edited", "Lru/netology/dto/Post;", "kotlin.jvm.PlatformType", "getEdited", "()Landroidx/lifecycle/MutableLiveData;", "postCreated", "getPostCreated", "repository", "Lru/netology/repository/PostRepository;", "cancelChange", "changeContent", "content", "", "edit", "post", "likeById", "id", "", "loadPosts", "Lkotlinx/coroutines/Job;", "openPost", "refreshPosts", "removeById", "save", "unLikeById", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.AndroidViewModel {
    private final ru.netology.repository.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<ru.netology.model.FeedModel> data = null;
    private final androidx.lifecycle.MutableLiveData<ru.netology.model.FeedModelState> _dataState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<ru.netology.dto.Post> edited = null;
    private final ru.netology.SingleLiveEvent<kotlin.Unit> _postCreated = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.netology.model.FeedModel> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.netology.model.FeedModelState> getDataState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<ru.netology.dto.Post> getEdited() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Unit> getPostCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job refreshPosts() {
        return null;
    }
    
    public final void save() {
    }
    
    public final void edit(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post) {
    }
    
    public final void changeContent(@org.jetbrains.annotations.NotNull()
    java.lang.String content) {
    }
    
    public final void likeById(long id) {
    }
    
    public final void removeById(long id) {
    }
    
    public final void unLikeById(long id) {
    }
    
    public final void openPost(@org.jetbrains.annotations.NotNull()
    ru.netology.dto.Post post) {
    }
    
    public final void cancelChange() {
    }
    
    public PostViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}